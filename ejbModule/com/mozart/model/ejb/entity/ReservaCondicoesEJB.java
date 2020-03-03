package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the RESERVA_CONDICOES database table.
 * 
 */
@Entity
@Table(name="RESERVA_CONDICOES")
public class ReservaCondicoesEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_HOTEL")
	private Long idHotel;

	private String linha1;

	private String linha10;

	private String linha11;

	private String linha12;

	private String linha13;

	private String linha14;

	private String linha15;

	private String linha2;

	private String linha3;

	private String linha4;

	private String linha5;

	private String linha6;

	private String linha7;

	private String linha8;

	private String linha9;

    public ReservaCondicoesEJB() {
    }

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getLinha1() {
		return this.linha1;
	}

	public void setLinha1(String linha1) {
		this.linha1 = linha1;
	}

	public String getLinha10() {
		return this.linha10;
	}

	public void setLinha10(String linha10) {
		this.linha10 = linha10;
	}

	public String getLinha11() {
		return this.linha11;
	}

	public void setLinha11(String linha11) {
		this.linha11 = linha11;
	}

	public String getLinha12() {
		return this.linha12;
	}

	public void setLinha12(String linha12) {
		this.linha12 = linha12;
	}

	public String getLinha13() {
		return this.linha13;
	}

	public void setLinha13(String linha13) {
		this.linha13 = linha13;
	}

	public String getLinha14() {
		return this.linha14;
	}

	public void setLinha14(String linha14) {
		this.linha14 = linha14;
	}

	public String getLinha15() {
		return this.linha15;
	}

	public void setLinha15(String linha15) {
		this.linha15 = linha15;
	}

	public String getLinha2() {
		return this.linha2;
	}

	public void setLinha2(String linha2) {
		this.linha2 = linha2;
	}

	public String getLinha3() {
		return this.linha3;
	}

	public void setLinha3(String linha3) {
		this.linha3 = linha3;
	}

	public String getLinha4() {
		return this.linha4;
	}

	public void setLinha4(String linha4) {
		this.linha4 = linha4;
	}

	public String getLinha5() {
		return this.linha5;
	}

	public void setLinha5(String linha5) {
		this.linha5 = linha5;
	}

	public String getLinha6() {
		return this.linha6;
	}

	public void setLinha6(String linha6) {
		this.linha6 = linha6;
	}

	public String getLinha7() {
		return this.linha7;
	}

	public void setLinha7(String linha7) {
		this.linha7 = linha7;
	}

	public String getLinha8() {
		return this.linha8;
	}

	public void setLinha8(String linha8) {
		this.linha8 = linha8;
	}

	public String getLinha9() {
		return this.linha9;
	}

	public void setLinha9(String linha9) {
		this.linha9 = linha9;
	}

}