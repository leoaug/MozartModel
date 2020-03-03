package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class PatrimonioSetorVO extends MozartVO {

	private static final long serialVersionUID = 3923882262894290855L;

	private FiltroWeb filtroNomeOuNomeReduzido;
	
	private Long idPatrimonioSetor;
	private String descricao; 
	
	public PatrimonioSetorVO(){
		filtroNomeOuNomeReduzido = new FiltroWeb();
	}
	
	public PatrimonioSetorVO (Object[] filtro ) {
		if (filtro != null){
			setLinha(filtro);
		
			idPatrimonioSetor = getLong();
			descricao = getString();
		}
	}

	public FiltroWeb getFiltroNomeOuNomeReduzido() {
		return filtroNomeOuNomeReduzido;
	}

	public void setFiltroNomeOuNomeReduzido(FiltroWeb filtroNomeOuNomeReduzido) {
		this.filtroNomeOuNomeReduzido = filtroNomeOuNomeReduzido;
	}

	public Long getIdPatrimonioSetor() {
		return idPatrimonioSetor;
	}

	public void setIdPatrimonioSetor(Long idPatrimonioSetor) {
		this.idPatrimonioSetor = idPatrimonioSetor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}