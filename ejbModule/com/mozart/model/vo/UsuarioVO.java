package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class UsuarioVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8826471336259391452L;
	
	private FiltroWeb filtroAjax;
	
	private Long idUsuario;
	private Long idHotel;
	private String nomeUsuario;
	
	
	public UsuarioVO(){
		this.filtroAjax = new FiltroWeb();
		
	}
	
	public UsuarioVO(Object[] linha){
		
		if (linha != null){
			setLinha(linha);
			idUsuario = getLong();
			nomeUsuario = getString();
		}
		
	}
	
	public UsuarioVO(Long idUsuario, String nomeUsuario){
		
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		
	}
	public UsuarioVO(Long idUsuario, String nomeUsuario, Long idHotel){
		
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.idHotel = idHotel;
		
	}
	
	public boolean equals(Object obj){
		if (obj == null)
			return false;
		return idUsuario.equals( ((UsuarioVO)obj).getIdUsuario() );
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public FiltroWeb getFiltroAjax() {
		return filtroAjax;
	}

	public void setFiltroAjax(FiltroWeb filtroAjax) {
		this.filtroAjax = filtroAjax;
	}
}
