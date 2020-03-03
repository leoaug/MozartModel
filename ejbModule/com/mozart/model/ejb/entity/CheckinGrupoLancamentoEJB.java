package com.mozart.model.ejb.entity;

import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CheckinGrupoLancamentoEJB.findAll", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "select o from CheckinGrupoLancamentoEJB o")
@Table(name = "CHECKIN_GRUPO_LANCAMENTO")
@IdClass(CheckinGrupoLancamentoEJBPK.class)
@SuppressWarnings("unchecked")
public class CheckinGrupoLancamentoEJB extends MozartEntity {
	private static final long serialVersionUID = -4357026851820077169L;
	@Id
	@Column(name = "ID_CHECKIN", nullable = false, insertable = false, updatable = false)
	private Long idCheckin;
	@Id
	@Column(name = "ID_HOTEL", nullable = false)
	private Long idHotel;
	@Id
	@Column(name = "ID_IDENTIFICA_LANCAMENTO", nullable = false, insertable = false, updatable = false)
	private Long idIdentificaLancamento;
	@Column(name = "QUEM_PAGA", nullable = false)
	private String quemPaga;
	@ManyToOne
	@JoinColumn(name = "ID_CHECKIN", referencedColumnName = "ID_CHECKIN")
	private CheckinEJB checkinEJB;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_IDENTIFICA_LANCAMENTO", referencedColumnName = "ID_IDENTIFICA_LANCAMENTO")
	private IdentificaLancamentoEJB identificaLancamentoEJB;

	public static Comparator getComparator() {
		return new Comparator() {
			public int compare(Object o1, Object o2) {
				CheckinGrupoLancamentoEJB primeiro = (CheckinGrupoLancamentoEJB) o1;
				CheckinGrupoLancamentoEJB segundo = (CheckinGrupoLancamentoEJB) o2;

				String valorPrimeiro = primeiro.getIdentificaLancamentoEJB()
						.getDescricaoLancamento();

				String valorSegundo = segundo.getIdentificaLancamentoEJB()
						.getDescricaoLancamento();

				return valorPrimeiro.compareTo(valorSegundo);
			}
		};
	}

	public Long getIdCheckin() {
		return this.idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdIdentificaLancamento() {
		return this.idIdentificaLancamento;
	}

	public void setIdIdentificaLancamento(Long idIdentificaLancamento) {
		this.idIdentificaLancamento = idIdentificaLancamento;
	}

	public String getQuemPaga() {
		return this.quemPaga;
	}

	public void setQuemPaga(String quemPaga) {
		this.quemPaga = quemPaga;
	}

	public void setCheckinEJB(CheckinEJB checkinEJB) {
		this.checkinEJB = checkinEJB;
	}

	public CheckinEJB getCheckinEJB() {
		return this.checkinEJB;
	}

	public void setIdentificaLancamentoEJB(
			IdentificaLancamentoEJB identificaLancamentoEJB) {
		this.identificaLancamentoEJB = identificaLancamentoEJB;
	}

	public IdentificaLancamentoEJB getIdentificaLancamentoEJB() {
		return this.identificaLancamentoEJB;
	}
}