package com.mozart.model.ejb.entity;

/**
 * The primary key class for the REPRESENTANTE_UNIDADE database table.
 * 
 */

public class RepresentanteUnidadeEJBPK extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	public Long idHotel;

	public Long idRepresentante;
	
	public Long idRedeHotel;

    public RepresentanteUnidadeEJBPK() {
    }

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RepresentanteUnidadeEJBPK)) {
			return false;
		}
		RepresentanteUnidadeEJBPK castOther = (RepresentanteUnidadeEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idRepresentante == castOther.idRepresentante)
			&& (this.idRedeHotel == castOther.idRedeHotel);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idRepresentante ^ (this.idRepresentante >>> 32)));
		hash = hash * prime + ((int) (this.idRedeHotel ^ (this.idRedeHotel >>> 32)));
		
		return hash;
    }

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(Long idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}
}