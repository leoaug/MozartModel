package com.mozart.model.ejb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "API_CONTRATO")
@NamedQueries({
		@NamedQuery(name = "ApiContratoEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiContratoEJB a"),
		@NamedQuery(name = "ApiContratoEJB.findById", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiContratoEJB a where a.idApiContrato = :idApiContrato"),
		@NamedQuery(name = "ApiContratoEJB.listByIdApiGeral", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiContratoEJB a where a.apiGeralEJB.idApiGeral = :idApiGeral"),
		@NamedQuery(name = "ApiContratoEJB.listByIdApiGeralAndIdHotel", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiContratoEJB a where a.apiGeralEJB.idApiGeral = :idApiGeral and a.hotelEjb.idHotel = :idHotel"),
		@NamedQuery(name = "ApiContratoEJB.listByIdHotel", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select a from ApiContratoEJB a where a.hotelEjb.idHotel = :idHotel"),

})
public class ApiContratoEJB extends MozartEntity {

	@Id
	@SequenceGenerator(name = "API_CONTRATO_IDAPICONTRATO_GENERATOR", sequenceName = "ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "API_CONTRATO_IDAPICONTRATO_GENERATOR")
	@Column(name = "ID_API_CONTRATO")
	private Long idApiContrato;

	@Column(name = "API_NOME")
	private String apiNome;

	@Column(name = "ATIVO")
	private String ativo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_API_GERAL", referencedColumnName = "ID_API_GERAL")
	private ApiGeralEJB apiGeralEJB;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
	private HotelEJB hotelEjb;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumns({
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO") })
	private TipoLancamentoEJB tipoLancamentoEJB;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumns({
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_TIPO_LANCAMENTO_CK", referencedColumnName = "ID_TIPO_LANCAMENTO") })
	private TipoLancamentoEJB tipoLancamentoCkEJB;

	public Long getIdApiContrato() {
		return idApiContrato;
	}

	public void setIdApiContrato(Long idApiContrato) {
		this.idApiContrato = idApiContrato;
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

	public TipoLancamentoEJB getTipoLancamentoEJB() {
		return tipoLancamentoEJB;
	}

	public void setTipoLancamentoEJB(TipoLancamentoEJB tipoLancamentoEJB) {
		this.tipoLancamentoEJB = tipoLancamentoEJB;
	}

	public TipoLancamentoEJB getTipoLancamentoCkEJB() {
		return tipoLancamentoCkEJB;
	}

	public void setTipoLancamentoCkEJB(TipoLancamentoEJB tipoLancamentoCkEJB) {
		this.tipoLancamentoCkEJB = tipoLancamentoCkEJB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiGeralEJB == null) ? 0 : apiGeralEJB.hashCode());
		result = prime * result + ((apiNome == null) ? 0 : apiNome.hashCode());
		result = prime * result + ((hotelEjb == null) ? 0 : hotelEjb.hashCode());
		result = prime * result + ((idApiContrato == null) ? 0 : idApiContrato.hashCode());
		result = prime * result + ((tipoLancamentoCkEJB == null) ? 0 : tipoLancamentoCkEJB.hashCode());
		result = prime * result + ((tipoLancamentoEJB == null) ? 0 : tipoLancamentoEJB.hashCode());
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
		ApiContratoEJB other = (ApiContratoEJB) obj;
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
		if (idApiContrato == null) {
			if (other.idApiContrato != null)
				return false;
		} else if (!idApiContrato.equals(other.idApiContrato))
			return false;
		if (tipoLancamentoCkEJB == null) {
			if (other.tipoLancamentoCkEJB != null)
				return false;
		} else if (!tipoLancamentoCkEJB.equals(other.tipoLancamentoCkEJB))
			return false;
		if (tipoLancamentoEJB == null) {
			if (other.tipoLancamentoEJB != null)
				return false;
		} else if (!tipoLancamentoEJB.equals(other.tipoLancamentoEJB))
			return false;
		return true;
	}

}
