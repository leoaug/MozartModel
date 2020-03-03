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
	@NamedQuery(name = "NfeImpressoraEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeImpressoraEJB o"),
})
@Table(name = "NFE_IMPRESSORA")
public class NfeImpressoraEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_IMPRESSORA")
    private Long idNfeImpressora;
	
	    
    @Column(name="MODELO")
    private String modelo;
    
    public NfeImpressoraEJB() {
    }

	public Long getIdNfeImpressora() {
		return idNfeImpressora;
	}

	public void setIdNfeImpressora(Long idNfeImpressora) {
		this.idNfeImpressora = idNfeImpressora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
