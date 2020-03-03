package com.mozart.model.ejb.entity;

import com.mozart.model.util.MozartUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQueries({
@NamedQuery(name = "ReservaApartamentoEJB.findBy", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	query = "select o from ReservaApartamentoEJB o"),
@NamedQuery(name = "ReservaApartamentoEJB.countByIdReserva", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	query = "select count(o.idReservaApartamento) from ReservaApartamentoEJB o where o.reservaEJB.idReserva = :idReserva"),
@NamedQuery(name = "ReservaApartamentoEJB.findByIdReservaHotelTpApto", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	query = "select o from ReservaApartamentoEJB o where o.reservaEJB.idReserva = :idReserva and o.idHotel = :idHotel and o.idTipoApartamento = :idTipoApartamento")
})
@Table(name = "RESERVA_APARTAMENTO")
public class ReservaApartamentoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4710429373847574827L;
	private Long adicional;
    private String cafe;
    @Column(name="DATA_ENTRADA")
    private Timestamp dataEntrada;
    @Column(name="DATA_MANUAL")
    private String dataManual;
    @Column(name="DATA_SAIDA")
    private Timestamp dataSaida;
    private String fap;

    @Column(name="ID_CENTRAL_RESERVAS")
    private Long idCentralReservas;
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqRA")
    @SequenceGenerator(name="idSeqRA", sequenceName="id", allocationSize=1)
    @Column(name="ID_RESERVA_APARTAMENTO", nullable = false)
    private Long idReservaApartamento;
    @Column(name="ID_TIPO_APARTAMENTO")
    private Long idTipoApartamento;
    @Column(name="ID_TIPO_DIARIA")
    private Long idTipoDiaria;
    @Column(name="JUSTIFICA_TARIFA")
    private String justificaTarifa;
    private String map;
    private String master;
    @Column(name="QTDE_APARTAMENTO")
    private Long qtdeApartamento;
    @Column(name="QTDE_CHECKIN")
    private Long qtdeCheckin;
    @Column(name="QTDE_CRIANCA")
    private Long qtdeCrianca;
    @Column(name="QTDE_PAX")
    private Long qtdePax;
    private Double tarifa;
    @Column(name="TARIFA_MANUAL")
    private String tarifaManual;
    @Column(name="TOTAL_TARIFA")
    private Double totalTarifa;
    @Column(name="VALOR_CAFE")
    private Double valorCafe;
    @Column(name="VALOR_MAP")
    private Double valorMap;
    @Column(name="VALOR_PENSAO")
    private Double valorPensao;
    @OneToMany(mappedBy = "reservaApartamentoEJB", fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
    private List<ReservaApartamentoDiariaEJB> reservaApartamentoDiariaEJBList;

    @OneToMany(mappedBy = "reservaApartamentoEJB", fetch=FetchType.EAGER, cascade={CascadeType.REFRESH})
    private List<RoomListEJB> roomListEJBList;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    private ReservaEJB reservaEJB;

    
    @OneToOne(cascade={CascadeType.REFRESH}, optional=false, fetch=FetchType.EAGER )
    @JoinColumn(name="ID_APARTAMENTO", referencedColumnName="ID_APARTAMENTO")
    private ApartamentoEJB apartamentoEJB;


    @Transient
    private String confirmada;
    

    public ReservaApartamentoEJB() {
        roomListEJBList = new ArrayList<RoomListEJB>();
        reservaApartamentoDiariaEJBList = new ArrayList<ReservaApartamentoDiariaEJB>();
        apartamentoEJB = new ApartamentoEJB();
    }


    public int getQtdeRoomList(){
        
        int result = 0;
        for (RoomListEJB room: roomListEJBList){
            if (MozartUtil.isNull(room.getDataSaida())){
                result ++;
            }
        }
    
        return result;
    }


    public String getHospedePrincipal(){
    	String result = "[Sem hóspede principal]";
    	RoomListEJB principal = null;
        for (RoomListEJB rl: roomListEJBList){
            if ( "S".equals( rl.getPrincipal() )){
                result =  rl.getHospede().getNomeHospede()+" "+rl.getHospede().getSobrenomeHospede();
                principal = rl;
                break;
            }
        }
        if (principal!=null){
        	roomListEJBList.remove( principal );
        	roomListEJBList.add(0, principal );
        }
        
        return result;
    }


    public Long getAdicional() {
        return adicional;
    }

    public void setAdicional(Long adicional) {
        this.adicional = adicional;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public Timestamp getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataManual() {
        return dataManual;
    }

    public void setDataManual(String dataManual) {
        this.dataManual = dataManual;
    }

    public Timestamp getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getFap() {
        return fap;
    }

    public void setFap(String fap) {
        this.fap = fap;
    }

    public Long getIdCentralReservas() {
        return idCentralReservas;
    }

    public void setIdCentralReservas(Long idCentralReservas) {
        this.idCentralReservas = idCentralReservas;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }


    public Long getIdReservaApartamento() {
        return idReservaApartamento;
    }

    public void setIdReservaApartamento(Long idReservaApartamento) {
        this.idReservaApartamento = idReservaApartamento;
    }

    public Long getIdTipoApartamento() {
        return idTipoApartamento;
    }

    public void setIdTipoApartamento(Long idTipoApartamento) {
        this.idTipoApartamento = idTipoApartamento;
    }

    public Long getIdTipoDiaria() {
        return idTipoDiaria;
    }

    public void setIdTipoDiaria(Long idTipoDiaria) {
        this.idTipoDiaria = idTipoDiaria;
    }

    public String getJustificaTarifa() {
        return justificaTarifa;
    }

    public void setJustificaTarifa(String justificaTarifa) {
        this.justificaTarifa = justificaTarifa;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Long getQtdeApartamento() {
        return qtdeApartamento;
    }

    public void setQtdeApartamento(Long qtdeApartamento) {
        this.qtdeApartamento = qtdeApartamento;
    }

    public Long getQtdeCheckin() {
        return qtdeCheckin;
    }

    public void setQtdeCheckin(Long qtdeCheckin) {
        this.qtdeCheckin = qtdeCheckin;
    }

    public Long getQtdeCrianca() {
        return qtdeCrianca;
    }

    public void setQtdeCrianca(Long qtdeCrianca) {
        this.qtdeCrianca = qtdeCrianca;
    }

    public Long getQtdePax() {
        return qtdePax;
    }

    public void setQtdePax(Long qtdePax) {
        this.qtdePax = qtdePax;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public String getTarifaManual() {
        return tarifaManual;
    }

    public void setTarifaManual(String tarifaManual) {
        this.tarifaManual = tarifaManual;
    }

    public Double getTotalTarifa() {
        return totalTarifa;
    }

    public void setTotalTarifa(Double totalTarifa) {
        this.totalTarifa = totalTarifa;
    }

    public Double getValorCafe() {
        return valorCafe;
    }

    public void setValorCafe(Double valorCafe) {
        this.valorCafe = valorCafe;
    }

    public Double getValorMap() {
        return valorMap;
    }

    public void setValorMap(Double valorMap) {
        this.valorMap = valorMap;
    }

    public Double getValorPensao() {
        return valorPensao;
    }

    public void setValorPensao(Double valorPensao) {
        this.valorPensao = valorPensao;
    }

    public List<ReservaApartamentoDiariaEJB> getReservaApartamentoDiariaEJBList() {
        return reservaApartamentoDiariaEJBList;
    }

    public void setReservaApartamentoDiariaEJBList(List<ReservaApartamentoDiariaEJB> reservaApartamentoDiariaEJBList) {
        this.reservaApartamentoDiariaEJBList = reservaApartamentoDiariaEJBList;
    }

    public ReservaApartamentoDiariaEJB addReservaApartamentoDiariaEJB(ReservaApartamentoDiariaEJB reservaApartamentoDiariaEJB) {
        getReservaApartamentoDiariaEJBList().add(reservaApartamentoDiariaEJB);
        reservaApartamentoDiariaEJB.setReservaApartamentoEJB(this);
        return reservaApartamentoDiariaEJB;
    }

    public ReservaApartamentoDiariaEJB removeReservaApartamentoDiariaEJB(ReservaApartamentoDiariaEJB reservaApartamentoDiariaEJB) {
        getReservaApartamentoDiariaEJBList().remove(reservaApartamentoDiariaEJB);
        reservaApartamentoDiariaEJB.setReservaApartamentoEJB(null);
        return reservaApartamentoDiariaEJB;
    }

    public ReservaEJB getReservaEJB() {
        return reservaEJB;
    }

    public void setReservaEJB(ReservaEJB reservaEJB) {
        this.reservaEJB = reservaEJB;
    }

    public void setRoomListEJBList(List<RoomListEJB> roomListEJBList) {
        this.roomListEJBList = roomListEJBList;
    }

    public List<RoomListEJB> getRoomListEJBList() {
        return roomListEJBList;
    }

    public void setConfirmada(String confirmada) {
        this.confirmada = confirmada;
    }

    public String getConfirmada() {
        return confirmada;
    }

    public void setApartamentoEJB(ApartamentoEJB apartamentoEJB) {
        this.apartamentoEJB = apartamentoEJB;
    }

    public ApartamentoEJB getApartamentoEJB() {
        return apartamentoEJB;
    }
}
