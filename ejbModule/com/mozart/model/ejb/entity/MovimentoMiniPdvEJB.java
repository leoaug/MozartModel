package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the MOVIMENTO_MINI_PDV database table.
 * 
 */
@Entity
@Table(name="MOVIMENTO_MINI_PDV")
public class MovimentoMiniPdvEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="MOVIMENTO_MINI_PDV_IDMOVIMENTOMINIPDV_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMENTO_MINI_PDV_IDMOVIMENTOMINIPDV_GENERATOR")
	@Column(name="ID_MOVIMENTO_MINI_PDV")
	private Long idMovimentoMiniPdv;	

	private Timestamp data;

    @ManyToOne
    @JoinColumn(name = "ID_MOVIMENTO_APARTAMENTO", referencedColumnName = "ID_MOVIMENTO_APARTAMENTO")
    private MovimentoApartamentoEJB movimentoApartamentoEJB;
	
	@Column(name="ID_PDV")
	private Long idPdv;
	@Column(name="ID_ROOM_LIST")
	private Long idRoomList;	
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_TIPO", referencedColumnName = "ID_PRATO"),
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
    })
    private PratoEJB pratoEJB;
	
	private Double quantidade;
	private String tipo;
	@Column(name="VALOR_TOTAL")
	private Double valorTotal;

    public MovimentoMiniPdvEJB() {

    }
	
	public Long getIdMovimentoMiniPdv() {
		return this.idMovimentoMiniPdv;
	}

	public void setIdMovimentoMiniPdv(Long idMovimentoMiniPdv) {
		this.idMovimentoMiniPdv = idMovimentoMiniPdv;
	}
    
	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}
	
	public Long getIdPdv() {
		return this.idPdv;
	}

	public void setIdPdv(Long idPdv) {
		this.idPdv = idPdv;
	}
	
	public Long getIdRoomList() {
		return this.idRoomList;
	}

	public void setIdRoomList(Long idRoomList) {
		this.idRoomList = idRoomList;
	}

	public Double getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public MovimentoApartamentoEJB getMovimentoApartamentoEJB() {
		return movimentoApartamentoEJB;
	}

	public void setMovimentoApartamentoEJB(
			MovimentoApartamentoEJB movimentoApartamentoEJB) {
		this.movimentoApartamentoEJB = movimentoApartamentoEJB;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

}