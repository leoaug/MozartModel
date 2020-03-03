package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the CENTRAL_RESERVAS_REDE database table.
 * 
 */
@Entity
@Table(name="CENTRAL_RESERVAS_REDE")
public class CentralReservasRedeEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CentralReservasRedeEJBPK id;
	
	private String ativo;

	@Column(name="CRS_PROPRIA")
	private String crsPropria;

	@ManyToOne
	@JoinColumn(name="ID_CRS", insertable=false, updatable=false)
	private CentralReservaEJB centralReserva;
	
    public CentralReservasRedeEJB() {
    }

    public boolean equals(Object obj) {
    	
    	if (obj == null){
    		return false;
    	}
    	return getId().equals( ((CentralReservasRedeEJB)obj).getId());
    }

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getCrsPropria() {
		return this.crsPropria;
	}

	public void setCrsPropria(String crsPropria) {
		this.crsPropria = crsPropria;
	}

	public CentralReservasRedeEJBPK getId() {
		return id;
	}

	public void setId(CentralReservasRedeEJBPK id) {
		this.id = id;
	}

	public CentralReservaEJB getCentralReserva() {
		return centralReserva;
	}

	public void setCentralReserva(CentralReservaEJB centralReserva) {
		this.centralReserva = centralReserva;
	}

}