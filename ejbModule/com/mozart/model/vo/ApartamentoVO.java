package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;
import java.util.Date;

public class ApartamentoVO extends MozartVO {
	private static final long serialVersionUID = 356154908949060049L;
	private FiltroWeb filtroNumApto;
	private FiltroWeb filtroStatus;
	private FiltroWeb filtroArea;
	private FiltroWeb filtroCaracteristica;
	private FiltroWeb filtroCofan;
	private FiltroWeb filtroTipoApto;
	private Long bcIdApartamento;
	private Long bcIdHotel;
	private Long bcIdTipoApartamento;
	private Long bcNumApartamento;
	private String bcAerea;
	private String bcStatus;
	private String bcCofan;
	private Date bcDataEntrada;
	private Date bcDataSaida;
	private String bcObservacao;
	private String bcDepositoAntecipado;
	private String bcCaracteristica;
	private Long bcIdCamareira;
	private String bcCheckout;
	private String bcBloco;
	private Long idReserva;
	private boolean ocupacao;
	private Long idCheckin;

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return this.bcIdApartamento.equals(((ApartamentoVO) obj)
				.getBcIdApartamento());
	}

	public void setaDados(Object[] pLinha) {
		setLinha(pLinha);
		this.bcIdApartamento = getLong();
		this.bcIdHotel = getLong();
		this.bcIdTipoApartamento = getLong();
		this.bcNumApartamento = getLong();
		this.bcAerea = getString();
		this.bcStatus = getString();
		this.bcCofan = getString();
		this.bcDataEntrada = getDate();
		this.bcDataSaida = getDate();
		this.bcObservacao = getString();
		this.bcDepositoAntecipado = getString();
		this.bcCaracteristica = getString();
		this.bcIdCamareira = getLong();
		this.bcCheckout = getString();
		this.ocupacao = (getLong().intValue() == 1);
	}

	public ApartamentoVO() {
		this.filtroNumApto = new FiltroWeb();
		this.filtroStatus = new FiltroWeb();
		this.filtroArea = new FiltroWeb();
		this.filtroCaracteristica = new FiltroWeb();
		this.filtroCofan = new FiltroWeb();
		this.filtroTipoApto = new FiltroWeb();
	}

	public void setBcIdApartamento(Long bcIdApartamento) {
		this.bcIdApartamento = bcIdApartamento;
	}

	public Long getBcIdApartamento() {
		return this.bcIdApartamento;
	}

	public void setBcIdHotel(Long bcIdHotel) {
		this.bcIdHotel = bcIdHotel;
	}

	public Long getBcIdHotel() {
		return this.bcIdHotel;
	}

	public void setBcIdTipoApartamento(Long bcIdTipoApartamento) {
		this.bcIdTipoApartamento = bcIdTipoApartamento;
	}

	public Long getBcIdTipoApartamento() {
		return this.bcIdTipoApartamento;
	}

	public void setBcNumApartamento(Long bcNumApartamento) {
		this.bcNumApartamento = bcNumApartamento;
	}

	public Long getBcNumApartamento() {
		return this.bcNumApartamento;
	}

	public void setBcAerea(String bcAerea) {
		this.bcAerea = bcAerea;
	}

	public String getBcAerea() {
		return this.bcAerea;
	}

	public void setBcStatus(String bcStatus) {
		this.bcStatus = bcStatus;
	}

	public String getBcStatus() {
		return this.bcStatus;
	}

	public void setBcCofan(String bcCofan) {
		this.bcCofan = bcCofan;
	}

	public String getBcCofan() {
		return this.bcCofan;
	}

	public void setBcDataEntrada(Date bcDataEntrada) {
		this.bcDataEntrada = bcDataEntrada;
	}

	public Date getBcDataEntrada() {
		return this.bcDataEntrada;
	}

	public void setBcDataSaida(Date bcDataSaida) {
		this.bcDataSaida = bcDataSaida;
	}

	public Date getBcDataSaida() {
		return this.bcDataSaida;
	}

	public void setBcObservacao(String bcObservacao) {
		this.bcObservacao = bcObservacao;
	}

	public String getBcObservacao() {
		return this.bcObservacao;
	}

	public void setBcDepositoAntecipado(String bcDepositoAntecipado) {
		this.bcDepositoAntecipado = bcDepositoAntecipado;
	}

	public String getBcDepositoAntecipado() {
		return this.bcDepositoAntecipado;
	}

	public void setBcCaracteristica(String bcCaracteristica) {
		this.bcCaracteristica = bcCaracteristica;
	}

	public String getBcCaracteristica() {
		return this.bcCaracteristica;
	}

	public void setBcIdCamareira(Long bcIdCamareira) {
		this.bcIdCamareira = bcIdCamareira;
	}

	public Long getBcIdCamareira() {
		return this.bcIdCamareira;
	}

	public void setBcCheckout(String bcCheckout) {
		this.bcCheckout = bcCheckout;
	}

	public String getBcCheckout() {
		return this.bcCheckout;
	}

	public void setBcBloco(String bcBloco) {
		this.bcBloco = bcBloco;
	}

	public String getBcBloco() {
		return this.bcBloco;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Long getIdReserva() {
		return this.idReserva;
	}

	public String getNumApartamentoStatus() {
		return this.bcNumApartamento + " ";
	}

	public FiltroWeb getFiltroNumApto() {
		return this.filtroNumApto;
	}

	public void setFiltroNumApto(FiltroWeb filtroNumApto) {
		this.filtroNumApto = filtroNumApto;
	}

	public FiltroWeb getFiltroStatus() {
		return this.filtroStatus;
	}

	public void setFiltroStatus(FiltroWeb filtroStatus) {
		this.filtroStatus = filtroStatus;
	}

	public FiltroWeb getFiltroArea() {
		return this.filtroArea;
	}

	public void setFiltroArea(FiltroWeb filtroArea) {
		this.filtroArea = filtroArea;
	}

	public FiltroWeb getFiltroCaracteristica() {
		return this.filtroCaracteristica;
	}

	public void setFiltroCaracteristica(FiltroWeb filtroCaracteristica) {
		this.filtroCaracteristica = filtroCaracteristica;
	}

	public FiltroWeb getFiltroCofan() {
		return this.filtroCofan;
	}

	public void setFiltroCofan(FiltroWeb filtroCofan) {
		this.filtroCofan = filtroCofan;
	}

	public FiltroWeb getFiltroTipoApto() {
		return this.filtroTipoApto;
	}

	public void setFiltroTipoApto(FiltroWeb filtroTipoApto) {
		this.filtroTipoApto = filtroTipoApto;
	}

	public boolean isOcupacao() {
		return this.ocupacao;
	}

	public void setOcupacao(boolean ocupacao) {
		this.ocupacao = ocupacao;
	}

	public Long getIdCheckin() {
		return this.idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}
}