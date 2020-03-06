package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.HotelVO;
import com.mozart.model.vo.TipoLancamentoVO;


@Remote
public interface TipoLancamentoSession {

	List <TipoLancamentoVO> consultarTipoLancamentoReceita(HotelVO filtro)  throws MozartSessionException;
	List <TipoLancamentoVO>  consultarTipoLancamentoRecebimento(HotelVO filtro) throws MozartSessionException;
	TipoLancamentoEJB consultarTipoLancamentoPorId(Long id) throws MozartSessionException;
}
