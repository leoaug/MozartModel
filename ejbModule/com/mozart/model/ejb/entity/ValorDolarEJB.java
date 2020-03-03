package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.*;




/**
 * The persistent class for the VALOR_DOLAR database table.
 * 
 */
@Entity
@Table(name="VALOR_DOLAR")
public class ValorDolarEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqValorDolar")
    @SequenceGenerator(name="idSeqValorDolar", sequenceName="id", allocationSize=1)
	@Column(name="ID_VALOR_DOLAR")
	private Long idValorDolar;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="ID_HOTEL")
	private Long idHotel;

    
	private Timestamp data;

	@Column(name="ID_MOEDA")
	private Long idMoeda;

	@Column(name="VALOR_DOLAR")
	private Double valorDolar;

    public ValorDolarEJB() {
    }

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}


	public Double getValorDolar() {
		return this.valorDolar;
	}

	public void setValorDolar(Double valorDolar) {
		this.valorDolar = valorDolar;
	}

	public Long getIdValorDolar() {
		return idValorDolar;
	}

	public void setIdValorDolar(Long idValorDolar) {
		this.idValorDolar = idValorDolar;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdMoeda() {
		return idMoeda;
	}

	public void setIdMoeda(Long idMoeda) {
		this.idMoeda = idMoeda;
	}

}