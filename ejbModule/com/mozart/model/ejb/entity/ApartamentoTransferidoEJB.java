package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "ApartamentoTransferidoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from ApartamentoTransferidoEJB o")
@Table(name = "APARTAMENTO_TRANSFERIDO")
@IdClass(ApartamentoTransferidoEJBPK.class)
public class ApartamentoTransferidoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3222504342476846237L;
	
	@Column(nullable = false)
    private Timestamp data;
    @Column(nullable = false)
    private Timestamp hora;
    @Column(name="ID_APARTAMENTO_DESTINO", nullable = false)
    private Long idApartamentoDestino;
    @Column(name="ID_APARTAMENTO_ORIGEM", nullable = false)
    private Long idApartamentoOrigem;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqApto")
    @SequenceGenerator(name="idSeqApto", sequenceName="id", allocationSize=1)
    @Column(name="ID_APARTAMENTO_TRANSFERIDO", nullable = false)
    private Long idApartamentoTransferido;
    @Column(name="ID_CHECKIN", nullable = false)
    private Long idCheckin;
    @Id
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Column(nullable = false)
    private String motivo;
    @Column(name="TIPO_TRANSFERENCIA")
    private String tipoTransferencia;
    @Column(name="VALOR_LANCAMENTO")
    private Double valorLancamento;

    public ApartamentoTransferidoEJB() {
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public Long getIdApartamentoDestino() {
        return idApartamentoDestino;
    }

    public void setIdApartamentoDestino(Long idApartamentoDestino) {
        this.idApartamentoDestino = idApartamentoDestino;
    }

    public Long getIdApartamentoOrigem() {
        return idApartamentoOrigem;
    }

    public void setIdApartamentoOrigem(Long idApartamentoOrigem) {
        this.idApartamentoOrigem = idApartamentoOrigem;
    }

    public Long getIdApartamentoTransferido() {
        return idApartamentoTransferido;
    }

    public void setIdApartamentoTransferido(Long idApartamentoTransferido) {
        this.idApartamentoTransferido = idApartamentoTransferido;
    }

    public Long getIdCheckin() {
        return idCheckin;
    }

    public void setIdCheckin(Long idCheckin) {
        this.idCheckin = idCheckin;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public Double getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(Double valorLancamento) {
        this.valorLancamento = valorLancamento;
    }
}
