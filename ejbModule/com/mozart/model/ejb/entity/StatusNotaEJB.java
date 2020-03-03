package com.mozart.model.ejb.entity;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "StatusNotaEJB.findAll", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "select o from StatusNotaEJB o")
@Table(name = "STATUS_NOTA")
public class StatusNotaEJB extends MozartEntity {
	private static final long serialVersionUID = -5425102964505366146L;
	@Column(name = "ALIQUOTA_ISS")
	private Double aliquotaIss;
	@Column(name = "BASE_CALCULO")
	private Double baseCalculo;
	@Column(nullable = false)
	private Timestamp data;
	@Column(name = "DATA_SUBSTITUTA")
	private Timestamp dataSubstituta;
	private Double icms;
	@Column(name = "ID_ALIQUOTA")
	private Long idAliquota;
	@Column(name = "ID_CHECKIN")
	private Long idCheckin;
	@Column(name = "ID_CONTA_CONTABIL")
	private Long idContaContabil;
	@Column(name = "ID_EMPRESA")
	private Long idEmpresa;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_EMPRESA", referencedColumnName="ID_EMPRESA", insertable=false, updatable=false),
		@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL", insertable=false, updatable=false)
	})
	private EmpresaHotelEJB empresaHotel;

	@ManyToOne
	@JoinColumn(name="ID_HOSPEDE", referencedColumnName="ID_HOSPEDE", insertable=false, updatable=false)
	private HospedeEJB hospede;
	@ManyToOne
	@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL", insertable=false, updatable=false)
	private HotelEJB hotel;

	
	@Column(name = "ID_FISCAL_CODIGO")
	private Long idFiscalCodigo;
	@Column(name = "ID_FISCAL_INCIDENCIA")
	private Long idFiscalIncidencia;
	@Column(name = "ID_HOSPEDE")
	private Long idHospede;
	@Column(name = "ID_HOTEL", nullable = false)
	private Long idHotel;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqSN")
	@SequenceGenerator(name = "idSeqSN", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_NOTA", nullable = false)
	private Long idNota;
	@Column(name = "ISS")
	private Double iss;
	@Column(name = "ISS_RETIDO")
	private Double issRetido;
	@Column(name = "MOTIVO_CANCELAMENTO")
	private String motivoCancelamento;
	@Column(name = "NOTA_FINAL")
	private Long notaFinal;
	@Column(name = "NOTA_INICIAL")
	private Long notaInicial;
	@Column(name = "NOTA_SUBSTITUTA")
	private Long notaSubstituta;
	@Column(name = "NUM_NOTA", nullable = false)
	private String numNota;
	@Column(name = "NUM_OCORRENCIA")
	private Long numOcorrencia;
	private String obs;
	@Column(nullable = false)
	private String restaurante;
	private String serie;
	@Column(name = "SERIE_SUBSTITUTA")
	private String serieSubstituta;
	private String situacaorps;
	@Column(name = "SITUACAO_NF")
	private String situacaoNf;
	@Column(nullable = false)
	private String status;
	@Column(name = "SUB_SERIE")
	private String subSerie;
	@Column(name = "SUB_SERIE_SUBSTITUTA")
	private String subSerieSubstituta;
	@Column(name = "TIPO_DOCUMENTO")
	private Long tipoDocumento;
	@Column(name = "TIPO_NOTA")
	private String tipoNota;
	@Column(name = "TIPO_NOTA_FISCAL")
	private String tipoNotaFiscal;
	@Column(name = "TIPO_OPERACAO")
	private String tipoOperacao;
	@Column(name = "TIPO_SERVICO")
	private String tipoServico;
	@Column(name = "TIPO_SUBSTITUTA")
	private String tipoSubstituta;
	@Column(name = "VALOR_DEDUCAO")
	private Double valorDeducao;
	@Column(name = "VALOR_NOTA")
	private Double valorNota;
	@Column(name = "IR_RETENCAO")
	private Double irRetencao;
	@Column(name = "CSLL")
	private Double csll;
	@Column(name = "COFINS")
	private Double cofins;
	@Column(name = "PIS")
	private Double pis;
	@Column(name = "INSS")
	private Double inss;
	@Column(name = "OUTRAS_RETENCOES")
	private Double outasRetencoes;
	@Column(name = "QUEM_PAGA")
	private String quemPaga;
	@Column(name = "RPS_STATUS")
	private String rpsStatus;
	@Column(name = "ID_CONTROLE_LOTE")
	private Long idControleLote;
	@Column(name = "DATA_EMISSAO")
	private Timestamp dataEmissao;
	@Column(name = "DISCRIMINACAO")
	private String discriminacao;
	@Column(name = "CPF_CNPJ")
	private String cpfCnpj;
	@Column(name = "CHAVE_ACESSO")
	private String chaveAcesso;
	@Column(name = "LOTE_NFE")
	private Long loteNfe;
	@Column(name = "ARQUIVO_NOME")
	private String nomeArquivoNotaNfe;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="ARQUIVO_IMAGEM", length=4000)
	private byte[] xml;
	

	public Timestamp getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Timestamp dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Double getAliquotaIss() {
		return this.aliquotaIss;
	}

	public void setAliquotaIss(Double aliquotaIss) {
		this.aliquotaIss = aliquotaIss;
	}

	public Double getBaseCalculo() {
		return this.baseCalculo;
	}

	public void setBaseCalculo(Double baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDataSubstituta() {
		return this.dataSubstituta;
	}

	public void setDataSubstituta(Timestamp dataSubstituta) {
		this.dataSubstituta = dataSubstituta;
	}

	public Double getIcms() {
		return this.icms;
	}

	public void setIcms(Double icms) {
		this.icms = icms;
	}

	public Long getIdAliquota() {
		return this.idAliquota;
	}

	public void setIdAliquota(Long idAliquota) {
		this.idAliquota = idAliquota;
	}

	public Long getIdCheckin() {
		return this.idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public Long getIdContaContabil() {
		return this.idContaContabil;
	}

	public void setIdContaContabil(Long idContaContabil) {
		this.idContaContabil = idContaContabil;
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdFiscalCodigo() {
		return this.idFiscalCodigo;
	}

	public void setIdFiscalCodigo(Long idFiscalCodigo) {
		this.idFiscalCodigo = idFiscalCodigo;
	}

	public Long getIdFiscalIncidencia() {
		return this.idFiscalIncidencia;
	}

	public void setIdFiscalIncidencia(Long idFiscalIncidencia) {
		this.idFiscalIncidencia = idFiscalIncidencia;
	}

	public Long getIdHospede() {
		return this.idHospede;
	}

	public void setIdHospede(Long idHospede) {
		this.idHospede = idHospede;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdNota() {
		return this.idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Double getIss() {
		return this.iss;
	}

	public void setIss(Double iss) {
		this.iss = iss;
	}

	public Double getIssRetido() {
		return this.issRetido;
	}

	public void setIssRetido(Double issRetido) {
		this.issRetido = issRetido;
	}

	public String getMotivoCancelamento() {
		return this.motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public Long getNotaFinal() {
		return this.notaFinal;
	}

	public void setNotaFinal(Long notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Long getNotaInicial() {
		return this.notaInicial;
	}

	public void setNotaInicial(Long notaInicial) {
		this.notaInicial = notaInicial;
	}

	public Long getNotaSubstituta() {
		return this.notaSubstituta;
	}

	public void setNotaSubstituta(Long notaSubstituta) {
		this.notaSubstituta = notaSubstituta;
	}

	public String getNumNota() {
		return this.numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public Long getNumOcorrencia() {
		return this.numOcorrencia;
	}

	public void setNumOcorrencia(Long numOcorrencia) {
		this.numOcorrencia = numOcorrencia;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getRestaurante() {
		return this.restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerieSubstituta() {
		return this.serieSubstituta;
	}

	public void setSerieSubstituta(String serieSubstituta) {
		this.serieSubstituta = serieSubstituta;
	}

	public String getSituacaorps() {
		return this.situacaorps;
	}

	public void setSituacaorps(String situacaorps) {
		this.situacaorps = situacaorps;
	}

	public String getSituacaoNf() {
		return this.situacaoNf;
	}

	public void setSituacaoNf(String situacaoNf) {
		this.situacaoNf = situacaoNf;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubSerie() {
		return this.subSerie;
	}

	public void setSubSerie(String subSerie) {
		this.subSerie = subSerie;
	}

	public String getSubSerieSubstituta() {
		return this.subSerieSubstituta;
	}

	public void setSubSerieSubstituta(String subSerieSubstituta) {
		this.subSerieSubstituta = subSerieSubstituta;
	}

	public Long getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoNota() {
		return this.tipoNota;
	}

	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	public String getTipoNotaFiscal() {
		return this.tipoNotaFiscal;
	}

	public void setTipoNotaFiscal(String tipoNotaFiscal) {
		this.tipoNotaFiscal = tipoNotaFiscal;
	}

	public String getTipoOperacao() {
		return this.tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public String getTipoServico() {
		return this.tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getTipoSubstituta() {
		return this.tipoSubstituta;
	}

	public void setTipoSubstituta(String tipoSubstituta) {
		this.tipoSubstituta = tipoSubstituta;
	}

	public Double getValorDeducao() {
		return this.valorDeducao;
	}

	public void setValorDeducao(Double valorDeducao) {
		this.valorDeducao = valorDeducao;
	}

	public Double getValorNota() {
		return this.valorNota;
	}

	public void setValorNota(Double valorNota) {
		this.valorNota = valorNota;
	}

	public Double getIrRetencao() {
		return irRetencao;
	}

	public void setIrRetencao(Double irRetencao) {
		this.irRetencao = irRetencao;
	}

	public Double getCsll() {
		return csll;
	}

	public void setCsll(Double csll) {
		this.csll = csll;
	}

	public Double getCofins() {
		return cofins;
	}

	public void setCofins(Double cofins) {
		this.cofins = cofins;
	}

	public Double getPis() {
		return pis;
	}

	public void setPis(Double pis) {
		this.pis = pis;
	}

	public Double getInss() {
		return inss;
	}

	public void setInss(Double inss) {
		this.inss = inss;
	}

	public Double getOutasRetencoes() {
		return outasRetencoes;
	}

	public void setOutasRetencoes(Double outasRetencoes) {
		this.outasRetencoes = outasRetencoes;
	}

	public String getQuemPaga() {
		return quemPaga;
	}

	public void setQuemPaga(String quemPaga) {
		this.quemPaga = quemPaga;
	}

	public String getRpsStatus() {
		return rpsStatus;
	}

	public void setRpsStatus(String rpsStatus) {
		this.rpsStatus = rpsStatus;
	}

	public Long getIdControleLote() {
		return idControleLote;
	}

	public void setIdControleLote(Long idControleLote) {
		this.idControleLote = idControleLote;
	}

	public HospedeEJB getHospede() {
		return hospede;
	}

	public void setHospede(HospedeEJB hospede) {
		this.hospede = hospede;
	}

	public EmpresaHotelEJB getEmpresaHotel() {
		return empresaHotel;
	}

	public void setEmpresaHotel(EmpresaHotelEJB empresaHotel) {
		this.empresaHotel = empresaHotel;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public String getDiscriminacao() {
		return discriminacao;
	}

	public void setDiscriminacao(String discriminacao) {
		this.discriminacao = discriminacao;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getChaveAcesso() {
		return chaveAcesso;
	}

	public void setChaveAcesso(String chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}

	public Long getLoteNfe() {
		return loteNfe;
	}

	public void setLoteNfe(Long loteNfe) {
		this.loteNfe = loteNfe;
	}

	public String getNomeArquivoNotaNfe() {
		return nomeArquivoNotaNfe;
	}

	public void setNomeArquivoNotaNfe(String nomeArquivoNotaNfe) {
		this.nomeArquivoNotaNfe = nomeArquivoNotaNfe;
	}

	public byte[] getXml() {
		return xml;
	}

	public void setXml(byte[] xml) {
		this.xml = xml;
	}
}
