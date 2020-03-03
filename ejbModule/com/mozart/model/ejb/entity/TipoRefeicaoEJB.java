package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the TIPO_REFEICAO database table.
 * 
 */
@Entity
@Table(name="TIPO_REFEICAO")
public class TipoRefeicaoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_REFEICAO_IDTIPOREFEICAO_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_REFEICAO_IDTIPOREFEICAO_GENERATOR")
	@Column(name="ID_TIPO_REFEICAO")
	private Long idTipoRefeicao;

	private String descricao;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

    public TipoRefeicaoEJB() {
    }

	public Long getIdTipoRefeicao() {
		return this.idTipoRefeicao;
	}

	public void setIdTipoRefeicao(Long idTipoRefeicao) {
		this.idTipoRefeicao = idTipoRefeicao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

}