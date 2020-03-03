package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the CONFIG_NOTA database table.
 * 
 */
@Entity
@Table(name="CONFIG_NOTA")
public class ConfigNotaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConfigNotaEJBPK id;

	private Long coluna;

	private Long linha;

    public ConfigNotaEJB() {
    }

    public ConfigNotaEJB(String campo, Long idHotel, Long linha, Long coluna) {
    	id = new ConfigNotaEJBPK();
    	id.setCampo( campo );
    	id.setIdHotel( idHotel );
    	this.linha = linha;
    	this.coluna = coluna;
    }

	public ConfigNotaEJBPK getId() {
		return this.id;
	}

	public void setId(ConfigNotaEJBPK id) {
		this.id = id;
	}
	
	public Long getColuna() {
		return this.coluna;
	}

	public void setColuna(Long coluna) {
		this.coluna = coluna;
	}

	public Long getLinha() {
		return this.linha;
	}

	public void setLinha(Long linha) {
		this.linha = linha;
	}

}