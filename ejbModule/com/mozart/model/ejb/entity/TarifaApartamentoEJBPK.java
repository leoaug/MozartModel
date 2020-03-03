package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TARIFA_APARTAMENTO database table.
 * 
 */
@Embeddable
public class TarifaApartamentoEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_TARIFA")
	private Long idTarifa;

	@Column(name="ID_TIPO_APARTAMENTO")
	private Long idTipoApartamento;

    public TarifaApartamentoEJBPK() {
    }
	public Long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public Long getIdTarifa() {
		return this.idTarifa;
	}
	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}
	public Long getIdTipoApartamento() {
		return this.idTipoApartamento;
	}
	public void setIdTipoApartamento(Long idTipoApartamento) {
		this.idTipoApartamento = idTipoApartamento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TarifaApartamentoEJBPK)) {
			return false;
		}
		TarifaApartamentoEJBPK castOther = (TarifaApartamentoEJBPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idTarifa == castOther.idTarifa)
			&& (this.idTipoApartamento == castOther.idTipoApartamento);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idTarifa ^ (this.idTarifa >>> 32)));
		hash = hash * prime + ((int) (this.idTipoApartamento ^ (this.idTipoApartamento >>> 32)));
		
		return hash;
    }
}