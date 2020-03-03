package com.mozart.model.ejb.entity;


public class CheckinGrupoLancamentoEJBPK extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7189001508015132787L;
	public Long idCheckin;
    public Long idHotel;
    public Long idIdentificaLancamento;

    public CheckinGrupoLancamentoEJBPK() {
    }

    public CheckinGrupoLancamentoEJBPK(Long idCheckin, Long idHotel, Long idIdentificaLancamento) {this.idCheckin = idCheckin;
        this.idHotel = idHotel;
        this.idIdentificaLancamento = idIdentificaLancamento;
    }

    public boolean equals(Object other) {
        if (other instanceof CheckinGrupoLancamentoEJBPK) {
            final CheckinGrupoLancamentoEJBPK otherCheckinGrupoLancamentoEJBPK = (CheckinGrupoLancamentoEJBPK) other;
            final boolean areEqual = 
                (otherCheckinGrupoLancamentoEJBPK.idCheckin.equals(idCheckin) && otherCheckinGrupoLancamentoEJBPK.idHotel.equals(idHotel) && otherCheckinGrupoLancamentoEJBPK.idIdentificaLancamento.equals(idIdentificaLancamento));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
