package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.delegate.CheckinDelegate;
import com.mozart.model.ejb.entity.EstadoEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoRestauranteEJB;
import com.mozart.model.ejb.entity.NfeCofinsCadastroEJB;
import com.mozart.model.ejb.entity.NfeCofinsCadastroStEJB;
import com.mozart.model.ejb.entity.NfeCofinsCstEJB;
import com.mozart.model.ejb.entity.NfeFcpEJB;
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
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.EstadoNfeVO;
import com.mozart.model.vo.SituacaoTributariaVO;
import com.mozart.model.vo.UnidadeNfeVO;
import com.mozart.model.vo.ValorBaseCalculoNfeVO;

@Stateless(name = "NfeSession")
public class NfeSessionBean implements NfeSession {

	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	public  List<SituacaoTributariaVO> obterListaSituacaoTributaria(HotelEJB hotel)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_LISTA_SITUACAO_TRIBUTARIA);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, hotel.getIdHotel()).getResultList();

			List<SituacaoTributariaVO> situacaoTributaria = new ArrayList<SituacaoTributariaVO>();
			for (Object sitTributaria : lista) {
				situacaoTributaria.add(new SituacaoTributariaVO((Object[]) sitTributaria));
			}
			return situacaoTributaria;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public  ValorBaseCalculoNfeVO obterValorBaseCalculoIcms(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_BC_ALIQ_VAL_ICMS);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			List<ValorBaseCalculoNfeVO> listaBaseCalculo = new ArrayList<ValorBaseCalculoNfeVO>();
			for (Object baseCalculo : lista) {
				listaBaseCalculo.add(new ValorBaseCalculoNfeVO((Object[]) baseCalculo));
			}
			
			return listaBaseCalculo.size() > 0 ? listaBaseCalculo.get(0) : null;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public ValorBaseCalculoNfeVO obterValorBaseCalculoIcmsSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VAL_BASE_CAL_ST);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			List<ValorBaseCalculoNfeVO> listaBaseCalculo = new ArrayList<ValorBaseCalculoNfeVO>();
			for (Object baseCalculo : lista) {
				listaBaseCalculo.add(new ValorBaseCalculoNfeVO((Object[]) baseCalculo));
			}
			
			return listaBaseCalculo.size() > 0 ? listaBaseCalculo.get(0) : null;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public Double obterValorCredIcms(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VR_CRED_ICMS);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			Double valorCredIcms = null;
			for (Object baseCalculo : lista) {
				valorCredIcms = new Double (((BigDecimal)baseCalculo).doubleValue());
			}
			
			return valorCredIcms;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public Double obterValorIcmsDiferido(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VAL_ICMS_DIF);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			Double valor = null;
			for (Object value : lista) {
				valor = new Double (((BigDecimal)value).doubleValue());
			}
			
			return valor;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public Double obterValorBaseCalculoCofins(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VAL_BASE_CAL_COFINS);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			Double valorCredIcms = null;
			for (Object baseCalculo : lista) {
				valorCredIcms = new Double (((BigDecimal)baseCalculo).doubleValue());
			}
			
			return valorCredIcms;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public Double obterValorCofins(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VAL_COFINS);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			Double valorCredIcms = null;
			for (Object baseCalculo : lista) {
				valorCredIcms = new Double (((BigDecimal)baseCalculo).doubleValue());
			}
			
			return valorCredIcms;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public Double obterValorCofinsSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VAL_COFINS_ST);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			Double valorCredIcms = null;
			for (Object baseCalculo : lista) {
				valorCredIcms = new Double (((BigDecimal)baseCalculo).doubleValue());
			}
			
			return valorCredIcms;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public Double obterValorPis(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VAL_PIS);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			Double valor = null;
			for (Object value : lista) {
				valor = new Double (((BigDecimal)value).doubleValue());
			}
			
			return valor;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public Double obterValorPisSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_VAL_PIS_ST);
		
		try {
			List lista = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, prato.getId().getIdPrato()).getResultList();

			Double valor = null;
			for (Object value : lista) {
				valor = new Double (((BigDecimal)value).doubleValue());
			}
			
			return valor;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	@SuppressWarnings("unchecked")
	public List<NfeCofinsCstEJB> obterListaSituacaoTributariaCofins()
			throws MozartSessionException {
		return (List<NfeCofinsCstEJB>) manager
				.createNamedQuery("NfeCofinsCstEJB.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<NfePisCstEJB> obterListaSituacaoTributariaPis()
			throws MozartSessionException {
		return (List<NfePisCstEJB>) manager
				.createNamedQuery("NfePisCstEJB.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<NfeIpiCstEJB> obterListaSituacaoTributariaIpi()
			throws MozartSessionException {
		return (List<NfeIpiCstEJB>) manager
				.createNamedQuery("NfeIpiCstEJB.findAll").getResultList();
	}
	
	public String obterRegimeTributario(HotelEJB hotel)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_REGIME_TRIBUTARIO);
		
		try {
			Object result = manager.createNativeQuery(query.toString())
					.setParameter(1, hotel.getIdHotel()).getSingleResult();

			String regime = (String) result;
			
			return regime;
			
		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	@SuppressWarnings("unchecked")
	public List<NfeIcmsOrigemMercadoriaEJB> obterOrigemMercadoriaIcms()
			throws MozartSessionException {
		return (List<NfeIcmsOrigemMercadoriaEJB>) manager
				.createNamedQuery("NfeIcmsOrigemMercadoriaEJB.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<NfeIcmsModBcIcmsEJB> obterModalidadeBaseCalculoIcms()
			throws MozartSessionException {
		return (List<NfeIcmsModBcIcmsEJB>) manager
				.createNamedQuery("NfeIcmsModBcIcmsEJB.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<NfeIcmsModBcIcmsStEJB> obterModalidadeBaseCalculoIcmsSt()
			throws MozartSessionException {
		return (List<NfeIcmsModBcIcmsStEJB>) manager
				.createNamedQuery("NfeIcmsModBcIcmsStEJB.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<NfeIcmsMotivoDesoneracaoEJB> obterMotivoDesoneracaoIcms()
			throws MozartSessionException {
		return (List<NfeIcmsMotivoDesoneracaoEJB>) manager
				.createNamedQuery("NfeIcmsMotivoDesoneracaoEJB.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public NfeIcmsCadastroEJB obterIcmsCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		List<NfeIcmsCadastroEJB> value = (List<NfeIcmsCadastroEJB>) manager
				.createNamedQuery("NfeIcmsCadastroEJB.findByHotelAndPrato")
				.setParameter(1, hotel.getIdHotel())
				.setParameter(2, prato.getId().getIdPrato()).getResultList();
		
		if(value.size() > 0)
			return value.get(0);
			
		return new NfeIcmsCadastroEJB();
	}
	
	@SuppressWarnings("unchecked")
	public NfeCofinsCadastroEJB obterCofinsCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		List<NfeCofinsCadastroEJB> value = (List<NfeCofinsCadastroEJB>) manager
				.createNamedQuery("NfeCofinsCadastroEJB.findByHotelAndPrato")
				.setParameter(1, hotel.getIdHotel())
				.setParameter(2, prato.getId().getIdPrato()).getResultList();
		
		if(value.size() > 0)
			return value.get(0);
			
		return new NfeCofinsCadastroEJB();
	}
	
	@SuppressWarnings("unchecked")
	public NfeCofinsCadastroStEJB obterCofinsCadastroSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		List<NfeCofinsCadastroStEJB> value = (List<NfeCofinsCadastroStEJB>) manager
				.createNamedQuery("NfeCofinsCadastroStEJB.findByHotelAndPrato")
				.setParameter(1, hotel.getIdHotel())
				.setParameter(2, prato.getId().getIdPrato()).getResultList();
		
		if(value.size() > 0)
			return value.get(0);
			
		return new NfeCofinsCadastroStEJB();
	}
	
	@SuppressWarnings("unchecked")
	public NfeIICadastroEJB obterIICadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		List<NfeIICadastroEJB> value = (List<NfeIICadastroEJB>) manager
				.createNamedQuery("NfeIICadastroEJB.findByHotelAndPrato")
				.setParameter(1, hotel.getIdHotel())
				.setParameter(2, prato.getId().getIdPrato()).getResultList();
		
		if(value.size() > 0)
			return value.get(0);
			
		return new NfeIICadastroEJB();
	}
	
	@SuppressWarnings("unchecked")
	public NfeIpiCadastroEJB obterIpiCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		
		List<NfeIpiCadastroEJB> value = (List<NfeIpiCadastroEJB>) manager
				.createNamedQuery("NfeIpiCadastroEJB.findByHotelAndPrato")
				.setParameter(1, hotel.getIdHotel())
				.setParameter(2, prato.getId().getIdPrato()).getResultList();
		
		if(value.size() > 0)
			return value.get(0);
			
		return new NfeIpiCadastroEJB();
	}
	
	@SuppressWarnings("unchecked")
	public NfePisCadastroEJB obterPisCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		List<NfePisCadastroEJB> value =  (List<NfePisCadastroEJB>) manager
				.createNamedQuery("NfePisCadastroEJB.findByHotelAndPrato")
				.setParameter(1, hotel.getIdHotel())
				.setParameter(2, prato.getId().getIdPrato()).getResultList();
		
		if(value.size() > 0)
			return value.get(0);
			
		return new NfePisCadastroEJB();
	}
	
	@SuppressWarnings("unchecked")
	public NfePisCadastroStEJB obterPisCadastroSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException {
		List<NfePisCadastroStEJB> value = (List<NfePisCadastroStEJB>) manager
				.createNamedQuery("NfePisCadastroStEJB.findByHotelAndPrato")
				.setParameter(1, hotel.getIdHotel())
				.setParameter(2, prato.getId().getIdPrato()).getResultList();
		
		if(value.size() > 0)
			return value.get(0);
			
		return new NfePisCadastroStEJB();
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfeIcmsCadastroEJB gravarIcms(NfeIcmsCadastroEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdNfeIcmsCadastro() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfeCofinsCadastroEJB gravarCofins(NfeCofinsCadastroEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdNfeCofinsCadastro() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfeCofinsCadastroStEJB gravarCofinsSt(NfeCofinsCadastroStEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdNfeCofinsCadastroSt() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfePisCadastroEJB gravarPis(NfePisCadastroEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdNfePisCadastro() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfePisCadastroStEJB gravarPisSt(NfePisCadastroStEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdNfePisCadastroSt() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfeIICadastroEJB gravarII(NfeIICadastroEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdNfeIICadastro() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfeIpiCadastroEJB gravarIpi(NfeIpiCadastroEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdNfeIpiCadastro() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<UnidadeNfeVO> obterListaUnidadesNfe()
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_UNIDADE_NFE);
		
		try {
			List lista = manager.createNativeQuery(query.toString()).getResultList();

			List<UnidadeNfeVO> unidades = new ArrayList<UnidadeNfeVO>();
			for (Object unidade : lista) {
				unidades.add(new UnidadeNfeVO((Object[]) unidade));
			}
			return unidades;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	public List<EstadoNfeVO> obterListaEstadosNfe()
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QUERY_ESTADO_ICMS);
		
		try {
			List lista = manager.createNativeQuery(query.toString()).getResultList();

			List<EstadoNfeVO> unidades = new ArrayList<EstadoNfeVO>();
			for (Object unidade : lista) {
				unidades.add(new EstadoNfeVO((Object[]) unidade));
			}
			return unidades;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}	
	}
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public EstadoNfeVO gravarFcp(EstadoNfeVO entidade) throws MozartSessionException {
		
		try {
			if (entidade.getIdFcp() == null) {
				NfeFcpEJB fcp = new NfeFcpEJB();
				EstadoEJB estado = (EstadoEJB) CheckinDelegate
						.instance().obter(EstadoEJB.class,
								entidade.getId());
				fcp.setEstado(estado);
				fcp.setPercentual(entidade.getValor());
				manager.persist(fcp);
			} else {
				NfeFcpEJB fcp = (NfeFcpEJB) CheckinDelegate
						.instance().obter(NfeFcpEJB.class,
								Long.parseLong(entidade.getIdFcp()));
				
				if(fcp.getPercentual() != entidade.getValor()){
					fcp.setPercentual(entidade.getValor());
					manager.merge(fcp);
				}
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
}