package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "EmpresaReferenciaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaReferenciaEJB o")
@Table(name = "EMPRESA_REFERENCIA")
public class EmpresaReferenciaEJB extends MozartEntity {
    
	private String contato;
    private String email;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqRef")
    @SequenceGenerator(name="idSeqRef", sequenceName="id", allocationSize=1)
    @Column(name="ID_EMPRESA_REFERENCIA", nullable = false)
    private Long idEmpresaReferencia;
    @Column(name="RAZAO_SOCIAL")
    private String razaoSocial;
    private String telefone;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    private EmpresaEJB empresaEJB;

    public EmpresaReferenciaEJB() {
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getIdEmpresaReferencia() {
        return idEmpresaReferencia;
    }

    public void setIdEmpresaReferencia(Long idEmpresaReferencia) {
        this.idEmpresaReferencia = idEmpresaReferencia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EmpresaEJB getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaEJB empresaEJB) {
        this.empresaEJB = empresaEJB;
    }
}
