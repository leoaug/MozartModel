package com.mozart.model.ejb.entity;


import javax.persistence.*;

//COMBO BOX

/**
 * The persistent class for the INDICE_TIPO database table.
 * 
 */
@Entity
@NamedQueries({				
	@NamedQuery  (name = "IndiceTipoEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			    	    query = "select o from IndiceTipoEJB o where o.idRedeHotel=?1 order by o.nomeIndice")
			})
@Table(name="INDICE_TIPO")
public class IndiceTipoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INDICE_TIPO_IDINDICETIPO_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDICE_TIPO_IDINDICETIPO_GENERATOR")
	@Column(name="ID_INDICE_TIPO")
	private Long idIndiceTipo;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NOME_INDICE")
	private String nomeIndice;

    public IndiceTipoEJB() {
    }

	public Long getIdIndiceTipo() {
		return this.idIndiceTipo;
	}

	public void setIdIndiceTipo(Long idIndiceTipo) {
		this.idIndiceTipo = idIndiceTipo;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeIndice() {
		return this.nomeIndice;
	}

	public void setNomeIndice(String nomeIndice) {
		this.nomeIndice = nomeIndice;
	}

	
}