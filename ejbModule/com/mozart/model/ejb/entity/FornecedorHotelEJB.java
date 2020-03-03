package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the FORNECEDOR_HOTEL database table.
 * 
 */
@Entity
@Table(name="FORNECEDOR_HOTEL")
@IdClass(FornecedorHotelEJBPK.class)
@NamedQueries({
	@NamedQuery(name="FornecedorHotelEJB.findPorIdhoteANDLikeNomeFantasiaFornecedorRede", 
			query="SELECT f from FornecedorHotelEJB f WHERE f.idHotel = :idHotel and  f.fornecedorRedeEJB.nomeFantasia like :likeNomeFantasia ORDER BY f.fornecedorRedeEJB.nomeFantasia")
})
public class FornecedorHotelEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FORNECEDOR", insertable = false, updatable = false)
	private Long idFornecedor;
	
	@Id
	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="CONTAS_PAGAR")
	private String contasPagar;

	private Long prazo;

	@Column(name="PRAZO_ENTREGA")
	private Long prazoEntrega;

	
	@ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR"),
    @JoinColumn(name = "ID_REDE_HOTEL", referencedColumnName = "ID_REDE_HOTEL")
    })
    private FornecedorRedeEJB fornecedorRedeEJB;
	
    public FornecedorHotelEJB() {
    }

	public String getContasPagar() {
		return this.contasPagar;
	}

	public void setContasPagar(String contasPagar) {
		this.contasPagar = contasPagar;
	}

	public Long getPrazo() {
		return this.prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public Long getPrazoEntrega() {
		return this.prazoEntrega;
	}

	public void setPrazoEntrega(Long prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public FornecedorRedeEJB getFornecedorRedeEJB() {
		return fornecedorRedeEJB;
	}

	public void setFornecedorRedeEJB(FornecedorRedeEJB fornecedorRedeEJB) {
		this.fornecedorRedeEJB = fornecedorRedeEJB;
	}

}