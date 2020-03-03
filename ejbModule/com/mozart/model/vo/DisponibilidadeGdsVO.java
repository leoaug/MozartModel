package com.mozart.model.vo;

import java.io.Serializable;
import java.util.Date;

public class DisponibilidadeGdsVO implements Serializable {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 7414094566323680476L;
	private Date dataInicio;
	private Date dataFim;
	private Date dataDisponibilidade;
	private Integer idRede;
	private Integer idHotel;
	private Integer totalDisponibilidade;
	private String tipoQuarto;
	private Integer idGds;

	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Date getDataDisponibilidade() {
		return dataDisponibilidade;
	}
	public void setDataDisponibilidade(Date dataDisponibilidade) {
		this.dataDisponibilidade = dataDisponibilidade;
	}
	public Integer getIdRede() {
		return idRede;
	}
	public void setIdRede(Integer idRede) {
		this.idRede = idRede;
	}
	public Integer getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}
	public Integer getTotalDisponibilidade() {
		return totalDisponibilidade;
	}
	public void setTotalDisponibilidade(Integer totalDisponibilidade) {
		this.totalDisponibilidade = totalDisponibilidade;
	}
	public String getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public Integer getIdGds() {
		return idGds;
	}
	public void setIdGds(Integer idGds) {
		this.idGds = idGds;
	}
	
	
}
