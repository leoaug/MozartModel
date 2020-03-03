package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EmpresaCrsEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaCrsEJB o")
@Table(name = "EMPRESA_CRS")
@IdClass(EmpresaCrsEJBPK.class)
public class EmpresaCrsEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2975422472902299106L;
	private String contato;
    private String contato2;
    @Column(nullable = false)
    private String credito;
    @Column(name="DATA_CADASTRO", nullable = false)
    private Timestamp dataCadastro;
    @Column(name="DATA_NASCIMENTO")
    private Timestamp dataNascimento;
    @Column(name="DATA_NASCIMENTO2")
    private Timestamp dataNascimento2;
    private String email;
    private String email2;
    private String fax;
    @Column(name="ID_CORPORATE")
    private Long idCorporate;
    @Id
    @Column(name="ID_CRS", nullable = false)
    private Long idCrs;
    @Id
    @Column(name="ID_EMPRESA", nullable = false)
    private Long idEmpresa;
    @Column(name="ID_GRUPO_ECONOMICO")
    private Long idGrupoEconomico;
    @Column(name="NOME_FANTASIA", nullable = false)
    private String nomeFantasia;
    private String observacao;
    private String particular;
    private String telefone;
    private String telefone2;
    private String telex;
    @Column(name="VALOR_CREDITO")
    private Double valorCredito;

    public EmpresaCrsEJB() {
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Timestamp getDataNascimento2() {
        return dataNascimento2;
    }

    public void setDataNascimento2(Timestamp dataNascimento2) {
        this.dataNascimento2 = dataNascimento2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Long getIdCorporate() {
        return idCorporate;
    }

    public void setIdCorporate(Long idCorporate) {
        this.idCorporate = idCorporate;
    }

    public Long getIdCrs() {
        return idCrs;
    }

    public void setIdCrs(Long idCrs) {
        this.idCrs = idCrs;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdGrupoEconomico() {
        return idGrupoEconomico;
    }

    public void setIdGrupoEconomico(Long idGrupoEconomico) {
        this.idGrupoEconomico = idGrupoEconomico;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelex() {
        return telex;
    }

    public void setTelex(String telex) {
        this.telex = telex;
    }

    public Double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }
}
