package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mozart.model.ejb.entity.CentroCustoContabilEJB;
import com.mozart.model.ejb.entity.ClassificacaoContabilEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoContabilEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ClassificacaoContabilCentroCustoVO;
import com.mozart.model.vo.ClassificacaoContabilFaturamentoGrupoVO;
import com.mozart.model.vo.ClassificacaoContabilFaturamentoVO;
import com.mozart.model.vo.ClassificacaoContabilPadraoVO;
import com.mozart.model.vo.DemonstrativoVO;
import com.mozart.model.vo.ImobilizadoDepreciacaoVO;
import com.mozart.model.vo.ImobilizadoDepreciacaoVO.TypeOfImobilizacaoDepreciacao;
import com.mozart.model.vo.MovimentoContabilVO;
import com.mozart.model.vo.PlanoContaVO;
import com.mozart.model.vo.PlanoContaVO.TypeOfPlanoConta;

@SuppressWarnings({"unchecked", "rawtypes"})
@Stateless(name = "ContabilidadeSession")
public class ContabilidadeSessionBean implements ContabilidadeSession {

	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<MovimentoContabilVO> pesquisarMovimentoContabil(
			MovimentoContabilVO filtro) throws MozartSessionException {
		try {
			String sql = QRY_MOVIMENTO_CONTABIL;
			String orderBy = " ORDER BY DATA_DOCUMENTO, CONTA_REDUZIDA, MOVIMENTO_CONTABIL.DEBITO_CREDITO DESC, VALOR ";

			if (!MozartUtil.isNull(filtro.getFiltroContaReduzida()
					.getTipoIntervalo())) {
				sql += " AND PLANO_CONTAS.CONTA_REDUZIDA "
						+ filtro.getFiltroContaReduzida();
			}
			if (!MozartUtil.isNull(filtro.getFiltroNomeConta()
					.getTipoIntervalo())) {
				sql += " AND PLANO_CONTAS.NOME_CONTA "
						+ filtro.getFiltroNomeConta();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataDocumento()
					.getTipoIntervalo())) {
				sql += " AND TRUNC(MOVIMENTO_CONTABIL.DATA_DOCUMENTO) "
						+ filtro.getFiltroDataDocumento();
			}
			if (!MozartUtil.isNull(filtro.getFiltroHistoricoComplementar()
					.getTipoIntervalo())) {
				sql += " AND UPPER(MOVIMENTO_CONTABIL.NUM_DOCUMENTO) "
						+ filtro.getFiltroHistoricoComplementar();
			}
			if (!MozartUtil.isNull(filtro.getFiltroValor().getTipoIntervalo())) {
				sql += " AND MOVIMENTO_CONTABIL.VALOR "
						+ filtro.getFiltroValor();
			}
			if (!MozartUtil.isNull(filtro.getFiltroSeqContabil()
					.getTipoIntervalo())) {
				sql += " AND MOVIMENTO_CONTABIL.ID_SEQ_CONTABIL "
						+ filtro.getFiltroSeqContabil();
			}
			
			sql += " AND INSTR('" + filtro.getIdHoteisSQL()
					+ "', ';'||HOTEL.ID_HOTEL||';') >= 1 ";

			sql += orderBy;

			List lista = null;
			lista = manager.createNativeQuery(sql)
					.setParameter(1, filtro.getFiltroTipoPesquisa())
					.getResultList();

			List<MovimentoContabilVO> resultado = new ArrayList<MovimentoContabilVO>();
			for (Object l : lista) {
				resultado.add(new MovimentoContabilVO((Object[]) l));
			}

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());

		}
	}

	public MovimentoContabilVO obterSaldoMovimentoContabil(HotelEJB filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_SALDO_MOVIMENTO_CONTABIL;

			Object[] linha = (Object[]) manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdHotel())
					.setParameter(2, filtro.getIdHotel()).getSingleResult();

			MovimentoContabilVO resultado = new MovimentoContabilVO();
			resultado.peencherSaldo(linha);

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());

		}
	}

	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void encerrarMovimentoContabil(MovimentoContabilEJB entidadeMov)
			throws MozartSessionException {

		try {
			if ("S".equalsIgnoreCase(entidadeMov.getExecutarLancamentoAnual())) {
				manager.createNativeQuery("{call PROC_ENCERRA_CTB_WEB(?1)}")
						.setParameter(1, entidadeMov.getIdHotel())
						.executeUpdate();
			}
			ControlaDataEJB controlaData = manager.find(ControlaDataEJB.class,
					entidadeMov.getIdHotel());
			controlaData.setContabilidade(entidadeMov.getDataDocumento());
			manager.merge(controlaData);
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void executarProcedureBalanceteRede(String idHoteis,
			Long idRedeHotel, Date data, String cnpj)
			throws MozartSessionException {
		try {
			manager.createNativeQuery(
					"{call PROC_BALANCETE_REDE_WEB(?1,?2,?3,?4)}")
					.setParameter(1, idHoteis).setParameter(2, idRedeHotel)
					.setParameter(3, data).setParameter(4, cnpj)
					.executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void executarProcedureTotLote(String idHoteis, Long idHotel,
			RedeHotelEJB redeHotelEJB, Date data, String cnpj)
			throws MozartSessionException {
		try {
			manager.createNativeQuery(
					"{call PROC_BALANCETE33_WEB(?1,?2,?3,?4,?5)}")
					.setParameter(1, idHoteis)
					.setParameter(2, redeHotelEJB.getIdRedeHotel())
					.setParameter(3, idHotel).setParameter(4, data)
					.setParameter(5, cnpj).executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<DemonstrativoVO> obterDemonstrativoPlanoContas(
			RedeHotelEJB redeHotelEJB) throws MozartSessionException {
		try {

			String sql = QRY_DEMONSTRATIVO_PLANO_CONTAS;

			List<Object[]> lista = manager.createNativeQuery(sql)
					.setParameter(1, redeHotelEJB.getIdRedeHotel())
					.getResultList();

			List<DemonstrativoVO> resultado = new ArrayList<DemonstrativoVO>();
			for (Object[] linha : lista) {
				resultado.add(new DemonstrativoVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<DemonstrativoVO> obterDemonstrativoResultado(
			RedeHotelEJB redeHotelEJB) throws MozartSessionException {
		try {

			String sql = QRY_DEMONSTRATIVO_RESULTADO;

			List<Object[]> lista = manager.createNativeQuery(sql)
					.setParameter(1, redeHotelEJB.getIdRedeHotel())
					.getResultList();

			List<DemonstrativoVO> resultado = new ArrayList<DemonstrativoVO>();
			for (Object[] linha : lista) {
				resultado.add(new DemonstrativoVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public void gravarDemonstrativos(DemonstrativoVO entidade)
			throws MozartSessionException {
		try {

			manager.createNativeQuery(
					"DELETE DEMONSTRATIVO_PLANO_CONTAS WHERE ID_REDE_HOTEL = ?1")
					.setParameter(1, entidade.getIdRedeHotel()).executeUpdate();
			manager.createNativeQuery(
					"DELETE DEMONSTRATIVO_RESULTADO WHERE ID_REDE_HOTEL = ?1")
					.setParameter(1, entidade.getIdRedeHotel()).executeUpdate();

			String sqlInsertDPL = "Insert into demonstrativo_plano_contas "
					+ "(ID_PLANO_CONTAS, ID_REDE_HOTEL) " + "Values "
					+ "(?1, ?2)";

			String sqlInsertDR = " Insert into demonstrativo_resultado "
					+ " (ID_PLANO_CONTAS, ID_REDE_HOTEL, ORDEM, DESCRICAO, TIPO) "
					+ " Values " + " (?1, ?2, ?3, ?4, ?5) ";

			if (!MozartUtil.isNull(entidade.getContas())) {
				Query qryDemoPlanoConta = manager
						.createNativeQuery(sqlInsertDPL);
				String[] contas = entidade.getContas().split("@");
				for (int x = 0; x < contas.length; x++) {
					qryDemoPlanoConta.setParameter(1, new Long(contas[x]))
							.setParameter(2, entidade.getIdRedeHotel())
							.executeUpdate();
				}
			}

			if (!MozartUtil.isNull(entidade.getDemonstrativos())) {
				Query qryDemoResultado = manager.createNativeQuery(sqlInsertDR);
				String[] demos = entidade.getDemonstrativos().split("@");
				for (int x = 0; x < demos.length; x++) {
					String item = demos[x];
					qryDemoResultado
							.setParameter(
									1,
									item.startsWith("S")
											|| item.startsWith("T") ? null
											: new Long(item))
							.setParameter(2, entidade.getIdRedeHotel())
							.setParameter(3, x + 1)
							.setParameter(
									4,
									item.startsWith("S")
											|| item.startsWith("T") ? item
											.substring(1) : null)
							.setParameter(
									5,
									item.startsWith("S")
											|| item.startsWith("T") ? item
											.substring(0, 1) : "C")
							.executeUpdate();
				}
			}

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<ClassificacaoContabilFaturamentoVO> obterComboCredito(
			RedeHotelEJB redeHotelEJB, String valor)
			throws MozartSessionException {
		try {

			String sql = QRY_CLASSIFICACAO_CONTABIL_FATURAMENTO_CREDITO;

			List<Object[]> lista = manager.createNativeQuery(sql)
					.setParameter(1, redeHotelEJB.getIdRedeHotel())
					.setParameter(2, valor.toUpperCase())
					.setParameter(3, valor.toUpperCase())
					.setParameter(4, valor.toUpperCase()).getResultList();

			List<ClassificacaoContabilFaturamentoVO> resultado = new ArrayList<ClassificacaoContabilFaturamentoVO>();
			for (Object[] linha : lista) {
				resultado.add(new ClassificacaoContabilFaturamentoVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<ClassificacaoContabilFaturamentoVO> obterComboDebito(
			RedeHotelEJB redeHotelEJB, String valor)
					throws MozartSessionException {
		return obterComboDebito(redeHotelEJB,  valor, null);
	}
	
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<ClassificacaoContabilFaturamentoVO> obterComboDebito(
			RedeHotelEJB redeHotelEJB, String valor, String ativoPassivo)
			throws MozartSessionException {
		try {

			String sql = QRY_CLASSIFICACAO_CONTABIL_FATURAMENTO_DEBITO;

			if(! MozartUtil.isNull(ativoPassivo)){
				sql = sql + " AND PC.ATIVO_PASSIVO = ?5";
				
			}
			sql = sql + " ORDER BY PC.NOME_CONTA ";
			
			Query query = manager.createNativeQuery(sql);
			query.setParameter(1, redeHotelEJB.getIdRedeHotel());
			query.setParameter(2, valor.toUpperCase());
			query.setParameter(3, valor.toUpperCase());
			query.setParameter(4, valor.toUpperCase());
			if(! MozartUtil.isNull(ativoPassivo)){
				query.setParameter(5, ativoPassivo.toUpperCase());
			}
			

			Logger log = Logger.getLogger(this.getClass());
			log.info(query.toString());

			List<Object[]> lista = query.getResultList();

			List<ClassificacaoContabilFaturamentoVO> resultado = new ArrayList<ClassificacaoContabilFaturamentoVO>();
			for (Object[] linha : lista) {
				resultado.add(new ClassificacaoContabilFaturamentoVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<ClassificacaoContabilCentroCustoVO> obterComboCentroCusto(
			RedeHotelEJB redeHotelEJB) throws MozartSessionException {
		try {

			String sql = QRY_CLASSIFICACAO_CONTABIL_CENTRO_CUSTO;

			List<Object[]> lista = manager.createNativeQuery(sql)
					.setParameter(1, redeHotelEJB.getIdRedeHotel())
					.getResultList();

			List<ClassificacaoContabilCentroCustoVO> resultado = new ArrayList<ClassificacaoContabilCentroCustoVO>();
			resultado.add(new ClassificacaoContabilCentroCustoVO("Selecione"));
			for (Object[] linha : lista) {
				resultado.add(new ClassificacaoContabilCentroCustoVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public Long obterNextVal() throws MozartSessionException {
		try {
			String SQL = "SELECT MOZART.ID.NEXTVAL FROM DUAL";
			BigDecimal vec = (BigDecimal) this.manager.createNativeQuery(SQL)
					.getSingleResult();
			Long retorno = Long.valueOf(vec.longValue());
			return retorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public void salvarClassificacaoContabilFaturamento(
			ClassificacaoContabilEJB faturamento) throws MozartSessionException {
		try {
			String sql = " Insert into classificacao_contabil "
					+ " ( ID_REDE_HOTEL, " + " ID_HOTEL, "
					+ " ID_CLASSIFICACAO_CONTABIL, "
					+ " ID_CENTRO_CUSTO_DEBITO, "
					+ " ID_CENTRO_CUSTO_CREDITO, "
					+ " ID_PLANO_CONTAS_DEBITO, "
					+ " ID_PLANO_CONTAS_CREDITO, " + " DESCRICAO, " + " PIS) "
					+ " Values " + " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9) ";

			if (!MozartUtil.isNull(faturamento)) {
				Query qryDemoPlanoConta = manager.createNativeQuery(sql);
				qryDemoPlanoConta
						.setParameter(1, faturamento.getIdRedeHotel())
						.setParameter(2, faturamento.getIdHotel())
						.setParameter(3,
								faturamento.getIdClassificacaoContabil())
						.setParameter(
								4,
								MozartUtil.isNull(faturamento
										.getCentroCustoDebito()) ? null
										: faturamento.getCentroCustoDebito()
												.getIdCentroCustoContabil())
						.setParameter(
								5,
								MozartUtil.isNull(faturamento
										.getCentroCustoCredito()) ? null
										: faturamento.getCentroCustoCredito()
												.getIdCentroCustoContabil())
						.setParameter(
								6,
								MozartUtil.isNull(faturamento
										.getPlanoContasDebito()) ? null
										: faturamento.getPlanoContasDebito()
												.getIdPlanoContas())
						.setParameter(
								7,
								MozartUtil.isNull(faturamento
										.getPlanoContasCredito()) ? null
										: faturamento.getPlanoContasCredito()
												.getIdPlanoContas())
						.setParameter(8, faturamento.getDescricao())
						.setParameter(9, faturamento.getPis()).executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}
	
	public void salvarClassificacaoContabil(
			ClassificacaoContabilEJB classificacaoContabil)
			throws MozartSessionException {
		try {
			String sql = " Insert into classificacao_contabil "
					+ " ( ID_REDE_HOTEL, "
					+ " ID_HOTEL, "
					+ " ID_CLASSIFICACAO_CONTABIL, "
					+ " ID_PLANO_CONTAS_DEBITO, "
					+ " ID_CENTRO_CUSTO_DEBITO, "
					+ " ID_PLANO_CONTAS_CREDITO, "
					+ " ID_CENTRO_CUSTO_CREDITO, "
					+ " DESCRICAO, "
					+ " PIS,"
					+ " PERCENTUAL,"
					+ " DEBITO_CREDITO,"
					+ " ID_TIPO_LANCAMENTO,"
					+ " ID_CONTA_CORRENTE,"
					+ " ID_PLANO_CONTAS_FINANCEIRO) "
					+ " Values "
					+ " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9,?10, ?11, ?12, ?13, ?14) ";

			if (!MozartUtil.isNull(classificacaoContabil)) {
				Query qryDemoPlanoConta = manager.createNativeQuery(sql);
				qryDemoPlanoConta
						.setParameter(1, classificacaoContabil.getIdRedeHotel())
						.setParameter(2, classificacaoContabil.getIdHotel())
						.setParameter(
								3,
								classificacaoContabil
										.getIdClassificacaoContabil())
						.setParameter(
								4,
								MozartUtil.isNull(classificacaoContabil
										.getPlanoContasDebito()) ? null
										: classificacaoContabil
												.getPlanoContasDebito()
												.getIdPlanoContas())
						.setParameter(
								5,
								MozartUtil.isNull(classificacaoContabil
										.getCentroCustoDebito()) ? null
										: classificacaoContabil
												.getCentroCustoDebito()
												.getIdCentroCustoContabil())
						.setParameter(
								6,
								MozartUtil.isNull(classificacaoContabil
										.getPlanoContasCredito()) ? null
										: classificacaoContabil
												.getPlanoContasCredito()
												.getIdPlanoContas())
						.setParameter(
								7,
								MozartUtil.isNull(classificacaoContabil
										.getCentroCustoCredito()) ? null
										: classificacaoContabil
												.getCentroCustoCredito()
												.getIdCentroCustoContabil())
						.setParameter(8, classificacaoContabil.getDescricao())
						.setParameter(9, classificacaoContabil.getPis())
						.setParameter(10, classificacaoContabil.getPercentual())
						.setParameter(11,
								classificacaoContabil.getDebitoCredito())
						.setParameter(
								12,
								(classificacaoContabil.getTipoLancamentoEJB() != null) ? classificacaoContabil
										.getTipoLancamentoEJB()
										.getIdTipoLancamento() : null)
						.setParameter(
								13,
								(classificacaoContabil.getContaCorrente() != null) ? 
										classificacaoContabil.getContaCorrente().getId()
										: null)
						.setParameter(
								14,
								MozartUtil.isNull(classificacaoContabil.getPlanoContasFin()) ? 
										null : 
										classificacaoContabil.getPlanoContasFin().getIdPlanoContas())
						.executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterarClassificacaoContabilFaturamento(
			ClassificacaoContabilEJB faturamento) throws MozartSessionException {
		try {
			String sql = " UPDATE MOZART.CLASSIFICACAO_CONTABIL CC"
					+ " SET CC.ID_PLANO_CONTAS_CREDITO=?1, "
					+ " CC.ID_CENTRO_CUSTO_CREDITO=?2,"
					+ " CC.ID_PLANO_CONTAS_DEBITO=?3, "
					+ " CC.ID_CENTRO_CUSTO_DEBITO=?4," + " CC.PIS=?5"
					+ " WHERE CC.ID_CLASSIFICACAO_CONTABIL=?6"
					+ " AND CC.ID_HOTEL=?7" + " AND CC.ID_REDE_HOTEL=?8"
					+ " AND CC.DESCRICAO=?9 ";

			if (!MozartUtil.isNull(faturamento)) {
				Query qryDemoPlanoConta = this.manager.createNativeQuery(sql);
				qryDemoPlanoConta
						.setParameter(
								1,
								MozartUtil.isNull(faturamento
										.getPlanoContasCredito()) ? null
										: faturamento.getPlanoContasCredito()
												.getIdPlanoContas())
						.setParameter(
								2,
								MozartUtil.isNull(faturamento
										.getCentroCustoCredito()) ? null
										: faturamento.getCentroCustoCredito()
												.getIdCentroCustoContabil())
						.setParameter(
								3,
								MozartUtil.isNull(faturamento
										.getPlanoContasDebito()) ? null
										: faturamento.getPlanoContasDebito()
												.getIdPlanoContas())
						.setParameter(
								4,
								MozartUtil.isNull(faturamento
										.getCentroCustoDebito()) ? null
										: faturamento.getCentroCustoDebito()
												.getIdCentroCustoContabil())
						.setParameter(5, faturamento.getPis())
						.setParameter(6,
								faturamento.getIdClassificacaoContabil())
						.setParameter(7, faturamento.getIdHotel())
						.setParameter(8, faturamento.getIdRedeHotel())
						.setParameter(9, faturamento.getDescricao())
						.executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}

	public List<ClassificacaoContabilFaturamentoGrupoVO> pesquisarClassificacaoContabilFaturamento(
			ClassificacaoContabilFaturamentoGrupoVO filtro)
			throws MozartSessionException {

		Query qryClassificacaoContabilFaturamento = manager
				.createNativeQuery(QRY_CLASSIFICACAO_CONTABIL_POR_ID_HOTEL_E_LIKE_DESCRICAO);

		qryClassificacaoContabilFaturamento.setParameter(1,
				filtro.getIdHoteis()[0]);
		qryClassificacaoContabilFaturamento.setParameter(2,
				filtro.getDescricao());

		List<Object[]> lista = qryClassificacaoContabilFaturamento
				.getResultList();

		ArrayList<ClassificacaoContabilFaturamentoGrupoVO> resultado = new ArrayList<ClassificacaoContabilFaturamentoGrupoVO>();

		for (Object[] linha : lista) {
			ClassificacaoContabilFaturamentoGrupoVO vo = new ClassificacaoContabilFaturamentoGrupoVO(
					linha);

			resultado.add(vo);
		}

		return resultado;
	}

	public List<ClassificacaoContabilEJB> obterClassificacaoContabilFaturamento(
			ClassificacaoContabilEJB faturamento) throws MozartSessionException {

		return (List<ClassificacaoContabilEJB>) manager
				.createNamedQuery(
						"classificacaoContabil.findByIdHotelAndLikeDescricao")
				.setParameter(1, faturamento.getIdHotel())
				.setParameter(2, faturamento.getDescricao()).getResultList();

	}

	public List<ClassificacaoContabilEJB> obterClassificacaoContabilPadrao(
			ClassificacaoContabilEJB faturamento) throws MozartSessionException {
		return null;
	}

	public List<ClassificacaoContabilPadraoVO> pesquisarClassificacaoContabilPadrao(
			ClassificacaoContabilPadraoVO padrao) throws MozartSessionException {

		String sql = QRY_CLASSIFICACAO_CONTABIL_PADRAO_POR_ID_HOTEL_E_LIKE_DESCRICAO;
		if (!MozartUtil.isNull(padrao.getFiltroDescricao().getTipoIntervalo())) {
			sql = sql + " AND DESCRICAO " + padrao.getFiltroDescricao();
		}
		Query qryClassificacaoContabilFaturamento = manager
				.createNativeQuery(sql);

		qryClassificacaoContabilFaturamento.setParameter(1,
				padrao.getDescricao());
		qryClassificacaoContabilFaturamento.setParameter(2,
				padrao.getIdHoteis()[0]);
		qryClassificacaoContabilFaturamento.setParameter(3,
				padrao.getDescricao());
		qryClassificacaoContabilFaturamento.setParameter(4,
				padrao.getIdHoteis()[0]);

		List<Object[]> lista = qryClassificacaoContabilFaturamento
				.getResultList();

		ArrayList<ClassificacaoContabilPadraoVO> resultado = new ArrayList<ClassificacaoContabilPadraoVO>();

		for (Object[] linha : lista) {
			ClassificacaoContabilPadraoVO vo = new ClassificacaoContabilPadraoVO(
					linha);

			resultado.add(vo);
		}

		return resultado;
	}

	public ClassificacaoContabilEJB obterClassificacaoContabilPorId(
			Long idClassificacaoContabil) throws MozartSessionException {

		return manager.find(ClassificacaoContabilEJB.class,
				idClassificacaoContabil);
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removerClassificacaoContabil(
			ClassificacaoContabilEJB classificacaoContabil)
			throws MozartSessionException {

		String sql = "DELETE FROM CLASSIFICACAO_CONTABIL WHERE ID_CLASSIFICACAO_CONTABIL = ?1";
		Query qry = manager.createNativeQuery(sql);
		qry.setParameter(1, classificacaoContabil.getIdClassificacaoContabil());

		qry.executeUpdate();
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterarClassificacaoContabil(
			ClassificacaoContabilEJB classificacaoContabil)
			throws MozartSessionException {
		try {
			int idx = 0;
			String sql = " UPDATE MOZART.CLASSIFICACAO_CONTABIL CC" + " SET "
					+ " CC.ID_PLANO_CONTAS_CREDITO=?"
					+ ++idx
					+ ", "
					+ " CC.ID_CENTRO_CUSTO_CREDITO=?"
					+ ++idx
					+ ", "
					+ " CC.ID_PLANO_CONTAS_DEBITO=?"
					+ ++idx
					+ ", "
					+ " CC.ID_CENTRO_CUSTO_DEBITO=?"
					+ ++idx
					+ ", "
					+ " CC.DESCRICAO=?"
					+ ++idx
					+ ", "
					+ " CC.PERCENTUAL=?"
					+ ++idx
					+ ", "
					+ " CC.DEBITO_CREDITO=?"
					+ ++idx
					+ ", "
					+ " CC.ID_TIPO_LANCAMENTO=?"
					+ ++idx
					+ ", "
					+ " CC.PIS=?"
					+ ++idx
					+ ", "
					// TODO: (ID/Conta Corrente) Verificar onde o método é usado
					+ " CC.ID_CONTA_CORRENTE=?"
					+ ++idx
					+ ", "
					+ " CC.ID_PLANO_CONTAS_FINANCEIRO=?"
					+ ++idx
					+ " "
					+ " WHERE CC.ID_CLASSIFICACAO_CONTABIL=?"
					+ ++idx
					+ " "
					+ " AND CC.ID_HOTEL=?"
					+ ++idx
					+ " "
					+ " AND CC.ID_REDE_HOTEL=?" + ++idx + " ";

			if (!MozartUtil.isNull(classificacaoContabil)) {
				Query qryDemoPlanoConta = this.manager.createNativeQuery(sql);
				idx = 0;
				qryDemoPlanoConta.setParameter(++idx,
						MozartUtil.isNull(classificacaoContabil
								.getPlanoContasCredito()) ? null
								: classificacaoContabil.getPlanoContasCredito()
										.getIdPlanoContas());
				qryDemoPlanoConta.setParameter(++idx,
						MozartUtil.isNull(classificacaoContabil
								.getCentroCustoCredito()) ? null
								: classificacaoContabil.getCentroCustoCredito()
										.getIdCentroCustoContabil());
				qryDemoPlanoConta.setParameter(++idx,
						MozartUtil.isNull(classificacaoContabil
								.getPlanoContasDebito()) ? null
								: classificacaoContabil.getPlanoContasDebito()
										.getIdPlanoContas());
				qryDemoPlanoConta.setParameter(++idx,
						MozartUtil.isNull(classificacaoContabil
								.getCentroCustoDebito()) ? null
								: classificacaoContabil.getCentroCustoDebito()
										.getIdCentroCustoContabil());
				qryDemoPlanoConta.setParameter(++idx,
						classificacaoContabil.getDescricao());
				qryDemoPlanoConta.setParameter(++idx,
						classificacaoContabil.getPercentual());
				qryDemoPlanoConta.setParameter(++idx,
						classificacaoContabil.getDebitoCredito());

				if (classificacaoContabil.getTipoLancamentoEJB() != null) {
					qryDemoPlanoConta.setParameter(++idx, classificacaoContabil
							.getTipoLancamentoEJB().getIdTipoLancamento());
				} else {
					qryDemoPlanoConta.setParameter(++idx, null);
				}

				qryDemoPlanoConta.setParameter(++idx,
						classificacaoContabil.getPis());

				if (MozartUtil.isNull(classificacaoContabil.getContaCorrente())
						|| (!MozartUtil.isNull(classificacaoContabil
								.getContaCorrente()) && (MozartUtil
								.isNull(classificacaoContabil
										.getContaCorrente().getId()) || MozartUtil
								.isNull(classificacaoContabil.getContaCorrente())))) {
					qryDemoPlanoConta.setParameter(++idx, null);
				} else if (!MozartUtil.isNull(classificacaoContabil
						.getContaCorrente())) {
					qryDemoPlanoConta.setParameter(++idx, classificacaoContabil
							.getContaCorrente().getId());
				}

				qryDemoPlanoConta.setParameter(++idx,
						MozartUtil.isNull(classificacaoContabil
								.getPlanoContasFin()) ? null
								: classificacaoContabil.getPlanoContasFin()
										.getIdPlanoContas());
				qryDemoPlanoConta.setParameter(++idx,
						classificacaoContabil.getIdClassificacaoContabil());
				qryDemoPlanoConta.setParameter(++idx,
						classificacaoContabil.getIdHotel());
				qryDemoPlanoConta.setParameter(++idx,
						classificacaoContabil.getIdRedeHotel());

				qryDemoPlanoConta.executeUpdate();
				this.manager.flush();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}

	public CentroCustoContabilEJB buscarCentroCustoContabil(
			CentroCustoContabilEJB centroCustoContabil)
			throws MozartSessionException {
		return (CentroCustoContabilEJB) manager.find(
				CentroCustoContabilEJB.class,
				centroCustoContabil.getIdCentroCustoContabil());
	}

	public Long obterMaxControleAtivoFixoMovimentoContabilPorHotel(Long pIdHotel)
			throws MozartSessionException {
		String sql ="SELECT MAX(CONTROLE_ATIVO_FIXO) FROM MOVIMENTO_CONTABIL WHERE ID_Hotel = ?1";
		
		return ((BigDecimal) manager.createNativeQuery(sql)
		.setParameter(1, pIdHotel).getSingleResult()).longValue();
		
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ImobilizadoDepreciacaoVO> pesquisarImobilizadoDepreciacao(
			ImobilizadoDepreciacaoVO filtro, HotelEJB hotel) throws MozartSessionException {
		try {
			String sql = QRY_IMOBILIZADO_DEPRECIACAO;

			if (!MozartUtil.isNull(filtro.getNumControle()
					.getTipoIntervalo())) {
				sql += " AND MC.CONTROLE_ATIVO_FIXO "
						+ filtro.getNumControle();
			}
			if (!MozartUtil.isNull(filtro.getContaContabil()
					.getTipoIntervalo())) {
				sql += " AND MC.ID_CENTRO_CUSTO "
						+ filtro.getContaContabil();
			}
			if (!MozartUtil.isNull(filtro.getDataMovimento()
					.getTipoIntervalo())) {
				sql += " AND TRUNC(MC.DATA_DOCUMENTO) "
						+ filtro.getDataMovimento();
			}
			
			List lista = null;
			lista = manager.createNativeQuery(sql)
					.setParameter(1, hotel.getIdHotel())
					.getResultList();

			List<ImobilizadoDepreciacaoVO> resultado = new ArrayList<ImobilizadoDepreciacaoVO>();
			
			for (Object l : lista) {
				resultado.add(new ImobilizadoDepreciacaoVO((Object[]) l, TypeOfImobilizacaoDepreciacao.PESQUISA));
			}

			return resultado;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public ImobilizadoDepreciacaoVO obterImobilizadoDepreciacao(
			long idMovimentoContabil, HotelEJB hotel) throws MozartSessionException {
		try {
			String sql = QRY_ALTERACAO_IMOBILIZADO_DEPRECIACAO;
			
			Object[] linha = (Object[])manager.createNativeQuery(sql)
					.setParameter(1, hotel.getIdHotel())
					.setParameter(2, idMovimentoContabil)
					.getSingleResult();

			ImobilizadoDepreciacaoVO resultado = new ImobilizadoDepreciacaoVO((Object[]) linha, TypeOfImobilizacaoDepreciacao.ALTERACAO);
			
			return resultado;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public Long verificaDepreciacaoJaLancada(long idHotel) throws MozartSessionException {
		try {
			String sql = QRY_CALCULO_JA_LANCADAS_DEPRECIACAO;
			
			BigDecimal linha = (BigDecimal)manager.createNativeQuery(sql)
					.setParameter(1, idHotel)
					.getSingleResult();

			Long resultado = linha.longValue();
			
			return resultado;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public Long verificaQuantidadePlanoConta(long idPlanoConta) throws MozartSessionException {
		try {
			String sql = QRY_QUANTIDADE_PLANO_CONTAS;
			
			BigDecimal linha = (BigDecimal)manager.createNativeQuery(sql)
					.setParameter(1, idPlanoConta)
					.getSingleResult();

			Long resultado = linha.longValue();
			
			return resultado;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	
	public List<String> obterValidacaoControleAtivoFixo(Long pIdHotel, Long pIdRedeHotel) throws MozartSessionException {

		try{
			String qry = " select fc_agrupa_dados( " +
					" 'SELECT PC.CONTA_CONTABIL|| '' - ''||ID_MOVIMENTO_CONTABIL||'' - ''|| TO_CHAR(DATA_DOCUMENTO,''DD/MM/YYYY'') " +
					" FROM MOVIMENTO_CONTABIL MC, PLANO_CONTAS PC, CONTROLA_DATA CD " +
					    " WHERE PC.ID_REDE_HOTEL = '||" + pIdRedeHotel + "||' " +
					        " AND MC.ID_PLANO_CONTAS = PC.ID_PLANO_CONTAS " +
					        " AND PC.DEPRECIACAO = ''S'' " +
					        " AND MC.TIPO_MOVIMENTO = ''M'' " +
					        " AND MC.CONTROLE_ATIVO_FIXO IS NULL " +
					        " AND MC.ID_HOTEL = " + pIdHotel + 
					        " AND CD.ID_HOTEL = MC.ID_HOTEL  " +
					        " AND MC.DATA_DOCUMENTO <= CD.CONTABILIDADE  " +
					    " order by MC.CONTROLE_ATIVO_FIXO',',') from dual ";

			List<String> result = manager.createNativeQuery(qry).getResultList();
			return result;
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void executarProcedureCalculoDepreciacao(Long idHotel)
			throws MozartSessionException {
		try {
			manager.createNativeQuery(
					"{call PROC_LANCAMENTO_DEPRE_WEB(?1)}")
					.setParameter(1, idHotel)
					.executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}
	
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<PlanoContaVO> obterComboPlanoConta(PlanoContaVO filtro)
			throws MozartSessionException {
		try {

			StringBuilder sql = new StringBuilder(QRY_COMBO_CONTABIL);

			if (!MozartUtil.isNull(
					filtro.getFiltroAjax().getTipoIntervalo())){
				sql.append(" AND ( ")
					.append(" UPPER(TRIM(PC.NOME_CONTA)) ")
					.append(filtro.getFiltroAjax())
					.append(" OR ")
					.append(" UPPER(TRIM(PC.CONTA_CONTABIL)) ")
					.append(filtro.getFiltroAjax())
					.append(" OR ")
					.append(" UPPER(TRIM(PC.CONTA_REDUZIDA)) ")
					.append(filtro.getFiltroAjax())
					.append(") ");
			}
			
			sql.append(" ORDER BY PC.NOME_CONTA, PC.CONTA_CONTABIL ");
			
			
			
			Query query = manager.createNativeQuery(sql.toString());
			query.setParameter(1, filtro.getIdRedeHotel());

			Logger log = Logger.getLogger(this.getClass());
			log.info(query.toString());

			List<Object[]> lista = query.getResultList();

			List<PlanoContaVO> resultado = new ArrayList<PlanoContaVO>();
			for (Object[] linha : lista) {
				resultado.add(new PlanoContaVO(linha, TypeOfPlanoConta.COMBO_BOX));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<String> obterComboControleAtivoFixo(Long pIdHotel) throws MozartSessionException {

		try{
			String qry = QRY_COMBO_CONTROLE_ATIVO_FIXO;

			qry = qry + " ORDER BY CONTROLE_ATIVO_FIXO ";
			
			List<String> result = manager.createNativeQuery(qry)
					.setParameter(1, pIdHotel)
					.getResultList();
			return result;
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
	}
}
