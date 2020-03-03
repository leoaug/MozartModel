package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.CentroCustoContabilEJB;
import com.mozart.model.ejb.entity.DepartamentoEJB;
import com.mozart.model.ejb.entity.GrupoPratoEJB;
import com.mozart.model.ejb.entity.HistoricoContabilEJB;
import com.mozart.model.ejb.entity.IndiceEconomicoEJB;
import com.mozart.model.ejb.entity.IndiceTipoEJB;
import com.mozart.model.ejb.entity.PlanoContasSpedEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.SetorPatrimonioEJB;
import com.mozart.model.ejb.entity.TipoDiariaEJB;
import com.mozart.model.ejb.entity.TipoHospedeEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.AdministradorCanaisVO;
import com.mozart.model.vo.CentroCustoVO;
import com.mozart.model.vo.CreditoEmpresaDetalheVO;
import com.mozart.model.vo.CreditoEmpresaVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.LogUsuarioVO;
import com.mozart.model.vo.MoedaVO;
import com.mozart.model.vo.PatrimonioSetorVO;
import com.mozart.model.vo.PlanoContaVO;
import com.mozart.model.vo.PlanoContaVO.TypeOfPlanoConta;
import com.mozart.model.vo.PratoConsumoInternoVO.TypeOfPratoConsumoInterno;
import com.mozart.model.vo.PromotorVO;

@SuppressWarnings("unchecked")
@Stateless(name="RedeSessionEJB")

public class RedeSessionBean implements RedeSession {
	@PersistenceContext(unitName="MozartModel")
	private EntityManager manager;
    public RedeSessionBean() {
    }
		
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<CreditoEmpresaVO> pesquisarCreditoEmpresa(CreditoEmpresaVO pFiltro) throws MozartSessionException{
        try{
            String sql = QUERY_CREDITO_EMPRESA;

            if (!MozartUtil.isNull( pFiltro.getFiltroPossuiCredito().getTipoIntervalo())){
            	sql += " AND CREDITO " + pFiltro.getFiltroPossuiCredito();
            }

            if (!MozartUtil.isNull( pFiltro.getFiltroDataCadastro().getTipoIntervalo())){
            	sql += " AND TRUNC(DATA_CADASTRO) " + pFiltro.getFiltroDataCadastro();
            }

            if (!MozartUtil.isNull( pFiltro.getFiltroNomeFantasia().getTipoIntervalo())){
            	sql += " AND NOME_FANTASIA " + pFiltro.getFiltroNomeFantasia();
            }

            if (!MozartUtil.isNull( pFiltro.getFiltroDuplicataVencida().getTipoIntervalo())){
            	sql += " AND DECODE(GREATEST(VENCIDAS,0),0,'N','S') " + pFiltro.getFiltroDuplicataVencida();
            }

            if (!MozartUtil.isNull( pFiltro.getFiltroSaldoNegativo().getTipoIntervalo())){
            	sql += " AND DECODE(GREATEST(SALDO,0),SALDO,'N','S') " + pFiltro.getFiltroSaldoNegativo();
            }
            
            if (!MozartUtil.isNull( pFiltro.getFiltroCNPJ().getTipoIntervalo())){
            	sql += " AND CGC " + pFiltro.getFiltroCNPJ();
            }
            
            List lista = manager.createNativeQuery( sql ).
                         setParameter(1, pFiltro.getIdRedeHotel()).
                         setParameter(2, pFiltro.getIdRedeHotel()).
                         setParameter(3, pFiltro.getIdRedeHotel()).
                         setParameter(4, pFiltro.getIdRedeHotel()).
                         setParameter(5, pFiltro.getIdRedeHotel()).
                         setParameter(6, pFiltro.getIdRedeHotel()).
                         setParameter(7, pFiltro.getIdRedeHotel()).
                         getResultList();
            List<CreditoEmpresaVO> resultado = new ArrayList<CreditoEmpresaVO>();                     
            for (Object l: lista){
                resultado.add( new CreditoEmpresaVO( (Object[])l ) );
            }           
            return resultado;
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );
        }
    }

	public LogUsuarioVO obterUltimoLog(LogUsuarioVO ultimoLog) throws MozartSessionException {
        try{
            String sql = QUERY_LOG_USUARIO;
            List lista = (List) manager.createNativeQuery( sql ).
            									setParameter(1, ultimoLog.getIdAuditado()).
            									setParameter(2, ultimoLog.getTabelaAuditada()).
            									setParameter(3, ultimoLog.getIdRedeHotel()).getResultList();
            if (MozartUtil.isNull( lista ))
            	return null;
            
        	return new LogUsuarioVO((Object[])lista.get(0));
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );
        }		
   }
		
	public List<CreditoEmpresaDetalheVO> obterCreditoEmpresaDetalhe(CreditoEmpresaDetalheVO pFiltro) throws MozartSessionException{
	    try{
            String sql = QUERY_CREDITO_EMPRESA_DETALHE;
            List lista = (List) manager.createNativeQuery( sql ).
            									setParameter(1, pFiltro.getIdRedeHotel()).
            									setParameter(2, pFiltro.getIdEmpresa()).
            									setParameter(3, pFiltro.getIdRedeHotel()).
            									setParameter(4, pFiltro.getIdEmpresa()).
            									setParameter(5, pFiltro.getIdRedeHotel()).	
            									setParameter(6, pFiltro.getIdEmpresa()).
            									setParameter(7, pFiltro.getIdRedeHotel()).
            									setParameter(8, pFiltro.getIdEmpresa()).
            									getResultList();
            
            List<CreditoEmpresaDetalheVO> resultado = new ArrayList<CreditoEmpresaDetalheVO>();
            for (Object linha: lista){
            	resultado.add(new CreditoEmpresaDetalheVO((Object[])linha));
            }
        	return resultado;
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );
        }
	}

	public List<MoedaVO> pesquisarMoeda(MoedaVO filtro)
			throws MozartSessionException {
		try{
            String sql = QUERY_MOEDA;
            List lista = (List) manager.createNativeQuery( sql ).getResultList();      									
            
            List<MoedaVO> resultado = new ArrayList<MoedaVO>();
            for (Object linha: lista){
            	resultado.add(new MoedaVO((Object[])linha));
            }
        	return resultado;
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );
        }
	}
	
	public MoedaVO buscarMoedaPorCodigo(String codigoMoeda) throws MozartSessionException {
		try{
            String sql = QUERY_MOEDA_CODIGO;
            MoedaVO moeda = null;       								
            		
			List<?> lista = manager.createNativeQuery( sql ).setParameter(1, codigoMoeda).getResultList();
			int param = 0;
			for (Object linhas : lista) {
				Object[] linha = (Object[]) linhas;
				moeda = new MoedaVO();
				moeda.setIdMoeda(((BigDecimal)linha[param++]).longValue());
				moeda.setNomeMoeda((String)linha[param++]);
				moeda.setSigla((String)linha[param++]);
				moeda.setSimbolo((String)linha[param++]);
			}
			
			if(moeda == null){
				throw new MozartSessionException("Nenhuma Moeda encontrada em MOEDA com SIGLA = [" + codigoMoeda + "]");
			}

        	return moeda;
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
	}

	public List<PromotorVO> pesquisarPromotor(PromotorVO filtro)
			throws MozartSessionException {
		try {
			String sql = QUERY_PROMOTOR;
			List lista = (List) manager.createNativeQuery( sql ).setParameter(1, filtro.getIdRedeHotel()).getResultList();
			List <PromotorVO> resultado = new ArrayList<PromotorVO>();
			for (Object linha: lista){
				resultado.add(new PromotorVO ((Object[])linha));
			}
			return resultado;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<TipoHospedeEJB> pesquisarTipoHospede(TipoHospedeEJB filtro)
			throws MozartSessionException {
		try {
			List<TipoHospedeEJB> lista=manager.createNamedQuery("TipoHospedeEJB.findByRede").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, filtro.getIdRedeHotel()).getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<GrupoPratoEJB> pesquisarGrupoPrato(GrupoPratoEJB filtro)
			throws MozartSessionException {
		try {
			
			List<GrupoPratoEJB> lista=manager.createNamedQuery("GrupoPratoEJB.findByHotel").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, filtro.getIdHotel()).getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<SetorPatrimonioEJB> pesquisarSetorPatrimonio(SetorPatrimonioEJB filtro)
			throws MozartSessionException {
		try {
			
			List<SetorPatrimonioEJB> lista=manager.createNamedQuery("SetorPatrimonioEJB.findByRede").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, filtro.getIdRedeHotel()).getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<TipoDiariaEJB> pesquisarTipoDiaria(TipoDiariaEJB filtro)
			throws MozartSessionException {
		try {
			List<TipoDiariaEJB> lista=manager.createNamedQuery("TipoDiariaEJB.findAllByRede").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, filtro.getIdRedeHotel()).getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<HistoricoContabilEJB> pesquisarHistoricoContabil(HistoricoContabilEJB filtro)
			throws MozartSessionException {
	
		try {
			
			List<HistoricoContabilEJB> lista=manager.createNamedQuery("HistoricoContabilEJB.findByRede").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, filtro.getIdRedeHotel()).getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}

	public List<DepartamentoEJB> pesquisarDepartamento(DepartamentoEJB filtro)
			throws MozartSessionException {
		try {
			
			List<DepartamentoEJB> lista=manager.createNamedQuery("DepartamentoEJB.findByRede").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, filtro.getIdRedeHotel()).getResultList();
			return lista;
		} catch (Exception ex) {
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<IndiceEconomicoEJB> pesquisarIndiceEconomico(IndiceEconomicoEJB filtro)
			throws MozartSessionException {
		try {
			
			List<IndiceEconomicoEJB> lista=manager.createNamedQuery("IndiceEconomicoEJB.findByRede").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, filtro.getIdRedeHotel()).getResultList();
			return lista;
		} catch (Exception ex) {
			throw new MozartSessionException (ex.getMessage());
		}
	}

	public List<IndiceTipoEJB> pesquisarIndiceTipo(Long idRedeHotel) throws MozartSessionException {
		try {
			
			List<IndiceTipoEJB> lista=manager.createNamedQuery("IndiceTipoEJB.findByRede").
			setHint("eclipselink.refresh", "TRUE").setParameter(1, idRedeHotel).getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<PlanoContaVO> pesquisarPlanoContaSugest(PlanoContaVO filtro)  throws MozartSessionException {
		
		try {
			
			StringBuilder sql = new StringBuilder(QUERY_PLANO_CONTA_SUGEST);
			String orderBy = " ORDER BY CONTA_CONTABIL ";
							
			if (!MozartUtil.isNull(
					filtro.getFiltroAjax().getTipoIntervalo())){
				sql.append(" AND ( ")
					.append(" UPPER(TRIM(NOME_CONTA)) ")
					.append(filtro.getFiltroAjax())
					.append(" OR ")
					.append(" UPPER(TRIM(CONTA_CONTABIL)) ")
					.append(filtro.getFiltroAjax())
					.append(") ");
			}
							
			sql.append(orderBy);
			
		    List lista = manager.createNativeQuery( sql.toString() ).
		               setParameter(1, filtro.getIdRedeHotel()).
		               getResultList();
		    List<PlanoContaVO> resultado = new ArrayList<PlanoContaVO>();                     
		    for (Object l: lista){
		        resultado.add( new PlanoContaVO( (Object[])l, TypeOfPlanoConta.COMBO_SUGGEST ) );
		    }           
			  
			return resultado;
			
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<PlanoContaVO> pesquisarPlanoConta(PlanoContaVO filtro)  throws MozartSessionException {
		
		try {
			
			String sql = QUERY_PLANO_CONTA;
			String orderBy = filtro.getOrdem()==1?" ORDER BY PC.NOME_CONTA ":" ORDER BY PC.NOME_CONTA ";
							
						if (!MozartUtil.isNull( filtro.getFiltroContaContabil().getTipoIntervalo())){
			            	sql += " AND CONTA_CONTABIL " + filtro.getFiltroContaContabil();
			            }
			
			            if (!MozartUtil.isNull( filtro.getFiltroContaReduzida().getTipoIntervalo())){
			            	sql += " AND CONTA_REDUZIDA " + filtro.getFiltroContaReduzida();
			            }
			
			            if (!MozartUtil.isNull( filtro.getFiltroNomeConta().getTipoIntervalo())){
			            	sql += " AND NOME_CONTA " + filtro.getFiltroNomeConta();
			            }
			
			            if (!MozartUtil.isNull( filtro.getFiltroTipoConta().getTipoIntervalo())){
			            	sql += " AND DECODE (PC.TIPO_CONTA, 'A', 'Analitico', 'Sintetico') " + filtro.getFiltroTipoConta();
			            }

			            if (!MozartUtil.isNull( filtro.getFiltroAtivoPassivo().getTipoIntervalo())){
			            	sql += " AND PC.ATIVO_PASSIVO " + filtro.getFiltroAtivoPassivo();
			            }
							
			    sql += orderBy;
			
			   List lista = manager.createNativeQuery( sql ).
			               setParameter(1, filtro.getIdRedeHotel()).
			               getResultList();
			  List<PlanoContaVO> resultado = new ArrayList<PlanoContaVO>();                     
			  for (Object l: lista){
			      resultado.add( new PlanoContaVO( (Object[])l, TypeOfPlanoConta.GERAL ) );
			  }           
			  
			return resultado;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<PlanoContaVO> obterPlanoContasDemonstrativoAnalitico(PlanoContaVO filtro) 
			throws MozartSessionException {
		StringBuilder sql = new StringBuilder(QUERY_PLANO_CONTA);
		
		if (!MozartUtil.isNull(
				filtro.getFiltroTipoConta().getTipoIntervalo())){
			sql.append( " AND PC.TIPO_CONTA " )
				.append(filtro.getFiltroTipoConta());
		}
		
		if (!MozartUtil.isNull(
				filtro.getFiltroAtivoPassivo().getTipoIntervalo())){
			sql.append( " AND PC.ATIVO_PASSIVO " )
				.append(filtro.getFiltroAtivoPassivo());
		}
		
		if (!MozartUtil.isNull(
				filtro.getFiltroAjax().getTipoIntervalo())){
			sql.append(" AND ( ")
				.append(" UPPER(TRIM(NOME_CONTA)) ")
				.append(filtro.getFiltroAjax())
				.append(" OR ")
				.append(" UPPER(TRIM(CONTA_CONTABIL)) ")
				.append(filtro.getFiltroAjax())
				.append(" OR ")
				.append(" UPPER(TRIM(CONTA_REDUZIDA)) ")
				.append(filtro.getFiltroAjax())
				.append(") ");
		}
		
		sql.append(" ORDER BY CONTA_CONTABIL ASC ");
		
		try {
			List lista = manager.createNativeQuery(sql.toString())
					.setParameter(1, filtro.getIdRedeHotel())
					.getResultList();
		
			List<PlanoContaVO> resultado = new ArrayList<PlanoContaVO>();                     
			for (Object l: lista){
				resultado.add( new PlanoContaVO( (Object[])l, TypeOfPlanoConta.GERAL));
			}           
			
			return resultado;
			
		} catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
	public List<PlanoContasSpedEJB> pesquisarPlanoContasSped(Long idRedeHotel) throws MozartSessionException{ 
		try {
			List<PlanoContasSpedEJB> lista = manager.createQuery( 
					"select o from PlanoContasSpedEJB o order by o.numeroConta")
					.getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}

	public List<CentroCustoContabilEJB> pesquisarCentroCusto(CentroCustoContabilEJB filtro) throws MozartSessionException {
		try {
			List<CentroCustoContabilEJB> lista = manager.createNamedQuery("CentroCustoContabilEJB.findByRede")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, filtro.getIdRedeHotel())
					.getResultList();
			return lista;
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}

	public List<CentroCustoVO> pesquisarCentroCusto(CentroCustoVO filtro) throws MozartSessionException {
		try {
			String sql = QRY_CENTRO_CUSTO;
			
			if (!MozartUtil.isNull( filtro.getFiltroControlado().getTipoIntervalo())){
				sql += " AND CCC.CONTROLADO " + filtro.getFiltroControlado();
			}
			sql += " ORDER BY DESCRICAO_CENTRO_CUSTO ";
		
			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdRedeHotel())
					.getResultList();
			
			List<CentroCustoVO> resultado = new ArrayList<CentroCustoVO>();
			for (Object l: lista){
				resultado.add( new CentroCustoVO( (Object[])l ) );
			}
			
			return resultado;
		
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<AdministradorCanaisVO> pesquisarAdministradorCanais(AdministradorCanaisVO filtro)
			throws MozartSessionException {
		
		String sql = QRY_ADMINISTRADOR_CANAIS;
		
		String sqlConector = " ", sqlFiltro="";
		
		if (!MozartUtil.isNull(filtro.getEmpresa().getTipoIntervalo())){
			sqlFiltro += sqlConector +  " UPPER(ER.NOME_FANTASIA) " + filtro.getEmpresa().toString().toUpperCase();
			sqlConector = "\n AND ";
		}
		if (!MozartUtil.isNull(filtro.getIdRedeHotel())){
			sqlFiltro += sqlConector + " G.ID_REDE_HOTEL = " + filtro.getIdRedeHotel();
			sqlConector = "\n AND ";
		}

		if(!MozartUtil.isNull(sqlFiltro)){
			sql += " WHERE \n" + sqlFiltro;
		}
		sql +=  "\n order by er.nome_fantasia "; 
		
		
		List lista = manager.createNativeQuery( sql ).getResultList();
		List<AdministradorCanaisVO> resultado = new ArrayList<AdministradorCanaisVO>();                     
		for (Object l: lista){
			resultado.add( new AdministradorCanaisVO( (Object[])l ) );
		}           
		return resultado;	
	}		
	
	public List<HospedeVO> obterHospedePorNomeSobrenomeCpfPassaporte(Long idRedeHotel, String parametro)
			throws MozartSessionException {
		try {
			List<HospedeVO> listHospede = obterHospedePorNomeSobrenomeCpfPassaporte(idRedeHotel, parametro, null);
			return listHospede;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<HospedeVO> obterHospedePorNomeSobrenomeCpfPassaporte(Long idRedeHotel, String parametro, Long idHospedeNaoListado)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_HOSPEDE_POR_NOME;
			SQL = SQL	+ " WHERE H.ID_REDE_HOTEL = ?1 "
						+ ((! MozartUtil.isNull(idHospedeNaoListado))? " AND ID_HOSPEDE <> "+idHospedeNaoListado : "") 
			
						+ " AND (UPPER(TRIM(NOME_HOSPEDE)) LIKE '%" + parametro.toUpperCase() + "%' "  
						+ " OR UPPER(TRIM(SOBRENOME_HOSPEDE)) LIKE '%" + parametro.toUpperCase() + "%' "  
						+ " OR UPPER(TRIM(CPF)) LIKE '%" + parametro.toUpperCase() + "%' "  
						+ " OR UPPER(TRIM(PASSAPORTE)) LIKE '%" + parametro.toUpperCase() + "%') "
						+ " ORDER BY UPPER(H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE||NVL2(H.CPF,'-', '')||H.CPF)";

			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, idRedeHotel).getResultList();

			List<HospedeVO> listHospede = new ArrayList();
			for (Object lis : lista) {
				HospedeVO vo = new HospedeVO();
				vo.setaDados((Object[]) lis);
				listHospede.add(vo);
			}
			return listHospede;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void executarProcedureTransferenciaHospede(RedeHotelEJB redeHotel, Long idHotel, Long idHospedeDe, Long idHospedePara)
			throws MozartSessionException {
		try {
			manager.createNativeQuery(
					"{call PROC_TROCAHOSPEDE(?1,?2,?3,?4)}")
					.setParameter(1, redeHotel.getIdRedeHotel())
					.setParameter(2, idHotel)
					.setParameter(3, idHospedePara)
					.setParameter(4, idHospedeDe)
					.executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}
	
	public List<PatrimonioSetorVO> pesquisarListaSetorPatrimonio(PatrimonioSetorVO filtro)
			throws MozartSessionException {
		try {
			
			String SQL = QUERY_PATRIMONIO_SETOR;
			String sqlConector = "\n AND ";
			if (!MozartUtil.isNull(filtro.getFiltroNomeOuNomeReduzido().getTipoIntervalo())){
				SQL += sqlConector +  " UPPER(DESCRICAO) " + filtro.getFiltroNomeOuNomeReduzido().toString().toUpperCase();
				sqlConector = "\n AND ";
			}

			SQL += " ORDER BY DESCRICAO ";
			
			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, filtro.getIdHoteis()[0]).getResultList();

			List<PatrimonioSetorVO> listaPatrimonio = new ArrayList();
			for (Object lis : lista) {
				PatrimonioSetorVO vo = new PatrimonioSetorVO((Object[]) lis);
				listaPatrimonio.add(vo);
			}
			return listaPatrimonio;
			
		}catch (Exception ex){
			throw new MozartSessionException (ex.getMessage());
		}
	}
	
}