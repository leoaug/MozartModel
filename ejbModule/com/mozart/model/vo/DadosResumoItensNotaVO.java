package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class DadosResumoItensNotaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038980128571235166L;
	
	
	private Long quantidade;
	private String valorProduto;
	private String taxa;
	private String valorTotal;
	private String imposto;
	
	public DadosResumoItensNotaVO(){
	}

	public DadosResumoItensNotaVO(Object[] linha){
		
		if (!MozartUtil.isNull(linha)){
			setLinha( linha );
			quantidade = getLong();
			valorProduto = getString();
			taxa = getString();
			valorTotal = getString();
			imposto = getString();
		}
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(String valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getImposto() {
		return imposto;
	}

	public void setImposto(String imposto) {
		this.imposto = imposto;
	}
	
	
}
