package com.mozart.model.ejb.facade;

import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.ConfigNotaEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.ejb.entity.ObjetoEJB;
import com.mozart.model.ejb.entity.RoomListEJB;
import com.mozart.model.ejb.entity.ApartamentoTransferidoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.CaixaGeralVO;
import com.mozart.model.vo.MiniPdvVO;
import com.mozart.model.vo.MovimentoObjetoVO;
import com.mozart.model.vo.TransacaoWebVO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CaixaGeralSession {

	public static final String WHERE_CAIXA_GERAL = "where apto.id_hotel = ?3\n"
			+ "and apto.id_tipo_apartamento = ta.id_tipo_apartamento\n"
			+ "and apto.id_hotel = ta.id_hotel\n"
			+ "and apto.id_apartamento = ck.id_apartamento(+)\n"
			+ "and apto.id_apartamento = res.id_apartamento(+)\n"
			+ "and instr(NVL(?4,';'||status||';'), ';'||status||';' ) >= 1 \n"
			+ "and nvl(entrada_dia,'N') = nvl(?5, nvl(entrada_dia,'N'))\n"
			+ "and nvl(saida_dia,'N') = nvl(?6, nvl(saida_dia,'N'))\n"
			+ "and nvl(cofan,'N') = nvl(?7, nvl(cofan,'N'))\n"
			+ "and nvl(checkout,'N') = nvl(?8, nvl(checkout,'N'))\n"
			+ "and apto.num_apartamento = nvl(?9, apto.num_apartamento)\n"
			+ "and apto.id_apartamento = nvl(?10, apto.id_apartamento)\n"
			+ "order by apto.num_apartamento \n";

	public static final String SUB_QUERY_RESERVA = "select ra.id_reserva_apartamento,  ra.id_reserva,  ra.id_apartamento, h.nome_hospede||' '|| h.sobrenome_hospede hospede_reserva, ra.data_entrada dt_entrada, decode(trunc(ra.data_entrada), trunc(cd.front_office),'S','N') ENTRADA_DIA\n"
			+ "from reserva r, reserva_apartamento ra, controla_data cd, room_list rl, hospede h\n"
			+ "where ra.id_hotel = ?2 and r.id_reserva = ra.id_reserva and r.apagada='N'\n"
			+ "and ra.id_hotel = cd.id_hotel\n"
			+ "and ra.id_reserva_apartamento = rl.id_reserva_apartamento\n"
			+ "and rl.id_hospede = h.id_hospede\n"
			+ "and rl.principal <> 'N'\n"
			+ "and rl.id_checkin is null\n"
			+ "and ra.id_apartamento is not null\n"
			+ "and trunc(ra.data_entrada) = trunc(cd.front_office)";

	String SUB_QUERY_CHECKIN_COM_HOSPEDE = "select c.id_checkin, c.id_reserva, c.id_apartamento, h.nome_hospede||' '|| h.sobrenome_hospede hospede, decode(trunc(c.data_saida), trunc(cd.front_office),'S','N') SAIDA_DIA, c.data_entrada, c.data_saida, TRIM (ER.NOME_FANTASIA || ' - ' || E.CGC) empresa \n"
			+ "from checkin c, controla_data cd, room_list rl, hospede h, empresa_rede er, EMPRESA E  \n"
			+ "where c.id_hotel = cd.id_hotel\n"
			+ "and (cd.id_rede_hotel = er.id_rede_hotel and c.id_empresa = er.id_empresa) \n"
			+ "and (C.ID_EMPRESA = E.ID_EMPRESA AND ER.ID_EMPRESA = E.ID_EMPRESA) \n "
			+ "and c.id_hotel = ?1\n"
			+ "and c.checkout = 'N'\n"
			+ "and rl.id_checkin = c.id_checkin\n"
			+ "and rl.id_hospede = h.id_hospede\n" + "and rl.principal <> 'N'";

	String SUB_QUERY_CHECKIN_SEM_HOSPEDE = "select c.id_checkin, c.id_reserva, c.id_apartamento, '' hospede, decode(trunc(c.data_saida), trunc(cd.front_office),'S','N') SAIDA_DIA, c.data_entrada, c.data_saida, TRIM (ER.NOME_FANTASIA || ' - ' || E.CGC) empresa \n"
			+ "from checkin c, controla_data cd, empresa_rede er, EMPRESA E  \n"
			+ "where c.id_hotel = cd.id_hotel\n"
			+ "and (cd.id_rede_hotel = er.id_rede_hotel and c.id_empresa = er.id_empresa) \n"
			+ "and (C.ID_EMPRESA = E.ID_EMPRESA AND ER.ID_EMPRESA = E.ID_EMPRESA) \n "
			+ "and c.id_hotel = ?1\n" + "and c.checkout = 'N'\n";

	String QUERY_CAIXA_GERAL = "select apto.id_apartamento, apto.num_apartamento, apto.status, apto.cofan, ta.fantasia,\n"
			+ "       ck.id_checkin, ck.hospede, ck.SAIDA_DIA, \n"
			+ "       res.id_reserva_apartamento, res.hospede_reserva, nvl(ck.data_entrada,res.dt_entrada), res.entrada_dia, nvl(ck.id_reserva,res.id_reserva), apto.checkout, ck.data_saida, decode(apto.status,'IN',TO_CHAR(APTO.DATA_ENTRADA,'DD/MM/YYYY')||'-'||TO_CHAR(APTO.DATA_SAIDA,'DD/MM/YYYY')||'->'||NVL(APTO.OBSERVACAO,'') ,'') obs, apto.bloco, ck.empresa \n"
			+ "from apartamento apto, tipo_apartamento ta \n";

	String QUERY_MOVIMENTO_OBJETO = " select mo.id_movimento_objeto, a.num_apartamento||' - '||a.status apartamento, "
			+ " h.nome_hospede||' '||h.sobrenome_hospede hospede, "
			+ " o.fantasia, mo.data, mo.observacao, mo.qtde, o.valor, nvl(mo.qtde,1) * nvl(o.valor,0) valor_total, mov.valor_lancamento "
			+ " from movimento_objeto mo, checkin c, room_list rl, hospede h, objeto o, apartamento a, movimento_apartamento mov "
			+ " where mo.id_checkin = c.id_checkin "
			+ " and mo.id_hotel = c.id_hotel "
			+ " and c.id_hotel = a.id_hotel "
			+ " and c.id_apartamento = a.id_apartamento "
			+ " and mo.id_room_list = rl.id_room_list "
			+ " and rl.id_hospede = h.id_hospede "
			+ " and mo.id_objeto = o.id_objeto "
			+ " and mo.id_hotel = o.id_hotel "
			+ " and mo.id_movimento_apartamento = mov.id_movimento_apartamento(+)";

	String QUERY_MINI_PDV = " SELECT MMPDV.ID_MOVIMENTO_MINI_PDV, MMPDV.ID_MOVIMENTO_APARTAMENTO, A.NUM_APARTAMENTO, "
			+ " PV.NOME_PONTO_VENDA, C.ID_CHECKIN, "
			+ " H.NOME_HOSPEDE||' '|| H.SOBRENOME_HOSPEDE HOSPEDE, MMPDV.DATA, P.NOME_PRATO, MMPDV.QUANTIDADE, MMPDV.VALOR_TOTAL "
			+ " FROM MOVIMENTO_MINI_PDV MMPDV, PONTO_VENDA PV, ROOM_LIST RL, CHECKIN C, APARTAMENTO A, PRATO P, HOSPEDE H "
			+ " WHERE PV.ID_PONTO_VENDA = MMPDV.ID_PDV "
			+ " AND MMPDV.ID_ROOM_LIST = RL.ID_ROOM_LIST "
			+ " AND RL.ID_CHECKIN = C.ID_CHECKIN "
			+ " AND C.ID_APARTAMENTO = A.ID_APARTAMENTO "
			+ " AND MMPDV.ID_TIPO = P.ID_PRATO "
			+ " AND RL.ID_HOSPEDE = H.ID_HOSPEDE ";

	String QRY_TRANSACAO_WEB = " SELECT TW.ID_TRANSACAO_WEB, NVL(A.BLOCO, A.NUM_APARTAMENTO||'') APTO, TW.NOME_CARTAO, TL.DESCRICAO_LANCAMENTO, TW.COD_AUTORIZACAO, TW.COD_TRANSACAO, TW.TXT_MENSAGEM, TW.DATA_TRANSACAO, TW.VALOR_TRANSACAO, decode(TW.STATUS,NULL,'Sucesso',0,'Cancelado',1,'Não cancelado',2,'Não encontrado/já cancelado') st, TW.id_reserva "
			+ " FROM TRANSACAO_WEB TW, CHECKIN C, APARTAMENTO A, TIPO_LANCAMENTO TL "
			+ " WHERE TW.ID_CHECKIN = C.ID_CHECKIN(+) "
			+ " AND TW.ID_HOTEL = C.ID_HOTEL(+) "
			+ " AND C.ID_APARTAMENTO = A.ID_APARTAMENTO(+) "
			+ " AND C.ID_HOTEL = A.ID_HOTEL(+) "
			+ " AND TW.ID_HOTEL = TL.ID_HOTEL "
			+ " AND TW.ID_TIPO_LANCAMENTO = TL.ID_TIPO_LANCAMENTO ";

	List<CaixaGeralVO> pesquisarApartamentoComCheckinEReserva(CaixaGeralVO param);
	List<CaixaGeralVO> pesquisarApartamentoComCheckinEReserva(CaixaGeralVO param, boolean isHotelaria);

	void transferirApartamento(ApartamentoTransferidoEJB apartamentoTransferido)
			throws MozartSessionException;

	List<ApartamentoEJB> obterApartamentoDisponivelTransferencia(
			Long idCheckin, Long idHotel) throws MozartSessionException;

	List<ConfigNotaEJB> obterConfiguracaoImpressoraFiscal(Long idHotel)
			throws MozartSessionException;

	List<String> obterValidacaoLancamentoDiaria(Long pIdHotel)
			throws MozartSessionException;

	void lancarDiariaAutomatica(ControlaDataEJB pControlaData)
			throws MozartSessionException;

	void transferirDespesasParaApto(ApartamentoEJB destino,
			Long pIdRoomListDestino, String motivo,
			List<MovimentoApartamentoEJB> listaMovimentoATransferir)
			throws MozartSessionException;

	List<MovimentoApartamentoEJB> obterMovimentoAtualDoApartamento(
			MovimentoApartamentoEJB origem) throws MozartSessionException;

	List<RoomListEJB> obterHospedePorApartamento(ApartamentoEJB apto)
			throws MozartSessionException;

	List<ConfigNotaEJB> obterConfiguracaoNotaFiscal(Long idHotel)
			throws MozartSessionException;

	void salvarConfiguracaoNotaFiscal(List<ConfigNotaEJB> lista)
			throws MozartSessionException;

	List<RoomListEJB> obterHospedePorCheckin(Long idCheckin)
			throws MozartSessionException;

	List<ObjetoEJB> obterObjetoPorHotel(Long idHotel)
			throws MozartSessionException;

	List<MovimentoObjetoVO> pesquisarMovimentoObjeto(MovimentoObjetoVO filtro)
			throws MozartSessionException;

	List<MiniPdvVO> pesquisarMiniPDV(MiniPdvVO filtro)
			throws MozartSessionException;

	List<TransacaoWebVO> pesquisarTransacaoWeb(TransacaoWebVO filtro)
			throws MozartSessionException;

}
