package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "EmpresaJuntaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaJuntaEJB o")
@Table(name = "EMPRESA_JUNTA")
public class EmpresaJuntaEJB extends MozartEntity {
    
	private String capital;
    @Column(name="DATA_CADASTRO1")
    private Timestamp dataCadastro1;
    @Column(name="DATA_CADASTRO2")
    private Timestamp dataCadastro2;
    @Id
    @Column(name="ID_EMPRESA_JUNTA", nullable = false, insertable=false, updatable=false)
    private Long idEmpresaJunta;
    
    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA_JUNTA", referencedColumnName = "ID_EMPRESA")
    private EmpresaEJB empresaEJB;

    private String junta1;
    private String junta2;
    
    public EmpresaJuntaEJB() {
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Timestamp getDataCadastro1() {
        return dataCadastro1;
    }

    public void setDataCadastro1(Timestamp dataCadastro1) {
        this.dataCadastro1 = dataCadastro1;
    }

    public Timestamp getDataCadastro2() {
        return dataCadastro2;
    }

    public void setDataCadastro2(Timestamp dataCadastro2) {
        this.dataCadastro2 = dataCadastro2;
    }

    public Long getIdEmpresaJunta() {
        return idEmpresaJunta;
    }

    public void setIdEmpresaJunta(Long idEmpresaJunta) {
        this.idEmpresaJunta = idEmpresaJunta;
    }

    public String getJunta1() {
        return junta1;
    }

    public void setJunta1(String junta1) {
        this.junta1 = junta1;
    }

    public String getJunta2() {
        return junta2;
    }

    public void setJunta2(String junta2) {
        this.junta2 = junta2;
    }

	public EmpresaEJB getEmpresaEJB() {
		return empresaEJB;
	}

	public void setEmpresaEJB(EmpresaEJB empresaEJB) {
		this.empresaEJB = empresaEJB;
	}

}
