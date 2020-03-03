package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class RamalVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8107731349199012759L;

	
	private FiltroWeb filtroRamal;
	private FiltroWeb filtroApartamento;
	
	private Long idRamal;
	private String ramal;
	private Long numApartamento;
	private String interno;
	
	public RamalVO(){
		
		filtroRamal = new FiltroWeb();
		filtroApartamento = new FiltroWeb();
		
	}

	public RamalVO(Object[] linha) {
		
		if (!MozartUtil.isNull(linha)){
			setLinha(linha);
			idRamal = getLong();
			ramal  = getString();
			numApartamento = getLong();
			interno = getString();
		}
	}

	public Long getIdRamal() {
		return idRamal;
	}

	public void setIdRamal(Long idRamal) {
		this.idRamal = idRamal;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public Long getNumApartamento() {
		return numApartamento;
	}

	public void setNumApartamento(Long numApartamento) {
		this.numApartamento = numApartamento;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public FiltroWeb getFiltroRamal() {
		return filtroRamal;
	}

	public void setFiltroRamal(FiltroWeb filtroRamal) {
		this.filtroRamal = filtroRamal;
	}

	public FiltroWeb getFiltroApartamento() {
		return filtroApartamento;
	}

	public void setFiltroApartamento(FiltroWeb filtroApartamento) {
		this.filtroApartamento = filtroApartamento;
	}
	
	
	
}
