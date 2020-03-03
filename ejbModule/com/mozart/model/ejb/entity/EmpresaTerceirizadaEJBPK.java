package com.mozart.model.ejb.entity;

public class EmpresaTerceirizadaEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9221874659985164023L;
	public Long idEmpresa;
    public Long idHotel;

    public EmpresaTerceirizadaEJBPK() {
    }

    public EmpresaTerceirizadaEJBPK(Long idEmpresa, Long idHotel) {
        this.idEmpresa = idEmpresa;
        this.idHotel = idHotel;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaTerceirizadaEJBPK) {
            final EmpresaTerceirizadaEJBPK otherEmpresaTerceirizadaEJBPK = (EmpresaTerceirizadaEJBPK) other;
            final boolean areEqual = 
                (otherEmpresaTerceirizadaEJBPK.idEmpresa.equals(idEmpresa) && otherEmpresaTerceirizadaEJBPK.idHotel.equals(idHotel));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
