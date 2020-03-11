package com.mozart.model.delegate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.ApartamentoEJBPK;
import com.mozart.model.ejb.entity.CheckinEJB;
import com.mozart.model.ejb.entity.CidadeEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HospedeEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MoedaEJB;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.ejb.entity.MovimentoObjetoEJB;
import com.mozart.model.ejb.entity.PontoVendaEJB;
import com.mozart.model.ejb.entity.RoomListEJB;
import com.mozart.model.ejb.entity.StatusNotaEJB;
import com.mozart.model.ejb.entity.TipoApartamentoEJB;
import com.mozart.model.ejb.entity.TipoDiariaEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJBPK;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.ejb.facade.CheckinSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.ChartApartamentoVO;
import com.mozart.model.vo.CheckinVO;
import com.mozart.model.vo.ContaCorrenteGeralVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.MovAptoPgtoAntecipadoVO;
import com.mozart.model.vo.ProcurarHospedeVO;
import com.mozart.model.vo.RoomListVO;
import com.mozart.model.vo.StatusNotaVO;

@SuppressWarnings("unchecked")
public class CheckinDelegate extends MozartDelegate {
	private static CheckinDelegate instance;
	private static CheckinSession session;

	private CheckinDelegate() throws MozartSessionException {
		try {
			session = (CheckinSession) getLookup("CheckinSession");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: CheckinSessionBean");
			}
		} catch (MozartSessionException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static CheckinDelegate instance() throws MozartSessionException {
		return instance == null ? (CheckinDelegate.instance = new CheckinDelegate())
				: instance;
	}
	
	private CheckinDelegate(String name) throws MozartSessionException {

		try {
            session = (CheckinSession) getLookup(name, "CheckinSession");
			if (session == null) {
				throw new MozartSessionException("Não foi possivel localizar: ReservaSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static CheckinDelegate instance(String name) throws MozartSessionException {
		return instance == null ? instance = new CheckinDelegate(name) : instance;
	}


	public List<TipoApartamentoEJB> obterTipoApartamento(
			TipoApartamentoEJB pTipoApartamentoEJB)
			throws MozartSessionException {
		return session.obterTipoApartamento(pTipoApartamentoEJB);
	}

	public List<CheckinVO> pesquisarCheckin(CheckinVO pCheckinVO)
			throws MozartSessionException {
		return session.pesquisarCheckin(pCheckinVO);
	}

	public List<ApartamentoEJB> pesquisarApartamento(ApartamentoEJB pApto) {
		return pesquisarApartamento(pApto, false);
	}
	public List<ApartamentoEJB> pesquisarApartamento(ApartamentoEJB pApto, Boolean incluirSujo) {
		return session.pesquisarApartamento(pApto, incluirSujo);
	}

	public List<ApartamentoEJB> obterApartamento(ApartamentoEJB pApto) {
		return session.obterApartamento(pApto);
	}

	public List<HospedeEJB> pesquisarHospede(HospedeVO param) {
		return session.pesquisarHospede(param);
	}

	public List<CidadeEJB> pesquisarCidade(String valor) {
		return session.pesquisarCidade(valor);
	}

	public List<TipoLancamentoEJB> pesquisarTipoLancamento(
			TipoLancamentoEJB valor) {
		return session.pesquisarTipoLancamento(valor);
	}

	public List<TipoLancamentoEJB> pesquisarSubGrupoLancamento(
			TipoLancamentoEJB valor) {
		return session.pesquisarSubGrupoLancamento(valor);
	}

	public HospedeEJB gravarHospede(HospedeEJB novoHospede)
			throws MozartSessionException {
		return session.gravarHospede(novoHospede);
	}

	public HospedeEJB obterHospede(HospedeEJB novoHospede)
			throws MozartSessionException {
		return session.findHospede(novoHospede);
	}

	public TipoDiariaEJB obterTipoDiariaPadraoByRede(Long idRedeHotel)
			throws MozartValidateException {
		return session.obterTipoDiariaPadraoByRede(idRedeHotel);
	}

	public TipoLancamentoEJB obterTipoLancamentoByPK(TipoLancamentoEJBPK chave) {
		return session.obterTipoLancamentoByPK(chave);
	}

	public List<TipoLancamentoEJB> pesquisarTipoLancamentoByFiltro(
			TipoLancamentoEJB tipoLancamento) throws MozartSessionException {
		return session.pesquisarTipoLancamentoByFiltro(tipoLancamento);
	}

	public CheckinEJB gravarWalkin(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		try {
			return session.gravarWalkin(checkinCorrente);
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg
						.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			}
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public CheckinEJB obterCheckin(Long idCheckin) throws MozartSessionException{
		CheckinEJB checkin = session.obterCheckin(idCheckin);
		try {
			checkin = obterCheckinComplemento(checkin);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return checkin;
	}

	public CheckinEJB obterCheckinComplemento(CheckinEJB checkin) {
		try {
			checkin = session.obterCheckinComplemento(checkin);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return checkin;
	}

	public ApartamentoEJB obterApartamentoByPK(ApartamentoEJBPK apartamentoEJBPK) {
		return session.obterApartamentoByPK(apartamentoEJBPK);
	}

	public List<TipoDiariaEJB> pesquisarTipoDiaria(TipoDiariaEJB pTipo) {
		return session.pesquisarTipoDiaria(pTipo);
	}

	public Object incluir(Object newEntity) throws MozartSessionException {
		try {
			return session.persist(newEntity);
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg
						.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			}
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public CheckinEJB gravarCheckout(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		try {
			return session.gravarCheckout(checkinCorrente);
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			String msg = ex.getCause() == null ? ex.getMessage() : ex
					.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg
						.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			}
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public CheckinEJB lancarTaxas(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		return session.lancarTaxas(checkinCorrente);
	}

	public StatusNotaEJB obterProximaNotaHospedagem(HotelEJB pHotel)
			throws MozartSessionException {
		return session.obterProximaNotaHospedagem(pHotel);
	}
	public StatusNotaEJB obterProximaNotaHospedagem(HotelEJB pHotel, String tipoNota)
			throws MozartSessionException {
		return session.obterProximaNotaHospedagem(pHotel, tipoNota);
	}
	public StatusNotaEJB atualizarDadosRPS(StatusNotaEJB pStatusNota)
			throws MozartSessionException {
		return session.atualizarDadosRPS(pStatusNota);
	}

	public void devolverObjetos(List<MovimentoObjetoEJB> listaDevolucao)
			throws MozartSessionException {
		session.devolverObjetos(listaDevolucao);
	}

	public List<MovimentoApartamentoEJB> pagarObjetos(
			MovimentoApartamentoEJB newMovApartamento,
			List<MovimentoObjetoEJB> listaDevolucao)
			throws MozartSessionException {
		return session.pagarObjetos(newMovApartamento, listaDevolucao);
	}

	public Object alterar(Object entity) throws MozartSessionException {
		try {
			return session.alterar(entity);
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg
						.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			}
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public void liberarCheckin(CheckinEJB checkinCorrente)
			throws MozartSessionException {
		try {
			session.liberarCheckin(checkinCorrente);
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg
						.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			}
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public RoomListEJB liberarHospede(RoomListEJB roomList)
			throws MozartSessionException {
		return session.liberarHospede(roomList);
	}

	public List<PontoVendaEJB> pesquisarPontoVendaByFiltro(
			PontoVendaEJB pFiltroPDV) throws MozartSessionException {
		return session.pesquisarPontoVendaByFiltro(pFiltroPDV);
	}

	public Object obter(Class class1, Object pk) throws MozartSessionException {
		return session.obter(class1, pk);
	}

	public StatusNotaEJB obterProximaNotaFiscal(Long idHotel)
			throws MozartSessionException {
		return session.obterProximaNotaFiscal(idHotel);
	}

	public List<ChartApartamentoVO> pesquisarChartApartamento(
			ChartApartamentoVO pFiltro) throws MozartSessionException {
		return session.pesquisarChartApartamento(pFiltro);
	}

	public List<StatusNotaVO> pesquisarStatusNota(HotelEJB hotel,
			String tipoNota, Timestamp dataInicial, Timestamp dataFinal)
			throws MozartSessionException {
		return session.pesquisarStatusNota(hotel, tipoNota, dataInicial,
				dataFinal);
	}

	public List<ProcurarHospedeVO> procurarHospede(ProcurarHospedeVO pFiltro)
			throws MozartSessionException {
		return session.procurarHospede(pFiltro);
	}

	public CheckinEJB obterCheckinParaAlteracao(Long idCheckin)
			throws MozartSessionException {
		return session.obterCheckinParaAlteracao(idCheckin);
	}

	public List<TipoLancamentoEJB> pesquisarGrupoLancamento(
			TipoLancamentoEJB pFiltro) throws MozartSessionException {
		return session.pesquisarGrupoLancamento(pFiltro);
	}

	public void unificaTaxasCheckin(CheckinEJB idCheckin)
			throws MozartSessionException {
		session.unificaTaxasCheckin(idCheckin);
	}

	public RoomListEJB liberarHospedeComPrincipal(RoomListEJB roomList,
			Long idNovoRoomListPrincipal) throws MozartSessionException {
		return session.liberarHospedeComPrincipal(roomList,
				idNovoRoomListPrincipal);
	}

	public void substituirHospedeCheckin(RoomListEJB roomListDe,
			HospedeEJB idNovoHospedeSubstituicao) throws MozartSessionException {
		session.substituirHospedeCheckin(roomListDe, idNovoHospedeSubstituicao);
	}

	public List<MoedaEJB> pesquisarMoeda() throws MozartSessionException {
		return session.pesquisarMoeda();
	}

	public Object refresh(Class entity, Object pk)
			throws MozartSessionException {
		try {
			return session.refresh(entity, pk);
		} catch (Exception ex) {
		}
		return null;
	}

	public void excluir(Object entidade) throws MozartSessionException {
		session.excluir(entidade);
	}

	public void gravarCheckin(UsuarioEJB usuarioEJB,
			List<CheckinEJB> listaCheckinConfirmado)
			throws MozartSessionException {
		try {
			session.gravarCheckin(usuarioEJB, listaCheckinConfirmado);
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg
						.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			}
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<MovAptoPgtoAntecipadoVO> buscarPagamentoAntecipado(Long idReserva) throws MozartSessionException{
		
		try {
			return session.buscarPagamentoAntecipado(idReserva);
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg
						.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			}
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<RoomListVO> pesquisarHospedeFNRH(RoomListEJB roomListEJB) throws MozartSessionException{
		return session.pesquisarHospedeFNRH(roomListEJB); 
	}
	
	
	public List<ContaCorrenteGeralVO> pesquisarContaCorrenteGeral(ContaCorrenteGeralVO pFiltro) throws MozartSessionException{
		
		return session.pesquisarContaCorrenteGeral(pFiltro); 
	}
	
	public List obterValidacaoContrato(Long idHotel) throws MozartSessionException{
		
		return session.obterValidacaoContrato(idHotel); 
	}

	public void lancarContrato(ControlaDataEJB controlaData) throws MozartSessionException{
		try{
			session.lancarContrato(controlaData);
		}catch(MozartValidateException ex){
			throw ex;
		}catch(Exception ex){
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}
	
	public List<MovimentoApartamentoEJB> obterMovimentosPorIdNota(Long idNota) throws MozartSessionException{
		return session.obterMovimentosPorIdNota(idNota);
	}
	
	public CidadeEJB pesquisarCidadePorCodigoIBGE(Long valor) {
		return session.pesquisarCidadePorCodigoIBGE(valor);
	}
	
	public List <CheckinVO> pesquisarChekinPorApartamentoOuHospedeLike(CheckinVO filtro) throws MozartSessionException{
		return session.pesquisarChekinPorApartamentoOuHospedeLike(filtro);
	}
}