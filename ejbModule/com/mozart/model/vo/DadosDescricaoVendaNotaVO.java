package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class DadosDescricaoVendaNotaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038980128571235166L;
	
	
	private String codigo;
	private String descricao;
	private String quantidade;
	private String unidade;
	private String valorUnidade;
	private String valorTotal;
	
	public DadosDescricaoVendaNotaVO(){
	}

	public DadosDescricaoVendaNotaVO(Object[] linha){
		
		if (!MozartUtil.isNull(linha)){
			setLinha( linha );
			codigo = getString();
			descricao = getString();
			quantidade = getString();
			unidade = getString();
			valorUnidade = getString();
			valorTotal = getString();
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getValorUnidade() {
		return valorUnidade;
	}

	public void setValorUnidade(String valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
}
