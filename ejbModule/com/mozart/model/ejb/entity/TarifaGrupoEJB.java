package com.mozart.model.ejb.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the TARIFA_GRUPO database table.
 * 
 */
@Entity
@Table(name="TARIFA_GRUPO")
public class TarifaGrupoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TARIFA_GRUPO_IDTARIFAGRUPO_GENERATOR", sequenceName="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TARIFA_GRUPO_IDTARIFAGRUPO_GENERATOR")
	@Column(name="ID_TARIFA_GRUPO")
	private Long idTarifaGrupo;

	private String descricao;

	private BigDecimal dom;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	private BigDecimal qua;

	private BigDecimal qui;

	private BigDecimal sab;

	private BigDecimal seg;

	private BigDecimal sex;

	private BigDecimal ter;

	
	@OneToMany(mappedBy="tarifaGrupo")
	private List<TarifaEJB> tarifas;

    public TarifaGrupoEJB() {
    }

	public Long getIdTarifaGrupo() {
		return this.idTarifaGrupo;
	}

	public void setIdTarifaGrupo(Long idTarifaGrupo) {
		this.idTarifaGrupo = idTarifaGrupo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getDom() {
		return this.dom;
	}

	public void setDom(BigDecimal dom) {
		this.dom = dom;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public BigDecimal getQua() {
		return this.qua;
	}

	public void setQua(BigDecimal qua) {
		this.qua = qua;
	}

	public BigDecimal getQui() {
		return this.qui;
	}

	public void setQui(BigDecimal qui) {
		this.qui = qui;
	}

	public BigDecimal getSab() {
		return this.sab;
	}

	public void setSab(BigDecimal sab) {
		this.sab = sab;
	}

	public BigDecimal getSeg() {
		return this.seg;
	}

	public void setSeg(BigDecimal seg) {
		this.seg = seg;
	}

	public BigDecimal getSex() {
		return this.sex;
	}

	public void setSex(BigDecimal sex) {
		this.sex = sex;
	}

	public BigDecimal getTer() {
		return this.ter;
	}

	public void setTer(BigDecimal ter) {
		this.ter = ter;
	}

	public List<TarifaEJB> getTarifas() {
		return this.tarifas;
	}

	public void setTarifas(List<TarifaEJB> tarifas) {
		this.tarifas = tarifas;
	}
	
}