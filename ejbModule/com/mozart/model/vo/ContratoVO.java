package com.mozart.model.vo;


import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ContratoVO extends MozartVO {

	private static final long serialVersionUID = 1370379234785052944L;

	private Long idContrato;
	private String cancelado;
	private String nomeCliente;
	private Date dataInicio;
	private Date dataFim;
	private String diaFaturamento;
	private String tipoServico;
	private String descricaoServico;
	private String quantidade;
	private Double vlUnitario;
	private Double vlTotal;
	private String iss;
	private String taxaServico;
	private String unidade;
	
	private FiltroWeb filtroEmpresa;
	private FiltroWeb filtroCancelado;
	private FiltroWeb filtrodataini;
	private FiltroWeb filtrodatafim;
	
	public ContratoVO() {
		filtroEmpresa = new FiltroWeb();
		filtroCancelado = new FiltroWeb();
		filtrodataini = new FiltroWeb();
		filtrodatafim = new FiltroWeb();
	}
	
	public ContratoVO(Object[] linha) {
		setLinha(linha);
		idContrato = getLong();
		cancelado = getString();
		nomeCliente = getString();
		dataInicio = getDate();
		dataFim = getDate();
		diaFaturamento = getString();
		tipoServico = getString();
		descricaoServico = getString();
		quantidade = getString();
		vlUnitario = getDouble();
		vlTotal = getDouble();
		iss = getString();
		taxaServico = getString();
		unidade = getString();
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public String getCancelado() {
		return cancelado;
	}

	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDiaFaturamento() {
		return diaFaturamento;
	}

	public void setDiaFaturamento(String diaFaturamento) {
		this.diaFaturamento = diaFaturamento;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(Double vlTotal) {
		this.vlTotal = vlTotal;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(String taxaServico) {
		this.taxaServico = taxaServico;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public FiltroWeb getFiltroEmpresa() {
		return filtroEmpresa;
	}

	public void setFiltroEmpresa(FiltroWeb filtroEmpresa) {
		this.filtroEmpresa = filtroEmpresa;
	}

	public FiltroWeb getFiltroCancelado() {
		return filtroCancelado;
	}

	public void setFiltroCancelado(FiltroWeb filtroCancelado) {
		this.filtroCancelado = filtroCancelado;
	}

	public FiltroWeb getFiltrodataini() {
		return filtrodataini;
	}

	public void setFiltrodataini(FiltroWeb filtrodataini) {
		this.filtrodataini = filtrodataini;
	}

	public FiltroWeb getFiltrodatafim() {
		return filtrodatafim;
	}

	public void setFiltrodatafim(FiltroWeb filtrodatafim) {
		this.filtrodatafim = filtrodatafim;
	}

	
}