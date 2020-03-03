package com.mozart.model.ejb.entity;


public class TipoApartamentoEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8101448084930191437L;
	public Long idHotel;
    public Long idTipoApartamento;

    public TipoApartamentoEJBPK() {
    }

    public TipoApartamentoEJBPK(Long idHotel, Long idTipoApartamento) {
        this.idHotel = idHotel;
        this.idTipoApartamento = idTipoApartamento;
    }

    public boolean equals(Object other) {
        if (other instanceof TipoApartamentoEJBPK) {
            final TipoApartamentoEJBPK otherTipoApartamentoEJBPK = (TipoApartamentoEJBPK) other;
            final boolean areEqual = 
                (otherTipoApartamentoEJBPK.idHotel.equals(idHotel) && otherTipoApartamentoEJBPK.idTipoApartamento.equals(idTipoApartamento));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
