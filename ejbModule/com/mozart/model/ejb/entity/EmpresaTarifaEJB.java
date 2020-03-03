package com.mozart.model.ejb.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EmpresaTarifaEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaTarifaEJB o")
@Table(name = "EMPRESA_TARIFA")
@IdClass(EmpresaTarifaEJBPK.class)
public class EmpresaTarifaEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7072135775380724732L;
	@Id
    @Column(name="ID_EMPRESA", nullable = false, insertable = false, 
        updatable = false)
    private Long idEmpresa;
    @Id
    @Column(name="ID_HOTEL", nullable = false, insertable = false, 
        updatable = false)
    private Long idHotel;
    @Id
    @Column(name="ID_TARIFA", nullable = false, insertable = false, 
            updatable = false)
    private Long idTarifa;
    @ManyToOne
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    })
    private EmpresaHotelEJB empresaHotelEJB;

    
    @OneToOne
    @JoinColumn(name = "ID_TARIFA", referencedColumnName = "ID_TARIFA")
    private TarifaEJB tarifaEJB;

    public EmpresaTarifaEJB() {
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

    public Long getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Long idTarifa) {
        this.idTarifa = idTarifa;
    }

    public EmpresaHotelEJB getEmpresaHotelEJB() {
        return empresaHotelEJB;
    }

    public void setEmpresaHotelEJB(EmpresaHotelEJB empresaHotelEJB) {
        this.empresaHotelEJB = empresaHotelEJB;
    }

	public TarifaEJB getTarifaEJB() {
		return tarifaEJB;
	}

	public void setTarifaEJB(TarifaEJB tarifaEJB) {
		this.tarifaEJB = tarifaEJB;
	}
}
