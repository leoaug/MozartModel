package com.mozart.model.ejb.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.ApiGeralEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ApiGeralVO;

@SuppressWarnings("unchecked")
@Stateless(name = "ApiGeralSessionEJB")
public class ApiGeralSessionEJBBean implements ApiGeralSessionEJB {

	@PersistenceContext(unitName="MozartModel")
	private EntityManager entityManager;

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ApiGeralVO> obterApisGeraisPorRazaoSocial(ApiGeralVO filtro) throws MozartSessionException {
		
		List <ApiGeralVO> lista = new ArrayList <ApiGeralVO> ();
		
		//if (filtro.getRazaoSocial() == null) {
			//throw new MozartValidateException("Razão Social é obrigatório");
		//}
		String sql = "";
		
		if (filtro.getRazaoSocial().getTipoIntervalo().equals("")){
			sql = "SELECT AG.NOME, \n"
					+ "AG.ATIVO, \n"
					+ "E.RAZAO_SOCIAL, \n"
					+ " AG.TOKEN, \n"
					+ "AG.URL, \n"
					+ "AG.ID_API_GERAL, \n" 
					+ "AC.API_NOME, \n"
					+ "AC.ATIVO, \n"
					+ "H.NOME_FANTASIA, \n"
					+ "TL.DESCRICAO_LANCAMENTO, \n"
					+ "TLCK.DESCRICAO_LANCAMENTO, \n"
					+ "AC.ID_API_CONTRATO,  \n" 
					+ "AP.API_NOME, \n"
					+ "AP.ATIVO, \n"
					+ "HTL.NOME_FANTASIA, \n"
					+ "AP.ID_API_VENDEDOR \n" + 
					"FROM API_GERAL AG \n" + 

					"JOIN API_CONTRATO AC ON (AG.ID_API_GERAL = AC.ID_API_GERAL) \n" + 
					"JOIN API_VENDEDOR AP ON (AG.ID_API_GERAL = AP.ID_API_GERAL) \n" + 
					"JOIN HOTEL H ON (AC.ID_HOTEL = H.ID_HOTEL) \n" + 
					"JOIN HOTEL HTL ON (AP.ID_HOTEL = HTL.ID_HOTEL) \n" + 
					"JOIN EMPRESA E ON (AG.ID_EMPRESA = E.ID_EMPRESA) \n" + 
					"JOIN TIPO_LANCAMENTO TL ON (AC.ID_TIPO_LANCAMENTO = TL.ID_TIPO_LANCAMENTO ) \n" + 
					"JOIN TIPO_LANCAMENTO TLCK ON (AC.ID_TIPO_LANCAMENTO_CK = TLCK.ID_TIPO_LANCAMENTO ) \n" +
					"\n ORDER BY E.RAZAO_SOCIAL,AG.URL";
			
		} else {

			sql = "SELECT AG.NOME, \n"
					+ "AG.ATIVO, \n"
					+ "E.RAZAO_SOCIAL, \n"
					+ " AG.TOKEN, \n"
					+ "AG.URL, \n"
					+ "AG.ID_API_GERAL, \n" 
					+ "AC.API_NOME, \n"
					+ "AC.ATIVO, \n"
					+ "H.NOME_FANTASIA, \n"
					+ "TL.DESCRICAO_LANCAMENTO, \n"
					+ "TLCK.DESCRICAO_LANCAMENTO, \n"
					+ "AC.ID_API_CONTRATO,  \n" 
					+ "AP.API_NOME, \n"
					+ "AP.ATIVO, \n"
					+ "HTL.NOME_FANTASIA, \n"
					+ "AP.ID_API_VENDEDOR \n" + 
					"FROM API_GERAL AG \n" + 

					"JOIN API_CONTRATO AC ON (AG.ID_API_GERAL = AC.ID_API_GERAL) \n" + 
					"JOIN API_VENDEDOR AP ON (AG.ID_API_GERAL = AP.ID_API_GERAL) \n" + 
					"JOIN HOTEL H ON (AC.ID_HOTEL = H.ID_HOTEL) \n" + 
					"JOIN HOTEL HTL ON (AP.ID_HOTEL = HTL.ID_HOTEL) \n" + 
					"JOIN EMPRESA E ON (AG.ID_EMPRESA = E.ID_EMPRESA) \n" + 
					"JOIN TIPO_LANCAMENTO TL ON (AC.ID_TIPO_LANCAMENTO = TL.ID_TIPO_LANCAMENTO ) \n" + 
					"JOIN TIPO_LANCAMENTO TLCK ON (AC.ID_TIPO_LANCAMENTO_CK = TLCK.ID_TIPO_LANCAMENTO ) \n" + 
					"WHERE E.RAZAO_SOCIAL " + filtro.getRazaoSocial().toString() +
					"\n ORDER BY E.RAZAO_SOCIAL,AG.URL";
		}
		List <Object[]> listaQuery = this.entityManager.createNativeQuery(sql).getResultList();
		
		for(Object[] obj : listaQuery) {
			Object[] param = (Object[]) obj;
			
			ApiGeralVO vo = new ApiGeralVO();
			
			vo.setNome(param[0] == null ? null : param[0].toString());
			vo.setAtivo(param[1] == null ? null : param[1].toString());
			vo.setRazaoSocialString(param[2] == null ? null : param[2].toString());
			vo.setToken(param[3] == null ? null : param[3].toString());
			vo.setUrl(param[4] == null ? null : param[4].toString());
			vo.setIdApiGeral(param[5] == null ? null : Long.parseLong(param[5].toString()));
			vo.setApiContratoNome(param[6] == null ? null : param[6].toString());
			vo.setApiContratoAtivo(param[7] == null ? null : param[7].toString());
			vo.setHotelNomeFantasia(param[8] == null ? null : param[8].toString());
			vo.setTipoLancamentoDescricao(param[9] == null ? null : param[9].toString());
			vo.setTipoLancamentoDescricaoCK(param[10] == null ? null : param[10].toString());
			vo.setIdApiContrato(param[11] == null ? null : Long.parseLong(param[11].toString()));
			vo.setApiVendedorNome(param[12] == null ? null : param[12].toString());
			vo.setApiVendedorAtivo(param[13] == null ? null : param[13].toString());
			vo.setHotelNomeFantasiaTL(param[14] == null ?  null : param[14].toString());
			vo.setApiVendedorId(param[15] == null ? null : Long.parseLong(param[15].toString()));
			
			lista.add(vo);
		}
		
		
		return lista;
		
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ApiGeralEJB gravarApiGeral(ApiGeralEJB entidade) throws MozartSessionException {
		if(entidade.getIdApiGeral() == null) {
			 this.entityManager.persist(entidade);
		} else {
			 this.entityManager.merge(entidade);
		}
		return entidade;
	}
}
