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
	@NamedQuery(name = "NfeIpiCadastroEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIpiCadastroEJB o"),
	@NamedQuery(name = "NfeIpiCadastroEJB.findByHotelAndPrato", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIpiCadastroEJB o where o.hotel.idHotel = ?1 and o.pratoEJB.id.idPrato = ?2")
})
@Table(name = "NFE_IPI_CADASTRO")
public class NfeIpiCadastroEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_IPI_CADASTRO")
	@SequenceGenerator(name="SEQ_MOVIMENTO_ESTOQUE", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_ESTOQUE")
    private Long idNfeIpiCadastro;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_IPI_CST", referencedColumnName = "ID_NFE_IPI_CST")
	private NfeIpiCstEJB nfeIpiCst;
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO"),
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
    })
    private PratoEJB pratoEJB;
	
	@Column(name="CENQ")
    private String codEnquandramento;
	
	@Column(name="CLENQ")
    private String classeEnquandramento;
	
	@Column(name="CNPJPROD")
    private Long cnpjProduto;
	
	@Column(name="CSELO")
    private String codSelo;
	
    @Column(name="PIPI")
    private Double aliIpi;
    
    @Column(name="QSELO")
    private Double qtdSelo;
    
    @Column(name="QUNID")
    private Double qtdUnidade;
    
    @Column(name="VIPI")
    private Double valIpi;
    
    @Column(name="VUNID")
    private Double valUnidade;
    
    public NfeIpiCadastroEJB() {
    }

	public Long getIdNfeIpiCadastro() {
		return idNfeIpiCadastro;
	}

	public void setIdNfeIpiCadastro(Long idNfeIpiCadastro) {
		this.idNfeIpiCadastro = idNfeIpiCadastro;
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

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

	public String getCodEnquandramento() {
		return codEnquandramento;
	}

	public void setCodEnquandramento(String codEnquandramento) {
		this.codEnquandramento = codEnquandramento;
	}

	public String getClasseEnquandramento() {
		return classeEnquandramento;
	}

	public void setClasseEnquandramento(String classeEnquandramento) {
		this.classeEnquandramento = classeEnquandramento;
	}

	public Long getCnpjProduto() {
		return cnpjProduto;
	}

	public void setCnpjProduto(Long cnpjProduto) {
		this.cnpjProduto = cnpjProduto;
	}

	public String getCodSelo() {
		return codSelo;
	}

	public void setCodSelo(String codSelo) {
		this.codSelo = codSelo;
	}

	public Double getAliIpi() {
		return aliIpi;
	}

	public void setAliIpi(Double aliIpi) {
		this.aliIpi = aliIpi;
	}

	public Double getQtdSelo() {
		return qtdSelo;
	}

	public void setQtdSelo(Double qtdSelo) {
		this.qtdSelo = qtdSelo;
	}

	public Double getQtdUnidade() {
		return qtdUnidade;
	}

	public void setQtdUnidade(Double qtdUnidade) {
		this.qtdUnidade = qtdUnidade;
	}

	public Double getValIpi() {
		return valIpi;
	}

	public void setValIpi(Double valIpi) {
		this.valIpi = valIpi;
	}

	public Double getValUnidade() {
		return valUnidade;
	}

	public void setValUnidade(Double valUnidade) {
		this.valUnidade = valUnidade;
	}
    
}
