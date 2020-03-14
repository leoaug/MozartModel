package com.mozart.model.ejb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "ApiGeralEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select api from ApiGeralEJB api")
@Table(name = "API_GERAL")
public class ApiGeralEJB extends MozartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqApiGeral")
	@SequenceGenerator(name = "idSeqApiGeral", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_API_GERAL", nullable = false)
	private Long idApiGeral;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
	private EmpresaEJB empresa;
	
	private String token;
	
	private String url;
	
	private String nome;
	
	private String ativo;
	
	@Transient
	private String palavra;
	

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public Long getIdApiGeral() {
		return idApiGeral;
	}

	public void setIdApiGeral(Long idApiGeral) {
		this.idApiGeral = idApiGeral;
	}

	public EmpresaEJB getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEJB empresa) {
		this.empresa = empresa;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
	
	
}
