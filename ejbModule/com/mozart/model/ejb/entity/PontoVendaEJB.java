package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the PONTO_VENDA database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "PontoVendaEJB.findByFilter", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from PontoVendaEJB o where o.id.idHotel = ?1 order by o.nomePontoVenda")
		})
@Table(name = "PONTO_VENDA")
public class PontoVendaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PontoVendaEJBPK id;

	private Long controle;

	@Transient
	private Long idPontoVenda;

	@Column(name = "DATA_PV")
	private Timestamp dataPv;

	@Column(name = "ID_CENTRO_CUSTO_CONTABIL")
	private Long idCentroCustoContabil;

	@Column(name = "ID_CHECKIN")
	private Long idCheckin;

	@Column(name = "ID_PLANO_CONTAS_ALIMENTOS")
	private Long idPlanoContasAlimentos;

	@Column(name = "ID_PLANO_CONTAS_BEBIDAS")
	private Long idPlanoContasBebidas;

	@Column(name = "ID_PLANO_CONTAS_OUTROS")
	private Long idPlanoContasOutros;

	@Column(name = "ID_REDE_HOTEL")
	private Long idRedeHotel;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumns({
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO") })
	private TipoLancamentoEJB tipoLancamentoEJB;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumns({
		@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
		@JoinColumn(name = "ID_TIPO_LANCAMENTO_SERVICO", referencedColumnName = "ID_TIPO_LANCAMENTO" , insertable = false, updatable = false) })
	private TipoLancamentoEJB tipoLancamentoServicoEJB;
	
	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumns({
		@JoinColumn(name = "ID_CHECKIN", referencedColumnName = "ID_CHECKIN", insertable = false, updatable = false)
		})
	private CheckinEJB checkinEJB;

	@Column(name = "ID_TIPO_LANCAMENTO_SERVICO")
	private Long idTipoLancamentoServico;

	@Column(name = "NOME_PONTO_VENDA")
	private String nomePontoVenda;

	@Column(name = "NOME_PROPRIETARIO")
	private String nomeProprietario;

	@Column(name = "PERC_TAXA_SERVICO")
	private Double percTaxaServico;

	@Column(name = "TIPO_PONTO_VENDA")
	private String tipoPontoVenda;

	@Column(name = "TIPO_VENDA")
	private String tipoVenda;
	
	@Column(name = "SERIE")
	private String serie;
	
	@Column(name = "ORGAO_1")
	private String defConsumidor1;
	
	@Column(name = "ORGAO_2")
	private String defConsumidor2;
	
	@Column(name = "AMBIENTE")
	private String ambiente;
	
	@Column(name = "NOTA_FISCAL")
	private String notaFiscal;
	
	@OneToOne(cascade = { CascadeType.REFRESH })
	@JoinColumns({
		@JoinColumn(name = "ID_NFE_IMPRESSORA", referencedColumnName = "ID_NFE_IMPRESSORA")
		})
	private NfeImpressoraEJB modeloImpressora;

	@OneToMany(mappedBy = "pontoVendaEJB", fetch = FetchType.EAGER, cascade = {
			CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST })
	private List<PratoPontoVendaEJB> pratoPontoVendaEJBList;

	@OneToMany(mappedBy = "pontoVendaEJB", fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	private List<UsuarioPontoVendaEJB> usuarioPontoVendaEJBList;

	public PontoVendaEJB() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PontoVendaEJB)) {
			return false;
		}

		if (id == null) {
			return false;
		}
		PontoVendaEJB castOther = (PontoVendaEJB) other;
		return id.equals(castOther.getId());
	}

	public PontoVendaEJBPK getId() {
		return this.id;
	}

	public void setId(PontoVendaEJBPK id) {
		this.id = id;
	}

	public Long getControle() {
		return controle;
	}

	public void setControle(Long controle) {
		this.controle = controle;
	}

	public Long getIdPontoVenda() {
		return idPontoVenda;
	}

	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public Timestamp getDataPv() {
		return dataPv;
	}

	public void setDataPv(Timestamp dataPv) {
		this.dataPv = dataPv;
	}

	public Long getIdCentroCustoContabil() {
		return idCentroCustoContabil;
	}

	public void setIdCentroCustoContabil(Long idCentroCustoContabil) {
		this.idCentroCustoContabil = idCentroCustoContabil;
	}

	public Long getIdCheckin() {
		return idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public Long getIdPlanoContasAlimentos() {
		return idPlanoContasAlimentos;
	}

	public void setIdPlanoContasAlimentos(Long idPlanoContasAlimentos) {
		this.idPlanoContasAlimentos = idPlanoContasAlimentos;
	}

	public Long getIdPlanoContasBebidas() {
		return idPlanoContasBebidas;
	}

	public void setIdPlanoContasBebidas(Long idPlanoContasBebidas) {
		this.idPlanoContasBebidas = idPlanoContasBebidas;
	}

	public Long getIdPlanoContasOutros() {
		return idPlanoContasOutros;
	}

	public void setIdPlanoContasOutros(Long idPlanoContasOutros) {
		this.idPlanoContasOutros = idPlanoContasOutros;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public TipoLancamentoEJB getTipoLancamentoEJB() {
		return tipoLancamentoEJB;
	}

	public void setTipoLancamentoEJB(TipoLancamentoEJB tipoLancamentoEJB) {
		this.tipoLancamentoEJB = tipoLancamentoEJB;
	}

	public Long getIdTipoLancamentoServico() {
		return idTipoLancamentoServico;
	}

	public void setIdTipoLancamentoServico(Long idTipoLancamentoServico) {
		this.idTipoLancamentoServico = idTipoLancamentoServico;
	}

	public String getNomePontoVenda() {
		return nomePontoVenda;
	}

	public void setNomePontoVenda(String nomePontoVenda) {
		this.nomePontoVenda = nomePontoVenda;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public Double getPercTaxaServico() {
		return percTaxaServico;
	}

	public void setPercTaxaServico(Double percTaxaServico) {
		this.percTaxaServico = percTaxaServico;
	}

	public String getTipoPontoVenda() {
		return tipoPontoVenda;
	}

	public void setTipoPontoVenda(String tipoPontoVenda) {
		this.tipoPontoVenda = tipoPontoVenda;
	}

	public String getTipoVenda() {
		return tipoVenda;
	}

	public void setTipoVenda(String tipoVenda) {
		this.tipoVenda = tipoVenda;
	}

	public List<PratoPontoVendaEJB> getPratoPontoVendaEJBList() {
		return pratoPontoVendaEJBList;
	}

	public void setPratoPontoVendaEJBList(
			List<PratoPontoVendaEJB> pratoPontoVendaEJBList) {
		this.pratoPontoVendaEJBList = pratoPontoVendaEJBList;
	}

	public void addPrato(PratoPontoVendaEJB novoPrato) {
		novoPrato.setPontoVendaEJB(this);
		pratoPontoVendaEJBList.add(novoPrato);

	}

	public void addUsuario(UsuarioPontoVendaEJB novoUsuario) {
		novoUsuario.setPontoVendaEJB(this);
		// novoUsuario.getId().setIdPontoVenda(idPontoVenda);
		usuarioPontoVendaEJBList.add(novoUsuario);

	}

	public List<UsuarioPontoVendaEJB> getUsuarioPontoVendaEJBList() {
		return usuarioPontoVendaEJBList;
	}

	public void setUsuarioPontoVendaEJBList(
			List<UsuarioPontoVendaEJB> usuarioPontoVendaEJBList) {
		this.usuarioPontoVendaEJBList = usuarioPontoVendaEJBList;
	}

	public CheckinEJB getCheckinEJB() {
		return checkinEJB;
	}

	public void setCheckinEJB(CheckinEJB checkinEJB) {
		this.checkinEJB = checkinEJB;
	}

	public TipoLancamentoEJB getTipoLancamentoServicoEJB() {
		return tipoLancamentoServicoEJB;
	}

	public void setTipoLancamentoServicoEJB(
			TipoLancamentoEJB tipoLancamentoServicoEJB) {
		this.tipoLancamentoServicoEJB = tipoLancamentoServicoEJB;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public NfeImpressoraEJB getModeloImpressora() {
		return modeloImpressora;
	}

	public void setModeloImpressora(NfeImpressoraEJB modeloImpressora) {
		this.modeloImpressora = modeloImpressora;
	}

	public String getDefConsumidor1() {
		return defConsumidor1;
	}

	public void setDefConsumidor1(String defConsumidor1) {
		this.defConsumidor1 = defConsumidor1;
	}

	public String getDefConsumidor2() {
		return defConsumidor2;
	}

	public void setDefConsumidor2(String defConsumidor2) {
		this.defConsumidor2 = defConsumidor2;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
}