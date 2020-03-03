package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.ServicosContratoEJB;
import com.mozart.model.ejb.facade.ContratoSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ContratoVO;

public class ContratoDelegate extends MozartDelegate {
	
	private static ContratoDelegate instance;
    private static ContratoSession session;

    private ContratoDelegate() throws MozartSessionException {
        try{
            session = (ContratoSession) getLookup("ContratoSession");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: ContratoSession");            
            }
            
        } catch (Exception ex) {
            throw new MozartSessionException(ex.getMessage());             
        }
    }
    
    public static ContratoDelegate instance() throws MozartSessionException {
    	if (instance == null) 
    		instance = new ContratoDelegate();
        return instance;
    }
	
    public List<ContratoVO> obterListaContratos(ContratoVO filtro)
			throws MozartSessionException{
		return session.obterListaContratos(filtro);
	}
    
    public ServicosContratoEJB gravarContrato(ServicosContratoEJB entidade) throws MozartSessionException{
    	return session.gravarContrato(entidade);
    }
}
