package com.mozart.model.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeMovRestConfinsStEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeMovRestConfinsStEJB o")
@Table(name = "NFE_MOVREST_COFINS_ST")
public class NfeMovRestConfinsStEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_MOVREST_COFINS_ST")
    private Long idNfeMovRestCofinsSt;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_MOVIMENTO_RESTAURANTE", insertable=false, updatable=false, referencedColumnName = "ID_MOVIMENTO_RESTAURANTE")
    private MovimentoRestauranteEJB movimentoRestauranteEJB;
	
    @Column(name="PCOFINS")
    private BigDecimal percCofins;
    
    @Column(name="QBCPROD")
    private BigDecimal qtdVendidaProd;
    
    @Column(name="VALIQPROD")
    private BigDecimal valAliqProd;
    
    @Column(name="VCOFINS")
    private BigDecimal valCofins;
    
    public NfeMovRestConfinsStEJB() {
    }

	public Long getIdNfeMovRestCofinsSt() {
		return idNfeMovRestCofinsSt;
	}

	public void setIdNfeMovRestCofinsSt(Long idNfeMovRestCofinsSt) {
		this.idNfeMovRestCofinsSt = idNfeMovRestCofinsSt;
	}

	public MovimentoRestauranteEJB getMovimentoRestauranteEJB() {
		return movimentoRestauranteEJB;
	}

	public void setMovimentoRestauranteEJB(
			MovimentoRestauranteEJB movimentoRestauranteEJB) {
		this.movimentoRestauranteEJB = movimentoRestauranteEJB;
	}

	public BigDecimal getPercCofins() {
		return percCofins;
	}

	public void setPercCofins(BigDecimal percCofins) {
		this.percCofins = percCofins;
	}

	public BigDecimal getQtdVendidaProd() {
		return qtdVendidaProd;
	}

	public void setQtdVendidaProd(BigDecimal qtdVendidaProd) {
		this.qtdVendidaProd = qtdVendidaProd;
	}

	public BigDecimal getValAliqProd() {
		return valAliqProd;
	}

	public void setValAliqProd(BigDecimal valAliqProd) {
		this.valAliqProd = valAliqProd;
	}

	public BigDecimal getValCofins() {
		return valCofins;
	}

	public void setValCofins(BigDecimal valCofins) {
		this.valCofins = valCofins;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}
}
