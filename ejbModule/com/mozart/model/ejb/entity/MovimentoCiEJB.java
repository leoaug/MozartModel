package com.mozart.model.ejb.entity;

import java.math.BigDecimal;
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
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MOVIMENTO_CI")
@NamedQuery(name = "MovimentoCiEJB.findAll", query = "SELECT m FROM MovimentoCiEJB m")
public class MovimentoCiEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_MOVIMENTO_CI", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_CI")
	@Column(name="ID_MOVIMENTO_CI")
	private Long idMovimentoCi;

	@Column(name="ID_USUARIO_CONSUMO_INTERNO")
	private Long idUsuariosConsumoInterno;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_PONTO_VENDA", referencedColumnName = "ID_PONTO_VENDA")
    })
    private PontoVendaEJB pontoVendaEJB;
	
	@ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO"),
    @JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
    })
    private PratoEJB pratoEJB;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_MOVIMENTO")
	private Date dataMovimento;

	@Column(name = "QTDE")
	private BigDecimal quantidade;

	@Column(name = "VALOR_UNITARIO_CUSTO")
	private BigDecimal valorUnitarioCusto;
	
	@Column(name = "VALOR_UNITARIO_VENDA")
	private BigDecimal valorUnitarioVenda;
	
	@Column(name = "NUM_DOCUMENTO")
	private String numDocumento;
	
	public MovimentoCiEJB() {
	}

	public Long getIdMovimentoCi() {
		return idMovimentoCi;
	}

	public void setIdMovimentoCi(Long idMovimentoCi) {
		this.idMovimentoCi = idMovimentoCi;
	}

	public Long getIdUsuariosConsumoInterno() {
		return idUsuariosConsumoInterno;
	}

	public void setIdUsuariosConsumoInterno(Long idUsuariosConsumoInterno) {
		this.idUsuariosConsumoInterno = idUsuariosConsumoInterno;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public PontoVendaEJB getPontoVendaEJB() {
		return pontoVendaEJB;
	}

	public void setPontoVendaEJB(PontoVendaEJB pontoVendaEJB) {
		this.pontoVendaEJB = pontoVendaEJB;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitarioCusto() {
		return valorUnitarioCusto;
	}

	public void setValorUnitarioCusto(BigDecimal valorUnitarioCusto) {
		this.valorUnitarioCusto = valorUnitarioCusto;
	}

	public BigDecimal getValorUnitarioVenda() {
		return valorUnitarioVenda;
	}

	public void setValorUnitarioVenda(BigDecimal valorUnitarioVenda) {
		this.valorUnitarioVenda = valorUnitarioVenda;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
}