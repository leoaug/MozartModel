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
@NamedQuery(name = "NfeMovRestPisStEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeMovRestPisStEJB o")
@Table(name = "NFE_MOVREST_PIS_ST")
public class NfeMovRestPisStEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_MOVREST_PIS_ST")
    private Long idNfeMovRestPisSt;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_MOVIMENTO_RESTAURANTE", insertable=false, updatable=false, referencedColumnName = "ID_MOVIMENTO_RESTAURANTE")
    private MovimentoRestauranteEJB movimentoRestauranteEJB;
	
    @Column(name="PPIS")
    private BigDecimal aliPis;
    
    @Column(name="QBCPROD")
    private BigDecimal qtdBcProd;
    
    @Column(name="QUNID")
    private BigDecimal qtdUnidade;
    
    @Column(name="VALIQPROD")
    private BigDecimal valAliProd;
    
    @Column(name="VPIS")
    private BigDecimal valPis;
    
    public NfeMovRestPisStEJB() {
    }

	public Long getIdNfeMovRestPisSt() {
		return idNfeMovRestPisSt;
	}

	public void setIdNfeMovRestPisSt(Long idNfeMovRestPisSt) {
		this.idNfeMovRestPisSt = idNfeMovRestPisSt;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public BigDecimal getAliPis() {
		return aliPis;
	}

	public void setAliPis(BigDecimal aliPis) {
		this.aliPis = aliPis;
	}

	public BigDecimal getQtdBcProd() {
		return qtdBcProd;
	}

	public void setQtdBcProd(BigDecimal qtdBcProd) {
		this.qtdBcProd = qtdBcProd;
	}

	public BigDecimal getQtdUnidade() {
		return qtdUnidade;
	}

	public void setQtdUnidade(BigDecimal qtdUnidade) {
		this.qtdUnidade = qtdUnidade;
	}

	public BigDecimal getValAliProd() {
		return valAliProd;
	}

	public void setValAliProd(BigDecimal valAliProd) {
		this.valAliProd = valAliProd;
	}

	public BigDecimal getValPis() {
		return valPis;
	}

	public void setValPis(BigDecimal valPis) {
		this.valPis = valPis;
	}

	public MovimentoRestauranteEJB getMovimentoRestauranteEJB() {
		return movimentoRestauranteEJB;
	}

	public void setMovimentoRestauranteEJB(
			MovimentoRestauranteEJB movimentoRestauranteEJB) {
		this.movimentoRestauranteEJB = movimentoRestauranteEJB;
	}
}
