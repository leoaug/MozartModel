package com.mozart.model.vo;

import java.util.Date;



public class RoomListVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4434950684156328313L;
	/* campos espelho do banco - bc */
    private Long bcIdRoomList;
    private Long bcIdCheckin;
    private Long bcIdReserva;
    private Long bcIdTipoHospede;
    private Long bcIdHotel;
    private Long bcIdCentralReservas;
    private Long bcIdHospede;
    private String bcSexo;
    private Long bcIdRedeHotel;
    private String bcNomeHospede;
    private String bcSobenomeHospede;
    private Long bcIdTipoLancamento;
    private Long bcIdReservaApartamento;
    private String bcPrincipal;;
    private String bcChegou;
    private Date bcDataCertificado;
    private Long bcCodCertificado;        
    private String bcTipoHospede;
    
    /* campo para auxiliar na tela  */
    private String bcTemp;
    
    
	public void setaDados(Object[] pLinha) {    
        setLinha(pLinha);
        bcIdRoomList = getLong();
        bcIdCheckin = getLong();
        bcIdReserva = getLong();
        bcIdTipoHospede = getLong();
        bcTipoHospede = getString();
        bcIdHotel = getLong();
        bcIdCentralReservas = getLong();
        bcIdHospede = getLong();
        bcSexo = getString();
        bcIdRedeHotel = getLong();
        bcNomeHospede = getString();
        bcSobenomeHospede = getString();
        bcIdTipoLancamento = getLong();
        bcIdReservaApartamento = getLong();
        bcPrincipal = getString();
        bcChegou = getString();
        bcDataCertificado = getDate();
        bcCodCertificado = getLong();
        getDate();
        getDate();        
    }
    
    public RoomListVO() {
    }

    public void setBcIdRoomList(Long bcIdRoomList) {
        this.bcIdRoomList = bcIdRoomList;
    }

    public Long getBcIdRoomList() {
        return bcIdRoomList;
    }

    public void setBcIdCheckin(Long bcIdCheckin) {
        this.bcIdCheckin = bcIdCheckin;
    }

    public Long getBcIdCheckin() {
        return bcIdCheckin;
    }

    public void setBcIdReserva(Long bcIdReserva) {
        this.bcIdReserva = bcIdReserva;
    }

    public Long getBcIdReserva() {
        return bcIdReserva;
    }

    public void setBcIdTipoHospede(Long bcIdTipoHospede) {
        this.bcIdTipoHospede = bcIdTipoHospede;
    }

    public Long getBcIdTipoHospede() {
        return bcIdTipoHospede;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

    public void setBcIdCentralReservas(Long bcIdCentralReservas) {
        this.bcIdCentralReservas = bcIdCentralReservas;
    }

    public Long getBcIdCentralReservas() {
        return bcIdCentralReservas;
    }

    public void setBcIdHospede(Long bcIdHospede) {
        this.bcIdHospede = bcIdHospede;
    }

    public Long getBcIdHospede() {
        return bcIdHospede;
    }

    public void setBcSexo(String bcSexo) {
        this.bcSexo = bcSexo;
    }

    public String getBcSexo() {
        return bcSexo;
    }

    public void setBcIdRedeHotel(Long bcIdRedeHotel) {
        this.bcIdRedeHotel = bcIdRedeHotel;
    }

    public Long getBcIdRedeHotel() {
        return bcIdRedeHotel;
    }

    public void setBcNomeHospede(String bcNomeHospede) {
        this.bcNomeHospede = bcNomeHospede;
    }

    public String getBcNomeHospede() {
        return bcNomeHospede;
    }

    public void setBcSobenomeHospede(String bcSobenomeHospede) {
        this.bcSobenomeHospede = bcSobenomeHospede;
    }

    public String getBcSobenomeHospede() {
        return bcSobenomeHospede;
    }

    public void setBcIdTipoLancamento(Long bcIdTipoLancamento) {
        this.bcIdTipoLancamento = bcIdTipoLancamento;
    }

    public Long getBcIdTipoLancamento() {
        return bcIdTipoLancamento;
    }

    public void setBcIdReservaApartamento(Long bcIdReservaApartamento) {
        this.bcIdReservaApartamento = bcIdReservaApartamento;
    }

    public Long getBcIdReservaApartamento() {
        return bcIdReservaApartamento;
    }

    public void setBcPrincipal(String bcPrincipal) {
        this.bcPrincipal = bcPrincipal;
    }

    public String getBcPrincipal() {
        return bcPrincipal;
    }

    public void setBcChegou(String bcChegou) {
        this.bcChegou = bcChegou;
    }

    public String getBcChegou() {
        return bcChegou;
    }

    public void setBcDataCertificado(Date bcDataCertificado) {
        this.bcDataCertificado = bcDataCertificado;
    }

    public Date getBcDataCertificado() {
        return bcDataCertificado;
    }

    public void setBcCodCertificado(Long bcCodCertificado) {
        this.bcCodCertificado = bcCodCertificado;
    }

    public Long getBcCodCertificado() {
        return bcCodCertificado;
    }

    public void setBcTemp(String bcTemp) {
        this.bcTemp = bcTemp;
    }

    public String getBcTemp() {
        return bcTemp;
    }

	public String getBcTipoHospede() {
		return bcTipoHospede;
	}

	public void setBcTipoHospede(String bcTipoHospede) {
		this.bcTipoHospede = bcTipoHospede;
	}
}
