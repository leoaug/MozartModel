package com.mozart.model.ejb.entity;

import javax.persistence.*;

/**
 * The persistent class for the DEPARTAMENTO database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery  (name = "DepartamentoEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			    	    query = "select o from DepartamentoEJB o where o.idRedeHotel=?1 order by o.descricao")
			})
@Table(name="DEPARTAMENTO")
public class DepartamentoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DPTO_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DPTO_GENERATOR")
	@Column(name="ID_DEPARTAMENTO")
	private Long idDepartamento;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;
	
	
	private String descricao;

    public DepartamentoEJB() {
    }

	
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Long getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public Long getIdRedeHotel() {
		return idRedeHotel;
	}


	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

}