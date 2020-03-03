package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class DadosGeraisNotaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038980128571235166L;
	
	
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String descricaoNfce;
	private String contingencia;
	private String numNota;
	private String dataEmissao;
	private String descricaoViaConsumidor;
	private String descricaoConsulte;
	private String chaveGerada;
	private String decricaoProtocolo;
	private String aidf;
	private String aidfData;
	private String descricaoConsumidor;
	private String discriminacao;
	private String orgao1;
	private String orgao2;
	private String descricaoCodMozart;
	private String descricaoPdv;
	private Long idPdv;
	private String serie;
	
	public DadosGeraisNotaVO(){
	}

	public DadosGeraisNotaVO(Object[] linha){
		
		if (!MozartUtil.isNull(linha)){
			setLinha( linha );
			razaoSocial = getString();
			cnpj = getString();
			inscricaoEstadual = getString();
			endereco = getString();
			numero = getString();
			complemento = getString();
			bairro = getString();
			cidade = getString();
			uf = getString();
			cep = getString();
			descricaoNfce = getString();
			contingencia = getString();
			numNota = getString();
			dataEmissao = getString();
			descricaoViaConsumidor = getString();
			descricaoConsulte = getString();
			chaveGerada = getString();
			decricaoProtocolo = getString();
			aidf = getString();
			aidfData = getString();
			descricaoConsumidor = getString();
			discriminacao = getString();
			orgao1 = getString();
			orgao2 = getString();
			descricaoCodMozart = getString();
			descricaoPdv = getString();
			idPdv = getLong();
			serie = getString();
		}
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescricaoNfce() {
		return descricaoNfce;
	}

	public void setDescricaoNfce(String descricaoNfce) {
		this.descricaoNfce = descricaoNfce;
	}

	public String getContingencia() {
		return contingencia;
	}

	public void setContingencia(String contingencia) {
		this.contingencia = contingencia;
	}

	public String getNumNota() {
		return numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getDescricaoViaConsumidor() {
		return descricaoViaConsumidor;
	}

	public void setDescricaoViaConsumidor(String descricaoViaConsumidor) {
		this.descricaoViaConsumidor = descricaoViaConsumidor;
	}

	public String getDescricaoConsulte() {
		return descricaoConsulte;
	}

	public void setDescricaoConsulte(String descricaoConsulte) {
		this.descricaoConsulte = descricaoConsulte;
	}

	public String getChaveGerada() {
		return chaveGerada;
	}

	public void setChaveGerada(String chaveGerada) {
		this.chaveGerada = chaveGerada;
	}

	public String getDecricaoProtocolo() {
		return decricaoProtocolo;
	}

	public void setDecricaoProtocolo(String decricaoProtocolo) {
		this.decricaoProtocolo = decricaoProtocolo;
	}

	public String getAidf() {
		return aidf;
	}

	public void setAidf(String aidf) {
		this.aidf = aidf;
	}

	public String getAidfData() {
		return aidfData;
	}

	public void setAidfData(String aidfData) {
		this.aidfData = aidfData;
	}

	public String getDescricaoConsumidor() {
		return descricaoConsumidor;
	}

	public void setDescricaoConsumidor(String descricaoConsumidor) {
		this.descricaoConsumidor = descricaoConsumidor;
	}

	public String getDiscriminacao() {
		return discriminacao;
	}

	public void setDiscriminacao(String discriminacao) {
		this.discriminacao = discriminacao;
	}

	public String getOrgao1() {
		return orgao1;
	}

	public void setOrgao1(String orgao1) {
		this.orgao1 = orgao1;
	}

	public String getOrgao2() {
		return orgao2;
	}

	public void setOrgao2(String orgao2) {
		this.orgao2 = orgao2;
	}

	public String getDescricaoCodMozart() {
		return descricaoCodMozart;
	}

	public void setDescricaoCodMozart(String descricaoCodMozart) {
		this.descricaoCodMozart = descricaoCodMozart;
	}

	public String getDescricaoPdv() {
		return descricaoPdv;
	}

	public void setDescricaoPdv(String descricaoPdv) {
		this.descricaoPdv = descricaoPdv;
	}

	public Long getIdPdv() {
		return idPdv;
	}

	public void setIdPdv(Long idPdv) {
		this.idPdv = idPdv;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	
}
