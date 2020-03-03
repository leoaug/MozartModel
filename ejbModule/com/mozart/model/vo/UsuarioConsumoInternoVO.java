package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class UsuarioConsumoInternoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb NomeFantasia;
	private FiltroWeb Ativo;
	private FiltroWeb CentroCusto;
	private FiltroWeb Nome;
	
	private String sigla;
	private String nomeUsuario;
	private String ativoDesc;
	private String centroCustoDesc;
	private Date validadeInicial;
	private Date validadeFinal;
	private String alcoolica;
	private String pensao;
	private long codUsuario;
	
	public UsuarioConsumoInternoVO(){
		
		NomeFantasia = new FiltroWeb();
		Ativo = new FiltroWeb();
		CentroCusto = new FiltroWeb();
		Nome = new FiltroWeb();
	}	
	
	public UsuarioConsumoInternoVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			codUsuario = getLong();
			nomeUsuario = getString();
			ativoDesc = getString();
			centroCustoDesc = getString();
			validadeInicial = getDate();
			validadeFinal = getDate();
			alcoolica = getString();
			pensao = getString();
			sigla = getString();
		}
		
	}

	public FiltroWeb getNomeFantasia() {
		return NomeFantasia;
	}

	public void setNomeFantasia(FiltroWeb nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}

	public FiltroWeb getAtivo() {
		return Ativo;
	}

	public void setAtivo(FiltroWeb ativo) {
		Ativo = ativo;
	}

	public FiltroWeb getCentroCusto() {
		return CentroCusto;
	}

	public void setCentroCusto(FiltroWeb centroCusto) {
		CentroCusto = centroCusto;
	}

	public FiltroWeb getNome() {
		return Nome;
	}

	public void setNome(FiltroWeb nome) {
		Nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getAtivoDesc() {
		return ativoDesc;
	}

	public void setAtivoDesc(String ativoDesc) {
		this.ativoDesc = ativoDesc;
	}

	public String getCentroCustoDesc() {
		return centroCustoDesc;
	}

	public void setCentroCustoDesc(String centroCustoDesc) {
		this.centroCustoDesc = centroCustoDesc;
	}

	public Date getValidadeInicial() {
		return validadeInicial;
	}

	public void setValidadeInicial(Date validadeInicial) {
		this.validadeInicial = validadeInicial;
	}

	public Date getValidadeFinal() {
		return validadeFinal;
	}

	public void setValidadeFinal(Date validadeFinal) {
		this.validadeFinal = validadeFinal;
	}

	public String getAlcoolica() {
		return alcoolica;
	}

	public void setAlcoolica(String alcoolica) {
		this.alcoolica = alcoolica;
	}

	public String getPensao() {
		return pensao;
	}

	public void setPensao(String pensao) {
		this.pensao = pensao;
	}

	public long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}
}
