package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.NfeCofinsCadastroEJB;
import com.mozart.model.ejb.entity.NfeCofinsCadastroStEJB;
import com.mozart.model.ejb.entity.NfeCofinsCstEJB;
import com.mozart.model.ejb.entity.NfeIICadastroEJB;
import com.mozart.model.ejb.entity.NfeIcmsCadastroEJB;
import com.mozart.model.ejb.entity.NfeIcmsModBcIcmsEJB;
import com.mozart.model.ejb.entity.NfeIcmsModBcIcmsStEJB;
import com.mozart.model.ejb.entity.NfeIcmsMotivoDesoneracaoEJB;
import com.mozart.model.ejb.entity.NfeIcmsOrigemMercadoriaEJB;
import com.mozart.model.ejb.entity.NfeIpiCadastroEJB;
import com.mozart.model.ejb.entity.NfeIpiCstEJB;
import com.mozart.model.ejb.entity.NfePisCadastroEJB;
import com.mozart.model.ejb.entity.NfePisCadastroStEJB;
import com.mozart.model.ejb.entity.NfePisCstEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.ejb.facade.NfeSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.EstadoNfeVO;
import com.mozart.model.vo.SituacaoTributariaVO;
import com.mozart.model.vo.UnidadeNfeVO;
import com.mozart.model.vo.ValorBaseCalculoNfeVO;

public class NfeDelegate extends MozartDelegate {
	
	private static NfeDelegate instance;
    private static NfeSession session;

    private NfeDelegate() throws MozartSessionException {
        try{
            session = (NfeSession) getLookup("NfeSession");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: NfeSession");            
            }
            
        } catch (Exception ex) {
            throw new MozartSessionException(ex.getMessage());             
        }
    }
    
    public static NfeDelegate instance() throws MozartSessionException {
    	if (instance == null) 
    		instance = new NfeDelegate();
        return instance;
    }

    public List<SituacaoTributariaVO> obterSituacaoTributariaIcms(HotelEJB hotel)
			throws MozartSessionException {
    	return session.obterListaSituacaoTributaria(hotel);
    }
    
    public List<NfeCofinsCstEJB> obterSituacaoTributariaCofins()
			throws MozartSessionException {
    	return session.obterListaSituacaoTributariaCofins();
    }
    
    public List<NfePisCstEJB> obterSituacaoTributariaPis()
			throws MozartSessionException {
    	return session.obterListaSituacaoTributariaPis();
    }
    
    public List<NfeIpiCstEJB> obterSituacaoTributariaIpi()
			throws MozartSessionException{
    	return session.obterListaSituacaoTributariaIpi();
    }

    public List<NfeIcmsOrigemMercadoriaEJB> obterOrigemMercadoriaIcms()
			throws MozartSessionException {
		return session.obterOrigemMercadoriaIcms();
	}
    
    public List<NfeIcmsModBcIcmsEJB> obterModalidadeBaseCalculoIcms()
			throws MozartSessionException {
    	return session.obterModalidadeBaseCalculoIcms();
    }
    
    public List<NfeIcmsModBcIcmsStEJB> obterModalidadeBaseCalculoIcmsSt()
			throws MozartSessionException {
    	return session.obterModalidadeBaseCalculoIcmsSt();
    }
    
    public List<NfeIcmsMotivoDesoneracaoEJB> obterMotivoDesoneracaoIcms()
			throws MozartSessionException {
    	return session.obterMotivoDesoneracaoIcms();
    }
    
    public String obterRegimeTributario(HotelEJB hotel)
			throws MozartSessionException {
    	return session.obterRegimeTributario(hotel);
    }
    
    public NfeIcmsCadastroEJB gravarIcms(NfeIcmsCadastroEJB entidade) 
			throws MozartSessionException{
    	return session.gravarIcms(entidade);
    }

	public NfeCofinsCadastroEJB gravarCofins(NfeCofinsCadastroEJB entidade) 
			throws MozartSessionException{
		return session.gravarCofins(entidade);
	}
	
	public NfeCofinsCadastroStEJB gravarCofinsSt(NfeCofinsCadastroStEJB entidade) 
			throws MozartSessionException{
		return session.gravarCofinsSt(entidade);
	}
	
	public NfePisCadastroEJB gravarPis(NfePisCadastroEJB entidade) 
			throws MozartSessionException{
		return session.gravarPis(entidade);
	}
	
	public NfePisCadastroStEJB gravarPisSt(NfePisCadastroStEJB entidade) 
			throws MozartSessionException{
		return session.gravarPisSt(entidade);
	}
	
	public NfeIICadastroEJB gravarII(NfeIICadastroEJB entidade) 
			throws MozartSessionException{
		return session.gravarII(entidade);
	}
	
	public NfeIpiCadastroEJB gravarIpi(NfeIpiCadastroEJB entidade) 
			throws MozartSessionException{
		return session.gravarIpi(entidade);
	}
	
	public ValorBaseCalculoNfeVO obterValorBaseCalculoIcms(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorBaseCalculoIcms(hotel, prato);
	}
	
	public Double obterValorCredIcms(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorCredIcms(hotel, prato);
	}
	
	public Double obterValorIcmsDiferido(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorIcmsDiferido(hotel, prato);
	}
	
	public ValorBaseCalculoNfeVO obterValorBaseCalculoIcmsSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorBaseCalculoIcmsSt(hotel, prato);
	}
	
	public Double obterValorBaseCalculoCofins(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorBaseCalculoCofins(hotel, prato);
	}
	
	public Double obterValorCofins(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorCofins(hotel, prato);
	}
	
	public Double obterValorCofinsSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorCofinsSt(hotel, prato);
	}
	
	public Double obterValorPis(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorPis(hotel, prato);
	}
	
	public Double obterValorPisSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterValorPisSt(hotel, prato);
	}
	
	public NfeIcmsCadastroEJB obterIcmsCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterIcmsCadastro(hotel, prato);
	}
	
	public NfeCofinsCadastroEJB obterCofinsCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterCofinsCadastro(hotel, prato);
	}
	
	public NfeCofinsCadastroStEJB obterCofinsCadastroSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterCofinsCadastroSt(hotel, prato);
	}
	
	public NfeIICadastroEJB obterIICadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterIICadastro(hotel, prato);
	}
	
	public NfeIpiCadastroEJB obterIpiCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterIpiCadastro(hotel, prato);
	}
	
	public NfePisCadastroEJB obterPisCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterPisCadastro(hotel, prato);
	}
	
	public NfePisCadastroStEJB obterPisCadastroSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException{
		return session.obterPisCadastroSt(hotel, prato);
	}
	
	public List<UnidadeNfeVO> obterListaUnidadesNfe()
			throws MozartSessionException{
		return session.obterListaUnidadesNfe();
	}
	
	public List<EstadoNfeVO> obterListaEstadosNfe()
			throws MozartSessionException{
		return session.obterListaEstadosNfe();
	}
	
	public EstadoNfeVO gravarFcp(EstadoNfeVO entidade) throws MozartSessionException{
		return session.gravarFcp(entidade);
	}
}
