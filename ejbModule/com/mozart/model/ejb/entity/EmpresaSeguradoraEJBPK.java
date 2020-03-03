package com.mozart.model.ejb.entity;


public class EmpresaSeguradoraEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600672271885399779L;
    public Long idHotelSegurado;
    public Long idSeguradora;

    public EmpresaSeguradoraEJBPK() {
    }

    public EmpresaSeguradoraEJBPK(Long idHotelSegurado, Long idSeguradora) {

        this.idHotelSegurado = idHotelSegurado;
        this.idSeguradora = idSeguradora;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaSeguradoraEJBPK) {
            final EmpresaSeguradoraEJBPK otherEmpresaSeguradoraEJBPK = (EmpresaSeguradoraEJBPK) other;
            final boolean areEqual = 
                otherEmpresaSeguradoraEJBPK.idHotelSegurado.equals(idHotelSegurado) && otherEmpresaSeguradoraEJBPK.idSeguradora.equals(idSeguradora);
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
