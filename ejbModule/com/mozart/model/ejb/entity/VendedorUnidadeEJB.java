package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the VENDEDOR_UNIDADE database table.
 * 
 */
@Entity
@Table(name="VENDEDOR_UNIDADE")
@IdClass(VendedorUnidadeEJBPK.class)
@NamedQueries({
	@NamedQuery(name="VendedorUnidadeEJB.findPorIdVendedorEIdHotel", 
			query="SELECT f from VendedorUnidadeEJB f WHERE f.idHotel = :idHotel and f.idVendedor = :idVendedor and f.idRedeHotel = :idRedeHotel")
})
public class VendedorUnidadeEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_VENDEDOR", insertable = false, updatable = false)
	private Long idVendedor;
	
	@Id
	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	@Id
	@Column(name="ID_REDE_HOTEL", insertable = false, updatable = false)
	private Long idRedeHotel;

	@Column(name="PRAZO_PAGAMENTO")
	private Long prazo;

	@Column(name="COMISSAO")
	private Double comissao;

	
	@OneToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_VENDEDOR", referencedColumnName = "ID_VENDEDOR"),
    @JoinColumn(name = "ID_REDE_HOTEL", referencedColumnName = "ID_REDE_HOTEL")
    })
    private VendedorRedeEJB vendedorRedeEJB;
	
    public VendedorUnidadeEJB() {
    }

	public Long getPrazo() {
		return this.prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public VendedorRedeEJB getVendedorRedeEJB() {
		return vendedorRedeEJB;
	}

	public void setVendedorRedeEJB(VendedorRedeEJB vendedorRedeEJB) {
		this.vendedorRedeEJB = vendedorRedeEJB;
	}

}