package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity

@NamedQueries({
@NamedQuery(name = "UsuarioSessionEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from UsuarioSessionEJB o"),
@NamedQuery(name = "UsuarioSessionEJB.findActive", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from UsuarioSessionEJB o where o.dtFinalizacao is null")  
})

@Table(name = "USUARIO_SESSION")
@IdClass(UsuarioSessionEJBPK.class)
public class UsuarioSessionEJB extends MozartEntity {
    @Column(name="DT_CRIACAO", nullable = false)
    private Timestamp dtCriacao;
    @Column(name="DT_FINALIZACAO")
    private Timestamp dtFinalizacao;
    @Id
    @Column(name="ID_USUARIO", nullable = false, insertable = false, 
        updatable = false)
    private Long idUsuario;
    @Id
    @Column(name="SESSION_ID", nullable = false)
    private String sessionId;
    @OneToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private UsuarioEJB usuarioEJB;

    public UsuarioSessionEJB() {
        dtCriacao = new Timestamp ( Calendar.getInstance().getTime().getTime() );
    }

    public Timestamp getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Timestamp dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Timestamp getDtFinalizacao() {
        return dtFinalizacao;
    }

    public void setDtFinalizacao(Timestamp dtFinalizacao) {
        this.dtFinalizacao = dtFinalizacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public UsuarioEJB getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }
}
