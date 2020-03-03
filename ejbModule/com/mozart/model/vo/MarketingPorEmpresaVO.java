package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MarketingPorEmpresaVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7411838161053536918L;

	/*filtros*/
	private FiltroWeb filtroPeriodo;
	private FiltroWeb filtroTipoEmpresa;
	private FiltroWeb filtroRoomNight;
	private FiltroWeb filtroDiariaMedia;
	private FiltroWeb filtroPromotor;
	private FiltroWeb filtroCrs;
	private FiltroWeb filtroCidade;
	private FiltroWeb filtroEstado;
	private FiltroWeb filtroFormaReserva;
	private FiltroWeb filtroValorConsumoMedio;
	private FiltroWeb filtroTicketMedio;
	private FiltroWeb filtroNomeEmpresa;
	private FiltroWeb filtroCidadeOrigem;
	private FiltroWeb filtroCidadeDestino;
	
	/*Campos*/
	private String email;
	private String sigla;
	private Long idEmpresa;
	private Long idCentralReservas;
	private Long idReserva;
	private Long idCheckin;
	private String formaReserva;
	private String nomeFantasia;
	private String tipoEmpresa;
	private String cidadeEmpresa;
	private String estadoEmpresa;
	private String paisEmpresa;
	private String promotor;
	private String nomeCrs;
	private String nomeHospede;
	private String nomeGrupo;
	private Date dataEntrada;
	private Date dataSaida;
	private Long qtdeRoomNight;
	private Double valorDiaria;
	private Double valorExtra;
	private Double valorTotal;
	private Double diariaMedia;
	private Double diariaMediaExtra;
	private Double ticketMedio;
	private String nick;
	private String cidadeOrigem;
	private String cidadeDestino;
	
	
	
	public MarketingPorEmpresaVO(){
		filtroPeriodo = new FiltroWeb();
		filtroTipoEmpresa = new FiltroWeb();
		filtroRoomNight = new FiltroWeb();
		filtroDiariaMedia = new FiltroWeb();
		filtroPromotor = new FiltroWeb();
		filtroCrs = new FiltroWeb();
		filtroCidade = new FiltroWeb();
		filtroEstado = new FiltroWeb();
		filtroFormaReserva = new FiltroWeb();
		filtroValorConsumoMedio = new FiltroWeb();
		filtroTicketMedio = new FiltroWeb();
		filtroNomeEmpresa = new FiltroWeb();
		filtroCidadeOrigem = new FiltroWeb();
		filtroCidadeDestino = new FiltroWeb();
	}
	
	
	public MarketingPorEmpresaVO(Object[] linha){
		if (linha !=null){
			setLinha(linha);
			email = getString();
			sigla = getString();
			idEmpresa = getLong();
			idCentralReservas = getLong();
			idReserva = getLong();
			idCheckin = getLong();
			formaReserva = getString();
			nomeFantasia = getString();
			tipoEmpresa = getString();
			cidadeEmpresa = getString();
			estadoEmpresa = getString();
			paisEmpresa = getString();
			promotor = getString();
			nomeCrs = getString();
			nomeHospede = getString();
			nomeGrupo = getString();
			dataEntrada = getDate();
			dataSaida = getDate();
			qtdeRoomNight = getLong();
			valorDiaria = getDouble();
			valorExtra = getDouble();
			valorTotal = getDouble();
			diariaMedia = getDouble();
			diariaMediaExtra = getDouble();
			ticketMedio = getDouble();
			nick = getString();
			cidadeOrigem = getString();
			cidadeDestino = getString();
		}
		
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public Long getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public Long getIdCentralReservas() {
		return idCentralReservas;
	}


	public void setIdCentralReservas(Long idCentralReservas) {
		this.idCentralReservas = idCentralReservas;
	}


	public Long getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}


	public Long getIdCheckin() {
		return idCheckin;
	}


	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}


	public String getFormaReserva() {
		return formaReserva;
	}


	public void setFormaReserva(String formaReserva) {
		this.formaReserva = formaReserva;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getTipoEmpresa() {
		return tipoEmpresa;
	}


	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}


	public String getCidadeEmpresa() {
		return cidadeEmpresa;
	}


	public void setCidadeEmpresa(String cidadeEmpresa) {
		this.cidadeEmpresa = cidadeEmpresa;
	}


	public String getEstadoEmpresa() {
		return estadoEmpresa;
	}


	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}


	public String getPaisEmpresa() {
		return paisEmpresa;
	}


	public void setPaisEmpresa(String paisEmpresa) {
		this.paisEmpresa = paisEmpresa;
	}


	public String getPromotor() {
		return promotor;
	}


	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}


	public String getNomeCrs() {
		return nomeCrs;
	}


	public void setNomeCrs(String nomeCrs) {
		this.nomeCrs = nomeCrs;
	}


	public String getNomeHospede() {
		return nomeHospede;
	}


	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}


	public String getNomeGrupo() {
		return nomeGrupo;
	}


	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}


	public Date getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public Date getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Long getQtdeRoomNight() {
		return qtdeRoomNight;
	}


	public void setQtdeRoomNight(Long qtdeRoomNight) {
		this.qtdeRoomNight = qtdeRoomNight;
	}


	public Double getValorDiaria() {
		return valorDiaria;
	}


	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}


	public Double getValorExtra() {
		return valorExtra;
	}


	public void setValorExtra(Double valorExtra) {
		this.valorExtra = valorExtra;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Double getDiariaMedia() {
		return diariaMedia;
	}


	public void setDiariaMedia(Double diariaMedia) {
		this.diariaMedia = diariaMedia;
	}


	public Double getDiariaMediaExtra() {
		return diariaMediaExtra;
	}


	public void setDiariaMediaExtra(Double diariaMediaExtra) {
		this.diariaMediaExtra = diariaMediaExtra;
	}


	public Double getTicketMedio() {
		return ticketMedio;
	}


	public void setTicketMedio(Double ticketMedio) {
		this.ticketMedio = ticketMedio;
	}


	public FiltroWeb getFiltroPeriodo() {
		return filtroPeriodo;
	}


	public void setFiltroPeriodo(FiltroWeb filtroPeriodo) {
		this.filtroPeriodo = filtroPeriodo;
	}


	public FiltroWeb getFiltroTipoEmpresa() {
		return filtroTipoEmpresa;
	}


	public void setFiltroTipoEmpresa(FiltroWeb filtroTipoEmpresa) {
		this.filtroTipoEmpresa = filtroTipoEmpresa;
	}


	public FiltroWeb getFiltroRoomNight() {
		return filtroRoomNight;
	}


	public void setFiltroRoomNight(FiltroWeb filtroRoomNight) {
		this.filtroRoomNight = filtroRoomNight;
	}


	public FiltroWeb getFiltroDiariaMedia() {
		return filtroDiariaMedia;
	}


	public void setFiltroDiariaMedia(FiltroWeb filtroDiariaMedia) {
		this.filtroDiariaMedia = filtroDiariaMedia;
	}


	public FiltroWeb getFiltroPromotor() {
		return filtroPromotor;
	}


	public void setFiltroPromotor(FiltroWeb filtroPromotor) {
		this.filtroPromotor = filtroPromotor;
	}


	public FiltroWeb getFiltroCrs() {
		return filtroCrs;
	}


	public void setFiltroCrs(FiltroWeb filtroCrs) {
		this.filtroCrs = filtroCrs;
	}


	public FiltroWeb getFiltroCidade() {
		return filtroCidade;
	}


	public void setFiltroCidade(FiltroWeb filtroCidade) {
		this.filtroCidade = filtroCidade;
	}


	public FiltroWeb getFiltroEstado() {
		return filtroEstado;
	}


	public void setFiltroEstado(FiltroWeb filtroEstado) {
		this.filtroEstado = filtroEstado;
	}


	public FiltroWeb getFiltroFormaReserva() {
		return filtroFormaReserva;
	}


	public void setFiltroFormaReserva(FiltroWeb filtroFormaReserva) {
		this.filtroFormaReserva = filtroFormaReserva;
	}


	public FiltroWeb getFiltroValorConsumoMedio() {
		return filtroValorConsumoMedio;
	}


	public void setFiltroValorConsumoMedio(FiltroWeb filtroValorConsumoMedio) {
		this.filtroValorConsumoMedio = filtroValorConsumoMedio;
	}


	public FiltroWeb getFiltroTicketMedio() {
		return filtroTicketMedio;
	}


	public void setFiltroTicketMedio(FiltroWeb filtroTicketMedio) {
		this.filtroTicketMedio = filtroTicketMedio;
	}


	public FiltroWeb getFiltroNomeEmpresa() {
		return filtroNomeEmpresa;
	}


	public void setFiltroNomeEmpresa(FiltroWeb filtroNomeEmpresa) {
		this.filtroNomeEmpresa = filtroNomeEmpresa;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getCidadeOrigem() {
		return cidadeOrigem;
	}


	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}


	public String getCidadeDestino() {
		return cidadeDestino;
	}


	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}


	public FiltroWeb getFiltroCidadeOrigem() {
		return filtroCidadeOrigem;
	}


	public void setFiltroCidadeOrigem(FiltroWeb filtroCidadeOrigem) {
		this.filtroCidadeOrigem = filtroCidadeOrigem;
	}


	public FiltroWeb getFiltroCidadeDestino() {
		return filtroCidadeDestino;
	}


	public void setFiltroCidadeDestino(FiltroWeb filtroCidadeDestino) {
		this.filtroCidadeDestino = filtroCidadeDestino;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
