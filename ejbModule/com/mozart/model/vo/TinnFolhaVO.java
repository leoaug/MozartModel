package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.util.MozartUtil;

public class TinnFolhaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2268668921556850409L;
	
	private Long id;
	private Long tipo;
	private Long idHotel;
	private String contaContabil;
	private Long idCentroCusto;
	private Long idFornecedor;
	private Long idContaDebito;
	private Long idContaCredito;
	private String documento;
	private String debitoCredito;
	private Date dataDocumento;
	private Double valor;
	
	
	public TinnFolhaVO(){
		
		
	}
	
	public TinnFolhaVO(String linha){
		
		if (!MozartUtil.isNull(linha)){
			String[] colunas = linha.split("@");
			int x = 0;
			tipo 	= new Long(colunas[x++]);
			idHotel = new Long(colunas[x++]);
			contaContabil = colunas[x++];
			idCentroCusto = colunas[x++]!=null?new Long(colunas[x-1]):null;
			if (tipo.equals(new Long(1))){
				idFornecedor = colunas[x++]!=null?new Long(colunas[x-1]):null;
				idContaDebito = colunas[x++]!=null?new Long(colunas[x-1]):null;
				idContaCredito = colunas[x++]!=null?new Long(colunas[x-1]):null;
			}
			documento = colunas[x++];
			dataDocumento = MozartUtil.toTimestamp(colunas[x++]);
			debitoCredito= colunas[x++];
			valor = MozartUtil.toDouble( colunas[x++]);
		}
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	public String getContaContabil() {
		return contaContabil;
	}


	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}


	public Long getIdCentroCusto() {
		return idCentroCusto;
	}


	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}


	public Long getIdFornecedor() {
		return idFornecedor;
	}


	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}


	public Long getIdContaDebito() {
		return idContaDebito;
	}


	public void setIdContaDebito(Long idContaDebito) {
		this.idContaDebito = idContaDebito;
	}


	public Long getIdContaCredito() {
		return idContaCredito;
	}


	public void setIdContaCredito(Long idContaCredito) {
		this.idContaCredito = idContaCredito;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getDebitoCredito() {
		return debitoCredito;
	}


	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	

}
