package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.RamalTelefonicoEJB;
import com.mozart.model.ejb.entity.TelefoniaDiscrepanciaEJB;
import com.mozart.model.ejb.entity.TelefoniaEJB;
import com.mozart.model.ejb.entity.TelefoniasConfigEJB;
import com.mozart.model.ejb.facade.TelefoniaSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.DiscrepanciaVO;
import com.mozart.model.vo.RamalVO;

public class TelefoniaDelegate extends MozartDelegate{

	
	 	private static TelefoniaDelegate instance;
	    private static TelefoniaSession session;
	    

	    private TelefoniaDelegate() throws MozartSessionException {
	    
	        try{
	            session = (TelefoniaSession) getLookup("TelefoniaSession");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: TelefoniaSession");            
	            }
	        }catch(Exception ex){
	        
	            throw new MozartSessionException(ex.getMessage());             
	        
	        }
	    
	    }
	    
	    
	    public static TelefoniaDelegate instance() throws MozartSessionException{
	        
	        return instance==null?instance = new TelefoniaDelegate() : instance;
	    
	    }


		public void gravarLancamentosTelefonia(HotelEJB hotel, String[] linhas) throws MozartSessionException{
			session.lancarTelefonia(hotel, linhas);
		}


		public List<TelefoniaEJB> obterCentralTelefonia()  throws MozartSessionException{
			return session.obterCentralTelefonia();
		}


		public TelefoniasConfigEJB obterTelefoniasConfigPorHotel(TelefoniasConfigEJB filtro) {

			return session.obterTelefoniasConfigPorHotel(filtro);
		}

		
		
		public List<RamalVO> pesquisarRamal(RamalVO filtro) throws MozartSessionException{
			return session.pesquisarRamal(filtro);
		}


		public void gravarRamalTelefonico(RamalTelefonicoEJB entidade) throws MozartSessionException{

			try{
				session.gravarRamalTelefonico(entidade);
				
			}catch(Exception ex){
				String msg = ex.getCause().getCause().getMessage();
				if (msg.indexOf("IDX_RAMAL_TEL_HTL__RAM") >= 0){
					throw new MozartValidateException( "O ramal: "+entidade.getRamal()+" já existe." );
				}else{
					throw new MozartSessionException(ex.getMessage());
				}
				
			}
			
			
		}


		public void excluirRamalTelefonico(RamalTelefonicoEJB entidade)  throws MozartSessionException{
			session.excluirRamalTelefonico(entidade);
		}

		public List<DiscrepanciaVO> pesquisarDiscrepancia(DiscrepanciaVO filtro) throws MozartSessionException {
			return session.pesquisarDiscrepancia(filtro);
		}


		public void lancarMovimentoDiscrepancia(TelefoniaDiscrepanciaEJB entidade) throws MozartSessionException {
			session.lancarMovimentoDiscrepancia(entidade);
		}

		
		
	    
}
