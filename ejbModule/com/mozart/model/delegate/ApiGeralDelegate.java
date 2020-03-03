package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.ApiGeralEJB;
import com.mozart.model.ejb.facade.ApiGeralSessionEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ApiGeralVO;

public class ApiGeralDelegate extends MozartDelegate {

	private static ApiGeralDelegate instance;
	private static ApiGeralSessionEJB session;
	
	private ApiGeralDelegate() throws MozartSessionException {
		try {
			session = (ApiGeralSessionEJB) getLookup("ApiGeralSessionEJB");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: ApiGeralSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static ApiGeralDelegate instance() throws MozartSessionException {
		return instance == null ? (ApiGeralDelegate.instance = new ApiGeralDelegate())
				: instance;
	}

	public List<ApiGeralVO> obterApisGeraisPorRazaoSocial(ApiGeralVO filtro) throws MozartSessionException {
		return session.obterApisGeraisPorRazaoSocial(filtro);
	}
	public ApiGeralEJB gravarApiGeral(ApiGeralEJB entidade) throws MozartSessionException {
		// TODO Auto-generated method stub
		return session.gravarApiGeral(entidade);
	}
}
