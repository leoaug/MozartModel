package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the CENTRAL_RESERVAS_HOTEL database table.
 * 
 */
@Entity
@Table(name="CENTRAL_RESERVAS_HOTEL")
public class CentralReservasHotelEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CentralReservasHotelEJBPK id;

	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_HOTEL", insertable=false, updatable=false)
	private HotelEJB hotelEJB;
	
	private String ativo;

	private String comissao;

	@Column(name="CUSTO_LINK")
	private BigDecimal custoLink;

	@Column(name="FEE_MENSAL")
	private BigDecimal feeMensal;

	@Column(name="FEE_RESERVA")
	private BigDecimal feeReserva;

	//bi-directional many-to-one association to CentralReservaEJB
    @ManyToOne
	@JoinColumn(name="ID_CENTRAL_RESERVAS", insertable=false, updatable=false)
	private CentralReservaEJB centralReserva;

    public CentralReservasHotelEJB() {
    }

	public CentralReservasHotelEJBPK getId() {
		return this.id;
	}

	public void setId(CentralReservasHotelEJBPK id) {
		this.id = id;
	}
	
	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getComissao() {
		return this.comissao;
	}

	public void setComissao(String comissao) {
		this.comissao = comissao;
	}

	public BigDecimal getCustoLink() {
		return this.custoLink;
	}

	public void setCustoLink(BigDecimal custoLink) {
		this.custoLink = custoLink;
	}

	public BigDecimal getFeeMensal() {
		return this.feeMensal;
	}

	public void setFeeMensal(BigDecimal feeMensal) {
		this.feeMensal = feeMensal;
	}

	public BigDecimal getFeeReserva() {
		return this.feeReserva;
	}

	public void setFeeReserva(BigDecimal feeReserva) {
		this.feeReserva = feeReserva;
	}

	public CentralReservaEJB getCentralReserva() {
		return this.centralReserva;
	}

	public void setCentralReserva(CentralReservaEJB centralReserva) {
		this.centralReserva = centralReserva;
	}

	public HotelEJB getHotelEJB() {
		return hotelEJB;
	}

	public void setHotelEJB(HotelEJB hotelEJB) {
		this.hotelEJB = hotelEJB;
	}
	
}