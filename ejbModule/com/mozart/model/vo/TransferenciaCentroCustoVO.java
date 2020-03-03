package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class TransferenciaCentroCustoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb DescricaoCentroCusto;
	private FiltroWeb DataMovimento;
	private FiltroWeb NomeItem;
	private FiltroWeb NumDocumento;
	
	private String nomeItemDesc;
	private String descricaoCentroCustoDesc;
	private Date dataMovimentoDesc;
	private String numDocumentoDesc;
	private String tipoDocumento;
	private String tipoMovimento;
	private long quantidade;
	private Double valorUnitario;
	private Double valorTotal;
	private String sigla;
	private long idMovimentoEstoque;
	
	public TransferenciaCentroCustoVO(){
		
		DescricaoCentroCusto = new FiltroWeb();
		DataMovimento = new FiltroWeb();
		NomeItem = new FiltroWeb();
		NumDocumento = new FiltroWeb();
	}	
	
	public TransferenciaCentroCustoVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			nomeItemDesc = getString();
			descricaoCentroCustoDesc = getString();
			dataMovimentoDesc = getDate();
			tipoMovimento = getString();
			numDocumentoDesc = getString();
			tipoDocumento = getString();
			quantidade = getLong();
			valorUnitario = getDouble();
			valorTotal = getDouble();
			sigla = getString();
			idMovimentoEstoque = getLong();
		}
		
	}

	public FiltroWeb getDescricaoCentroCusto() {
		return DescricaoCentroCusto;
	}

	public void setDescricaoCentroCusto(FiltroWeb descricaoCentroCusto) {
		DescricaoCentroCusto = descricaoCentroCusto;
	}

	public FiltroWeb getDataMovimento() {
		return DataMovimento;
	}

	public void setDataMovimento(FiltroWeb dataMovimento) {
		DataMovimento = dataMovimento;
	}

	public FiltroWeb getNomeItem() {
		return NomeItem;
	}

	public void setNomeItem(FiltroWeb nomeItem) {
		NomeItem = nomeItem;
	}

	public FiltroWeb getNumDocumento() {
		return NumDocumento;
	}

	public void setNumDocumento(FiltroWeb numDocumento) {
		NumDocumento = numDocumento;
	}

	public String getNomeItemDesc() {
		return nomeItemDesc;
	}

	public void setNomeItemDesc(String nomeItemDesc) {
		this.nomeItemDesc = nomeItemDesc;
	}

	public String getDescricaoCentroCustoDesc() {
		return descricaoCentroCustoDesc;
	}

	public void setDescricaoCentroCustoDesc(String descricaoCentroCustoDesc) {
		this.descricaoCentroCustoDesc = descricaoCentroCustoDesc;
	}

	public Date getDataMovimentoDesc() {
		return dataMovimentoDesc;
	}

	public void setDataMovimentoDesc(Date dataMovimentoDesc) {
		this.dataMovimentoDesc = dataMovimentoDesc;
	}

	public String getNumDocumentoDesc() {
		return numDocumentoDesc;
	}

	public void setNumDocumentoDesc(String numDocumentoDesc) {
		this.numDocumentoDesc = numDocumentoDesc;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public long getIdMovimentoEstoque() {
		return idMovimentoEstoque;
	}

	public void setIdMovimentoEstoque(long idMovimentoEstoque) {
		this.idMovimentoEstoque = idMovimentoEstoque;
	}
}
