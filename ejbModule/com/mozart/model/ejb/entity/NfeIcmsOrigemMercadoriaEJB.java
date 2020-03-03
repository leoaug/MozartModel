package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeIcmsOrigemMercadoriaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIcmsOrigemMercadoriaEJB o order by o.codigo")
@Table(name = "NFE_ICMS_ORIGEM_MERCADORIA")
public class NfeIcmsOrigemMercadoriaEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_ICMS_ORIGEM_MERCADORIA")
    private Long idNfeIcmsOrigemMercadoria;
	
    @Column(name="CODIGO")
    private String codigo;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeIcmsOrigemMercadoriaEJB() {
    }

	public Long getIdNfeIcmsOrigemMercadoria() {
		return idNfeIcmsOrigemMercadoria;
	}

	public void setIdNfeIcmsOrigemMercadoria(Long idNfeIcmsOrigemMercadoria) {
		this.idNfeIcmsOrigemMercadoria = idNfeIcmsOrigemMercadoria;
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
