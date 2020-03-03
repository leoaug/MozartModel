package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VENDEDOR_REDE")
@IdClass(VendedorRedeEJBPK.class)
@SuppressWarnings("unchecked")
public class VendedorRedeEJB extends MozartEntity {
	private static final long serialVersionUID = 4990595408427208718L;
	
	@Id
	@Column(name = "ID_VENDEDOR")
	private Long idVendedor;
	
	@Id
	@Column(name = "ID_REDE_HOTEL")
	private Long idRedeHotel;
	
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name = "CONTATO")
	private String contato;
	
	@Column(name = "TELEFONE_1")
	private String telefone1;
	
	@Column(name = "TELEFONE_2")
	private String telefone2;
	
	@Column(name = "TELEFONE_3")
	private String telefone3;
	
	@Column(name = "E_MAIL_1")
	private String email1;
	
	@Column(name = "E_MAIL_2")
	private String email2;
	
	@Column(name = "E_MAIL_3")
	private String email3;
	
	@Column(name = "NUM_AGENCIA")
	private Long numAgencia;
	
	@Column(name = "DIGITO_AGENCIA")
	private Long digitoAgencia;
	
	@Column(name = "NUM_CONTA_CORRENTE")
	private Long numContaCorrente;
	
	@Column(name = "DIGITO_CONTA")
	private Long digitoContaCorrente;
	
	@OneToOne(cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_BANCO", referencedColumnName = "ID_BANCO")
	private BancoEJB bancoEJB;
	
	@OneToOne(mappedBy = "vendedorRedeEJB", cascade = {
			javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private VendedorUnidadeEJB vendedorUnidadeEJB;
	
	@OneToOne(cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_FORNECEDOR_GRUPO", referencedColumnName = "ID_FORNECEDOR_GRUPO")
	private FornecedorGrupoEJB fornecedorGrupo;

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public BancoEJB getBancoEJB() {
		return this.bancoEJB;
	}

	public void setBancoEJB(BancoEJB bancoEJB) {
		this.bancoEJB = bancoEJB;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Long getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(Long numAgencia) {
		this.numAgencia = numAgencia;
	}

	public Long getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(Long digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public Long getNumContaCorrente() {
		return numContaCorrente;
	}

	public void setNumContaCorrente(Long numContaCorrente) {
		this.numContaCorrente = numContaCorrente;
	}

	public Long getDigitoContaCorrente() {
		return digitoContaCorrente;
	}

	public void setDigitoContaCorrente(Long digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}
	
	public FornecedorGrupoEJB getFornecedorGrupo() {
		return fornecedorGrupo;
	}

	public void setFornecedorGrupo(FornecedorGrupoEJB fornecedorGrupo) {
		this.fornecedorGrupo = fornecedorGrupo;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public VendedorUnidadeEJB getVendedorUnidadeEJB() {
		return vendedorUnidadeEJB;
	}

	public void setVendedorUnidadeEJB(VendedorUnidadeEJB vendedorUnidadeEJB) {
		this.vendedorUnidadeEJB = vendedorUnidadeEJB;
	}
}