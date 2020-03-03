package com.mozart.model.ejb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.mozart.model.util.MozartUtil;

@Entity
@Table(name="ITEM_REDE")
public class ItemRedeEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemRedeEJBPK id;

	@Column(name="CODIGO_BARRA")
	private String codigoBarra;

	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name="ID_CENTRO_CUSTO", referencedColumnName="ID_CENTRO_CUSTO_CONTABIL")
    private CentroCustoContabilEJB centroCustoContabilEJB;

	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name="ID_CONTA_CONTABIL", referencedColumnName="ID_PLANO_CONTAS")
    private PlanoContaEJB contaContabilEJB;

	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_PLANO_CONTAS", referencedColumnName="ID_PLANO_CONTAS")
	private PlanoContaEJB planoContaEJB;

	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name="ID_TIPO_ITEM", referencedColumnName="ID_TIPO_ITEM")
    private TipoItemEJB tipoItemEJB;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name="ID_UNIDADE_COMPRA", referencedColumnName="ID_UNIDADE_ESTOQUE")
    private UnidadeEstoqueEJB unidadeEstoqueCompraEJB;

	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name="ID_UNIDADE_ESTOQUE", referencedColumnName="ID_UNIDADE_ESTOQUE")
    private UnidadeEstoqueEJB unidadeEstoqueRedeEJB;

	@ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name="ID_UNIDADE_REQUISICAO", referencedColumnName="ID_UNIDADE_ESTOQUE")
    private UnidadeEstoqueEJB unidadeEstoqueRequisicaoJB;
	
	@Column(name="IMOBILIZADO")
	private String imobilizado;

	@Column(name="NOME_ITEM")
	private String nomeItem;

	@Column(name="NOME_ITEM_REDUZIDO")
	private String nomeItemReduzido;

	@OneToMany(mappedBy = "itemRedeEJB", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	private List<ItemEstoqueEJB> itemEstoqueEJBList;
	
	@Column(name="COD_NCM")
	private String codNcm;

	public ItemRedeEJB() {
    }

	public ItemRedeEJBPK getId() {
		return this.id;
	}

	public void setId(ItemRedeEJBPK id) {
		this.id = id;
	}
	
	public String getCodigoBarra() {
		return this.codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
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

	public UnidadeEstoqueEJB getUnidadeEstoqueCompraEJB() {
		return unidadeEstoqueCompraEJB;
	}

	public void setUnidadeEstoqueCompraEJB(UnidadeEstoqueEJB unidadeEstoqueCompraEJB) {
		this.unidadeEstoqueCompraEJB = unidadeEstoqueCompraEJB;
	}

	public UnidadeEstoqueEJB getUnidadeEstoqueRedeEJB() {
		return unidadeEstoqueRedeEJB;
	}

	public void setUnidadeEstoqueRedeEJB(UnidadeEstoqueEJB unidadeEstoqueRedeEJB) {
		this.unidadeEstoqueRedeEJB = unidadeEstoqueRedeEJB;
	}

	public UnidadeEstoqueEJB getUnidadeEstoqueRequisicaoJB() {
		return unidadeEstoqueRequisicaoJB;
	}

	public void setUnidadeEstoqueRequisicaoJB(
			UnidadeEstoqueEJB unidadeEstoqueRequisicaoJB) {
		this.unidadeEstoqueRequisicaoJB = unidadeEstoqueRequisicaoJB;
	}

	public TipoItemEJB getTipoItemEJB() {
		return tipoItemEJB;
	}

	public void setTipoItemEJB(TipoItemEJB tipoItemEJB) {
		this.tipoItemEJB = tipoItemEJB;
	}

	public CentroCustoContabilEJB getCentroCustoContabilEJB() {
		return centroCustoContabilEJB;
	}

	public void setCentroCustoContabilEJB(
			CentroCustoContabilEJB centroCustoContabilEJB) {
		this.centroCustoContabilEJB = centroCustoContabilEJB;
	}

	public PlanoContaEJB getContaContabilEJB() {
		return contaContabilEJB;
	}

	public void setContaContabilEJB(PlanoContaEJB contaContabilEJB) {
		this.contaContabilEJB = contaContabilEJB;
	}

	public List<ItemEstoqueEJB> getItemEstoqueEJBList() {
		return itemEstoqueEJBList;
	}

	public void setItemEstoqueEJBList(List<ItemEstoqueEJB> itemEstoqueEJBList) {
		this.itemEstoqueEJBList = itemEstoqueEJBList;
	}
	
	public String getCodNcm() {
		return codNcm;
	}

	public void setCodNcm(String codNcm) {
		this.codNcm = codNcm;
	}
	
	

	public PlanoContaEJB getPlanoContaEJB() {
		return planoContaEJB;
	}

	public void setPlanoContaEJB(PlanoContaEJB planoContaEJB) {
		this.planoContaEJB = planoContaEJB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemRedeEJB other = (ItemRedeEJB) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void addItemEstoqueEJB(ItemEstoqueEJB itemEstoque) {
		if(MozartUtil.isNull(itemEstoqueEJBList)){
			itemEstoqueEJBList= new ArrayList <ItemEstoqueEJB>();
		}
		
		itemEstoque.setItemRedeEJB(this);
		itemEstoqueEJBList.add(itemEstoque);
		
	}

	
}