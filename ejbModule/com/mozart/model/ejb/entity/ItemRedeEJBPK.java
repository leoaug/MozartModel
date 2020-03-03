package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ITEM_REDE database table.
 * 
 */
@Embeddable
public class ItemRedeEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqItem")
    @SequenceGenerator(name="idSeqItem", sequenceName="id", allocationSize=1)
	@Column(name="ID_ITEM")
	private Long idItem;

    public ItemRedeEJBPK() {
    }
	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}
	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
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
		if (!(other instanceof ItemRedeEJBPK)) {
			return false;
		}
		ItemRedeEJBPK castOther = (ItemRedeEJBPK)other;
		return 
			(this.idRedeHotel.equals(castOther.idRedeHotel))
			&& (this.idItem.equals(castOther.idItem));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idRedeHotel ^ (this.idRedeHotel >>> 32)));
		hash = hash * prime + ((int) (this.idItem ^ (this.idItem >>> 32)));
		
		return hash;
    }
}