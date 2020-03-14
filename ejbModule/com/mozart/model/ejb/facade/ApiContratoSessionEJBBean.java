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

import com.mozart.model.ejb.entity.ApiContratoEJB;
import com.mozart.model.ejb.entity.ApiGeralEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;


@Stateless(name = "ApiContratoSessionEJB")
public class ApiContratoSessionEJBBean implements ApiContratoSessionEJB {

	@PersistenceContext(unitName="MozartModel")
	private EntityManager entityManager;

	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ApiContratoEJB gravarApiContrato(ApiContratoEJB entidade) throws MozartSessionException {
		if(entidade.getIdApiContrato() == null) {
			 this.entityManager.persist(entidade);
		} else {
			 this.entityManager.merge(entidade);
		}
		return entidade;
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ApiContratoEJB consultarPorApiGeral(ApiGeralEJB entidade) {		
		@SuppressWarnings("unchecked")
		List <Object[]> lista = this.entityManager.
				createNativeQuery("select ID_API_CONTRATO, API_NOME from API_CONTRATO where ID_API_GERAL = " + entidade.getIdApiGeral()).getResultList();
		
		for(Object[] param : lista) {
			
			BigDecimal id = (BigDecimal) param[0];			
			return this.entityManager.find(ApiContratoEJB.class, Long.parseLong(id.toString()));
		}
		return null;
		
	}
}
