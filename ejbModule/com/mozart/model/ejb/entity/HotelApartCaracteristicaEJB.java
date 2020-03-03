package com.mozart.model.ejb.entity;


import javax.persistence.*;


/**
 * The persistent class for the HOTEL_APART_CARACTERISTICAS database table.
 * 
 */
@Entity
@Table(name="HOTEL_APART_CARACTERISTICAS")
public class HotelApartCaracteristicaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqCarac")
    @SequenceGenerator(name="idSeqCarac", sequenceName="id", allocationSize=1)
	@Column(name="ID_HOTEL_APART_CARACT")
	private Long idHotelTipoApartamentoCaracteristica;
	
	@Column(name="ID_CARACTERISTICA")
	private Long idCaracteristica;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_TIPO_APARTAMENTO")
	private Long idTipoApartamento;

	private Long ordem;

    public HotelApartCaracteristicaEJB() {
    }

	public Long getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(Long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdTipoApartamento() {
		return idTipoApartamento;
	}

	public void setIdTipoApartamento(Long idTipoApartamento) {
		this.idTipoApartamento = idTipoApartamento;
	}

	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}

	public Long getIdHotelTipoApartamentoCaracteristica() {
		return idHotelTipoApartamentoCaracteristica;
	}

	public void setIdHotelTipoApartamentoCaracteristica(
			Long idHotelTipoApartamentoCaracteristica) {
		this.idHotelTipoApartamentoCaracteristica = idHotelTipoApartamentoCaracteristica;
	}


}