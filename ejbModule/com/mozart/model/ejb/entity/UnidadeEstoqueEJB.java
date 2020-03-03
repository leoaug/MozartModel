package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the UNIDADE_ESTOQUE database table.
 * 
 */
@Entity
@NamedQuery(name = "UnidadeEstoqueEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from UnidadeEstoqueEJB o where o.idRedeHotel = ?1 order by o.nomeUnidade")
@Table(name="UNIDADE_ESTOQUE")
public class UnidadeEstoqueEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDADE_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDADE_GENERATOR")
	@Column(name="ID_UNIDADE_ESTOQUE")
	private Long idUnidadeEstoque;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	private Double fracao;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NOME_UNIDADE")
	private String nomeUnidade;

	@Column(name="NOME_UNIDADE_REDUZIDO")
	private String nomeUnidadeReduzido;

    public UnidadeEstoqueEJB() {
    }

	public Double getFracao() {
		return this.fracao;
	}

	public void setFracao(Double fracao) {
		this.fracao = fracao;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeUnidade() {
		return this.nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public String getNomeUnidadeReduzido() {
		return this.nomeUnidadeReduzido;
	}

	public void setNomeUnidadeReduzido(String nomeUnidadeReduzido) {
		this.nomeUnidadeReduzido = nomeUnidadeReduzido;
	}

	public Long getIdUnidadeEstoque() {
		return idUnidadeEstoque;
	}

	public void setIdUnidadeEstoque(Long idUnidadeEstoque) {
		this.idUnidadeEstoque = idUnidadeEstoque;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

}