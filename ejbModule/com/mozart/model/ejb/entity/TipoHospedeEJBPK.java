package com.mozart.model.ejb.entity;

public class TipoHospedeEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2490864553837729576L;
	public Long idRedeHotel;
    public Long idTipoHospede;

    public TipoHospedeEJBPK() {
    }

    public TipoHospedeEJBPK(Long idRedeHotel, Long idTipoHospede) {
        this.idRedeHotel = idRedeHotel;
        this.idTipoHospede = idTipoHospede;
    }

    public boolean equals(Object other) {
        if (other instanceof TipoHospedeEJBPK) {
            final TipoHospedeEJBPK otherTipoHospedeEJBPK = (TipoHospedeEJBPK) other;
            final boolean areEqual = 
                (otherTipoHospedeEJBPK.idRedeHotel.equals(idRedeHotel) && otherTipoHospedeEJBPK.idTipoHospede.equals(idTipoHospede));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
