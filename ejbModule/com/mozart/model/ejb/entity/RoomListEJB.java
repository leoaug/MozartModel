package com.mozart.model.ejb.entity;

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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RoomListEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from RoomListEJB o")
@Table(name = "ROOM_LIST")
public class RoomListEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5947176956835475466L;
	@Column(name="CHEGOU")
	private String chegou;
    @Column(name="COD_CERTIFICADO")
    private Long codCertificado;
    @Column(name="DATA_CERTIFICADO")
    private Timestamp dataCertificado;
    @Column(name="ID_CENTRAL_RESERVAS")
    private Long idCentralReservas;
    @ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_CHECKIN", referencedColumnName = "ID_CHECKIN")
    private CheckinEJB checkin;
    @OneToOne
    @JoinColumn(name = "ID_HOSPEDE", referencedColumnName = "ID_HOSPEDE")
    private HospedeEJB hospede;
    @Column(name="ID_REDE_HOTEL")
    private Long idRedeHotel;

    @Column(name="ID_HOTEL")
    private Long idHotel;

    
    @ManyToOne(cascade={CascadeType.REFRESH},optional=true)
    @JoinColumn(name = "ID_RESERVA_APARTAMENTO", referencedColumnName = "ID_RESERVA_APARTAMENTO")
    private ReservaApartamentoEJB reservaApartamentoEJB;
    
    @ManyToOne(cascade={CascadeType.REFRESH}, optional=true)
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    private ReservaEJB reservaEJB;
    
    @OneToMany(mappedBy = "roomListEJB", fetch=FetchType.LAZY, cascade = {CascadeType.REFRESH})
    private List<MovimentoApartamentoEJB> movimentoApartamentoEJBList;    
    
    @OneToMany(mappedBy = "roomListEJB", fetch=FetchType.EAGER, cascade = {CascadeType.REFRESH})
    private List<MovimentoObjetoEJB> movimentoObjetoEJBList;    
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqRL")
    @SequenceGenerator(name="idSeqRL", sequenceName="id", allocationSize=1)
    @Column(name="ID_ROOM_LIST", nullable = false)
    private Long idRoomList;
    //@Column(name="ID_TIPO_HOSPEDE")
    //private Long idTipoHospede;
    //@Column(name="ID_TIPO_LANCAMENTO")
    //private Long idTipoLancamento;
    private String principal;


    @Column(name="DATA_ENTRADA")
    private Timestamp dataEntrada;


    @Column(name="DATA_SAIDA")
    private Timestamp dataSaida;

    public RoomListEJB() {
        movimentoApartamentoEJBList = new ArrayList<MovimentoApartamentoEJB>();
        movimentoObjetoEJBList = new ArrayList<MovimentoObjetoEJB>();

   }

    public RoomListEJB(Long id) {
        this();
        idRoomList = id;
   }

    public boolean equals(Object obj){
    	
    	if (obj == null){
    		return false;
    	}
    	if (idRoomList == null){
    		return super.equals( obj );
    	}
    	
    	return idRoomList.equals( ((RoomListEJB)obj).getIdRoomList() );
    	
    }
    
    public String getChegou() {
        return chegou;
    }

    public void setChegou(String chegou) {
        this.chegou = chegou;
    }

    public Long getCodCertificado() {
        return codCertificado;
    }

    public void setCodCertificado(Long codCertificado) {
        this.codCertificado = codCertificado;
    }

    public Timestamp getDataCertificado() {
        return dataCertificado;
    }

    public void setDataCertificado(Timestamp dataCertificado) {
        this.dataCertificado = dataCertificado;
    }

    public Long getIdCentralReservas() {
        return idCentralReservas;
    }

    public void setIdCentralReservas(Long idCentralReservas) {
        this.idCentralReservas = idCentralReservas;
    }

    public Long getIdRedeHotel() {
        return idRedeHotel;
    }

    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }

    public Long getIdRoomList() {
        return idRoomList;
    }

    public void setIdRoomList(Long idRoomList) {
        this.idRoomList = idRoomList;
    }

  /*  public Long getIdTipoHospede() {
        return idTipoHospede;
    }

    public void setIdTipoHospede(Long idTipoHospede) {
        this.idTipoHospede = idTipoHospede;
    }

    public Long getIdTipoLancamento() {
        return idTipoLancamento;
    }

    public void setIdTipoLancamento(Long idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }
*/
    
    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void setReservaApartamentoEJB(ReservaApartamentoEJB reservaApartamentoEJB) {
        this.reservaApartamentoEJB = reservaApartamentoEJB;
    }

    public ReservaApartamentoEJB getReservaApartamentoEJB() {
        return reservaApartamentoEJB;
    }

    public void setHospede(HospedeEJB hospede) {
        this.hospede = hospede;
    }

    public HospedeEJB getHospede() {
        return hospede;
    }

    public void setCheckin(CheckinEJB checkin) {
        this.checkin = checkin;
    }

    public CheckinEJB getCheckin() {
        return checkin;
    }

    public void setReservaEJB(ReservaEJB reservaEJB) {
        this.reservaEJB = reservaEJB;
    }

    public ReservaEJB getReservaEJB() {
        return reservaEJB;
    }

    public void setMovimentoApartamentoEJBList(List<MovimentoApartamentoEJB> movimentoApartamentoEJBList) {
        this.movimentoApartamentoEJBList = movimentoApartamentoEJBList;
    }

    public void addMovimentoApartamentoEJBList(MovimentoApartamentoEJB movimentoApartamentoEJB) {
    	if (movimentoApartamentoEJBList == null){
    		movimentoApartamentoEJBList = new ArrayList<MovimentoApartamentoEJB>();
    	}
        movimentoApartamentoEJB.setRoomListEJB( this );
        this.movimentoApartamentoEJBList.add( movimentoApartamentoEJB );
    }

    public List<MovimentoApartamentoEJB> getMovimentoApartamentoEJBList() {
        return movimentoApartamentoEJBList;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setMovimentoObjetoEJBList(List<MovimentoObjetoEJB> movimentoObjetoEJBList) {
        this.movimentoObjetoEJBList = movimentoObjetoEJBList;
    }

    public List<MovimentoObjetoEJB> getMovimentoObjetoEJBList() {
        return movimentoObjetoEJBList;
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Timestamp getDataEntrada() {
        return dataEntrada;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Timestamp getDataSaida() {
        return dataSaida;
    }
}
