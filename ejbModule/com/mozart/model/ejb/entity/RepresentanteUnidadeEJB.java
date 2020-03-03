package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the REPRESENTANTE_HOTEL database table.
 * 
 */
@Entity
@Table(name="REPRESENTANTE_UNIDADE")
@IdClass(RepresentanteUnidadeEJBPK.class)
@NamedQueries({
	@NamedQuery(name="RepresentanteUnidadeEJB.findPorIdRepresentanteEIdHotel", 
			query="SELECT f from RepresentanteUnidadeEJB f WHERE f.idHotel = :idHotel and f.idRepresentante = :idRepresentante and f.idRedeHotel = :idRedeHotel")
})
public class RepresentanteUnidadeEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_REPRESENTANTE", insertable = false, updatable = false)
	private Long idRepresentante;
	
	@Id
	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	@Id
	@Column(name="ID_REDE_HOTEL", insertable = false, updatable = false)
	private Long idRedeHotel;

	@Column(name="PRAZO_PAGAMENTO")
	private Long prazo;

	@Column(name="COMISSAO")
	private Double comissao;

	
	@OneToOne( fetch=FetchType.EAGER, cascade={CascadeType.REFRESH} )
    @JoinColumns({
    @JoinColumn(name = "ID_REPRESENTANTE", referencedColumnName = "ID_REPRESENTANTE"),
    @JoinColumn(name = "ID_REDE_HOTEL", referencedColumnName = "ID_REDE_HOTEL")
    })
    private RepresentanteRedeEJB representanteRedeEJB;
	
    public RepresentanteUnidadeEJB() {
    }

	public Long getPrazo() {
		return this.prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public Long getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(Long idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public RepresentanteRedeEJB getRepresentanteRedeEJB() {
		return representanteRedeEJB;
	}

	public void setRepresentanteRedeEJB(RepresentanteRedeEJB representanteRedeEJB) {
		this.representanteRedeEJB = representanteRedeEJB;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}
	
}