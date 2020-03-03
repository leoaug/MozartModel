package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "AliquotaEJB.findByHotel", 
			hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), 
			query = "select o from AliquotaEJB o where o.idHotel = ?1 order by o.tipoAliquota"),
			@NamedQuery(name = "AliquotaEJB.findAll", 
			hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), 
			query = "select o from AliquotaEJB o order by o.idAliquotas")
})
@Table(name = "ALIQUOTAS")
public class AliquotaEJB extends MozartEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqAliquota")
	@SequenceGenerator(name = "idSeqAliquota", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_ALIQUOTAS")
	private Long idAliquotas;
	
	private String aliquota;

	private String descricao;

	@Column(name = "ID_HOTEL")
	private Long idHotel;

	@Column(name = "ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name = "TIPO_ALIQUOTA")
	private String tipoAliquota;

	public AliquotaEJB() {
	}

	public String getAliquota() {
		return this.aliquota;
	}

	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdAliquotas() {
		return this.idAliquotas;
	}

	public void setIdAliquotas(Long idAliquotas) {
		this.idAliquotas = idAliquotas;
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

	public String getTipoAliquota() {
		return this.tipoAliquota;
	}

	public void setTipoAliquota(String tipoAliquota) {
		this.tipoAliquota = tipoAliquota;
	}
}