package com.mozart.model.ejb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "PaisEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from PaisEJB o")
@Table(name = "PAIS")
public class PaisEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	@Id
    @Column(nullable = false)
    private Long codpais;
    @Column(nullable = false)
    private String ddi;
    @Column(name="ID_CONTINENTE")
    private Long idContinente;
    @Column(nullable = false)
    private String nacionalidade;
    @Column(nullable = false)
    private String pais;

    public PaisEJB() {
    }

    public Long getCodpais() {
        return codpais;
    }

    public void setCodpais(Long codpais) {
        this.codpais = codpais;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public Long getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Long idContinente) {
        this.idContinente = idContinente;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
