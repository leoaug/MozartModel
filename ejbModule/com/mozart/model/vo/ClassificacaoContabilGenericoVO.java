package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;

public class ClassificacaoContabilGenericoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2682028379743323260L;

	private Long idRedeHotel;
	private Long idHotel;
	private Long idClassificacaoContabil;
	private Long idCentroCustoDebito;
	private Long idCentroCustoCredito;
	private Long idPlanoContasDebito;
	private Long idPlanoContasCredito;
	private String descricao;
	private Long percentual;
	private String debitoCredito;
	private Long idTipoLancamento;
	private String pis;
	private String contaCorrente;
	private Long idPlanoContasFinanceiro;

	
	/**
	 * @param linha
	 * 
	 * idRedeHotel = Long
	 * idHotel = Long
	 * idClassificacaoContabil = Long
	 * idCentroCustoDebito = Long
	 * idCentroCustoCredito = Long
	 * idPlanoContasDebito = Long
	 * idPlanoContasCredito = Long
	 * descricao = String
	 * percentual = Long
	 * debitoCredito = String
	 * idTipoLancamento = Long
	 * pis = String
	 * contaCorrente =  String
	 * idPlanoContasFinanceiro = Long
	 * 	
	 * */
	
	public ClassificacaoContabilGenericoVO(Object[] linha) {
		if (!MozartUtil.isNull(linha)) {
			setLinha(linha);
			idRedeHotel = getLong();
			idHotel = getLong();
			idClassificacaoContabil = getLong();
			idCentroCustoDebito = getLong();
			idCentroCustoCredito = getLong();
			idPlanoContasDebito = getLong();
			idPlanoContasCredito = getLong();
			descricao = getString();
			percentual = getLong();
			debitoCredito = getString();
			idTipoLancamento = getLong();
			pis = getString();
			contaCorrente =  getString();
			idPlanoContasFinanceiro = getLong();
		}
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdClassificacaoContabil() {
		return idClassificacaoContabil;
	}

	public void setIdClassificacaoContabil(Long idClassificacaoContabil) {
		this.idClassificacaoContabil = idClassificacaoContabil;
	}

	public Long getIdCentroCustoDebito() {
		return idCentroCustoDebito;
	}

	public void setIdCentroCustoDebito(Long idCentroCustoDebito) {
		this.idCentroCustoDebito = idCentroCustoDebito;
	}

	public Long getIdCentroCustoCredito() {
		return idCentroCustoCredito;
	}

	public void setIdCentroCustoCredito(Long idCentroCustoCredito) {
		this.idCentroCustoCredito = idCentroCustoCredito;
	}

	public Long getIdPlanoContasDebito() {
		return idPlanoContasDebito;
	}

	public void setIdPlanoContasDebito(Long idPlanoContasDebito) {
		this.idPlanoContasDebito = idPlanoContasDebito;
	}

	public Long getIdPlanoContasCredito() {
		return idPlanoContasCredito;
	}

	public void setIdPlanoContasCredito(Long idPlanoContasCredito) {
		this.idPlanoContasCredito = idPlanoContasCredito;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getPercentual() {
		return percentual;
	}

	public void setPercentual(Long percentual) {
		this.percentual = percentual;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public Long getIdTipoLancamento() {
		return idTipoLancamento;
	}

	public void setIdTipoLancamento(Long idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Long getIdPlanoContasFinanceiro() {
		return idPlanoContasFinanceiro;
	}

	public void setIdPlanoContasFinanceiro(Long idPlanoContasFinanceiro) {
		this.idPlanoContasFinanceiro = idPlanoContasFinanceiro;
	}
	
	

}
