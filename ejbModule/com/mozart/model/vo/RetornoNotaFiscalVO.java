package com.mozart.model.vo;

import java.util.ArrayList;
import java.util.List;


public class RetornoNotaFiscalVO extends MozartVO {

	private static final long serialVersionUID = 1L;

    private String idNotaFiscal;
    private String chaveNota;
    private String xmlNota;
    private List<String> erros;
    
	public RetornoNotaFiscalVO() {
		erros = new ArrayList<String>();
	}

	public RetornoNotaFiscalVO(Object[] filtro) {
		if (filtro != null) {
			setLinha(filtro);
			
		}
	}

	public String getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(String idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public String getChaveNota() {
		return chaveNota;
	}

	public void setChaveNota(String chaveNota) {
		this.chaveNota = chaveNota;
	}

	public String getXmlNota() {
		return xmlNota;
	}

	public void setXmlNota(String xmlNota) {
		this.xmlNota = xmlNota;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
}
