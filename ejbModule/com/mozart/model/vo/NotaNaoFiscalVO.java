package com.mozart.model.vo;

import java.util.List;

public class NotaNaoFiscalVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038980128571235166L;
	
	
	private DadosGeraisNotaVO dadosGerais;
	private List<DadosDescricaoVendaNotaVO> dadosItens;
	private DadosResumoItensNotaVO dadosResumoItensNota;
	private List<DadosFormaPagamentoNotaVO> dadosFormaPagamento;
	private String chaveNota;
	private String urlQrCode;
	private String cpfCnpjConsumidor;
	private String nomeImpressora;
	
	public NotaNaoFiscalVO(){
	}

	public DadosGeraisNotaVO getDadosGerais() {
		return dadosGerais;
	}

	public void setDadosGerais(DadosGeraisNotaVO dadosGerais) {
		this.dadosGerais = dadosGerais;
	}

	public List<DadosDescricaoVendaNotaVO> getDadosItens() {
		return dadosItens;
	}

	public void setDadosItens(List<DadosDescricaoVendaNotaVO> dadosItens) {
		this.dadosItens = dadosItens;
	}

	public DadosResumoItensNotaVO getDadosResumoItensNota() {
		return dadosResumoItensNota;
	}

	public void setDadosResumoItensNota(DadosResumoItensNotaVO dadosResumoItensNota) {
		this.dadosResumoItensNota = dadosResumoItensNota;
	}

	public List<DadosFormaPagamentoNotaVO> getDadosFormaPagamento() {
		return dadosFormaPagamento;
	}

	public void setDadosFormaPagamento(
			List<DadosFormaPagamentoNotaVO> dadosFormaPagamento) {
		this.dadosFormaPagamento = dadosFormaPagamento;
	}

	public String getChaveNota() {
		return chaveNota;
	}

	public void setChaveNota(String chaveNota) {
		this.chaveNota = chaveNota;
	}

	public String getUrlQrCode() {
		return urlQrCode;
	}

	public void setUrlQrCode(String urlQrCode) {
		this.urlQrCode = urlQrCode;
	}

	public String getCpfCnpjConsumidor() {
		return cpfCnpjConsumidor;
	}

	public void setCpfCnpjConsumidor(String cpfCnpjConsumidor) {
		this.cpfCnpjConsumidor = cpfCnpjConsumidor;
	}

	public String getNomeImpressora() {
		return nomeImpressora;
	}

	public void setNomeImpressora(String nomeImpressora) {
		this.nomeImpressora = nomeImpressora;
	}
}
