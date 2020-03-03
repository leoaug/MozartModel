package com.mozart.model.ejb.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO_SESSION_INFO")
public class UsuarioSessionInfo extends MozartEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6376987499869619011L;
	@Id
    @Column(name="ID_USUARIO")
	private Long idUsuario;
	@Column(name="NICK")
	private String nick;
	
	public UsuarioSessionInfo(){
		
	}

	public UsuarioSessionInfo(Long idUsuario, String nick){
		this.idUsuario = idUsuario;
		this.nick = nick;
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
