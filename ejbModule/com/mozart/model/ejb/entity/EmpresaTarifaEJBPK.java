package com.mozart.model.ejb.entity;



public class EmpresaTarifaEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5403878634403221787L;
	public Long idEmpresa;
    public Long idHotel;
    public Long idTarifa;

    public EmpresaTarifaEJBPK() {
    }

    public EmpresaTarifaEJBPK(Long idEmpresa, Long idHotel, Long idTarifa) {
        this.idEmpresa = idEmpresa;
        this.idHotel = idHotel;
        this.idTarifa = idTarifa;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaTarifaEJBPK) {
            final EmpresaTarifaEJBPK otherEmpresaTarifaEJBPK = (EmpresaTarifaEJBPK) other;
            final boolean areEqual = 
                (otherEmpresaTarifaEJBPK.idEmpresa.equals(idEmpresa) && otherEmpresaTarifaEJBPK.idHotel.equals(idHotel) && otherEmpresaTarifaEJBPK.idTarifa.equals(idTarifa));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
