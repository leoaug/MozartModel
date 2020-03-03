package com.mozart.model.ejb.entity;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TARIFA_APARTAMENTO")
@SuppressWarnings("unchecked")
public class TarifaApartamentoEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private TarifaApartamentoEJBPK id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_APARTAMENTO", referencedColumnName = "ID_TIPO_APARTAMENTO")
	@MapsId("idTipoApartamento")
	private TipoApartamentoEJB tipoApartamento;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "ID_TARIFA", referencedColumnName = "ID_TARIFA") })
	@MapsId("idTarifa")
	private TarifaEJB tarifaEJB;
	private Double adicional;
	private Double pax1;
	private Double pax2;
	private Double pax3;
	private Double pax4;
	private Double pax5;
	private Double pax6;
	private Double pax7;

	public static Comparator getComparator() {
		return new Comparator() {
			public int compare(Object o1, Object o2) {
				TarifaApartamentoEJB primeiro = (TarifaApartamentoEJB) o1;
				TarifaApartamentoEJB segundo = (TarifaApartamentoEJB) o2;

				String valorPrimeiro = primeiro.getTipoApartamento()
						.getTipoApartamento();

				String valorSegundo = segundo.getTipoApartamento()
						.getTipoApartamento();

				return valorPrimeiro.compareTo(valorSegundo);
			}
		};
	}

	public TarifaApartamentoEJB() {
		this.id = new TarifaApartamentoEJBPK();
	}
	public TarifaApartamentoEJB(TarifaApartamentoEJB clone) {
		id = new TarifaApartamentoEJBPK();
		id.setIdHotel(clone.getId().getIdHotel());
		id.setIdTarifa(clone.getId().getIdTarifa());
		id.setIdTipoApartamento(clone.getId().getIdTipoApartamento());
		tipoApartamento =  clone.getTipoApartamento();
		tarifaEJB = new TarifaEJB(clone.getTarifaEJB());
		adicional = clone.getAdicional();
		pax1 = clone.getPax1();
		pax2 = clone.getPax2();
		pax3 = clone.getPax3();
		pax4 = clone.getPax4();
		pax5 = clone.getPax5();
		pax6 = clone.getPax6();
		pax7 = clone.getPax7();
	}

	public TarifaApartamentoEJBPK getId() {
		return this.id;
	}

	public void setId(TarifaApartamentoEJBPK id) {
		this.id = id;
	}

	public Double getAdicional() {
		return this.adicional;
	}

	public void setAdicional(Double adicional) {
		this.adicional = adicional;
	}

	public Double getPax1() {
		return this.pax1;
	}

	public void setPax1(Double pax1) {
		this.pax1 = pax1;
	}

	public Double getPax2() {
		return this.pax2;
	}

	public void setPax2(Double pax2) {
		this.pax2 = pax2;
	}

	public Double getPax3() {
		return this.pax3;
	}

	public void setPax3(Double pax3) {
		this.pax3 = pax3;
	}

	public Double getPax4() {
		return this.pax4;
	}

	public void setPax4(Double pax4) {
		this.pax4 = pax4;
	}

	public Double getPax5() {
		return this.pax5;
	}

	public void setPax5(Double pax5) {
		this.pax5 = pax5;
	}

	public Double getPax6() {
		return this.pax6;
	}

	public void setPax6(Double pax6) {
		this.pax6 = pax6;
	}

	public Double getPax7() {
		return this.pax7;
	}

	public void setPax7(Double pax7) {
		this.pax7 = pax7;
	}

	public TipoApartamentoEJB getTipoApartamento() {
		return this.tipoApartamento;
	}

	public void setTipoApartamento(TipoApartamentoEJB tipoApartamento) {
		this.tipoApartamento = tipoApartamento;
	}

	public TarifaEJB getTarifaEJB() {
		return this.tarifaEJB;
	}

	public void setTarifaEJB(TarifaEJB tarifaEJB) {
		this.tarifaEJB = tarifaEJB;
		this.id.setIdTarifa(tarifaEJB.getIdTarifa());
	}
}