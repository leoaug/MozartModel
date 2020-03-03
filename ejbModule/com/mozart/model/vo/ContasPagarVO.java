package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

import java.util.Date;

public class ContasPagarVO extends DuplicataVO {
	private static final long serialVersionUID = -113723029757899610L;
	private FiltroWeb filtroDataPagamento;
	private FiltroWeb filtroSituacao;
	private Long idContasPagar;
	private String sigla;
	private String empresa;
	private String documento;
	private Date dataPagamento;
	private Date dataVencimento;
	private Date dataLancamento;
	private Date dataProrrogado;
	private Double valorBruto;
	private Double juros;
	private Double desconto;
	private Double valorLiquido;
	private Double valorPago;
	private String numCheque;
	private String tipoDocumento;
	private String serieDocumento;
	private String situacao;
	private Long contaCorrente;
	private String internet;
	private String observacao;
	private Long idFornecedor;
	private Long idCentroCustoDesc;
	private Long idPlanoContasDesc;
	private String justificativaDesc;
	private String nomePortador;
	private Long idContaCorrente;
	private String nomeArquivo;

	public ContasPagarVO() {
		this.filtroDataPagamento = new FiltroWeb();
		this.filtroSituacao = new FiltroWeb();
	}

	public ContasPagarVO(Object[] linha) {
		super();
		if (linha != null) {
			setLinha(linha);

			this.idContasPagar = getLong();
			this.sigla = getString();
			this.empresa = getString();
			this.documento = getString();
			this.dataPagamento = getDate();
			this.dataVencimento = getDate();
			this.dataLancamento = getDate();
			this.dataProrrogado = getDate();
			this.valorBruto = getDouble();
			this.juros = getDouble();
			this.desconto = getDouble();
			this.valorLiquido = getDouble();
			this.valorPago = getDouble();
			this.numCheque = getString();
			this.tipoDocumento = getString();
			this.serieDocumento = getString();
			this.situacao = getString();
			this.contaCorrente = getLong();
			this.internet = getString();
			this.observacao = getString();
			this.idFornecedor = getLong();
			this.idCentroCustoDesc = getLong();
			this.idPlanoContasDesc = getLong();
			this.justificativaDesc = getString();
			this.idContaCorrente = getLong();
			getBytes();
			this.nomeArquivo = getString();
		}
	}

	public Long getIdContasPagar() {
		return this.idContasPagar;
	}

	public void setIdContasPagar(Long idContasPagar) {
		this.idContasPagar = idContasPagar;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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

	public Date getDataProrrogado() {
		return this.dataProrrogado;
	}

	public void setDataProrrogado(Date dataProrrogado) {
		this.dataProrrogado = dataProrrogado;
	}

	public Double getValorBruto() {
		return this.valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getJuros() {
		return this.juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorLiquido() {
		this.valorLiquido =

		Double.valueOf(this.valorBruto.doubleValue()
				+ (this.juros == null ? 0.0D : this.juros.doubleValue())
				- (this.desconto == null ? 0.0D : this.desconto.doubleValue()));
		return new Double(this.valorLiquido.doubleValue());
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Double getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public String getNumCheque() {
		return this.numCheque;
	}

	public void setNumCheque(String numCheque) {
		this.numCheque = numCheque;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public Long getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getInternet() {
		return this.internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public FiltroWeb getFiltroDataPagamento() {
		return this.filtroDataPagamento;
	}

	public void setFiltroDataPagamento(FiltroWeb filtroDataPagamento) {
		this.filtroDataPagamento = filtroDataPagamento;
	}

	public FiltroWeb getFiltroSituacao() {
		return this.filtroSituacao;
	}

	public void setFiltroSituacao(FiltroWeb filtroSituacao) {
		this.filtroSituacao = filtroSituacao;
	}

	public Long getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Long getIdCentroCustoDesc() {
		return this.idCentroCustoDesc;
	}

	public void setIdCentroCustoDesc(Long idCentroCustoDesc) {
		this.idCentroCustoDesc = idCentroCustoDesc;
	}

	public Long getIdPlanoContasDesc() {
		return this.idPlanoContasDesc;
	}

	public void setIdPlanoContasDesc(Long idPlanoContasDesc) {
		this.idPlanoContasDesc = idPlanoContasDesc;
	}

	public String getJustificativaDesc() {
		return this.justificativaDesc;
	}

	public void setJustificativaDesc(String justificativaDesc) {
		this.justificativaDesc = justificativaDesc;
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (this.idContasPagar == null ? 0 : this.idContasPagar
						.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		ContasPagarVO other = (ContasPagarVO) obj;
		if (this.idContasPagar == null) {
			if (other.getIdContasPagar() != null) {
				return false;
			}
		} else if (!this.idContasPagar.equals(other.getIdContasPagar())) {
			return false;
		}
		return true;
	}

	public String getNomePortador() {
		return this.nomePortador;
	}

	public void setNomePortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}

	public Long getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}	
}