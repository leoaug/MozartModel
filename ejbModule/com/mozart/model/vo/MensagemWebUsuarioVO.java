package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class MensagemWebUsuarioVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3267539202207105109L;

//FILTRO = TITULO, DESCRICAO, DATA_CRIACAO

//CRIAR MENU 'MINHAS MENSAGENS' PAI=INICAR
	
				
		/* FILTRO */
		private FiltroWeb filtroTitulo;
		private FiltroWeb filtroDescricao;
		private FiltroWeb filtroDataCriacao;
		
		private String usuarioCriacao;
		private Long idUsuario;
		private Long idMensagemWebUsuario;
		private String titulo;
		private String descricao;
		private Date dataCriacao;
		private String nivel;
		private Date dataResposta;
		private String resposta;
		
		
		
		public MensagemWebUsuarioVO(){
			
			filtroTitulo = new FiltroWeb();
			filtroDescricao = new FiltroWeb();		
			filtroDataCriacao = new FiltroWeb();
			
			
		}	
		
		public MensagemWebUsuarioVO(Object[] filtro ) {
			
			if (filtro != null){
				setLinha(filtro);
			
				
				idMensagemWebUsuario = getLong();
				titulo = getString();
				descricao = getString();
				dataCriacao = getDate();
				nivel = getString();
				dataResposta = getDate();
				resposta = getString();
				usuarioCriacao = getString();
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

		public Long getIdMensagemWebUsuario() {
			return idMensagemWebUsuario;
		}

		public void setIdMensagemWebUsuario(Long idMensagemWebUsuario) {
			this.idMensagemWebUsuario = idMensagemWebUsuario;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getNivel() {
			return nivel;
		}

		public void setNivel(String nivel) {
			this.nivel = nivel;
		}

		public String getResposta() {
			return resposta;
		}

		public void setResposta(String resposta) {
			this.resposta = resposta;
		}

		public Date getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(Date dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		public Date getDataResposta() {
			return dataResposta;
		}

		public void setDataResposta(Date dataResposta) {
			this.dataResposta = dataResposta;
		}

		public Long getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getUsuarioCriacao() {
			return usuarioCriacao;
		}

		public void setUsuarioCriacao(String usuarioCriacao) {
			this.usuarioCriacao = usuarioCriacao;
		}
	}
