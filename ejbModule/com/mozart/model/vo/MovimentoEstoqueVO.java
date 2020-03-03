package com.mozart.model.vo;


import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MovimentoEstoqueVO extends MozartVO {

	private static final long serialVersionUID = 1370379234785052944L;

	private String nmItem;
	private String dsTipoMovimento;
	private String dsUnidade;
	private Double vlQuantidade;
	private Double vlUnitario;
	private Double vlTotal;
	private String dsCentroCusto;
	private String nmFornecedor;
	private String numDocumento;
	private Date dtMovimento;
	private String nmTipoItem;
	private String sglHotelMutuo;
	private Long idMovEstqPorcao;
	private String sglHotel;
	private Long idMovEstoque;
	private Long idHotel;
	private Long idCentroCusto;
	private Long idItem;
	private Date dtDocumento;
	private Long idRedeHotel;
	private Long idPontoVenda;
	private String numNota;

	private FiltroWeb lancamento;
	private FiltroWeb movimento;
	private FiltroWeb fornecedor;
	private FiltroWeb documento;
	private FiltroWeb centroCusto;
	private FiltroWeb item;
	private FiltroWeb tipoItem;
	
	public MovimentoEstoqueVO() {
		super();
	}
	
	public MovimentoEstoqueVO(Object[] linha, boolean isMovimentoFechamento) {
		setLinha(linha);
		
		if(isMovimentoFechamento){
			idMovEstoque = getLong();
			idItem = getLong();
			idHotel = getLong();
			idCentroCusto = getLong();
			dtMovimento = getDate();
			dsTipoMovimento = getString();
			dtDocumento = getDate();
			numDocumento = getString();
			vlQuantidade = getDouble();
			idRedeHotel = getLong();
		}
		else
		{
			nmItem = getString();
			dsTipoMovimento = getString();
			dsUnidade = getString();
			vlQuantidade = getDouble();
			vlUnitario = getDouble();
			vlTotal = getDouble();
			dsCentroCusto = getString();
			nmFornecedor = getString();
			numDocumento = getString();
			dtMovimento = getDate();
			nmTipoItem = getString();
			sglHotelMutuo = getString();
			idMovEstqPorcao = getLong();
			sglHotel = getString();
			idMovEstoque = getLong();
		}
	}

	public String getNmItem() {
		return nmItem;
	}

	public void setNmItem(String nmItem) {
		this.nmItem = nmItem;
	}

	public String getDsTipoMovimento() {
		return dsTipoMovimento;
	}

	public void setDsTipoMovimento(String dsTipoMovimento) {
		this.dsTipoMovimento = dsTipoMovimento;
	}

	public String getDsUnidade() {
		return dsUnidade;
	}

	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}

	public Double getVlQuantidade() {
		return vlQuantidade;
	}

	public void setVlQuantidade(Double vlQuantidade) {
		this.vlQuantidade = vlQuantidade;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(Double vlTotal) {
		this.vlTotal = vlTotal;
	}

	public String getDsCentroCusto() {
		return dsCentroCusto;
	}

	public void setDsCentroCusto(String dsCentroCusto) {
		this.dsCentroCusto = dsCentroCusto;
	}

	public String getNmFornecedor() {
		return nmFornecedor;
	}

	public void setNmFornecedor(String nmFornecedor) {
		this.nmFornecedor = nmFornecedor;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Date getDtMovimento() {
		return dtMovimento;
	}

	public void setDtMovimento(Date dtMovimento) {
		this.dtMovimento = dtMovimento;
	}

	public String getNmTipoItem() {
		return nmTipoItem;
	}

	public void setNmTipoItem(String nmTipoItem) {
		this.nmTipoItem = nmTipoItem;
	}

	public String getSglHotelMutuo() {
		return sglHotelMutuo;
	}

	public void setSglHotelMutuo(String sglHotelMutuo) {
		this.sglHotelMutuo = sglHotelMutuo;
	}

	public Long getIdMovEstqPorcao() {
		return idMovEstqPorcao;
	}

	public void setIdMovEstqPorcao(Long idMovEstqPorcao) {
		this.idMovEstqPorcao = idMovEstqPorcao;
	}

	public String getSglHotel() {
		return sglHotel;
	}

	public void setSglHotel(String sglHotel) {
		this.sglHotel = sglHotel;
	}

	public Long getIdMovEstoque() {
		return idMovEstoque;
	}

	public void setIdMovEstoque(Long idMovEstoque) {
		this.idMovEstoque = idMovEstoque;
	}

	public FiltroWeb getLancamento() {
		return lancamento;
	}

	public void setLancamento(FiltroWeb lancamento) {
		this.lancamento = lancamento;
	}

	public FiltroWeb getMovimento() {
		return movimento;
	}

	public void setMovimento(FiltroWeb movimento) {
		this.movimento = movimento;
	}

	public FiltroWeb getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FiltroWeb fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FiltroWeb getDocumento() {
		return documento;
	}

	public void setDocumento(FiltroWeb documento) {
		this.documento = documento;
	}

	public FiltroWeb getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(FiltroWeb centroCusto) {
		this.centroCusto = centroCusto;
	}

	public FiltroWeb getItem() {
		return item;
	}

	public void setItem(FiltroWeb item) {
		this.item = item;
	}

	public FiltroWeb getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(FiltroWeb tipoItem) {
		this.tipoItem = tipoItem;
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

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Date getDtDocumento() {
		return dtDocumento;
	}

	public void setDtDocumento(Date dtDocumento) {
		this.dtDocumento = dtDocumento;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getIdPontoVenda() {
		return idPontoVenda;
	}

	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public String getNumNota() {
		return numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}
}