package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class DemonstrativoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7755681020479198418L;
	
	
	private Long idPlanoContas;
	private String contaContabil;
	private String nome;
	private String tipoConta;
	private Long ordem;
	private Long idRedeHotel;
	
	//gravacao
	private String contas;
	private String demonstrativos;
	
	
	public DemonstrativoVO(){
		
	}

	public DemonstrativoVO(Object[] linha){
		if (!MozartUtil.isNull(linha)){
			setLinha(linha);
			idPlanoContas = getLong();
			contaContabil = getString();
			nome = getString();
			tipoConta = getString();
			ordem = getLong();
			idRedeHotel = getLong();
		}
	}

	public Long getIdPlanoContas() {
		return idPlanoContas;
	}

	public void setIdPlanoContas(Long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}

	public String getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getContas() {
		return contas;
	}

	public void setContas(String contas) {
		this.contas = contas;
	}

	public String getDemonstrativos() {
		return demonstrativos;
	}

	public void setDemonstrativos(String demonstrativos) {
		this.demonstrativos = demonstrativos;
	}

}
