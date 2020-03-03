package com.mozart.model.ejb.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ContaCorrenteVO;

@SuppressWarnings({"unchecked", "rawtypes"})
@Stateless(name="ContaCorrenteSession")
public class ContaCorrenteSessionBean implements ContaCorrenteSession {
	
	@PersistenceContext(unitName="MozartModel")
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object obter(Class class1, Object pk) throws MozartSessionException {
		try {
			Object obj = this.entityManager.find(class1, pk);
			if (!MozartUtil.isNull(obj)) {
				this.entityManager.refresh(obj);
			}
			return obj;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Object persist(Object newEntity) throws MozartSessionException {
		this.entityManager.persist(newEntity);
		return newEntity;
	}
	
	public Object refresh(Class entity, Object pk)
			throws MozartSessionException {
		Object result = this.entityManager.getReference(entity, pk);
		this.entityManager.refresh(result);
		return result;
	}
	
	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object alterar(Object entity) throws MozartSessionException {
		try {
			this.entityManager.merge(entity);
			return entity;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(Object entity) throws MozartSessionException {
		try {
			entity = this.entityManager.merge(entity);
			this.entityManager.remove(entity);
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ContaCorrenteVO> obterContasCorrente(ContaCorrenteVO filtro)
			throws MozartSessionException {

		String query = QRY_CONTA_CORRENTE;
		
		if (filtro.getFiltroPagamento().getValorInicial() != null) {
			query += " AND CC.PAGAMENTO " + filtro.getFiltroPagamento();
		}
		
		List lista = this.entityManager
				.createNativeQuery(query)
				.setParameter(1, filtro.getIdHotel())
				.getResultList();

		List<ContaCorrenteVO> resultado = new ArrayList<ContaCorrenteVO>();
		for (Object o : lista) {
			resultado.add(new ContaCorrenteVO((Object[]) o));
		}
		return resultado;
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public ContaCorrenteVO obterContaCorrente(ContaCorrenteVO filtro)
			throws MozartSessionException {

		String query = QRY_CONTA_CORRENTE;
		
		if (filtro.getIdContaCorrente() != null) {
			query += " AND CC.ID_CONTA_CORRENTE = ?2 ";
		}
		
		List lista = this.entityManager
				.createNativeQuery(query)
				.setParameter(1, filtro.getIdHotel())
				.setParameter(2, filtro.getIdContaCorrente())
				.getResultList();

		ContaCorrenteVO resultado = new ContaCorrenteVO();
		if (!lista.isEmpty()) {
			resultado = new ContaCorrenteVO((Object[]) lista.get(0));
		}
		return resultado;
	}
}
