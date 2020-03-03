package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class StatusNotaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5585335719175267184L;
	
	private Long idNota;
	private Long idCheckin;
	private Long numApartamento;
	private String tipoApartamento;
	private String numNota;
	private String notaInicial;
	private String nomeHospede;
	private String nomeEmpresa;
	
	public StatusNotaVO(){
		
		
	}
	
	public StatusNotaVO(Object[] linha){
		if (linha != null){
			setLinha(linha);
			idNota = getLong();
			idCheckin  =getLong();
			numApartamento = getLong();
			tipoApartamento = getString();
			numNota = getString();
			notaInicial = getString();
			nomeHospede = getString();
			nomeEmpresa = getString();
		}
	}

	public String toString(){
		return MozartUtil.rpad(numNota, " ", 10) + " : " +
			   MozartUtil.rpad(numApartamento+"-"+tipoApartamento, " ", 10) + " : " + 
			   MozartUtil.rpad(nomeHospede, " ", 60) +  " : " +
			   MozartUtil.rpad(nomeEmpresa, " ", 60);
	}
	
	public Long getIdNota() {
		return idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Long getIdCheckin() {
		return idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public Long getNumApartamento() {
		return numApartamento;
	}

	public void setNumApartamento(Long numApartamento) {
		this.numApartamento = numApartamento;
	}

	public String getTipoApartamento() {
		return tipoApartamento;
	}

	public void setTipoApartamento(String tipoApartamento) {
		this.tipoApartamento = tipoApartamento;
	}

	public String getNumNota() {
		return numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public String getNomeHospede() {
		return nomeHospede;
	}

	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNotaInicial() {
		return notaInicial;
	}

	public void setNotaInicial(String notaInicial) {
		this.notaInicial = notaInicial;
	}
	

}
