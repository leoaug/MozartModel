package com.mozart.model.ejb.entity;

import com.mozart.model.util.MozartUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FORNECEDOR_REDE")
@IdClass(FornecedorRedeEJBPK.class)
@SuppressWarnings("unchecked")
public class FornecedorRedeEJB extends MozartEntity {
	private static final long serialVersionUID = 4990595408427208718L;
	@Id
	@Column(name = "ID_FORNECEDOR")
	private Long idFornecedor;
	@Id
	@Column(name = "ID_REDE_HOTEL")
	private Long idRedeHotel;
	@Column(name = "CONTAS_PAGAR")
	private String contasPagar;
	@Column(name = "CONTATO")
	private String contato;
	@Column(name = "E_MAIL_1")
	private String email1;
	@Column(name = "E_MAIL_2")
	private String email2;
	@Column(name = "E_MAIL_3")
	private String email3;
	private String fax;
	@OneToOne(cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_BANCO", referencedColumnName = "ID_BANCO")
	private BancoEJB bancoEJB;
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;
	private String pis;
	@Column(name = "TELEFONE_1")
	private String telefone1;
	@Column(name = "TELEFONE_2")
	private String telefone2;
	@Column(name = "TELEFONE_3")
	private String telefone3;
	@OneToMany(mappedBy = "fornecedorRedeEJB", cascade = {
			javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<FornecedorHotelEJB> fornecedorHotelEJBList;
	@OneToOne(cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_FORNECEDOR_GRUPO", referencedColumnName = "ID_FORNECEDOR_GRUPO")
	private FornecedorGrupoEJB fornecedorGrupo;

	public String getContasPagar() {
		return this.contasPagar;
	}

	public void setContasPagar(String contasPagar) {
		this.contasPagar = contasPagar;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getPis() {
		return this.pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
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

	public String getTelefone3() {
		return this.telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Long getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
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

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return this.email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public List<FornecedorHotelEJB> getFornecedorHotelEJBList() {
		return this.fornecedorHotelEJBList;
	}

	public void setFornecedorHotelEJBList(
			List<FornecedorHotelEJB> fornecedorHotelEJBList) {
		this.fornecedorHotelEJBList = fornecedorHotelEJBList;
	}

	public FornecedorGrupoEJB getFornecedorGrupo() {
		return this.fornecedorGrupo;
	}

	public void setFornecedorGrupo(FornecedorGrupoEJB fornecedorGrupo) {
		this.fornecedorGrupo = fornecedorGrupo;
	}

	public void addFornecedorHotelEJB(FornecedorHotelEJB fornecedorHotel) {
		if (MozartUtil.isNull(this.fornecedorHotelEJBList)) {
			this.fornecedorHotelEJBList = new ArrayList();
		}
		fornecedorHotel.setFornecedorRedeEJB(this);
		this.fornecedorHotelEJBList.add(fornecedorHotel);
	}

	public BancoEJB getBancoEJB() {
		return this.bancoEJB;
	}

	public void setBancoEJB(BancoEJB bancoEJB) {
		this.bancoEJB = bancoEJB;
	}
}