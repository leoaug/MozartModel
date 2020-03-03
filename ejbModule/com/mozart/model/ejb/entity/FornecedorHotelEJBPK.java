package com.mozart.model.ejb.entity;

/**
 * The primary key class for the FORNECEDOR_HOTEL database table.
 * 
 */

public class FornecedorHotelEJBPK extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	public Long idHotel;

	public Long idFornecedor;

    public FornecedorHotelEJBPK() {
    }

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FornecedorHotelEJBPK)) {
			return false;
		}
		FornecedorHotelEJBPK castOther = (FornecedorHotelEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idFornecedor == castOther.idFornecedor);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idFornecedor ^ (this.idFornecedor >>> 32)));
		
		return hash;
    }

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
}