package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CONFIG_BLOQUETE")
public class ConfigBloqueteEJB extends MozartEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConfigBloqueteEJBPK id;
	
	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="VALOR")
	private Integer valor;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	public ConfigBloqueteEJB() {
	}

	public ConfigBloqueteEJB(ConfigBloqueteEJBPK configBloqueteEJBPK) {
		id = configBloqueteEJBPK;
	}

	public ConfigBloqueteEJBPK getId() {
		return id;
	}

	public void setId(ConfigBloqueteEJBPK id) {
		this.id = id;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
