package com.mozart.model.delegate;

import com.mozart.model.ejb.entity.TransacaoWebEJB;
import com.mozart.model.ejb.facade.BraspagSession;
import com.mozart.model.exception.MozartSessionException;

public class BraspagDelegate extends MozartDelegate {
	
	private static BraspagDelegate instance;
    private static BraspagSession session;
    

    private BraspagDelegate() throws MozartSessionException {
    
        try{
        
            session = (BraspagSession) getLookup("BraspagSession");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: BraspagSession");            
            }
        }catch(Exception ex){
        
            throw new MozartSessionException(ex.getMessage());             
        
        }
    
    }
    
    public static BraspagDelegate instance() throws MozartSessionException{
    
        return instance==null?instance = new BraspagDelegate() : instance;
    
    }

	public TransacaoWebEJB realizarTransacaoWeb(TransacaoWebEJB novaTransacao) throws MozartSessionException{

		return session.realizarTransacaoWeb( novaTransacao );
	}

	public TransacaoWebEJB estornarTransacaoWeb(TransacaoWebEJB transacao) throws MozartSessionException{
		return session.estornarTransacaoWeb( transacao );
	}

}
