package com.mozart.model.ejb.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EstadoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from EstadoEJB o")
@Table(name = "ESTADO")
public class EstadoEJB extends MozartEntity {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6718661793488850896L;
	@JoinColumn(name="CODPAIS", referencedColumnName="CODPAIS")
    private PaisEJB pais;
    @Column(nullable = false)
    private String estado;
    @Id
    @Column(name="ID_ESTADO", nullable = false)
    private Long idEstado;
    @Column(nullable = false)
    private String uf;

    public EstadoEJB() {
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setPais(PaisEJB pais) {
        this.pais = pais;
    }

    public PaisEJB getPais() {
        return pais;
    }
}
