package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "API_VENDEDOR")
@NamedQueries({
	@NamedQuery(name = "ApiVendedorEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiVendedorEJB a"),
	@NamedQuery(name = "ApiVendedorEJB.findById", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiVendedorEJB a where a.idApiVendedor = :idApiVendedor "),
	@NamedQuery(name = "ApiVendedorEJB.listByIdApiGeral", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiVendedorEJB a where a.apiGeralEJB.idApiGeral = :idApiGeral "),
	@NamedQuery(name = "ApiVendedorEJB.listByIdApiGeralAndIdHotel", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiVendedorEJB a where a.apiGeralEJB.idApiGeral = :idApiGeral and a.hotelEjb.idHotel = :idHotel "),
	@NamedQuery(name = "ApiVendedorEJB.listByIdHotel", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiVendedorEJB a where a.hotelEjb.idHotel = :idHotel ")
})
public class ApiVendedorEJB extends MozartEntity {
	
	
	
	@Id
	@SequenceGenerator(name="API_VENDEDOR_IDAPIVENDEDOR_GENERATOR", sequenceName="ID", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="API_VENDEDOR_IDAPIVENDEDOR_GENERATOR")
	@Column(name = "ID_API_VENDEDOR")
	private Long idApiVendedor;
	
	@Column(name = "API_NOME")
	private String apiNome;
	
	@Column(name="ATIVO")
	private String ativo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_API_GERAL", referencedColumnName = "ID_API_GERAL")
	private ApiGeralEJB apiGeralEJB;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
	private HotelEJB hotelEjb;

	public Long getIdApiVendedor() {
		return idApiVendedor;
	}

	public void setIdApiVendedor(Long idApiVendedor) {
		this.idApiVendedor = idApiVendedor;
	}

	public String getApiNome() {
		return apiNome;
	}

	public void setApiNome(String apiNome) {
		this.apiNome = apiNome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public ApiGeralEJB getApiGeralEJB() {
		return apiGeralEJB;
	}

	public void setApiGeralEJB(ApiGeralEJB apiGeralEJB) {
		this.apiGeralEJB = apiGeralEJB;
	}

	public HotelEJB getHotelEjb() {
		return hotelEjb;
	}

	public void setHotelEjb(HotelEJB hotelEjb) {
		this.hotelEjb = hotelEjb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiGeralEJB == null) ? 0 : apiGeralEJB.hashCode());
		result = prime * result + ((apiNome == null) ? 0 : apiNome.hashCode());
		result = prime * result + ((hotelEjb == null) ? 0 : hotelEjb.hashCode());
		result = prime * result + ((idApiVendedor == null) ? 0 : idApiVendedor.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
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
		ApiVendedorEJB other = (ApiVendedorEJB) obj;
		if (apiGeralEJB == null) {
			if (other.apiGeralEJB != null)
				return false;
		} else if (!apiGeralEJB.equals(other.apiGeralEJB))
			return false;
		if (apiNome == null) {
			if (other.apiNome != null)
				return false;
		} else if (!apiNome.equals(other.apiNome))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (hotelEjb == null) {
			if (other.hotelEjb != null)
				return false;
		} else if (!hotelEjb.equals(other.hotelEjb))
			return false;
		if (idApiVendedor == null) {
			if (other.idApiVendedor != null)
				return false;
		} else if (!idApiVendedor.equals(other.idApiVendedor))
			return false;
		return true;
	}
	
	
	
	
	
}
