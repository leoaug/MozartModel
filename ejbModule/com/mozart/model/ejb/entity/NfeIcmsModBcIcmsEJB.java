package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeIcmsModBcIcmsEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIcmsModBcIcmsEJB o")
@Table(name = "NFE_ICMS_MOD_BC_ICMS")
public class NfeIcmsModBcIcmsEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_ICMS_MOD_BC_ICMS")
    private Long idNfeIcmsModBcIcms;
	
    @Column(name="CODIGO")
    private String codigo;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeIcmsModBcIcmsEJB() {
    }

	public Long getIdNfeIcmsModBcIcms() {
		return idNfeIcmsModBcIcms;
	}

	public void setIdNfeIcmsModBcIcms(Long idNfeIcmsModBcIcms) {
		this.idNfeIcmsModBcIcms = idNfeIcmsModBcIcms;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
