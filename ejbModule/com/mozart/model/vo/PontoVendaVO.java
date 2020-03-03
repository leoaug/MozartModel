package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class PontoVendaVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroNomePontoVenda;
	private FiltroWeb filtroNomeProprietario;
	private FiltroWeb filtroTipoPontoVenda;
	

	
	private Long idPontoVenda;
	private String proprietario;
	private String descricao;
	private Double taxaServico;
	private String tipoPdv;
	
	
	
	public PontoVendaVO(){
		
		filtroNomePontoVenda = new FiltroWeb();
		filtroNomeProprietario = new FiltroWeb();	
		filtroTipoPontoVenda = new FiltroWeb();
		
	}	
	
	public PontoVendaVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
			idPontoVenda = getLong();
			descricao = getString();
			tipoPdv = getString();
			proprietario = getString();
			taxaServico = getDouble();
			
			
		}
		
	}

	public FiltroWeb getFiltroNomePontoVenda() {
		return filtroNomePontoVenda;
	}

	public void setFiltroNomePontoVenda(FiltroWeb filtroNomePontoVenda) {
		this.filtroNomePontoVenda = filtroNomePontoVenda;
	}

	
	public Long getIdPontoVenda() {
		return idPontoVenda;
	}

	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public FiltroWeb getFiltroNomeProprietario() {
		return filtroNomeProprietario;
	}

	public void setFiltroNomeProprietario(FiltroWeb filtroNomeProprietario) {
		this.filtroNomeProprietario = filtroNomeProprietario;
	}

	public FiltroWeb getFiltroTipoPontoVenda() {
		return filtroTipoPontoVenda;
	}

	public void setFiltroTipoPontoVenda(FiltroWeb filtroTipoPontoVenda) {
		this.filtroTipoPontoVenda = filtroTipoPontoVenda;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(Double taxaServico) {
		this.taxaServico = taxaServico;
	}

	public String getTipoPdv() {
		return tipoPdv;
	}

	public void setTipoPdv(String tipoPdv) {
		this.tipoPdv = tipoPdv;
	}

		
	
}