package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "FiscalIncidenciaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    query = "select o from FiscalIncidenciaEJB o order by o.codigo")
@Table(name="FISCAL_INCIDENCIA")
public class FiscalIncidenciaEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FISCAL_INCIDENCIA")
	private Long idFiscalIncidencia;
	
	private String codigo;

	private String descricao;

    public FiscalIncidenciaEJB() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdFiscalIncidencia() {
		return this.idFiscalIncidencia;
	}

	public void setIdFiscalIncidencia(Long idFiscalIncidencia) {
		this.idFiscalIncidencia = idFiscalIncidencia;
	}
}