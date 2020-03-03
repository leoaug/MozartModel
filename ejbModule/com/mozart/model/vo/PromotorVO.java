package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class PromotorVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idPromotor;
	private String nomePromotor;
	private Double comissao;
	private String area;
	
	public PromotorVO (){
		
		
	}
	
	public PromotorVO(Object[] linha) {
			
			if (!MozartUtil.isNull(linha)){
				setLinha(linha);
				idPromotor = getLong ();
				nomePromotor = getString ();
				comissao = getDouble();
				area = getString ();
				
		}
	}
	
	
	
	public String getNome() {
		return nomePromotor;
	}
	public void setNome(String nome) {
		this.nomePromotor = nome;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public String getNomePromotor() {
		return nomePromotor;
	}

	public void setNomePromotor(String nomePromotor) {
		this.nomePromotor = nomePromotor;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Long getIdPromotor() {
		return idPromotor;
	}

	public void setIdPromotor(Long idPromotor) {
		this.idPromotor = idPromotor;
	}
	
	
	
}
