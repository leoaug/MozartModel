package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class TransacaoWebVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6013229645174161345L;
	
	//Campos
	private Long idTransacao;
	private String apartamento;
	private String nomeCliente;
	private String cartao;
	private String codAutorizacao;
	private String codTransacao;
	private String txtMensagem;
	private Date dataTransacao;
	private Double valorTransacao;
	private String status;
	private Long idReserva;
	
	
	//Filtros
	private FiltroWeb filtroDataTransacao;
	private FiltroWeb filtroApartamento;
	
	
	public TransacaoWebVO(){
		filtroDataTransacao = new FiltroWeb();
		filtroApartamento = new FiltroWeb();
	}

	public TransacaoWebVO(Object[] linha){
			
		if ( linha != null){
			setLinha(linha);
			idTransacao = getLong();
			apartamento = getString();
			nomeCliente = getString();
			cartao = getString();
			codAutorizacao = getString();
			codTransacao = getString();
			txtMensagem = getString();
			dataTransacao = getDate();
			valorTransacao = getDouble();
			status = getString();
			idReserva = getLong();
		}
	}


	public FiltroWeb getFiltroDataTransacao() {
		return filtroDataTransacao;
	}


	public void setFiltroDataTransacao(FiltroWeb filtroDataTransacao) {
		this.filtroDataTransacao = filtroDataTransacao;
	}


	public FiltroWeb getFiltroApartamento() {
		return filtroApartamento;
	}


	public void setFiltroApartamento(FiltroWeb filtroApartamento) {
		this.filtroApartamento = filtroApartamento;
	}


	public Long getIdTransacao() {
		return idTransacao;
	}


	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}


	public String getApartamento() {
		return apartamento;
	}


	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getCartao() {
		return cartao;
	}


	public void setCartao(String cartao) {
		this.cartao = cartao;
	}


	public String getCodAutorizacao() {
		return codAutorizacao;
	}


	public void setCodAutorizacao(String codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}


	public String getCodTransacao() {
		return codTransacao;
	}


	public void setCodTransacao(String codTransacao) {
		this.codTransacao = codTransacao;
	}


	public String getTxtMensagem() {
		return txtMensagem;
	}


	public void setTxtMensagem(String txtMensagem) {
		this.txtMensagem = txtMensagem;
	}


	public Date getDataTransacao() {
		return dataTransacao;
	}


	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}


	public Double getValorTransacao() {
		return valorTransacao;
	}


	public void setValorTransacao(Double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	

}
