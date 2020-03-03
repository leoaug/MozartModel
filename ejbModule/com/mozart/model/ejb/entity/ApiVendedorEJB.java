package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "ApiVendedorEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select api from ApiVendedorEJB api")
@Table(name = "API_Vendedor")
public class ApiVendedorEJB extends MozartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqApiVendedor")
	@SequenceGenerator(name = "idSeqApiVendedor", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_API_Vendedor", nullable = false)
	private Long idApiVendedor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_API_GERAL", referencedColumnName = "ID_API_GERAL")
	private ApiGeralEJB apiGeral;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;

	
	private String nome;
	
	private String ativo;

	public Long getIdApiVendedor() {
		return idApiVendedor;
	}

	public void setIdApiVendedor(Long idApiVendedor) {
		this.idApiVendedor = idApiVendedor;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public ApiGeralEJB getApiGeral() {
		return apiGeral;
	}

	public void setApiGeral(ApiGeralEJB apiGeral) {
		this.apiGeral = apiGeral;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}
	
	
	
}
