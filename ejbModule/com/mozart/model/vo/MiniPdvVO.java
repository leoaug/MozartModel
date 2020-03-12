package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MiniPdvVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroCheckin;
	private FiltroWeb filtroPontoVenda;
	private FiltroWeb filtroNumApartamento;
	private FiltroWeb filtroData;
	
	

	
	private Long idMiniPdv;
	private Long idMovimentoApartamento;
	private Long numApartamento;
	private String nomePontoVenda;
	private Long idCheckin;
	private String hospede;
	private Date data;
	private String nomePrato;
	private Double qtde;
	private Double vlTotal;
	
	
	
	public MiniPdvVO(){
		
		filtroCheckin = new FiltroWeb();
		filtroPontoVenda = new FiltroWeb();
		filtroNumApartamento = new FiltroWeb();		
		filtroData = new FiltroWeb();
		
		
	}	
	
	public MiniPdvVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idMiniPdv = getLong();
			idMovimentoApartamento = getLong();
			numApartamento = getLong();
			nomePontoVenda = getString();
			idCheckin = getLong();
			hospede = getString();
			data = getDate();
			nomePrato = getString();
			qtde = getDouble();
			vlTotal = getDouble();
			
		
		}
		
	}

	public FiltroWeb getFiltroCheckin() {
		return filtroCheckin;
	}

	public void setFiltroCheckin(FiltroWeb filtroCheckin) {
		this.filtroCheckin = filtroCheckin;
	}

	public FiltroWeb getFiltroNumApartamento() {
		return filtroNumApartamento;
	}

	public void setFiltroNumApartamento(FiltroWeb filtroNumApartamento) {
		this.filtroNumApartamento = filtroNumApartamento;
	}

	public Long getIdMiniPdv() {
		return idMiniPdv;
	}

	public void setIdMiniPdv(Long idMiniPdv) {
		this.idMiniPdv = idMiniPdv;
	}

	public Long getIdMovimentoApartamento() {
		return idMovimentoApartamento;
	}

	public void setIdMovimentoApartamento(Long idMovimentoApartamento) {
		this.idMovimentoApartamento = idMovimentoApartamento;
	}

	public Long getNumApartamento() {
		return numApartamento;
	}

	public void setNumApartamento(Long numApartamento) {
		this.numApartamento = numApartamento;
	}

	public String getNomePontoVenda() {
		return nomePontoVenda;
	}

	public void setNomePontoVenda(String nomePontoVenda) {
		this.nomePontoVenda = nomePontoVenda;
	}

	public String getHospede() {
		return hospede;
	}

	public void setHospede(String hospede) {
		this.hospede = hospede;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public Double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(Double vlTotal) {
		this.vlTotal = vlTotal;
	}

	public Long getIdCheckin() {
		return idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public Double getQtde() {
		return qtde;
	}

	public void setQtde(Double qtde) {
		this.qtde = qtde;
	}

	public FiltroWeb getFiltroData() {
		return filtroData;
	}

	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}

	public FiltroWeb getFiltroPontoVenda() {
		return filtroPontoVenda;
	}

	public void setFiltroPontoVenda(FiltroWeb filtroPontoVenda) {
		this.filtroPontoVenda = filtroPontoVenda;
	}

	


}
