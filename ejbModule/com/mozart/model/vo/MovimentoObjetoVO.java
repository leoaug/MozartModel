package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MovimentoObjetoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8643600119752268909L;
	
	
	private FiltroWeb filtroApto;
	private FiltroWeb filtroNome;
	private FiltroWeb filtroData;
	

	private Long idMovimentoObjeto;
	private String apartamento;
	private String hospede;
	private String objeto;
	private Date data;
	private String observacao;
	private Long qtde;
	private Double valorObjeto;
	private Double valorEmprestimo;
	private Double valorLancamento;
	
	
	public MovimentoObjetoVO(){
		filtroApto = new FiltroWeb ();
		filtroNome = new FiltroWeb ();
		filtroData = new FiltroWeb ();
	}
	
	
	
	public MovimentoObjetoVO(Object[] linha){
		
		if (linha != null){
			setLinha(linha);
			idMovimentoObjeto = getLong();
			apartamento = getString();
			hospede = getString();
			objeto = getString();
			data = getDate();
			observacao = getString();
			qtde = getLong();
			valorObjeto = getDouble();
			valorEmprestimo = getDouble();
			valorLancamento = getDouble();

		}
	}

	public FiltroWeb getFiltroApto() {
		return filtroApto;
	}



	public void setFiltroApto(FiltroWeb filtroApto) {
		this.filtroApto = filtroApto;
	}



	public FiltroWeb getFiltroNome() {
		return filtroNome;
	}



	public void setFiltroNome(FiltroWeb filtroNome) {
		this.filtroNome = filtroNome;
	}



	public FiltroWeb getFiltroData() {
		return filtroData;
	}



	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}



	public Long getIdMovimentoObjeto() {
		return idMovimentoObjeto;
	}



	public void setIdMovimentoObjeto(Long idMovimentoObjeto) {
		this.idMovimentoObjeto = idMovimentoObjeto;
	}



	public String getApartamento() {
		return apartamento;
	}



	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}



	public String getHospede() {
		return hospede;
	}



	public void setHospede(String hospede) {
		this.hospede = hospede;
	}



	public String getObjeto() {
		return objeto;
	}



	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public Long getQtde() {
		return qtde;
	}



	public void setQtde(Long qtde) {
		this.qtde = qtde;
	}



	public Double getValorObjeto() {
		return valorObjeto;
	}



	public void setValorObjeto(Double valorObjeto) {
		this.valorObjeto = valorObjeto;
	}



	public Double getValorEmprestimo() {
		return valorEmprestimo;
	}



	public void setValorEmprestimo(Double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}



	public Double getValorLancamento() {
		return valorLancamento;
	}



	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

}
