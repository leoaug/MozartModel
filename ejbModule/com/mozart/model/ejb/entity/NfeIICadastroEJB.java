package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "NfeIICadastroEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIICadastroEJB o"),
	@NamedQuery(name = "NfeIICadastroEJB.findByHotelAndPrato", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeIICadastroEJB o where o.hotel.idHotel = ?1 and o.pratoEJB.id.idPrato = ?2")
})
@Table(name = "NFE_II_CADASTRO")
public class NfeIICadastroEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_II_CADASTRO")
	@SequenceGenerator(name="SEQ_MOVIMENTO_ESTOQUE", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_ESTOQUE")
    private Long idNfeIICadastro;
	
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL", insertable=false, updatable=false, referencedColumnName = "ID_HOTEL")
	private HotelEJB hotel;
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO"),
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL")
    })
    private PratoEJB pratoEJB;
	
    @Column(name="VDESPADU")
    private Double valDespAdu;
    
    @Column(name="VII")
    private Double vII;
    
    @Column(name="VIOF")
    private Double vIof;
    
    public NfeIICadastroEJB() {
    }

	public Long getIdNfeIICadastro() {
		return idNfeIICadastro;
	}

	public void setIdNfeIICadastro(Long idNfeIICadastro) {
		this.idNfeIICadastro = idNfeIICadastro;
	}

	public Double getValDespAdu() {
		return valDespAdu;
	}

	public void setValDespAdu(Double valDespAdu) {
		this.valDespAdu = valDespAdu;
	}

	public Double getvII() {
		return vII;
	}

	public void setvII(Double vII) {
		this.vII = vII;
	}

	public Double getvIof() {
		return vIof;
	}

	public void setvIof(Double vIof) {
		this.vIof = vIof;
	}

	public HotelEJB getHotel() {
		return hotel;
	}

	public void setHotel(HotelEJB hotel) {
		this.hotel = hotel;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}	
}
