package com.mozart.model.ejb.entity;

import java.io.Serializable;

public class MozartEntity implements Serializable{

	private static final long serialVersionUID = 8095450932311645964L;
	
	protected UsuarioEJB usuario;

	public UsuarioEJB getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEJB usuario) {
		this.usuario = usuario;
	}
}
