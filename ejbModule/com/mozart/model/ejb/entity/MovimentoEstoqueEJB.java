package com.mozart.model.ejb.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MOVIMENTO_ESTOQUE")
@NamedQuery(name = "MovimentoEstoqueEJB.findAll", query = "SELECT m FROM MovimentoEstoqueEJB m")
public class MovimentoEstoqueEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_MOVIMENTO_ESTOQUE")
	private Long idMovimentoEstoque;

	@Column(name = "BASE_CALCULO")
	private BigDecimal baseCalculo;
	
	// TODO: (ID / Conta Corrente) Atributo incompativel, nao obtem entidade
	@Column(name = "ID_CONTA_CORRENTE")
	private Long contaCorrente;

	@Column(name = "CONTROLE_ATIVO_FIXO")
	private BigDecimal controleAtivoFixo;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DOCUMENTO")
	private Date dataDocumento;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_MOVIMENTO")
	private Date dataMovimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCIMENTO")
	private Date dataVencimento;

	@Column(name = "HISTORICO_COMPLEMENTAR")
	private String historicoComplementar;

	@Column(name = "CHAVE_ACESSO")
	private String chaveAcesso;

	@Column(name = "ICMS_VALOR")
	private BigDecimal icmsValor;

	@ManyToOne
	@JoinColumn(name = "ID_ALIQUOTAS", referencedColumnName = "ID_ALIQUOTAS")
	private AliquotaEJB aliquotas;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "ID_CENTRO_CUSTO", referencedColumnName = "ID_CENTRO_CUSTO_CONTABIL"),
			@JoinColumn(name = "ID_REDE_HOTEL", referencedColumnName = "ID_REDE_HOTEL") })
	private CentroCustoContabilEJB centroCustoContabil;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "ID_CENTRO_CUSTO_ACESSOR", referencedColumnName = "ID_CENTRO_CUSTO_CONTABIL"),
			@JoinColumn(name = "ID_REDE_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_REDE_HOTEL") })
	private CentroCustoContabilEJB centroCustoContabilAcessor;

	@ManyToOne
	@JoinColumn(name = "ID_COD_FISCAL", referencedColumnName = "ID_CODIGO_FISCAL")
	private FiscalCodigoEJB fiscalCodigo;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "ID_COTACAO", referencedColumnName = "ID_COTACAO"),
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL") })
	private CotacaoEJB cotacao;

	@ManyToOne
	@JoinColumn(name = "ID_FISCAL_INCIDENCIA", referencedColumnName = "ID_FISCAL_INCIDENCIA")
	private FiscalIncidenciaEJB fiscalIncidencia;

	@OneToOne(optional=false, fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", updatable = false, insertable = false),
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR", updatable = false, insertable = false)
    })
    private FornecedorHotelEJB fornecedorHotelEJB;

	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "ID_HISTORICO", referencedColumnName = "ID_HISTORICO"),
			@JoinColumn(name = "ID_REDE_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_REDE_HOTEL") })
	private HistoricoContabilEJB historicoContabil;

	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;

	@Column(name = "ID_HOTEL_MUTUO")
	private BigDecimal idHotelMutuo;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_ITEM", referencedColumnName = "ID_ITEM"),
		@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL") })
	private ItemEstoqueEJB item;

	@Column(name = "ID_MOVIMENTO_ESTOQUE_PORCAO")
	private BigDecimal idMovimentoEstoquePorcao;

	@Column(name = "ID_PATRIMONIO_SETOR")
	private BigDecimal idPatrimonioSetor;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "ID_PLANO_CONTAS", referencedColumnName = "ID_PLANO_CONTAS"),
			@JoinColumn(name = "ID_REDE_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_REDE_HOTEL") })
	private PlanoContaEJB planoContas;

	@ManyToOne
	@JoinColumn(name = "ID_REDE_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_REDE_HOTEL")
	private RedeHotelEJB redeHotel;

	@Column(name = "ID_REQUISICAO")
	private BigDecimal idRequisicao;

	@ManyToOne
	@JoinColumn(name = "ID_UNIDADE_ESTOQUE", referencedColumnName = "ID_UNIDADE_ESTOQUE")
	private UnidadeEstoqueEJB unidadeEstoque;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEJB usuario;

	@Column(name = "MOTIVO")
	private String motivo;

	@Column(name = "NUM_DOCUMENTO")
	private String numDocumento;

	@Column(name = "OBSERVACAO")
	private String observacao;

	@Column(name = "QUANTIDADE")
	private BigDecimal quantidade;

	@Column(name = "QUANTIDADE_AUTORIZADA")
	private BigDecimal quantidadeAutorizada;

	@Column(name = "QUANTIDADE_LIBERADA")
	private BigDecimal quantidadeLiberada;

	@Column(name = "QUANTIDADE_RECEBIDA")
	private BigDecimal quantidadeRecebida;

	@Column(name = "SERIE_DOCUMENTO")
	private String serieDocumento;

	@Column(name = "TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name = "TIPO_MOVIMENTO")
	private String tipoMovimento;

	@Column(name = "VALOR_ACESSORIO")
	private BigDecimal valorAcessorio;

	@Column(name = "VALOR_TOTAL")
	private BigDecimal valorTotal;

	@Column(name = "VALOR_UNITARIO")
	private BigDecimal valorUnitario;

	public MovimentoEstoqueEJB() {
	}

	public Long getIdMovimentoEstoque() {
		return idMovimentoEstoque;
	}

	public void setIdMovimentoEstoque(Long idMovimentoEstoque) {
		this.idMovimentoEstoque = idMovimentoEstoque;
	}

	public BigDecimal getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(BigDecimal baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public Long getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public BigDecimal getControleAtivoFixo() {
		return controleAtivoFixo;
	}

	public void setControleAtivoFixo(BigDecimal controleAtivoFixo) {
		this.controleAtivoFixo = controleAtivoFixo;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getHistoricoComplementar() {
		return historicoComplementar;
	}

	public void setHistoricoComplementar(String historicoComplementar) {
		this.historicoComplementar = historicoComplementar;
	}

	public BigDecimal getIcmsValor() {
		return icmsValor;
	}

	public void setIcmsValor(BigDecimal icmsValor) {
		this.icmsValor = icmsValor;
	}

	public AliquotaEJB getAliquotas() {
		return aliquotas;
	}

	public void setAliquotas(AliquotaEJB aliquotas) {
		this.aliquotas = aliquotas;
	}

	public CentroCustoContabilEJB getCentroCustoContabil() {
		return centroCustoContabil;
	}

	public void setCentroCustoContabil(CentroCustoContabilEJB centroCustoContabil) {
		this.centroCustoContabil = centroCustoContabil;
	}

	public CentroCustoContabilEJB getCentroCustoContabilAcessor() {
		return centroCustoContabilAcessor;
	}

	public void setCentroCustoContabilAcessor(
			CentroCustoContabilEJB centroCustoContabilAcessor) {
		this.centroCustoContabilAcessor = centroCustoContabilAcessor;
	}

	public FiscalCodigoEJB getFiscalCodigo() {
		return fiscalCodigo;
	}

	public void setFiscalCodigo(FiscalCodigoEJB fiscalCodigo) {
		this.fiscalCodigo = fiscalCodigo;
	}

	public CotacaoEJB getCotacao() {
		return cotacao;
	}

	public void setCotacao(CotacaoEJB cotacao) {
		this.cotacao = cotacao;
	}

	public FiscalIncidenciaEJB getFiscalIncidencia() {
		return fiscalIncidencia;
	}

	public void setFiscalIncidencia(FiscalIncidenciaEJB fiscalIncidencia) {
		this.fiscalIncidencia = fiscalIncidencia;
	}

	public FornecedorHotelEJB getFornecedorHotelEJB() {
		return fornecedorHotelEJB;
	}

	public void setFornecedorHotelEJB(FornecedorHotelEJB fornecedorHotelEJB) {
		this.fornecedorHotelEJB = fornecedorHotelEJB;
	}

	public HistoricoContabilEJB getHistoricoContabil() {
		return historicoContabil;
	}

	public void setHistoricoContabil(HistoricoContabilEJB historicoContabil) {
		this.historicoContabil = historicoContabil;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public BigDecimal getIdHotelMutuo() {
		return idHotelMutuo;
	}

	public void setIdHotelMutuo(BigDecimal idHotelMutuo) {
		this.idHotelMutuo = idHotelMutuo;
	}

	public ItemEstoqueEJB getItem() {
		return item;
	}

	public void setItem(ItemEstoqueEJB item) {
		this.item = item;
	}

	public BigDecimal getIdMovimentoEstoquePorcao() {
		return idMovimentoEstoquePorcao;
	}

	public void setIdMovimentoEstoquePorcao(BigDecimal idMovimentoEstoquePorcao) {
		this.idMovimentoEstoquePorcao = idMovimentoEstoquePorcao;
	}

	public BigDecimal getIdPatrimonioSetor() {
		return idPatrimonioSetor;
	}

	public void setIdPatrimonioSetor(BigDecimal idPatrimonioSetor) {
		this.idPatrimonioSetor = idPatrimonioSetor;
	}

	public PlanoContaEJB getPlanoContas() {
		return planoContas;
	}

	public void setPlanoContas(PlanoContaEJB planoContas) {
		this.planoContas = planoContas;
	}

	public RedeHotelEJB getRedeHotel() {
		return redeHotel;
	}

	public void setRedeHotel(RedeHotelEJB redeHotel) {
		this.redeHotel = redeHotel;
	}

	public BigDecimal getIdRequisicao() {
		return idRequisicao;
	}

	public void setIdRequisicao(BigDecimal idRequisicao) {
		this.idRequisicao = idRequisicao;
	}

	public UnidadeEstoqueEJB getUnidadeEstoque() {
		return unidadeEstoque;
	}

	public void setUnidadeEstoque(UnidadeEstoqueEJB unidadeEstoque) {
		this.unidadeEstoque = unidadeEstoque;
	}

	public UsuarioEJB getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEJB usuario) {
		this.usuario = usuario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getQuantidadeAutorizada() {
		return quantidadeAutorizada;
	}

	public void setQuantidadeAutorizada(BigDecimal quantidadeAutorizada) {
		this.quantidadeAutorizada = quantidadeAutorizada;
	}

	public BigDecimal getQuantidadeLiberada() {
		return quantidadeLiberada;
	}

	public void setQuantidadeLiberada(BigDecimal quantidadeLiberada) {
		this.quantidadeLiberada = quantidadeLiberada;
	}

	public BigDecimal getQuantidadeRecebida() {
		return quantidadeRecebida;
	}

	public void setQuantidadeRecebida(BigDecimal quantidadeRecebida) {
		this.quantidadeRecebida = quantidadeRecebida;
	}

	public String getSerieDocumento() {
		return serieDocumento;
	}

	public void setSerieDocumento(String serieDocumento) {
		this.serieDocumento = serieDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public BigDecimal getValorAcessorio() {
		return valorAcessorio;
	}

	public void setValorAcessorio(BigDecimal valorAcessorio) {
		this.valorAcessorio = valorAcessorio;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getChaveAcesso() {
		return chaveAcesso;
	}

	public void setChaveAcesso(String chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}
}