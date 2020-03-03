package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class EstoqueItemVO extends MozartVO {

	private static final long serialVersionUID = 3923882262894290855L;

	private FiltroWeb nomeconta;
	private FiltroWeb item;
	private FiltroWeb tipoitem;
	private FiltroWeb filtroNomeOuNomeReduzido;
	
	private Long idItem;
	private String imobilizado;
	private String nomeItem;
	private String nomeUnidadeReduzida;
	private String nomeConta;
	private Long idCentroCusto;
	private String descricaoCentroCusto;
	private String direto;
	private String controlado;
	private String aliquota;
	private Long idFiscalIncidencia;
	private Long estoqueMinimo;
	private Long estoqueMaximo;
	private String nomeTipo;
	private String sigla;
	private String unidadeRede;
	private String unidadeCompra;
	private String unidadeRequisicao;
	
	public EstoqueItemVO(){
		nomeconta = new FiltroWeb();
		item = new FiltroWeb();	
		tipoitem = new FiltroWeb();
		filtroNomeOuNomeReduzido = new FiltroWeb();
	}
	
	public EstoqueItemVO (Object[] filtro ) {
		if (filtro != null){
			setLinha(filtro);
		
			idItem = getLong();
			imobilizado = getString();
			nomeItem = getString();
			nomeUnidadeReduzida = getString();
			nomeConta = getString();
			descricaoCentroCusto = getString();
			direto = getString();
			controlado = getString();
			aliquota = getString();
			idFiscalIncidencia = getLong();
			estoqueMinimo = getLong();
			estoqueMaximo = getLong();
			nomeTipo = getString();
			sigla = getString();
			unidadeRede = getString();
			unidadeCompra = getString();
			unidadeRequisicao = getString();
			idCentroCusto = getLong();
		}
	}

	public FiltroWeb getNomeconta() {
		return nomeconta;
	}

	public void setNomeconta(FiltroWeb nomeconta) {
		this.nomeconta = nomeconta;
	}

	public FiltroWeb getItem() {
		return item;
	}

	public void setItem(FiltroWeb item) {
		this.item = item;
	}

	public FiltroWeb getTipoitem() {
		return tipoitem;
	}

	public void setTipoitem(FiltroWeb tipoitem) {
		this.tipoitem = tipoitem;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getImobilizado() {
		return imobilizado;
	}

	public void setImobilizado(String imobilizado) {
		this.imobilizado = imobilizado;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getNomeUnidadeReduzida() {
		return nomeUnidadeReduzida;
	}

	public void setNomeUnidadeReduzida(String nomeUnidadeReduzida) {
		this.nomeUnidadeReduzida = nomeUnidadeReduzida;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public String getDescricaoCentroCusto() {
		return descricaoCentroCusto;
	}

	public void setDescricaoCentroCusto(String descricaoCentroCusto) {
		this.descricaoCentroCusto = descricaoCentroCusto;
	}

	public String getDireto() {
		return direto;
	}

	public void setDireto(String direto) {
		this.direto = direto;
	}

	public String getControlado() {
		return controlado;
	}

	public void setControlado(String controlado) {
		this.controlado = controlado;
	}

	public String getAliquota() {
		return aliquota;
	}

	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}
	
	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUnidadeRede() {
		return unidadeRede;
	}

	public void setUnidadeRede(String unidadeRede) {
		this.unidadeRede = unidadeRede;
	}

	public String getUnidadeCompra() {
		return unidadeCompra;
	}

	public void setUnidadeCompra(String unidadeCompra) {
		this.unidadeCompra = unidadeCompra;
	}

	public String getUnidadeRequisicao() {
		return unidadeRequisicao;
	}

	public void setUnidadeRequisicao(String unidadeRequisicao) {
		this.unidadeRequisicao = unidadeRequisicao;
	}

	public Long getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(Long estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public Long getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(Long estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public FiltroWeb getFiltroNomeOuNomeReduzido() {
		return filtroNomeOuNomeReduzido;
	}

	public void setFiltroNomeOuNomeReduzido(FiltroWeb filtroNomeOuNomeReduzido) {
		this.filtroNomeOuNomeReduzido = filtroNomeOuNomeReduzido;
	}

	public Long getIdCentroCusto() {
		return idCentroCusto;
	}

	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	public Long getIdFiscalIncidencia() {
		return idFiscalIncidencia;
	}

	public void setIdFiscalIncidencia(Long idFiscalIncidencia) {
		this.idFiscalIncidencia = idFiscalIncidencia;
	}
}