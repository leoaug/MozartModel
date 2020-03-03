package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class VendedorVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb cnpj;
	private FiltroWeb nomeFantasia;
	
	private Long idVendedor;
	private String cgc;
	private String contato;
	private String nomeFantasiaCgc;
	private String tel1;
	private String tel2;
	private String email1;
	private String numAgencia;
	private String digitoAgencia;
	private String numContaCorrente;
	private String digitoContaCorrente;
	private String banco;
	private String comissao;
	private Long prazoPagamento;

	public VendedorVO(){
		cnpj = new FiltroWeb();
		nomeFantasia = new FiltroWeb();		
	}	
	
	public VendedorVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			cgc = getString();
			idVendedor = getLong();
			contato = getString();
			nomeFantasiaCgc = getString();
			tel1 = getString();
			tel2 = getString();
			email1 = getString();
			numAgencia = getString();
			digitoAgencia = getString();
			numContaCorrente = getString();
			digitoContaCorrente = getString();
			banco = getString();
			prazoPagamento = getLong();
			comissao = getString();
		
		}
		
	}

	public FiltroWeb getCnpj() {
		return cnpj;
	}

	public void setCnpj(FiltroWeb cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasiaCgc() {
		return nomeFantasiaCgc;
	}

	public void setNomeFantasiaCgc(String nomeFantasiaCgc) {
		this.nomeFantasiaCgc = nomeFantasiaCgc;
	}

	public void setNomeFantasia(FiltroWeb nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCgc() {
		return cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public String getNumContaCorrente() {
		return numContaCorrente;
	}

	public void setNumContaCorrente(String numContaCorrente) {
		this.numContaCorrente = numContaCorrente;
	}

	public String getDigitoContaCorrente() {
		return digitoContaCorrente;
	}

	public void setDigitoContaCorrente(String digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}

	public String getComissao() {
		return comissao;
	}

	public void setComissao(String comissao) {
		this.comissao = comissao;
	}

	public Long getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(Long prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public FiltroWeb getNomeFantasia() {
		return nomeFantasia;
	}
}
