package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MesaVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroNumMesa;
	private FiltroWeb filtroPontoVenda;
	

	
	private Long idMesa;
	private Long numMesa;
	private String nomeGarcon;
	private String nomePontoVenda;
	private String statusMesa;	
	private Long numPessoas;
	
	public MesaVO(){
		
		filtroNumMesa = new FiltroWeb();
		filtroPontoVenda = new FiltroWeb();		
		
		
	}	
	
	public MesaVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idMesa = getLong();
			numMesa = getLong();
			nomeGarcon = getString();
			nomePontoVenda = getString();
			statusMesa = getString();
			numPessoas = getLong();
			
		}
		
	}

	public FiltroWeb getFiltroNumMesa() {
		return filtroNumMesa;
	}

	public void setFiltroNumMesa(FiltroWeb filtroNumMesa) {
		this.filtroNumMesa = filtroNumMesa;
	}

	public FiltroWeb getFiltroPontoVenda() {
		return filtroPontoVenda;
	}

	public void setFiltroPontoVenda(FiltroWeb filtroPontoVenda) {
		this.filtroPontoVenda = filtroPontoVenda;
	}

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public Long getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(Long numMesa) {
		this.numMesa = numMesa;
	}

	public String getNomeGarcon() {
		return nomeGarcon;
	}

	public void setNomeGarcon(String nomeGarcon) {
		this.nomeGarcon = nomeGarcon;
	}

	public String getNomePontoVenda() {
		return nomePontoVenda;
	}

	public void setNomePontoVenda(String nomePontoVenda) {
		this.nomePontoVenda = nomePontoVenda;
	}

	public String getStatusMesa() {
		return statusMesa;
	}

	public void setStatusMesa(String statusMesa) {
		this.statusMesa = statusMesa;
	}

	public Long getNumPessoas() {
		return numPessoas;
	}

	public void setNumPessoas(Long numPessoas) {
		this.numPessoas = numPessoas;
	}

		
}