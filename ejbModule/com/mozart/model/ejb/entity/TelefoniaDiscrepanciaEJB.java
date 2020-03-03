package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the TELEFONIA_DISCREPANCIA database table.
 * 
 */
@Entity
@Table(name="TELEFONIA_DISCREPANCIA")
public class TelefoniaDiscrepanciaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqDiscr")
	@SequenceGenerator(name="idSeqDiscr", sequenceName="id", allocationSize=1)
	@Column(name="ID_TELEFONIA")
	private Long idTelefonia;

    private Timestamp data;

	private Long duracao;

	private String duracao2;

	@Column(name="HORA_FIM")
	private String horaFim;

	@Column(name="HORA_INICIO")
	private String horaInicio;

	@Column(name="NUM_APARTAMENTO")
	private Long numApartamento;

	@Column(name="NUM_TELEFONE")
	private String numTelefone;

	private Double valor;
	
	@Column(name="ID_RAMAL_TELEFONICO")
	private Long idRamalTelefonico;

    public TelefoniaDiscrepanciaEJB() {
    }


	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Long getDuracao() {
		return this.duracao;
	}

	public void setDuracao(Long duracao) {
		this.duracao = duracao;
	}

	public String getDuracao2() {
		return this.duracao2;
	}

	public void setDuracao2(String duracao2) {
		this.duracao2 = duracao2;
	}

	public String getHoraFim() {
		return this.horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Long getNumApartamento() {
		return this.numApartamento;
	}

	/**
	 * Não é mais para usar este campo, ele foi substituido pelo idRamalTelefonico
	 * @see idRamalTelefonico
	 * */
	@Deprecated
	public void setNumApartamento(Long numApartamento) {
		this.numApartamento = numApartamento;
	}

	public String getNumTelefone() {
		return this.numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdTelefonia() {
		return idTelefonia;
	}

	public void setIdTelefonia(Long idTelefonia) {
		this.idTelefonia = idTelefonia;
	}


	public Long getIdRamalTelefonico() {
		return idRamalTelefonico;
	}


	public void setIdRamalTelefonico(Long idRamalTelefonico) {
		this.idRamalTelefonico = idRamalTelefonico;
	}

}