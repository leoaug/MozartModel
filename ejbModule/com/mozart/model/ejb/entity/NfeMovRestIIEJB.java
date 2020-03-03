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
@NamedQuery(name = "NfeMovRestIIEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeMovRestIIEJB o")
@Table(name = "NFE_MOVREST_II")
public class NfeMovRestIIEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_MOVREST_II")
    private Long idNfeMovRestII;
	
	@ManyToOne
	@JoinColumn(name = "ID_MOVIMENTO_RESTAURANTE", insertable=false, updatable=false, referencedColumnName = "ID_MOVIMENTO_RESTAURANTE")
    private MovimentoRestauranteEJB movimentoRestauranteEJB;
	
    @Column(name="VDESPADU")
    private BigDecimal valDespAdu;
    
    @Column(name="VII")
    private BigDecimal valII;
    
    @Column(name="VIOF")
    private BigDecimal valIof;
    
    public NfeMovRestIIEJB() {
    }

	public Long getIdNfeMovRestII() {
		return idNfeMovRestII;
	}

	public void setIdNfeMovRestII(Long idNfeMovRestII) {
		this.idNfeMovRestII = idNfeMovRestII;
	}

	public BigDecimal getValDespAdu() {
		return valDespAdu;
	}

	public void setValDespAdu(BigDecimal valDespAdu) {
		this.valDespAdu = valDespAdu;
	}

	public BigDecimal getValII() {
		return valII;
	}

	public void setValII(BigDecimal valII) {
		this.valII = valII;
	}

	public BigDecimal getValIof() {
		return valIof;
	}

	public void setValIof(BigDecimal valIof) {
		this.valIof = valIof;
	}

	public MovimentoRestauranteEJB getMovimentoRestauranteEJB() {
		return movimentoRestauranteEJB;
	}

	public void setMovimentoRestauranteEJB(
			MovimentoRestauranteEJB movimentoRestauranteEJB) {
		this.movimentoRestauranteEJB = movimentoRestauranteEJB;
	}
}
