package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class AdministradorCanaisVO extends MozartVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3767517557716107125L;

	private FiltroWeb empresa;

	private Long idGds;
	private Long idEmpresa;
	private Long idRedeHotel;
	private String codigo;
	private String ativo;
	private Double comissao;
	private Double feeReserva;
	private Double feeMensal;
	private String nomeFantasia;
	private String disponibilidadeBloqueio;

	public AdministradorCanaisVO() {
	}

	public AdministradorCanaisVO(Object[] l) {
		setLinha(l);

		idGds = getLong();
		idEmpresa = getLong();
		idRedeHotel = getLong();
		codigo = getString();
		ativo = getString();
		comissao = getDouble();
		feeReserva = getDouble();
		feeMensal = getDouble();
		nomeFantasia = getString();
		disponibilidadeBloqueio = getString();
	}

	public FiltroWeb getEmpresa() {
		return empresa;
	}

	public void setEmpresa(FiltroWeb empresa) {
		this.empresa = empresa;
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

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getDisponibilidadeBloqueio() {
		return disponibilidadeBloqueio;
	}

	public void setDisponibilidadeBloqueio(String disponibilidadeBloqueio) {
		this.disponibilidadeBloqueio = disponibilidadeBloqueio;
	}

}
