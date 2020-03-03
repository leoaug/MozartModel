package com.mozart.model.vo;


public class ConfiguracaoTributarioVO extends MozartVO {

	private static final long serialVersionUID = 7540220476141649729L;

	private Long idHotel;
	private Long numeroRps;
	private String serie;
	private String subSerie;
	private Double issAliquota;
	private Double impIncidentesS;
	private String aidf;
	private String producao;
	private String incetivoFiscal;
	private Long lote;
	private Long idExibilidade;
	private String exibilidade;
	private String prefeitura;
	private String codigoServico;
	private String senha;
	private String fraseSecreta;
	private String discriminacao;
	private Double impIncidentesM;
	private Long idRegimeTributario;
	private String regimeTributario;
	private String tabelaServico;
	private String cnae;
	private String sigla;
	private String cnpjAutorizado;
	private String cpfAutorizado;
	
	public ConfiguracaoTributarioVO() {
	}

	public ConfiguracaoTributarioVO(Object[] linha) {
		if (linha != null) {
				       
			setLinha(linha);
			idHotel = getLong();
			numeroRps = getLong();
			serie = getString();
			subSerie = getString();
			issAliquota = getDouble();
			impIncidentesS = getDouble();
			aidf = getString();
			producao = getString();
			incetivoFiscal = getString();
			lote = getLong();
			idExibilidade = getLong();
			exibilidade = getString();
			prefeitura = getString();
			codigoServico = getString();
			senha = getString();
			fraseSecreta = getString();
			discriminacao = getString();
			impIncidentesM = getDouble();
			idRegimeTributario = getLong();
			regimeTributario = getString();
			tabelaServico = getString();
			cnae = getString();
			sigla = getString();
			cnpjAutorizado = getString();
			cpfAutorizado = getString();
		}
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getNumeroRps() {
		return numeroRps;
	}

	public void setNumeroRps(Long numeroRps) {
		this.numeroRps = numeroRps;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSubSerie() {
		return subSerie;
	}

	public void setSubSerie(String subSerie) {
		this.subSerie = subSerie;
	}

	
	public Double getIssAliquota() {
		return issAliquota;
	}

	public void setIssAliquota(Double issAliquota) {
		this.issAliquota = issAliquota;
	}

	public Double getImpIncidentesS() {
		return impIncidentesS;
	}

	public void setImpIncidentesS(Double impIncidentesS) {
		this.impIncidentesS = impIncidentesS;
	}

	public String getAidf() {
		return aidf;
	}

	public void setAidf(String aidf) {
		this.aidf = aidf;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

	public String getIncetivoFiscal() {
		return incetivoFiscal;
	}

	public void setIncetivoFiscal(String incetivoFiscal) {
		this.incetivoFiscal = incetivoFiscal;
	}

	public Long getLote() {
		return lote;
	}

	public void setLote(Long lote) {
		this.lote = lote;
	}

	public String getExibilidade() {
		return exibilidade;
	}

	public void setExibilidade(String exibilidade) {
		this.exibilidade = exibilidade;
	}

	public String getPrefeitura() {
		return prefeitura;
	}

	public void setPrefeitura(String prefeitura) {
		this.prefeitura = prefeitura;
	}

	public String getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(String codigoServico) {
		this.codigoServico = codigoServico;
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

	public String getDiscriminacao() {
		return discriminacao;
	}

	public void setDiscriminacao(String discriminacao) {
		this.discriminacao = discriminacao;
	}

	public Double getImpIncidentesM() {
		return impIncidentesM;
	}

	public void setImpIncidentesM(Double impIncidentesM) {
		this.impIncidentesM = impIncidentesM;
	}

	public String getRegimeTributario() {
		return regimeTributario;
	}

	public void setRegimeTributario(String regimeTributario) {
		this.regimeTributario = regimeTributario;
	}

	public String getTabelaServico() {
		return tabelaServico;
	}

	public void setTabelaServico(String tabelaServico) {
		this.tabelaServico = tabelaServico;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Long getIdExibilidade() {
		return idExibilidade;
	}

	public void setIdExibilidade(Long idExibilidade) {
		this.idExibilidade = idExibilidade;
	}

	public Long getIdRegimeTributario() {
		return idRegimeTributario;
	}

	public void setIdRegimeTributario(Long idRegimeTributario) {
		this.idRegimeTributario = idRegimeTributario;
	}

	public String getCnpjAutorizado() {
		return cnpjAutorizado;
	}

	public void setCnpjAutorizado(String cnpjAutorizado) {
		this.cnpjAutorizado = cnpjAutorizado;
	}

	public String getCpfAutorizado() {
		return cpfAutorizado;
	}

	public void setCpfAutorizado(String cpfAutorizado) {
		this.cpfAutorizado = cpfAutorizado;
	}
}
