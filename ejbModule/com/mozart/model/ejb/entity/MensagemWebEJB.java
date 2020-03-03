package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the MENSAGEM_WEB database table.
 * 
 */
@Entity
@Table(name="MENSAGEM_WEB")
public class MensagemWebEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENSAGEM_WEB_IDMENSAGEM_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENSAGEM_WEB_IDMENSAGEM_GENERATOR")
	@Column(name="ID_MENSAGEM")
	private Long idMensagem;

    
	@Column(name="DATA_CRIACAO")
	private Timestamp dataCriacao;

	private String descricao;

	private String titulo;
	
	@Column(name="NIVEL")
	private Long nivel;

	@Column(name="APROVADA")
	private String aprovada;
	
	@OneToMany(mappedBy="mensagemWeb", fetch=FetchType.EAGER, cascade = {CascadeType.REFRESH })
    private List<MensagemWebUsuarioEJB> mensagemWebUsuarioEJBList;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_USUARIO")
	private UsuarioEJB usuarioEJB;
	
	
    public MensagemWebEJB() {
    	
    	mensagemWebUsuarioEJBList = new ArrayList<MensagemWebUsuarioEJB>();
    }
    
    public void addMensagemWebUsuarioEJB(MensagemWebUsuarioEJB mensagemWebUsuarioEJB){
    	mensagemWebUsuarioEJB.getId().setIdMensagem(idMensagem);
    	mensagemWebUsuarioEJBList.add( mensagemWebUsuarioEJB );
    }

	public Long getIdMensagem() {
		return this.idMensagem;
	}

	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Timestamp getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	public String getAprovada() {
		return aprovada;
	}

	public void setAprovada(String aprovada) {
		this.aprovada = aprovada;
	}

	public List<MensagemWebUsuarioEJB> getMensagemWebUsuarioEJBList() {
		return mensagemWebUsuarioEJBList;
	}

	public void setMensagemWebUsuarioEJBList(
			List<MensagemWebUsuarioEJB> mensagemWebUsuarioEJBList) {
		this.mensagemWebUsuarioEJBList = mensagemWebUsuarioEJBList;
	}

	public UsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}

}