package com.mozart.model.vo;

public class EmpresaHotelVO extends MozartVO {
	private static final long serialVersionUID = 8202416851256149606L;
	private Long bcIdEmpresa;
	private Long bcIdHotel;
	private Long bcIdRedeHotel;
	private String bcTipoPensao;
	private Double bcDesconto;
	private Double bcComissao;
	private Long bcPrazoPagamento;
	private String bcCalculaIss;
	private String bcCalculaTaxa;
	private String bcCalculaRoomtax;
	private Long bcContaCorrente;
	private Long bcIdTipoEmpresa;
	private String bcEnderecoCobranca;
	private Long bcIdCidade;
	private String bcCep;
	private String bcBairro;
	private String bcTipoEmpresa;
	private Long bcIdPromotor;
	private String bcAcredito;
	private String bcNomeFantasia;
	private String bcIssRetencao;
	private Double bcValorCredito;
	private Long bcIdCorporate;
	private String bcCalculaSeguro;
	private String cnpj;
	private String bcCidade;
	private String bcCredito;
	private String bcCorporate;

	public void setaDados(Object[] pLinha) {
		setLinha(pLinha);

		this.bcIdEmpresa = getLong();
		this.bcIdHotel = getLong();
		this.bcIdRedeHotel = getLong();
		this.bcTipoPensao = getString();
		this.bcDesconto = getDouble();
		this.bcComissao = getDouble();
		this.bcPrazoPagamento = getLong();
		this.bcCalculaIss = getString();
		this.bcCalculaTaxa = getString();
		this.bcCalculaRoomtax = getString();
		this.bcContaCorrente = getLong();
		this.bcIdTipoEmpresa = getLong();
		this.bcEnderecoCobranca = getString();
		this.bcIdCidade = getLong();
		this.bcCidade = getString();
		this.bcCep = getString();
		this.bcBairro = getString();
		this.bcTipoEmpresa = getString();
		this.bcIdPromotor = getLong();
		this.bcAcredito = getString();
		this.bcNomeFantasia = getString();
		this.bcIssRetencao = getString();
		this.bcValorCredito = getDouble();
		this.bcIdCorporate = getLong();
		this.bcCredito = getString();
		this.bcCalculaSeguro = getString();
	}

	public EmpresaHotelVO() {
	}

	public EmpresaHotelVO(Object[] pLinha) {
		setLinha(pLinha);

		this.bcIdEmpresa = getLong();
		this.bcIdHotel = getLong();
		this.bcIdRedeHotel = getLong();
		this.bcNomeFantasia = getString();
		this.cnpj = getString();
		this.bcCredito = getString();
		this.bcComissao = getDouble();
		this.bcCalculaTaxa = getString();
		this.bcCalculaRoomtax = getString();
		this.bcCalculaIss = getString();
	}

	public void setBcIdEmpresa(Long bcIdEmpresa) {
		this.bcIdEmpresa = bcIdEmpresa;
	}

	public Long getBcIdEmpresa() {
		return this.bcIdEmpresa;
	}

	public void setBcIdHotel(Long bcIdHotel) {
		this.bcIdHotel = bcIdHotel;
	}

	public Long getBcIdHotel() {
		return this.bcIdHotel;
	}

	public void setBcIdRedeHotel(Long bcIdRedeHotel) {
		this.bcIdRedeHotel = bcIdRedeHotel;
	}

	public Long getBcIdRedeHotel() {
		return this.bcIdRedeHotel;
	}

	public void setBcTipoPensao(String bcTipoPensao) {
		this.bcTipoPensao = bcTipoPensao;
	}

	public String getBcTipoPensao() {
		return this.bcTipoPensao;
	}

	public void setBcDesconto(Double bcDesconto) {
		this.bcDesconto = bcDesconto;
	}

	public Double getBcDesconto() {
		return this.bcDesconto;
	}

	public void setBcComissao(Double bcComissao) {
		this.bcComissao = bcComissao;
	}

	public Double getBcComissao() {
		return this.bcComissao;
	}

	public void setBcPrazoPagamento(Long bcPrazoPagamento) {
		this.bcPrazoPagamento = bcPrazoPagamento;
	}

	public Long getBcPrazoPagamento() {
		return this.bcPrazoPagamento;
	}

	public void setBcCalculaIss(String bcCalculaIss) {
		this.bcCalculaIss = bcCalculaIss;
	}

	public String getBcCalculaIss() {
		return this.bcCalculaIss;
	}

	public void setBcCalculaTaxa(String bcCalculaTaxa) {
		this.bcCalculaTaxa = bcCalculaTaxa;
	}

	public String getBcCalculaTaxa() {
		return this.bcCalculaTaxa;
	}

	public void setBcCalculaRoomtax(String bcCalculaRoomtax) {
		this.bcCalculaRoomtax = bcCalculaRoomtax;
	}

	public String getBcCalculaRoomtax() {
		return this.bcCalculaRoomtax;
	}

	public void setBcContaCorrente(Long bcContaCorrente) {
		this.bcContaCorrente = bcContaCorrente;
	}

	public Long getBcContaCorrente() {
		return this.bcContaCorrente;
	}

	public void setBcIdTipoEmpresa(Long bcIdTipoEmpresa) {
		this.bcIdTipoEmpresa = bcIdTipoEmpresa;
	}

	public Long getBcIdTipoEmpresa() {
		return this.bcIdTipoEmpresa;
	}

	public void setBcEnderecoCobranca(String bcEnderecoCobranca) {
		this.bcEnderecoCobranca = bcEnderecoCobranca;
	}

	public String getBcEnderecoCobranca() {
		return this.bcEnderecoCobranca;
	}

	public void setBcIdCidade(Long bcIdCidade) {
		this.bcIdCidade = bcIdCidade;
	}

	public Long getBcIdCidade() {
		return this.bcIdCidade;
	}

	public void setBcCep(String bcCep) {
		this.bcCep = bcCep;
	}

	public String getBcCep() {
		return this.bcCep;
	}

	public void setBcBairro(String bcBairro) {
		this.bcBairro = bcBairro;
	}

	public String getBcBairro() {
		return this.bcBairro;
	}

	public void setBcTipoEmpresa(String bcTipoEmpresa) {
		this.bcTipoEmpresa = bcTipoEmpresa;
	}

	public String getBcTipoEmpresa() {
		return this.bcTipoEmpresa;
	}

	public void setBcIdPromotor(Long bcIdPromotor) {
		this.bcIdPromotor = bcIdPromotor;
	}

	public Long getBcIdPromotor() {
		return this.bcIdPromotor;
	}

	public void setBcAcredito(String bcAcredito) {
		this.bcAcredito = bcAcredito;
	}

	public String getBcAcredito() {
		return this.bcAcredito;
	}

	public void setBcNomeFantasia(String bcNomeFantasia) {
		this.bcNomeFantasia = bcNomeFantasia;
	}

	public String getBcNomeFantasia() {
		return this.bcNomeFantasia;
	}

	public void setBcIssRetencao(String bcIssRetencao) {
		this.bcIssRetencao = bcIssRetencao;
	}

	public String getBcIssRetencao() {
		return this.bcIssRetencao;
	}

	public void setBcValorCredito(Double bcValorCredito) {
		this.bcValorCredito = bcValorCredito;
	}

	public Double getBcValorCredito() {
		return this.bcValorCredito;
	}

	public void setBcIdCorporate(Long bcIdCorporate) {
		this.bcIdCorporate = bcIdCorporate;
	}

	public Long getBcIdCorporate() {
		return this.bcIdCorporate;
	}

	public void setBcCalculaSeguro(String bcCalculaSeguro) {
		this.bcCalculaSeguro = bcCalculaSeguro;
	}

	public String getBcCalculaSeguro() {
		return this.bcCalculaSeguro;
	}

	public void setBcCidade(String bcCidade) {
		this.bcCidade = bcCidade;
	}

	public String getBcCidade() {
		return this.bcCidade;
	}

	public void setBcCredito(String bcCredito) {
		this.bcCredito = bcCredito;
	}

	public String getBcCredito() {
		return this.bcCredito;
	}

	public void setBcCorporate(String bcCorporate) {
		this.bcCorporate = bcCorporate;
	}

	public String getBcCorporate() {
		return this.bcCorporate;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}