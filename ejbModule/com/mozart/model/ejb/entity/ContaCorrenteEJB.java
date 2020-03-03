package com.mozart.model.ejb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CONTA_CORRENTE_X")
public class ContaCorrenteEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequenceGen")
    @SequenceGenerator(name="sequenceGen", sequenceName="SEQ_CONTA_CORRENTE", allocationSize=1)
	@Column(name="ID_CONTA_CORRENTE")
	private Long id;
	
	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	private String carteira;

	private String cobranca;
	
	@Column(name="DIGITO_AGENCIA")
	private Long digitoAgencia;

	@Column(name="DIGITO_CONTA")
	private Long digitoConta;

	private Long flooting;

	@Column(name="FLUXO_CAIXA")
	private String fluxoCaixa;
	
	@OneToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_BANCO", referencedColumnName="ID_BANCO")
	private BancoEJB bancoEJB;

	@Column(name="ID_CENTRO_CUSTO_C")
	private Long idCentroCustoC;

	@Column(name="ID_CENTRO_CUSTO_CONTABIL_D")
	private Long idCentroCustoContabilD;

	@Column(name="ID_CONTABIL_PAG")
	private Long idContabilPag;

	@Column(name="ID_CONTABIL_REC")
	private Long idContabilRec;

	@Column(name="ID_HISTORICO_CREDITO")
	private Long idHistoricoCredito;

	@Column(name="ID_HISTORICO_DEBITO")
	private Long idHistoricoDebito;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NOME_AGENCIA")
	private String nomeAgencia;

	@Column(name="NUM_CARTEIRA")
	private String numCarteira;
	
	@Column(name="ESPECIE_DOCUMENTO")
	private String especieDocumento;

	@Column(name="NUMERO_AGENCIA")
	private Long numeroAgencia;
	
	@Column(name="NUM_CONTA_CORRENTE")
	private Long numContaCorrente;

	private String pagamento;

	@Column(name="SALDO_MES")
	private Double saldoMes;

	@Column(name="ULTIMO_CHEQUE")
	private Long ultimoCheque;
	
	@Column(name="CODIGO_BRADESCO")
	private Long codigoBradesco;

    public ContaCorrenteEJB() {
    }

	public String getCarteira() {
		return this.carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public String getCobranca() {
		return this.cobranca;
	}

	public void setCobranca(String cobranca) {
		this.cobranca = cobranca;
	}

	public Long getDigitoAgencia() {
		return this.digitoAgencia;
	}

	public void setDigitoAgencia(Long digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public Long getDigitoConta() {
		return this.digitoConta;
	}

	public void setDigitoConta(Long digitoConta) {
		this.digitoConta = digitoConta;
	}

	public Long getFlooting() {
		return this.flooting;
	}

	public void setFlooting(Long flooting) {
		this.flooting = flooting;
	}

	public String getFluxoCaixa() {
		return this.fluxoCaixa;
	}

	public void setFluxoCaixa(String fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	public Long getIdCentroCustoC() {
		return this.idCentroCustoC;
	}

	public void setIdCentroCustoC(Long idCentroCustoC) {
		this.idCentroCustoC = idCentroCustoC;
	}

	public Long getIdCentroCustoContabilD() {
		return this.idCentroCustoContabilD;
	}

	public void setIdCentroCustoContabilD(Long idCentroCustoContabilD) {
		this.idCentroCustoContabilD = idCentroCustoContabilD;
	}

	public Long getIdContabilPag() {
		return this.idContabilPag;
	}

	public void setIdContabilPag(Long idContabilPag) {
		this.idContabilPag = idContabilPag;
	}

	public Long getIdContabilRec() {
		return this.idContabilRec;
	}

	public void setIdContabilRec(Long idContabilRec) {
		this.idContabilRec = idContabilRec;
	}

	public Long getIdHistoricoCredito() {
		return this.idHistoricoCredito;
	}

	public void setIdHistoricoCredito(Long idHistoricoCredito) {
		this.idHistoricoCredito = idHistoricoCredito;
	}

	public Long getIdHistoricoDebito() {
		return this.idHistoricoDebito;
	}

	public void setIdHistoricoDebito(Long idHistoricoDebito) {
		this.idHistoricoDebito = idHistoricoDebito;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeAgencia() {
		return this.nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public String getNumCarteira() {
		return this.numCarteira;
	}

	public void setNumCarteira(String numCarteira) {
		this.numCarteira = numCarteira;
	}

	public Long getNumeroAgencia() {
		return this.numeroAgencia;
	}

	public void setNumeroAgencia(Long numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getPagamento() {
		return this.pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public Double getSaldoMes() {
		return this.saldoMes;
	}

	public void setSaldoMes(Double saldoMes) {
		this.saldoMes = saldoMes;
	}

	public Long getUltimoCheque() {
		return this.ultimoCheque;
	}

	public void setUltimoCheque(Long ultimoCheque) {
		this.ultimoCheque = ultimoCheque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BancoEJB getBancoEJB() {
		return bancoEJB;
	}

	public void setBancoEJB(BancoEJB bancoEJB) {
		this.bancoEJB = bancoEJB;
	}
	
	public Long getCodigoBradesco() {
		return codigoBradesco;
	}

	public void setCodigoBradesco(Long codigoBradesco) {
		this.codigoBradesco = codigoBradesco;
	}
	
	public String getEspecieDocumento() {
		return especieDocumento;
	}

	public void setEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
	}

	public Long getNumContaCorrente() {
		return numContaCorrente;
	}

	public void setNumContaCorrente(Long numContaCorrente) {
		this.numContaCorrente = numContaCorrente;
	}

	public String toString(){
		return numContaCorrente + " - " + numeroAgencia + " - " + (bancoEJB==null?bancoEJB.getNomeFantasia():"");
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
}