package com.mozart.model.ejb.entity;

public class StatusNotaEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3107816566526716262L;
	public Long idHotel;
    public Long idNota;

    public StatusNotaEJBPK() {
    }

    public StatusNotaEJBPK(Long idHotel, Long idNota) {
        this.idHotel = idHotel;
        this.idNota = idNota;
    }

    public boolean equals(Object other) {
        if (other instanceof StatusNotaEJBPK) {
            final StatusNotaEJBPK otherStatusNotaEJBPK = (StatusNotaEJBPK) other;
            final boolean areEqual = 
                (otherStatusNotaEJBPK.idHotel.equals(idHotel) && otherStatusNotaEJBPK.idNota.equals(idNota));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
