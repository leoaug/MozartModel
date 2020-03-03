package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeModeloEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeModeloEJB o")
@Table(name = "NFE_MODELO")
public class NfeModeloEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_MODELO")
    private Long idNfeModelo;
	
    @Column(name="MODELO")
    private String modelo;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeModeloEJB() {
    }

	public Long getIdNfeModelo() {
		return idNfeModelo;
	}

	public void setIdNfeModelo(Long idNfeModelo) {
		this.idNfeModelo = idNfeModelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
