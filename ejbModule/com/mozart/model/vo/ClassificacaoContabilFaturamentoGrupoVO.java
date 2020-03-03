package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;


public class ClassificacaoContabilFaturamentoGrupoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5231005196200245967L;

	private ClassificacaoContabilFaturamentoVO debito;
	private ClassificacaoContabilCentroCustoVO centroCustoDebito;
	private Boolean pisDebito;
	private ClassificacaoContabilFaturamentoVO credito;
	private ClassificacaoContabilCentroCustoVO centroCustoCredito;
	private Boolean pisCredito;
	private String descricao;
	
	private Long idHotel;
	private Long idClassificacaoContabil;
	private Long idPlanoContasCredito;
	private String cdContaReduzidaCredito;
	private String cdContaContabilCredito;
	private String nmContaCredito;
	private Long idCentroCustoCredito;
	private String nmCentroCustoCredito;
	private Long idPlanoContasDebito;
	private String cdContaReduzidaDebito;
	private String cdContaContabilDebito;
	private String nmContaDebito;
	private Long idCentroCustoDebito;
	private String nmCentroCustoDebito;
	private String pis;
	
	private FiltroWeb filtroFaturamento;

	public ClassificacaoContabilFaturamentoGrupoVO(){
		filtroFaturamento = new FiltroWeb();
	}
	
	public ClassificacaoContabilFaturamentoGrupoVO(Object[] linha){
		if (!MozartUtil.isNull(linha)) {
			setLinha(linha);
			idClassificacaoContabil 	= getLong();
			idHotel 					= getLong();
			idPlanoContasDebito 		= getLong();
			cdContaReduzidaDebito		= getString();
			cdContaContabilDebito		= getString();
			nmContaDebito 				= getString();
			idCentroCustoDebito 		= getLong();
			nmCentroCustoDebito 		= getString();
			idPlanoContasCredito 		= getLong();
			cdContaReduzidaCredito		= getString();
			cdContaContabilCredito		= getString();
			nmContaCredito 				= getString();
			idCentroCustoCredito 		= getLong();
			nmCentroCustoCredito 		= getString();
			descricao 					= getString();
			pis 						= getString().equals("S")?"SIM":"NÃO";
			
		};
	}
	
	
	public FiltroWeb getFiltroFaturamento() {
		return filtroFaturamento;
	}


	public void setFiltroFaturamento(FiltroWeb filtroFaturamento) {
		this.filtroFaturamento = filtroFaturamento;
	}


	public ClassificacaoContabilFaturamentoVO getDebito() {
		return debito;
	}

	public void setDebito(ClassificacaoContabilFaturamentoVO debito) {
		this.debito = debito;
	}

	public ClassificacaoContabilCentroCustoVO getCentroCustoDebito() {
		return centroCustoDebito;
	}

	public void setCentroCustoDebito(
			ClassificacaoContabilCentroCustoVO centroCustoDebito) {
		this.centroCustoDebito = centroCustoDebito;
	}

	public ClassificacaoContabilFaturamentoVO getCredito() {
		return credito;
	}

	public void setCredito(ClassificacaoContabilFaturamentoVO credito) {
		this.credito = credito;
	}

	public ClassificacaoContabilCentroCustoVO getCentroCustoCredito() {
		return centroCustoCredito;
	}

	public void setCentroCustoCredito(
			ClassificacaoContabilCentroCustoVO centroCustoCredito) {
		this.centroCustoCredito = centroCustoCredito;
	}

	public Boolean getPisDebito() {
		return pisDebito;
	}

	public void setPisDebito(Boolean pisDebito) {
		this.pisDebito = pisDebito;
	}
	
	public Boolean getPisCredito() {
		return pisCredito;
	}

	public void setPisCredito(Boolean pisCredito) {
		this.pisCredito = pisCredito;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdClassificacaoContabil() {
		return idClassificacaoContabil;
	}

	public void setIdClassificacaoContabil(Long idClassificacaoContabil) {
		this.idClassificacaoContabil = idClassificacaoContabil;
	}

	public Long getIdPlanoContasCredito() {
		return idPlanoContasCredito;
	}

	public void setIdPlanoContasCredito(Long idPlanoContasCredito) {
		this.idPlanoContasCredito = idPlanoContasCredito;
	}

	public String getNmContaCredito() {
		return nmContaCredito;
	}

	public void setNmContaCredito(String nmContaCredito) {
		this.nmContaCredito = nmContaCredito;
	}

	public String getNmCentroCustoCredito() {
		return nmCentroCustoCredito;
	}

	public void setNmCentroCustoCredito(String nmCentroCustoCredito) {
		this.nmCentroCustoCredito = nmCentroCustoCredito;
	}

	public Long getIdPlanoContasDebito() {
		return idPlanoContasDebito;
	}

	public void setIdPlanoContasDebito(Long idPlanoContasDebito) {
		this.idPlanoContasDebito = idPlanoContasDebito;
	}

	public String getNmContaDebito() {
		return nmContaDebito;
	}

	public void setNmContaDebito(String nmContaDebito) {
		this.nmContaDebito = nmContaDebito;
	}

	public String getNmCentroCustoDebito() {
		return nmCentroCustoDebito;
	}

	public void setNmCentroCustoDebito(String nmCentroCustoDebito) {
		this.nmCentroCustoDebito = nmCentroCustoDebito;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public Long getIdCentroCustoCredito() {
		return idCentroCustoCredito;
	}

	public void setIdCentroCustoCredito(Long idCentroCustoCredito) {
		this.idCentroCustoCredito = idCentroCustoCredito;
	}

	public Long getIdCentroCustoDebito() {
		return idCentroCustoDebito;
	}

	public void setIdCentroCustoDebito(Long idCentroCustoDebito) {
		this.idCentroCustoDebito = idCentroCustoDebito;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getCdContaReduzidaCredito() {
		return cdContaReduzidaCredito;
	}

	public void setCdContaReduzidaCredito(String cdContaReduzidaCredito) {
		this.cdContaReduzidaCredito = cdContaReduzidaCredito;
	}

	public String getCdContaContabilCredito() {
		return cdContaContabilCredito;
	}

	public void setCdContaContabilCredito(String cdContaContabilCredito) {
		this.cdContaContabilCredito = cdContaContabilCredito;
	}

	public String getCdContaReduzidaDebito() {
		return cdContaReduzidaDebito;
	}

	public void setCdContaReduzidaDebito(String cdContaReduzidaDebito) {
		this.cdContaReduzidaDebito = cdContaReduzidaDebito;
	}

	public String getCdContaContabilDebito() {
		return cdContaContabilDebito;
	}

	public void setCdContaContabilDebito(String cdContaContabilDebito) {
		this.cdContaContabilDebito = cdContaContabilDebito;
	}

	
}
