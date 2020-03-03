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
	@NamedQuery(name = "NfeIcmsCadastroEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIcmsCadastroEJB o"),
	@NamedQuery(name = "NfeIcmsCadastroEJB.findByHotelAndPrato", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIcmsCadastroEJB o where o.hotel.idHotel = ?1 and o.pratoEJB.id.idPrato = ?2")
})

@Table(name = "NFE_ICMS_CADASTRO")
public class NfeIcmsCadastroEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_ICMS_CADASTRO")
	@SequenceGenerator(name="SEQ_MOVIMENTO_ESTOQUE", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_ESTOQUE")
    private Long idNfeIcmsCadastro;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_CST", referencedColumnName = "ID_NFE_ICMS_CST")
    private NfeIcmsCstEJB nfeIcmsCst;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_MOD_BC_ICMS", referencedColumnName = "ID_NFE_ICMS_MOD_BC_ICMS")
    private NfeIcmsModBcIcmsEJB nfeIcmsModBcIcms;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_MOD_BC_ICMSST", referencedColumnName = "ID_NFE_ICMS_MOD_BC_ICMSST")
    private NfeIcmsModBcIcmsStEJB nfeIcmsModBcIcmsSt;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_MOTIVO_DESONERACAO", referencedColumnName = "ID_NFE_ICMS_MOTIVO_DESONERACAO")
    private NfeIcmsMotivoDesoneracaoEJB nfeIcmsMotivoDesoneracao;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_ORIGEM_MERCADORIA", referencedColumnName = "ID_NFE_ICMS_ORIGEM_MERCADORIA")
    private NfeIcmsOrigemMercadoriaEJB nfeIcmsOrigemMercadoria;
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO"),
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
    })
    private PratoEJB pratoEJB;
	
    @Column(name="PBCOP")
    private Double percOperacao;
    
    @Column(name="PCREDSN")
    private Double percCreditoSimplesNacional;
    
    @Column(name="PDIF")
    private Double percDiferimento;
    
    @Column(name="PICMSST")
    private Double percIcmsSt;
    
    @Column(name="PMVAST")
    private Double percMargemValAdicional;
    
    @Column(name="PREDBC")
    private Double percReducaoBc;
    
    @Column(name="PREDBCST")
    private Double percReducaoBcSt;
    
    @Column(name="UFST")
    private String ufSt;
    
    @Column(name="VBCSTDEST")
    private Double valBcStDest;
    
    @Column(name="VBCSTRET")
    private Double valBcStRet;

    @Column(name="VBCSTRETUF")
    private Double valBcStRetuf;
    
    @Column(name="VICMSDESON")
    private Double valIcmsDeson;
    
    @Column(name="VICMSOP")
    private Double valIcmsOperacao;

    @Column(name="VICMSSTDEST")
    private Double valIcmsStDest;
    
    @Column(name="VICMSSTRET")
    private Double valIcmsStRet;
    
    @Column(name="VICMSSTRETUF")
    private Double valIcmsStRetuf;
    
    public NfeIcmsCadastroEJB() {
    }
    
	public Long getIdNfeIcmsCadastro() {
		return idNfeIcmsCadastro;
	}

	public void setIdNfeIcmsCadastro(Long idNfeIcmsCadastro) {
		this.idNfeIcmsCadastro = idNfeIcmsCadastro;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

	public Double getValBcStRetuf() {
		return valBcStRetuf;
	}

	public void setValBcStRetuf(Double valBcStRetuf) {
		this.valBcStRetuf = valBcStRetuf;
	}

	public Double getValIcmsStRetuf() {
		return valIcmsStRetuf;
	}

	public void setValIcmsStRetuf(Double valIcmsStRetuf) {
		this.valIcmsStRetuf = valIcmsStRetuf;
	}

	public NfeIcmsCstEJB getNfeIcmsCst() {
		return nfeIcmsCst;
	}

	public void setNfeIcmsCst(NfeIcmsCstEJB nfeIcmsCst) {
		this.nfeIcmsCst = nfeIcmsCst;
	}

	public NfeIcmsModBcIcmsEJB getNfeIcmsModBcIcms() {
		return nfeIcmsModBcIcms;
	}

	public void setNfeIcmsModBcIcms(NfeIcmsModBcIcmsEJB nfeIcmsModBcIcms) {
		this.nfeIcmsModBcIcms = nfeIcmsModBcIcms;
	}

	public NfeIcmsModBcIcmsStEJB getNfeIcmsModBcIcmsSt() {
		return nfeIcmsModBcIcmsSt;
	}

	public void setNfeIcmsModBcIcmsSt(NfeIcmsModBcIcmsStEJB nfeIcmsModBcIcmsSt) {
		this.nfeIcmsModBcIcmsSt = nfeIcmsModBcIcmsSt;
	}

	public NfeIcmsMotivoDesoneracaoEJB getNfeIcmsMotivoDesoneracao() {
		return nfeIcmsMotivoDesoneracao;
	}

	public void setNfeIcmsMotivoDesoneracao(
			NfeIcmsMotivoDesoneracaoEJB nfeIcmsMotivoDesoneracao) {
		this.nfeIcmsMotivoDesoneracao = nfeIcmsMotivoDesoneracao;
	}

	public NfeIcmsOrigemMercadoriaEJB getNfeIcmsOrigemMercadoria() {
		return nfeIcmsOrigemMercadoria;
	}

	public void setNfeIcmsOrigemMercadoria(
			NfeIcmsOrigemMercadoriaEJB nfeIcmsOrigemMercadoria) {
		this.nfeIcmsOrigemMercadoria = nfeIcmsOrigemMercadoria;
	}

	public Double getPercOperacao() {
		return percOperacao;
	}

	public void setPercOperacao(Double percOperacao) {
		this.percOperacao = percOperacao;
	}

	public Double getPercCreditoSimplesNacional() {
		return percCreditoSimplesNacional;
	}

	public void setPercCreditoSimplesNacional(Double percCreditoSimplesNacional) {
		this.percCreditoSimplesNacional = percCreditoSimplesNacional;
	}

	public Double getPercDiferimento() {
		return percDiferimento;
	}

	public void setPercDiferimento(Double percDiferimento) {
		this.percDiferimento = percDiferimento;
	}

	public Double getPercIcmsSt() {
		return percIcmsSt;
	}

	public void setPercIcmsSt(Double percIcmsSt) {
		this.percIcmsSt = percIcmsSt;
	}

	public Double getPercMargemValAdicional() {
		return percMargemValAdicional;
	}

	public void setPercMargemValAdicional(Double percMargemValAdicional) {
		this.percMargemValAdicional = percMargemValAdicional;
	}

	public Double getPercReducaoBc() {
		return percReducaoBc;
	}

	public void setPercReducaoBc(Double percReducaoBc) {
		this.percReducaoBc = percReducaoBc;
	}

	public Double getPercReducaoBcSt() {
		return percReducaoBcSt;
	}

	public void setPercReducaoBcSt(Double percReducaoBcSt) {
		this.percReducaoBcSt = percReducaoBcSt;
	}

	public String getUfSt() {
		return ufSt;
	}

	public void setUfSt(String ufSt) {
		this.ufSt = ufSt;
	}

	public Double getValBcStDest() {
		return valBcStDest;
	}

	public void setValBcStDest(Double valBcStDest) {
		this.valBcStDest = valBcStDest;
	}

	public Double getValBcStRet() {
		return valBcStRet;
	}

	public void setValBcStRet(Double valBcStRet) {
		this.valBcStRet = valBcStRet;
	}

	public Double getValIcmsDeson() {
		return valIcmsDeson;
	}

	public void setValIcmsDeson(Double valIcmsDeson) {
		this.valIcmsDeson = valIcmsDeson;
	}

	public Double getValIcmsOperacao() {
		return valIcmsOperacao;
	}

	public void setValIcmsOperacao(Double valIcmsOperacao) {
		this.valIcmsOperacao = valIcmsOperacao;
	}

	public Double getValIcmsStDest() {
		return valIcmsStDest;
	}

	public void setValIcmsStDest(Double valIcmsStDest) {
		this.valIcmsStDest = valIcmsStDest;
	}

	public Double getValIcmsStRet() {
		return valIcmsStRet;
	}

	public void setValIcmsStRet(Double valIcmsStRet) {
		this.valIcmsStRet = valIcmsStRet;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}
}
