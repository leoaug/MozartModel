package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class GrupoEconomicoVO extends MozartVO{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 781614161320643225L;

	private FiltroWeb filtroNomeGrupo;
	private FiltroWeb filtroTipoGrupo;
	
	private Long idGrupoEconomico;
	private Long idHotel;
	private String nomeGrupo;
	private String tipoGrupo;
	private String sigla;
	
	
	

	public GrupoEconomicoVO(){
		filtroNomeGrupo = new FiltroWeb();
		filtroTipoGrupo = new FiltroWeb();
		
	}
	

	public GrupoEconomicoVO(Object[] v){
		setLinha( v );
		idGrupoEconomico = getLong();
		idHotel = getLong();
		nomeGrupo = getString();
		tipoGrupo = getString();
		sigla = getString();
	}


	public FiltroWeb getFiltroNomeGrupo() {
		return filtroNomeGrupo;
	}


	public void setFiltroNomeGrupo(FiltroWeb filtroNomeGrupo) {
		this.filtroNomeGrupo = filtroNomeGrupo;
	}


	public FiltroWeb getFiltroTipoGrupo() {
		return filtroTipoGrupo;
	}


	public void setFiltroTipoGrupo(FiltroWeb filtroTipoGrupo) {
		this.filtroTipoGrupo = filtroTipoGrupo;
	}


	public Long getIdGrupoEconomico() {
		return idGrupoEconomico;
	}


	public void setIdGrupoEconomico(Long idGrupoEconomico) {
		this.idGrupoEconomico = idGrupoEconomico;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	public String getNomeGrupo() {
		return nomeGrupo;
	}


	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}


	public String getTipoGrupo() {
		return tipoGrupo;
	}


	public void setTipoGrupo(String tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	
}
