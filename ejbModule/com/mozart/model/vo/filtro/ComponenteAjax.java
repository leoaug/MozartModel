package com.mozart.model.vo.filtro;

import java.io.Serializable;

public class ComponenteAjax implements Serializable {

	private static final long serialVersionUID = 7630035263287453961L;
	
	private String idElemento;
	private String idElementoOculto;
	private String queryUsuario;
	private Object queryResultado;
	
	public String getIdElementoOculto() {
		return idElementoOculto;
	}
	public void setIdElementoOculto(String idElementoOculto) {
		this.idElementoOculto = idElementoOculto;
	}
	public String getQueryUsuario() {
		return queryUsuario;
	}
	public void setQueryUsuario(String queryUsuario) {
		this.queryUsuario = queryUsuario.trim().toUpperCase();
	}
	public String getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(String idElemento) {
		this.idElemento = idElemento;
	}
	public Object getQueryResultado() {
		return queryResultado;
	}
	public void setQueryResultado(Object queryResultado) {
		this.queryResultado = queryResultado;
	}
}