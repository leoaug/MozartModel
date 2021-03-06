package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.AdministradorCanaisEJB;
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
import com.mozart.model.ejb.facade.RedeSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.AdministradorCanaisVO;
import com.mozart.model.vo.CentroCustoVO;
import com.mozart.model.vo.CreditoEmpresaDetalheVO;
import com.mozart.model.vo.CreditoEmpresaVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.LogUsuarioVO;
import com.mozart.model.vo.MoedaVO;
import com.mozart.model.vo.PatrimonioSetorVO;
import com.mozart.model.vo.PlanoContaVO;
import com.mozart.model.vo.PromotorVO;

public class RedeDelegate extends MozartDelegate{

	
		private static RedeDelegate instance;
		private static RedeSession session;
			    
		
		private RedeDelegate() throws MozartSessionException {
			try{
				session = (RedeSession) getLookup("RedeSessionEJB");
				if (session == null){
					throw new MozartSessionException("N�o foi possivel localizar: RedeSessionEJB");            
			    }
		    }catch(Exception ex){
		        throw new MozartSessionException(ex.getMessage());             
		    }
			
		}

		
		private RedeDelegate(String name) throws MozartSessionException {

			try {
	            session = (RedeSession) getLookup(name, "RedeSessionEJB");
				if (session == null) {
					throw new MozartSessionException("N�o foi possivel localizar: ReservaSessionEJB");
				}
			} catch (Exception ex) {
				throw new MozartSessionException(ex.getMessage());
			}
		}

		public static RedeDelegate instance(String name) throws MozartSessionException {
			return instance == null ? instance = new RedeDelegate(name) : instance;
		}
		
		public static RedeDelegate instance() throws MozartSessionException{
		    return instance==null?instance = new RedeDelegate() : instance;
		}

	    public List<CreditoEmpresaVO> pesquisarCreditoEmpresa(CreditoEmpresaVO pFiltro) throws MozartSessionException{
	    	return session.pesquisarCreditoEmpresa(pFiltro);
	    }

		public LogUsuarioVO obterUltimoLog(LogUsuarioVO ultimoLog)  throws MozartSessionException{
			return session.obterUltimoLog(ultimoLog);
		}

		public List<CreditoEmpresaDetalheVO> obterCreditoEmpresaDetalhe(CreditoEmpresaDetalheVO pFiltro)  throws MozartSessionException{
			return session.obterCreditoEmpresaDetalhe(pFiltro);
		}
	    
		public List<MoedaVO> pesquisarMoeda(MoedaVO filtro) throws MozartSessionException {
			return session.pesquisarMoeda(filtro);
		}	

		public MoedaVO buscarMoedaPorCodigo(String codigoMoeda) throws MozartSessionException {
			return session.buscarMoedaPorCodigo(codigoMoeda);
		}	

		public List<PromotorVO> pesquisarPromotor(PromotorVO filtro) throws MozartSessionException {
			return session.pesquisarPromotor(filtro);
				
		}

		public List<TipoHospedeEJB> pesquisarTipoHospede(TipoHospedeEJB filtro) throws MozartSessionException {
			return session.pesquisarTipoHospede(filtro);
				
		}
		
		public List<GrupoPratoEJB> pesquisarGrupoPrato(GrupoPratoEJB filtro) throws MozartSessionException {
			return session.pesquisarGrupoPrato(filtro);
				
		}
		
		public List<SetorPatrimonioEJB> pesquisarSetorPatrimonio(SetorPatrimonioEJB filtro) throws MozartSessionException {
			return session.pesquisarSetorPatrimonio(filtro);
				
		}

		public List<TipoDiariaEJB> pesquisarTipoDiaria(TipoDiariaEJB filtro) throws MozartSessionException {
			return session.pesquisarTipoDiaria(filtro);
		}
		
		public List<HistoricoContabilEJB> pesquisarHistoricoContabil(HistoricoContabilEJB filtro) throws MozartSessionException {
			return session.pesquisarHistoricoContabil(filtro);
		}
		
		public List<DepartamentoEJB> pesquisarDepartamento(DepartamentoEJB filtro) throws MozartSessionException {
			return session.pesquisarDepartamento(filtro);
		}
		
		public List<IndiceEconomicoEJB> pesquisarIndiceEconomico(IndiceEconomicoEJB filtro) throws MozartSessionException {
			return session.pesquisarIndiceEconomico(filtro);
		}
		
		public List<IndiceTipoEJB> pesquisarIndiceTipo(Long idRedeHotel) throws MozartSessionException {
			return session.pesquisarIndiceTipo(idRedeHotel);
		}
		
		public List<PlanoContaVO> pesquisarPlanoConta(PlanoContaVO filtro) throws MozartSessionException {
			return session.pesquisarPlanoConta(filtro);
		}
		
		public List<PlanoContaVO> obterPlanoContasDemonstrativoAnalitico(PlanoContaVO filtro) throws MozartSessionException {
			return session.obterPlanoContasDemonstrativoAnalitico(filtro);
		}
		
		public List<PlanoContasSpedEJB> pesquisarPlanoContasSped(Long idRedeHotel) throws MozartSessionException {
			return session.pesquisarPlanoContasSped(idRedeHotel);
		}
		
		public List<CentroCustoContabilEJB> pesquisarCentroCusto(CentroCustoContabilEJB filtro) throws MozartSessionException {
			return session.pesquisarCentroCusto(filtro);
		}

		public List<CentroCustoVO> pesquisarCentroCusto(CentroCustoVO filtro) throws MozartSessionException {

			return session.pesquisarCentroCusto(filtro);
		}
		
		public List<AdministradorCanaisVO> pesquisarAdministradorCanais(AdministradorCanaisVO filtro)  throws MozartSessionException{
			return session.pesquisarAdministradorCanais(filtro);		
		}
		
		public void gravarAdministradorCanais(AdministradorCanaisEJB administradorCanaisEJB) throws MozartSessionException{}
		
		public List<HospedeVO> obterHospedePorNomeSobrenomeCpfPassaporte(Long idRedeHotel, String parametro) throws MozartSessionException {
			return session.obterHospedePorNomeSobrenomeCpfPassaporte(idRedeHotel, parametro);
		}
		
		public List<HospedeVO> obterHospedePorNomeSobrenomeCpfPassaporte(Long idRedeHotel, String parametro, Long idHospedeNaoListado) throws MozartSessionException {
			return session.obterHospedePorNomeSobrenomeCpfPassaporte(idRedeHotel, parametro, idHospedeNaoListado);
		}
		
		public void executarProcedureTransferenciaHospede(RedeHotelEJB redeHotel, Long idHotel, Long idHospedeDe, Long idHospedePara) throws MozartSessionException {
			session.executarProcedureTransferenciaHospede(redeHotel, idHotel, idHospedeDe, idHospedePara);
		}
		
		public List<PatrimonioSetorVO> pesquisarListaSetorPatrimonio(PatrimonioSetorVO filtro) throws MozartSessionException {
			return session.pesquisarListaSetorPatrimonio(filtro);
		}
		
		public List<PlanoContaVO> pesquisarPlanoContaSugest(PlanoContaVO filtro)  throws MozartSessionException{
			return session.pesquisarPlanoContaSugest(filtro);
		}
}