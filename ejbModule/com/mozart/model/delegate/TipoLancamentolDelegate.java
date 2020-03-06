package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.facade.TipoLancamentoSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.HotelVO;
import com.mozart.model.vo.TipoLancamentoVO;

public class TipoLancamentolDelegate extends MozartDelegate {

	private static TipoLancamentolDelegate instance;
	private static TipoLancamentoSession session;
	
	private TipoLancamentolDelegate() throws MozartSessionException {
		try {
			session = (TipoLancamentoSession) getLookup("TipoLancamentoSession");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: TipoLancamentoSession");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static TipoLancamentolDelegate instance() throws MozartSessionException {
		return instance == null ? (TipoLancamentolDelegate.instance = new TipoLancamentolDelegate())
				: instance;
	}

	public List<TipoLancamentoVO> consultarTipoLancamentoRecebimento(HotelVO filtro) throws MozartSessionException {
		return session.consultarTipoLancamentoRecebimento(filtro);
	}
	public List<TipoLancamentoVO> consultarTipoLancamentoReceita(HotelVO filtro) throws MozartSessionException {
		return session.consultarTipoLancamentoReceita(filtro);
	}
	public TipoLancamentoEJB consultarTipoLancamentoPorId(Long id)  throws MozartSessionException {
		return session.consultarTipoLancamentoPorId(id);
	}
}
