package com.mozart.model.ejb.facade;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.TransacaoWebEJB;
import com.mozart.model.exception.MozartSessionException;


@Remote
public interface BraspagSession {

	TransacaoWebEJB realizarTransacaoWeb(TransacaoWebEJB novaTransacao)  throws MozartSessionException;
	TransacaoWebEJB estornarTransacaoWeb(TransacaoWebEJB transacao) throws MozartSessionException;
}
