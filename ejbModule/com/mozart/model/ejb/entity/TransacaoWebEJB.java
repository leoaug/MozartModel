package com.mozart.model.ejb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the TRANSACAO_WEB database table.
 * 
 */
@Entity
@Table(name="TRANSACAO_WEB")
public class TransacaoWebEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACAO_WEB_IDTRANSACAOWEB_GENERATOR", sequenceName="ID_BRASPAG", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACAO_WEB_IDTRANSACAOWEB_GENERATOR")
	@Column(name="ID_TRANSACAO_WEB")
	private long idTransacaoWeb;

	@Column(name="COD_AUTORIZACAO")
	private String codAutorizacao;

	@Column(name="COD_RETORNO")
	private String codRetorno;

	@Column(name="COD_TRANSACAO")
	private String codTransacao;

	@Column(name="ID_CHECKIN")
	private Long idCheckin;

    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO")
    })
    private TipoLancamentoEJB tipoLancamentoEJB;


	@Column(name="NOME_CARTAO")
	private String nomeCartao;

	@Column(name="NUMERO_CARTAO")
	private String numeroCartao;

	@Column(name="VALIDADE")
	private String validade;

	@Column(name="COD_SEGURANCA")
	private String codSeguranca;

	@Column(name="TXT_MENSAGEM")
	private String txtMensagem;
	
	
	@Column(name="DATA_TRANSACAO")
	private Timestamp dataTransacao;
	
	@Column(name="VALOR_TRANSACAO")
	private Double valorTransacao;
	
	@Column(name="STATUS")
	private Long status;

	@Column(name="ID_RESERVA")
	private Long idReserva;

	@Transient
	private HotelEJB hotelEJB;

    public TransacaoWebEJB() {
    }

	public long getIdTransacaoWeb() {
		return this.idTransacaoWeb;
	}

	public void setIdTransacaoWeb(long idTransacaoWeb) {
		this.idTransacaoWeb = idTransacaoWeb;
	}

	public String getCodAutorizacao() {
		return this.codAutorizacao;
	}

	public void setCodAutorizacao(String codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}

	public String getCodRetorno() {
		return this.codRetorno;
	}

	public void setCodRetorno(String codRetorno) {
		this.codRetorno = codRetorno;
	}

	public String getCodTransacao() {
		return this.codTransacao;
	}

	public void setCodTransacao(String codTransacao) {
		this.codTransacao = codTransacao;
	}

	public Long getIdCheckin() {
		return this.idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public String getNomeCartao() {
		return this.nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getTxtMensagem() {
		return this.txtMensagem;
	}

	public void setTxtMensagem(String txtMensagem) {
		this.txtMensagem = txtMensagem;
	}

	public Timestamp getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Timestamp dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public TipoLancamentoEJB getTipoLancamentoEJB() {
		return tipoLancamentoEJB;
	}

	public void setTipoLancamentoEJB(TipoLancamentoEJB tipoLancamentoEJB) {
		this.tipoLancamentoEJB = tipoLancamentoEJB;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	public HotelEJB getHotelEJB() {
		return hotelEJB;
	}

	public void setHotelEJB(HotelEJB hotelEJB) {
		this.hotelEJB = hotelEJB;
	}

	public Double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(Double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

}