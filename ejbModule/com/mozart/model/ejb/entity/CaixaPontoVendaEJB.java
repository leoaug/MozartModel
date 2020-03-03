package com.mozart.model.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CAIXA_PONTO_VENDA database table.
 * 
 */
@Entity
@Table(name="CAIXA_PONTO_VENDA")
@NamedQuery(name="CaixaPontoVendaEJB.findAll", query="SELECT c FROM CaixaPontoVendaEJB c")
public class CaixaPontoVendaEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CAIXA_PONTO_VENDA")
	private Long idCaixaPontoVenda;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MOVIMENTO")
	private Date dataMovimento;

	@Column(name="ID_EMPRESA")
	private Long idEmpresa;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_MESA")
	private Long idMesa;

	@Column(name="ID_NOTA")
	private Long idNota;

	@Column(name="ID_PONTO_VENDA")
	private Long idPontoVenda;

	@Column(name="ID_TIPO_LANCAMENTO")
	private Long idTipoLancamento;

	@Column(name="ID_TIPO_REFEICAO")
	private Long idTipoRefeicao;

	@Column(name="NUM_DOCUMENTO")
	private String numDocumento;

	@Column(name="NUM_NOTA")
	private String numNota;

	@Column(name="QTD_PESSOAS")
	private Long qtdPessoas;

	@Column(name="SERIE_NOTA")
	private String serieNota;

	@Column(name="VALOR_NOTA")
	private Double valorNota;

	public CaixaPontoVendaEJB() {
	}

	public Long getIdCaixaPontoVenda() {
		return idCaixaPontoVenda;
	}

	public void setIdCaixaPontoVenda(Long idCaixaPontoVenda) {
		this.idCaixaPontoVenda = idCaixaPontoVenda;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public Long getIdNota() {
		return idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Long getIdPontoVenda() {
		return idPontoVenda;
	}

	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public Long getIdTipoLancamento() {
		return idTipoLancamento;
	}

	public void setIdTipoLancamento(Long idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public Long getIdTipoRefeicao() {
		return idTipoRefeicao;
	}

	public void setIdTipoRefeicao(Long idTipoRefeicao) {
		this.idTipoRefeicao = idTipoRefeicao;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNumNota() {
		return numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public Long getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Long qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public String getSerieNota() {
		return serieNota;
	}

	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

	public Double getValorNota() {
		return valorNota;
	}

	public void setValorNota(Double valorNota) {
		this.valorNota = valorNota;
	}

	
}