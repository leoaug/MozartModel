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
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "ReservaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from ReservaEJB o")
@Table(name = "RESERVA")
public class ReservaEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7563663106429137014L;
	private String alterando;
    private String apagada;
    @Column(nullable = false)
    private String bloqueio;
    @Column(name="CALCULA_ISS", nullable = false)
    private String calculaIss;
    @Column(name="CALCULA_ROOMTAX", nullable = false)
    private String calculaRoomtax;
    @Column(name="CALCULA_SEGURO")
    private String calculaSeguro;
    @Column(name="CALCULA_TAXA", nullable = false)
    private String calculaTaxa;
    @Column(nullable = false)
    private String checkin;
    private Double comissao;
    @Column(nullable = false)
    private String confirma;
    @Column(nullable = false)
    private String contato;
    @Column(nullable = false)
    private String cortesia;
    @Column(name="DATA_CONFIRMA_BLOQUEIO")
    private Timestamp dataConfirmaBloqueio;
    @Column(name="DATA_ENTRADA", nullable = false)
    private Timestamp dataEntrada;
    @Column(name="DATA_RESERVA", nullable = false)
    private Timestamp dataReserva;
    @Column(name="DATA_SAIDA", nullable = false)
    private Timestamp dataSaida;
    @Column(name="DEAD_LINE")
    private Long deadLine;
    @Column(name="EMAIL_CONTATO")
    private String emailContato;
    @Column(name="FAX_CONTATO")
    private String faxContato;
    private String fidelidade;
    @Column(name="FLG_ALCOOLICA")
    private String flgAlcoolica;
    @Column(name="FORMA_PG")
    private String formaPg;
    @Column(name="FORMA_RESERVA")
    private String formaReserva;
    private String garantenoshow;
    @Column(nullable = false)
    private String grupo;
    @Column(name="HORA_RESERVA", nullable = false)
    private Timestamp horaReserva;
    @Column(name="ID_CENTRAL_RESERVAS")
    private Long idCentralReservas;
    @Column(name="ID_CIDADE_CONTATO", nullable = false)
    private Long idCidadeContato;
    @Column(name="ID_CORPORATE")
    private Long idCorporate;
    @Column(name="ID_EMPRESA", nullable = false)
    private Long idEmpresa;
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Column(name="ID_PERMUTA")
    private Long idPermuta;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqR")
    @SequenceGenerator(name="idSeqR", sequenceName="id", allocationSize=1)
    @Column(name="ID_RESERVA", nullable = false)
    private Long idReserva;
    @Column(name="ID_RESERVA_MIDIA")
    private Long idReservaMidia;
    @Column(name="ID_USUARIO_WEB")
    private Long idUsuarioWeb;
    @Column(name="NOME_GRUPO")
    private String nomeGrupo;
    private String observacao;
    private String permuta;
    @Column(name="RESERVA_JAVA")
    private String reservaJava;
    @Column(name="TELEFONE_CONTATO", nullable = false)
    private String telefoneContato;
    @Column(name="TIPO_PENSAO")
    private String tipoPensao;
    @Column(name="VALOR_PENSAO")
    private Double valorPensao;
    @Column(name="VALOR_TOTAL")
    private Double valorTotal;
    @ManyToOne
    @JoinColumn(name = "ID_RESERVA_BLOQUEIO", referencedColumnName = "ID_RESERVA")
    private ReservaEJB reservaEJB;
    @OneToMany(mappedBy = "reservaEJB")
    private List<ReservaEJB> reservaEJBList;
    @OneToMany(mappedBy = "reservaEJB", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<ReservaApartamentoEJB> reservaApartamentoEJBList;
    @OneToMany(mappedBy = "reservaEJB", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<ReservaGrupoLancamentoEJB> reservaGrupoLancamentoEJBList;
    @OneToMany(mappedBy = "reservaEJB", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<ReservaPagamentoEJB> reservaPagamentoEJBList;



    public ReservaEJB() {
        reservaApartamentoEJBList = new ArrayList<ReservaApartamentoEJB>();
        reservaGrupoLancamentoEJBList = new ArrayList<ReservaGrupoLancamentoEJB>();
        reservaPagamentoEJBList = new ArrayList<ReservaPagamentoEJB>();
    }

    public String getAlterando() {
        return alterando;
    }

    public void setAlterando(String alterando) {
        this.alterando = alterando;
    }

    public String getApagada() {
        return apagada;
    }

    public void setApagada(String apagada) {
        this.apagada = apagada;
    }

    public String getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(String bloqueio) {
        this.bloqueio = bloqueio;
    }

    public String getCalculaIss() {
        return calculaIss;
    }

    public void setCalculaIss(String calculaIss) {
        this.calculaIss = calculaIss;
    }

    public String getCalculaRoomtax() {
        return calculaRoomtax;
    }

    public void setCalculaRoomtax(String calculaRoomtax) {
        this.calculaRoomtax = calculaRoomtax;
    }

    public String getCalculaSeguro() {
        return calculaSeguro;
    }

    public void setCalculaSeguro(String calculaSeguro) {
        this.calculaSeguro = calculaSeguro;
    }

    public String getCalculaTaxa() {
        return calculaTaxa;
    }

    public void setCalculaTaxa(String calculaTaxa) {
        this.calculaTaxa = calculaTaxa;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public String getConfirma() {
        return confirma;
    }

    public void setConfirma(String confirma) {
        this.confirma = confirma;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCortesia() {
        return cortesia;
    }

    public void setCortesia(String cortesia) {
        this.cortesia = cortesia;
    }

    public Timestamp getDataConfirmaBloqueio() {
        return dataConfirmaBloqueio;
    }

    public void setDataConfirmaBloqueio(Timestamp dataConfirmaBloqueio) {
        this.dataConfirmaBloqueio = dataConfirmaBloqueio;
    }

    public Timestamp getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Timestamp getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Timestamp dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Timestamp getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Long getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Long deadLine) {
        this.deadLine = deadLine;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getFaxContato() {
        return faxContato;
    }

    public void setFaxContato(String faxContato) {
        this.faxContato = faxContato;
    }

    public String getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(String fidelidade) {
        this.fidelidade = fidelidade;
    }

    public String getFlgAlcoolica() {
        return flgAlcoolica;
    }

    public void setFlgAlcoolica(String flgAlcoolica) {
        this.flgAlcoolica = flgAlcoolica;
    }

    public String getFormaPg() {
        return formaPg;
    }

    public void setFormaPg(String formaPg) {
        this.formaPg = formaPg;
    }

    public String getFormaReserva() {
        return formaReserva;
    }

    public void setFormaReserva(String formaReserva) {
        this.formaReserva = formaReserva;
    }

    public String getGarantenoshow() {
        return garantenoshow;
    }

    public void setGarantenoshow(String garantenoshow) {
        this.garantenoshow = garantenoshow;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Timestamp getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Timestamp horaReserva) {
        this.horaReserva = horaReserva;
    }

    public Long getIdCentralReservas() {
        return idCentralReservas;
    }

    public void setIdCentralReservas(Long idCentralReservas) {
        this.idCentralReservas = idCentralReservas;
    }

    public Long getIdCidadeContato() {
        return idCidadeContato;
    }

    public void setIdCidadeContato(Long idCidadeContato) {
        this.idCidadeContato = idCidadeContato;
    }

    public Long getIdCorporate() {
        return idCorporate;
    }

    public void setIdCorporate(Long idCorporate) {
        this.idCorporate = idCorporate;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdPermuta() {
        return idPermuta;
    }

    public void setIdPermuta(Long idPermuta) {
        this.idPermuta = idPermuta;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }


    public Long getIdReservaMidia() {
        return idReservaMidia;
    }

    public void setIdReservaMidia(Long idReservaMidia) {
        this.idReservaMidia = idReservaMidia;
    }

    public Long getIdUsuarioWeb() {
        return idUsuarioWeb;
    }

    public void setIdUsuarioWeb(Long idUsuarioWeb) {
        this.idUsuarioWeb = idUsuarioWeb;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPermuta() {
        return permuta;
    }

    public void setPermuta(String permuta) {
        this.permuta = permuta;
    }

    public String getReservaJava() {
        return reservaJava;
    }

    public void setReservaJava(String reservaJava) {
        this.reservaJava = reservaJava;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getTipoPensao() {
        return tipoPensao;
    }

    public void setTipoPensao(String tipoPensao) {
        this.tipoPensao = tipoPensao;
    }

    public Double getValorPensao() {
        return valorPensao;
    }

    public void setValorPensao(Double valorPensao) {
        this.valorPensao = valorPensao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ReservaEJB getReservaEJB() {
        return reservaEJB;
    }

    public void setReservaEJB(ReservaEJB reservaEJB) {
        this.reservaEJB = reservaEJB;
    }

    public List<ReservaEJB> getReservaEJBList() {
        return reservaEJBList;
    }

    public void setReservaEJBList(List<ReservaEJB> reservaEJBList) {
        this.reservaEJBList = reservaEJBList;
    }

    public ReservaEJB addReservaEJB(ReservaEJB reservaEJB) {
        getReservaEJBList().add(reservaEJB);
        reservaEJB.setReservaEJB(this);
        return reservaEJB;
    }

    public ReservaEJB removeReservaEJB(ReservaEJB reservaEJB) {
        getReservaEJBList().remove(reservaEJB);
        reservaEJB.setReservaEJB(null);
        return reservaEJB;
    }

    public List<ReservaApartamentoEJB> getReservaApartamentoEJBList() {
        return reservaApartamentoEJBList;
    }

    public void setReservaApartamentoEJBList(List<ReservaApartamentoEJB> reservaApartamentoEJBList) {
        this.reservaApartamentoEJBList = reservaApartamentoEJBList;
    }

    public ReservaApartamentoEJB addReservaApartamentoEJB(ReservaApartamentoEJB reservaApartamentoEJB) {
        getReservaApartamentoEJBList().add(reservaApartamentoEJB);
        reservaApartamentoEJB.setReservaEJB(this);
        return reservaApartamentoEJB;
    }

    public ReservaApartamentoEJB removeReservaApartamentoEJB(ReservaApartamentoEJB reservaApartamentoEJB) {
        getReservaApartamentoEJBList().remove(reservaApartamentoEJB);
        reservaApartamentoEJB.setReservaEJB(null);
        return reservaApartamentoEJB;
    }

    public void setReservaGrupoLancamentoEJBList(List<ReservaGrupoLancamentoEJB> reservaGrupoLancamentoEJBList) {
        this.reservaGrupoLancamentoEJBList = reservaGrupoLancamentoEJBList;
    }

    public List<ReservaGrupoLancamentoEJB> getReservaGrupoLancamentoEJBList() {
        return reservaGrupoLancamentoEJBList;
    }
    
    public ReservaGrupoLancamentoEJB addReservaGrupoLancamentoEJB(ReservaGrupoLancamentoEJB reservaGrupoLancamentoEJB) {
        getReservaGrupoLancamentoEJBList().add(reservaGrupoLancamentoEJB);
        reservaGrupoLancamentoEJB.setReservaEJB(this);
        return reservaGrupoLancamentoEJB;
    }
    
    public ReservaPagamentoEJB addReservaPagamentoEJB(ReservaPagamentoEJB reservaPagamentoEJB) {
        getReservaPagamentoEJBList().add(reservaPagamentoEJB);
        reservaPagamentoEJB.setReservaEJB(this);
        return reservaPagamentoEJB;
    }

    public void setReservaPagamentoEJBList(List<ReservaPagamentoEJB> reservaPagamentoEJBList) {
        this.reservaPagamentoEJBList = reservaPagamentoEJBList;
    }

    public List<ReservaPagamentoEJB> getReservaPagamentoEJBList() {
        return reservaPagamentoEJBList;
    }
}
