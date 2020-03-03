package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class BancoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroBanco;
	private FiltroWeb filtroNumero;
	

	
	private Long idBanco;
	private String banco;
	private String nomeFantasia;
	private Long numeroBanco;
	
	
	
	
	public BancoVO(){
		
		filtroBanco = new FiltroWeb();
		filtroNumero = new FiltroWeb();		
		
		
	}	
	
	public BancoVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
			idBanco = getLong();
			numeroBanco = getLong();
			banco = getString();
			nomeFantasia = getString();
		}
	}
	
	
	

	public FiltroWeb getFiltroBanco() {
		return filtroBanco;
	}

	public void setFiltroBanco(FiltroWeb filtroBanco) {
		this.filtroBanco = filtroBanco;
	}

	public FiltroWeb getFiltroNumero() {
		return filtroNumero;
	}

	public void setFiltroNumero(FiltroWeb filtroNumero) {
		this.filtroNumero = filtroNumero;
	}

	public Long getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}

	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Long getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(Long numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	@Override
	public String toString() {
		return numeroBanco + " - " + banco;
	}

		
}
