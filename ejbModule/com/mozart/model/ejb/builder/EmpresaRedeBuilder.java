package com.mozart.model.ejb.builder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.mozart.model.ejb.entity.CidadeEJB;
import com.mozart.model.ejb.entity.EmpresaEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaRedeEJB;
import com.mozart.model.ejb.entity.GrupoEconomicoEJB;
import com.mozart.model.ejb.entity.PromotorEJB;

public class EmpresaRedeBuilder {

	private String nomeFantasia;
	private String enderecoCobranca;
	private CidadeEJB cidade;
	private String bairro;
	private String cep;
	private String telefone;
	private String telefone2;
	private String contato;
	private String contato2;
	private String credito = "N";
	private String crs = "N";
	private Timestamp dataCadastro;
	private Timestamp dataNascimento;
	private String dataNascimento2;
	private String email;
	private String email2;
	private String fax;
	private Long idEmpresa;
	private GrupoEconomicoEJB grupoEconomico;
	private PromotorEJB promotorEJB;
	private Long idRepresentante;
	private Long idVendedor;
	private Long idHotel;
	private Long idRedeHotel;
	private String internet;
	private String observacao;
	private String particular = "N";
	private String telex;
	private Double valorCredito;
	private EmpresaEJB empresaEJB;
	private EmpresaEJB empresaCorporateEJB;
	private List<EmpresaHotelEJB> empresaHotelEJBList;
	private String issRetido;
	private Double pis;
	private Double inss;
	private Double cofins;
	private Double irRetencao;
	private Double csll;
	private Double outrasRetencoes;
	private Long deadLine = 1l;
	private String noShow = "N";

	public EmpresaRedeEJB build() {
		empresaHotelEJBList = new ArrayList<EmpresaHotelEJB>();
		EmpresaRedeEJB retorno = new EmpresaRedeEJB();
		retorno.setNomeFantasia(nomeFantasia);
		retorno.setEnderecoCobranca(enderecoCobranca);
		retorno.setCidade(cidade);
		retorno.setBairro(bairro);
		retorno.setCep(cep);
		retorno.setTelefone(telefone);
		retorno.setTelefone2(telefone2);
		retorno.setContato(contato);
		retorno.setContato2(contato2);
		retorno.setCredito(credito);
		retorno.setCrs(crs);
		retorno.setDataCadastro(dataCadastro);
		retorno.setDataNascimento(dataNascimento);
		retorno.setDataNascimento2(dataNascimento2);
		retorno.setEmail(email);
		retorno.setEmail2(email2);
		retorno.setFax(fax);
		retorno.setIdEmpresa(idEmpresa);
		retorno.setGrupoEconomico(grupoEconomico);
		retorno.setPromotorEJB(promotorEJB);
		retorno.setIdRepresentante(idRepresentante);
		retorno.setIdVendedor(idVendedor);
		retorno.setIdHotel(idHotel);
		retorno.setIdRedeHotel(idRedeHotel);
		retorno.setInternet(internet);
		retorno.setObservacao(observacao);
		retorno.setParticular(particular);
		retorno.setTelex(telex);
		retorno.setValorCredito(valorCredito);
		retorno.setEmpresaEJB(empresaEJB);
		retorno.setEmpresaCorporateEJB(empresaCorporateEJB);
		retorno.setEmpresaHotelEJBList(empresaHotelEJBList);
		retorno.setIssRetido(issRetido);
		retorno.setPis(pis);
		retorno.setInss(inss);
		retorno.setCofins(cofins);
		retorno.setIrRetencao(irRetencao);
		retorno.setCsll(csll);
		retorno.setOutrasRetencoes(outrasRetencoes);
		retorno.setDeadLine(deadLine);
		retorno.setNoShow(noShow);

		return retorno;
	}

	public EmpresaRedeBuilder nomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
		return this;
	}

	public EmpresaRedeBuilder enderecoCobranca(String enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
		return this;
	}

	public EmpresaRedeBuilder cidade(CidadeEJB cidade) {
		this.cidade = cidade;
		return this;
	}

	public EmpresaRedeBuilder bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public EmpresaRedeBuilder cep(String cep) {
		this.cep = cep;
		return this;
	}

	public EmpresaRedeBuilder telefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public EmpresaRedeBuilder telefone2(String telefone2) {
		this.telefone2 = telefone2;
		return this;
	}

	public EmpresaRedeBuilder contato(String contato) {
		this.contato = contato;
		return this;
	}

	public EmpresaRedeBuilder contato2(String contato2) {
		this.contato2 = contato2;
		return this;
	}

	public EmpresaRedeBuilder credito(String credito) {
		this.credito = credito;
		return this;
	}

	public EmpresaRedeBuilder crs(String crs) {
		this.crs = crs;
		return this;
	}

	public EmpresaRedeBuilder dataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
		return this;
	}

	public EmpresaRedeBuilder dataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public EmpresaRedeBuilder dataNascimento2(String dataNascimento2) {
		this.dataNascimento2 = dataNascimento2;
		return this;
	}

	public EmpresaRedeBuilder email(String email) {
		this.email = email;
		return this;
	}

	public EmpresaRedeBuilder email2(String email2) {
		this.email2 = email2;
		return this;
	}

	public EmpresaRedeBuilder setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public EmpresaRedeBuilder idEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
		return this;
	}

	public EmpresaRedeBuilder grupoEconomico(GrupoEconomicoEJB grupoEconomico) {
		this.grupoEconomico = grupoEconomico;
		return this;
	}

	public EmpresaRedeBuilder promotorEJB(PromotorEJB promotorEJB) {
		this.promotorEJB = promotorEJB;
		return this;
	}

	public EmpresaRedeBuilder idRepresentante(Long idRepresentante) {
		this.idRepresentante = idRepresentante;
		return this;
	}

	public EmpresaRedeBuilder idVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
		return this;
	}

	public EmpresaRedeBuilder idHotel(Long idHotel) {
		this.idHotel = idHotel;
		return this;
	}

	public EmpresaRedeBuilder idRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
		return this;
	}

	public EmpresaRedeBuilder internet(String internet) {
		this.internet = internet;
		return this;
	}

	public EmpresaRedeBuilder observacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public EmpresaRedeBuilder particular(String particular) {
		this.particular = particular;
		return this;
	}

	public EmpresaRedeBuilder telex(String telex) {
		this.telex = telex;
		return this;
	}

	public EmpresaRedeBuilder setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
		return this;
	}

	public EmpresaRedeBuilder empresaEJB(EmpresaEJB empresaEJB) {
		this.empresaEJB = empresaEJB;
		return this;
	}

	public EmpresaRedeBuilder empresaCorporateEJB(EmpresaEJB empresaCorporateEJB) {
		this.empresaCorporateEJB = empresaCorporateEJB;
		return this;
	}

	public EmpresaRedeBuilder empresaHotelEJBList(List<EmpresaHotelEJB> empresaHotelEJBList) {
		this.empresaHotelEJBList = empresaHotelEJBList;
		return this;
	}

	public EmpresaRedeBuilder issRetido(String issRetido) {
		this.issRetido = issRetido;
		return this;
	}

	public EmpresaRedeBuilder pis(Double pis) {
		this.pis = pis;
		return this;
	}

	public EmpresaRedeBuilder inss(Double inss) {
		this.inss = inss;
		return this;
	}

	public EmpresaRedeBuilder cofins(Double cofins) {
		this.cofins = cofins;
		return this;
	}

	public EmpresaRedeBuilder irRetencao(Double irRetencao) {
		this.irRetencao = irRetencao;
		return this;
	}

	public EmpresaRedeBuilder csll(Double csll) {
		this.csll = csll;
		return this;
	}

	public EmpresaRedeBuilder outrasRetencoes(Double outrasRetencoes) {
		this.outrasRetencoes = outrasRetencoes;
		return this;
	}

	public EmpresaRedeBuilder deadLine(Long deadLine) {
		this.deadLine = deadLine;
		return this;
	}

	public EmpresaRedeBuilder noShow(String noShow) {
		this.noShow = noShow;
		return this;
	}

}
