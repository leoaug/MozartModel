package com.mozart.model.vo;


import com.mozart.model.vo.filtro.FiltroWeb;

public class TipoEmpresaVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	
	private FiltroWeb filtroTipoEmpresa;
	
	
	
	private Long idTipoEmpresa;
	private String tipoEmpresa;
	private Double crs;
	private Long idHotel;
	
		
		
	public TipoEmpresaVO(){
		
		filtroTipoEmpresa = new FiltroWeb();
						
	}	
	
	public TipoEmpresaVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idTipoEmpresa = getLong();
			tipoEmpresa = getString();
			crs	= getDouble();
			
								
		}
		
	}

	public FiltroWeb getFiltroTipoEmpresa() {
		return filtroTipoEmpresa;
	}

	public void setFiltroTipoEmpresa(FiltroWeb filtroTipoEmpresa) {
		this.filtroTipoEmpresa = filtroTipoEmpresa;
	}

	public Long getIdTipoEmpresa() {
		return idTipoEmpresa;
	}

	public void setIdTipoEmpresa(Long idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public Double getCrs() {
		return crs;
	}

	public void setCrs(Double crs) {
		this.crs = crs;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

		

}
