package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;


public class MoedaVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private String nomeMoeda;
	private String sigla;
	private String simbolo;
	private Long idMoeda;
	
	public MoedaVO(){
		
		
				
	}

	public MoedaVO(Object[] linha) {
		
		if (!MozartUtil.isNull(linha)){
			setLinha(linha);
			idMoeda = getLong ();
			nomeMoeda = getString();
			sigla = getString ();
			simbolo = getString();
					
		
		}
	}

	public String getNomeMoeda() {
		return nomeMoeda;
	}

	public void setNomeMoeda(String nomeMoeda) {
		this.nomeMoeda = nomeMoeda;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Long getIdMoeda() {
		return idMoeda;
	}

	public void setIdMoeda(Long idMoeda) {
		this.idMoeda = idMoeda;
	}

}	



