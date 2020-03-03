package com.mozart.model.vo;

import java.util.Date;

@SuppressWarnings("serial")
public class TarifaApartamentoGestaoBloqueioVO extends MozartVO {

	public static final String CAMPO_SEPARADOR = "[[*]]";
	public static final String PREFIXO_PAX = "PAX";

	private Long idEmpresa;
	private Long idTarifa;
	private Long idMoeda;
	private Date dtEntrada;
	private Date dtSaida;
	private String dsFantasia;
	private String pax;
	private Double valor;
	private Long idHotel;
	private Long idTipoApartamento;
	private Long idReservaApartamento;
	private Long idReservaApartamentoDiaria;
	private String tipo;

	private boolean objetoAlterado;

	private String chave;

	public TarifaApartamentoGestaoBloqueioVO() {

	}

	public TarifaApartamentoGestaoBloqueioVO(Object[] objeto) {
		setDados(objeto);
	}

	public void setDados(Object[] objeto) {
		setLinha(objeto);

		this.setIdEmpresa(getLong());
		this.setIdTarifa(getLong());
		this.setIdMoeda(getLong());
		this.setDtEntrada(getDate());
		this.setDtSaida(getDate());
		this.setDsFantasia(getString());
		this.setPax(getString());
		this.setValor(getDouble());
		this.setIdHotel(getLong());
		this.setIdTipoApartamento(getLong());
		this.setTipo(getString());
		this.setIdReservaApartamento(getLong());
		this.setIdReservaApartamentoDiaria(getLong());
		this.setObjetoAlterado(false);
	}

	public String getValorChave() {
		String campoSeparador = CAMPO_SEPARADOR;

		String valorChave = idEmpresa + campoSeparador + idTarifa
				+ campoSeparador + idMoeda + campoSeparador + dsFantasia
				+ campoSeparador + pax + campoSeparador + valor
				+ campoSeparador + idHotel + campoSeparador + idTipoApartamento
				+ campoSeparador + tipo + campoSeparador + dtEntrada
				+ campoSeparador + dtSaida
				+ campoSeparador + idReservaApartamento
				+ campoSeparador + idReservaApartamentoDiaria;

		return valorChave;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public Long getIdMoeda() {
		return idMoeda;
	}

	public void setIdMoeda(Long idMoeda) {
		this.idMoeda = idMoeda;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public String getDsFantasia() {
		return dsFantasia;
	}

	public void setDsFantasia(String dsFantasia) {
		this.dsFantasia = dsFantasia;
	}

	public String getPax() {
		return pax;
	}

	public void setPax(String pax) {
		this.pax = pax;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdTipoApartamento() {
		return idTipoApartamento;
	}

	public void setIdTipoApartamento(Long idTipoApartamento) {
		this.idTipoApartamento = idTipoApartamento;
	}

	public Long getIdReservaApartamento() {
		return idReservaApartamento;
	}

	public void setIdReservaApartamento(Long idReservaApartamento) {
		this.idReservaApartamento = idReservaApartamento;
	}

	public Long getIdReservaApartamentoDiaria() {
		return idReservaApartamentoDiaria;
	}

	public void setIdReservaApartamentoDiaria(Long idReservaApartamentoDiaria) {
		this.idReservaApartamentoDiaria = idReservaApartamentoDiaria;
	}
	
	

}