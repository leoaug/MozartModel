package com.mozart.model.vo;



import com.mozart.model.vo.filtro.FiltroWeb;

public class PratoConsumoInternoVO extends MozartVO {
	
	public enum TypeOfPratoConsumoInterno {
	    CONSULTA_PRATO, CONSULTA_VENDA
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* FILTRO */
	private FiltroWeb filtroNomePrato;
	
	private Long idHotel;
	private Long idPontoVenda;
	private Long idUsuarioConsumoInterno;
	private Long idPrato;
	private String nomePrato;
	private String unidade;
	private Double quantidade;
	private Double custo;
	private Double custoTotal;
	private Double venda;
	private Double vendaTotal;
	
	public PratoConsumoInternoVO(){
		filtroNomePrato = new FiltroWeb();
	}	
	
	public PratoConsumoInternoVO (Object[] filtro, TypeOfPratoConsumoInterno tipo) {
		
		if (filtro != null){
			setLinha(filtro);
			switch (tipo) {
            case CONSULTA_PRATO:
				idPrato = getLong();
				nomePrato = getString();
				unidade = getString();  				
			break;
            case CONSULTA_VENDA:
            	idPrato = getLong();
            	custo = getDouble();
            	venda = getDouble();
				break;
			}
		}
	}

	public FiltroWeb getFiltroNomePrato() {
		return filtroNomePrato;
	}

	public void setFiltroNomePrato(FiltroWeb filtroNomePrato) {
		this.filtroNomePrato = filtroNomePrato;
	}

	public Long getIdPontoVenda() {
		return idPontoVenda;
	}

	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public Long getIdUsuarioConsumoInterno() {
		return idUsuarioConsumoInterno;
	}

	public void setIdUsuarioConsumoInterno(Long idUsuarioConsumoInterno) {
		this.idUsuarioConsumoInterno = idUsuarioConsumoInterno;
	}

	public Long getIdPrato() {
		return idPrato;
	}

	public void setIdPrato(Long idPrato) {
		this.idPrato = idPrato;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getVenda() {
		return venda;
	}

	public void setVenda(Double venda) {
		this.venda = venda;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(Double custoTotal) {
		this.custoTotal = custoTotal;
	}

	public Double getVendaTotal() {
		return vendaTotal;
	}

	public void setVendaTotal(Double vendaTotal) {
		this.vendaTotal = vendaTotal;
	}
}