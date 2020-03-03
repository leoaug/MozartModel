package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "NfeCofinsCadastroEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeCofinsCadastroEJB o"),
	@NamedQuery(name = "NfeCofinsCadastroEJB.findByHotelAndPrato", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeCofinsCadastroEJB o where o.hotel.idHotel = ?1 and o.pratoEJB.id.idPrato = ?2")
})
@Table(name = "NFE_COFINS_CADASTRO")
public class NfeCofinsCadastroEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_COFINS_CADASTRO")
	@SequenceGenerator(name="SEQ_MOVIMENTO_ESTOQUE", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_ESTOQUE")
    private Long idNfeCofinsCadastro;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_COFINS_CST", referencedColumnName = "ID_NFE_COFINS_CST")
	private NfeCofinsCstEJB nfeCofinsCst;
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO"),
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
    })
    private PratoEJB pratoEJB;
	
    @Column(name="PCOFINS")
    private Double pCofins;
    
    @Column(name="QBCPROD")
    private Double qbcProd;
    
    @Column(name="VALIQPROD")
    private Double valLiqProd;
    
    @Column(name="VCOFINS")
    private Double valCofins;
    
    public NfeCofinsCadastroEJB() {
    }

	public Long getIdNfeCofinsCadastro() {
		return idNfeCofinsCadastro;
	}

	public void setIdNfeCofinsCadastro(Long idNfeCofinsCadastro) {
		this.idNfeCofinsCadastro = idNfeCofinsCadastro;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public NfeCofinsCstEJB getNfeCofinsCst() {
		return nfeCofinsCst;
	}

	public void setNfeCofinsCst(NfeCofinsCstEJB nfeCofinsCst) {
		this.nfeCofinsCst = nfeCofinsCst;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

	public Double getpCofins() {
		return pCofins;
	}

	public void setpCofins(Double pCofins) {
		this.pCofins = pCofins;
	}

	public Double getQbcProd() {
		return qbcProd;
	}

	public void setQbcProd(Double qbcProd) {
		this.qbcProd = qbcProd;
	}

	public Double getValLiqProd() {
		return valLiqProd;
	}

	public void setValLiqProd(Double valLiqProd) {
		this.valLiqProd = valLiqProd;
	}

	public Double getValCofins() {
		return valCofins;
	}

	public void setValCofins(Double valCofins) {
		this.valCofins = valCofins;
	}

	
}
