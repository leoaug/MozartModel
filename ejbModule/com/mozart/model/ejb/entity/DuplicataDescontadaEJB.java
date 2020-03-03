package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="DUPLICATA_DESCONTADA")
public class DuplicataDescontadaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DUPLICATA_DESCONTADA_IDDUPLICATADESCONTADA_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUPLICATA_DESCONTADA_IDDUPLICATADESCONTADA_GENERATOR")
	@Column(name="ID_DUPLICATA_DESCONTADA")
	private long idDuplicataDescontada;

	@Column(name="CONTA_CORRENTE")
	private Long contaCorrente;

	@Column(name="DATA_DESCONTO")
	private Timestamp dataDesconto;

	@Column(name="DATA_RECOMPRA")
	private Timestamp dataRecompra;

	@Column(name="ID_CENTRO_CUSTO")
	private Long idCentroCusto;

	@Column(name="ID_HISTORICO")
	private Long idHistorico;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_PLANO_CONTAS")
	private Long idPlanoContas;

	private Double valor;

    public DuplicataDescontadaEJB() {
    }

	public long getIdDuplicataDescontada() {
		return this.idDuplicataDescontada;
	}

	public void setIdDuplicataDescontada(long idDuplicataDescontada) {
		this.idDuplicataDescontada = idDuplicataDescontada;
	}

	public Long getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Timestamp getDataDesconto() {
		return this.dataDesconto;
	}

	public void setDataDesconto(Timestamp dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public Timestamp getDataRecompra() {
		return this.dataRecompra;
	}

	public void setDataRecompra(Timestamp dataRecompra) {
		this.dataRecompra = dataRecompra;
	}

	public Long getIdCentroCusto() {
		return this.idCentroCusto;
	}

	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	public Long getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdPlanoContas() {
		return this.idPlanoContas;
	}

	public void setIdPlanoContas(Long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}