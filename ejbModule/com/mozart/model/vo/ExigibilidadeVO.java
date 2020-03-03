package com.mozart.model.vo;


public class ExigibilidadeVO extends MozartVO {

	private static final long serialVersionUID = 7540220476141649729L;

	private Long id;
	private String descricao;
	
	public ExigibilidadeVO() {
	}

	public ExigibilidadeVO(Object[] linha) {
		if (linha != null) {
				       
			setLinha(linha);
			id = getLong();
			descricao = getString();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
