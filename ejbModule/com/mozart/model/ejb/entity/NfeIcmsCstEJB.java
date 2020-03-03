package com.mozart.model.ejb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeIcmsCstEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIcmsCstEJB o")
@Table(name = "NFE_ICMS_CST")
public class NfeIcmsCstEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_ICMS_CST")
    private Long idNfeIcmsCst;
	
	@Column(name="CSOSN")
    private String cson;
    
    @Column(name="CST")
    private String cst;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeIcmsCstEJB() {
    }

	public Long getIdNfeIcmsCst() {
		return idNfeIcmsCst;
	}

	public void setIdNfeIcmsCst(Long idNfeIcmsCst) {
		this.idNfeIcmsCst = idNfeIcmsCst;
	}

	public String getCson() {
		return cson;
	}

	public void setCson(String cson) {
		this.cson = cson;
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
