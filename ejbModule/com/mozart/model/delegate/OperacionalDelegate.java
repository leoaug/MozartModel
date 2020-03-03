package com.mozart.model.delegate;

import java.math.BigDecimal;
import java.util.List;

import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.CamareiraEJB;
import com.mozart.model.ejb.entity.ConfigFnrhEJB;
import com.mozart.model.ejb.entity.GarconEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MesaEJB;
import com.mozart.model.ejb.entity.NfeImpressoraEJB;
import com.mozart.model.ejb.entity.PontoVendaEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.ejb.entity.RepresentanteRedeEJB;
import com.mozart.model.ejb.entity.TipoApartamentoEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.entity.TipoRefeicaoEJB;
import com.mozart.model.ejb.entity.UnidadeEstoqueEJB;
import com.mozart.model.ejb.entity.VendedorRedeEJB;
import com.mozart.model.ejb.facade.OperacionalSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.ApartamentoHospedeVO;
import com.mozart.model.vo.ApartamentoVO;
import com.mozart.model.vo.CamareiraVO;
import com.mozart.model.vo.GarconVO;
import com.mozart.model.vo.MesaVO;
import com.mozart.model.vo.ObjetoVO;
import com.mozart.model.vo.PontoVendaVO;
import com.mozart.model.vo.RepresentanteVO;
import com.mozart.model.vo.TipoApartamentoVO;
import com.mozart.model.vo.UsuarioVO;
import com.mozart.model.vo.VendedorVO;

public class OperacionalDelegate extends MozartDelegate{

	
	 private static OperacionalDelegate instance;
	 private static OperacionalSession session;
	    

	    private OperacionalDelegate() throws MozartSessionException {
	    
	        try{
	        
	            
	            session = (OperacionalSession) getLookup("OperacionalSessionEJB");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: OperacionalSessionEJB");            
	            }
	        }catch(Exception ex){
	        
	            throw new MozartSessionException(ex.getMessage());             
	        
	        }
	    
	    }

	    private OperacionalDelegate(String name) throws MozartSessionException {
		    
	        try{
	        
	            
	            session = (OperacionalSession) getLookup(name, "OperacionalSessionEJB");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: OperacionalSessionEJB");            
	            }
	        }catch(Exception ex){
	        
	            throw new MozartSessionException(ex.getMessage());             
	        
	        }
	    
	    }

	    public static OperacionalDelegate instance(String name) throws MozartSessionException{
		    
	        return instance==null?instance = new OperacionalDelegate(name) : instance;
	    
	    }

	    public static OperacionalDelegate instance() throws MozartSessionException{
	    
	        return instance==null?instance = new OperacionalDelegate() : instance;
	    
	    }

		public List<ApartamentoEJB> pesquisarApartamento(ApartamentoVO filtro)  throws MozartSessionException{
			
			return session.pesquisarApartamento(filtro);
		}

		public List<CamareiraEJB> pesquisaCamareira(CamareiraEJB filtro) throws MozartSessionException{
			
			return session.pesquisaCamareira(filtro);
		}

		public ApartamentoEJB gravarApartamento(ApartamentoEJB apto) throws MozartSessionException{
			
			return session.gravarApartamento(apto);
		}

		public ApartamentoEJB obterApartamento(ApartamentoEJB apto)  throws MozartSessionException{
			
			return session.obterApartamento(apto);
		}

		public TipoApartamentoEJB obterTipoApartamento(
				TipoApartamentoEJB entidade) throws MozartSessionException{
			
			return session.obterTipoApartamento(entidade);
		}

		public List<TipoApartamentoVO> pesquisarTipoApartamento(
				TipoApartamentoVO filtro) throws MozartSessionException{
			
			return session.pesquisarTipoApartamento(filtro);
		}

		public CamareiraEJB obterCamareira(CamareiraEJB entidade) throws MozartSessionException{
			
			return session.obterCamareira( entidade );
		}

		public List<CamareiraVO> pesquisarCamareira(CamareiraVO filtro)  throws MozartSessionException{

			return session.pesquisarCamareira(filtro);
		}

		public List<GarconEJB> obterGarcon(GarconEJB filtroGarcon) throws MozartSessionException{
			return session.obterGarcon( filtroGarcon );
		}

		
		public void alterarStatusApartamentoLote(ApartamentoEJB aptoDe,
				ApartamentoEJB aptoPara, String idMarcados)  throws MozartSessionException{
			session.alterarStatusApartamentoLote( aptoDe, aptoPara, idMarcados );
		}

		public List<ApartamentoVO> pesquisarArea(ApartamentoVO param) throws MozartSessionException{
			return session.pesquisarArea( param ); 
		}
		
		public List<GarconVO> pesquisarGarcon(GarconVO filtro)  throws MozartSessionException{


			return session.pesquisarGarcon(filtro);
		}

		public List<MesaVO> pesquisarMesa(MesaVO filtro)  throws MozartSessionException{

			return session.pesquisarMesa(filtro);
		}
		

		public List<ObjetoVO> pesquisarObjeto(ObjetoVO filtro) throws MozartSessionException{
		
			return session.pesquisarObjeto( filtro ); 
		}

	
		public List<TipoRefeicaoEJB> pesquisarTipoRefeicao(TipoRefeicaoEJB filtro) throws MozartSessionException {
			
			return session.pesquisarTipoRefeicao(filtro);
		}

		public List<PontoVendaVO> pesquisarPontoVenda(PontoVendaVO filtro) throws MozartSessionException {
			
			return session.pesquisarPontoVenda(filtro);
		}
		
		public List<ConfigFnrhEJB> pesquisarConfigFnrh(ConfigFnrhEJB param) throws MozartSessionException {

			return session.pesquisarConfigFnrh(param);
		}
		
		public List <TipoLancamentoEJB> pesquisarTipoLancamentoPDV(TipoLancamentoEJB valor) throws MozartSessionException{
			
			return session.pesquisarTipoLancamentoPDV(valor);
			
		}
		
		public List<TipoLancamentoEJB> pesquisarTipoLancamentoContrato(TipoLancamentoEJB valor) throws MozartSessionException{
			return session.pesquisarTipoLancamentoContrato(valor);
		}
		
		public List<TipoLancamentoEJB> pesquisarTipoLancamentoContratoPagamento(TipoLancamentoEJB valor) throws MozartSessionException{
			return session.pesquisarTipoLancamentoContratoPagamento(valor);
		}
		
		public List <TipoLancamentoEJB> pesquisarTipoLancamentoServico(TipoLancamentoEJB valor) throws MozartSessionException {
			
			return session.pesquisarTipoLancamentoServico(valor);
			
		}
		
		public List <PratoEJB> pesquisarPrato(PratoEJB filtro) throws MozartSessionException {
					
					return session.pesquisarPrato(filtro);
			
		}

		public void gravarPontoVenda(PontoVendaEJB entidade) throws MozartSessionException{

			session.gravarPontoVenda(entidade);
		}
		
		public List<TipoItemEJB> pesquisarTipoItem(TipoItemEJB filtro) throws MozartSessionException {
			
			return session.pesquisarTipoItem(filtro);
		}
		
		public List<UnidadeEstoqueEJB> pesquisarUnidadeEstoque(UnidadeEstoqueEJB filtro) throws MozartSessionException {
			
			return session.pesquisarUnidadeEstoque(filtro);
		}

		public void encerrarPontoVenda(PontoVendaEJB entidade) throws MozartSessionException {
			
			session.encerrarPontoVenda(entidade);
			
		}

		public List<PontoVendaEJB> obterPontoVendaEncerramento(HotelEJB hotelCorrente) throws MozartSessionException {

			return session.obterPontoVendaEncerramento(hotelCorrente);
		}
		
		public BigDecimal obterQuantidadeMovimentosAbertos(HotelEJB hotelCorrente) throws MozartSessionException{
			return session.obterQuantidadeMovimentosAbertos(hotelCorrente);
		}

		public void gravarTipoLancamento(TipoLancamentoEJB entidade) throws MozartSessionException {
			
			try{
				session.gravarTipoLancamento( entidade );
	    	}catch(MozartValidateException ex){
	    		throw ex;
	    	}catch(Exception ex){
				String msg = ex.getCause().getCause().getMessage();
				if (msg.indexOf("-2000") >= 0){
					throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
				}else{
					throw new MozartSessionException(ex.getMessage());
				}
			}
	    	
			
		}

		public List<PontoVendaVO> pesquisarPontoVendaUsuario(UsuarioVO filtro) throws MozartSessionException {
			
			return session.pesquisarPontoVendaUsuario(filtro);
		}
		
		public List<ApartamentoHospedeVO> pesquisarApartamentoHospede(ApartamentoHospedeVO filtro) throws MozartSessionException {
			
			return session.pesquisarApartamentoHospede(filtro);
		}
		
		public List<MesaEJB> pesquisarMesaLivre(Long idPontoVenda, String numMesa, String statusMesa) throws MozartSessionException  {
			
			return session.pesquisarMesaLivre(idPontoVenda, numMesa, statusMesa);
		}
		
		public List<PratoEJB> pesquisarPrato(String nomePrato, Long idHotel) throws MozartSessionException {
			return session.pesquisarPrato(nomePrato, idHotel);
		}
		
		public List<NfeImpressoraEJB> pesquisarImpressoras() throws MozartSessionException {
			return session.pesquisarImpressoras();
		}
		
		public void gravarRepresentante(RepresentanteRedeEJB representante) throws MozartSessionException {
			session.gravarRepresentante(representante);
		}
		
		public List<RepresentanteVO> pesquisarRepresentante(RepresentanteVO filtro)
				throws MozartSessionException{
			return session.pesquisarRepresentante(filtro);
		}
		
		public void gravarVendedor(VendedorRedeEJB representante) throws MozartSessionException {
			session.gravarVendedor(representante);
		}
		
		public List<VendedorVO> pesquisarVendedor(VendedorVO filtro)
				throws MozartSessionException{
			return session.pesquisarVendedor(filtro);
		}

}