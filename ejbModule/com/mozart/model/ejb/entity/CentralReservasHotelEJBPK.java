package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CENTRAL_RESERVAS_HOTEL database table.
 * 
 */
@Embeddable
public class CentralReservasHotelEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_CENTRAL_RESERVAS")
	private long idCentralReservas;

	@Column(name="ID_HOTEL")
	private long idHotel;
	
	  
    public CentralReservasHotelEJBPK() {
    }
	public long getIdCentralReservas() {
		return this.idCentralReservas;
	}
	public void setIdCentralReservas(long idCentralReservas) {
		this.idCentralReservas = idCentralReservas;
	}
	

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CentralReservasHotelEJBPK)) {
			return false;
		}
		CentralReservasHotelEJBPK castOther = (CentralReservasHotelEJBPK)other;
		return 
			(this.idCentralReservas == castOther.idCentralReservas)
			&& (this.getIdHotel() == castOther.getIdHotel());

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idCentralReservas ^ (this.idCentralReservas >>> 32)));
		hash = hash * prime + ((int) (this.getIdHotel() ^ (this.getIdHotel() >>> 32)));
		
		return hash;
    }
	public long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
}