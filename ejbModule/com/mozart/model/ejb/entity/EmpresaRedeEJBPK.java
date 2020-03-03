package com.mozart.model.ejb.entity;


public class EmpresaRedeEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8603566803817814199L;
	public Long idEmpresa;
    public Long idRedeHotel;

    public EmpresaRedeEJBPK() {
    }

    public EmpresaRedeEJBPK(Long idEmpresa, Long idRedeHotel) {
        this.idEmpresa = idEmpresa;
        this.idRedeHotel = idRedeHotel;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaRedeEJBPK) {
            final EmpresaRedeEJBPK otherEmpresaRedeEJBPK = (EmpresaRedeEJBPK) other;
            final boolean areEqual = 
                (otherEmpresaRedeEJBPK.idEmpresa.equals(idEmpresa) && otherEmpresaRedeEJBPK.idRedeHotel.equals(idRedeHotel));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
