package com.mozart.model.ejb.entity;


import javax.persistence.*;



/**
 * The persistent class for the SCM_SISTEMA database table.
 * 
 */
@Entity
@NamedQuery(name = "ScmSistemaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    query = "select o from ScmSistemaEJB o order by o.dsSistema")
@Table(name="SCM_SISTEMA")
public class ScmSistemaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCM_SISTEMA_IDSISTEMA_GENERATOR", sequenceName="ID", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCM_SISTEMA_IDSISTEMA_GENERATOR")
	@Column(name="ID_SISTEMA")
	private Long idSistema;

	@Column(name="DS_SISTEMA")
	private String dsSistema;

    public ScmSistemaEJB() {
    }

	public Long getIdSistema() {
		return this.idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public String getDsSistema() {
		return this.dsSistema;
	}

	public void setDsSistema(String dsSistema) {
		this.dsSistema = dsSistema;
	}

	
}