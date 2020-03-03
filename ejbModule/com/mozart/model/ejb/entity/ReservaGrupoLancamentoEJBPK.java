package com.mozart.model.ejb.entity;

public class ReservaGrupoLancamentoEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -567826602228585840L;
	public Long idIdentificaLancamento;
    public Long idReserva;

    public ReservaGrupoLancamentoEJBPK() {
    }

    public ReservaGrupoLancamentoEJBPK(Long idIdentificaLancamento, Long idReserva) {this.idIdentificaLancamento = idIdentificaLancamento;
        this.idReserva = idReserva;
    }

    public boolean equals(Object other) {
        if (other instanceof ReservaGrupoLancamentoEJBPK) {
            final ReservaGrupoLancamentoEJBPK otherReservaGrupoLancamentoEJBPK = (ReservaGrupoLancamentoEJBPK) other;
            final boolean areEqual = 
                (otherReservaGrupoLancamentoEJBPK.idIdentificaLancamento.equals(idIdentificaLancamento) && otherReservaGrupoLancamentoEJBPK.idReserva.equals(idReserva));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
