package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FISCAL_DEDUCOES database table.
 * 
 */
@Entity
@Table(name="FISCAL_DEDUCOES")
public class FiscalDeducoesEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FISCAL_DEDUCOES")
	private Long idFiscalDeducoes;

	
	@Column(name="ID_EMPRESA")
	private Long idEmpresa;


	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_NOTA")
	private Long idNota;

	@Column(name="NUM_DOC")
	private String numDoc;

	private Double valor;

    public FiscalDeducoesEJB() {
    }

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdFiscalDeducoes() {
		return this.idFiscalDeducoes;
	}

	public void setIdFiscalDeducoes(Long idFiscalDeducoes) {
		this.idFiscalDeducoes = idFiscalDeducoes;
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

	public String getNumDoc() {
		return this.numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}