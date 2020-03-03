package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class CidadeVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroCidade;
	private FiltroWeb filtroEstado;
	

	
	private Long idCidade;
	private String cidade;
	private String estado;
	private String uf;
	private String pais;
	private String continente;
	private String ddd;
	private String ddi;
	
	
	
	public CidadeVO(){
		
		filtroCidade = new FiltroWeb();
		filtroEstado = new FiltroWeb();		
		
		
	}	
	
	public CidadeVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idCidade = getLong();
			cidade = getString();
			estado = getString();
			uf = getString();
			pais = getString();
			continente = getString();
			ddd = getString();
			ddi = getString();
			
		
		}
		
	}

	public FiltroWeb getFiltroCidade() {
		return filtroCidade;
	}

	public void setFiltroCidade(FiltroWeb filtroCidade) {
		this.filtroCidade = filtroCidade;
	}

	public FiltroWeb getFiltroEstado() {
		return filtroEstado;
	}

	public void setFiltroEstado(FiltroWeb filtroEstado) {
		this.filtroEstado = filtroEstado;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

}
