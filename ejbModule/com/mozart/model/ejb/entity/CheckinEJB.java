package com.mozart.model.ejb.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mozart.model.util.MozartUtil;

@Entity
@NamedQuery(name = "CheckinEJB.findAll", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "select o from CheckinEJB o")
@Table(name = "CHECKIN")
@SuppressWarnings("unchecked")
public class CheckinEJB extends MozartEntity {
	private static final long serialVersionUID = -8351493808600077683L;
	private Long adicional;
	@Column(name = "CALCULA_ISS", nullable = false)
	private String calculaIss;
	@Column(name = "CALCULA_ROOMTAX", nullable = false)
	private String calculaRoomtax;
	@Column(name = "CALCULA_SEGURO")
	private String calculaSeguro;
	@Column(name = "CALCULA_TAXA", nullable = false)
	private String calculaTaxa;
	@Column(nullable = false)
	private String checkout;
	private Double comissao;
	@Column(nullable = false)
	private String cortesia;
	@Column(nullable = false)
	private String credito;
	@Column(name = "DATA_ENTRADA", nullable = false)
	private Timestamp dataEntrada;
	@Column(name = "DATA_REAL_ENTRADA")
	private Timestamp dataRealEntrada;
	@Column(name = "DATA_REAL_SAIDA")
	private Timestamp dataRealSaida;
	@Column(name = "DATA_SAIDA", nullable = false)
	private Timestamp dataSaida;
	@Column(name = "FLG_ALCOOLICA")
	private String flgAlcoolica;
	private String hora;
	@Column(name = "ID_CENTRAL_RESERVAS")
	private Long idCentralReservas;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeqChk")
	@SequenceGenerator(name = "idSeqChk", sequenceName = "id", allocationSize = 1)
	@Column(name = "ID_CHECKIN", nullable = false)
	private Long idCheckin;
	@Column(name = "JUSTIFICA_TARIFA")
	private String justificaTarifa;
	@Column(name = "MAPFRE_ENVIADO")
	private String mapfreEnviado;
	@Column(name = "MEIO_TRANSPORTE")
	private String meioTransporte;
	@Column(name = "MOTIVO_VIAGEM")
	private String motivoViagem;
	private String observacao;
	@Column(name = "QTDE_ADULTOS")
	private Long qtdeAdultos;
	@Column(name = "QTDE_CAFE")
	private Long qtdeCafe;
	@Column(name = "QTDE_CRIANCAS")
	private Long qtdeCriancas;
	private String rda;
	private Double tarifa;
	@Column(name = "TIPO_PENSAO")
	private String tipoPensao;
	@Column(name = "TIPO_TARIFA")
	private String tipoTarifa;
	@Column(name = "VALOR_PENSAO")
	private Double valorPensao;
	@OneToMany(mappedBy = "checkinEJB", fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.ALL })
	private List<CheckinTipoLancamentoEJB> checkinTipoLancamentoEJBList;
	@OneToMany(mappedBy = "checkinEJB", fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.ALL })
	private List<CheckinGrupoLancamentoEJB> checkinGrupoLancamentoEJBList;
	@OneToMany(mappedBy = "checkin", fetch = FetchType.LAZY, cascade = { javax.persistence.CascadeType.ALL })
	private List<RoomListEJB> roomListEJBList;
	@OneToMany(mappedBy = "checkinEJB", fetch = FetchType.LAZY, cascade = { javax.persistence.CascadeType.ALL })
	private List<MovimentoApartamentoEJB> movimentoApartamentoEJBList;
	@OneToOne(fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_CIDADE_DESTINO", referencedColumnName = "ID_CIDADE")
	private CidadeEJB cidadeDestino;
	@OneToOne(fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ID_CIDADE_PROCEDENCIA", referencedColumnName = "ID_CIDADE")
	private CidadeEJB cidadeProcedencia;
	@OneToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
	private ReservaEJB reservaEJB;
	@OneToOne(cascade = { javax.persistence.CascadeType.REFRESH }, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_RESERVA_APARTAMENTO", referencedColumnName = "ID_RESERVA_APARTAMENTO")
	private ReservaApartamentoEJB reservaApartamentoEJB;
	@OneToOne(cascade = { javax.persistence.CascadeType.REFRESH }, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_APARTAMENTO", referencedColumnName = "ID_APARTAMENTO")
	private ApartamentoEJB apartamentoEJB;
	@OneToOne(optional = true, fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.REFRESH })
	@JoinColumns( {
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA", insertable = false, updatable = false) })
	private EmpresaHotelEJB empresaHotelEJB;
	@Column(name = "ID_HOTEL")
	private Long idHotel;
	@Column(name = "ID_EMPRESA")
	private Long idEmpresa;
	@Transient
	private HotelEJB hotelEJB;

	public CheckinEJB() {
		this.checkinTipoLancamentoEJBList = new ArrayList();
		this.roomListEJBList = new ArrayList();
		this.checkinGrupoLancamentoEJBList = new ArrayList();
		this.movimentoApartamentoEJBList = new ArrayList();
	}

	public int getQtdeRoomListChegou() {
		int qtde = 0;
		if (MozartUtil.isNull(this.roomListEJBList)) {
			return qtde;
		}
		for (RoomListEJB room : this.roomListEJBList) {
			if (("S".equals(room.getChegou()))
					&& (room.getDataEntrada() == null)) {
				qtde++;
			}
		}
		return qtde;
	}

	public CheckinEJB(Long idCheckin) {
		this();
		this.idCheckin = idCheckin;
	}

	public Long getAdicional() {
		return this.adicional;
	}

	public void setAdicional(Long adicional) {
		this.adicional = adicional;
	}

	public String getCalculaIss() {
		return this.calculaIss;
	}

	public void setCalculaIss(String calculaIss) {
		this.calculaIss = calculaIss;
	}

	public String getCalculaRoomtax() {
		return this.calculaRoomtax;
	}

	public void setCalculaRoomtax(String calculaRoomtax) {
		this.calculaRoomtax = calculaRoomtax;
	}

	public String getCalculaSeguro() {
		return this.calculaSeguro;
	}

	public void setCalculaSeguro(String calculaSeguro) {
		this.calculaSeguro = calculaSeguro;
	}

	public String getCalculaTaxa() {
		return this.calculaTaxa;
	}

	public void setCalculaTaxa(String calculaTaxa) {
		this.calculaTaxa = calculaTaxa;
	}

	public String getCheckout() {
		return this.checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public Double getComissao() {
		return this.comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public String getCortesia() {
		return this.cortesia;
	}

	public void setCortesia(String cortesia) {
		this.cortesia = cortesia;
	}

	public String getCredito() {
		return this.credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public Timestamp getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Timestamp getDataRealEntrada() {
		return this.dataRealEntrada;
	}

	public void setDataRealEntrada(Timestamp dataRealEntrada) {
		this.dataRealEntrada = dataRealEntrada;
	}

	public Timestamp getDataRealSaida() {
		return this.dataRealSaida;
	}

	public void setDataRealSaida(Timestamp dataRealSaida) {
		this.dataRealSaida = dataRealSaida;
	}

	public Timestamp getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getFlgAlcoolica() {
		return this.flgAlcoolica;
	}

	public void setFlgAlcoolica(String flgAlcoolica) {
		this.flgAlcoolica = flgAlcoolica;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Long getIdCentralReservas() {
		return this.idCentralReservas;
	}

	public void setIdCentralReservas(Long idCentralReservas) {
		this.idCentralReservas = idCentralReservas;
	}

	public Long getIdCheckin() {
		return this.idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public String getJustificaTarifa() {
		return this.justificaTarifa;
	}

	public void setJustificaTarifa(String justificaTarifa) {
		this.justificaTarifa = justificaTarifa;
	}

	public String getMapfreEnviado() {
		return this.mapfreEnviado;
	}

	public void setMapfreEnviado(String mapfreEnviado) {
		this.mapfreEnviado = mapfreEnviado;
	}

	public String getMeioTransporte() {
		return this.meioTransporte;
	}

	public void setMeioTransporte(String meioTransporte) {
		this.meioTransporte = meioTransporte;
	}

	public String getMotivoViagem() {
		return this.motivoViagem;
	}

	public void setMotivoViagem(String motivoViagem) {
		this.motivoViagem = motivoViagem;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getQtdeAdultos() {
		return this.qtdeAdultos;
	}

	public void setQtdeAdultos(Long qtdeAdultos) {
		this.qtdeAdultos = qtdeAdultos;
	}

	public Long getQtdeCafe() {
		return this.qtdeCafe;
	}

	public void setQtdeCafe(Long qtdeCafe) {
		this.qtdeCafe = qtdeCafe;
	}

	public Long getQtdeCriancas() {
		return this.qtdeCriancas;
	}

	public void setQtdeCriancas(Long qtdeCriancas) {
		this.qtdeCriancas = qtdeCriancas;
	}

	public String getRda() {
		return this.rda;
	}

	public void setRda(String rda) {
		this.rda = rda;
	}

	public Double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public String getTipoPensao() {
		return this.tipoPensao;
	}

	public void setTipoPensao(String tipoPensao) {
		this.tipoPensao = tipoPensao;
	}

	public String getTipoTarifa() {
		return this.tipoTarifa;
	}

	public void setTipoTarifa(String tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}

	public Double getValorPensao() {
		return this.valorPensao;
	}

	public void setValorPensao(Double valorPensao) {
		this.valorPensao = valorPensao;
	}

	public List<CheckinTipoLancamentoEJB> getCheckinTipoLancamentoEJBList() {
		return this.checkinTipoLancamentoEJBList;
	}

	public void setCheckinTipoLancamentoEJBList(
			List<CheckinTipoLancamentoEJB> checkinTipoLancamentoEJBList) {
		this.checkinTipoLancamentoEJBList = checkinTipoLancamentoEJBList;
	}

	public CheckinTipoLancamentoEJB addCheckinTipoLancamentoEJB(
			CheckinTipoLancamentoEJB checkinTipoLancamentoEJB) {
		getCheckinTipoLancamentoEJBList().add(checkinTipoLancamentoEJB);
		checkinTipoLancamentoEJB.setCheckinEJB(this);
		return checkinTipoLancamentoEJB;
	}

	public CheckinTipoLancamentoEJB removeCheckinTipoLancamentoEJB(
			CheckinTipoLancamentoEJB checkinTipoLancamentoEJB) {
		getCheckinTipoLancamentoEJBList().remove(checkinTipoLancamentoEJB);
		checkinTipoLancamentoEJB.setCheckinEJB(null);
		return checkinTipoLancamentoEJB;
	}

	public void setReservaEJB(ReservaEJB reservaEJB) {
		this.reservaEJB = reservaEJB;
	}

	public ReservaEJB getReservaEJB() {
		return this.reservaEJB;
	}

	public void setReservaApartamentoEJB(
			ReservaApartamentoEJB reservaApartamentoEJB) {
		this.reservaApartamentoEJB = reservaApartamentoEJB;
	}

	public ReservaApartamentoEJB getReservaApartamentoEJB() {
		return this.reservaApartamentoEJB;
	}

	public void setCidadeDestino(CidadeEJB cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public CidadeEJB getCidadeDestino() {
		return this.cidadeDestino;
	}

	public void setCidadeProcedencia(CidadeEJB cidadeProcedencia) {
		this.cidadeProcedencia = cidadeProcedencia;
	}

	public CidadeEJB getCidadeProcedencia() {
		return this.cidadeProcedencia;
	}

	public void setRoomListEJBList(List<RoomListEJB> roomListEJBList) {
		this.roomListEJBList = roomListEJBList;
	}

	public List<RoomListEJB> getRoomListEJBList() {
		return this.roomListEJBList;
	}

	public void setCheckinGrupoLancamentoEJBList(
			List<CheckinGrupoLancamentoEJB> checkinGrupoLancamentoEJBList) {
		this.checkinGrupoLancamentoEJBList = checkinGrupoLancamentoEJBList;
	}

	public List<CheckinGrupoLancamentoEJB> getCheckinGrupoLancamentoEJBList() {
		return this.checkinGrupoLancamentoEJBList;
	}

	public void setMovimentoApartamentoEJBList(
			List<MovimentoApartamentoEJB> movimentoApartamentoEJBList) {
		this.movimentoApartamentoEJBList = movimentoApartamentoEJBList;
	}

	public List<MovimentoApartamentoEJB> getMovimentoApartamentoEJBList() {
		return this.movimentoApartamentoEJBList;
	}

	public RoomListEJB getRoomListPrincipal() {
		if (this.roomListEJBList == null) {
			return null;
		}
		for (RoomListEJB room : this.roomListEJBList) {
			if ("S".equalsIgnoreCase(room.getPrincipal())) {
				return room;
			}
		}
		return null;
	}

	public void setEmpresaHotelEJB(EmpresaHotelEJB empresaHotelEJB) {
		this.empresaHotelEJB = empresaHotelEJB;
	}

	public EmpresaHotelEJB getEmpresaHotelEJB() {
		return this.empresaHotelEJB;
	}

	public void setApartamentoEJB(ApartamentoEJB apartamentoEJB) {
		this.apartamentoEJB = apartamentoEJB;
	}

	public ApartamentoEJB getApartamentoEJB() {
		return this.apartamentoEJB;
	}

	public void addMovimentoApartamentoEJB(
			MovimentoApartamentoEJB newMoviApartamento) {
		newMoviApartamento.setCheckinEJB(this);
		this.movimentoApartamentoEJBList.add(newMoviApartamento);
	}

	public HotelEJB getHotelEJB() {
		return this.hotelEJB;
	}

	public void setHotelEJB(HotelEJB hotelEJB) {
		this.hotelEJB = hotelEJB;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
}