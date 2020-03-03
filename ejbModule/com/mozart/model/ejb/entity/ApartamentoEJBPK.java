package com.mozart.model.ejb.entity;


public class ApartamentoEJBPK extends MozartEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = -621842832751723592L;
	public Long idApartamento;
    public Long idHotel;

    public ApartamentoEJBPK() {
    }

    public ApartamentoEJBPK(Long idApartamento, Long idHotel) {
        this.idApartamento = idApartamento;
        this.idHotel = idHotel;
    }

    public boolean equals(Object other) {
        if (other instanceof ApartamentoEJBPK) {
            final ApartamentoEJBPK otherApartamentoEJBPK = (ApartamentoEJBPK) other;
            final boolean areEqual = 
                (otherApartamentoEJBPK.idApartamento.equals(idApartamento) && otherApartamentoEJBPK.idHotel.equals(idHotel));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
