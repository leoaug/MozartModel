package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COTACAO database table.
 * 
 */
@Embeddable
public class CotacaoEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private long idHotel;

	@Column(name="ID_COTACAO")
	private long idCotacao;

	public CotacaoEJBPK() {
	}
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdCotacao() {
		return this.idCotacao;
	}
	public void setIdCotacao(long idCotacao) {
		this.idCotacao = idCotacao;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CotacaoEJBPK)) {
			return false;
		}
		CotacaoEJBPK castOther = (CotacaoEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idCotacao == castOther.idCotacao);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idCotacao ^ (this.idCotacao >>> 32)));
		
		return hash;
	}
}