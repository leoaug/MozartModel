package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="TESOURARIA")
public class TesourariaEJB extends MozartEntity{

	private static final long serialVersionUID = 7334785961248839333L;

	@Id
	@SequenceGenerator(name="TES_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TES_GENERATOR")
	@Column(name="ID_TESOURARIA")
	private Long idTesouraria;
	
	@Column(name="COMPLEMENTO_HISTORICO")
	private String complementoHistorico;

	private String conciliado;

	// TODO: (ID / Conta Corrente) Atributo incompativel, nao obtem entidade
	@Column(name="ID_CONTA_CORRENTE")
	private Long contaCorrente;

	@Column(name="DATA_CONCILIADO")
	private Timestamp dataConciliado;
    
	@Column(name="DATA_LANCAMENTO")
	private Timestamp dataLancamento;

	@Column(name="DEBITO_CREDITO")
	private String debitoCredito;

	@Column(name="ID_FORNECEDOR_GRUPO")
	private Long idFornecedorGrupo;

	@Column(name="ID_HISTORICO")
	private Long idHistorico;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_PLANO_CONTAS")
	private Long idPlanoContas;

	@Column(name="ID_PLANO_CONTAS_FINANCEIRO")
	private Long idPlanoContasFinanceiro;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NUM_DOCUMENTO")
	private String numDocumento;

	@Column(name="TIPO_MOVIMENTACAO")
	private String tipoMovimentacao;

	private Double valor;

	@OneToMany(mappedBy = "tesourariaEJB", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	private List<MovimentoContabilEJB> movimentoContabilEJBList;
	
    public TesourariaEJB() {
    }

	public String getComplementoHistorico() {
		return this.complementoHistorico;
	}

	public void setComplementoHistorico(String complementoHistorico) {
		this.complementoHistorico = complementoHistorico;
	}

	public String getConciliado() {
		return this.conciliado;
	}

	public void setConciliado(String conciliado) {
		this.conciliado = conciliado;
	}

	public Long getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Timestamp getDataConciliado() {
		return this.dataConciliado;
	}

	public void setDataConciliado(Timestamp dataConciliado) {
		this.dataConciliado = dataConciliado;
	}

	public Timestamp getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Timestamp dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDebitoCredito() {
		return this.debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public Long getIdFornecedorGrupo() {
		return this.idFornecedorGrupo;
	}

	public void setIdFornecedorGrupo(Long idFornecedorGrupo) {
		this.idFornecedorGrupo = idFornecedorGrupo;
	}

	public Long getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdPlanoContas() {
		return this.idPlanoContas;
	}

	public void setIdPlanoContas(Long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}

	public Long getIdPlanoContasFinanceiro() {
		return this.idPlanoContasFinanceiro;
	}

	public void setIdPlanoContasFinanceiro(Long idPlanoContasFinanceiro) {
		this.idPlanoContasFinanceiro = idPlanoContasFinanceiro;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Long getIdTesouraria() {
		return this.idTesouraria;
	}

	public void setIdTesouraria(Long idTesouraria) {
		this.idTesouraria = idTesouraria;
	}

	public String getNumDocumento() {
		return this.numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getTipoMovimentacao() {
		return this.tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void addMovimentoContabilEJB(MovimentoContabilEJB mov) {
		if (movimentoContabilEJBList == null)
			movimentoContabilEJBList = new ArrayList<MovimentoContabilEJB>();
		mov.setTesourariaEJB( this );
		movimentoContabilEJBList.add( mov );
	}
	
	public List<MovimentoContabilEJB> getMovimentoContabilEJBList() {
		return movimentoContabilEJBList;
	}

	public void setMovimentoContabilEJBList(
			List<MovimentoContabilEJB> movimentoContabilEJBList) {
		this.movimentoContabilEJBList = movimentoContabilEJBList;
	}
}