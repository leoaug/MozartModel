package com.mozart.model.ejb.entity;

public class TipoLancamentoEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2696634401091936476L;
	public Long idHotel;
    public Long idTipoLancamento;

    public TipoLancamentoEJBPK() {
    }

    public TipoLancamentoEJBPK(Long idHotel, Long idTipoLancamento) {
        this.idHotel = idHotel;
        this.idTipoLancamento = idTipoLancamento;
    }

    public boolean equals(Object other) {
        if (other instanceof TipoLancamentoEJBPK) {
            final TipoLancamentoEJBPK otherTipoLancamentoEJBPK = (TipoLancamentoEJBPK) other;
            final boolean areEqual = 
                (otherTipoLancamentoEJBPK.idHotel.equals(idHotel) && otherTipoLancamentoEJBPK.idTipoLancamento.equals(idTipoLancamento));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
