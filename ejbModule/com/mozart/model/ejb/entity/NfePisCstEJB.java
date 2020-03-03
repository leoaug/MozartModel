package com.mozart.model.ejb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfePisCstEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfePisCstEJB o")
@Table(name = "NFE_PIS_CST")
public class NfePisCstEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_PIS_CST")
    private Long idNfePisCst;
	
    @Column(name="CST")
    private String cst;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfePisCstEJB() {
    }

	public Long getIdNfePisCst() {
		return idNfePisCst;
	}

	public void setIdNfePisCst(Long idNfePisCst) {
		this.idNfePisCst = idNfePisCst;
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
