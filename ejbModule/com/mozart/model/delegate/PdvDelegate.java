package com.mozart.model.delegate;

import java.text.ParseException;
import java.util.List;

import com.mozart.model.ejb.entity.CaixaPontoVendaEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MesaEJB;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.ejb.entity.MovimentoRestauranteEJB;
import com.mozart.model.ejb.entity.NfeMovRestConfinsEJB;
import com.mozart.model.ejb.entity.PartnerDominioEJB;
import com.mozart.model.ejb.entity.PontoVendaEJB;
import com.mozart.model.ejb.entity.RestTlHtlEJB;
import com.mozart.model.ejb.entity.RoomListEJB;
import com.mozart.model.ejb.entity.StatusNotaEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.facade.PdvSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.DadosDescricaoVendaNotaVO;
import com.mozart.model.vo.DadosFormaPagamentoNotaVO;
import com.mozart.model.vo.DadosGeraisNotaVO;
import com.mozart.model.vo.DadosResumoItensNotaVO;
import com.mozart.model.vo.MovimentoRestauranteVO;
import com.mozart.model.vo.NotaFiscalEnvioVO;
import com.mozart.model.vo.NotaFiscalVO;
import com.mozart.model.vo.ProdutoEnvioVO;

public class PdvDelegate extends MozartDelegate {

	private static PdvDelegate instance;
	private static PdvSession session;

	private PdvDelegate() throws MozartSessionException {
		try {
			session = (PdvSession) getLookup("PdvSession");
			if (session == null) {
				throw new MozartSessionException("Não foi possivel localizar: PdvSession");
			}

		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public PontoVendaEJB gravarPontoVenda(PontoVendaEJB pPontoVenda) throws MozartSessionException {
		return session.gravarPontoVenda(pPontoVenda);
	} 
	
	public CaixaPontoVendaEJB gravarCaixaPontoVenda(CaixaPontoVendaEJB entidade)
			throws MozartSessionException {

		return session.gravarCaixaPontoVenda(entidade);
	}

	public MovimentoApartamentoEJB gravarMovimentoApartamento(MovimentoApartamentoEJB entidade)
			throws MozartSessionException {

		return session.gravarMovimentoApartamento(entidade);
	}

	public StatusNotaEJB gravarStatusNota(StatusNotaEJB entidade)
			throws MozartSessionException {
		
		return session.gravarStatusNota(entidade);
	}

	public static PdvDelegate instance() throws MozartSessionException {
		if (instance == null)
			instance = new PdvDelegate();
		return instance;
	}

	public List<MovimentoRestauranteVO> pesquisarMovimentoRestaurante(MovimentoRestauranteVO pFiltro)
			throws MozartSessionException {

		return session.pesquisarMovimentoRestaurante(pFiltro);
	}

	public MovimentoRestauranteEJB gravarMovimentoRestaurante(MovimentoRestauranteEJB movimentoRestaurante,
			MesaEJB mesa) throws MozartSessionException {
		return session.gravarMovimentoRestaurante(movimentoRestaurante, mesa);
	}

	public void excluir(MovimentoRestauranteEJB movimentoRestaurante) throws MozartSessionException {
		session.excluir(movimentoRestaurante);
	}

	public RoomListEJB getRoomListPrincipalCheckin(Long pIdCheckin, String pPrincipal) throws MozartSessionException {
		return session.getRoomListPrincipalCheckin(pIdCheckin, pPrincipal);
	}
	public HotelEJB getHotelPorRestaurante(Long pIdRestaurante) throws MozartSessionException {
		return session.getHotelPorRestaurante(pIdRestaurante);
	}

	public TipoLancamentoEJB consultarTipoLancamentoParaRestauranteTerceirizado (
			TipoLancamentoEJB pTipoLancamentoRestaurante) throws MozartSessionException{
		return session.consultarTipoLancamentoParaRestauranteTerceirizado(pTipoLancamentoRestaurante);
	}
	public TipoLancamentoEJB consultarTipoLancamentoDoRestaurante(
			TipoLancamentoEJB pTipoLancamentoRestaurante, HotelEJB pRestaurante) throws MozartSessionException{
		return session.consultarTipoLancamentoDoRestaurante(pTipoLancamentoRestaurante, pRestaurante);
	}

	public List<MovimentoRestauranteEJB> consultarMovimentacaoMesa(MesaEJB mesaEJB) throws MozartSessionException{
		return session.consultarMovimentacaoMesa(mesaEJB);
		
	}

	public RestTlHtlEJB consultarRestTlHtl(TipoLancamentoEJB tipoLancamentoHotel,
			TipoLancamentoEJB tipoLancamentoRest) throws MozartSessionException{
		// TODO Auto-generated method stub
		return session.consultarRestTlHtl( tipoLancamentoHotel,
				tipoLancamentoRest);
	}
	
	public NfeMovRestConfinsEJB gravarMovCofins(NfeMovRestConfinsEJB entidade) throws MozartSessionException{
		return session.gravarMovCofins(entidade);
	}
	
	public String obterChaveNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException {
		return session.obterChaveNota(hotel, nota);
	}
	
	public List<DadosGeraisNotaVO> obterDadosGeraisNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException
	{
		return session.obterDadosGeraisNota(hotel, nota);
	} 
	
	public List<DadosDescricaoVendaNotaVO> obterDescricaoVendaNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException{
		return session.obterDescricaoVendaNota(hotel, nota);
	}
	
	public List<DadosResumoItensNotaVO> obterResumoItensNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException{
		return session.obterResumoItensNota(hotel, nota);
	}
	
	public List<DadosFormaPagamentoNotaVO> obterFormaPagamentoNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException{
		return session.obterFormaPagamentoNota(hotel, nota);
	}
	
	public void executarProcedureNfeRestaurante(Long idMovimentoRestaurante) throws MozartSessionException{
		session.executarProcedureNfeRestaurante(idMovimentoRestaurante);
	}
	
	public String obterUrlQrCode(PontoVendaEJB pdv) throws MozartSessionException{
		return session.obterUrlQrCode(pdv);
	}
	
	public NotaFiscalEnvioVO consultarNotaFiscalEmissao(NotaFiscalEnvioVO filtro) throws MozartSessionException, ParseException{
		return session.consultarNotaFiscalEmissao(filtro);
	}
	
	public List<ProdutoEnvioVO> obterProdutosEmissaoNota(ProdutoEnvioVO filtro) throws MozartSessionException {
		return session.obterProdutosEmissaoNota(filtro);
	}
	
	public PartnerDominioEJB getDesignHotel(String urlHotel) throws MozartSessionException{
		return session.getDesignHotel(urlHotel);
	}
	
	public List<NotaFiscalVO> consultarNotaFiscalNfce(NotaFiscalVO pFiltro) throws MozartSessionException{
		return session.consultarNotaFiscalNfce(pFiltro);
	}
}

