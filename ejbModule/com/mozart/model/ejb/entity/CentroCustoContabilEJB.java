package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the CENTRO_CUSTO_CONTABIL database table.
 * 
 */
@Entity
@Table(name="CENTRO_CUSTO_CONTABIL")
@NamedQuery(name = "CentroCustoContabilEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from CentroCustoContabilEJB o where o.idRedeHotel = ?1 order by o.descricaoCentroCusto")
public class CentroCustoContabilEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqCCC")
	@SequenceGenerator(name="idSeqCCC", sequenceName="id", allocationSize=1)
	@Column(name="ID_CENTRO_CUSTO_CONTABIL")
	private Long idCentroCustoContabil;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="CONTROLADO")
	private String controlado;

	@Column(name="CREDITO_PENSAO")
	private String creditoPensao;

	@Column(name="DESCRICAO_CENTRO_CUSTO")
	private String descricaoCentroCusto;

	@Column(name="ID_DEPARTAMENTO")
	private Long idDepartamento;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="TIPO_CUSTO")
	private String tipoCusto;

	@Column(name="TIPO_PESSOA")
	private String tipoPessoa;

    public CentroCustoContabilEJB() {
    }

	
	public String getControlado() {
		return this.controlado;
	}

	public void setControlado(String controlado) {
		this.controlado = controlado;
	}

	public String getCreditoPensao() {
		return this.creditoPensao;
	}

	public void setCreditoPensao(String creditoPensao) {
		this.creditoPensao = creditoPensao;
	}

	public String getDescricaoCentroCusto() {
		return this.descricaoCentroCusto;
	}

	public void setDescricaoCentroCusto(String descricaoCentroCusto) {
		this.descricaoCentroCusto = descricaoCentroCusto;
	}

	public Long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getTipoCusto() {
		return this.tipoCusto;
	}

	public void setTipoCusto(String tipoCusto) {
		this.tipoCusto = tipoCusto;
	}

	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Long getIdCentroCustoContabil() {
		return idCentroCustoContabil;
	}

	public void setIdCentroCustoContabil(Long idCentroCustoContabil) {
		this.idCentroCustoContabil = idCentroCustoContabil;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idCentroCustoContabil == null) ? 0 : idCentroCustoContabil
						.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentroCustoContabilEJB other = (CentroCustoContabilEJB) obj;
		if (idCentroCustoContabil == null) {
			if (other.idCentroCustoContabil != null)
				return false;
		} else if (!idCentroCustoContabil.equals(other.idCentroCustoContabil))
			return false;
		return true;
	}

}