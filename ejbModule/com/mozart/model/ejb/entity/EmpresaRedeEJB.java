package com.mozart.model.ejb.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mozart.model.util.MozartUtil;

@Entity
@NamedQuery(name = "EmpresaRedeEJB.findAll", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "select o from EmpresaRedeEJB o")
@Table(name = "EMPRESA_REDE")
@IdClass(EmpresaRedeEJBPK.class)
@SuppressWarnings("unchecked")
public class EmpresaRedeEJB extends MozartEntity {

	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String contato;
	private String contato2;
	@Column(nullable = false)
	private String credito;
	private String crs;
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Timestamp dataCadastro;
	@Column(name = "DATA_NASCIMENTO")
	private Timestamp dataNascimento;
	@Column(name = "DATA_NASCIMENTO2")
	private String dataNascimento2;
	private String email;
	private String email2;
	private String fax;
	@Id
	@Column(name = "ID_EMPRESA", nullable = false, insertable = false, updatable = false)
	private Long idEmpresa;
	
	@OneToOne(cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_GRUPO_ECONOMICO", referencedColumnName = "ID_GRUPO_ECONOMICO",  insertable = false, updatable = false)
	private GrupoEconomicoEJB grupoEconomico;
	
	@OneToOne(cascade = { javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_PROMOTOR", referencedColumnName = "ID_PROMOTOR")
	private PromotorEJB promotorEJB;
		
	@Column(name = "ID_REPRESENTANTE")
	private Long idRepresentante;

	@Column(name = "ID_VENDEDOR")
	private Long idVendedor;
	
	@Column(name = "ID_HOTEL")
	private Long idHotel;
	@Id
	@Column(name = "ID_REDE_HOTEL", nullable = false)
	private Long idRedeHotel;
	private String internet;
	@Column(name = "NOME_FANTASIA", nullable = false)
	private String nomeFantasia;
	private String observacao;
	@Column(name = "PARTICULAR")
	private String particular;
	private String telefone;
	private String telefone2;
	private String telex;
	@Column(name = "VALOR_CREDITO")
	private Double valorCredito;
	@ManyToOne(cascade = { javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
	private EmpresaEJB empresaEJB;
	@OneToOne
	@JoinColumn(name = "ID_CORPORATE", referencedColumnName = "ID_EMPRESA")
	private EmpresaEJB empresaCorporateEJB;
	@OneToMany(mappedBy = "empresaRedeEJB", cascade = {
			javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<EmpresaHotelEJB> empresaHotelEJBList;
	@Column(name = "ENDERECO_COBRANCA")
	private String enderecoCobranca;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE")
	private CidadeEJB cidade;
	private String bairro;
	private String cep;
	
	@Column(name = "ISS_RETIDO")
	private String issRetido;
	@Column(name = "PIS")
	private Double pis;
	@Column(name = "INSS")
	private Double inss;
	@Column(name = "COFINS")
	private Double cofins;
	@Column(name = "IR_RETENCAO")
	private Double irRetencao;
	@Column(name = "CSLL")
	private Double csll;
	@Column(name = "OUTRAS_RETENCOES")
	private Double outrasRetencoes;
	
	@Column(name = "DEAD_LINE")
	private Long deadLine;
	
	@Column(name = "NO_SHOW")
	private String noShow;

	public EmpresaRedeEJB() {
		this.empresaHotelEJBList = new ArrayList();
		this.cidade = new CidadeEJB();
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getContato2() {
		return this.contato2;
	}

	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}

	public String getCredito() {
		return this.credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public String getCrs() {
		return this.crs;
	}

	public void setCrs(String crs) {
		this.crs = crs;
	}

	public Timestamp getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Timestamp getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataNascimento2() {
		return this.dataNascimento2;
	}

	public void setDataNascimento2(String dataNascimento2) {
		this.dataNascimento2 = dataNascimento2;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getInternet() {
		return this.internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
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

	public String getParticular() {
		return this.particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelex() {
		return this.telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	public Double getValorCredito() {
		return this.valorCredito;
	}

	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public EmpresaEJB getEmpresaEJB() {
		return this.empresaEJB;
	}

	public void setEmpresaEJB(EmpresaEJB empresaEJB) {
		this.empresaEJB = empresaEJB;
	}

	public EmpresaEJB getEmpresaCorporateEJB() {
		return this.empresaCorporateEJB;
	}

	public void setEmpresaCorporateEJB(EmpresaEJB empresaCorporateEJB) {
		this.empresaCorporateEJB = empresaCorporateEJB;
	}

	public List<EmpresaHotelEJB> getEmpresaHotelEJBList() {
		return this.empresaHotelEJBList;
	}

	public void setEmpresaHotelEJBList(List<EmpresaHotelEJB> empresaHotelEJBList) {
		this.empresaHotelEJBList = empresaHotelEJBList;
	}

	public EmpresaHotelEJB addEmpresaHotelEJB(EmpresaHotelEJB empresaHotelEJB) {
		getEmpresaHotelEJBList().add(empresaHotelEJB);
		empresaHotelEJB.setEmpresaRedeEJB(this);
		return empresaHotelEJB;
	}

	public EmpresaHotelEJB removeEmpresaHotelEJB(EmpresaHotelEJB empresaHotelEJB) {
		getEmpresaHotelEJBList().remove(empresaHotelEJB);
		empresaHotelEJB.setEmpresaRedeEJB(null);
		return empresaHotelEJB;
	}

	public PromotorEJB getPromotorEJB() {
		return this.promotorEJB;
	}

	public void setPromotorEJB(PromotorEJB promotorEJB) {
		this.promotorEJB = promotorEJB;
	}

	public GrupoEconomicoEJB getGrupoEconomico() {
		return this.grupoEconomico;
	}

	public void setGrupoEconomico(GrupoEconomicoEJB grupoEconomico) {
		this.grupoEconomico = grupoEconomico;
	}

	public String getEnderecoCobranca() {
		return this.enderecoCobranca;
	}

	public void setEnderecoCobranca(String enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public CidadeEJB getCidade() {
		return this.cidade;
	}

	public void setCidade(CidadeEJB cidade) {
		this.cidade = cidade;
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
			throw new IllegalArgumentException("CEP informado está em formato inválido. CEP:" + cep);
		this.cep = cep;
	}

	public Long getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Long deadLine) {
		this.deadLine = deadLine;
	}

	public String getNoShow() {
		return noShow;
	}

	public void setNoShow(String noShow) {
		this.noShow = noShow;
	}

	public String getIssRetido() {
		return issRetido;
	}

	public void setIssRetido(String issRetido) {
		this.issRetido = issRetido;
	}

	public Double getPis() {
		return pis;
	}

	public void setPis(Double pis) {
		this.pis = pis;
	}

	public Double getInss() {
		return inss;
	}

	public void setInss(Double inss) {
		this.inss = inss;
	}

	public Double getCofins() {
		return cofins;
	}

	public void setCofins(Double cofins) {
		this.cofins = cofins;
	}

	public Double getIrRetencao() {
		return irRetencao;
	}

	public void setIrRetencao(Double irRetencao) {
		this.irRetencao = irRetencao;
	}

	public Double getCsll() {
		return csll;
	}

	public void setCsll(Double csll) {
		this.csll = csll;
	}

	public Double getOutrasRetencoes() {
		return outrasRetencoes;
	}

	public void setOutrasRetencoes(Double outrasRetencoes) {
		this.outrasRetencoes = outrasRetencoes;
	}

	public Long getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(Long idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
}