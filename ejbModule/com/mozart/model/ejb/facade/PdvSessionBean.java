package com.mozart.model.ejb.facade;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.DadosDescricaoVendaNotaVO;
import com.mozart.model.vo.DadosFormaPagamentoNotaVO;
import com.mozart.model.vo.DadosGeraisNotaVO;
import com.mozart.model.vo.DadosResumoItensNotaVO;
import com.mozart.model.vo.MovimentoRestauranteVO;
import com.mozart.model.vo.NotaFiscalEnvioVO;
import com.mozart.model.vo.NotaFiscalVO;
import com.mozart.model.vo.ProdutoEnvioVO;
import com.mozart.model.vo.NotaFiscalVO.TypeOfNotaFiscal;

@Stateless(name = "PdvSession")
@SuppressWarnings("unchecked")
public class PdvSessionBean implements PdvSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	public List<MovimentoRestauranteVO> pesquisarMovimentoRestaurante(
			MovimentoRestauranteVO pFiltro) throws MozartSessionException {

		List resultList = null;
		List<MovimentoRestauranteVO> listaRetorno = new ArrayList();

		try {
			String sql = QUERY_MOVIMENTO_RESTAURANTE;

			if (!MozartUtil.isNull(pFiltro.getNummesa().getTipoIntervalo())) {
				sql = sql + " and M.NUM_MESA " + pFiltro.getNummesa();
			}
			if (!MozartUtil.isNull(pFiltro.getNomeprato().getTipoIntervalo())) {
				sql = sql + " and PRATO.NOME_PRATO " + pFiltro.getNomeprato();
			}
			if (!MozartUtil.isNull(pFiltro.getDatamovimento()
					.getTipoIntervalo())) {
				sql = sql + " and DATA_MOVIMENTO " + pFiltro.getDatamovimento();
			}
			if (!MozartUtil.isNull(pFiltro.getNumnota().getTipoIntervalo())) {
				sql = sql + " and NUM_NOTA " + pFiltro.getNumnota();
			}

			sql = sql + "order by DATA_MOVIMENTO desc\n";

			Query q = this.manager.createNativeQuery(sql).setParameter(1,
					pFiltro.getIdHoteis()[0]);
			resultList = q.getResultList();

			for (Object l : resultList) {
				listaRetorno.add(new MovimentoRestauranteVO((Object[]) l));
			}
			return listaRetorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public String obterChaveNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException {

		String result = null;
		
		try {
			String sql = QUERY_CHAVE_NOTA;

			Query q = this.manager.createNativeQuery(sql)
					.setParameter(1,hotel.getIdHotel())
					.setParameter(2,nota.getIdNota());
			result = (String) q.getSingleResult();

			return result + verificadorChave(result);
			
		} catch (Exception ex) {
			return "";
		}
	}
	
	public String obterUrlQrCode(PontoVendaEJB pdv) throws MozartSessionException {

		String result = null;
		
		try {
			String sql = QUERY_URL_QR_CODE;

			Query q = this.manager.createNativeQuery(sql)
					.setParameter(1,pdv.getId().getIdPontoVenda());
			result = (String) q.getSingleResult();

			return result + verificadorChave(result);
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	
	
	private int verificadorChave(String chave) {  
        int total = 0;  
        int peso = 2;  
              
        for (int i = 0; i < chave.length(); i++) {  
            total += (chave.charAt((chave.length()-1) - i) - '0') * peso;  
            peso ++;  
            if (peso == 10)  
                peso = 2;  
        }  
        int resto = total % 11;  
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);  
    }  

	public List<DadosGeraisNotaVO> obterDadosGeraisNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException {

		List resultList = null;
		List<DadosGeraisNotaVO> listaRetorno = new ArrayList();
		
		try {
			String sql = QUERY_DADOS_GERAIS_NOTA;

			Query q = this.manager.createNativeQuery(sql)
					.setParameter(1,hotel.getIdHotel())
					.setParameter(2,nota.getIdNota());
			resultList = q.getResultList();

			for (Object l : resultList) {
				listaRetorno.add(new DadosGeraisNotaVO((Object[]) l));
			}
			return listaRetorno;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<DadosDescricaoVendaNotaVO> obterDescricaoVendaNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException {

		List resultList = null;
		List<DadosDescricaoVendaNotaVO> listaRetorno = new ArrayList();
		
		try {
			String sql = QUERY_DESCRICAO_VENDA_NOTA;

			Query q = this.manager.createNativeQuery(sql)
					.setParameter(1,hotel.getIdHotel())
					.setParameter(2,nota.getIdNota());
			resultList = q.getResultList();

			for (Object l : resultList) {
				listaRetorno.add(new DadosDescricaoVendaNotaVO((Object[]) l));
			}
			return listaRetorno;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<DadosResumoItensNotaVO> obterResumoItensNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException {

		List resultList = null;
		List<DadosResumoItensNotaVO> listaRetorno = new ArrayList();
		
		try {
			String sql = QUERY_RESUMO_ITENS_NOTA;

			Query q = this.manager.createNativeQuery(sql)
					.setParameter(1,hotel.getIdHotel())
					.setParameter(2,nota.getIdNota());
			resultList = q.getResultList();

			for (Object l : resultList) {
				listaRetorno.add(new DadosResumoItensNotaVO((Object[]) l));
			}
			return listaRetorno;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<DadosFormaPagamentoNotaVO> obterFormaPagamentoNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException {

		List resultList = null;
		List<DadosFormaPagamentoNotaVO> listaRetorno = new ArrayList();
		
		try {
			String sql = QUERY_FORMA_PAGAMENTO_NOTA;

			Query q = this.manager.createNativeQuery(sql)
					.setParameter(1,hotel.getIdHotel())
					.setParameter(2,nota.getIdNota());
			resultList = q.getResultList();

			for (Object l : resultList) {
				listaRetorno.add(new DadosFormaPagamentoNotaVO((Object[]) l));
			}
			return listaRetorno;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	
	
	public MovimentoRestauranteEJB gravarMovimentoRestaurante(
			MovimentoRestauranteEJB movimentoRestaurante, MesaEJB mesa)
			throws MozartSessionException {

		try {
			if (movimentoRestaurante.getIdMovimentoRestaurante() == null) {
				this.manager.persist(movimentoRestaurante);
			} else {
				this.manager.merge(movimentoRestaurante);
			}

			this.manager.merge(mesa);

			this.manager.flush();
			
			manager.refresh(movimentoRestaurante);
			return movimentoRestaurante;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void excluir(MovimentoRestauranteEJB entidade)
			throws MozartSessionException {

		entidade = manager.find(MovimentoRestauranteEJB.class,
				entidade.getIdMovimentoRestaurante());
		manager.remove(entidade);

	}

	public RoomListEJB getRoomListPrincipalCheckin(Long pIdCheckin,
			String pPrincipal) throws MozartSessionException {

		List<RoomListEJB> l = manager
				.createNativeQuery(
						" select * from room_list rl"
								+ " where rl.id_checkin = ?1 "
								+ " and rl.principal = ?2", RoomListEJB.class)
				.setParameter(1, pIdCheckin).setParameter(2, pPrincipal)
				.getResultList();

		return (MozartUtil.isNull(l)) ? null : l.get(0);

	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public PontoVendaEJB gravarPontoVenda(PontoVendaEJB pPontoVenda)
			throws MozartSessionException {

		if (MozartUtil.isNull(pPontoVenda.getId().getIdPontoVenda())) {
			manager.persist(pPontoVenda);
		} else {
			pPontoVenda = manager.merge(pPontoVenda);
		}

		manager.flush();
		return pPontoVenda;
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public CaixaPontoVendaEJB gravarCaixaPontoVenda(CaixaPontoVendaEJB entidade)
			throws MozartSessionException {
		if (MozartUtil.isNull(entidade.getIdCaixaPontoVenda())) {
			manager.persist(entidade);
		} else {
			entidade = manager.merge(entidade);
		}
		manager.flush();
		return entidade;
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public MovimentoApartamentoEJB gravarMovimentoApartamento(
			MovimentoApartamentoEJB entidade) throws MozartSessionException {
		if (MozartUtil.isNull(entidade.getIdMovimentoApartamento())) {
			manager.persist(entidade);
		} else {
			entidade = manager.merge(entidade);
		}
		
		manager.flush();
		return entidade;
	}

	@Interceptors({ UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public StatusNotaEJB gravarStatusNota(StatusNotaEJB entidade)
			throws MozartSessionException {
		if (MozartUtil.isNull(entidade.getIdNota())) {
			manager.persist(entidade);
		} else {
			entidade = manager.merge(entidade);
		}
		manager.flush();
		return entidade;
	}

	public HotelEJB getHotelPorRestaurante(Long pIdRestaurante)
			throws MozartSessionException {

		String sql = " select h.* from hotel h where id_hotel in ( "
				+ " Select distinct id_hotel from rest_tl_htl "
				+ " where id_restaurante = ?1 group by id_hotel) "
				+ " union all "
				+ " select h.* from hotel h where id_hotel = ?2 ";

		List<HotelEJB> list = manager.createNativeQuery(sql, HotelEJB.class)
			.setParameter(1, pIdRestaurante)
			.setParameter(2, pIdRestaurante)
			.getResultList();
		
		return MozartUtil.isNull(list)? null : list.get(0);
	}

	public TipoLancamentoEJB consultarTipoLancamentoParaRestauranteTerceirizado(
			TipoLancamentoEJB pTipoLancamentoRestaurante)
			throws MozartSessionException {
		List<TipoLancamentoEJB> list;
		
		String sql = " select tl.* from tipo_lancamento tl "
				+ " join rest_tl_htl r on r.id_hotel=tl.id_hotel "
				+ " and r.id_tipo_lancamento = tl.id_tipo_lancamento "
				+ " where r.id_restaurante=?1 and r.id_tipo_lancamento_rest = ?2 "
				+ " union all "
				+ " select * from tipo_lancamento where id_hotel=?3 and id_tipo_lancamento = ?4 ";
		
		list = manager.createNativeQuery(sql, TipoLancamentoEJB.class)
				.setParameter(1, pTipoLancamentoRestaurante.getIdHotel())
				.setParameter(2, pTipoLancamentoRestaurante.getIdTipoLancamento())
				.setParameter(3, pTipoLancamentoRestaurante.getIdHotel())
				.setParameter(4, pTipoLancamentoRestaurante.getIdTipoLancamento())
				.getResultList();
		
		
		return MozartUtil.isNull(list)? null : list.get(0);
	}
	public TipoLancamentoEJB consultarTipoLancamentoDoRestaurante(
			TipoLancamentoEJB pTipoLancamentoHotel, HotelEJB pRestaurante)
					throws MozartSessionException {
		List<TipoLancamentoEJB> list;
		
		String sql = " select tl.* from tipo_lancamento tl "
				+ " join rest_tl_htl r on r.id_restaurante=tl.id_hotel "
				+ " and r.id_tipo_lancamento_rest = tl.id_tipo_lancamento "
				+ " where r.id_restaurante=?1 and r.id_tipo_lancamento = ?2 and r.id_hotel=?3";
		
		list = manager.createNativeQuery(sql, TipoLancamentoEJB.class)
				.setParameter(1, pRestaurante.getIdHotel())
				.setParameter(2, pTipoLancamentoHotel.getIdTipoLancamento())
				.setParameter(3, pTipoLancamentoHotel.getIdHotel())
				.getResultList();
		
		
		return MozartUtil.isNull(list)? null : list.get(0);
	}

	public List<MovimentoRestauranteEJB> consultarMovimentacaoMesa(
				MesaEJB mesaEJB) throws MozartSessionException {
		String sql="SELECT * FROM movimento_restaurante "
				+ " where id_hoteL=?1 "
				+ " and id_ponto_venda=?2 " 
				+ " and id_mesa=?3 "
				+ " and num_nota is null ";
		
		List<MovimentoRestauranteEJB> l = manager
				.createNativeQuery(sql, MovimentoRestauranteEJB.class)
				.setParameter(1, mesaEJB.getPontoVenda().getId().getIdHotel())
				.setParameter(2, mesaEJB.getPontoVenda().getId().getIdPontoVenda())
				.setParameter(3, mesaEJB.getIdMesa())
				.getResultList();
		
		return l;
	}

	public RestTlHtlEJB consultarRestTlHtl(
			TipoLancamentoEJB tipoLancamentoHotel,
			TipoLancamentoEJB tipoLancamentoRest) throws MozartSessionException {
		List<RestTlHtlEJB> list;
		String sql="SELECT * FROM rest_tl_htl "
				+ " where id_hoteL=?1 "
				+ " and id_tipo_lancamento=?2 "; 
				//+ " and id_restaurante=?3 "
				//+ " and id_tipo_lancamento_rest=?4 ";
		
		list = manager
		.createNativeQuery(sql, RestTlHtlEJB.class)
		.setParameter(1, tipoLancamentoHotel.getIdHotel())
		.setParameter(2, tipoLancamentoHotel.getIdTipoLancamento()).getResultList();
		//.setParameter(3, tipoLancamentoRest.getIdHotel())
		//.setParameter(4, tipoLancamentoRest.getIdTipoLancamento()).getResultList();
		
		return MozartUtil.isNull(list)? null : list.get(0);
		
	}

	@Interceptors(value = { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public NfeMovRestConfinsEJB gravarMovCofins(NfeMovRestConfinsEJB entidade) throws MozartSessionException {	
		try {
			if (entidade.getIdNfeMovRestCofins() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}
			
			return entidade;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void executarProcedureNfeRestaurante(Long idMovimentoRestaurante)
			throws MozartSessionException {
		try {
			manager.createNativeQuery(
					"{call PROC_REST_NFE_XML(?1)}")
					.setParameter(1, idMovimentoRestaurante)
					.executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}

	}
	
	public NotaFiscalEnvioVO consultarNotaFiscalEmissao(NotaFiscalEnvioVO filtro) throws MozartSessionException, ParseException {
		List<NotaFiscalEnvioVO> list = new ArrayList<NotaFiscalEnvioVO>();
		
		String sql = QUERY_EMITIR_NOTA_FISCAL;
		
		List resultList = manager.createNativeQuery(sql)
				.setParameter(1, filtro.getIdHotel())
				.setParameter(2, filtro.getFiltroIdNotaFiscal())
				.getResultList();
		
		for (Object l : resultList) {
			list.add(new NotaFiscalEnvioVO((Object[]) l));
		}
		
		return MozartUtil.isNull(list)? null : list.get(0);
	}
	
	public List<ProdutoEnvioVO> obterProdutosEmissaoNota(ProdutoEnvioVO filtro) throws MozartSessionException {

		List resultList = null;
		List<ProdutoEnvioVO> listaRetorno = new ArrayList();
		
		try {
			String sql = QUERY_INCLUIR_PRODUTO_NOTA;

			Query q = this.manager.createNativeQuery(sql)
					.setParameter(1,filtro.getIdHotel())
					.setParameter(2,filtro.getFiltroIdNotaFiscal());
			resultList = q.getResultList();

			for (Object l : resultList) {
				listaRetorno.add(new ProdutoEnvioVO((Object[]) l));
			}
			return listaRetorno;
			
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public PartnerDominioEJB getDesignHotel(String urlHotel)
			throws MozartSessionException {

		String sql = " select p.* from MOZART.PARTNER_DOMINIO p where p.ativo = 'S' and p.dominio = ?1 ";

		List<PartnerDominioEJB> list = manager.createNativeQuery(sql, PartnerDominioEJB.class)
			.setParameter(1, urlHotel)
			.getResultList();
		
		return MozartUtil.isNull(list)? null : list.get(0);
	}
	
	public List<NotaFiscalVO> consultarNotaFiscalNfce(
			NotaFiscalVO pFiltro) throws MozartSessionException {
	
		String sql = QRY_NOTA_FISCAL_NFCE;
		
		if (!MozartUtil.isNull(pFiltro.getData().getTipoIntervalo())) {
			sql = sql + " and SN.DATA " + pFiltro.getData();
		}
		if (!MozartUtil.isNull(pFiltro.getNotaInicial().getTipoIntervalo())) {
			sql = sql +  " AND NOTA_INICIAL " + pFiltro.getNotaInicial();
		}
		if (!MozartUtil.isNull(pFiltro.getGracStatusRPS())) {
			sql = sql +  " AND (SN.RPS_STATUS is null or SN.RPS_STATUS <> '" + pFiltro.getGracStatusRPS() + "')";
		}
		else if (!MozartUtil.isNull(pFiltro.getRpsstatus().getValorInicial())) {
			sql = sql +  " AND SN.RPS_STATUS " + pFiltro.getRpsstatus();
		}

		sql = sql + "        GROUP BY " +
				"            SN.TIPO_NOTA, PV.NOME_PONTO_VENDA,PV.ID_NFE_MODELO, H.ID_FISCAL_REGIME_TRIBUTARIO, NIC.ID_NFE_ICMS_CST,SN.RPS_STATUS,SN.DATA_EMISSAO,NM.DESCRICAO,SN.NUM_NOTA,PV.SERIE,SN.CHAVE_ACESSO,CL.CODIGO,CL.MENSAGEM,SN.ID_NOTA,SN.ARQUIVO_NOME,H.SIGLA" +
				"        ORDER BY SN.DATA_EMISSAO,PV.NOME_PONTO_VENDA,PV.SERIE,SN.NUM_NOTA ";
	
		List lista = this.manager.createNativeQuery(sql).setParameter(1,
				pFiltro.getBcIdHotel()).getResultList();

		List<NotaFiscalVO> resultado = new ArrayList();
		for (Object l : lista) {
			resultado.add(new NotaFiscalVO((Object[]) l, TypeOfNotaFiscal.ESTADUAL));
		}
		
		return resultado;
}
}