package com.mozart.model.ejb.entity;


public class CheckinEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7435635390158694388L;
	public Long idCheckin;
    public Long idHotel;

    public CheckinEJBPK() {
    }

    public CheckinEJBPK(Long idCheckin, Long idHotel) {
        this.idCheckin = idCheckin;
        this.idHotel = idHotel;
    }

    public boolean equals(Object other) {
        if (other instanceof CheckinEJBPK) {
            final CheckinEJBPK otherCheckinEJBPK = (CheckinEJBPK) other;
            final boolean areEqual = 
                (otherCheckinEJBPK.idCheckin.equals(idCheckin) && otherCheckinEJBPK.idHotel.equals(idHotel));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
