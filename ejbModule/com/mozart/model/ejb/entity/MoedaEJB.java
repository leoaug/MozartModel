package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "MoedaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from MoedaEJB o")
@Table(name = "MOEDA")
public class MoedaEJB extends MozartEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqMoeda")
    @SequenceGenerator(name="idSeqMoeda", sequenceName="id", allocationSize=1)
    @Column(name="ID_MOEDA", nullable = false)
    private Long idMoeda;
    @Column(name="NOME_MOEDA", nullable = false)
    private String nomeMoeda;
    @Column(nullable = false)
    private String sigla;
    private String simbolo;
    
    public String toString (){
        return simbolo +"-"+nomeMoeda; 
    }

    public MoedaEJB() {
    }

    public Long getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Long idMoeda) {
        this.idMoeda = idMoeda;
    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }

    public void setNomeMoeda(String nomeMoeda) {
        this.nomeMoeda = nomeMoeda;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

	public void setInterno(String string) {

		
	}
}
