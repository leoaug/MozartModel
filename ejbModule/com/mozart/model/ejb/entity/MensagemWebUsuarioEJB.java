package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the MENSAGEM_WEB_USUARIO database table.
 * 
 */
@Entity
@Table(name="MENSAGEM_WEB_USUARIO")
@NamedQuery(name = "MensagemWebUsuarioEJB.findAllUnread",hints=@QueryHint(name="eclipselink.refresh", value="TRUE"), query = "select o from MensagemWebUsuarioEJB o where o.id.idUsuario = ?1 and o.dataResposta is null and o.mensagemWeb.aprovada = 'S' order by o.mensagemWeb.dataCriacao desc")
public class MensagemWebUsuarioEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MensagemWebUsuarioEJBPK id;

	@Column(name="DATA_RESPOSTA")
	private Timestamp dataResposta;

	@Column(name="RESPOSTA")
	private String resposta;

	//bi-directional many-to-one association to MensagemWebEJB
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_MENSAGEM", insertable=false, updatable=false)
	private MensagemWebEJB mensagemWeb;

    @ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_USUARIO", insertable=false, updatable=false)
	private UsuarioEJB usuarioEJB;

    
    public MensagemWebUsuarioEJB() {
    	id = new MensagemWebUsuarioEJBPK() ;
    	usuarioEJB  = new UsuarioEJB();
    }

	public MensagemWebUsuarioEJBPK getId() {
		return this.id;
	}

	
	public boolean equals(Object obj){
		
		if (obj == null || !(obj instanceof MensagemWebUsuarioEJB) || usuarioEJB.getIdUsuario() == null)
			return false;
		
		return usuarioEJB.getIdUsuario().equals( ((MensagemWebUsuarioEJB)obj).getUsuarioEJB().getIdUsuario() );
	}
	
	public void setId(MensagemWebUsuarioEJBPK id) {
		this.id = id;
	}
	
	public Timestamp getDataResposta() {
		return this.dataResposta;
	}

	public void setDataResposta(Timestamp dataResposta) {
		this.dataResposta = dataResposta;
	}

	public MensagemWebEJB getMensagemWeb() {
		return this.mensagemWeb;
	}

	public void setMensagemWeb(MensagemWebEJB mensagemWeb) {
		this.mensagemWeb = mensagemWeb;
	}

	public UsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
}