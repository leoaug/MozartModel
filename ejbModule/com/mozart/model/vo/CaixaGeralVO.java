package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.util.MozartUtil;

public class CaixaGeralVO extends MozartVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2227042538841247184L;
	private Long idHotel;
    private Long idApartamento;
    private Long numApartamento;
    private String status;
    private String cofan;
    private String tipoApartamento;
    private Long idCheckin;
    private String nomeHospedeCheckin;
    private String saidaDia;
    private Long idReservaApartamento;
    private String nomeHospedeReserva;
    private Date dataEntrada;
    private String entradaDia;
    private Long idReserva;
    private String checkout;
    private Date dataSaida;
    private String obs;
    private String apelido;
    private String empresa;


    public CaixaGeralVO() {
        status = null;
        cofan = null;
        entradaDia = null;
        saidaDia = null;
    }
    
    
	
	public CaixaGeralVO(Object[] linha) {
        this();
        setLinha( linha );
        idApartamento = getLong();
        numApartamento = getLong();
        status = getString();
        cofan = getString();
        tipoApartamento = getString();
        idCheckin = getLong();
        nomeHospedeCheckin = getString();
        saidaDia = getString();
        idReservaApartamento = getLong();
        nomeHospedeReserva = getString();
        dataEntrada = getDate();
        entradaDia = getString();
        idReserva  = getLong();
        checkout = getString();
        dataSaida = getDate();
        obs = getString();
        apelido = getString();
        empresa = getString();
    }

    public String toString(){
    
        return (MozartUtil.isNull(apelido)?numApartamento:apelido) +" "+(tipoApartamento!=null?tipoApartamento:"")+" "+status;
    }


    public boolean equals(Object obj){
        if (obj == null)
            return false;
        return numApartamento.equals( ((CaixaGeralVO) obj).getNumApartamento());
    }

    public void setIdApartamento(Long idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Long getIdApartamento() {
        return idApartamento;
    }

    public void setNumApartamento(Long numApartamento) {
        this.numApartamento = numApartamento;
    }

    public Long getNumApartamento() {
        return numApartamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCofan(String cofan) {
        this.cofan = cofan;
    }

    public String getCofan() {
        return cofan;
    }

    public void setTipoApartamento(String tipoApartamento) {
        this.tipoApartamento = tipoApartamento;
    }

    public String getTipoApartamento() {
        return tipoApartamento;
    }

    public void setIdCheckin(Long idCheckin) {
        this.idCheckin = idCheckin;
    }

    public Long getIdCheckin() {
        return idCheckin;
    }

    public void setNomeHospedeCheckin(String nomeHospedeCheckin) {
        this.nomeHospedeCheckin = nomeHospedeCheckin;
    }

    public String getNomeHospedeCheckin() {
        return nomeHospedeCheckin;
    }

    public void setSaidaDia(String saidaDia) {
        this.saidaDia = saidaDia;
    }

    public String getSaidaDia() {
        return saidaDia;
    }

    public void setIdReservaApartamento(Long idReservaApartamento) {
        this.idReservaApartamento = idReservaApartamento;
    }

    public Long getIdReservaApartamento() {
        return idReservaApartamento;
    }

    public void setNomeHospedeReserva(String nomeHospedeReserva) {
        this.nomeHospedeReserva = nomeHospedeReserva;
    }

    public String getNomeHospedeReserva() {
        return nomeHospedeReserva;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setEntradaDia(String entradaDia) {
        this.entradaDia = entradaDia;
    }

    public String getEntradaDia() {
        return entradaDia;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckout() {
        return checkout;
    }



	public Date getDataSaida() {
		return dataSaida;
	}



	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}



	public String getObs() {
		return obs;
	}



	public void setObs(String obs) {
		this.obs = obs;
	}



	public String getApelido() {
		return apelido;
	}



	public void setApelido(String apelido) {
		this.apelido = apelido;
	}



	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}
