package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class DadosFormaPagamentoNotaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038980128571235166L;
	
	
	private String descricao;
	private String valorTotal;
	
	public DadosFormaPagamentoNotaVO(){
	}

	public DadosFormaPagamentoNotaVO(Object[] linha){
		
		if (!MozartUtil.isNull(linha)){
			setLinha( linha );
			descricao = getString();
			valorTotal = getString();
		}
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
}
