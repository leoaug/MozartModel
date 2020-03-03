package com.mozart.model.vo;

import java.util.Date;





public class ComprovanteAjusteVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	
	private Long comprovanteAjuste;
	private Long numeroApartamento;
	private String descricaoLancamento;
	private String nomeFantasia;
	private Date dataLancamento;
	private Date horaLancamento;
	private Double valorLancamento;
	private String numDocumento;
	private String nome;
	
	
	public ComprovanteAjusteVO(){
		
		
		
		
	}
	
	public ComprovanteAjusteVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			comprovanteAjuste = getLong();
			numeroApartamento = getLong();
			descricaoLancamento = getString();
			nomeFantasia = getString();
			dataLancamento = getDate();
			horaLancamento = getDate();
			valorLancamento = getDouble();
			numDocumento = getString();
			nome = getString();
						
		}
		
	}

	public String toString(){
    	
    	return comprovanteAjuste+" - "+numeroApartamento+" - "+numDocumento+" - "+descricaoLancamento ; 

	}


	public Long getComprovanteAjuste() {
		return comprovanteAjuste;
	}



	public void setComprovanteAjuste(Long comprovanteAjuste) {
		this.comprovanteAjuste = comprovanteAjuste;
	}



	
	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}



	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}



	
	public Date getDataLancamento() {
		return dataLancamento;
	}



	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}



	public Date getHoraLancamento() {
		return horaLancamento;
	}



	public void setHoraLancamento(Date horaLancamento) {
		this.horaLancamento = horaLancamento;
	}



	public String getNumDocumento() {
		return numDocumento;
	}



	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(Long numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	
	
	
}
