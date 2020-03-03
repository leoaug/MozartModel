package com.mozart.model.ejb.entity;


public class EmpresaGrupoLancamentoEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7013162211199461272L;
	public Long idEmpresa;
    public Long idHotel;
    public Long idIdentificaLancamento;

    public EmpresaGrupoLancamentoEJBPK() {
    }

    public EmpresaGrupoLancamentoEJBPK(Long idEmpresa, Long idHotel, Long idIdentificaLancamento) {this.idEmpresa = idEmpresa;
        this.idHotel = idHotel;
        this.idIdentificaLancamento = idIdentificaLancamento;
    }

    public boolean equals(Object other) {
        if (other instanceof EmpresaGrupoLancamentoEJBPK) {
            final EmpresaGrupoLancamentoEJBPK otherEmpresaGrupoLancamentoEJBPK = (EmpresaGrupoLancamentoEJBPK) other;
            final boolean areEqual = 
                (otherEmpresaGrupoLancamentoEJBPK.idEmpresa.equals(idEmpresa) && otherEmpresaGrupoLancamentoEJBPK.idHotel.equals(idHotel) && otherEmpresaGrupoLancamentoEJBPK.idIdentificaLancamento.equals(idIdentificaLancamento));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
