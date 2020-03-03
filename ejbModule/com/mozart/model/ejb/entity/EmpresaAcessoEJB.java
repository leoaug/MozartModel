package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

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
@NamedQuery(name = "EmpresaAcessoEJB.findAll",hints=@QueryHint(name="eclipselink.refresh", value="TRUE"), 
    query = "select o from EmpresaAcessoEJB o")
@Table(name = "EMPRESA_ACESSO")
public class EmpresaAcessoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -882631965973082269L;
	private String ativo;
    @Column(name="DATA_VALIDADE")
    private Timestamp dataValidade;
    private String email;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqEmpresa")
    @SequenceGenerator(name="idSeqEmpresa", sequenceName="id", allocationSize=1)
    @Column(name="ID_USER", nullable = false)
    private Long idUser;
    private String master;
    private String nome;
    private String password;
    private String username;
    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    private EmpresaEJB empresaEJB;

    public EmpresaAcessoEJB() {
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Timestamp getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Timestamp dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EmpresaEJB getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaEJB empresaEJB) {
        this.empresaEJB = empresaEJB;
    }
}
