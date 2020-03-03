package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.CheckinEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.ejb.entity.RamalTelefonicoEJB;
import com.mozart.model.ejb.entity.RoomListEJB;
import com.mozart.model.ejb.entity.TelefoniaDiscrepanciaEJB;
import com.mozart.model.ejb.entity.TelefoniaEJB;
import com.mozart.model.ejb.entity.TelefoniasConfigEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.RamalVO;
import com.mozart.model.vo.DiscrepanciaVO;

@Stateless(name="TelefoniaSession")
public class TelefoniaSessionBean implements TelefoniaSession{

	@PersistenceContext(unitName="MozartModel")
	private EntityManager manager;
	
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void lancarTelefonia(HotelEJB hotel, String[] linhas) throws MozartSessionException{
		
		try{

			
			Map<String, List<Object[]>> cacheCheckin = new HashMap<String,List<Object[]>>();
	        ControlaDataEJB controlaData = (ControlaDataEJB)manager.createQuery("select o from ControlaDataEJB o where o.idHotel = ?1" ).setHint("eclipselink.refresh", "TRUE").
            									setParameter(1, hotel.getIdHotel()).getSingleResult();
 

	        TipoLancamentoEJB tipoLancamentoISS = null;
	        
	        List<TipoLancamentoEJB> listaTipo = manager.createQuery("select o from TipoLancamentoEJB o where o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 13 and o.idHotel = ?1" ).
	        					setHint("eclipselink.refresh", "TRUE").
	        					setParameter(1, hotel.getIdHotel()).getResultList();
	        
	        if (!MozartUtil.isNull( listaTipo )){
	        	tipoLancamentoISS = listaTipo.get(0);
	        }
	        
	        TipoLancamentoEJB tipoLancamentoTAXA = null;
	        
	        listaTipo = manager.createQuery("select o from TipoLancamentoEJB o where o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 11 and o.idHotel = ?1" ).setHint("eclipselink.refresh", "TRUE").
            setParameter(1, hotel.getIdHotel()).getResultList();
	        
	        if (!MozartUtil.isNull( listaTipo )){
	        	tipoLancamentoTAXA = listaTipo.get(0);
	        }

	        
	        String qry_checkin = QRY_CHECKIN_TELEFONIA;
	        	//" AND RA.INTERNO = 'N' ";

			if (hotel.getTelefoniasConfigEJB().getTaxa() == null){
				hotel.getTelefoniasConfigEJB().setTaxa(new Double(0));
			}

			for (String linha: linhas){
				//Começo a partir da posição 1, pq o primeiro campo a applet define se é telefonia ou internet.
				String[] resultado = hotel.getTelefoniasConfigEJB().build( linha.substring(1) );
				List<Object[]> lista = null;
				
				if (cacheCheckin.containsKey(resultado[0].trim())){
					lista = cacheCheckin.get(resultado[0].trim()); 
				} else {
					lista = (List<Object[]>)manager.createNativeQuery( qry_checkin ).
										setParameter(1, hotel.getIdHotel()).
										setParameter(2, hotel.getIdHotel()).
										setParameter(3, resultado[0].trim()).
										getResultList();
					cacheCheckin.put(resultado[0].trim(), lista);
				}
				
				Object[] idCheckin = null;
				
				if (!MozartUtil.isNull(lista)){
					idCheckin = lista.get(0);
				}
				
				//Não deve entrar nesse if, caso entre o ramal encontrado na bilhete, não foi cadastrado no sistema
				if (MozartUtil.isNull(lista)){
					TelefoniaDiscrepanciaEJB discrepancia = new TelefoniaDiscrepanciaEJB();
					discrepancia.setData(MozartUtil.toTimestamp(resultado[1], "dd/MM/yy"));
					discrepancia.setDuracao2( resultado[4]);
					discrepancia.setHoraInicio(resultado[2]);
					discrepancia.setIdHotel( hotel.getIdHotel() );
					discrepancia.setNumApartamento(Long.valueOf(resultado[0].trim()));		
					discrepancia.setNumTelefone(resultado[3].trim());
					discrepancia.setValor( MozartUtil.toDouble(resultado[5].trim()));
					
					manager.persist(discrepancia);
				
				}else if (MozartUtil.isNull(idCheckin[0])){
					//Não fez o checkin ainda
					TelefoniaDiscrepanciaEJB discrepancia = new TelefoniaDiscrepanciaEJB();
					discrepancia.setData(MozartUtil.toTimestamp(resultado[1], "dd/MM/yy"));
					discrepancia.setDuracao2( resultado[4]);
					discrepancia.setHoraInicio(resultado[2]);
					discrepancia.setIdHotel( hotel.getIdHotel() );
					discrepancia.setNumTelefone(resultado[3].trim());
					discrepancia.setValor( MozartUtil.toDouble(resultado[5].trim()));
					discrepancia.setIdRamalTelefonico( ((BigDecimal)idCheckin[1]).longValue() );
					manager.persist(discrepancia);
				}else{
					if (hotel.getTelefoniasConfigEJB().getAcobrar() == null)
						hotel.getTelefoniasConfigEJB().setAcobrar(new Double(0));
					
					Double valorLigacao = resultado[3].trim().startsWith("90")?hotel.getTelefoniasConfigEJB().getAcobrar():resultado[3].trim().startsWith("0800")?new Double(0):MozartUtil.toDouble(resultado[5].trim());
					
					if ((!resultado[3].trim().startsWith("90")) && "S".equals(hotel.getTelefoniasConfigEJB().getTarifaTaxa())){
						valorLigacao = new Double(valorLigacao * (1 + (double)(hotel.getTelefoniasConfigEJB().getTaxa().doubleValue() / 100)));
					}
					
					TipoLancamentoEJB tipoTelefonia = linha.startsWith("I")? hotel.getTelefoniasConfigEJB().getTipoLancamentoInternet(): hotel.getTelefoniasConfigEJB().getTipoLancamentoTelefonia(); 
			        MovimentoApartamentoEJB movimentoInicial = new MovimentoApartamentoEJB();
			        movimentoInicial.setIdRedeHotel( hotel.getRedeHotelEJB().getIdRedeHotel() );
			        movimentoInicial.setRoomListEJB( new RoomListEJB(((BigDecimal)idCheckin[2]).longValue()) );
			        movimentoInicial.setCheckinEJB( new CheckinEJB(((BigDecimal)idCheckin[0]).longValue()));
			        movimentoInicial.setTipoLancamentoEJB( tipoTelefonia );
			        movimentoInicial.setNumDocumento(  resultado[4].trim() + "-" + resultado[3].trim());
			        movimentoInicial.setDataLancamento( new Timestamp(controlaData.getFrontOffice().getTime()) );
			        movimentoInicial.setHoraLancamento( new Timestamp( new java.util.Date().getTime()));
			        movimentoInicial.setValorLancamento( valorLigacao );
			        movimentoInicial.setQuemPaga( (String)idCheckin[3] );
			        movimentoInicial.setCheckout("N");
			        movimentoInicial.setMovTmp("S");
			        movimentoInicial.setParcial("N");
			        manager.persist( movimentoInicial );
			        
			        
			        
			        if (valorLigacao.doubleValue() > 0 && tipoLancamentoISS != null && "N".equals(hotel.getTaxaCheckout()) && 
			        			hotel.getIss().doubleValue() > 0 && 
			        			"S".equals((String)idCheckin[4]) && 
			        			"S".equals(tipoTelefonia.getIss())){
			        	
			        	
			        	List<MovimentoApartamentoEJB> listIss = manager.
						  createNativeQuery("select ma.* from movimento_apartamento ma, controla_data cd where cd.id_hotel = ma.id_hotel and ma.data_lancamento = cd.front_office and id_checkin = ?1 and mov_tmp='S' and id_tipo_lancamento = ?2 and quem_paga=?3 and id_room_list = nvl(?4, id_room_list)", MovimentoApartamentoEJB.class).
						  setParameter(1, movimentoInicial.getCheckinEJB().getIdCheckin()).
						  setParameter(2, tipoLancamentoISS.getIdTipoLancamento()).
						  setParameter(3, movimentoInicial.getQuemPaga()).
						  setParameter(4, movimentoInicial.getQuemPaga().equals("E")?null:movimentoInicial.getRoomListEJB().getIdRoomList()).
						  setHint("eclipselink.refresh", "TRUE").								  
						  getResultList();
			        	
			        	if (MozartUtil.isNull( listIss )){
					
			        		movimentoInicial = new MovimentoApartamentoEJB();
					        movimentoInicial.setIdRedeHotel( hotel.getRedeHotelEJB().getIdRedeHotel() );
					        movimentoInicial.setRoomListEJB( new RoomListEJB(((BigDecimal)idCheckin[2]).longValue()) );
					        movimentoInicial.setCheckinEJB( new CheckinEJB(((BigDecimal)idCheckin[0]).longValue()));
					        movimentoInicial.setTipoLancamentoEJB( tipoLancamentoISS );
					        movimentoInicial.setNumDocumento(  "ISS Tel -" + resultado[3].trim());
					        movimentoInicial.setDataLancamento( new Timestamp(controlaData.getFrontOffice().getTime()) );
					        movimentoInicial.setHoraLancamento( new Timestamp( new java.util.Date().getTime()));
					        movimentoInicial.setValorLancamento( valorLigacao * ( ((double)hotel.getIss().doubleValue()/100)) );
					        movimentoInicial.setQuemPaga( (String)idCheckin[3] );
					        movimentoInicial.setCheckout("N");
					        movimentoInicial.setMovTmp("S");
					        movimentoInicial.setParcial("N");
					        manager.persist( movimentoInicial );
			        
			        	}else{
			        		
			        		MovimentoApartamentoEJB movimentoIss = listIss.get(0);
							movimentoIss.setValorLancamento( movimentoIss.getValorLancamento() + (  valorLigacao * ( ((double)hotel.getIss().doubleValue()/100)) ));
							manager.merge( movimentoIss );
			        		
			        	}
			        	
			        }
			        
			        if (valorLigacao.doubleValue() > 0 && tipoLancamentoTAXA != null && "N".equals(hotel.getTaxaCheckout()) && 
		        			hotel.getTaxaServico().doubleValue() > 0 && 
		        			"S".equals((String)idCheckin[5]) && 
		        			"S".equals(tipoTelefonia.getTaxaServico())){
		        	
			        	List<MovimentoApartamentoEJB> listTaxa = manager.
						  createNativeQuery("select ma.* from movimento_apartamento ma, controla_data cd where cd.id_hotel = ma.id_hotel and ma.data_lancamento = cd.front_office and id_checkin = ?1 and mov_tmp='S' and id_tipo_lancamento = ?2 and quem_paga=?3 and id_room_list = nvl(?4, id_room_list)", MovimentoApartamentoEJB.class).
						  setParameter(1, movimentoInicial.getCheckinEJB().getIdCheckin()).
						  setParameter(2, tipoLancamentoTAXA.getIdTipoLancamento()).
						  setParameter(3, movimentoInicial.getQuemPaga()).
						  setParameter(4, movimentoInicial.getQuemPaga().equals("E")?null:movimentoInicial.getRoomListEJB().getIdRoomList()).
						  setHint("eclipselink.refresh", "TRUE").								  
						  getResultList();
						
						if (MozartUtil.isNull( listTaxa )){
							        movimentoInicial = new MovimentoApartamentoEJB();
							        movimentoInicial.setIdRedeHotel( hotel.getRedeHotelEJB().getIdRedeHotel() );
							        movimentoInicial.setRoomListEJB( new RoomListEJB(((BigDecimal)idCheckin[2]).longValue()) );
							        movimentoInicial.setCheckinEJB( new CheckinEJB(((BigDecimal)idCheckin[0]).longValue()));
							        movimentoInicial.setTipoLancamentoEJB( tipoLancamentoTAXA );
							        movimentoInicial.setNumDocumento(  "Taxa Tel -" + resultado[3].trim());
							        movimentoInicial.setDataLancamento( new Timestamp(controlaData.getFrontOffice().getTime()) );
							        movimentoInicial.setHoraLancamento( new Timestamp( new java.util.Date().getTime()));
							        movimentoInicial.setValorLancamento( valorLigacao * ( ((double)hotel.getTaxaServico().doubleValue()/100)) );
							        movimentoInicial.setQuemPaga( (String)idCheckin[3] );
							        movimentoInicial.setCheckout("N");
							        movimentoInicial.setMovTmp("S");
							        movimentoInicial.setParcial("N");
							        manager.persist( movimentoInicial );
						}else{
							MovimentoApartamentoEJB movimentoTaxa = listTaxa.get(0);
							movimentoTaxa.setValorLancamento( movimentoTaxa.getValorLancamento() + ( valorLigacao * ( ((double)hotel.getTaxaServico().doubleValue()/100)) ) );
							manager.merge( movimentoTaxa );
							
						}
		        }
			        
			        
			        
				}
			}
			
			
			
		}catch(Exception ex){
			throw new MozartSessionException( ex.getMessage() );
		}
	}


	@SuppressWarnings("unchecked")
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<TelefoniaEJB> obterCentralTelefonia() throws MozartSessionException {
		try{
			List<TelefoniaEJB> resultado = manager.createQuery("select o from TelefoniaEJB o order by o.nome").
							setHint("eclipselink.refresh", "TRUE").
							getResultList();
			return resultado;
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
			
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public TelefoniasConfigEJB obterTelefoniasConfigPorHotel(
			TelefoniasConfigEJB filtro) {
		try{
			List<TelefoniasConfigEJB> resultado = manager.createQuery("select o from TelefoniasConfigEJB o where o.idHotel = ?1").
							setParameter(1, filtro.getIdHotel()).
							setHint("eclipselink.refresh", "TRUE").
							getResultList();
			
			return MozartUtil.isNull(resultado)?new TelefoniasConfigEJB(): resultado.get(0);
		}catch(Exception ex){
			return new TelefoniasConfigEJB();
		}
	}


	//RAMAL BEAN
	@SuppressWarnings("unchecked")
	public List<RamalVO> pesquisarRamal(RamalVO filtro) throws MozartSessionException {

		try{
			String qry = QRY_RAMAL;
			qry += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||rt.id_hotel||';') >= 1 ";
			
			if (!MozartUtil.isNull( filtro.getFiltroApartamento().getTipoIntervalo() ) ){
				qry += " and a.num_apartamento " + filtro.getFiltroApartamento();
			}

			if (!MozartUtil.isNull( filtro.getFiltroRamal().getTipoIntervalo() ) ){
				qry += " and rt.ramal " + filtro.getFiltroRamal();
			}
			
			qry += " order by a.num_apartamento ";
			
			List<Object[]> resultado = manager.createNativeQuery(qry).getResultList();
			List<RamalVO> resultadoVO = new ArrayList<RamalVO>();
			for (Object[] linha: resultado){
				resultadoVO.add( new RamalVO ( linha ) );
			}
			return resultadoVO;

		}catch(Exception ex){
			 throw new MozartSessionException(ex.getMessage());
		}
	}

	
	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void gravarRamalTelefonico(RamalTelefonicoEJB entidade) throws MozartSessionException {
		
		if (MozartUtil.isNull(entidade.getIdRamalTelefonico())){
			manager.persist(entidade);
		}else{
			manager.merge(entidade);
		}
		
	}

	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void excluirRamalTelefonico(RamalTelefonicoEJB entidade) throws MozartSessionException {

		entidade = manager.find(RamalTelefonicoEJB.class, entidade.getIdRamalTelefonico());
		manager.remove( entidade );
		
	}
	
	
	// DISCREPANCIA BEAN 
	

	@SuppressWarnings("unchecked")
	public List<DiscrepanciaVO> pesquisarDiscrepancia(DiscrepanciaVO filtro) throws MozartSessionException {

		try{
			String qry = QRY_DISCREPANCIA;
			qry += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||td.id_hotel||';') >= 1 ";
			
			
				if (!MozartUtil.isNull( filtro.getFiltroData().getTipoIntervalo() ) ){
				qry += " and td.data " + filtro.getFiltroData();
			}
			
			qry += " order by td.data desc ";
			List<Object[]> resultado = manager.createNativeQuery(qry).getResultList();
			List<DiscrepanciaVO> resultadoVO = new ArrayList<DiscrepanciaVO>();
			for (Object[] linha: resultado){
				resultadoVO.add( new DiscrepanciaVO ( linha ) );
			}
			return resultadoVO;

		}catch(Exception ex){
			 throw new MozartSessionException(ex.getMessage());
		}
	}


	@SuppressWarnings("unchecked")
	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void lancarMovimentoDiscrepancia(TelefoniaDiscrepanciaEJB entidade) throws MozartSessionException {

		
		try{
			if (MozartUtil.isNull(entidade) || MozartUtil.isNull( entidade.getIdTelefonia())){
				throw new MozartValidateException("O campo 'Discrepância' é obrigatorio.");
			}
			
			entidade = manager.find( TelefoniaDiscrepanciaEJB.class, entidade.getIdTelefonia());

			if (MozartUtil.isNull(entidade.getIdRamalTelefonico())){
				throw new MozartValidateException("A 'Discrepância' está sem ramal associado.");
			}

			RamalTelefonicoEJB ramal = manager.find(RamalTelefonicoEJB.class, entidade.getIdRamalTelefonico());
			
			String qry_checkin = QRY_CHECKIN_TELEFONIA;
			
			List<Object[]> lista = (List<Object[]>)manager.createNativeQuery( qry_checkin ).
									setParameter(1, entidade.getIdHotel()).
									setParameter(2, entidade.getIdHotel()).
									setParameter(3, ramal.getRamal()).
									getResultList();

			
			if (MozartUtil.isNull(lista)){
				throw new MozartValidateException("Este ramal não possui apartamento associado.");
			}

			Object[] idCheckin = (Object[])lista.get(0);
			
			if (MozartUtil.isNull(idCheckin[0])){
				throw new MozartValidateException("Não existe Check-in para esse ramal.");
			}
			
	        ControlaDataEJB controlaData = (ControlaDataEJB)manager.createQuery("select o from ControlaDataEJB o where o.idHotel = ?1" ).
									        setHint("eclipselink.refresh", "TRUE").
											setParameter(1, entidade.getIdHotel()).getSingleResult();


	        TelefoniasConfigEJB telefoniaConfig = (TelefoniasConfigEJB) manager.createQuery("select o from TelefoniasConfigEJB o where o.idHotel = ?1").
	        									  setHint("eclipselink.refresh", "TRUE").
	        									  setParameter(1, entidade.getIdHotel()).getSingleResult();
	        
	        HotelEJB hotel = (HotelEJB)manager.find(HotelEJB.class, entidade.getIdHotel());
	        
	        TipoLancamentoEJB tipoLancamentoISS = null;
	        
	        List<TipoLancamentoEJB> listaTipo = manager.createQuery("select o from TipoLancamentoEJB o where o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 13 and o.idHotel = ?1" ).
	        					setHint("eclipselink.refresh", "TRUE").
	        					setParameter(1, hotel.getIdHotel()).getResultList();
	        
	        if (!MozartUtil.isNull( listaTipo )){
	        	tipoLancamentoISS = listaTipo.get(0);
	        }
	        
	        TipoLancamentoEJB tipoLancamentoTAXA = null;
	        
	        listaTipo = manager.createQuery("select o from TipoLancamentoEJB o where o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 11 and o.idHotel = ?1" ).setHint("eclipselink.refresh", "TRUE").
            setParameter(1, hotel.getIdHotel()).getResultList();
	        
	        if (!MozartUtil.isNull( listaTipo )){
	        	tipoLancamentoTAXA = listaTipo.get(0);
	        }

	        									  
			if (telefoniaConfig.getTaxa() == null){
				telefoniaConfig.setTaxa(new Double(0));
			}
			
			if (telefoniaConfig.getAcobrar() == null)
				telefoniaConfig.setAcobrar(new Double(0));

			if (entidade.getValor() == null)
				entidade.setValor(new Double(0));
			
			Double valorLigacao = entidade.getNumTelefone().trim().startsWith("90")?telefoniaConfig.getAcobrar():entidade.getNumTelefone().trim().startsWith("0800")?new Double(0):entidade.getValor();
			
			if ("S".equals(telefoniaConfig.getTarifaTaxa())){
				valorLigacao = new Double(valorLigacao * (1 + (double)(telefoniaConfig.getTaxa().doubleValue() / 100)));
			}
			
			
			MovimentoApartamentoEJB movimentoInicial = new MovimentoApartamentoEJB();
			movimentoInicial.setIdRedeHotel( controlaData.getIdRedeHotel() );
			movimentoInicial.setRoomListEJB( new RoomListEJB(((BigDecimal)idCheckin[2]).longValue()) );
			movimentoInicial.setCheckinEJB( new CheckinEJB(((BigDecimal)idCheckin[0]).longValue()));
			movimentoInicial.setTipoLancamentoEJB( telefoniaConfig.getTipoLancamentoTelefonia() );
			movimentoInicial.setNumDocumento(  entidade.getNumTelefone() );
			movimentoInicial.setDataLancamento( new Timestamp(controlaData.getFrontOffice().getTime()) );
			movimentoInicial.setHoraLancamento( new Timestamp( new java.util.Date().getTime()));
			movimentoInicial.setValorLancamento( valorLigacao );
			movimentoInicial.setQuemPaga( (String)idCheckin[3] );
			movimentoInicial.setCheckout("N");
			movimentoInicial.setMovTmp("S");
			movimentoInicial.setParcial("N");
			manager.persist( movimentoInicial );        
			
			
			
			 if (tipoLancamentoISS !=null && "N".equals(hotel.getTaxaCheckout()) && 
	        			hotel.getIss().doubleValue() > 0 && 
	        			"S".equals((String)idCheckin[4]) && 
	        			"S".equals(telefoniaConfig.getTipoLancamentoTelefonia().getIss())){
	        	
		        movimentoInicial = new MovimentoApartamentoEJB();
		        movimentoInicial.setIdRedeHotel( hotel.getRedeHotelEJB().getIdRedeHotel() );
		        movimentoInicial.setRoomListEJB( new RoomListEJB(((BigDecimal)idCheckin[2]).longValue()) );
		        movimentoInicial.setCheckinEJB( new CheckinEJB(((BigDecimal)idCheckin[0]).longValue()));
		        movimentoInicial.setTipoLancamentoEJB( tipoLancamentoISS );
		        movimentoInicial.setNumDocumento("ISS - "+ entidade.getNumTelefone());
		        movimentoInicial.setDataLancamento( new Timestamp(controlaData.getFrontOffice().getTime()) );
		        movimentoInicial.setHoraLancamento( new Timestamp( new java.util.Date().getTime()));
		        movimentoInicial.setValorLancamento( valorLigacao * (1+ ((double)hotel.getIss().doubleValue()/100)) );
		        movimentoInicial.setQuemPaga( (String)idCheckin[3] );
		        movimentoInicial.setCheckout("N");
		        movimentoInicial.setMovTmp("S");
		        movimentoInicial.setParcial("N");
		        manager.persist( movimentoInicial );
	        	
	        }
	        
	        if (tipoLancamentoTAXA != null && "N".equals(hotel.getTaxaCheckout()) && 
     			hotel.getTaxaServico().doubleValue() > 0 && 
     			"S".equals((String)idCheckin[5]) && 
     			"S".equals(telefoniaConfig.getTipoLancamentoTelefonia().getTaxaServico())){
     	
			        movimentoInicial = new MovimentoApartamentoEJB();
			        movimentoInicial.setIdRedeHotel( hotel.getRedeHotelEJB().getIdRedeHotel() );
			        movimentoInicial.setRoomListEJB( new RoomListEJB(((BigDecimal)idCheckin[2]).longValue()) );
			        movimentoInicial.setCheckinEJB( new CheckinEJB(((BigDecimal)idCheckin[0]).longValue()));
			        movimentoInicial.setTipoLancamentoEJB( tipoLancamentoTAXA );
			        movimentoInicial.setNumDocumento("ISS - "+ entidade.getNumTelefone());
			        movimentoInicial.setDataLancamento( new Timestamp(controlaData.getFrontOffice().getTime()) );
			        movimentoInicial.setHoraLancamento( new Timestamp( new java.util.Date().getTime()));
			        movimentoInicial.setValorLancamento( valorLigacao * (1+ ((double)hotel.getTaxaServico().doubleValue()/100)) );
			        movimentoInicial.setQuemPaga( (String)idCheckin[3] );
			        movimentoInicial.setCheckout("N");
			        movimentoInicial.setMovTmp("S");
			        movimentoInicial.setParcial("N");
			        manager.persist( movimentoInicial );
	        }
	        
			manager.remove( entidade );

		}catch(MozartValidateException ex){
			throw ex;

		}catch(Exception ex){
			 throw new MozartSessionException(ex.getMessage());
		}		
		
		
		
	}

}
	
	
	

