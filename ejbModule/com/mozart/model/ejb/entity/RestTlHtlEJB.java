package com.mozart.model.ejb.entity;

import com.mozart.model.ejb.entity.MozartEntity;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RestTlHtlEJB
 *
 */
@Entity
public class RestTlHtlEJB extends MozartEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5981574074890117030L;

	public RestTlHtlEJB() {
		super();
		
	}
	@Id
	@Column(name="ID_REST_TL_HTL")
	private Long IdRestTlHtl;
	
	@ManyToOne
	@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL", insertable=false, updatable=false),
		@JoinColumn(name="ID_TIPO_LANCAMENTO", referencedColumnName="ID_TIPO_LANCAMENTO")
	})
	private TipoLancamentoEJB tipoLancamento;
	
	@ManyToOne
	@JoinColumn(name="ID_CHECKIN", referencedColumnName="ID_CHECKIN")
	private CheckinEJB checkin;

	@JoinColumn(name="ID_RESTAURANTE", referencedColumnName="ID_HOTEL")
	private HotelEJB restaurante;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_RESTAURANTE", referencedColumnName="ID_HOTEL", insertable=false, updatable=false),
		@JoinColumn(name="ID_TIPO_LANCAMENTO_REST", referencedColumnName="ID_TIPO_LANCAMENTO")
	})
	private TipoLancamentoEJB tipoLancamentoRestaurante;

	public Long getIdRestTlHtl() {
		return IdRestTlHtl;
	}

	public void setIdRestTlHtl(Long idRestTlHtl) {
		IdRestTlHtl = idRestTlHtl;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public TipoLancamentoEJB getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamentoEJB tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public CheckinEJB getCheckin() {
		return checkin;
	}

	public void setCheckin(CheckinEJB checkin) {
		this.checkin = checkin;
	}

	public HotelEJB getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(HotelEJB restaurante) {
		this.restaurante = restaurante;
	}

	public TipoLancamentoEJB getTipoLancamentoRestaurante() {
		return tipoLancamentoRestaurante;
	}

	public void setTipoLancamentoRestaurante(
			TipoLancamentoEJB tipoLancamentoRestaurante) {
		this.tipoLancamentoRestaurante = tipoLancamentoRestaurante;
	}
	
   
}
