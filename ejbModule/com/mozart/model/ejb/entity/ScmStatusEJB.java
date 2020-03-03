package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the SCM_STATUS database table.
 * 
 */
@Entity
@Table(name="SCM_STATUS")
@NamedQueries({
@NamedQuery(name = "ScmStatusEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    query = "select o from ScmStatusEJB o order by o.idStatus"),
	    
@NamedQuery(name = "ScmStatusEJB.findInicialPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    query = "select o from ScmStatusEJB o where o.idStatus = 1"),

@NamedQuery(name = "ScmStatusEJB.findAbertoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (2,3,11)"),
		
@NamedQuery(name = "ScmStatusEJB.findPendentePara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (1,11)"), 

@NamedQuery(name = "ScmStatusEJB.findRecebidoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (5,11)"), 

@NamedQuery(name = "ScmStatusEJB.findAnalisadoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (7,4,6,11)"), 

@NamedQuery(name = "ScmStatusEJB.findRejeitadoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (11)"),

@NamedQuery(name = "ScmStatusEJB.findDesenvolvidoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (8,6)"), 
		
@NamedQuery(name = "ScmStatusEJB.findSuspensoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (5)"),
				
@NamedQuery(name = "ScmStatusEJB.findTestadoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (9,7)"),
		
@NamedQuery(name = "ScmStatusEJB.findHomologadoPara", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
		query = "select o from ScmStatusEJB o where o.idStatus in (10,7,9)")
})
	    
	    

public class ScmStatusEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCM_STATUS_IDSTATUS_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCM_STATUS_IDSTATUS_GENERATOR")
	@Column(name="ID_STATUS")
	private Long idStatus;

	@Column(name="DS_STATUS")
	private String dsStatus;

	@Column(name="NM_NIVEL")
	private Integer nmNivel;

    public ScmStatusEJB() {
    }

	public Long getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getDsStatus() {
		return this.dsStatus;
	}

	public void setDsStatus(String dsStatus) {
		this.dsStatus = dsStatus;
	}

	public Integer getNmNivel() {
		return this.nmNivel;
	}

	public void setNmNivel(Integer nmNivel) {
		this.nmNivel = nmNivel;
	}	
}