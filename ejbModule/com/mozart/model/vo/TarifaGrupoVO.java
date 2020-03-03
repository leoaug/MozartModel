package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class TarifaGrupoVO extends MozartVO{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4670748360346255874L;

	private FiltroWeb filtroDescricao;
	
	private Long idTarifaGrupo;
	private Long idHotel;
	private String sigla;
	private String descricao;
	
	
	public TarifaGrupoVO(){
		filtroDescricao = new FiltroWeb();
	}

	
	
	public TarifaGrupoVO(Object[] v){
		setLinha(v);
		
		idTarifaGrupo = getLong();
		idHotel = getLong();
		descricao = getString();
		sigla = getString();
		
	}

	public FiltroWeb getFiltroDescricao() {
		return filtroDescricao;
	}


	public void setFiltroDescricao(FiltroWeb filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}


	public Long getIdTarifaGrupo() {
		return idTarifaGrupo;
	}


	public void setIdTarifaGrupo(Long idTarifaGrupo) {
		this.idTarifaGrupo = idTarifaGrupo;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
