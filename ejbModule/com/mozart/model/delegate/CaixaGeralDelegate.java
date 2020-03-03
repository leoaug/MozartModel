package com.mozart.model.delegate;

import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.ApartamentoTransferidoEJB;
import com.mozart.model.ejb.entity.ConfigNotaEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.ObjetoEJB;
import com.mozart.model.ejb.entity.RoomListEJB;
import com.mozart.model.ejb.facade.CaixaGeralSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;

import com.mozart.model.vo.CaixaGeralVO;
import com.mozart.model.vo.MiniPdvVO;
import com.mozart.model.vo.MovimentoObjetoVO;
import com.mozart.model.vo.TransacaoWebVO;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;

import java.util.List;


public class CaixaGeralDelegate extends MozartDelegate{
    private static CaixaGeralDelegate instance;
    private static CaixaGeralSession session;
    

    private CaixaGeralDelegate() throws MozartSessionException {
    
        try{
        
            session = (CaixaGeralSession) getLookup("CaixaGeralSessionEJB");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: CaixaGeralSessionEJB");            
            }
        }catch(Exception ex){
        
            throw new MozartSessionException(ex.getMessage());             
        
        }
    
    }
    
    public static CaixaGeralDelegate instance() throws MozartSessionException{
    
        return instance==null?instance = new CaixaGeralDelegate() : instance;
    
    }

    public List<CaixaGeralVO> pesquisarApartamentoComCheckinEReserva(CaixaGeralVO param) {
        return pesquisarApartamentoComCheckinEReserva(param, true);
    }
    
    public List<CaixaGeralVO> pesquisarApartamentoComCheckinEReserva(CaixaGeralVO param, boolean isHotelaria) {
    	return session.pesquisarApartamentoComCheckinEReserva( param, isHotelaria );
    }

    public void transferirApartamento(ApartamentoTransferidoEJB apartamentoTransferido)  throws MozartSessionException{
    	try{
    		session.transferirApartamento( apartamentoTransferido );
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
    
    public List<ApartamentoEJB> obterApartamentoDisponivelTransferencia(Long idCheckin, Long idHotel) throws MozartSessionException{
        return session.obterApartamentoDisponivelTransferencia(idCheckin, idHotel);
    }

	public List<ConfigNotaEJB> obterConfiguracaoImpressoraFiscal(Long idHotel) throws MozartSessionException{
		return session.obterConfiguracaoImpressoraFiscal(idHotel);
	}

	public List<String> obterValidacaoLancamentoDiaria(Long pIdHotel) throws MozartSessionException{
		return session.obterValidacaoLancamentoDiaria(pIdHotel);
	}

	public void lancarDiariaAutomatica(ControlaDataEJB pControlaData) throws MozartSessionException{
		session.lancarDiariaAutomatica(pControlaData);
	}

	public List<MovimentoApartamentoEJB> obterMovimentoAtualDoApartamento(MovimentoApartamentoEJB origem) throws MozartSessionException{

		return session.obterMovimentoAtualDoApartamento(origem);
	}

	
	public void transferirDespesasParaApto(ApartamentoEJB destino, Long pIdRoomListDestino, String motivo,
			List<MovimentoApartamentoEJB> listaMovimentoATransferir)  throws MozartSessionException{

		session.transferirDespesasParaApto(destino, pIdRoomListDestino, motivo, listaMovimentoATransferir);
	}

	public List<RoomListEJB> obterHospedePorApartamento(ApartamentoEJB apto) throws MozartSessionException{

		return session.obterHospedePorApartamento(apto);
	}
	
	
	public List<ConfigNotaEJB> obterConfiguracaoNotaFiscal(Long idHotel) throws MozartSessionException {

		return session.obterConfiguracaoNotaFiscal(idHotel); 
	} 

	public void salvarConfiguracaoNotaFiscal(List<ConfigNotaEJB> lista) throws MozartSessionException {
		session.salvarConfiguracaoNotaFiscal( lista );
	}

	public List<RoomListEJB> obterHospedePorCheckin(Long idCheckin) throws MozartSessionException {

		return session.obterHospedePorCheckin(idCheckin);
	}
	
	public List<ObjetoEJB> obterObjetoPorHotel(Long idHotel) throws MozartSessionException {
		return session.obterObjetoPorHotel(idHotel);
	}
	
	public List<MovimentoObjetoVO> pesquisarMovimentoObjeto(MovimentoObjetoVO filtro) throws MozartSessionException {
		return session.pesquisarMovimentoObjeto(filtro);
	}
	
	public List<MiniPdvVO> pesquisarMiniPDV(MiniPdvVO filtro) throws MozartSessionException {
		return session.pesquisarMiniPDV(filtro);
	}

	public List<TransacaoWebVO> pesquisarTransacaoWeb(TransacaoWebVO filtro) throws MozartSessionException {
		return session.pesquisarTransacaoWeb(filtro);
	}

}