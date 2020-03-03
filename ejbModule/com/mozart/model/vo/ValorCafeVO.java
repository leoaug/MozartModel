package com.mozart.model.vo;

import java.util.Date;
import com.mozart.model.vo.filtro.FiltroWeb;

public class ValorCafeVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	
	private FiltroWeb filtroData;
	
	
	
	private Long idValorCafe;
	private Date data;
	private Double valorCafe;
	private String tipoPensao;
		
		
	public ValorCafeVO(){
		
		filtroData = new FiltroWeb();
						
	}	
	
	public ValorCafeVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idValorCafe = getLong();
			data = getDate();
			valorCafe = getDouble();
			tipoPensao = getString();
								
		}
		
	}

	public FiltroWeb getFiltroData() {
		return filtroData;
	}

	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getIdValorCafe() {
		return idValorCafe;
	}

	public void setIdValorCafe(Long idValorCafe) {
		this.idValorCafe = idValorCafe;
	}

	public Double getValorCafe() {
		return valorCafe;
	}

	public void setValorCafe(Double valorCafe) {
		this.valorCafe = valorCafe;
	}

	public String getTipoPensao() {
		return tipoPensao;
	}

	public void setTipoPensao(String tipoPensao) {
		this.tipoPensao = tipoPensao;
	}

	

}
