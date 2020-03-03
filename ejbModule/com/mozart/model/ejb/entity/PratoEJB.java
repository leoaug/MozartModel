package com.mozart.model.ejb.entity;

import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the PRATO database table.
 * 
 */
@Entity
@Table(name="PRATO")
@NamedQuery(name = "PratoEJB.findByHotel", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    query = "select o from PratoEJB o where o.id.idHotel = ?1 order by o.descricaoPrato")
public class PratoEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PratoEJBPK id;

	
	private String aliquota;

	@Column(name="DESCRICAO_PRATO")
	private String descricaoPrato;

	@Column(name="FLG_ALCOOLICA")
	private String flgAlcoolica;

	private String icms;

	@Column(name="ID_ALIQUOTA")
	private Long idAliquota;

	@Column(name="ID_FISCAL_CODIGO")
	private Long idFiscalCodigo;

	@Column(name="ID_FISCAL_INCIDENCIA")
	private Long idFiscalIncidencia;

	@Column(name="ID_GRUPO_PRATO")
	private Long idGrupoPrato;


	@Column(name="ID_PONTO_VENDA")
	private Long idPontoVenda;

	@Column(name="ID_TIPO_ITEM")
	private Long idTipoItem;
	
	@Column(name="ID_NFE_UNIDADE")
	private Long idNfeUnidade;

	private String imprimir;

	@Column(name="NOME_PRATO")
	private String nomePrato;

	@Column(name="NCM")
	private String ncm;
	
	@Column(name="CEAN")
	private String cean;
	
	@Column(name="CEST")
	private String cest;
	
	@Column(name="CSTA")
	private String csta;
	
	@Column(name="CSTB")
	private String cstb;

	@Column(name="VALOR_PRATO")
	private Double valorPrato;

	
    @OneToMany(mappedBy = "pratoEJB", fetch=FetchType.EAGER, cascade={CascadeType.REFRESH})
    private List<FichaTecnicaPratoEJB> fichaTecnicaPratoEJBList;

    
    public PratoEJB() {
    }

	public String getAliquota() {
		return this.aliquota;
	}

	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}

	public String getDescricaoPrato() {
		return this.descricaoPrato;
	}

	public void setDescricaoPrato(String descricaoPrato) {
		this.descricaoPrato = descricaoPrato;
	}

	public String getFlgAlcoolica() {
		return this.flgAlcoolica;
	}

	public void setFlgAlcoolica(String flgAlcoolica) {
		this.flgAlcoolica = flgAlcoolica;
	}

	public String getIcms() {
		return this.icms;
	}

	public void setIcms(String icms) {
		this.icms = icms;
	}

	public Long getIdAliquota() {
		return this.idAliquota;
	}

	public void setIdAliquota(Long idAliquota) {
		this.idAliquota = idAliquota;
	}

	public Long getIdFiscalCodigo() {
		return this.idFiscalCodigo;
	}

	public void setIdFiscalCodigo(Long idFiscalCodigo) {
		this.idFiscalCodigo = idFiscalCodigo;
	}

	public Long getIdFiscalIncidencia() {
		return this.idFiscalIncidencia;
	}

	public void setIdFiscalIncidencia(Long idFiscalIncidencia) {
		this.idFiscalIncidencia = idFiscalIncidencia;
	}

	public Long getIdGrupoPrato() {
		return this.idGrupoPrato;
	}

	public void setIdGrupoPrato(Long idGrupoPrato) {
		this.idGrupoPrato = idGrupoPrato;
	}

	public Long getIdPontoVenda() {
		return this.idPontoVenda;
	}

	public void setIdPontoVenda(Long idPontoVenda) {
		this.idPontoVenda = idPontoVenda;
	}

	public Long getIdTipoItem() {
		return this.idTipoItem;
	}

	public void setIdTipoItem(Long idTipoItem) {
		this.idTipoItem = idTipoItem;
	}

	public String getImprimir() {
		return this.imprimir;
	}

	public void setImprimir(String imprimir) {
		this.imprimir = imprimir;
	}

	public String getNomePrato() {
		return this.nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public Double getValorPrato() {
		return this.valorPrato;
	}

	public void setValorPrato(Double valorPrato) {
		this.valorPrato = valorPrato;
	}

	public PratoEJBPK getId() {
		return id;
	}

	public void setId(PratoEJBPK id) {
		this.id = id;
	}

	public List<FichaTecnicaPratoEJB> getFichaTecnicaPratoEJBList() {
		return fichaTecnicaPratoEJBList;
	}

	public void setFichaTecnicaPratoEJBList(
			List<FichaTecnicaPratoEJB> fichaTecnicaPratoEJBList) {
		this.fichaTecnicaPratoEJBList = fichaTecnicaPratoEJBList;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getCsta() {
		return csta;
	}

	public void setCsta(String csta) {
		this.csta = csta;
	}

	public String getCstb() {
		return cstb;
	}

	public void setCstb(String cstb) {
		this.cstb = cstb;
	}

	public Long getIdNfeUnidade() {
		return idNfeUnidade;
	}

	public void setIdNfeUnidade(Long idNfeUnidade) {
		this.idNfeUnidade = idNfeUnidade;
	}

	public String getCean() {
		return cean;
	}

	public void setCean(String cean) {
		this.cean = cean;
	}

	public String getCest() {
		return cest;
	}

	public void setCest(String cest) {
		this.cest = cest;
	}
	
	
}