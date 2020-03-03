package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "NfeUnidadeEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeUnidadeEJB o"),
})
@Table(name = "NFE_UNIDADE")
public class NfeUnidadeEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_UNIDADE")
    private Long idNfeUnidade;
	
    @Column(name="UNIDADE")
    private String unidade;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeUnidadeEJB() {
    }

	public Long getIdNfeUnidade() {
		return idNfeUnidade;
	}

	public void setIdNfeUnidade(Long idNfeUnidade) {
		this.idNfeUnidade = idNfeUnidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
