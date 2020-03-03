package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the TIPO_EMPRESA database table.
 * 
 */
@Entity
@Table(name="TIPO_EMPRESA")
public class TipoEmpresaEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="TIPO_EMRPESA_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_EMRPESA_GENERATOR")
	@Column(name="ID_TIPO_EMPRESA")
	private long idTipoEmpresa;

	@Column(name="ID_REDE_HOTEL")
	private long idRedeHotel;

	@Column(name="COMISSAO_CRS")
	private Double comissaoCrs;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="TIPO_EMPRESA")
	private String tipoEmpresa;
	
	@Column(name="PADRAO")
	private String padrao;

    public TipoEmpresaEJB() {
    }

	public Double getComissaoCrs() {
		return this.comissaoCrs;
	}

	public void setComissaoCrs(Double comissaoCrs) {
		this.comissaoCrs = comissaoCrs;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public long getIdTipoEmpresa() {
		return idTipoEmpresa;
	}

	public void setIdTipoEmpresa(long idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}

	public long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getPadrao() {
		return padrao;
	}

	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}
	
	

}