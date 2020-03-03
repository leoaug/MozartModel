package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="MOVIMENTO_CONTABIL")
public class MovimentoContabilEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVC_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVC_GENERATOR")
	@Column(name="ID_MOVIMENTO_CONTABIL")
	private Long idMovimentoContabil;
	
	// TODO: (ID / Conta Corrente) Atributo incompativel, nao obtem entidade
	@Column(name="ID_CONTA_CORRENTE")
	private Long contaCorrente;

	@Column(name="CONTROLE_ATIVO_FIXO")
	private Long controleAtivoFixo;

    
	@Column(name="DATA_DOCUMENTO")
	private Timestamp dataDocumento;

	@Column(name="DEBITO_CREDITO")
	private String debitoCredito;

	@Column(name="ID_DUPLICATA")
	private Long idDuplicata;

	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	@Column(name="ID_SEQ_CONTABIL")
	private Long idSeqContabil;

	@Column(name="ID_PATRIMONIO_SETOR")
	private Long idPatrimonioSetor;

	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_PLANO_CONTAS", referencedColumnName="ID_PLANO_CONTAS")
    private PlanoContaEJB planoContaEJB;

	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_CONTAS_PAGAR", referencedColumnName="ID_CONTAS_PAGAR")
	private ContasPagarEJB contasPagarEJB;

	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_HISTORICO", referencedColumnName="ID_HISTORICO")
	private HistoricoContabilEJB historicoContabilEJB;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_CENTRO_CUSTO", referencedColumnName="ID_CENTRO_CUSTO_CONTABIL")
	private CentroCustoContabilEJB centroCustoContabilEJB;
	

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@ManyToOne(cascade={CascadeType.REFRESH} )
    @JoinColumn(name = "ID_TESOURARIA", referencedColumnName = "ID_TESOURARIA")
    private TesourariaEJB tesourariaEJB;


	@Column(name="NUM_DOCUMENTO")
	private String numDocumento;

	private String pis;

	@Column(name="TIPO_MOVIMENTO")
	private String tipoMovimento;

	private Double valor;

	@Transient
	private String lancarContasPagarCredito;
	
	@Transient
	private String contaCorrenteTxt;
	
	@Transient
	private String executarLancamentoAnual;
	
	public MovimentoContabilEJB() {
    }

	public Long getIdMovimentoContabil() {
		return idMovimentoContabil;
	}

	public void setIdMovimentoContabil(Long idMovimentoContabil) {
		this.idMovimentoContabil = idMovimentoContabil;
	}

	public Long getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Long getControleAtivoFixo() {
		return controleAtivoFixo;
	}

	public void setControleAtivoFixo(Long controleAtivoFixo) {
		this.controleAtivoFixo = controleAtivoFixo;
	}

	public Timestamp getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Timestamp dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public Long getIdDuplicata() {
		return idDuplicata;
	}

	public void setIdDuplicata(Long idDuplicata) {
		this.idDuplicata = idDuplicata;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdPatrimonioSetor() {
		return idPatrimonioSetor;
	}

	public void setIdPatrimonioSetor(Long idPatrimonioSetor) {
		this.idPatrimonioSetor = idPatrimonioSetor;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ContasPagarEJB getContasPagarEJB() {
		return contasPagarEJB;
	}

	public void setContasPagarEJB(ContasPagarEJB contasPagarEJB) {
		this.contasPagarEJB = contasPagarEJB;
	}

	public PlanoContaEJB getPlanoContaEJB() {
		return planoContaEJB;
	}

	public void setPlanoContaEJB(PlanoContaEJB planoContaEJB) {
		this.planoContaEJB = planoContaEJB;
	}

	public HistoricoContabilEJB getHistoricoContabilEJB() {
		return historicoContabilEJB;
	}

	public void setHistoricoContabilEJB(HistoricoContabilEJB historicoContabilEJB) {
		this.historicoContabilEJB = historicoContabilEJB;
	}

	public CentroCustoContabilEJB getCentroCustoContabilEJB() {
		return centroCustoContabilEJB;
	}

	public void setCentroCustoContabilEJB(
			CentroCustoContabilEJB centroCustoContabilEJB) {
		this.centroCustoContabilEJB = centroCustoContabilEJB;
	}

	public String getLancarContasPagarCredito() {
		return lancarContasPagarCredito;
	}

	public void setLancarContasPagarCredito(String lancarContasPagarCredito) {
		this.lancarContasPagarCredito = lancarContasPagarCredito;
	}

	public String getContaCorrenteTxt() {
		return contaCorrenteTxt;
	}

	public void setContaCorrenteTxt(String contaCorrenteTxt) {
		this.contaCorrenteTxt = contaCorrenteTxt;
	}

	public TesourariaEJB getTesourariaEJB() {
		return tesourariaEJB;
	}

	public void setTesourariaEJB(TesourariaEJB tesourariaEJB) {
		this.tesourariaEJB = tesourariaEJB;
	}

	public String getExecutarLancamentoAnual() {
		return executarLancamentoAnual;
	}

	public void setExecutarLancamentoAnual(String executarLancamentoAnual) {
		this.executarLancamentoAnual = executarLancamentoAnual;
	}

	public Long getIdSeqContabil() {
		return idSeqContabil;
	}

	public void setIdSeqContabil(Long idSeqContabil) {
		this.idSeqContabil = idSeqContabil;
	}
	
	
}