package com.mozart.model.vo;


import com.mozart.model.vo.filtro.FiltroWeb;


public class CamareiraVO extends MozartVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4021793214169198994L;
	private FiltroWeb filtroNome;
	private FiltroWeb filtroAtivo;
	
	
	private Long idCamareira;
	private String nome;
	private String ativo;
	private Long idHotel;
	private String codCentralAdviser;
	private Long idUsuario;
	private String nick;
	
	public CamareiraVO(){
		
		filtroNome = new FiltroWeb();
		filtroAtivo = new FiltroWeb();
	}
	
	public CamareiraVO(Object[] linha){
		setLinha( linha );
		idCamareira = getLong();
		nome = getString();
		ativo = getString();
		idHotel = getLong();
		codCentralAdviser = getString();
		idUsuario = getLong();
		sigla = getString();
	}

	public FiltroWeb getFiltroNome() {
		return filtroNome;
	}

	public void setFiltroNome(FiltroWeb filtroNome) {
		this.filtroNome = filtroNome;
	}

	public FiltroWeb getFiltroAtivo() {
		return filtroAtivo;
	}

	public void setFiltroAtivo(FiltroWeb filtroAtivo) {
		this.filtroAtivo = filtroAtivo;
	}

	public Long getIdCamareira() {
		return idCamareira;
	}

	public void setIdCamareira(Long idCamareira) {
		this.idCamareira = idCamareira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getCodCentralAdviser() {
		return codCentralAdviser;
	}

	public void setCodCentralAdviser(String codCentralAdviser) {
		this.codCentralAdviser = codCentralAdviser;
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

}
