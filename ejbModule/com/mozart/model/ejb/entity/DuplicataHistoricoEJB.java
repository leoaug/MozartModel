package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "HISTORICO_TITULOS")
public class DuplicataHistoricoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HISTORICO_TITULOS_IDHISTORICOTITULOS_GENERATOR", sequenceName = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HISTORICO_TITULOS_IDHISTORICOTITULOS_GENERATOR")
	@Column(name = "ID_HISTORICO_TITULOS")
	private long idHistoricoTitulos;

	private String contato;

	private Timestamp data;

	private String forma;

	@Column(name = "ID_HOTEL")
	private Long idHotel;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ID_TITULO", referencedColumnName = "ID_DUPLICATA")
	private DuplicataEJB duplicataEJB;

	@Column(name = "NUMERO_FORMA")
	private String numeroForma;

	private String observacoes;

	public DuplicataHistoricoEJB() {
	}

	public long getIdHistoricoTitulos() {
		return this.idHistoricoTitulos;
	}

	public void setIdHistoricoTitulos(long idHistoricoTitulos) {
		this.idHistoricoTitulos = idHistoricoTitulos;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getForma() {
		return this.forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNumeroForma() {
		return this.numeroForma;
	}

	public void setNumeroForma(String numeroForma) {
		this.numeroForma = numeroForma;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public DuplicataEJB getDuplicataEJB() {
		return duplicataEJB;
	}

	public void setDuplicataEJB(DuplicataEJB duplicataEJB) {
		this.duplicataEJB = duplicataEJB;
	}

}