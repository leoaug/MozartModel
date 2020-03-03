package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DuplicataStatusNotaEJBPK  extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_DUPLICATA")
	private Long idDuplicata;

	@Column(name="ID_NOTA")
	private Long idNota;


    public DuplicataStatusNotaEJBPK() {
    }

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DuplicataStatusNotaEJBPK)) {
			return false;
		}
		DuplicataStatusNotaEJBPK castOther = (DuplicataStatusNotaEJBPK)other;
		return 
			(this.idDuplicata.equals(castOther.idDuplicata))
			&& this.idNota.equals(castOther.idNota);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idDuplicata ^ (this.idDuplicata >>> 32)));
		hash = hash * prime + ((int) (this.idNota ^ (this.idNota >>> 32)));
		
		return hash;
    }

	public Long getIdDuplicata() {
		return idDuplicata;
	}

	public void setIdDuplicata(Long idDuplicata) {
		this.idDuplicata = idDuplicata;
	}

	public Long getIdNota() {
		return idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	

}
