package com.mozart.model.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.mozart.model.vo.ItemEstoqueVO.TypeOfItemEstoque;
import com.mozart.model.vo.filtro.FiltroWeb;

public class ConsumoInternoVO extends MozartVO {

	public enum TypeOfConsumoInterno {
	    CONSULTA, COMBO_USUARIO, COMBO_PONTO_VENDA, DETALHE_PONTO_VENDA
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb dataMovimento;
	private FiltroWeb Nome;
	private FiltroWeb PontoVenda;
	private FiltroWeb hotel;
	
	private long idUsuario;
	private String nomeUsuario;
	private Date data;
	private Date dataPontoVenda;
	private long idPontoVenda;
	private String pontoVendaDesc;
	private long idPrato;
	private String prato;
	private String numDocumento;
	private Double quantidade;
	private Double custo;
	private Double custoTotal;
	private Double venda;
	private Double vendaTotal;
	private Double percentualCusto;
	private String sigla;
	private String pensao;
	private String tipoPensao;
	private String unidade;
	private long codMovimento;
	
	public ConsumoInternoVO(){
		
		dataMovimento = new FiltroWeb();
		PontoVenda = new FiltroWeb();
		Nome = new FiltroWeb();
		hotel = new FiltroWeb();
	}	
	
	public ConsumoInternoVO(Object[] filtro, TypeOfConsumoInterno typeOf) {
		
		if (filtro != null){
			setLinha(filtro);
			switch (typeOf) {
            case CONSULTA:
            	nomeUsuario = getString();
    			data = getDate();
    			pontoVendaDesc = getString();
    			prato = getString();
    			numDocumento = getString();
    			quantidade = getDouble();
    			custo = getDouble();
    			venda = getDouble();
    			custoTotal = getDouble();
    			vendaTotal = getDouble();
    			percentualCusto = getDouble();
    			sigla = getString();
    			codMovimento = getLong();
				break;
            case COMBO_USUARIO:
            	idUsuario = getLong();
            	nomeUsuario = getString();
				break;
            case COMBO_PONTO_VENDA:
            	idPontoVenda = getLong();
    			pontoVendaDesc = getString();
				break;
            case DETALHE_PONTO_VENDA:
            	idPontoVenda = getLong();
    			pontoVendaDesc = getString();
            	dataPontoVenda = getDate();
            	pensao = getString();
    			tipoPensao = getString();
				break;
			}
		}
		
	}

	public FiltroWeb getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(FiltroWeb dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public FiltroWeb getNome() {
		return Nome;
	}

	public void setNome(FiltroWeb nome) {
		Nome = nome;
	}

	public FiltroWeb getPontoVenda() {
		return PontoVenda;
	}

	public void setPontoVenda(FiltroWeb pontoVenda) {
		PontoVenda = pontoVenda;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getPontoVendaDesc() {
		return pontoVendaDesc;
	}

	public void setPontoVendaDesc(String pontoVendaDesc) {
		this.pontoVendaDesc = pontoVendaDesc;
	}

	public String getPrato() {
		return prato;
	}

	public void setPrato(String prato) {
		this.prato = prato;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(Double custoTotal) {
		this.custoTotal = custoTotal;
	}

	public Double getVenda() {
		return venda;
	}

	public void setVenda(Double venda) {
		this.venda = venda;
	}

	public Double getPercentualCusto() {
		return percentualCusto;
	}

	public void setPercentualCusto(Double percentualCusto) {
		this.percentualCusto = percentualCusto;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public long getCodMovimento() {
		return codMovimento;
	}

	public void setCodMovimento(long codMovimento) {
		this.codMovimento = codMovimento;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getVendaTotal() {
		return vendaTotal;
	}

	public void setVendaTotal(Double vendaTotal) {
		this.vendaTotal = vendaTotal;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataPontoVenda() {
		return dataPontoVenda;
	}

	public void setDataPontoVenda(Date dataPontoVenda) {
		this.dataPontoVenda = dataPontoVenda;
	}

	public long getIdPontoVenda() {
		return idPontoVenda;
	}

	public void setIdPontoVenda(long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public String getPensao() {
		return pensao;
	}

	public void setPensao(String pensao) {
		this.pensao = pensao;
	}

	public long getIdPrato() {
		return idPrato;
	}

	public void setIdPrato(long idPrato) {
		this.idPrato = idPrato;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getTipoPensao() {
		return tipoPensao;
	}

	public void setTipoPensao(String tipoPensao) {
		this.tipoPensao = tipoPensao;
	}

	public FiltroWeb getHotel() {
		return hotel;
	}

	public void setHotel(FiltroWeb hotel) {
		this.hotel = hotel;
	}
	
	
}
