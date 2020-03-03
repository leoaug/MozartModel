package com.mozart.model.vo;

import java.io.Serializable;

public class GdsCanalVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7233933325361455354L;
	/**
	 * 
	 */
	private Long idGdsCanal;
	private Long idGds;
	private Long idHotel;
	private Long idEmpresa;
	private String codigo;
	private String ativo;
	private String disponibilidadeBloqueio;
	
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
	public Long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
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
	public String getDisponibilidadeBloqueio() {
		return disponibilidadeBloqueio;
	}
	public void setDisponibilidadeBloqueio(String disponibilidadeBloqueio) {
		this.disponibilidadeBloqueio = disponibilidadeBloqueio;
	}
}
