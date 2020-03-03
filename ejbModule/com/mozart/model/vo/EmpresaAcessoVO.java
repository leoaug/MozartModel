package com.mozart.model.vo;

import java.util.Date;
import com.mozart.model.vo.filtro.FiltroWeb;

public class EmpresaAcessoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4572035598150799075L;
	
	private FiltroWeb filtroNomeFantasia;
	private FiltroWeb filtroMaster;
	private FiltroWeb filtroNome;
	private FiltroWeb filtroValidade;
	private FiltroWeb filtroAtivo;
	

	private Long idUser;
	private String nome;
	private String username;
	private String email;
	private String master;
	private Date dataValidade;
	private String ativo;
	private String nomeFantasia;
	
	
	public EmpresaAcessoVO(){
		
	}
	
	public EmpresaAcessoVO(Object[] linha){
		setLinha( linha );
		
		idUser = getLong();
		nome = getString();
		username = getString();
		email = getString();
		master = getString();
		dataValidade = getDate();
		ativo = getString();
		nomeFantasia = getString();
	}


	public FiltroWeb getFiltroNomeFantasia() {
		return filtroNomeFantasia;
	}


	public void setFiltroNomeFantasia(FiltroWeb filtroNomeFantasia) {
		this.filtroNomeFantasia = filtroNomeFantasia;
	}


	public FiltroWeb getFiltroMaster() {
		return filtroMaster;
	}


	public void setFiltroMaster(FiltroWeb filtroMaster) {
		this.filtroMaster = filtroMaster;
	}


	public FiltroWeb getFiltroNome() {
		return filtroNome;
	}


	public void setFiltroNome(FiltroWeb filtroNome) {
		this.filtroNome = filtroNome;
	}


	public FiltroWeb getFiltroValidade() {
		return filtroValidade;
	}


	public void setFiltroValidade(FiltroWeb filtroValidade) {
		this.filtroValidade = filtroValidade;
	}


	public FiltroWeb getFiltroAtivo() {
		return filtroAtivo;
	}


	public void setFiltroAtivo(FiltroWeb filtroAtivo) {
		this.filtroAtivo = filtroAtivo;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMaster() {
		return master;
	}


	public void setMaster(String master) {
		this.master = master;
	}


	public Date getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}


	public String getAtivo() {
		return ativo;
	}


	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
