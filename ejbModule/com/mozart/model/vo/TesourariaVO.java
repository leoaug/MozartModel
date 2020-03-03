package com.mozart.model.vo;

import java.sql.Timestamp;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class TesourariaVO extends ContasPagarVO {

	private static final long serialVersionUID = -4772639499425836925L;
	
	private Long idTesouraria;
	private String sigla;
	private String nomeContaCorrente;
	private Long contaCorrente;
	private Timestamp data;
	private Double valor;
	private String debitoCredito;
	private String conciliado;
	private Timestamp dataConciliado;
	private String numDocumento;
	private String historicoPadrao;
	
	/*Filtros*/
	
	private FiltroWeb filtroContaReduzida;
	private FiltroWeb filtroComplementoHistorico;
	private FiltroWeb filtroConciliado;
	private FiltroWeb filtroNomeConta;
	private FiltroWeb filtroValor;
	private FiltroWeb filtroContaCorrente;
	private FiltroWeb filtroDataConciliado;
	private FiltroWeb filtroDataLancamento;
	
	public TesourariaVO(){
		filtroContaReduzida = new FiltroWeb();
		filtroComplementoHistorico = new FiltroWeb();
		filtroConciliado = new FiltroWeb();
		filtroNomeConta = new FiltroWeb();
		filtroValor = new FiltroWeb();
		filtroContaCorrente = new FiltroWeb();
		filtroDataConciliado = new FiltroWeb();
		filtroDataLancamento = new FiltroWeb();
	}

	public TesourariaVO(Object[] linha){
		if (!MozartUtil.isNull(linha)){
			setLinha( linha );
			idTesouraria = getLong();
			sigla = getString();
			nomeContaCorrente = getString();
			contaCorrente = getLong();
			data = getTimestamp();
			valor = getDouble();
			debitoCredito = getString();
			conciliado = getString();
			dataConciliado = getTimestamp();
			numDocumento = getString();
			historicoPadrao = getString();
		}
	}

	public Long getIdTesouraria() {
		return idTesouraria;
	}

	public void setIdTesouraria(Long idTesouraria) {
		this.idTesouraria = idTesouraria;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNomeContaCorrente() {
		return nomeContaCorrente;
	}

	public void setNomeContaCorrente(String nomeContaCorrente) {
		this.nomeContaCorrente = nomeContaCorrente;
	}

	public Long getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public String getConciliado() {
		return conciliado;
	}

	public void setConciliado(String conciliado) {
		this.conciliado = conciliado;
	}

	public Timestamp getDataConciliado() {
		return dataConciliado;
	}

	public void setDataConciliado(Timestamp dataConciliado) {
		this.dataConciliado = dataConciliado;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getHistoricoPadrao() {
		return historicoPadrao;
	}

	public void setHistoricoPadrao(String historicoPadrao) {
		this.historicoPadrao = historicoPadrao;
	}

	public FiltroWeb getFiltroContaReduzida() {
		return filtroContaReduzida;
	}

	public void setFiltroContaReduzida(FiltroWeb filtroContaReduzida) {
		this.filtroContaReduzida = filtroContaReduzida;
	}

	public FiltroWeb getFiltroComplementoHistorico() {
		return filtroComplementoHistorico;
	}

	public void setFiltroComplementoHistorico(FiltroWeb filtroComplementoHistorico) {
		this.filtroComplementoHistorico = filtroComplementoHistorico;
	}

	public FiltroWeb getFiltroConciliado() {
		return filtroConciliado;
	}

	public void setFiltroConciliado(FiltroWeb filtroConciliado) {
		this.filtroConciliado = filtroConciliado;
	}

	public FiltroWeb getFiltroNomeConta() {
		return filtroNomeConta;
	}

	public void setFiltroNomeConta(FiltroWeb filtroNomeConta) {
		this.filtroNomeConta = filtroNomeConta;
	}

	public FiltroWeb getFiltroValor() {
		return filtroValor;
	}

	public void setFiltroValor(FiltroWeb filtroValor) {
		this.filtroValor = filtroValor;
	}

	public FiltroWeb getFiltroContaCorrente() {
		return filtroContaCorrente;
	}

	public void setFiltroContaCorrente(FiltroWeb filtroContaCorrente) {
		this.filtroContaCorrente = filtroContaCorrente;
	}

	public FiltroWeb getFiltroDataConciliado() {
		return filtroDataConciliado;
	}

	public void setFiltroDataConciliado(FiltroWeb filtroDataConciliado) {
		this.filtroDataConciliado = filtroDataConciliado;
	}

	public FiltroWeb getFiltroDataLancamento() {
		return filtroDataLancamento;
	}

	public void setFiltroDataLancamento(FiltroWeb filtroDataLancamento) {
		this.filtroDataLancamento = filtroDataLancamento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTesouraria == null) ? 0 : idTesouraria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		TesourariaVO other = (TesourariaVO) obj;
		if (idTesouraria == null) {
			if (other.getIdTesouraria() != null)
				return false;
		} else if (!idTesouraria.equals(other.getIdTesouraria()))
			return false;
		
		return true;
	}	
}