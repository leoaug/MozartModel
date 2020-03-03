package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class MovimentoContabilVO extends TesourariaVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4614839712569240567L;
	
	private Long idSeqContabil;
	private Long idMovimentoContabil;
	private String sigla;
	private Date dataDocumento;
	private String contaReduzida;
	private String nomeConta;
	private Double valor;
	private String debitoCredito;
	private String historico;
	private String numDocumento;
	private String centroCusto;
	private Long controleAtivoFixo;
	
	private Double totalCredito;
	private Double totalDebito;
	private Double diferenca;

	/*Filtros*/
	private FiltroWeb filtroDataDocumento;
	private FiltroWeb filtroContaReduzida;
	private FiltroWeb filtroNomeConta;
	private FiltroWeb filtroHistoricoComplementar;
	private FiltroWeb filtroValor;
	private FiltroWeb filtroSeqContabil;
	
	//private String filtroTipoMovimento; //A - Não consolidado,  M - Consolidado, E - Excluído
	
	
	public MovimentoContabilVO(){
		filtroDataDocumento = new FiltroWeb();
		filtroContaReduzida = new FiltroWeb();
		filtroNomeConta = new FiltroWeb();
		filtroHistoricoComplementar = new FiltroWeb();
		filtroValor = new FiltroWeb();
		filtroSeqContabil = new FiltroWeb();
		setFiltroTipoPesquisa("M");
	}

	public MovimentoContabilVO(Object[] linha){
		
		if (linha != null){
			setLinha(linha);
			idSeqContabil = getLong();
			idMovimentoContabil = getLong();
			sigla = getString();
			dataDocumento = getDate();
			contaReduzida = getString();
			nomeConta = getString();
			valor = getDouble();
			debitoCredito = getString();
			historico = getString();
			numDocumento = getString();
			centroCusto = getString();
			controleAtivoFixo = getLong();
		}
		
	}

	public Long getIdMovimentoContabil() {
		return idMovimentoContabil;
	}

	public void setIdMovimentoContabil(Long idMovimentoContabil) {
		this.idMovimentoContabil = idMovimentoContabil;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public String getContaReduzida() {
		return contaReduzida;
	}

	public void setContaReduzida(String contaReduzida) {
		this.contaReduzida = contaReduzida;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String dc) {
		this.debitoCredito = dc;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}

	public Long getControleAtivoFixo() {
		return controleAtivoFixo;
	}

	public void setControleAtivoFixo(Long controleAtivoFixo) {
		this.controleAtivoFixo = controleAtivoFixo;
	}

	public FiltroWeb getFiltroDataDocumento() {
		return filtroDataDocumento;
	}

	public void setFiltroDataDocumento(FiltroWeb filtroDataDocumento) {
		this.filtroDataDocumento = filtroDataDocumento;
	}

	public FiltroWeb getFiltroContaReduzida() {
		return filtroContaReduzida;
	}

	public void setFiltroContaReduzida(FiltroWeb filtroContaReduzida) {
		this.filtroContaReduzida = filtroContaReduzida;
	}

	public FiltroWeb getFiltroNomeConta() {
		return filtroNomeConta;
	}

	public void setFiltroNomeConta(FiltroWeb filtroNomeConta) {
		this.filtroNomeConta = filtroNomeConta;
	}

	public FiltroWeb getFiltroHistoricoComplementar() {
		return filtroHistoricoComplementar;
	}

	public void setFiltroHistoricoComplementar(FiltroWeb filtroHistoricoComplementar) {
		this.filtroHistoricoComplementar = filtroHistoricoComplementar;
	}

	public FiltroWeb getFiltroValor() {
		return filtroValor;
	}

	public void setFiltroValor(FiltroWeb filtroValor) {
		this.filtroValor = filtroValor;
	}

	public void peencherSaldo(Object[] linha) {
		if (MozartUtil.isNull( linha )){
			totalCredito = new Double(0);
			totalDebito = new Double(0);
			diferenca = new Double(0);
		}else{
			setLinha(linha);
			totalCredito = getDouble();
			totalDebito = getDouble();
			diferenca = getDouble();
		}
	}

	public Double getTotalCredito() {
		return totalCredito;
	}

	public void setTotalCredito(Double totalCredito) {
		this.totalCredito = totalCredito;
	}

	public Double getTotalDebito() {
		return totalDebito;
	}

	public void setTotalDebito(Double totalDebito) {
		this.totalDebito = totalDebito;
	}

	public Double getDiferenca() {
		return diferenca;
	}

	public void setDiferenca(Double diferenca) {
		this.diferenca = diferenca;
	}

	public Long getIdSeqContabil() {
		return idSeqContabil;
	}

	public void setIdSeqContabil(Long idSeqContabil) {
		this.idSeqContabil = idSeqContabil;
	}

	public FiltroWeb getFiltroSeqContabil() {
		return filtroSeqContabil;
	}

	public void setFiltroSeqContabil(FiltroWeb filtroSeqContabil) {
		this.filtroSeqContabil = filtroSeqContabil;
	}
}
