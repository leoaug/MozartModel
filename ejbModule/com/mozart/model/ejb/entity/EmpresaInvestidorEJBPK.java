package com.mozart.model.ejb.entity;


public class EmpresaInvestidorEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2411040615516174598L;
	public Long idApartamento;
    public Long idEmpresa;

    public EmpresaInvestidorEJBPK() {
    }

    public EmpresaInvestidorEJBPK(Long idApartamento, Long idEmpresa) {
        this.idApartamento = idApartamento;
        this.idEmpresa = idEmpresa;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaInvestidorEJBPK) {
            final EmpresaInvestidorEJBPK otherEmpresaInvestidorEJBPK = (EmpresaInvestidorEJBPK) other;
            final boolean areEqual = 
                (otherEmpresaInvestidorEJBPK.idApartamento.equals(idApartamento) && otherEmpresaInvestidorEJBPK.idEmpresa.equals(idEmpresa));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
