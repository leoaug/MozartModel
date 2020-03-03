package com.mozart.model.vo;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;


public class ReservaApartamentoVO extends MozartVO {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4633888604303969927L;
	/* Campos espelho do banco  bc - banco*/
    private Long bcIdReservaApartamento;
    private Long bcIdTipoApartamento;
    private Long bcIdReserva;
    private Long bcQtdeApartamento;
    private Long bcQtdeCheckin;
    private Long bcQtdePax;
    private Double bcTarifa;
    @SuppressWarnings("unused")
	private Double bcTotalTarifa;
    private String bcJustificaTarifa;
    private Long bcIdCentralReservas;
    private Long bcIdHotel;
    private Long bcAdicional;
    private Long bcQtdeCrianca;
    private Long bcIdApartamento;
    private String bcMaster;
    private Double bcValorPensao;
    private Timestamp bcDataEntrada;
    private Timestamp bcDataSaida;
    private String bcCafe;
    private Double bcValorCafe;
    private String bcMap;
    private Double bcValorMap;
    private String bcFap;
    private String bcTarifaManual;
    private String bcDataManual;
    private Long bcIdTipoDiaria;
    /* Fim Campos espelho do banco  bc - banco*/
    
    /* Campos auxiliares*/
    private String bcTipoApartamentoDesc;
    private String bcQtdePaxDesc;
    private String bcApartamentoDesc;
    private String bcTipoDiariaDesc;
    private Long bcIdEmpresa;
    private Long bcIdMoeda;
    private String bcNoShow;
    private String bcCheckout;
    private Long bcGrupoSimNao;
    
    private List<ReservaApartamentoDiariaVO> listReservaApartamentoDiaria;
    private List<RoomListVO> listRoomList;
    

    
	public void setaDados(Object[] pLinha) {
        
        setLinha(pLinha);
        bcIdReservaApartamento = getLong();
        bcIdTipoApartamento = getLong();
        bcIdReserva = getLong();
        bcQtdeApartamento = getLong();
        bcQtdeCheckin = getLong();
        bcQtdePax = getLong();
        bcTarifa = getDouble();
        bcJustificaTarifa = getString();
        bcIdCentralReservas = getLong();
        bcIdHotel = getLong();
        bcTotalTarifa = getDouble();
        bcAdicional = getLong();
        bcQtdeCrianca = getLong();
        bcIdApartamento = getLong();
        bcMaster = getString();
        bcValorPensao = getDouble();
        bcDataEntrada = getTimestamp();
        bcDataSaida = getTimestamp();
        bcCafe = getString();
        bcValorCafe = getDouble();
        bcMap = getString();
        bcValorMap = getDouble();
        bcFap = getString();
        bcTarifaManual = getString();
        bcDataManual = getString();
        bcIdTipoDiaria = getLong();                
        Long apdesc = getLong();
        if (apdesc!=null)
            bcApartamentoDesc = apdesc.toString();
        bcNoShow = getString();
        bcCheckout = getString();
        bcTipoApartamentoDesc = getString();
        bcTipoDiariaDesc = getString();
    }
    
    public ReservaApartamentoVO() {
        listReservaApartamentoDiaria = new ArrayList<ReservaApartamentoDiariaVO>();
        listRoomList = new ArrayList<RoomListVO>();
    }


    public void setBcIdReservaApartamento(Long bcIdReservaApartamento) {
        this.bcIdReservaApartamento = bcIdReservaApartamento;
    }

    public Long getBcIdReservaApartamento() {
        return bcIdReservaApartamento;
    }

    public void setBcIdTipoApartamento(Long bcIdTipoApartamento) {
        this.bcIdTipoApartamento = bcIdTipoApartamento;
    }

    public Long getBcIdTipoApartamento() {
        return bcIdTipoApartamento;
    }

    public void setBcIdReserva(Long bcIdReserva) {
        this.bcIdReserva = bcIdReserva;
    }

    public Long getBcIdReserva() {
        return bcIdReserva;
    }

    public void setBcQtdeApartamento(Long bcQtdeApartamento) {
        this.bcQtdeApartamento = bcQtdeApartamento;
    }

    public Long getBcQtdeApartamento() {
        return bcQtdeApartamento;
    }

    public void setBcQtdeCheckin(Long bcQtdeCheckin) {
        this.bcQtdeCheckin = bcQtdeCheckin;
    }

    public Long getBcQtdeCheckin() {
        return bcQtdeCheckin;
    }

    public void setBcQtdePax(Long bcQtdePax) {
        this.bcQtdePax = bcQtdePax;
    }

    public Long getBcQtdePax() {
        return bcQtdePax;
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

    public void setBcIdCentralReservas(Long bcIdCentralReservas) {
        this.bcIdCentralReservas = bcIdCentralReservas;
    }

    public Long getBcIdCentralReservas() {
        return bcIdCentralReservas;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }


    public Double getBcTotalTarifa() {
        Double total = new Double(0);
        for (ReservaApartamentoDiariaVO obj: listReservaApartamentoDiaria) {
            total += obj.getBcTarifa();
        }
        return total;
    }

    public void setBcAdicional(Long bcAdicional) {
        this.bcAdicional = bcAdicional;
    }

    public Long getBcAdicional() {
        return bcAdicional;
    }

    public void setBcQtdeCrianca(Long bcQtdeCrianca) {
        this.bcQtdeCrianca = bcQtdeCrianca;
    }

    public Long getBcQtdeCrianca() {
        return bcQtdeCrianca;
    }

    public void setBcIdApartamento(Long bcIdApartamento) {
        this.bcIdApartamento = bcIdApartamento;
    }

    public Long getBcIdApartamento() {
        return bcIdApartamento;
    }

    public void setBcMaster(String bcMaster) {
        this.bcMaster = bcMaster;
    }

    public String getBcMaster() {
        return bcMaster;
    }

    public void setBcValorPensao(Double bcValorPensao) {
        this.bcValorPensao = bcValorPensao;
    }

    public Double getBcValorPensao() {
        return bcValorPensao;
    }

    public void setBcDataEntrada(Timestamp bcDataEntrada) {
        this.bcDataEntrada = bcDataEntrada;
    }

    public Timestamp getBcDataEntrada() {
        return bcDataEntrada;
    }

    public void setBcDataSaida(Timestamp bcDataSaida) {
        this.bcDataSaida = bcDataSaida;
    }

    public Timestamp getBcDataSaida() {
        return bcDataSaida;
    }

    public void setBcCafe(String bcCafe) {
        this.bcCafe = bcCafe;
    }

    public String getBcCafe() {
        return bcCafe;
    }

    public void setBcValorCafe(Double bcValorCafe) {
        this.bcValorCafe = bcValorCafe;
    }

    public Double getBcValorCafe() {
        return bcValorCafe;
    }

    public void setBcMap(String bcMap) {
        this.bcMap = bcMap;
    }

    public String getBcMap() {
        return bcMap;
    }

    public void setBcValorMap(Double bcValorMap) {
        this.bcValorMap = bcValorMap;
    }

    public Double getBcValorMap() {
        return bcValorMap;
    }

    public void setBcFap(String bcFap) {
        this.bcFap = bcFap;
    }

    public String getBcFap() {
        return bcFap;
    }

    public void setBcTarifaManual(String bcTarifaManual) {
        this.bcTarifaManual = bcTarifaManual;
    }

    public String getBcTarifaManual() {
        return bcTarifaManual;
    }

    public void setBcDataManual(String bcDataManual) {
        this.bcDataManual = bcDataManual;
    }

    public String getBcDataManual() {
        return bcDataManual;
    }

    public void setBcIdTipoDiaria(Long bcIdTipoDiaria) {
        this.bcIdTipoDiaria = bcIdTipoDiaria;
    }

    public Long getBcIdTipoDiaria() {
        return bcIdTipoDiaria;
    }

    public void setBcQtdePaxDesc(String bcQtdePaxDesc) {
        this.bcQtdePaxDesc = bcQtdePaxDesc;
    }

    public String getBcQtdePaxDesc() {
        String tipo = "";
        if (new Long(1).equals(bcQtdePax))
            tipo ="Single";
        else if (new Long(2).equals(bcQtdePax))
            tipo ="Double";
        else if (new Long(3).equals(bcQtdePax))
            tipo ="Triple";
        else if (new Long(4).equals(bcQtdePax))
            tipo ="Quadruple";
        else if (new Long(5).equals(bcQtdePax))
            tipo ="Fivefold";
        else if (new Long(6).equals(bcQtdePax))
            tipo ="Sixfold";
        else if (new Long(7).equals(bcQtdePax))
            tipo ="Sevenfold";
        return tipo;
    }

    public void setBcTipoApartamentoDesc(String bcTipoApartamentoDesc) {
        this.bcTipoApartamentoDesc = bcTipoApartamentoDesc;
    }

    public String getBcTipoApartamentoDesc() {
        return bcTipoApartamentoDesc;
    }

    public void setBcApartamentoDesc(String bcApartamentoDesc) {
        this.bcApartamentoDesc = bcApartamentoDesc;
    }

    public String getBcApartamentoDesc() {
        return bcApartamentoDesc;
    }

    public String get_bcQtdePaxDesc() {
        return bcQtdePaxDesc;
    }

    public void setBcTipoDiariaDesc(String bcTipoDiariaDesc) {
        this.bcTipoDiariaDesc = bcTipoDiariaDesc;
    }

    public String getBcTipoDiariaDesc() {
        return bcTipoDiariaDesc;
    }

    

    public String getBcTarifaManualDesc() {
        return "S".equals(bcTarifaManual)?"Sim":"Não";
    }

    public String getBcDataManualDesc() {
        return "S".equals(bcDataManual)?"Sim":"Não";
    }
    
    public void setListReservaApartamentoDiaria(List<ReservaApartamentoDiariaVO> listReservaApartamentoDiaria) {
        this.listReservaApartamentoDiaria = listReservaApartamentoDiaria;
    }

    public List<ReservaApartamentoDiariaVO> getListReservaApartamentoDiaria() {
        return listReservaApartamentoDiaria;
    }

    public void setBcIdEmpresa(Long bcIdEmpresa) {
        this.bcIdEmpresa = bcIdEmpresa;
    }

    public Long getBcIdEmpresa() {
        return bcIdEmpresa;
    }

    public void setBcIdMoeda(Long bcIdMoeda) {
        this.bcIdMoeda = bcIdMoeda;
    }

    public Long getBcIdMoeda() {
        return bcIdMoeda;
    }

    public void setListRoomList(List<RoomListVO> listRoomList) {
        this.listRoomList = listRoomList;
    }

    public List<RoomListVO> getListRoomList() {
        return listRoomList;
    }


    public String getBcNomesHospedes() {
        String nomeHospedes = " ";
        for(RoomListVO obj: listRoomList) {
            if (obj.getBcNomeHospede()!=null)
                nomeHospedes += obj.getBcNomeHospede();
            if (obj.getBcSobenomeHospede()!=null)
                nomeHospedes += " "+obj.getBcSobenomeHospede();
            nomeHospedes+="; ";
        }
        return nomeHospedes.substring(0, nomeHospedes.length()-2);
    }


    public String getBcNomePrimeiroHospede() {
        String nomeHospedes = "";
        for(RoomListVO obj: listRoomList) {
            if (obj.getBcNomeHospede()!=null)
                nomeHospedes += obj.getBcNomeHospede();
            if (obj.getBcSobenomeHospede()!=null)
                nomeHospedes += " "+obj.getBcSobenomeHospede();
            break;
        }        
        return nomeHospedes;
    }

    public void setBcNoShow(String bcNoShow) {
        this.bcNoShow = bcNoShow;
    }

    public String getBcNoShow() {
        return bcNoShow;
    }

    public void setBcCheckout(String bcCheckout) {
        this.bcCheckout = bcCheckout;
    }

    public String getBcCheckout() {
        return bcCheckout;
    }

    public void setBcGrupoSimNao(Long bcGrupoSimNao) {
        this.bcGrupoSimNao = bcGrupoSimNao;
    }

    public Long getBcGrupoSimNao() {
        return bcGrupoSimNao;
    }

	public void setBcTotalTarifa(Double bcTotalTarifa) {
		this.bcTotalTarifa = bcTotalTarifa;
	}
}
