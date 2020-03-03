package com.mozart.model.ejb.entity;

/**
 * The primary key class for the REPRESENTANTE_REDE database table.
 * 
 */

public class VendedorRedeEJBPK extends MozartEntity  {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Long idVendedor;

	private Long idRedeHotel;

    public VendedorRedeEJBPK() {
    }
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VendedorRedeEJBPK)) {
			return false;
		}
		VendedorRedeEJBPK castOther = (VendedorRedeEJBPK)other;
		return 
			(this.idVendedor.equals(castOther.getIdVendedor()))
			&& (this.idRedeHotel.equals(castOther.getIdRedeHotel()));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idVendedor ^ (this.idVendedor >>> 32)));
		hash = hash * prime + ((int) (this.idRedeHotel ^ (this.idRedeHotel >>> 32)));
		
		return hash;
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