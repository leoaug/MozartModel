package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class HotelVO extends MozartVO {

	private static final long serialVersionUID = 7540220476141649729L;

	private FiltroWeb filtroIdHotel;
	private FiltroWeb filtroNomeFantasia;

	private Long idHotel;
	private String nomeFantasia;
	private String razaoSocial;
	private String endereco;
	private String cep;
	private String bairro;
	private String telefone;
	private String email;
	private String fax;
	private String cgc;

	public HotelVO() {

		filtroIdHotel = new FiltroWeb();
		filtroNomeFantasia = new FiltroWeb();

	}

	public HotelVO(Object[] linha) {
		if (linha != null) {
			setLinha(linha);
			idHotel = getLong();
			nomeFantasia = getString();
			razaoSocial = getString();
			endereco = getString();
			cep = getString();
			bairro = getString();
			telefone = getString();
			email = getString();
			fax = getString();
			cgc = getString();

		}
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public FiltroWeb getFiltroIdHotel() {
		return filtroIdHotel;
	}

	public void setFiltroIdHotel(FiltroWeb filtroIdHotel) {
		this.filtroIdHotel = filtroIdHotel;
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

}
