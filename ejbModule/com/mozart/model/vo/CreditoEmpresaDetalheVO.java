package com.mozart.model.vo;

import java.util.Date;

public class CreditoEmpresaDetalheVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7956751477958455883L;
	
	private Long tipo;
	private Long idHotel;
	private Long idEmpresa;
	private Long idReserva;
	private Long idCheckin;
	private String numero;
	private String siglaHotel;
	private String nomeFantasia;
	private Date dataEntrada;
	private Date dataSaida;
	private Double valor;
	
	public CreditoEmpresaDetalheVO(){}
	
	
	public CreditoEmpresaDetalheVO(Object[] linha){
		
		if (linha != null){
			setLinha(linha);
			tipo = getLong();
			idHotel = getLong();
			idEmpresa = getLong();
			idCheckin = getLong();
			idReserva = getLong();
			numero = getString();
			sigla = getString();
			nomeFantasia = getString();
			dataEntrada = getDate();
			dataSaida = getDate();
			valor = getDouble();
		}
		
		
	}
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	public Long getIdCheckin() {
		return idCheckin;
	}
	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSiglaHotel() {
		return siglaHotel;
	}
	public void setSiglaHotel(String siglaHotel) {
		this.siglaHotel = siglaHotel;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Long getTipo() {
		return tipo;
	}


	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	
	
	
	
	

}
