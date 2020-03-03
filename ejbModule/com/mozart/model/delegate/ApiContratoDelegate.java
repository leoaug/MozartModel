package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.ApiContratoEJB;
import com.mozart.model.ejb.facade.ApiContratoSessionEJB;
import com.mozart.model.exception.MozartSessionException;

public class ApiContratoDelegate extends MozartDelegate {

	private static ApiContratoDelegate instance;
	private static ApiContratoSessionEJB session;
	
	private ApiContratoDelegate() throws MozartSessionException {
		try {
			session = (ApiContratoSessionEJB) getLookup("ApiContratoSessionEJB");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: ApiContratoSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static ApiContratoDelegate instance() throws MozartSessionException {
		return instance == null ? (ApiContratoDelegate.instance = new ApiContratoDelegate())
				: instance;
	}

	public ApiContratoEJB gravarApiContrato(ApiContratoEJB entidade) throws MozartSessionException {
		// TODO Auto-generated method stub
		return session.gravarApiContrato(entidade);
	}
}
