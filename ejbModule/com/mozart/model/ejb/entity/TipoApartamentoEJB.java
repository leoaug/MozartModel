package com.mozart.model.ejb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQueries({
		@NamedQuery(name = "TipoApartamentoEJB.findAll", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "select o from TipoApartamentoEJB o where o.idHotel = ?1 order by o.tipoApartamento"),
		@NamedQuery(name = "TipoApartamentoEJB.findByFantasia", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "select o from TipoApartamentoEJB o where o.idHotel = ?1 and o.fantasia = ?2 order by o.tipoApartamento")
})
@Table(name = "TIPO_APARTAMENTO")
public class TipoApartamentoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "DESCRICAO_APARTAMENTO")
	private String descricaoApartamento;
	@Column(nullable = false)
	private String fantasia;
	@Column(name = "ID_HOTEL", nullable = false)
	private Long idHotel;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqTipoApto")
	@SequenceGenerator(name = "idSeqTipoApto", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_TIPO_APARTAMENTO", nullable = false)
	private Long idTipoApartamento;
	@Column(name = "QTDE_PESSOA")
	private Long qtdePessoa;
	@Column(name = "TIPO_APARTAMENTO", nullable = false)
	private String tipoApartamento;
	@Transient
	private List<CaracteristicaEJB> caracteristicaList;

	public TipoApartamentoEJB() {
	}

	public TipoApartamentoEJB(Long idTipoApartamento) {
		this.idTipoApartamento = idTipoApartamento;
	}

	public String getDescricaoApartamento() {
		return this.descricaoApartamento;
	}

	public void setDescricaoApartamento(String descricaoApartamento) {
		this.descricaoApartamento = descricaoApartamento;
	}

	public String getFantasia() {
		return this.fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdTipoApartamento() {
		return this.idTipoApartamento;
	}

	public void setIdTipoApartamento(Long idTipoApartamento) {
		this.idTipoApartamento = idTipoApartamento;
	}

	public Long getQtdePessoa() {
		return this.qtdePessoa;
	}

	public void setQtdePessoa(Long qtdePessoa) {
		this.qtdePessoa = qtdePessoa;
	}

	public String getTipoApartamento() {
		return this.tipoApartamento;
	}

	public void setTipoApartamento(String tipoApartamento) {
		this.tipoApartamento = tipoApartamento;
	}

	public List<CaracteristicaEJB> getCaracteristicaList() {
		return this.caracteristicaList;
	}

	public void setCaracteristicaList(List<CaracteristicaEJB> caracteristicaList) {
		this.caracteristicaList = caracteristicaList;
	}
}