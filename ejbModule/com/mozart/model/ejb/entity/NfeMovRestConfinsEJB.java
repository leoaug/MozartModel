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
@NamedQuery(name = "NfeMovRestConfinsEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeMovRestConfinsEJB o")
@Table(name = "NFE_MOVREST_COFINS")
public class NfeMovRestConfinsEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_MOVREST_COFINS")
    private Long idNfeMovRestCofins;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_MOVIMENTO_RESTAURANTE", insertable=false, updatable=false, referencedColumnName = "ID_MOVIMENTO_RESTAURANTE")
    private MovimentoRestauranteEJB movimentoRestauranteEJB;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_COFINS_CST", insertable=false, updatable=false, referencedColumnName = "ID_NFE_COFINS_CST")
    private NfeCofinsCstEJB nfeCofinsCstEJB;
	
    @Column(name="PCOFINS")
    private BigDecimal percCofins;
    
    @Column(name="QBCPROD")
    private BigDecimal qtdVendidaProd;
    
    @Column(name="VALIQPROD")
    private BigDecimal valAliqProd;
    
    @Column(name="VCOFINS")
    private BigDecimal valCofins;
    
    public NfeMovRestConfinsEJB() {
    }

	public Long getIdNfeMovRestCofins() {
		return idNfeMovRestCofins;
	}

	public void setIdNfeMovRestCofins(Long idNfeMovRestCofins) {
		this.idNfeMovRestCofins = idNfeMovRestCofins;
	}

	public MovimentoRestauranteEJB getMovimentoRestauranteEJB() {
		return movimentoRestauranteEJB;
	}

	public void setMovimentoRestauranteEJB(
			MovimentoRestauranteEJB movimentoRestauranteEJB) {
		this.movimentoRestauranteEJB = movimentoRestauranteEJB;
	}

	public NfeCofinsCstEJB getNfeCofinsCstEJB() {
		return nfeCofinsCstEJB;
	}

	public void setNfeCofinsCstEJB(NfeCofinsCstEJB nfeCofinsCstEJB) {
		this.nfeCofinsCstEJB = nfeCofinsCstEJB;
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
