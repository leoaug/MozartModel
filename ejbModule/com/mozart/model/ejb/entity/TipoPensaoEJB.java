package com.mozart.model.ejb.entity;

import javax.persistence.*;



/**
 * The persistent class for the TIPO_PENSAO database table.
 * 
 */
@Entity
@Table(name="TIPO_PENSAO")
public class TipoPensaoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PENSAO_IDTIPOPENSAO_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PENSAO_IDTIPOPENSAO_GENERATOR")
	@Column(name="ID_TIPO_PENSAO")
	private Long idTipoPensao;

	private String d2;

	private String descricao;

	
    public TipoPensaoEJB() {
    }

	public Long getIdTipoPensao() {
		return this.idTipoPensao;
	}

	public void setIdTipoPensao(Long idTipoPensao) {
		this.idTipoPensao = idTipoPensao;
	}

	public String getD2() {
		return this.d2;
	}

	public void setD2(String d2) {
		this.d2 = d2;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

		
}