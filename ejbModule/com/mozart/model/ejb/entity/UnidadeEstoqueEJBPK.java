package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the UNIDADE_ESTOQUE database table.
 * 
 */

public class UnidadeEstoqueEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private long idHotel;

	@Column(name="ID_UNIDADE_ESTOQUE")
	private long idUnidadeEstoque;

    public UnidadeEstoqueEJBPK() {
    }
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdUnidadeEstoque() {
		return this.idUnidadeEstoque;
	}
	public void setIdUnidadeEstoque(long idUnidadeEstoque) {
		this.idUnidadeEstoque = idUnidadeEstoque;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UnidadeEstoqueEJBPK)) {
			return false;
		}
		UnidadeEstoqueEJBPK castOther = (UnidadeEstoqueEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idUnidadeEstoque == castOther.idUnidadeEstoque);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idUnidadeEstoque ^ (this.idUnidadeEstoque >>> 32)));
		
		return hash;
    }
}