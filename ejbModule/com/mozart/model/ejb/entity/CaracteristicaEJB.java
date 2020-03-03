package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the CARACTERISTICAS database table.
 * 
 */
@NamedQueries({
	@NamedQuery(name = "CaracteristicaEJB.findByHotel", 
			hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	        query = "select o from CaracteristicaEJB o where o.tipoCaracteristica in ('E','F') order by o.tipoCaracteristica, o.descCaracteristica"),

	@NamedQuery(name = "CaracteristicaEJB.findByTipoApartamento", 
	    		hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    	    query = "select o from CaracteristicaEJB o where o.tipoCaracteristica in ('Q','C','B') order by o.tipoCaracteristica desc, o.descCaracteristica"),
	        
	        
})

@Entity
@Table(name="CARACTERISTICAS")
public class CaracteristicaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARACTERISTICAS_IDCARACTERISTICA_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARACTERISTICAS_IDCARACTERISTICA_GENERATOR")
	@Column(name="ID_CARACTERISTICA")
	private long idCaracteristica;

	@Column(name="DESC_CARACTERISTICA")
	private String descCaracteristica;

	private String link;

	@Column(name="TIPO_CARACTERISTICA")
	private String tipoCaracteristica;

    public CaracteristicaEJB() {
    }

	public long getIdCaracteristica() {
		return this.idCaracteristica;
	}

	public void setIdCaracteristica(long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public String getDescCaracteristica() {
		return this.descCaracteristica;
	}

	public void setDescCaracteristica(String descCaracteristica) {
		this.descCaracteristica = descCaracteristica;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTipoCaracteristica() {
		return this.tipoCaracteristica;
	}

	public void setTipoCaracteristica(String tipoCaracteristica) {
		this.tipoCaracteristica = tipoCaracteristica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idCaracteristica ^ (idCaracteristica >>> 32));
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
		CaracteristicaEJB other = (CaracteristicaEJB) obj;
		if (idCaracteristica != other.idCaracteristica)
			return false;
		return true;
	}

}