package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.CentralReservaEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.facade.CrsSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.CrsVO;

public class CrsDelegate extends MozartDelegate{
	
	
    private static CrsDelegate instance;
    private static CrsSession session;

    private CrsDelegate() throws MozartSessionException {
    
        try{
        
            session = (CrsSession) getLookup("CrsSessionEJB");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: CrsSession");            
            }
        }catch(Exception ex){
        
            throw new MozartSessionException(ex.getMessage());             
        
        }
    
    }
    
    public static CrsDelegate instance() throws MozartSessionException{
    
        return instance==null?instance = new CrsDelegate() : instance;
    
    }
    
    
    public List<HotelEJB> pesquisarHotel(CrsVO filtro) throws MozartSessionException {
    	return session.pesquisarHotel(filtro);
    }
    
    public HotelEJB pesquisarOcupacao(CrsVO filtro) throws MozartSessionException {
    	return session.pesquisarOcupacao(filtro);
    }
    
    public HotelEJB pesquisarDisponibilidade(CrsVO filtro) throws MozartSessionException {
    	return session.pesquisarDisponibilidade(filtro);
    }

	public CentralReservaEJB obterCrsPropria(RedeHotelEJB redeHotelEJB) throws MozartSessionException {
    	return session.obterCrsPropria(redeHotelEJB);
	}

}
