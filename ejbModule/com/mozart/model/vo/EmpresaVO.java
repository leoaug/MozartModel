package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class EmpresaVO extends MozartVO{
	private static final long serialVersionUID = -7854970308535592038L;
	
	private FiltroWeb filtroCidade;
	private FiltroWeb filtroUF;
	private FiltroWeb filtroEstado;
	private FiltroWeb filtroBairro;
	private FiltroWeb filtroCNPJ;
	private FiltroWeb filtroFantasia;
	private FiltroWeb filtroRazaoSocial;
	private FiltroWeb filtroCredito;
	private FiltroWeb filtroNomeFantasiaCNPJ;
	
	private Long idEmpresa;
	private Long idRedeHotel;
	private Long idHotel;
	private String nomeFantasia;
	private String razaoSocial;
	private String telefone;
	private String fax;
	private String telex;
	private String contato;
	private String cnpj;
	private String email;
	private String credito;
	private String tipoEmpresa;
	private String cidade;
	private String estado;
	private String pais;
	private Double comissaoCRS;
	private String nacional;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String siglaHotel;
	private Double valorCredito;
	private Double comissao;
	private Long prazoPagamento;
	private String nomeFantasiaCNPJ;
	
	public EmpresaVO(){
		filtroCidade = new FiltroWeb();
		filtroUF = new FiltroWeb();
		filtroEstado = new FiltroWeb();
		filtroBairro = new FiltroWeb();
		filtroCNPJ = new FiltroWeb();
		filtroFantasia = new FiltroWeb();
		filtroRazaoSocial = new FiltroWeb();
		filtroCredito = new FiltroWeb();
		filtroNomeFantasiaCNPJ = new FiltroWeb();
	}
	
	public EmpresaVO( Object[] linha ){
		if (!MozartUtil.isNull( linha )){
			setLinha(linha);
			idEmpresa = getLong();
			idRedeHotel = getLong();
			idHotel = getLong();
			nomeFantasia = getString();
			razaoSocial = getString();
			telefone = getString();
			fax = getString();
			telex = getString();
			contato = getString();
			cnpj = getString();
			email = getString();
			credito = getString();
			tipoEmpresa = getString();
			cidade = getString();
			estado = getString();
			pais = getString();
			comissaoCRS = getDouble();
			nacional = getString();
			endereco = getString();
			bairro = getString();
			siglaHotel = getString();
			valorCredito = getDouble();
			comissao = getDouble();
			prazoPagamento = getLong();
			numero = getString();
			complemento = getString();
		}
	}

	public FiltroWeb getFiltroCidade() {
		return filtroCidade;
	}

	public void setFiltroCidade(FiltroWeb filtroCidade) {
		this.filtroCidade = filtroCidade;
	}

	public FiltroWeb getFiltroUF() {
		return filtroUF;
	}

	public void setFiltroUF(FiltroWeb filtroUF) {
		this.filtroUF = filtroUF;
	}

	public FiltroWeb getFiltroEstado() {
		return filtroEstado;
	}

	public void setFiltroEstado(FiltroWeb filtroEstado) {
		this.filtroEstado = filtroEstado;
	}

	public FiltroWeb getFiltroBairro() {
		return filtroBairro;
	}

	public void setFiltroBairro(FiltroWeb filtroBairro) {
		this.filtroBairro = filtroBairro;
	}

	public FiltroWeb getFiltroCNPJ() {
		return filtroCNPJ;
	}

	public void setFiltroCNPJ(FiltroWeb filtroCNPJ) {
		this.filtroCNPJ = filtroCNPJ;
	}

	public FiltroWeb getFiltroFantasia() {
		return filtroFantasia;
	}

	public void setFiltroFantasia(FiltroWeb filtroFantasia) {
		this.filtroFantasia = filtroFantasia;
	}

	public FiltroWeb getFiltroRazaoSocial() {
		return filtroRazaoSocial;
	}

	public void setFiltroRazaoSocial(FiltroWeb filtroRazaoSocial) {
		this.filtroRazaoSocial = filtroRazaoSocial;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelex() {
		return telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Double getComissaoCRS() {
		return comissaoCRS;
	}

	public void setComissaoCRS(Double comissaoCRS) {
		this.comissaoCRS = comissaoCRS;
	}

	public String getNacional() {
		return nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getSiglaHotel() {
		return siglaHotel;
	}

	public void setSiglaHotel(String siglaHotel) {
		this.siglaHotel = siglaHotel;
	}

	public Double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Long getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(Long prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public FiltroWeb getFiltroCredito() {
		return filtroCredito;
	}

	public void setFiltroCredito(FiltroWeb filtroCredito) {
		this.filtroCredito = filtroCredito;
	}

	public FiltroWeb getFiltroNomeFantasiaCNPJ() {
		return filtroNomeFantasiaCNPJ;
	}

	public void setFiltroNomeFantasiaCNPJ(FiltroWeb filtroNomeFantasiaCNPJ) {
		this.filtroNomeFantasiaCNPJ = filtroNomeFantasiaCNPJ;
	}

	public String getNomeFantasiaCNPJ() {
		return nomeFantasiaCNPJ;
	}

	public void setNomeFantasiaCNPJ(String nomeFantasiaCNPJ) {
		this.nomeFantasiaCNPJ = nomeFantasiaCNPJ;
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
}
