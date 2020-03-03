package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.facade.ContaCorrenteSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ContaCorrenteVO;

public class ContaCorrenteDelegate extends MozartDelegate {

	private static ContaCorrenteDelegate instance;
	private static ContaCorrenteSession session;

	private ContaCorrenteDelegate() throws MozartSessionException {
		try {
			session = (ContaCorrenteSession) getLookup("ContaCorrenteSession");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: ContaCorrenteSession");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static ContaCorrenteDelegate instance()
			throws MozartSessionException {
		if (instance == null)
			instance = new ContaCorrenteDelegate();
		return instance;
	}

	public List<ContaCorrenteVO> obterContasCorrente(ContaCorrenteVO filtro)
			throws MozartSessionException {
		return session.obterContasCorrente(filtro);
	}
	
	public ContaCorrenteVO obterContaCorrente(ContaCorrenteVO filtro)
			throws MozartSessionException {
		return session.obterContaCorrente(filtro);
	}
}