package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NOTICIA database table.
 * 
 */
@Embeddable
public class NoticiaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="NOTICIA_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTICIA_GENERATOR")
	@Column(name="ID_NOTICIA")
	private Long idNoticia;

	@Column(name="ID_IDIOMA")
	private Long idIdioma;

    public NoticiaPK() {
    }
	public Long getIdNoticia() {
		return this.idNoticia;
	}
	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}
	public Long getIdIdioma() {
		return this.idIdioma;
	}
	public void setIdIdioma(Long idIdioma) {
		this.idIdioma = idIdioma;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NoticiaPK)) {
			return false;
		}
		NoticiaPK castOther = (NoticiaPK)other;
		return 
			(this.idNoticia.equals(castOther.getIdNoticia()))
			&& (this.idIdioma.equals(castOther.getIdIdioma()));

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idNoticia ^ (this.idNoticia >>> 32)));
		hash = hash * prime + ((int) (this.idIdioma ^ (this.idIdioma >>> 32)));
		
		return hash;
    }
}