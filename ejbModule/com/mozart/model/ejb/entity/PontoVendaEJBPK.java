package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The primary key class for the PONTO_VENDA database table.
 * 
 */
@Embeddable
public class PontoVendaEJBPK extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private long idHotel;

	@SequenceGenerator(name="PDV_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PDV_GENERATOR")
	@Column(name="ID_PONTO_VENDA")
	private Long idPontoVenda;

    public PontoVendaEJBPK() {
    }
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public Long getIdPontoVenda() {
		return this.idPontoVenda;
	}
	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PontoVendaEJBPK)) {
			return false;
		}
		PontoVendaEJBPK castOther = (PontoVendaEJBPK)other;
		return 
			(this.idHotel == castOther.getIdHotel())
			&& (this.idPontoVenda.equals(castOther.getIdPontoVenda()));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idPontoVenda ^ (this.idPontoVenda >>> 32)));
		
		return hash;
    }
}