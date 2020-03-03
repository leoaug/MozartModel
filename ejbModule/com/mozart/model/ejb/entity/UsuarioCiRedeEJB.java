package com.mozart.model.ejb.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the USUARIOS_CI_REDE database table.
 * 
 */
@Entity
@Table(name="USUARIOS_CI_REDE")
public class UsuarioCiRedeEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIOS_CI", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIOS_CI")
	@Column(name="ID_USUARIOS_CI_REDE")
	private Long id;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_USUARIO_CONSUMO_INTERNO", referencedColumnName="ID_USUARIO_CONSUMO_INTERNO")
	private UsuarioConsumoInternoEJB usuarioConsumoInternoEJB;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="ID_REDE_HOTEL", name="ID_REDE_HOTEL", nullable=false)
	private RedeHotelEJB redeHotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
    public UsuarioCiRedeEJB() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public UsuarioConsumoInternoEJB getUsuarioConsumoInternoEJB() {
		return usuarioConsumoInternoEJB;
	}

	public void setUsuarioConsumoInternoEJB(
			UsuarioConsumoInternoEJB usuarioConsumoInternoEJB) {
		this.usuarioConsumoInternoEJB = usuarioConsumoInternoEJB;
	}

	public RedeHotelEJB getRedeHotel() {
		return redeHotel;
	}

	public void setRedeHotel(RedeHotelEJB redeHotel) {
		this.redeHotel = redeHotel;
	}
}