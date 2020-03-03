package com.mozart.model.ejb.entity;


public class ApartamentoTransferidoEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3379284013544157842L;
	public Long idApartamentoTransferido;
    public Long idHotel;

    public ApartamentoTransferidoEJBPK() {
    }

    public ApartamentoTransferidoEJBPK(Long idApartamentoTransferido, Long idHotel) {this.idApartamentoTransferido = idApartamentoTransferido;
        this.idHotel = idHotel;
    }

    public boolean equals(Object other) {
        if (other instanceof ApartamentoTransferidoEJBPK) {
            final ApartamentoTransferidoEJBPK otherApartamentoTransferidoEJBPK = (ApartamentoTransferidoEJBPK) other;
            final boolean areEqual = 
                (otherApartamentoTransferidoEJBPK.idApartamentoTransferido.equals(idApartamentoTransferido) && otherApartamentoTransferidoEJBPK.idHotel.equals(idHotel));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
