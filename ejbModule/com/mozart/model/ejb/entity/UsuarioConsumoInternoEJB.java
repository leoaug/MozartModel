package com.mozart.model.ejb.entity;

import java.io.Serializable;





import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the USUARIOS_CONSUMO_INTERNO database table.
 * 
 */
@Entity
@Table(name="USUARIOS_CONSUMO_INTERNO")
public class UsuarioConsumoInternoEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIOS_CONSUMO_INTERNO", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIOS_CONSUMO_INTERNO")
	@Column(name="ID_USUARIO_CONSUMO_INTERNO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@Column(name = "ATIVO")
	private String ativo;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_CENTRO_CUSTO_CONTABIL", referencedColumnName="ID_CENTRO_CUSTO_CONTABIL")
	private CentroCustoContabilEJB centroCustoContabilEJB;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIAL")
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FINAL")
	private Date dataFinal;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ALCOOLICA")
	private String alcoolica;
	
	@Column(name = "TIPO_PENSAO")
	private String tipoPensao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="ID_REDE_HOTEL", name="ID_REDE_HOTEL", nullable=false)
	private RedeHotelEJB redeHotel;
	
	@OneToMany(mappedBy = "usuarioConsumoInternoEJB", fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	private List<UsuarioCiRedeEJB> hotelEJBList;
	
    public UsuarioConsumoInternoEJB() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public CentroCustoContabilEJB getCentroCustoContabilEJB() {
		return centroCustoContabilEJB;
	}

	public void setCentroCustoContabilEJB(
			CentroCustoContabilEJB centroCustoContabilEJB) {
		this.centroCustoContabilEJB = centroCustoContabilEJB;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlcoolica() {
		return alcoolica;
	}

	public void setAlcoolica(String alcoolica) {
		this.alcoolica = alcoolica;
	}

	public String getTipoPensao() {
		return tipoPensao;
	}

	public void setTipoPensao(String tipoPensao) {
		this.tipoPensao = tipoPensao;
	}

	public RedeHotelEJB getRedeHotel() {
		return redeHotel;
	}

	public void setRedeHotel(RedeHotelEJB redeHotel) {
		this.redeHotel = redeHotel;
	}

	public List<UsuarioCiRedeEJB> getHotelEJBList() {
		return hotelEJBList;
	}

	public void setHotelEJBList(List<UsuarioCiRedeEJB> hotelEJBList) {
		this.hotelEJBList = hotelEJBList;
	}
	
	public void addHotel(UsuarioCiRedeEJB novoHotel) {
		novoHotel.setUsuarioConsumoInternoEJB(this);
		hotelEJBList.add(novoHotel);
	}
}