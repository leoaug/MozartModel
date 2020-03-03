package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FORNECEDOR_GRUPO database table.
 * 
 */
@Entity
@Table(name="FORNECEDOR_GRUPO")
public class FornecedorGrupoEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORNECEDOR_GRUPO_IDFORNECEDORGRUPO_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORNECEDOR_GRUPO_IDFORNECEDORGRUPO_GENERATOR")
	@Column(name="ID_FORNECEDOR_GRUPO")
	private Long idFornecedorGrupo;

	private String descricao;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

    public FornecedorGrupoEJB() {
    }

	public Long getIdFornecedorGrupo() {
		return this.idFornecedorGrupo;
	}

	public void setIdFornecedorGrupo(Long idFornecedorGrupo) {
		this.idFornecedorGrupo = idFornecedorGrupo;
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