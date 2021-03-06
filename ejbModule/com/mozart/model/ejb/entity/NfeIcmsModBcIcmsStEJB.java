package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeIcmsModBcIcmsStEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIcmsModBcIcmsStEJB o")
@Table(name = "NFE_ICMS_MOD_BC_ICMSST")
public class NfeIcmsModBcIcmsStEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_ICMS_MOD_BC_ICMSST")
    private Long idNfeIcmsModBcIcmsSt;
	
    @Column(name="CODIGO")
    private String codigo;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeIcmsModBcIcmsStEJB() {
    }

	public Long getIdNfeIcmsModBcIcmsSt() {
		return idNfeIcmsModBcIcmsSt;
	}

	public void setIdNfeIcmsModBcIcmsSt(Long idNfeIcmsModBcIcmsSt) {
		this.idNfeIcmsModBcIcmsSt = idNfeIcmsModBcIcmsSt;
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
