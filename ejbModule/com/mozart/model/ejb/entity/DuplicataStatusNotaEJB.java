package com.mozart.model.ejb.entity;

import javax.persistence.*;

@Entity
@Table(name="DUPLICATA_STATUS_NOTA")
public class DuplicataStatusNotaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DuplicataStatusNotaEJBPK id;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

    public DuplicataStatusNotaEJB() {
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

	public DuplicataStatusNotaEJBPK getId() {
		return id;
	}

	public void setId(DuplicataStatusNotaEJBPK id) {
		this.id = id;
	}
}