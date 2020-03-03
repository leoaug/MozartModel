package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the POLITICA_HOTEL database table.
 * 
 */
@Entity
@Table(name="POLITICA_HOTEL")
public class PoliticaHotelEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="CHECK_IN")
	private Timestamp checkIn;

	@Column(name="CHECK_OUT")
	private Timestamp checkOut;
	
	@Column(name="CHECKIN")
	private String horaCheckIn;
	
	@Column(name="CHECKOUT")
	private String horaCheckOut;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Id
	@SequenceGenerator(name="POLITICA_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POLITICA_GENERATOR")
	@Column(name="ID_POLITICA_HOTEL")
	private Long idPoliticaHotel;

	@Column(name="IDADE_CHILD_FREE")
	private Long idadeChildFree;

	@Column(name="QTDE_CHILD_FREE")
	private Long qtdeChildFree;

	@Column(name="TIPO_PAGAMENTO")
	private String tipoPagamento;
	
	@Column(name="PRAZO_CANCELAMENTO")
	private Long prazoCancelamento;
	
	@Column(name="DEAD_LINE")
	private Long deadLine;
    
	public PoliticaHotelEJB() {
    }

	public Timestamp getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}

	public String getHoraCheckIn() {
		return horaCheckIn;
	}

	public void setHoraCheckIn(String horaCheckIn) {
		this.horaCheckIn = horaCheckIn;
	}

	public String getHoraCheckOut() {
		return horaCheckOut;
	}

	public void setHoraCheckOut(String horaCheckOut) {
		this.horaCheckOut = horaCheckOut;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdPoliticaHotel() {
		return idPoliticaHotel;
	}

	public void setIdPoliticaHotel(Long idPoliticaHotel) {
		this.idPoliticaHotel = idPoliticaHotel;
	}

	public Long getIdadeChildFree() {
		return idadeChildFree;
	}

	public void setIdadeChildFree(Long idadeChildFree) {
		this.idadeChildFree = idadeChildFree;
	}

	public Long getQtdeChildFree() {
		return qtdeChildFree;
	}

	public void setQtdeChildFree(Long qtdeChildFree) {
		this.qtdeChildFree = qtdeChildFree;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Long getPrazoCancelamento() {
		return prazoCancelamento;
	}

	public void setPrazoCancelamento(Long prazoCancelamento) {
		this.prazoCancelamento = prazoCancelamento;
	}

	public Long getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Long deadLine) {
		this.deadLine = deadLine;
	}

}