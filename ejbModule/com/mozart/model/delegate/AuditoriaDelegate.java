package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.CheckinEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.facade.AuditoriaSessionEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.ComprovanteAjusteVO;
import com.mozart.model.vo.MovimentoApartamentoVO;
import com.mozart.model.vo.StatusNotaVO;

public class AuditoriaDelegate extends MozartDelegate {

	
	 private static AuditoriaDelegate instance;
	 private static AuditoriaSessionEJB session;
	    

	 private AuditoriaDelegate() throws MozartSessionException {
	        try{
	        
	            session = (AuditoriaSessionEJB) getLookup("AuditoriaSessionEJB");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: AuditoriaSessionEJB");            
	            }
	        }catch(Exception ex){
	            throw new MozartSessionException(ex.getMessage());             
	        }
	 }
	    
	 public static AuditoriaDelegate instance() throws MozartSessionException{
	        return instance==null?instance = new AuditoriaDelegate() : instance;
	 }

	public List<MovimentoApartamentoVO> pesquisarMovimento(MovimentoApartamentoVO filtro)  throws MozartSessionException{
	
		return session.pesquisarMovimento(filtro);
	}

	public void encerrarAuditoria(ControlaDataEJB controlaData) throws MozartSessionException{
		try{
			session.encerrarAuditoria(controlaData);
		}catch(MozartValidateException ex){
			throw ex;
		}catch(Exception ex){
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}
	public void encerrarAuditoriaRestaurante(ControlaDataEJB controlaData) throws MozartSessionException{
		try{
			session.encerrarAuditoriaRestaurante(controlaData);
		}catch(MozartValidateException ex){
			throw ex;
		}catch(Exception ex){
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}
	public void encerrarAuditoriaServ(ControlaDataEJB controlaData) throws MozartSessionException{
		try{
			session.encerrarAuditoriaServ(controlaData);
		}catch(MozartValidateException ex){
			throw ex;
		}catch(Exception ex){
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List obterValidacao(Long idHotel) throws MozartSessionException{
		return session.obterValidacao(idHotel);
	}

	public List<StatusNotaVO> obterReaberturaConta(Long idHotel) throws MozartSessionException{
		return session.obterReaberturaConta(idHotel);
	}

	public void reabrirConta(StatusNotaVO statusNota) throws MozartSessionException{
		
		try{
			session.reabrirConta(statusNota);
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
	    

	
	public List<ComprovanteAjusteVO> obterComprovanteAjuste(ComprovanteAjusteVO ajuste) throws MozartSessionException{
		return session.obterComprovanteAjuste(ajuste);
	}

	public void gravarCheckinComplemento(HotelEJB hotel,
			List<CheckinEJB> checkinEJBList) throws MozartSessionException{

		session.gravarCheckinComplemento(hotel, checkinEJBList);
	}

	public Long obterNossoNumeroMesAnterior(ControlaDataEJB cd)  throws MozartSessionException{

		return session.obterNossoNumeroMesAnterior(cd);
	}

	public List<Long> obterApartamentosInterditadosVencidos(HotelEJB hotel) throws MozartSessionException{
		return session.obterApartamentosInterditadosVencidos(hotel);
	}
			
}