package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the GARCON database table.
 * 
 */
@Entity
@Table(name="GARCON")
public class GarconEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;


	@Id
	@SequenceGenerator(name="IDGARCON_GENERATOR", sequenceName="id", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDGARCON_GENERATOR")
	@Column(name="ID_GARCON")
	private Long idGarcon;

	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	private String ativo;

	@Column(name="COD_GAR")
	private BigDecimal codGar;

	private BigDecimal comissao;

    private Timestamp data;

	@Column(name="NOME_GARCON")
	private String nomeGarcon;

    public GarconEJB() {
    }

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public BigDecimal getCodGar() {
		return this.codGar;
	}

	public void setCodGar(BigDecimal codGar) {
		this.codGar = codGar;
	}

	public BigDecimal getComissao() {
		return this.comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getNomeGarcon() {
		return this.nomeGarcon;
	}

	public void setNomeGarcon(String nomeGarcon) {
		this.nomeGarcon = nomeGarcon;
	}

	public Long getIdGarcon() {
		return idGarcon;
	}

	public void setIdGarcon(Long idGarcon) {
		this.idGarcon = idGarcon;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

}