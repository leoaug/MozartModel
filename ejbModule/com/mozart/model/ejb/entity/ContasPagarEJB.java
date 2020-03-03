package com.mozart.model.ejb.entity;

import javax.persistence.*;

import com.mozart.model.util.MozartUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CONTAS_PAGAR")
public class ContasPagarEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqCp")
    @SequenceGenerator(name="idSeqCp", sequenceName="id", allocationSize=1)
	@Column(name="ID_CONTAS_PAGAR")
	private Long idContasPagar;

	@Column(name="ID_CONTA_CORRENTE")
	private Long contaCorrente;

	@Column(name="DATA_EMISSAO")
	private Timestamp dataEmissao;

	@Column(name="DATA_LANCAMENTO")
	private Timestamp dataLancamento;

	@Column(name="DATA_PAGAMENTO")
	private Timestamp dataPagamento;

	@Column(name="DATA_VENCIMENTO")
	private Timestamp dataVencimento;

	private Double desconto;

	private String emitido;

	@Column(name="HISTORICO_COMPLEMENTAR_DESC")
	private String historicoComplementarDesc;

	@Column(name="ID_BANCO")
	private Long idBanco;

	@Column(name="ID_CENTRO_CUSTO_CONTABIL_DESC")
	private Long idCentroCustoContabilDesc;

    @OneToOne(optional=false, fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR")
    })
    private FornecedorHotelEJB fornecedorHotelEJB;

	@Column(name="ID_HISTORICO_CREDITO")
	private Long idHistoricoCredito;

	@Column(name="ID_HOTEL_MUTUO")
	private Long idHotelMutuo;

	@Column(name="ID_PLANO_CONTAS_CREDITO")
	private Long idPlanoContasCredito;

	@Column(name="ID_PLANO_CONTAS_DEBITO_DESC")
	private Long idPlanoContasDebitoDesc;

	@Column(name="ID_PLANO_CONTAS_FINANCEIRO")
	private Long idPlanoContasFinanceiro;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	private String internet;

	private Double juros;

	@Column(name="JUSTIFICATIVA_DESC")
	private String justificativaDesc;

	@Column(name="NUM_CHEQUE")
	private String numCheque;

	@Column(name="NUM_DOCUMENTO")
	private String numDocumento;

	@Column(name="NUM_PARCELAS")
	private Long numParcelas;

	private String observacao;

	private String pago;

	@Column(name="PERC_JUROS")
	private Double percJuros;

	private String pis;

	private String portador;

	private Timestamp prorrogacao;

	@Column(name="SERIE_DOCUMENTO")
	private String serieDocumento;

	private String situacao;

	@Column(name="TAXA_ICMS")
	private Double taxaIcms;

	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name="VALOR_BRUTO")
	private Double valorBruto;

	@Column(name="VALOR_ICMS")
	private Double valorIcms;

	@Column(name="VALOR_PAGAMENTO")
	private Double valorPagamento;
	
	@OneToMany(mappedBy = "contasPagarEJB", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	private List<MovimentoContabilEJB> movimentoContabilEJBList;

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="ARQUIVO_IMAGEM", length=4000)
	private byte[] arquivoDocumento;
	
	@Column(name="ARQUIVO_NOME")
	private String nomeDocumento;
	
	@Transient
	private List<DuplicataHistoricoEJB> historicoList;
	
    public ContasPagarEJB() {
    }
    
    public boolean isCredito(){
    	
    	if (MozartUtil.isNull( movimentoContabilEJBList )){
    		return false;
    	}
    	
    	for (MovimentoContabilEJB lancamento: movimentoContabilEJBList){
    		if ("S".equals( lancamento.getLancarContasPagarCredito())){
    			return true;
    		}
    		if (idPlanoContasCredito!=null && lancamento.getPlanoContaEJB()!=null && idPlanoContasCredito.equals( lancamento.getPlanoContaEJB().getIdPlanoContas())){
    			return true;
    		}
    	}
    	
    	return false;
    }

	public Long getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Timestamp getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(Timestamp dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Timestamp getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Timestamp dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Timestamp getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Timestamp dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Timestamp getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Timestamp dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public String getEmitido() {
		return this.emitido;
	}

	public void setEmitido(String emitido) {
		this.emitido = emitido;
	}

	public String getHistoricoComplementarDesc() {
		return this.historicoComplementarDesc;
	}

	public void setHistoricoComplementarDesc(String historicoComplementarDesc) {
		this.historicoComplementarDesc = historicoComplementarDesc;
	}

	public Long getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}

	public Long getIdCentroCustoContabilDesc() {
		return this.idCentroCustoContabilDesc;
	}

	public void setIdCentroCustoContabilDesc(Long idCentroCustoContabilDesc) {
		this.idCentroCustoContabilDesc = idCentroCustoContabilDesc;
	}

	public Long getIdHistoricoCredito() {
		return this.idHistoricoCredito;
	}

	public void setIdHistoricoCredito(Long idHistoricoCredito) {
		this.idHistoricoCredito = idHistoricoCredito;
	}

	public Long getIdHotelMutuo() {
		return this.idHotelMutuo;
	}

	public void setIdHotelMutuo(Long idHotelMutuo) {
		this.idHotelMutuo = idHotelMutuo;
	}

	public Long getIdPlanoContasCredito() {
		return this.idPlanoContasCredito;
	}

	public void setIdPlanoContasCredito(Long idPlanoContasCredito) {
		this.idPlanoContasCredito = idPlanoContasCredito;
	}

	public Long getIdPlanoContasDebitoDesc() {
		return this.idPlanoContasDebitoDesc;
	}

	public void setIdPlanoContasDebitoDesc(Long idPlanoContasDebitoDesc) {
		this.idPlanoContasDebitoDesc = idPlanoContasDebitoDesc;
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

	public String getInternet() {
		return this.internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public Double getJuros() {
		return this.juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public String getJustificativaDesc() {
		return this.justificativaDesc;
	}

	public void setJustificativaDesc(String justificativaDesc) {
		this.justificativaDesc = justificativaDesc;
	}

	public String getNumCheque() {
		return this.numCheque;
	}

	public void setNumCheque(String numCheque) {
		this.numCheque = numCheque;
	}

	public String getNumDocumento() {
		return this.numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Long getNumParcelas() {
		return this.numParcelas;
	}

	public void setNumParcelas(Long numParcelas) {
		this.numParcelas = numParcelas;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPago() {
		return this.pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public Double getPercJuros() {
		return this.percJuros;
	}

	public void setPercJuros(Double percJuros) {
		this.percJuros = percJuros;
	}

	public String getPis() {
		return this.pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getPortador() {
		return this.portador;
	}

	public void setPortador(String portador) {
		this.portador = portador;
	}

	public Timestamp getProrrogacao() {
		return this.prorrogacao;
	}

	public void setProrrogacao(Timestamp prorrogacao) {
		this.prorrogacao = prorrogacao;
	}

	public String getSerieDocumento() {
		return this.serieDocumento;
	}

	public void setSerieDocumento(String serieDocumento) {
		this.serieDocumento = serieDocumento;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Double getTaxaIcms() {
		return this.taxaIcms;
	}

	public void setTaxaIcms(Double taxaIcms) {
		this.taxaIcms = taxaIcms;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Double getValorBruto() {
		return this.valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorIcms() {
		return this.valorIcms;
	}

	public void setValorIcms(Double valorIcms) {
		this.valorIcms = valorIcms;
	}

	public Double getValorPagamento() {
		return this.valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}


	public FornecedorHotelEJB getFornecedorHotelEJB() {
		return fornecedorHotelEJB;
	}

	public void setFornecedorHotelEJB(FornecedorHotelEJB fornecedorHotelEJB) {
		this.fornecedorHotelEJB = fornecedorHotelEJB;
	}

	public void setIdContasPagar(Long idContasPagar) {
		this.idContasPagar = idContasPagar;
	}

	public Long getIdContasPagar() {
		return this.idContasPagar;
	}

	public List<MovimentoContabilEJB> getMovimentoContabilEJBList() {
		return movimentoContabilEJBList;
	}

	public void setMovimentoContabilEJBList(
			List<MovimentoContabilEJB> movimentoContabilEJBList) {
		this.movimentoContabilEJBList = movimentoContabilEJBList;
	}

	public void addMovimentoContabilEJBList(MovimentoContabilEJB movimentoContabilEJB) {
		if (this.movimentoContabilEJBList == null)
			this.movimentoContabilEJBList = new ArrayList<MovimentoContabilEJB>();
		movimentoContabilEJB.setContasPagarEJB( this );
		movimentoContabilEJBList.add( movimentoContabilEJB );
	}

	public List<DuplicataHistoricoEJB> getHistoricoList() {
		return historicoList;
	}

	public void setHistoricoList(List<DuplicataHistoricoEJB> historicoList) {
		this.historicoList = historicoList;
	}

    public ContasPagarEJB clone(){
    	ContasPagarEJB clone = new ContasPagarEJB();
    	clone.setIdContasPagar( this.getIdContasPagar() );
    	clone.setContaCorrente( getContaCorrente() );
    	clone.setDataEmissao( getDataEmissao() );
    	clone.setDataLancamento( getDataLancamento() );
    	clone.setDataPagamento( getDataPagamento() );
    	clone.setDataVencimento( getDataVencimento() );
    	clone.setDesconto( getDesconto() );
    	clone.setEmitido( getEmitido() );
    	clone.setFornecedorHotelEJB( getFornecedorHotelEJB() );
    	clone.setHistoricoComplementarDesc( getHistoricoComplementarDesc() );
    	clone.setIdBanco( getIdBanco() );
    	clone.setIdCentroCustoContabilDesc( getIdCentroCustoContabilDesc() );
    	clone.setIdContasPagar( getIdContasPagar() );
    	clone.setIdHistoricoCredito( getIdHistoricoCredito() );
    	clone.setIdHotelMutuo( getIdHotelMutuo() );
    	clone.setIdPlanoContasCredito( getIdPlanoContasCredito() );
    	clone.setIdPlanoContasDebitoDesc(idPlanoContasDebitoDesc);
    	clone.setIdPlanoContasFinanceiro(idPlanoContasFinanceiro);
    	clone.setIdRedeHotel(idRedeHotel);
    	clone.setInternet(internet);
    	clone.setJuros(juros);
    	clone.setJustificativaDesc(justificativaDesc);
    	clone.setNumCheque(numCheque);
    	clone.setNumDocumento(numDocumento);
    	clone.setNumParcelas(numParcelas);
    	clone.setObservacao(observacao);
    	clone.setPago(pago);
    	clone.setPercJuros(percJuros);
    	clone.setPis(pis);
    	clone.setPortador(portador);
    	clone.setProrrogacao(prorrogacao);
    	clone.setSerieDocumento(serieDocumento);
    	clone.setSituacao(situacao);
    	clone.setTaxaIcms(taxaIcms);
    	clone.setTipoDocumento(tipoDocumento);
    	clone.setValorBruto(valorBruto);
    	clone.setValorIcms(valorIcms);
    	clone.setValorPagamento(valorPagamento);
    	return clone;
    }

	public byte[] getArquivoDocumento() {
		return arquivoDocumento;
	}

	public void setArquivoDocumento(byte[] arquivoDocumento) {
		this.arquivoDocumento = arquivoDocumento;
	}

	public String getNomeDocumento() {
		return this.nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}
}