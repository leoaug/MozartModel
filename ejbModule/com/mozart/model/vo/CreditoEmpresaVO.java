package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class CreditoEmpresaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4351647810510594207L;
	
	
	/* FILTRO */
	private FiltroWeb filtroPossuiCredito;
	private FiltroWeb filtroDataCadastro;
	private FiltroWeb filtroNomeFantasia;
	private FiltroWeb filtroDuplicataVencida;
	private FiltroWeb filtroSaldoNegativo;
	private FiltroWeb filtroCNPJ;
	
	private Long idEmpresa;
	private String nomeFantasia;
	private String credito;
	private Double valorCredito;
	private String observacao;
	private Date dataCadastro;
	private Double duplicatasAbertas;
	private Double duplicatasVencidas;
	private Double duplicatasPagas;
	private Double valorReservas;
	private Double valorCheckins;
	private Double valorTotal;
	private Double saldo;
	private String cnpj;
	
	
	public CreditoEmpresaVO(){
		filtroPossuiCredito = new FiltroWeb();
		filtroDataCadastro = new FiltroWeb();
		filtroNomeFantasia = new FiltroWeb();
		filtroDuplicataVencida = new FiltroWeb();
		filtroSaldoNegativo = new FiltroWeb();
		filtroCNPJ = new FiltroWeb();
	}


	public CreditoEmpresaVO(Object[] l) {

		setLinha( l );
		idEmpresa = getLong();
		nomeFantasia = getString();
		credito = getString();
		valorCredito = getDouble();
		observacao = getString();
		dataCadastro = getDate();
		duplicatasAbertas = getDouble();
		duplicatasVencidas = getDouble();
		duplicatasPagas	= getDouble();
		valorReservas = getDouble();
		valorCheckins = getDouble();
		valorTotal = getDouble();
		saldo = getDouble();
		cnpj = getString();
		
	}
	
	
	public boolean equals (Object obj){
		if (obj == null){
			return false;
		}
		return idEmpresa.equals( ((CreditoEmpresaVO)obj).getIdEmpresa() );
	}


	public Long getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getCredito() {
		return credito;
	}


	public void setCredito(String credito) {
		this.credito = credito;
	}


	public Double getValorCredito() {
		return valorCredito;
	}


	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public Double getDuplicatasAbertas() {
		return duplicatasAbertas;
	}


	public void setDuplicatasAbertas(Double duplicatasAbertas) {
		this.duplicatasAbertas = duplicatasAbertas;
	}


	public Double getDuplicatasVencidas() {
		return duplicatasVencidas;
	}


	public void setDuplicatasVencidas(Double duplicatasVencidas) {
		this.duplicatasVencidas = duplicatasVencidas;
	}


	public Double getDuplicatasPagas() {
		return duplicatasPagas;
	}


	public void setDuplicatasPagas(Double duplicatasPagas) {
		this.duplicatasPagas = duplicatasPagas;
	}

	

	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public FiltroWeb getFiltroPossuiCredito() {
		return filtroPossuiCredito;
	}


	public void setFiltroPossuiCredito(FiltroWeb filtroPossuiCredito) {
		this.filtroPossuiCredito = filtroPossuiCredito;
	}


	public FiltroWeb getFiltroDataCadastro() {
		return filtroDataCadastro;
	}


	public void setFiltroDataCadastro(FiltroWeb filtroDataCadastro) {
		this.filtroDataCadastro = filtroDataCadastro;
	}


	public FiltroWeb getFiltroNomeFantasia() {
		return filtroNomeFantasia;
	}


	public void setFiltroNomeFantasia(FiltroWeb filtroNomeFantasia) {
		this.filtroNomeFantasia = filtroNomeFantasia;
	}


	public FiltroWeb getFiltroDuplicataVencida() {
		return filtroDuplicataVencida;
	}


	public void setFiltroDuplicataVencida(FiltroWeb filtroDuplicataVencida) {
		this.filtroDuplicataVencida = filtroDuplicataVencida;
	}


	public FiltroWeb getFiltroSaldoNegativo() {
		return filtroSaldoNegativo;
	}


	public void setFiltroSaldoNegativo(FiltroWeb filtroSaldoNegativo) {
		this.filtroSaldoNegativo = filtroSaldoNegativo;
	}


	public Double getValorReservas() {
		return valorReservas;
	}


	public void setValorReservas(Double valorReservas) {
		this.valorReservas = valorReservas;
	}


	public Double getValorCheckins() {
		return valorCheckins;
	}


	public void setValorCheckins(Double valorCheckins) {
		this.valorCheckins = valorCheckins;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public FiltroWeb getFiltroCNPJ() {
		return filtroCNPJ;
	}


	public void setFiltroCNPJ(FiltroWeb filtroCNPJ) {
		this.filtroCNPJ = filtroCNPJ;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
	

}
