package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ApiContratoEJB;
import com.mozart.model.ejb.entity.ApiGeralEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ApiContratoVO;

@Remote
public abstract interface ApiContratoSessionEJB {

	public abstract ApiContratoEJB gravarApiContrato(ApiContratoEJB entidade) throws MozartSessionException;

	public abstract ApiContratoEJB consultarPorApiGeral(ApiGeralEJB entidade);
}
