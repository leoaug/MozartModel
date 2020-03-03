package com.mozart.model.ejb.entity;


public class ReservaPagamentoEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3656331635650033399L;
	public Long idHotel;
    public Long idPagamentoReserva;

    public ReservaPagamentoEJBPK() {
    }

    public ReservaPagamentoEJBPK(Long idHotel, Long idPagamentoReserva) {
        this.idHotel = idHotel;
        this.idPagamentoReserva = idPagamentoReserva;
    }

    public boolean equals(Object other) {
        if (other instanceof ReservaPagamentoEJBPK) {
            final ReservaPagamentoEJBPK otherReservaPagamentoEJBPK = (ReservaPagamentoEJBPK) other;
            final boolean areEqual = 
                (otherReservaPagamentoEJBPK.idHotel.equals(idHotel) && otherReservaPagamentoEJBPK.idPagamentoReserva.equals(idPagamentoReserva));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
