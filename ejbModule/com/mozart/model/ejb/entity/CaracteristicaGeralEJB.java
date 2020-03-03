package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the CARACTERISTICAS_GERAIS database table.
 * 
 */
@Entity
@Table(name="CARACTERISTICAS_GERAIS")
public class CaracteristicaGeralEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARACTERISTICAS_GERAIS_IDCARACTERISTICASGERAIS_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARACTERISTICAS_GERAIS_IDCARACTERISTICASGERAIS_GENERATOR")
	@Column(name="ID_CARACTERISTICAS_GERAIS")
	private Long idCaracteristicasGerais;

	@Column(name="ANO_CONSTRUCAO")
	private Long anoConstrucao;

	@Column(name="ANO_ULTIMA_REFORMA")
	private Long anoUltimaReforma;

	private String descricao;

	@Column(name="DESCRICAO_HOTEL")
	private String descricaoHotel;

	@Column(name="DISTANCIA_AEROPORTO")
	private Long distanciaAeroporto;

	@Column(name="DISTANCIA_CCONVENCOES")
	private Long distanciaCconvencoes;

	@Column(name="DISTANCIA_CENTRO")
	private Long distanciaCentro;

	@Column(name="DISTANCIA_RODOVIARIA")
	private Long distanciaRodoviaria;

	private String estabelecimento;

	@Column(name="ID_HOTEL")
	private Long idHotel;


	@OneToOne
	@JoinColumn(name="ID_IDIOMA", referencedColumnName="ID_IDIOMA")
	private IdiomaMozartEJB idioma;

	private String localizacao;

	@Column(name="NOME_AEROPORTO")
	private String nomeAeroporto;

	@Column(name="NOME_CCONVENCOES")
	private String nomeCconvencoes;

	@Column(name="NOME_CENTRO")
	private String nomeCentro;

	@Column(name="NOME_RODOVIARIA")
	private String nomeRodoviaria;

	@Column(name="QTDE_ANDARES")
	private Long qtdeAndares;

	@Column(name="QTDE_ELEVADORES")
	private Long qtdeElevadores;

	@Column(name="TEMPO_AEROPORTO")
	private String tempoAeroporto;

	@Column(name="TEMPO_CCONVENCOES")
	private String tempoCconvencoes;

	@Column(name="TEMPO_CENTRO")
	private String tempoCentro;

	@Column(name="TEMPO_RODOVIARIA")
	private String tempoRodoviaria;

	@Column(name="UNIDADES_HABITACIONAIS")
	private Long unidadesHabitacionais;

    public CaracteristicaGeralEJB() {
    		
    }

	public Long getIdCaracteristicasGerais() {
		return this.idCaracteristicasGerais;
	}

	public void setIdCaracteristicasGerais(Long idCaracteristicasGerais) {
		this.idCaracteristicasGerais = idCaracteristicasGerais;
	}

	public Long getAnoConstrucao() {
		return this.anoConstrucao;
	}

	public void setAnoConstrucao(Long anoConstrucao) {
		this.anoConstrucao = anoConstrucao;
	}

	public Long getAnoUltimaReforma() {
		return this.anoUltimaReforma;
	}

	public void setAnoUltimaReforma(Long anoUltimaReforma) {
		this.anoUltimaReforma = anoUltimaReforma;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoHotel() {
		return this.descricaoHotel;
	}

	public void setDescricaoHotel(String descricaoHotel) {
		this.descricaoHotel = descricaoHotel;
	}

	public Long getDistanciaAeroporto() {
		return this.distanciaAeroporto;
	}

	public void setDistanciaAeroporto(Long distanciaAeroporto) {
		this.distanciaAeroporto = distanciaAeroporto;
	}

	public Long getDistanciaCconvencoes() {
		return this.distanciaCconvencoes;
	}

	public void setDistanciaCconvencoes(Long distanciaCconvencoes) {
		this.distanciaCconvencoes = distanciaCconvencoes;
	}

	public Long getDistanciaCentro() {
		return this.distanciaCentro;
	}

	public void setDistanciaCentro(Long distanciaCentro) {
		this.distanciaCentro = distanciaCentro;
	}

	public Long getDistanciaRodoviaria() {
		return this.distanciaRodoviaria;
	}

	public void setDistanciaRodoviaria(Long distanciaRodoviaria) {
		this.distanciaRodoviaria = distanciaRodoviaria;
	}

	public String getEstabelecimento() {
		return this.estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getNomeAeroporto() {
		return this.nomeAeroporto;
	}

	public void setNomeAeroporto(String nomeAeroporto) {
		this.nomeAeroporto = nomeAeroporto;
	}

	public String getNomeCconvencoes() {
		return this.nomeCconvencoes;
	}

	public void setNomeCconvencoes(String nomeCconvencoes) {
		this.nomeCconvencoes = nomeCconvencoes;
	}

	public String getNomeCentro() {
		return this.nomeCentro;
	}

	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}

	public String getNomeRodoviaria() {
		return this.nomeRodoviaria;
	}

	public void setNomeRodoviaria(String nomeRodoviaria) {
		this.nomeRodoviaria = nomeRodoviaria;
	}

	public Long getQtdeAndares() {
		return this.qtdeAndares;
	}

	public void setQtdeAndares(Long qtdeAndares) {
		this.qtdeAndares = qtdeAndares;
	}

	public Long getQtdeElevadores() {
		return this.qtdeElevadores;
	}

	public void setQtdeElevadores(Long qtdeElevadores) {
		this.qtdeElevadores = qtdeElevadores;
	}

	public String getTempoAeroporto() {
		return this.tempoAeroporto;
	}

	public void setTempoAeroporto(String tempoAeroporto) {
		this.tempoAeroporto = tempoAeroporto;
	}

	public String getTempoCconvencoes() {
		return this.tempoCconvencoes;
	}

	public void setTempoCconvencoes(String tempoCconvencoes) {
		this.tempoCconvencoes = tempoCconvencoes;
	}

	public String getTempoCentro() {
		return this.tempoCentro;
	}

	public void setTempoCentro(String tempoCentro) {
		this.tempoCentro = tempoCentro;
	}

	public String getTempoRodoviaria() {
		return this.tempoRodoviaria;
	}

	public void setTempoRodoviaria(String tempoRodoviaria) {
		this.tempoRodoviaria = tempoRodoviaria;
	}

	public Long getUnidadesHabitacionais() {
		return this.unidadesHabitacionais;
	}

	public void setUnidadesHabitacionais(Long unidadesHabitacionais) {
		this.unidadesHabitacionais = unidadesHabitacionais;
	}

	public IdiomaMozartEJB getIdioma() {
		return idioma;
	}

	public void setIdioma(IdiomaMozartEJB idioma) {
		this.idioma = idioma;
	}

}