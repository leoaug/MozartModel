package com.mozart.model.vo;


public class RegimeTributarioVO extends MozartVO {

	private static final long serialVersionUID = 7540220476141649729L;

	private Long id;
	private String regime;
	
	public RegimeTributarioVO() {
	}

	public RegimeTributarioVO(Object[] linha) {
		if (linha != null) {
				       
			setLinha(linha);
			id = getLong();
			regime = getString();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	
}
