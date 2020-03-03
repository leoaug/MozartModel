package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "ReservaGrupoLancamentoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from ReservaGrupoLancamentoEJB o")
@Table(name = "RESERVA_GRUPO_LANCAMENTO")
@IdClass(ReservaGrupoLancamentoEJBPK.class)
public class ReservaGrupoLancamentoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2082609683261938618L;
	@Column(name="ID_CENTRAL_RESERVAS")
    private Long idCentralReservas;
    @Column(name="ID_EMPRESA")
    private Long idEmpresa;
    @Column(name="ID_HOTEL")
    private Long idHotel;
    @Id
    @Column(name="ID_IDENTIFICA_LANCAMENTO", nullable = false)
    private Long idIdentificaLancamento;
    @Id
    @Column(name="ID_RESERVA", nullable = false, insertable=false, updatable=false)
    private Long idReserva;
    @Column(name="QUEM_PAGA")
    private String quemPaga;
    
    @ManyToOne
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    private ReservaEJB reservaEJB;

    public ReservaGrupoLancamentoEJB() {
    }

    public Long getIdCentralReservas() {
        return idCentralReservas;
    }

    public void setIdCentralReservas(Long idCentralReservas) {
        this.idCentralReservas = idCentralReservas;
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

    public Long getIdIdentificaLancamento() {
        return idIdentificaLancamento;
    }

    public void setIdIdentificaLancamento(Long idIdentificaLancamento) {
        this.idIdentificaLancamento = idIdentificaLancamento;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getQuemPaga() {
        return quemPaga;
    }

    public void setQuemPaga(String quemPaga) {
        this.quemPaga = quemPaga;
    }

    public void setReservaEJB(ReservaEJB reservaEJB) {
        this.reservaEJB = reservaEJB;
    }

    public ReservaEJB getReservaEJB() {
        return reservaEJB;
    }
}
