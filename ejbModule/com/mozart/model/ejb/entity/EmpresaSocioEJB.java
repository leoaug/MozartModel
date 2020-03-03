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

@Entity
@NamedQuery(name = "EmpresaSocioEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaSocioEJB o")
@Table(name = "EMPRESA_SOCIO")
public class EmpresaSocioEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3964879894389960736L;
	private String cpf;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqSocio")
    @SequenceGenerator(name="idSeqSocio", sequenceName="id", allocationSize=1)
    @Column(name="ID_EMPRESA_SOCIO", nullable = false)
    private Long idEmpresaSocio;
    private String nome;
    private String participacao;
    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    private EmpresaEJB empresaEJB;

    public EmpresaSocioEJB() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public Long getIdEmpresaSocio() {
        return idEmpresaSocio;
    }

    public void setIdEmpresaSocio(Long idEmpresaSocio) {
        this.idEmpresaSocio = idEmpresaSocio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParticipacao() {
        return participacao;
    }

    public void setParticipacao(String participacao) {
        this.participacao = participacao;
    }

    public EmpresaEJB getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaEJB empresaEJB) {
        this.empresaEJB = empresaEJB;
    }
}
