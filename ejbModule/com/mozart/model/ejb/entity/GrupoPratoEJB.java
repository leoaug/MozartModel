package com.mozart.model.ejb.entity;

import javax.persistence.*;



/**
 * The persistent class for the GRUPO_PRATO database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoPratoEJB.findByHotel", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    	    query = "select o from GrupoPratoEJB o where o.idHotel=?1 order by o.nomeGrupoPrato")
	})
@Table(name="GRUPO_PRATO")
public class GrupoPratoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRUPO_PRATO_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPO_PRATO_GENERATOR")
	@Column(name="ID_GRUPO_PRATO")
	private Long idGrupoPrato;
	
	
	@Column(name="ID_HOTEL")
	private Long idHotel;

	
	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NOME_GRUPO_PRATO")
	private String nomeGrupoPrato;

    public GrupoPratoEJB() {
    }

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeGrupoPrato() {
		return this.nomeGrupoPrato;
	}

	public void setNomeGrupoPrato(String nomeGrupoPrato) {
		this.nomeGrupoPrato = nomeGrupoPrato;
	}

	public Long getIdGrupoPrato() {
		return idGrupoPrato;
	}

	public void setIdGrupoPrato(Long idGrupoPrato) {
		this.idGrupoPrato = idGrupoPrato;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

}