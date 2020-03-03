package com.mozart.model.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

	@Embeddable
	public class CentralReservasRedeEJBPK implements Serializable {
		//default serial version id, required for serializable classes.
		private static final long serialVersionUID = 1L;

		@Column(name="ID_CRS")
		private long idCentralReservas;

		@Column(name="ID_REDE")
		private long idRedeHotel;
		
		  
	    public CentralReservasRedeEJBPK() {
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
			if (!(other instanceof CentralReservasRedeEJBPK)) {
				return false;
			}
			CentralReservasRedeEJBPK castOther = (CentralReservasRedeEJBPK)other;
			return 
				(this.idCentralReservas == castOther.idCentralReservas)
				&& (this.getIdRedeHotel() == castOther.getIdRedeHotel());

	    }
	    
		public int hashCode() {
			final int prime = 31;
			int hash = 17;
			hash = hash * prime + ((int) (this.idCentralReservas ^ (this.idCentralReservas >>> 32)));
			hash = hash * prime + ((int) (this.getIdRedeHotel() ^ (this.getIdRedeHotel() >>> 32)));
			
			return hash;
	    }
		public long getIdRedeHotel() {
			return idRedeHotel;
		}
		public void setIdRedeHotel(long idRedeHotel) {
			this.idRedeHotel = idRedeHotel;
		}
		
}