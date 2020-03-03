package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.CheckinEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ComprovanteAjusteVO;
import com.mozart.model.vo.MovimentoApartamentoVO;
import com.mozart.model.vo.StatusNotaVO;
import com.mozart.model.vo.filtro.FiltroWeb;

@Stateless(name = "AuditoriaSessionEJB")
@SuppressWarnings("unchecked")
public class AuditoriaSessionEJBBean implements AuditoriaSessionEJB {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MovimentoApartamentoVO> pesquisarMovimento(
			MovimentoApartamentoVO filtro) throws MozartSessionException {
		if ((MozartUtil.isNull(filtro.getFiltroDataLancamento()))
				|| (MozartUtil.isNull(filtro.getFiltroDataLancamento()
						.getTipoIntervalo()))) {
			throw new MozartValidateException(
					"O filtro 'Data Lançamento' é obrigatório.");
		}
		String sql = " select mov.id_movimento_apartamento, mov.num_documento, sn.num_nota, mov.data_lancamento, log.hora, log.usuario, a.num_apartamento, mov.valor_lancamento, tl.debito_credito,  mov.qtde_adultos, mov.qtde_cafe, mov.map, mov.fap, il.receita_checkout, tl.grupo_lancamento,tl.sub_grupo_lancamento, tl.descricao_lancamento, mov.quem_paga  from checkin c, apartamento a, movimento_apartamento mov, status_nota sn, tipo_lancamento tl, identifica_lancamento il,  %s  where c.id_checkin = mov.id_checkin  and mov.id_hotel = c.id_hotel  and c.id_apartamento = a.id_apartamento  and c.id_hotel = a.id_hotel  and mov.id_nota = sn.id_nota(+)  and mov.id_tipo_lancamento = tl.id_tipo_lancamento  and mov.id_hotel = tl.id_hotel  and tl.id_identifica_lancamento = il.id_identifica_lancamento  and mov.id_hotel = a.id_hotel  and mov.id_movimento_apartamento = log.id_auditado(+) ";
		String sqlLog = " (select log.id_auditado, log.hora, substr(u.nick,8) usuario   from usuario u,     (select /*+ index(log_usuario idx_log_us_htl_op_tb_dt)*/ id_auditado, id_usuario, hora    from log_usuario    where %s    and operacao = 'Inclusão'  and tabela_auditada = 'MOVIMENTO_APARTAMENTO'    %s ) log  where u.id_usuario = log.id_usuario ) log ";
		if (!MozartUtil.isNull(filtro.getFiltroDataLancamento()
				.getTipoIntervalo())) {
			List ids = new ArrayList();
			ids.addAll(Arrays.asList(filtro.getIdHoteis()));
			ids.add(new Long(0L));

			FiltroWeb dataLog = new FiltroWeb();
			dataLog.setTipo(filtro.getFiltroDataLancamento().getTipo());
			dataLog.setTipoIntervalo(filtro.getFiltroDataLancamento()
					.getTipoIntervalo());
			dataLog.setValorFinal(filtro.getFiltroDataLancamento()
					.getValorFinal());
			dataLog.setValorInicial(filtro.getFiltroDataLancamento()
					.getValorInicial());
			dataLog.setValorInicial(MozartUtil.format(MozartUtil
					.decrementarDia(MozartUtil.toTimestamp(dataLog
							.getValorInicial()), 45), "dd/MM/yyyy"));
			sqlLog = String.format(sqlLog, new Object[] {
					filtro.getIdHoteisSQLOr(ids.toArray(), ""),
					" and trunc(data) " + dataLog });

			sql = sql + " and trunc(mov.data_lancamento)  "
					+ filtro.getFiltroDataLancamento();
			sql = String.format(sql, new Object[] { sqlLog });
		}
		if (!MozartUtil.isNull(filtro.getFiltroDescricao().getTipoIntervalo())) {
			sql = sql + " and UPPER(tl.DESCRICAO_LANCAMENTO) "
					+ filtro.getFiltroDescricao();
		}
		if (!MozartUtil.isNull(filtro.getFiltroNumApto().getTipoIntervalo())) {
			sql = sql + " and a.num_apartamento " + filtro.getFiltroNumApto();
		}
		if (!MozartUtil.isNull(filtro.getFiltroQuemPaga().getTipoIntervalo())) {
			sql = sql + " and mov.quem_paga " + filtro.getFiltroQuemPaga();
		}
		if (!MozartUtil.isNull(filtro.getFiltroGrupo().getTipoIntervalo())) {
			sql = sql + " and tl.grupo_lancamento " + filtro.getFiltroGrupo();
		}
		if (!MozartUtil.isNull(filtro.getFiltroSubgrupo().getTipoIntervalo())) {
			sql = sql + " and tl.sub_grupo_lancamento "
					+ filtro.getFiltroSubgrupo();
		}
		if (!MozartUtil.isNull(filtro.getIdHoteis())) {
			sql = sql + " and instr('" + filtro.getIdHoteisSQL()
					+ "', ';'||c.id_hotel||';') >= 1 ";
		}
		sql = sql
				+ " order by tl.GRUPO_LANCAMENTO,tl.sub_GRUPO_LANCAMENTO, receita_checkout, num_apartamento ";

		List lista = this.manager.createNativeQuery(sql).getResultList();

		List<MovimentoApartamentoVO> resultado = new ArrayList();
		for (Object l : lista) {
			resultado.add(new MovimentoApartamentoVO((Object[]) l));
		}
		return resultado;
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarAuditoria(ControlaDataEJB controlaData)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_ENCERRA_AUDITORIA_WEB(?1)}").setParameter(1,
					controlaData.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarAuditoriaRestaurante(ControlaDataEJB controlaData)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_REST_ENCERRA_AUDITORIA(?1)}").setParameter(1,
							controlaData.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarAuditoriaServ(ControlaDataEJB controlaData)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_SERV_ENCERRA_AUDITORIA(?1)}").setParameter(1,
							controlaData.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List obterValidacao(Long idHotel) throws MozartSessionException {
		try {
			String qry = "SELECT FC_AGRUPA_DADOS('SELECT NUM_APARTAMENTO TOTAL FROM APARTAMENTO A, CHECKIN C, CONTROLA_DATA CD  WHERE C.ID_HOTEL = CD.ID_HOTEL AND A.ID_HOTEL=C.ID_HOTEL AND A.ID_APARTAMENTO=C.ID_APARTAMENTO AND C.CHECKOUT = ''P'' AND TRUNC(C.DATA_ENTRADA) = TRUNC(CD.FRONT_OFFICE) AND C.ID_HOTEL = "
					+ idHotel
					+ "',',') FROM DUAL "
					+ "UNION ALL "
					+ "SELECT FC_AGRUPA_DADOS('SELECT PDV.NOME_PONTO_VENDA FROM PONTO_VENDA PDV, CONTROLA_DATA CD WHERE PDV.ID_HOTEL = CD.ID_HOTEL  AND TRUNC(PDV.DATA_PV) <= TRUNC(CD.FRONT_OFFICE) AND CD.ID_HOTEL = "
					+ idHotel
					+ "',',') FROM DUAL "
					+ "UNION ALL "
					+ "SELECT COUNT(*)||'' FROM LOG_USUARIO LO, CONTROLA_DATA CD WHERE LO.TABELA_AUDITADA = 'LANCAMENTO_DIARIAS' AND TRUNC(LO.DATA) = TRUNC(CD.FRONT_OFFICE) AND LO.ID_HOTEL = CD.ID_HOTEL AND CD.ID_HOTEL = "
					+ idHotel
					+ " "
					+ "UNION ALL "
					+ "SELECT FC_AGRUPA_DADOS('select num_apartamento from checkin c, apartamento a where c.id_hotel = "
					+ idHotel
					+ " and (id_cidade_destino is null or id_cidade_procedencia is null or motivo_viagem is null or meio_transporte is null) and c.checkout = ''N'' and c.id_apartamento = a.id_apartamento and c.id_hotel = a.id_hotel and a.cofan = ''N'' order by num_apartamento',',') FROM DUAL "
					+ "UNION ALL "
					+ "SELECT FC_AGRUPA_DADOS('select num_apartamento from checkin c, apartamento a, controla_data cd where c.id_hotel = "
					+ idHotel
					+ " and cd.id_hotel = c.id_hotel and TRUNC(c.DATA_SAIDA) <= TRUNC(cd.front_office) and c.checkout = ''N'' and c.id_apartamento = a.id_apartamento and c.id_hotel = a.id_hotel and a.cofan = ''N'' order by num_apartamento',',') FROM DUAL "
					+ "UNION ALL "
					+ "select fc_agrupa_dados('SELECT H.SIGLA||''-''||PV.NOME_PONTO_VENDA FROM HOTEL H, PONTO_VENDA PV, CONTROLA_DATA CDH WHERE H.ID_HOTEL = PV.ID_HOTEL AND H.ID_HOTEL_REFERENCIA = "
					+ idHotel
					+ " AND H.ATIVO = ''S'' AND H.ID_HOTEL_REFERENCIA = CDH.ID_HOTEL AND TRUNC(PV.DATA_PV) <= TRUNC(CDH.FRONT_OFFICE)',',') from dual"
					+ " UNION ALL "
					+ " SELECT fc_agrupa_dados ( 'SELECT R.ID_RESERVA FROM RESERVA_APARTAMENTO RA JOIN CONTROLA_DATA CD ON(RA.ID_HOTEL = CD.ID_HOTEL) JOIN RESERVA R ON (R.ID_RESERVA = RA.ID_RESERVA) WHERE RA.ID_HOTEL = "
					+ idHotel
					+ "AND TRUNC(RA.DATA_ENTRADA) <=  TRUNC(CD.FRONT_OFFICE) AND TRUNC(RA.DATA_SAIDA) > TRUNC(CD.FRONT_OFFICE) AND RA.QTDE_APARTAMENTO - RA.QTDE_CHECKIN > 0 AND R.APAGADA = ''N'' AND R.BLOQUEIO = ''N'' order by R.ID_RESERVA',',') FROM DUAL "
					+ " UNION ALL "
					+ " SELECT FC_AGRUPA_DADOS ('select num_apartamento from apartamento a join controla_data cd on (a.id_hotel = cd.id_hotel) where a.id_hotel = " 
					+ idHotel
					+ " and status = ''IN'' and a.data_saida <= cd.front_office order by num_apartamento', ',') FROM DUAL "
					+ " UNION ALL "
					+ " SELECT COUNT(*)||'' from tarifa t join tarifa_apartamento ta on (T.ID_TARIFA = ta.id_tarifa) join controla_data cd on (t.id_hotel = cd.id_hotel) where t.id_hotel = "
					+ idHotel 
					+ " and t.tipo = 'B' and T.ATIVO = 'S' and T.DATA_ENTRADA > CD.FRONT_OFFICE and data_saida < CD.FRONT_OFFICE ";

			return this.manager.createNativeQuery(qry).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<StatusNotaVO> obterReaberturaConta(Long idHotel)
			throws MozartSessionException {
		try {
			List<Object[]> lista = this.manager
					.createNativeQuery(
							" select distinct sn.id_nota, c.id_checkin,  a.num_apartamento, ta.fantasia, sn.num_nota, to_char(sn.NOTA_INICIAL) notaInicial,  h.nome_hospede||' '||h.sobrenome_hospede nome_hospede, er.nome_fantasia  from status_nota sn, checkin c, empresa_rede er, controla_data cd, room_list rl, hospede h, apartamento a, tipo_apartamento ta, movimento_apartamento mov  where c.id_hotel = cd.id_hotel  and cd.id_hotel = ?1  and (c.data_saida = cd.front_office or c.checkout = 'N')  and TRUNC(sn.data) = TRUNC(cd.front_office)  and a.id_apartamento = c.id_apartamento and a.id_hotel = c.id_hotel   and a.status like decode(c.checkout,'S','L%',a.status)  and a.id_tipo_apartamento = ta.id_tipo_apartamento  and rl.id_hospede = h.id_hospede  and sn.id_checkin = c.id_checkin  and sn.status = 'OK'  and c.id_empresa = er.id_empresa  and er.id_rede_hotel = cd.id_rede_hotel  and mov.id_hotel = cd.id_hotel  and mov.id_checkin = c.id_checkin  and mov.id_nota = sn.id_nota  and mov.id_room_list = rl.id_room_list  order by num_apartamento ")
					.setParameter(1, idHotel).getResultList();
			List<StatusNotaVO> listaResult = new ArrayList();
			for (Object[] linha : lista) {
				listaResult.add(new StatusNotaVO(linha));
			}
			return listaResult;
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void reabrirConta(StatusNotaVO statusNota)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery("{call PROC_REABRE_CONTA_WEB(?1)}")
					.setParameter(1, statusNota.getIdNota()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}

	public List<ComprovanteAjusteVO> obterComprovanteAjuste(
			ComprovanteAjusteVO ajuste) throws MozartSessionException {
		try {
			List<Object[]> lista = this.manager
					.createNativeQuery(
							" SELECT ID_MOVIMENTO_APARTAMENTO, NUM_APARTAMENTO, DESCRICAO_LANCAMENTO,  NOME_FANTASIA, DATA_LANCAMENTO, HORA_LANCAMENTO, VALOR_LANCAMENTO, NUM_DOCUMENTO, NOME  FROM (SELECT MA.ID_MOVIMENTO_APARTAMENTO, AP.NUM_APARTAMENTO, TL.DESCRICAO_LANCAMENTO,  ER.NOME_FANTASIA, TRUNC(MA.DATA_LANCAMENTO) DATA_LANCAMENTO, MA.HORA_LANCAMENTO, MA.VALOR_LANCAMENTO,  MA.NUM_DOCUMENTO, U.NOME  FROM MOVIMENTO_APARTAMENTO MA  JOIN CHECKIN CK ON (MA.ID_CHECKIN = CK.ID_CHECKIN)  JOIN CONTROLA_DATA H ON (CK.ID_HOTEL = H.ID_HOTEL)  JOIN APARTAMENTO AP ON (CK.ID_APARTAMENTO = AP.ID_APARTAMENTO)  JOIN TIPO_LANCAMENTO TL ON (MA.ID_TIPO_LANCAMENTO=TL.ID_TIPO_LANCAMENTO)  JOIN IDENTIFICA_LANCAMENTO IL ON (TL.ID_IDENTIFICA_LANCAMENTO = IL.ID_IDENTIFICA_LANCAMENTO AND IL.RECEITA_CHECKOUT = 1)  JOIN LOG_USUARIO LU ON (MA.ID_MOVIMENTO_APARTAMENTO=LU.ID_AUDITADO AND LU.OPERACAO = 'Inclusão')  JOIN USUARIO U ON (LU.ID_USUARIO=U.ID_USUARIO)  JOIN EMPRESA_REDE ER ON (CK.ID_EMPRESA=ER.ID_EMPRESA AND ER.ID_REDE_HOTEL = H.ID_REDE_HOTEL)  WHERE MA.ID_HOTEL = ?1  AND TRUNC(MA.DATA_LANCAMENTO) = TRUNC(?2)  AND MA.VALOR_LANCAMENTO < 0  UNION  SELECT MA.ID_MOVIMENTO_APARTAMENTO, AP.NUM_APARTAMENTO, TL.DESCRICAO_LANCAMENTO,  ER.NOME_FANTASIA, TRUNC(MA.DATA_LANCAMENTO) DATA_LANCAMENTO, MA.HORA_LANCAMENTO, MA.VALOR_LANCAMENTO,  MA.NUM_DOCUMENTO, U.NOME  FROM MOVIMENTO_APARTAMENTO MA  JOIN CHECKIN CK ON (MA.ID_CHECKIN = CK.ID_CHECKIN)  JOIN CONTROLA_DATA H ON (CK.ID_HOTEL = H.ID_HOTEL)  JOIN APARTAMENTO AP ON (CK.ID_APARTAMENTO = AP.ID_APARTAMENTO)  JOIN TIPO_LANCAMENTO TL ON (MA.ID_TIPO_LANCAMENTO=TL.ID_TIPO_LANCAMENTO)  JOIN IDENTIFICA_LANCAMENTO IL ON (TL.ID_IDENTIFICA_LANCAMENTO = IL.ID_IDENTIFICA_LANCAMENTO AND IL.RECEITA_CHECKOUT = 2)  JOIN LOG_USUARIO LU ON (MA.ID_MOVIMENTO_APARTAMENTO=LU.ID_AUDITADO AND LU.OPERACAO = 'Inclusão')  JOIN USUARIO U ON (LU.ID_USUARIO=U.ID_USUARIO)  JOIN EMPRESA_REDE ER ON (CK.ID_EMPRESA=ER.ID_EMPRESA AND ER.ID_REDE_HOTEL = H.ID_REDE_HOTEL)  WHERE MA.ID_HOTEL = ?3  AND TRUNC(MA.DATA_LANCAMENTO) =  TRUNC(?4)  AND MA.VALOR_LANCAMENTO > 0) ORDER BY NUM_APARTAMENTO ")
					.setParameter(1, ajuste.getIdHoteis()[0]).setParameter(2,
							ajuste.getDataLancamento()).setParameter(3,
							ajuste.getIdHoteis()[0]).setParameter(4,
							ajuste.getDataLancamento()).getResultList();
			List<ComprovanteAjusteVO> listaResult = new ArrayList();
			for (Object[] linha : lista) {
				listaResult.add(new ComprovanteAjusteVO(linha));
			}
			return listaResult;
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarCheckinComplemento(HotelEJB hotel,
			List<CheckinEJB> checkinEJBList) throws MozartSessionException {
		try {
			for (CheckinEJB chk : checkinEJBList) {
				CheckinEJB old = (CheckinEJB) this.manager.getReference(
						CheckinEJB.class, chk.getIdCheckin());
				old.setMotivoViagem(chk.getMotivoViagem());
				old.setMeioTransporte(chk.getMeioTransporte());
				old.setCidadeDestino(chk.getCidadeDestino());
				old.setCidadeProcedencia(chk.getCidadeProcedencia());
				this.manager.merge(old);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public Long obterNossoNumeroMesAnterior(ControlaDataEJB cd)
			throws MozartSessionException {
		try {
			String qry = " select unique cod_nosso_numero+0 cod_nosso_numero  from room_list  where id_hotel = ?1  and cod_certificado is not null  and cod_nosso_numero is not null  and trunc(data_saida,'month') = trunc(trunc(?2,'month')-1,'month') ";

			BigDecimal result = (BigDecimal) this.manager
					.createNativeQuery(qry).setParameter(1, cd.getIdHotel())
					.setParameter(2, cd.getFrontOffice()).getSingleResult();

			return new Long(result.longValue());
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<Long> obterApartamentosInterditadosVencidos(HotelEJB hotel)
			throws MozartSessionException {
		try {
			String qry = QRY_APT_INTERDITADO;

			List<Long> lista = this.manager
					.createNativeQuery(qry)
					.setParameter(1, hotel.getIdHotel()).getResultList();
			
			List<Long> listaResult = new ArrayList<Long>();

			return lista;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
}