package com.mozart.model.ejb.entity;

import com.mozart.model.ejb.entity.MozartEntity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AdministradorCanaisEJB
 * 
 */
@Entity
@Table(name = "GDS_CANAL")
public class CanalVendaEJB extends MozartEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public CanalVendaEJB() {
		super();
	}

	@Id
	@Column(nullable = false, name = "ID_GDS_CANAL")
	private Long idGdsCanal;
	
	@Column(nullable = false, name = "ID_GDS")
	private Long idGds;
	
	@Column(nullable = false, name = "ID_EMPRESA")
	private Long idEmpresa;
	
	@Column(nullable = false, name = "ID_HOTEL")
	private Long idHotel;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ID_GDS", referencedColumnName = "ID_GDS", insertable = false, updatable = false)
	private AdministradorCanaisEJB administradorCanais;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumns({
		@JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA", insertable = false, updatable = false),
		@JoinColumn (name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false)})
	private EmpresaHotelEJB empresa;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false)
	private HotelEJB hotel;

	@Column(nullable = false, name = "CODIGO")
	private String codigo;

	@Column(nullable = false, name = "ATIVO")
	private String ativo;

	public Long getIdGdsCanal() {
		return idGdsCanal;
	}

	public void setIdGdsCanal(Long idGdsCanal) {
		this.idGdsCanal = idGdsCanal;
	}

	public AdministradorCanaisEJB getAdministradorCanais() {
		return administradorCanais;
	}

	public void setAdministradorCanais(
			AdministradorCanaisEJB administradorCanais) {
		this.administradorCanais = administradorCanais;
	}

	public EmpresaHotelEJB getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaHotelEJB empresa) {
		this.empresa = empresa;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
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
	
	

}
