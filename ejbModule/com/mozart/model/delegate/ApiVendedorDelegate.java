package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.ApiVendedorEJB;
import com.mozart.model.ejb.facade.ApiVendedorSessionEJB;
import com.mozart.model.exception.MozartSessionException;

public class ApiVendedorDelegate extends MozartDelegate {

	private static ApiVendedorDelegate instance;
	private static ApiVendedorSessionEJB session;
	
	private ApiVendedorDelegate() throws MozartSessionException {
		try {
			session = (ApiVendedorSessionEJB) getLookup("ApiVendedorSessionEJB");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: ApiVendedorSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static ApiVendedorDelegate instance() throws MozartSessionException {
		return instance == null ? (ApiVendedorDelegate.instance = new ApiVendedorDelegate())
				: instance;
	}


	public ApiVendedorEJB gravarApiVendedor(ApiVendedorEJB entidade) throws MozartSessionException {
		// TODO Auto-generated method stub
		return session.gravarApiVendedor(entidade);
	}
}
