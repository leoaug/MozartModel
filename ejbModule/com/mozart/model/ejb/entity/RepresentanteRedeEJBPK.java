package com.mozart.model.ejb.entity;

/**
 * The primary key class for the REPRESENTANTE_REDE database table.
 * 
 */

public class RepresentanteRedeEJBPK extends MozartEntity  {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Long idRepresentante;

	private Long idRedeHotel;

    public RepresentanteRedeEJBPK() {
    }
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RepresentanteRedeEJBPK)) {
			return false;
		}
		RepresentanteRedeEJBPK castOther = (RepresentanteRedeEJBPK)other;
		return 
			(this.idRepresentante.equals(castOther.getIdRepresentante()))
			&& (this.idRedeHotel.equals(castOther.getIdRedeHotel()));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idRepresentante ^ (this.idRepresentante >>> 32)));
		hash = hash * prime + ((int) (this.idRedeHotel ^ (this.idRedeHotel >>> 32)));
		
		return hash;
    }
	
	public Long getIdRedeHotel() {
		return idRedeHotel;
	}
	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}
	public Long getIdRepresentante() {
		return idRepresentante;
	}
	public void setIdRepresentante(Long idRepresentante) {
		this.idRepresentante = idRepresentante;
	}
}