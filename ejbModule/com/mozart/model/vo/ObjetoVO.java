package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ObjetoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -909211619842681672L;
	
	private FiltroWeb filtroFantasia;
	
	
	private Long idObjeto;
	private String fantasia;
	private String descricao;
	private Double valor;
	
	public ObjetoVO(){
		filtroFantasia = new FiltroWeb(); 
	}

	public ObjetoVO(Object[] linha){
		if (linha != null){
			setLinha(linha);
			idObjeto = getLong();
			fantasia = getString();
			descricao = getString();
			valor = getDouble();
		}
	}

	public FiltroWeb getFiltroFantasia() {
		return filtroFantasia;
	}

	public void setFiltroFantasia(FiltroWeb filtroFantasia) {
		this.filtroFantasia = filtroFantasia;
	}

	public Long getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(Long idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
