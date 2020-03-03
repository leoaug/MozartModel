package com.mozart.model.vo;

import java.util.Date;

@SuppressWarnings("serial")
public class QuantidadeAptoGestaoBloqueioVO extends MozartVO {

	public static final String CAMPO_SEPARADOR = "[[*]]";
	public static final String PREFIXO_PAX = "PAX";

	private Date data;
	private String dsFantasia;
	private Long valor;
	private Double percentual;
	private String diaSemana;
	private Long total;
	private Long totalDia;
	private Double percentDia;

	private Long idReserva;
	private Long idApartamento;
	private Double tarifa;
	private boolean objetoAlterado;

	private String chave;

	public QuantidadeAptoGestaoBloqueioVO() {

	}

	public QuantidadeAptoGestaoBloqueioVO(Object[] objeto) {
		setDados(objeto);
	}

	public void setDados(Object[] objeto) {
		setLinha(objeto);
		
		this.setIdReserva(getLong());
		this.setData(getDate());
		this.setDsFantasia(getString());
		this.setValor(getLong());
		this.setPercentual(getDouble());
		this.setDiaSemana(getString());
		this.setTotal(getLong());
		this.setTotalDia(getLong());
		this.setPercentDia(getDouble());
		this.setObjetoAlterado(false);
	}

	public String getValorChave() {
		String campoSeparador = CAMPO_SEPARADOR;

		String valorChave = idReserva + campoSeparador + data + campoSeparador + dsFantasia
				+ campoSeparador + valor + campoSeparador + percentual
				+ campoSeparador + diaSemana + campoSeparador + total
				+ campoSeparador + totalDia + campoSeparador + percentDia;

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
	
	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Double getPercentDia() {
		return percentDia;
	}

	public void setPercentDia(Double percentDia) {
		this.percentDia = percentDia;
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

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getTotalDia() {
		return totalDia;
	}

	public void setTotalDia(Long totalDia) {
		this.totalDia = totalDia;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Long getIdApartamento() {
		return idApartamento;
	}

	public void setIdApartamento(Long idApartamento) {
		this.idApartamento = idApartamento;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	
}