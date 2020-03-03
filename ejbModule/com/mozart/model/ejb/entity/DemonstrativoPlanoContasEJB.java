package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEMONSTRATIVO_PLANO_CONTAS")
@IdClass(DemonstrativoPlanoContasEJBPK.class)
public class DemonstrativoPlanoContasEJB extends MozartEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4980061184182373302L;

	@Id
	@Column(name="ID_PLANO_CONTAS", nullable=false, insertable=false, updatable=false)
	private long idPlanoContas;

	@Id
	@Column(name="ID_REDE_HOTEL", nullable=false, insertable=false, updatable=false)
	private long idRedeHotel;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="ID_PLANO_CONTAS", name="ID_PLANO_CONTAS", nullable=false)
	private PlanoContaEJB planoConta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="ID_REDE_HOTEL", name="ID_REDE_HOTEL", nullable=false)
	private RedeHotelEJB redeHotel;
	
	@Column(name="NOME_CONTA")
	private String nomeConta;
	
	@Column(name="CONTA_CONTABIL")
	private String contaContabil;

	@Column(name="TIPO_CONTA")
	private String tipoConta;
	
	
	public DemonstrativoPlanoContasEJB() {
		
		
	}


	public long getIdPlanoContas() {
		return idPlanoContas;
	}


	public void setIdPlanoContas(long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}


	public long getIdRedeHotel() {
		return idRedeHotel;
	}


	public void setIdRedeHotel(long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}


	public PlanoContaEJB getPlanoConta() {
		return planoConta;
	}


	public void setPlanoConta(PlanoContaEJB planoConta) {
		this.planoConta = planoConta;
	}


	public RedeHotelEJB getRedeHotel() {
		return redeHotel;
	}


	public void setRedeHotel(RedeHotelEJB redeHotel) {
		this.redeHotel = redeHotel;
	}


	public String getNomeConta() {
		return nomeConta;
	}


	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}


	public String getContaContabil() {
		return contaContabil;
	}


	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}


	public String getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	
	
}
