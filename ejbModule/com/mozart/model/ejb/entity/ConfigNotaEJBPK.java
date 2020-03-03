package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The primary key class for the CONFIG_NOTA database table.
 * 
 */
@Embeddable
public class ConfigNotaEJBPK extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	private String campo;

    public ConfigNotaEJBPK() {
    }
	public Long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public String getCampo() {
		return this.campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConfigNotaEJBPK)) {
			return false;
		}
		ConfigNotaEJBPK castOther = (ConfigNotaEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& this.campo.equals(castOther.campo);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + this.campo.hashCode();
		
		return hash;
    }
}