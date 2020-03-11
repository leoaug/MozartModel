package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.Position.Bias;

import org.apache.log4j.Logger;

import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.ApartamentoEJBPK;
import com.mozart.model.ejb.entity.CheckinEJB;
import com.mozart.model.ejb.entity.CheckinGrupoLancamentoEJB;
import com.mozart.model.ejb.entity.CheckinTipoLancamentoEJB;
import com.mozart.model.ejb.entity.CidadeEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaSeguradoraEJB;
import com.mozart.model.ejb.entity.HospedeEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.IdentificaLancamentoEJB;
import com.mozart.model.ejb.entity.MoedaEJB;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.ejb.entity.MovimentoObjetoEJB;
import com.mozart.model.ejb.entity.PontoVendaEJB;
import com.mozart.model.ejb.entity.ReservaApartamentoDiariaEJB;
import com.mozart.model.ejb.entity.ReservaApartamentoEJB;
import com.mozart.model.ejb.entity.ReservaEJB;
import com.mozart.model.ejb.entity.ReservaGrupoLancamentoEJB;
import com.mozart.model.ejb.entity.RoomListEJB;
import com.mozart.model.ejb.entity.StatusNotaEJB;
import com.mozart.model.ejb.entity.TipoApartamentoEJB;
import com.mozart.model.ejb.entity.TipoDiariaEJB;
import com.mozart.model.ejb.entity.TipoHospedeEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJBPK;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.ejb.entity.ValorDolarEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ApartamentoVO;
import com.mozart.model.vo.ApiGeralVO;
import com.mozart.model.vo.ChartApartamentoVO;
import com.mozart.model.vo.CheckinVO;
import com.mozart.model.vo.ContaCorrenteGeralVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.MovAptoPgtoAntecipadoVO;
import com.mozart.model.vo.MozartVO;
import com.mozart.model.vo.ProcurarHospedeVO;
import com.mozart.model.vo.RoomListVO;
import com.mozart.model.vo.StatusNotaVO;

@Stateless(name = "CheckinSession")
@SuppressWarnings("unchecked")
public class CheckinSessionBean implements CheckinSession {
	@PersistenceContext(unitName = "MozartModel")
	protected EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoApartamentoEJB> obterTipoApartamento(
			TipoApartamentoEJB pTipoApartamentoEJB)
			throws MozartSessionException {
		if ((MozartUtil.isNull(pTipoApartamentoEJB))
				|| (MozartUtil.isNull(pTipoApartamentoEJB.getIdHotel()))) {
			throw new MozartSessionException("Informe o hotel");
		}
		return

		this.manager.createNamedQuery("TipoApartamentoEJB.findAll")
				.setParameter(1, pTipoApartamentoEJB.getIdHotel())
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CheckinVO> pesquisarCheckin(CheckinVO pCheckinVO)
			throws MozartSessionException {
		try {
			String sql = "";
			String orderBy = " order by NUM_APARTAMENTO ";
			if ("1".equals(pCheckinVO.getFiltroTipoPesquisa())) {
				sql = QUERY_CHECKIN_DIA;
				orderBy = " order by DATA_ENTRADA ";
			} else if ("2".equals(pCheckinVO.getFiltroTipoPesquisa())) {
				sql = QUERY_HOSPEDE_DIA;
			} else if ("3".equals(pCheckinVO.getFiltroTipoPesquisa())) {
				sql = QUERY_APTO_EXECUTADO;
			} else if ("4".equals(pCheckinVO.getFiltroTipoPesquisa())) {
				sql = QUERY_HOSPEDE_EXECUTADO;
			} else if ("5".equals(pCheckinVO.getFiltroTipoPesquisa())) {
				sql = QUERY_PRE_CHECKIN;
			} else if ("6".equals(pCheckinVO.getFiltroTipoPesquisa())) {
				sql = QUERY_APTO_HISTORICO;
				orderBy = " order by NUM_APARTAMENTO, data_saida desc ";
			} else {
				return Collections.EMPTY_LIST;
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroApto()
					.getTipoIntervalo())) {
				sql = sql + " and num_apartamento "
						+ pCheckinVO.getFiltroApto();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroHospede()
					.getTipoIntervalo())) {
				sql = sql + " and UPPER(nome_hospede)  "
						+ pCheckinVO.getFiltroHospede();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroCheckin()
					.getTipoIntervalo())) {
				sql = sql + " and ID_CHECKIN " + pCheckinVO.getFiltroCheckin();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroReserva()
					.getTipoIntervalo())) {
				sql = sql + " and ID_RESERVA " + pCheckinVO.getFiltroReserva();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroConfirmada()
					.getTipoIntervalo())) {
				sql = sql + " and CONFIRMA " + pCheckinVO.getFiltroConfirmada();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroDataEntrada()
					.getTipoIntervalo())) {
				sql = sql + " and TRUNC(DATA_ENTRADA) "
						+ pCheckinVO.getFiltroDataEntrada();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroDataSaida()
					.getTipoIntervalo())) {
				sql = sql + " and TRUNC(DATA_SAIDA) "
						+ pCheckinVO.getFiltroDataSaida();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroEmpresa()
					.getTipoIntervalo())) {
				sql = sql + " and UPPER(NOME_FANTASIA) "
						+ pCheckinVO.getFiltroEmpresa();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroGrupo()
					.getTipoIntervalo())) {
				sql = sql + " and UPPER(NOME_GRUPO) "
						+ pCheckinVO.getFiltroGrupo();
			}
			if (!MozartUtil
					.isNull(pCheckinVO.getFiltroObs().getTipoIntervalo())) {
				sql = sql + " and upper(OBSERVACAO) "
						+ pCheckinVO.getFiltroObs();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroPensao()
					.getTipoIntervalo())) {
				sql = sql + " and UPPER(TIPO_PENSAO) "
						+ pCheckinVO.getFiltroPensao();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroQtdeApto()
					.getTipoIntervalo())) {
				sql = sql + " and QTDE_APART " + pCheckinVO.getFiltroQtdeApto();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroQtdePax()
					.getTipoIntervalo())) {
				sql = sql + " and QTDE_PAX " + pCheckinVO.getFiltroQtdePax();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroCofan()
					.getTipoIntervalo())) {
				sql = sql + " and COFAN " + pCheckinVO.getFiltroCofan();
			}
			if (!MozartUtil.isNull(pCheckinVO.getFiltroCheckinIncompleto()
					.getTipoIntervalo())) {
				sql = sql
						+ " and num_apartamento in ("
						+ pCheckinVO.getFiltroCheckinIncompleto()
								.getTipoIntervalo() + ") ";
			}
			String hoteis = null;
			if (!MozartUtil.isNull(pCheckinVO.getIdHoteis())) {
				hoteis = ";";
				for (Long id : pCheckinVO.getIdHoteis()) {
					hoteis = hoteis + id + ";";
				}
			}
			sql = sql + orderBy;

			List lista = null;
			lista = this.manager.createNativeQuery(sql).setParameter(1, hoteis)
					.setParameter(2, hoteis).setParameter(3, hoteis)
					.getResultList();

			List<CheckinVO> resultado = new ArrayList<CheckinVO>();
			for (Object l : lista) {
				resultado.add(new CheckinVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ApartamentoEJB> pesquisarApartamento(ApartamentoEJB pApto, Boolean incluirSujo) {
		String sql = "select a from ApartamentoEJB a where a.idHotel = ?1 ";
		if (!MozartUtil.isNull(pApto.getCofan())) {
			sql = sql.concat(" and a.cofan = '" + pApto.getCofan() + "' ");
		}
		if (!MozartUtil.isNull(pApto.getStatus())) {
			sql = sql
					.concat(" and a.status like '" + pApto.getStatus() + "%' ");
			if ((!incluirSujo) && pApto.getStatus().equals("L")) {
				sql = sql.concat(" and a.status <> 'LS' ");
			}
		}
		if (!MozartUtil.isNull(pApto.getNumApartamento())) {
			sql = sql.concat(" and a.numApartamento = "
					+ pApto.getNumApartamento() + " ");
		}
		if (!MozartUtil.isNull(pApto.getIdApartamento())) {
			sql = sql.concat(" and a.idApartamento = "
					+ pApto.getIdApartamento() + " ");
		}
		if ((!MozartUtil.isNull(pApto.getTipoApartamentoEJB()))
				&& (!MozartUtil.isNull(pApto.getTipoApartamentoEJB()
						.getIdTipoApartamento()))) {
			sql = sql.concat(" and a.tipoApartamentoEJB.idTipoApartamento = "
					+ pApto.getTipoApartamentoEJB().getIdTipoApartamento()
					+ " ");
		}
		sql = sql
				.concat(" order by a.tipoApartamentoEJB.tipoApartamento, a.numApartamento, a.status ");
		
		return this.manager.createQuery(sql)
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, pApto.getIdHotel()).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<RoomListVO> pesquisarHospedeFNRH(RoomListEJB roomListEJB) {
		String sql = QRY_HOSPEDES_FNRH;
		sql = sql.concat(" AND R.APAGADA='N' AND R.BLOQUEIO='N' ");

		if (!MozartUtil.isNull( roomListEJB.getIdHotel() )) {
			sql = sql.concat(" and RA.ID_HOTEL = ?1 ");
		}
		if (!MozartUtil.isNull(roomListEJB.getDataEntrada() ) && !MozartUtil.isNull(roomListEJB.getDataSaida() )) {
			
			sql = sql.concat(" AND TRUNC(RA.DATA_ENTRADA) BETWEEN "
					+ " TO_DATE(?2,'DD/MM/YYYY') "
					+ " AND TO_DATE(?3,'DD/MM/YYYY') ");
		}

		sql= sql.concat(" ORDER BY RA.DATA_ENTRADA,  R.ID_RESERVA ASC ");
		List<Object[]> list = this.manager.createNativeQuery(sql)
				.setParameter(1, roomListEJB.getIdHotel())
				.setParameter(2, MozartUtil.format(roomListEJB.getDataEntrada()))
				.setParameter(3, MozartUtil.format(roomListEJB.getDataSaida()))
				.getResultList();
		
		List<RoomListVO> retorno = new ArrayList<RoomListVO>();
		
		for(Object[] o: list){
			RoomListVO r = new RoomListVO();
			
			r.setBcIdReserva(((BigDecimal) o[0]).longValue());
			r.setBcIdHospede(((BigDecimal) o[1]).longValue());
			r.setBcNomeHospede((String) o[2]);
			r.setBcDataCertificado((Timestamp) o[3]);
			
			retorno.add(r);
		}
		
		return retorno; 
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ApartamentoEJB> obterApartamento(ApartamentoEJB pApto) {
		return

		this.manager
				.createNamedQuery("ApartamentoEJB.findByTipo")
				.setParameter(1, pApto.getIdHotel())
				.setParameter(2,
						pApto.getTipoApartamentoEJB().getIdTipoApartamento())
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<HospedeEJB> pesquisarHospede(HospedeVO param) {
		return

		this.manager
				.createNativeQuery(
						"select * \nfrom hospede h\nwhere upper(h.nome_hospede ||' '||h.sobrenome_hospede) like '%'||upper(?1)||'%' and h.id_rede_hotel = ?2 \nORDER BY h.nome_hospede,  h.sobrenome_hospede",
						HospedeEJB.class)
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, param.getBcNomeHospede())
				.setParameter(2, param.getIdRedeHotel()).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CidadeEJB> pesquisarCidade(String valor) {
		return this.manager.createNamedQuery("CidadeEJB.findByName")
				.setParameter(1, "%" + valor.toUpperCase() + "%")
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public TipoLancamentoEJB obterTipoLancamentoByPK(TipoLancamentoEJBPK chave) {
		return (TipoLancamentoEJB) this.manager.find(TipoLancamentoEJB.class,
				chave);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoLancamentoEJB> pesquisarSubGrupoLancamento(
			TipoLancamentoEJB valor) {
		String query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.subGrupoLancamento <> '000' \n";
		if (!MozartUtil.isNull(valor.getGrupoLancamento())) {
			query = query
					.concat(" and o.identificaLancamento.receitaCheckout = '2' \n");
		} else {
			query = query
					.concat(" and o.identificaLancamento.idIdentificaLancamento <> 18 \n");
		}
		query = query
				.concat("order by o.grupoLancamento, o.subGrupoLancamento ");

		return this.manager.createQuery(query)
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, valor.getIdHotel()).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoLancamentoEJB> pesquisarTipoLancamento(
			TipoLancamentoEJB valor) {
		return

		this.manager.createNamedQuery("TipoLancamentoEJB.findByDespesaFixa")
				.setParameter(1, valor.getIdHotel()).getResultList();
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public HospedeEJB gravarHospede(HospedeEJB novoHospede)
			throws MozartSessionException {
		try {
			if (novoHospede.getIdRedeHotel() == null) {
				throw new MozartValidateException(
						"Você deve informar a Rede ou o Tipo do hóspede.");
			}
			TipoHospedeEJB tipoPadrao = new TipoHospedeEJB();
			System.out.println("Salvando novo Hospede com nome: "
					+ novoHospede.getNomeHospede());
			System.out.println("Salvando novo Hospede com sobrenome: "
					+ novoHospede.getSobrenomeHospede());
			tipoPadrao = (TipoHospedeEJB) this.manager
					.createQuery(
							"select o from TipoHospedeEJB o where o.padrao=1 and o.idRedeHotel=?1")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, novoHospede.getIdRedeHotel())
					.getSingleResult();
			if (novoHospede.getIdHospede() == null) {
				if ((novoHospede.getTipoHospedeEJB() == null)
						|| (novoHospede.getTipoHospedeEJB().getIdTipoHospede() == null)) {
					novoHospede.setIdRedeHotel(tipoPadrao.getIdRedeHotel());
					novoHospede.setTipoHospedeEJB(tipoPadrao);
				}
				this.manager.persist(novoHospede);
			} else {
				this.manager.merge(novoHospede);
			}
			this.manager.flush();
			return novoHospede;
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public HospedeEJB findHospede(HospedeEJB novoHospede)
			throws MozartSessionException {
		if ((novoHospede == null) || (novoHospede.getIdHospede() == null)) {
			throw new MozartValidateException("Chave não informada.");
		}
		try {
			return (HospedeEJB) this.manager.find(HospedeEJB.class,
					novoHospede.getIdHospede());
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CheckinEJB gravarWalkin(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		try {
			validarCheckin(checkinCorrente);

			checkinCorrente.setIdHotel(checkinCorrente.getHotelEJB()
					.getIdHotel());
			checkinCorrente.setIdEmpresa(checkinCorrente.getEmpresaHotelEJB()
					.getIdEmpresa());
			checkinCorrente.setEmpresaHotelEJB(null);
			if (checkinCorrente.getIdCheckin() == null) {
				this.manager.persist(checkinCorrente);
				if ("N".equals(checkinCorrente.getApartamentoEJB().getCofan())) {
					ReservaEJB reserva = checkinCorrente.getReservaEJB();
					this.manager.persist(reserva);

					this.manager
							.createNativeQuery(
									" update reserva_apartamento_diaria set id_reserva = ?1  where id_reserva_apartamento in (select id_reserva_apartamento from reserva_apartamento where id_reserva = ?2)")

							.setParameter(1, reserva.getIdReserva())
							.setParameter(2, reserva.getIdReserva())
							.executeUpdate();

					this.manager
							.createNativeQuery(
									"delete from ROOM_LIST r where r.id_checkin is null and r.id_Reserva_Apartamento =?1")
							.setParameter(
									1,
									checkinCorrente.getReservaApartamentoEJB()
											.getIdReservaApartamento())
							.executeUpdate();
					gerarMovimentoApartamento(checkinCorrente);
				}
			} else {
				if (("S".equals(checkinCorrente.getCalculaSeguro()))
						&& (checkinCorrente.getQtdeRoomListChegou() > 0)) {
					lancarSeguro(checkinCorrente);
				}
				CheckinEJB old = (CheckinEJB) this.manager.getReference(
						CheckinEJB.class, checkinCorrente.getIdCheckin());
				old.setAdicional(checkinCorrente.getAdicional());
				old.setApartamentoEJB(checkinCorrente.getApartamentoEJB());
				old.setCalculaIss(checkinCorrente.getCalculaIss());
				old.setCalculaRoomtax(checkinCorrente.getCalculaRoomtax());
				old.setCalculaSeguro(checkinCorrente.getCalculaSeguro());
				old.setCalculaTaxa(checkinCorrente.getCalculaTaxa());
				old.setCidadeDestino(checkinCorrente.getCidadeDestino());
				old.setCidadeProcedencia(checkinCorrente.getCidadeProcedencia());
				old.setCheckout(checkinCorrente.getCheckout());
				old.setComissao(checkinCorrente.getComissao());
				old.setCortesia(checkinCorrente.getCortesia());
				old.setCredito(checkinCorrente.getCredito());
				old.setDataEntrada(checkinCorrente.getDataEntrada());
				old.setDataSaida(checkinCorrente.getDataSaida());

				old.setIdEmpresa(checkinCorrente.getIdEmpresa());
				old.setIdHotel(checkinCorrente.getIdHotel());
				old.setEmpresaHotelEJB(checkinCorrente.getEmpresaHotelEJB());
				old.setFlgAlcoolica(checkinCorrente.getFlgAlcoolica());
				old.setHora(checkinCorrente.getHora());
				old.setHotelEJB(checkinCorrente.getHotelEJB());
				old.setIdCentralReservas(checkinCorrente.getIdCentralReservas());
				old.setJustificaTarifa(checkinCorrente.getJustificaTarifa());
				old.setMapfreEnviado(checkinCorrente.getMapfreEnviado());
				old.setMeioTransporte(checkinCorrente.getMeioTransporte());
				old.setMotivoViagem(checkinCorrente.getMotivoViagem());
				old.setObservacao(checkinCorrente.getObservacao());
				old.setQtdeAdultos(checkinCorrente.getQtdeAdultos());
				old.setQtdeCafe(checkinCorrente.getQtdeCafe());
				old.setQtdeCriancas(checkinCorrente.getQtdeCriancas());
				old.setRda(checkinCorrente.getRda());
				old.setTarifa(checkinCorrente.getTarifa());
				old.setTipoPensao(checkinCorrente.getTipoPensao());
				old.setTipoTarifa(checkinCorrente.getTipoTarifa());
				old.setValorPensao(checkinCorrente.getValorPensao());
				this.manager.merge(old);

				this.manager
						.createNativeQuery(
								"delete checkin_grupo_lancamento where id_checkin = ?1")
						.setParameter(1, checkinCorrente.getIdCheckin())
						.executeUpdate();
				for (CheckinGrupoLancamentoEJB cgl : checkinCorrente
						.getCheckinGrupoLancamentoEJBList()) {
					this.manager.persist(cgl);
				}
				this.manager
						.createNativeQuery(
								"delete checkin_tipo_lancamento where id_checkin = ?1")
						.setParameter(1, checkinCorrente.getIdCheckin())
						.executeUpdate();
				for (CheckinTipoLancamentoEJB ctl : checkinCorrente
						.getCheckinTipoLancamentoEJBList()) {
					this.manager.persist(ctl);
				}
				this.manager
						.createNativeQuery(
								"delete room_list where id_checkin = ?1 and chegou='N'")
						.setParameter(1, checkinCorrente.getIdCheckin())
						.executeUpdate();
				for (RoomListEJB room : checkinCorrente.getRoomListEJBList()) {
					if (MozartUtil.isNull(room.getIdRoomList())) {
						this.manager.persist(room);
					} else {
						this.manager.merge(room);
					}
				}
			}
			return checkinCorrente;
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CheckinEJB gravarCheckout(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		try {
			validarCheckout(checkinCorrente);
			List<MovimentoApartamentoEJB> movList = checkinCorrente
					.getMovimentoApartamentoEJBList();
			for (MovimentoApartamentoEJB mov : movList) {
				if (mov.getIdMovimentoApartamento() != null) {
					this.manager.merge(mov);
				} else {
					this.manager.persist(mov);
				}
			}
			return checkinCorrente;
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	private void validarCheckout(CheckinEJB checkinCorrente)
			throws MozartValidateException {
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	private void lancarSeguro(CheckinEJB checkinCorrente) {
		if (("N".equals(checkinCorrente.getApartamentoEJB().getCofan()))
				&& (checkinCorrente.getQtdeRoomListChegou() > 0)
				&& ("S".equals(checkinCorrente.getCalculaSeguro()))) {
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, checkinCorrente
							.getReservaApartamentoEJB().getIdHotel());
			HotelEJB hotel = (HotelEJB) this.manager.find(HotelEJB.class,
					controlaData.getIdHotel());
			if (hotel.getSeguro().doubleValue() > 0.0D) {
				TipoLancamentoEJB tipoLancamento =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 33 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				List<MovimentoApartamentoEJB> listSeg = this.manager
						.createNativeQuery(
								"select ma.* from movimento_apartamento ma, controla_data cd where cd.id_hotel = ma.id_hotel and trunc(ma.data_lancamento) = trunc(cd.front_office) and id_checkin = ?1 and mov_tmp='S' and id_tipo_lancamento = ?2",
								MovimentoApartamentoEJB.class)
						.setParameter(1, checkinCorrente.getIdCheckin())
						.setParameter(2, tipoLancamento.getIdTipoLancamento())
						.setHint("eclipselink.refresh", "TRUE").getResultList();

				MovimentoApartamentoEJB movimentoSeguro = null;
				if (MozartUtil.isNull(listSeg)) {
					movimentoSeguro = new MovimentoApartamentoEJB();
					movimentoSeguro.setIdRedeHotel(hotel.getRedeHotelEJB()
							.getIdRedeHotel());
					movimentoSeguro.setRoomListEJB(checkinCorrente
							.getRoomListPrincipal());
					movimentoSeguro.setCheckinEJB(checkinCorrente);
					movimentoSeguro.setTipoLancamentoEJB(tipoLancamento);
					movimentoSeguro.setNumDocumento("Seguro hospedagem");
					movimentoSeguro.setDataLancamento(new Timestamp(
							controlaData.getFrontOffice().getTime()));
					movimentoSeguro.setHoraLancamento(new Timestamp(new Date()
							.getTime()));
					movimentoSeguro.setValorLancamento(new Double(
							checkinCorrente.getQtdeRoomListChegou()
									* hotel.getSeguro().doubleValue()));
					movimentoSeguro.setQuemPaga("H");
					movimentoSeguro.setCheckout("N");
					movimentoSeguro.setMovTmp("S");
					movimentoSeguro.setParcial("N");
					this.manager.persist(movimentoSeguro);
				} else {
					movimentoSeguro = (MovimentoApartamentoEJB) listSeg.get(0);
					movimentoSeguro = (MovimentoApartamentoEJB) this.manager
							.find(MovimentoApartamentoEJB.class,
									movimentoSeguro.getIdMovimentoApartamento());
					movimentoSeguro.setValorLancamento(Double
							.valueOf(movimentoSeguro.getValorLancamento()
									.doubleValue()
									+ checkinCorrente.getQtdeRoomListChegou()
									* hotel.getSeguro().doubleValue()));
					this.manager.merge(movimentoSeguro);
				}
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	private void gerarMovimentoApartamento(CheckinEJB checkinCorrente) {
		CheckinEJB checkinMovimento = checkinCorrente;

		ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
				ControlaDataEJB.class, checkinCorrente
						.getReservaApartamentoEJB().getIdHotel());

		HotelEJB hotel = checkinCorrente.getHotelEJB();
		if (("N".equalsIgnoreCase(checkinCorrente.getReservaApartamentoEJB()
				.getMaster()))
				&& (!MozartUtil.isNull(checkinCorrente.getReservaEJB()
						.getNomeGrupo()))) {
			List<CheckinEJB> listaMaster = this.manager
					.createQuery(
							"select o from CheckinEJB o where o.reservaApartamentoEJB.reservaEJB.idReserva = ?1 and o.reservaApartamentoEJB.master = 'S'")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1,
							checkinCorrente.getReservaEJB().getIdReserva())
					.getResultList();
			if (!listaMaster.isEmpty()) {
				checkinMovimento = (CheckinEJB) listaMaster.get(0);
			}
		}
		MovimentoApartamentoEJB movimentoInicial = new MovimentoApartamentoEJB();
		movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());

		RoomListEJB principal = checkinMovimento.getRoomListPrincipal();

		movimentoInicial.setRoomListEJB(principal);

		movimentoInicial.setCheckinEJB(checkinMovimento);

		TipoLancamentoEJB tipoLancamento =

		(TipoLancamentoEJB) this.manager
				.createQuery(
						"select o from TipoLancamentoEJB o where o.identificaLancamento.idIdentificaLancamento = 26 and o.idTipoApartamento = ?1")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(
						1,
						checkinCorrente.getReservaApartamentoEJB()
								.getIdTipoApartamento()).getResultList().get(0);

		movimentoInicial.setTipoLancamentoEJB(tipoLancamento);

		ApartamentoEJB apto = (ApartamentoEJB) this.manager.find(
				ApartamentoEJB.class, checkinCorrente
						.getReservaApartamentoEJB().getApartamentoEJB()
						.getIdApartamento());
		movimentoInicial.setNumDocumento(apto.getNumApartamento() + " IN");
		movimentoInicial.setDataLancamento(new Timestamp(controlaData
				.getFrontOffice().getTime()));
		movimentoInicial.setHoraLancamento(new Timestamp(new Date().getTime()));

		movimentoInicial.setValorLancamento(checkinMovimento.getTarifa());

		CheckinGrupoLancamentoEJB grupoLancamentoQuemPaga = null;
		for (CheckinGrupoLancamentoEJB grupoLancamento : checkinMovimento
				.getCheckinGrupoLancamentoEJBList()) {
			if (grupoLancamento.getIdentificaLancamentoEJB()
					.getIdIdentificaLancamento().equals(new Long(1L))) {
				grupoLancamentoQuemPaga = grupoLancamento;
				movimentoInicial.setQuemPaga(grupoLancamento.getQuemPaga());
				break;
			}
		}
		movimentoInicial.setCheckout("N");
		movimentoInicial.setMovTmp("S");
		movimentoInicial.setParcial("N");
		movimentoInicial.setIdTipoDiaria(checkinCorrente
				.getReservaApartamentoEJB().getIdTipoDiaria());

		this.manager.persist(movimentoInicial);
		if ("N".equalsIgnoreCase(hotel.getTaxaCheckout())) {
			if (("S".equals(checkinCorrente.getCalculaIss()))
					&& (hotel.getIss().doubleValue() > 0.0D)) {
				movimentoInicial = new MovimentoApartamentoEJB();
				movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
				movimentoInicial.setRoomListEJB(principal);
				movimentoInicial.setCheckinEJB(checkinMovimento);

				tipoLancamento =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.debitoCredito='D' and o.identificaLancamento.idIdentificaLancamento = 13 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				movimentoInicial.setTipoLancamentoEJB(tipoLancamento);

				movimentoInicial.setNumDocumento("ISS");
				movimentoInicial.setDataLancamento(new Timestamp(controlaData
						.getFrontOffice().getTime()));
				movimentoInicial.setHoraLancamento(new Timestamp(new Date()
						.getTime()));
				movimentoInicial.setValorLancamento(Double
						.valueOf(checkinMovimento.getTarifa().doubleValue()
								* (hotel.getIss().doubleValue() / 100.0D)));
				movimentoInicial.setQuemPaga(grupoLancamentoQuemPaga
						.getQuemPaga());
				movimentoInicial.setCheckout("N");
				movimentoInicial.setMovTmp("S");
				movimentoInicial.setParcial("N");
				movimentoInicial.setIdTipoDiaria(checkinCorrente
						.getReservaApartamentoEJB().getIdTipoDiaria());

				this.manager.persist(movimentoInicial);
			}
			if (("S".equals(checkinCorrente.getCalculaRoomtax()))
					&& (hotel.getRoomtax().doubleValue() > 0.0D)) {
				movimentoInicial = new MovimentoApartamentoEJB();
				movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
				movimentoInicial.setRoomListEJB(principal);
				movimentoInicial.setCheckinEJB(checkinMovimento);

				tipoLancamento =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.debitoCredito='D' and o.identificaLancamento.idIdentificaLancamento = 15 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				movimentoInicial.setTipoLancamentoEJB(tipoLancamento);

				movimentoInicial.setNumDocumento("ROOMTAX");
				movimentoInicial.setDataLancamento(new Timestamp(controlaData
						.getFrontOffice().getTime()));
				movimentoInicial.setHoraLancamento(new Timestamp(new Date()
						.getTime()));
				movimentoInicial.setValorLancamento(Double.valueOf(hotel
						.getRoomtax().doubleValue()));
				movimentoInicial.setQuemPaga(grupoLancamentoQuemPaga
						.getQuemPaga());
				movimentoInicial.setCheckout("N");
				movimentoInicial.setMovTmp("S");
				movimentoInicial.setParcial("N");
				movimentoInicial.setIdTipoDiaria(checkinCorrente
						.getReservaApartamentoEJB().getIdTipoDiaria());

				this.manager.persist(movimentoInicial);
			}
			if (("S".equals(checkinCorrente.getCalculaTaxa()))
					&& (hotel.getTaxaServico().doubleValue() > 0.0D)) {
				movimentoInicial = new MovimentoApartamentoEJB();
				movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
				movimentoInicial.setRoomListEJB(principal);
				movimentoInicial.setCheckinEJB(checkinMovimento);

				tipoLancamento =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 11 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				movimentoInicial.setTipoLancamentoEJB(tipoLancamento);

				movimentoInicial.setNumDocumento("TAXASERV");
				movimentoInicial.setDataLancamento(new Timestamp(controlaData
						.getFrontOffice().getTime()));
				movimentoInicial.setHoraLancamento(new Timestamp(new Date()
						.getTime()));
				movimentoInicial
						.setValorLancamento(Double
								.valueOf(checkinCorrente.getTarifa()
										.doubleValue()
										* (hotel.getTaxaServico().doubleValue() / 100.0D)));
				movimentoInicial.setQuemPaga(grupoLancamentoQuemPaga
						.getQuemPaga());
				movimentoInicial.setCheckout("N");
				movimentoInicial.setMovTmp("S");
				movimentoInicial.setParcial("N");
				movimentoInicial.setIdTipoDiaria(checkinCorrente
						.getReservaApartamentoEJB().getIdTipoDiaria());

				this.manager.persist(movimentoInicial);
			}
			if (("S".equals(checkinCorrente.getCalculaSeguro()))
					&& (hotel.getSeguro() != null)
					&& (hotel.getSeguro().doubleValue() > 0.0D)) {
				tipoLancamento =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where  o.debitoCredito='D' and o.identificaLancamento.idIdentificaLancamento = 33 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				movimentoInicial = new MovimentoApartamentoEJB();
				movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
				movimentoInicial.setRoomListEJB(checkinMovimento
						.getRoomListPrincipal());
				movimentoInicial.setCheckinEJB(checkinMovimento);
				movimentoInicial.setTipoLancamentoEJB(tipoLancamento);
				movimentoInicial.setNumDocumento("Seguro hospedagem");
				movimentoInicial.setDataLancamento(new Timestamp(controlaData
						.getFrontOffice().getTime()));
				movimentoInicial.setHoraLancamento(new Timestamp(new Date()
						.getTime()));
				movimentoInicial.setValorLancamento(Double
						.valueOf(checkinMovimento.getQtdeRoomListChegou()
								* hotel.getSeguro().doubleValue()));
				movimentoInicial.setQuemPaga("H");
				movimentoInicial.setCheckout("N");
				movimentoInicial.setMovTmp("S");
				movimentoInicial.setParcial("N");
				movimentoInicial.setIdTipoDiaria(checkinCorrente
						.getReservaApartamentoEJB().getIdTipoDiaria());

				this.manager.persist(movimentoInicial);
			}
		} else {
			if (("S".equals(checkinCorrente.getCalculaRoomtax()))
					&& (hotel.getRoomtax().doubleValue() > 0.0D)) {
				movimentoInicial = new MovimentoApartamentoEJB();
				movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
				movimentoInicial.setRoomListEJB(principal);
				movimentoInicial.setCheckinEJB(checkinMovimento);

				tipoLancamento =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where  o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 15 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				movimentoInicial.setTipoLancamentoEJB(tipoLancamento);

				movimentoInicial.setNumDocumento("ROOMTAX");
				movimentoInicial.setDataLancamento(new Timestamp(controlaData
						.getFrontOffice().getTime()));
				movimentoInicial.setHoraLancamento(new Timestamp(new Date()
						.getTime()));
				movimentoInicial.setValorLancamento(Double.valueOf(hotel
						.getRoomtax().doubleValue()));
				movimentoInicial.setQuemPaga(grupoLancamentoQuemPaga
						.getQuemPaga());
				movimentoInicial.setCheckout("N");
				movimentoInicial.setMovTmp("S");
				movimentoInicial.setParcial("N");
				movimentoInicial.setIdTipoDiaria(checkinCorrente
						.getReservaApartamentoEJB().getIdTipoDiaria());

				this.manager.persist(movimentoInicial);
			}
			if (("S".equals(checkinCorrente.getCalculaSeguro()))
					&& (hotel.getSeguro().doubleValue() > 0.0D)) {
				tipoLancamento =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.debitoCredito='D' and  o.identificaLancamento.idIdentificaLancamento = 33 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				movimentoInicial = new MovimentoApartamentoEJB();
				movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
				movimentoInicial.setRoomListEJB(checkinMovimento
						.getRoomListPrincipal());
				movimentoInicial.setCheckinEJB(checkinMovimento);
				movimentoInicial.setTipoLancamentoEJB(tipoLancamento);
				movimentoInicial.setNumDocumento("Seguro hospedagem");
				movimentoInicial.setDataLancamento(new Timestamp(controlaData
						.getFrontOffice().getTime()));
				movimentoInicial.setHoraLancamento(new Timestamp(new Date()
						.getTime()));
				movimentoInicial.setValorLancamento(Double
						.valueOf(checkinMovimento.getQtdeRoomListChegou()
								* hotel.getSeguro().doubleValue()));
				movimentoInicial.setQuemPaga("H");
				movimentoInicial.setCheckout("N");
				movimentoInicial.setMovTmp("S");
				movimentoInicial.setParcial("N");
				movimentoInicial.setIdTipoDiaria(checkinCorrente
						.getReservaApartamentoEJB().getIdTipoDiaria());

				this.manager.persist(movimentoInicial);
			}
		}
	}

	private void validarCheckin(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		int ID_MOEDA_REAL = 1;
		if (checkinCorrente == null) {
			throw new MozartValidateException("Entidade inválida");
		}
		if ((checkinCorrente.getReservaApartamentoEJB().getApartamentoEJB() == null)
				|| (checkinCorrente.getReservaApartamentoEJB()
						.getApartamentoEJB().getIdApartamento() == null)
				|| (checkinCorrente.getReservaApartamentoEJB()
						.getApartamentoEJB().getIdApartamento().intValue() <= 0)) {
			throw new MozartValidateException(
					"O campo 'Apartamento' é obrigatório");
		}
		if (checkinCorrente.getReservaApartamentoEJB() == null) {
			throw new MozartValidateException(
					"Reserva de apartamento não informada");
		}
		if (checkinCorrente.getReservaApartamentoEJB().getReservaEJB() == null) {
			throw new MozartValidateException("Reserva não informada");
		}
		if (checkinCorrente.getReservaApartamentoEJB().getRoomListEJBList() == null) {
			throw new MozartValidateException("Hóspede não informado");
		}
		if (checkinCorrente.getReservaApartamentoEJB().getQtdePax() == null) {
			throw new MozartValidateException("Quantidade de pax não informada");
		}
		ApartamentoVO filtroApto = new ApartamentoVO();
		filtroApto.setBcIdHotel(checkinCorrente.getHotelEJB().getIdHotel());
		filtroApto.setBcIdApartamento(checkinCorrente.getApartamentoEJB()
				.getIdApartamento());
		filtroApto.setBcDataEntrada(checkinCorrente.getDataEntrada());
		filtroApto.setBcDataSaida(checkinCorrente.getDataSaida());
		filtroApto.setBcIdTipoApartamento(checkinCorrente.getApartamentoEJB()
				.getTipoApartamentoEJB().getIdTipoApartamento());
		filtroApto.setIdReserva(checkinCorrente.getReservaApartamentoEJB()
				.getReservaEJB().getIdReserva());
		filtroApto.setIdCheckin(checkinCorrente.getIdCheckin());
		filtroApto.setOcupacao(true);

		// TODO: (ID) Mais uma gambiarra infernal
		List<ApartamentoVO> listaApto = null; // ReservaDelegate.instance()
												// .obterApartamentoPorDisponibilidade(filtroApto);
		if (!MozartUtil.isNull(listaApto)) {
			ApartamentoVO apto = (ApartamentoVO) listaApto.get(0);
			if (apto.isOcupacao()) {
				throw new MozartValidateException("O apartamento: "
						+ apto.getBcNumApartamento()
						+ " está bloqueado para outra reserva nesse período.");
			}
		}
		if ("S".equals(checkinCorrente.getReservaApartamentoEJB().getMaster())) {
			List listaMaster = this.manager
					.createNativeQuery(
							"select o.id_reserva_apartamento from Reserva_Apartamento o where o.id_Reserva = ?1 and o.master = 'S' and o.id_Reserva_Apartamento <> ?2")
					.setParameter(
							1,
							checkinCorrente.getReservaApartamentoEJB()
									.getReservaEJB().getIdReserva())
					.setParameter(
							2,
							checkinCorrente.getReservaApartamentoEJB()
									.getIdReservaApartamento()).getResultList();
			if (!MozartUtil.isNull(listaMaster)) {
				throw new MozartValidateException(
						"Já existe um Checkin master para essa reserva.");
			}
		}
		if ((!MozartUtil.isNull(checkinCorrente.getReservaApartamentoEJB()))
				&& (!MozartUtil.isNull(checkinCorrente
						.getReservaApartamentoEJB().getIdReservaApartamento()))) {
			ReservaApartamentoDiariaEJB diaria =

			(ReservaApartamentoDiariaEJB) this.manager
					.createQuery(
							"select o from ReservaApartamentoDiariaEJB o where o.reservaApartamentoEJB.idReservaApartamento = ?1")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(
							1,
							checkinCorrente.getReservaApartamentoEJB()
									.getIdReservaApartamento()).getResultList()
					.get(0);

			int idMoeda = 0;
			if ((idMoeda = diaria.getIdMoeda().intValue()) != ID_MOEDA_REAL) {
				ValorDolarEJB valorMoeda = (ValorDolarEJB) this.manager
						.createNativeQuery(
								"select * from VALOR_DOLAR o where o.id_Hotel = ?1 and o.id_Moeda = ?2 and trunc(o.data) = TRUNC(?3)",
								ValorDolarEJB.class)
						.setParameter(
								1,
								checkinCorrente.getReservaApartamentoEJB()
										.getIdHotel())
						.setParameter(2, Integer.valueOf(idMoeda))
						.setParameter(3, checkinCorrente.getDataEntrada())
						.getSingleResult();
				if (valorMoeda == null) {
					throw new MozartValidateException(
							"A moeda selecionada não possui tarifa para este dia:"
									+ MozartUtil.format(
											checkinCorrente.getDataEntrada(),
											"dd/MM/yyyy"));
				}
				checkinCorrente.setTarifa(Double.valueOf(checkinCorrente
						.getTarifa().doubleValue()
						* valorMoeda.getValorDolar().doubleValue()));
			}
		} else if (MozartUtil.isNull(checkinCorrente.getReservaApartamentoEJB()
				.getIdReservaApartamento())) {
			ReservaApartamentoDiariaEJB diaria = (ReservaApartamentoDiariaEJB) checkinCorrente
					.getReservaApartamentoEJB()
					.getReservaApartamentoDiariaEJBList().get(0);
			int idMoeda = 0;
			if ((idMoeda = diaria.getIdMoeda().intValue()) != ID_MOEDA_REAL) {
				ValorDolarEJB valorMoeda = (ValorDolarEJB) this.manager
						.createNativeQuery(
								"select * from VALOR_DOLAR o where o.id_Hotel = ?1 and o.id_Moeda = ?2 and trunc(o.data) = TRUNC(?3)",
								ValorDolarEJB.class)
						.setParameter(
								1,
								checkinCorrente.getReservaApartamentoEJB()
										.getIdHotel())
						.setParameter(2, Integer.valueOf(idMoeda))
						.setParameter(3, checkinCorrente.getDataEntrada())
						.getSingleResult();
				if (valorMoeda == null) {
					throw new MozartValidateException(
							"A moeda selecionada não possui tarifa para este dia:"
									+ MozartUtil.format(
											checkinCorrente.getDataEntrada(),
											"dd/MM/yyyy"));
				}
				checkinCorrente.setTarifa(Double.valueOf(checkinCorrente
						.getTarifa().doubleValue()
						* valorMoeda.getValorDolar().doubleValue()));
				for (ReservaApartamentoDiariaEJB diariaAlteracao : checkinCorrente
						.getReservaApartamentoEJB()
						.getReservaApartamentoDiariaEJBList()) {
					diariaAlteracao.setIdMoeda(new Long(1L));
					diariaAlteracao.setTarifa(checkinCorrente.getTarifa());
				}
			}
		}
		checkinCorrente.setRoomListEJBList(new ArrayList());
		String sql = "SELECT decode(count(t0.ID_SEGURADORA),0, 'N','S') obriga_dados"
				+ " FROM EMPRESA_SEGURADORA t0,"
				+ "  CONTROLA_DATA t1"
				+ " WHERE (((((t0.ID_SEGURADORA = ?1)"
				+ " AND (t0.ID_HOTEL_SEGURADO   = ?2))"
				+ " AND (t0.ID_HOTEL_SEGURADO   = t1.ID_HOTEL))"
				+ " AND (t1.FRONT_OFFICE       >= t0.DT_INICIO_SEGURO))"
				+ " AND (t0.DT_FIM_SEGURO      IS NULL))"
				+ " union ( select"
				+ " decode(count(id_hotel),0, 'N','S')"
				+ "  from hotel where hotel.ID_HOTEL =?3"
				+ "  and hotel.OBRIGA_DADOS_HOSP = 'S')";

		List<String> lista = this.manager
				.createNativeQuery(sql)
				// .setHint("eclipselink.refresh", "TRUE")
				.setParameter(1,
						checkinCorrente.getHotelEJB().getIdSeguradora())
				.setParameter(2, checkinCorrente.getHotelEJB().getIdHotel())
				.setParameter(3, checkinCorrente.getHotelEJB().getIdHotel())
				.getResultList();
		if ("S".equals(checkinCorrente.getApartamentoEJB().getCofan())) {
			lista = null;
		}
		if ((checkinCorrente.getCidadeProcedencia() != null)
				&& (checkinCorrente.getCidadeProcedencia().getIdCidade() != null)) {
			checkinCorrente.setCidadeProcedencia((CidadeEJB) this.manager.find(
					CidadeEJB.class, checkinCorrente.getCidadeProcedencia()
							.getIdCidade()));
		}
		if ((checkinCorrente.getCidadeDestino() != null)
				&& (checkinCorrente.getCidadeDestino().getIdCidade() != null)) {
			checkinCorrente.setCidadeDestino((CidadeEJB) this.manager.find(
					CidadeEJB.class, checkinCorrente.getCidadeDestino()
							.getIdCidade()));
		}
		Boolean algumHospedeChegou = Boolean.valueOf(false);
		Boolean algumHospedePrincipal = Boolean.valueOf(false);
		for (RoomListEJB roomList : checkinCorrente.getReservaApartamentoEJB()
				.getRoomListEJBList()) {
			if (roomList.getDataSaida() == null) {
				if (roomList.getHospede() == null) {
					throw new MozartValidateException(
							"O campo 'Hóspede' é obrigatório");
				}
				if ((!MozartUtil.isNull(lista) && lista.contains("S"))
						&& (MozartUtil.isNull(roomList.getHospede().getCpf()))
						&& (MozartUtil.isNull(roomList.getHospede()
								.getPassaporte()))) {
					throw new MozartValidateException("O hóspede: "
							+ roomList.getHospede().getNomeHospede()
							+ " está sem o campo CPF/Passaporte preenchido");
				}
				if ((!MozartUtil.isNull(lista) && lista.contains("S"))
						&& (roomList.getHospede().getNascimento() == null)) {
					throw new MozartValidateException("O hóspede: "
							+ roomList.getHospede().getNomeHospede()
							+ " está sem o campo Data de nascimento preenchido");
				}
				if ((!MozartUtil.isNull(lista) && lista.contains("S"))
						&& (MozartUtil.isNull(roomList.getHospede().getEmail()))) {
					throw new MozartValidateException("O hóspede: "
							+ roomList.getHospede().getNomeHospede()
							+ " está sem o campo E-mail preenchido");
				}
				if ((!MozartUtil.isNull(lista) && lista.contains("S"))
						&& (MozartUtil.isNull(roomList.getHospede().getSexo()))) {
					throw new MozartValidateException("O hóspede: "
							+ roomList.getHospede().getNomeHospede()
							+ " está sem o campo sexo preenchido.");
				}
				if ("S".equals(roomList.getChegou())) {
					algumHospedeChegou = Boolean.valueOf(true);
				}
				if ("S".equals(roomList.getPrincipal())) {
					if (algumHospedePrincipal.booleanValue()) {
						throw new MozartValidateException(
								"Só pode existir UM hóspede principal.");
					}
					algumHospedePrincipal = Boolean.valueOf(true);
				}
				RoomListEJB obj = new RoomListEJB();
				obj.setIdHotel(checkinCorrente.getHotelEJB().getIdHotel());
				obj.setIdRoomList(roomList.getIdRoomList());
				if (checkinCorrente.getRoomListEJBList().contains(obj)) {
					obj = (RoomListEJB) checkinCorrente.getRoomListEJBList()
							.get(checkinCorrente.getRoomListEJBList().indexOf(
									obj));
				}
				obj.setCheckin(checkinCorrente);
				if ("N".equals(checkinCorrente.getApartamentoEJB().getCofan())) {
					obj.setReservaEJB(checkinCorrente.getReservaEJB());
					obj.setReservaApartamentoEJB(checkinCorrente
							.getReservaApartamentoEJB());
				}
				obj.setHospede(roomList.getHospede());
				obj.setChegou(roomList.getChegou());
				obj.setPrincipal(roomList.getPrincipal());
				obj.setDataEntrada(roomList.getDataEntrada());
				obj.setDataSaida(roomList.getDataSaida());
				obj.setCodCertificado(roomList.getCodCertificado());
				obj.setDataCertificado(roomList.getDataCertificado());
				if (!checkinCorrente.getRoomListEJBList().contains(obj)) {
					checkinCorrente.getRoomListEJBList().add(obj);
				}
			}
		}
		checkinCorrente.getReservaApartamentoEJB().setRoomListEJBList(null);
		if ("S".equals(checkinCorrente.getApartamentoEJB().getCofan())) {
			checkinCorrente.setReservaEJB(null);
			checkinCorrente.setReservaApartamentoEJB(null);
		}
		if (!algumHospedeChegou.booleanValue()) {
			throw new MozartValidateException(
					"Você deve informar se algum hóspede chegou.");
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MoedaEJB> pesquisarMoeda() {
		return this.manager.createNamedQuery("MoedaEJB.findAll")
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public TipoDiariaEJB obterTipoDiariaPadraoByRede(Long idRedeHotel)
			throws MozartValidateException {
		if (MozartUtil.isNull(idRedeHotel)) {
			throw new MozartValidateException("Informe o id da rede");
		}
		return (TipoDiariaEJB) this.manager
				.createQuery(
						"select o from TipoDiariaEJB o where o.padrao='S' and o.idRedeHotel = ?1")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, idRedeHotel).getSingleResult();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoLancamentoEJB> pesquisarTipoLancamentoByFiltro(
			TipoLancamentoEJB tipoLancamento) throws MozartSessionException {
		try {
			String query = "select o from TipoLancamentoEJB o where o.idHotel = ?1 ";
			if (!MozartUtil.isNull(tipoLancamento.getIdentificaLancamento())) {
				query = query
						.concat(" and o.identificaLancamento.idIdentificaLancamento = "
								+ tipoLancamento.getIdentificaLancamento()
										.getIdIdentificaLancamento());
			}
			if (!MozartUtil.isNull(tipoLancamento.getDebitoCredito())) {
				query = query.concat(" and o.debitoCredito='"
						+ tipoLancamento.getDebitoCredito() + "'");
			}
			if (!MozartUtil.isNull(tipoLancamento.getSubGrupoLancamento())) {
				query = query.concat(" and o.subGrupoLancamento = '"
						+ tipoLancamento.getSubGrupoLancamento() + "'");
			}

			query += " order by o.idTipoLancamento ";

			return this.manager.createQuery(query)
					.setParameter(1, tipoLancamento.getIdHotel())
					.setHint("eclipselink.refresh", "TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public CheckinEJB obterCheckin(Long idCheckin) throws MozartSessionException{
		List<RoomListEJB> roomListEJBList = this.manager
				.createQuery(
						"select o from RoomListEJB o where o.checkin.idCheckin = ?1 and o.chegou = 'S' and o.dataSaida is null ")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, idCheckin).getResultList();
		for (RoomListEJB room : roomListEJBList) {
			room.setMovimentoApartamentoEJBList(new ArrayList());
		}
		CheckinEJB checkin = null;
		if( ! MozartUtil.isNull(roomListEJBList)){
			
			checkin = ((RoomListEJB) roomListEJBList.get(0))
					.getCheckin();
		}else{
			checkin = (CheckinEJB)obter(CheckinEJB.class, idCheckin);
		}
		
		checkin.setRoomListEJBList(roomListEJBList);
		checkin.setMovimentoApartamentoEJBList(new ArrayList());
		return checkin;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public CheckinEJB obterCheckinComplemento(CheckinEJB checkin) {
		checkin.setMovimentoApartamentoEJBList(new ArrayList());
		List<MovimentoApartamentoEJB> movList = this.manager
				.createQuery(
						"select m from MovimentoApartamentoEJB m where m.checkinEJB.idCheckin = ?1 and m.movTmp = 'S' and m.checkout = 'N' and m.quemPaga='E'")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, checkin.getIdCheckin()).getResultList();
		if (!MozartUtil.isNull(movList)) {
			checkin.getMovimentoApartamentoEJBList().addAll(movList);
		}
		for (RoomListEJB room : checkin.getRoomListEJBList()) {
			movList =

			this.manager
					.createQuery(
							"select m from MovimentoApartamentoEJB m where m.roomListEJB.idRoomList = ?1 and m.movTmp = 'S' and m.checkout = 'N' and m.quemPaga='H'")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, room.getIdRoomList()).getResultList();

			room.getMovimentoApartamentoEJBList().addAll(movList);
			checkin.getMovimentoApartamentoEJBList().addAll(movList);
		}
		return checkin;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public CheckinEJB obterCheckinParaAlteracao(Long idCheckin) {
		List<RoomListEJB> roomListEJBList = this.manager
				.createQuery(
						"select o from RoomListEJB o where o.checkin.idCheckin = ?1 and o.dataSaida is null ")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, idCheckin).getResultList();
		for (RoomListEJB room : roomListEJBList) {
			room.setMovimentoApartamentoEJBList(new ArrayList());
		}
		CheckinEJB checkin = ((RoomListEJB) roomListEJBList.get(0))
				.getCheckin();
		checkin.setRoomListEJBList(roomListEJBList);
		checkin.setMovimentoApartamentoEJBList(new ArrayList());
		List<CheckinGrupoLancamentoEJB> lista = checkin
				.getCheckinGrupoLancamentoEJBList();
		Collections.sort(lista, CheckinGrupoLancamentoEJB.getComparator());
		checkin.setCheckinGrupoLancamentoEJBList(lista);
		checkin.setCheckinGrupoLancamentoEJBList((List) lista);

		return checkin;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ApartamentoEJB obterApartamentoByPK(ApartamentoEJBPK apartamentoEJBPK) {
		return (ApartamentoEJB) this.manager.find(ApartamentoEJB.class,
				apartamentoEJBPK.idApartamento);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoDiariaEJB> pesquisarTipoDiaria(TipoDiariaEJB pTipo) {
		return this.manager.createNamedQuery("TipoDiariaEJB.findAllByRede")
				.setParameter(1, pTipo.getIdRedeHotel()).getResultList();
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Object persist(Object newEntity) throws MozartSessionException {
		// TODO: (ID) Gambiarra infernal que fizeram aqui
		if ((newEntity instanceof MovimentoApartamentoEJB)) {
			return persist((MovimentoApartamentoEJB) newEntity);
		}
		this.manager.persist(newEntity);
		return newEntity;
	}

	private Object persist(MovimentoApartamentoEJB newEntity) {
		List<MovimentoApartamentoEJB> movimentos = new ArrayList();
		movimentos.add((MovimentoApartamentoEJB) newEntity);
		this.manager.persist(newEntity);

		HotelEJB hotel = (HotelEJB) this.manager.find(HotelEJB.class,
				((MovimentoApartamentoEJB) newEntity).getTipoLancamentoEJB()
						.getIdHotel());
		ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
				ControlaDataEJB.class, hotel.getIdHotel());
		MovimentoApartamentoEJB mov = (MovimentoApartamentoEJB) newEntity;
		if (("N".equals(hotel.getTaxaCheckout()))
				&& (hotel.getIss().doubleValue() > 0.0D)
				&& ("S".equals(((MovimentoApartamentoEJB) newEntity)
						.getCheckinEJB().getCalculaIss()))
				&& ("S".equals(((MovimentoApartamentoEJB) newEntity)
						.getTipoLancamentoEJB().getIss()))) {
			MovimentoApartamentoEJB movimentoInicial = new MovimentoApartamentoEJB();
			movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
			movimentoInicial.setRoomListEJB(mov.getRoomListEJB());
			movimentoInicial.setCheckinEJB(mov.getCheckinEJB());

			TipoLancamentoEJB tipoLancamentoISS =

			(TipoLancamentoEJB) this.manager
					.createQuery(
							"select o from TipoLancamentoEJB o where o.debitoCredito='D' and o.identificaLancamento.idIdentificaLancamento = 13 and o.idHotel = ?1")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, hotel.getIdHotel()).getResultList().get(0);

			movimentoInicial.setTipoLancamentoEJB(tipoLancamentoISS);

			movimentoInicial.setNumDocumento("ISS");
			movimentoInicial.setDataLancamento(new Timestamp(controlaData
					.getFrontOffice().getTime()));
			movimentoInicial.setHoraLancamento(new Timestamp(new Date()
					.getTime()));
			movimentoInicial.setValorLancamento(Double.valueOf(mov
					.getValorLancamento().doubleValue()
					* (hotel.getIss().doubleValue() / 100.0D)));
			movimentoInicial.setQuemPaga(mov.getQuemPaga());
			movimentoInicial.setCheckout("N");
			movimentoInicial.setMovTmp("S");
			movimentoInicial.setParcial("N");

			this.manager.persist(movimentoInicial);
			movimentos.add(movimentoInicial);
		}
		if (("N".equals(hotel.getTaxaCheckout()))
				&& (hotel.getTaxaServico().doubleValue() > 0.0D)
				&& ("S".equals(((MovimentoApartamentoEJB) newEntity)
						.getCheckinEJB().getCalculaTaxa()))
				&& ("S".equals(((MovimentoApartamentoEJB) newEntity)
						.getTipoLancamentoEJB().getTaxaServico()))) {
			MovimentoApartamentoEJB movimentoInicial = new MovimentoApartamentoEJB();
			movimentoInicial.setIdRedeHotel(controlaData.getIdRedeHotel());
			movimentoInicial.setRoomListEJB(mov.getRoomListEJB());
			movimentoInicial.setCheckinEJB(mov.getCheckinEJB());

			TipoLancamentoEJB tipoLancamentoTAXA =

			(TipoLancamentoEJB) this.manager
					.createQuery(
							"select o from TipoLancamentoEJB o where o.debitoCredito='D' and o.identificaLancamento.idIdentificaLancamento = 11 and o.idHotel = ?1")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, hotel.getIdHotel()).getResultList().get(0);

			movimentoInicial.setTipoLancamentoEJB(tipoLancamentoTAXA);

			movimentoInicial.setNumDocumento("TAXASERV");
			movimentoInicial.setDataLancamento(new Timestamp(controlaData
					.getFrontOffice().getTime()));
			movimentoInicial.setHoraLancamento(new Timestamp(new Date()
					.getTime()));
			movimentoInicial.setValorLancamento(Double.valueOf(mov
					.getValorLancamento().doubleValue()
					* (hotel.getTaxaServico().doubleValue() / 100.0D)));
			movimentoInicial.setQuemPaga(mov.getQuemPaga());
			movimentoInicial.setCheckout("N");
			movimentoInicial.setMovTmp("S");
			movimentoInicial.setParcial("N");

			this.manager.persist(movimentoInicial);
			movimentos.add(movimentoInicial);
		}
		return movimentos;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public CheckinEJB lancarTaxas(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		return null;
	}

	public StatusNotaEJB obterProximaNotaHospedagem(HotelEJB pHotel)
			throws MozartSessionException {
		return obterProximaNotaHospedagem(pHotel, "H");
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public StatusNotaEJB obterProximaNotaHospedagem(HotelEJB pHotel,
			String tipoNota) throws MozartSessionException {
		if ((MozartUtil.isNull(pHotel))
				|| (MozartUtil.isNull(pHotel.getIdHotel()))) {
			throw new MozartValidateException(
					"obterProximaNotaHospedagem:Informe o hotel");
		}
		try {
			Long pIdHotel = pHotel.getIdHotel();
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, pIdHotel);
					
					
			Time hora = new Time(MozartUtil.now().getTime());
			String data = MozartUtil.format(controlaData.getFrontOffice());

			StatusNotaEJB newNota = new StatusNotaEJB();
			newNota.setIdHotel(pIdHotel);
			
			if("F".equals(tipoNota)){
				Long numNotal = new BigDecimal(controlaData.getUltimaNotaHospedagem()).longValue(); 
				//Long notaInicial = buscarUltimoNotaHospedagem(pHotel);
				//newNota.setNotaInicial(notaInicial + 1L);
				//newNota.setNotaFinal(newNota.getNotaInicial());
				newNota.setNumNota(numNotal.longValue() + 1L + "");
				controlaData.setUltimaNotaHospedagem(newNota.getNumNota() + "");
			} else {
				Long numNotal = new BigDecimal(controlaData.getUltimaNotaHospedagem()).longValue();
				newNota.setIdHotel(pIdHotel);
				//newNota.setNotaInicial(numNotal + 1L);
				//newNota.setNotaFinal(newNota.getNotaInicial());
				newNota.setNumNota(numNotal + 1L + "");
				controlaData.setUltimaNotaHospedagem(newNota.getNumNota() + "");
			}
			
			newNota.setStatus("OK");
			newNota.setRestaurante("N");
			newNota.setData(MozartUtil.toTimestamp(data + " " + hora));
			newNota.setSerie(pHotel.getNotaFiscalTipo());
			newNota.setTipoOperacao("VS");
			newNota.setSituacaorps("C");
			newNota.setSituacaoNf("C");
			newNota.setTipoDocumento(new Long(1L));
			newNota.setTipoServico("SC");
			newNota.setTipoNota(tipoNota);
			newNota.setTipoNotaFiscal("NFS");
			newNota.setDataEmissao(newNota.getData());

			this.manager.merge(controlaData);
			this.manager.persist(newNota);
			return newNota;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	
	public Long buscarUltimoNotaHospedagem(HotelEJB pHotel ){
		String sql = " SELECT Max(nota_inicial) FROM Status_Nota WHERE id_Hotel=?1 ";
		BigDecimal numNota= (BigDecimal) manager.createNativeQuery(sql)
				.setParameter(1, pHotel.getIdHotel())
				.getSingleResult();
		
		return ( ! MozartUtil.isNull(numNota))? numNota.longValue(): 0L;
	}
	
	public Long buscarUltimoNumNotaHospedagem(HotelEJB pHotel ){
		String sql = " SELECT Max(num_nota) FROM Status_Nota WHERE id_Hotel=?1 ";
		String numNota= (String) manager.createNativeQuery(sql)
				.setParameter(1, pHotel.getIdHotel())
				.getSingleResult();
		
		return ( ! MozartUtil.isNull(numNota))? new BigDecimal(numNota).longValue(): 0L;
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public StatusNotaEJB atualizarDadosRPS(StatusNotaEJB pStatusNota)
			throws MozartSessionException {
		if ((MozartUtil.isNull(pStatusNota))
				|| (MozartUtil.isNull(pStatusNota.getIdHotel()))) {
			throw new MozartValidateException(
					"obterProximaNotaHospedagem:Informe o hotel");
		}
		try {

			Query qry = this.manager.createNativeQuery(QRY_CARGA_DADOS_RPS);
			
			if(pStatusNota.getHotel().getIdPrograma() != 1)
				qry = this.manager.createNativeQuery(QRY_CARGA_DADOS_RPS_PROG_DIF_1);

			qry.setParameter(1, pStatusNota.getIdHotel());
			qry.setParameter(2, pStatusNota.getIdNota());
			qry.setParameter(3, pStatusNota.getIdHotel());
			qry.setParameter(4, pStatusNota.getIdNota());
			qry.setParameter(5, pStatusNota.getIdHotel());
			qry.setParameter(6, pStatusNota.getIdNota());

			Object[] result = (Object[]) qry.getSingleResult();

			MozartVO vo = new MozartVO(result);

			Long pIdHotel = pStatusNota.getIdHotel();

			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, pIdHotel);

			Long numNota = buscarUltimoNotaHospedagem(pStatusNota.getHotel());

			StatusNotaEJB newNota = (StatusNotaEJB) this.manager.find(
					StatusNotaEJB.class, vo.getLong());

			newNota.setTipoNota(pStatusNota.getTipoNota());
			if(MozartUtil.isNull(newNota.getNotaInicial()))
				newNota.setNotaInicial(numNota + 1);

			newNota.setValorNota(vo.getDouble());
			newNota.setValorDeducao(vo.getDouble());
			newNota.setBaseCalculo(vo.getDouble());
			newNota.setAliquotaIss(vo.getDouble());
			newNota.setIss(vo.getDouble());
			// newNota.setTipoServico(vo.getString());
			// newNota.setTipoDocumento(vo.getLong());
			// newNota.setSituacaoNf(vo.getString());
			newNota.setIdEmpresa(vo.getLong());
			newNota.setTipoNotaFiscal(vo.getString());
			
			if(pStatusNota.getHotel().getIdPrograma() == 1)
				newNota.setIdHospede(vo.getLong());
			
			newNota.setQuemPaga(vo.getString());
			newNota.setIrRetencao(vo.getDouble());
			newNota.setCsll(vo.getDouble());
			newNota.setCofins(vo.getDouble());
			newNota.setPis(vo.getDouble());
			newNota.setInss(vo.getDouble());
			newNota.setOutasRetencoes(vo.getDouble());
			newNota.setIssRetido(vo.getDouble());
			newNota.setDiscriminacao(vo.getString());
			newNota.setRpsStatus("A");
			newNota.setDataEmissao(newNota.getData());

			controlaData.setUltimaNfs(newNota.getNotaInicial());
			this.manager.merge(controlaData);
			this.manager.merge(newNota);
			return newNota;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void devolverObjetos(List<MovimentoObjetoEJB> listaDevolucao)
			throws MozartSessionException {
		if (MozartUtil.isNull(listaDevolucao)) {
			throw new MozartValidateException(
					"devolverObjetos:sem objetos para devolver");
		}
		try {
			for (MovimentoObjetoEJB obj : listaDevolucao) {
				obj = (MovimentoObjetoEJB) this.manager.find(
						MovimentoObjetoEJB.class, obj.getIdMovimentoObjeto());
				this.manager.remove(obj);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<MovimentoApartamentoEJB> obterMovimentosPorIdNota(Long idNota) throws MozartSessionException{
		List<MovimentoApartamentoEJB> lista = new ArrayList<MovimentoApartamentoEJB>();
		try {
			lista = this.manager
					.createNativeQuery(
							"select ma.* from movimento_apartamento ma where ma.ID_NOTA = ?1",
							MovimentoApartamentoEJB.class)
					.setParameter(1, idNota)
					.setHint("eclipselink.refresh", "TRUE").getResultList();	
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

		return lista;
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<MovimentoApartamentoEJB> pagarObjetos(
			MovimentoApartamentoEJB newMovApartamento,
			List<MovimentoObjetoEJB> listaDevolucao)
			throws MozartSessionException {
		try {
			List<MovimentoApartamentoEJB> movimentos = new ArrayList<MovimentoApartamentoEJB>();
			movimentos.add(newMovApartamento);
			this.manager.persist(newMovApartamento);

			HotelEJB hotel = (HotelEJB) this.manager.find(HotelEJB.class,
					newMovApartamento.getTipoLancamentoEJB().getIdHotel());
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, hotel.getIdHotel());
			MovimentoApartamentoEJB mov = newMovApartamento;
			if (("N".equals(hotel.getTaxaCheckout()))
					&& (hotel.getIss().doubleValue() > 0.0D)
					&& ("S".equals(mov.getCheckinEJB().getCalculaIss()))
					&& ("S".equals(mov.getTipoLancamentoEJB().getIss()))) {
				TipoLancamentoEJB tipoLancamentoISS =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.debitoCredito='D' and o.identificaLancamento.idIdentificaLancamento = 13 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				List<MovimentoApartamentoEJB> listIss = this.manager
						.createNativeQuery(
								"select ma.* from movimento_apartamento ma, controla_data cd where cd.id_hotel = ma.id_hotel and trunc(ma.data_lancamento) = trunc(cd.front_office) and id_checkin = ?1 and mov_tmp='S' and id_tipo_lancamento = ?2 and quem_paga=?3 and id_room_list = nvl(?4, id_room_list)",
								MovimentoApartamentoEJB.class)
						.setParameter(1, mov.getCheckinEJB().getIdCheckin())
						.setParameter(2,
								tipoLancamentoISS.getIdTipoLancamento())
						.setParameter(3, mov.getQuemPaga())
						.setParameter(
								4,
								mov.getQuemPaga().equals("E") ? null : mov
										.getRoomListEJB().getIdRoomList())
						.setHint("eclipselink.refresh", "TRUE").getResultList();
				if (MozartUtil.isNull(listIss)) {
					MovimentoApartamentoEJB movimentoInicial = new MovimentoApartamentoEJB();
					movimentoInicial.setIdRedeHotel(controlaData
							.getIdRedeHotel());
					movimentoInicial.setRoomListEJB(mov.getRoomListEJB());
					movimentoInicial.setCheckinEJB(mov.getCheckinEJB());

					movimentoInicial.setTipoLancamentoEJB(tipoLancamentoISS);

					movimentoInicial.setNumDocumento("ISS");
					movimentoInicial.setDataLancamento(new Timestamp(
							controlaData.getFrontOffice().getTime()));
					movimentoInicial.setHoraLancamento(new Timestamp(new Date()
							.getTime()));
					movimentoInicial.setValorLancamento(Double.valueOf(mov
							.getValorLancamento().doubleValue()
							* (hotel.getIss().doubleValue() / 100.0D)));
					movimentoInicial.setQuemPaga(mov.getQuemPaga());
					movimentoInicial.setCheckout("N");
					movimentoInicial.setMovTmp("S");
					movimentoInicial.setParcial("N");

					this.manager.persist(movimentoInicial);
					movimentos.add(movimentoInicial);
				} else {
					MovimentoApartamentoEJB movimentoIss = (MovimentoApartamentoEJB) listIss
							.get(0);
					movimentoIss.setValorLancamento(Double.valueOf(movimentoIss
							.getValorLancamento().doubleValue()
							+ mov.getValorLancamento().doubleValue()
							* (hotel.getIss().doubleValue() / 100.0D)));
					movimentos.add(movimentoIss);
					this.manager.merge(movimentoIss);
				}
			}
			List<MovimentoApartamentoEJB> listTaxa;
			if (("N".equals(hotel.getTaxaCheckout()))
					&& (hotel.getTaxaServico().doubleValue() > 0.0D)
					&& ("S".equals(mov.getCheckinEJB().getCalculaTaxa()))
					&& ("S".equals(mov.getTipoLancamentoEJB().getTaxaServico()))) {
				TipoLancamentoEJB tipoLancamentoTAXA =

				(TipoLancamentoEJB) this.manager
						.createQuery(
								"select o from TipoLancamentoEJB o where o.debitoCredito='D' and o.identificaLancamento.idIdentificaLancamento = 11 and o.idHotel = ?1")
						.setHint("eclipselink.refresh", "TRUE")
						.setParameter(1, hotel.getIdHotel()).getResultList()
						.get(0);

				listTaxa = this.manager
						.createNativeQuery(
								"select ma.* from movimento_apartamento ma, controla_data cd where cd.id_hotel = ma.id_hotel and trunc(ma.data_lancamento) = trunc(cd.front_office) and id_checkin = ?1 and mov_tmp='S' and id_tipo_lancamento = ?2 and quem_paga=?3 and id_room_list = nvl(?4, id_room_list)",
								MovimentoApartamentoEJB.class)
						.setParameter(1, mov.getCheckinEJB().getIdCheckin())
						.setParameter(2,
								tipoLancamentoTAXA.getIdTipoLancamento())
						.setParameter(3, mov.getQuemPaga())
						.setParameter(
								4,
								mov.getQuemPaga().equals("E") ? null : mov
										.getRoomListEJB().getIdRoomList())
						.setHint("eclipselink.refresh", "TRUE").getResultList();
				if (MozartUtil.isNull(listTaxa)) {
					MovimentoApartamentoEJB movimentoInicial = new MovimentoApartamentoEJB();
					movimentoInicial.setIdRedeHotel(controlaData
							.getIdRedeHotel());
					movimentoInicial.setRoomListEJB(mov.getRoomListEJB());
					movimentoInicial.setCheckinEJB(mov.getCheckinEJB());
					movimentoInicial.setTipoLancamentoEJB(tipoLancamentoTAXA);
					movimentoInicial.setNumDocumento("TAXASERV");
					movimentoInicial.setDataLancamento(new Timestamp(
							controlaData.getFrontOffice().getTime()));
					movimentoInicial.setHoraLancamento(new Timestamp(new Date()
							.getTime()));
					movimentoInicial.setValorLancamento(Double.valueOf(mov
							.getValorLancamento().doubleValue()
							* (hotel.getTaxaServico().doubleValue() / 100.0D)));
					movimentoInicial.setQuemPaga(mov.getQuemPaga());
					movimentoInicial.setCheckout("N");
					movimentoInicial.setMovTmp("S");
					movimentoInicial.setParcial("N");

					this.manager.persist(movimentoInicial);
					movimentos.add(movimentoInicial);
				} else {
					MovimentoApartamentoEJB movimentoTaxa = (MovimentoApartamentoEJB) listTaxa
							.get(0);
					movimentoTaxa
							.setValorLancamento(Double
									.valueOf(movimentoTaxa.getValorLancamento()
											.doubleValue()
											+ mov.getValorLancamento()
													.doubleValue()
											* (hotel.getTaxaServico()
													.doubleValue() / 100.0D)));
					movimentos.add(movimentoTaxa);
					this.manager.merge(movimentoTaxa);
				}
			}
			for (MovimentoObjetoEJB obj : listaDevolucao) {
				obj = (MovimentoObjetoEJB) this.manager.find(
						MovimentoObjetoEJB.class, obj.getIdMovimentoObjeto());
				obj.setIdMovimentoApartamento(newMovApartamento
						.getIdMovimentoApartamento());
				this.manager.merge(obj);
			}
			return movimentos;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(Object entity) throws MozartSessionException {
		try {
			entity = this.manager.merge(entity);
			this.manager.remove(entity);
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object alterar(Object entity) throws MozartSessionException {
		try {
			this.manager.merge(entity);
			return entity;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void liberarCheckin(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		try {
			checkinCorrente = (CheckinEJB) this.manager.getReference(
					CheckinEJB.class, checkinCorrente.getIdCheckin());
			checkinCorrente.setCheckout("S");
			this.manager.merge(checkinCorrente);
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public RoomListEJB liberarHospede(RoomListEJB roomList)
			throws MozartSessionException {
		try {
			RoomListEJB room = (RoomListEJB) this.manager.find(
					RoomListEJB.class, roomList.getIdRoomList());
			room.setDataSaida(new Timestamp(new Date().getTime()));
			room.setPrincipal(roomList.getPrincipal());
			this.manager.merge(room);

			CheckinEJB checkin = room.getCheckin();
			checkin.setQtdeAdultos(checkin.getQtdeAdultos().longValue() - 1L);
			this.manager.merge(checkin);

			return room;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PontoVendaEJB> pesquisarPontoVendaByFiltro(
			PontoVendaEJB pFiltroPDV) throws MozartSessionException {
		try {
			return this.manager.createNamedQuery("PontoVendaEJB.findByFilter")
					.setParameter(1, pFiltroPDV.getId().getIdHotel())
					.getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object obter(Class class1, Object pk) throws MozartSessionException {
		try {
			Object obj = this.manager.find(class1, pk);
			if (!MozartUtil.isNull(obj)) {
				this.manager.refresh(obj);
			}
			return obj;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public StatusNotaEJB obterProximaNotaFiscal(Long pIdHotel)
			throws MozartSessionException {
		if (MozartUtil.isNull(pIdHotel)) {
			throw new MozartValidateException(
					"obterProximaNotaFiscal:Informe o hotel");
		}
		try {
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, pIdHotel);

			HotelEJB pHotel = this.manager.find(HotelEJB.class, pIdHotel);
			 
			String stringSqlNumNota = "select max(NUM_NOTA) from status_nota where id_hotel = ?1 ";
			BigDecimal numNota = (BigDecimal) manager.createNativeQuery(stringSqlNumNota)
							.setParameter(1, pIdHotel)
								.getSingleResult();
			Long numNotaAtu = (!MozartUtil.isNull(numNota))?numNota.longValue():0L;
			
 			String stringSqlNotaIni = "select max(nota_inicial) from status_nota where id_hotel = ?1 ";
			BigDecimal notaIni = (BigDecimal) manager.createNativeQuery(stringSqlNotaIni)
							.setParameter(1, pIdHotel)
								.getSingleResult();
			Long notaInicial = (!MozartUtil.isNull(notaIni))?notaIni.longValue():0L;
			
			controlaData.getUltimaNfs();
			StatusNotaEJB newNota = new StatusNotaEJB();
			newNota.setIdHotel(pIdHotel);
			newNota.setNumNota(numNotaAtu.longValue() + 1L + "");
			newNota.setStatus("OK");
			newNota.setRestaurante("N");

			Timestamp dataHora = new Timestamp(controlaData.getFrontOffice()
					.getTime());
			Date data = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			int hora = cal.get(11);
			int minuto = cal.get(12);
			int segundo = cal.get(13);

			cal.setTime(dataHora);
			cal.set(11, hora);
			cal.set(12, minuto);
			cal.set(13, segundo);

			newNota.setData(new Timestamp(cal.getTime().getTime()));

			newNota.setSerie(pHotel.getNotaFiscalTipo());
			newNota.setTipoOperacao("VS");
			newNota.setSituacaorps("C");
			newNota.setSituacaoNf("C");
			newNota.setTipoDocumento(new Long(1L));
			newNota.setTipoServico("SC");
			newNota.setTipoNota("F");
			newNota.setTipoNotaFiscal("NFS");
			newNota.setNotaFinal(Long.parseLong(notaInicial.longValue() + 1L + ""));
			newNota.setNotaInicial(Long.parseLong(notaInicial.longValue() + 1L + ""));

			controlaData.setUltimaNfs(numNota.longValue() + 1L);
			this.manager.merge(controlaData);
			this.manager.persist(newNota);
			return newNota;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ChartApartamentoVO> pesquisarChartApartamento(
			ChartApartamentoVO pFiltro) throws MozartSessionException {
		try {
			String qry = QRY_CHART_APARTAMENTO;

			List<Object[]> result = this.manager.createNativeQuery(qry)
					.setParameter(1, pFiltro.getIdHoteis()[0])
					.setParameter(2, pFiltro.getDataInicio())
					.setParameter(3, pFiltro.getDataFim()).getResultList();

			List<ChartApartamentoVO> resultado = new ArrayList();
			for (Object[] linha : result) {
				resultado.add(new ChartApartamentoVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<StatusNotaVO> pesquisarStatusNota(HotelEJB hotel,
			String tipoNota, Timestamp dataInicial, Timestamp dataFinal)
			throws MozartSessionException {
		try {
			List<StatusNotaVO> resultado = new ArrayList();

			if (MozartUtil.isNull(tipoNota)) {
				return resultado;
			}

			String qry = QRY_STATUS_NOTA;

			if ("F".equals(tipoNota)) {
				qry = qry
						+ " AND SN.TIPO_NOTA = ?4 AND NOTA_INICIAL IS NOT NULL ";
			}

			qry = qry + " ORDER BY sn.id_nota ";

			Query query = this.manager.createNativeQuery(qry);

			query.setParameter(1, hotel.getIdHotel())
					.setParameter(2, MozartUtil.format(dataInicial))
					.setParameter(3, MozartUtil.format(dataFinal));

			if ("F".equals(tipoNota)) {
				query.setParameter(4, tipoNota);
			}

			List<Object[]> result = query.getResultList();

			for (Object[] linha : result) {
				resultado.add(new StatusNotaVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProcurarHospedeVO> procurarHospede(ProcurarHospedeVO pFiltro)
			throws MozartSessionException {
		try {
			String qry = QRY_PROCURAR_HOSPEDE;

			List<Object[]> result = this.manager.createNativeQuery(qry)
					.setParameter(1, pFiltro.getIdHoteis()[0])
					.setParameter(2, pFiltro.getIdHoteis()[0])
					.setParameter(3, pFiltro.getNomeHospede()).getResultList();

			List<ProcurarHospedeVO> resultado = new ArrayList();
			for (Object[] linha : result) {
				resultado.add(new ProcurarHospedeVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoLancamentoEJB> pesquisarGrupoLancamento(
			TipoLancamentoEJB pFiltro) throws MozartSessionException {
		try {
			String qry = "select o from TipoLancamentoEJB o where o.idHotel = ?1 and o.subGrupoLancamento = '000' order by o.grupoLancamento";
			return this.manager.createQuery(qry)
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, pFiltro.getIdHotel()).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void unificaTaxasCheckin(CheckinEJB idCheckin)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery("{call PROC_UNIFICA_TAXAS(?1)}")
					.setParameter(1, idCheckin.getIdCheckin()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public RoomListEJB liberarHospedeComPrincipal(RoomListEJB roomList,
			Long idNovoRoomListPrincipal) throws MozartSessionException {
		try {
			RoomListEJB room = (RoomListEJB) this.manager.find(
					RoomListEJB.class, roomList.getIdRoomList());
			room.setDataSaida(new Timestamp(new Date().getTime()));
			room.setPrincipal(roomList.getPrincipal());
			this.manager.merge(room);

			CheckinEJB checkin = room.getCheckin();
			checkin.setQtdeAdultos(checkin.getQtdeAdultos().longValue() - 1L);
			this.manager.merge(checkin);
			if (!MozartUtil.isNull(idNovoRoomListPrincipal)) {
				room = (RoomListEJB) this.manager.find(RoomListEJB.class,
						idNovoRoomListPrincipal);
				room.setPrincipal("S");
				this.manager.merge(room);
			}
			return room;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void substituirHospedeCheckin(RoomListEJB roomListDe,
			HospedeEJB idNovoHospedeSubstituicao) throws MozartSessionException {
		try {
			HospedeEJB hospedePara = null;
			roomListDe = (RoomListEJB) this.manager.find(RoomListEJB.class,
					roomListDe.getIdRoomList());
			if (idNovoHospedeSubstituicao.getIdHospede() == null) {
				idNovoHospedeSubstituicao.setTipoHospedeEJB(roomListDe
						.getHospede().getTipoHospedeEJB());
				this.manager.persist(idNovoHospedeSubstituicao);
				hospedePara = idNovoHospedeSubstituicao;
			} else {
				hospedePara = (HospedeEJB) this.manager.find(HospedeEJB.class,
						idNovoHospedeSubstituicao.getIdHospede());
			}
			List<EmpresaSeguradoraEJB> lista = this.manager
					.createQuery(
							" select o from EmpresaSeguradoraEJB o, ControlaDataEJB cd where o.idSeguradora = 82 and o.idHotelSegurado = ?1 and o.idHotelSegurado = cd.idHotel and cd.frontOffice >= o.dtInicioSeguro and o.dtFimSeguro is null ")
					.setHint("eclipselink.refresh", "TRUE")
					.setParameter(1, roomListDe.getIdHotel()).getResultList();
			if (!MozartUtil.isNull(lista)) {
				if ((MozartUtil.isNull(hospedePara.getCpf()))
						&& (MozartUtil.isNull(hospedePara.getPassaporte()))) {
					throw new MozartValidateException(
							"O campo 'CPF' ou 'Passaporte' é obrigatório");
				}
				if (MozartUtil.isNull(hospedePara.getNascimento())) {
					throw new MozartValidateException(
							"O campo 'Dt. Nasc.' é obrigatório");
				}
				if (MozartUtil.isNull(hospedePara.getEmail())) {
					throw new MozartValidateException(
							"O campo 'E-mail' é obrigatório");
				}
				if (MozartUtil.isNull(hospedePara.getSexo())) {
					throw new MozartValidateException(
							"O campo 'Sexo' é obrigatório");
				}
			}
			roomListDe.setDataSaida(new Timestamp(new Date().getTime()));

			RoomListEJB roomListPara = new RoomListEJB();
			roomListPara.setHospede(hospedePara);
			roomListPara.setPrincipal("N");
			if ("S".equals(roomListDe.getPrincipal())) {
				roomListDe.setPrincipal("N");
				roomListPara.setPrincipal("S");
			}
			roomListPara.setCheckin(roomListDe.getCheckin());
			roomListPara.setChegou("S");

			roomListPara
					.setIdCentralReservas(roomListDe.getIdCentralReservas());
			roomListPara.setIdHotel(roomListDe.getIdHotel());
			roomListPara.setIdRedeHotel(roomListDe.getIdRedeHotel());
			roomListPara.setReservaApartamentoEJB(roomListDe
					.getReservaApartamentoEJB());
			roomListPara.setReservaEJB(roomListDe.getReservaEJB());

			this.manager.persist(roomListPara);
			this.manager.merge(roomListDe);

			this.manager
					.createNativeQuery(
							"update movimento_apartamento set id_room_list = ?1 where id_room_list = ?2 and mov_tmp = 'S' and checkout = 'N'")
					.setParameter(1, roomListPara.getIdRoomList())
					.setParameter(2, roomListDe.getIdRoomList())
					.executeUpdate();

			this.manager
					.createNativeQuery(
							"update movimento_objeto set id_room_list = ?1 where id_room_list = ?2")
					.setParameter(1, roomListPara.getIdRoomList())
					.setParameter(2, roomListDe.getIdRoomList())
					.executeUpdate();
			if ("S".equals(roomListDe.getCheckin().getCalculaSeguro())) {
				lancarSeguro(roomListDe.getCheckin());
			}
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public Object refresh(Class entity, Object pk)
			throws MozartSessionException {
		Object result = this.manager.getReference(entity, pk);
		this.manager.refresh(result);
		return result;
	}

	Logger log = Logger.getLogger(getClass());
	private EmpresaHotelEJB empresaHotelEJB;

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarCheckin(UsuarioEJB usuario,
			List<CheckinEJB> listaCheckinConfirmado)
			throws MozartSessionException {
		try {
			Date dataFim = null;
			for (CheckinEJB checkinCorrente : listaCheckinConfirmado) {
				Date dataInicio = new Date();
				popularReserva(checkinCorrente);
				dataFim = new Date();
				this.log.warn("popularReserva: "
						+ (dataFim.getTime() - dataInicio.getTime()));

				dataInicio = new Date();
				validarCheckin(checkinCorrente);
				dataFim = new Date();
				this.log.warn("validarCheckin: "
						+ (dataFim.getTime() - dataInicio.getTime()));

				this.manager
						.createQuery(
								"delete from RoomListEJB r where r.checkin is null and r.reservaApartamentoEJB.idReservaApartamento =?1")
						.setParameter(
								1,
								checkinCorrente.getReservaApartamentoEJB()
										.getIdReservaApartamento())
						.executeUpdate();

				this.manager.merge(checkinCorrente.getReservaApartamentoEJB());

				this.manager.persist(checkinCorrente);
				if ("N".equals(checkinCorrente.getApartamentoEJB().getCofan())) {
					gerarMovimentoApartamento(checkinCorrente);
				}
			}
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@SuppressWarnings("unused")
	private EmpresaHotelEJB getEmpresaHotel(CheckinEJB checkinCorrente) {
		if (this.empresaHotelEJB == null) {
			this.empresaHotelEJB = new EmpresaHotelEJB();
			this.empresaHotelEJB.setIdHotel(checkinCorrente.getHotelEJB()
					.getIdHotel());
			this.empresaHotelEJB.setIdEmpresa(checkinCorrente.getReservaEJB()
					.getIdEmpresa());

			checkinCorrente.setIdHotel(checkinCorrente.getHotelEJB()
					.getIdHotel());
			checkinCorrente.setIdEmpresa(checkinCorrente.getReservaEJB()
					.getIdEmpresa());
			checkinCorrente.setEmpresaHotelEJB(null);

			this.log.warn("empresaHotelEJB: "
					+ this.empresaHotelEJB.getIdHotel() + "-"
					+ this.empresaHotelEJB.getIdEmpresa());
			this.log.warn("empresaHotelEJB: " + this.empresaHotelEJB);
		}
		return this.empresaHotelEJB;
	}

	private void popularReserva(CheckinEJB checkinCorrente) {
		Date dataFim = null;

		Date dataInicio = new Date();
		ReservaApartamentoEJB resApto = new ReservaApartamentoEJB();
		resApto = (ReservaApartamentoEJB) this.manager.find(
				ReservaApartamentoEJB.class, checkinCorrente
						.getReservaApartamentoEJB().getIdReservaApartamento());
		dataFim = new Date();
		this.log.warn("resApto: " + (dataFim.getTime() - dataInicio.getTime()));

		checkinCorrente.getReservaApartamentoEJB().setIdHotel(
				resApto.getIdHotel());
		checkinCorrente.setReservaEJB(resApto.getReservaEJB());
		checkinCorrente.setCheckout("N");

		dataInicio = new Date();
		ApartamentoEJB apto = new ApartamentoEJB();
		apto.setIdApartamento(checkinCorrente.getReservaApartamentoEJB()
				.getApartamentoEJB().getIdApartamento());
		apto.setIdHotel(resApto.getIdHotel());
		apto = obterApartamentoByPK(new ApartamentoEJBPK(
				apto.getIdApartamento(), resApto.getIdHotel()));
		checkinCorrente.setApartamentoEJB(apto);
		dataFim = new Date();
		this.log.warn("apto: " + (dataFim.getTime() - dataInicio.getTime()));

		dataInicio = new Date();
		checkinCorrente.setIdHotel(checkinCorrente.getHotelEJB().getIdHotel());
		checkinCorrente.setIdEmpresa(checkinCorrente.getReservaEJB()
				.getIdEmpresa());
		checkinCorrente.setEmpresaHotelEJB(null);

		dataFim = new Date();
		this.log.warn("getEmpresaHotel: "
				+ (dataFim.getTime() - dataInicio.getTime()));

		checkinCorrente.setCortesia(checkinCorrente.getReservaEJB()
				.getCortesia());
		checkinCorrente.setCalculaIss(checkinCorrente.getReservaEJB()
				.getCalculaIss());
		checkinCorrente.setCalculaTaxa(checkinCorrente.getReservaEJB()
				.getCalculaTaxa());
		checkinCorrente.setCalculaRoomtax(checkinCorrente.getReservaEJB()
				.getCalculaRoomtax());
		checkinCorrente.setCalculaSeguro(checkinCorrente.getReservaEJB()
				.getCalculaSeguro());
		checkinCorrente.setCredito("S");
		checkinCorrente.setDataEntrada(resApto.getDataEntrada());
		checkinCorrente.setDataSaida(resApto.getDataSaida());

		checkinCorrente.setQtdeAdultos(resApto.getQtdePax());
		checkinCorrente.setAdicional(resApto.getAdicional());
		checkinCorrente.setQtdeCriancas(resApto.getQtdeCrianca());
		checkinCorrente.setTipoPensao(resApto.getReservaEJB().getTipoPensao());
		checkinCorrente.setJustificaTarifa(resApto.getJustificaTarifa());

		checkinCorrente.setFlgAlcoolica(resApto.getReservaEJB()
				.getFlgAlcoolica());
		checkinCorrente.setTipoTarifa(resApto.getTarifaManual());

		Double valor = resApto.getTarifa();
		if (!MozartUtil.isNull(resApto.getReservaApartamentoDiariaEJBList())) {
			for (ReservaApartamentoDiariaEJB diaria : resApto
					.getReservaApartamentoDiariaEJBList()) {
				if ((diaria.getData() != null)
						&& (checkinCorrente.getDataEntrada().compareTo(
								diaria.getData()) == 0)) {
					valor = diaria.getTarifa();
					break;
				}
			}
		}
		checkinCorrente.setTarifa(valor);

		checkinCorrente.setCheckinGrupoLancamentoEJBList(new ArrayList());
		for (ReservaGrupoLancamentoEJB grupo : checkinCorrente.getReservaEJB()
				.getReservaGrupoLancamentoEJBList()) {
			CheckinGrupoLancamentoEJB grupoLanc = new CheckinGrupoLancamentoEJB();
			grupoLanc.setCheckinEJB(checkinCorrente);
			grupoLanc.setIdHotel(resApto.getIdHotel());
			IdentificaLancamentoEJB ident = new IdentificaLancamentoEJB();
			ident.setIdIdentificaLancamento(grupo.getIdIdentificaLancamento());
			grupoLanc.setIdentificaLancamentoEJB(ident);
			grupoLanc.setQuemPaga(grupo.getQuemPaga());
			checkinCorrente.getCheckinGrupoLancamentoEJBList().add(grupoLanc);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MovAptoPgtoAntecipadoVO> buscarPagamentoAntecipado(
			Long idReserva) throws MozartSessionException {
		String sql = "";
		String orderBy = " order by NUM_APARTAMENTO ";
		sql = QRY_MOV_APTO_PGTO_ANTECIPADO;
		String paramIdReserva = "";

		if (!MozartUtil.isNull(idReserva)) {
			paramIdReserva = idReserva.toString();
			paramIdReserva = paramIdReserva + "%";
		}

		List lista = null;
		lista = this.manager.createNativeQuery(sql)
				.setParameter(1, paramIdReserva).getResultList();

		List<MovAptoPgtoAntecipadoVO> resultado = new ArrayList<MovAptoPgtoAntecipadoVO>();
		for (Object l : lista) {
			resultado.add(new MovAptoPgtoAntecipadoVO((Object[]) l));
		}

		return resultado;
	}
	
	public List<ContaCorrenteGeralVO> pesquisarContaCorrenteGeral(ContaCorrenteGeralVO pFiltro) throws MozartSessionException{
		List<ContaCorrenteGeralVO> resultado = new ArrayList<ContaCorrenteGeralVO>();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT CIN.ID_CHECKIN, A.NUM_APARTAMENTO, ER.NOME_FANTASIA, CIN.OBSERVACAO, H.SIGLA "
				+ "\n FROM CHECKIN CIN "
				+ "\n JOIN APARTAMENTO A ON (CIN.ID_APARTAMENTO = A.ID_APARTAMENTO)"
				+ "\n JOIN CONTROLA_DATA CD ON (CIN.ID_HOTEL = CD.ID_HOTEL)"
				+ "\n JOIN EMPRESA_REDE ER ON (CD.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND CIN.ID_EMPRESA = ER.ID_EMPRESA) "
				+ "\n JOIN HOTEL H ON (CIN.ID_HOTEL= H.ID_HOTEL) "
				+ "\n WHERE 1=1 "
				+ "\n AND CIN.ID_HOTEL = ? "
				+ "\n AND CIN.CHECKOUT = ? ");
		
			
		if (!MozartUtil.isNull(pFiltro.getFiltroApto()
				.getTipoIntervalo())) {
			sb.append(" and a.num_apartamento "
					+ pFiltro.getFiltroApto());
		}
		
		if (!MozartUtil.isNull(pFiltro.getFiltroEmpresa()
				.getTipoIntervalo())) {
			sb.append(" and UPPER(er.NOME_FANTASIA) "
					+ pFiltro.getFiltroEmpresa());
		}
		
		sb.append("\n ORDER BY NUM_APARTAMENTO ");
		
		List lista = this.manager.createNativeQuery(sb.toString())
				.setParameter(1, pFiltro.getIdHoteis()[0])
				.setParameter(2, 'N').getResultList();
		
		for (Object l : lista) {
			resultado.add(new ContaCorrenteGeralVO((Object[]) l));
		}
		
		return resultado;
	}
	
	public List obterValidacaoContrato(Long idHotel) throws MozartSessionException {
		try {
			StringBuilder sb= new StringBuilder();
			sb.append(" SELECT ''||COUNT(*) "
					+ " FROM LOG_USUARIO LO "
					+ " join controla_data cd on lo.id_hotel = cd.id_hotel "
					+ " WHERE LO.TABELA_AUDITADA = 'LANCAMENTO_SERVIÇOS'"
					+ " AND trunc(LO.DATA) = trunc(cd.front_office) "
					+ " AND LO.ID_HOTEL = " + idHotel);
			sb.append("\n union all \n");
			sb.append("SELECT FC_AGRUPA_DADOS('SELECT TRIM (SC.ID_CONTRATO || '' - '' || ER.NOME_FANTASIA) FROM SERVICOS_CONTRATO SC JOIN CONTROLA_DATA CD ON (SC.ID_HOTEL = CD.ID_HOTEL) JOIN EMPRESA_REDE ER  ON (CD.ID_REDE_hotel = ER.ID_REDE_hotel  AND SC.ID_EMPRESA = ER.ID_EMPRESA)  WHERE  SC.ID_HOTEL = "
					+ idHotel
					+ " AND TRUNC (SC.DATA_FIM) <= TRUNC (CD.FRONT_OFFICE)  AND SC.CANCELADO = ''N''  ORDER BY ER.NOME_FANTASIA',',') FROM DUAL ");
			sb.append("\n union all \n");
			sb.append("SELECT FC_AGRUPA_DADOS('SELECT TRIM (SC.ID_CONTRATO || '' - '' || ER.NOME_FANTASIA) FROM SERVICOS_CONTRATO SC"
					+ " JOIN CONTROLA_DATA CD"
					+ " ON (SC.ID_HOTEL = CD.ID_HOTEL)"
					+ " JOIN EMPRESA_REDE ER "
					+ " ON (CD.ID_REDE_hotel = ER.ID_REDE_hotel AND sc.id_empreSA = ER.ID_EMPRESA)"
					+ " JOIN CHECKIN CIN"
					+ " ON (SC.ID_EMPRESA = CIN.ID_EMPRESA) "
					+ " WHERE     SC.ID_HOTEL = "
					+ idHotel
					+ " AND TRUNC (SC.DATA_FIM) <= TRUNC (CD.FRONT_OFFICE)"
					+ " AND SC.CANCELADO = ''N''"
					+ " AND CIN.CHECKOUT = ''N'' ORDER BY ER.NOME_FANTASIA',',') FROM DUAL  ");
			
			return this.manager
					.createNativeQuery(sb.toString())
					.getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void lancarContrato(ControlaDataEJB controlaData)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_SERV_LANC_CONTRATO_WEB(?1)}").setParameter(1,
							controlaData.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
		
	}

	@Override
	public CidadeEJB pesquisarCidadePorCodigoIBGE(Long valor) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT c FROM CidadeEJB c WHERE c.codigoIbge = ?1 ");
		
		return (CidadeEJB)this.manager.createQuery(sb.toString())
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, valor).getSingleResult();
	}

	@Override
	public List<CheckinVO> pesquisarChekinPorApartamentoOuHospedeLike(CheckinVO filtro) {
		
		String sql = "select c.id_checkin,"
						+ "(a.num_apartamento||' - '|| hosp.nome_hospede||' '||hosp.sobrenome_hospede) apartamento  \r\n" + 
					"from checkin c \r\n" + 
							"join room_list rl on c.id_checkin = rl.id_checkin \r\n" + 
							"join hospede hosp on rl.id_hospede = hosp.id_hospede \r\n" + 
							"join apartamento a on c.id_apartamento = a.id_apartamento \r\n" + 
					"where c.id_hotel = "+filtro.getIdHoteis()[0]+ " \r\n" + 
							"and c.checkout = 'N' \r\n" + 
							"and rl.data_saida is null \r\n" + 
							"and rl.principal = 'S' \r\n" + 
							"AND (UPPER(TRIM(A.NUM_APARTAMENTO)) LIKE '%"+filtro.getNomeHospede().toUpperCase()+"%' \r\n" + 
							"OR UPPER(TRIM(hosp.nome_hospede)) LIKE  '%"+filtro.getNomeHospede().toUpperCase()+"%'  \r\n" + 
							"OR UPPER(TRIM(hosp.sobrenome_hospede)) LIKE '%"+filtro.getNomeHospede().toUpperCase() +"%')\r\n" + 
					"order by a.num_apartamento";
		
		
		List <CheckinVO> lista = new ArrayList<>();
		
		List <Object[]> listaQuery = this.manager.createNativeQuery(sql).getResultList();
		
		for(Object[] obj : listaQuery) {
			Object[] param = (Object[]) obj;
			
			CheckinVO vo = new CheckinVO();
			vo.setIdCheckin(Long.parseLong(param[0].toString()));
			vo.setNomeHospede(param[1] == null ? null : param[1].toString());
			lista.add(vo);
		}
		
		return lista;
	}
}