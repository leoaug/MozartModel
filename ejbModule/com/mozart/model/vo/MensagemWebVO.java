package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MensagemWebVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8422386482620328087L;
	
	
	private FiltroWeb filtroTitulo;
	private FiltroWeb filtroUsuario;
	private FiltroWeb filtroNickUsuario;
	private FiltroWeb filtroDescricao;
	private FiltroWeb filtroDataCriacao;
	private FiltroWeb filtroHotel;
	private FiltroWeb filtroRespondeu;
	
	
	private Long idMensagem;
	private String titulo;
	private Date dataCriacao;
	private String nivel;
	private String nomeUsuario;
	private Date dataResposta;
	private String nomeHotel;
	private String resposta;
	private String criadaPor;
	
		
	public MensagemWebVO(){
		filtroTitulo = new FiltroWeb();
		filtroDescricao = new FiltroWeb();
		filtroDataCriacao = new FiltroWeb();
		filtroHotel = new FiltroWeb();
		filtroUsuario = new FiltroWeb();
		filtroNickUsuario = new FiltroWeb();
		filtroRespondeu = new FiltroWeb();
	}

	public MensagemWebVO(Object[] linha){
		
		if (linha != null){
			setLinha( linha );
			idMensagem = getLong();
			titulo = getString();
			dataCriacao = getDate();
			nivel = getString();
			nomeUsuario = getString();
			dataResposta = getDate();
			nomeHotel = getString();
			resposta = getString();
			criadaPor = getString();
		}
		
	}



	public FiltroWeb getFiltroTitulo() {
		return filtroTitulo;
	}




	public void setFiltroTitulo(FiltroWeb filtroTitulo) {
		this.filtroTitulo = filtroTitulo;
	}




	public FiltroWeb getFiltroDescricao() {
		return filtroDescricao;
	}




	public void setFiltroDescricao(FiltroWeb filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}




	public FiltroWeb getFiltroDataCriacao() {
		return filtroDataCriacao;
	}




	public void setFiltroDataCriacao(FiltroWeb filtroDataCriacao) {
		this.filtroDataCriacao = filtroDataCriacao;
	}




	public Long getIdMensagem() {
		return idMensagem;
	}




	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public Date getDataCriacao() {
		return dataCriacao;
	}




	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}




	public String getNomeUsuario() {
		return nomeUsuario;
	}




	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}




	public Date getDataResposta() {
		return dataResposta;
	}




	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

	public FiltroWeb getFiltroUsuario() {
		return filtroUsuario;
	}

	public void setFiltroUsuario(FiltroWeb filtroUsuario) {
		this.filtroUsuario = filtroUsuario;
	}

	public FiltroWeb getFiltroNickUsuario() {
		return filtroNickUsuario;
	}

	public void setFiltroNickUsuario(FiltroWeb filtroNickUsuario) {
		this.filtroNickUsuario = filtroNickUsuario;
	}

	public FiltroWeb getFiltroHotel() {
		return filtroHotel;
	}

	public void setFiltroHotel(FiltroWeb filtroHotel) {
		this.filtroHotel = filtroHotel;
	}

	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public FiltroWeb getFiltroRespondeu() {
		return filtroRespondeu;
	}

	public void setFiltroRespondeu(FiltroWeb filtroRespondeu) {
		this.filtroRespondeu = filtroRespondeu;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getCriadaPor() {
		return criadaPor;
	}

	public void setCriadaPor(String criadaPor) {
		this.criadaPor = criadaPor;
	}

	
	
}
