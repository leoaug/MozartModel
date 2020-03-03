package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mozart.model.ejb.entity.AliquotaEJB;
import com.mozart.model.ejb.entity.FichaTecnicaPratoEJB;
import com.mozart.model.ejb.entity.FichaTecnicaPratoEJBPK;
import com.mozart.model.ejb.entity.FiscalCodigoEJB;
import com.mozart.model.ejb.entity.FiscalIncidenciaEJB;
import com.mozart.model.ejb.entity.GrupoPratoEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoCiEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.UsuarioCiRedeEJB;
import com.mozart.model.ejb.entity.UsuarioConsumoInternoEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.AjustePdvVO;
import com.mozart.model.vo.ConsumoInternoVO;
import com.mozart.model.vo.ConsumoInternoVO.TypeOfConsumoInterno;
import com.mozart.model.vo.FiscalCodigoVO;
import com.mozart.model.vo.ItemEstoqueVO;
import com.mozart.model.vo.ItemEstoqueVO.TypeOfItemEstoque;
import com.mozart.model.vo.PratoConsumoInternoVO;
import com.mozart.model.vo.PratoConsumoInternoVO.TypeOfPratoConsumoInterno;
import com.mozart.model.vo.PratoVO;
import com.mozart.model.vo.TransferenciaCentroCustoVO;
import com.mozart.model.vo.UsuarioConsumoInternoVO;

@Stateless(name = "CustoSession")
public class CustoSessionBean implements CustoSession {

	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@SuppressWarnings("rawtypes")
	public List<PratoVO> pesquisarPrato(PratoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_PRATO;

			sql = String.format(sql, (Object[]) new String[] {
				" instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||id_hotel||';') >= 1 ",
				" instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||id_hotel||';') >= 1 ",
				" instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||p.id_hotel||';') >= 1 ", });
			
			if (!MozartUtil.isNull(filtro.getFiltroProduto().getTipoIntervalo())) {
				sql += " AND P.NOME_PRATO " + filtro.getFiltroProduto();
			}
			
			if (!MozartUtil.isNull(filtro.getFiltroGrupo().getTipoIntervalo())) {
				sql += " AND GP.NOME_GRUPO_PRATO " + filtro.getFiltroGrupo();
			}

			sql += " GROUP BY P.ID_PRATO, P.NOME_PRATO, TI.NOME_TIPO, GP.NOME_GRUPO_PRATO, P.VALOR_PRATO ORDER BY P.NOME_PRATO, TI.NOME_TIPO ";

			List lista = manager.createNativeQuery(sql).getResultList();

			List<PratoVO> resultado = new ArrayList<PratoVO>();
			for (Object l : lista) {
				resultado.add(new PratoVO((Object[]) l));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<GrupoPratoEJB> obterGrupoPrato(HotelEJB hotel)
			throws MozartSessionException {
		return (List<GrupoPratoEJB>) manager
				.createNamedQuery("GrupoPratoEJB.findByHotel")
				.setParameter(1, hotel.getIdHotel()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TipoItemEJB> obterTipoItem(HotelEJB hotel)
			throws MozartSessionException {
		return (List<TipoItemEJB>) manager
				.createNamedQuery("TipoItemEJB.findByRede")
				.setParameter(1, hotel.getRedeHotelEJB().getIdRedeHotel())
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoItemEJB> obterTipoItemLikeNome(HotelEJB hotel, String nomeTipoItem)throws MozartSessionException {
		return (List<TipoItemEJB>) manager.createNamedQuery("TipoItemEJB.findLikeNomeByRede").setParameter(1, hotel.getRedeHotelEJB().getIdRedeHotel())
				.setParameter(2,nomeTipoItem).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<FiscalCodigoEJB> obterFiscalCodigoCompra(HotelEJB hotel)
			throws MozartSessionException {
		return (List<FiscalCodigoEJB>) manager.createNamedQuery(
				"FiscalCodigoEJB.obterCodigoCompra").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<FiscalCodigoEJB> obterFiscalCodigo(HotelEJB hotel)
			throws MozartSessionException {
		return (List<FiscalCodigoEJB>) manager.createNamedQuery(
				"FiscalCodigoEJB.findAll").getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	public List<FiscalCodigoVO> obterFiscalCodigos(FiscalCodigoVO filtro)
			throws MozartSessionException {
		
		String condition = " WHERE ";
		StringBuilder query = new StringBuilder(QRY_FISCAL_CODIGOS);
		
		if (!MozartUtil.isNull(
				filtro.getFiltroSubcodigoOuDescricao().getValorInicial())) {
			query.append(condition)
				.append(" (UPPER(TRIM(FC.SUB_CODIGO)) ")
				.append(filtro.getFiltroSubcodigoOuDescricao())
				.append(" OR UPPER(TRIM(FC.DESCRICAO)) ")
				.append(filtro.getFiltroSubcodigoOuDescricao())
				.append(") ");
			condition = " AND ";
		}
		
		query.append(condition)
		.append(" FC.COD_ESTADO IN (1,2,3) AND FC.FLG_PRINCIPAL = 'N' ")
		.append(" ORDER BY FC.SUB_CODIGO ");
		
		try {
			List queryResult = manager.createNativeQuery(
					query.toString()).getResultList();

			List<FiscalCodigoVO> fiscalCodigos = new ArrayList<FiscalCodigoVO>();
			for (Object fiscalCodigo : queryResult) {
				fiscalCodigos.add(new FiscalCodigoVO((Object[]) fiscalCodigo));
			}
			return fiscalCodigos;

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<FiscalIncidenciaEJB> obterFiscalIncidencias() 
			throws MozartSessionException {
		return (List<FiscalIncidenciaEJB>) manager.createNamedQuery(
				"FiscalIncidenciaEJB.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<AliquotaEJB> obterAliquota(HotelEJB hotel)
			throws MozartSessionException {
		return (List<AliquotaEJB>) manager
				.createNamedQuery("AliquotaEJB.findByHotel")
				.setParameter(1, hotel.getIdHotel())
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<AliquotaEJB> obterAliquota()
			throws MozartSessionException {
		return (List<AliquotaEJB>) manager
				.createNamedQuery("AliquotaEJB.findAll")
				.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List<ItemEstoqueVO> pesquisarItemEstoqueFichaTecnica(
			ItemEstoqueVO filtro) throws MozartSessionException {
		try {
			String sql = QRY_ITEM_ESTOQUE_FICHA_TECNICA;

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdHoteis()[0])
					.setParameter(2, filtro.getIdRedeHotel()).getResultList();

			List<ItemEstoqueVO> resultado = new ArrayList<ItemEstoqueVO>();
			for (Object l : lista) {
				resultado.add(new ItemEstoqueVO((Object[]) l,ItemEstoqueVO.TypeOfItemEstoque.FICHA_TECNICA));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public PratoEJB gravarProduto(PratoEJB entidade) throws MozartSessionException {
		if (MozartUtil.isNull(entidade.getFichaTecnicaPratoEJBList())) {
			throw new MozartValidateException(
					"O campo 'Ficha Técnica' é obrigatório.");
		}
		try {
			if (entidade.getId().getIdPrato() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
				manager.createNativeQuery(
						"delete ficha_tecnica_prato where id_prato=?1 and id_hotel = ?2 ")
						.setParameter(1, entidade.getId().getIdPrato())
						.setParameter(2, entidade.getId().getIdHotel())
						.executeUpdate();
			}

			for (FichaTecnicaPratoEJB item : entidade
					.getFichaTecnicaPratoEJBList()) {
				FichaTecnicaPratoEJBPK id = new FichaTecnicaPratoEJBPK();
				id.setIdHotel(entidade.getId().getIdHotel());
				id.setIdPrato(entidade.getId().getIdPrato());
				id.setIdItem(item.getItemEstoqueEJB().getId().getIdItem());
				item.setId(id);
				manager.persist(item);
			}

			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<TransferenciaCentroCustoVO> pesquisarTransferenciaCentroCusto(TransferenciaCentroCustoVO filtro, HotelEJB hotel)
			throws MozartSessionException {
		try {
			String sql = QRY_TRANSFERENCIA_CENTRO_CUSTO;

			if (!MozartUtil.isNull(filtro.getDataMovimento().getTipoIntervalo())) {
				sql += " AND ME.DATA_MOVIMENTO " + filtro.getDataMovimento();
			}
			if (!MozartUtil.isNull(filtro.getDescricaoCentroCusto().getTipoIntervalo())) {
				sql += " AND CCC.DESCRICAO_CENTRO_CUSTO " + filtro.getDescricaoCentroCusto();
			}
			if (!MozartUtil.isNull(filtro.getNomeItem().getTipoIntervalo())) {
				sql += " AND IR.NOME_ITEM " + filtro.getNomeItem();
			}
			if (!MozartUtil.isNull(filtro.getNumDocumento().getTipoIntervalo())) {
				sql += " AND ME.NUM_DOCUMENTO " + filtro.getNumDocumento();
			}

			sql += " ORDER BY ME.DATA_MOVIMENTO, ME.NUM_DOCUMENTO, ME.TIPO_MOVIMENTO ";

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, hotel.getIdHotel())
					.getResultList();

			List<TransferenciaCentroCustoVO> resultado = new ArrayList<TransferenciaCentroCustoVO>();
			for (Object l : lista) {
				resultado.add(new TransferenciaCentroCustoVO((Object[]) l));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<UsuarioConsumoInternoVO> pesquisarConsumoInternoUsuario(UsuarioConsumoInternoVO filtro, HotelEJB hotel)
			throws MozartSessionException {
		try {
			String sql = QRY_USUARIO_CONSUMO_INTERNO;

			if (!MozartUtil.isNull(filtro.getNomeFantasia().getTipoIntervalo())) {
				sql += " AND H.NOME_FANTASIA  " + filtro.getNomeFantasia();
			}
			if (!MozartUtil.isNull(filtro.getCentroCusto().getTipoIntervalo())) {
				sql += " AND CCC.DESCRICAO_CENTRO_CUSTO " + filtro.getCentroCusto();
			}
			if (!MozartUtil.isNull(filtro.getNome().getTipoIntervalo())) {
				sql += " AND UCI.NOME " + filtro.getNome();
			}
			if (!MozartUtil.isNull(filtro.getAtivo().getTipoIntervalo())) {
				sql += " AND UCI.ATIVO " + filtro.getAtivo();
			}

			sql += " ORDER BY UCI.NOME ";

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, hotel.getRedeHotelEJB().getIdRedeHotel())
					.getResultList();

			List<UsuarioConsumoInternoVO> resultado = new ArrayList<UsuarioConsumoInternoVO>();
			for (Object l : lista) {
				resultado.add(new UsuarioConsumoInternoVO((Object[]) l));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<ConsumoInternoVO> pesquisarConsumoInterno(ConsumoInternoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_CONSUMO_INTERNO;

			if (!MozartUtil.isNull(filtro.getHotel().getTipoIntervalo())) {
				sql += " AND H.NOME_FANTASIA " + filtro.getHotel();
			}
			if (!MozartUtil.isNull(filtro.getNome().getTipoIntervalo())) {
				sql += " AND UCI.NOME " + filtro.getNome();
			}
			if (!MozartUtil.isNull(filtro.getDataMovimento().getTipoIntervalo())) {
				sql += " AND TRUNC (MCI.DATA_MOVIMENTO) " + filtro.getDataMovimento();
			}
			if (!MozartUtil.isNull(filtro.getPontoVenda().getTipoIntervalo())) {
				sql += " AND MCI.ID_PONTO_VENDA " + filtro.getPontoVenda();
			}

			sql += " ORDER BY UCI.NOME, MCI.DATA_MOVIMENTO, H.SIGLA ";

			List lista = manager.createNativeQuery(sql)
					.getResultList();

			List<ConsumoInternoVO> resultado = new ArrayList<ConsumoInternoVO>();
			for (Object l : lista) {
				resultado.add(new ConsumoInternoVO((Object[]) l, TypeOfConsumoInterno.CONSULTA));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<ConsumoInternoVO> pesquisarComboUsuarioConsumoInterno(HotelEJB hotel)
			throws MozartSessionException {
		try {
			String sql = QRY_USUARIO_CONSUMO_COMBO;
			
			List lista = manager.createNativeQuery(sql)
					.setParameter(1, hotel.getIdHotel())
					.getResultList();

			List<ConsumoInternoVO> resultado = new ArrayList<ConsumoInternoVO>();
			for (Object l : lista) {
				resultado.add(new ConsumoInternoVO((Object[]) l, TypeOfConsumoInterno.COMBO_USUARIO));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<ConsumoInternoVO> pesquisarComboPontoVendaConsumoInterno(HotelEJB hotel)
			throws MozartSessionException {
		try {
			String sql = QRY_PONTO_VENDA_CONSUMO_COMBO;
			
			List lista = manager.createNativeQuery(sql)
					.setParameter(1, hotel.getIdHotel())
					.getResultList();

			List<ConsumoInternoVO> resultado = new ArrayList<ConsumoInternoVO>();
			for (Object l : lista) {
				resultado.add(new ConsumoInternoVO((Object[]) l, TypeOfConsumoInterno.COMBO_PONTO_VENDA));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public ConsumoInternoVO pesquisarUsuarioConsumoInternoPorId(HotelEJB hotel, long idUsuario, long idPontoVenda)
			throws MozartSessionException {
		try {
			String sql = QRY_PONTO_VENDA_CONSUMO_DETALHE;

			if(idUsuario > 0)
				sql += " AND UCI.ID_USUARIO_CONSUMO_INTERNO = " + idUsuario;
			
			if(idPontoVenda > 0)
				sql += " AND PV.ID_PONTO_VENDA = " + idPontoVenda;
			
			List lista = manager.createNativeQuery(sql)
					.setParameter(1, hotel.getIdHotel())
					.getResultList();

			ConsumoInternoVO resultado = null;
			for (Object l : lista) {
				resultado = new ConsumoInternoVO((Object[]) l, TypeOfConsumoInterno.DETALHE_PONTO_VENDA);
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<HotelEJB> obterHoteis(HotelEJB hotel)
			throws MozartSessionException {
		return (List<HotelEJB>) manager
				.createNamedQuery("HotelEJB.findByRede")
				.setParameter(1, hotel.getRedeHotelEJB().getIdRedeHotel())
				.getResultList();
	}
	
	public HotelEJB obterHotelPorId(long idHotel)
			throws MozartSessionException {
		try {
			return (HotelEJB) this.manager
					.createNativeQuery(
							"select ho.* from hotel ho where ho.ID_HOTEL = ?1",
							HotelEJB.class)
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, idHotel).getSingleResult();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarUsuarioConsumo(UsuarioConsumoInternoEJB entidade)
			throws MozartSessionException {
		try {
			if (MozartUtil.isNull(entidade.getHotelEJBList())) {
				entidade.setHotelEJBList(null);
			}
			
			List<UsuarioCiRedeEJB> usuarioList = new ArrayList();
			usuarioList = entidade.getHotelEJBList();
			entidade.setHotelEJBList(null);
			if (entidade.getId() == null) {
				entidade.setId(obterSeqUsuarioConsumoInternoNextVal());
				this.manager.persist(entidade);
			} else {
				String sql = "Delete MOVIMENTO_CI where ID_USUARIO_CONSUMO_INTERNO=?1";
				this.manager.createNativeQuery(sql)
						.setParameter(1, entidade.getId())
						.executeUpdate();
				
				this.manager.merge(entidade);
			}
			for (UsuarioCiRedeEJB linha : usuarioList) {
				this.manager.persist(linha);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<PratoConsumoInternoVO> pesquisarPratoUsuarioConsumoInterno(PratoConsumoInternoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_PRATO_CONSUMO;

			if (!MozartUtil.isNull(filtro.getFiltroNomePrato().getTipoIntervalo())) {
				sql += " AND PR.NOME_PRATO " + filtro.getFiltroNomePrato();
			}
			
			sql += " ORDER BY PR.NOME_PRATO ";
			
			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdHotel())
					.setParameter(2, filtro.getIdPontoVenda())
					.setParameter(3, filtro.getIdUsuarioConsumoInterno())
					.getResultList();
			
			List<PratoConsumoInternoVO> resultado = new ArrayList<PratoConsumoInternoVO>();
			for (Object l : lista) {
				resultado.add(new PratoConsumoInternoVO((Object[]) l, TypeOfPratoConsumoInterno.CONSULTA_PRATO));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public PratoConsumoInternoVO pesquisarPratoValorConsumoInterno(PratoConsumoInternoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_PRATO_CUSTO_VENDA;

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdPrato())
					.setParameter(2, filtro.getIdHotel())
					.getResultList();
			
			PratoConsumoInternoVO resultado = null;
			for (Object l : lista) {
				resultado = new PratoConsumoInternoVO((Object[]) l,TypeOfPratoConsumoInterno.CONSULTA_VENDA);
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<ItemEstoqueVO> pesquisarItemEstoqueConsumoInterno(PratoConsumoInternoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_MOVIMENTO_CONSUMO_INTERNO;

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getQuantidade())
					.setParameter(2, filtro.getIdPrato())
					.setParameter(3, filtro.getIdHotel())
					.getResultList();
			
			List<ItemEstoqueVO> resultado = new ArrayList<ItemEstoqueVO>();
			for (Object l : lista) {
				resultado.add(new ItemEstoqueVO((Object[]) l,TypeOfItemEstoque.CONSUMO_INTERNO));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public void salvarMovimentoCi(MovimentoCiEJB movimento) throws MozartSessionException{
		try {
			String sql = " Insert into MOVIMENTO_CI "
					+ " (ID_USUARIO_CONSUMO_INTERNO, "
					+ " ID_HOTEL, "
					+ " ID_PONTO_VENDA, "
					+ " ID_PRATO, "
					+ " DATA_MOVIMENTO, "
					+ " QTDE, "
					+ " VALOR_UNITARIO_CUSTO, "
					+ " VALOR_UNITARIO_VENDA,"
					+ " NUM_DOCUMENTO) "
					+ " Values "
					+ " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9) ";

			if (!MozartUtil.isNull(movimento)) {
				Query qryMovimentoCi = manager.createNativeQuery(sql);
				qryMovimentoCi
						.setParameter(1, movimento.getIdUsuariosConsumoInterno())
						.setParameter(2, movimento.getHotel().getIdHotel())
						.setParameter(3, movimento.getPontoVendaEJB().getIdPontoVenda())
						.setParameter(4, movimento.getPratoEJB().getId().getIdPrato())
						.setParameter(5, movimento.getDataMovimento())
						.setParameter(6, movimento.getQuantidade())
						.setParameter(7, movimento.getValorUnitarioCusto())
						.setParameter(8, movimento.getValorUnitarioVenda())
						.setParameter(9, movimento.getNumDocumento())
						.executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}
	
	public Long obterSeqMovimentoCiNextVal() throws MozartSessionException {
		try {
			String SQL = "SELECT MOZART.SEQ_MOVIMENTO_CI.NEXTVAL FROM DUAL";
			BigDecimal vec = (BigDecimal) this.manager.createNativeQuery(SQL)
					.getSingleResult();
			Long retorno = Long.valueOf(vec.longValue());
			return retorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	private Long obterSeqUsuarioConsumoInternoNextVal() throws MozartSessionException {
		try {
			String SQL = "SELECT MOZART.SEQ_USUARIOS_CONSUMO_INTERNO.NEXTVAL FROM DUAL";
			BigDecimal vec = (BigDecimal) this.manager.createNativeQuery(SQL)
					.getSingleResult();
			Long retorno = Long.valueOf(vec.longValue());
			return retorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<AjustePdvVO> pesquisarAjustePdv(AjustePdvVO filtro, HotelEJB hotel)
			throws MozartSessionException {
		try {
			String sql = QRY_AJUSTE_PDV;

			if (!MozartUtil.isNull(filtro.getCentroCusto().getTipoIntervalo())) {
				sql += " AND me.id_centro_custo " + filtro.getCentroCusto();
			}
			
			if (!MozartUtil.isNull(filtro.getDataMovimento().getTipoIntervalo())) {
				sql += " AND trunc(me.data_movimento) " + filtro.getDataMovimento();
			}
			
			if (!MozartUtil.isNull(filtro.getTipoMovimento().getTipoIntervalo())) {
				sql += " me.tipo_movimento " + filtro.getTipoMovimento();
			}
			
			if (!MozartUtil.isNull(filtro.getNomeItem().getTipoIntervalo())) {
				sql += " AND IR.NOME_ITEM " + filtro.getNomeItem();
			}

			sql += " ORDER BY me.data_movimento ";

			List lista = manager.createNativeQuery(sql).setParameter(1, hotel.getIdHotel()).getResultList();

			List<AjustePdvVO> resultado = new ArrayList<AjustePdvVO>();
			for (Object l : lista) {
				resultado.add(new AjustePdvVO((Object[]) l));
			}
			return resultado;

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
		
	}
}