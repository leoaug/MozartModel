package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class CanalVendaVO extends MozartVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7613832995583187375L;


	private FiltroWeb empresa;
	

	private Long idGdsCanal;
	private Long idGds;
	private Long idEmpresa;
	private Long idHotel;
	private String codigo;
	private String ativo;
	private String nomeFantasia;
	private String nomeAdmCanal;
	
	
	public CanalVendaVO(){
		
	}
	
	public CanalVendaVO(Object[] linha){
		setLinha( linha );
		
		idGdsCanal = getLong();
		idGds = getLong();
		idEmpresa = getLong();
		idHotel = getLong();
		codigo = getString();
		ativo = getString();
		nomeFantasia = getString();
		nomeAdmCanal = getString();
	}

	public FiltroWeb getEmpresa() {
		return empresa;
	}

	public void setEmpresa(FiltroWeb empresa) {
		this.empresa = empresa;
	}

	public Long getIdGdsCanal() {
		return idGdsCanal;
	}

	public void setIdGdsCanal(Long idGdsCanal) {
		this.idGdsCanal = idGdsCanal;
	}

	public Long getIdGds() {
		return idGds;
	}

	public void setIdGds(Long idGds) {
		this.idGds = idGds;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeAdmCanal() {
		return nomeAdmCanal;
	}

	public void setNomeAdmCanal(String nomeAdmCanal) {
		this.nomeAdmCanal = nomeAdmCanal;
	}
	
}
