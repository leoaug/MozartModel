package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class RedeHotelVO extends MozartVO {

	private static final long serialVersionUID = -7878573134487485414L;

	private FiltroWeb filtroNomeFantasia;

	private Long idRedeHotel;
	private String nomeFantasia;
	private String razaoSocial;
	private String endereco;
	private String cep;
	private String bairro;
	private String telefone;
	private String email;
	private String fax;
	private String cgc;
	private String inscEstadual;
	private String inscMunicipal;
	private String inscEmbratur;
	private String telex;
	private String automatico;
	private String valorInscricao;
	private String qtdValor;
	private String expirar;
	private String foraAno;
	private String sigla;
	private String enderecoLogotipo;
	private String linkVoucher;
	private String formatoConta;

	public RedeHotelVO() {

		filtroNomeFantasia = new FiltroWeb();

	}

	public RedeHotelVO(Object[] linha) {
		if (linha != null) {
			setLinha(linha);

			idRedeHotel = getLong();
			nomeFantasia = getString();
			razaoSocial = getString();
			endereco = getString();
			cep = getString();
			bairro = getString();
			telefone = getString();
			email = getString();
			fax = getString();
			cgc = getString();
			inscEstadual = getString();
			inscMunicipal = getString();
			inscEmbratur = getString();
			telex = getString();
			automatico = getString();
			valorInscricao = getString();
			qtdValor = getString();
			expirar = getString();
			foraAno = getString();
			sigla = getString();
			enderecoLogotipo = getString();
			linkVoucher = getString();
			formatoConta = getString();

		}
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public FiltroWeb getFiltroNomeFantasia() {
		return filtroNomeFantasia;
	}

	public void setFiltroNomeFantasia(FiltroWeb filtroNomeFantasia) {
		this.filtroNomeFantasia = filtroNomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return MozartUtil.formatCEP(cep);
	}

	public void setCep(String cep) {
		cep = MozartUtil.removerNaoNumericos(cep);
		if (!MozartUtil.validarCEP(cep))
			throw new IllegalArgumentException(
					"CEP informado está em formato inválido.");
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCgc() {
		return cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getInscEmbratur() {
		return inscEmbratur;
	}

	public void setInscEmbratur(String inscEmbratur) {
		this.inscEmbratur = inscEmbratur;
	}

	public String getTelex() {
		return telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	public String getAutomatico() {
		return automatico;
	}

	public void setAutomatico(String automatico) {
		this.automatico = automatico;
	}

	public String getValorInscricao() {
		return valorInscricao;
	}

	public void setValorInscricao(String valorInscricao) {
		this.valorInscricao = valorInscricao;
	}

	public String getQtdValor() {
		return qtdValor;
	}

	public void setQtdValor(String qtdValor) {
		this.qtdValor = qtdValor;
	}

	public String getExpirar() {
		return expirar;
	}

	public void setExpirar(String expirar) {
		this.expirar = expirar;
	}

	public String getForaAno() {
		return foraAno;
	}

	public void setForaAno(String foraAno) {
		this.foraAno = foraAno;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEnderecoLogotipo() {
		return enderecoLogotipo;
	}

	public void setEnderecoLogotipo(String enderecoLogotipo) {
		this.enderecoLogotipo = enderecoLogotipo;
	}

	public String getLinkVoucher() {
		return linkVoucher;
	}

	public void setLinkVoucher(String linkVoucher) {
		this.linkVoucher = linkVoucher;
	}

	public String getFormatoConta() {
		return formatoConta;
	}

	public void setFormatoConta(String formatoConta) {
		this.formatoConta = formatoConta;
	}

}
