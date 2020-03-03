package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MovimentoRestauranteVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	
	private FiltroWeb nummesa;
	private FiltroWeb nomepontovenda;
	private FiltroWeb nomeprato;
	private FiltroWeb datamovimento;
	private FiltroWeb numnota;
	private FiltroWeb numcomanda;
	
	private String nomePontoVenda;
	private String nomePrato;
	private String numComanda;
	private String nomeGarcon;
	private Long idGarcon;
	private Long numMesa;
	private Long quantidade;
	private String numNota;
	private Double vlPrato;
	private Double vlUnitario;
	private Double vlDesconto;
	private String siglaHotel;
	private Long idMovimentoRestaurante;
	private String flgAlcoolico;
	private Double vlPago;
		
	public MovimentoRestauranteVO(){
		
		nummesa = new FiltroWeb();
		nomepontovenda = new FiltroWeb();
		nomeprato = new FiltroWeb();
		datamovimento = new FiltroWeb();
		numnota = new FiltroWeb();
		numcomanda = new FiltroWeb();
						
	}	
	
	public MovimentoRestauranteVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
			nomePontoVenda = getString();
			nomePrato = getString();
			numMesa = getLong();
			quantidade = getLong();
			numNota = getString();
			vlPrato = getDouble();
			vlUnitario = getDouble();
			vlDesconto = getDouble();
			siglaHotel = getString();
			idMovimentoRestaurante = getLong();
			numComanda = getString();
			idGarcon = getLong();
			nomeGarcon = getString();
		}
		
	}

	

	public FiltroWeb getNummesa() {
		return nummesa;
	}

	public void setNummesa(FiltroWeb nummesa) {
		this.nummesa = nummesa;
	}

	public FiltroWeb getNomepontovenda() {
		return nomepontovenda;
	}

	public void setNomepontovenda(FiltroWeb nomepontovenda) {
		this.nomepontovenda = nomepontovenda;
	}

	public FiltroWeb getNomeprato() {
		return nomeprato;
	}

	public void setNomeprato(FiltroWeb nomeprato) {
		this.nomeprato = nomeprato;
	}

	public FiltroWeb getDatamovimento() {
		return datamovimento;
	}

	public void setDatamovimento(FiltroWeb datamovimento) {
		this.datamovimento = datamovimento;
	}

	public FiltroWeb getNumnota() {
		return numnota;
	}

	public void setNumnota(FiltroWeb numnota) {
		this.numnota = numnota;
	}

	public FiltroWeb getNumcomanda() {
		return numcomanda;
	}

	public void setNumcomanda(FiltroWeb numcomanda) {
		this.numcomanda = numcomanda;
	}

	public String getNomePontoVenda() {
		return nomePontoVenda;
	}

	public void setNomePontoVenda(String nomePontoVenda) {
		this.nomePontoVenda = nomePontoVenda;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public Long getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(Long numMesa) {
		this.numMesa = numMesa;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getNumNota() {
		return numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public Double getVlPrato() {
		return vlPrato;
	}

	public void setVlPrato(Double vlPrato) {
		this.vlPrato = vlPrato;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Double getVlDesconto() {
		return vlDesconto;
	}

	public void setVlDesconto(Double vlDesconto) {
		this.vlDesconto = vlDesconto;
	}

	public String getSiglaHotel() {
		return siglaHotel;
	}

	public void setSiglaHotel(String siglaHotel) {
		this.siglaHotel = siglaHotel;
	}

	public Long getIdMovimentoRestaurante() {
		return idMovimentoRestaurante;
	}

	public void setIdMovimentoRestaurante(Long idMovimentoRestaurante) {
		this.idMovimentoRestaurante = idMovimentoRestaurante;
	}

	public String getFlgAlcoolico() {
		return flgAlcoolico;
	}

	public void setFlgAlcoolico(String flgAlcoolico) {
		this.flgAlcoolico = flgAlcoolico;
	}

	public Double getVlPago() {
		return vlPago;
	}

	public void setVlPago(Double vlPago) {
		this.vlPago = vlPago;
	}

	public String getNumComanda() {
		return numComanda;
	}

	public void setNumComanda(String numComanda) {
		this.numComanda = numComanda;
	}

	public String getNomeGarcon() {
		return nomeGarcon;
	}

	public void setNomeGarcon(String nomeGarcon) {
		this.nomeGarcon = nomeGarcon;
	}

	public Long getIdGarcon() {
		return idGarcon;
	}

	public void setIdGarcon(Long idGarcon) {
		this.idGarcon = idGarcon;
	}
	
	

}
