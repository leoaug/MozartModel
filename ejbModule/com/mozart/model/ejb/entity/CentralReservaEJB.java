package com.mozart.model.ejb.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.mozart.model.util.MozartUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="CENTRAL_RESERVAS")
public class CentralReservaEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CENTRAL_RESERVAS_IDCENTRALRESERVAS_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CENTRAL_RESERVAS_IDCENTRALRESERVAS_GENERATOR")
	@Column(name="ID_CENTRAL_RESERVAS")
	private long idCentralReservas;

	private String bairro;

	private String cep;

	private String cgc;

	private String contato;

	private String email;

	private String endereco;

	private String fax;

	@Column(name="ID_CIDADE")
	private BigDecimal idCidade;

	@Column(name="ID_PROGRAMA_NOTICIA")
	private BigDecimal idProgramaNoticia;

	@Column(name="INSC_ESTADUAL")
	private String inscEstadual;

	@Column(name="INSC_MUNICIPAL")
	private String inscMunicipal;

	@Column(name="LINK_ID_CORPORATIVA")
	private String linkIdCorporativa;

	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;

	private String observacao;

	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;

	private String sigla;

	private String telefone;

	private String telex;

	@Column(name="TITULO_SITE")
	private String tituloSite;

	@OneToMany(mappedBy="centralReserva", fetch=FetchType.EAGER)
	private List<CentralReservasHotelEJB> centralReservasHotel;

	
	@OneToMany(mappedBy="centralReserva",fetch=FetchType.EAGER)
	private List<CentralReservasRedeEJB> centralReservasRedeHotel;

	@Transient
	private List<HotelEJB> hoteisAtivos = null;

	@Transient
	private List<CidadeEJB> cidadesAtivas = null;
	
	
	@SuppressWarnings("unchecked")
	public List<HotelEJB> getHoteisAtivos(){
		if (hoteisAtivos == null){
			hoteisAtivos = new ArrayList<HotelEJB>();
		
			for (CentralReservasHotelEJB crs: centralReservasHotel){
				if ("S".equalsIgnoreCase(crs.getAtivo()) && "S".equalsIgnoreCase( crs.getHotelEJB().getAtivo())){
					hoteisAtivos.add( crs.getHotelEJB());
				}
			}
			Collections.sort( hoteisAtivos, HotelEJB.getComparator());
		}
		return hoteisAtivos;
	}
	
	@SuppressWarnings("unchecked")
	public List<CidadeEJB> getCidadesAtivas(){
		if (hoteisAtivos == null){
			getHoteisAtivos();
		}
		if (cidadesAtivas == null){
			cidadesAtivas = new ArrayList<CidadeEJB>();
			for (HotelEJB linha: hoteisAtivos){
				if (!cidadesAtivas.contains(linha.getCidadeEJB())){
					cidadesAtivas.add( linha.getCidadeEJB());
				}
			}
			Collections.sort( cidadesAtivas, CidadeEJB.getComparator());
		}
		
		return cidadesAtivas;
	}
	
	
	
    public CentralReservaEJB() {
    }

	public long getIdCentralReservas() {
		return this.idCentralReservas;
	}

	public void setIdCentralReservas(long idCentralReservas) {
		this.idCentralReservas = idCentralReservas;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	 public String getCep() {
		return MozartUtil.formatCEP(cep);
	}

	public void setCep(String cep) {
		cep = MozartUtil.removerNaoNumericos(cep);
		if (!MozartUtil.validarCEP(cep))
			throw new IllegalArgumentException("CEP informado está em formato inválido.");
		this.cep = cep;
	}

	public String getCgc() {
		return this.cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public BigDecimal getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(BigDecimal idCidade) {
		this.idCidade = idCidade;
	}

	public BigDecimal getIdProgramaNoticia() {
		return this.idProgramaNoticia;
	}

	public void setIdProgramaNoticia(BigDecimal idProgramaNoticia) {
		this.idProgramaNoticia = idProgramaNoticia;
	}

	public String getInscEstadual() {
		return this.inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicipal() {
		return this.inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getLinkIdCorporativa() {
		return this.linkIdCorporativa;
	}

	public void setLinkIdCorporativa(String linkIdCorporativa) {
		this.linkIdCorporativa = linkIdCorporativa;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelex() {
		return this.telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	public String getTituloSite() {
		return this.tituloSite;
	}

	public void setTituloSite(String tituloSite) {
		this.tituloSite = tituloSite;
	}

	public List<CentralReservasHotelEJB> getCentralReservasHotel() {
		return this.centralReservasHotel;
	}

	public void setCentralReservasHotels(List<CentralReservasHotelEJB> centralReservasHotel) {
		this.centralReservasHotel = centralReservasHotel;
	}
	public void setCentralReservasHotel(
			List<CentralReservasHotelEJB> centralReservasHotel) {
		this.centralReservasHotel = centralReservasHotel;
	}
	public void setHoteisAtivos(List<HotelEJB> hoteisAtivos) {
		this.hoteisAtivos = hoteisAtivos;
	}

	public void setCidadesAtivas(List<CidadeEJB> cidadesAtivas) {
		this.cidadesAtivas = cidadesAtivas;
	}

	public List<CentralReservasRedeEJB> getCentralReservasRedeHotel() {
		return centralReservasRedeHotel;
	}

	public void setCentralReservasRedeHotel(
			List<CentralReservasRedeEJB> centralReservasRedeHotel) {
		this.centralReservasRedeHotel = centralReservasRedeHotel;
	}
	
}