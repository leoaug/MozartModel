package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the MESA database table.
 * 
 */
@Entity
@Table(name="MESA")
public class MesaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqMesa")
    @SequenceGenerator(name="idSeqMesa", sequenceName="id", allocationSize=1)
	@Column(name="ID_MESA")
	private Long idMesa;

	@Column(name="CONTATO_RESERVA")
	private String contatoReserva;

	@Column(name="ID_GARCON")
	private Long idGarcon;

	@Column(name="LOCALIZACAO_MESA")
	private String localizacaoMesa;

	@Column(name="NUM_MESA")
	private Long numMesa;

	@Column(name="NUM_PESSOAS")
	private Long numPessoas;

	@Column(name="STATUS_MESA")
	private String statusMesa;

	//bi-directional many-to-one association to PontoVendaEJB
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL"),
		@JoinColumn(name="ID_PONTO_VENDA", referencedColumnName="ID_PONTO_VENDA"),
		})
	private PontoVendaEJB pontoVenda;

    public MesaEJB() {
    }

	public String getContatoReserva() {
		return this.contatoReserva;
	}

	public void setContatoReserva(String contatoReserva) {
		this.contatoReserva = contatoReserva;
	}

	public Long getIdGarcon() {
		return this.idGarcon;
	}

	public void setIdGarcon(Long idGarcon) {
		this.idGarcon = idGarcon;
	}

	public String getLocalizacaoMesa() {
		return this.localizacaoMesa;
	}

	public void setLocalizacaoMesa(String localizacaoMesa) {
		this.localizacaoMesa = localizacaoMesa;
	}

	public Long getNumMesa() {
		return this.numMesa;
	}

	public void setNumMesa(Long numMesa) {
		this.numMesa = numMesa;
	}

	public Long getNumPessoas() {
		return this.numPessoas;
	}

	public void setNumPessoas(Long numPessoas) {
		this.numPessoas = numPessoas;
	}

	public String getStatusMesa() {
		return this.statusMesa;
	}

	public void setStatusMesa(String statusMesa) {
		this.statusMesa = statusMesa;
	}

	public PontoVendaEJB getPontoVenda() {
		return this.pontoVenda;
	}

	public void setPontoVenda(PontoVendaEJB pontoVenda) {
		this.pontoVenda = pontoVenda;
	}

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}
	
}