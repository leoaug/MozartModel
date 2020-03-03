package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the TARIFA database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="TARIFA")
public class TarifaEJB extends MozartEntity {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqTarifa")
    @SequenceGenerator(name="idSeqTarifa", sequenceName="id", allocationSize=1)
	@Column(name="ID_TARIFA")
	private Long idTarifa;


	@Column(name="ID_HOTEL")
	private Long idHotel;

	
	private String ativo;

    
	@Column(name="DATA_ENTRADA")
	private Timestamp dataEntrada;

    
	@Column(name="DATA_SAIDA")
	private Timestamp dataSaida;

	private String descricao;

	@Column(name="ID_MOEDA")
	private java.math.BigDecimal idMoeda;

	private String observacao;

	private String tipo;

	//bi-directional many-to-one association to TarifaGrupoEJB
    @ManyToOne
	@JoinColumn(name="ID_TARIFA_GRUPO")
	private TarifaGrupoEJB tarifaGrupo;
    
    @OneToMany(mappedBy="tarifaEJB", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TarifaApartamentoEJB> tarifaApartamentoList;

    @OneToMany(mappedBy="tarifaEJB", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TarifaIdiomaEJB> tarifaIdiomaList;

    public TarifaEJB() {
    	tarifaApartamentoList = new ArrayList<TarifaApartamentoEJB>();
    	tarifaIdiomaList = new ArrayList<TarifaIdiomaEJB>();
    }
    
    public TarifaEJB(TarifaEJB clone) {
    	idTarifa = clone.getIdTarifa();
    	idHotel= clone.getIdHotel();
    	idMoeda = clone.getIdMoeda();
    	ativo = clone.getAtivo();
    	descricao = clone.getDescricao();
    	dataEntrada = clone.getDataEntrada();
    	dataSaida = clone.getDataSaida();
    	tarifaApartamentoList = clone.getTarifaApartamentoList();
    	tarifaGrupo = clone.tarifaGrupo;
    	tarifaIdiomaList = clone.getTarifaIdiomaList();
    	tipo = clone.getTipo();
    	observacao = clone.getObservacao();
    	
    }

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Timestamp getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Timestamp getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public java.math.BigDecimal getIdMoeda() {
		return this.idMoeda;
	}

	public void setIdMoeda(java.math.BigDecimal idMoeda) {
		this.idMoeda = idMoeda;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TarifaGrupoEJB getTarifaGrupo() {
		return this.tarifaGrupo;
	}

	public void setTarifaGrupo(TarifaGrupoEJB tarifaGrupo) {
		this.tarifaGrupo = tarifaGrupo;
	}

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public List<TarifaApartamentoEJB> getTarifaApartamentoList() {
		return tarifaApartamentoList;
	}

	public void setTarifaApartamentoList(
			List<TarifaApartamentoEJB> tarifaApartamentoList) {
		this.tarifaApartamentoList = tarifaApartamentoList;
	}
	
	public void addTarifaApartamento(TarifaApartamentoEJB tarifaApartamento) {
		tarifaApartamento.setTarifaEJB(this);
		tarifaApartamentoList.add(tarifaApartamento);
	}
	public void addTarifaIdioma(TarifaIdiomaEJB tarifaIdioma) {
		tarifaIdioma.setTarifaEJB(this);
		tarifaIdiomaList.add(tarifaIdioma);
	}

	public List<TarifaIdiomaEJB> getTarifaIdiomaList() {
		return tarifaIdiomaList;
	}

	public void setTarifaIdiomaList(List<TarifaIdiomaEJB> tarifaIdiomaList) {
		this.tarifaIdiomaList = tarifaIdiomaList;
	}

	
}