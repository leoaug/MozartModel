package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class TipoLancamentoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4382371203759853515L;
	
	private Long idTipoLancamento;
	private String sigla;
	private String descricaoLancamento;
	private String grupo;
	private String subGrupo;
	private String debitoCredito;
	private String notaFiscal;
	private String iss;
	private String taxaServico;
	private Long idIdentificaLancamento;
	
	/*Filtros*/
	private FiltroWeb filtroDescricao;
	private FiltroWeb filtroGrupo;
	private FiltroWeb filtroSubGrupo;
	
	
	public TipoLancamentoVO(){
		filtroDescricao = new FiltroWeb();
		filtroGrupo = new FiltroWeb();
		filtroSubGrupo = new FiltroWeb();
	}
	
	public TipoLancamentoVO(Object[] linha){
		
		if (linha != null){
			setLinha(linha);
			idTipoLancamento = getLong();
			sigla = getString();
			descricaoLancamento = getString();
			grupo = getString();
			subGrupo = getString();
			debitoCredito = getString();
			notaFiscal = getString();
			iss = getString();
			taxaServico = getString();
			idIdentificaLancamento = getLong();
		}
		
		
	}

	public Long getIdTipoLancamento() {
		return idTipoLancamento;
	}

	public void setIdTipoLancamento(Long idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(String subGrupo) {
		this.subGrupo = subGrupo;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(String taxaServico) {
		this.taxaServico = taxaServico;
	}

	public FiltroWeb getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(FiltroWeb filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public FiltroWeb getFiltroGrupo() {
		return filtroGrupo;
	}

	public void setFiltroGrupo(FiltroWeb filtroGrupo) {
		this.filtroGrupo = filtroGrupo;
	}

	public FiltroWeb getFiltroSubGrupo() {
		return filtroSubGrupo;
	}

	public void setFiltroSubGrupo(FiltroWeb filtroSubGrupo) {
		this.filtroSubGrupo = filtroSubGrupo;
	}

	public Long getIdIdentificaLancamento() {
		return idIdentificaLancamento;
	}

	public void setIdIdentificaLancamento(Long idIdentificaLancamento) {
		this.idIdentificaLancamento = idIdentificaLancamento;
	}
	

}
