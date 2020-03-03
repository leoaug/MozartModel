package com.mozart.model.ejb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Transient;

@Entity
@NamedQueries({
		@NamedQuery(name = "TipoLancamentoEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from TipoLancamentoEJB o"),
		@NamedQuery(name = "TipoLancamentoEJB.findByDespesaFixa", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.despesaFixa = 'S'"),
		@NamedQuery(name = "TipoLancamentoEJB.findBySubGrupo", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.subGrupoLancamento <> '000' order by o.descricaoLancamento"),
		@NamedQuery(name = "TipoLancamentoEJB.findByPDV", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.identificaLancamento.idIdentificaLancamento in (5,9,22) order by o.descricaoLancamento"),
		@NamedQuery(name = "TipoLancamentoEJB.findToContrato", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.subGrupoLancamento <> '000' and o.identificaLancamento.receitaCheckout = 1 order by o.grupoLancamento, o.subGrupoLancamento"),
		@NamedQuery(name = "TipoLancamentoEJB.findToContratoPagamento", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.identificaLancamento.receitaCheckout = 2 and o.identificaLancamento.grupoSub = 'S' order by o.descricaoLancamento"),
		@NamedQuery(name = "TipoLancamentoEJB.findByTipoLancamentoServico", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.identificaLancamento.idIdentificaLancamento in (11) and o.debitoCredito='D' order by o.descricaoLancamento") })
@Table(name = "TIPO_LANCAMENTO")
@IdClass(TipoLancamentoEJBPK.class)
public class TipoLancamentoEJB extends MozartEntity {

	private static final long serialVersionUID = 701696799686163916L;

	@Id
	@Column(name = "ID_HOTEL", nullable = false)
	private Long idHotel;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqTL")
	@SequenceGenerator(name = "idSeqTL", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_TIPO_LANCAMENTO", nullable = false)
	private Long idTipoLancamento;

	@Column(name = "COFINS", nullable = false)
	private String cofins;

	@Column(name = "DEBITO_CREDITO", nullable = false)
	private String debitoCredito;

	@Column(name = "DESCRICAO_LANCAMENTO")
	private String descricaoLancamento;

	@Column(name = "DESPESA_FIXA")
	private String despesaFixa;

	private String fantasia;

	@Column(name = "FUNDO_RESERVA")
	private String fundoReserva;

	@Column(name = "GRUPO_LANCAMENTO", nullable = false)
	private String grupoLancamento;

	@Column(name = "ID_ALIQUOTA")
	private Long idAliquota;

	@Column(name = "ID_CARTAO_CREDITO")
	private Long idCartaoCredito;

	@OneToOne(optional = false, fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumns({
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_EMPRESA_TERC", referencedColumnName = "ID_EMPRESA") })
	private EmpresaHotelEJB empresaHotelEJB;

	@OneToOne(fetch = FetchType.EAGER, optional = false, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ID_IDENTIFICA_LANCAMENTO", referencedColumnName = "ID_IDENTIFICA_LANCAMENTO")
	private IdentificaLancamentoEJB identificaLancamento;

	@Column(name = "ID_PLANO_CONTAS_FINANCEIRO")
	private Long idPlanoContasFinanceiro;

	@Column(name = "ID_TIPO_APARTAMENTO")
	private Long idTipoApartamento;

	@Column(nullable = false)
	private String iss;

	@Column(name = "ISS_NOTA")
	private String issNota;

	@Column(name = "NOTA_FISCAL", nullable = false)
	private String notaFiscal;

	@Column(name = "PIS", nullable = false)
	private String pis;

	private String roomtax;

	@Column(name = "SUB_GRUPO_LANCAMENTO", nullable = false)
	private String subGrupoLancamento;

	@Column(name = "TAXA_SERVICO", nullable = false)
	private String taxaServico;

	@Column(name = "VALOR_DESP_FIXA")
	private Double valorDespFixa;

	@Column(name = "COD_TRANSACAO_WEB")
	private String codTransacaoWeb;

	@Column(name = "ID_LANCAMENTO_PAI")
	private Long idTipoLancamentoPai;

	@Column(name = "BANDEIRA")
	private String bandeira;

	@Column(name = "PRAZO")
	private Long prazo;

	@Column(name = "COMISSAO")
	private Double comissao;

	@Column(name = "ID_CONTA_CORRENTE")
	private Long contaCorrente;

	@Column(name = "E_COMMERCE", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
	private Character eCommerce;

	@OneToMany(mappedBy = "tipoLancamentoEJB", cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<ClassificacaoContabilEJB> classificacaoContabilEJBList;

	@Transient
	private ClassificacaoContabilEJB classificacaoContabilEJB;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
	 * 
	 * @JoinColumn(name = "ID_LANCAMENTO_PAI", referencedColumnName =
	 * "ID_TIPO_LANCAMENTO") }) private TipoLancamentoEJB tipoLancamentoEJB;
	 * 
	 * @OneToOne(mappedBy = "tipoLancamentoEJB") private TipoLancamentoEJB
	 * tipoLancamentoEJB1;
	 */
	public TipoLancamentoEJB() {
		identificaLancamento = new IdentificaLancamentoEJB();
	}

	public String toString() {
		return grupoLancamento + "-" + descricaoLancamento;
	}

	public boolean equals(Object other) {
		if (other instanceof TipoLancamentoEJB) {
			final TipoLancamentoEJB otherTipoLancamentoEJBPK = (TipoLancamentoEJB) other;
			final boolean areEqual = otherTipoLancamentoEJBPK.idTipoLancamento
					.equals(idTipoLancamento);
			return areEqual;
		}
		return false;
	}

	public String getCofins() {
		return cofins;
	}

	public void setCofins(String cofins) {
		this.cofins = cofins;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}

	public String getDespesaFixa() {
		return despesaFixa;
	}

	public void setDespesaFixa(String despesaFixa) {
		this.despesaFixa = despesaFixa;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getFundoReserva() {
		return fundoReserva;
	}

	public void setFundoReserva(String fundoReserva) {
		this.fundoReserva = fundoReserva;
	}

	public String getGrupoLancamento() {
		return grupoLancamento;
	}

	public void setGrupoLancamento(String grupoLancamento) {
		this.grupoLancamento = grupoLancamento;
	}

	public Long getIdAliquota() {
		return idAliquota;
	}

	public void setIdAliquota(Long idAliquota) {
		this.idAliquota = idAliquota;
	}

	public Long getIdCartaoCredito() {
		return idCartaoCredito;
	}

	public void setIdCartaoCredito(Long idCartaoCredito) {
		this.idCartaoCredito = idCartaoCredito;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdPlanoContasFinanceiro() {
		return idPlanoContasFinanceiro;
	}

	public void setIdPlanoContasFinanceiro(Long idPlanoContasFinanceiro) {
		this.idPlanoContasFinanceiro = idPlanoContasFinanceiro;
	}

	public Long getIdTipoApartamento() {
		return idTipoApartamento;
	}

	public void setIdTipoApartamento(Long idTipoApartamento) {
		this.idTipoApartamento = idTipoApartamento;
	}

	public Long getIdTipoLancamento() {
		return idTipoLancamento;
	}

	public void setIdTipoLancamento(Long idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getIssNota() {
		return issNota;
	}

	public void setIssNota(String issNota) {
		this.issNota = issNota;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getRoomtax() {
		return roomtax;
	}

	public void setRoomtax(String roomtax) {
		this.roomtax = roomtax;
	}

	public String getSubGrupoLancamento() {
		return subGrupoLancamento;
	}

	public void setSubGrupoLancamento(String subGrupoLancamento) {
		this.subGrupoLancamento = subGrupoLancamento;
	}

	public String getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(String taxaServico) {
		this.taxaServico = taxaServico;
	}

	public Double getValorDespFixa() {
		return valorDespFixa;
	}

	public void setValorDespFixa(Double valorDespFixa) {
		this.valorDespFixa = valorDespFixa;
	}

	public void setIdentificaLancamento(
			IdentificaLancamentoEJB identificaLancamento) {
		this.identificaLancamento = identificaLancamento;
	}

	public IdentificaLancamentoEJB getIdentificaLancamento() {
		return identificaLancamento;
	}

	public String getCodTransacaoWeb() {
		return codTransacaoWeb;
	}

	public void setCodTransacaoWeb(String codTransacaoWeb) {
		this.codTransacaoWeb = codTransacaoWeb;
	}

	public EmpresaHotelEJB getEmpresaHotelEJB() {
		return empresaHotelEJB;
	}

	public void setEmpresaHotelEJB(EmpresaHotelEJB empresaHotelEJB) {
		this.empresaHotelEJB = empresaHotelEJB;
	}

	public Long getIdTipoLancamentoPai() {
		return idTipoLancamentoPai;
	}

	public void setIdTipoLancamentoPai(Long idTipoLancamentoPai) {
		this.idTipoLancamentoPai = idTipoLancamentoPai;
	}

	public List<ClassificacaoContabilEJB> getClassificacaoContabilEJBList() {
		return classificacaoContabilEJBList;
	}

	public void setClassificacaoContabilEJBList(
			List<ClassificacaoContabilEJB> classificacaoContabilEJBList) {
		this.classificacaoContabilEJBList = classificacaoContabilEJBList;
	}

	public ClassificacaoContabilEJB getClassificacaoContabilEJB() {
		return classificacaoContabilEJB;
	}

	public void setClassificacaoContabilEJB(
			ClassificacaoContabilEJB classificacaoContabilEJB) {
		this.classificacaoContabilEJB = classificacaoContabilEJB;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public Long getPrazo() {
		return prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Long getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Character getECommerce() {
		return eCommerce;
	}

	public void setECommerce(Character eCommerce) {
		this.eCommerce = eCommerce;
	}

	public Long getIdIdentificaLancamento() {
		return (getIdentificaLancamento() != null)?
				getIdentificaLancamento().getIdIdentificaLancamento():
					null;
	}
}