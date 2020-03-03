package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the RAMAL_TELEFONICO database table.
 * 
 */
@Entity
@Table(name="RAMAL_TELEFONICO")
public class RamalTelefonicoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Ramal", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Ramal")
	@Column(name="ID_RAMAL_TELEFONICO")
	private Long idRamalTelefonico;

	@Column(name="ID_HOTEL")
	private Long idHotel;	

	@Column(name="ID_APARTAMENTO")
	private Long idApartamento;

	private String interno;

	private String ramal;

    public RamalTelefonicoEJB() {
    }

	
	public Long getIdApartamento() {
		return this.idApartamento;
	}

	public void setIdApartamento(Long idApartamento) {
		this.idApartamento = idApartamento;
	}

	public String getInterno() {
		return this.interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public String getRamal() {
		return this.ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdRamalTelefonico() {
		return idRamalTelefonico;
	}

	public void setIdRamalTelefonico(Long idRamalTelefonico) {
		this.idRamalTelefonico = idRamalTelefonico;
	}

}