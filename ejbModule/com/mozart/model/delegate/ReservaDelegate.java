	package com.mozart.model.delegate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.ReservaApartamentoEJB;
import com.mozart.model.ejb.entity.ReservaApartamentoEJBPK;
import com.mozart.model.ejb.entity.ReservaEJB;
import com.mozart.model.ejb.entity.ReservaMidiaEJB;
import com.mozart.model.ejb.facade.OperacionalSession;
import com.mozart.model.ejb.facade.ReservaSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
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

public class ReservaDelegate extends MozartDelegate {
	private static ReservaDelegate instance;
	private static ReservaSession session;

	private ReservaDelegate() throws MozartSessionException {
		try {
			session = (ReservaSession) getLookup("ReservaSessionEJB");
			if (session == null) {
				throw new MozartSessionException("Não foi possivel localizar: ReservaSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	private ReservaDelegate(String name) throws MozartSessionException {

		try {
            session = (ReservaSession) getLookup(name, "ReservaSessionEJB");
			if (session == null) {
				throw new MozartSessionException("Não foi possivel localizar: ReservaSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static ReservaDelegate instance(String name) throws MozartSessionException {
		return instance == null ? instance = new ReservaDelegate(name) : instance;
	}

	public static ReservaDelegate instance() throws MozartSessionException {
		return instance == null ? instance = new ReservaDelegate() : instance;
	}

	public List<ReservaApartamentoEJB> obterReservaApartamentoSemCheckin(ReservaEJB reserva)
			throws MozartSessionException {
		return session.obterReservaApartamentoSemCheckin(reserva);

	}

	public ReservaApartamentoEJB obterReservaApartamento(ReservaApartamentoEJBPK pk) {
		return session.obterReservaApartamento(pk);
	}

	public List<ReservaVO> pesquisarReservas(ReservaVO vo) throws MozartSessionException {
		return session.pesquisarReservas(vo);
	}

	public List<BloqueioVO> pesquisarReservas(BloqueioVO vo) throws MozartSessionException {
		return session.pesquisarReservas(vo);
	}

	public EmpresaHotelVO obterEmpresaHotelPorIdEHotel(EmpresaHotelVO vo) throws MozartSessionException {
		return session.obterEmpresaHotelPorIdEHotel(vo);
	}

	public List<TipoApartamentoVO> obterTipoApartamentoPorHotel(TipoApartamentoVO vo) throws MozartSessionException {
		return session.obterTipoApartamentoPorHotel(vo);
	}

	public List<TipoDiariaVO> obterTipoDiariaPorHotel(TipoDiariaVO vo) throws MozartSessionException {
		return session.obterTipoDiariaPorHotel(vo);
	}

	public List<ApartamentoVO> obterApartamentoPorDisponibilidade(ApartamentoVO vo) throws MozartSessionException {
		return session.obterApartamentoPorDisponibilidade(vo);
	}

	public TipoApartamentoVO obterTipoApartamentoPorId(TipoApartamentoVO vo) throws MozartSessionException {
		return session.obterTipoApartamentoPorId(vo);
	}

	public TipoApartamentoVO obterTipoApartamentoPorCodigoEOuIdHotel(String codigo, Long idHotel) throws MozartSessionException {
		return session.obterTipoApartamentoPorCodigoEOuIdHotel(codigo, idHotel);
	}

	public HotelEJB obterHotelPorCodigo(String codigo) throws MozartSessionException {
		return session.obterHotelPorCodigo(codigo);
	}

	public ApartamentoVO obterApartamentoPorId(ApartamentoVO vo) throws MozartSessionException {
		return session.obterApartamentoPorId(vo);
	}

	public TipoDiariaVO obterTipoDiariaPorId(TipoDiariaVO vo) throws MozartSessionException {
		return session.obterTipoDiariaPorId(vo);
	}

	public List<TarifaVO> obterTarifaPorPeriodo(ReservaApartamentoVO vo) throws MozartSessionException {
		return session.obterTarifaPorPeriodo(vo);
	}

	public List<HospedeVO> obterHospedePorNome(HospedeVO vo) throws MozartSessionException {
		return session.obterHospedePorNome(vo);
	}

	public HospedeVO obterHospedePorId(HospedeVO vo) throws MozartSessionException {
		return session.obterHospedePorId(vo);
	}

	public EmpresaRedeVO obterEmpresaRedePorIdERede(EmpresaRedeVO vo) throws MozartSessionException {
		return session.obterEmpresaRedePorIdERede(vo);
	}

	public List<EmpresaGrupoLancamentoVO> obterEmpresaGrupoLancamentoPorHotelEEmpresa(EmpresaGrupoLancamentoVO vo)
			throws MozartSessionException {
		return session.obterEmpresaGrupoLancamentoPorHotelEEmpresa(vo);
	}

	public List<PagamentoReservaVO> obterTiposDePagamentoReserva(PagamentoReservaVO vo) throws MozartSessionException {
		return session.obterTiposDePagamentoReserva(vo);
	}

	public void salvarReserva(ReservaVO reservaVO) throws MozartSessionException {
		try {
			session.salvarReserva(reservaVO);
		} catch (MozartValidateException ex) {
			throw ex;

		} catch (Exception ex) {
			String msg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
			if (msg != null && msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			} else {
				throw new MozartSessionException(ex.getMessage());
			}
		}

	}

	public Long obterNextVal() throws MozartSessionException {
		return session.obterNextVal();
	}

	public ReservaVO obterReservaPorId(ReservaVO vo) throws MozartSessionException {
		return session.obterReservaPorId(vo);
	}

	public ReservaVO obterReservaPorIdGds(ReservaVO vo) throws MozartSessionException {
		return session.obterReservaPorIdGds(vo);
	}

	public BloqueioGestaoVO obterBloqueioGestaoPorId(BloqueioGestaoVO vo) throws MozartSessionException {
		return session.obterBloqueioGestaoPorId(vo);
	}

	public List<ReservaVO> obterBloqueioLookup(ReservaVO vo) throws MozartSessionException {
		return session.obterBloqueioLookup(vo);
	}

	public List<ReservaApartamentoVO> obterReservaApartamentoPorIdReserva(ReservaVO vo) throws MozartSessionException {
		return session.obterReservaApartamentoPorIdReserva(vo);
	}

	public List<ReservaApartamentoDiariaVO> obterReservaApartamentoDiariaPorIdReserva(ReservaVO vo)
			throws MozartSessionException {
		return session.obterReservaApartamentoDiariaPorIdReserva(vo);
	}

	public List<RoomListVO> obterRoomListPorIdReserva(ReservaVO vo) throws MozartSessionException {
		return session.obterRoomListPorIdReserva(vo);
	}

	public List<ReservaGrupoLancamentoVO> obterReservaGrupoLancamentoPorIdReserva(ReservaVO vo)
			throws MozartSessionException {
		return session.obterReservaGrupoLancamentoPorIdReserva(vo);
	}

	public List<PagamentoReservaVO> obterPagamentoReservaPorIdReserva(ReservaVO vo) throws MozartSessionException {
		return session.obterPagamentoReservaPorIdReserva(vo);
	}

	public void atualizarReserva(ReservaVO reservaVO) throws MozartSessionException {
		session.atualizarReserva(reservaVO);
	}

	public List<OcupDispVO> obterOcupacaoDisponibilidade(ReservaVO vo) throws MozartSessionException {
		return session.obterOcupacaoDisponibilidade(vo);
	}

	public List<ReservaMapaOcupacaoVO> pesquisarMapaOcupacao(ReservaMapaOcupacaoVO pFiltro)
			throws MozartSessionException {
		return session.pesquisarMapaOcupacao(pFiltro);

	}

	public void apagarReserva(ReservaVO reservaVO) throws MozartSessionException {
		try {
			session.apagarReserva(reservaVO);

		} catch (Exception ex) {
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			} else {
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}
	
	public boolean existeCheckinAtivo(ReservaVO reservaVO)
			throws MozartSessionException {
		return session.existeCheckinAtivo(reservaVO);
	}

	public void apagarReservaOmnibees(ReservaVO reservaVO) throws MozartSessionException {
		try {
			session.apagarReservaOmnibees(reservaVO);

		} catch (Exception ex) {
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0) {
				throw new MozartValidateException(msg.substring(msg.indexOf("ORA-20000:") + 11, msg.indexOf("ORA-065")));
			} else {
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}

	public void confirmarReserva(ReservaVO reservaVO) throws MozartSessionException {
		session.confirmarReserva(reservaVO);

	}

	public void destravarReserva(ReservaVO reservaVO) throws MozartSessionException {
		session.destravarReserva(reservaVO);
	}

	public List<ReservaVO> obterBloqueios(ReservaVO paramReservaVO) throws MozartSessionException {
		return session.obterBloqueios(paramReservaVO);
	}

	public List<BloqueioGestaoVO> obterBloqueioGestaoEmpresa(EmpresaHotelEJB pFiltro) throws MozartSessionException {
		return session.obterBloqueioGestaoEmpresa(pFiltro);
	}

	public List<TarifaApartamentoGestaoBloqueioVO> obterGridTarBloqueioGestaoEmpresa(ReservaVO pFiltro)
			throws MozartSessionException {
		return session.obterGridTarBloqueioGestaoEmpresa(pFiltro);
	}

	/**
	 * Salva lista de Tarifas Bloqueio
	 * 
	 * @param pTarifaApartamentoGestaoBloqueioVO
	 * @throws MozartSessionException
	 */
	public void salvarReservaApartamentoGestaoBloqueioVO(
			TarifaApartamentoGestaoBloqueioVO pTarifaApartamentoGestaoBloqueioVO) throws MozartSessionException {
		session.salvarReservaApartamentoGestaoBloqueioVO(pTarifaApartamentoGestaoBloqueioVO);
	}
	
	public void salvarTarifaApartamentoGestaoBloqueioVO(
			TarifaApartamentoGestaoBloqueioVO pTarifaApartamentoGestaoBloqueioVO) throws MozartSessionException {
		session.salvarTarifaApartamentoGestaoBloqueioVO(pTarifaApartamentoGestaoBloqueioVO);
	}

	public List<QuantidadeAptoGestaoBloqueioVO> obterGridQtdAptoBloqTipo(ReservaVO paramReservaVO)
			throws MozartSessionException {

		return session.obterGridQtdAptoBloqTipo(paramReservaVO);
	}

	public List<DisponibilidadeAptoGestaoBloqueioVO> obterGridDisponibilidadeAptoBloq(ReservaVO paramReservaVO)
			throws MozartSessionException{
		return session.obterGridDisponibilidadeAptoBloq(paramReservaVO);
	}

	public void salvarQtdAptoBloqueio(QuantidadeAptoGestaoBloqueioVO pQuantidadeAptoGestaoBloqueioVO)
			throws MozartSessionException {
		session.salvarQtdAptoBloqueio(pQuantidadeAptoGestaoBloqueioVO);
	}
	
	public List<DisponibilidadeGdsVO> obterDisponibilidadeGDS(DisponibilidadeGdsVO entrada)
			throws MozartSessionException {
		
		if("B".equals(session.obterTipoDisponibilidade(entrada.getIdGds().longValue()))){
			return session.obterDisponibilidadeGDS(entrada);
		}
		
		return session.obterDisponibilidadeGDSTotal(entrada);	
	}
	
	public GdsCanalVO obterGdsCanal(Long idGds, Long idEmpresa, Long idHotel, String codigo) throws MozartSessionException {
		return session.obterGdsCanal(idGds, idEmpresa, idHotel, codigo);
	}
	
	public BloqueioVO obterDadosGeraisEmpresa(Long idRedeHotel, Long idHotel) throws MozartSessionException {
		return session.obterDadosGeraisEmpresa(idRedeHotel, idHotel);
	}
	
    public BloqueioVO obterDadosGeraisEmpresaNaoParticular(Long idEmpresa, Long idRedeHotel, Long idHotel) throws MozartSessionException {
        return session.obterDadosGeraisEmpresaNaoParticular(idEmpresa, idRedeHotel, idHotel);
    }
    
	public BloqueioVO obterBloqueio(Long idHotel, Long idEmpresa, Date dataInicio, Date dataFim) throws MozartSessionException{
		return session.obterBloqueio(idHotel, idEmpresa, dataInicio, dataFim);
	}
	
	public Double obterComissao(long idEmpresa, long idHotel) throws MozartSessionException{
		return session.obterComissao(idEmpresa, idHotel);
	}

	public TipoDiariaVO obterTipoDiariaPorHotelEPadrao(TipoDiariaVO vo)
			throws MozartSessionException {
		return session.obterTipoDiariaPorHotelEPadrao(vo);
	}
	
	public String obterTipoPagamentoPorHotel(long idHotel) throws MozartSessionException{
		return session.obterTipoPagamentoPorHotel(idHotel);
	}

	public String obterTipoDisponibilidade(Long idGds) throws MozartSessionException {
		return session.obterTipoDisponibilidade(idGds);
	}
	
	public List<ReservaMidiaEJB> obterListaReservaMidia() throws MozartSessionException{
		return session.obterListaReservaMidia();
	}
	
	public List obterComboApartamentoCofan(Long pIdHotel) throws MozartSessionException{
		return session.obterComboApartamentoCofan(pIdHotel);
		
	}

	public List<BloqueioGestaoVO> obterBloqueioGestaoEmpresa(
			EmpresaHotelEJB pFiltro, Timestamp frontOffice)  throws MozartSessionException{
		return session.obterBloqueioGestaoEmpresa(pFiltro, frontOffice);
	}

	public HotelVO obterEmailsCentralReserva(Long pIdHotel) throws MozartSessionException{
		return session.obterEmailsCentralReserva(pIdHotel);
	}
}