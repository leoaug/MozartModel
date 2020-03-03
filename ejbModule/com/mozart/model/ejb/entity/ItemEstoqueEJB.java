package com.mozart.model.ejb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mozart.model.util.MozartUtil;

@Entity
@Table(name = "ITEM_ESTOQUE")
public class ItemEstoqueEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ItemEstoqueEJBPK id;

	private Double aliquota;
	
	@Column(name="CONTROLADO")
	private String controlado;

	private String direto;

	@Column(name = "ESTOQUE_MAXIMO")
	private Long estoqueMaximo;

	@Column(name = "ESTOQUE_MINIMO")
	private Long estoqueMinimo;

	@Column(name = "GERA_ETIQUETA")
	private String geraEtiqueta;

	@Column(name = "ID_ALIQUOTAS_DENTRO")
	private Long idAliquotasDentro;

	@Column(name = "ID_ALIQUOTAS_FORA")
	private Long idAliquotasFora;

	@Column(name = "ID_CENTRO_CUSTO")
	private Long idCentroCusto;

	@Column(name = "ID_CONTA_CONTABIL")
	private Long idContaContabil;

	@Column(name = "ID_FISCAL_CODIGO", insertable = true, updatable = true)
	private Long idFiscalCodigo;

	@Column(name = "ID_FISCAL_INCIDENCIA")
	private Long idFiscalIncidencia;

	@Column(name = "ID_TIPO_ITEM")
	private Long idTipoItem;

	@Column(name = "ID_UNIDADE_ESTOQUE")
	private Long idUnidadeEstoque;

	private String imobilizado;

	@Column(name = "NOME_ITEM")
	private String nomeItem;

	@Column(name = "NOME_ITEM_REDUZIDO")
	private String nomeItemReduzido;

	private String unidade;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumns({
			@JoinColumn(name = "ID_ITEM", referencedColumnName = "ID_ITEM"),
			@JoinColumn(name = "ID_REDE_HOTEL", referencedColumnName = "ID_REDE_HOTEL") })
	private ItemRedeEJB itemRedeEJB;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumns({ @JoinColumn(name = "ID_FISCAL_INCIDENCIA", referencedColumnName = "ID_FISCAL_INCIDENCIA", insertable = false, updatable = false) })
	private FiscalIncidenciaEJB fiscalIncidenciaEJB;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ID_FISCAL_CODIGO", referencedColumnName = "ID_CODIGO_FISCAL", insertable = false, updatable = false)
	private FiscalCodigoEJB fiscalCodigoEJB;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ID_CONTA_CONTABIL", referencedColumnName = "ID_PLANO_CONTAS", insertable = false, updatable = false)
	private PlanoContaEJB planoContaEJB;

	public ItemEstoqueEJB() {
	}

	public Double getAliquota() {
		return this.aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}

	public String getControlado() {
		return this.controlado;
	}

	public void setControlado(String controlado) {
		this.controlado = controlado;
	}

	public String getDireto() {
		return this.direto;
	}

	public void setDireto(String direto) {
		this.direto = direto;
	}

	public Long getEstoqueMaximo() {
		return this.estoqueMaximo;
	}

	public void setEstoqueMaximo(Long estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public Long getEstoqueMinimo() {
		return this.estoqueMinimo;
	}

	public void setEstoqueMinimo(Long estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public String getGeraEtiqueta() {
		return this.geraEtiqueta;
	}

	public void setGeraEtiqueta(String geraEtiqueta) {
		this.geraEtiqueta = geraEtiqueta;
	}

	public Long getIdAliquotasDentro() {
		return this.idAliquotasDentro;
	}

	public void setIdAliquotasDentro(Long idAliquotasDentro) {
		this.idAliquotasDentro = idAliquotasDentro;
	}

	public Long getIdAliquotasFora() {
		return this.idAliquotasFora;
	}

	public void setIdAliquotasFora(Long idAliquotasFora) {
		this.idAliquotasFora = idAliquotasFora;
	}

	public Long getIdCentroCusto() {
		return this.idCentroCusto;
	}

	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	public Long getIdContaContabil() {
		return this.idContaContabil;
	}

	public void setIdContaContabil(Long idContaContabil) {
		this.idContaContabil = idContaContabil;
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

	public Long getIdTipoItem() {
		return this.idTipoItem;
	}

	public void setIdTipoItem(Long idTipoItem) {
		this.idTipoItem = idTipoItem;
	}

	public Long getIdUnidadeEstoque() {
		return this.idUnidadeEstoque;
	}

	public void setIdUnidadeEstoque(Long idUnidadeEstoque) {
		this.idUnidadeEstoque = idUnidadeEstoque;
	}

	public String getImobilizado() {
		return this.imobilizado;
	}

	public void setImobilizado(String imobilizado) {
		this.imobilizado = imobilizado;
	}

	public String getNomeItem() {
		return this.nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getNomeItemReduzido() {
		return this.nomeItemReduzido;
	}

	public void setNomeItemReduzido(String nomeItemReduzido) {
		this.nomeItemReduzido = nomeItemReduzido;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public ItemRedeEJB getItemRedeEJB() {
		return itemRedeEJB;
	}

	public void setItemRedeEJB(ItemRedeEJB itemRedeEJB) {
		this.itemRedeEJB = itemRedeEJB;

		if (!MozartUtil.isNull(itemRedeEJB)
				&& !MozartUtil.isNull(itemRedeEJB.getId()))
			id.setIdItem(itemRedeEJB.getId().getIdItem());
	}

	public FiscalIncidenciaEJB getFiscalIncidenciaEJB() {
		return fiscalIncidenciaEJB;
	}

	public void setFiscalIncidenciaEJB(FiscalIncidenciaEJB fiscalIncidenciaEJB) {
		this.fiscalIncidenciaEJB = fiscalIncidenciaEJB;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEstoqueEJB other = (ItemEstoqueEJB) obj;
		return id.equals(other.getId());
	}

	public ItemEstoqueEJBPK getId() {
		return id;
	}

	public void setId(ItemEstoqueEJBPK id) {
		this.id = id;
	}

	public FiscalCodigoEJB getFiscalCodigoEJB() {
		return fiscalCodigoEJB;
	}

	public void setFiscalCodigoEJB(FiscalCodigoEJB fiscalCodigoEJB) {
		this.fiscalCodigoEJB = fiscalCodigoEJB;
	}

	public PlanoContaEJB getPlanoContaEJB() {
		return planoContaEJB;
	}

	public void setPlanoContaEJB(PlanoContaEJB planoContaEJB) {
		this.planoContaEJB = planoContaEJB;
	}

}