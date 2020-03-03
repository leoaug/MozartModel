package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The primary key class for the PONTO_VENDA database table.
 * 
 */
@Embeddable
public class PratoEJBPK extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_PRATO")
	@SequenceGenerator(name="PRATO_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRATO_GENERATOR")
	private Long idPrato;

    public PratoEJBPK() {
    }
	public Long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public Long getIdPrato() {
		return this.idPrato;
	}
	public void setIdPrato(Long idPrato) {
		this.idPrato = idPrato;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PratoEJBPK)) {
			return false;
		}
		PratoEJBPK castOther = (PratoEJBPK)other;
		return 
			(this.idHotel.equals(castOther.getIdHotel()))
			&& (this.idPrato.equals(castOther.getIdPrato()));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idPrato ^ (this.idPrato >>> 32)));
		
		return hash;
    }
}