package com.mozart.model.ejb.entity;

import java.util.Comparator;

import javax.persistence.*;

/**
 * The persistent class for the PRATO_PONTO_VENDA database table.
 * 
 */
@Entity
@Table(name="PRATO_PONTO_VENDA")
public class PratoPontoVendaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqMovPDV")
    @SequenceGenerator(name="idSeqMovPDV", sequenceName="id", allocationSize=1)
	@Column(name="ID_PRATO_PONTO_VENDA")
	private Long idPratoPontoVenda;

	@ManyToOne
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable=false, updatable=false),
    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO")
    })
    private PratoEJB pratoEJB;
	
	@ManyToOne
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_PONTO_VENDA", referencedColumnName = "ID_PONTO_VENDA")
    })
    private PontoVendaEJB pontoVendaEJB;


    public PratoPontoVendaEJB() {
    }

    
    
    public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PratoPontoVendaEJB)) {
			return false;
		}

		if (pratoEJB == null) {
			return false;
		}
		PratoPontoVendaEJB castOther = (PratoPontoVendaEJB)other;
		return pratoEJB.getId().equals(castOther.getPratoEJB().getId());
    }
    
    
    
    @SuppressWarnings("unchecked")
	public static Comparator getComparator(){
        return new Comparator<PratoPontoVendaEJB>() {  
            @Override  
            public int compare(PratoPontoVendaEJB p1, PratoPontoVendaEJB p2) {  
                return p1.getPratoEJB().getNomePrato().toUpperCase().compareTo(p2.getPratoEJB().getNomePrato().toUpperCase());  
            }  
        };
    }
    
	public Long getIdPratoPontoVenda() {
		return this.idPratoPontoVenda;
	}

	public void setIdPratoPontoVenda(Long idPratoPontoVenda) {
		this.idPratoPontoVenda = idPratoPontoVenda;
	}

	public PratoEJB getPratoEJB() {
		return pratoEJB;
	}

	public void setPratoEJB(PratoEJB pratoEJB) {
		this.pratoEJB = pratoEJB;
	}

	public PontoVendaEJB getPontoVendaEJB() {
		return pontoVendaEJB;
	}

	public void setPontoVendaEJB(PontoVendaEJB pontoVendaEJB) {
		this.pontoVendaEJB = pontoVendaEJB;
	}

}