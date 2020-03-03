package com.mozart.model.ejb.entity;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the VALOR_CAFE database table.
 * 
 */
@Entity
@Table(name="VALOR_CAFE")
public class ValorCafeEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VALOR_CAFE_IDVALORCAFE_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VALOR_CAFE_IDVALORCAFE_GENERATOR")
	@Column(name="ID_VALOR_CAFE")
	private Long idValorCafe;

    
	private Timestamp data;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="VALOR_CAFE")
	private Double valorCafe;

	//bi-directional many-to-one association to TipoPensao
    @ManyToOne
	@JoinColumn(name="ID_TIPO_PENSAO")
	private TipoPensaoEJB tipoPensao;

    public ValorCafeEJB() {
    }

	public Long getIdValorCafe() {
		return this.idValorCafe;
	}

	public void setIdValorCafe(Long idValorCafe) {
		this.idValorCafe = idValorCafe;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public Double getValorCafe() {
		return this.valorCafe;
	}

	public void setValorCafe(Double valorCafe) {
		this.valorCafe = valorCafe;
	}

	public TipoPensaoEJB getTipoPensao() {
		return this.tipoPensao;
	}

	public void setTipoPensao(TipoPensaoEJB tipoPensao) {
		this.tipoPensao = tipoPensao;
	}
	
}