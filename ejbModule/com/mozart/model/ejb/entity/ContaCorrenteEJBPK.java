package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContaCorrenteEJBPK extends MozartEntity {

	/**
	 * TODO: (ID) Eliminar - não será mais necessária
	 */
	private static final long serialVersionUID = -3277979490485282615L;
	@Column(name="CONTA_CORRENTE")
	private Long contaCorrente;
	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	public ContaCorrenteEJBPK(){
		
	}

	public Long getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contaCorrente == null) ? 0 : contaCorrente.hashCode());
		result = prime * result + ((idHotel == null) ? 0 : idHotel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrenteEJBPK other = (ContaCorrenteEJBPK) obj;
		if (contaCorrente == null) {
			if (other.getContaCorrente() != null)
				return false;
		} else if (!contaCorrente.equals(other.getContaCorrente()))
			return false;
		if (idHotel == null) {
			if (other.getIdHotel() != null)
				return false;
		} else if (!idHotel.equals(other.getIdHotel()))
			return false;
		return true;
	}

}
