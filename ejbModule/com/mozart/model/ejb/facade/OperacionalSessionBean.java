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

import com.mozart.model.delegate.ContabilidadeDelegate;
import com.mozart.model.delegate.EmpresaDelegate;
import com.mozart.model.delegate.ReservaDelegate;
import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.CamareiraEJB;
import com.mozart.model.ejb.entity.ClassificacaoContabilEJB;
import com.mozart.model.ejb.entity.ConfigFnrhEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJBPK;
import com.mozart.model.ejb.entity.GarconEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MesaEJB;
import com.mozart.model.ejb.entity.NfeImpressoraEJB;
import com.mozart.model.ejb.entity.PontoVendaEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.ejb.entity.RepresentanteRedeEJB;
import com.mozart.model.ejb.entity.RepresentanteRedeEJBPK;
import com.mozart.model.ejb.entity.TipoApartamentoEJB;
import com.mozart.model.ejb.entity.TipoApartamentoEJBPK;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.entity.TipoRefeicaoEJB;
import com.mozart.model.ejb.entity.UnidadeEstoqueEJB;
import com.mozart.model.ejb.entity.UsuarioPontoVendaEJB;
import com.mozart.model.ejb.entity.VendedorRedeEJB;
import com.mozart.model.ejb.entity.VendedorRedeEJBPK;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ApartamentoHospedeVO;
import com.mozart.model.vo.ApartamentoVO;
import com.mozart.model.vo.CamareiraVO;
import com.mozart.model.vo.GarconVO;
import com.mozart.model.vo.MesaVO;
import com.mozart.model.vo.ObjetoVO;
import com.mozart.model.vo.PontoVendaVO;
import com.mozart.model.vo.RepresentanteVO;
import com.mozart.model.vo.TipoApartamentoVO;
import com.mozart.model.vo.UsuarioVO;
import com.mozart.model.vo.VendedorVO;

@Stateless(name = "OperacionalSessionEJB")
@SuppressWarnings("unchecked")
public class OperacionalSessionBean implements OperacionalSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ApartamentoEJB> pesquisarApartamento(ApartamentoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QUERY_APARTAMENTO;
			if (!MozartUtil.isNull(filtro.getFiltroArea().getTipoIntervalo())) {
				sql = sql + " and a.area " + filtro.getFiltroArea();
			}
			if (!MozartUtil.isNull(filtro.getFiltroCaracteristica()
					.getTipoIntervalo())) {
				sql = sql + " and a.caracteristica "
						+ filtro.getFiltroCaracteristica();
			}
			if (!MozartUtil.isNull(filtro.getFiltroCofan().getTipoIntervalo())) {
				sql = sql + " and a.cofan " + filtro.getFiltroCofan();
			}
			if (!MozartUtil.isNull(filtro.getFiltroStatus().getTipoIntervalo())) {
				sql = sql + " and a.status " + filtro.getFiltroStatus();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroNumApto().getTipoIntervalo())) {
				sql = sql + " and a.num_apartamento "
						+ filtro.getFiltroNumApto();
			}
			if (!MozartUtil.isNull(filtro.getFiltroTipoApto()
					.getTipoIntervalo())) {
				sql = sql + " and t.fantasia " + filtro.getFiltroTipoApto();
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||a.id_hotel||';') >= 1 ";
			}
			sql = sql + "order by a.id_tipo_apartamento, a.num_apartamento\n";
			return this.manager.createNativeQuery(sql, ApartamentoEJB.class)
					.setHint("eclipselink.refresh", "TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CamareiraEJB> pesquisaCamareira(CamareiraEJB filtro)
			throws MozartSessionException {
		return this.manager
				.createQuery(
						"select o from CamareiraEJB o where o.idHotel = ?1 order by o.nomeCamareira")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, filtro.getIdHotel()).getResultList();
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ApartamentoEJB gravarApartamento(ApartamentoEJB apto)
			throws MozartSessionException {
		try {
			validarApartamento(apto);

			apto.setTipoApartamentoEJB((TipoApartamentoEJB) this.manager
					.createQuery(
							"select o from TipoApartamentoEJB o where o.idTipoApartamento = ?1")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1,
							apto.getTipoApartamentoEJB().getIdTipoApartamento())
					.getSingleResult());
			if (apto.getCamareira() != null) {
				apto.setCamareira((CamareiraEJB) this.manager
						.createQuery(
								"select o from CamareiraEJB o where o.idCamareira = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, apto.getCamareira().getIdCamareira())
						.getSingleResult());
			}
			if (apto.getIdApartamento() == null) {
				this.manager.persist(apto);
			} else {
				this.manager.merge(apto);
			}
			return apto;
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void validarApartamento(ApartamentoEJB apto)
			throws MozartValidateException {
		if (MozartUtil.isNull(apto)) {
			throw new MozartValidateException("Apartamento está inválido.");
		}
		if (MozartUtil.isNull(apto.getIdHotel())) {
			throw new MozartValidateException("Campo 'Hotel' é obrigatório.");
		}
		if (MozartUtil.isNull(apto.getNumApartamento())) {
			throw new MozartValidateException("Campo 'Num Apto' é obrigatório.");
		}
		List<ApartamentoEJB> listApto = this.manager
				.createQuery(
						"select o from ApartamentoEJB o where o.idHotel = ?1 and o.numApartamento = ?2")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, apto.getIdHotel())
				.setParameter(2, apto.getNumApartamento()).getResultList();
		if ((!MozartUtil.isNull(listApto))
				&& (!((ApartamentoEJB) listApto.get(0)).getIdApartamento()
						.equals(apto.getIdApartamento()))) {
			throw new MozartValidateException(
					"Campo 'Num Apto' deve ser único.");
		}
		if ((!MozartUtil.isNull(apto.getCamareira()))
				&& (MozartUtil.isNull(apto.getCamareira().getIdCamareira()))) {
			apto.setCamareira(null);
		}
	}

	public ApartamentoEJB obterApartamento(ApartamentoEJB apto)
			throws MozartSessionException {
		if (MozartUtil.isNull(apto)) {
			throw new MozartValidateException("Apartamento é inválido");
		}
		return (ApartamentoEJB) this.manager.find(ApartamentoEJB.class,
				apto.getIdApartamento());
	}

	public TipoApartamentoEJB obterTipoApartamento(TipoApartamentoEJB entidade)
			throws MozartSessionException {
		if ((MozartUtil.isNull(entidade))
				|| (MozartUtil.isNull(entidade.getIdTipoApartamento()))
				|| (MozartUtil.isNull(entidade.getIdHotel()))) {
			throw new MozartValidateException("TipoApartamento é inválido");
		}
		TipoApartamentoEJBPK id = new TipoApartamentoEJBPK();
		id.idTipoApartamento = entidade.getIdTipoApartamento();
		id.idHotel = entidade.getIdHotel();
		return (TipoApartamentoEJB) this.manager.find(TipoApartamentoEJB.class,
				entidade.getIdTipoApartamento());
	}

	public List<TipoApartamentoVO> pesquisarTipoApartamento(
			TipoApartamentoVO filtro) throws MozartSessionException {
		String sql = QUERY_TIPO_APARTAMENTO;
		if (!MozartUtil.isNull(filtro.getFiltroFantasia().getTipoIntervalo())) {
			sql = sql + " and fantasia " + filtro.getFiltroFantasia();
		}
		if (!MozartUtil.isNull(filtro.getFiltroTipoApto().getTipoIntervalo())) {
			sql = sql + " and tipo_apartamento " + filtro.getFiltroTipoApto();
		}
		if (!MozartUtil.isNull(filtro.getIdHoteis())) {
			sql = sql + " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||id_hotel||';') >= 1 ";
		}
		sql = sql + "order by tipo_apartamento\n";

		List lista = null;
		lista = this.manager.createNativeQuery(sql).getResultList();

		List<TipoApartamentoVO> resultado = new ArrayList();
		for (Object l : lista) {
			resultado.add(new TipoApartamentoVO((Object[]) l));
		}
		return resultado;
	}

	public CamareiraEJB obterCamareira(CamareiraEJB entidade)
			throws MozartSessionException {
		if ((MozartUtil.isNull(entidade))
				|| (MozartUtil.isNull(entidade.getIdCamareira()))) {
			throw new MozartValidateException("Camareira é inválido");
		}
		return (CamareiraEJB) this.manager.find(CamareiraEJB.class,
				entidade.getIdCamareira());
	}

	public List<CamareiraVO> pesquisarCamareira(CamareiraVO filtro)
			throws MozartSessionException {
		String sql = QUERY_CAMAREIRA;
		if (!MozartUtil.isNull(filtro.getFiltroNome().getTipoIntervalo())) {
			sql = sql + " and c.nome_camareira " + filtro.getFiltroNome();
		}
		if (!MozartUtil.isNull(filtro.getFiltroAtivo().getTipoIntervalo())) {
			sql = sql + " and c.ativo " + filtro.getFiltroAtivo();
		}
		if (!MozartUtil.isNull(filtro.getIdHoteis())) {
			sql = sql + " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||c.id_hotel||';') >= 1 ";
		}
		sql = sql + "order by c.nome_camareira\n";

		List lista = null;
		lista = this.manager.createNativeQuery(sql).getResultList();

		List<CamareiraVO> resultado = new ArrayList();
		for (Object l : lista) {
			resultado.add(new CamareiraVO((Object[]) l));
		}
		return resultado;
	}

	public List<GarconEJB> obterGarcon(GarconEJB filtroGarcon)
			throws MozartSessionException {
		List<GarconEJB> result = this.manager
				.createQuery(
						" select o from GarconEJB o where o.idHotel = ?1 order by o.nomeGarcon")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, filtroGarcon.getIdHotel()).getResultList();

		return result;
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterarStatusApartamentoLote(ApartamentoEJB aptoDe,
			ApartamentoEJB aptoPara, String idMarcados)
			throws MozartSessionException {
		if ((MozartUtil.isNull(idMarcados)) || (MozartUtil.isNull(aptoDe))
				|| (MozartUtil.isNull(aptoPara))
				|| (MozartUtil.isNull(aptoDe.getStatus()))
				|| (MozartUtil.isNull(aptoPara.getStatus()))) {
			throw new MozartValidateException(
					"Alteração não pode ser concluída");
		}
		this.manager
				.createNativeQuery(
						"UPDATE APARTAMENTO SET STATUS = ?1, DATA_ENTRADA = ?2, DATA_SAIDA = ?3, OBSERVACAO = ?4 WHERE ID_HOTEL = ?5 AND STATUS = ?6 AND INSTR(NVL(?7, ';'||ID_APARTAMENTO||';'), ';'||ID_APARTAMENTO||';') >= 1")
				.setParameter(1, aptoPara.getStatus())
				.setParameter(2, aptoPara.getDataEntrada())
				.setParameter(3, aptoPara.getDataSaida())
				.setParameter(4, aptoPara.getObservacao())
				.setParameter(5, aptoDe.getIdHotel())
				.setParameter(6, aptoDe.getStatus())
				.setParameter(7, idMarcados).executeUpdate();
	}

	public List<ApartamentoVO> pesquisarArea(ApartamentoVO param)
			throws MozartSessionException {
		try {
			String sql = "select distinct area from apartamento where id_hotel = ?1 order by area";
			List<Object[]> lista = this.manager.createNativeQuery(sql)
					.setParameter(1, param.getIdHoteis()[0]).getResultList();
			List<ApartamentoVO> listaApto = new ArrayList();
			for (Object obj : lista) {
				ApartamentoVO apto = new ApartamentoVO();
				apto.setBcAerea((String) obj);
				listaApto.add(apto);
			}
			return listaApto;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<GarconVO> pesquisarGarcon(GarconVO filtro)
			throws MozartSessionException {
		try {
			String sql = QUERY_GARCON;
			if (!MozartUtil.isNull(filtro.getFiltroNome().getTipoIntervalo())) {
				sql = sql + " AND NOME_GARCON " + filtro.getFiltroNome();
			}
			if (!MozartUtil.isNull(filtro.getFiltroAtivo().getTipoIntervalo())) {
				sql = sql + " AND ATIVO " + filtro.getFiltroAtivo();
			}
			sql = sql + " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||id_hotel||';') >= 1 ";

			sql = sql + " ORDER BY NOME_GARCON ";

			List lista = this.manager.createNativeQuery(sql).getResultList();

			List<GarconVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new GarconVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ObjetoVO> pesquisarObjeto(ObjetoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QUERY_OBJETO;
			if (!MozartUtil.isNull(filtro.getFiltroFantasia()
					.getTipoIntervalo())) {
				sql = sql + " and fantasia " + filtro.getFiltroFantasia();
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||id_hotel||';') >= 1 ";
			}
			sql = sql + "order by fantasia\n";

			List lista = null;
			lista = this.manager.createNativeQuery(sql).getResultList();

			List<ObjetoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new ObjetoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<TipoRefeicaoEJB> pesquisarTipoRefeicao(TipoRefeicaoEJB filtro)
			throws MozartSessionException {
		try {
			String sql = QUERY_TIPO_REFEICAO;
			List<TipoRefeicaoEJB> lista = this.manager
					.createNativeQuery(sql, TipoRefeicaoEJB.class)
					.setParameter(1, filtro.getIdRedeHotel()).getResultList();
			sql = sql + "ORDER BY DESCRICAO ";

			return lista;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<MesaVO> pesquisarMesa(MesaVO filtro)
			throws MozartSessionException {
		try {
			String sql = QUERY_MESA;
			if (!MozartUtil
					.isNull(filtro.getFiltroNumMesa().getTipoIntervalo())) {
				sql = sql + " AND NUM_MESA " + filtro.getFiltroNumMesa();
			}
			if (!MozartUtil.isNull(filtro.getFiltroPontoVenda()
					.getTipoIntervalo())) {
				sql = sql + " AND NOME_PONTO_VENDA "
						+ filtro.getFiltroPontoVenda();
			}
			sql = sql + " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||m.id_hotel||';') >= 1 ";

			sql = sql + " ORDER BY NUM_MESA ";

			List lista = this.manager.createNativeQuery(sql)

			.getResultList();

			List<MesaVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new MesaVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<MesaEJB> pesquisarMesaLivre(Long idPontoVenda, String numMesa,
			String statusMesa) throws MozartSessionException {
		try {
			String sql = QUERY_MESA_LIVRE;

			sql = sql + " AND ";

			boolean ehNumerico = MozartUtil.isNumber(numMesa);

			if (ehNumerico) {
				sql = sql + " (UPPER(TRIM(M.NUM_MESA)) LIKE UPPER('%" + numMesa
						+ "%') "
						+ " OR UPPER(TRIM(M.STATUS_MESA)) LIKE UPPER('%"
						+ statusMesa + "%')) ";
			} else {
				sql = sql + " UPPER(TRIM(M.STATUS_MESA)) LIKE UPPER('%"
						+ statusMesa + "%') ";
			}

			sql = sql + " ORDER BY M.NUM_MESA ";

			List<MesaEJB> resultado = this.manager
					.createNativeQuery(sql, MesaEJB.class)
					.setParameter(1, idPontoVenda)
					.setHint("eclipselink.refresh", "TRUE").getResultList();

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<PratoEJB> pesquisarPrato(String nomePrato, Long idHotel)
			throws MozartSessionException {
		try {
			String sql = QUERY_PRATO;

			if (!MozartUtil.isNull(nomePrato))
				sql = sql + " AND UPPER(TRIM(P.NOME_PRATO)) LIKE UPPER(?2) ";

			sql = sql + " ORDER BY p.NOME_PRATO ";

			List<PratoEJB> resultado = this.manager
					.createNativeQuery(sql, PratoEJB.class)
					.setParameter(1, idHotel)
					.setParameter(2, "%" + nomePrato + "%")
					.setHint("eclipselink.refresh", "TRUE").getResultList();

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<PontoVendaVO> pesquisarPontoVenda(PontoVendaVO filtro)
			throws MozartSessionException {
		try {
			String sql = QUERY_PONTO_VENDA;
			if (!MozartUtil.isNull(filtro.getFiltroNomePontoVenda()
					.getTipoIntervalo())) {
				sql = sql + " AND NOME_PONTO_VENDA "
						+ filtro.getFiltroNomePontoVenda();
			}
			if (!MozartUtil.isNull(filtro.getFiltroNomeProprietario()
					.getTipoIntervalo())) {
				sql = sql + " AND NOME_PROPRIETARIO "
						+ filtro.getFiltroNomeProprietario();
			}
			if (!MozartUtil.isNull(filtro.getFiltroTipoPontoVenda()
					.getTipoIntervalo())) {
				if (!MozartUtil.isNull(filtro.getFiltroTipoPontoVenda()
						.getValorInicial())) {
					filtro.getFiltroTipoPontoVenda().setValorInicial(
							filtro.getFiltroTipoPontoVenda().getValorInicial()
									.substring(0, 1));
				}
				sql = sql + " AND TIPO_PONTO_VENDA "
						+ filtro.getFiltroTipoPontoVenda();
			}
			sql = sql + " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||id_hotel||';') >= 1 ";

			sql = sql + " ORDER BY NOME_PONTO_VENDA ";

			List lista = this.manager.createNativeQuery(sql).getResultList();

			List<PontoVendaVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new PontoVendaVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ConfigFnrhEJB> pesquisarConfigFnrh(ConfigFnrhEJB param)
			throws MozartSessionException {
		try {
			String sql = "select o from ConfigFnrhEJB o where o.idHotel=?1 order by o.idConfig";
			return this.manager.createQuery(sql)
					.setParameter(1, param.getIdHotel()).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<TipoLancamentoEJB> pesquisarTipoLancamentoPDV(
			TipoLancamentoEJB valor) throws MozartSessionException {
		return

		this.manager.createNamedQuery("TipoLancamentoEJB.findByPDV")
				.setParameter(1, valor.getIdHotel()).getResultList();
	}
	
	public List<TipoLancamentoEJB> pesquisarTipoLancamentoContrato(
			TipoLancamentoEJB valor) throws MozartSessionException {
		return

		this.manager.createNamedQuery("TipoLancamentoEJB.findToContrato")
				.setParameter(1, valor.getIdHotel()).getResultList();
	}
	
	public List<TipoLancamentoEJB> pesquisarTipoLancamentoContratoPagamento(
			TipoLancamentoEJB valor) throws MozartSessionException {
		return

		this.manager.createNamedQuery("TipoLancamentoEJB.findToContratoPagamento")
				.setParameter(1, valor.getIdHotel()).getResultList();
	}

	public List<TipoLancamentoEJB> pesquisarTipoLancamentoServico(
			TipoLancamentoEJB valor) throws MozartSessionException {
		return

		this.manager
				.createNamedQuery(
						"TipoLancamentoEJB.findByTipoLancamentoServico")
				.setParameter(1, valor.getIdHotel()).getResultList();
	}

	public List<PratoEJB> pesquisarPrato(PratoEJB filtro)
			throws MozartSessionException {
		return

		this.manager.createNamedQuery("PratoEJB.findByHotel")
				.setParameter(1, filtro.getId().getIdHotel()).getResultList();
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarPontoVenda(PontoVendaEJB entidade)
			throws MozartSessionException {
		try {
			if (MozartUtil.isNull(entidade.getPratoPontoVendaEJBList())) {
				entidade.setPratoPontoVendaEJBList(null);
			}
			if ((entidade.getTipoLancamentoEJB() != null)
					&& (entidade.getTipoLancamentoEJB().getIdTipoLancamento() == null)) {
				entidade.setTipoLancamentoEJB(null);
			}
			List<UsuarioPontoVendaEJB> usuarioList = new ArrayList();
			usuarioList = entidade.getUsuarioPontoVendaEJBList();
			entidade.setUsuarioPontoVendaEJBList(null);
			if (entidade.getId().getIdPontoVenda() == null) {
				this.manager.persist(entidade);
			} else {
				String sql = "Delete Prato_Ponto_Venda where id_ponto_venda=?1";
				this.manager.createNativeQuery(sql)
						.setParameter(1, entidade.getId().getIdPontoVenda())
						.executeUpdate();

				sql = "Delete Usuario_Ponto_Venda where id_ponto_venda=?1";
				this.manager.createNativeQuery(sql)
						.setParameter(1, entidade.getId().getIdPontoVenda())
						.executeUpdate();

				this.manager.merge(entidade);
			}
			for (UsuarioPontoVendaEJB linha : usuarioList) {
				linha.setPontoVendaEJB(null);
				linha.setUsuarioEJB(null);
				linha.getId().setIdPontoVenda(
						entidade.getId().getIdPontoVenda().longValue());
				this.manager.persist(linha);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<TipoItemEJB> pesquisarTipoItem(TipoItemEJB filtro)
			throws MozartSessionException {
		try {
			String sql = "select o from TipoItemEJB o where o.idRedeHotel=?1 order by o.nomeTipo";
			return this.manager.createQuery(sql)
					.setParameter(1, filtro.getIdRedeHotel()).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<UnidadeEstoqueEJB> pesquisarUnidadeEstoque(
			UnidadeEstoqueEJB filtro) throws MozartSessionException {
		try {
			String sql = "select o from UnidadeEstoqueEJB o where o.idRedeHotel=?1 order by o.nomeUnidade";
			return this.manager.createQuery(sql)
					.setParameter(1, filtro.getIdRedeHotel()).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarPontoVenda(PontoVendaEJB entidade)
			throws MozartSessionException {
		try {
			ControlaDataEJB cd = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, new Long(entidade.getId()
							.getIdHotel()));
			entidade = (PontoVendaEJB) this.manager.find(PontoVendaEJB.class,
					entidade.getId());
			entidade.setDataPv(MozartUtil.incrementarDia(cd.getFrontOffice()));
			this.manager.merge(entidade);
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<PontoVendaEJB> obterPontoVendaEncerramento(
			HotelEJB hotelCorrente) throws MozartSessionException {
		try {
			return

			this.manager
					.createNativeQuery(
							" SELECT PV.* FROM PONTO_VENDA PV, CONTROLA_DATA CD WHERE PV.ID_HOTEL = CD.ID_HOTEL AND NVL(TRUNC(PV.DATA_PV),TRUNC(CD.FRONT_OFFICE)) <= TRUNC(CD.FRONT_OFFICE)  AND PV.ID_HOTEL = ?1 ORDER BY NOME_PONTO_VENDA",
							PontoVendaEJB.class)
					.setParameter(1, hotelCorrente.getIdHotel())
					.getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public BigDecimal obterQuantidadeMovimentosAbertos(
			HotelEJB hotelCorrente) throws MozartSessionException {
		try {
			
			BigDecimal value = (BigDecimal) this.manager
					.createNativeQuery("select count(*) from movimento_restaurante where id_hotel = ?1 and num_nota is null")
					.setParameter(1, hotelCorrente.getIdHotel())
					.getSingleResult();
			
			return value;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarTipoLancamento(TipoLancamentoEJB entidade)
			throws MozartSessionException {
		try {
			if (entidade == null) {
				throw new MozartValidateException(
						"O campo 'Tipo lançamento' é obrigatório");
			}
			if (MozartUtil.isNull(entidade.getIdTipoLancamento())) {
				List<TipoLancamentoEJB> tipoLancamentoList = this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.grupoLancamento = ?2 and o.subGrupoLancamento = ?3 ")
						.setParameter(1, entidade.getIdHotel())
						.setParameter(2, entidade.getGrupoLancamento())
						.setParameter(3, entidade.getSubGrupoLancamento())
						.getResultList();
				if ((!MozartUtil.isNull(tipoLancamentoList))
						&& (!((TipoLancamentoEJB) tipoLancamentoList.get(0))
								.getIdTipoLancamento().equals(
										entidade.getIdTipoLancamento()))) {
					throw new MozartValidateException("O grupo '"
							+ entidade.getGrupoLancamento()
							+ "' com sub-grupo '"
							+ entidade.getSubGrupoLancamento()
							+ "' já está cadastrado.");
				}
			}
			if (!entidade.getSubGrupoLancamento().equals("000")) {
				List<TipoLancamentoEJB> tipoLancamentoPaiList = this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.subGrupoLancamento = '000' and o.grupoLancamento = ?2")
						.setParameter(1, entidade.getIdHotel())
						.setParameter(2, entidade.getGrupoLancamento())
						.getResultList();
				if (MozartUtil.isNull(tipoLancamentoPaiList)) {
					throw new MozartValidateException("O grupo '"
							+ entidade.getGrupoLancamento()
							+ "' não possui sub-grupo '000'.");
				}
				entidade.setIdTipoLancamentoPai(((TipoLancamentoEJB) tipoLancamentoPaiList
						.get(0)).getIdTipoLancamento());
			}
			if (entidade.getIdTipoApartamento() != null) {
				List<TipoLancamentoEJB> tipoLancamentoAptoList = this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.idTipoApartamento = ?2")
						.setParameter(1, entidade.getIdHotel())
						.setParameter(2, entidade.getIdTipoApartamento())
						.getResultList();
				if ((!MozartUtil.isNull(tipoLancamentoAptoList))
						&& (!((TipoLancamentoEJB) tipoLancamentoAptoList.get(0))
								.getIdTipoLancamento().equals(
										entidade.getIdTipoLancamento()))) {
					throw new MozartValidateException(
							"Este tipo de apartamento já está cadastrado para o lançamento: "
									+ tipoLancamentoAptoList.get(0));
				}
			}
			if ((!MozartUtil.isNull(entidade.getEmpresaHotelEJB()))
					&& (!MozartUtil.isNull(entidade.getEmpresaHotelEJB()
							.getEmpresaRedeEJB()))
					&& (!MozartUtil.isNull(entidade.getEmpresaHotelEJB()
							.getEmpresaRedeEJB().getEmpresaEJB()))
					&& (!MozartUtil
							.isNull(entidade.getEmpresaHotelEJB()
									.getEmpresaRedeEJB().getEmpresaEJB()
									.getIdEmpresa()))) {
				EmpresaHotelEJBPK ehpk = new EmpresaHotelEJBPK(entidade
						.getEmpresaHotelEJB().getEmpresaRedeEJB()
						.getEmpresaEJB().getIdEmpresa(), entidade.getIdHotel());
				entidade.setEmpresaHotelEJB(EmpresaDelegate.instance()
						.obterEmpresaHotelByPK(ehpk));
			} else {
				entidade.setEmpresaHotelEJB(null);
			}
			entidade.setCofins(entidade.getPis());

			ClassificacaoContabilEJB classificacao = entidade
					.getClassificacaoContabilEJB();
			if (MozartUtil.isNull(entidade.getIdTipoLancamento())) {
				this.manager.persist(entidade);
			} else {
				this.manager.merge(entidade);
			}
			classificacao.setTipoLancamentoEJB(entidade);
			classificacao.setDescricao(entidade.getGrupoLancamento()
					+ entidade.getSubGrupoLancamento());
			if (MozartUtil.isNull(classificacao.getIdClassificacaoContabil())) {
				classificacao.setIdClassificacaoContabil(ReservaDelegate
						.instance().obterNextVal());
				ContabilidadeDelegate.instance().salvarClassificacaoContabil(
						classificacao);
			} else {
				ClassificacaoContabilEJB old = (ClassificacaoContabilEJB) this.manager
						.getReference(ClassificacaoContabilEJB.class,
								classificacao.getIdClassificacaoContabil());
				old.setCentroCustoCredito(classificacao.getCentroCustoCredito());
				old.setCentroCustoDebito(classificacao.getCentroCustoDebito());
				old.setPlanoContasCredito(classificacao.getPlanoContasCredito());
				old.setPlanoContasDebito(classificacao.getPlanoContasDebito());
				old.setDescricao(classificacao.getDescricao());
				ContabilidadeDelegate.instance().alterarClassificacaoContabil(
						classificacao);
			}
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<PontoVendaVO> pesquisarPontoVendaUsuario(UsuarioVO filtro)
			throws MozartSessionException {
		try {
			String sql = (MozartUtil.isNull(filtro.getIdHotel())) ? QUERY_PONTO_VENDA_POR_USUARIO
					: QUERY_PONTO_VENDA_POR_USUARIO_HOTEL;
			sql = sql + " ORDER BY PV.NOME_PONTO_VENDA ";

			 Query query = this.manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdUsuario());
			
			if(! MozartUtil.isNull(filtro.getIdHotel())){
				query.setParameter(2, filtro.getIdHotel());
			}
					
			List lista = query.getResultList();

			List<PontoVendaVO> resultado = new ArrayList();
			for (Object l : lista) {
				PontoVendaVO obj = new PontoVendaVO();

				obj.setIdPontoVenda(((BigDecimal) ((Object[]) l)[0])
						.longValue());
				obj.setDescricao(((String) ((Object[]) l)[1]));
				resultado.add(obj);
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ApartamentoHospedeVO> pesquisarApartamentoHospede(
			ApartamentoHospedeVO paramApartamentoVO)
			throws MozartSessionException {

		String sql = QRY_HOSPEDE_APARTAMENTO;

		sql = sql + " AND (UPPER(TRIM(A.NUM_APARTAMENTO)) LIKE UPPER(?2) "
				+ " OR UPPER(TRIM(H.NOME_HOSPEDE))LIKE UPPER(?3) "
				+ " OR UPPER(TRIM(H.SOBRENOME_HOSPEDE))LIKE UPPER(?4)) ";
		
		if(!MozartUtil.isNull(paramApartamentoVO.getBcPrincipal()))
			sql = sql + " AND RL.PRINCIPAL in ?5 ";
			
		sql = sql +  " ORDER BY A.NUM_APARTAMENTO ";

		String param2=  MozartUtil.isNull(paramApartamentoVO.getNumApartamento()) ? "%" : "%" + paramApartamentoVO.getNumApartamento()+"%";
		String param3=  MozartUtil.isNull(paramApartamentoVO.getBcNomeHospede()) ? "%" : "%" + paramApartamentoVO.getBcNomeHospede()+"%";
		String param4=  MozartUtil.isNull(paramApartamentoVO.getBcSobrenomeHospede()) ? "%" : "%" + paramApartamentoVO.getBcSobrenomeHospede()+"%";
		String param5[]=  MozartUtil.isNull(paramApartamentoVO.getBcPrincipal()) ? new String[]{"S","N"} 
			: new String[]{ paramApartamentoVO.getBcPrincipal()};

		
		List lista = this.manager
				.createNativeQuery(sql)
				.setParameter(1, paramApartamentoVO.getIdHotel())
				.setParameter(2, param2 )
				.setParameter(3,param3)
				.setParameter(4, param4)
				.setParameter(5, param5)
				.getResultList();

		List<ApartamentoHospedeVO> resultado = new ArrayList();

		for (Object l : lista) {
			resultado.add(new ApartamentoHospedeVO((Object[]) l));
		}

		return resultado;
	}
	
	public List<NfeImpressoraEJB> pesquisarImpressoras() throws MozartSessionException {
		return

		this.manager.createNamedQuery("NfeImpressoraEJB.findAll").getResultList();
	}
	
	public void gravarRepresentante(RepresentanteRedeEJB representante)
			throws MozartSessionException {
		try {
			RepresentanteRedeEJBPK id = new RepresentanteRedeEJBPK();
			id.setIdRepresentante(representante.getIdRepresentante());
			id.setIdRedeHotel(representante.getIdRedeHotel());
			if (manager.find(RepresentanteRedeEJB.class, id) != null) {
				manager.merge(representante);
			} else {
				manager.persist(representante);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<RepresentanteVO> pesquisarRepresentante(RepresentanteVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_REPRESENTANTE;

			if (!MozartUtil.isNull(filtro.getCnpj().getTipoIntervalo())) {
				sql += " AND (E.CGC " + filtro.getCnpj();
				sql += " OR E.CPF " + filtro.getCnpj();
				sql += " OR E.CODIGO " + filtro.getCnpj();
				sql += " ) ";
				
			}

			if (!MozartUtil.isNull(filtro.getNomeFantasia()
					.getTipoIntervalo())) {
				sql += " AND RR.NOME_FANTASIA "
						+ filtro.getNomeFantasia();
			}

			sql += " ORDER BY RR.NOME_FANTASIA ";

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdRedeHotel()).getResultList();
			List<RepresentanteVO> resultado = new ArrayList<RepresentanteVO>();
			
			for (Object l : lista) {
				resultado.add(new RepresentanteVO((Object[]) l));
			}
			
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public void gravarVendedor(VendedorRedeEJB vendedor)
			throws MozartSessionException {
		try {
			VendedorRedeEJBPK id = new VendedorRedeEJBPK();
			id.setIdVendedor(vendedor.getIdVendedor());
			id.setIdRedeHotel(vendedor.getIdRedeHotel());
			if (manager.find(VendedorRedeEJB.class, id) != null) {
				manager.merge(vendedor);
			} else {
				manager.persist(vendedor);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VendedorVO> pesquisarVendedor(VendedorVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_VENDEDOR;

			if (!MozartUtil.isNull(filtro.getCnpj().getTipoIntervalo())) {
				sql += " AND (E.CGC " + filtro.getCnpj();
				sql += " OR E.CPF " + filtro.getCnpj();
				sql += " OR E.CODIGO " + filtro.getCnpj();
				sql += " ) ";
				
			}

			if (!MozartUtil.isNull(filtro.getNomeFantasia()
					.getTipoIntervalo())) {
				sql += " AND VR.NOME_FANTASIA "
						+ filtro.getNomeFantasia();
			}

			sql += " ORDER BY VR.NOME_FANTASIA ";

			List lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdRedeHotel()).getResultList();
			List<VendedorVO> resultado = new ArrayList<VendedorVO>();
			
			for (Object l : lista) {
				resultado.add(new VendedorVO((Object[]) l));
			}
			
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
}