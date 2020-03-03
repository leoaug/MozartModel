package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.facade.MarketingSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.MarketingPorEmpresaVO;

public class MarketingDelegate  extends MozartDelegate{
	
	
	private static MarketingDelegate instance;
    private static MarketingSession session;

    private MarketingDelegate() throws MozartSessionException {
    
        try{
        
            session = (MarketingSession) getLookup("MarketingSession");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: MarketingSession");            
            }
        }catch(Exception ex){
        
            throw new MozartSessionException(ex.getMessage());             
        
        }
    
    }
    public static MarketingDelegate instance() throws MozartSessionException{
        
        return instance==null?instance = new MarketingDelegate() : instance;
    
    }

    
    public List<MarketingPorEmpresaVO> pesquisarReservasPorEmpreasa(MarketingPorEmpresaVO pFiltro) throws MozartSessionException {
    	return session.pesquisarReservasPorEmpreasa( pFiltro );
    }
	public void executarRDSAnual(Long idHotel, String ateDia, String ateMes,
			String anoInicial, String anoFinal) throws MozartSessionException {

		session.executarRDSAnual( idHotel, ateDia, ateMes, anoInicial, anoFinal );
	}
}
