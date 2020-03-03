package com.mozart.model.ejb.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




/**
 * The persistent class for the MOVIMENTO_RESTAURANTE database table.
 * 
 */
@Entity
@Table(name="MOVIMENTO_RESTAURANTE")
@NamedQuery(name="MovimentoRestaurante.findAll", query="SELECT m FROM MovimentoRestauranteEJB m")
public class MovimentoRestauranteEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MOVIMENTO")
	private Date dataMovimento;

	@Column(name="ID_CAIXA_PONTO_VENDA")
	private Long idCaixaPontoVenda;

	@Column(name="ID_CHECKIN")
	private Long idCheckin;

	@Column(name="ID_GARCON")
	private Long idGarcon;

	@Column(name="ID_HOSPEDE")
	private Long idHospede;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_MESA")
	private Long idMesa;

	@Column(name="ID_MOV")
	private Long idMov;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqMovimentoRestaurante")
    @SequenceGenerator(name="idSeqMovimentoRestaurante", sequenceName="id", allocationSize=1)
	@Column(name="ID_MOVIMENTO_RESTAURANTE")
	private Long idMovimentoRestaurante;

	@Column(name="ID_NOTA")
	private Long idNota;

	@Column(name="ID_PONTO_VENDA")
	private Long idPontoVenda;

	@Column(name="ID_PRATO")
	private Long idPrato;

	@Column(name="ID_TIPO_LANCAMENTO")
	private Long idTipoLancamento;

	@Column(name="ID_USUARIOS_CONSUMO_INTERNO")
	private Long idUsuariosConsumoInterno;

	@Column(name="NUM_COMANDA")
	private String numComanda;

	@Column(name="NUM_NOTA")
	private String numNota;

	@Column(name="QUANTIDADE")
	private BigDecimal quantidade;

	private BigDecimal seq;

	private String status;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="VALOR_PRATO")
	private BigDecimal valorPrato;

	@Column(name="VALOR_TAXA_SERVICO")
	private BigDecimal valorTaxaServico;

	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_PRATO", referencedColumnName="ID_PRATO", insertable=false, updatable=false),
		@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL", insertable=false, updatable=false)
	})
	private PratoEJB pratoEJB;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_GARCON", referencedColumnName="ID_GARCON", insertable=false, updatable=false)
	})
	private GarconEJB garconEJB;

	public MovimentoRestauranteEJB() {
	}

	public Date getDataMovimento() {
		return this.dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public Long getIdCaixaPontoVenda() {
		return this.idCaixaPontoVenda;
	}

	public void setIdCaixaPontoVenda(Long idCaixaPontoVenda) {
		this.idCaixaPontoVenda = idCaixaPontoVenda;
	}

	public Long getIdCheckin() {
		return this.idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public Long getIdGarcon() {
		return this.idGarcon;
	}

	public void setIdGarcon(Long idGarcon) {
		this.idGarcon = idGarcon;
	}

	public Long getIdHospede() {
		return this.idHospede;
	}

	public void setIdHospede(Long idHospede) {
		this.idHospede = idHospede;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public Long getIdMov() {
		return this.idMov;
	}

	public void setIdMov(Long idMov) {
		this.idMov = idMov;
	}

	public Long getIdMovimentoRestaurante() {
		return this.idMovimentoRestaurante;
	}

	public void setIdMovimentoRestaurante(Long idMovimentoRestaurante) {
		this.idMovimentoRestaurante = idMovimentoRestaurante;
	}

	public Long getIdNota() {
		return this.idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Long getIdPontoVenda() {
		return this.idPontoVenda;
	}

	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public Long getIdPrato() {
		return this.idPrato;
	}

	public void setIdPrato(Long idPrato) {
		this.idPrato = idPrato;
	}

	public Long getIdTipoLancamento() {
		return this.idTipoLancamento;
	}

	public void setIdTipoLancamento(Long idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public Long getIdUsuariosConsumoInterno() {
		return this.idUsuariosConsumoInterno;
	}

	public void setIdUsuariosConsumoInterno(Long idUsuariosConsumoInterno) {
		this.idUsuariosConsumoInterno = idUsuariosConsumoInterno;
	}

	public String getNumComanda() {
		return this.numComanda;
	}

	public void setNumComanda(String numComanda) {
		this.numComanda = numComanda;
	}

	public String getNumNota() {
		return this.numNota;
	}

	public void setNumNota(String numNota) {
		this.numNota = numNota;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getSeq() {
		return this.seq;
	}

	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorPrato() {
		return this.valorPrato;
	}

	public void setValorPrato(BigDecimal valorPrato) {
		this.valorPrato = valorPrato;
	}

	public BigDecimal getValorTaxaServico() {
		return this.valorTaxaServico;
	}

	public void setValorTaxaServico(BigDecimal valorTaxaServico) {
		this.valorTaxaServico = valorTaxaServico;
	}

	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;	
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

	public GarconEJB getGarconEJB() {
		return garconEJB;
	}

	public void setGarconEJB(GarconEJB garconEJB) {
		this.garconEJB = garconEJB;
	}
	

}