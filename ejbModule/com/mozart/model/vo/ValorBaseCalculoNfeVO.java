package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ValorBaseCalculoNfeVO extends MozartVO {

	private static final long serialVersionUID = -5368866542928980201L;

	private FiltroWeb filtroSubcodigoOuDescricao;
	
	private Double valorBaseCalculo;
	private Double aliquota;
	private Double valorIcms;
	
	public ValorBaseCalculoNfeVO() {
		filtroSubcodigoOuDescricao = new FiltroWeb();
	}	
	
	public ValorBaseCalculoNfeVO(Object[] filtro ) {
		if (filtro != null){
			setLinha(filtro);
			
			valorBaseCalculo = getDouble();
			aliquota = getDouble();
			valorIcms = getDouble();
		}
	}
	
	public Double getValorBaseCalculo() {
		return valorBaseCalculo;
	}

	public void setValorBaseCalculo(Double valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
	}

	public Double getAliquota() {
		return aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}

	public Double getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(Double valorIcms) {
		this.valorIcms = valorIcms;
	}

	public FiltroWeb getFiltroSubcodigoOuDescricao() {
		return filtroSubcodigoOuDescricao;
	}

	public void setFiltroSubcodigoOuDescricao(FiltroWeb filtroSubcodigoOuDescricao) {
		this.filtroSubcodigoOuDescricao = filtroSubcodigoOuDescricao;
	}
}