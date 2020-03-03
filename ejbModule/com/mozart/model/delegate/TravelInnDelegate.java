package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.dao.TravelInnDAO;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.TinnFolhaVO;

public class TravelInnDelegate extends MozartDelegate {

	
	

	
	public static void gravarArquivo(List<TinnFolhaVO> lista) throws MozartSessionException{
         try{
             new TravelInnDAO().gravarArquivo( lista );
         }catch(Exception ex){
             throw new MozartSessionException( ex.getMessage() );

         }
	}

	  
}
