package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.CheckinEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ComprovanteAjusteVO;
import com.mozart.model.vo.MovimentoApartamentoVO;
import com.mozart.model.vo.StatusNotaVO;

@Remote
public interface AuditoriaSessionEJB {

	
	String QRY_MOVIMENTO = 
					" select mov.id_movimento_apartamento, mov.num_documento, sn.num_nota, mov.data_lancamento, log.hora, log.usuario, a.num_apartamento, mov.valor_lancamento, tl.debito_credito, "+ 
					" mov.qtde_adultos, mov.qtde_cafe, mov.map, mov.fap, il.receita_checkout, tl.grupo_lancamento,tl.sub_grupo_lancamento, tl.descricao_lancamento, mov.quem_paga "+
					" from checkin c, apartamento a, movimento_apartamento mov, status_nota sn, tipo_lancamento tl, identifica_lancamento il, "+
					" %s "+
					" where c.id_checkin = mov.id_checkin "+
					" and mov.id_hotel = c.id_hotel "+ 
					" and c.id_apartamento = a.id_apartamento "+
					" and c.id_hotel = a.id_hotel "+
					" and mov.id_nota = sn.id_nota(+) "+
					" and mov.id_tipo_lancamento = tl.id_tipo_lancamento "+
					" and mov.id_hotel = tl.id_hotel "+
					" and tl.id_identifica_lancamento = il.id_identifica_lancamento "+
					" and mov.id_hotel = a.id_hotel "+
					" and mov.id_movimento_apartamento = log.id_auditado(+) ";
	
	String QRY_LOG = 
			 		" (select log.id_auditado, log.hora, substr(u.nick,8) usuario "+
			 		"  from usuario u, "+  
			 		"    (select /*+ index(log_usuario idx_log_us_htl_op_tb_dt)*/ id_auditado, id_usuario, hora "+  
			 		"   from log_usuario "+
			 		"   where %s "+   
			 		"   and operacao = 'Inclusão'  and tabela_auditada = 'MOVIMENTO_APARTAMENTO' "+ 
			 		"   %s ) log "+
			 		" where u.id_usuario = log.id_usuario ) log ";  

	
	String QRY_REABERTURA_CONTA = 
					" select distinct sn.id_nota, c.id_checkin,  a.num_apartamento, ta.fantasia, sn.num_nota,  h.nome_hospede||' '||h.sobrenome_hospede nome_hospede, er.nome_fantasia "+ 
					" from status_nota sn, checkin c, empresa_rede er, controla_data cd, room_list rl, hospede h, apartamento a, tipo_apartamento ta, movimento_apartamento mov "+
					" where c.id_hotel = cd.id_hotel "+
					" and cd.id_hotel = ?1 "+
					" and (c.data_saida = cd.front_office or c.checkout = 'N') "+
					" and sn.data = cd.front_office "+
					" and a.id_apartamento = c.id_apartamento and a.id_hotel = c.id_hotel  "+
					" and a.status like decode(c.checkout,'S','L%',a.status) "+
					" and a.id_tipo_apartamento = ta.id_tipo_apartamento "+
					" and rl.id_hospede = h.id_hospede "+
					" and sn.id_checkin = c.id_checkin "+
					" and sn.status = 'OK' "+
					" and c.id_empresa = er.id_empresa "+
					" and er.id_rede_hotel = cd.id_rede_hotel "+
					" and mov.id_hotel = cd.id_hotel "+
					" and mov.id_checkin = c.id_checkin "+
					" and mov.id_nota = sn.id_nota "+
					" and mov.id_room_list = rl.id_room_list "+ 
					" order by num_apartamento ";



	String QRY_COMPROVANTE_AJUSTE = 
					" SELECT ID_MOVIMENTO_APARTAMENTO, NUM_APARTAMENTO, DESCRICAO_LANCAMENTO, " +
					" NOME_FANTASIA, DATA_LANCAMENTO, HORA_LANCAMENTO, VALOR_LANCAMENTO, NUM_DOCUMENTO, NOME " +
					" FROM (SELECT MA.ID_MOVIMENTO_APARTAMENTO, AP.NUM_APARTAMENTO, TL.DESCRICAO_LANCAMENTO, " +
					" ER.NOME_FANTASIA, TRUNC(MA.DATA_LANCAMENTO) DATA_LANCAMENTO, MA.HORA_LANCAMENTO, MA.VALOR_LANCAMENTO, " +
					" MA.NUM_DOCUMENTO, U.NOME " +
					" FROM MOVIMENTO_APARTAMENTO MA " +
					" JOIN CHECKIN CK ON (MA.ID_CHECKIN = CK.ID_CHECKIN) " +
					" JOIN CONTROLA_DATA H ON (CK.ID_HOTEL = H.ID_HOTEL) " +
					" JOIN APARTAMENTO AP ON (CK.ID_APARTAMENTO = AP.ID_APARTAMENTO) " +
					" JOIN TIPO_LANCAMENTO TL ON (MA.ID_TIPO_LANCAMENTO=TL.ID_TIPO_LANCAMENTO) " +
					" JOIN IDENTIFICA_LANCAMENTO IL ON (TL.ID_IDENTIFICA_LANCAMENTO = IL.ID_IDENTIFICA_LANCAMENTO AND IL.RECEITA_CHECKOUT = 1) " +
					" JOIN LOG_USUARIO LU ON (MA.ID_MOVIMENTO_APARTAMENTO=LU.ID_AUDITADO AND LU.OPERACAO = 'Inclusão') " +
					" JOIN USUARIO U ON (LU.ID_USUARIO=U.ID_USUARIO) " +
					" JOIN EMPRESA_REDE ER ON (CK.ID_EMPRESA=ER.ID_EMPRESA AND ER.ID_REDE_HOTEL = H.ID_REDE_HOTEL) " +
					" WHERE MA.ID_HOTEL = ?1 " +
					" AND TRUNC(MA.DATA_LANCAMENTO) = TRUNC(?2) " +
					" AND MA.VALOR_LANCAMENTO < 0 " +
					" UNION " +
					" SELECT MA.ID_MOVIMENTO_APARTAMENTO, AP.NUM_APARTAMENTO, TL.DESCRICAO_LANCAMENTO, " +
					" ER.NOME_FANTASIA, TRUNC(MA.DATA_LANCAMENTO) DATA_LANCAMENTO, MA.HORA_LANCAMENTO, MA.VALOR_LANCAMENTO, " +
					" MA.NUM_DOCUMENTO, U.NOME " +
					" FROM MOVIMENTO_APARTAMENTO MA " +
					" JOIN CHECKIN CK ON (MA.ID_CHECKIN = CK.ID_CHECKIN) " +
					" JOIN CONTROLA_DATA H ON (CK.ID_HOTEL = H.ID_HOTEL) " +
					" JOIN APARTAMENTO AP ON (CK.ID_APARTAMENTO = AP.ID_APARTAMENTO) " +
					" JOIN TIPO_LANCAMENTO TL ON (MA.ID_TIPO_LANCAMENTO=TL.ID_TIPO_LANCAMENTO) " +
					" JOIN IDENTIFICA_LANCAMENTO IL ON (TL.ID_IDENTIFICA_LANCAMENTO = IL.ID_IDENTIFICA_LANCAMENTO AND IL.RECEITA_CHECKOUT = 2) " +
					" JOIN LOG_USUARIO LU ON (MA.ID_MOVIMENTO_APARTAMENTO=LU.ID_AUDITADO AND LU.OPERACAO = 'Inclusão') " +
					" JOIN USUARIO U ON (LU.ID_USUARIO=U.ID_USUARIO) " +
					" JOIN EMPRESA_REDE ER ON (CK.ID_EMPRESA=ER.ID_EMPRESA AND ER.ID_REDE_HOTEL = H.ID_REDE_HOTEL) " +
					" WHERE MA.ID_HOTEL = ?3 " +
					" AND TRUNC(MA.DATA_LANCAMENTO) =  TRUNC(?4) " +
					" AND MA.VALOR_LANCAMENTO > 0) ORDER BY NUM_APARTAMENTO ";

	String QRY_APT_INTERDITADO = " SELECT NUM_APARTAMENTO " +
			" FROM APARTAMENTO a " +
			" JOIN CONTROLA_DATA cd ON (a.ID_HOTEL = cd.ID_HOTEL) " +
			" WHERE a.ID_HOTEL = ?1 " +
	        " and a.STATUS = 'IN' " + 
	        " and a.DATA_SAIDA <= cd.FRONT_OFFICE order by NUM_APARTAMENTO ";

	List<MovimentoApartamentoVO> pesquisarMovimento(MovimentoApartamentoVO filtro)  throws MozartSessionException;

	void encerrarAuditoria(ControlaDataEJB controlaData) throws MozartSessionException;
	void encerrarAuditoriaRestaurante(ControlaDataEJB controlaData) throws MozartSessionException;
	void encerrarAuditoriaServ(ControlaDataEJB controlaData) throws MozartSessionException;


	@SuppressWarnings("unchecked")
	List obterValidacao(Long idHotel)throws MozartSessionException;


	List<StatusNotaVO> obterReaberturaConta(Long idHotel)throws MozartSessionException;
	void reabrirConta(StatusNotaVO statusNota) throws MozartSessionException;

	
	List<ComprovanteAjusteVO> obterComprovanteAjuste (ComprovanteAjusteVO ajuste)throws MozartSessionException;


	void gravarCheckinComplemento(HotelEJB hotel,
			List<CheckinEJB> checkinEJBList)throws MozartSessionException;


	Long obterNossoNumeroMesAnterior(ControlaDataEJB cd)throws MozartSessionException;

	List<Long> obterApartamentosInterditadosVencidos(HotelEJB hotel) throws MozartSessionException;

}
