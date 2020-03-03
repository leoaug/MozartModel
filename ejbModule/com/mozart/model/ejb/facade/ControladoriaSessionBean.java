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

import com.mozart.model.ejb.entity.ConfigBloqueteEJB;
import com.mozart.model.ejb.entity.ContaCorrenteEJB;
import com.mozart.model.ejb.entity.IdentificaLancamentoEJB;
import com.mozart.model.ejb.entity.TipoPensaoEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ContaCorrenteVO;
import com.mozart.model.vo.LogUsuarioVO;
import com.mozart.model.vo.TipoLancamentoVO;
import com.mozart.model.vo.ValorCafeVO;
import com.mozart.model.vo.ValorDolarVO;

@Stateless(name = "ControladoriaSession")
@SuppressWarnings("unchecked")
public class ControladoriaSessionBean implements ControladoriaSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ValorDolarVO> pesquisarValorDolar(ValorDolarVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_VALOR_DOLAR;
			if (!MozartUtil.isNull(filtro.getFiltroData().getTipoIntervalo())) {
				sql = sql + " AND DATA " + filtro.getFiltroData();
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||vd.id_hotel||';') >= 1 ";
			}
			sql = sql + " ORDER BY DATA DESC ";

			List lista = this.manager.createNativeQuery(sql).getResultList();
			List<ValorDolarVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new ValorDolarVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ValorCafeVO> pesquisarValorCafe(ValorCafeVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_VALOR_CAFE;
			if (!MozartUtil.isNull(filtro.getFiltroData().getTipoIntervalo())) {
				sql = sql + " AND DATA " + filtro.getFiltroData();
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||vc.id_hotel||';') >= 1 ";
			}
			sql = sql + " ORDER BY DATA DESC ";

			List lista = this.manager.createNativeQuery(sql).getResultList();
			List<ValorCafeVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new ValorCafeVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoPensaoEJB> pesquisarTipoPensao()
			throws MozartSessionException {
		try {
			return this.manager.createQuery(
					"select o from TipoPensaoEJB o order by o.descricao")
					.setHint("eclipselink.refresh", "TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ContaCorrenteVO> pesquisarContaCorrente(ContaCorrenteVO filtro)
			throws MozartSessionException {
		try {
			
			String sql = QRY_CONTA_CORRENTE;
			if (!MozartUtil.isNull(filtro.getFiltroContaCorrente()
					.getTipoIntervalo())) {
				sql = sql + " AND NUM_CONTA_CORRENTE "
						+ filtro.getFiltroContaCorrente();
			}
			if (!MozartUtil.isNull(filtro.getFiltroNumeroAgencia()
					.getTipoIntervalo())) {
				sql = sql + " AND NUMERO_AGENCIA "
						+ filtro.getFiltroNumeroAgencia();
			}
			if (!MozartUtil.isNull(filtro.getIdContabilPag())) {
				sql = sql + " AND ID_CONTABIL_PAG = "
						+ filtro.getIdContabilPag();
			}
			if (!MozartUtil.isNull(filtro.getIdContabilRec())) {
				sql = sql + " AND ID_CONTABIL_REC = "
						+ filtro.getIdContabilRec();
			}
			if (!MozartUtil.isNull(filtro.getCobranca())) {
				sql = sql + " AND COBRANCA = '"
						+ filtro.getCobranca()+"'";
			}
			if (!MozartUtil.isNull(filtro.getBoleto()) && "S".equals(filtro.getBoleto())) {
				sql = sql + " AND NUM_CARTEIRA IS NOT NULL ";
			}
			if (!MozartUtil.isNull(filtro.getCarteira())) {
				sql = sql + " AND CARTEIRA = '"
						+ filtro.getCarteira()+"'";
			}
			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					filtro.getIdHoteis()[0]).getResultList();

			List<ContaCorrenteVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new ContaCorrenteVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ContaCorrenteVO> obterContaCorrenteLookup(ContaCorrenteVO filtro)
			throws MozartSessionException {
		try {
			String sql = " SELECT  CC.ID_CONTA_CORRENTE, " 
					+ " UPPER (TRIM (B.NOME_FANTASIA) " 
					+ " ||' - ' "
					+ " || TRIM(CC.NUMERO_AGENCIA) "
					+ " ||' - ' " 
					+ " || TRIM(CC.NUM_CONTA_CORRENTE) "
					+ " ) CONTACORRENTE"
					+ " FROM "
					+ " CONTA_CORRENTE_X CC "
					+ " JOIN BANCO B ON (CC.ID_BANCO = B.ID_BANCO) WHERE CC.ID_HOTEL = ?1 "
					+ " AND (UPPER(TRIM(CC.NUM_CONTA_CORRENTE)) LIKE '%' " 
					+ " || ?2 " 
					+ " || '%' "
					+ " OR UPPER(TRIM(B.NOME_FANTASIA))LIKE '%' " 
					+ " || ?3 " 
					+ " ||'%' " 
					+ " OR UPPER(TRIM(CC.NUMERO_AGENCIA))LIKE '%' "
					+ " || ?4 " 
					+ " ||'%') "
					+ " ORDER BY B.NOME_FANTASIA ";
			
			List<Object[]> lista = this.manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdHoteis()[0])
					.setParameter(2, filtro.getBanco())
					.setParameter(3, filtro.getBanco())
					.setParameter(4, filtro.getBanco())
					.getResultList();
			
			List<ContaCorrenteVO> resultado = new ArrayList();
			for (Object[] l : lista) {
				ContaCorrenteVO contaCorrenteVO =new ContaCorrenteVO();
				contaCorrenteVO.setIdContaCorrente(Long.valueOf(l[0].toString()));
				contaCorrenteVO.setBanco(l[1].toString());
				resultado.add(contaCorrenteVO);
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	private String possuiContaVinculada(ContaCorrenteEJB contaCorrente, String sql) {
		String retorno = "N";
		List resultado = this.manager.createNativeQuery(sql)
				.setParameter(1, contaCorrente.getIdHotel()).getResultList();
		
		if (!MozartUtil.isNull(resultado)) {
			Object[] obj = (Object[]) resultado.get(0);
			if (!new Long(((BigDecimal) obj[0]).longValue())
					.equals(contaCorrente.getId())) {
				retorno = "S";
			}
		}
		
		return retorno;
	}
	
	// TODO: (ID/Conta Corrente) Esse método verifica se o hotel já possui conta para 
	// pagamento, cobranca, e carteira a fim de não permitir registros com informação 'S' duplicada (por hotel).
	// O método foi reescrito para melhorar DRY, porém o mecanismo continua ruim.
	// Outra melhoria de fácil implementação é obter os IDs das contas para cada caso em uma única query, 
	// para evitar as múltiplas conexões com o BD.
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public String[] obterDadosContaCorrente(ContaCorrenteEJB contaCorrente)
			throws MozartSessionException {
		final String sqlVinculadaPagamento = "SELECT NUM_CONTA_CORRENTE, PAGAMENTO FROM CONTA_CORRENTE_X WHERE ID_HOTEL = ?1 AND PAGAMENTO = 'S'";
		final String sqlVinculadaCobranca = "SELECT NUM_CONTA_CORRENTE, COBRANCA FROM CONTA_CORRENTE_X WHERE ID_HOTEL = ?1 AND COBRANCA = 'S'";
		final String sqlVinculadaCarteira = "SELECT NUM_CONTA_CORRENTE, CARTEIRA FROM CONTA_CORRENTE_X WHERE ID_HOTEL = ?1 AND CARTEIRA = 'S'";
		
		String[] result = new String[3];
		result[0] = possuiContaVinculada(contaCorrente, sqlVinculadaPagamento);
		result[1] = possuiContaVinculada(contaCorrente, sqlVinculadaCobranca);
		result[2] = possuiContaVinculada(contaCorrente, sqlVinculadaCarteira);
		return result;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<LogUsuarioVO> pesquisarLogUsuario(LogUsuarioVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_LOG_USUARIO;
			if ("RESERVA".equals(filtro.getTabela())) {
				sql = QRY_LOG_USUARIO_RESERVA;
			} else if ("CHECKIN".equals(filtro.getTabela())) {
				sql = QRY_LOG_USUARIO_CHECKIN;
			} else if ("EMPRESA".equals(filtro.getTabela())) {
				sql = QRY_LOG_USUARIO_EMPRESA;
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||log.id_hotel||';') >= 1 ";
			}
			sql = sql + " )WHERE 1 = 1 ";
			if (!MozartUtil.isNull(filtro.getFiltroData().getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DATA_SISTEMA) "
						+ filtro.getFiltroData();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroUsuario().getTipoIntervalo())) {
				sql = sql + " AND USUARIO " + filtro.getFiltroUsuario();
			}
			if (!MozartUtil.isNull(filtro.getFiltroId().getTipoIntervalo())) {
				sql = sql + " AND ID_AUDITADO " + filtro.getFiltroId();
			}
			sql = sql + " ORDER BY HORA DESC ";

			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					filtro.getTabela()).getResultList();
			List<LogUsuarioVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new LogUsuarioVO((Object[]) l, "TABELA_GERAL"));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoLancamentoVO> pesquisarTipoLancamento(
			TipoLancamentoVO filtro) throws MozartSessionException {
		try {
			String sql = QRY_TIPO_LANCAMENTO;
			String orderBy = " ORDER BY TL.GRUPO_LANCAMENTO, TL.SUB_GRUPO_LANCAMENTO ";

			sql = sql + " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||tl.id_hotel||';') >= 1 ";
			if (!MozartUtil.isNull(filtro.getFiltroDescricao()
					.getTipoIntervalo())) {
				sql = sql + " AND TL.DESCRICAO_LANCAMENTO "
						+ filtro.getFiltroDescricao();
			}
			if (!MozartUtil.isNull(filtro.getFiltroGrupo().getTipoIntervalo())) {
				sql = sql + " AND TL.GRUPO_LANCAMENTO "
						+ filtro.getFiltroGrupo();
			}
			if (!MozartUtil.isNull(filtro.getFiltroSubGrupo()
					.getTipoIntervalo())) {
				sql = sql + " AND TL.SUB_GRUPO_LANCAMENTO "
						+ filtro.getFiltroSubGrupo();
			}
			sql = sql + orderBy;

			List lista = this.manager.createNativeQuery(sql).getResultList();
			List<TipoLancamentoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new TipoLancamentoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<IdentificaLancamentoEJB> obterIdentificaLancamentoEJB(
			IdentificaLancamentoEJB filtro) throws MozartSessionException {
		return

		this.manager
				.createQuery(
						"select o from IdentificaLancamentoEJB o where o.atividade = ?1 and o.grupoSub = ?2 "
								+ (MozartUtil.isNull(filtro
										.getIdentificaLancamentoPaiEJB()) ? ""
										: new StringBuilder(
												" and o.identificaLancamentoPaiEJB.idIdentificaLancamento = ")
												.append(
														filtro
																.getIdentificaLancamentoPaiEJB()
																.getIdIdentificaLancamento())
												.toString())
								+ " order by o.idIdentificaLancamento")
				.setParameter(1, filtro.getAtividade()).setParameter(2,
						filtro.getGrupoSub()).getResultList();
	}

	public TipoLancamentoVO obterProximoSubGrupoLancamento(
			TipoLancamentoVO pFiltro) throws MozartSessionException {
		try {
			String sql = "SELECT LPAD(MAX(SUB_GRUPO_LANCAMENTO+1),3,'0') PROXIMO FROM TIPO_LANCAMENTO WHERE ID_HOTEL = ?1 AND GRUPO_LANCAMENTO = ?2";

			Object obj = this.manager.createNativeQuery(sql).setParameter(1,
					pFiltro.getIdHoteis()[0]).setParameter(2,
					pFiltro.getGrupo()).getSingleResult();
			if (obj == null) {
				pFiltro.setSubGrupo("000");
			} else {
				pFiltro.setSubGrupo((String) obj);
			}
			return pFiltro;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ConfigBloqueteEJB> obterListConfigBloquete(ConfigBloqueteEJB configBloqueteEJB)  throws MozartSessionException{
		try {

			List<ConfigBloqueteEJB> retorno;
			String sql = " SELECT o FROM ConfigBloqueteEJB o ";
			String sqlFiltro = "";
			String conector = " ";
					
			if(!MozartUtil.isNull(configBloqueteEJB.getId())){
				if(!MozartUtil.isNull(configBloqueteEJB.getId().getIdHotel())){
					sqlFiltro = sqlFiltro + conector + " o.id.idHotel = " + configBloqueteEJB.getId().getIdHotel();
					conector = " AND ";
				}
				if(!MozartUtil.isNull(configBloqueteEJB.getId().getIdBanco())){
					sqlFiltro = sqlFiltro + conector + " o.id.idBanco = " + configBloqueteEJB.getId().getIdBanco();
					conector = " AND ";
				}
				if(!MozartUtil.isNull(configBloqueteEJB.getId().getCampo())){
				
					String operacao = " = ";
					String valorCampo = configBloqueteEJB.getId().getCampo();
					
					if(configBloqueteEJB.getId().getCampo().equalsIgnoreCase("INSTRUCOES0%")){
						operacao = " LIKE ";
					}
					
					sqlFiltro = sqlFiltro + conector + " o.id.campo " + operacao + MozartUtil.getTextoEntreCaracter(valorCampo , "'");
					conector = " AND ";
				}
			}
			if(!MozartUtil.isNull(configBloqueteEJB.getDescricao())){
				sqlFiltro = sqlFiltro + conector + " o.descricao = " + MozartUtil.getTextoEntreCaracter(configBloqueteEJB.getDescricao() , "'") ;
				conector = " AND ";
			}
			if(!MozartUtil.isNull(configBloqueteEJB.getValor())){
				sqlFiltro = sqlFiltro + conector + " o.valor = " + configBloqueteEJB.getValor();
				conector = " AND ";
			}
			if(!MozartUtil.isNull(configBloqueteEJB.getIdRedeHotel())){
				sqlFiltro = sqlFiltro + conector + " o.idRedeHotel = " + configBloqueteEJB.getIdRedeHotel();			
				conector = " AND ";
			}
			
			sql = sql + " WHERE " + sqlFiltro + " ORDER BY o.id.idHotel , o.id.idBanco , o.id.campo  ";
			
			Query q = manager.createQuery(sql);
			
			retorno = q.getResultList();
			
			return retorno;
		
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarConfigBloquete(ConfigBloqueteEJB configBloqueteEJB)  throws MozartSessionException{
		try {
			String sql = " SELECT CONFIG_BLOQUETE.ID_HOTEL FROM CONFIG_BLOQUETE WHERE ID_HOTEL=?1 AND ID_BANCO=?2 AND CAMPO=?3 ";
			
			manager.createNativeQuery(" DELETE CONFIG_BLOQUETE  WHERE ID_HOTEL=?1 AND ID_BANCO=?2 AND CAMPO LIKE ?3")
			.setParameter(1, configBloqueteEJB.getId().getIdHotel())
			.setParameter(2, configBloqueteEJB.getId().getIdBanco())
			.setParameter(3, configBloqueteEJB.getId().getCampo()+"%").executeUpdate();
			
			List aux = manager.createNativeQuery(sql)
					.setParameter(1, configBloqueteEJB.getId().getIdHotel())
					.setParameter(2, configBloqueteEJB.getId().getIdBanco().toString())
					.setParameter(3, configBloqueteEJB.getId().getCampo()).getResultList();
			
			Query q;
			if(aux == null || aux.isEmpty()){
				sql = " INSERT INTO CONFIG_BLOQUETE (ID_HOTEL, ID_BANCO, CAMPO, DESCRICAO) VALUES(?1,?2,?3,?4) ";
				
				q = manager.createNativeQuery(sql)
						.setParameter(1, configBloqueteEJB.getId().getIdHotel())
						.setParameter(2, configBloqueteEJB.getId().getIdBanco())
						.setParameter(3, configBloqueteEJB.getId().getCampo())
						.setParameter(4, configBloqueteEJB.getDescricao());
			}else{
				
				sql = " UPDATE CONFIG_BLOQUETE SET DESCRICAO = ?1  WHERE ID_HOTEL=?2 AND ID_BANCO=?3 AND CAMPO=?4 ";
				q = manager.createNativeQuery(sql)
						.setParameter(1, configBloqueteEJB.getDescricao())
						.setParameter(2, configBloqueteEJB.getId().getIdHotel())
						.setParameter(3, configBloqueteEJB.getId().getIdBanco())
						.setParameter(4, configBloqueteEJB.getId().getCampo());
			}
			if( ! MozartUtil.isNull(configBloqueteEJB.getDescricao())){
				q.executeUpdate();
			}
			manager.flush();
			manager.clear();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Object find(Class classe, Object id) throws MozartSessionException {
		try {
			
			return manager.find(classe, id);
		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}
}