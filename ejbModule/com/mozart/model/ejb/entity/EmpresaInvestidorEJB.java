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
@NamedQuery(name = "EmpresaInvestidorEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaInvestidorEJB o")
@Table(name = "EMPRESA_INVESTIDOR")
@IdClass(EmpresaInvestidorEJBPK.class)
public class EmpresaInvestidorEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 445062011292761435L;
	private String agencia;
    private String contacorrente;
    @Column(name="DATA_FINAL")
    private Timestamp dataFinal;
    @Column(name="DATA_INICIAL")
    private Timestamp dataInicial;
    @Id
    @Column(name="ID_APARTAMENTO", nullable = false)
    private Long idApartamento;
    @Column(name="ID_BANCO")
    private Long idBanco;
    @Id
    @Column(name="ID_EMPRESA", nullable = false)
    private Long idEmpresa;
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Column(nullable = false)
    private Double indice;
    @Column(name="PESSOA_FISICA", nullable = false)
    private String pessoaFisica;

    public EmpresaInvestidorEJB() {
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContacorrente() {
        return contacorrente;
    }

    public void setContacorrente(String contacorrente) {
        this.contacorrente = contacorrente;
    }

    public Timestamp getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Timestamp getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Timestamp dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Long getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Long idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Double getIndice() {
        return indice;
    }

    public void setIndice(Double indice) {
        this.indice = indice;
    }

    public String getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(String pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
