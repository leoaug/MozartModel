package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.ConfigBloqueteEJB;
import com.mozart.model.ejb.entity.ContaCorrenteEJB;
import com.mozart.model.ejb.entity.IdentificaLancamentoEJB;
import com.mozart.model.ejb.entity.TipoPensaoEJB;
import com.mozart.model.ejb.facade.ControladoriaSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ContaCorrenteVO;
import com.mozart.model.vo.LogUsuarioVO;
import com.mozart.model.vo.TipoLancamentoVO;
import com.mozart.model.vo.ValorCafeVO;
import com.mozart.model.vo.ValorDolarVO;

public class ControladoriaDelegate extends MozartDelegate{
	 	
	
		private static ControladoriaDelegate instance;
	    private static ControladoriaSession session;
	    

	    private ControladoriaDelegate() throws MozartSessionException {
	    
	        try{
	            session = (ControladoriaSession) getLookup("ControladoriaSession");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: ControladoriaSession");            
	            }
	        }catch(Exception ex){
	        
	            throw new MozartSessionException(ex.getMessage());             
	        
	        }
	    
	    }
	    
	    public static ControladoriaDelegate instance() throws MozartSessionException{
	        
	        return instance==null?instance = new ControladoriaDelegate() : instance;
	    
	    }	  
	  
	    public List<ValorDolarVO> pesquisarValorDolar(ValorDolarVO filtro) throws MozartSessionException {
			return session.pesquisarValorDolar(filtro);
		}
	    
	    public List<ValorCafeVO> pesquisarValorCafe(ValorCafeVO filtro) throws MozartSessionException {
			return session.pesquisarValorCafe(filtro);
		}  
	    	   
	    public List<TipoPensaoEJB> pesquisarTipoPensao() throws MozartSessionException {
	    	return session.pesquisarTipoPensao();
		}	 
	    
	    public List<ContaCorrenteVO> pesquisarContaCorrente(ContaCorrenteVO filtro) throws MozartSessionException {
	    	return session.pesquisarContaCorrente(filtro);
		}

		public String[] obterDadosContaCorrente(ContaCorrenteEJB contaCorrente) throws MozartSessionException {
			return session.obterDadosContaCorrente(contaCorrente);
		}

		public List<LogUsuarioVO> pesquisarLogUsuario(LogUsuarioVO filtro)throws MozartSessionException {
			return session.pesquisarLogUsuario(filtro);
		}

		public List<TipoLancamentoVO> pesquisarTipoLancamento(
				TipoLancamentoVO filtro) throws MozartSessionException {
			return session.pesquisarTipoLancamento(filtro);
		}

		public List<IdentificaLancamentoEJB> obterIdentificaLancamentoEJB(
				IdentificaLancamentoEJB filtro) throws MozartSessionException {
			return session.obterIdentificaLancamentoEJB(filtro);
		}

		public TipoLancamentoVO obterProximoSubGrupoLancamento(
				TipoLancamentoVO pFiltro) throws MozartSessionException {
			return session.obterProximoSubGrupoLancamento( pFiltro );
		}
		public List<ConfigBloqueteEJB> obterListConfigBloquete(
				ConfigBloqueteEJB configBloqueteEJB)  throws MozartSessionException{
			return session.obterListConfigBloquete(configBloqueteEJB);
		}
		public void gravarConfigBloquete(ConfigBloqueteEJB configBloqueteEJB) 
				throws MozartSessionException{
			session.gravarConfigBloquete(configBloqueteEJB);
		}
		public Object find(Class classe, Object id )  throws MozartSessionException{
			return session.find(classe, id );
		}

		public List<ContaCorrenteVO> obterContaCorrenteLookup(
				ContaCorrenteVO filtro) throws MozartSessionException {
			return session.obterContaCorrenteLookup( filtro);
		}
		
}