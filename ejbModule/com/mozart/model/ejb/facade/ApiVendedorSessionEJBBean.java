package com.mozart.model.ejb.facade;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.ApiVendedorEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;


@Stateless(name = "ApiVendedorSessionEJB")
public class ApiVendedorSessionEJBBean implements ApiVendedorSessionEJB {

	@PersistenceContext(unitName="MozartModel")
	private EntityManager entityManager;

	
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ApiVendedorEJB gravarApiVendedor(ApiVendedorEJB entidade) throws MozartSessionException {
		if(entidade.getIdApiVendedor() == null) {
			 this.entityManager.persist(entidade);
		} else {
			 this.entityManager.merge(entidade);
		}
		return entidade;
	}
}
