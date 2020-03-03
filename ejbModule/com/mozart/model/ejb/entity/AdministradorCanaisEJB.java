package com.mozart.model.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AdministradorCanaisEJB
 * 
 */
@Entity
@Table(name = "GDS")
public class AdministradorCanaisEJB extends MozartEntity implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public AdministradorCanaisEJB() {
		super();
	}

	@Id
	@Column(nullable = false, name = "ID_GDS")
	private Long idGds;

	@Column(nullable = false, name = "ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(nullable = false, name = "ID_EMPRESA")
	private Long idEmpresa;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "ID_REDE_HOTEL", referencedColumnName = "ID_REDE_HOTEL", insertable = false, updatable = false) })
	private EmpresaRedeEJB empresaRedeEJB;

	@Column(nullable = false, name = "CODIGO")
	private String Codigo;

	@Column(nullable = false, name = "ATIVO")
	private String ativo;

	@Column(nullable = false, name = "COMISSAO")
	private Double comissao;

	@Column(nullable = false, name = "FEE_RESERVA")
	private Double feeReserva;

	@Column(nullable = false, name = "FEE_MENSAL")
	private Double feeMensal;

	@Column(nullable = false, name = "DISPONIBILIDADE_BLOQUEIO")
	private String disponibilidadeBloqueio;

	public Long getIdGds() {
		return idGds;
	}

	public void setIdGds(Long idGds) {
		this.idGds = idGds;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Double getFeeReserva() {
		return feeReserva;
	}

	public void setFeeReserva(Double feeReserva) {
		this.feeReserva = feeReserva;
	}

	public Double getFeeMensal() {
		return feeMensal;
	}

	public void setFeeMensal(Double feeMensal) {
		this.feeMensal = feeMensal;
	}

	public EmpresaRedeEJB getEmpresaRedeEJB() {
		return empresaRedeEJB;
	}

	public void setEmpresaRedeEJB(EmpresaRedeEJB empresaRedeEJB) {
		this.empresaRedeEJB = empresaRedeEJB;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDisponibilidadeBloqueio() {
		return disponibilidadeBloqueio;
	}

	public void setDisponibilidadeBloqueio(String disponibilidadeBloqueio) {
		this.disponibilidadeBloqueio = disponibilidadeBloqueio;
	}

}
