package com.mozart.model.ejb.entity;

import javax.persistence.*;

                 
/**
 * The persistent class for the PLANO_CONTAS_SPED database table.
 * 
 */
@Entity
@Table(name="PLANO_CONTAS_SPED")
public class PlanoContasSpedEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PLANO_CONTAS_SPED")
	private Long idPlanoContasSped;

	private String analitica;

	private String descricao;

	@Column(name="NUMERO_CONTA")
	private String numeroConta;

	@Column(name="TIPO_ATIVIDADE")
	private String tipoAtividade;

	@Column(name="TIPO_CONTA")
	private String tipoConta;

    public PlanoContasSpedEJB() {
    }

    public String toString(){
    	
    	return numeroConta+" - "+descricao;
    }
	public Long getIdPlanoContasSped() {
		return this.idPlanoContasSped;
	}

	public void setIdPlanoContasSped(Long idPlanoContasSped) {
		this.idPlanoContasSped = idPlanoContasSped;
	}

	public String getAnalitica() {
		return this.analitica;
	}

	public void setAnalitica(String analitica) {
		this.analitica = analitica;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroConta() {
		return this.numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTipoAtividade() {
		return this.tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public String getTipoConta() {
		return this.tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

}