package com.mozart.model.ejb.entity;


import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PERMUTA database table.
 * 
 */
@Entity
@Table(name="PERMUTA")
public class PermutaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMUTA_IDPERMUTA_GENERATOR", sequenceName="ID", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMUTA_IDPERMUTA_GENERATOR")
	@Column(name="ID_PERMUTA")
	private Long idPermuta;

    
	@Column(name="DATA_FIM")
	private Timestamp dataFim;

    
	@Column(name="DATA_INICIO")
	private Timestamp dataInicio;

	private String descricao;

	@OneToOne
	@JoinColumns({
	@JoinColumn(name="ID_EMPRESA", referencedColumnName="ID_EMPRESA"),
	@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL")})
	private EmpresaHotelEJB empresaHotel;

	@Column(name="QTD_DIARIA")
	private Long qtdDiaria;

	@Column(name="VALOR_DIARIA")
	private Double valorDiaria;

    public PermutaEJB() {
    }


	public Timestamp getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}

	public Timestamp getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EmpresaHotelEJB getEmpresaHotel() {
		return empresaHotel;
	}

	public void setEmpresaHotel(EmpresaHotelEJB empresaHotel) {
		this.empresaHotel = empresaHotel;
	}

	public Long getQtdDiaria() {
		return qtdDiaria;
	}

	public void setQtdDiaria(Long qtdDiaria) {
		this.qtdDiaria = qtdDiaria;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}


	public Long getIdPermuta() {
		return idPermuta;
	}


	public void setIdPermuta(Long idPermuta) {
		this.idPermuta = idPermuta;
	}

}