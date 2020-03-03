package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The persistent class for the HISTORICO_CONTABIL database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery  (name = "HistoricoContabilEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			    	    query = "select o from HistoricoContabilEJB o where o.idRedeHotel=?1 order by o.historico")
			})
@Table(name="HISTORICO_CONTABIL")
public class HistoricoContabilEJB extends MozartEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HISTORICO_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORICO_GENERATOR")
	@Column(name="ID_HISTORICO")
	private Long idHistorico;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="DEBITO_CREDITO")
	private String debitoCredito;

	private String historico;

	@Column(name="ID_HOTEL")
	private Long idHotel;

    public HistoricoContabilEJB() {
    }
    
    public boolean equals(Object obj){
    	if (obj == null || idHistorico == null)
    		return false;
    	
    	return idHistorico.equals( ((HistoricoContabilEJB) obj).getIdHistorico() );
    }

	public String getDebitoCredito() {
		return this.debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

}