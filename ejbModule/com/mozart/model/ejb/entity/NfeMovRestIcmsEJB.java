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
@NamedQuery(name = "NfeMovRestIcmsEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeMovRestIcmsEJB o")
@Table(name = "NFE_MOVREST_ICMS")
public class NfeMovRestIcmsEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_MOVREST_ICMS")
    private Long idNfeMovRestIcms;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumn(name = "ID_MOVIMENTO_RESTAURANTE", insertable=false, updatable=false, referencedColumnName = "ID_MOVIMENTO_RESTAURANTE")
    private MovimentoRestauranteEJB movimentoRestaurante;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_CST", insertable=false, updatable=false, referencedColumnName = "ID_NFE_ICMS_CST")
    private NfeIcmsCstEJB nfeIcmsCst;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_MOD_BC_ICMS", insertable=false, updatable=false, referencedColumnName = "ID_NFE_ICMS_MOD_BC_ICMS")
    private NfeIcmsModBcIcmsEJB nfeIcmsModBcIcms;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_MOD_BC_ICMSST", insertable=false, updatable=false, referencedColumnName = "ID_NFE_ICMS_MOD_BC_ICMSST")
    private NfeIcmsModBcIcmsStEJB nfeIcmsModBcIcmsSt;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_MOTIVO_DESONERACAO", insertable=false, updatable=false, referencedColumnName = "ID_NFE_ICMS_MOTIVO_DESONERACAO")
    private NfeIcmsMotivoDesoneracaoEJB nfeIcmsMotivoDesoneracao;
	
	@ManyToOne
	@JoinColumn(name = "ID_NFE_ICMS_ORIGEM_MERCADORIA", insertable=false, updatable=false, referencedColumnName = "ID_NFE_ICMS_ORIGEM_MERCADORIA")
    private NfeIcmsOrigemMercadoriaEJB nfeIcmsOrigemMercadoria;
	
    @Column(name="PBCOP")
    private BigDecimal percOperacao;
    
    @Column(name="PCREDSN")
    private BigDecimal percCreditoSimplesNacional;
    
    @Column(name="PDIF")
    private BigDecimal percDiferimento;
    
    @Column(name="PICMSST")
    private BigDecimal percIcmsSt;
    
    @Column(name="PMVAST")
    private BigDecimal percMargemValAdicional;
    
    @Column(name="PREDBC")
    private BigDecimal percReducaoBc;
    
    @Column(name="PREDBCST")
    private BigDecimal percReducaoBcSt;
    
    @Column(name="UFST")
    private String ufSt;
    
    @Column(name="VBCST")
    private BigDecimal valBcSt;
    
    @Column(name="VBCSTDEST")
    private BigDecimal valBcStDest;
    
    @Column(name="VBCSTRET")
    private BigDecimal valBcStRet;

    @Column(name="VICMSDESON")
    private BigDecimal valIcmsDeson;
    
    @Column(name="VICMSDIF")
    private BigDecimal valIcmsDif;
    
    @Column(name="VICMSOP")
    private BigDecimal valIcmsOperacao;
    
    @Column(name="VICMSST")
    private BigDecimal valIcmsSt;

    @Column(name="VICMSSTDEST")
    private BigDecimal valIcmsStDest;
    
    @Column(name="VICMSSTRET")
    private BigDecimal valIcmsStRet;
    
    public NfeMovRestIcmsEJB() {
    }

	public Long getIdNfeMovRestIcms() {
		return idNfeMovRestIcms;
	}

	public void setIdNfeMovRestIcms(Long idNfeMovRestIcms) {
		this.idNfeMovRestIcms = idNfeMovRestIcms;
	}

	public MovimentoRestauranteEJB getMovimentoRestaurante() {
		return movimentoRestaurante;
	}

	public void setMovimentoRestaurante(MovimentoRestauranteEJB movimentoRestaurante) {
		this.movimentoRestaurante = movimentoRestaurante;
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

	public BigDecimal getPercOperacao() {
		return percOperacao;
	}

	public void setPercOperacao(BigDecimal percOperacao) {
		this.percOperacao = percOperacao;
	}

	public BigDecimal getPercCreditoSimplesNacional() {
		return percCreditoSimplesNacional;
	}

	public void setPercCreditoSimplesNacional(BigDecimal percCreditoSimplesNacional) {
		this.percCreditoSimplesNacional = percCreditoSimplesNacional;
	}

	public BigDecimal getPercDiferimento() {
		return percDiferimento;
	}

	public void setPercDiferimento(BigDecimal percDiferimento) {
		this.percDiferimento = percDiferimento;
	}

	public BigDecimal getPercIcmsSt() {
		return percIcmsSt;
	}

	public void setPercIcmsSt(BigDecimal percIcmsSt) {
		this.percIcmsSt = percIcmsSt;
	}

	public BigDecimal getPercMargemValAdicional() {
		return percMargemValAdicional;
	}

	public void setPercMargemValAdicional(BigDecimal percMargemValAdicional) {
		this.percMargemValAdicional = percMargemValAdicional;
	}

	public BigDecimal getPercReducaoBc() {
		return percReducaoBc;
	}

	public void setPercReducaoBc(BigDecimal percReducaoBc) {
		this.percReducaoBc = percReducaoBc;
	}

	public BigDecimal getPercReducaoBcSt() {
		return percReducaoBcSt;
	}

	public void setPercReducaoBcSt(BigDecimal percReducaoBcSt) {
		this.percReducaoBcSt = percReducaoBcSt;
	}

	public String getUfSt() {
		return ufSt;
	}

	public void setUfSt(String ufSt) {
		this.ufSt = ufSt;
	}

	public BigDecimal getValBcSt() {
		return valBcSt;
	}

	public void setValBcSt(BigDecimal valBcSt) {
		this.valBcSt = valBcSt;
	}

	public BigDecimal getValBcStDest() {
		return valBcStDest;
	}

	public void setValBcStDest(BigDecimal valBcStDest) {
		this.valBcStDest = valBcStDest;
	}

	public BigDecimal getValBcStRet() {
		return valBcStRet;
	}

	public void setValBcStRet(BigDecimal valBcStRet) {
		this.valBcStRet = valBcStRet;
	}

	public BigDecimal getValIcmsDeson() {
		return valIcmsDeson;
	}

	public void setValIcmsDeson(BigDecimal valIcmsDeson) {
		this.valIcmsDeson = valIcmsDeson;
	}

	public BigDecimal getValIcmsDif() {
		return valIcmsDif;
	}

	public void setValIcmsDif(BigDecimal valIcmsDif) {
		this.valIcmsDif = valIcmsDif;
	}

	public BigDecimal getValIcmsOperacao() {
		return valIcmsOperacao;
	}

	public void setValIcmsOperacao(BigDecimal valIcmsOperacao) {
		this.valIcmsOperacao = valIcmsOperacao;
	}

	public BigDecimal getValIcmsSt() {
		return valIcmsSt;
	}

	public void setValIcmsSt(BigDecimal valIcmsSt) {
		this.valIcmsSt = valIcmsSt;
	}

	public BigDecimal getValIcmsStDest() {
		return valIcmsStDest;
	}

	public void setValIcmsStDest(BigDecimal valIcmsStDest) {
		this.valIcmsStDest = valIcmsStDest;
	}

	public BigDecimal getValIcmsStRet() {
		return valIcmsStRet;
	}

	public void setValIcmsStRet(BigDecimal valIcmsStRet) {
		this.valIcmsStRet = valIcmsStRet;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}
}
