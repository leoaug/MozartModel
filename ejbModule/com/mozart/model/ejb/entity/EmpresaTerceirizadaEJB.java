package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EmpresaTerceirizadaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaTerceirizadaEJB o")
@Table(name = "EMPRESA_TERCEIRIZADA")
@IdClass(EmpresaTerceirizadaEJBPK.class)
public class EmpresaTerceirizadaEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 378036614021828496L;
	@Id
    @Column(name="ID_EMPRESA", nullable = false, insertable = false, 
        updatable = false)
    private Long idEmpresa;
    @Id
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Column(name="NOME_FANTASIA")
    private String nomeFantasia;
    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    private EmpresaEJB empresaEJB;

    public EmpresaTerceirizadaEJB() {
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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public EmpresaEJB getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaEJB empresaEJB) {
        this.empresaEJB = empresaEJB;
    }
}
