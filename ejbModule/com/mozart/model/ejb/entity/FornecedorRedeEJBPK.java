package com.mozart.model.ejb.entity;

/**
 * The primary key class for the FORNECEDOR_REDE database table.
 * 
 */

public class FornecedorRedeEJBPK extends MozartEntity  {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private Long idFornecedor;

	private Long idRedeHotel;

    public FornecedorRedeEJBPK() {
    }
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FornecedorRedeEJBPK)) {
			return false;
		}
		FornecedorRedeEJBPK castOther = (FornecedorRedeEJBPK)other;
		return 
			(this.idFornecedor.equals(castOther.getIdFornecedor()))
			&& (this.idRedeHotel.equals(castOther.getIdRedeHotel()));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idFornecedor ^ (this.idFornecedor >>> 32)));
		hash = hash * prime + ((int) (this.idRedeHotel ^ (this.idRedeHotel >>> 32)));
		
		return hash;
    }
	public Long getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public Long getIdRedeHotel() {
		return idRedeHotel;
	}
	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}
}