package com.mozart.model.vo;

import java.util.Date;

public class ReservaMapaOcupacaoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Campos de filtro*/
	private Date dataEntrada;
	private Date dataSaida;
	private String bloqueio;
	private Long idHotel;
	
	
	/*campos da query*/
	private Long dia;
	private Date data;
	private String fantasia;
	private String diaSemana;
	private Long qtdeAptoDisponivel;
	private Long qtdeAptoDisponivelGeral;
	private Double qtdeAptoDisponivelGeralPercentual;
	private Long qtdeAptoOcupado;
	private Long qtdeAptoOcupadoGeral;
	private Double qtdeAptoOcupadoGeralPercentual;
	private Long qtdeConfirmadas;
	private Long qtdeNaoConfirmadas;
	private Long qtdeInterditado;
	private Long qtdeNoShow;
	private Long qtdeApto;
	private String naoConfirmadasDetalhe;
	private Long qtdeTipoApto;
	private Long qtdeCafe;
	private Long qtdeMap;
	private Long qtdeFap;
	private Long qtdeHospede;
	private Long qtdeBloqueio;
	private String detalheBloqueio;
	private Long qtdeCrianca;
	private Long qtdeAll;
	
	
	
	
	public ReservaMapaOcupacaoVO(){
		
		
		
	}

	public ReservaMapaOcupacaoVO(Object[] linha){
		if (linha != null){
			setLinha( linha );
			dia = getLong();
			data = getDate();
			fantasia = getString();
			diaSemana = getString();
			qtdeAptoDisponivel = getLong();
			qtdeAptoDisponivelGeral = getLong();
			qtdeAptoDisponivelGeralPercentual = getDouble();
			qtdeAptoOcupado = getLong();
			qtdeAptoOcupadoGeral = getLong();
			qtdeAptoOcupadoGeralPercentual = getDouble();
			qtdeConfirmadas = getLong();
			qtdeNaoConfirmadas = getLong();
			qtdeInterditado = getLong();
			qtdeNoShow = getLong();
			qtdeApto = getLong();
			naoConfirmadasDetalhe = getString();
			qtdeTipoApto = getLong();
			qtdeCafe = getLong();
			qtdeMap = getLong();
			qtdeFap = getLong();
			qtdeHospede = getLong();
			qtdeBloqueio = getLong();
			detalheBloqueio = getString();
			qtdeCrianca = getLong();
			qtdeAll = getLong();
		}
	}



	public Date getDataEntrada() {
		return dataEntrada;
	}




	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}




	public Date getDataSaida() {
		return dataSaida;
	}




	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}




	public String getBloqueio() {
		return bloqueio;
	}




	public void setBloqueio(String bloqueio) {
		this.bloqueio = bloqueio;
	}




	public Long getIdHotel() {
		return idHotel;
	}




	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}




	public Long getDia() {
		return dia;
	}




	public void setDia(Long dia) {
		this.dia = dia;
	}




	public Date getData() {
		return data;
	}




	public void setData(Date data) {
		this.data = data;
	}




	public String getFantasia() {
		return fantasia;
	}




	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}




	public String getDiaSemana() {
		return diaSemana;
	}




	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}




	public Long getQtdeAptoDisponivel() {
		return qtdeAptoDisponivel;
	}




	public void setQtdeAptoDisponivel(Long qtdeAptoDisponivel) {
		this.qtdeAptoDisponivel = qtdeAptoDisponivel;
	}




	public Long getQtdeAptoDisponivelGeral() {
		return qtdeAptoDisponivelGeral;
	}




	public void setQtdeAptoDisponivelGeral(Long qtdeAptoDisponivelGeral) {
		this.qtdeAptoDisponivelGeral = qtdeAptoDisponivelGeral;
	}




	public Double getQtdeAptoDisponivelGeralPercentual() {
		return qtdeAptoDisponivelGeralPercentual;
	}




	public void setQtdeAptoDisponivelGeralPercentual(
			Double qtdeAptoDisponivelGeralPercentual) {
		this.qtdeAptoDisponivelGeralPercentual = qtdeAptoDisponivelGeralPercentual;
	}




	public Long getQtdeAptoOcupado() {
		return qtdeAptoOcupado;
	}




	public void setQtdeAptoOcupado(Long qtdeAptoOcupado) {
		this.qtdeAptoOcupado = qtdeAptoOcupado;
	}




	public Long getQtdeAptoOcupadoGeral() {
		return qtdeAptoOcupadoGeral;
	}




	public void setQtdeAptoOcupadoGeral(Long qtdeAptoOcupadoGeral) {
		this.qtdeAptoOcupadoGeral = qtdeAptoOcupadoGeral;
	}




	public Double getQtdeAptoOcupadoGeralPercentual() {
		return qtdeAptoOcupadoGeralPercentual;
	}




	public void setQtdeAptoOcupadoGeralPercentual(
			Double qtdeAptoOcupadoGeralPercentual) {
		this.qtdeAptoOcupadoGeralPercentual = qtdeAptoOcupadoGeralPercentual;
	}




	public Long getQtdeConfirmadas() {
		return qtdeConfirmadas;
	}




	public void setQtdeConfirmadas(Long qtdeConfirmadas) {
		this.qtdeConfirmadas = qtdeConfirmadas;
	}




	public Long getQtdeNaoConfirmadas() {
		return qtdeNaoConfirmadas;
	}




	public void setQtdeNaoConfirmadas(Long qtdeNaoConfirmadas) {
		this.qtdeNaoConfirmadas = qtdeNaoConfirmadas;
	}




	public Long getQtdeInterditado() {
		return qtdeInterditado;
	}




	public void setQtdeInterditado(Long qtdeInterditado) {
		this.qtdeInterditado = qtdeInterditado;
	}




	public Long getQtdeNoShow() {
		return qtdeNoShow;
	}




	public void setQtdeNoShow(Long qtdeNoShow) {
		this.qtdeNoShow = qtdeNoShow;
	}




	public Long getQtdeApto() {
		return qtdeApto;
	}




	public void setQtdeApto(Long qtdeApto) {
		this.qtdeApto = qtdeApto;
	}




	public String getNaoConfirmadasDetalhe() {
		return naoConfirmadasDetalhe;
	}




	public void setNaoConfirmadasDetalhe(String naoConfirmadasDetalhe) {
		this.naoConfirmadasDetalhe = naoConfirmadasDetalhe;
	}




	public Long getQtdeTipoApto() {
		return qtdeTipoApto;
	}




	public void setQtdeTipoApto(Long qtdeTipoApto) {
		this.qtdeTipoApto = qtdeTipoApto;
	}




	public Long getQtdeCafe() {
		return qtdeCafe;
	}




	public void setQtdeCafe(Long qtdeCafe) {
		this.qtdeCafe = qtdeCafe;
	}




	public Long getQtdeMap() {
		return qtdeMap;
	}




	public void setQtdeMap(Long qtdeMap) {
		this.qtdeMap = qtdeMap;
	}




	public Long getQtdeFap() {
		return qtdeFap;
	}




	public void setQtdeFap(Long qtdeFap) {
		this.qtdeFap = qtdeFap;
	}




	public Long getQtdeHospede() {
		return qtdeHospede;
	}




	public void setQtdeHospede(Long qtdeHospede) {
		this.qtdeHospede = qtdeHospede;
	}




	public Long getQtdeBloqueio() {
		return qtdeBloqueio;
	}




	public void setQtdeBloqueio(Long qtdeBloqueio) {
		this.qtdeBloqueio = qtdeBloqueio;
	}




	public String getDetalheBloqueio() {
		return detalheBloqueio;
	}




	public void setDetalheBloqueio(String detalheBloqueio) {
		this.detalheBloqueio = detalheBloqueio;
	}




	public Long getQtdeCrianca() {
		return qtdeCrianca;
	}




	public void setQtdeCrianca(Long qtdeCrianca) {
		this.qtdeCrianca = qtdeCrianca;
	}




	public Long getQtdeAll() {
		return qtdeAll;
	}




	public void setQtdeAll(Long qtdeAll) {
		this.qtdeAll = qtdeAll;
	}
	
	

}
