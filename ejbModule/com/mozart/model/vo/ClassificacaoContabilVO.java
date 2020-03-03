package com.mozart.model.vo;

public class ClassificacaoContabilVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3370967101071031126L;
	
	
	
	private Long idClassificacaoContabil;
	private String descricao;
	private Long idPlanoContasFinanceiro;
	
	
	
	public ClassificacaoContabilVO(){
		
		
	}

	public ClassificacaoContabilVO(Object[] linha){
		if (linha != null){
			setLinha(linha);
			idClassificacaoContabil = getLong();
			descricao = getString();
			idPlanoContasFinanceiro = getLong();
		}
		
		
	}

	public Long getIdClassificacaoContabil() {
		return idClassificacaoContabil;
	}

	public void setIdClassificacaoContabil(Long idClassificacaoContabil) {
		this.idClassificacaoContabil = idClassificacaoContabil;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdPlanoContasFinanceiro() {
		return idPlanoContasFinanceiro;
	}

	public void setIdPlanoContasFinanceiro(Long idPlanoContasFinanceiro) {
		this.idPlanoContasFinanceiro = idPlanoContasFinanceiro;
	}
	

}
