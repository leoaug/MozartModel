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
@NamedQuery(name = "ApiContratoEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select api from ApiContratoEJB api")
@Table(name = "API_Contrato")
public class ApiContratoEJB extends MozartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqApiContrato")
	@SequenceGenerator(name = "idSeqApiContrato", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_API_Contrato", nullable = false)
	private Long idApiContrato;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_API_GERAL", referencedColumnName = "ID_API_GERAL")
	private ApiGeralEJB apiGeral;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO")
	private TipoLancamentoEJB tipoLancamento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO")
	private TipoLancamentoEJB tipoLancamentoCk;
	
	private String nome;
	
	private String ativo;

	public Long getIdApiContrato() {
		return idApiContrato;
	}

	public void setIdApiContrato(Long idApiContrato) {
		this.idApiContrato = idApiContrato;
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

	public TipoLancamentoEJB getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamentoEJB tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public TipoLancamentoEJB getTipoLancamentoCk() {
		return tipoLancamentoCk;
	}

	public void setTipoLancamentoCk(TipoLancamentoEJB tipoLancamentoCk) {
		this.tipoLancamentoCk = tipoLancamentoCk;
	}
	
	
	
}
