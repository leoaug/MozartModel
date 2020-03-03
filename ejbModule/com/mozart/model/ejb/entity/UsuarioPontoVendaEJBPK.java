package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIO_PONTO_VENDA database table.
 * 
 */
@Embeddable
public class UsuarioPontoVendaEJBPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column(name="ID_PONTO_VENDA")
	private long idPontoVenda;

    public UsuarioPontoVendaEJBPK() {
    }
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdPontoVenda() {
		return this.idPontoVenda;
	}
	public void setIdPontoVenda(long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPontoVendaEJBPK)) {
			return false;
		}
		UsuarioPontoVendaEJBPK castOther = (UsuarioPontoVendaEJBPK)other;
		return 
			(this.idUsuario == castOther.getIdUsuario())
			&& (this.idPontoVenda == castOther.getIdPontoVenda());

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.idPontoVenda ^ (this.idPontoVenda >>> 32)));
		
		return hash;
    }
}