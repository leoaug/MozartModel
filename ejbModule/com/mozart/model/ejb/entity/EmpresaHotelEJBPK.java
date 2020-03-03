package com.mozart.model.ejb.entity;

@SuppressWarnings("serial")
public class EmpresaHotelEJBPK extends MozartEntity {

	public Long idEmpresa;
    public Long idHotel;

    public EmpresaHotelEJBPK() {
    }

    public EmpresaHotelEJBPK(Long idEmpresa, Long idHotel) {
        this.idEmpresa = idEmpresa;
        this.idHotel = idHotel;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaHotelEJBPK) {
            final EmpresaHotelEJBPK otherEmpresaHotelEJBPK = (EmpresaHotelEJBPK) other;
            final boolean areEqual = 
                (otherEmpresaHotelEJBPK.idEmpresa.equals(idEmpresa) && otherEmpresaHotelEJBPK.idHotel.equals(idHotel));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
