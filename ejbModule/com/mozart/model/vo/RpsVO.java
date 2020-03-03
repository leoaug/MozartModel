package com.mozart.model.vo;

import java.math.BigDecimal;

import com.mozart.model.util.MozartUtil;

public class RpsVO extends MozartVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pais;

	public RpsVO() {

	}

	public RpsVO(Object[] filtro) {
		if (filtro != null) {
			setLinha(filtro);

			// this.naturezaOperacao = getString();
			// this.descontoIncondicionado = getString();
			// this.descontoCondicionado = getString();

			this.idNota = getBigDecimal();
			this.cgc = getString();
			this.inscricaoMunicipal = getString();
			this.notaInicial = getBigDecimal();
			this.serie = getString();
			this.tipo = getString();
			this.dataEmissao = getString();
			this.status = getBigDecimal();
			this.naturezaOperacao = getString();
			this.competencia = getString();
			this.valorServicos = getBigDecimal();
			this.valorPis = getBigDecimal();
			this.valorCofins = getBigDecimal();
			this.valorInss = getBigDecimal();
			this.valorIr = getBigDecimal();
			this.valorCsll = getBigDecimal();
			this.outrasRetencoes = getBigDecimal();
			this.valorIss = getBigDecimal();
			this.aliquotaIss = getBigDecimal();
			this.issRetido = getBigDecimal();
			this.responsavelRetencao = getBigDecimal();
			this.itemListaServico = getString();
			String tmpCnae = getString();
			if(tmpCnae != null && !"".equals(tmpCnae)){
				this.codigoCnae = new BigDecimal(tmpCnae);	
			}
			this.discriminacao = getString();
			this.codigoMunicipio = getBigDecimal();
			this.exigibilidadeISS = new BigDecimal(getString());
			//this.valorDeducoes = getBigDecimal();
			this.senha = getString();
			this.fraseSecreta = getString();
			this.cpfCnpjTomador = getString();
			if(this.cpfCnpjTomador != null){
				this.cpfCnpjTomador = this.cpfCnpjTomador.trim();
			}
			this.inscricaoMunicipalTomador = getString();
			this.razaoSocial = getString();
			this.enderecoTomador = getString();
			this.numeroTomador = getString();
			this.complementoTomador = getString();
			this.bairroTomador = getString();
			this.codigoMunicipioTomador = getBigDecimal();
			this.ufTomador = getString();
			this.cepTomador = getString	();
			this.pais = getString();
			this.eMailtomador = getString();
			String tmpRegime = getString();
			if(tmpRegime != null && !"".equals(tmpRegime)){
				this.regimeEspecialTributacao = new BigDecimal(tmpRegime);	
			}
			this.optanteSimplesNacional = getBigDecimal();
			this.incentivoCultura = getBigDecimal();
			this.producao = new BigDecimal(getString());
		}
	}

	private BigDecimal idNota;
	private String cgc;
	private String inscricaoMunicipal;
	private BigDecimal notaInicial;
	private String serie;
	private String tipo;
	private String dataEmissao;
	private BigDecimal status;
	private String competencia;
	private BigDecimal producao;
	private BigDecimal codigoCnae;
	private BigDecimal responsavelRetencao;
	private String naturezaOperacao;
	private BigDecimal optanteSimplesNacional;
	private BigDecimal incentivoCultura;
	private BigDecimal valorServicos;
	private BigDecimal valorDeducoes;
	private BigDecimal valorPis;
	private BigDecimal valorCofins;
	private BigDecimal valorInss;
	private BigDecimal valorIr;
	private BigDecimal valorCsll;
	private BigDecimal issRetido;
	private BigDecimal valorIss;
	private BigDecimal outrasRetencoes;
	private BigDecimal aliquotaIss;
	private String descontoIncondicionado;
	private String descontoCondicionado;
	private String itemListaServico;
	private String codigoTributacaoMunicipio;
	private String discriminacao;
	private BigDecimal codigoMunicipio;
	private BigDecimal exigibilidadeISS;
	private String senha;
	private String fraseSecreta;
	private String cpfCnpjTomador;
	private String inscricaoMunicipalTomador;
	private String razaoSocial;
	private String enderecoTomador;
	private String numeroTomador;
	private String complementoTomador;
	private String bairroTomador;
	private BigDecimal codigoMunicipioTomador;
	private String ufTomador;
	private BigDecimal regimeEspecialTributacao;
	private String cepTomador;
	private String eMailtomador;

	public BigDecimal getIdNota() {
		return idNota;
	}

	public void setIdNota(BigDecimal idNotal) {
		this.idNota = idNotal;
	}

	public String getCgc() {
		return cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public BigDecimal getNotaInicial() {
		return notaInicial;
	}

	public void setNotaInicial(BigDecimal notaInicial) {
		this.notaInicial = notaInicial;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}

	public void setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}

	public BigDecimal getOptanteSimplesNacional() {
		return optanteSimplesNacional;
	}

	public void setOptanteSimplesNacional(BigDecimal optanteSimplesNacional) {
		this.optanteSimplesNacional = optanteSimplesNacional;
	}

	public BigDecimal getIncentivoCultura() {
		return incentivoCultura;
	}

	public void setIncentivoCultura(BigDecimal incentivoCultura) {
		this.incentivoCultura = incentivoCultura;
	}

	public BigDecimal getValorServicos() {
		return valorServicos;
	}

	public void setValorServicos(BigDecimal valorServicos) {
		this.valorServicos = valorServicos;
	}

	public BigDecimal getValorDeducoes() {
		return valorDeducoes;
	}

	public void setValorDeducoes(BigDecimal valorDeducoes) {
		this.valorDeducoes = valorDeducoes;
	}

	public BigDecimal getValorPis() {
		return valorPis;
	}

	public void setValorPis(BigDecimal valorPis) {
		this.valorPis = valorPis;
	}

	public BigDecimal getValorCofins() {
		return valorCofins;
	}

	public void setValorCofins(BigDecimal valorCofins) {
		this.valorCofins = valorCofins;
	}

	public BigDecimal getValorInss() {
		return valorInss;
	}

	public void setValorInss(BigDecimal valorInss) {
		this.valorInss = valorInss;
	}

	public BigDecimal getValorIr() {
		return valorIr;
	}

	public void setValorIr(BigDecimal valorIr) {
		this.valorIr = valorIr;
	}

	public BigDecimal getValorCsll() {
		return valorCsll;
	}

	public void setValorCsll(BigDecimal valorCsll) {
		this.valorCsll = valorCsll;
	}

	public BigDecimal getIssRetido() {
		return issRetido;
	}

	public void setIssRetido(BigDecimal issRetido) {
		this.issRetido = issRetido;
	}

	public BigDecimal getValorIss() {
		return valorIss;
	}

	public void setValorIss(BigDecimal valorIss) {
		this.valorIss = valorIss;
	}

	public BigDecimal getOutrasRetencoes() {
		return outrasRetencoes;
	}

	public void setOutrasRetencoes(BigDecimal outrasRetencoes) {
		this.outrasRetencoes = outrasRetencoes;
	}

	public BigDecimal getAliquotaIss() {
		return aliquotaIss;
	}

	public void setAliquotaIss(BigDecimal aliquotaIss) {
		this.aliquotaIss = aliquotaIss;
	}

	public String getDescontoIncondicionado() {
		return descontoIncondicionado;
	}

	public void setDescontoIncondicionado(String descontoIncondicionado) {
		this.descontoIncondicionado = descontoIncondicionado;
	}

	public String getDescontoCondicionado() {
		return descontoCondicionado;
	}

	public void setDescontoCondicionado(String descontoCondicionado) {
		this.descontoCondicionado = descontoCondicionado;
	}

	public String getItemListaServico() {
		return itemListaServico;
	}

	public void setItemListaServico(String itemListaServico) {
		this.itemListaServico = itemListaServico;
	}

	public String getCodigoTributacaoMunicipio() {
		return codigoTributacaoMunicipio;
	}

	public void setCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
		this.codigoTributacaoMunicipio = codigoTributacaoMunicipio;
	}

	public String getDiscriminacao() {
		return discriminacao;
	}

	public void setDiscriminacao(String discriminacao) {
		this.discriminacao = discriminacao;
	}

	public BigDecimal getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(BigDecimal codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public BigDecimal getExigibilidadeISS() {
		return exigibilidadeISS;
	}

	public void setExigibilidadeISS(BigDecimal exigibilidadeISS) {
		this.exigibilidadeISS = exigibilidadeISS;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFraseSecreta() {
		return fraseSecreta;
	}

	public void setFraseSecreta(String fraseSecreta) {
		this.fraseSecreta = fraseSecreta;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpfCnpjTomador() {
		return cpfCnpjTomador;
	}

	public void setCpfCnpjTomador(String cpfCnpjTomador) {
		this.cpfCnpjTomador = cpfCnpjTomador;
	}

	public String getInscricaoMunicipalTomador() {
		return inscricaoMunicipalTomador;
	}

	public void setInscricaoMunicipalTomador(String inscricaoMunicipalTomador) {
		this.inscricaoMunicipalTomador = inscricaoMunicipalTomador;
	}

	public String getEnderecoTomador() {
		return enderecoTomador;
	}

	public void setEnderecoTomador(String enderecoTomador) {
		this.enderecoTomador = enderecoTomador;
	}

	public String getNumeroTomador() {
		return numeroTomador;
	}

	public void setNumeroTomador(String numeroTomador) {
		this.numeroTomador = numeroTomador;
	}

	public String getComplementoTomador() {
		return complementoTomador;
	}

	public void setComplementoTomador(String complementoTomador) {
		this.complementoTomador = complementoTomador;
	}

	public String getBairroTomador() {
		return bairroTomador;
	}

	public void setBairroTomador(String bairroTomador) {
		this.bairroTomador = bairroTomador;
	}

	public BigDecimal getCodigoMunicipioTomador() {
		return codigoMunicipioTomador;
	}

	public void setCodigoMunicipioTomador(BigDecimal codigoMunicipioTomador) {
		this.codigoMunicipioTomador = codigoMunicipioTomador;
	}

	public String getUfTomador() {
		return ufTomador;
	}

	public void setUfTomador(String ufTomador) {
		this.ufTomador = ufTomador;
	}

	public String getCepTomador() {
		return cepTomador;
	}

	public void setCepTomador(String cepTomador) {
		this.cepTomador = cepTomador;
	}

	public String geteMailtomador() {
		return eMailtomador;
	}

	public void seteMailtomador(String eMailtomador) {
		this.eMailtomador = eMailtomador;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public BigDecimal getProducao() {
		return producao;
	}

	public void setProducao(BigDecimal producao) {
		this.producao = producao;
	}

	public BigDecimal getCodigoCnae() {
		return codigoCnae;
	}

	public void setCodigoCnae(BigDecimal codigoCnae) {
		this.codigoCnae = codigoCnae;
	}

	public BigDecimal getResponsavelRetencao() {
		return responsavelRetencao;
	}

	public void setResponsavelRetencao(BigDecimal responsavelRetencao) {
		this.responsavelRetencao = responsavelRetencao;
	}

	public BigDecimal getRegimeEspecialTributacao() {
		return regimeEspecialTributacao;
	}

	public void setRegimeEspecialTributacao(BigDecimal regimeEspecialTributacao) {
		this.regimeEspecialTributacao = regimeEspecialTributacao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
