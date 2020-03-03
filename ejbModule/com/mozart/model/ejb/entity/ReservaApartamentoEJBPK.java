package com.mozart.model.ejb.entity;


public class ReservaApartamentoEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5301506300302720331L;
	public Long idHotel;
    public Long idReservaApartamento;

    public ReservaApartamentoEJBPK() {
    }

    public ReservaApartamentoEJBPK(Long idHotel, Long idReservaApartamento) {
        this.idHotel = idHotel;
        this.idReservaApartamento = idReservaApartamento;
    }

    public boolean equals(Object other) {
        if (other instanceof ReservaApartamentoEJBPK) {
            final ReservaApartamentoEJBPK otherReservaApartamentoEJBPK = (ReservaApartamentoEJBPK) other;
            final boolean areEqual = 
                (otherReservaApartamentoEJBPK.idHotel.equals(idHotel) && otherReservaApartamentoEJBPK.idReservaApartamento.equals(idReservaApartamento));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
