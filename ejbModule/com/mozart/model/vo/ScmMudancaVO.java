package com.mozart.model.vo;

import java.sql.Timestamp;

import com.mozart.model.util.MozartUtil;

public class ScmMudancaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1512231066321042720L;

	private Long idMudanca;
	private String dsSistema;
	private String dsTitulo;
	private String dsCaminho;
	private String dsPrioridade;
	private String dsStatus;
	private Timestamp data;
	private String criadaPor;
	private String responsavel;
	
	
	public ScmMudancaVO(){
		
		
	}
	
	public ScmMudancaVO(Object[] linha){
		if (!MozartUtil.isNull( linha )){
			setLinha(linha);
			idMudanca = getLong();
			dsSistema = getString();
			dsTitulo = getString();
			dsCaminho = getString();
			dsPrioridade = getString();
			dsStatus = getString();
			data = getTimestamp();
			criadaPor = getString();
			responsavel = getString();		
		}
	}

	public Long getIdMudanca() {
		return idMudanca;
	}

	public void setIdMudanca(Long idMudanca) {
		this.idMudanca = idMudanca;
	}

	public String getDsSistema() {
		return dsSistema;
	}

	public void setDsSistema(String dsSistema) {
		this.dsSistema = dsSistema;
	}

	public String getDsTitulo() {
		return dsTitulo;
	}

	public void setDsTitulo(String dsTitulo) {
		this.dsTitulo = dsTitulo;
	}

	public String getDsCaminho() {
		return dsCaminho;
	}

	public void setDsCaminho(String dsCaminho) {
		this.dsCaminho = dsCaminho;
	}

	public String getDsPrioridade() {
		return dsPrioridade;
	}

	public void setDsPrioridade(String dsPrioridade) {
		this.dsPrioridade = dsPrioridade;
	}

	public String getDsStatus() {
		return dsStatus;
	}

	public void setDsStatus(String dsStatus) {
		this.dsStatus = dsStatus;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getCriadaPor() {
		return criadaPor;
	}

	public void setCriadaPor(String criadaPor) {
		this.criadaPor = criadaPor;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
}
