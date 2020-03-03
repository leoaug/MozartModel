package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class ClassificacaoContabilCentroCustoVO extends MozartVO {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8370488835631787521L;
	private Long idCentroCustoContabil;
	private String descricaoCentroCusto;

	public ClassificacaoContabilCentroCustoVO() {

	}

	public ClassificacaoContabilCentroCustoVO(Object[] linha) {

		if (!MozartUtil.isNull(linha)) {
			setLinha(linha);

			idCentroCustoContabil = getLong();
			descricaoCentroCusto = getString();
		}

	}
	
	public ClassificacaoContabilCentroCustoVO(String content) {
			descricaoCentroCusto = content;
	}

	public Long getIdCentroCustoContabil() {
		return idCentroCustoContabil;
	}

	public void setIdCentroCustoContabil(Long idCentroCustoContabil) {
		this.idCentroCustoContabil = idCentroCustoContabil;
	}

	public String getDescricaoCentroCusto() {
		return descricaoCentroCusto;
	}

	public void setDescricaoCentroCusto(String descricaoCentroCusto) {
		this.descricaoCentroCusto = descricaoCentroCusto;
	}
}
