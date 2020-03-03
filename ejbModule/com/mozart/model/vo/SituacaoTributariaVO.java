package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class SituacaoTributariaVO extends MozartVO {

	private static final long serialVersionUID = -5368866542928980201L;

	private FiltroWeb filtroSubcodigoOuDescricao;
	
	private Long idSituacaoTributaria;
	private String descricao;
	
	public SituacaoTributariaVO() {
		filtroSubcodigoOuDescricao = new FiltroWeb();
	}	
	
	public SituacaoTributariaVO(Object[] filtro ) {
		if (filtro != null){
			setLinha(filtro);
			
			idSituacaoTributaria = getLong();
			descricao = getString();
		}
	}

	public Long getIdSituacaoTributaria() {
		return idSituacaoTributaria;
	}

	public void setIdSituacaoTributaria(Long idSituacaoTributaria) {
		this.idSituacaoTributaria = idSituacaoTributaria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FiltroWeb getFiltroSubcodigoOuDescricao() {
		return filtroSubcodigoOuDescricao;
	}

	public void setFiltroSubcodigoOuDescricao(FiltroWeb filtroSubcodigoOuDescricao) {
		this.filtroSubcodigoOuDescricao = filtroSubcodigoOuDescricao;
	}
}