package com.mozart.model.vo;

import java.util.Date;
import com.mozart.model.vo.filtro.FiltroWeb;

public class ValorDolarVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	
	private FiltroWeb filtroData;
	
	
	
	
	private Long idMoeda;
	private Date data;
	private Double valorDolar;
	private String simbolo;
	private String nomeMoeda;
	
		
	public ValorDolarVO(){
		
		filtroData = new FiltroWeb();
						
	}	
	
	public ValorDolarVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idMoeda = getLong();
			data = getDate();
			valorDolar = getDouble();
			simbolo = getString();
			nomeMoeda = getString();
					
		}
		
	}

	public FiltroWeb getFiltroData() {
		return filtroData;
	}

	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}

	public Long getIdMoeda() {
		return idMoeda;
	}

	public void setIdMoeda(Long idMoeda) {
		this.idMoeda = idMoeda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorDolar() {
		return valorDolar;
	}

	public void setValorDolar(Double valorDolar) {
		this.valorDolar = valorDolar;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getNomeMoeda() {
		return nomeMoeda;
	}

	public void setNomeMoeda(String nomeMoeda) {
		this.nomeMoeda = nomeMoeda;
	}

	
	
	

}
