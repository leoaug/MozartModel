package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the GRUPO_ECONOMICO database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="GRUPO_ECONOMICO")
public class GrupoEconomicoEJB extends MozartEntity {
	

	@Id
	@SequenceGenerator(name="GRUPO_ECONOMICO_IDGRUPOECONOMICO_GENERATOR", sequenceName="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPO_ECONOMICO_IDGRUPOECONOMICO_GENERATOR")
	@Column(name="ID_GRUPO_ECONOMICO")
	private Long idGrupoEconomico;

	@Column(name="HOTEL_EMPRESA")
	private String hotelEmpresa;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NOME_GRUPO")
	private String nomeGrupo;

    public GrupoEconomicoEJB() {
    }

	public String getHotelEmpresa() {
		return this.hotelEmpresa;
	}

	public void setHotelEmpresa(String hotelEmpresa) {
		this.hotelEmpresa = hotelEmpresa;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public Long getIdGrupoEconomico() {
		return idGrupoEconomico;
	}

	public void setIdGrupoEconomico(Long idGrupoEconomico) {
		this.idGrupoEconomico = idGrupoEconomico;
	}

}