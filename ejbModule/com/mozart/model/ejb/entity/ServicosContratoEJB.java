package com.mozart.model.ejb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "ServicosContratoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from ServicosContratoEJB o"),
})
@Table(name = "SERVICOS_CONTRATO")
public class ServicosContratoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_CONTRATO")
	@SequenceGenerator(name="SEQ_MOVIMENTO_ESTOQUE", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_ESTOQUE")
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    private EmpresaEJB empresaEJB;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO")
    })
    private TipoLancamentoEJB tipoLancamentoEJB;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
    @JoinColumn(name = "ID_TIPO_LANCAMENTO_CK", referencedColumnName = "ID_TIPO_LANCAMENTO")
    })
    private TipoLancamentoEJB tipoLancamentoCkEJB;

    @Column(name="CANCELADO")
    private String cancelado;
    
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INI")
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_FIM")
	private Date dataFim;
    
	@Column(name="DIA_FATURAMENTO")
    private String diaFaturamento;
	
	@Column(name="ISS")
    private String iss;

	@Column(name="QUANTIDADE")
    private String quantidade;
	
	@Column(name="TAXA_SERVICO")
    private String taxaServico;
		
    @Column(name="VALOR_UNITARIO")
    private Double valorUnitario;
    
    @Column(name="DESCRICAO_SERVICO")
    private String descricao;
    
    @Column(name="FORMA_REAJUSTE")
    private String formaReajuste;

    @Column(name="REALIZADO")
    private String realizado;

    @Column(name="SERIE")
    private String serie;
    
    public ServicosContratoEJB() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmpresaEJB getEmpresaEJB() {
		return empresaEJB;
	}

	public void setEmpresaEJB(EmpresaEJB empresaEJB) {
		this.empresaEJB = empresaEJB;
	}

	public TipoLancamentoEJB getTipoLancamentoEJB() {
		return tipoLancamentoEJB;
	}

	public void setTipoLancamentoEJB(TipoLancamentoEJB tipoLancamentoEJB) {
		this.tipoLancamentoEJB = tipoLancamentoEJB;
	}

	public String getCancelado() {
		return cancelado;
	}

	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDiaFaturamento() {
		return diaFaturamento;
	}

	public void setDiaFaturamento(String diaFaturamento) {
		this.diaFaturamento = diaFaturamento;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(String taxaServico) {
		this.taxaServico = taxaServico;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFormaReajuste() {
		return formaReajuste;
	}

	public void setFormaReajuste(String formaReajuste) {
		this.formaReajuste = formaReajuste;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public TipoLancamentoEJB getTipoLancamentoCkEJB() {
		return tipoLancamentoCkEJB;
	}

	public void setTipoLancamentoCkEJB(TipoLancamentoEJB tipoLancamentoCkEJB) {
		this.tipoLancamentoCkEJB = tipoLancamentoCkEJB;
	}

	public String getRealizado() {
		return realizado;
	}

	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	
}
