package com.mozart.model.vo;

import java.sql.Timestamp;

public class CrsVO extends MozartVO{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -467396979046747830L;
	private Long idCrs;
	private Long idHotel;
	private Long idCidade;
	private String bairro;
	private Timestamp dataEntrada;
	private Timestamp dataSaida;
	private Long qtdeApto;
	private Double tarifaAte;
	private Long qtdePessoa;
	private String bloqueio;
	private String propria;
	
	public CrsVO(){
		qtdeApto = new Long(1);
		qtdePessoa = new Long(1);
		bloqueio = "N";
	}


	public Long getIdCrs() {
		return idCrs;
	}


	public void setIdCrs(Long idCrs) {
		this.idCrs = idCrs;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	public Long getIdCidade() {
		return idCidade;
	}


	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public Timestamp getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public Timestamp getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Long getQtdeApto() {
		return qtdeApto;
	}


	public void setQtdeApto(Long qtdeApto) {
		this.qtdeApto = qtdeApto;
	}


	public Double getTarifaAte() {
		return tarifaAte;
	}


	public void setTarifaAte(Double tarifaAte) {
		this.tarifaAte = tarifaAte;
	}


	public Long getQtdePessoa() {
		return qtdePessoa;
	}


	public void setQtdePessoa(Long qtdePessoa) {
		this.qtdePessoa = qtdePessoa;
	}


	public String getBloqueio() {
		return bloqueio;
	}


	public void setBloqueio(String bloqueio) {
		this.bloqueio = bloqueio;
	}


	public String getPropria() {
		return propria;
	}


	public void setPropria(String propria) {
		this.propria = propria;
	}
	
	

}
