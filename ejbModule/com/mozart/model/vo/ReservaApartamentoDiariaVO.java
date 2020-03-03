package com.mozart.model.vo;

import java.sql.Timestamp;

public class ReservaApartamentoDiariaVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4439396019580188940L;
	private Timestamp bcData;
    private Long bcIdHotel;
    private Long bcIdReserva;
    private Long bcIdReservaApartamento;
    private Double bcTarifa;
    private String bcJustificaTarifa;
    private Long bcIdMoeda;
    private Long bcIdReservaApartamentoDiaria;            
        
    
	
	public void setaDados(Object[] pLinha) {    
        setLinha(pLinha);
        bcData = getTimestamp();
        bcIdHotel = getLong();
        bcIdReserva = getLong();
        bcIdReservaApartamento = getLong();
        bcTarifa = getDouble();
        bcJustificaTarifa = getString();
        bcIdMoeda = getLong();
        bcIdReservaApartamentoDiaria = getLong();            
    }
    
    public ReservaApartamentoDiariaVO() {
    }

    public void setBcData(Timestamp bcData) {
        this.bcData = bcData;
    }

    public Timestamp getBcData() {
        return bcData;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

    public void setBcIdReserva(Long bcIdReserva) {
        this.bcIdReserva = bcIdReserva;
    }

    public Long getBcIdReserva() {
        return bcIdReserva;
    }

    public void setBcIdReservaApartamento(Long bcIdReservaApartamento) {
        this.bcIdReservaApartamento = bcIdReservaApartamento;
    }

    public Long getBcIdReservaApartamento() {
        return bcIdReservaApartamento;
    }

    public void setBcTarifa(Double bcTarifa) {
        this.bcTarifa = bcTarifa;
    }

    public Double getBcTarifa() {
        return bcTarifa;
    }

    public void setBcJustificaTarifa(String bcJustificaTarifa) {
        this.bcJustificaTarifa = bcJustificaTarifa;
    }

    public String getBcJustificaTarifa() {
        return bcJustificaTarifa;
    }

    public void setBcIdMoeda(Long bcIdMoeda) {
        this.bcIdMoeda = bcIdMoeda;
    }

    public Long getBcIdMoeda() {
        return bcIdMoeda;
    }

    public void setBcIdReservaApartamentoDiaria(Long bcIdReservaApartamentoDiaria) {
        this.bcIdReservaApartamentoDiaria = bcIdReservaApartamentoDiaria;
    }

    public Long getBcIdReservaApartamentoDiaria() {
        return bcIdReservaApartamentoDiaria;
    }
}
