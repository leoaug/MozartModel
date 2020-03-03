package com.mozart.model.ejb.entity;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the USUARIO_PONTO_VENDA database table.
 * 
 */
@Entity
@Table(name="USUARIO_PONTO_VENDA")
public class UsuarioPontoVendaEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPontoVendaEJBPK id;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable=false, updatable=false),
    @JoinColumn(name = "ID_PONTO_VENDA", referencedColumnName = "ID_PONTO_VENDA", insertable=false, updatable=false)
    })
    private PontoVendaEJB pontoVendaEJB;

	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable=false, updatable=false)
    private UsuarioEJB usuarioEJB;
	
    public UsuarioPontoVendaEJB() {
    }

	public UsuarioPontoVendaEJBPK getId() {
		return this.id;
	}

	public void setId(UsuarioPontoVendaEJBPK id) {
		this.id = id;
	}
	
	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public PontoVendaEJB getPontoVendaEJB() {
		return pontoVendaEJB;
	}

	public void setPontoVendaEJB(PontoVendaEJB pontoVendaEJB) {
		this.pontoVendaEJB = pontoVendaEJB;
	}

	public UsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((usuarioEJB == null) ? 0 : usuarioEJB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioPontoVendaEJB other = (UsuarioPontoVendaEJB) obj;
		if (usuarioEJB == null) {
			if (other.getUsuarioEJB() != null)
				return false;
		} else if (!usuarioEJB.equals(other.getUsuarioEJB()))
			return false;
		return true;
	}

	
}