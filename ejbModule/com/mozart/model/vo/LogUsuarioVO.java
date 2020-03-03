package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class LogUsuarioVO extends MozartVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -908202821944552433L;
	
	public static final String TABELA_GERAL = "TABELA_GERAL";
	
	private FiltroWeb filtroData;
	private FiltroWeb filtroUsuario;
	private FiltroWeb filtroId;
	
	private Long idAuditado;
	private Long idUsuario;
	private String nick;
	private String tabelaAuditada;
	private String estacao;
	private Date data;
	private Date hora;
	private String operacao;
	private Long idRedeHotel;
	private Long idHotel;
	private String nomeHotel;
	private String tabela;
	private String titulo;
	private String alteracao;
	private String geral;
	private String geral2;
	
	public LogUsuarioVO(){
		
		filtroData = new FiltroWeb();
		filtroUsuario = new FiltroWeb();		
		filtroId = new FiltroWeb();	
			
	}	
	
	public LogUsuarioVO(Object[] linha){
			
		if (linha != null){
			setLinha(linha);
			idAuditado = getLong();
			idUsuario = getLong();
			nick = getString();
			tabelaAuditada = getString();
			estacao = getString();
			data = getDate();
			hora = getDate();
			operacao = getString();
			idRedeHotel = getLong();
			idHotel = getLong();
			nomeHotel = getString();
		}
	}
	
	public LogUsuarioVO(Object[] linha, String tabela){
		
		if (linha != null){
			
			if (tabela.equals(TABELA_GERAL)){
				setLinha(linha);
				idAuditado = getLong();
				operacao = getString();
				nick = getString();
				estacao = getString();
				data = getDate();
				hora = getDate();
				alteracao = getString();
				geral = getString();
				geral2 = getString();
			}
		}
			
	}
	
	public Long getIdAuditado() {
		return idAuditado;
	}
	public void setIdAuditado(Long idAuditado) {
		this.idAuditado = idAuditado;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getTabelaAuditada() {
		return tabelaAuditada;
	}
	public void setTabelaAuditada(String tabelaAuditada) {
		this.tabelaAuditada = tabelaAuditada;
	}
	public String getEstacao() {
		return estacao;
	}
	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public Long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public String getNomeHotel() {
		return nomeHotel;
	}
	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public FiltroWeb getFiltroData() {
		return filtroData;
	}

	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}

	public FiltroWeb getFiltroUsuario() {
		return filtroUsuario;
	}

	public void setFiltroUsuario(FiltroWeb filtroUsuario) {
		this.filtroUsuario = filtroUsuario;
	}

	public String getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(String alteracao) {
		this.alteracao = alteracao;
	}

	public String getGeral() {
		return geral;
	}

	public void setGeral(String geral) {
		this.geral = geral;
	}

	public FiltroWeb getFiltroId() {
		return filtroId;
	}

	public void setFiltroId(FiltroWeb filtroId) {
		this.filtroId = filtroId;
	}

	public String getGeral2() {
		return geral2;
	}

	public void setGeral2(String geral2) {
		this.geral2 = geral2;
	}

	
}
