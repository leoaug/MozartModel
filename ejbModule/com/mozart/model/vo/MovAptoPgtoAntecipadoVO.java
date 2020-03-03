package com.mozart.model.vo;

public class MovAptoPgtoAntecipadoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5404316218003885989L;
	
	private Long idMovimentoApartamento;
	private Long idCheckin;
	private Long idApartamento;

	private String numDocumento;

	public MovAptoPgtoAntecipadoVO() {
		
	}
	
	public MovAptoPgtoAntecipadoVO(Object[] linha){
		setLinha(linha);
		idMovimentoApartamento = getLong();
		idCheckin = getLong();
		numDocumento = getString();
		idApartamento = getLong();
	}

	public Long getIdMovimentoApartamento() {
		return idMovimentoApartamento;
	}

	public void setIdMovimentoApartamento(Long idMovimentoApartamento) {
		this.idMovimentoApartamento = idMovimentoApartamento;
	}

	public Long getIdCheckin() {
		return idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public Long getIdApartamento() {
		return idApartamento;
	}

	public void setIdApartamento(Long idApartamento) {
		this.idApartamento = idApartamento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	
	

}
