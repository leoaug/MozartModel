package com.mozart.model.ejb.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.FornecedorGrupoEJB;
import com.mozart.model.ejb.entity.FornecedorRedeEJB;
import com.mozart.model.ejb.entity.FornecedorRedeEJBPK;
import com.mozart.model.ejb.entity.ItemRedeEJB;
import com.mozart.model.ejb.entity.NfeUnidadeEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.UnidadeEstoqueEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartModelConstantes;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.EstoqueItemVO;
import com.mozart.model.vo.FornecedorVO;

@Stateless(name = "ComprasSession")
public class ComprasSessionBean implements ComprasSession {

	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<FornecedorVO> pesquisarFornecedor(FornecedorVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_FORNECEDOR;

			if (!MozartUtil.isNull(filtro.getFiltroCgc().getTipoIntervalo())) {
				sql += " AND E.CGC " + filtro.getFiltroCgc();
			}

			if (!MozartUtil.isNull(filtro.getFiltroNomeFantasia()
					.getTipoIntervalo())) {
				sql += " AND FR.NOME_FANTASIA "
						+ filtro.getFiltroNomeFantasia();
			}

			sql += " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||cd.id_hotel||';') >= 1 ";

			sql += " ORDER BY FR.NOME_FANTASIA ";

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdHoteis()[0]).getResultList();
			List<FornecedorVO> resultado = new ArrayList<FornecedorVO>();
			for (Object l : lista) {
				resultado.add(new FornecedorVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<FornecedorGrupoEJB> pesquisarFornecedorGrupo(
			FornecedorGrupoEJB fornecedor) throws MozartSessionException {

		try {
			List<FornecedorGrupoEJB> lista = manager
					.createQuery(
							"select o from FornecedorGrupoEJB o where o.idRedeHotel=?1 order by o.descricao")
					.setHint(MozartModelConstantes.ECLIPSELINK_REFRESH,
							MozartModelConstantes.ECLIPSELINK_REFRESH_VALUE)
					.setParameter(1, fornecedor.getIdRedeHotel())
					.getResultList();

			return lista;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());

		}
	}

	public void gravarFornecedor(FornecedorRedeEJB fornecedor)
			throws MozartSessionException {

		try {
			FornecedorRedeEJBPK id = new FornecedorRedeEJBPK();
			id.setIdFornecedor(fornecedor.getIdFornecedor());
			id.setIdRedeHotel(fornecedor.getIdRedeHotel());
			if (manager.find(FornecedorRedeEJB.class, id) != null) {

				manager.merge(fornecedor);

			} else {

				manager.persist(fornecedor);

			}

		} catch (Exception ex) {

			throw new MozartSessionException(ex.getMessage());

		}

	}

	public List<EstoqueItemVO> pesquisarEstoqueItem(EstoqueItemVO filtro)
			throws MozartSessionException {
		StringBuilder sql = new StringBuilder(QRY_ESTOQUE_ITEM_JOIN_MOVIMENTO_ESTOQUE);

		if (!MozartUtil.isNull(filtro.getNomeconta().getTipoIntervalo())) {
			sql.append(" AND ITENS.NOME_CONTA ").append(filtro.getNomeconta());
		}

		if (!MozartUtil.isNull(filtro.getItem().getTipoIntervalo())) {
			sql.append(" AND ITENS.NOME_ITEM ").append(filtro.getItem());
		}

		if (!MozartUtil.isNull(filtro.getTipoitem().getTipoIntervalo())) {
			sql.append(" AND ITENS.NOME_TIPO ").append(filtro.getTipoitem());
		}

		if (!MozartUtil.isNull(filtro.getFiltroNomeOuNomeReduzido()
				.getValorInicial())) {
			sql.append(" AND (").append(" ITENS.NOME_ITEM ")
					.append(filtro.getFiltroNomeOuNomeReduzido())
					.append(" OR ITENS.NOME_ITEM_REDUZIDO ")
					.append(filtro.getFiltroNomeOuNomeReduzido()).append(") ");
		}

		if (!MozartUtil.isNull(filtro.getIdCentroCusto())) {
			sql.append(" AND MOVIMENTO_ESTOQUE.TIPO_MOVIMENTO = ")
					.append("'S'")
					.append(" AND MOVIMENTO_ESTOQUE.ID_CENTRO_CUSTO = ")
					.append(filtro.getIdCentroCusto());
		}

		sql.append("  GROUP BY ITENS.ID_ITEM, ")
				.append("  ITENS.IMOBILIZADO, ")
				.append("  ITENS.NOME_ITEM,")
				.append("  ITENS.NOME_UNIDADE_REDUZIDO, ")
				.append("  ITENS.NOME_CONTA,")
				.append("  ITENS.DESCRICAO_CENTRO_CUSTO, ")
				.append("  ITENS.DIRETO,")
				.append("  ITENS.CONTROLADO, ")
				.append("  ITENS.ALIQUOTA,")
				.append("  ITENS.ID_FISCAL_INCIDENCIA, ")
				.append("  ITENS.ESTOQUE_MINIMO,")
				.append("  ITENS.ESTOQUE_MAXIMO, ")
				.append("  ITENS.NOME_TIPO,")
				.append("  ITENS.SIGLA, ")
				.append("  ITENS.UNIDADE_REDE ,")
				.append("  ITENS.UNIDADE_COMPRA , ")
				.append("  ITENS.UNIDADE_REQUISICAO ,")
				.append("  ITENS.ID_CENTRO_CUSTO, ")
				.append("  ITENS.NOME_ITEM_REDUZIDO ");

		sql.append(" ORDER BY ITENS.NOME_ITEM ASC ");

		try {
			List lista = manager.createNativeQuery(sql.toString())
					.setParameter(1, filtro.getIdHoteis()[0]).getResultList();

			List<EstoqueItemVO> resultado = new ArrayList<EstoqueItemVO>();
			for (Object l : lista) {
				resultado.add(new EstoqueItemVO((Object[]) l));
			}

			return resultado;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<UnidadeEstoqueEJB> pesquisarUnidadeEstoque(
			RedeHotelEJB redeHotel) throws MozartSessionException {

		try {
		
			return manager
					.createQuery(
							"select o from UnidadeEstoqueEJB o where o.idRedeHotel=?1 order by o.nomeUnidade")
					.setParameter(1, redeHotel.getIdRedeHotel())
					.getResultList();

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<NfeUnidadeEJB> pesquisarNfeUnidade() throws MozartSessionException {

		try {
		
			return manager
					.createQuery(
							"select o from NfeUnidadeEJB o order by (case when o.idNfeUnidade IN (35, 37, 59) then '1' else o.descricao end), o.descricao")
					.getResultList();
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public List<ItemRedeEJB> pesquisarItemRede(ItemRedeEJB itemRede)
			throws MozartSessionException {

		try {

			return manager
					.createQuery(
							" select o from ItemRedeEJB o where o.id.idRedeHotel=?1 order by o.nomeItem ")
					.setParameter(1, itemRede.getId().getIdRedeHotel())
					.getResultList();

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());

		}
	}

	@SuppressWarnings("unchecked")
	public List<ItemRedeEJB> pesquisarItemRedeLikeNome(ItemRedeEJB itemRede,
			String nomeItem) throws MozartSessionException {

		try {

			return manager
					.createQuery(
							" select o from ItemRedeEJB o where o.id.idRedeHotel=?1 and o.nomeItem like ?2 order by o.nomeItem ")
					.setParameter(1, itemRede.getId().getIdRedeHotel())
					.setParameter(2, nomeItem.toUpperCase()).getResultList();

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());

		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoItemEJB> pesquisarTipoItemLikeNome(TipoItemEJB tipoItem,
			String nomeTipo) throws MozartSessionException {

		try {

			return manager.createNamedQuery("TipoItemEJB.findLikeNomeByRede")
					.setParameter(1, tipoItem.getIdRedeHotel())
					.setParameter(2, nomeTipo.toUpperCase()).getResultList();

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());

		}
	}
}
