package com.mozart.model.ejb.facade;


import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ApiGeralEJB;
import com.mozart.model.ejb.entity.ApiVendedorEJB;
import com.mozart.model.exception.MozartSessionException;

@Remote
public abstract interface ApiVendedorSessionEJB {

	public abstract ApiVendedorEJB gravarApiVendedor(ApiVendedorEJB entidade) throws MozartSessionException;

	public abstract ApiVendedorEJB consultarPorApiGeral(ApiGeralEJB entidade);
}
