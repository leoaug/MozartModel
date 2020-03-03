package com.mozart.model.ejb.entity;

import javax.persistence.*;




/**
 * The persistent class for the PROMOTOR database table.
 * 
 */
@Entity
@Table(name="PROMOTOR")
public class PromotorEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROMOTOR_IDPROMOTOR_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROMOTOR_IDPROMOTOR_GENERATOR")
	@Column(name="ID_PROMOTOR")
	private Long idPromotor;

	private String area;

	private Double comissao;

	@Column(name="ID_CENTRAL_RESERVAS")
	private Long idCentralReservas;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="TIPO_PROMOTOR")
	private String tipoPromotor;

	@Column(name="ATIVO")
	private String ativo;

	private String promotor;

    public PromotorEJB() {
    }

	public Long getIdPromotor() {
		return this.idPromotor;
	}

	public void setIdPromotor(Long idPromotor) {
		this.idPromotor = idPromotor;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Long getIdCentralReservas() {
		return idCentralReservas;
	}

	public void setIdCentralReservas(Long idCentralReservas) {
		this.idCentralReservas = idCentralReservas;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getPromotor() {
		return promotor;
	}

	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}

	public String getTipoPromotor() {
		return tipoPromotor;
	}

	public void setTipoPromotor(String tipoPromotor) {
		this.tipoPromotor = tipoPromotor;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	

}