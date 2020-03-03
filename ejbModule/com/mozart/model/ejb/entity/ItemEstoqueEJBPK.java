package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ITEM_ESTOQUE database table.
 * 
 */
@Embeddable
public class ItemEstoqueEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	
	@Column(name="ID_ITEM",insertable=false,updatable=false)
	private Long idItem;

    public ItemEstoqueEJBPK() {
    }
	public Long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public Long getIdItem() {
		return this.idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemEstoqueEJBPK)) {
			return false;
		}
		ItemEstoqueEJBPK castOther = (ItemEstoqueEJBPK)other;
		return 
			(this.idHotel.equals(castOther.idHotel))
			&& (this.idItem.equals(castOther.idItem));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idItem ^ (this.idItem >>> 32)));
		
		return hash;
    }
}