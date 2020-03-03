package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.FornecedorGrupoEJB;
import com.mozart.model.ejb.entity.FornecedorRedeEJB;
import com.mozart.model.ejb.entity.ItemRedeEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.UnidadeEstoqueEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.EstoqueItemVO;
import com.mozart.model.vo.FornecedorVO;

@Remote
public interface ComprasSession {

	String QRY_FORNECEDOR = " SELECT "
			+ " FR.ID_FORNECEDOR, E.CGC, FR.CONTATO, FR.NOME_FANTASIA, FR.TELEFONE_1, "
			+ " FR.TELEFONE_2, FR.TELEFONE_3, FR.E_MAIL_1, FR.E_MAIL_2, FR.E_MAIL_3, FR.FAX, FR.PIS, FR.CONTAS_PAGAR "
			+ " FROM EMPRESA E, FORNECEDOR_REDE FR, FORNECEDOR_HOTEL FH, CONTROLA_DATA CD "
			+ " WHERE E.ID_EMPRESA = FR.ID_FORNECEDOR "
			+ " AND FR.ID_FORNECEDOR = FH.ID_FORNECEDOR "
			+ " AND FH.ID_HOTEL = CD.ID_HOTEL "
			+ " AND FR.ID_REDE_HOTEL = CD.ID_REDE_HOTEL ";

	String QRY_ESTOQUE_ITEM = " SELECT "
			+ " ITEM_REDE.ID_ITEM, ITEM_ESTOQUE.IMOBILIZADO,ITEM_REDE.NOME_ITEM, "
			+ " UE.NOME_UNIDADE_REDUZIDO, PLANO_CONTAS.NOME_CONTA, CENTRO_CUSTO_CONTABIL.DESCRICAO_CENTRO_CUSTO, "
			+ " ITEM_ESTOQUE.DIRETO, ITEM_ESTOQUE.CONTROLADO, ITEM_ESTOQUE.ALIQUOTA, ITEM_ESTOQUE.ID_FISCAL_INCIDENCIA, "
			+ " ITEM_ESTOQUE.ESTOQUE_MINIMO, ITEM_ESTOQUE.ESTOQUE_MAXIMO, TIPO_ITEM.NOME_TIPO,HOTEL.SIGLA, "
			+ " UE.NOME_UNIDADE UNIDADE_REDE, UC.NOME_UNIDADE UNIDADE_COMPRA, UR.NOME_UNIDADE UNIDADE_REQUISICAO,"
			+ " ITEM_ESTOQUE.ID_CENTRO_CUSTO, ITEM_REDE.NOME_ITEM_REDUZIDO "
			+ " FROM ITEM_ESTOQUE, UNIDADE_ESTOQUE UE, PLANO_CONTAS,CENTRO_CUSTO_CONTABIL, "
			+ " TIPO_ITEM, ITEM_REDE, HOTEL, UNIDADE_ESTOQUE UC, UNIDADE_ESTOQUE UR "
			+ " WHERE ITEM_ESTOQUE.ID_hotel = ?1 "
			+ " AND ITEM_REDE.ID_UNIDADE_ESTOQUE = UE.ID_UNIDADE_ESTOQUE "
			+ " AND ITEM_rede.ID_rede_hotel = UE.ID_rede_HOTEL "
			+ " AND ITEM_REDE.ID_TIPO_ITEM = TIPO_ITEM.ID_TIPO_ITEM "
			+ " AND ITEM_ESTOQUE.ID_REDE_HOTEL =  PLANO_CONTAS.ID_REDE_HOTEL "
			+ " AND ITEM_REDE.ID_CONTA_CONTABIL = PLANO_CONTAS.ID_PLANO_CONTAS "
			+ " AND ITEM_ESTOQUE.ID_REDE_HOTEL = CENTRO_CUSTO_CONTABIL.ID_REDE_HOTEL(+) "
			+ " AND ITEM_ESTOQUE.ID_CENTRO_CUSTO = CENTRO_CUSTO_CONTABIL.ID_CENTRO_CUSTO_CONTABIL(+) "
			+ " AND ITEM_REDE.ID_ITEM = ITEM_ESTOQUE.ID_ITEM "
			+ " AND ITEM_ESTOQUE.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND UC.ID_UNIDADE_ESTOQUE = ITEM_REDE.ID_UNIDADE_COMPRA "
			+ " AND UR.ID_UNIDADE_ESTOQUE = ITEM_REDE.ID_UNIDADE_REQUISICAO "
			+ " AND ITEM_rede.ID_rede_hotel = UC.ID_rede_HOTEL "
			+ " AND ITEM_rede.ID_rede_hotel = UR.ID_rede_HOTEL ";
	
	String QRY_ESTOQUE_ITEM_JOIN_MOVIMENTO_ESTOQUE = " SELECT"
			+ " ITENS.ID_ITEM,"
			+ " ITENS.IMOBILIZADO,"
			+ " ITENS.NOME_ITEM,"
			+ " ITENS.NOME_UNIDADE_REDUZIDO,"
			+ " ITENS.NOME_CONTA, "
			+ " ITENS.DESCRICAO_CENTRO_CUSTO,"
			+ " ITENS.DIRETO,"
			+ " ITENS.CONTROLADO,"
			+ " ITENS.ALIQUOTA,"
			+ " ITENS.ID_FISCAL_INCIDENCIA,"
			+ " ITENS.ESTOQUE_MINIMO,"
			+ " ITENS.ESTOQUE_MAXIMO,"
			+ " ITENS.NOME_TIPO,"
			+ " ITENS.SIGLA,"
			+ " ITENS.UNIDADE_REDE UNIDADE_REDE,"
			+ " ITENS.UNIDADE_COMPRA UNIDADE_COMPRA,"
			+ " ITENS.UNIDADE_REQUISICAO UNIDADE_REQUISICAO,"
			+ " ITENS.ID_CENTRO_CUSTO,"
			+ " ITENS.NOME_UNIDADE_REDUZIDO"
			+ " FROM ( "
			+ QRY_ESTOQUE_ITEM
			+ " ) ITENS LEFT JOIN MOVIMENTO_ESTOQUE MOVIMENTO_ESTOQUE "
			+ " ON MOVIMENTO_ESTOQUE.ID_ITEM = ITENS.ID_ITEM "
			+ " WHERE 1=1 ";

	public abstract List<FornecedorVO> pesquisarFornecedor(FornecedorVO filtro)
			throws MozartSessionException;

	public abstract List<FornecedorGrupoEJB> pesquisarFornecedorGrupo(
			FornecedorGrupoEJB fornecedor) throws MozartSessionException;

	public abstract void gravarFornecedor(FornecedorRedeEJB fornecedor)
			throws MozartSessionException;

	public abstract List<EstoqueItemVO> pesquisarEstoqueItem(
			EstoqueItemVO filtro) throws MozartSessionException;

	public abstract List<UnidadeEstoqueEJB> pesquisarUnidadeEstoque(
			RedeHotelEJB redeHotel) throws MozartSessionException;

	public abstract List<ItemRedeEJB> pesquisarItemRede(ItemRedeEJB itemRede)
			throws MozartSessionException;
	
	public List<ItemRedeEJB> pesquisarItemRedeLikeNome(ItemRedeEJB itemRede, String nomeItem) throws MozartSessionException;
	public List<TipoItemEJB> pesquisarTipoItemLikeNome(TipoItemEJB tipoItem, String nomeTipo) throws MozartSessionException;
}