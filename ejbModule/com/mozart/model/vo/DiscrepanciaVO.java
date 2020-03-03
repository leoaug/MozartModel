package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class DiscrepanciaVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private FiltroWeb filtroData;
	
	
	

	
	private Long idDiscrepancia;
	private String discrepancia;
	private Long numApartamento;
	private String numTelefone;
	private Date data;
	private String horaInicio;
	private String horaFim;
	private Double valor;
	private String ramal;
	
	public DiscrepanciaVO(){
		
		filtroData = new FiltroWeb();
				
	}

	public DiscrepanciaVO(Object[] linha) {
		
		if (!MozartUtil.isNull(linha)){
			setLinha(linha);
			idDiscrepancia = getLong();
			ramal = getString ();
			numApartamento = getLong();
			numTelefone = getString ();
			data  = getDate();
			horaInicio = getString();
			horaFim = getString ();
			valor = getDouble ();
		}
	}

	
	

	public Long getIdDiscrepancia() {
		return idDiscrepancia;
	}

	public void setIdDiscrepancia(Long idDiscrepancia) {
		this.idDiscrepancia = idDiscrepancia;
	}

	public String getDiscrepancia() {
		return discrepancia;
	}

	public void setDiscrepancia(String discrepancia) {
		this.discrepancia = discrepancia;
	}

	public String getRamal() {
		return ramal;
	}
	
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	public Long getNumApartamento() {
		return numApartamento;
	}

	public void setNumApartamento(Long numApartamento) {
		this.numApartamento = numApartamento;
	}


	
	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	
	public FiltroWeb getFiltroData() {
		return filtroData;
	}

	public void setFiltroDiscrepancia(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}

	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}
	}


