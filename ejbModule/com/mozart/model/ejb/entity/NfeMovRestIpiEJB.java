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
@NamedQuery(name = "NfeMovRestIpiEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeMovRestIpiEJB o")
@Table(name = "NFE_MOVREST_IPI")
public class NfeMovRestIpiEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_MOVREST_IPI")
    private Long idNfeMovRestIpi;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_MOVIMENTO_RESTAURANTE", insertable=false, updatable=false, referencedColumnName = "ID_MOVIMENTO_RESTAURANTE")
    private MovimentoRestauranteEJB movimentoRestauranteEJB;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_IPI_CST", insertable=false, updatable=false, referencedColumnName = "ID_NFE_IPI_CST")
    private NfeIpiCstEJB nfeIpiCst;
	
    @Column(name="PIPI")
    private BigDecimal aliIpi;
    
    @Column(name="QSELO")
    private BigDecimal qtdSelo;
    
    @Column(name="QUNID")
    private BigDecimal qtdUnidade;
    
    @Column(name="VIPI")
    private BigDecimal valIpi;
    
    @Column(name="VUNID")
    private BigDecimal valUnidade;
    
    public NfeMovRestIpiEJB() {
    }

	public Long getIdNfeMovRestIpi() {
		return idNfeMovRestIpi;
	}

	public void setIdNfeMovRestIpi(Long idNfeMovRestIpi) {
		this.idNfeMovRestIpi = idNfeMovRestIpi;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public NfeIpiCstEJB getNfeIpiCst() {
		return nfeIpiCst;
	}

	public void setNfeIpiCst(NfeIpiCstEJB nfeIpiCst) {
		this.nfeIpiCst = nfeIpiCst;
	}

	public BigDecimal getAliIpi() {
		return aliIpi;
	}

	public void setAliIpi(BigDecimal aliIpi) {
		this.aliIpi = aliIpi;
	}

	public BigDecimal getQtdSelo() {
		return qtdSelo;
	}

	public void setQtdSelo(BigDecimal qtdSelo) {
		this.qtdSelo = qtdSelo;
	}

	public BigDecimal getQtdUnidade() {
		return qtdUnidade;
	}

	public void setQtdUnidade(BigDecimal qtdUnidade) {
		this.qtdUnidade = qtdUnidade;
	}

	public BigDecimal getValIpi() {
		return valIpi;
	}

	public void setValIpi(BigDecimal valIpi) {
		this.valIpi = valIpi;
	}

	public BigDecimal getValUnidade() {
		return valUnidade;
	}

	public void setValUnidade(BigDecimal valUnidade) {
		this.valUnidade = valUnidade;
	}

	public MovimentoRestauranteEJB getMovimentoRestauranteEJB() {
		return movimentoRestauranteEJB;
	}

	public void setMovimentoRestauranteEJB(
			MovimentoRestauranteEJB movimentoRestauranteEJB) {
		this.movimentoRestauranteEJB = movimentoRestauranteEJB;
	}
}
