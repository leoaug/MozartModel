package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import java.util.Date;

public class ChartApartamentoVO extends MozartVO {
	private static final long serialVersionUID = 6816015714792652911L;
	private Date dataInicio;
	private Date dataFim;
	private Long idApartamento;
	private Long numApartamento;
	private Long idTipoApartamento;
	private String tipoApartamento;
	private String observacao;
	private Date dia;
	private Long status;

	public ChartApartamentoVO() {
	}

	public ChartApartamentoVO(Object[] linha) {
		if (linha != null) {
			setLinha(linha);
			this.idApartamento = getLong();
			this.numApartamento = getLong();
			this.dia = getDate();
			this.status = getLong();
			this.observacao = getString();
			this.idTipoApartamento = getLong();
			this.tipoApartamento = getString();
		}
	}

	public boolean isFinalSemana() {
		return MozartUtil.isFinalSemana(this.dia);
	}

	public Long getIdApartamento() {
		return this.idApartamento;
	}

	public void setIdApartamento(Long idApartamento) {
		this.idApartamento = idApartamento;
	}

	public Long getNumApartamento() {
		return this.numApartamento;
	}

	public void setNumApartamento(Long numApartamento) {
		this.numApartamento = numApartamento;
	}

	public Date getDia() {
		return this.dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Long getIdTipoApartamento() {
		return this.idTipoApartamento;
	}

	public void setIdTipoApartamento(Long idTipoApartamento) {
		this.idTipoApartamento = idTipoApartamento;
	}

	public String getTipoApartamento() {
		return this.tipoApartamento;
	}

	public void setTipoApartamento(String tipoApartamento) {
		this.tipoApartamento = tipoApartamento;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}