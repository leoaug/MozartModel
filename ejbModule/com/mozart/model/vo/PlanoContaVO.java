package com.mozart.model.vo;

import com.mozart.model.vo.ItemEstoqueVO.TypeOfItemEstoque;
import com.mozart.model.vo.filtro.FiltroWeb;

public class PlanoContaVO extends MozartVO {
	public enum TypeOfPlanoConta {
	    COMBO_BOX, GERAL, COMBO_SUGGEST
	}
	
	private static final long serialVersionUID = 1L;
	private FiltroWeb filtroContaContabil;
	private FiltroWeb filtroContaReduzida;
	private FiltroWeb filtroNomeConta;
	private FiltroWeb filtroTipoConta;
	private FiltroWeb filtroAtivoPassivo;
	private FiltroWeb filtroAjax;
	public static final int ORDEM_CONTA_CONTABIL = 1;
	private int ordem;
	private Long idPlanoContas;
	private String contaContabil;
	private String contaReduzida;
	private String nomeConta;
	private String tipoConta;
	private String razaoAuxiliar;
	private String correcaoMonetaria;
	private String depreciacao;
	private String ativoPassivo;
	private String historicoDebito;
	private String historicoCredito;
	private String planoContasSped;

	public PlanoContaVO() {
		this.filtroContaReduzida = new FiltroWeb();
		this.filtroContaContabil = new FiltroWeb();
		this.filtroNomeConta = new FiltroWeb();
		this.filtroTipoConta = new FiltroWeb();
		this.filtroAtivoPassivo = new FiltroWeb();
		this.filtroAjax = new FiltroWeb();
	}

	public PlanoContaVO(Object[] filtro, TypeOfPlanoConta typeOf) {
		if (filtro != null) {
			setLinha(filtro);
			
			switch (typeOf) {
            case GERAL:
				this.idPlanoContas = getLong();
				this.contaReduzida = getString();
				this.contaContabil = getString();
				this.nomeConta = getString();
				this.tipoConta = getString();
				this.razaoAuxiliar = getString();
				this.correcaoMonetaria = getString();
				this.depreciacao = getString();
				this.ativoPassivo = getString();
				this.historicoCredito = getString();
				this.historicoDebito = getString();
				this.planoContasSped = getString();
				break;
			case COMBO_BOX:
				this.idPlanoContas = getLong();
				this.contaContabil = getString();
				this.contaReduzida = getString();
				this.nomeConta = getString();
				break;
			case COMBO_SUGGEST:
				this.idPlanoContas = getLong();
				this.contaContabil = getString();
				this.nomeConta = getString();
				break;
			}
		}
	}

	public String toString() {
		return this.contaContabil + " - " + this.ativoPassivo + " - "
				+ this.nomeConta;
	}

	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof PlanoContaVO))) {
			return false;
		}
		return this.idPlanoContas.equals(((PlanoContaVO) obj)
				.getIdPlanoContas());
	}

	public String getContaContabil() {
		return this.contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getContaReduzida() {
		return this.contaReduzida;
	}

	public void setContaReduzida(String contaReduzida) {
		this.contaReduzida = contaReduzida;
	}

	public String getNomeConta() {
		return this.nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public String getTipoConta() {
		return this.tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getRazaoAuxiliar() {
		return this.razaoAuxiliar;
	}

	public void setRazaoAuxiliar(String razaoAuxiliar) {
		this.razaoAuxiliar = razaoAuxiliar;
	}

	public String getCorrecaoMonetaria() {
		return this.correcaoMonetaria;
	}

	public void setCorrecaoMonetaria(String correcaoMonetaria) {
		this.correcaoMonetaria = correcaoMonetaria;
	}

	public String getDepreciacao() {
		return this.depreciacao;
	}

	public void setDepreciacao(String depreciacao) {
		this.depreciacao = depreciacao;
	}

	public String getAtivoPassivo() {
		return this.ativoPassivo;
	}

	public void setAtivoPassivo(String ativoPassivo) {
		this.ativoPassivo = ativoPassivo;
	}

	public String getHistoricoDebito() {
		return this.historicoDebito;
	}

	public void setHistoricoDebito(String historicoDebito) {
		this.historicoDebito = historicoDebito;
	}

	public String getHistoricoCredito() {
		return this.historicoCredito;
	}

	public void setHistoricoCredito(String historicoCredito) {
		this.historicoCredito = historicoCredito;
	}

	public String getPlanoContasSped() {
		return this.planoContasSped;
	}

	public void setPlanoContasSped(String planoContasSped) {
		this.planoContasSped = planoContasSped;
	}

	public FiltroWeb getFiltroContaContabil() {
		return this.filtroContaContabil;
	}

	public void setFiltroContaContabil(FiltroWeb filtroContaContabil) {
		this.filtroContaContabil = filtroContaContabil;
	}

	public FiltroWeb getFiltroContaReduzida() {
		return this.filtroContaReduzida;
	}

	public void setFiltroContaReduzida(FiltroWeb filtroContaReduzida) {
		this.filtroContaReduzida = filtroContaReduzida;
	}

	public FiltroWeb getFiltroNomeConta() {
		return this.filtroNomeConta;
	}

	public void setFiltroNomeConta(FiltroWeb filtroNomeConta) {
		this.filtroNomeConta = filtroNomeConta;
	}

	public FiltroWeb getFiltroTipoConta() {
		return this.filtroTipoConta;
	}

	public void setFiltroTipoConta(FiltroWeb filtroTipoConta) {
		this.filtroTipoConta = filtroTipoConta;
	}

	public Long getIdPlanoContas() {
		return this.idPlanoContas;
	}

	public void setIdPlanoContas(Long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}

	public FiltroWeb getFiltroAtivoPassivo() {
		return this.filtroAtivoPassivo;
	}

	public void setFiltroAtivoPassivo(FiltroWeb filtroAtivoPassivo) {
		this.filtroAtivoPassivo = filtroAtivoPassivo;
	}

	public int getOrdem() {
		return this.ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getContaReduzidaNomeConta() {
		return this.contaReduzida + "-" + this.nomeConta;
	}

	public FiltroWeb getFiltroAjax() {
		return filtroAjax;
	}

	public void setFiltroAjax(FiltroWeb filtroAjax) {
		this.filtroAjax = filtroAjax;
	}
}