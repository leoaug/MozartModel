package com.mozart.model.vo;


public class UnidadeNfeVO extends MozartVO {

	private static final long serialVersionUID = -5368866542928980201L;
	
	private Long idUnidadeNfe;
	private String descricao;
	
	public UnidadeNfeVO() {
	}	
	
	public UnidadeNfeVO(Object[] filtro ) {
		if (filtro != null){
			setLinha(filtro);
			
			idUnidadeNfe = getLong();
			descricao = getString();
		}
	}

	public Long getIdUnidadeNfe() {
		return idUnidadeNfe;
	}

	public void setIdUnidadeNfe(Long idUnidadeNfe) {
		this.idUnidadeNfe = idUnidadeNfe;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}