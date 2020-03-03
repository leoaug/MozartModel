package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ProfissaoVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8761297418932541530L;
	
	
	private FiltroWeb filtroProfissao;
	
	private Long idProfissao;
	private String profissao;

	public ProfissaoVO(){
		
		
	}
	
	public ProfissaoVO(Object[] linha){
		setLinha( linha );
		idProfissao = getLong();
		profissao = getString();
	}

	public FiltroWeb getFiltroProfissao() {
		return filtroProfissao;
	}

	public void setFiltroProfissao(FiltroWeb filtroProfissao) {
		this.filtroProfissao = filtroProfissao;
	}

	public Long getIdProfissao() {
		return idProfissao;
	}

	public void setIdProfissao(Long idProfissao) {
		this.idProfissao = idProfissao;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
}
