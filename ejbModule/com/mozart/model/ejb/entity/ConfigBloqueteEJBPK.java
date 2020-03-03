package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConfigBloqueteEJBPK extends MozartEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8937909846832080415L;


	public ConfigBloqueteEJBPK()  {
	}

	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	@Column(name="ID_BANCO")
	private Long idBanco;
	
	@Column(name="CAMPO")
	private String campo;
	
	
	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idBanco == null) ? 0 : idBanco.hashCode());
		result = prime * result + ((idHotel == null) ? 0 : idHotel.hashCode());
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
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
		
		ConfigBloqueteEJBPK other = (ConfigBloqueteEJBPK) obj;
		
		if (idBanco == null) {
			if (other.getIdBanco() != null)
				return false;
		} else if (!idBanco.equals(other.getIdBanco()))
			return false;
		
		if (idHotel == null) {
			if (other.getIdHotel() != null)
				return false;
		} else if (!idHotel.equals(other.getIdHotel()))
			return false;
		
		if (campo == null) {
			if (other.getCampo() != null)
				return false;
		} else if (!campo.equalsIgnoreCase(other.getCampo()))
			return false;
		
		return true;
	}
}
