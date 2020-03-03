package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class FornecedorVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroCgc;
	private FiltroWeb filtroNomeFantasia;
	

	
	private Long idFornecedor;
	private String cgc;
	private String contato;
	private String nomeFantasia;
	private String tel1;
	private String tel2;
	private String tel3;
	private String email1;
	private String email2;
	private String email3;
	private String fax;
	private String pis;
	private String contasPagar;
	
	
	

	public FornecedorVO(){
		
		filtroCgc = new FiltroWeb();
		filtroNomeFantasia = new FiltroWeb();		
		
		
	}	
	
	public FornecedorVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idFornecedor = getLong();
			cgc = getString();
			contato = getString();
			nomeFantasia = getString();
			tel1 = getString();
			tel2 = getString();
			tel3 = getString();
			email1 = getString();
			email2 = getString();
			email3 = getString();
			fax = getString();
			pis = getString();
			contasPagar = getString();
			
		
		}
		
	}

	public FiltroWeb getFiltroCgc() {
		return filtroCgc;
	}

	public void setFiltroCgc(FiltroWeb filtroCgc) {
		this.filtroCgc = filtroCgc;
	}

	public FiltroWeb getFiltroNomeFantasia() {
		return filtroNomeFantasia;
	}

	public void setFiltroNomeFantasia(FiltroWeb filtroNomeFantasia) {
		this.filtroNomeFantasia = filtroNomeFantasia;
	}

	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(String contasPagar) {
		this.contasPagar = contasPagar;
	}

	
	
	

}
