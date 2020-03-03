package com.mozart.model.vo;

import java.util.Date;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class MovimentoApartamentoVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038980128571235166L;
	
	
	private Long idMovimentoApartamento;
	private String numDocumento;
	private String numNota;
	private Date dataLancamento;
	private Date horaLancamento;
	private String usuarioStr;
	private Long numApartamento;
	private Double valorLancamento;
	private String debitoCredito;
	private Long qtdeAdultos;
	private Long qtdeCafe;
	private Long map;
	private Long fap;
	private String receitaCheckout;
	private String grupoLancamento;
	private String subGrupoLancamento;
	private String descricaoLancamento;
	private String quemPaga;
	
	
	
	private FiltroWeb filtroDescricao, filtroNumApto, filtroQuemPaga, filtroDataLancamento, filtroSubgrupo, filtroGrupo;
	
	
	public MovimentoApartamentoVO(){
		filtroDescricao = new FiltroWeb();
		filtroNumApto = new FiltroWeb();
		filtroQuemPaga = new FiltroWeb();
		filtroDataLancamento = new FiltroWeb();
		filtroSubgrupo = new FiltroWeb();
		filtroGrupo = new FiltroWeb();
	}

	public MovimentoApartamentoVO(Object[] linha){
		
		if (!MozartUtil.isNull(linha)){
			setLinha( linha );
			idMovimentoApartamento = getLong();
			numDocumento = getString();
			numNota = getString();
			dataLancamento = getDate();
			horaLancamento = getDate();
			usuarioStr = getString();
			numApartamento = getLong();
			valorLancamento = getDouble();
			debitoCredito = getString();
			qtdeAdultos = getLong();
			qtdeCafe = getLong();
			map = getLong();
			fap = getLong();
			receitaCheckout = getString();
			grupoLancamento = getString();
			subGrupoLancamento = getString();
			descricaoLancamento = getString();
			quemPaga = getString();
		}
	}


	public FiltroWeb getFiltroDescricao() {
		return filtroDescricao;
	}


	public void setFiltroDescricao(FiltroWeb filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}


	public FiltroWeb getFiltroNumApto() {
		return filtroNumApto;
	}


	public void setFiltroNumApto(FiltroWeb filtroNumApto) {
		this.filtroNumApto = filtroNumApto;
	}


	public FiltroWeb getFiltroQuemPaga() {
		return filtroQuemPaga;
	}


	public void setFiltroQuemPaga(FiltroWeb filtroQuemPaga) {
		this.filtroQuemPaga = filtroQuemPaga;
	}


	public Long getIdMovimentoApartamento() {
		return idMovimentoApartamento;
	}


	public void setIdMovimentoApartamento(Long idMovimentoApartamento) {
		this.idMovimentoApartamento = idMovimentoApartamento;
	}


	public String getNumDocumento() {
		return numDocumento;
	}


	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}


	public String getNumNota() {
		return numNota;
	}


	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}


	public Date getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public Date getHoraLancamento() {
		return horaLancamento;
	}


	public void setHoraLancamento(Date horaLancamento) {
		this.horaLancamento = horaLancamento;
	}


	public String getUsuarioStr() {
		return usuarioStr;
	}


	public void setUsuarioStr(String usuario) {
		this.usuarioStr = usuario;
	}


	public Long getNumApartamento() {
		return numApartamento;
	}


	public void setNumApartamento(Long numApartamento) {
		this.numApartamento = numApartamento;
	}


	public Double getValorLancamento() {
		return valorLancamento;
	}


	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}


	public String getDebitoCredito() {
		return "D".equals(debitoCredito)?"Débito":"C".equals(debitoCredito)?"Crédito":"";
	}


	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}


	public Long getQtdeAdultos() {
		return qtdeAdultos;
	}


	public void setQtdeAdultos(Long qtdeAdultos) {
		this.qtdeAdultos = qtdeAdultos;
	}


	public Long getQtdeCafe() {
		return qtdeCafe;
	}


	public void setQtdeCafe(Long qtdeCafe) {
		this.qtdeCafe = qtdeCafe;
	}


	public Long getMap() {
		return map;
	}


	public void setMap(Long map) {
		this.map = map;
	}


	public Long getFap() {
		return fap;
	}


	public void setFap(Long fap) {
		this.fap = fap;
	}


	public String getReceitaCheckout() {
		return receitaCheckout;
	}


	public void setReceitaCheckout(String receitaCheckout) {
		this.receitaCheckout = receitaCheckout;
	}


	public String getGrupoLancamento() {
		return grupoLancamento;
	}


	public void setGrupoLancamento(String grupoLancamento) {
		this.grupoLancamento = grupoLancamento;
	}


	public String getSubGrupoLancamento() {
		return subGrupoLancamento;
	}


	public void setSubGrupoLancamento(String subGrupoLancamento) {
		this.subGrupoLancamento = subGrupoLancamento;
	}


	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}


	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}


	public FiltroWeb getFiltroDataLancamento() {
		return filtroDataLancamento;
	}


	public void setFiltroDataLancamento(FiltroWeb filtroDataLancamento) {
		this.filtroDataLancamento = filtroDataLancamento;
	}

	public String getQuemPaga() {
		return "E".equals(quemPaga)?"Empresa":"H".equals(quemPaga)?"Hóspede":"";
	}

	public void setQuemPaga(String quemPaga) {
		this.quemPaga = quemPaga;
	}

	public FiltroWeb getFiltroSubgrupo() {
		return filtroSubgrupo;
	}

	public void setFiltroSubgrupo(FiltroWeb filtroSubgrupo) {
		this.filtroSubgrupo = filtroSubgrupo;
	}

	public FiltroWeb getFiltroGrupo() {
		return filtroGrupo;
	}

	public void setFiltroGrupo(FiltroWeb filtroGrupo) {
		this.filtroGrupo = filtroGrupo;
	}


}
