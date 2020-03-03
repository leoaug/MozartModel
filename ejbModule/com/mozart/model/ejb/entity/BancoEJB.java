package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the BANCO database table.
 * 
 */
@Entity
@Table(name="BANCO")
public class BancoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BANCO_IDBANCO_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BANCO_IDBANCO_GENERATOR")
	@Column(name="ID_BANCO")
	private Long idBanco;

	private String banco;

	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;

	@Column(name="NUMERO_BANCO")
	private Long numeroBanco;

    public BancoEJB() {
    }

	public Long getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Long getNumeroBanco() {
		return this.numeroBanco;
	}

	public void setNumeroBanco(Long numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

}