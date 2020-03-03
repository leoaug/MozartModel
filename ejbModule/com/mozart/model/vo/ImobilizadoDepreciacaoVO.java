package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ImobilizadoDepreciacaoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TypeOfImobilizacaoDepreciacao {
		PESQUISA, ALTERACAO
	}

	/* FILTRO */
	private FiltroWeb NumControle;
	private FiltroWeb DataMovimento;
	private FiltroWeb ContaContabil;
	private long idHotel;

	private String controle;
	private Date dataDocumento;
	private String numDocumentoDesc;
	private Long idCentroCustoContabil;
	private String descricaoCentroCusto;
	private Double valor;
	private String debCred;
	private String numContaContabil;
	private String nomeContaContabil;
	private String nomeContaCredora;
	private String nomeContaDepreciacao;
	private String setor;
	private String historico;
	private String idPatrimonioSetor;
	private String descPatrimonioSetor;
	private Long idMovimentoContabil;

	public ImobilizadoDepreciacaoVO() {
		NumControle = new FiltroWeb();
		DataMovimento = new FiltroWeb();
		ContaContabil = new FiltroWeb();
	}

	public ImobilizadoDepreciacaoVO(Object[] filtro,
			TypeOfImobilizacaoDepreciacao typeOf) {

		if (filtro != null) {
			setLinha(filtro);
			switch (typeOf) {
			case PESQUISA:
				controle = getString();
				dataDocumento = getDate();
				numDocumentoDesc = getString();
				descricaoCentroCusto = getString();
				valor = getDouble();
				debCred = getString();
				numContaContabil = getString();
				nomeContaContabil = getString();
				nomeContaCredora = getString();
				nomeContaDepreciacao = getString();
				setor = getString();
				historico = getString();
				idMovimentoContabil = getLong();
				break;
			case ALTERACAO:
				numDocumentoDesc = getString();
				debCred = getString();
				numContaContabil = getString();
				nomeContaContabil = getString();
				valor = getDouble();
				controle = getString();
				idCentroCustoContabil = getLong();
				descricaoCentroCusto = getString();
				idMovimentoContabil = getLong();
				idPatrimonioSetor = getString();
				descPatrimonioSetor = getString();
				break;
			}			
		}
	}

	public FiltroWeb getNumControle() {
		return NumControle;
	}

	public void setNumControle(FiltroWeb numControle) {
		NumControle = numControle;
	}

	public FiltroWeb getDataMovimento() {
		return DataMovimento;
	}

	public void setDataMovimento(FiltroWeb dataMovimento) {
		DataMovimento = dataMovimento;
	}

	public FiltroWeb getContaContabil() {
		return ContaContabil;
	}

	public void setContaContabil(FiltroWeb contaContabil) {
		ContaContabil = contaContabil;
	}

	public String getControle() {
		return controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public String getNumDocumentoDesc() {
		return numDocumentoDesc;
	}

	public void setNumDocumentoDesc(String numDocumentoDesc) {
		this.numDocumentoDesc = numDocumentoDesc;
	}

	public String getDescricaoCentroCusto() {
		return descricaoCentroCusto;
	}

	public void setDescricaoCentroCusto(String descricaoCentroCusto) {
		this.descricaoCentroCusto = descricaoCentroCusto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDebCred() {
		return debCred;
	}

	public void setDebCred(String debCred) {
		this.debCred = debCred;
	}

	public String getNumContaContabil() {
		return numContaContabil;
	}

	public void setNumContaContabil(String numContaContabil) {
		this.numContaContabil = numContaContabil;
	}

	public String getNomeContaContabil() {
		return nomeContaContabil;
	}

	public void setNomeContaContabil(String nomeContaContabil) {
		this.nomeContaContabil = nomeContaContabil;
	}

	public String getNomeContaCredora() {
		return nomeContaCredora;
	}

	public void setNomeContaCredora(String nomeContaCredora) {
		this.nomeContaCredora = nomeContaCredora;
	}

	public String getNomeContaDepreciacao() {
		return nomeContaDepreciacao;
	}

	public void setNomeContaDepreciacao(String nomeContaDepreciacao) {
		this.nomeContaDepreciacao = nomeContaDepreciacao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public long getIdMovimentoContabil() {
		return idMovimentoContabil;
	}

	public void setIdMovimentoContabil(long idMovimentoContabil) {
		this.idMovimentoContabil = idMovimentoContabil;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public String getDescPatrimonioSetor() {
		return descPatrimonioSetor;
	}

	public void setDescPatrimonioSetor(String descPatrimonioSetor) {
		this.descPatrimonioSetor = descPatrimonioSetor;
	}

	public long getIdCentroCustoContabil() {
		return idCentroCustoContabil;
	}

	public void setIdCentroCustoContabil(long idCentroCustoContabil) {
		this.idCentroCustoContabil = idCentroCustoContabil;
	}

	public String getIdPatrimonioSetor() {
		return idPatrimonioSetor;
	}

	public void setIdPatrimonioSetor(String idPatrimonioSetor) {
		this.idPatrimonioSetor = idPatrimonioSetor;
	}

}
