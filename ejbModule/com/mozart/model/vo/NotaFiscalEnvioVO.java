package com.mozart.model.vo;

import java.text.ParseException;
import java.util.Calendar;

import com.mozart.model.util.MozartUtil;

public class NotaFiscalEnvioVO extends MozartVO {

	private static final long serialVersionUID = 1L;

	private Long idHotel;
	private Long filtroIdNotaFiscal;
	
	private String idNotaFiscal;
	private String token;
	private String cpfCnpjEmpresa;
	private String cpfCnpjCliente;
	private String nomeCliente;
	private String cep;
	private String foneCliente;
	private long indicadorIdDestinatario;
	private String emailCliente;
	private Calendar dataEmissaoNf;
	private String modeloNf;
	private String serieNf;
	private String numeroNf;
	private long tipoEmissaoNf;
	private String codigoNf;
	private String natOperacaoNf;
	private String indPagNf;
	private String tipoNf;
	private String tipoImpressao;
	private String numeroLote;
	private String numeroResidencia;
	private String complementoCliente;
	private String tfinNfe;
	private String indfinal;
	private long indiedest;
	private long tipoPagamento;
	private String infcpl;
	private String infoperador;
	private double vlPago;
	private double vlTroco;
	private String tipoFrete;
	private String cnpjTransportador;
	private String razaoSocialTransportadora;
	private String inscEstadualTransportadora;
	private String cepTransportadora;
	private String logradouroTransportadora;
	private String numeroTransportadora;
	private String bairroTransportadora;
	private String codigoAntt;
	private String municipioTransportadora;
	private String ufTransportadora;
	private String placaVeiculo;
	private String qtdTransportado;
	private String especie;
	private String marca;
	private String numeracao;
	private String pesoBruto;
	private String pesoLiquido;
	private String logradouroCliente;
	private String bairroCliente;
	private Calendar dataSaida;
	private String ieCliente;
	private String nfRef;
	private String nfat;
	private String ndup;
	private Calendar vencimento;
	private double precoFrete;
	private double vicmsdeson;
	private double vfcpufdest;
	private double vfcp;
	private double vfcpst;
	private double vfcpstret;
	private double vii;
	private double vipidevol;
	private double valorDesconto;
	
	private String idDestNf;
	private String inffonte;
	
	public NotaFiscalEnvioVO() {

	}

	public NotaFiscalEnvioVO(Object[] filtro) throws ParseException {
		if (filtro != null) {
			setLinha(filtro);
			
			token = getString();
			cpfCnpjEmpresa = getString();
			cpfCnpjCliente = getString();
			nomeCliente = getString();
			cep = getString();
			foneCliente = getString();
			indicadorIdDestinatario = getLong();
			emailCliente = getString();
			dataEmissaoNf = MozartUtil.stringToCalendar(getString());
			modeloNf = getString();
			serieNf = getString();
			numeroNf = getString();
			tipoEmissaoNf = getLong();
			codigoNf = getString();
			natOperacaoNf = getString();
			indPagNf = getString();
			tipoNf = getString();
			tipoImpressao = getString();
			numeroLote = getString();
			numeroResidencia = getString();
			complementoCliente = getString();
			tfinNfe = getString();
			indfinal = getString();
			indiedest = getLong();
			tipoPagamento = getLong();
			infcpl = getString();
			infoperador = getString();
			vlTroco = getDouble();
			tipoFrete = getString();
			cnpjTransportador = getString();
			razaoSocialTransportadora = getString();
			inscEstadualTransportadora = getString();
			cepTransportadora = getString();
			logradouroTransportadora = getString();
			numeroTransportadora = getString();
			bairroTransportadora = getString();
			codigoAntt = getString();
			municipioTransportadora = getString();
			ufTransportadora = getString();
			placaVeiculo = getString();
			qtdTransportado = getString();
			especie = getString();
			marca = getString();
			numeracao = getString();
			pesoBruto = getString();
			pesoLiquido = getString();
			logradouroCliente = getString();
			bairroCliente = getString();
			dataSaida = MozartUtil.stringToCalendar(getString());
			ieCliente = getString();
			nfRef = getString();
			nfat = getString();
			ndup = getString();
			vencimento = MozartUtil.stringToCalendar(getString());
			precoFrete = getDouble();
			vicmsdeson = getDouble();
			vfcpufdest = getDouble();
			vfcp = getDouble();
			vfcpst = getDouble();
			vfcpstret = getDouble();
			vii = getDouble();
			vipidevol = getDouble();
			valorDesconto = getDouble();
			vlPago = getDouble();
		}
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCpfCnpjEmpresa() {
		return cpfCnpjEmpresa;
	}

	public void setCpfCnpjEmpresa(String cpfCnpjEmpresa) {
		this.cpfCnpjEmpresa = cpfCnpjEmpresa;
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getFoneCliente() {
		return foneCliente;
	}

	public void setFoneCliente(String foneCliente) {
		this.foneCliente = foneCliente;
	}

	public long getIndicadorIdDestinatario() {
		return indicadorIdDestinatario;
	}

	public void setIndicadorIdDestinatario(long indicadorIdDestinatario) {
		this.indicadorIdDestinatario = indicadorIdDestinatario;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Calendar getDataEmissaoNf() {
		return dataEmissaoNf;
	}

	public void setDataEmissaoNf(Calendar dataEmissaoNf) {
		this.dataEmissaoNf = dataEmissaoNf;
	}

	public String getModeloNf() {
		return modeloNf;
	}

	public void setModeloNf(String modeloNf) {
		this.modeloNf = modeloNf;
	}

	public String getSerieNf() {
		return serieNf;
	}

	public void setSerieNf(String serieNf) {
		this.serieNf = serieNf;
	}

	public String getNumeroNf() {
		return numeroNf;
	}

	public void setNumeroNf(String numeroNf) {
		this.numeroNf = numeroNf;
	}

	public long getTipoEmissaoNf() {
		return tipoEmissaoNf;
	}

	public void setTipoEmissaoNf(long tipoEmissaoNf) {
		this.tipoEmissaoNf = tipoEmissaoNf;
	}

	public String getCodigoNf() {
		return codigoNf;
	}

	public void setCodigoNf(String codigoNf) {
		this.codigoNf = codigoNf;
	}

	public String getNatOperacaoNf() {
		return natOperacaoNf;
	}

	public void setNatOperacaoNf(String natOperacaoNf) {
		this.natOperacaoNf = natOperacaoNf;
	}

	public String getIndPagNf() {
		return indPagNf;
	}

	public void setIndPagNf(String indPagNf) {
		this.indPagNf = indPagNf;
	}

	public String getTipoNf() {
		return tipoNf;
	}

	public void setTipoNf(String tipoNf) {
		this.tipoNf = tipoNf;
	}

	public String getIdDestNf() {
		return idDestNf;
	}

	public void setIdDestNf(String idDestNf) {
		this.idDestNf = idDestNf;
	}

	public String getTipoImpressao() {
		return tipoImpressao;
	}

	public void setTipoImpressao(String tipoImpressao) {
		this.tipoImpressao = tipoImpressao;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getComplementoCliente() {
		return complementoCliente;
	}

	public void setComplementoCliente(String complementoCliente) {
		this.complementoCliente = complementoCliente;
	}

	public String getTfinNfe() {
		return tfinNfe;
	}

	public void setTfinNfe(String tfinNfe) {
		this.tfinNfe = tfinNfe;
	}

	public String getIndfinal() {
		return indfinal;
	}

	public void setIndfinal(String indfinal) {
		this.indfinal = indfinal;
	}

	public long getIndiedest() {
		return indiedest;
	}

	public void setIndiedest(long indiedest) {
		this.indiedest = indiedest;
	}

	public long getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(long tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getInfcpl() {
		return infcpl;
	}

	public void setInfcpl(String infcpl) {
		this.infcpl = infcpl;
	}

	public String getInffonte() {
		return inffonte;
	}

	public void setInffonte(String inffonte) {
		this.inffonte = inffonte;
	}

	public String getInfoperador() {
		return infoperador;
	}

	public void setInfoperador(String infoperador) {
		this.infoperador = infoperador;
	}

	public double getVlPago() {
		return vlPago;
	}

	public void setVlPago(double vlPago) {
		this.vlPago = vlPago;
	}

	public double getVlTroco() {
		return vlTroco;
	}

	public void setVlTroco(double vlTroco) {
		this.vlTroco = vlTroco;
	}

	public String getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public String getCnpjTransportador() {
		return cnpjTransportador;
	}

	public void setCnpjTransportador(String cnpjTransportador) {
		this.cnpjTransportador = cnpjTransportador;
	}

	public String getRazaoSocialTransportadora() {
		return razaoSocialTransportadora;
	}

	public void setRazaoSocialTransportadora(String razaoSocialTransportadora) {
		this.razaoSocialTransportadora = razaoSocialTransportadora;
	}

	public String getInscEstadualTransportadora() {
		return inscEstadualTransportadora;
	}

	public void setInscEstadualTransportadora(String inscEstadualTransportadora) {
		this.inscEstadualTransportadora = inscEstadualTransportadora;
	}

	public String getCepTransportadora() {
		return cepTransportadora;
	}

	public void setCepTransportadora(String cepTransportadora) {
		this.cepTransportadora = cepTransportadora;
	}

	public String getLogradouroTransportadora() {
		return logradouroTransportadora;
	}

	public void setLogradouroTransportadora(String logradouroTransportadora) {
		this.logradouroTransportadora = logradouroTransportadora;
	}

	public String getNumeroTransportadora() {
		return numeroTransportadora;
	}

	public void setNumeroTransportadora(String numeroTransportadora) {
		this.numeroTransportadora = numeroTransportadora;
	}

	public String getBairroTransportadora() {
		return bairroTransportadora;
	}

	public void setBairroTransportadora(String bairroTransportadora) {
		this.bairroTransportadora = bairroTransportadora;
	}

	public String getCodigoAntt() {
		return codigoAntt;
	}

	public void setCodigoAntt(String codigoAntt) {
		this.codigoAntt = codigoAntt;
	}

	public String getMunicipioTransportadora() {
		return municipioTransportadora;
	}

	public void setMunicipioTransportadora(String municipioTransportadora) {
		this.municipioTransportadora = municipioTransportadora;
	}

	public String getUfTransportadora() {
		return ufTransportadora;
	}

	public void setUfTransportadora(String ufTransportadora) {
		this.ufTransportadora = ufTransportadora;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getQtdTransportado() {
		return qtdTransportado;
	}

	public void setQtdTransportado(String qtdTransportado) {
		this.qtdTransportado = qtdTransportado;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(String numeracao) {
		this.numeracao = numeracao;
	}

	public String getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(String pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public String getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(String pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public String getLogradouroCliente() {
		return logradouroCliente;
	}

	public void setLogradouroCliente(String logradouroCliente) {
		this.logradouroCliente = logradouroCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getIeCliente() {
		return ieCliente;
	}

	public void setIeCliente(String ieCliente) {
		this.ieCliente = ieCliente;
	}

	public String getNfRef() {
		return nfRef;
	}

	public void setNfRef(String nfRef) {
		this.nfRef = nfRef;
	}

	public double getVicmsdeson() {
		return vicmsdeson;
	}

	public void setVicmsdeson(double vicmsdeson) {
		this.vicmsdeson = vicmsdeson;
	}

	public double getVfcpufdest() {
		return vfcpufdest;
	}

	public void setVfcpufdest(double vfcpufdest) {
		this.vfcpufdest = vfcpufdest;
	}

	public double getVfcp() {
		return vfcp;
	}

	public void setVfcp(double vfcp) {
		this.vfcp = vfcp;
	}

	public double getVfcpst() {
		return vfcpst;
	}

	public void setVfcpst(double vfcpst) {
		this.vfcpst = vfcpst;
	}

	public double getVfcpstret() {
		return vfcpstret;
	}

	public void setVfcpstret(double vfcpstret) {
		this.vfcpstret = vfcpstret;
	}

	public double getVii() {
		return vii;
	}

	public void setVii(double vii) {
		this.vii = vii;
	}

	public double getVipidevol() {
		return vipidevol;
	}

	public void setVipidevol(double vipidevol) {
		this.vipidevol = vipidevol;
	}

	public String getNfat() {
		return nfat;
	}

	public void setNfat(String nfat) {
		this.nfat = nfat;
	}

	public String getNdup() {
		return ndup;
	}

	public void setNdup(String ndup) {
		this.ndup = ndup;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

	public double getPrecoFrete() {
		return precoFrete;
	}

	public void setPrecoFrete(double precoFrete) {
		this.precoFrete = precoFrete;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public String getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(String idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public Long getFiltroIdNotaFiscal() {
		return filtroIdNotaFiscal;
	}

	public void setFiltroIdNotaFiscal(Long filtroIdNotaFiscal) {
		this.filtroIdNotaFiscal = filtroIdNotaFiscal;
	}
}
