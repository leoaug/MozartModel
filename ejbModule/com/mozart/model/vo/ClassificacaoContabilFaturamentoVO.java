package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class ClassificacaoContabilFaturamentoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2682028379743323260L;

	private Long idPlanoContas;
	private Long idHistoricoDebitoCredito;
	private String contaContabil;

	public ClassificacaoContabilFaturamentoVO() {

	}

	public ClassificacaoContabilFaturamentoVO(Object[] linha) {
		if (!MozartUtil.isNull(linha)) {
			setLinha(linha);
			idPlanoContas = getLong();
			idHistoricoDebitoCredito = getLong();
			contaContabil = getString();
		}
	}

	public Long getIdPlanoContas() {
		return idPlanoContas;
	}

	public void setIdPlanoContas(Long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}

	public Long getIdHistoricoDebitoCredito() {
		return idHistoricoDebitoCredito;
	}

	public void setIdHistoricoDebitoCredito(Long idHistoricoDebitoCredito) {
		this.idHistoricoDebitoCredito = idHistoricoDebitoCredito;
	}

	public String getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}
}
