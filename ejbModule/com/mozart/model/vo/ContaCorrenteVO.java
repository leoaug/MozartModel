package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ContaCorrenteVO extends MozartVO {
	private static final long serialVersionUID = 1L;
	private FiltroWeb filtroContaCorrente;
	private FiltroWeb filtroNumeroAgencia;
	private Long numContaCorrente;
	private Long idContaCorrente;
	private String banco;
	private String nomeAgencia;
	private Long numeroAgencia;
	private String cobranca;
	private String boleto;
	private String pagamento;
	private String fluxoCaixa;
	private String carteira;
	private String ultimoCheque;
	private String historicoCredito;
	private String historicoDebito;
	private String nomeContasRec;
	private String nomeContasPag;
	private String centroCustosRec;
	private String centroCustosPag;
	private Long idContabilRec;
	private Long idContabilPag;
	private String bancoAgenciaContaCorrente;
	private Long idHotel;
	
	private FiltroWeb filtroPagamento;

	public ContaCorrenteVO() {
		setFiltroContaCorrente(new FiltroWeb());
		setFiltroNumeroAgencia(new FiltroWeb());
		setFiltroPagamento(new FiltroWeb("C", "3"));
	}

	public ContaCorrenteVO(Object[] filtro) {
		if (filtro != null) {
			setLinha(filtro);
			
			this.idContaCorrente = getLong();
			this.numContaCorrente = getLong();
			this.banco = getString();
			this.nomeAgencia = getString();
			this.numeroAgencia = getLong();
			this.cobranca = getString();
			this.pagamento = getString();
			this.historicoCredito = getString();
			this.historicoDebito = getString();
			this.nomeContasRec = getString();
			this.nomeContasPag = getString();
			this.centroCustosRec = getString();
			this.centroCustosPag = getString();
			this.idContabilRec = getLong();
			this.carteira = getString();
		}
	}

	public String toString() {
		return this.numContaCorrente + " - " + this.numeroAgencia + " - "
				+ this.banco;
	}

	public void setFiltroContaCorrente(FiltroWeb filtroContaCorrente) {
		this.filtroContaCorrente = filtroContaCorrente;
	}

	public FiltroWeb getFiltroContaCorrente() {
		return this.filtroContaCorrente;
	}

	public void setFiltroNumeroAgencia(FiltroWeb filtroNumeroAgencia) {
		this.filtroNumeroAgencia = filtroNumeroAgencia;
	}

	public FiltroWeb getFiltroNumeroAgencia() {
		return this.filtroNumeroAgencia;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCobranca() {
		return this.cobranca;
	}

	public void setCobranca(String cobranca) {
		this.cobranca = cobranca;
	}

	public String getPagamento() {
		return this.pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getHistoricoCredito() {
		return this.historicoCredito;
	}

	public void setHistoricoCredito(String historicoCredito) {
		this.historicoCredito = historicoCredito;
	}

	public String getHistoricoDebito() {
		return this.historicoDebito;
	}

	public void setHistoricoDebito(String historicoDebito) {
		this.historicoDebito = historicoDebito;
	}

	public String getNomeContasRec() {
		return this.nomeContasRec;
	}

	public void setNomeContasRec(String nomeContasRec) {
		this.nomeContasRec = nomeContasRec;
	}

	public String getNomeContasPag() {
		return this.nomeContasPag;
	}

	public void setNomeContasPag(String nomeContasPag) {
		this.nomeContasPag = nomeContasPag;
	}

	public String getCentroCustosRec() {
		return this.centroCustosRec;
	}

	public void setCentroCustosRec(String centroCustosRec) {
		this.centroCustosRec = centroCustosRec;
	}

	public String getCentroCustosPag() {
		return this.centroCustosPag;
	}

	public void setCentroCustosPag(String centroCustosPag) {
		this.centroCustosPag = centroCustosPag;
	}

	public Long getIdContaCorrente() {
		return this.idContaCorrente;
	}

	public void setIdContaCorrente(Long contaCorrente) {
		this.idContaCorrente = contaCorrente;
	}
	
	public String getNomeAgencia() {
		return this.nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public Long getNumeroAgencia() {
		return this.numeroAgencia;
	}

	public void setNumeroAgencia(Long numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getFluxoCaixa() {
		return this.fluxoCaixa;
	}

	public void setFluxoCaixa(String fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	public String getCarteira() {
		return this.carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public String getUltimoCheque() {
		return this.ultimoCheque;
	}

	public void setUltimoCheque(String ultimoCheque) {
		this.ultimoCheque = ultimoCheque;
	}

	public Long getIdContabilRec() {
		return this.idContabilRec;
	}

	public void setIdContabilRec(Long idContabilRec) {
		this.idContabilRec = idContabilRec;
	}

	public Long getIdContabilPag() {
		return this.idContabilPag;
	}

	public void setIdContabilPag(Long idContabilPag) {
		this.idContabilPag = idContabilPag;
	}

	public Long getNumContaCorrente() {
		return numContaCorrente;
	}

	public void setNumContaCorrente(Long numContaCorrente) {
		this.numContaCorrente = numContaCorrente;
	}

	public String getBancoAgenciaContaCorrente() {
		return bancoAgenciaContaCorrente;
	}

	public void setBancoAgenciaContaCorrente(String bancoAgenciaContaCorrente) {
		this.bancoAgenciaContaCorrente = bancoAgenciaContaCorrente;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public FiltroWeb getFiltroPagamento() {
		return filtroPagamento;
	}

	public void setFiltroPagamento(FiltroWeb filtroPagamento) {
		this.filtroPagamento = filtroPagamento;
	}

	public String getBoleto() {
		return boleto;
	}

	public void setBoleto(String boleto) {
		this.boleto = boleto;
	}
	
}