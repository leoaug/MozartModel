package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class AjustePdvVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb DataMovimento;
	private FiltroWeb NomeItem;
	private FiltroWeb CentroCusto;
	private FiltroWeb TipoMovimento;
	
	private Date data;
	private String centroCustoDesc;
	private String nomeItemDesc;
	private String tipoMovimentoDesc;
	private String movimento;
	private String numDocumento;
	private String tipoDocumento;
	private Double quantidade;
	private String motivo;
	private long codMovimento;
	
	public AjustePdvVO(){
		
		DataMovimento = new FiltroWeb();
		NomeItem = new FiltroWeb();
		CentroCusto = new FiltroWeb();
		TipoMovimento = new FiltroWeb();
	}	
	
	public AjustePdvVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			data = getDate();
			centroCustoDesc = getString();
			nomeItemDesc = getString();
			tipoMovimentoDesc = getString();
			movimento = getString();
			numDocumento = getString();
			tipoDocumento = getString();
			quantidade = getDouble();
			motivo = getString();
			codMovimento = getLong();
		}
		
	}

	public FiltroWeb getDataMovimento() {
		return DataMovimento;
	}

	public void setDataMovimento(FiltroWeb dataMovimento) {
		this.DataMovimento = dataMovimento;
	}

	public FiltroWeb getNomeItem() {
		return NomeItem;
	}

	public void setNomeItem(FiltroWeb nomeItem) {
		NomeItem = nomeItem;
	}

	public FiltroWeb getCentroCusto() {
		return CentroCusto;
	}

	public void setCentroCusto(FiltroWeb centroCusto) {
		CentroCusto = centroCusto;
	}

	public FiltroWeb getTipoMovimento() {
		return TipoMovimento;
	}

	public void setTipoMovimento(FiltroWeb tipoMovimento) {
		TipoMovimento = tipoMovimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCentroCustoDesc() {
		return centroCustoDesc;
	}

	public void setCentroCustoDesc(String centroCustoDesc) {
		this.centroCustoDesc = centroCustoDesc;
	}

	public String getNomeItemDesc() {
		return nomeItemDesc;
	}

	public void setNomeItemDesc(String nomeItemDesc) {
		this.nomeItemDesc = nomeItemDesc;
	}

	public String getTipoMovimentoDesc() {
		return tipoMovimentoDesc;
	}

	public void setTipoMovimentoDesc(String tipoMovimentoDesc) {
		this.tipoMovimentoDesc = tipoMovimentoDesc;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public long getCodMovimento() {
		return codMovimento;
	}

	public void setCodMovimento(long codMovimento) {
		this.codMovimento = codMovimento;
	}
}
