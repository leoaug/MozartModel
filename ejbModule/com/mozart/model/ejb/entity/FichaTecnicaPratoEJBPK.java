package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FICHA_TECNICA_PRATO database table.
 * 
 */
@Embeddable
public class FichaTecnicaPratoEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private long idHotel;

	@Column(name="ID_PRATO")
	private long idPrato;

	@Column(name="ID_ITEM")
	private long idItem;

    public FichaTecnicaPratoEJBPK() {
    }
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdPrato() {
		return this.idPrato;
	}
	public void setIdPrato(long idPrato) {
		this.idPrato = idPrato;
	}
	public long getIdItem() {
		return this.idItem;
	}
	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FichaTecnicaPratoEJBPK)) {
			return false;
		}
		FichaTecnicaPratoEJBPK castOther = (FichaTecnicaPratoEJBPK)other;
		return 
			(this.idHotel == castOther.getIdHotel())
			&& (this.idPrato == castOther.getIdPrato())
			&& (this.idItem == castOther.getIdItem());

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idPrato ^ (this.idPrato >>> 32)));
		hash = hash * prime + ((int) (this.idItem ^ (this.idItem >>> 32)));
		
		return hash;
    }
}