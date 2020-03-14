package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ApiGeralEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ApiGeralVO;

@Remote
public abstract interface ApiGeralSessionEJB {

	public abstract List<ApiGeralVO> obterApisGeraisPorRazaoSocial(ApiGeralVO filtro) throws MozartSessionException;
	public abstract ApiGeralEJB gravarApiGeral(ApiGeralEJB entidade) throws MozartSessionException;
	public abstract ApiGeralEJB obter(Long idApiGeral);
}
