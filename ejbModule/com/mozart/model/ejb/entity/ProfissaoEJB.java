package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the PROFISSAO database table.
 * 
 */
@Entity
@Table(name="PROFISSAO")
public class ProfissaoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="profissao", sequenceName="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="profissao")
	@Column(name="ID_PROFISSAO")
	private Long idProfissao;

	private String profissao;

    public ProfissaoEJB() {
    }

	public Long getIdProfissao() {
		return this.idProfissao;
	}

	public void setIdProfissao(Long idProfissao) {
		this.idProfissao = idProfissao;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}