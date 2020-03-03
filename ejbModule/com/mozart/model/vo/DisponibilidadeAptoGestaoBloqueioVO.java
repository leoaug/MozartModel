package com.mozart.model.vo;

import java.util.Date;

@SuppressWarnings("serial")
public class DisponibilidadeAptoGestaoBloqueioVO extends MozartVO {

	public static final String CAMPO_SEPARADOR = "[[*]]";
	public static final String PREFIXO_PAX = "PAX";

	private Date data;
	private String dsFantasia;
	private Long quantidade;
	private Long idReserva;

	private boolean objetoAlterado;

	private String chave;

	public DisponibilidadeAptoGestaoBloqueioVO() {

	}

	public DisponibilidadeAptoGestaoBloqueioVO(Object[] objeto) {
		setDados(objeto);
	}

	public void setDados(Object[] objeto) {
		setLinha(objeto);

		this.setData(getDate());
		//this.setDsFantasia(getString());
		this.setQuantidade(getLong());
		this.setIdReserva(getLong());
		this.setObjetoAlterado(false);
	}

	public String getValorChave() {
		String campoSeparador = CAMPO_SEPARADOR;

		String valorChave = data 
				//+ campoSeparador + dsFantasia 
				+ campoSeparador + idReserva
				+ campoSeparador + quantidade; 

		return valorChave;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDsFantasia() {
		return dsFantasia;
	}

	public void setDsFantasia(String dsFantasia) {
		this.dsFantasia = dsFantasia;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isObjetoAlterado() {
		return objetoAlterado;
	}

	public void setObjetoAlterado(boolean objetoAlterado) {
		this.objetoAlterado = objetoAlterado;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	
}