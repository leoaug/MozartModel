package com.mozart.model.vo;

import java.util.Date;

public class ItemEstoqueVO extends MozartVO{

	private static final long serialVersionUID = -5061773842464588105L;
	
	public enum TypeOfItemEstoque {
	    SAIDA, FICHA_TECNICA, DEVOLUCAO, TRANSFERENCIA, CONSUMO_INTERNO
	}
	
	private Long idItem;
	private Long idHotel;
	private Long idRedeHotel;
	private Long idCentroCusto;
	private String nomeItem;
	private Date dataMovimento;
	private Double vlUnitario;
	private Double vlTotal;
	private Long quantidade;
	private Double quantidadeConsumoInterno;
	
	
	public ItemEstoqueVO(){
	}
	
	public ItemEstoqueVO (Object[] filtro, TypeOfItemEstoque typeOf) {
		if (filtro != null){
			setLinha(filtro);
			 switch (typeOf) {
	            case FICHA_TECNICA:
					idItem = getLong();
					nomeItem = getString();
					dataMovimento = getDate();
					vlUnitario = getDouble();
					break;
	            case SAIDA:
	            	idItem = getLong();
	            	idRedeHotel = getLong();
					vlUnitario = getDouble();
					quantidade = getLong();
					break;
	            case DEVOLUCAO:
					vlUnitario = getDouble();
					idItem = getLong();
					quantidade = getLong();
					break;
	            case TRANSFERENCIA:
	            	idCentroCusto = getLong();
					idItem = getLong();
					quantidade = getLong();
					break;
	            case CONSUMO_INTERNO:
					idItem = getLong();
					quantidadeConsumoInterno = getDouble();
					vlUnitario = getDouble();
					vlTotal = getDouble();
					break;
			 }
		}
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Double getQuantidadeConsumoInterno() {
		return quantidadeConsumoInterno;
	}

	public void setQuantidadeConsumoInterno(Double quantidadeConsumoInterno) {
		this.quantidadeConsumoInterno = quantidadeConsumoInterno;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEstoqueVO other = (ItemEstoqueVO) obj;
		if (idItem == null) {
			if (other.getIdItem() != null)
				return false;
		} else if (!idItem.equals(other.getIdItem()))
			return false;
		return true;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdCentroCusto() {
		return idCentroCusto;
	}

	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	public Double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(Double vlTotal) {
		this.vlTotal = vlTotal;
	}
	
}