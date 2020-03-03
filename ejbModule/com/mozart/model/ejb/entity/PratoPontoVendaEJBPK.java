package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The primary key class for the PONTO_VENDA database table.
 * 
 */
@Embeddable
public class PratoPontoVendaEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2487910498597811037L;

	@Column(name="ID_HOTEL")
	private long idHotel;

	@Column(name="ID_PONTO_VENDA")
	private long idPontoVenda;

    public PratoPontoVendaEJBPK() {
    }
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdPontoVenda() {
		return this.idPontoVenda;
	}
	public void setIdPontoVenda(long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PratoPontoVendaEJBPK)) {
			return false;
		}
		PratoPontoVendaEJBPK castOther = (PratoPontoVendaEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idPontoVenda == castOther.idPontoVenda);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idPontoVenda ^ (this.idPontoVenda >>> 32)));
		
		return hash;
    }
}