package com.mozart.model.ejb.entity;

/**
 * The primary key class for the VENDEDOR_UNIDADE database table.
 * 
 */

public class VendedorUnidadeEJBPK extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	public Long idHotel;

	public Long idVendedor;
	
	public Long idRedeHotel;

    public VendedorUnidadeEJBPK() {
    }

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VendedorUnidadeEJBPK)) {
			return false;
		}
		VendedorUnidadeEJBPK castOther = (VendedorUnidadeEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idVendedor == castOther.idVendedor)
			&& (this.idRedeHotel == castOther.idRedeHotel);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idVendedor ^ (this.idVendedor >>> 32)));
		hash = hash * prime + ((int) (this.idRedeHotel ^ (this.idRedeHotel >>> 32)));
		
		return hash;
    }

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
}