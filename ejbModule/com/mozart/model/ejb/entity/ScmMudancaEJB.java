package com.mozart.model.ejb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.mozart.model.util.MozartUtil;


/**
 * The persistent class for the SCM_MUDANCA database table.
 * 
 */
@Entity
@Table(name="SCM_MUDANCA")
public class ScmMudancaEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCM_MUDANCA_IDMUDANCA_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCM_MUDANCA_IDMUDANCA_GENERATOR")
	@Column(name="ID_MUDANCA")
	private Long idMudanca;

	@Column(name="DS_CAMINHO")
	private String dsCaminho;

	@Column(name="DS_TITULO")
	private String dsTitulo;

	@ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    })
	private UsuarioEJB usuarioEJB;

	//bi-directional many-to-one association to ScmSistema
    @ManyToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
	@JoinColumn(name="ID_SISTEMA")
	private ScmSistemaEJB scmSistema;

	//bi-directional many-to-one association to ScmMudancaComplemento
	@OneToMany(mappedBy="scmMudancaEJB", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<ScmMudancaComplementoEJB> scmMudancaComplementos;

	@Column(name="NM_PRIORIDADE")
	private Long nmPrioridade;
	
    public ScmMudancaEJB() {
    }

	public Long getIdMudanca() {
		return this.idMudanca;
	}

	public void setIdMudanca(Long idMudanca) {
		this.idMudanca = idMudanca;
	}

	public String getDsCaminho() {
		return this.dsCaminho;
	}

	public void setDsCaminho(String dsCaminho) {
		this.dsCaminho = dsCaminho;
	}

	public String getDsTitulo() {
		return this.dsTitulo;
	}

	public void setDsTitulo(String dsTitulo) {
		this.dsTitulo = dsTitulo;
	}

	public ScmSistemaEJB getScmSistema() {
		return this.scmSistema;
	}

	public void setScmSistema(ScmSistemaEJB scmSistema) {
		this.scmSistema = scmSistema;
	}
	
	public List<ScmMudancaComplementoEJB> getScmMudancaComplementos() {
		return this.scmMudancaComplementos;
	}

	public void setScmMudancaComplementos(List<ScmMudancaComplementoEJB> scmMudancaComplementos) {
		this.scmMudancaComplementos = scmMudancaComplementos;
	}

	public void addScmMudancaComplementos(ScmMudancaComplementoEJB scmMudancaComplemento) {
		if (MozartUtil.isNull(scmMudancaComplementos)){
			scmMudancaComplementos = new ArrayList<ScmMudancaComplementoEJB>();
		}
		scmMudancaComplemento.setScmMudancaEJB(this);
		this.scmMudancaComplementos.add(scmMudancaComplemento);
	}

	public UsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}

	public Long getNmPrioridade() {
		return nmPrioridade;
	}

	public void setNmPrioridade(Long nmPrioridade) {
		this.nmPrioridade = nmPrioridade;
	}
	
}