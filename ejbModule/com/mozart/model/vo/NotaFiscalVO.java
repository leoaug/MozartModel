package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class NotaFiscalVO extends MozartVO {

	public enum TypeOfNotaFiscal {
	    MUNICIPAL, ESTADUAL
	}
	
	private static final long serialVersionUID = 1L;

	/* FILTRO */
	private FiltroWeb data;
	private FiltroWeb notaInicial;
	private FiltroWeb rpsstatus;
	
	private Long bcIdHotel;
	private String bcTipoNota;
	private String filtroTipoPesquisa;
	
	/* Variaveis que vão ser usada no resultado do grid e no action
     * grac -> gr: grid | ac: action
     * 
     *  Will, gentileza se manter ao padrão existente.
     *  
     * */
	private Long gracIdNota;
    private String gracCGC;
    private String gracInscMunicipal;
    private String gracNumNota;
    private String gracNotaInicial;
    private String gracSerie;
    private String gracTipo;
    private String gracDataEmissao;
    private String gracDataEmissaoFormatada;
    private Long gracStatus;
    private String gracNaturezaOperacao;
    private Long gracOptSimplesNacional;
    private Long gracIncentivoCultura;
    private Double gracValorServico;
    private Double gracValorDeducoes;
    private Double gracValorPIS;
    private Double gracValorCOFINS;
    private Double gracValorINSS;
    private Double gracValorIR;
    private Double gracValorCSLL;
    private Double gracISSRetido;
    private Double gracValorISS;
    private Double gracOutrasRetencoes;
    private Double gracAliquota;
    private String gracDescontoIncondicionado;
    private String gracDescontoCondicionado;
    private String gracItemListaServico;
    private String gracCodigoTributacaoMunicipio;
    private String gracDiscriminacao;
    private Long gracCodigoMunicipio;
    private String gracCPFCNPJ;
    private String gracEndereco;
    private String gracNumero;
    private String gracComplemento;
    private String gracBairro;
    private Long gracCodMunicipioTomador;
    private String gracUF;
    private String gracCEP;
    private String gracStatusRPS;
    private String gracRazaoSocial;
    private String gracNomePontoVenda;
    private String gracDescricaoModelo;
    private Double gracValorTotal;
    private String gracChaveAcesso;
    private String gracMensagem;
    private String gracNomeArquivo;
    private String gracSigla;
    
	public NotaFiscalVO() {
		data = new FiltroWeb();
		notaInicial = new FiltroWeb();
		rpsstatus = new FiltroWeb();
	}

	public NotaFiscalVO(Object[] filtro, TypeOfNotaFiscal typeOf) {
		if (filtro != null) {
			setLinha(filtro);
			switch (typeOf) {
            case MUNICIPAL:
				gracIdNota = getLong();
				gracCGC = getString();
				gracInscMunicipal = getString();
				gracNumNota= getString();
				gracNotaInicial= getString();
				gracSerie= getString();
				gracTipo= getString();
				gracDataEmissao= getString();
				gracStatus= getLong();
				gracNaturezaOperacao = getString();
				gracOptSimplesNacional = getLong();
				gracIncentivoCultura = getLong();
				gracValorServico = getDouble();
				gracValorDeducoes = getDouble();
				gracValorPIS = getDouble();
				gracValorCOFINS = getDouble();
				gracValorINSS = getDouble();
				gracValorIR = getDouble();
				gracValorCSLL = getDouble();
				gracISSRetido = getDouble();
				gracValorISS = getDouble();
				gracOutrasRetencoes = getDouble();
				gracAliquota = getDouble();
				gracDescontoIncondicionado = getString();
				gracDescontoCondicionado = getString();
				gracItemListaServico = getString();
				gracCodigoTributacaoMunicipio= getString();
				gracDiscriminacao = getString();
				gracCodigoMunicipio = getLong();
				gracCPFCNPJ = getString();
				gracEndereco = getString();
				gracNumero = getString();
				gracComplemento = getString();
				gracBairro = getString();
				gracCodMunicipioTomador = getLong();
				gracUF = getString();
				gracCEP = getString();
				gracDataEmissaoFormatada = getString();
				gracStatusRPS = getString();
				gracRazaoSocial = getString();
				break;
            case ESTADUAL:
            	gracStatus= getLong();
            	gracDataEmissao= getString();
            	gracNomePontoVenda = getString();
            	gracDescricaoModelo = getString();
            	gracNumNota= getString();
            	gracSerie= getString();
            	gracNaturezaOperacao = getString();
            	gracValorTotal = getDouble();
            	gracChaveAcesso = getString();
            	gracNumero = getString();
            	gracMensagem = getString();
            	gracNomeArquivo = getString();
            	gracIdNota = getLong();
            	gracDataEmissaoFormatada = getString();
            	gracSigla = getString();
            	break;
			}
		}
	}

	public FiltroWeb getData() {
		return data;
	}

	public void setData(FiltroWeb data) {
		this.data = data;
	}

	public FiltroWeb getNotaInicial() {
		return notaInicial;
	}

	public void setNotaInicial(FiltroWeb notaInicial) {
		this.notaInicial = notaInicial;
	}
	
	public FiltroWeb getRpsstatus() {
		return rpsstatus;
	}

	public void setRpsstatus(FiltroWeb rpsstatus) {
		this.rpsstatus = rpsstatus;
	}

	public Long getGracIdNota() {
		return gracIdNota;
	}

	public void setGracIdNota(Long gracIdNota) {
		this.gracIdNota = gracIdNota;
	}

	public String getGracCGC() {
		return gracCGC;
	}

	public void setGracCGC(String gracCGC) {
		this.gracCGC = gracCGC;
	}

	public String getGracInscMunicipal() {
		return gracInscMunicipal;
	}

	public void setGracInscMunicipal(String gracInscMunicipal) {
		this.gracInscMunicipal = gracInscMunicipal;
	}

	public String getGracNumNota() {
		return gracNumNota;
	}

	public void setGracNumNota(String gracNumNota) {
		this.gracNumNota = gracNumNota;
	}

	public String getGracNotaInicial() {
		return gracNotaInicial;
	}

	public void setGracNotaInicial(String gracNotaInicial) {
		this.gracNotaInicial = gracNotaInicial;
	}

	public String getGracSerie() {
		return gracSerie;
	}

	public void setGracSerie(String gracSerie) {
		this.gracSerie = gracSerie;
	}

	public String getGracTipo() {
		return gracTipo;
	}

	public void setGracTipo(String gracTipo) {
		this.gracTipo = gracTipo;
	}

	public String getGracDataEmissao() {
		return gracDataEmissao;
	}

	public void setGracDataEmissao(String gracDataEmissao) {
		this.gracDataEmissao = gracDataEmissao;
	}

	public Long getGracStatus() {
		return gracStatus;
	}

	public void setGracStatus(Long gracStatus) {
		this.gracStatus = gracStatus;
	}

	public String getGracNaturezaOperacao() {
		return gracNaturezaOperacao;
	}

	public void setGracNaturezaOperacao(String gracNaturezaOperacao) {
		this.gracNaturezaOperacao = gracNaturezaOperacao;
	}

	public Long getGracOptSimplesNacional() {
		return gracOptSimplesNacional;
	}

	public void setGracOptSimplesNacional(Long gracOptSimplesNacional) {
		this.gracOptSimplesNacional = gracOptSimplesNacional;
	}

	public Long getGracIncentivoCultura() {
		return gracIncentivoCultura;
	}

	public void setGracIncentivoCultura(Long gracIncentivoCultura) {
		this.gracIncentivoCultura = gracIncentivoCultura;
	}

	public Double getGracValorServico() {
		return gracValorServico;
	}

	public void setGracValorServico(Double gracValorServico) {
		this.gracValorServico = gracValorServico;
	}

	public Double getGracValorDeducoes() {
		return gracValorDeducoes;
	}

	public void setGracValorDeducoes(Double gracValorDeducoes) {
		this.gracValorDeducoes = gracValorDeducoes;
	}

	public Double getGracValorPIS() {
		return gracValorPIS;
	}

	public void setGracValorPIS(Double gracValorPIS) {
		this.gracValorPIS = gracValorPIS;
	}

	public Double getGracValorCOFINS() {
		return gracValorCOFINS;
	}

	public void setGracValorCOFINS(Double gracValorCOFINS) {
		this.gracValorCOFINS = gracValorCOFINS;
	}

	public Double getGracValorINSS() {
		return gracValorINSS;
	}

	public void setGracValorINSS(Double gracValorINSS) {
		this.gracValorINSS = gracValorINSS;
	}

	public Double getGracValorIR() {
		return gracValorIR;
	}

	public void setGracValorIR(Double gracValorIR) {
		this.gracValorIR = gracValorIR;
	}

	public Double getGracValorCSLL() {
		return gracValorCSLL;
	}

	public void setGracValorCSLL(Double gracValorCSLL) {
		this.gracValorCSLL = gracValorCSLL;
	}

	public Double getGracISSRetido() {
		return gracISSRetido;
	}

	public void setGracISSRetido(Double gracISSRetido) {
		this.gracISSRetido = gracISSRetido;
	}

	public Double getGracValorISS() {
		return gracValorISS;
	}

	public void setGracValorISS(Double gracValorISS) {
		this.gracValorISS = gracValorISS;
	}

	public Double getGracOutrasRetencoes() {
		return gracOutrasRetencoes;
	}

	public void setGracOutrasRetencoes(Double gracOutrasRetencoes) {
		this.gracOutrasRetencoes = gracOutrasRetencoes;
	}

	public Double getGracAliquota() {
		return gracAliquota;
	}

	public void setGracAliquota(Double gracAliquota) {
		this.gracAliquota = gracAliquota;
	}

	public String getGracDescontoIncondicionado() {
		return gracDescontoIncondicionado;
	}

	public void setGracDescontoIncondicionado(String gracDescontoIncondicionado) {
		this.gracDescontoIncondicionado = gracDescontoIncondicionado;
	}

	public String getGracDescontoCondicionado() {
		return gracDescontoCondicionado;
	}

	public void setGracDescontoCondicionado(String gracDescontoCondicionado) {
		this.gracDescontoCondicionado = gracDescontoCondicionado;
	}

	public String getGracItemListaServico() {
		return gracItemListaServico;
	}

	public void setGracItemListaServico(String gracItemListaServico) {
		this.gracItemListaServico = gracItemListaServico;
	}

	public String getGracCodigoTributacaoMunicipio() {
		return gracCodigoTributacaoMunicipio;
	}

	public void setGracCodigoTributacaoMunicipio(
			String gracCodigoTributacaoMunicipio) {
		this.gracCodigoTributacaoMunicipio = gracCodigoTributacaoMunicipio;
	}

	public String getGracDiscriminacao() {
		return gracDiscriminacao;
	}

	public void setGracDiscriminacao(String gracDiscriminacao) {
		this.gracDiscriminacao = gracDiscriminacao;
	}

	public Long getGracCodigoMunicipio() {
		return gracCodigoMunicipio;
	}

	public void setGracCodigoMunicipio(Long gracCodigoMunicipio) {
		this.gracCodigoMunicipio = gracCodigoMunicipio;
	}

	public String getGracCPFCNPJ() {
		return gracCPFCNPJ;
	}

	public void setGracCPFCNPJ(String gracCPFCNPJ) {
		this.gracCPFCNPJ = gracCPFCNPJ;
	}

	public String getGracEndereco() {
		return gracEndereco;
	}

	public void setGracEndereco(String gracEndereco) {
		this.gracEndereco = gracEndereco;
	}

	public String getGracNumero() {
		return gracNumero;
	}

	public void setGracNumero(String gracNumero) {
		this.gracNumero = gracNumero;
	}

	public String getGracComplemento() {
		return gracComplemento;
	}

	public void setGracComplemento(String gracComplemento) {
		this.gracComplemento = gracComplemento;
	}

	public String getGracBairro() {
		return gracBairro;
	}

	public void setGracBairro(String gracBairro) {
		this.gracBairro = gracBairro;
	}

	public Long getGracCodMunicipioTomador() {
		return gracCodMunicipioTomador;
	}

	public void setGracCodMunicipioTomador(Long gracCodMunicipioTomador) {
		this.gracCodMunicipioTomador = gracCodMunicipioTomador;
	}

	public String getGracUF() {
		return gracUF;
	}

	public void setGracUF(String gracUF) {
		this.gracUF = gracUF;
	}

	public String getGracCEP() {
		return gracCEP;
	}

	public void setGracCEP(String gracCEP) {
		this.gracCEP = gracCEP;
	}

	public Long getBcIdHotel() {
		return bcIdHotel;
	}

	public void setBcIdHotel(Long bcIdHotel) {
		this.bcIdHotel = bcIdHotel;
	}

	public String getBcTipoNota() {
		return bcTipoNota;
	}

	public void setBcTipoNota(String bcTipoNota) {
		this.bcTipoNota = bcTipoNota;
	}

	public String getFiltroTipoPesquisa() {
		return filtroTipoPesquisa;
	}

	public void setFiltroTipoPesquisa(String filtroTipoPesquisa) {
		this.filtroTipoPesquisa = filtroTipoPesquisa;
	}

	public String getGracDataEmissaoFormatada() {
		return gracDataEmissaoFormatada;
	}

	public void setGracDataEmissaoFormatada(String gracDataEmissaoFormatada) {
		this.gracDataEmissaoFormatada = gracDataEmissaoFormatada;
	}

	public String getGracStatusRPS() {
		return gracStatusRPS;
	}

	public void setGracStatusRPS(String gracStatusRPS) {
		this.gracStatusRPS = gracStatusRPS;
	}

	public String getGracRazaoSocial() {
		return gracRazaoSocial;
	}

	public void setGracRazaoSocial(String gracRazaoSocial) {
		this.gracRazaoSocial = gracRazaoSocial;
	}

	public String getGracNomePontoVenda() {
		return gracNomePontoVenda;
	}

	public void setGracNomePontoVenda(String gracNomePontoVenda) {
		this.gracNomePontoVenda = gracNomePontoVenda;
	}

	public String getGracDescricaoModelo() {
		return gracDescricaoModelo;
	}

	public void setGracDescricaoModelo(String gracDescricaoModelo) {
		this.gracDescricaoModelo = gracDescricaoModelo;
	}

	public Double getGracValorTotal() {
		return gracValorTotal;
	}

	public void setGracValorTotal(Double gracValorTotal) {
		this.gracValorTotal = gracValorTotal;
	}

	public String getGracChaveAcesso() {
		return gracChaveAcesso;
	}

	public void setGracChaveAcesso(String gracChaveAcesso) {
		this.gracChaveAcesso = gracChaveAcesso;
	}

	public String getGracMensagem() {
		return gracMensagem;
	}

	public void setGracMensagem(String gracMensagem) {
		this.gracMensagem = gracMensagem;
	}

	public String getGracNomeArquivo() {
		return gracNomeArquivo;
	}

	public void setGracNomeArquivo(String gracNomeArquivo) {
		this.gracNomeArquivo = gracNomeArquivo;
	}

	public String getGracSigla() {
		return gracSigla;
	}

	public void setGracSigla(String gracSigla) {
		this.gracSigla = gracSigla;
	}
}
