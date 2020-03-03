package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeIpiCstEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIpiCstEJB o")
@Table(name = "NFE_IPI_CST")
public class NfeIpiCstEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_IPI_CST")
    private Long idNfeIpiCst;
	
    @Column(name="CST")
    private String cst;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeIpiCstEJB() {
    }

	public Long getIdNfeIpiCst() {
		return idNfeIpiCst;
	}

	public void setIdNfeIpiCst(Long idNfeIpiCst) {
		this.idNfeIpiCst = idNfeIpiCst;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
