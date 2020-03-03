package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IDIOMA_MOZART database table.
 * 
 */
@Entity
@Table(name="IDIOMA_MOZART")
public class IdiomaMozartEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IDIOMA_MOZART_IDIDIOMA_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDIOMA_MOZART_IDIDIOMA_GENERATOR")
	@Column(name="ID_IDIOMA")
	private Long idIdioma;

	private String descricao;

	private String sigla;
	
	@Column(name="ENDERECO_IMAGEM")
	private String enderecoImagem;


    public IdiomaMozartEJB() {
    }

	public Long getIdIdioma() {
		return this.idIdioma;
	}

	public void setIdIdioma(Long idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEnderecoImagem() {
		return enderecoImagem;
	}

	public void setEnderecoImagem(String enderecoImagem) {
		this.enderecoImagem = enderecoImagem;
	}

	
}