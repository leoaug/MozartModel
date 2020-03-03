package com.mozart.model.ejb.facade;

import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.ApartamentoTransferidoEJB;
import com.mozart.model.ejb.entity.CheckinEJB;
import com.mozart.model.ejb.entity.ConfigNotaEJB;
import com.mozart.model.ejb.entity.ConfigNotaEJBPK;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.ejb.entity.ObjetoEJB;
import com.mozart.model.ejb.entity.RoomListEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.CaixaGeralVO;
import com.mozart.model.vo.MiniPdvVO;
import com.mozart.model.vo.MovimentoObjetoVO;
import com.mozart.model.vo.TransacaoWebVO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("unchecked")
@Stateless(name="CaixaGeralSessionEJB")
public class CaixaGeralSessionBean implements CaixaGeralSession {
    @PersistenceContext(unitName="MozartModel")
    private EntityManager manager;

    public CaixaGeralSessionBean() {
    }


	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<CaixaGeralVO> pesquisarApartamentoComCheckinEReserva(CaixaGeralVO param) {
                                   
        return pesquisarApartamentoComCheckinEReserva(param, true);
    }

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<CaixaGeralVO> pesquisarApartamentoComCheckinEReserva(CaixaGeralVO param, boolean isHotelaria) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(QUERY_CAIXA_GERAL);
		sb.append("\n ,( \n" + ((isHotelaria) ? SUB_QUERY_CHECKIN_COM_HOSPEDE : SUB_QUERY_CHECKIN_SEM_HOSPEDE ) +" \n) ck \n");
		sb.append("\n ,( \n" + SUB_QUERY_RESERVA +" \n) res \n");
		sb.append("\n" + WHERE_CAIXA_GERAL + "\n");
		
		List resultado = manager.createNativeQuery(sb.toString().toUpperCase()).
				setParameter(1, param.getIdHotel()).
				setParameter(2, param.getIdHotel()).
				setParameter(3, param.getIdHotel()).
				setParameter(4, param.getStatus()).
				setParameter(5, param.getEntradaDia()).
				setParameter(6, param.getSaidaDia()).
				setParameter(7, param.getCofan()).
				setParameter(8, param.getCheckout()).
				setParameter(9, param.getNumApartamento()).
				setParameter(10, param.getIdApartamento()).
				getResultList();
		
		List<CaixaGeralVO> result = new ArrayList<CaixaGeralVO>();     
		for (Object linha: resultado){
			result.add( new CaixaGeralVO((Object[])linha ));
		}                             
		return result;
	}
	
	
	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public void transferirApartamento(ApartamentoTransferidoEJB apartamentoTransferido) throws MozartSessionException{


            try{    
                ApartamentoEJB aptoDestino = manager.find(ApartamentoEJB.class, apartamentoTransferido.getIdApartamentoDestino());
                CheckinEJB checkinEJB = manager.find(CheckinEJB.class, apartamentoTransferido.getIdCheckin());
                validarTransferencia( aptoDestino,  checkinEJB);
        		ControlaDataEJB controlaData = manager.find(ControlaDataEJB.class, aptoDestino.getIdHotel());

                ApartamentoEJB aptoOrigem = checkinEJB.getApartamentoEJB();
                aptoOrigem.setStatus("LS");
                aptoDestino.setStatus("OL");
                checkinEJB.setApartamentoEJB( aptoDestino );
                if( ! MozartUtil.isNull(checkinEJB.getReservaApartamentoEJB()))
                	checkinEJB.getReservaApartamentoEJB().setApartamentoEJB( aptoDestino );
                
                apartamentoTransferido.setData( controlaData.getFrontOffice() );
                apartamentoTransferido.setHora( new Timestamp(new Date().getTime()));
                apartamentoTransferido.setTipoTransferencia("APTO");
                apartamentoTransferido.setIdApartamentoOrigem( aptoOrigem.getIdApartamento() );
                
                manager.merge( aptoOrigem );
                manager.merge( aptoDestino );
                manager.merge( checkinEJB );
                manager.persist( apartamentoTransferido );

            }catch(MozartValidateException ex){
                throw ex;            
                            
            }catch(Exception ex){
                throw new MozartSessionException( ex.getMessage() );            
            }
            
    }

    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	private void validarTransferencia(ApartamentoEJB aptoDestino, CheckinEJB checkinEJB) throws MozartValidateException{
    
            String qry = "select ra.id_reserva from reserva_apartamento ra, reserva r\n" + 
            "where ra.id_reserva = r.id_reserva and r.apagada = 'N' and ra.id_hotel = ?1\n" + 
            "and ra.id_apartamento = ?2\n" + 
            "and (?3 between ra.data_entrada+1 and ra.data_saida-1 )";
            
            List resultado = manager.createNativeQuery( qry ).setParameter(1, checkinEJB.getApartamentoEJB().getIdHotel()).
                    setParameter(2, aptoDestino.getIdApartamento()).
                    //setParameter(3, checkinEJB.getDataEntrada()).
                    setParameter(3, checkinEJB.getDataSaida()).getResultList();
            
            if (resultado != null && resultado.size() > 0)
                throw new MozartValidateException("Apartamento bloqueado para a reserva: "+ ((java.math.BigDecimal)resultado.get(0)).longValue() );
        
    }
    
    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ApartamentoEJB> obterApartamentoDisponivelTransferencia(Long idCheckin, Long idHotel) throws MozartSessionException{
    
        String qry = "\n" + 
            "select * from apartamento\n" + 
            "where id_apartamento not in (\n" + 
            "select ra.id_apartamento \n" + 
            "from reserva_apartamento ra, reserva r,  \n" + 
            "    (select c.data_entrada, c.data_saida, a.cofan from checkin c, apartamento a where c.id_apartamento = a.id_apartamento and c.id_checkin  = ?1 and c.id_hotel = ?2) periodo\n" + 
            "where ra.id_hotel = ?3\n" + 
            "and (periodo.data_saida between ra.data_entrada+1 and ra.data_saida-1 )\n" + 
            "and ra.id_apartamento is not null and r.id_reserva = ra.id_reserva and r.APAGADA = 'N' \n" + 
            ")\n" + 
            "and id_hotel = ?4\n" +
            "and status = 'LL' and cofan like decode(?5,'S','S','%')\n" +
            "order by id_tipo_apartamento, num_apartamento \n";
            
        try{
        	String qryCofan = "select a.cofan from checkin c, apartamento a where c.id_apartamento = a.id_apartamento and c.id_checkin  = ?1 and c.id_hotel = ?2";
        	String cofan = (String)manager.createNativeQuery( qryCofan ).setParameter(1, idCheckin).setParameter(2, idHotel).getSingleResult();
            List<ApartamentoEJB> result = manager.createNativeQuery( qry, ApartamentoEJB.class).setHint("eclipselink.refresh", "TRUE").
                                            setParameter(1, idCheckin).
                                            setParameter(2, idHotel).
                                            setParameter(3, idHotel).
                                            setParameter(4, idHotel).
                                            setParameter(5, cofan).
                                            getResultList();
            return result;
        
        }catch(Exception ex){
        
            throw new MozartSessionException ( ex.getMessage() );
        }
    
    
    
    
    }

    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ConfigNotaEJB> obterConfiguracaoImpressoraFiscal(Long idHotel)	throws MozartSessionException {

        
        String qry = "\n" + 
            " select id_hotel, substr(campo,1, length(campo)-1) campo, linha, coluna " +
            " from config_nota " +
            " where id_hotel = ?1 " +
            " and linha > 0 " +
            " and instr(campo, '1') > 1 " +
            " order by linha, coluna, campo ";
            
        try{
            List<ConfigNotaEJB> result = manager.createNativeQuery( qry, ConfigNotaEJB.class).setHint("eclipselink.refresh", "TRUE").
                                            setParameter(1, idHotel).
                                            getResultList();
            return result;
        
        }catch(Exception ex){
        
            throw new MozartSessionException ( ex.getMessage() );
        }

    
    
    }


	public List<String> obterValidacaoLancamentoDiaria(Long pIdHotel) throws MozartSessionException {

		try{
			String qry =
				"SELECT FC_AGRUPA_DADOS('SELECT num_apartamento FROM checkin, controla_data, apartamento WHERE checkin.data_saida < = controla_data.front_office AND CHECKIN.checkout = ''N'' AND checkin.ID_APARTAMENTO = apartamento.ID_APARTAMENTO AND cofan = ''N'' AND checkin.id_hotel = '||"+pIdHotel+"||' AND controla_data.ID_HOTEL = checkin.id_hotel ORDER BY num_apartamento',',') APTOS FROM DUAL "+
				"UNION ALL "+
				"SELECT COUNT(*)||'' FROM LOG_USUARIO LO, CONTROLA_DATA CD WHERE LO.TABELA_AUDITADA = 'LANCAMENTO_DIARIAS' AND LO.DATA = CD.FRONT_OFFICE AND LO.ID_HOTEL = CD.ID_HOTEL AND CD.ID_HOTEL = "+pIdHotel;

			List<String> result = manager.createNativeQuery(qry).getResultList();
			return result;
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
		
	}

	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void lancarDiariaAutomatica(ControlaDataEJB pControlaData) throws MozartSessionException {
		try{
			manager.createNativeQuery( "{call PROC_LANCAMENTO_DIARIA_WEB(?1)}").setParameter(1, pControlaData.getIdHotel()).executeUpdate();
		}catch(Exception ex){
			throw new MozartValidateException(ex.getMessage());
		}		
	}
    
	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void transferirDespesasParaApto(ApartamentoEJB destino, Long pIdRoomListDestino, String motivo, List<MovimentoApartamentoEJB> listaMovimentoATransferir) throws MozartSessionException {

    	try{            
    		/*CheckinEJB checkin = (CheckinEJB)manager.createQuery("select o from CheckinEJB o where o.checkout='N' and o.apartamentoEJB.idHotel = ?1 and o.apartamentoEJB.idApartamento = ?2").
    							setParameter(1, destino.getIdHotel()).setParameter(2, destino.getIdApartamento()).getSingleResult();
    		*/
    		String qry = " UPDATE MOVIMENTO_APARTAMENTO SET ID_CHECKIN = ?1, "+
    					 " ID_ROOM_LIST = ?2, NUM_DOCUMENTO = ?3 WHERE ID_MOVIMENTO_APARTAMENTO = ?4 ";
    		manager.joinTransaction();
    		BigDecimal idCheckin = (BigDecimal)manager.createNativeQuery("SELECT ID_CHECKIN FROM CHECKIN WHERE ID_HOTEL=?1 AND ID_APARTAMENTO=?2 AND CHECKOUT = 'N'").
									    		setParameter(1, destino.getIdHotel()).
												setParameter(2, destino.getIdApartamento()).
												getSingleResult();
    		
    		ControlaDataEJB controlaData = manager.find(ControlaDataEJB.class, destino.getIdHotel());
    		
    		for (MovimentoApartamentoEJB mov : listaMovimentoATransferir){
    			manager.createNativeQuery( qry ).setParameter(1, idCheckin.longValue()).
    											 setParameter(2, pIdRoomListDestino).
    											 setParameter(3, mov.getNumDocumento()).
    											 setParameter(4, mov.getIdMovimentoApartamento()).
    											 executeUpdate();
    			
    			ApartamentoTransferidoEJB apartamentoTransferido = new ApartamentoTransferidoEJB();
    			apartamentoTransferido.setIdHotel(destino.getIdHotel() );
    			apartamentoTransferido.setIdCheckin(idCheckin.longValue() );
    			apartamentoTransferido.setIdApartamentoDestino( destino.getIdApartamento() );
    			apartamentoTransferido.setIdApartamentoOrigem( mov.getCheckinEJB().getApartamentoEJB().getIdApartamento() );
    			apartamentoTransferido.setData( controlaData.getFrontOffice() );
                apartamentoTransferido.setHora( new Timestamp(new Date().getTime()));
                apartamentoTransferido.setValorLancamento( mov.getValorLancamento() );
                apartamentoTransferido.setTipoTransferencia("DESP");
                apartamentoTransferido.setMotivo(motivo);
                manager.persist( apartamentoTransferido );
    		}
    		
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }

	}


	public List<MovimentoApartamentoEJB> obterMovimentoAtualDoApartamento(MovimentoApartamentoEJB origem) throws MozartSessionException {
    	try{            
    		String sql = "select m.* from movimento_apartamento m, checkin c "
    				+ "where c.id_hotel = m.id_hotel and c.id_checkin = m.id_checkin and m.mov_tmp='S' "
    				+ "and c.checkout='N' and c.id_hotel = ?1 and c.id_apartamento = ?2 ";
    		
    		ApartamentoEJB aptoOrigem = origem.getCheckinEJB().getApartamentoEJB();
    		if(!MozartUtil.isNull(origem.getNumDocumento())){
    			sql = sql + " and NUM_DOCUMENTO like '" + origem.getNumDocumento() + "%'";
    		}
    		
			List<MovimentoApartamentoEJB> lista = (List<MovimentoApartamentoEJB>)
					manager.createNativeQuery(sql, MovimentoApartamentoEJB.class).
							setHint("eclipselink.refresh", "TRUE").
							setParameter(1, aptoOrigem.getIdHotel()).
							setParameter(2, aptoOrigem.getIdApartamento()).
							getResultList();

    		return lista;
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
	}


	public List<RoomListEJB> obterHospedePorApartamento(ApartamentoEJB apto)
			throws MozartSessionException {
		try{   
			manager.flush();
    		List<RoomListEJB> lista = (List<RoomListEJB>)
					manager.createNativeQuery("select rl.* from room_list rl, checkin c where c.checkout='N' and c.id_hotel = ?1 and c.id_apartamento= ?2 and c.id_checkin = rl.id_checkin and rl.data_saida is null and rl.chegou='S' ", RoomListEJB.class).setHint("eclipselink.refresh", "TRUE").
					setParameter(1, apto.getIdHotel()).setParameter(2, apto.getIdApartamento()).getResultList();
    		return lista;
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
	}


	public List<ConfigNotaEJB> obterConfiguracaoNotaFiscal(Long idHotel) throws MozartSessionException {

		try{            
    		List<ConfigNotaEJB> lista = (List<ConfigNotaEJB>)
    		manager.createNativeQuery("select id_hotel, campo, linha, coluna from config_nota where instr(campo,'1') > 0 and id_hotel = ?1 order by linha, coluna ", ConfigNotaEJB.class).
				setHint("eclipselink.refresh", "TRUE").
				setParameter(1, idHotel).getResultList();
    		return lista;
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
	}


	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void salvarConfiguracaoNotaFiscal(List<ConfigNotaEJB> lista) throws MozartSessionException {

		try{            

			if (MozartUtil.isNull( lista ))
				throw new MozartValidateException("A configuração é obrigatória");
			
			for (ConfigNotaEJB linha:lista){
				ConfigNotaEJBPK pk = linha.getId();
				ConfigNotaEJB consulta = manager.find(ConfigNotaEJB.class, pk); 
				if ( consulta != null){
					consulta.setLinha( linha.getLinha() );
					consulta.setColuna( linha.getColuna() );
					manager.merge( consulta );
				}else{
					manager.persist( linha );
				}
			}
			
		}catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
	}


	public List<RoomListEJB> obterHospedePorCheckin(Long idCheckin) throws MozartSessionException {

		try{            
    		List<RoomListEJB> lista = (List<RoomListEJB>)
					manager.createNativeQuery("select rl.* from room_list rl, checkin c where c.checkout='N' and c.id_checkin = ?1 and c.id_checkin = rl.id_checkin and rl.data_saida is null and rl.chegou='S' ", RoomListEJB.class).setHint("eclipselink.refresh", "TRUE").
					setParameter(1, idCheckin).getResultList();
    		return lista;
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
	}


	public List<ObjetoEJB> obterObjetoPorHotel(Long idHotel)
			throws MozartSessionException {
		try{            
    		List<ObjetoEJB> lista = (List<ObjetoEJB>)
					manager.createQuery("select o from ObjetoEJB o where o.idHotel = ?1 order by o.fantasia ").setHint("eclipselink.refresh", "TRUE").
					setParameter(1, idHotel).getResultList();
    		return lista;
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
	}


	public List<MovimentoObjetoVO> pesquisarMovimentoObjeto(
			MovimentoObjetoVO filtro) throws MozartSessionException {
		try{

			String sql = QUERY_MOVIMENTO_OBJETO;
			
			 if  (!MozartUtil.isNull(filtro.getFiltroApto().getTipoIntervalo())){
	                sql += " and a.num_apartamento " + filtro.getFiltroApto();
	         }
	         if  (!MozartUtil.isNull(filtro.getFiltroData().getTipoIntervalo())){
	                sql += " and mo.data  " + filtro.getFiltroData();
	         }
	         if  (!MozartUtil.isNull(filtro.getFiltroNome().getTipoIntervalo())){
	                sql += " and upper(h.nome_hospede||' '||h.sobrenome_hospede) " + filtro.getFiltroNome();
	         }
	            
	         
	         if  (!MozartUtil.isNull(filtro.getIdHoteis())){
            	 sql += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||mo.id_hotel||';') >= 1 ";
             }
            sql += " ORDER BY a.num_apartamento ";

			 List resultado = manager.createNativeQuery( sql ).
             getResultList();
             
			List<MovimentoObjetoVO> result = new ArrayList<MovimentoObjetoVO>();     
			for (Object linha: resultado){
				result.add( new MovimentoObjetoVO((Object[])linha ));
			}                             
			return result;
						
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
	
	}


	public List<MiniPdvVO> pesquisarMiniPDV(MiniPdvVO filtro)	throws MozartSessionException {
		
		try{
				String sql = QUERY_MINI_PDV;

					    
					    if (!MozartUtil.isNull( filtro.getFiltroCheckin().getTipoIntervalo())){
					    	sql += " AND C.ID_CHECKIN " + filtro.getFiltroCheckin();
					    }
					
					    if (!MozartUtil.isNull( filtro.getFiltroNumApartamento().getTipoIntervalo())){
					    	sql += " AND A.NUM_APARTAMENTO " + filtro.getFiltroNumApartamento();
					    }
					    	 sql += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||mmpdv.id_hotel||';') >= 1 ";
			            
					    sql += " ORDER BY A.NUM_APARTAMENTO ";
					    
					    List lista = manager.createNativeQuery( sql ).
					    getResultList();
					    List<MiniPdvVO> resultado = new ArrayList<MiniPdvVO>();                     
					    for (Object l: lista){
					        resultado.add( new MiniPdvVO( (Object[])l ) );
					    }           
					    return resultado;
					}catch(Exception ex){
					    throw new MozartSessionException( ex.getMessage() );
					
					}
		
			}


	public List<TransacaoWebVO> pesquisarTransacaoWeb(TransacaoWebVO filtro) throws MozartSessionException {
		try{
				String sql = QRY_TRANSACAO_WEB;
				String orderBy = " ORDER BY TW.DATA_TRANSACAO DESC ";

			    if (!MozartUtil.isNull( filtro.getFiltroDataTransacao().getTipoIntervalo())){
			    	sql += " AND TRUNC(TW.DATA_TRANSACAO) " + filtro.getFiltroDataTransacao();
			    }
			
			    if (!MozartUtil.isNull( filtro.getFiltroApartamento().getTipoIntervalo())){
			    	sql += " AND NVL(A.BLOCO,A.NUM_APARTAMENTO||'') " + filtro.getFiltroApartamento();
			    }
			    sql += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||TW.ID_HOTEL||';') >= 1 ";
	            
			    sql += orderBy;
			    
			    List lista = manager.createNativeQuery( sql ).
			    getResultList();
			    List<TransacaoWebVO> resultado = new ArrayList<TransacaoWebVO>();                     
			    for (Object l: lista){
			        resultado.add( new TransacaoWebVO( (Object[])l ) );
			    }           
			    return resultado;
			}catch(Exception ex){
			    throw new MozartSessionException( ex.getMessage() );
			
			}
	}
}
