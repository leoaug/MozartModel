package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DUPLICATA")
public class DuplicataEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="DUP_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUP_GENERATOR")
	@Column(name="ID_DUPLICATA")
	private Long idDuplicata;

	private String agrupar;

	private Double ajustes;

	private Long ano;

	private Double cofins;

	private Double comissao;

	@OneToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CONTA_CORRENTE", referencedColumnName="ID_CONTA_CORRENTE")
	private ContaCorrenteEJB contaCorrente;

	private Double cssl;
    
	@Column(name="DATA_DESCONTO")
	private Timestamp dataDesconto;
    
	@Column(name="DATA_LANCAMENTO")
	private Timestamp dataLancamento;

	@Column(name="DATA_LIQUIDACAO")
	private Timestamp dataLiquidacao;
    
	@Column(name="DATA_RECEBIMENTO")
	private Timestamp dataRecebimento;
    
	@Column(name="DATA_RECOMPRA")
	private Timestamp dataRecompra;
    
	@Column(name="DATA_VENCIMENTO")
	private Timestamp dataVencimento;

	@Column(name="DESCONTO_RECEBIMENTO")
	private Double descontoRecebimento;

	@Column(name="DESP_FINANCEIRA")
	private Double despFinanceira;

	private Double encargos;

	@Column(name="HISTORICO_COMPLEMENTAR")
	private String historicoComplementar;
	
	@Column(name="NUM_DOCUMENTO")
	private String numDocumento;

	@Column(name="ID_CENTRO_CUSTO_CONTABIL")
	private Long idCentroCustoContabil;

	@Column(name="ID_DUPLICATA_DESCONTADA")
	private Long idDuplicataDescontada;

    @OneToOne(optional=false, fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    })
    private EmpresaHotelEJB empresaHotelEJB;
    
    @OneToMany(mappedBy="duplicataEJB", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<DuplicataHistoricoEJB> duplicataHistoricoEJBList;
    
	@Column(name="ID_HOSPEDE")
	private Long idHospede;

	@Column(name="ID_HOTEL_MUTUO")
	private Long idHotelMutuo;

	@Column(name="ID_NOTA")
	private Long idNota;

	@Column(name="ID_PLANO_CONTAS")
	private Long idPlanoContas;

	@Column(name="ID_PLANO_CONTAS_FINANCEIRO")
	private Long idPlanoContasFinanceiro;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	private String imprimir;

	private Double ir;

	@Column(name="IR_RETENCAO")
	private Double irRetencao;

	private Double iss;

	@Column(name="JUROS_RECEBIMENTO")
	private Double jurosRecebimento;

	@Column(name="JUSTIFICA_AJUSTE")
	private String justificaAjuste;

	@Column(name="NUM_DUPLICATA")
	private String numDuplicata;

	@Column(name="NUM_PARCELAS")
	private Long numParcelas;

	private Double pis;

    private Timestamp prorrogado;

	private String recebimento;

	@Column(name="SEQUENCIA_BANCARIA")
	private Long sequenciaBancaria;

	private String situacao;

	@Column(name="STATUS_BANCO")
	private String statusBanco;

	@Column(name="VALOR_DUPLICATA")
	private Double valorDuplicata;

	@Column(name="VALOR_RECEBIDO")
	private Double valorRecebido;

    public DuplicataEJB() {
    	duplicataHistoricoEJBList = new ArrayList<DuplicataHistoricoEJB>();
    }
    
    public DuplicataEJB clone(){
    	DuplicataEJB clone = new DuplicataEJB();
    	clone.setIdDuplicata( this.getIdDuplicata());
    	clone.setAgrupar( this.getAgrupar() );
		clone.setAno( this.getAno() );
		clone.setContaCorrente( this.getContaCorrente() );
		clone.setDataVencimento( this.getDataVencimento() );
		clone.setDataDesconto( this.getDataDesconto() );
		clone.setDataLancamento( this.getDataLancamento() );
		clone.setDataLiquidacao( this.getDataLiquidacao() );
		clone.setDataRecebimento( this.getDataRecebimento() );
		clone.setDataRecompra( this.getDataRecompra());
		clone.setDescontoRecebimento( this.getDescontoRecebimento() );
		clone.setDespFinanceira( this.getDespFinanceira());
		clone.setEmpresaHotelEJB( this.getEmpresaHotelEJB());
		clone.setHistoricoComplementar( this.getHistoricoComplementar() );
		clone.setIdCentroCustoContabil( this.getIdCentroCustoContabil() );
		clone.setIdDuplicataDescontada( this.getIdDuplicataDescontada() );
		clone.setIdHospede( this.getIdHospede() );
		clone.setIdHotelMutuo( this.getIdHotelMutuo() );
		clone.setIdNota( this.getIdNota() );
		clone.setIdPlanoContas( this.getIdPlanoContas() );
		clone.setIdPlanoContasFinanceiro( this.getIdPlanoContasFinanceiro() );
		clone.setIdRedeHotel( this.getIdRedeHotel() );
		clone.setImprimir( this.getImprimir() );
		clone.setJurosRecebimento( this.getJurosRecebimento());
		clone.setNumDuplicata( this.getNumDuplicata() );
		clone.setProrrogado( this.getProrrogado());
		clone.setRecebimento( this.getRecebimento() );
		clone.setSequenciaBancaria( this.getSequenciaBancaria() );
		clone.setSituacao( this.getSituacao() );
		clone.setStatusBanco( this.getStatusBanco() );
		clone.setValorDuplicata( this.getValorDuplicata() );
		clone.setValorRecebido( this.getValorRecebido() );
		clone.setNumParcelas( this.getNumParcelas() );
		clone.setNumDocumento( this.getNumDocumento() );
    	return clone;
    }

    
	public Double getValorLiquido() {
		double valorLiquido = valorDuplicata.doubleValue() + (ir == null?0:ir.doubleValue()) - 
						(comissao==null?0:comissao.doubleValue()) -  (ajustes==null?0:ajustes.doubleValue()) -
						(encargos==null?0:encargos.doubleValue());
		return new Double(valorLiquido);
	}
	
	public Double getValorAlteracao() {
		double valorLiquido = valorDuplicata.doubleValue() + (ir == null?0:ir.doubleValue()) - 
						(comissao==null?0:comissao.doubleValue()) -  (ajustes==null?0:ajustes.doubleValue()) -
						(encargos==null?0:encargos.doubleValue()) -  (irRetencao==null?0:irRetencao.doubleValue()) -
						(cofins==null?0:cofins.doubleValue()) - (pis==null?0:pis.doubleValue()) -
						(cssl==null?0:cssl.doubleValue()) - (iss==null?0:iss.doubleValue());
		return new Double(valorLiquido);
	}
	
	public String getAgrupar() {
		return this.agrupar;
	}

	public void setAgrupar(String agrupar) {
		this.agrupar = agrupar;
	}

	public Double getAjustes() {
		return this.ajustes;
	}

	public void setAjustes(Double ajustes) {
		this.ajustes = ajustes;
	}

	public Long getAno() {
		return this.ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Double getCofins() {
		return this.cofins;
	}

	public void setCofins(Double cofins) {
		this.cofins = cofins;
	}

	public Double getComissao() {
		return this.comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public ContaCorrenteEJB getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrenteEJB contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Double getCssl() {
		return this.cssl;
	}

	public void setCssl(Double cssl) {
		this.cssl = cssl;
	}

	public Timestamp getDataDesconto() {
		return this.dataDesconto;
	}

	public void setDataDesconto(Timestamp dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public Timestamp getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Timestamp dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Timestamp getDataLiquidacao() {
		return this.dataLiquidacao;
	}

	public void setDataLiquidacao(Timestamp dataLiquidacao) {
		this.dataLiquidacao = dataLiquidacao;
	}

	public Timestamp getDataRecebimento() {
		return this.dataRecebimento;
	}

	public void setDataRecebimento(Timestamp dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Timestamp getDataRecompra() {
		return this.dataRecompra;
	}

	public void setDataRecompra(Timestamp dataRecompra) {
		this.dataRecompra = dataRecompra;
	}

	public Timestamp getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Timestamp dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDescontoRecebimento() {
		return this.descontoRecebimento;
	}

	public void setDescontoRecebimento(Double descontoRecebimento) {
		this.descontoRecebimento = descontoRecebimento;
	}

	public Double getDespFinanceira() {
		return this.despFinanceira;
	}

	public void setDespFinanceira(Double despFinanceira) {
		this.despFinanceira = despFinanceira;
	}

	public Double getEncargos() {
		return this.encargos;
	}

	public void setEncargos(Double encargos) {
		this.encargos = encargos;
	}

	public String getHistoricoComplementar() {
		return this.historicoComplementar;
	}

	public void setHistoricoComplementar(String historicoComplementar) {
		this.historicoComplementar = historicoComplementar;
	}

	public Long getIdCentroCustoContabil() {
		return this.idCentroCustoContabil;
	}

	public void setIdCentroCustoContabil(Long idCentroCustoContabil) {
		this.idCentroCustoContabil = idCentroCustoContabil;
	}

	public Long getIdDuplicataDescontada() {
		return this.idDuplicataDescontada;
	}

	public void setIdDuplicataDescontada(Long idDuplicataDescontada) {
		this.idDuplicataDescontada = idDuplicataDescontada;
	}

	public Long getIdHospede() {
		return this.idHospede;
	}

	public void setIdHospede(Long idHospede) {
		this.idHospede = idHospede;
	}

	public Long getIdHotelMutuo() {
		return this.idHotelMutuo;
	}

	public void setIdHotelMutuo(Long idHotelMutuo) {
		this.idHotelMutuo = idHotelMutuo;
	}

	public Long getIdNota() {
		return this.idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
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

	public String getImprimir() {
		return this.imprimir;
	}

	public void setImprimir(String imprimir) {
		this.imprimir = imprimir;
	}

	public Double getIr() {
		return this.ir;
	}

	public void setIr(Double ir) {
		this.ir = ir;
	}

	public Double getIrRetencao() {
		return this.irRetencao;
	}

	public void setIrRetencao(Double irRetencao) {
		this.irRetencao = irRetencao;
	}

	public Double getIss() {
		return this.iss;
	}

	public void setIss(Double iss) {
		this.iss = iss;
	}

	public Double getJurosRecebimento() {
		return this.jurosRecebimento;
	}

	public void setJurosRecebimento(Double jurosRecebimento) {
		this.jurosRecebimento = jurosRecebimento;
	}

	public String getJustificaAjuste() {
		return this.justificaAjuste;
	}

	public void setJustificaAjuste(String justificaAjuste) {
		this.justificaAjuste = justificaAjuste;
	}

	public String getNumDuplicata() {
		return this.numDuplicata;
	}

	public void setNumDuplicata(String numDuplicata) {
		this.numDuplicata = numDuplicata;
	}

	public Long getNumParcelas() {
		return this.numParcelas;
	}

	public void setNumParcelas(Long numParcelas) {
		this.numParcelas = numParcelas;
	}

	public Double getPis() {
		return this.pis;
	}

	public void setPis(Double pis) {
		this.pis = pis;
	}

	public Timestamp getProrrogado() {
		return this.prorrogado;
	}

	public void setProrrogado(Timestamp prorrogado) {
		this.prorrogado = prorrogado;
	}

	public String getRecebimento() {
		return this.recebimento;
	}

	public void setRecebimento(String recebimento) {
		this.recebimento = recebimento;
	}

	public Long getSequenciaBancaria() {
		return this.sequenciaBancaria;
	}

	public void setSequenciaBancaria(Long sequenciaBancaria) {
		this.sequenciaBancaria = sequenciaBancaria;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getStatusBanco() {
		return this.statusBanco;
	}

	public void setStatusBanco(String statusBanco) {
		this.statusBanco = statusBanco;
	}

	public Double getValorDuplicata() {
		return this.valorDuplicata;
	}

	public void setValorDuplicata(Double valorDuplicata) {
		this.valorDuplicata = valorDuplicata;
	}

	public Double getValorRecebido() {
		return this.valorRecebido;
	}

	public void setValorRecebido(Double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public Long getIdDuplicata() {
		return idDuplicata;
	}

	public void setIdDuplicata(Long idDuplicata) {
		this.idDuplicata = idDuplicata;
	}

	public EmpresaHotelEJB getEmpresaHotelEJB() {
		return empresaHotelEJB;
	}

	public void setEmpresaHotelEJB(EmpresaHotelEJB empresaHotelEJB) {
		this.empresaHotelEJB = empresaHotelEJB;
	}

	public List<DuplicataHistoricoEJB> getDuplicataHistoricoEJBList() {
		return duplicataHistoricoEJBList;
	}

	public void setDuplicataHistoricoEJBList(
			List<DuplicataHistoricoEJB> duplicataHistoricoEJBList) {
		this.duplicataHistoricoEJBList = duplicataHistoricoEJBList;
	}

	public void addDuplicataHistoricoEJB(DuplicataHistoricoEJB entidadeHistorico) {
		if (entidadeHistorico != null){
			entidadeHistorico.setDuplicataEJB(this);
			duplicataHistoricoEJBList.add( entidadeHistorico );
		}
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
}