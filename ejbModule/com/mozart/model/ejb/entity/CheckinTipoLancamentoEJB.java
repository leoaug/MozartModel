package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQuery(name = "CheckinTipoLancamentoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from CheckinTipoLancamentoEJB o")
@Table(name = "CHECKIN_TIPO_LANCAMENTO")
@IdClass(value=CheckinTipoLancamentoEJBPK.class)
public class CheckinTipoLancamentoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5651355965878539226L;
	@Id
    @Column(name="ID_TIPO_LANCAMENTO", nullable = false, insertable = false, updatable = false)
    private Long idTipoLancamento;
    @Id
    @Column(name="ID_CHECKIN", nullable = false, insertable = false, updatable = false)
    private Long idCheckin;
    @Id
    @Column(name="ID_HOTEL", nullable = false, insertable = false, updatable = false)
    private Long idHotel;
    
    @Column(nullable = false)
    private Double quantidade;
    @Column(name="VALOR_UNITARIO")
    private Double valorUnitario;
    @ManyToOne
    @JoinColumn(name = "ID_CHECKIN", referencedColumnName = "ID_CHECKIN")
    private CheckinEJB checkinEJB;

    @ManyToOne
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO")
    })
    private TipoLancamentoEJB tipoLancamentoEJB;


    public boolean equals(Object other) {
        if ( other == null)
            return false;
        if ( ((CheckinTipoLancamentoEJB) other).getTipoLancamentoEJB() == null)
            return false;
            
        if (other instanceof CheckinTipoLancamentoEJB) {
            final CheckinTipoLancamentoEJB checkinTipolancamentoEJB = (CheckinTipoLancamentoEJB) other;
            final boolean areEqual = 
                checkinTipolancamentoEJB.tipoLancamentoEJB.equals(tipoLancamentoEJB);
            return areEqual;
        }
        return false;
    }
    
    public CheckinTipoLancamentoEJB() {
    }


    public Long getIdTipoLancamento() {
        return idTipoLancamento;
    }

    public void setIdTipoLancamento(Long idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public CheckinEJB getCheckinEJB() {
        return checkinEJB;
    }

    public void setCheckinEJB(CheckinEJB checkinEJB) {
        this.checkinEJB = checkinEJB;
    }

    public void setIdCheckin(Long idCheckin) {
        this.idCheckin = idCheckin;
    }

    public Long getIdCheckin() {
        return idCheckin;
    }

    public void setTipoLancamentoEJB(TipoLancamentoEJB tipoLancamentoEJB) {
        this.tipoLancamentoEJB = tipoLancamentoEJB;
    }

    public TipoLancamentoEJB getTipoLancamentoEJB() {
        return tipoLancamentoEJB;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }
}
