package com.mozart.model.ejb.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mozart.model.util.MozartUtil;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "EmpresaEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from EmpresaEJB o")
@Table(name = "EMPRESA")
public class EmpresaEJB extends MozartEntity {
	@Column(name = "ADATA_CADASTRO")
	private Timestamp dataCadastro;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "CARTAO_CREDITO", nullable = false)
	private String cartaoCredito;

	@Column(name = "CEP")
	private String cep;
	private String cgc;
	private String cliente;
	private String codigo;

	@Column(name = "ENDERECO")
	private String endereco;

	private String fornecedor;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE")
	private CidadeEJB cidade;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqEmp")
	@SequenceGenerator(name = "idSeqEmp", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_EMPRESA", nullable = false)
	private Long idEmpresa;
	@Column(name = "INSC_EMBRATUR")
	private String inscEmbratur;
	@Column(name = "INSC_ESTADUAL")
	private String inscEstadual;
	@Column(name = "INSC_IATA")
	private String inscIata;
	@Column(name = "INSC_MUNICIPAL")
	private String inscMunicipal;
	private String nacional;
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;
	@Column(name = "RAZAO_SOCIAL", nullable = false)
	private String razaoSocial;
	private String terceirizada;
	private String tipo;
	private String cpf;

	@OneToMany(mappedBy = "empresaEJB", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<EmpresaTerceirizadaEJB> empresaTerceirizadaEJBList;

	@OneToMany(mappedBy = "empresaEJB", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<EmpresaAcessoEJB> empresaAcessoEJBList;

	@OneToMany(mappedBy = "empresaEJB", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<EmpresaRedeEJB> empresaRedeEJBList;

	@OneToMany(mappedBy = "empresaEJB", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<EmpresaReferenciaEJB> empresaReferenciaEJBList;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA_JUNTA")
	private EmpresaJuntaEJB empresaJuntaEJB;

	@OneToMany(mappedBy = "empresaEJB", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<EmpresaSocioEJB> empresaSocioEJBList;

	@OneToMany(mappedBy = "empresaEJB", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<ServicosContratoEJB> servicosContratoEJBList;

	public EmpresaEJB() {
		// empresaJuntaEJB = new EmpresaJuntaEJB();
		// empresaJuntaEJB.setEmpresaEJB( this );
		empresaSocioEJBList = new ArrayList<EmpresaSocioEJB>();
		empresaReferenciaEJBList = new ArrayList<EmpresaReferenciaEJB>();
		empresaRedeEJBList = new ArrayList<EmpresaRedeEJB>();
		// cidade = new CidadeEJB();
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public String getCep() {
		return MozartUtil.formatCEP(cep);
	}

	public void setCep(String cep) {
		cep = MozartUtil.removerNaoNumericos(cep);
		if (!MozartUtil.isNull(cep) && !cep.isEmpty() && !MozartUtil.validarCEP(cep))
			throw new IllegalArgumentException("CEP informado está em formato inválido.");
		this.cep = cep;
	}

	public String getCgc() {
		return cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getInscEmbratur() {
		return inscEmbratur;
	}

	public void setInscEmbratur(String inscEmbratur) {
		this.inscEmbratur = inscEmbratur;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscIata() {
		return inscIata;
	}

	public void setInscIata(String inscIata) {
		this.inscIata = inscIata;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getNacional() {
		return nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTerceirizada() {
		return terceirizada;
	}

	public void setTerceirizada(String terceirizada) {
		this.terceirizada = terceirizada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<EmpresaTerceirizadaEJB> getEmpresaTerceirizadaEJBList() {
		return empresaTerceirizadaEJBList;
	}

	public void setEmpresaTerceirizadaEJBList(List<EmpresaTerceirizadaEJB> empresaTerceirizadaEJBList) {
		this.empresaTerceirizadaEJBList = empresaTerceirizadaEJBList;
	}

	public EmpresaTerceirizadaEJB addEmpresaTerceirizadaEJB(EmpresaTerceirizadaEJB empresaTerceirizadaEJB) {
		getEmpresaTerceirizadaEJBList().add(empresaTerceirizadaEJB);
		empresaTerceirizadaEJB.setEmpresaEJB(this);
		return empresaTerceirizadaEJB;
	}

	public EmpresaTerceirizadaEJB removeEmpresaTerceirizadaEJB(EmpresaTerceirizadaEJB empresaTerceirizadaEJB) {
		getEmpresaTerceirizadaEJBList().remove(empresaTerceirizadaEJB);
		empresaTerceirizadaEJB.setEmpresaEJB(null);
		return empresaTerceirizadaEJB;
	}

	public List<EmpresaAcessoEJB> getEmpresaAcessoEJBList() {
		return empresaAcessoEJBList;
	}

	public void setEmpresaAcessoEJBList(List<EmpresaAcessoEJB> empresaAcessoEJBList) {
		this.empresaAcessoEJBList = empresaAcessoEJBList;
	}

	public EmpresaAcessoEJB addEmpresaAcessoEJB(EmpresaAcessoEJB empresaAcessoEJB) {
		getEmpresaAcessoEJBList().add(empresaAcessoEJB);
		empresaAcessoEJB.setEmpresaEJB(this);
		return empresaAcessoEJB;
	}

	public EmpresaAcessoEJB removeEmpresaAcessoEJB(EmpresaAcessoEJB empresaAcessoEJB) {
		getEmpresaAcessoEJBList().remove(empresaAcessoEJB);
		empresaAcessoEJB.setEmpresaEJB(null);
		return empresaAcessoEJB;
	}

	public List<EmpresaRedeEJB> getEmpresaRedeEJBList() {
		return empresaRedeEJBList;
	}

	public void setEmpresaRedeEJBList(List<EmpresaRedeEJB> empresaRedeEJBList) {
		this.empresaRedeEJBList = empresaRedeEJBList;
	}

	public EmpresaRedeEJB addEmpresaRedeEJB(EmpresaRedeEJB empresaRedeEJB) {
		getEmpresaRedeEJBList().add(empresaRedeEJB);
		empresaRedeEJB.setEmpresaEJB(this);
		return empresaRedeEJB;
	}

	public EmpresaRedeEJB removeEmpresaRedeEJB(EmpresaRedeEJB empresaRedeEJB) {
		getEmpresaRedeEJBList().remove(empresaRedeEJB);
		empresaRedeEJB.setEmpresaEJB(null);
		return empresaRedeEJB;
	}

	public List<EmpresaReferenciaEJB> getEmpresaReferenciaEJBList() {
		return empresaReferenciaEJBList;
	}

	public void setEmpresaReferenciaEJBList(List<EmpresaReferenciaEJB> empresaReferenciaEJBList) {
		this.empresaReferenciaEJBList = empresaReferenciaEJBList;
	}

	public EmpresaReferenciaEJB addEmpresaReferenciaEJB(EmpresaReferenciaEJB empresaReferenciaEJB) {
		getEmpresaReferenciaEJBList().add(empresaReferenciaEJB);
		empresaReferenciaEJB.setEmpresaEJB(this);
		return empresaReferenciaEJB;
	}

	public EmpresaReferenciaEJB removeEmpresaReferenciaEJB(EmpresaReferenciaEJB empresaReferenciaEJB) {
		getEmpresaReferenciaEJBList().remove(empresaReferenciaEJB);
		empresaReferenciaEJB.setEmpresaEJB(null);
		return empresaReferenciaEJB;
	}

	public EmpresaJuntaEJB getEmpresaJuntaEJB() {
		return empresaJuntaEJB;
	}

	public void setEmpresaJuntaEJB(EmpresaJuntaEJB empresaJuntaEJB) {
		this.empresaJuntaEJB = empresaJuntaEJB;
	}

	public List<EmpresaSocioEJB> getEmpresaSocioEJBList() {
		return empresaSocioEJBList;
	}

	public void setEmpresaSocioEJBList(List<EmpresaSocioEJB> empresaSocioEJBList) {
		this.empresaSocioEJBList = empresaSocioEJBList;
	}

	public EmpresaSocioEJB addEmpresaSocioEJB(EmpresaSocioEJB empresaSocioEJB) {
		getEmpresaSocioEJBList().add(empresaSocioEJB);
		empresaSocioEJB.setEmpresaEJB(this);
		return empresaSocioEJB;
	}

	public EmpresaSocioEJB removeEmpresaSocioEJB(EmpresaSocioEJB empresaSocioEJB) {
		getEmpresaSocioEJBList().remove(empresaSocioEJB);
		empresaSocioEJB.setEmpresaEJB(null);
		return empresaSocioEJB;
	}

	public CidadeEJB getCidade() {
		return cidade;
	}

	public void setCidade(CidadeEJB cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<ServicosContratoEJB> getServicosContratoEJBList() {
		return servicosContratoEJBList;
	}

	public void setServicosContratoEJBList(List<ServicosContratoEJB> servicosContratoEJBList) {
		this.servicosContratoEJBList = servicosContratoEJBList;
	}

	public ServicosContratoEJB addServicosContratoEJB(ServicosContratoEJB servicosContratoEJB) {
		getServicosContratoEJBList().add(servicosContratoEJB);
		servicosContratoEJB.setEmpresaEJB(this);
		return servicosContratoEJB;
	}

	public ServicosContratoEJB removeServicosContratoEJB(ServicosContratoEJB servicosContratoEJB) {
		getServicosContratoEJBList().remove(servicosContratoEJB);
		servicosContratoEJB.setEmpresaEJB(null);
		return servicosContratoEJB;
	}
}
