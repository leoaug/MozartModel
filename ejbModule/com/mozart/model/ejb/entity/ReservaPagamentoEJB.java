package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "ReservaPagamentoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from ReservaPagamentoEJB o")
@Table(name = "PAGAMENTO_RESERVA")
@IdClass(ReservaPagamentoEJBPK.class)
public class ReservaPagamentoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1630080254570699784L;
	@Column(nullable = false)
    private String confirma;
    @Column(name="DATA_CONFIRMA")
    private Timestamp dataConfirma;
    @Column(name="FORMA_PG", nullable = false)
    private String formaPg;
    @Column(name="ID_CARTAO_CREDITO")
    private Long idCartaoCredito;
    @Column(name="ID_CENTRAL_RESERVAS")
    private Long idCentralReservas;
    @Id
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqP")
    @SequenceGenerator(name="idSeqP", sequenceName="id", allocationSize=1)
    @Column(name="ID_PAGAMENTO_RESERVA", nullable = false)
    private Long idPagamentoReserva;
    @ManyToOne
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    private ReservaEJB reservaEJB;
    @Column(name="ID_TIPO_LANCAMENTO")
    private Long idTipoLancamento;
    @Column(name="NUM_DOCUMENTO")
    private String numDocumento;
    @Column(name="VALIDADE_CARTAO")
    private String validadeCartao;
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "ID_MOVIMENTO_APARTAMENTO", referencedColumnName = "ID_MOVIMENTO_APARTAMENTO")
    private MovimentoApartamentoEJB movimentoApartamentoEJB;

    public ReservaPagamentoEJB() {
    }

    public String getConfirma() {
        return confirma;
    }

    public void setConfirma(String confirma) {
        this.confirma = confirma;
    }

    public Timestamp getDataConfirma() {
        return dataConfirma;
    }

    public void setDataConfirma(Timestamp dataConfirma) {
        this.dataConfirma = dataConfirma;
    }

    public String getFormaPg() {
        return formaPg;
    }

    public void setFormaPg(String formaPg) {
        this.formaPg = formaPg;
    }

    public Long getIdCartaoCredito() {
        return idCartaoCredito;
    }

    public void setIdCartaoCredito(Long idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
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

    public Long getIdPagamentoReserva() {
        return idPagamentoReserva;
    }

    public void setIdPagamentoReserva(Long idPagamentoReserva) {
        this.idPagamentoReserva = idPagamentoReserva;
    }

    public Long getIdTipoLancamento() {
        return idTipoLancamento;
    }

    public void setIdTipoLancamento(Long idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setReservaEJB(ReservaEJB reservaEJB) {
        this.reservaEJB = reservaEJB;
    }

    public ReservaEJB getReservaEJB() {
        return reservaEJB;
    }

	public MovimentoApartamentoEJB getMovimentoApartamentoEJB() {
		return movimentoApartamentoEJB;
	}

	public void setMovimentoApartamentoEJB(
			MovimentoApartamentoEJB movimentoApartamentoEJB) {
		this.movimentoApartamentoEJB = movimentoApartamentoEJB;
	}
    
    
}
