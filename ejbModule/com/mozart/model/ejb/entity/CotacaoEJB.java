package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the COTACAO database table.
 * 
 */
@Entity
@Table(name="COTACAO")
@NamedQuery(name="CotacaoEJB.findAll", query="SELECT c FROM CotacaoEJB c")
public class CotacaoEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CotacaoEJBPK id;

	private String aprovada;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_COTACAO")
	private Date dataCotacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NECESSIDADE")
	private Date dataNecessidade;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PEDIDO")
	private Date dataPedido;

	private BigDecimal estoque;

	@Column(name="ID_FORNECEDOR")
	private BigDecimal idFornecedor;

	@Column(name="ID_ITEM")
	private BigDecimal idItem;

	@Column(name="NUMERO_COTACAO")
	private BigDecimal numeroCotacao;

	@Column(name="NUMERO_PEDIDO")
	private BigDecimal numeroPedido;

	@Column(name="PRECO_UNITARIO")
	private BigDecimal precoUnitario;

	@Column(name="QUANTIDADE_COTADA")
	private BigDecimal quantidadeCotada;

	@Column(name="QUANTIDADE_PEDIDA")
	private BigDecimal quantidadePedida;

	public CotacaoEJB() {
	}

	public CotacaoEJBPK getId() {
		return this.id;
	}

	public void setId(CotacaoEJBPK id) {
		this.id = id;
	}

	public String getAprovada() {
		return this.aprovada;
	}

	public void setAprovada(String aprovada) {
		this.aprovada = aprovada;
	}

	public Date getDataCotacao() {
		return this.dataCotacao;
	}

	public void setDataCotacao(Date dataCotacao) {
		this.dataCotacao = dataCotacao;
	}

	public Date getDataNecessidade() {
		return this.dataNecessidade;
	}

	public void setDataNecessidade(Date dataNecessidade) {
		this.dataNecessidade = dataNecessidade;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getEstoque() {
		return this.estoque;
	}

	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(BigDecimal idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public BigDecimal getIdItem() {
		return this.idItem;
	}

	public void setIdItem(BigDecimal idItem) {
		this.idItem = idItem;
	}

	public BigDecimal getNumeroCotacao() {
		return this.numeroCotacao;
	}

	public void setNumeroCotacao(BigDecimal numeroCotacao) {
		this.numeroCotacao = numeroCotacao;
	}

	public BigDecimal getNumeroPedido() {
		return this.numeroPedido;
	}

	public void setNumeroPedido(BigDecimal numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public BigDecimal getPrecoUnitario() {
		return this.precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getQuantidadeCotada() {
		return this.quantidadeCotada;
	}

	public void setQuantidadeCotada(BigDecimal quantidadeCotada) {
		this.quantidadeCotada = quantidadeCotada;
	}

	public BigDecimal getQuantidadePedida() {
		return this.quantidadePedida;
	}

	public void setQuantidadePedida(BigDecimal quantidadePedida) {
		this.quantidadePedida = quantidadePedida;
	}

}