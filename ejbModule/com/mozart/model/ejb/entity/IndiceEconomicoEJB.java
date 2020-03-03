package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.sql.Timestamp;

// TABELA

/**
 * The persistent class for the INDICE_ECONOMICO database table.
 * 
 */

@Entity
@NamedQueries({				
	@NamedQuery  (name = "IndiceEconomicoEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			    	    query = "select o from IndiceEconomicoEJB o where o.idRedeHotel=?1 order by o.indiceMes")
			})
@Table(name="INDICE_ECONOMICO")
public class IndiceEconomicoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	@Id
	@SequenceGenerator(name="INDICE_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDICE_GENERATOR")
	@Column(name="ID_INDICE_ECONOMICO")
	private Long idIndiceEconomico;
	


	private Timestamp data;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="INDICE_ANUAL")
	private Double indiceAnual;

	@Column(name="INDICE_DO_ANO")
	private Double indiceDoAno;

	@Column(name="INDICE_MES")
	private Double indiceMes;

	//bi-directional many-to-one association to IndiceTipoEJB
    @ManyToOne
	@JoinColumn(name="ID_INDICE_TIPO")
	private IndiceTipoEJB indiceTipo;

    public IndiceEconomicoEJB() {
    }

	
	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	
	public IndiceTipoEJB getIndiceTipo() {
		return this.indiceTipo;
	}

	public void setIndiceTipo(IndiceTipoEJB indiceTipo) {
		this.indiceTipo = indiceTipo;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	public Long getIdIndiceEconomico() {
		return idIndiceEconomico;
	}


	public void setIdIndiceEconomico(Long idIndiceEconomico) {
		this.idIndiceEconomico = idIndiceEconomico;
	}


	public Long getIdRedeHotel() {
		return idRedeHotel;
	}


	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}


	public Double getIndiceAnual() {
		return indiceAnual;
	}


	public void setIndiceAnual(Double indiceAnual) {
		this.indiceAnual = indiceAnual;
	}


	public Double getIndiceDoAno() {
		return indiceDoAno;
	}


	public void setIndiceDoAno(Double indiceDoAno) {
		this.indiceDoAno = indiceDoAno;
	}


	public Double getIndiceMes() {
		return indiceMes;
	}


	public void setIndiceMes(Double indiceMes) {
		this.indiceMes = indiceMes;
	}
	
}