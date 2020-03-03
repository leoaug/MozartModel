package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The primary key class for the GARCON database table.
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class GarconEJBPK extends MozartEntity {

	@Column(name="ID_HOTEL")
	private long idHotel;

	@Column(name="ID_GARCON")
	private long idGarcon;

    public GarconEJBPK() {
    }
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdGarcon() {
		return this.idGarcon;
	}
	public void setIdGarcon(long idGarcon) {
		this.idGarcon = idGarcon;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GarconEJBPK)) {
			return false;
		}
		GarconEJBPK castOther = (GarconEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idGarcon == castOther.idGarcon);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idGarcon ^ (this.idGarcon >>> 32)));
		
		return hash;
    }
}