package com.mozart.model.ejb.builder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mozart.model.ejb.entity.CidadeEJB;
import com.mozart.model.ejb.entity.EmpresaAcessoEJB;
import com.mozart.model.ejb.entity.EmpresaEJB;
import com.mozart.model.ejb.entity.EmpresaJuntaEJB;
import com.mozart.model.ejb.entity.EmpresaRedeEJB;
import com.mozart.model.ejb.entity.EmpresaReferenciaEJB;
import com.mozart.model.ejb.entity.EmpresaSocioEJB;
import com.mozart.model.ejb.entity.EmpresaTerceirizadaEJB;
import com.mozart.model.ejb.entity.ServicosContratoEJB;

public class EmpresaBuilder {

	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private CidadeEJB cidade;
	private String cep;
	private String cgc;
	private String cartaoCredito = "N";
	private String nacional = "S";
	private Timestamp dataCadastro;
	private String cliente;
	private String codigo;
	private String fornecedor;
	private Long idEmpresa;
	private String inscEmbratur;
	private String inscEstadual;
	private String inscIata;
	private String inscMunicipal;
	private String nomeFantasia;
	private String razaoSocial;
	private String terceirizada;
	private String tipo;
	private List<EmpresaTerceirizadaEJB> empresaTerceirizadaEJBList;
	private List<EmpresaAcessoEJB> empresaAcessoEJBList;
	private List<EmpresaRedeEJB> empresaRedeEJBList;
	private List<EmpresaReferenciaEJB> empresaReferenciaEJBList;
	private EmpresaJuntaEJB empresaJuntaEJB;
	private List<EmpresaSocioEJB> empresaSocioEJBList;
	private String cpf;
	private List<ServicosContratoEJB> servicosContratoEJBList;

	public EmpresaEJB build() {
		empresaTerceirizadaEJBList = new ArrayList<EmpresaTerceirizadaEJB>();
		empresaAcessoEJBList = new ArrayList<EmpresaAcessoEJB>();
		empresaRedeEJBList = new ArrayList<EmpresaRedeEJB>();
		empresaReferenciaEJBList = new ArrayList<EmpresaReferenciaEJB>();
		empresaSocioEJBList = new ArrayList<EmpresaSocioEJB>();
		servicosContratoEJBList = new ArrayList<ServicosContratoEJB>();

		EmpresaEJB retorno = new EmpresaEJB();
		retorno.setEndereco(endereco);
		retorno.setNumero(numero);
		retorno.setComplemento(complemento);
		retorno.setBairro(bairro);
		retorno.setCidade(cidade);
		retorno.setCep(cep);
		retorno.setCgc(cgc);
		retorno.setCartaoCredito(cartaoCredito);
		retorno.setNacional(nacional);
		retorno.setDataCadastro(dataCadastro);
		retorno.setCliente(cliente);
		retorno.setCodigo(codigo);
		retorno.setFornecedor(fornecedor);
		retorno.setIdEmpresa(idEmpresa);
		retorno.setInscEmbratur(inscEmbratur);
		retorno.setInscEstadual(inscEstadual);
		retorno.setInscIata(inscIata);
		retorno.setInscMunicipal(inscMunicipal);
		retorno.setNomeFantasia(nomeFantasia);
		retorno.setRazaoSocial(razaoSocial);
		retorno.setTerceirizada(terceirizada);
		retorno.setTipo(tipo);
		retorno.setEmpresaTerceirizadaEJBList(empresaTerceirizadaEJBList);
		retorno.setEmpresaAcessoEJBList(empresaAcessoEJBList);
		retorno.setEmpresaRedeEJBList(empresaRedeEJBList);
		retorno.setEmpresaReferenciaEJBList(empresaReferenciaEJBList);
		retorno.setEmpresaJuntaEJB(empresaJuntaEJB);
		retorno.setEmpresaSocioEJBList(empresaSocioEJBList);
		retorno.setServicosContratoEJBList(servicosContratoEJBList);
		//retorno.setCpf(cpf);

		return retorno;
	}

	public EmpresaBuilder endereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public EmpresaBuilder numero(String numero) {
		this.numero = numero;
		return this;
	}

	public EmpresaBuilder complemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public EmpresaBuilder bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public EmpresaBuilder cidade(CidadeEJB cidade) {
		this.cidade = cidade;
		return this;
	}

	public EmpresaBuilder cep(String cep) {
		this.cep = cep;
		return this;
	}

	public EmpresaBuilder cgc(String cgc) {
		this.cgc = cgc;
		return this;
	}

	public EmpresaBuilder cartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
		return this;
	}

	public EmpresaBuilder nacional(String nacional) {
		this.nacional = nacional;
		return this;
	}

	public EmpresaBuilder dataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
		return this;
	}

	public EmpresaBuilder cliente(String cliente) {
		this.cliente = cliente;
		return this;
	}

	public EmpresaBuilder codigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public EmpresaBuilder fornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
		return this;
	}

	public EmpresaBuilder idEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
		return this;
	}

	public EmpresaBuilder inscEmbratur(String inscEmbratur) {
		this.inscEmbratur = inscEmbratur;
		return this;
	}

	public EmpresaBuilder inscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
		return this;
	}

	public EmpresaBuilder inscIata(String inscIata) {
		this.inscIata = inscIata;
		return this;
	}

	public EmpresaBuilder inscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
		return this;
	}

	public EmpresaBuilder nomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
		return this;
	}

	public EmpresaBuilder razaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public EmpresaBuilder terceirizada(String terceirizada) {
		this.terceirizada = terceirizada;
		return this;
	}

	public EmpresaBuilder tipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public EmpresaBuilder empresaTerceirizadaEJBList(List<EmpresaTerceirizadaEJB> empresaTerceirizadaEJBList) {
		this.empresaTerceirizadaEJBList = empresaTerceirizadaEJBList;
		return this;
	}

	public EmpresaBuilder empresaAcessoEJBList(List<EmpresaAcessoEJB> empresaAcessoEJBList) {
		this.empresaAcessoEJBList = empresaAcessoEJBList;
		return this;
	}

	public EmpresaBuilder empresaRedeEJBList(List<EmpresaRedeEJB> empresaRedeEJBList) {
		this.empresaRedeEJBList = empresaRedeEJBList;
		return this;
	}

	public EmpresaBuilder empresaReferenciaEJBList(List<EmpresaReferenciaEJB> empresaReferenciaEJBList) {
		this.empresaReferenciaEJBList = empresaReferenciaEJBList;
		return this;
	}

	public EmpresaBuilder empresaJuntaEJB(EmpresaJuntaEJB empresaJuntaEJB) {
		this.empresaJuntaEJB = empresaJuntaEJB;
		return this;
	}

	public EmpresaBuilder empresaSocioEJBList(List<EmpresaSocioEJB> empresaSocioEJBList) {
		this.empresaSocioEJBList = empresaSocioEJBList;
		return this;
	}

	public EmpresaBuilder cpf(String documento) {
		this.cpf = documento;
		return this;
	}

}
