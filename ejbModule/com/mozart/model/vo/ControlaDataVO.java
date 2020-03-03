package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ControlaDataVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroIdHotel;
	

	private Long idHotel;
	
	
	
	public ControlaDataVO(){
		
		filtroIdHotel = new FiltroWeb();
			
		
		
	}	
	
	public ControlaDataVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
			
			idHotel = getLong();
			
			
		}
	}

	public FiltroWeb getFiltroIdHotel() {
		return filtroIdHotel;
	}

	public void setFiltroIdHotel(FiltroWeb filtroIdHotel) {
		this.filtroIdHotel = filtroIdHotel;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	

		
}