package com.mozart.model.ejb.entity;

public class CheckinTipoLancamentoEJBPK extends MozartEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7845290520973885615L;	public Long idCheckin;
	public Long idTipoLancamento;
	public Long idHotel;
	
	public CheckinTipoLancamentoEJBPK(){
		
	}
	
	public CheckinTipoLancamentoEJBPK(Long idCheckin, Long idTipoLancamento,
			Long idHotel) {
		this.idCheckin = idCheckin;
		this.idTipoLancamento = idTipoLancamento;
		this.idHotel = idHotel;
	}

	public boolean equals(Object other) {
		if ((other instanceof CheckinTipoLancamentoEJBPK)) {
			CheckinTipoLancamentoEJBPK checkinTipolancamentoEJBPK = (CheckinTipoLancamentoEJBPK) other;
			boolean areEqual = (checkinTipolancamentoEJBPK.idCheckin
					.equals(this.idCheckin))
					&& (checkinTipolancamentoEJBPK.idTipoLancamento
							.equals(this.idTipoLancamento))
					&& (checkinTipolancamentoEJBPK.idHotel.equals(this.idHotel));
			return areEqual;
		}
		return false;
	}

	public int hashCode() {
		return super.hashCode();
	}
}