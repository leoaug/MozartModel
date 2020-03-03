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
import com.mozart.model.ejb.entity.ServicosContratoEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ContratoVO;
import com.mozart.model.vo.SituacaoTributariaVO;
import com.mozart.model.vo.ValorBaseCalculoNfeVO;

@Stateless(name = "ContratoSession")
public class ContratoSessionBean implements ContratoSession {

	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	public List<ContratoVO> obterListaContratos(ContratoVO filtro)
			throws MozartSessionException {
		StringBuilder query = new StringBuilder(QRY_PES_CONTRATO);
		
		try 
		{
			
			query.append(" WHERE instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||SC.ID_HOTEL||';') >= 1 ");
			
			if (!MozartUtil.isNull(filtro.getFiltroCancelado().getTipoIntervalo())) {
				query.append(" and SC.CANCELADO " + filtro.getFiltroCancelado());
			}
			
			if (!MozartUtil.isNull(filtro.getFiltroEmpresa().getTipoIntervalo())) {
				query.append(" and ER.NOME_FANTASIA " + filtro.getFiltroEmpresa());
			}
			
			if  (!MozartUtil.isNull(filtro.getFiltrodataini().getTipoIntervalo())){
				query.append(" and SC.DATA_INI  " + filtro.getFiltrodataini());
			}
			
			if  (!MozartUtil.isNull(filtro.getFiltrodatafim().getTipoIntervalo())){
				query.append(" and SC.DATA_FIM  " + filtro.getFiltrodatafim());
			}
			
			query.append(" ORDER BY ER.NOME_FANTASIA ");
			
			List lista = manager.createNativeQuery(query.toString()).getResultList();
			
			List<ContratoVO> situacaoTributaria = new ArrayList<ContratoVO>();
			for (Object sitTributaria : lista) {
				situacaoTributaria.add(new ContratoVO((Object[]) sitTributaria));
			}
			return situacaoTributaria;

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
	
	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public ServicosContratoEJB gravarContrato(ServicosContratoEJB entidade) throws MozartSessionException {
		
		try {
			if (entidade.getId() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
}