package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the CAMAREIRA database table.
 * 
 */
@Entity
@Table(name="CAMAREIRA")
public class CamareiraEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	private String ativo;

	@Column(name="COD_CENTRAL_ADVISER")
	private String codCentralAdviser;
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="SEQ_CAMAREIRA")
    @SequenceGenerator(name="SEQ_CAMAREIRA", sequenceName="id", allocationSize=1)
	@Column(name="ID_CAMAREIRA")
	private Long idCamareira;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_USUARIO")
	private Long idUsuario;

	@Column(name="NOME_CAMAREIRA")
	private String nomeCamareira;

    public CamareiraEJB() {
    }

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getCodCentralAdviser() {
		return this.codCentralAdviser;
	}

	public void setCodCentralAdviser(String codCentralAdviser) {
		this.codCentralAdviser = codCentralAdviser;
	}

	public Long getIdCamareira() {
		return this.idCamareira;
	}

	public void setIdCamareira(Long idCamareira) {
		this.idCamareira = idCamareira;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeCamareira() {
		return this.nomeCamareira;
	}

	public void setNomeCamareira(String nomeCamareira) {
		this.nomeCamareira = nomeCamareira;
	}

}