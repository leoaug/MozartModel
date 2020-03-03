package com.mozart.model.ejb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The primary key class for the SCM_MUDANCA_COMPLEMENTO database table.
 * 
 */
@Embeddable
public class ScmMudancaComplementoEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_MUDANCA", insertable=false, updatable = false)
	private Long idMudanca;


	@Column(name="DT_DATA_CRIACAO")
	private Timestamp dtDataCriacao;

    public ScmMudancaComplementoEJBPK() {
    }
	public Long getIdMudanca() {
		return this.idMudanca;
	}
	public void setIdMudanca(Long idMudanca) {
		this.idMudanca = idMudanca;
	}
	public Timestamp getDtDataCriacao() {
		return this.dtDataCriacao;
	}
	public void setDtDataCriacao(Timestamp dtDataCriacao) {
		this.dtDataCriacao = dtDataCriacao;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ScmMudancaComplementoEJBPK)) {
			return false;
		}
		ScmMudancaComplementoEJBPK castOther = (ScmMudancaComplementoEJBPK)other;
		return 
			(this.getIdMudanca().equals(castOther.getIdMudanca())
			&& this.getDtDataCriacao().equals(castOther.getDtDataCriacao()));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idMudanca ^ (this.idMudanca >>> 32)));
		hash = hash * prime + this.dtDataCriacao.hashCode();
		
		return hash;
    }
}