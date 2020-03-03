package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class ClassificacaoContabilPadraoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2682028379743323260L;

	private String sigla;
	private Long idClassificacaoContabil;
	private String descricaoCentroCusto;
	private String contaReduzida;
	private String nomeConta;
	private String descricao;
	private Double percentual;
	private String debitoCredito;
	private String contaFinanceira;
	private String pis;
	
	private FiltroWeb filtroDescricao;
	/**
	 * @param linha
	 * 
	 * sigla = String
	 * idClassificacaoContabil = Long
	 * descricaoCentroCusto = String
	 * contaReduzida = String
	 * nomeConta = String
	 * descricao = String
	 * percentual = Long
	 * debitoCredito = String
	 * contaFinanceira =  String
	 * pis = String
	 * 	
	 * */
	public ClassificacaoContabilPadraoVO(Object[] linha) {
		if (!MozartUtil.isNull(linha)) {
			setLinha(linha);
			sigla = getString();
			idClassificacaoContabil = getLong();
			descricaoCentroCusto = getString();
			contaReduzida = getString();
			nomeConta = getString();
			descricao = getString();
			percentual = getDouble();
			debitoCredito = getString();
			contaFinanceira = getString();
			pis = getString();
		}
	}


	public ClassificacaoContabilPadraoVO() {
		filtroDescricao = new FiltroWeb();
		
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public Long getIdClassificacaoContabil() {
		return idClassificacaoContabil;
	}


	public void setIdClassificacaoContabil(Long idClassificacaoContabil) {
		this.idClassificacaoContabil = idClassificacaoContabil;
	}


	public String getDescricaoCentroCusto() {
		return descricaoCentroCusto;
	}


	public void setDescricaoCentroCusto(String descricaoCentroCusto) {
		this.descricaoCentroCusto = descricaoCentroCusto;
	}


	public String getContaReduzida() {
		return contaReduzida;
	}


	public void setContaReduzida(String contaReduzida) {
		this.contaReduzida = contaReduzida;
	}


	public String getNomeConta() {
		return nomeConta;
	}


	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPercentual() {
		return percentual;
	}


	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}


	public String getDebitoCredito() {
		return debitoCredito;
	}


	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}


	public String getContaFinanceira() {
		return contaFinanceira;
	}


	public void setContaFinanceira(String contaFinanceira) {
		this.contaFinanceira = contaFinanceira;
	}


	public String getPis() {
		return pis;
	}


	public void setPis(String pis) {
		this.pis = pis;
	}


	public FiltroWeb getFiltroDescricao() {
		return filtroDescricao;
	}


	public void setFiltroDescricao(FiltroWeb filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	
}
