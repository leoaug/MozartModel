package com.mozart.model.ejb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeCofinsCstEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeCofinsCstEJB o")
@Table(name = "NFE_COFINS_CST")
public class NfeCofinsCstEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_COFINS_CST")
    private Long idNfeCofinsCst;
	
    @Column(name="CST")
    private String cst;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeCofinsCstEJB() {
    }

	public Long getIdNfeCofinsCst() {
		return idNfeCofinsCst;
	}

	public void setIdNfeCofinsCst(Long idNfeCofinsCst) {
		this.idNfeCofinsCst = idNfeCofinsCst;
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
