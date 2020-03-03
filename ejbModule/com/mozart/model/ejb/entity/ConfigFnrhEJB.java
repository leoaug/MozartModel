package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the CONFIG_FNRH database table.
 * 
 */
@Entity
@Table(name="CONFIG_FNRH")
public class ConfigFnrhEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONFIG_FNRH_IDCONFIG_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONFIG_FNRH_IDCONFIG_GENERATOR")
	@Column(name="ID_CONFIG")
	private long idConfig;

	private String descricao;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	private String titulo;

    public ConfigFnrhEJB() {
    }

	public long getIdConfig() {
		return this.idConfig;
	}

	public void setIdConfig(long idConfig) {
		this.idConfig = idConfig;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}