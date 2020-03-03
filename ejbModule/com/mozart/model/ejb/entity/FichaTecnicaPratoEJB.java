package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the FICHA_TECNICA_PRATO database table.
 * 
 */
@Entity
@Table(name="FICHA_TECNICA_PRATO")
public class FichaTecnicaPratoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FichaTecnicaPratoEJBPK id;

	private Double quantidade;

	@Column(name="VALOR_TOTAL")
	private Double valorTotal;

	@Column(name="VALOR_UNITARIO")
	private Double valorUnitario;
	
    @ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO", insertable=false, updatable=false),
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable=false, updatable=false)
    })
    private PratoEJB pratoEJB;

    @ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_ITEM", referencedColumnName = "ID_ITEM", insertable=false, updatable=false),
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable=false, updatable=false)
 
    })
    private ItemEstoqueEJB itemEstoqueEJB;

    public FichaTecnicaPratoEJB() {
    }

	public FichaTecnicaPratoEJBPK getId() {
		return this.id;
	}

	public void setId(FichaTecnicaPratoEJBPK id) {
		this.id = id;
	}
	
	public Double getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

	public ItemEstoqueEJB getItemEstoqueEJB() {
		return itemEstoqueEJB;
	}

	public void setItemEstoqueEJB(ItemEstoqueEJB itemEstoqueEJB) {
		this.itemEstoqueEJB = itemEstoqueEJB;
	}

}