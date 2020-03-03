package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the SCM_MUDANCA_COMPLEMENTO database table.
 * 
 */
@Entity
@Table(name="SCM_MUDANCA_COMPLEMENTO")
public class ScmMudancaComplementoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ScmMudancaComplementoEJBPK id;

	@Column(name="DS_DESCRICAO")
	private String dsDescricao;

	@ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_STATUS", referencedColumnName = "ID_STATUS")
    })
	private ScmStatusEJB scmStatusEJB;

	@ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    })
	private UsuarioEJB usuarioEJB;

	@ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_MUDANCA", referencedColumnName = "ID_MUDANCA")
    })
    private ScmMudancaEJB scmMudancaEJB;

    public ScmMudancaComplementoEJB() {
    }

	public ScmMudancaComplementoEJBPK getId() {
		return this.id;
	}

	public void setId(ScmMudancaComplementoEJBPK id) {
		this.id = id;
	}
	
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public UsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}

	public ScmStatusEJB getScmStatusEJB() {
		return scmStatusEJB;
	}

	public void setScmStatusEJB(ScmStatusEJB scmStatusEJB) {
		this.scmStatusEJB = scmStatusEJB;
	}

	public ScmMudancaEJB getScmMudancaEJB() {
		return scmMudancaEJB;
	}

	public void setScmMudancaEJB(ScmMudancaEJB scmMudancaEJB) {
		this.scmMudancaEJB = scmMudancaEJB;
	}


}