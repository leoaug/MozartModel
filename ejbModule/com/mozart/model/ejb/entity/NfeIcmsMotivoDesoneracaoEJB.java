package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeIcmsMotivoDesoneracaoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIcmsMotivoDesoneracaoEJB o")
@Table(name = "NFE_ICMS_MOTIVO_DESONERACAO")
public class NfeIcmsMotivoDesoneracaoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_ICMS_MOTIVO_DESONERACAO")
    private Long idNfeIcmsMotivoDesoneracao;
	
    @Column(name="CODIGO")
    private String codigo;
    
    @Column(name="DESCRICAO")
    private String descricao;
    
    public NfeIcmsMotivoDesoneracaoEJB() {
    }

	public Long getIdNfeIcmsMotivoDesoneracao() {
		return idNfeIcmsMotivoDesoneracao;
	}

	public void setIdNfeIcmsMotivoDesoneracao(Long idNfeIcmsMotivoDesoneracao) {
		this.idNfeIcmsMotivoDesoneracao = idNfeIcmsMotivoDesoneracao;
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
