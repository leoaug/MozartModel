package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaTarifaEJB;
import com.mozart.model.ejb.entity.EmpresaTarifaEJBPK;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.ejb.entity.ReservaApartamentoDiariaEJB;
import com.mozart.model.ejb.entity.ReservaApartamentoEJB;
import com.mozart.model.ejb.entity.ReservaApartamentoEJBPK;
import com.mozart.model.ejb.entity.ReservaEJB;
import com.mozart.model.ejb.entity.ReservaMidiaEJB;
import com.mozart.model.ejb.entity.TarifaApartamentoEJB;
import com.mozart.model.ejb.entity.TarifaEJB;
import com.mozart.model.ejb.entity.TipoApartamentoEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ApartamentoVO;
import com.mozart.model.vo.BloqueioGestaoVO;
import com.mozart.model.vo.BloqueioVO;
import com.mozart.model.vo.DisponibilidadeAptoGestaoBloqueioVO;
import com.mozart.model.vo.DisponibilidadeGdsVO;
import com.mozart.model.vo.EmpresaGrupoLancamentoVO;
import com.mozart.model.vo.EmpresaHotelVO;
import com.mozart.model.vo.EmpresaRedeVO;
import com.mozart.model.vo.GdsCanalVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.HotelVO;
import com.mozart.model.vo.OcupDispVO;
import com.mozart.model.vo.PagamentoReservaVO;
import com.mozart.model.vo.QuantidadeAptoGestaoBloqueioVO;
import com.mozart.model.vo.ReservaApartamentoDiariaVO;
import com.mozart.model.vo.ReservaApartamentoVO;
import com.mozart.model.vo.ReservaGrupoLancamentoVO;
import com.mozart.model.vo.ReservaMapaOcupacaoVO;
import com.mozart.model.vo.ReservaVO;
import com.mozart.model.vo.RoomListVO;
import com.mozart.model.vo.TarifaApartamentoGestaoBloqueioVO;
import com.mozart.model.vo.TarifaVO;
import com.mozart.model.vo.TipoApartamentoVO;
import com.mozart.model.vo.TipoDiariaVO;

@Stateless(name = "ReservaSessionEJB")
@SuppressWarnings("unchecked")
public class ReservaSessionBean implements ReservaSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	public List<ReservaApartamentoEJB> obterReservaApartamentoSemCheckin(
			ReservaEJB reserva) throws MozartSessionException {
		if ((MozartUtil.isNull(reserva))
				|| (MozartUtil.isNull(reserva.getIdReserva()))) {
			throw new MozartSessionException("Informe a reserva");
		}
		try {
			return

			this.manager
					.createNativeQuery(
							"select ra.* from reserva_apartamento ra, controla_data cd \nwhere ra.id_reserva = ?1 \nand ra.id_hotel = cd.id_hotel and trunc(ra.data_entrada) <= trunc(cd.front_office) and ra.id_reserva_apartamento in (\nselect rl.id_reserva_apartamento \nfrom room_list rl, hospede hos\nwhere rl.id_hospede = hos.id_hospede\nand rl.id_reserva  = ?2 and rl.id_checkin is null ) order by ra.data_entrada ",
							ReservaApartamentoEJB.class)
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, reserva.getIdReserva())
					.setParameter(2, reserva.getIdReserva()).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ReservaVO> pesquisarReservas(ReservaVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_PESQUISARRESERVAS;

			String hoteis = ";";
			for (Long id : vo.getIdHoteis()) {
				hoteis = hoteis + id + ";";
			}
			SQL = SQL + " AND INSTR('" + hoteis
					+ "', ';'||RESERVA.ID_HOTEL||';') > 0\n";
			if (!MozartUtil.isNull(vo.getDataEntrada().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA_APARTAMENTO.DATA_ENTRADA) "
						+ vo.getDataEntrada();
			}
			if (!MozartUtil.isNull(vo.getBcBloqueio())) {
				SQL = SQL + " AND UPPER(RESERVA.BLOQUEIO) = '"
						+ vo.getBcBloqueio() + "'";
			}
			if (!MozartUtil.isNull(vo.getConfirmada().getTipoIntervalo())) {
				SQL = SQL + " AND RESERVA.CONFIRMA " + vo.getConfirmada();
			}
			if (!MozartUtil.isNull(vo.getFormaReserva().getTipoIntervalo())) {
				SQL = SQL + " AND UPPER(NVL(RESERVA.FORMA_RESERVA,' ')) "
						+ vo.getFormaReserva();
			}
			if (!MozartUtil.isNull(vo.getContato().getTipoIntervalo())) {
				SQL = SQL + " AND UPPER(NVL(RESERVA.CONTATO,' ')) "
						+ vo.getContato();
			}
			if (!MozartUtil.isNull(vo.getDataSaida().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA.DATA_SAIDA) "
						+ vo.getDataSaida();
			}
			if (!MozartUtil.isNull(vo.getEmpresa().getTipoIntervalo())) {
				SQL = SQL + " AND UPPER(EMPRESA_REDE.NOME_FANTASIA) "
						+ vo.getEmpresa();
			}
			if (!MozartUtil.isNull(vo.getNomeGrupo().getTipoIntervalo())) {
				SQL = SQL
						+ " AND UPPER(DECODE(RESERVA.NOME_GRUPO,NULL,' ',RESERVA.NOME_GRUPO)) "
						+ vo.getNomeGrupo();
			}
			if (!MozartUtil.isNull(vo.getSiglaHotel().getTipoIntervalo())) {
				SQL = SQL + " AND UPPER(HT.SIGLA) " + vo.getSiglaHotel();
			}
			if (!MozartUtil.isNull(vo.getNumBloqueio().getTipoIntervalo())) {
				SQL = SQL + " AND NVL(RESERVA.ID_RESERVA_BLOQUEIO,1) "
						+ vo.getNumBloqueio();
			}
			if (!MozartUtil.isNull(vo.getIdReserva().getTipoIntervalo())) {
				SQL = SQL + " AND RESERVA.ID_RESERVA " + vo.getIdReserva();
			}
			if (!MozartUtil.isNull(vo.getDataReserva().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA.DATA_RESERVA) "
						+ vo.getDataReserva();
			}
			if (!MozartUtil.isNull(vo.getApagada().getTipoIntervalo())) {
				SQL = SQL + "AND RESERVA.APAGADA " + vo.getApagada();
			}
			if (!MozartUtil.isNull(vo.getApagada().getTipoIntervalo())) {
				SQL = SQL + "AND RESERVA.APAGADA " + vo.getApagada();
			}
			if (!MozartUtil.isNull(vo.getTipoHospede().getTipoIntervalo())) {
				SQL = SQL + " AND TIPO_HOSPEDE.TIPO_HOSPEDE "
						+ vo.getTipoHospede();
			}
			if (!MozartUtil.isNull(vo.getIdCrs().getTipoIntervalo())) {
				SQL = SQL + " AND RESERVA.ID_CENTRAL_RESERVAS " + vo.getIdCrs();
			}
			if (!MozartUtil
					.isNull(vo.getPrazoCancelamento().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA.DATA_CONFIRMA_BLOQUEIO) "
						+ vo.getPrazoCancelamento();
			}
			if (!MozartUtil.isNull(vo.getReservaTravada().getTipoIntervalo())) {
				SQL = SQL + " AND NVL(RESERVA.ALTERANDO,'N') "
						+ vo.getReservaTravada();
			}
			if (!MozartUtil.isNull(vo.getApartamento().getTipoIntervalo())) {
				SQL = SQL + " AND APARTAMENTO.NUM_APARTAMENTO "
						+ vo.getApartamento();
			}
			if (!MozartUtil.isNull(vo.getEmpresagds().getTipoIntervalo())) {
				SQL = SQL + " AND ERGDS.NOME_FANTASIA " + vo.getEmpresagds();
			}
			SQL = SQL
					+ "\n GROUP BY RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO, RESERVA.ID_RESERVA_BLOQUEIO, EMPRESA_REDE.ID_EMPRESA, \nRESERVA.ID_RESERVA,RESERVA_APARTAMENTO.QTDE_CRIANCA,RESERVA_APARTAMENTO.ADICIONAL, \nRESERVA_APARTAMENTO.DATA_ENTRADA, RESERVA_APARTAMENTO.DATA_SAIDA, RESERVA.BLOQUEIO,EMPRESA_REDE.NOME_FANTASIA, \nRESERVA.CONTATO,RESERVA.FORMA_RESERVA,RESERVA.TELEFONE_CONTATO,RESERVA.CONTATO,\nRESERVA.OBSERVACAO,HT.SIGLA, RESERVA.CONFIRMA, reserva.tipo_pensao,  RESERVA.VALOR_TOTAL, \nreserva_apartamento.qtde_checkin ,RESERVA_APARTAMENTO.QTDE_PAX,RESERVA_APARTAMENTO.TARIFA, RESERVA.NOME_GRUPO,\nRESERVA_APARTAMENTO.QTDE_APARTAMENTO,TIPO_APARTAMENTO.FANTASIA,RESERVA_APARTAMENTO.ID_APARTAMENTO,RESERVA.ID_PERMUTA, RESERVA.DATA_RESERVA,\nDECODE(RESERVA.ID_USUARIO_WEB,NULL,'Não','Sim'),CENTRAL_RESERVAS.NOME_FANTASIA,RESERVA.RESERVA_JAVA,\nDECODE( greatest( RESERVA_APARTAMENTO.DATA_ENTRADA, CONTROLA_DATA.FRONT_OFFICE ), RESERVA_APARTAMENTO.DATA_ENTRADA, 'Não', 'Sim'),\nRESERVA.APAGADA,CHECKIN.CHECKOUT,\nDECODE (APARTAMENTO.NUM_APARTAMENTO,NULL,'', APARTAMENTO.NUM_APARTAMENTO || ' ' || TIPO_APARTAMENTO.FANTASIA || ' ' || APARTAMENTO.STATUS),\n(RESERVA.ID_RESERVA|| ',' || RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO), \n RESERVA.ID_GDS, \n ERGDS.NOME_FANTASIA,\n RESERVA_APARTAMENTO.TOTAL_TARIFA ";
			if (!MozartUtil.isNull(vo.getNomeHospede().getTipoIntervalo())) {
				SQL = SQL
						+ " HAVING UPPER(MIN(trim(HOSPEDE.NOME_HOSPEDE) || ' ' || trim(HOSPEDE.SOBRENOME_HOSPEDE))) "
						+ vo.getNomeHospede();
			}
			SQL = SQL + " ORDER BY DATA_ENTRADA\n";
			SQL = SQL + " )\n";

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<ReservaVO> resultado = new ArrayList<ReservaVO>();
			for (Object lis : lista) {
				ReservaVO objVO = new ReservaVO();
				objVO.setaDados((Object[]) lis);
				resultado.add(objVO);
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<BloqueioVO> pesquisarReservas(BloqueioVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_PESQUISARBLOQUEIO;

			String hoteis = ";";
			for (Long id : vo.getIdHoteis()) {
				hoteis = hoteis + id + ";";
			}
			SQL = SQL + " AND INSTR('" + hoteis
					+ "', ';'||RESERVA.ID_HOTEL||';') > 0\n";
			if (!MozartUtil.isNull(vo.getDataEntrada().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA_APARTAMENTO.DATA_ENTRADA) "
						+ vo.getDataEntrada();
			}

			SQL = SQL + " AND UPPER(RESERVA.BLOQUEIO) = 'S' ";

			if (!MozartUtil.isNull(vo.getConfirmada().getTipoIntervalo())) {
				SQL = SQL + " AND RESERVA.CONFIRMA " + vo.getConfirmada();
			}
			if (!MozartUtil.isNull(vo.getConfirmada().getTipoIntervalo())) {
				SQL = SQL + " AND UPPER(NVL(RESERVA.FORMA_RESERVA,' ')) "
						+ vo.getConfirmada();
			}
			if (!MozartUtil.isNull(vo.getContato().getTipoIntervalo())) {
				SQL = SQL + " AND UPPER(NVL(RESERVA.CONTATO,' ')) "
						+ vo.getContato();
			}
			if (!MozartUtil.isNull(vo.getDataSaida().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA.DATA_SAIDA) "
						+ vo.getDataSaida();
			}
			if (!MozartUtil.isNull(vo.getEmpresa().getTipoIntervalo())) {
				SQL = SQL + " AND UPPER(EMPRESA_REDE.NOME_FANTASIA) "
						+ vo.getEmpresa();
			}
			if (!MozartUtil.isNull(vo.getNomeGrupo().getTipoIntervalo())) {
				SQL = SQL
						+ " AND UPPER(DECODE(RESERVA.NOME_GRUPO,NULL,' ',RESERVA.NOME_GRUPO)) "
						+ vo.getNomeGrupo();
			}
			if (!MozartUtil.isNull(vo.getNumBloqueio().getTipoIntervalo())) {
				SQL = SQL + " AND NVL(RESERVA.ID_RESERVA_BLOQUEIO,1) "
						+ vo.getNumBloqueio();
			}
			if (!MozartUtil.isNull(vo.getIdReserva().getTipoIntervalo())) {
				SQL = SQL + " AND RESERVA.ID_RESERVA " + vo.getIdReserva();
			}
			if (!MozartUtil.isNull(vo.getDataReserva().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA.DATA_RESERVA) "
						+ vo.getDataReserva();
			}
			if (!MozartUtil.isNull(vo.getApagada().getTipoIntervalo())) {
				SQL = SQL + "AND RESERVA.APAGADA " + vo.getApagada();
			}
			if (!MozartUtil.isNull(vo.getApagada().getTipoIntervalo())) {
				SQL = SQL + "AND RESERVA.APAGADA " + vo.getApagada();
			}
			if (!MozartUtil
					.isNull(vo.getPrazoCancelamento().getTipoIntervalo())) {
				SQL = SQL + " AND TRUNC(RESERVA.DATA_CONFIRMA_BLOQUEIO) "
						+ vo.getPrazoCancelamento();
			}
			SQL = SQL
					+ "\n GROUP BY RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO, RESERVA.ID_RESERVA_BLOQUEIO, EMPRESA_REDE.ID_EMPRESA, \nRESERVA.ID_RESERVA,RESERVA_APARTAMENTO.QTDE_CRIANCA,RESERVA_APARTAMENTO.ADICIONAL, \nRESERVA_APARTAMENTO.DATA_ENTRADA, RESERVA_APARTAMENTO.DATA_SAIDA, RESERVA.BLOQUEIO,EMPRESA_REDE.NOME_FANTASIA, \nRESERVA.CONTATO,RESERVA.FORMA_RESERVA,RESERVA.TELEFONE_CONTATO,RESERVA.CONTATO,\nRESERVA.OBSERVACAO,HT.SIGLA, RESERVA.CONFIRMA, reserva.tipo_pensao,  RESERVA.VALOR_TOTAL, \nreserva_apartamento.qtde_checkin ,RESERVA_APARTAMENTO.QTDE_PAX,RESERVA_APARTAMENTO.TARIFA, RESERVA.NOME_GRUPO,\nRESERVA_APARTAMENTO.QTDE_APARTAMENTO,TIPO_APARTAMENTO.FANTASIA,RESERVA_APARTAMENTO.ID_APARTAMENTO,RESERVA.ID_PERMUTA, RESERVA.DATA_RESERVA,\nDECODE(RESERVA.ID_USUARIO_WEB,NULL,'Não','Sim'),CENTRAL_RESERVAS.NOME_FANTASIA,RESERVA.RESERVA_JAVA,\nDECODE( greatest( RESERVA_APARTAMENTO.DATA_ENTRADA, CONTROLA_DATA.FRONT_OFFICE ), RESERVA_APARTAMENTO.DATA_ENTRADA, 'Não', 'Sim'),\nRESERVA.APAGADA,CHECKIN.CHECKOUT,\nDECODE (APARTAMENTO.NUM_APARTAMENTO,NULL,'', APARTAMENTO.NUM_APARTAMENTO || ' ' || TIPO_APARTAMENTO.FANTASIA || ' ' || APARTAMENTO.STATUS),\n(RESERVA.ID_RESERVA|| ',' || RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO),\n"
					+ " RESERVA.ID_GDS, ERGDS.NOME_FANTASIA, RESERVA_APARTAMENTO.TOTAL_TARIFA";
			if (!MozartUtil.isNull(vo.getNomeHospede().getTipoIntervalo())) {
				SQL = SQL
						+ " HAVING UPPER(MIN(trim(HOSPEDE.NOME_HOSPEDE) || ' ' || trim(HOSPEDE.SOBRENOME_HOSPEDE))) "
						+ vo.getNomeHospede();
			}
			SQL = SQL + " ORDER BY DATA_ENTRADA\n";
			SQL = SQL + " )\n";

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<BloqueioVO> resultado = new ArrayList<BloqueioVO>();
			for (Object lis : lista) {
				BloqueioVO objVO = new BloqueioVO();
				objVO.setaDados((Object[]) lis);
				resultado.add(objVO);
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public ReservaApartamentoEJB obterReservaApartamento(
			ReservaApartamentoEJBPK pk) {
		ReservaApartamentoEJB resApto = (ReservaApartamentoEJB) this.manager
				.find(ReservaApartamentoEJB.class, pk.idReservaApartamento);
		this.manager.refresh(resApto);
		return resApto;
	}

	public EmpresaHotelVO obterEmpresaHotelPorIdEHotel(EmpresaHotelVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_EMPRESA;

			SQL = SQL + " AND EH.ID_HOTEL = " + vo.getBcIdHotel();
			SQL = SQL + " AND EH.ID_EMPRESA = " + vo.getBcIdEmpresa();

			List lista = this.manager.createNativeQuery(SQL).getResultList();
			for (Object lis : lista) {
				vo.setaDados((Object[]) lis);
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<TipoApartamentoVO> obterTipoApartamentoPorHotel(
			TipoApartamentoVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_TIPO_APARTAMENTO;
			SQL = SQL + "    WHERE ID_HOTEL = " + vo.getBcIdHotel();
			SQL = SQL + "    ORDER BY FANTASIA";

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<TipoApartamentoVO> resultado = new ArrayList();
			for (Object lis : lista) {
				TipoApartamentoVO objVO = new TipoApartamentoVO();
				objVO.setaDados((Object[]) lis);
				resultado.add(objVO);
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public TipoApartamentoVO obterTipoApartamentoPorId(TipoApartamentoVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_TIPO_APARTAMENTO_POR_ID;
			SQL = SQL + "    WHERE ID_TIPO_APARTAMENTO = "
					+ vo.getBcIdTipoApartamento();

			List lista = this.manager.createNativeQuery(SQL).getResultList();
			for (Object lis : lista) {
				vo = new TipoApartamentoVO();
				vo.setaDados((Object[]) lis);
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public TipoApartamentoVO obterTipoApartamentoPorCodigoEOuIdHotel(
			String codigo, Long idHotel) throws MozartSessionException {
		try {
			TipoApartamentoVO vo = new TipoApartamentoVO();
			vo.setBcFantasia(codigo);
			String SQL = QUERY_OBTER_TIPO_APARTAMENTO_POR_ID;
			SQL = SQL + "    WHERE FANTASIA = '" + codigo + "'";

			if (idHotel != null && idHotel > 0) {
				SQL = SQL + "    and ID_HOTEL = " + idHotel + "";
			}
			List lista = this.manager.createNativeQuery(SQL).getResultList();
			for (Object lis : lista) {
				vo = new TipoApartamentoVO();
				vo.setaDados((Object[]) lis);
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(
					"Erro ao tentar obter TIPO_APARTAMENTO com FANTASIA: ["
							+ codigo + "] e ID_HOTEL: [" + idHotel + "]: "
							+ ex.getMessage());
		}
	}

	public List<TipoDiariaVO> obterTipoDiariaPorHotel(TipoDiariaVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_TIPO_DIARIA;
			SQL = SQL + " WHERE HOTEL.ID_HOTEL = " + vo.getBcIdRedeHotel();

			if (!MozartUtil.isNull(vo.getBcPadrao())) {
				SQL = SQL + " AND TP.PADRAO = '" + vo.getBcPadrao() + "'";
			}

			SQL = SQL + " ORDER BY TP.PADRAO DESC";

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<TipoDiariaVO> resultado = new ArrayList();
			for (Object lis : lista) {
				TipoDiariaVO objVO = new TipoDiariaVO();
				objVO.setaDados((Object[]) lis);
				resultado.add(objVO);
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public TipoDiariaVO obterTipoDiariaPorHotelEPadrao(TipoDiariaVO vo)
			throws MozartSessionException {
		try {
			String SQL = "SELECT ID_TIPO_DIARIA FROM TIPO_DIARIA TP ";
			SQL = SQL + " WHERE TP.ID_REDE_HOTEL = " + vo.getBcIdRedeHotel();

			if (!MozartUtil.isNull(vo.getBcPadrao())) {
				SQL = SQL + " AND TP.PADRAO = '" + vo.getBcPadrao() + "'";
			}

			SQL = SQL + " ORDER BY TP.PADRAO DESC";

			List<?> lista = this.manager.createNativeQuery(SQL).getResultList();

			for (Object lis : lista) {
				TipoDiariaVO objVO = new TipoDiariaVO();
				objVO.setBcIdRedeHotel(vo.getBcIdRedeHotel());
				objVO.setBcIdTipoDiaria(((BigDecimal) lis).longValue());
				return objVO;
			}
			return null;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public TipoDiariaVO obterTipoDiariaPorId(TipoDiariaVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_TIPO_DIARIA_POR_ID;
			SQL = SQL + " WHERE TP.ID_TIPO_DIARIA = " + vo.getBcIdTipoDiaria();
			SQL = SQL + " ORDER BY TP.PADRAO DESC";

			List lista = this.manager.createNativeQuery(SQL).getResultList();
			for (Object lis : lista) {
				vo = new TipoDiariaVO();
				vo.setaDados((Object[]) lis);
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ApartamentoVO> obterApartamentoPorDisponibilidade(
			ApartamentoVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_APART_DISP;

			SQL = SQL + "\t\tAND R.ID_HOTEL = " + vo.getBcIdHotel() + "\t\n"
					+ "\t\tAND RA.ID_HOTEL = R.ID_HOTEL\n";
			if (vo.isOcupacao()) {
				SQL = SQL + " and r.checkin ='N'\n ";
			}
			SQL =

			SQL
					+ "\t\tAND R.APAGADA = 'N' \n\t\tAND ('"
					+ MozartUtil.format(vo.getBcDataEntrada(), "dd/MM/yyyy")
					+ "' BETWEEN TRUNC(RA.DATA_ENTRADA) AND TRUNC(RA.DATA_SAIDA-1)\n"
					+ "\t\tOR '"
					+ MozartUtil.format(vo.getBcDataSaida(), "dd/MM/yyyy")
					+ "' BETWEEN TRUNC(RA.DATA_ENTRADA+1) AND TRUNC(RA.DATA_SAIDA-1)\n"
					+ "                OR   (TRUNC(RA.DATA_ENTRADA+1) BETWEEN '"
					+ MozartUtil.format(vo.getBcDataEntrada(), "dd/MM/yyyy")
					+ "' AND '"
					+ MozartUtil.format(vo.getBcDataSaida(), "dd/MM/yyyy")
					+ "'\n" + "\t\t      AND TRUNC(RA.DATA_SAIDA-1) BETWEEN '"
					+ MozartUtil.format(vo.getBcDataEntrada(), "dd/MM/yyyy")
					+ "' AND '"
					+ MozartUtil.format(vo.getBcDataSaida(), "dd/MM/yyyy")
					+ "')   \n" + "\t\tAND   (TRUNC(RA.DATA_ENTRADA) BETWEEN '"
					+ MozartUtil.format(vo.getBcDataEntrada(), "dd/MM/yyyy")
					+ "' AND '"
					+ MozartUtil.format(vo.getBcDataSaida(), "dd/MM/yyyy")
					+ "'\n" + "\t\t     AND TRUNC(RA.DATA_SAIDA-1) BETWEEN '"
					+ MozartUtil.format(vo.getBcDataEntrada(), "dd/MM/yyyy")
					+ "' AND '"
					+ MozartUtil.format(vo.getBcDataSaida(), "dd/MM/yyyy")
					+ "')\n" + "                )                \n";
			if (vo.getIdReserva() != null) {
				SQL = SQL + "\t\tAND R.ID_RESERVA <> "
						+ vo.getIdReserva().toString() + "\n";
			}
			SQL =

			SQL
					+ "    ) APTO_RES , \n                (  SELECT ID_APARTAMENTO \n\t\tFROM CHECKIN \n\t\tWHERE ID_HOTEL = "
					+ vo.getBcIdHotel() + "\n";
			if (vo.getIdCheckin() != null) {
				SQL = SQL + " AND ID_CHECKIN <> "
						+ vo.getIdCheckin().toString() + "\n";
			}
			SQL =

			SQL
					+ " AND (CHECKOUT='N' or CHECKOUT='P') \n\t\tAND ('"
					+ MozartUtil.format(vo.getBcDataEntrada(), "dd/MM/yyyy")
					+ "' BETWEEN TRUNC(DATA_ENTRADA) AND TRUNC(DATA_SAIDA-1)\n"
					+ "\t\tOR '"
					+ MozartUtil.format(vo.getBcDataSaida(), "dd/MM/yyyy")
					+ "' BETWEEN TRUNC(DATA_ENTRADA) AND TRUNC(DATA_SAIDA-1))) APTO_CHK\n"
					+ "\t\t\n"
					+ "WHERE A.ID_TIPO_APARTAMENTO = TA.ID_TIPO_APARTAMENTO\n"
					+ "AND A.ID_HOTEL = TA.ID_HOTEL\n" + "AND A.ID_HOTEL = "
					+ vo.getBcIdHotel() + "\n";
			if (vo.getBcIdTipoApartamento() != null) {
				SQL = SQL + "AND A.ID_TIPO_APARTAMENTO = "
						+ vo.getBcIdTipoApartamento() + "\n";
			}
			if (vo.getBcIdApartamento() != null) {
				SQL = SQL + "AND A.ID_APARTAMENTO = " + vo.getBcIdApartamento()
						+ "\n";
			}
			SQL = SQL
					+ "AND A.STATUS <> 'IN'\nAND COFAN = 'N'\nAND A.ID_APARTAMENTO = APTO_RES.ID_APARTAMENTO(+)\nAND A.ID_APARTAMENTO  = APTO_CHK.ID_APARTAMENTO(+)\n";
			if (!vo.isOcupacao()) {
				SQL = SQL
						+ "AND APTO_CHK.ID_APARTAMENTO IS NULL\nAND APTO_RES.ID_APARTAMENTO IS NULL\n";
			}
			SQL = SQL + "ORDER BY TIPO_APARTAMENTO, NUM_APARTAMENTO";

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<ApartamentoVO> resultado = new ArrayList();
			for (Object lis : lista) {
				ApartamentoVO objVO = new ApartamentoVO();
				objVO.setaDados((Object[]) lis);
				resultado.add(objVO);
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public ApartamentoVO obterApartamentoPorId(ApartamentoVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_APART_POR_ID;

			SQL = SQL + " WHERE A.ID_APARTAMENTO = " + vo.getBcIdApartamento();

			List lista = this.manager.createNativeQuery(SQL).getResultList();
			for (Object lis : lista) {
				vo = new ApartamentoVO();
				vo.setaDados((Object[]) lis);
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<TarifaVO> obterTarifaPorPeriodo(ReservaApartamentoVO vo)
			throws MozartSessionException {
		try {
			String SQL = "SELECT TA.ID_TARIFA, DESCRICAO, TA.ADICIONAL, t.TIPO, \n";
			SQL = SQL
					+ "DECODE("
					+ vo.getBcQtdePax()
					+ ",0,0,1,TA.PAX1,2,TA.PAX2,3,TA.PAX3,4,TA.PAX4,5,TA.PAX5,6,TA.PAX6,7,TA.PAX7) PAX, DATA\n";
			SQL = SQL + "FROM TABLE(CAST(FC_TARIFA('"
					+ MozartUtil.format(vo.getBcDataEntrada(), "dd/MM/yyyy")
					+ "',";
			SQL = SQL
					+ "'"
					+ MozartUtil.format(
							MozartUtil.decrementarDia(vo.getBcDataSaida(), 1),
							"dd/MM/yyyy") + "',";
			SQL = SQL + vo.getBcIdTipoApartamento() + "," + vo.getBcIdEmpresa()
					+ "," + vo.getBcIdHotel() + "," + vo.getBcIdMoeda()
					+ ") AS TARIFA_SET)) TI,\n"
					+ "TARIFA_APARTAMENTO TA, TARIFA T\n"
					+ "WHERE TI.ID_TARIFA = TA.ID_TARIFA\n"
					+ "AND T.ID_TARIFA = TA.ID_TARIFA\n"
					+ "AND TA.ID_TIPO_APARTAMENTO = "
					+ vo.getBcIdTipoApartamento();

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<TarifaVO> listTarifa = new ArrayList();
			TarifaVO tarifaVO = null;
			for (Object lis : lista) {
				tarifaVO = new TarifaVO();
				tarifaVO.setaDados((Object[]) lis);
				listTarifa.add(tarifaVO);
			}
			return listTarifa;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<HospedeVO> obterHospedePorNome(HospedeVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_HOSPEDE_POR_NOME;
			SQL = SQL
					+ "    WHERE (UPPER(H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE)) LIKE '%'||UPPER('"
					+ vo.getBcNomeHospede()
					+ "')||'%' \n"
					+ " AND H.ID_REDE_HOTEL = ?1 "
					+ " ORDER BY UPPER(H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE||NVL2(H.CPF,'-', '')||H.CPF)";

			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getIdRedeHotel()).getResultList();

			List<HospedeVO> listHospede = new ArrayList();
			for (Object lis : lista) {
				vo = new HospedeVO();
				vo.setaDados((Object[]) lis);
				listHospede.add(vo);
			}
			return listHospede;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public HospedeVO obterHospedePorId(HospedeVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_HOSPEDE_POR_ID;
			SQL = SQL + "    WHERE H.ID_HOSPEDE = " + vo.getBcIdHospede();

			List lista = this.manager.createNativeQuery(SQL).getResultList();
			for (Object lis : lista) {
				vo = new HospedeVO();
				vo.setaDados((Object[]) lis);
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public EmpresaRedeVO obterEmpresaRedePorIdERede(EmpresaRedeVO vo)
			throws MozartSessionException {
		try {
			String sql = QUERY_OBTER_EMPRESA_REDE_POR_ID_E_IDREDE;
			String filtroSql = "", conector = " ";
			if (!MozartUtil.isNull(vo.getBcIdEmpresa())) {
				filtroSql = filtroSql + conector + "ID_EMPRESA = "
						+ vo.getBcIdEmpresa();
				conector = " AND ";
			}
			if (!MozartUtil.isNull(vo.getBcIdRedeHotel())) {
				filtroSql = filtroSql + conector + " ID_REDE_HOTEL = "
						+ vo.getBcIdRedeHotel();
				conector = " AND ";
			}
			if (!MozartUtil.isNull(vo.getIdRedeHotel())) {
				filtroSql = filtroSql + conector + " ID_REDE_HOTEL = "
						+ vo.getIdRedeHotel();
				conector = " AND ";
			}
			if (!MozartUtil.isNull(vo.getBcParticular())) {
				filtroSql = filtroSql
						+ conector
						+ " PARTICULAR = "
						+ MozartUtil.getTextoEntreCaracter(
								vo.getBcParticular(), "'");
				conector = " AND ";
			}

			if (!MozartUtil.isNull(filtroSql)) {
				sql = sql + " WHERE " + filtroSql;
			}

			List lista = this.manager.createNativeQuery(sql).getResultList();
			for (Object lis : lista) {
				vo = new EmpresaRedeVO();
				vo.setaDados((Object[]) lis);
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<EmpresaGrupoLancamentoVO> obterEmpresaGrupoLancamentoPorHotelEEmpresa(
			EmpresaGrupoLancamentoVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_GRUPO_LANCAMENTO_POR_HOTEL_EMPRESA;
			SQL = SQL + "WHERE ID_EMPRESA = " + vo.getBcIdEmpresa() + "\n"
					+ "AND ID_HOTEL = " + vo.getBcIdHotel();

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<EmpresaGrupoLancamentoVO> listEmpresaGrupoLancamento = new ArrayList();
			for (Object lis : lista) {
				vo = new EmpresaGrupoLancamentoVO();
				vo.setaDados((Object[]) lis);
				listEmpresaGrupoLancamento.add(vo);
			}
			return listEmpresaGrupoLancamento;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<PagamentoReservaVO> obterTiposDePagamentoReserva(
			PagamentoReservaVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_OBTER_TIPOS_PAGAMENTO_RESERVA;
			SQL = SQL + "WHERE ID_HOTEL = " + vo.getBcIdHotel() + " \n"
					+ "AND IL.RECEITA_CHECKOUT = 2 \n" + "AND (    ('"
					+ vo.getBcFormaPg()
					+ "' = 'A' AND TL.ID_IDENTIFICA_LANCAMENTO IN (16,17,19)) \n"
					+ "                    OR ('" + vo.getBcFormaPg()
					+ "' = 'D' AND TL.ID_IDENTIFICA_LANCAMENTO = 16) \n"
					+ "                    OR ('" + vo.getBcFormaPg()
					+ "' = 'F' AND TL.ID_IDENTIFICA_LANCAMENTO = 18)   \n"
					+ "                  )   \n"
					+ "                ORDER BY TL.DESCRICAO_LANCAMENTO";

			List lista = this.manager.createNativeQuery(SQL).getResultList();

			List<PagamentoReservaVO> listPagamentoReserva = new ArrayList();
			for (Object lis : lista) {
				vo = new PagamentoReservaVO();
				vo.setaDadosObterTiposDePagamentoReserva((Object[]) lis);
				listPagamentoReserva.add(vo);
			}
			return listPagamentoReserva;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarReserva(ReservaVO reservaVO)
			throws MozartSessionException {
		try {

			Date agora = new Date();

			String SQL = INSERT_RESERVA;
			this.manager
					.createNativeQuery(SQL)
					.setParameter(1, reservaVO.getBcIdReserva())
					.setParameter(2,
							reservaVO.getEmpresaHotelVO().getBcIdEmpresa())
					.setParameter(3, reservaVO.getBcIdCentralReservas())
					.setParameter(4, reservaVO.getBcIdReservaBloqueio())
					.setParameter(5, reservaVO.getBcIdHotel())
					.setParameter(6, reservaVO.getBcDataEntrada())
					.setParameter(7, reservaVO.getBcDataSaida())
					.setParameter(8, agora).setParameter(9, agora)
					.setParameter(10, reservaVO.getBcDataConfirmaBloqueio())
					.setParameter(11, reservaVO.getBcBloqueio())
					.setParameter(12, reservaVO.getBcDeadLine())
					.setParameter(13, reservaVO.getBcCalculaIss())
					.setParameter(14, reservaVO.getBcCalculaTaxa())
					.setParameter(15, reservaVO.getBcCalculaRoomTax())
					.setParameter(16, reservaVO.getBcFormaReserva())
					.setParameter(17, reservaVO.getBcContato())
					.setParameter(18, reservaVO.getBcIdCidadeContato())
					.setParameter(19, reservaVO.getBcTelefoneContato())
					.setParameter(20, reservaVO.getBcFaxContato())
					.setParameter(21, reservaVO.getBcEmailContato())
					.setParameter(22, reservaVO.getBcObservacao())
					.setParameter(23, reservaVO.getBcNomeGrupo())
					.setParameter(24, reservaVO.getBcCheckin())
					.setParameter(25, reservaVO.getBcTipoPensao())
					.setParameter(26, reservaVO.getBcCortesia())
					.setParameter(27, reservaVO.getBcGrupo())
					.setParameter(28, reservaVO.getBcValorTotal())
					.setParameter(29, "N")
					.setParameter(30, reservaVO.getBcConfirma())
					.setParameter(31, reservaVO.getBcFlgAlcoolica())
					.setParameter(32, reservaVO.getBcIdReservaMida())
					.setParameter(33, reservaVO.getBcPermuta())
					.setParameter(34, reservaVO.getBcIdCorporate())
					.setParameter(35, null)
					.setParameter(36, reservaVO.getBcIdPermuta())
					.setParameter(37, reservaVO.getBcGaranteNoShow())
					.setParameter(38, reservaVO.getBcFidelidade())
					.setParameter(39, null).setParameter(40, "S")
					.setParameter(41, reservaVO.getBcAlterando())
					.setParameter(42, reservaVO.getBcComissao())
					.setParameter(43, reservaVO.getBcCalculaSeguro())
					.setParameter(44, reservaVO.getBcValorPensao())
					.setParameter(45, reservaVO.getBcObservacaoVoucher())
					.setParameter(46, reservaVO.getBcIdGds())
					.setParameter(47, reservaVO.getBcIdReservaGds())
					.executeUpdate();
			System.out.println("Reserva salva com o objeto: "
					+ reservaVO.toAllString());
			for (ReservaApartamentoVO obj : reservaVO
					.getListReservaApartamento()) {
				SQL = INSERT_RESERVA_APARTAMENTO;
				this.manager.createNativeQuery(SQL)
						.setParameter(1, obj.getBcIdReservaApartamento())
						.setParameter(2, obj.getBcIdTipoApartamento())
						.setParameter(3, obj.getBcIdReserva())
						.setParameter(4, new Long(1L))
						.setParameter(5, obj.getBcQtdeCheckin())
						.setParameter(6, obj.getBcQtdePax())
						.setParameter(7, obj.getBcTarifa())
						.setParameter(8, obj.getBcJustificaTarifa())
						.setParameter(9, obj.getBcIdCentralReservas())
						.setParameter(10, obj.getBcIdHotel())
						.setParameter(11, obj.getBcTotalTarifa())
						.setParameter(12, obj.getBcAdicional())
						.setParameter(13, obj.getBcQtdeCrianca())
						.setParameter(14, obj.getBcIdApartamento())
						.setParameter(15, obj.getBcMaster())
						.setParameter(16, obj.getBcValorPensao())
						.setParameter(17, obj.getBcDataEntrada())
						.setParameter(18, obj.getBcDataSaida())
						.setParameter(19, null)
						.setParameter(20, obj.getBcValorCafe())
						.setParameter(21, null).setParameter(22, null)
						.setParameter(23, null)
						.setParameter(24, obj.getBcTarifaManual())
						.setParameter(25, obj.getBcDataManual())
						.setParameter(26, obj.getBcIdTipoDiaria())
						.executeUpdate();
			}
			// Fim Query reserva apartamento
			// Query room list
			for (ReservaApartamentoVO obj : reservaVO
					.getListReservaApartamento()) {
				for (RoomListVO objRL : obj.getListRoomList()) {
					SQL = INSERT_ROOM_LIST;
					this.manager
							.createNativeQuery(SQL)
							.setParameter(1, objRL.getBcIdRoomList())
							.setParameter(2, objRL.getBcIdCheckin())
							.setParameter(3, objRL.getBcIdReserva())
							.setParameter(4, objRL.getBcIdTipoHospede())
							.setParameter(5, objRL.getBcIdHotel())
							.setParameter(6, null)
							.setParameter(7, objRL.getBcIdHospede())
							.setParameter(8, null)
							.setParameter(9, null)
							.setParameter(10, objRL.getBcNomeHospede())
							.setParameter(11, null)
							.setParameter(12, null)
							.setParameter(13, objRL.getBcIdReservaApartamento())
							.setParameter(14, objRL.getBcPrincipal())
							.setParameter(15, "N").executeUpdate();
				}
			}// Fim Query room list
				// Query reserva apartamento diaria
			for (ReservaApartamentoVO obj : reservaVO
					.getListReservaApartamento()) {
				for (ReservaApartamentoDiariaVO objRAD : obj
						.getListReservaApartamentoDiaria()) {
					SQL = INSERT_RESERVA_APARTAMENTO_DIARIA;
					this.manager
							.createNativeQuery(SQL)
							.setParameter(1, objRAD.getBcData())
							.setParameter(2, objRAD.getBcIdHotel())
							.setParameter(3, objRAD.getBcIdReserva())
							.setParameter(4, objRAD.getBcIdReservaApartamento())
							.setParameter(5, objRAD.getBcTarifa())
							.setParameter(6, objRAD.getBcJustificaTarifa())
							.setParameter(7, objRAD.getBcIdMoeda())
							.setParameter(8,
									objRAD.getBcIdReservaApartamentoDiaria())
							.executeUpdate();
				}
			}
			if (reservaVO.getListMovimentoApartamento() != null
					&& reservaVO.getListMovimentoApartamento().size() > 0) {
				for (MovimentoApartamentoEJB movimentoApartamentoEJB : reservaVO
						.getListMovimentoApartamento()) {
					if (movimentoApartamentoEJB != null
							&& movimentoApartamentoEJB
									.getIdMovimentoApartamento() != null) {

						movimentoApartamentoEJB.setNumDocumento(reservaVO
								.getBcIdReserva()
								+ " - "
								+ MozartUtil.format(reservaVO
										.getBcDataEntrada()));
						movimentoApartamentoEJB.getTipoLancamentoEJB()
								.setIdHotel(reservaVO.getBcIdHotel());
						System.out
								.println("Movimento Apartamento salva com o objeto: "
										+ movimentoApartamentoEJB.toAllString());
						manager.persist(movimentoApartamentoEJB);
					}
				}
			}
			for (PagamentoReservaVO obj : reservaVO.getListPagamento()) {
				SQL = INSERT_PAGAMENTO_RESERVA;
				this.manager.createNativeQuery(SQL)
						.setParameter(1, obj.getBcIdPagamentoReserva())
						.setParameter(2, obj.getBcIdCartaoCredito())
						.setParameter(3, obj.getBcIdTipoLancamento())
						.setParameter(4, obj.getBcIdReserva())
						.setParameter(5, obj.getBcValor())
						.setParameter(6, obj.getBcConfirma())
						.setParameter(7, obj.getBcDataConfirma())
						.setParameter(8, obj.getBcNumDocumento())
						.setParameter(9, obj.getBcValidadeCartao())
						.setParameter(10, obj.getBcIdHotel())
						.setParameter(11, null)
						.setParameter(12, obj.getBcFormaPg())
						.setParameter(13, obj.getBcCodigoSeguranca())
						.setParameter(14, obj.getBcBandeira())
						.setParameter(15, obj.getBcNomeCartao())
						.setParameter(16, obj.getBcIdApartamento())
						.setParameter(17, obj.getBcIdMovimentoApartamento())
						.executeUpdate();
				System.out.println("Pagamento Reserva salva com o objeto: "
						+ obj.toAllString());
			}
			for (ReservaGrupoLancamentoVO obj : reservaVO
					.getListReservaGrupoLancamento()) {
				SQL = INSERT_RESERVA_GRUPO_LANCAMENTO;
				this.manager.createNativeQuery(SQL).setParameter(1, null)
						.setParameter(2, obj.getBcIdReserva())
						.setParameter(3, obj.getBcIdIdentificaLancamento())
						.setParameter(4, obj.getBcQuemPaga())
						.setParameter(5, obj.getBcIdHotel())
						.setParameter(6, obj.getBcIdEmpresa()).executeUpdate();
			}

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public Long obterNextVal() throws MozartSessionException {
		try {
			String SQL = "SELECT MOZART.ID.NEXTVAL FROM DUAL";
			BigDecimal vec = (BigDecimal) this.manager.createNativeQuery(SQL)
					.getSingleResult();
			Long retorno = null;
			retorno = vec.longValue();
			return retorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public ReservaVO obterReservaPorId(ReservaVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_RESERVA;
			Object[] vec = (Object[]) this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcIdReserva()).getSingleResult();

			vo.setaDadosAlteracaoReserva(vec);

			vo.getEmpresaHotelVO().setBcIdEmpresa(vo.getBcIdEmpresa());
			vo.getEmpresaHotelVO().setBcIdHotel(vo.getBcIdHotel());
			vo.setEmpresaHotelVO(obterEmpresaHotelPorIdEHotel(vo
					.getEmpresaHotelVO()));

			vo.setListReservaApartamento(obterReservaApartamentoPorIdReserva(vo));

			vo.setListReservaGrupoLancamento(obterReservaGrupoLancamentoPorIdReserva(vo));

			vo.setListPagamento(obterPagamentoReservaPorIdReserva(vo));

			List<ReservaApartamentoDiariaVO> listaReservaApartamentoDiaria = obterReservaApartamentoDiariaPorIdReserva(vo);

			List<RoomListVO> listaRoomList = obterRoomListPorIdReserva(vo);
			// setando o reserva apartamento diaria e o room list no reserva
			// apartamento
			for (ReservaApartamentoVO resApto : vo.getListReservaApartamento()) {

				for (RoomListVO roomList : listaRoomList) {
					if (resApto.getBcIdReservaApartamento().equals(
							roomList.getBcIdReservaApartamento()))
						resApto.getListRoomList().add(roomList);
				}

				for (ReservaApartamentoDiariaVO resAptoDia : listaReservaApartamentoDiaria) {
					if (resApto.getBcIdReservaApartamento().equals(
							resAptoDia.getBcIdReservaApartamento()))
						resApto.getListReservaApartamentoDiaria().add(
								resAptoDia);
				}
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public ReservaVO obterReservaPorIdGds(ReservaVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_RESERVA_GDS;

			Query query = this.manager.createNativeQuery(SQL).setParameter(1,
					vo.getBcIdReservaGds());

			if (query.getResultList().size() == 0) {
				throw new MozartSessionException(
						MozartSessionException.RESERVA_NAO_ENCONTRADA);
			}

			Object[] vec = (Object[]) query.getSingleResult();

			vo.setaDadosAlteracaoReserva(vec);

			vo.getEmpresaHotelVO().setBcIdEmpresa(vo.getBcIdEmpresa());
			vo.getEmpresaHotelVO().setBcIdHotel(vo.getBcIdHotel());
			vo.setEmpresaHotelVO(obterEmpresaHotelPorIdEHotel(vo
					.getEmpresaHotelVO()));

			vo.setListReservaApartamento(obterReservaApartamentoPorIdReserva(vo));

			vo.setListReservaGrupoLancamento(obterReservaGrupoLancamentoPorIdReserva(vo));

			vo.setListPagamento(obterPagamentoReservaPorIdReserva(vo));

			List<ReservaApartamentoDiariaVO> listaReservaApartamentoDiaria = obterReservaApartamentoDiariaPorIdReserva(vo);

			List<RoomListVO> listaRoomList = obterRoomListPorIdReserva(vo);
			// setando o reserva apartamento diaria e o room list no reserva
			// apartamento
			for (ReservaApartamentoVO resApto : vo.getListReservaApartamento()) {

				for (RoomListVO roomList : listaRoomList) {
					if (resApto.getBcIdReservaApartamento().equals(
							roomList.getBcIdReservaApartamento()))
						resApto.getListRoomList().add(roomList);
				}

				for (ReservaApartamentoDiariaVO resAptoDia : listaReservaApartamentoDiaria) {
					if (resApto.getBcIdReservaApartamento().equals(
							resAptoDia.getBcIdReservaApartamento()))
						resApto.getListReservaApartamentoDiaria().add(
								resAptoDia);
				}
			}
			return vo;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public BloqueioGestaoVO obterBloqueioGestaoPorId(BloqueioGestaoVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_BLOQUEIO_GESTAO;
			Object[] vec = (Object[]) this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcIdReserva()).getSingleResult();

			BloqueioGestaoVO gestao = new BloqueioGestaoVO();
			gestao.setaDadosGestaoBloqueio(vec);

			return gestao;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ReservaVO> obterBloqueioLookup(ReservaVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_RESERVA_BLOQUEIO_LOOKUP;
			List<Object[]> vecs = (List<Object[]>) this.manager
					.createNativeQuery(SQL)
					.setParameter(1,
							"%" + vo.getGracFantasia().toUpperCase() + "%")
					.setParameter(2,
							"%" + vo.getGracFantasia().toUpperCase() + "%")
					.setParameter(3, vo.getBcIdHotel().toString())
					.getResultList();

			List<ReservaVO> reservas = new ArrayList<ReservaVO>();

			for (Object[] vec : vecs) {
				ReservaVO reserva = new ReservaVO();
				reserva.setaDadosAlteracaoReserva(vec);
				reservas.add(reserva);
			}

			return reservas;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ReservaApartamentoVO> obterReservaApartamentoPorIdReserva(
			ReservaVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_RESERVA_APARTAMENTO;
			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcIdReserva()).getResultList();

			ReservaApartamentoVO reservaApartamentoVO = null;
			List<ReservaApartamentoVO> listaRetorno = new ArrayList();
			for (Object vec : lista) {
				reservaApartamentoVO = new ReservaApartamentoVO();
				reservaApartamentoVO.setaDados((Object[]) vec);
				listaRetorno.add(reservaApartamentoVO);
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ReservaApartamentoDiariaVO> obterReservaApartamentoDiariaPorIdReserva(
			ReservaVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_RESERVA_APARTAMENTO_DIARIA;
			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcIdReserva()).getResultList();

			ReservaApartamentoDiariaVO reservaApartamentoDiariaVO = null;
			List<ReservaApartamentoDiariaVO> listaRetorno = new ArrayList();
			for (Object vec : lista) {
				reservaApartamentoDiariaVO = new ReservaApartamentoDiariaVO();
				reservaApartamentoDiariaVO.setaDados((Object[]) vec);
				listaRetorno.add(reservaApartamentoDiariaVO);
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<RoomListVO> obterRoomListPorIdReserva(ReservaVO vo)
			throws MozartSessionException {
		try {
			String SQL = QUERY_ROOM_LIST;
			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcIdReserva()).getResultList();

			RoomListVO roomListVO = null;
			List<RoomListVO> listaRetorno = new ArrayList();
			for (Object vec : lista) {
				roomListVO = new RoomListVO();
				roomListVO.setaDados((Object[]) vec);
				listaRetorno.add(roomListVO);
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ReservaGrupoLancamentoVO> obterReservaGrupoLancamentoPorIdReserva(
			ReservaVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_RESERVA_GRUPO_LANCAMENTO;
			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcIdReserva()).getResultList();

			ReservaGrupoLancamentoVO reservaGrupoLancamentoVO = null;
			List<ReservaGrupoLancamentoVO> listaRetorno = new ArrayList();
			for (Object vec : lista) {
				reservaGrupoLancamentoVO = new ReservaGrupoLancamentoVO();
				reservaGrupoLancamentoVO.setaDados((Object[]) vec);
				listaRetorno.add(reservaGrupoLancamentoVO);
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<PagamentoReservaVO> obterPagamentoReservaPorIdReserva(
			ReservaVO vo) throws MozartSessionException {
		try {
			String SQL = QUERY_PAGAMENTO_RESERVA;
			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcIdReserva()).getResultList();

			PagamentoReservaVO pagamentoReservaVO = null;
			List<PagamentoReservaVO> listaRetorno = new ArrayList();

			if (MozartUtil.isNull(vo.getListMovimentoApartamento()))
				vo.setListMovimentoApartamento(new ArrayList<MovimentoApartamentoEJB>());

			for (Object vec : lista) {
				pagamentoReservaVO = new PagamentoReservaVO();
				pagamentoReservaVO.setaDados((Object[]) vec);
				MovimentoApartamentoEJB movApto = new MovimentoApartamentoEJB();

				if (!MozartUtil.isNull(pagamentoReservaVO
						.getBcIdMovimentoApartamento())) {
					movApto = manager.find(MovimentoApartamentoEJB.class,
							pagamentoReservaVO.getBcIdMovimentoApartamento());

					pagamentoReservaVO
							.setDsAptoCofan(movApto.getCheckinEJB()
									.getApartamentoEJB().getNumApartamento()
									.toString());
				}

				vo.getListMovimentoApartamento().add(movApto);

				listaRetorno.add(pagamentoReservaVO);
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualizarReserva(ReservaVO reservaVO)
			throws MozartSessionException {
		try {
			ApartamentoVO filtroApto = new ApartamentoVO();
			for (ReservaApartamentoVO obj : reservaVO
					.getListReservaApartamento()) {
				if (((obj.getBcQtdeCheckin() == null) || (obj
						.getBcQtdeCheckin().intValue() == 0))
						&& (obj.getBcIdApartamento() != null)) {
					filtroApto.setBcIdHotel(obj.getBcIdHotel());
					filtroApto.setBcIdApartamento(obj.getBcIdApartamento());
					filtroApto.setBcDataEntrada(obj.getBcDataEntrada());
					filtroApto.setBcDataSaida(obj.getBcDataSaida());
					filtroApto.setIdReserva(obj.getBcIdReserva());
					filtroApto.setBcIdTipoApartamento(obj
							.getBcIdTipoApartamento());
					filtroApto.setOcupacao(true);
					List<ApartamentoVO> listaApto = obterApartamentoPorDisponibilidade(filtroApto);
					if (!MozartUtil.isNull(listaApto)) {
						ApartamentoVO apto = (ApartamentoVO) listaApto.get(0);
						if (apto.isOcupacao()) {
							throw new MozartValidateException(
									"O apartamento: "
											+ apto.getBcNumApartamento()
											+ " está bloqueado para outra reserva nesse período.");
						}
					}
				}
			}

			String SQL = DELETE_RESERVA_GRUPO_LANCAMENTO;
			this.manager.createNativeQuery(SQL)
					.setParameter(1, reservaVO.getBcIdReserva())
					.executeUpdate();

			SQL = DELETE_PAGAMENTO_RESERVA;
			this.manager.createNativeQuery(SQL)
					.setParameter(1, reservaVO.getBcIdReserva())
					.executeUpdate();

			SQL = DELETE_ROOM_LIST;
			this.manager.createNativeQuery(SQL)
					.setParameter(1, reservaVO.getBcIdReserva())
					.executeUpdate();

			SQL = DELETE_RESERVA_APARTAMENTO_DIARIA;
			this.manager.createNativeQuery(SQL)
					.setParameter(1, reservaVO.getBcIdReserva())
					.executeUpdate();

			SQL = DELETE_RESERVA_APARTAMENTO;
			this.manager.createNativeQuery(SQL)
					.setParameter(1, reservaVO.getBcIdReserva())
					.executeUpdate();

			SQL = UPDATE_RESERVA;
			int x = 1;
			this.manager
					.createNativeQuery(SQL)
					.setParameter(x++,
							reservaVO.getEmpresaHotelVO().getBcIdEmpresa())
					.setParameter(x++, reservaVO.getBcIdCentralReservas())
					.setParameter(x++, reservaVO.getBcIdReservaBloqueio())
					.setParameter(x++, reservaVO.getBcIdHotel())
					.setParameter(x++, reservaVO.getBcDataEntrada())
					.setParameter(x++, reservaVO.getBcDataSaida())
					.setParameter(x++, reservaVO.getBcDataConfirmaBloqueio())
					.setParameter(x++, reservaVO.getBcBloqueio())
					.setParameter(x++, reservaVO.getBcDeadLine())
					.setParameter(x++, reservaVO.getBcCalculaIss())
					.setParameter(x++, reservaVO.getBcCalculaTaxa())
					.setParameter(x++, reservaVO.getBcCalculaRoomTax())
					.setParameter(x++, reservaVO.getBcFormaReserva())
					.setParameter(x++, reservaVO.getBcContato())
					.setParameter(x++, reservaVO.getBcIdCidadeContato())
					.setParameter(x++, reservaVO.getBcTelefoneContato())
					.setParameter(x++, reservaVO.getBcFaxContato())
					.setParameter(x++, reservaVO.getBcEmailContato())
					.setParameter(x++, reservaVO.getBcObservacao())
					.setParameter(x++, reservaVO.getBcNomeGrupo())
					.setParameter(x++, reservaVO.getBcCheckin())
					.setParameter(x++, reservaVO.getBcTipoPensao())
					.setParameter(x++, reservaVO.getBcCortesia())
					.setParameter(x++, reservaVO.getBcGrupo())
					.setParameter(x++, reservaVO.getBcValorTotal())
					.setParameter(x++, "N")
					.setParameter(x++, reservaVO.getBcConfirma())
					.setParameter(x++, reservaVO.getBcFlgAlcoolica())
					.setParameter(x++, reservaVO.getBcIdReservaMida())
					.setParameter(x++, reservaVO.getBcPermuta())
					.setParameter(x++, reservaVO.getBcIdCorporate())
					.setParameter(x++, reservaVO.getBcIdUsuarioWeb())
					.setParameter(x++, reservaVO.getBcIdPermuta())
					.setParameter(x++, reservaVO.getBcGaranteNoShow())
					.setParameter(x++, reservaVO.getBcFidelidade())
					.setParameter(x++, null).setParameter(x++, "S")
					.setParameter(x++, reservaVO.getBcAlterando())
					.setParameter(x++, reservaVO.getBcComissao())
					.setParameter(x++, reservaVO.getBcCalculaSeguro())
					.setParameter(x++, reservaVO.getBcValorPensao())
					.setParameter(x++, reservaVO.getBcObservacaoVoucher())
					.setParameter(x++, reservaVO.getBcIdReserva())
					.executeUpdate();
			for (ReservaApartamentoVO obj : reservaVO
					.getListReservaApartamento()) {
				if ((obj.getBcQtdeCheckin() == null)
						|| (obj.getBcQtdeCheckin().equals(new Long(0L)))) {
					SQL = INSERT_RESERVA_APARTAMENTO;
					this.manager.createNativeQuery(SQL)
							.setParameter(1, obj.getBcIdReservaApartamento())
							.setParameter(2, obj.getBcIdTipoApartamento())
							.setParameter(3, obj.getBcIdReserva())
							.setParameter(4, new Long(1L))
							.setParameter(5, obj.getBcQtdeCheckin())
							.setParameter(6, obj.getBcQtdePax())
							.setParameter(7, obj.getBcTarifa())
							.setParameter(8, obj.getBcJustificaTarifa())
							.setParameter(9, obj.getBcIdCentralReservas())
							.setParameter(10, obj.getBcIdHotel())
							.setParameter(11, obj.getBcTotalTarifa())
							.setParameter(12, obj.getBcAdicional())
							.setParameter(13, obj.getBcQtdeCrianca())
							.setParameter(14, obj.getBcIdApartamento())
							.setParameter(15, obj.getBcMaster())
							.setParameter(16, obj.getBcValorPensao())
							.setParameter(17, obj.getBcDataEntrada())
							.setParameter(18, obj.getBcDataSaida())
							.setParameter(19, null)
							.setParameter(20, obj.getBcValorCafe())
							.setParameter(21, null).setParameter(22, null)
							.setParameter(23, null)
							.setParameter(24, obj.getBcTarifaManual())
							.setParameter(25, obj.getBcDataManual())
							.setParameter(26, obj.getBcIdTipoDiaria())
							.executeUpdate();
				}
			}
			// Fim Query reserva apartamento
			// Query room list
			for (ReservaApartamentoVO obj : reservaVO
					.getListReservaApartamento()) {
				for (RoomListVO objRL : obj.getListRoomList()) {
					if (objRL.getBcIdCheckin() == null
							&& !"TEMP".equals(objRL.getBcTemp())) {
						SQL = INSERT_ROOM_LIST;
						this.manager
								.createNativeQuery(SQL)
								.setParameter(1, objRL.getBcIdRoomList())
								.setParameter(2, objRL.getBcIdCheckin())
								.setParameter(3, objRL.getBcIdReserva())
								.setParameter(4, objRL.getBcIdTipoHospede())
								.setParameter(5, objRL.getBcIdHotel())
								.setParameter(6, null)
								.setParameter(7, objRL.getBcIdHospede())
								.setParameter(8, null)
								.setParameter(9, null)
								.setParameter(10, objRL.getBcNomeHospede())
								.setParameter(11, null)
								.setParameter(12, null)
								.setParameter(13,
										objRL.getBcIdReservaApartamento())
								.setParameter(14, objRL.getBcPrincipal())
								.setParameter(15, "N").executeUpdate();
					}
				}
			}
			// Fim Query room list
			// Query reserva apartamento diaria
			for (ReservaApartamentoVO obj : reservaVO
					.getListReservaApartamento()) {
				for (ReservaApartamentoDiariaVO objRAD : obj
						.getListReservaApartamentoDiaria()) {
					SQL = INSERT_RESERVA_APARTAMENTO_DIARIA;
					this.manager
							.createNativeQuery(SQL)
							.setParameter(1, objRAD.getBcData())
							.setParameter(2, objRAD.getBcIdHotel())
							.setParameter(3, objRAD.getBcIdReserva())
							.setParameter(4, objRAD.getBcIdReservaApartamento())
							.setParameter(5, objRAD.getBcTarifa())
							.setParameter(6, objRAD.getBcJustificaTarifa())
							.setParameter(7, objRAD.getBcIdMoeda())
							.setParameter(8,
									objRAD.getBcIdReservaApartamentoDiaria())
							.executeUpdate();
				}
			}

			if (reservaVO.getListMovimentoApartamento() != null
					&& reservaVO.getListMovimentoApartamento().size() > 0) {
				for (MovimentoApartamentoEJB movimentoApartamentoEJB : reservaVO
						.getListMovimentoApartamento()) {
					if (movimentoApartamentoEJB != null
							&& movimentoApartamentoEJB
									.getIdMovimentoApartamento() != null) {

						movimentoApartamentoEJB.setNumDocumento(reservaVO
								.getBcIdReserva()
								+ " - "
								+ MozartUtil.format(reservaVO
										.getBcDataEntrada()));
						movimentoApartamentoEJB.getTipoLancamentoEJB()
								.setIdHotel(reservaVO.getBcIdHotel());
						System.out
								.println("Movimento Apartamento salva com o objeto: "
										+ movimentoApartamentoEJB.toAllString());
						manager.merge(movimentoApartamentoEJB);
					}
				}
			}

			for (PagamentoReservaVO obj : reservaVO.getListPagamento()) {
				SQL = INSERT_PAGAMENTO_RESERVA;
				this.manager.createNativeQuery(SQL)
						.setParameter(1, obj.getBcIdPagamentoReserva())
						.setParameter(2, obj.getBcIdCartaoCredito())
						.setParameter(3, obj.getBcIdTipoLancamento())
						.setParameter(4, obj.getBcIdReserva())
						.setParameter(5, obj.getBcValor())
						.setParameter(6, obj.getBcConfirma())
						.setParameter(7, obj.getBcDataConfirma())
						.setParameter(8, obj.getBcNumDocumento())
						.setParameter(9, obj.getBcValidadeCartao())
						.setParameter(10, obj.getBcIdHotel())
						.setParameter(11, null)
						.setParameter(12, obj.getBcFormaPg())
						.setParameter(13, obj.getBcCodigoSeguranca())
						.setParameter(14, obj.getBcBandeira())
						.setParameter(15, obj.getBcNomeCartao())
						.setParameter(16, obj.getBcIdApartamento())
						.setParameter(17, obj.getBcIdMovimentoApartamento())
						.executeUpdate();
			}
			for (ReservaGrupoLancamentoVO obj : reservaVO
					.getListReservaGrupoLancamento()) {
				SQL = INSERT_RESERVA_GRUPO_LANCAMENTO;
				this.manager.createNativeQuery(SQL).setParameter(1, null)
						.setParameter(2, obj.getBcIdReserva())
						.setParameter(3, obj.getBcIdIdentificaLancamento())
						.setParameter(4, obj.getBcQuemPaga())
						.setParameter(5, obj.getBcIdHotel())
						.setParameter(6, obj.getBcIdEmpresa()).executeUpdate();
			}
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<OcupDispVO> obterOcupacaoDisponibilidade(ReservaVO vo)
			throws MozartSessionException {
		try {
			String SQL = "";
			if (vo.getOcupacaoDisponibilidade().equals(new Long(1L))) {
				SQL = QUERY_OCUPACAO;
			} else {
				SQL = QUERY_DISPONIBILIDADE;
			}
			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, vo.getBcDataEntrada())
					.setParameter(2, vo.getBcDataSaida())
					.setParameter(3, vo.getBcIdHotel()).setParameter(4, "%")
					.getResultList();

			List<OcupDispVO> listaRetorno = new ArrayList();
			OcupDispVO od = null;
			for (Object vec : lista) {
				od = new OcupDispVO();
				od.setaDados((Object[]) vec);
				listaRetorno.add(od);
			}
			int qtdQuartos = 0;
			String dataIni = ((OcupDispVO) listaRetorno.get(0)).getData();
			for (OcupDispVO obj : listaRetorno) {
				if (obj.getData().equals(dataIni)) {
					qtdQuartos++;
				}
			}
			int quartoAtual = 1;
			for (OcupDispVO obj : listaRetorno) {
				if (quartoAtual == qtdQuartos) {
					quartoAtual = 1;
					obj.setUltimoDoDia(new Long(1L));
				} else {
					quartoAtual++;
				}
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ReservaMapaOcupacaoVO> pesquisarMapaOcupacao(
			ReservaMapaOcupacaoVO pFiltro) throws MozartSessionException {
		try {
			String SQL = "";
			SQL = QUERY_MAPA_OCUPACAO;

			List lista = this.manager.createNativeQuery(SQL)
					.setParameter(1, pFiltro.getDataEntrada())
					.setParameter(2, pFiltro.getDataSaida())
					.setParameter(3, pFiltro.getIdHotel())
					.setParameter(4, pFiltro.getBloqueio()).getResultList();

			List<ReservaMapaOcupacaoVO> listaRetorno = new ArrayList();
			for (Object vec : lista) {
				listaRetorno.add(new ReservaMapaOcupacaoVO((Object[]) vec));
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void apagarReserva(ReservaVO reservaVO)
			throws MozartSessionException {
		String sql = " update reserva set apagada = ?1 where id_reserva = ?2";
		this.manager.createNativeQuery(sql)
				.setParameter(1, reservaVO.getBcApagada())
				.setParameter(2, reservaVO.getBcIdReserva()).executeUpdate();
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void apagarReservaOmnibees(ReservaVO reservaVO)
			throws MozartSessionException {
		String sql = " update reserva set apagada = ?1 where id_reserva_gds = ?2";
		this.manager.createNativeQuery(sql)
				.setParameter(1, reservaVO.getBcApagada())
				.setParameter(2, reservaVO.getBcIdReservaGds()).executeUpdate();
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void confirmarReserva(ReservaVO reservaVO)
			throws MozartSessionException {
		try {
			String sql = " update reserva set confirma = ?1 where id_reserva = ?2";
			this.manager.createNativeQuery(sql)
					.setParameter(1, reservaVO.getBcConfirma())
					.setParameter(2, reservaVO.getBcIdReserva())
					.executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void destravarReserva(ReservaVO reservaVO)
			throws MozartSessionException {
		try {
			String sql = " update reserva set alterando = ?1 where id_reserva = ?2";
			this.manager.createNativeQuery(sql)
					.setParameter(1, reservaVO.getBcConfirma())
					.setParameter(2, reservaVO.getBcIdReserva())
					.executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ReservaVO> obterBloqueios(ReservaVO paramReservaVO)
			throws MozartSessionException {
		try {
			int x = 1;
			String SQL = QUERY_OBTER_BLOQUEIO;
			List<Object[]> vec = (List<Object[]>) this.manager
					.createNativeQuery(SQL)
					.setParameter(x++, paramReservaVO.getBcIdHotel())
					.setParameter(x++, paramReservaVO.getBcIdEmpresa())
					.setParameter(
							x++,
							MozartUtil.format(
									paramReservaVO.getBcDataEntrada(),
									"dd/MM/yyyy"))
					.setParameter(
							x++,
							MozartUtil.format(paramReservaVO.getBcDataSaida(),
									"dd/MM/yyyy")).getResultList();

			List<ReservaVO> resultado = new ArrayList<ReservaVO>();

			for (Object[] obj : vec) {
				ReservaVO vo = new ReservaVO();
				int y = 0;
				vo.setBloqueio((String) obj[y++]);
				vo.setBcIdReserva(((BigDecimal) obj[y++]).longValue());
				resultado.add(vo);
			}

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<BloqueioGestaoVO> obterBloqueioGestaoEmpresa(
			EmpresaHotelEJB paramReservaVO) throws MozartSessionException {
		return obterBloqueioGestaoEmpresa(paramReservaVO, null);
	}
	
	public List<BloqueioGestaoVO> obterBloqueioGestaoEmpresa(
			EmpresaHotelEJB paramReservaVO, Timestamp frontOffice) throws MozartSessionException {
		try {
			int x = 1;
			String SQL = QUERY_OBTER_BLOQUEIO_GESTAO;
			
			if(! MozartUtil.isNull(frontOffice)){
				SQL = SQL + " AND (R.DATA_ENTRADA <= ?4 AND R.DATA_SAIDA > ?5 )";
			}
			
			SQL = SQL + " ORDER BY R.DATA_ENTRADA ";
			
			Query q = this.manager
					.createNativeQuery(SQL)
					.setParameter(x++, paramReservaVO.getIdHotel())
					.setParameter(x++, paramReservaVO.getNomeFantasia())
					.setParameter(x++, paramReservaVO.getNomeFantasia());
			
			if(! MozartUtil.isNull(frontOffice)){
				q = q.setParameter(x++, frontOffice)
					.setParameter(x++, frontOffice);
				
			}
			
			List<Object[]> vec = (List<Object[]>) q.getResultList();

			List<BloqueioGestaoVO> resultado = new ArrayList<BloqueioGestaoVO>();

			for (Object[] obj : vec) {
				BloqueioGestaoVO vo = new BloqueioGestaoVO();
				vo.setaDados(obj);
				resultado.add(vo);
			}

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<TarifaApartamentoGestaoBloqueioVO> obterGridTarBloqueioGestaoEmpresa(
			ReservaVO paramReservaVO) throws MozartSessionException {
		try {
			int x = 1;
			String dtEntrada = MozartUtil.format(
					paramReservaVO.getBcDataEntrada(), "dd/MM/yyyy");
			String dtSaida = MozartUtil.format(paramReservaVO.getBcDataSaida(),
					"dd/MM/yyyy");
			String SQL = QUERY_OBTER_TARIFA_BLOQUEIO_GESTAO_PAX;
			Query q = this.manager.createNativeQuery(SQL)
					.setParameter(x++, paramReservaVO.getBcIdReserva())
					.setParameter(x++, dtEntrada)
					.setParameter(x++, dtSaida);

			List<Object[]> vec = q.getResultList();
			List<TarifaApartamentoGestaoBloqueioVO> resultado = new ArrayList<TarifaApartamentoGestaoBloqueioVO>();

			for (Object[] obj : vec) {
				TarifaApartamentoGestaoBloqueioVO vo = new TarifaApartamentoGestaoBloqueioVO();
				vo.setDados(obj);
				resultado.add(vo);
			}

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarReservaApartamentoGestaoBloqueioVO(
			TarifaApartamentoGestaoBloqueioVO pTarifaApartamentoGestaoBloqueioVO)
					throws MozartSessionException {
		Long idReserevaApto = pTarifaApartamentoGestaoBloqueioVO.getIdReservaApartamento();
		
		Long idReserevaAptoDiaria = pTarifaApartamentoGestaoBloqueioVO.getIdReservaApartamentoDiaria();
		
		ReservaApartamentoEJB resApto = manager.find(ReservaApartamentoEJB.class, idReserevaApto);
		
		ReservaApartamentoDiariaEJB resAptoDiaria = manager.find(ReservaApartamentoDiariaEJB.class, idReserevaAptoDiaria);
		
		resAptoDiaria.setTarifa(pTarifaApartamentoGestaoBloqueioVO.getValor());
		resApto.setTarifa(pTarifaApartamentoGestaoBloqueioVO.getValor());
		resApto.setTotalTarifa(pTarifaApartamentoGestaoBloqueioVO.getValor());
		
		manager.merge(resApto);
		manager.merge(resAptoDiaria);
		
	}
	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarTarifaApartamentoGestaoBloqueioVO(
			TarifaApartamentoGestaoBloqueioVO pTarifaApartamentoGestaoBloqueioVO)
			throws MozartSessionException {

		TarifaEJB tarifa = new TarifaEJB();

		TarifaApartamentoEJB tarifaApartamento = new TarifaApartamentoEJB();

		EmpresaTarifaEJB empresaTarifa = new EmpresaTarifaEJB();

		String sqlTipoApartamento = " SELECT ID_TIPO_APARTAMENTO FROM TIPO_APARTAMENTO WHERE FANTASIA=?1 AND ID_HOTEL=?2 ";

		Long idTipoApartamento = ((BigDecimal) manager
				.createNativeQuery(sqlTipoApartamento)
				.setParameter(1,
						pTarifaApartamentoGestaoBloqueioVO.getDsFantasia())
				.setParameter(2,
						pTarifaApartamentoGestaoBloqueioVO.getIdHotel())
				.getSingleResult()).longValue();

		TipoApartamentoEJB tipoApartamento = new TipoApartamentoEJB(
				idTipoApartamento);

		String sqlVerificaTarifa = "SELECT ID_TARIFA FROM TARIFA WHERE DATA_ENTRADA = ?1 AND DATA_SAIDA= ?2 AND ID_HOTEL= ?3 AND ID_MOEDA= ?4 AND TIPO= ?5 AND ATIVO=?6";

		tarifaApartamento.getId().setIdHotel(
				pTarifaApartamentoGestaoBloqueioVO.getIdHotel());

		tarifaApartamento.getId().setIdTipoApartamento(
				pTarifaApartamentoGestaoBloqueioVO.getIdTipoApartamento());

		tarifaApartamento.setUsuario(pTarifaApartamentoGestaoBloqueioVO
				.getUsuario());
		empresaTarifa.setIdEmpresa(pTarifaApartamentoGestaoBloqueioVO
				.getIdEmpresa());
		empresaTarifa.setIdHotel(pTarifaApartamentoGestaoBloqueioVO
				.getIdHotel());
		empresaTarifa.setUsuario(pTarifaApartamentoGestaoBloqueioVO
				.getUsuario());
		try {

			if (pTarifaApartamentoGestaoBloqueioVO.getIdTarifa() != null) {
				tarifaApartamento.getId().setIdTarifa(
						pTarifaApartamentoGestaoBloqueioVO.getIdTarifa());

				tarifaApartamento = manager.find(TarifaApartamentoEJB.class,
						tarifaApartamento.getId());

				String pax = pTarifaApartamentoGestaoBloqueioVO.getPax();
				pax = pax.contains("PAX")? pax: "PAX"+pax; 
				if ("PAX1".equals(pax)) {
					tarifaApartamento
							.setPax1(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if ("PAX2".equals(pax)) {
					tarifaApartamento
							.setPax2(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if ("PAX3".equals(pax)) {
					tarifaApartamento
							.setPax3(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if ("PAX4".equals(pax)) {
					tarifaApartamento
							.setPax4(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if ("PAX5".equals(pax)) {
					tarifaApartamento
							.setPax5(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if ("PAX6".equals(pax)) {
					tarifaApartamento
							.setPax6(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if ("PAX7".equals(pax)) {
					tarifaApartamento
							.setPax7(pTarifaApartamentoGestaoBloqueioVO
									.getValor());

				}

				tarifa.setIdTarifa(pTarifaApartamentoGestaoBloqueioVO
						.getIdTarifa());
				tarifa = manager.find(TarifaEJB.class, tarifa.getIdTarifa());

				tarifa.setUsuario(pTarifaApartamentoGestaoBloqueioVO
						.getUsuario());

				GregorianCalendar dtIn = new GregorianCalendar();
				dtIn.setTime(tarifa.getDataEntrada());
				GregorianCalendar dtOut = new GregorianCalendar();
				dtOut.setTime(tarifa.getDataSaida());

				GregorianCalendar novaData = new GregorianCalendar();

				if (dtIn.before(dtOut)) {
					novaData.setTime(dtIn.getTime());

					do {
						TarifaEJB tarifaAux = new TarifaEJB(tarifa);
						if (novaData.compareTo(dtIn) != 0) {
							tarifaAux.setIdTarifa(this.obterNextVal());
							tarifaAux.setDataEntrada(new Timestamp(novaData
									.getTime().getTime()));
							tarifaAux.setDataSaida(new Timestamp(novaData
									.getTime().getTime()));
							manager.persist(tarifaAux);

							TarifaApartamentoEJB tarifaApartamentoAux = new TarifaApartamentoEJB(
									tarifaApartamento);
							tarifaApartamentoAux.getId().setIdTarifa(
									tarifaAux.getIdTarifa());
							tarifaApartamentoAux.setTarifaEJB(tarifaAux);

							manager.persist(tarifaApartamentoAux);

							empresaTarifa.setIdTarifa(tarifaAux.getIdTarifa());

							EmpresaHotelEJB empresaHotel = new EmpresaHotelEJB();
							empresaHotel.setIdEmpresa(empresaTarifa
									.getIdEmpresa());
							empresaHotel.setIdHotel(empresaTarifa.getIdHotel());

							empresaTarifa.setTarifaEJB(tarifaAux);
							empresaTarifa.setEmpresaHotelEJB(empresaHotel);
							String sqlInsertEmpresaTarifa = " INSERT INTO EMPRESA_TARIFA(ID_EMPRESA, ID_TARIFA, ID_HOTEL) VALUES(?1,?2,?3)";

							EmpresaTarifaEJBPK ejbpk = new EmpresaTarifaEJBPK(
									empresaTarifa.getIdEmpresa(),
									empresaTarifa.getIdHotel(), empresaTarifa
											.getTarifaEJB().getIdTarifa());

							if (manager.find(EmpresaTarifaEJB.class, ejbpk) == null) {
								manager.createNativeQuery(
										sqlInsertEmpresaTarifa)
										.setParameter(1,
												empresaTarifa.getIdEmpresa())
										.setParameter(2,
												empresaTarifa.getIdTarifa())
										.setParameter(3,
												empresaTarifa.getIdHotel())
										.executeUpdate();
							}

						} else {
							tarifa.setDataSaida(tarifa.getDataEntrada());
							manager.merge(tarifa);
							manager.merge(tarifaApartamento);
						}
						novaData.add(Calendar.DAY_OF_MONTH, 1);
					} while (novaData.compareTo(dtOut) <= 0);

				}

			} else {
				Query q = manager.createNativeQuery(sqlVerificaTarifa);

				q.setParameter(1,
						pTarifaApartamentoGestaoBloqueioVO.getDtEntrada());
				q.setParameter(2,
						pTarifaApartamentoGestaoBloqueioVO.getDtSaida());
				q.setParameter(3,
						pTarifaApartamentoGestaoBloqueioVO.getIdHotel());
				q.setParameter(4,
						pTarifaApartamentoGestaoBloqueioVO.getIdMoeda());
				q.setParameter(5, "A");
				q.setParameter(6, "S");
				Long idTarifa;

				if (q.getResultList().size() > 0) {
					idTarifa = ((BigDecimal) q.getSingleResult()).longValue();
				} else {
					tarifa.setIdTarifa(this.obterNextVal());
					tarifa.setDataEntrada(new Timestamp(
							pTarifaApartamentoGestaoBloqueioVO.getDtEntrada()
									.getTime()));
					tarifa.setDataSaida(new Timestamp(
							pTarifaApartamentoGestaoBloqueioVO.getDtSaida()
									.getTime()));
					manager.persist(tarifa);
					idTarifa = tarifa.getIdTarifa();
				}

				tarifaApartamento.getId().setIdTarifa(idTarifa);
				tarifaApartamento.getId().setIdTipoApartamento(
						idTipoApartamento);
				tarifaApartamento.getId().setIdHotel(
						pTarifaApartamentoGestaoBloqueioVO.getIdHotel());
				tarifaApartamento.setTipoApartamento(tipoApartamento);
				tarifa.setIdTarifa(idTarifa);
				tarifaApartamento.setTarifaEJB(tarifa);

				TarifaApartamentoEJB tarifaApartamentoAux = manager.find(
						TarifaApartamentoEJB.class, tarifaApartamento.getId());

				boolean alterarTarifaApto = false;

				if (tarifaApartamentoAux != null) {
					tarifaApartamento = tarifaApartamentoAux;
					alterarTarifaApto = true;
				} else {

					tarifaApartamento.setPax1(0D);
					tarifaApartamento.setPax2(0D);
					tarifaApartamento.setPax3(0D);
					tarifaApartamento.setPax4(0D);
					tarifaApartamento.setPax5(0D);
					tarifaApartamento.setPax6(0D);
					tarifaApartamento.setPax7(0D);
					tarifaApartamento.setAdicional(0D);
				}

				if (pTarifaApartamentoGestaoBloqueioVO.getPax().equals("PAX1")) {
					tarifaApartamento
							.setPax1(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if (pTarifaApartamentoGestaoBloqueioVO.getPax().equals(
						"PAX2")) {
					tarifaApartamento
							.setPax2(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if (pTarifaApartamentoGestaoBloqueioVO.getPax().equals(
						"PAX3")) {
					tarifaApartamento
							.setPax3(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if (pTarifaApartamentoGestaoBloqueioVO.getPax().equals(
						"PAX4")) {
					tarifaApartamento
							.setPax4(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if (pTarifaApartamentoGestaoBloqueioVO.getPax().equals(
						"PAX5")) {
					tarifaApartamento
							.setPax5(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if (pTarifaApartamentoGestaoBloqueioVO.getPax().equals(
						"PAX6")) {
					tarifaApartamento
							.setPax6(pTarifaApartamentoGestaoBloqueioVO
									.getValor());
				} else if (pTarifaApartamentoGestaoBloqueioVO.getPax().equals(
						"PAX7")) {
					tarifaApartamento
							.setPax7(pTarifaApartamentoGestaoBloqueioVO
									.getValor());

				}

				if (alterarTarifaApto) {
					manager.merge(tarifaApartamento);
				} else {
					manager.persist(tarifaApartamento);
				}
				empresaTarifa.setIdTarifa(idTarifa);

				EmpresaHotelEJB empresaHotel = new EmpresaHotelEJB();
				empresaHotel.setIdEmpresa(empresaTarifa.getIdEmpresa());
				empresaHotel.setIdHotel(empresaTarifa.getIdHotel());

				empresaTarifa.setTarifaEJB(tarifa);
				empresaTarifa.setEmpresaHotelEJB(empresaHotel);
				String sqlInsertEmpresaTarifa = " INSERT INTO EMPRESA_TARIFA(ID_EMPRESA, ID_TARIFA, ID_HOTEL) VALUES(?1,?2,?3)";

				EmpresaTarifaEJBPK ejbpk = new EmpresaTarifaEJBPK(
						empresaTarifa.getIdEmpresa(),
						empresaTarifa.getIdHotel(), empresaTarifa
								.getTarifaEJB().getIdTarifa());

				if (manager.find(EmpresaTarifaEJB.class, ejbpk) == null) {
					manager.createNativeQuery(sqlInsertEmpresaTarifa)
							.setParameter(1, empresaTarifa.getIdEmpresa())
							.setParameter(2, empresaTarifa.getIdTarifa())
							.setParameter(3, empresaTarifa.getIdHotel())
							.executeUpdate();
				}
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}

	public List<QuantidadeAptoGestaoBloqueioVO> obterGridQtdAptoBloqTipo(
			ReservaVO paramReservaVO) throws MozartSessionException {

		int i = 0;
		List<QuantidadeAptoGestaoBloqueioVO> listaRetorno = new Vector<QuantidadeAptoGestaoBloqueioVO>();
		String sql = QUERY_OBTER_QTD_APTO_BLOQ_POR_TIPO;

		Query q = manager.createNativeQuery(sql);

		String dtEntrada = MozartUtil.format(paramReservaVO.getBcDataEntrada(),
				"dd/MM/yyyy");
		String dtSaida = MozartUtil.format(paramReservaVO.getBcDataSaida(),
				"dd/MM/yyyy");

		q.setParameter(++i, paramReservaVO.getBcIdReserva());
		q.setParameter(++i, dtEntrada);
		q.setParameter(++i, dtSaida);
		q.setParameter(++i, paramReservaVO.getBcIdHotel());
		q.setParameter(++i, paramReservaVO.getBcIdReserva());
		List<Object[]> vec = q.getResultList();

		for (Object[] obj : vec) {
			QuantidadeAptoGestaoBloqueioVO vo = new QuantidadeAptoGestaoBloqueioVO();
			vo.setDados(obj);
			listaRetorno.add(vo);

		}

		return listaRetorno;
	}

	public List<DisponibilidadeAptoGestaoBloqueioVO> obterGridDisponibilidadeAptoBloq(
			ReservaVO paramReservaVO) throws MozartSessionException {
		int i = 0;
		List<DisponibilidadeAptoGestaoBloqueioVO> listaRetorno = new Vector<DisponibilidadeAptoGestaoBloqueioVO>();
		String sql = QUERY_OBTER_QTD_APTO_RESERVADO_BLOQ_POR_RESERVA;
		sql = " SELECT " + " TMP.DATA, " + " SUM(TMP.RESERVADOS) RESERVADOS, "
				+ " TMP.ID_RESERVADOS FROM  (" + sql + " ) TMP "
				+ " GROUP BY TMP.DATA," + " TMP.ID_RESERVADOS "
				+ " ORDER BY DATA," + " ID_RESERVADOS ";
		Query q = manager.createNativeQuery(sql);

		q.setParameter(++i, paramReservaVO.getBcIdHotel());
		q.setParameter(++i, paramReservaVO.getBcIdReserva());
		q.setParameter(++i, paramReservaVO.getBcDataEntrada());
		q.setParameter(++i, paramReservaVO.getBcDataSaida());
		q.setParameter(++i, paramReservaVO.getBcDataEntrada());
		q.setParameter(++i, paramReservaVO.getBcDataEntrada());
		q.setParameter(++i, paramReservaVO.getBcDataSaida());
		q.setParameter(++i, paramReservaVO.getBcDataSaida());
		List<Object[]> vec = q.getResultList();

		for (Object[] obj : vec) {
			DisponibilidadeAptoGestaoBloqueioVO vo = new DisponibilidadeAptoGestaoBloqueioVO();
			vo.setDados(obj);
			listaRetorno.add(vo);

		}

		return listaRetorno;
	}

	public void salvarQtdAptoBloqueio(
			QuantidadeAptoGestaoBloqueioVO pQuantidadeAptoGestaoBloqueioVO)
			throws MozartSessionException {

		Query q = manager
				.createNamedQuery("ReservaApartamentoDiariaEJB.findByIdHotelIdReservaData");
		q.setParameter("idHotel",
				pQuantidadeAptoGestaoBloqueioVO.getIdHoteis()[0]);
		q.setParameter("idReserva",
				pQuantidadeAptoGestaoBloqueioVO.getIdReserva());
		q.setParameter("data", new Timestamp(pQuantidadeAptoGestaoBloqueioVO
				.getData().getTime()));

		int countRegistros = q.getResultList().size();

		q = manager.createNamedQuery("TipoApartamentoEJB.findByFantasia");
		q.setParameter(1, pQuantidadeAptoGestaoBloqueioVO.getIdHoteis()[0]);
		q.setParameter(2, pQuantidadeAptoGestaoBloqueioVO.getDsFantasia());

		TipoApartamentoEJB tipoApartamentoEJB = (TipoApartamentoEJB) q
				.getResultList().get(0);

		pQuantidadeAptoGestaoBloqueioVO.setIdApartamento(tipoApartamentoEJB
				.getIdTipoApartamento());

		q = manager
				.createNamedQuery("ReservaApartamentoEJB.findByIdReservaHotelTpApto");
		q.setParameter("idReserva",
				pQuantidadeAptoGestaoBloqueioVO.getIdReserva())
				.setParameter("idHotel",
						pQuantidadeAptoGestaoBloqueioVO.getIdHoteis()[0])
				.setParameter("idTipoApartamento",
						pQuantidadeAptoGestaoBloqueioVO.getIdApartamento());

		ReservaApartamentoEJB reservaApartamentoAux = (ReservaApartamentoEJB) q
				.getResultList().get(0);

		GregorianCalendar dataInAux = new GregorianCalendar();
		dataInAux.setTime(pQuantidadeAptoGestaoBloqueioVO.getData());
		GregorianCalendar dataOutAux = new GregorianCalendar();
		dataOutAux.setTime(pQuantidadeAptoGestaoBloqueioVO.getData());
		dataOutAux.add(Calendar.DAY_OF_MONTH, 1);

		int dif;
		if (countRegistros < pQuantidadeAptoGestaoBloqueioVO.getValor()) {
			dif = pQuantidadeAptoGestaoBloqueioVO.getValor().intValue()
					- countRegistros;
			while (dif != 0) {
				Long idReservaApto = obterNextVal();
				manager.createNativeQuery(INSERT_RESERVA_APARTAMENTO)
						.setParameter(1, idReservaApto)
						.setParameter(2,
								tipoApartamentoEJB.getIdTipoApartamento())
						.setParameter(3,
								pQuantidadeAptoGestaoBloqueioVO.getIdReserva())
						.setParameter(4, new Long(1L))
						.setParameter(5, 0L)
						.setParameter(6, 1L)
						.setParameter(7, reservaApartamentoAux.getTarifa())
						.setParameter(8,
								reservaApartamentoAux.getJustificaTarifa())
						.setParameter(9,
								reservaApartamentoAux.getIdCentralReservas())
						.setParameter(10, reservaApartamentoAux.getIdHotel())
						.setParameter(11,
								reservaApartamentoAux.getTotalTarifa())
						.setParameter(12, reservaApartamentoAux.getAdicional())
						.setParameter(13,
								reservaApartamentoAux.getQtdeCrianca())
						.setParameter(14, null)
						.setParameter(15, reservaApartamentoAux.getMaster())
						.setParameter(16,
								reservaApartamentoAux.getValorPensao())
						.setParameter(17,
								new Timestamp(dataInAux.getTime().getTime()))
						.setParameter(18,
								new Timestamp(dataOutAux.getTime().getTime()))
						.setParameter(19, null)
						.setParameter(20, null)
						.setParameter(21, null)
						.setParameter(22, null)
						.setParameter(23, null)
						.setParameter(24,
								reservaApartamentoAux.getTarifaManual())
						.setParameter(25, reservaApartamentoAux.getDataManual())
						.setParameter(26,
								reservaApartamentoAux.getIdTipoDiaria())
						.executeUpdate();

				this.manager
						.createNativeQuery(INSERT_RESERVA_APARTAMENTO_DIARIA)
						.setParameter(1,
								new Timestamp(dataInAux.getTime().getTime()))
						.setParameter(2, reservaApartamentoAux.getIdHotel())
						.setParameter(3,
								pQuantidadeAptoGestaoBloqueioVO.getIdReserva())
						.setParameter(4, idReservaApto)
						.setParameter(5, reservaApartamentoAux.getTarifa())
						.setParameter(6,
								reservaApartamentoAux.getJustificaTarifa())
						.setParameter(7, 1L).setParameter(8, obterNextVal())
						.executeUpdate();

				--dif;
			}

		} else if (countRegistros > pQuantidadeAptoGestaoBloqueioVO.getValor()) {
			dif = countRegistros
					- pQuantidadeAptoGestaoBloqueioVO.getValor().intValue();

			String sql;

			sql = " SELECT " + " ID_RESERVA_APARTAMENTO " + " FROM "
					+ " RESERVA_APARTAMENTO " + " WHERE " + " ID_HOTEL = ?1 "
					+ " AND ID_RESERVA = ?2 "
					+ " AND ID_TIPO_APARTAMENTO = ?3 ";

			Vector<Object> idsReservaApto = new Vector<Object>();
			idsReservaApto
					.addAll(manager
							.createNativeQuery(
									sql
											+ " AND DATA_ENTRADA = ?4 "
											+ " AND DATA_SAIDA = DATA_ENTRADA + 1 AND ROWNUM <= ?5")
							.setParameter(
									1,
									pQuantidadeAptoGestaoBloqueioVO
											.getIdHoteis()[0])
							.setParameter(
									2,
									pQuantidadeAptoGestaoBloqueioVO
											.getIdReserva())
							.setParameter(
									3,
									pQuantidadeAptoGestaoBloqueioVO
											.getIdApartamento())
							.setParameter(
									4,
									MozartUtil.format(
											pQuantidadeAptoGestaoBloqueioVO
													.getData(), "dd/MM/yyyy"))
							.setParameter(5, dif).getResultList());

			if (idsReservaApto.size() < dif) {
				idsReservaApto
						.addAll(manager
								.createNativeQuery(
										sql
												+ " AND DATA_ENTRADA <= ?4 "
												+ " AND DATA_SAIDA > to_date(?5) +1 "
												+ " AND ROWNUM <= ?6 ")
								.setParameter(
										1,
										pQuantidadeAptoGestaoBloqueioVO
												.getIdHoteis()[0])
								.setParameter(
										2,
										pQuantidadeAptoGestaoBloqueioVO
												.getIdReserva())
								.setParameter(
										3,
										pQuantidadeAptoGestaoBloqueioVO
												.getIdApartamento())
								.setParameter(
										4,
										MozartUtil.format(
												pQuantidadeAptoGestaoBloqueioVO
														.getData(),
												"dd/MM/yyyy"))
								.setParameter(
										5,
										MozartUtil.format(
												pQuantidadeAptoGestaoBloqueioVO
														.getData(),
												"dd/MM/yyyy"))
								.setParameter(6, dif - idsReservaApto.size())
								.getResultList());
			}

			String idReservaAptoIn = "";
			String conector = "";
			for (Object idReservaApto : idsReservaApto) {
				idReservaAptoIn = idReservaAptoIn + conector + idReservaApto;
				conector = ", ";
			}

			sql = DELETE_RESERVA_APARTAMENTO_DIARIA
					+ " AND ID_HOTEL = ?2 AND DATA = ?3";
			if (!idReservaAptoIn.equals("")) {
				sql = sql + " AND ID_RESERVA_APARTAMENTO IN( "
						+ idReservaAptoIn + " ) ";
			}
			manager.createNativeQuery(sql)
					.setParameter(1,
							pQuantidadeAptoGestaoBloqueioVO.getIdReserva())
					.setParameter(2,
							pQuantidadeAptoGestaoBloqueioVO.getIdHoteis()[0])
					.setParameter(
							3,
							MozartUtil.format(
									pQuantidadeAptoGestaoBloqueioVO.getData(),
									"dd/MM/yyyy")).executeUpdate();

			sql = DELETE_RESERVA_APARTAMENTO
					+ "  AND DATA_ENTRADA = ?2 AND DATA_SAIDA = DATA_ENTRADA + 1 ";
			if (!idReservaAptoIn.equals("")) {
				sql = sql + " AND ID_RESERVA_APARTAMENTO IN( "
						+ idReservaAptoIn + " ) ";
			}

			this.manager
					.createNativeQuery(sql)
					.setParameter(1,
							pQuantidadeAptoGestaoBloqueioVO.getIdReserva())
					.setParameter(
							2,
							MozartUtil.format(
									pQuantidadeAptoGestaoBloqueioVO.getData(),
									"dd/MM/yyyy")).executeUpdate();
		}

	}

	public List<DisponibilidadeGdsVO> obterDisponibilidadeGDS(
			DisponibilidadeGdsVO vo) throws MozartSessionException {
		try {
			String dtEntrada = MozartUtil.format(vo.getDataInicio(),
					"dd/MM/yyyy");
			String dtSaida = MozartUtil.format(vo.getDataFim(), "dd/MM/yyyy");
			
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(vo.getDataInicio());
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(vo.getDataFim());

			int diffYear = endCalendar.get(Calendar.YEAR)
					- startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH)
					- startCalendar.get(Calendar.MONTH);

			if (diffMonth > 4) {
				startCalendar.add(Calendar.MONTH, 4);
				dtSaida = MozartUtil.format(startCalendar.getTime(),
						"dd/MM/yyyy");
			}

			List<?> lista = this.manager
					.createNativeQuery(QUERY_OBTER_DISPONIBILIDADE_GDS)
					.setParameter(1, dtEntrada).setParameter(2, dtSaida)
					.setParameter(3, vo.getIdHotel())
					.setParameter(4, vo.getIdGds()).getResultList();

			List<DisponibilidadeGdsVO> listaDisponibilidade = new ArrayList<DisponibilidadeGdsVO>();
			DisponibilidadeGdsVO disponibilidade = null;
			for (Object linhas : lista) {
				Object[] linha = (Object[]) linhas;
				disponibilidade = new DisponibilidadeGdsVO();
				disponibilidade.setDataDisponibilidade((Date) linha[0]);
				disponibilidade.setTipoQuarto((String) linha[1]);
				disponibilidade.setTotalDisponibilidade(((BigDecimal) linha[2])
						.intValue());

				listaDisponibilidade.add(disponibilidade);
			}
			return listaDisponibilidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<DisponibilidadeGdsVO> obterDisponibilidadeGDSTotal(
			DisponibilidadeGdsVO vo) throws MozartSessionException {
		try {
			String dtEntrada = MozartUtil.format(vo.getDataInicio(),
					"dd/MM/yyyy");
			String dtSaida = MozartUtil.format(vo.getDataFim(), "dd/MM/yyyy");

			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(vo.getDataInicio());
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(vo.getDataFim());

			int diffYear = endCalendar.get(Calendar.YEAR)
					- startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH)
					- startCalendar.get(Calendar.MONTH);

			if (diffMonth > 4) {
				startCalendar.add(Calendar.MONTH, 4);
				dtSaida = MozartUtil.format(startCalendar.getTime(),
						"dd/MM/yyyy");
			}

			List<?> lista = this.manager
					.createNativeQuery(QUERY_OBTER_DISPONIBILIDADE_GDS_TOTAL)
					.setParameter(1, dtEntrada).setParameter(2, dtSaida)
					.setParameter(3, vo.getIdHotel()).setParameter(4, "N")
					.getResultList();

			List<DisponibilidadeGdsVO> listaDisponibilidade = new ArrayList<DisponibilidadeGdsVO>();
			DisponibilidadeGdsVO disponibilidade = null;
			for (Object linhas : lista) {
				Object[] linha = (Object[]) linhas;
				disponibilidade = new DisponibilidadeGdsVO();
				disponibilidade.setDataDisponibilidade((Date) linha[0]);
				disponibilidade.setTipoQuarto((String) linha[1]);
				disponibilidade.setTotalDisponibilidade(((BigDecimal) linha[2])
						.intValue());

				listaDisponibilidade.add(disponibilidade);
			}
			return listaDisponibilidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public HotelEJB obterHotelPorCodigo(String codigoHotel)
			throws MozartSessionException {
		try {
			return (HotelEJB) this.manager
					.createNativeQuery(
							"select ho.* from hotel ho, controla_data cd where ho.id_reserva = ",
							HotelEJB.class)
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, codigoHotel).getSingleResult();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public BloqueioVO obterBloqueio(Long idHotel, Long idEmpresa,
			Date dataInicio, Date dataFim) throws MozartSessionException {
		try {
			String dtEntrada = MozartUtil.format(dataInicio, "dd/MM/yyyy");
			String dtSaida = MozartUtil.format(dataFim, "dd/MM/yyyy");

			StringBuilder sql = new StringBuilder(" ");
			sql.append(" SELECT ");
			sql.append(" 	RE.DEAD_LINE, RE.CALCULA_ISS, RE.CALCULA_TAXA, RE.CALCULA_ROOMTAX, ");
			sql.append(" 	RE.CONTATO, RE.TELEFONE_CONTATO, RE.CORTESIA, RE.GRUPO, ");
			sql.append(" 	RE.ID_CIDADE_CONTATO, RE.ID_RESERVA, RE.GARANTENOSHOW, RE.TIPO_PENSAO ");
			sql.append(" FROM ");
			sql.append(" 	RESERVA RE ");
			sql.append(" WHERE ");
			sql.append(" 	RE.BLOQUEIO = 'S' AND RE.APAGADA = 'N'  ");
			sql.append(" 	AND ( ");
			sql.append("			(RE.DATA_ENTRADA >= TO_DATE(?1,'DD/MM/YYYY') AND RE.DATA_SAIDA <= TO_DATE(?2,'DD/MM/YYYY')) ");
			sql.append(" 		OR (RE.DATA_ENTRADA <=  TO_DATE(?3,'DD/MM/YYYY') AND RE.DATA_SAIDA >=  TO_DATE(?4,'DD/MM/YYYY') )  ");
			sql.append(" 		OR (RE.DATA_ENTRADA <= TO_DATE(?5,'DD/MM/YYYY') AND RE.DATA_SAIDA >= TO_DATE(?6,'DD/MM/YYYY'))  ");
			sql.append(" 	)  ");

			BloqueioVO resultado = null;

			if (idEmpresa != null && idEmpresa > 0) {
				sql.append(" AND RE.ID_EMPRESA = ").append(idEmpresa);
			}
			if (idHotel != null && idHotel > 0) {
				sql.append(" AND RE.ID_HOTEL = ").append(idHotel);
			}

			List<?> lista = this.manager.createNativeQuery(sql.toString())
					.setParameter(1, dtEntrada).setParameter(2, dtSaida)
					.setParameter(3, dtEntrada).setParameter(4, dtEntrada)
					.setParameter(5, dtSaida).setParameter(6, dtSaida)
					.getResultList();
			
			for (Object linhas : lista) {
				int param = 0;
				Object[] linha = (Object[]) linhas;
				resultado = new BloqueioVO();
				Object param0 = linha[param++];
				resultado.setBcDeadLine(param0 != null ? ((BigDecimal) param0)
						.longValue() : 0);
				resultado.setBcCalculaIss((String) linha[param++]);
				resultado.setBcCalculaTaxa((String) linha[param++]);
				resultado.setBcCalculaRoomTax((String) linha[param++]);
				resultado.setBcContato((String) linha[param++]);
				resultado.setBcTelefoneContato((String) linha[param++]);
				resultado.setBcCortesia((String) linha[param++]);
				resultado.setBcGrupo((String) linha[param++]);
				resultado.setBcIdCidadeContato(((BigDecimal) linha[param++])
						.longValue());
				resultado.setBcIdReserva(((BigDecimal) linha[param++])
						.longValue());
				resultado.setBcGaranteNoShow(((String) linha[param++]));
				resultado.setBcTipoPensao(((String) linha[param++]));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public GdsCanalVO obterGdsCanal(Long idGds, Long idEmpresa, Long idHotel,
			String codigo) throws MozartSessionException {

		StringBuilder sql = new StringBuilder(
				" SELECT ID_GDS_CANAL, ID_GDS, ID_EMPRESA, ID_HOTEL, CODIGO, ATIVO from GDS_CANAL GDS WHERE ATIVO = 'S' ");

		if (idGds != null && idGds > 0) {
			sql.append(" AND ID_GDS = ").append(idGds);
		}
		if (idEmpresa != null && idEmpresa > 0) {
			sql.append(" AND ID_EMPRESA = ").append(idEmpresa);
		}
		if (idHotel != null && idHotel > 0) {
			sql.append(" AND ID_HOTEL = ").append(idHotel);
		}
		if (codigo != null && !codigo.isEmpty()) {
			sql.append(" AND CODIGO = '").append(codigo).append("'");
		}

		List<?> lista = this.manager.createNativeQuery(sql.toString())
				.getResultList();
		GdsCanalVO canal = null;
		
		for (Object linhas : lista) {
			int param = 0;
			canal = new GdsCanalVO();
			Object[] linha = (Object[]) linhas;
			canal.setIdGdsCanal(((BigDecimal) linha[param++]).longValue());
			canal.setIdGds(((BigDecimal) linha[param++]).longValue());
			canal.setIdEmpresa(((BigDecimal) linha[param++]).longValue());
			canal.setIdHotel(((BigDecimal) linha[param++]).longValue());
			canal.setCodigo((String) linha[param++]);
			canal.setAtivo((String) linha[param++]);
		}
		// if(canal == null){
		// throw new
		// MozartSessionException("Nenhum registro encotrado em GDS_CANAL: ID_GDS = ["
		// + idGds + "], ID_HOTEL = [" + idHotel + "], CODIGO = [" + codigo +
		// "] ");
		// }
		return canal;
	}

	public BloqueioVO obterDadosGeraisEmpresa(Long idRedeHotel, Long idHotel)
			throws MozartSessionException {

		StringBuilder sql = new StringBuilder(
				" SELECT EH.ID_EMPRESA, EH.TIPO_PENSAO, EH.CALCULA_ISS, EH.CALCULA_ROOMTAX, EH.CALCULA_TAXA,  ER.CONTATO, ER.TELEFONE, ER.ID_CIDADE, ER.DEAD_LINE, ER.NO_SHOW FROM EMPRESA_HOTEL EH JOIN EMPRESA_REDE ER ON (EH.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND EH.ID_EMPRESA = ER.ID_EMPRESA) WHERE ");
		sql.append(" ER.PARTICULAR = 'S' ");
		sql.append(" AND EH.ID_REDE_HOTEL = ").append(idRedeHotel);
		sql.append(" AND EH.ID_HOTEL = ").append(idHotel);

		List<?> lista = this.manager.createNativeQuery(sql.toString())
				.getResultList();
		BloqueioVO dados = null;
		
		for (Object linhas : lista) {
			int param = 0;
			dados = new BloqueioVO();
			Object[] linha = (Object[]) linhas;
			dados.setBcIdEmpresa(((BigDecimal) linha[param++]).longValue());
			dados.setBcTipoPensao((String) linha[param++]);
			dados.setBcCalculaIss((String) linha[param++]);
			dados.setBcCalculaRoomTax((String) linha[param++]);
			dados.setBcCalculaTaxa((String) linha[param++]);
			dados.setBcContato((String) linha[param++]);
			dados.setBcTelefoneContato((String) linha[param++]);
			dados.setBcIdCidadeContato(((BigDecimal) linha[param++])
					.longValue());
			dados.setBcDeadLine(((BigDecimal) linha[param++]).longValue());
			dados.setBcGaranteNoShow((String) linha[param++]);
			dados.setBcCortesia("N");
		}
		if (dados == null) {
			throw new MozartSessionException(
					"Nenhum cliente particular encontrado para obter dados gerais: ID_REDE_HOTEL = ["
							+ idRedeHotel + "], ID_HOTEL = [" + idHotel + "] ");
		}
		return dados;
	}

	public BloqueioVO obterDadosGeraisEmpresaNaoParticular(Long idEmpresa,
			Long idRedeHotel, Long idHotel) throws MozartSessionException {
		StringBuilder sql = new StringBuilder(
				" SELECT EH.ID_EMPRESA, EH.TIPO_PENSAO, EH.CALCULA_ISS, EH.CALCULA_ROOMTAX, EH.CALCULA_TAXA, ER.CONTATO, ER.TELEFONE, ER.ID_CIDADE, ER.DEAD_LINE, ER.NO_SHOW, FAX, EMAIL, EH.CALCULA_SEGURO FROM EMPRESA_HOTEL EH JOIN EMPRESA_REDE ER ON (EH.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND EH.ID_EMPRESA = ER.ID_EMPRESA) WHERE ");
		sql.append(" EH.ID_REDE_HOTEL = ").append(idRedeHotel);
		sql.append(" AND EH.ID_HOTEL = ").append(idHotel);
		sql.append(" AND ER.ID_EMPRESA = ").append(idEmpresa);
		List lista = this.manager.createNativeQuery(sql.toString())
				.getResultList();
		BloqueioVO dados = null;
		
		for (Object linhas : lista) {
			int param = 0;
			dados = new BloqueioVO();
			Object[] linha = (Object[]) linhas;
			dados.setBcIdEmpresa(Long.valueOf(((BigDecimal) linha[param++])
					.longValue()));
			dados.setBcTipoPensao((String) linha[param++]);
			dados.setBcCalculaIss((String) linha[param++]);
			dados.setBcCalculaRoomTax((String) linha[param++]);
			dados.setBcCalculaTaxa((String) linha[param++]);
			dados.setBcContato((String) linha[param++]);
			dados.setBcTelefoneContato((String) linha[param++]);
			dados.setBcIdCidadeContato(Long
					.valueOf(((BigDecimal) linha[param++]).longValue()));
			dados.setBcDeadLine(Long.valueOf(((BigDecimal) linha[param++])
					.longValue()));
			dados.setBcGaranteNoShow((String) linha[param++]);
			dados.setBcFaxContato((String) linha[param++]);
			dados.setBcEmailContato((String) linha[param++]);
			dados.setBcCortesia("N");
			dados.setBcCalculaSeguro((String) linha[param++]);
		}
		if (dados == null) {
			throw new MozartSessionException(
					"Nenhum registro encotrado para obter dados gerais: ID_REDE_HOTEL = ["
							+ idRedeHotel + "], ID_HOTEL = [" + idHotel + "] ");
		}
		return dados;
	}

	public Double obterComissao(long idEmpresa, long idHotel)
			throws MozartSessionException {
		BigDecimal bigComissao = ((BigDecimal) this.manager
				.createNativeQuery(
						"SELECT COMISSAO FROM EMPRESA_HOTEL WHERE ID_EMPRESA = ?1 AND ID_HOTEL = ?2")
				.setParameter(1, idEmpresa).setParameter(2, idHotel)
				.getSingleResult());

		return bigComissao != null ? bigComissao.doubleValue() : 0;
	}

	public String obterTipoPagamentoPorHotel(long idHotel)
			throws MozartSessionException {
		return (String) this.manager
				.createNativeQuery(
						"SELECT TIPO_PAGAMENTO FROM POLITICA_HOTEL WHERE ID_HOTEL = ?1")
				.setParameter(1, idHotel).getSingleResult();
	}

	public String obterTipoDisponibilidade(Long idGds)
			throws MozartSessionException {

		StringBuilder sql = new StringBuilder(
				" SELECT DISPONIBILIDADE_BLOQUEIO from GDS  WHERE ATIVO = 'S' ");

		if (idGds != null && idGds > 0) {
			sql.append(" AND ID_GDS = ").append(idGds);
		}
		String tipoDisponibilidade = (String) this.manager.createNativeQuery(
				sql.toString()).getSingleResult();
		if (tipoDisponibilidade == null) {
			throw new MozartSessionException(
					"Nenhum registro encotrado em GDS_CANAL: ID_GDS = ["
							+ idGds + "] ");

		}
		return tipoDisponibilidade;
	}

	public List<ReservaMidiaEJB> obterListaReservaMidia()
			throws MozartSessionException {
		List<ReservaMidiaEJB> lista = new ArrayList<ReservaMidiaEJB>();

		lista = this.manager.createNamedQuery("ReservaMidiaEJB.findAll")
				.getResultList();

		return lista;
	}

	public List obterComboApartamentoCofan(Long pIdHotel)
			throws MozartSessionException {

		StringBuilder sql = new StringBuilder(
				" SELECT CK.ID_CHECKIN, AP.NUM_APARTAMENTO ||' - ' || ER.NOME_FANTASIA DS, EGL.QUEM_PAGA, CK.ID_APARTAMENTO  "
						+ " FROM CHECKIN CK "
						+ " JOIN APARTAMENTO AP ON (CK.ID_APARTAMENTO = AP.ID_APARTAMENTO) "
						+ " JOIN HOTEL H ON (CK.ID_HOTEL = H.ID_HOTEL) "
						+ " JOIN EMPRESA_REDE ER ON (CK.ID_EMPRESA = ER.ID_EMPRESA AND H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL) "
						+ " JOIN EMPRESA_GRUPO_LANCAMENTO EGL ON (CK.ID_EMPRESA = EGL.ID_EMPRESA AND CK.ID_HOTEL = EGL.ID_HOTEL) "
						+ " WHERE CK.ID_HOTEL = ?1 "
						+ " AND CK.CHECKOUT = 'N' "
						+ " AND AP.COFAN = 'S' "
						+ " AND EGL.ID_IDENTIFICA_LANCAMENTO = 1 "
						+ " ORDER BY AP.NUM_APARTAMENTO ");

		List l = this.manager.createNativeQuery(sql.toString())
				.setParameter(1, pIdHotel).getResultList();

		return l;
	}

	public HotelVO obterEmailsCentralReserva(Long pIdHotel) throws MozartSessionException{
		
		StringBuilder sql = new StringBuilder(" SELECT HT.NOME_FANTASIA, HT.EMAIL,  CR.EMAIL "); 
		sql.append(" FROM HOTEL HT ");
		sql.append(" JOIN CENTRAL_RESERVAS_HOTEL CRH ON (CRH.ID_HOTEL = HT.ID_HOTEL) ");
		sql.append(" JOIN CENTRAL_RESERVAS CR ON  (CRH.ID_CENTRAL_RESERVAS = CR.ID_CENTRAL_RESERVAS) ");
		sql.append(" WHERE HT.ID_HOTEL = ?1 ");
		sql.append(" AND CR.ATIVO = 'S'");
		sql.append(" AND CRH.CRS_PROPRIA = 'S' ");
		
		List l = this.manager.createNativeQuery(sql.toString()).setParameter(1, pIdHotel).getResultList();
		HotelVO hotel = new HotelVO();
		
		for(Object dados : l){
			Object[] linha = (Object[])dados;
			hotel.setNomeFantasia((String)linha[0]);
			hotel.setEmail(linha[1] + ";" + linha[2]);
		}
		
		return hotel;
	}
	
	public boolean existeCheckinAtivo(
			ReservaVO reservaVO) throws MozartSessionException {
		try {
			try {
				String qry = "SELECT COUNT(*) FROM CHECKIN WHERE ID_RESERVA = "
						+ reservaVO.getBcIdReserva();
				List result = this.manager.createNativeQuery(qry).getResultList();
				
				return ((BigDecimal) result.get(0)).intValue() > 0;
			} catch (Exception ex) {
				throw new MozartSessionException(ex.getMessage());
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

}