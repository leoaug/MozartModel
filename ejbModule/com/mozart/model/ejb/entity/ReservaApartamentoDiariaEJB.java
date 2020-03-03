package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "ReservaApartamentoDiariaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ReservaApartamentoDiariaEJB o"),
	@NamedQuery(name = "ReservaApartamentoDiariaEJB.findByIdHotelIdReservaData", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ReservaApartamentoDiariaEJB o WHERE o.idHotel = :idHotel AND o.idReserva = :idReserva and o.data= :data")
})
@Table(name = "RESERVA_APARTAMENTO_DIARIA")
public class ReservaApartamentoDiariaEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3582832834601174953L;
	private Timestamp data;
    @Column(name="ID_HOTEL")
    private Long idHotel;
    @Column(name="ID_MOEDA")
    private Long idMoeda;
    @Column(name="ID_RESERVA")
    private Long idReserva;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqDia")
    @SequenceGenerator(name="idSeqDia", sequenceName="id", allocationSize=1)
    @Column(name="ID_RESERVA_APARTAMENTO_DIARIA", nullable = false)
    private Long idReservaApartamentoDiaria;
    @Column(name="JUSTIFICA_TARIFA")
    private String justificaTarifa;
    private Double tarifa;
    @ManyToOne
    @JoinColumn(name = "ID_RESERVA_APARTAMENTO", referencedColumnName = "ID_RESERVA_APARTAMENTO")
    private ReservaApartamentoEJB reservaApartamentoEJB;

    public ReservaApartamentoDiariaEJB() {
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }


    public Long getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Long idMoeda) {
        this.idMoeda = idMoeda;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }


    public Long getIdReservaApartamentoDiaria() {
        return idReservaApartamentoDiaria;
    }

    public void setIdReservaApartamentoDiaria(Long idReservaApartamentoDiaria) {
        this.idReservaApartamentoDiaria = idReservaApartamentoDiaria;
    }

    public String getJustificaTarifa() {
        return justificaTarifa;
    }

    public void setJustificaTarifa(String justificaTarifa) {
        this.justificaTarifa = justificaTarifa;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public ReservaApartamentoEJB getReservaApartamentoEJB() {
        return reservaApartamentoEJB;
    }

    public void setReservaApartamentoEJB(ReservaApartamentoEJB reservaApartamentoEJB) {
        this.reservaApartamentoEJB = reservaApartamentoEJB;
    }

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
}
