package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class DuplicataVO extends MozartVO {
	private static final long serialVersionUID = 4608845456493444960L;
	private FiltroWeb filtroDataLancamento;
	private FiltroWeb filtroDataVencimento;
	private FiltroWeb filtroEmpresa;
	private FiltroWeb filtroNumNota;
	private FiltroWeb filtroNumDuplicata;
	private FiltroWeb filtroValorDuplicata;
	private FiltroWeb filtroBanco;
	private FiltroWeb filtroContaCorrente;
	private String filtroTipoPesquisa;
	private String filtroIds;
	private Long idDuplicata;
	private String empresa;
	private String numDuplicata;
	private String numNota;
	private Long parcela;
	private Double valorDuplicata;
	private Double comissao;
	private Double ir;
	private Double ajuste;
	private Double encargos;
	private Date dataVencimento;
	private Date dataLancamento;
	private Long contaCorrente;
	private String sigla;
	private Long numBanco;
	private Long seqBancaria;
	private FiltroWeb filtroDataDesconto;
	private FiltroWeb filtroDataRecompra;
	private FiltroWeb filtroDataProrrogacao;
	private FiltroWeb filtroDataRecebimento;
	private FiltroWeb filtroNumLote;
	private Date dataDesconto;
	private Date dataRecebimento;
	private Date dataProrrogado;
	private Date dataRecompra;
	private Double retencao;
	private Double descontoRecebimento;
	private Long numLote;
	private String agrupar;
	private double valorLiquido;
	private Double juros;
	private Double cofins;
	private Double pis;
	private Double cssl;
	private Double iss;
	private String justificativa;
	private Double valorRecebido;
	private Long idEmpresa;
	private Long idPlanoContas;
	private Long idCentroCusto;
	private Double despesaFinanceira;
	private Double irRetencao;
	private String nomeBanco;
	private String numDocTesouraria;
	private Long idContaCorrente;
	public static final int TR_CONTAS_RECEBER = 1;

	public DuplicataVO() {
		this.filtroDataVencimento = new FiltroWeb();
		this.filtroEmpresa = new FiltroWeb();
		this.filtroNumNota = new FiltroWeb();
		this.filtroNumDuplicata = new FiltroWeb();
		this.filtroValorDuplicata = new FiltroWeb();
		this.filtroDataLancamento = new FiltroWeb();
		this.filtroBanco = new FiltroWeb();

		this.filtroDataDesconto = new FiltroWeb();
		this.filtroDataRecompra = new FiltroWeb();
		this.filtroDataProrrogacao = new FiltroWeb();
		this.filtroDataRecebimento = new FiltroWeb();
		this.filtroNumLote = new FiltroWeb();
		this.filtroContaCorrente = new FiltroWeb();
	}

	public DuplicataVO(Object[] linha) {
		if (!MozartUtil.isNull(linha)) {
			setLinha(linha);
			this.idDuplicata = getLong();
			this.empresa = getString();
			this.numDuplicata = getString();
			this.numNota = getString();
			this.parcela = getLong();
			this.valorDuplicata = getDouble();
			this.comissao = getDouble();
			this.ir = getDouble();
			this.ajuste = getDouble();
			this.encargos = getDouble();
			this.dataVencimento = getDate();
			this.dataLancamento = getDate();
			this.contaCorrente = getLong();
			this.sigla = getString();
			this.idEmpresa = getLong();
			this.numBanco = getLong();
			this.seqBancaria = getLong();
		}
	}

	public DuplicataVO(Object[] linha, int tipo) {
		if (!MozartUtil.isNull(linha)) {
			setLinha(linha);
			if (tipo == 1) {
				this.idDuplicata = getLong();
				this.sigla = getString();
				this.empresa = getString();
				this.numDuplicata = getString();
				this.valorDuplicata = getDouble();
				this.dataLancamento = getDate();
				this.dataVencimento = getDate();
				this.dataDesconto = getDate();
				this.dataRecebimento = getDate();
				this.dataProrrogado = getDate();
				this.dataRecompra = getDate();
				this.comissao = getDouble();
				this.ir = getDouble();
				this.ajuste = getDouble();
				this.encargos = getDouble();
				this.retencao = getDouble();
				this.descontoRecebimento = getDouble();
				this.numLote = getLong();
				this.agrupar = getString();
				this.valorLiquido = getDouble().doubleValue();
				this.contaCorrente = getLong();
				this.juros = getDouble();
				this.cofins = getDouble();
				this.pis = getDouble();
				this.cssl = getDouble();
				this.iss = getDouble();
				this.justificativa = getString();
				this.valorRecebido = getDouble();
				this.idEmpresa = getLong();
				this.idPlanoContas = getLong();
				this.idCentroCusto = getLong();
				this.despesaFinanceira = getDouble();
				this.irRetencao = getDouble();
				this.nomeBanco = getString();
				this.idContaCorrente = getLong();
			}
		}
	}

	public boolean equals(Object obj) {
		if ((obj == null) || (this.idDuplicata == null)
				|| (!(obj instanceof DuplicataVO))) {
			return false;
		}
		return this.idDuplicata.equals(((DuplicataVO) obj).getIdDuplicata());
	}

	public String toString() {
		return this.numDuplicata + " - "
				+ (this.parcela == null ? "1" : this.parcela) + " - "
				+ MozartUtil.format(this.dataLancamento, "yyyy") + " - "
				+ MozartUtil.format(this.dataLancamento, "dd/MM/yyyy");
	}

	public Long getIdDuplicata() {
		return this.idDuplicata;
	}

	public void setIdDuplicata(Long idDuplicata) {
		this.idDuplicata = idDuplicata;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNumNota() {
		return this.numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public Long getParcela() {
		return this.parcela;
	}

	public void setParcela(Long parcela) {
		this.parcela = parcela;
	}

	public Double getValorDuplicata() {
		return this.valorDuplicata;
	}

	public void setValorDuplicata(Double valorDuplicata) {
		this.valorDuplicata = valorDuplicata;
	}

	public Double getComissao() {
		return this.comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Double getIr() {
		return this.ir;
	}

	public void setIr(Double ir) {
		this.ir = ir;
	}

	public Double getAjuste() {
		return this.ajuste;
	}

	public void setAjuste(Double ajuste) {
		this.ajuste = ajuste;
	}

	public Double getEncargos() {
		return this.encargos;
	}

	public void setEncargos(Double encargos) {
		this.encargos = encargos;
	}

	public Date getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Long getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public FiltroWeb getFiltroDataVencimento() {
		return this.filtroDataVencimento;
	}

	public void setFiltroDataVencimento(FiltroWeb filtroDataVencimento) {
		this.filtroDataVencimento = filtroDataVencimento;
	}

	public FiltroWeb getFiltroEmpresa() {
		return this.filtroEmpresa;
	}

	public void setFiltroEmpresa(FiltroWeb filtroEmpresa) {
		this.filtroEmpresa = filtroEmpresa;
	}

	public FiltroWeb getFiltroNumNota() {
		return this.filtroNumNota;
	}

	public void setFiltroNumNota(FiltroWeb filtroNumNota) {
		this.filtroNumNota = filtroNumNota;
	}

	public FiltroWeb getFiltroNumDuplicata() {
		return this.filtroNumDuplicata;
	}

	public void setFiltroNumDuplicata(FiltroWeb filtroNumDuplicata) {
		this.filtroNumDuplicata = filtroNumDuplicata;
	}

	public FiltroWeb getFiltroValorDuplicata() {
		return this.filtroValorDuplicata;
	}

	public void setFiltroValorDuplicata(FiltroWeb filtroValorDuplicata) {
		this.filtroValorDuplicata = filtroValorDuplicata;
	}

	public String getNumDuplicata() {
		return this.numDuplicata;
	}

	public void setNumDuplicata(String numDuplicata) {
		this.numDuplicata = numDuplicata;
	}

	public String getFiltroTipoPesquisa() {
		return this.filtroTipoPesquisa;
	}

	public void setFiltroTipoPesquisa(String filtroTipoPesquisa) {
		this.filtroTipoPesquisa = filtroTipoPesquisa;
	}

	public FiltroWeb getFiltroDataLancamento() {
		return this.filtroDataLancamento;
	}

	public void setFiltroDataLancamento(FiltroWeb filtroDataLancamento) {
		this.filtroDataLancamento = filtroDataLancamento;
	}

	public Date getDataDesconto() {
		return this.dataDesconto;
	}

	public void setDataDesconto(Date dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public Date getDataRecebimento() {
		return this.dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Date getDataProrrogado() {
		return this.dataProrrogado;
	}

	public void setDataProrrogado(Date dataProrrogado) {
		this.dataProrrogado = dataProrrogado;
	}

	public Date getDataRecompra() {
		return this.dataRecompra;
	}

	public void setDataRecompra(Date dataRecompra) {
		this.dataRecompra = dataRecompra;
	}

	public Double getRetencao() {
		return this.retencao;
	}

	public void setRetencao(Double retencao) {
		this.retencao = retencao;
	}

	public Double getDescontoRecebimento() {
		return this.descontoRecebimento;
	}

	public void setDescontoRecebimento(Double descontoRecebimento) {
		this.descontoRecebimento = descontoRecebimento;
	}

	public Long getNumLote() {
		return this.numLote;
	}

	public void setNumLote(Long numLote) {
		this.numLote = numLote;
	}

	public String getAgrupar() {
		return this.agrupar;
	}

	public void setAgrupar(String agrupar) {
		this.agrupar = agrupar;
	}

	public FiltroWeb getFiltroDataDesconto() {
		return this.filtroDataDesconto;
	}

	public void setFiltroDataDesconto(FiltroWeb filtroDataDesconto) {
		this.filtroDataDesconto = filtroDataDesconto;
	}

	public FiltroWeb getFiltroDataRecompra() {
		return this.filtroDataRecompra;
	}

	public void setFiltroDataRecompra(FiltroWeb filtroDataRecompra) {
		this.filtroDataRecompra = filtroDataRecompra;
	}

	public FiltroWeb getFiltroDataProrrogacao() {
		return this.filtroDataProrrogacao;
	}

	public void setFiltroDataProrrogacao(FiltroWeb filtroDataProrrogacao) {
		this.filtroDataProrrogacao = filtroDataProrrogacao;
	}

	public FiltroWeb getFiltroDataRecebimento() {
		return this.filtroDataRecebimento;
	}

	public void setFiltroDataRecebimento(FiltroWeb filtroDataRecebimento) {
		this.filtroDataRecebimento = filtroDataRecebimento;
	}

	public FiltroWeb getFiltroNumLote() {
		return this.filtroNumLote;
	}

	public void setFiltroNumLote(FiltroWeb filtroNumLote) {
		this.filtroNumLote = filtroNumLote;
	}

	public FiltroWeb getFiltroBanco() {
		return this.filtroBanco;
	}

	public void setFiltroBanco(FiltroWeb filtroBanco) {
		this.filtroBanco = filtroBanco;
	}

	public Double getValorLiquido() {
		this.valorLiquido =
		(this.valorDuplicata.floatValue()
				- (this.comissao == null ? 0.0F : this.comissao.floatValue())
				+ (this.ir == null ? 0.0F : this.ir.floatValue())
				- (this.ajuste == null ? 0.0F : this.ajuste.floatValue())
				- (this.encargos == null ? 0.0F	: this.encargos.floatValue()));
		return new Double(this.valorLiquido);
	}

	public Double getValorRecebidoCalculado() {
		Float valor =
				getValorLiquido().floatValue()
				+ (this.juros == null ? 0.0F : this.juros.floatValue())
				- (this.descontoRecebimento == null ? 0.0F
						: this.descontoRecebimento.floatValue())
				- (this.retencao == null ? 0.0F : this.retencao.floatValue())
				- (this.cofins == null ? 0.0F : this.cofins.floatValue())
				- (this.pis == null ? 0.0F : this.pis.floatValue())
				- (this.cssl == null ? 0.0F : this.cssl.floatValue())
				- (this.iss == null ? 0.0F : this.iss.floatValue());

		 
		return new Double(valor.toString());
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido.doubleValue();
	}

	public Double getJuros() {
		return this.juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Double getCofins() {
		return this.cofins;
	}

	public void setCofins(Double cofins) {
		this.cofins = cofins;
	}

	public Double getPis() {
		return this.pis;
	}

	public void setPis(Double pis) {
		this.pis = pis;
	}

	public Double getCssl() {
		return this.cssl;
	}

	public void setCssl(Double cssl) {
		this.cssl = cssl;
	}

	public Double getIss() {
		return this.iss;
	}

	public void setIss(Double iss) {
		this.iss = iss;
	}

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Double getValorRecebido() {
		return this.valorRecebido;
	}

	public void setValorRecebido(Double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdPlanoContas() {
		return this.idPlanoContas;
	}

	public void setIdPlanoContas(Long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}

	public Long getIdCentroCusto() {
		return this.idCentroCusto;
	}

	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	public Double getDespesaFinanceira() {
		return this.despesaFinanceira;
	}

	public void setDespesaFinanceira(Double despesaFinanceira) {
		this.despesaFinanceira = despesaFinanceira;
	}

	public Double getIrRetencao() {
		return this.irRetencao;
	}

	public void setIrRetencao(Double irRetencao) {
		this.irRetencao = irRetencao;
	}

	public String getNomeBanco() {
		return this.nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public FiltroWeb getFiltroContaCorrente() {
		return this.filtroContaCorrente;
	}

	public void setFiltroContaCorrente(FiltroWeb filtroContaCorrente) {
		this.filtroContaCorrente = filtroContaCorrente;
	}

	public String getFiltroIds() {
		return this.filtroIds;
	}

	public void setFiltroIds(String filtroIds) {
		this.filtroIds = filtroIds;
	}

	public Long getNumBanco() {
		return this.numBanco;
	}

	public void setNumBanco(Long numBanco) {
		this.numBanco = numBanco;
	}

	public String getNumDocTesouraria() {
		return this.numDocTesouraria;
	}

	public void setNumDocTesouraria(String numDocTesouraria) {
		this.numDocTesouraria = numDocTesouraria;
	}

	public Long getSeqBancaria() {
		return seqBancaria;
	}

	public void setSeqBancaria(Long seqBancaria) {
		this.seqBancaria = seqBancaria;
	}

	public Long getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}
	
	
}