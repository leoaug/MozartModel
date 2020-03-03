package com.mozart.model.ejb.entity;

import java.io.Serializable;



public class DemonstrativoPlanoContasEJBPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4677700399358416919L;

	//default serial version id, required for serializable classes.

	
	
	private long idPlanoContas;

	private long idRedeHotel;
	
	  
    public DemonstrativoPlanoContasEJBPK() {
    	
    }
	
	

	public long getIdPlanoContas() {
		return idPlanoContas;
	}



	public void setIdPlanoContas(long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}



	public long getIdRedeHotel() {
		return idRedeHotel;
	}



	public void setIdRedeHotel(long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}



	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DemonstrativoPlanoContasEJBPK)) {
			return false;
		}
		DemonstrativoPlanoContasEJBPK castOther = (DemonstrativoPlanoContasEJBPK)other;
		return 
			(this.idPlanoContas == castOther.idPlanoContas)
			&& (this.getIdRedeHotel() == castOther.getIdRedeHotel());

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.getIdPlanoContas() ^ (this.idPlanoContas >>> 32)));
		hash = hash * prime + ((int) (this.getIdRedeHotel() ^ (this.getIdRedeHotel() >>> 32)));
		
		return hash;
    }
}