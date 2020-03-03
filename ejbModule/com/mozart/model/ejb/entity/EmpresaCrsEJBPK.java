package com.mozart.model.ejb.entity;


public class EmpresaCrsEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1764883631533874749L;
	public Long idCrs;
    public Long idEmpresa;

    public EmpresaCrsEJBPK() {
    }

    public EmpresaCrsEJBPK(Long idCrs, Long idEmpresa) {
        this.idCrs = idCrs;
        this.idEmpresa = idEmpresa;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaCrsEJBPK) {
            final EmpresaCrsEJBPK otherEmpresaCrsEJBPK = (EmpresaCrsEJBPK) other;
            final boolean areEqual = 
                (otherEmpresaCrsEJBPK.idCrs.equals(idCrs) && otherEmpresaCrsEJBPK.idEmpresa.equals(idEmpresa));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
