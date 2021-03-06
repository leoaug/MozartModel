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
	@NamedQuery(name = "NfePisCadastroEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfePisCadastroEJB o"),
	@NamedQuery(name = "NfePisCadastroEJB.findByHotelAndPrato", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfePisCadastroEJB o where o.hotel.idHotel = ?1 and o.pratoEJB.id.idPrato = ?2")
})
@Table(name = "NFE_PIS_CADASTRO")
public class NfePisCadastroEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_PIS_CADASTRO")
	@SequenceGenerator(name="SEQ_MOVIMENTO_ESTOQUE", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_ESTOQUE")
    private Long idNfePisCadastro;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_PIS_CST", referencedColumnName = "ID_NFE_PIS_CST")
	private NfePisCstEJB nfePisCst;
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO"),
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
    })
    private PratoEJB pratoEJB;
	
    @Column(name="PPIS")
    private Double pPis;
    
    @Column(name="QBCPROD")
    private Double qbcProd;
    
    @Column(name="VALIQPROD")
    private Double valLiqProd;
    
    @Column(name="VPIS")
    private Double valPis;
    
    public NfePisCadastroEJB() {
    }

	public Long getIdNfePisCadastro() {
		return idNfePisCadastro;
	}

	public void setIdNfePisCadastro(Long idNfePisCadastro) {
		this.idNfePisCadastro = idNfePisCadastro;
	}

	public NfePisCstEJB getNfePisCst() {
		return nfePisCst;
	}

	public void setNfePisCst(NfePisCstEJB nfePisCst) {
		this.nfePisCst = nfePisCst;
	}

	public Double getpPis() {
		return pPis;
	}

	public void setpPis(Double pPis) {
		this.pPis = pPis;
	}

	public Double getValPis() {
		return valPis;
	}

	public void setValPis(Double valPis) {
		this.valPis = valPis;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
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
}
