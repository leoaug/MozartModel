package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ReservaMidiaEJB.findAll", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "SELECT O FROM ReservaMidiaEJB O order by O.dsReservaMidia") })
@Table(name = "RESERVA_MIDIA")
public class ReservaMidiaEJB extends MozartEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1814269543003137000L;

	@Id
	@Column(name = "ID_RESERVA_MIDIA")
	private Long idReservaMidia;

	@Column(name = "DESCRICAO_RESERVA_MIDIA")
	private String dsReservaMidia;

	@Column(name = "COD_RESERVA_MIDIA")
	private String codReservaMidia;

	public ReservaMidiaEJB() {
	}

	public Long getIdReservaMidia() {
		return idReservaMidia;
	}

	public void setIdReservaMidia(Long idReservaMidia) {
		this.idReservaMidia = idReservaMidia;
	}

	public String getDsReservaMidia() {
		return dsReservaMidia;
	}

	public void setDsReservaMidia(String dsReservaMidia) {
		this.dsReservaMidia = dsReservaMidia;
	}

	public String getCodReservaMidia() {
		return codReservaMidia;
	}

	public void setCodReservaMidia(String codReservaMidia) {
		this.codReservaMidia = codReservaMidia;
	}

}
