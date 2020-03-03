package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MENSAGEM_WEB_USUARIO database table.
 * 
 */
@Embeddable
public class MensagemWebUsuarioEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_MENSAGEM")
	private Long idMensagem;

	@Column(name="ID_USUARIO")
	private Long idUsuario;

    public MensagemWebUsuarioEJBPK() {
    }

    public MensagemWebUsuarioEJBPK(Long idMensagem, Long idUsuario) {
    	this.idMensagem = idMensagem;
    	this.idUsuario = idUsuario;
    }
    
	public Long getIdMensagem() {
		return this.idMensagem;
	}
	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}
	public Long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MensagemWebUsuarioEJBPK)) {
			return false;
		}
		MensagemWebUsuarioEJBPK castOther = (MensagemWebUsuarioEJBPK)other;
		return 
			(this.idMensagem == castOther.idMensagem)
			&& (this.idUsuario == castOther.idUsuario);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idMensagem ^ (this.idMensagem >>> 32)));
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		
		return hash;
    }
}