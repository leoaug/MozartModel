package com.mozart.model.vo;

import com.mozart.model.ejb.entity.ContasPagarEJB;
import com.mozart.model.vo.filtro.FiltroWeb;

import java.util.Date;

public class ContasPagarComissaoVO extends MozartVO {

	private static final long serialVersionUID = -5934696277649079306L;
	private FiltroWeb filtroData;
	private FiltroWeb filtroNomeHospede;
	private FiltroWeb filtroDataSaida;
	private FiltroWeb filtroValor;
	private FiltroWeb filtroNomeFantasia;
	private FiltroWeb filtroNumNota;	

	private Long idMovimentoApartamento;
	private String filtroTipoPesquisa;
	private String nomeEmpresa;
	private Long idEmpresa;
	private Double valorDiaria;
	private Double comissao;
	private Double valorComissao;
	private String nomeHospede;	
	private Long idNota;
	private String numNota;
	private Date dataGerado;
	private Date dataSaida;
	private Long idContasPagar;
	private String sigla;
	private Long prazoPagamento;
	private Long idContaCorrente;
	private Long idPlanoContasCredito;
	private Long idCentroCustoCredito;
	private Long idPlanoContasDebito;
	private Long idCentroCustoDebito;
	private Long idHistoricoCredito;
	private Long idHistoricoDebito;
	private Long idPlanoContasFinanceiro;

	public ContasPagarComissaoVO() {
		this.filtroData = new FiltroWeb();
		this.filtroNomeHospede = new FiltroWeb();
		this.filtroDataSaida = new FiltroWeb();
		this.filtroValor = new FiltroWeb();
		this.filtroNomeFantasia = new FiltroWeb();
		this.filtroNumNota = new FiltroWeb();
	}

	public ContasPagarComissaoVO(Object[] linha) {
		super();
		if (linha != null) {
			setLinha(linha);
			this.idMovimentoApartamento = getLong();
			this.dataSaida = getDate();
			this.dataGerado = getDate();
			this.idContasPagar = getLong();
			this.valorDiaria = getDouble();
			this.nomeEmpresa = getString();
			this.idEmpresa = getLong();
			this.prazoPagamento = getLong();
			this.comissao = getDouble();
			this.idNota = getLong();
			this.nomeHospede = getString();
			this.numNota = getString();
			this.idContaCorrente = getLong();
			this.sigla = getString();
			this.idPlanoContasCredito = getLong();
			this.idCentroCustoCredito = getLong();
			this.idPlanoContasDebito = getLong();
			this.idCentroCustoDebito = getLong();
			this.idHistoricoCredito = getLong();
			this.idHistoricoDebito = getLong();
			this.idPlanoContasFinanceiro = getLong();
		}
	}
	
	public FiltroWeb getFiltroData() {
		return filtroData;
	}

	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}

	public FiltroWeb getFiltroNomeHospede() {
		return filtroNomeHospede;
	}

	public void setFiltroNomeHospede(FiltroWeb filtroNomeHospede) {
		this.filtroNomeHospede = filtroNomeHospede;
	}

	public FiltroWeb getFiltroValor() {
		return filtroValor;
	}

	public void setFiltroValor(FiltroWeb filtroValor) {
		this.filtroValor = filtroValor;
	}

	public FiltroWeb getFiltroNomeFantasia() {
		return filtroNomeFantasia;
	}

	public void setFiltroNomeFantasia(FiltroWeb filtroNomeFantasia) {
		this.filtroNomeFantasia = filtroNomeFantasia;
	}

	public FiltroWeb getFiltroNumNota() {
		return filtroNumNota;
	}

	public void setFiltroNumNota(FiltroWeb filtroNumNota) {
		this.filtroNumNota = filtroNumNota;
	}

	public FiltroWeb getFiltroDataSaida() {
		return filtroDataSaida;
	}

	public void setFiltroDataSaida(FiltroWeb filtroDataSaida) {
		this.filtroDataSaida = filtroDataSaida;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Double getValorComissao() {
		valorComissao = valorDiaria * comissao / 100;		
		return valorComissao;
	}

	public void setValorComissao(Double valorComissao) {
		this.valorComissao = valorComissao;
	}

	public Date getDataGerado() {
		return dataGerado;
	}

	public void setDataGerado(Date dataGerado) {
		this.dataGerado = dataGerado;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Long getIdContasPagar() {
		return idContasPagar;
	}

	public void setIdContasPagar(Long idContasPagar) {
		this.idContasPagar = idContasPagar;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getFiltroTipoPesquisa() {
		return filtroTipoPesquisa;
	}

	public void setFiltroTipoPesquisa(String filtroTipoPesquisa) {
		this.filtroTipoPesquisa = filtroTipoPesquisa;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public String getNomeHospede() {
		return nomeHospede;
	}

	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}

	public String getNumNota() {
		return numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public Long getIdMovimentoApartamento() {
		return idMovimentoApartamento;
	}

	public void setIdMovimentoApartamento(Long idMovimentoApartamento) {
		this.idMovimentoApartamento = idMovimentoApartamento;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Long getIdNota() {
		return idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Long getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(Long prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public Long getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (this.idNota == null ? 0 : this.idNota
						.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		ContasPagarComissaoVO other = (ContasPagarComissaoVO) obj;
		if (this.idNota == null) {
			if (other.getIdNota() != null) {
				return false;
			}
		} else if (!this.idNota.equals(other.getIdNota())) {
			return false;
		}
		return true;
	}

	public Long getIdPlanoContasCredito() {
		return idPlanoContasCredito;
	}

	public void setIdPlanoContasCredito(Long idPlanoContasCredito) {
		this.idPlanoContasCredito = idPlanoContasCredito;
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

	public Long getIdCentroCustoDebito() {
		return idCentroCustoDebito;
	}

	public void setIdCentroCustoDebito(Long idCentroCustoDebito) {
		this.idCentroCustoDebito = idCentroCustoDebito;
	}

	public Long getIdHistoricoCredito() {
		return idHistoricoCredito;
	}

	public void setIdHistoricoCredito(Long idHistoricoCredito) {
		this.idHistoricoCredito = idHistoricoCredito;
	}

	public Long getIdHistoricoDebito() {
		return idHistoricoDebito;
	}

	public void setIdHistoricoDebito(Long idHistoricoDebito) {
		this.idHistoricoDebito = idHistoricoDebito;
	}

	public Long getIdPlanoContasFinanceiro() {
		return idPlanoContasFinanceiro;
	}

	public void setIdPlanoContasFinanceiro(Long idPlanoContasFinanceiro) {
		this.idPlanoContasFinanceiro = idPlanoContasFinanceiro;
	}	
	
    public ContasPagarComissaoVO clone(){
    	ContasPagarComissaoVO clone = new ContasPagarComissaoVO();
		clone.idMovimentoApartamento = this.idMovimentoApartamento;
		clone.dataSaida = this.dataSaida;
		clone.dataGerado = this.dataGerado;
		clone.idContasPagar = this.idContasPagar;
		clone.valorDiaria = this.valorDiaria;
		clone.nomeEmpresa = this.nomeEmpresa;
		clone.idEmpresa = this.idEmpresa;
		clone.prazoPagamento = this.prazoPagamento;
		clone.comissao = this.comissao;
		clone.idNota = this.idNota;
		clone.nomeHospede = this.nomeHospede;
		clone.numNota = this.numNota;
		clone.idContaCorrente = this.idContaCorrente;
		clone.sigla = this.sigla;
		clone.idPlanoContasCredito = this.idPlanoContasCredito;
		clone.idCentroCustoCredito = this.idCentroCustoCredito;
		clone.idPlanoContasDebito = this.idPlanoContasDebito;
		clone.idCentroCustoDebito = this.idCentroCustoDebito;
		clone.idHistoricoCredito = this.idHistoricoCredito;
		clone.idHistoricoDebito = this.idHistoricoDebito;
		clone.idPlanoContasFinanceiro = this.idPlanoContasFinanceiro;
    	return clone;
    }
}