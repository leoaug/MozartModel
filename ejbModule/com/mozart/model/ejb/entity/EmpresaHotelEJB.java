package com.mozart.model.ejb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EmpresaHotelEJB.findAll", 
	hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, 
	query = "select o from EmpresaHotelEJB o")
@Table(name = "EMPRESA_HOTEL")
@IdClass(EmpresaHotelEJBPK.class)
@SuppressWarnings("unchecked")
public class EmpresaHotelEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_EMPRESA", nullable = false, insertable = false, updatable = false)
	private Long idEmpresa;
	
	@Id
	@Column(name = "ID_HOTEL", nullable = false)
	private Long idHotel;
	
	private String acredito;
	
	@Column(name = "CALCULA_ISS", nullable = false)
	private String calculaIss;
	
	@Column(name = "CALCULA_ROOMTAX", nullable = false)
	private String calculaRoomtax;
	
	@Column(name = "CALCULA_SEGURO")
	private String calculaSeguro;
	
	@Column(name = "CALCULA_TAXA", nullable = false)
	private String calculaTaxa;
	
	private Double comissao;
	
	@Column(name = "ID_CONTA_CORRENTE")
	private Long contaCorrente;
	
	private Double desconto;
		
	@Column(name = "ID_PROMOTOR")
	private Long idPromotor;
	
	@Column(name = "ID_TIPO_EMPRESA", nullable = false)
	private Long idTipoEmpresa;
	
	@Column(name = "ISS_RETENCAO")
	private String issRetencao;
	
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name = "PRAZO_PAGAMENTO")
	private Long prazoPagamento;
	
	@Column(name = "TIPO_EMPRESA")
	private String tipoEmpresa;
	
	@Column(name = "TIPO_PENSAO", nullable = false)
	private String tipoPensao;
	
	@Column(name = "VALOR_CREDITO")
	private Double valorCredito;
	
	@Column(name = "ID_CORPORATE")
	private Long idCorporate;
	
	@OneToMany(mappedBy = "empresaHotelEJB", fetch = FetchType.EAGER, cascade = {
			javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.PERSIST })
	private List<EmpresaGrupoLancamentoEJB> empresaGrupoLancamentoEJBList;
	
	@OneToMany(mappedBy = "empresaHotelEJB", fetch = FetchType.EAGER, cascade = {
			javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.PERSIST })
	private List<EmpresaTarifaEJB> empresaTarifaEJBList;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumns( {
			@javax.persistence.JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA"),
			@javax.persistence.JoinColumn(name = "ID_REDE_HOTEL", referencedColumnName = "ID_REDE_HOTEL") })
	private EmpresaRedeEJB empresaRedeEJB;

	public EmpresaHotelEJB() {
		this.empresaGrupoLancamentoEJBList = new ArrayList();
		this.empresaTarifaEJBList = new ArrayList();
	}

	public String getAcredito() {
		return this.acredito;
	}

	public void setAcredito(String acredito) {
		this.acredito = acredito;
	}

	public String getCalculaIss() {
		return this.calculaIss;
	}

	public void setCalculaIss(String calculaIss) {
		this.calculaIss = calculaIss;
	}

	public String getCalculaRoomtax() {
		return this.calculaRoomtax;
	}

	public void setCalculaRoomtax(String calculaRoomtax) {
		this.calculaRoomtax = calculaRoomtax;
	}

	public String getCalculaSeguro() {
		return this.calculaSeguro;
	}

	public void setCalculaSeguro(String calculaSeguro) {
		this.calculaSeguro = calculaSeguro;
	}

	public String getCalculaTaxa() {
		return this.calculaTaxa;
	}

	public void setCalculaTaxa(String calculaTaxa) {
		this.calculaTaxa = calculaTaxa;
	}

	public Double getComissao() {
		return this.comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Long getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdPromotor() {
		return this.idPromotor;
	}

	public void setIdPromotor(Long idPromotor) {
		this.idPromotor = idPromotor;
	}

	public Long getIdTipoEmpresa() {
		return this.idTipoEmpresa;
	}

	public void setIdTipoEmpresa(Long idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}

	public String getIssRetencao() {
		return this.issRetencao;
	}

	public void setIssRetencao(String issRetencao) {
		this.issRetencao = issRetencao;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Long getPrazoPagamento() {
		return this.prazoPagamento;
	}

	public void setPrazoPagamento(Long prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getTipoPensao() {
		return this.tipoPensao;
	}

	public void setTipoPensao(String tipoPensao) {
		this.tipoPensao = tipoPensao;
	}

	public Double getValorCredito() {
		return this.valorCredito;
	}

	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public List<EmpresaGrupoLancamentoEJB> getEmpresaGrupoLancamentoEJBList() {
		return this.empresaGrupoLancamentoEJBList;
	}

	public void setEmpresaGrupoLancamentoEJBList(
			List<EmpresaGrupoLancamentoEJB> empresaGrupoLancamentoEJBList) {
		this.empresaGrupoLancamentoEJBList = empresaGrupoLancamentoEJBList;
	}

	public EmpresaGrupoLancamentoEJB addEmpresaGrupoLancamentoEJB(
			EmpresaGrupoLancamentoEJB empresaGrupoLancamentoEJB) {
		getEmpresaGrupoLancamentoEJBList().add(empresaGrupoLancamentoEJB);
		empresaGrupoLancamentoEJB.setEmpresaHotelEJB(this);
		return empresaGrupoLancamentoEJB;
	}

	public EmpresaGrupoLancamentoEJB removeEmpresaGrupoLancamentoEJB(
			EmpresaGrupoLancamentoEJB empresaGrupoLancamentoEJB) {
		getEmpresaGrupoLancamentoEJBList().remove(empresaGrupoLancamentoEJB);
		empresaGrupoLancamentoEJB.setEmpresaHotelEJB(null);
		return empresaGrupoLancamentoEJB;
	}

	public List<EmpresaTarifaEJB> getEmpresaTarifaEJBList() {
		return this.empresaTarifaEJBList;
	}

	public void setEmpresaTarifaEJBList(
			List<EmpresaTarifaEJB> empresaTarifaEJBList) {
		this.empresaTarifaEJBList = empresaTarifaEJBList;
	}

	public EmpresaTarifaEJB addEmpresaTarifaEJB(
			EmpresaTarifaEJB empresaTarifaEJB) {
		getEmpresaTarifaEJBList().add(empresaTarifaEJB);
		empresaTarifaEJB.setEmpresaHotelEJB(this);
		return empresaTarifaEJB;
	}

	public EmpresaTarifaEJB removeEmpresaTarifaEJB(
			EmpresaTarifaEJB empresaTarifaEJB) {
		getEmpresaTarifaEJBList().remove(empresaTarifaEJB);
		empresaTarifaEJB.setEmpresaHotelEJB(null);
		return empresaTarifaEJB;
	}

	public void setEmpresaRedeEJB(EmpresaRedeEJB empresaRedeEJB) {
		this.empresaRedeEJB = empresaRedeEJB;
	}

	public EmpresaRedeEJB getEmpresaRedeEJB() {
		return this.empresaRedeEJB;
	}

	public Long getIdCorporate() {
		return this.idCorporate;
	}

	public void setIdCorporate(Long idCorporate) {
		this.idCorporate = idCorporate;
	}
}