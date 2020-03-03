package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The primary key class for the TIPO_EMPRESA database table.
 * 
 */
@Embeddable
public class TipoEmpresaEJBPK extends MozartEntity {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_TIPO_EMPRESA")
	private long idTipoEmpresa;

	@Column(name="ID_REDE_HOTEL")
	private long idRedeHotel;

    public TipoEmpresaEJBPK() {
    }
	public long getIdTipoEmpresa() {
		return this.idTipoEmpresa;
	}
	public void setIdTipoEmpresa(long idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}
	public long getIdRedeHotel() {
		return this.idRedeHotel;
	}
	public void setIdRedeHotel(long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TipoEmpresaEJBPK)) {
			return false;
		}
		TipoEmpresaEJBPK castOther = (TipoEmpresaEJBPK)other;
		return 
			(this.idTipoEmpresa == castOther.idTipoEmpresa)
			&& (this.idRedeHotel == castOther.idRedeHotel);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idTipoEmpresa ^ (this.idTipoEmpresa >>> 32)));
		hash = hash * prime + ((int) (this.idRedeHotel ^ (this.idRedeHotel >>> 32)));
		
		return hash;
    }
}