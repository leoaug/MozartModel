package com.mozart.model.delegate;

import com.mozart.model.dao.AlfaSeguradoraDAO;
import com.mozart.model.ejb.entity.AlfaArquivoEJB;
import com.mozart.model.ejb.facade.AlfaSessionEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ApoliceAlfa;
import com.mozart.model.vo.HospedeSegurado;
import com.mozart.model.vo.HotelConsolidadoAlfa;

import java.util.List;

public class AlfaDelegate extends MozartDelegate{

    private static AlfaDelegate instance;
    private static AlfaSessionEJB session;
    

    private AlfaDelegate() throws MozartSessionException {
    
        try{
            session = (AlfaSessionEJB) getLookup("AlfaSessionEJB");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: AlfaSessionEJB");            
            }
        }catch(Exception ex){
        
            throw new MozartSessionException(ex.getMessage());             
        
        }
    
    }
    
    public static AlfaDelegate instance() throws MozartSessionException{
    
        return instance==null?instance = new AlfaDelegate() : instance;
    
    }
    
    
    public List<HospedeSegurado> pesquisarHospedeSegurado(HospedeSegurado pHospedeSegurado) throws MozartSessionException{
    
        return session.pesquisarHospedeSegurado( pHospedeSegurado );
    }

    public List<HotelConsolidadoAlfa> pesquisarHotelConsolidadoAlfa(HotelConsolidadoAlfa pHotelConsolidadoAlfa) throws MozartSessionException{
    
        return session.pesquisarHotelConsolidadoAlfa( pHotelConsolidadoAlfa );
    }

    public ApoliceAlfa opterApoliceAlfa(ApoliceAlfa pApoliceAlfa) throws MozartSessionException{
    
        return session.opterApoliceAlfa( pApoliceAlfa );
    }

    public void gerarArquivo01PorHotel(HospedeSegurado pHospedeSegurado) throws MozartSessionException{
    
        session.gerarArquivo01PorHotel( pHospedeSegurado );
        
    }


    public static void gravarArquivo(AlfaArquivoEJB arquivoEJB) throws MozartSessionException{
        
        //session.gravarArquivo(arquivoEJB);
         try{
             
             //manager.persist( arquivoEJB );
             new AlfaSeguradoraDAO().gravarArquivo( arquivoEJB );
         }catch(Exception ex){
             throw new MozartSessionException( ex.getMessage() );

         }


    }

    public static void gerarCertificados() throws MozartSessionException{
        try{
            new AlfaSeguradoraDAO().gerarCertificados( );
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );

        }
    
    }

    public static Long getQtdeCertificadosFree()  throws MozartSessionException{
        
        try{
            return new AlfaSeguradoraDAO().getQtdeCertificadosFree();
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );
        }
    }
    
    public Long obterNextSequence(String seqName) throws MozartSessionException{
    	return session.obterNextSequence(seqName);
    }
}
