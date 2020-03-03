package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class CentroCustoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroControlado;
	
	

	private Long idDepartamento;
	private Long idCentroCusto;
	private String descricaoCentroCusto;
	private String descricaoDp;
	private String controlado;
		
	
	public CentroCustoVO(){
		
		filtroControlado = new FiltroWeb();
				
		
		
	}	
	
	public CentroCustoVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idDepartamento = getLong();
			idCentroCusto = getLong();
			descricaoCentroCusto = getString();
			descricaoDp = getString();
			controlado = getString();
			
		
		}
		
	}

	public FiltroWeb getFiltroControlado() {
		return filtroControlado;
	}

	public void setFiltroControlado(FiltroWeb filtroControlado) {
		this.filtroControlado = filtroControlado;
	}

	public String getDescricaoCentroCusto() {
		return descricaoCentroCusto;
	}

	public void setDescricaoCentroCusto(String descricaoCentroCusto) {
		this.descricaoCentroCusto = descricaoCentroCusto;
	}

	public String getDescricaoDp() {
		return descricaoDp;
	}

	public void setDescricaoDp(String descricaoDp) {
		this.descricaoDp = descricaoDp;
	}

	public String getControlado() {
		return controlado;
	}

	public void setControlado(String controlado) {
		this.controlado = controlado;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Long getIdCentroCusto() {
		return idCentroCusto;
	}

	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	
}
