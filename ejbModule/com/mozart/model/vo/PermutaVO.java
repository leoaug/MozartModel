package com.mozart.model.vo;

import java.util.Date;
import com.mozart.model.vo.filtro.FiltroWeb;

public class PermutaVO extends MozartVO{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3062445622502117931L;
	
	
	private FiltroWeb filtroEmpresa;
	private FiltroWeb filtroContrato;
	private FiltroWeb filtroDataInicio;
	private FiltroWeb filtroDataFim;
	private FiltroWeb filtroQtdeDiaria;
	private FiltroWeb filtroValorDiaria;


	
	private Long idPermuta;
	private String nomeEmpresa;
	private String descricao;
	private Date dataInicio;
	private Date dataFim;
	private Long qtdeDiaria;
	private Double valorDiaria;
	
	
	public PermutaVO(){}
	
	
	public PermutaVO(Object[] linha){
		setLinha( linha );
		
		idPermuta = getLong();
		nomeEmpresa = getString();
		descricao = getString();
		dataInicio = getDate();
		dataFim = getDate();
		qtdeDiaria = getLong();
		valorDiaria = getDouble();
		sigla = getString();
		
	}
	
	
	public Long getIdPermuta() {
		return idPermuta;
	}
	public void setIdPermuta(Long idPermuta) {
		this.idPermuta = idPermuta;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
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
	public Long getQtdeDiaria() {
		return qtdeDiaria;
	}
	public void setQtdeDiaria(Long qtdeDiaria) {
		this.qtdeDiaria = qtdeDiaria;
	}
	public Double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public FiltroWeb getFiltroEmpresa() {
		return filtroEmpresa;
	}
	public void setFiltroEmpresa(FiltroWeb filtroEmpresa) {
		this.filtroEmpresa = filtroEmpresa;
	}
	public FiltroWeb getFiltroContrato() {
		return filtroContrato;
	}
	public void setFiltroContrato(FiltroWeb filtroContrato) {
		this.filtroContrato = filtroContrato;
	}
	public FiltroWeb getFiltroDataInicio() {
		return filtroDataInicio;
	}
	public void setFiltroDataInicio(FiltroWeb filtroDataInicio) {
		this.filtroDataInicio = filtroDataInicio;
	}
	public FiltroWeb getFiltroDataFim() {
		return filtroDataFim;
	}
	public void setFiltroDataFim(FiltroWeb filtroDataFim) {
		this.filtroDataFim = filtroDataFim;
	}
	public FiltroWeb getFiltroQtdeDiaria() {
		return filtroQtdeDiaria;
	}
	public void setFiltroQtdeDiaria(FiltroWeb filtroQtdeDiaria) {
		this.filtroQtdeDiaria = filtroQtdeDiaria;
	}
	public FiltroWeb getFiltroValorDiaria() {
		return filtroValorDiaria;
	}
	public void setFiltroValorDiaria(FiltroWeb filtroValorDiaria) {
		this.filtroValorDiaria = filtroValorDiaria;
	}

}
