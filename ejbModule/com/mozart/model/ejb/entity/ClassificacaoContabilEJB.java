package com.mozart.model.ejb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLASSIFICACAO_CONTABIL")
@NamedQueries({
	@NamedQuery(name="classificacaoContabil.findByIdHotelAndLikeDescricao", query="SELECT CC FROM ClassificacaoContabilEJB CC WHERE CC.idHotel = ?1 AND CC.descricao LIKE ?2",hints={@QueryHint(name="eclipselink.refresh", value="TRUE")})
})
public class ClassificacaoContabilEJB extends MozartEntity {	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLASSIFICACAO_CONTABIL_IDCLASSIFICACAOCONTABIL_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASSIFICACAO_CONTABIL_IDCLASSIFICACAOCONTABIL_GENERATOR")
	@Column(name="ID_CLASSIFICACAO_CONTABIL")
	private Long idClassificacaoContabil;

	@OneToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CONTA_CORRENTE", referencedColumnName="ID_CONTA_CORRENTE")
	private ContaCorrenteEJB contaCorrente;

	@Column(name="DEBITO_CREDITO")
	private String debitoCredito;

	private String descricao;

	@Column(name="ID_CENTRO_CUSTO_CREDITO")
	private Long idCentroCustoCredito;

	@Column(name="ID_CENTRO_CUSTO_DEBITO")
	private Long idCentroCustoDebito;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_PLANO_CONTAS_CREDITO")
	private Long idPlanoContasCredito;

	@Column(name="ID_PLANO_CONTAS_DEBITO")
	private Long idPlanoContasDebito;

	@Column(name="ID_PLANO_CONTAS_FINANCEIRO")
	private Long idPlanoContasFinanceiro;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumns({
    @JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO"),
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable=false, updatable=false)
    })
    private TipoLancamentoEJB tipoLancamentoEJB;

    @OneToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumns({
    		@JoinColumn(name="ID_REDE_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_REDE_HOTEL"),
    		@JoinColumn(name="ID_CENTRO_CUSTO_CREDITO", insertable = false, updatable = false, referencedColumnName = "ID_CENTRO_CUSTO_CONTABIL")
    })
    private CentroCustoContabilEJB centroCustoCredito;
    

	@OneToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumns({
    	@JoinColumn(name="ID_REDE_HOTEL", insertable = false, updatable = false, referencedColumnName = "ID_REDE_HOTEL"),
    	@JoinColumn(name="ID_CENTRO_CUSTO_DEBITO", insertable = false, updatable = false, referencedColumnName = "ID_CENTRO_CUSTO_CONTABIL")
    })
    private CentroCustoContabilEJB centroCustoDebito;
    
    @OneToOne( fetch=FetchType.EAGER)
    @JoinColumns({
    	@JoinColumn(name="ID_REDE_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_REDE_HOTEL"),
    	@JoinColumn(name="ID_PLANO_CONTAS_DEBITO", insertable=false, updatable=false, referencedColumnName = "ID_PLANO_CONTAS")
    })
    private PlanoContaEJB planoContasDebito;
    
    @OneToOne( fetch=FetchType.EAGER)
    @JoinColumns({
    	@JoinColumn(name="ID_REDE_HOTEL", insertable=false, updatable=false,referencedColumnName = "ID_REDE_HOTEL"),
    	@JoinColumn(name="ID_PLANO_CONTAS_CREDITO", insertable=false, updatable=false, referencedColumnName = "ID_PLANO_CONTAS")
    })
    private PlanoContaEJB planoContasCredito;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumns({
    	@JoinColumn(name="ID_REDE_HOTEL", insertable = false, updatable = false, referencedColumnName = "ID_REDE_HOTEL"),
    	@JoinColumn(name="ID_PLANO_CONTAS_FINANCEIRO", insertable = false, updatable = false, referencedColumnName = "ID_PLANO_CONTAS")
    })
    private PlanoContaEJB planoContasFin;
    
    public CentroCustoContabilEJB getCentroCustoDebito() {
    	return centroCustoDebito;
    }
    
    public void setCentroCustoDebito(CentroCustoContabilEJB centroCustoDebito) {
    	this.centroCustoDebito = centroCustoDebito;
    }
    
    public PlanoContaEJB getPlanoContasDebito() {
    	return planoContasDebito;
    }
    
    public void setPlanoContasDebito(PlanoContaEJB planoContasDebito) {
    	this.planoContasDebito = planoContasDebito;
    }
    
    public PlanoContaEJB getPlanoContasCredito() {
    	return planoContasCredito;
    }
    
    public void setPlanoContasCredito(PlanoContaEJB planoContasCredito) {
    	this.planoContasCredito = planoContasCredito;
    }
    
	private Double percentual;

	private String pis;

    public ClassificacaoContabilEJB() {
    	super();
    }

	public CentroCustoContabilEJB getCentroCustoCredito() {
		return centroCustoCredito;
	}

	public void setCentroCustoCredito(
			CentroCustoContabilEJB centroCustoCredito) {
		this.centroCustoCredito = centroCustoCredito;
	}

	public Long getIdClassificacaoContabil() {
		return this.idClassificacaoContabil;
	}

	public void setIdClassificacaoContabil(Long idClassificacaoContabil) {
		this.idClassificacaoContabil = idClassificacaoContabil;
	}

	public String getDebitoCredito() {
		return this.debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdCentroCustoCredito() {
		return this.idCentroCustoCredito;
	}

	public void setIdCentroCustoCredito(Long idCentroCustoCredito) {
		this.idCentroCustoCredito = idCentroCustoCredito;
	}

	public Long getIdCentroCustoDebito() {
		return this.idCentroCustoDebito;
	}

	public void setIdCentroCustoDebito(Long idCentroCustoDebito) {
		this.idCentroCustoDebito = idCentroCustoDebito;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdPlanoContasCredito() {
		return this.idPlanoContasCredito;
	}

	public void setIdPlanoContasCredito(Long idPlanoContasCredito) {
		this.idPlanoContasCredito = idPlanoContasCredito;
	}

	public Long getIdPlanoContasDebito() {
		return this.idPlanoContasDebito;
	}

	public void setIdPlanoContasDebito(Long idPlanoContasDebito) {
		this.idPlanoContasDebito = idPlanoContasDebito;
	}

	public Long getIdPlanoContasFinanceiro() {
		return this.idPlanoContasFinanceiro;
	}

	public void setIdPlanoContasFinanceiro(Long idPlanoContasFinanceiro) {
		this.idPlanoContasFinanceiro = idPlanoContasFinanceiro;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Double getPercentual() {
		return this.percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public String getPis() {
		return this.pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}
	public void setPis(boolean pis) {
		if(pis){
			setPis("S");
		}else {
			setPis("N");
		}
	}

	public ContaCorrenteEJB getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrenteEJB contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public TipoLancamentoEJB getTipoLancamentoEJB() {
		return tipoLancamentoEJB;
	}

	public void setTipoLancamentoEJB(TipoLancamentoEJB tipoLancamentoEJB) {
		this.tipoLancamentoEJB = tipoLancamentoEJB;
	}

	public boolean isPis(){
		return this.pis.equalsIgnoreCase("S");
	}

	public PlanoContaEJB getPlanoContasFin() {
		return planoContasFin;
	}

	public void setPlanoContasFin(PlanoContaEJB planoContasFin) {
		this.planoContasFin = planoContasFin;
	}
}