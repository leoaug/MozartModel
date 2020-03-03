package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.ScmMudancaEJB;
import com.mozart.model.ejb.entity.ScmSistemaEJB;
import com.mozart.model.ejb.entity.ScmStatusEJB;
import com.mozart.model.ejb.facade.MudancaSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ScmMudancaVO;

public class MudancaDelegate extends MozartDelegate {
	
	

	private static MudancaDelegate instance;
    private static MudancaSession session;
    
	private MudancaDelegate() throws MozartSessionException {
		    
	        try{
	        
	            session = (MudancaSession) getLookup("MudancaSession");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: MudancaDelegate");            
	            }
	        }catch(Exception ex){
	        
	            throw new MozartSessionException(ex.getMessage());             
	        
	        }
	    
	}
	
	public static MudancaDelegate instance() throws MozartSessionException{
	        
	        return instance==null?instance = new MudancaDelegate() : instance;
	    
	}

	    
	public List<ScmMudancaVO> pesquisarMudanca(ScmMudancaVO pFiltro) throws MozartSessionException {
	    	return session.pesquisarMudanca( pFiltro );
	}

	public List<ScmSistemaEJB> pesquisarSistema() throws MozartSessionException {
		return session.pesquisarSistema();
	}

	public List<ScmStatusEJB> pesquisarStatus(ScmMudancaEJB filtro)  throws MozartSessionException {

		return session.pesquisarStatus(filtro);
	}

}
