package com.mozart.model.vo;

import java.util.Date;

public class ProcurarHospedeVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3460737426522476746L;
	
	
	private Long status;
	private String numApartamento;
	private String nomeEmpresa;
	private String nomeHospede;
	private Date dataEntrada;
	private Date dataSaida;
	
	
	
	public ProcurarHospedeVO(){
		
		
	}
	public ProcurarHospedeVO(Object[] linha){
		
		if (linha != null){
			setLinha(linha);
			status = getLong();
			numApartamento = getString();
			nomeEmpresa = getString();
			nomeHospede = getString();
			dataEntrada = getDate();
			dataSaida = getDate();
		}
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getNumApartamento() {
		return numApartamento;
	}
	public void setNumApartamento(String numApartamento) {
		this.numApartamento = numApartamento;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getNomeHospede() {
		return nomeHospede;
	}
	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
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

}
