package com.mozart.model.ejb.facade;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.ejb.Remote;

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

@Remote
@SuppressWarnings("unchecked")
public abstract interface CheckinSession {
	public static final String QUERY_CHECKIN_DIA = "SELECT * FROM (\nSELECT RS.ID_RESERVA,\n       RA.ID_RESERVA_APARTAMENTO, \n       rl.ID_CHECKIN, \n       RS.ID_CENTRAL_RESERVAS,\n       RL.ID_ROOM_LIST,\n       RS.ID_CORPORATE, \n       rl.ID_HOSPEDE,\n       H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, \n       apar.num_apartamento,\n       RA.DATA_ENTRADA, \n       RA.DATA_SAIDA, \n       RS.BLOQUEIO,\n       (TOTAL.QTDE_APART-TOTAL.QTDE_CHECKIN) AS DISPONIVEL, \n       TOTAL.QTDE_APART, \n       TOTAL.QTDE_CHECKIN,\n       RA.QTDE_PAX, \n       E.NOME_FANTASIA,\n       RS.GRUPO,\n       RS.CORTESIA, \n       RS.OBSERVACAO, \n       '' AS CREDITO, \n       RS.CALCULA_TAXA, \n       RS.CALCULA_ISS, \n       RS.CALCULA_ROOMTAX,\n       RS.CALCULA_SEGURO,\n       DECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café','ALL','All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \n       RS.NOME_GRUPO,\n       RS.CONFIRMA,\n       TH.TIPO_HOSPEDE,  \n       RS.VALOR_PENSAO, RA.MASTER, \nDECODE( greatest( RA.DATA_ENTRADA, DATA_FRONT.FRONT_OFFICE ), RA.DATA_ENTRADA, 'Não', 'Sim') NOSHOW, APAR.COFAN, 0 QTDE_ADULTOS, 0 QTDE_CRIANCAS, 0 ADICIONAL, 0 QTDE_CAFE, rl.cod_Certificado\nFROM RESERVA RS, EMPRESA_REDE E, RESERVA_APARTAMENTO RA, ROOM_LIST RL , HOSPEDE H, CONTROLA_DATA CD, apartamento apar, TIPO_HOSPEDE TH, \n        (SELECT /*+INDEX(RA IDX_RES_APTO_HOT_RES) */\nRA.ID_RESERVA, SUM(RA.QTDE_APARTAMENTO) QTDE_APART, SUM(RA.QTDE_CHECKIN) QTDE_CHECKIN\n        FROM RESERVA_APARTAMENTO RA, RESERVA R, CONTROLA_DATA C\n        WHERE instr(NVL(?1,';'||r.id_hotel||';'), ';'||r.id_hotel||';' ) >= 1\nAND R.ID_HOTEL = C.ID_HOTEL\nAND RA.ID_RESERVA = R.ID_RESERVA\nAND trunc(RA.DATA_ENTRADA) between C.FRONT_OFFICE-30 and C.FRONT_OFFICE\nAND TRUNC(RA.DATA_SAIDA) >= TRUNC(C.FRONT_OFFICE)\n        GROUP BY RA.ID_RESERVA) TOTAL,\n(SELECT TRUNC(FRONT_OFFICE)FRONT_OFFICE FROM CONTROLA_DATA WHERE instr(NVL(?2,';'||id_hotel||';'), ';'||id_hotel||';' ) >= 1) DATA_FRONT\nWHERE instr(NVL(?3,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1\nand ra.id_apartamento = apar.id_apartamento(+)\nAND RS.ID_HOTEL = CD.ID_HOTEL\nAND RS.ID_EMPRESA = E.ID_EMPRESA\nAND RS.APAGADA = 'N'\nAND RA.ID_RESERVA = RS.ID_RESERVA\nAND RA.ID_RESERVA_APARTAMENTO = RL.ID_RESERVA_APARTAMENTO(+)\nAND RA.QTDE_CHECKIN = 0\nAND RL.ID_HOSPEDE = H.ID_HOSPEDE(+)\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE \nAND RL.ID_CHECKIN IS NULL\nAND RS.BLOQUEIO = 'N'\nAND RL.PRINCIPAL ='S' AND RL.DATA_SAIDA IS NULL \nAND TOTAL.ID_RESERVA = RS.ID_RESERVA\nAND TOTAL.QTDE_CHECKIN < TOTAL.QTDE_APART\nAND TRUNC(RA.DATA_ENTRADA) between DATA_FRONT.FRONT_OFFICE-30 and DATA_FRONT.FRONT_OFFICE\nAND TRUNC(RA.DATA_SAIDA) >= DATA_FRONT.FRONT_OFFICE\nAND CD.ID_REDE_HOTEL = E.ID_REDE_HOTEL)  where 1=1 ";
	public static final String QUERY_HOSPEDE_DIA = "SELECT * FROM (\nSELECT RS.ID_RESERVA,\n       RA.ID_RESERVA_APARTAMENTO, \n      rl.ID_CHECKIN, \n      RS.ID_CENTRAL_RESERVAS,\n      rl.id_room_list,\n      RS.ID_CORPORATE,       \n      H.ID_HOSPEDE,\n      H.NOME_HOSPEDE||' '|| H.SOBRENOME_HOSPEDE NOME_HOSPEDE, \n      apar.num_apartamento, \n      RA.DATA_ENTRADA, \n      RA.DATA_SAIDA,\n      RS.BLOQUEIO,\n      (TOTAL.QTDE_APART-TOTAL.QTDE_CHECKIN) AS DISPONIVEL, \n      TOTAL.QTDE_APART, \n      TOTAL.QTDE_CHECKIN, \n      1 QTDE_PAX, \n      ER.NOME_FANTASIA,\n      RS.GRUPO,\n      RS.CORTESIA, \n      RS.OBSERVACAO, \n      ' ' AS CREDITO,\n      RS.CALCULA_TAXA, \n      RS.CALCULA_ISS, \n      RS.CALCULA_ROOMTAX, \n      RS.CALCULA_SEGURO, \n      DECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café', 'ALL', 'All Iclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \n      RS.NOME_GRUPO,\n      RS.CONFIRMA,    \n      TH.TIPO_HOSPEDE, \n      RS.VALOR_PENSAO, RA.MASTER, \nDECODE( greatest( TRUNC(RA.DATA_ENTRADA), DATA_FRONT.FRONT_OFFICE ), TRUNC(RA.DATA_ENTRADA), 'Não', 'Sim') NOSHOW, APAR.COFAN, 0 QTDE_ADULTOS, 0 QTDE_CRIANCAS, 0 ADICIONAL, 0 QTDE_CAFE, rl.cod_Certificado \n\nFROM RESERVA RS, EMPRESA_HOTEL E,RESERVA_APARTAMENTO RA, ROOM_LIST RL, HOSPEDE H, EMPRESA_REDE ER, CONTROLA_DATA CD,apartamento apar, TIPO_HOSPEDE TH,\n        (SELECT /*+INDEX(RA IDX_RES_APTO_HOT_RES) */\nRA.ID_RESERVA, SUM(RA.QTDE_APARTAMENTO) QTDE_APART, SUM(RA.QTDE_CHECKIN) QTDE_CHECKIN\n        FROM RESERVA_APARTAMENTO RA, RESERVA R, CONTROLA_DATA C\n        WHERE instr(NVL(?1,';'||r.id_hotel||';'), ';'||r.id_hotel||';' ) >= 1\nAND R.ID_HOTEL = C.ID_HOTEL\nAND RA.ID_RESERVA = R.ID_RESERVA\nAND TRUNC(RA.DATA_ENTRADA) between TRUNC(C.FRONT_OFFICE)-30 and  TRUNC(C.FRONT_OFFICE)\n        GROUP BY RA.ID_RESERVA) TOTAL,\n(SELECT TRUNC(FRONT_OFFICE) FRONT_OFFICE \nFROM CONTROLA_DATA \nWHERE instr(NVL(?2,';'||id_hotel||';'), ';'||id_hotel||';' ) >= 1) DATA_FRONT\nWHERE instr(NVL(?3,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1 \nand ra.id_apartamento = apar.id_apartamento(+)\nAND RS.ID_EMPRESA = E.ID_EMPRESA\nAND RS.ID_HOTEL = E.ID_HOTEL\nAND RS.ID_HOTEL = CD.ID_HOTEL\nAND E.ID_EMPRESA = ER.ID_EMPRESA\nAND ER.ID_REDE_HOTEL = CD.ID_REDE_HOTEL \nAND RS.APAGADA = 'N'\nAND RA.ID_RESERVA = RS.ID_RESERVA\nAND RS.BLOQUEIO = 'N'\nAND E.ID_HOTEL = RS.ID_HOTEL\nAND TOTAL.ID_RESERVA = RS.ID_RESERVA\nAND TOTAL.QTDE_CHECKIN < TOTAL.QTDE_APART\nAND TRUNC(RA.DATA_ENTRADA) between TRUNC(DATA_FRONT.FRONT_OFFICE-30) and  TRUNC(DATA_FRONT.FRONT_OFFICE)\nAND RL.ID_CHECKIN IS NULL AND RL.DATA_SAIDA IS NULL\nAND H.ID_HOSPEDE(+) = RL.ID_HOSPEDE\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE\nAND RA.ID_RESERVA_APARTAMENTO = RL.ID_RESERVA_APARTAMENTO(+) )  where 1=1 ";
	public static final String QUERY_APTO_EXECUTADO = "SELECT * FROM (\nSELECT RS.ID_RESERVA, RA.ID_RESERVA_APARTAMENTO, RS.ID_CHECKIN, RL.ID_ROOM_LIST, null as id_central_reserva, NULL AS ID_CORPORATE, rl.id_hospede, \nH.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, apar.NUM_APARTAMENTO, RA.DATA_ENTRADA, RA.DATA_SAIDA, null as BLOQUEIO,\nnull AS DISPONIVEL, 1 AS QTDE_APART, 1 AS QTDE_CHECKIN, 1 AS QTDE_PAX, E.NOME_FANTASIA, NULL AS GRUPO, RS.CORTESIA,\nNULL AS OBSERVACAO, RS.CREDITO, RS.CALCULA_TAXA, RS.CALCULA_ISS, RS.CALCULA_ROOMTAX, RS.CALCULA_SEGURO, \nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café','ALL', 'All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \nNULL AS NOME_GRUPO, NULL AS CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, \n'Não' NOSHOW, APAR.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado \nFROM CHECKIN RS, APARTAMENTO Apar, EMPRESA_REDE E, ROOM_LIST RL, HOSPEDE H, CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE TH\nWHERE RS.ID_APARTAMENTO = Apar.ID_APARTAMENTO\nAND RS.ID_EMPRESA = E.ID_EMPRESA\nAND instr(NVL(?1,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1\nAND RL.ID_HOSPEDE = H.ID_HOSPEDE AND RL.DATA_SAIDA IS NULL\nAND RL.ID_CHECKIN(+) = RS.ID_CHECKIN\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE\nAND RS.ID_RESERVA IS NULL\nAND RS.CHECKOUT = 'N'\nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel  \nAND RA.ID_HOTEL = RS.ID_HOTEL\nAND RA.ID_RESERVA_APARTAMENTO = RS.ID_RESERVA_APARTAMENTO\n \nUNION ALL\n\nSELECT RS.ID_RESERVA,RA.ID_RESERVA_APARTAMENTO, RS.ID_CHECKIN, RL.ID_ROOM_LIST,  null as id_central_reserva,R.ID_CORPORATE,h.id_HOSPEDE, \nH.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, APAR.NUM_APARTAMENTO AS APARTAMENTO, RS.DATA_ENTRADA, RS.DATA_SAIDA,\nR.BLOQUEIO, 1 AS DISPONIVEL,1 AS QTDE_APART, 1 AS QTDE_CHECKIN, RS.QTDE_ADULTOS QTDE_PAX, E.NOME_FANTASIA, R.GRUPO,\nR.CORTESIA, R.OBSERVACAO, RS.CREDITO, R.CALCULA_TAXA, R.CALCULA_ISS, R.CALCULA_ROOMTAX, R.CALCULA_SEGURO, \nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café','ALL', 'All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO,\nR.NOME_GRUPO, R.CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, 'Não' NOSHOW, APAR.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado \nFROM  RESERVA R, CHECKIN RS,ROOM_LIST RL, APARTAMENTO Apar, EMPRESA_REDE E, HOSPEDE H, CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE TH\nWHERE instr(NVL(?2,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1\nAND RS.ID_RESERVA = R.ID_RESERVA(+)\nAND RS.ID_CHECKIN = RL.ID_CHECKIN(+)\nAND RL.PRINCIPAL = 'S' AND RL.DATA_SAIDA IS NULL \nAND RS.ID_APARTAMENTO = Apar.ID_APARTAMENTO\nAND RL.ID_HOSPEDE = H.ID_HOSPEDE(+)\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE\nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel  \nAND RS.CHECKOUT = 'N'\nAND E.ID_EMPRESA = RS.ID_EMPRESA\nAND RA.ID_RESERVA_APARTAMENTO(+) = RS.ID_RESERVA_APARTAMENTO\nAND RS.ID_RESERVA IS NULL\n\nUNION ALL\n\nSELECT RS.ID_RESERVA, RA.ID_RESERVA_APARTAMENTO, RS.ID_CHECKIN, RL.ID_ROOM_LIST, null as id_central_reservas, R.ID_CORPORATE, h.id_hospede, \nH.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE  NOME_HOSPEDE, A.NUM_APARTAMENTO, RA.DATA_ENTRADA, RA.DATA_SAIDA,\nR.BLOQUEIO, 1 AS DISPONIVEL, 1 AS QTDE_APART, 1 AS QTDE_CHECKIN, RS.QTDE_ADULTOS QTDE_PAX, E.NOME_FANTASIA, \nR.GRUPO, RS.CORTESIA, R.OBSERVACAO, RS.CREDITO, R.CALCULA_TAXA, R.CALCULA_ISS, R.CALCULA_ROOMTAX, R.CALCULA_SEGURO,\nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café','ALL','All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO,\nR.NOME_GRUPO, R.CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, 'Não' NOSHOW , A.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado\nFROM  RESERVA R, CHECKIN RS,ROOM_LIST RL, APARTAMENTO A, EMPRESA_REDE E, HOSPEDE H, CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE  TH\nWHERE instr(NVL(?3,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1 \nAND RS.ID_RESERVA = R.ID_RESERVA(+)\nAND RS.ID_CHECKIN = RL.ID_CHECKIN(+) \nAND RS.ID_APARTAMENTO = A.ID_APARTAMENTO\nAND RL.ID_HOSPEDE = H.ID_HOSPEDE(+)\nAND RL.PRINCIPAL = 'S' AND RL.DATA_SAIDA IS NULL\nAND H.ID_TIPO_HOSPEDE  = TH.ID_TIPO_HOSPEDE \nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel  \nAND RS.CHECKOUT = 'N'\nAND E.ID_EMPRESA = RS.ID_EMPRESA\nAND RA.ID_RESERVA_APARTAMENTO(+) = RS.ID_RESERVA_APARTAMENTO\nAND RS.ID_RESERVA IS NOT NULL)  where 1=1 ";
	public static final String QUERY_HOSPEDE_EXECUTADO = "SELECT * FROM (\nSELECT /*+ INDEX ( RS IDX_CHECKIN_AP_H_EM_RE_CKO) */ \nRS.ID_RESERVA, RA.ID_RESERVA_APARTAMENTO,RS.ID_CHECKIN, RL.ID_ROOM_LIST, rs.id_central_reservas, NULL AS ID_CORPORATE, h.id_hospede,\nH.NOME_HOSPEDE ||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, A.NUM_APARTAMENTO, RS.DATA_ENTRADA, RS.DATA_SAIDA,\nnull as BLOQUEIO, 1 AS DISPONIVEL, 1 AS QTDE_APART, 1 AS QTDE_CHECKIN, 1 AS QTDE_PAX, E.NOME_FANTASIA,\nNULL AS GRUPO, RS.CORTESIA, NULL AS OBSERVACAO, RS.CREDITO, RS.CALCULA_TAXA, RS.CALCULA_ISS, RS.CALCULA_ROOMTAX, RS.CALCULA_SEGURO,\nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café', 'ALL', 'All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \nNULL AS NOME_GRUPO, NULL AS CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, 'Não' NOSHOW, A.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado \nFROM CHECKIN RS, APARTAMENTO A, EMPRESA_rede E, ROOM_LIST RL, HOSPEDE H,CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE TH\nWHERE RS.ID_APARTAMENTO = A.ID_APARTAMENTO\nAND RS.ID_EMPRESA = E.ID_EMPRESA\nAND instr(NVL(?1,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1 \nAND RL.ID_HOSPEDE = H.ID_HOSPEDE AND RL.DATA_SAIDA IS NULL\nAND RL.ID_CHECKIN(+) = RS.ID_CHECKIN\nAND RS.ID_RESERVA IS NULL\nAND RS.CHECKOUT = 'N'\nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel\nAND RA.ID_HOTEL = RS.ID_HOTEL\nAND RA.ID_RESERVA_APARTAMENTO = RS.ID_RESERVA_APARTAMENTO\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE\nUNION ALL\nSELECT /*+ INDEX ( RS IDX_CHECKIN_AP_H_EM_RE_CKO) */ \n\nRS.ID_RESERVA, RA.ID_RESERVA_APARTAMENTO, RS.ID_CHECKIN, RL.ID_ROOM_LIST, rs.id_central_reservas, R.ID_CORPORATE, h.id_hospede,\nH.NOME_HOSPEDE ||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, A.NUM_APARTAMENTO, RS.DATA_ENTRADA, RS.DATA_SAIDA,\nR.BLOQUEIO, 1 AS DISPONIVEL, 1 AS QTDE_APART, 1 AS QTDE_CHECKIN, 1 AS QTDE_PAX, E.NOME_FANTASIA,\nR.GRUPO, RS.CORTESIA, R.OBSERVACAO, RS.CREDITO, RS.CALCULA_TAXA, RS.CALCULA_ISS, RS.CALCULA_ROOMTAX, RS.CALCULA_SEGURO,\nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café', 'ALL', 'All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \nR.NOME_GRUPO, R.CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, 'Não' NOSHOW, A.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado \nFROM RESERVA R, CHECKIN RS, APARTAMENTO A, EMPRESA_rede E, ROOM_LIST RL, HOSPEDE H,CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE TH                      \nWHERE instr(NVL(?2,';'||r.id_hotel||';'), ';'||r.id_hotel||';' ) >= 1\nAND instr(NVL(?3,';'||r.id_hotel||';'), ';'||r.id_hotel||';' ) >= 1\nAND R.ID_RESERVA = RS.ID_RESERVA\nAND RL.ID_HOSPEDE = H.ID_HOSPEDE AND RL.DATA_SAIDA IS NULL\nAND RL.ID_CHECKIN(+) = RS.ID_CHECKIN\nAND RS.ID_APARTAMENTO = A.ID_APARTAMENTO\nAND RS.CHECKOUT = 'N'\nAND E.ID_EMPRESA = RS.ID_EMPRESA\nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel\nAND RA.ID_HOTEL = RS.ID_HOTEL\nAND RA.ID_RESERVA_APARTAMENTO = RS.ID_RESERVA_APARTAMENTO\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE) where 1=1 ";
	public static final String QUERY_PRE_CHECKIN = "SELECT * FROM (\nSELECT /*+ INDEX ( RS IDX_CHECKIN_AP_H_EM_RE_CKO) */ \nRS.ID_RESERVA, RA.ID_RESERVA_APARTAMENTO, RS.ID_CHECKIN, RL.ID_ROOM_LIST, rs.id_central_reservas, NULL AS ID_CORPORATE, h.id_hospede,\nH.NOME_HOSPEDE ||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, A.NUM_APARTAMENTO, RS.DATA_ENTRADA, RS.DATA_SAIDA,\nnull as BLOQUEIO, 1 AS DISPONIVEL, 1 AS QTDE_APART, 1 AS QTDE_CHECKIN, 1 AS QTDE_PAX, E.NOME_FANTASIA,\nNULL AS GRUPO, RS.CORTESIA, NULL AS OBSERVACAO, RS.CREDITO, RS.CALCULA_TAXA, RS.CALCULA_ISS, RS.CALCULA_ROOMTAX, RS.CALCULA_SEGURO,\nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café', 'ALL', 'All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \nNULL AS NOME_GRUPO, NULL AS CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, 'Não' NOSHOW, A.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado \nFROM CHECKIN RS, APARTAMENTO A, EMPRESA_rede E, ROOM_LIST RL, HOSPEDE H,CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE TH\nWHERE RS.ID_APARTAMENTO = A.ID_APARTAMENTO\nAND RS.ID_EMPRESA = E.ID_EMPRESA\nAND instr(NVL(?1,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1 \nAND RL.ID_HOSPEDE = H.ID_HOSPEDE AND RL.DATA_SAIDA IS NULL\nAND RL.ID_CHECKIN(+) = RS.ID_CHECKIN\nAND RS.ID_RESERVA IS NULL\nAND RS.CHECKOUT = 'P'\nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel\nAND RA.ID_HOTEL = RS.ID_HOTEL\nAND RA.ID_RESERVA_APARTAMENTO = RS.ID_RESERVA_APARTAMENTO\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE\nUNION ALL\nSELECT /*+ INDEX ( RS IDX_CHECKIN_AP_H_EM_RE_CKO) */ \n\nRS.ID_RESERVA, RA.ID_RESERVA_APARTAMENTO, RS.ID_CHECKIN, RL.ID_ROOM_LIST, rs.id_central_reservas, R.ID_CORPORATE, h.id_hospede,\nH.NOME_HOSPEDE ||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, A.NUM_APARTAMENTO, RS.DATA_ENTRADA, RS.DATA_SAIDA,\nR.BLOQUEIO, 1 AS DISPONIVEL, 1 AS QTDE_APART, 1 AS QTDE_CHECKIN, 1 AS QTDE_PAX, E.NOME_FANTASIA,\nR.GRUPO, RS.CORTESIA, R.OBSERVACAO, RS.CREDITO, RS.CALCULA_TAXA, RS.CALCULA_ISS, RS.CALCULA_ROOMTAX, RS.CALCULA_SEGURO,\nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café', 'ALL', 'All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \nR.NOME_GRUPO, R.CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, 'Não' NOSHOW, A.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado \nFROM RESERVA R, CHECKIN RS, APARTAMENTO A, EMPRESA_rede E, ROOM_LIST RL, HOSPEDE H,CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE TH                      \nWHERE instr(NVL(?2,';'||r.id_hotel||';'), ';'||r.id_hotel||';' ) >= 1\nAND instr(NVL(?3,';'||r.id_hotel||';'), ';'||r.id_hotel||';' ) >= 1\nAND R.ID_RESERVA = RS.ID_RESERVA\nAND RL.ID_HOSPEDE = H.ID_HOSPEDE AND RL.DATA_SAIDA IS NULL\nAND RL.ID_CHECKIN(+) = RS.ID_CHECKIN\nAND RS.ID_APARTAMENTO = A.ID_APARTAMENTO\nAND RS.CHECKOUT = 'P'\nAND E.ID_EMPRESA = RS.ID_EMPRESA\nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel\nAND RA.ID_HOTEL = RS.ID_HOTEL\nAND RA.ID_RESERVA_APARTAMENTO = RS.ID_RESERVA_APARTAMENTO\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE) where 1=1 ";
	public static final String QUERY_APTO_HISTORICO = "SELECT * FROM (\nSELECT RS.ID_RESERVA, RA.ID_RESERVA_APARTAMENTO, RS.ID_CHECKIN, RL.ID_ROOM_LIST, null as id_central_reserva, NULL AS ID_CORPORATE, rl.id_hospede, \nH.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, apar.NUM_APARTAMENTO, RA.DATA_ENTRADA, RA.DATA_SAIDA, null as BLOQUEIO,\nnull AS DISPONIVEL, 1 AS QTDE_APART, 1 AS QTDE_CHECKIN, 1 AS QTDE_PAX, E.NOME_FANTASIA, NULL AS GRUPO, RS.CORTESIA,\nNULL AS OBSERVACAO, RS.CREDITO, RS.CALCULA_TAXA, RS.CALCULA_ISS, RS.CALCULA_ROOMTAX, RS.CALCULA_SEGURO, \nDECODE(RS.TIPO_PENSAO,'SIM','Café manhã','NAO','Sem café','ALL', 'All Inclusive',RS.TIPO_PENSAO) TIPO_PENSAO, \nNULL AS NOME_GRUPO, NULL AS CONFIRMA, TH.TIPO_HOSPEDE, RS.VALOR_PENSAO, RA.MASTER, \n'Não' NOSHOW, APAR.COFAN, RS.QTDE_ADULTOS, RS.QTDE_CRIANCAS, RS.ADICIONAL, RS.QTDE_CAFE, rl.cod_Certificado \nFROM CHECKIN RS, APARTAMENTO Apar, EMPRESA_REDE E, ROOM_LIST RL, HOSPEDE H, CONTROLA_DATA CD, RESERVA_APARTAMENTO RA, TIPO_HOSPEDE TH\nWHERE RS.ID_APARTAMENTO = Apar.ID_APARTAMENTO\nAND RS.ID_EMPRESA = E.ID_EMPRESA\nAND instr(NVL(?1,';'||rs.id_hotel||';'), ';'||rs.id_hotel||';' ) >= 1\nAND RL.ID_HOSPEDE = H.ID_HOSPEDE AND RL.PRINCIPAL='S' \nAND RL.ID_CHECKIN = RS.ID_CHECKIN\nAND H.ID_TIPO_HOSPEDE = TH.ID_TIPO_HOSPEDE\nAND RS.CHECKOUT = 'S'\nand CD.id_hotel = RS.ID_HOTEL\nand CD.id_rede_hotel = e.id_rede_hotel  \nAND RS.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO(+)) where 1=1 \n";
	public static final String QRY_CHART_APARTAMENTO = "SELECT chart.ID_APARTAMENTO, chart.NUM_APARTAMENTO, chart.DIA, chart.STATUS, chart.obs, ta.id_tipo_apartamento, ta.fantasia FROM TABLE (CHART_STATUS_APTO_WEB(?1,?2,?3)) chart, apartamento apto, tipo_apartamento ta where chart.id_apartamento = apto.id_apartamento and apto.id_tipo_apartamento = ta.id_tipo_apartamento ORDER BY chart.NUM_APARTAMENTO, chart.DIA";
	public static final String QRY_PROCURAR_HOSPEDE = " SELECT * FROM (  SELECT DECODE(C.CHECKOUT,'S',2,nvl2(rl.data_saida,2,1)) STATUS,  A.NUM_APARTAMENTO||'-'||TA.FANTASIA NUM_APARTAMENTO, ER.NOME_FANTASIA, HOS.NOME_HOSPEDE ||' '|| HOS.SOBRENOME_HOSPEDE NOME_HOSPEDE, NVL(RL.DATA_ENTRADA, C.DATA_ENTRADA) DATA_ENTRADA, NVL(RL.DATA_SAIDA,C.DATA_SAIDA) DATA_SAIDA  FROM CONTROLA_DATA CD, CHECKIN C, APARTAMENTO A, TIPO_APARTAMENTO TA, EMPRESA_REDE ER, ROOM_LIST RL, HOSPEDE HOS  WHERE CD.ID_HOTEL = ?1  AND CD.ID_HOTEL = C.ID_HOTEL  AND C.ID_EMPRESA = ER.ID_EMPRESA  AND ER.ID_REDE_HOTEL = CD.ID_REDE_HOTEL  AND TA.ID_HOTEL = CD.ID_HOTEL  AND C.ID_APARTAMENTO = A.ID_APARTAMENTO  AND A.ID_TIPO_APARTAMENTO = TA.ID_TIPO_APARTAMENTO  AND C.ID_CHECKIN = RL.ID_CHECKIN  AND RL.ID_HOSPEDE = HOS.ID_HOSPEDE  AND TRUNC(CD.FRONT_OFFICE) BETWEEN TRUNC(C.DATA_ENTRADA) AND TRUNC(C.DATA_SAIDA)  AND TRUNC(nvl(rl.data_saida+1, CD.FRONT_OFFICE)) = TRUNC(CD.FRONT_OFFICE)  union all  SELECT 3 STATUS,  DECODE(A.NUM_APARTAMENTO,NULL,'',A.NUM_APARTAMENTO||'-'||TA.FANTASIA) NUM_APARTAMENTO, ER.NOME_FANTASIA, HOS.NOME_HOSPEDE ||' '|| HOS.SOBRENOME_HOSPEDE NOME_HOSPEDE,  RA.DATA_ENTRADA DATA_ENTRADA, RA.DATA_SAIDA DATA_SAIDA  FROM CONTROLA_DATA CD, RESERVA R, RESERVA_APARTAMENTO RA, APARTAMENTO A, TIPO_APARTAMENTO TA, EMPRESA_REDE ER, ROOM_LIST RL, HOSPEDE HOS  WHERE CD.ID_HOTEL = ?2  AND CD.ID_HOTEL = RA.ID_HOTEL  AND R.ID_EMPRESA = ER.ID_EMPRESA  AND ER.ID_REDE_HOTEL = CD.ID_REDE_HOTEL  AND RA.ID_APARTAMENTO = A.ID_APARTAMENTO(+)  AND A.ID_TIPO_APARTAMENTO = TA.ID_TIPO_APARTAMENTO(+)  AND RA.ID_RESERVA_APARTAMENTO = RL.ID_RESERVA_APARTAMENTO(+)  AND RL.ID_HOSPEDE = HOS.ID_HOSPEDE  AND RA.QTDE_CHECKIN = 0  AND RA.ID_RESERVA = R.ID_RESERVA  AND TRUNC(CD.FRONT_OFFICE) = TRUNC(RA.DATA_ENTRADA)  AND R.APAGADA = 'N'  \t\t) WHERE  \t\tINSTR(NUM_APARTAMENTO||NOME_FANTASIA||NOME_HOSPEDE, ?3) > 0 ";
	public static final String QRY_STATUS_NOTA = " SELECT DISTINCT sn.id_nota, sn.id_checkin, a.num_apartamento, ta.fantasia,  sn.num_nota, to_char(sn.NOTA_INICIAL) notaInicial, h.nome_hospede  ||' '  ||h.sobrenome_hospede nome_hospede, eR.nome_fantasia, SN.DATA FROM status_nota sn, checkin c, apartamento a, tipo_apartamento ta, movimento_apartamento ma, room_list rl, hospede h, empresa_hotel eh, EMPRESA_REDE ER, hotel ht WHERE c.id_empresa = eh.id_empresa AND c.id_hotel = eh.id_hotel AND rl.id_hospede = h.id_hospede AND rl.id_checkin = ma.id_checkin AND rl.id_room_list = ma.id_room_list AND c.id_checkin = ma.id_checkin AND sn.id_nota = ma.id_nota AND sn.id_checkin = c.id_checkin AND sn.id_hotel = c.id_hotel AND c.id_apartamento = a.id_apartamento AND c.id_hotel = a.id_hotel AND a.id_tipo_apartamento = ta.id_tipo_apartamento AND c.ID_EMPRESA = ER.ID_EMPRESA AND h.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND sn.status = 'OK' AND sn.restaurante = 'N' AND sn.id_hotel = ht.id_hotel AND sn.id_hotel = ?1 AND TO_CHAR(SN.DATA,'DD/MM/YYYY')  BETWEEN ?2 AND ?3 AND sn.RESTAURANTE = 'N' ";
	public static final String QRY_MOV_APTO_PGTO_ANTECIPADO = " SELECT MA.ID_MOVIMENTO_APARTAMENTO, MA.ID_CHECKIN,  MA.NUM_DOCUMENTO,  A.ID_APARTAMENTO FROM MOVIMENTO_APARTAMENTO MA JOIN CHECKIN C ON MA.ID_CHECKIN = C.ID_CHECKIN AND C.CHECKOUT   = 'N' JOIN APARTAMENTO A ON C.ID_APARTAMENTO = A.ID_APARTAMENTO AND A.COFAN = 'S' WHERE MA.NUM_DOCUMENTO LIKE ?1 AND MA.MOV_TMP = 'S' ";
	public static final String QRY_CARGA_DADOS_RPS = " SELECT SN.ID_NOTA, "
			+ "   NVL(X.VALOR,0) + NVL(Y.VALOR,0) VALOR_NOTA,                           "
			+ "   NVL(Y.VALOR,0) VALOR_DEDUCAO,                                         "
			+ "   NVL(X.VALOR,0) BASE_CALCULO,                                          "
			+ "   H.ISS ALIQUOTA_ISS,                                                   "
			+ "   NVL(ROUND((X.VALOR * H.ISS / 100),2),0) VR_ISS,                       "
//			+ "   FC.TIPO_SERVICO,                                                    "
//			+ "   FC.TIPO_DOCUMENTO,                                                  "
//			+ "   FC.SITUACAO_NF,                                                     "
			+ "   CH.ID_EMPRESA,                                                        "
			+ "   H.NOTA_FISCAL_CODIGO,                                                 "
			+ "   MIN(HO.ID_HOSPEDE) ID_HOSPEDE,                                        "
			+ "   MA.QUEM_PAGA,                                                         "
			+ "   NVL(X.VALOR,0)*ER.IR_RETENCAO /100 IR_RETENCAO,                       "
			+ "   NVL(X.VALOR,0)*ER.CSLL /100 CSLL,                                     "
			+ "   NVL(X.VALOR,0)*ER.COFINS /100 COFINS,                                 "
			+ "   NVL(X.VALOR,0)*ER.PIS /100 PIS,                                       "
			+ "   NVL(X.VALOR,0)*ER.INSS /100 INSS,                                     "
			+ "   NVL(X.VALOR,0)*ER.OUTRAS_RETENCOES /100 OUTRAS_RETENCOES,             "
			+ "   NVL(X.VALOR,0)*EH.ISS_RETIDO /100 ISS_RETIDO,                         "
			+ "   TRIM ('Serviços prestados para: ' || HO.NOME_HOSPEDE  || ' ' || 		" 
			+ "   HO.SOBRENOME_HOSPEDE || ' - ' || 'Período de ' 						"
			+ "   || TRUNC(TO_DATE(CH.DATA_ENTRADA,'DD/MM/YY')) || ' a '  				"
			+ "   || TRUNC(TO_DATE(CH.DATA_SAIDA,'DD/MM/YY')) || ' nh: '                "
			+ "   || SN.NUM_NOTA || '. ' || H.NOTA_TERMO || H.IMPOSTOS_SERVICOS         "
			+ "	  || '%' || ' no valor de R$ '											"	 
			+ "	  || TO_CHAR ( NVL(X.VALOR,0) * H.IMPOSTOS_SERVICOS / 100, '999G990D00') "
			+ "   ) DISCRIMINACAO  														"
			+ " FROM STATUS_NOTA SN,                                                    "
			+ "   HOTEL H,                                                              "
			+ "   CHECKIN CH ,                                                          "
			+ "   MOVIMENTO_APARTAMENTO MA,                                             "
//			+ "   FISCAL_CODIGO FC,                                                   "
			+ "   CIDADE C,                                                             "
			+ "   ROOM_LIST RL,                                                         "
			+ "   HOSPEDE HO,                                                           "
			+ "   EMPRESA_REDE ER,                                                      "
			+ "   EMPRESA_HOTEL EH,                                                     "
			+ "   (SELECT SN.NUM_NOTA,                                                  "
			+ "     NVL(TRUNC(SUM(VALOR_LANCAMENTO),2),0) VALOR,                        "
			+ "     DATA                                                                "
			+ "   FROM STATUS_NOTA SN,                                                  "
			+ "     MOVIMENTO_APARTAMENTO MA,                                           "
			+ "     TIPO_LANCAMENTO TL ,                                                "
			+ "     IDENTIFICA_LANCAMENTO IDL                                           "
			+ "   WHERE MA.ID_HOTEL               = ?1                           "
			+ "   AND TL.ID_TIPO_LANCAMENTO       = MA.ID_TIPO_LANCAMENTO               "
			+ "   AND TL.ID_IDENTIFICA_LANCAMENTO = IDL.ID_IDENTIFICA_LANCAMENTO        "
			+ "   AND IDL.RECEITA_CHECKOUT        = 1                                   "
			+ "   AND SN.TIPO_NOTA                = 'F'                                 "
			+ "   AND SN.ID_NOTA                  = ?2                            "
			+ "   AND TL.ISS_NOTA                 = 'S'                                 "
			+ "   AND SN.STATUS                   = 'OK'                                "
			+ "   AND MA.ID_NOTA                    = SN.ID_NOTA                        "
			+ "   AND MA.ID_HOTEL                 = SN.ID_HOTEL                         "
			+ "   AND MA.ID_HOTEL                 = TL.ID_HOTEL                         "
			+ "   GROUP BY SN.NUM_NOTA,                                                 "
			+ "     DATA                                                                "
			+ "   ) X,                                                                  "
			+ "   (SELECT SN.NUM_NOTA,                                                  "
			+ "     NVL(TRUNC(SUM(VALOR_LANCAMENTO),2),0) VALOR,                        "
			+ "     DATA                                                                "
			+ "   FROM STATUS_NOTA SN,                                                  "
			+ "     MOVIMENTO_APARTAMENTO MA,                                           "
			+ "     TIPO_LANCAMENTO TL ,                                                "
			+ "     IDENTIFICA_LANCAMENTO IDL                                           "
			+ "   WHERE MA.ID_HOTEL               = ?3                           "
			+ "   AND MA.ID_HOTEL                 = SN.ID_HOTEL                         "
			+ "   AND MA.ID_HOTEL                 = TL.ID_HOTEL                         "
			+ "   AND TL.ID_TIPO_LANCAMENTO       = MA.ID_TIPO_LANCAMENTO               "
			+ "   AND TL.ID_IDENTIFICA_LANCAMENTO = IDL.ID_IDENTIFICA_LANCAMENTO        "
			+ "   AND IDL.RECEITA_CHECKOUT        = 1                                   "
			+ "   AND SN.ID_NOTA                  = ?4                            "
			+ "   AND SN.STATUS                   = 'OK'                                "
			+ "   AND SN.TIPO_NOTA                = 'F'                                 "
			+ "   AND TL.ISS_NOTA                 = 'N'                                 "
			+ "   AND MA.ID_NOTA                    = SN.ID_NOTA                        "
			+ "   GROUP BY SN.NUM_NOTA,                                                 "
			+ "     DATA                                                                "
			+ "   ) Y                                                                   "
			+ " WHERE SN.ID_HOTEL   = ?5                                         "
			+ " AND SN.ID_HOTEL     = H.ID_HOTEL                                        "
			+ " AND SN.ID_HOTEL     = CH.ID_HOTEL                                       "
//			+ " AND H.ID_CIDADE     = FC.ID_CIDADE                                    "
			+ " AND SN.ID_CHECKIN   = CH.ID_CHECKIN                                     "
			+ " AND SN.ID_NOTA      = ?6                                         "
			+ " AND EH.ID_EMPRESA   = CH.ID_EMPRESA                                     "
			+ " AND ER.ID_EMPRESA   = CH.ID_EMPRESA                                     "
			+ " AND ER.ID_REDE_HOTEL= H.ID_REDE_HOTEL                                   "
			+ " AND SN.NUM_NOTA     = Y.NUM_NOTA(+)                                     "
			+ " AND SN.NUM_NOTA     = X.NUM_NOTA(+)                                     "
			+ " AND SN.TIPO_NOTA    = 'F'                                               "
			+ " AND SN.STATUS       = 'OK'                                              "
			+ " AND MA.ID_HOTEL     = CH.ID_HOTEL                                       "
			+ " AND MA.ID_NOTA        = SN.ID_NOTA                                      "
			+ " AND MA.ID_ROOM_LIST = RL.ID_ROOM_LIST                                   "
			+ " AND RL.ID_HOSPEDE   = HO.ID_HOSPEDE                                     "
			+ " GROUP BY SN.ID_NOTA,                                                    "
			+ "   X.VALOR,                                                              "
			+ "   Y.VALOR,                                                              "
			+ "   H.ISS,                                                                "
//			+ "   FC.TIPO_SERVICO,                                                    "
//			+ "   FC.TIPO_DOCUMENTO,                                                  "
//			+ "   FC.SITUACAO_NF,                                                     "
			+ "   CH.ID_EMPRESA,                                                        "
			+ "   H.NOTA_FISCAL_CODIGO ,                                                "
			+ "   SN.NUM_NOTA,                                                          "
			+ "   SN.DATA,                                                              "
			+ "   MA.QUEM_PAGA,                                                         "
			+ "   ER.IR_RETENCAO,                                                       "
			+ "   ER.CSLL,                                                              "
			+ "   ER.COFINS,                                                            "
			+ "   ER.PIS,                                                               "
			+ "   ER.INSS,                                                              "
			+ "   ER.OUTRAS_RETENCOES,                                                  "
			+ "   EH.ISS_RETIDO,                                                        "
			+ "   TRIM ('Serviços prestados para: ' || HO.NOME_HOSPEDE  || ' ' || 		" 
			+ "   HO.SOBRENOME_HOSPEDE || ' - ' || 'Período de ' 						"
			+ "   || TRUNC(TO_DATE(CH.DATA_ENTRADA,'DD/MM/YY')) || ' a '  				"
			+ "   || TRUNC(TO_DATE(CH.DATA_SAIDA,'DD/MM/YY')) || ' nh: '                "
			+ "   || SN.NUM_NOTA || '. ' || H.NOTA_TERMO || H.IMPOSTOS_SERVICOS         "
			+ "	  || '%' || ' no valor de R$ '											"	 
			+ "	  || TO_CHAR ( NVL(X.VALOR,0) * H.IMPOSTOS_SERVICOS / 100, '999G990D00')) ";
	
	 String QRY_HOSPEDES_FNRH = 
		    	" SELECT RA.ID_RESERVA , RL.ID_HOSPEDE, "
		    	+ "	TRIM (H.NOME_HOSPEDE) ||' '|| TRIM (H.SOBRENOME_HOSPEDE) NOME_COMPLETO, "
		    	+ " RA.DATA_ENTRADA "
		    	+ " FROM RESERVA_APARTAMENTO RA "
		    	+ " JOIN ROOM_LIST RL ON (RA.ID_RESERVA = RL.ID_RESERVA) "
		    	+ " JOIN HOSPEDE H ON RL.ID_HOSPEDE=H.ID_HOSPEDE "
		    	+ " JOIN RESERVA R ON RA.ID_RESERVA= R.ID_RESERVA"
		    	+ " WHERE 1=1 ";


	 public static final String QRY_CARGA_DADOS_RPS_PROG_DIF_1 = " SELECT SN.ID_NOTA, "
				+ "   NVL(X.VALOR,0) + NVL(Y.VALOR,0) VALOR_NOTA,                           "
				+ "   NVL(Y.VALOR,0) VALOR_DEDUCAO,                                         "
				+ "   NVL(X.VALOR,0) BASE_CALCULO,                                          "
				+ "   H.ISS ALIQUOTA_ISS,                                                   "
				+ "   NVL(ROUND((X.VALOR * H.ISS / 100),2),0) VR_ISS,                       "
//				+ "   FC.TIPO_SERVICO,                                                    "
//				+ "   FC.TIPO_DOCUMENTO,                                                  "
//				+ "   FC.SITUACAO_NF,                                                     "
				+ "   CH.ID_EMPRESA,                                                        "
				+ "   H.NOTA_FISCAL_CODIGO,                                                 "
				+ "   MA.QUEM_PAGA,                                                         "
				+ "   NVL(X.VALOR,0)*ER.IR_RETENCAO /100 IR_RETENCAO,                       "
				+ "   NVL(X.VALOR,0)*ER.CSLL /100 CSLL,                                     "
				+ "   NVL(X.VALOR,0)*ER.COFINS /100 COFINS,                                 "
				+ "   NVL(X.VALOR,0)*ER.PIS /100 PIS,                                       "
				+ "   NVL(X.VALOR,0)*ER.INSS /100 INSS,                                     "
				+ "   NVL(X.VALOR,0)*ER.OUTRAS_RETENCOES /100 OUTRAS_RETENCOES,             "
				+ "   NVL(X.VALOR,0)*EH.ISS_RETIDO /100 ISS_RETIDO,                         "
				+ " TRIM ('Serviços prestados no Período de ' 								" 
				+ " || TRUNC(TO_DATE(CH.DATA_ENTRADA,'DD/MM/YY')) || ' a ' 					" 
				+ " || TRUNC(TO_DATE(CH.DATA_SAIDA,'DD/MM/YY')) || ' conta corrente: ' 		" 
				+ " || SN.NUM_NOTA || '. ' || H.NOTA_TERMO || H.IMPOSTOS_SERVICOS || '%' 	" 
				+ " || ' no valor de R$ ' || TO_CHAR (NVL(X.VALOR,0) 						"
				+ " 				* H.IMPOSTOS_SERVICOS / 100, '999G990D00')) DISCRIMINACAO "
				+ " FROM STATUS_NOTA SN,                                                    "
				+ "   HOTEL H,                                                              "
				+ "   CHECKIN CH ,                                                          "
				+ "   MOVIMENTO_APARTAMENTO MA,                                             "
//				+ "   FISCAL_CODIGO FC,                                                   "
				+ "   CIDADE C,                                                             "
				+ "   EMPRESA_REDE ER,                                                      "
				+ "   EMPRESA_HOTEL EH,                                                     "
				+ "   (SELECT SN.NUM_NOTA,                                                  "
				+ "     NVL(TRUNC(SUM(VALOR_LANCAMENTO),2),0) VALOR,                        "
				+ "     DATA                                                                "
				+ "   FROM STATUS_NOTA SN,                                                  "
				+ "     MOVIMENTO_APARTAMENTO MA,                                           "
				+ "     TIPO_LANCAMENTO TL ,                                                "
				+ "     IDENTIFICA_LANCAMENTO IDL                                           "
				+ "   WHERE MA.ID_HOTEL               = ?1                           "
				+ "   AND TL.ID_TIPO_LANCAMENTO       = MA.ID_TIPO_LANCAMENTO               "
				+ "   AND TL.ID_IDENTIFICA_LANCAMENTO = IDL.ID_IDENTIFICA_LANCAMENTO        "
				+ "   AND IDL.RECEITA_CHECKOUT        = 1                                   "
				+ "   AND SN.TIPO_NOTA                = 'F'                                 "
				+ "   AND SN.ID_NOTA                  = ?2                            "
				+ "   AND TL.ISS_NOTA                 = 'S'                                 "
				+ "   AND SN.STATUS                   = 'OK'                                "
				+ "   AND MA.ID_NOTA                    = SN.ID_NOTA                        "
				+ "   AND MA.ID_HOTEL                 = SN.ID_HOTEL                         "
				+ "   AND MA.ID_HOTEL                 = TL.ID_HOTEL                         "
				+ "   GROUP BY SN.NUM_NOTA,                                                 "
				+ "     DATA                                                                "
				+ "   ) X,                                                                  "
				+ "   (SELECT SN.NUM_NOTA,                                                  "
				+ "     NVL(TRUNC(SUM(VALOR_LANCAMENTO),2),0) VALOR,                        "
				+ "     DATA                                                                "
				+ "   FROM STATUS_NOTA SN,                                                  "
				+ "     MOVIMENTO_APARTAMENTO MA,                                           "
				+ "     TIPO_LANCAMENTO TL ,                                                "
				+ "     IDENTIFICA_LANCAMENTO IDL                                           "
				+ "   WHERE MA.ID_HOTEL               = ?3                           "
				+ "   AND MA.ID_HOTEL                 = SN.ID_HOTEL                         "
				+ "   AND MA.ID_HOTEL                 = TL.ID_HOTEL                         "
				+ "   AND TL.ID_TIPO_LANCAMENTO       = MA.ID_TIPO_LANCAMENTO               "
				+ "   AND TL.ID_IDENTIFICA_LANCAMENTO = IDL.ID_IDENTIFICA_LANCAMENTO        "
				+ "   AND IDL.RECEITA_CHECKOUT        = 1                                   "
				+ "   AND SN.ID_NOTA                  = ?4                            "
				+ "   AND SN.STATUS                   = 'OK'                                "
				+ "   AND SN.TIPO_NOTA                = 'F'                                 "
				+ "   AND TL.ISS_NOTA                 = 'N'                                 "
				+ "   AND MA.ID_NOTA                    = SN.ID_NOTA                        "
				+ "   GROUP BY SN.NUM_NOTA,                                                 "
				+ "     DATA                                                                "
				+ "   ) Y                                                                   "
				+ " WHERE SN.ID_HOTEL   = ?5                                         "
				+ " AND SN.ID_HOTEL     = H.ID_HOTEL                                        "
				+ " AND SN.ID_HOTEL     = CH.ID_HOTEL                                       "
//				+ " AND H.ID_CIDADE     = FC.ID_CIDADE                                    "
				+ " AND SN.ID_CHECKIN   = CH.ID_CHECKIN                                     "
				+ " AND SN.ID_NOTA      = ?6                                         "
				+ " AND EH.ID_EMPRESA   = CH.ID_EMPRESA                                     "
				+ " AND ER.ID_EMPRESA   = CH.ID_EMPRESA                                     "
				+ " AND ER.ID_REDE_HOTEL= H.ID_REDE_HOTEL                                   "
				+ " AND SN.NUM_NOTA     = Y.NUM_NOTA(+)                                     "
				+ " AND SN.NUM_NOTA     = X.NUM_NOTA(+)                                     "
				+ " AND SN.TIPO_NOTA    = 'F'                                               "
				+ " AND SN.STATUS       = 'OK'                                              "
				+ " AND MA.ID_HOTEL     = CH.ID_HOTEL                                       "
				+ " AND MA.ID_NOTA        = SN.ID_NOTA                                      "
				+ " GROUP BY SN.ID_NOTA,                                                    "
				+ "   X.VALOR,                                                              "
				+ "   Y.VALOR,                                                              "
				+ "   H.ISS,                                                                "
//				+ "   FC.TIPO_SERVICO,                                                    "
//				+ "   FC.TIPO_DOCUMENTO,                                                  "
//				+ "   FC.SITUACAO_NF,                                                     "
				+ "   CH.ID_EMPRESA,                                                        "
				+ "   H.NOTA_FISCAL_CODIGO ,                                                "
				+ "   SN.NUM_NOTA,                                                          "
				+ "   SN.DATA,                                                              "
				+ "   MA.QUEM_PAGA,                                                         "
				+ "   ER.IR_RETENCAO,                                                       "
				+ "   ER.CSLL,                                                              "
				+ "   ER.COFINS,                                                            "
				+ "   ER.PIS,                                                               "
				+ "   ER.INSS,                                                              "
				+ "   ER.OUTRAS_RETENCOES,                                                  "
				+ "   EH.ISS_RETIDO,                                                        "
				+ " TRIM ('Serviços prestados no Período de ' 								" 
				+ " || TRUNC(TO_DATE(CH.DATA_ENTRADA,'DD/MM/YY')) || ' a ' 					" 
				+ " || TRUNC(TO_DATE(CH.DATA_SAIDA,'DD/MM/YY')) || ' conta corrente: ' 		" 
				+ " || SN.NUM_NOTA || '. ' || H.NOTA_TERMO || H.IMPOSTOS_SERVICOS || '%' 	" 
				+ " || ' no valor de R$ ' || TO_CHAR (NVL(X.VALOR,0) 						"
				+ " 				* H.IMPOSTOS_SERVICOS / 100, '999G990D00')) 			";
		
		 
	public abstract List<CheckinVO> pesquisarCheckin(CheckinVO paramCheckinVO)
			throws MozartSessionException;

	public abstract List<TipoApartamentoEJB> obterTipoApartamento(
			TipoApartamentoEJB paramTipoApartamentoEJB)
			throws MozartSessionException;

	public abstract List<ApartamentoEJB> obterApartamento(
			ApartamentoEJB paramApartamentoEJB);

	public abstract List<HospedeEJB> pesquisarHospede(HospedeVO paramHospedeVO);

	public abstract List<CidadeEJB> pesquisarCidade(String paramString);

	public abstract List<TipoLancamentoEJB> pesquisarTipoLancamento(
			TipoLancamentoEJB paramTipoLancamentoEJB);

	public abstract HospedeEJB gravarHospede(HospedeEJB paramHospedeEJB)
			throws MozartSessionException;

	public abstract HospedeEJB findHospede(HospedeEJB paramHospedeEJB)
			throws MozartSessionException;

	public abstract List<MoedaEJB> pesquisarMoeda();

	public abstract List<ApartamentoEJB> pesquisarApartamento(
			ApartamentoEJB paramApartamentoEJB, Boolean incluirSujo);

	public abstract TipoDiariaEJB obterTipoDiariaPadraoByRede(Long paramLong)
			throws MozartValidateException;

	public abstract TipoLancamentoEJB obterTipoLancamentoByPK(
			TipoLancamentoEJBPK paramTipoLancamentoEJBPK);

	public abstract List<TipoLancamentoEJB> pesquisarTipoLancamentoByFiltro(
			TipoLancamentoEJB paramTipoLancamentoEJB)
			throws MozartSessionException;

	public abstract CheckinEJB gravarWalkin(CheckinEJB paramCheckinEJB)
			throws MozartSessionException;

	public abstract CheckinEJB obterCheckin(Long paramLong) throws MozartSessionException;

	public abstract ApartamentoEJB obterApartamentoByPK(
			ApartamentoEJBPK paramApartamentoEJBPK);

	public abstract List<TipoLancamentoEJB> pesquisarSubGrupoLancamento(
			TipoLancamentoEJB paramTipoLancamentoEJB);

	public abstract List<TipoDiariaEJB> pesquisarTipoDiaria(
			TipoDiariaEJB paramTipoDiariaEJB);

	public abstract Object persist(Object paramObject)
			throws MozartSessionException;

	public abstract CheckinEJB gravarCheckout(CheckinEJB paramCheckinEJB)
			throws MozartSessionException;

	public abstract CheckinEJB lancarTaxas(CheckinEJB paramCheckinEJB)
			throws MozartSessionException;

	public abstract StatusNotaEJB obterProximaNotaHospedagem(
			HotelEJB paramHotelEJB) throws MozartSessionException;
	
	public abstract StatusNotaEJB obterProximaNotaHospedagem(
			HotelEJB paramHotelEJB, String tipoNota) throws MozartSessionException;

	public abstract void devolverObjetos(List<MovimentoObjetoEJB> paramList)
			throws MozartSessionException;

	public abstract List<MovimentoApartamentoEJB> pagarObjetos(
			MovimentoApartamentoEJB paramMovimentoApartamentoEJB,
			List<MovimentoObjetoEJB> paramList) throws MozartSessionException;

	public abstract Object alterar(Object paramObject)
			throws MozartSessionException;

	public abstract void liberarCheckin(CheckinEJB paramCheckinEJB)
			throws MozartSessionException;

	public abstract RoomListEJB liberarHospede(RoomListEJB paramRoomListEJB)
			throws MozartSessionException;

	public abstract List<PontoVendaEJB> pesquisarPontoVendaByFiltro(
			PontoVendaEJB paramPontoVendaEJB) throws MozartSessionException;

	public abstract Object obter(Class paramClass, Object paramObject)
			throws MozartSessionException;

	public abstract StatusNotaEJB obterProximaNotaFiscal(Long paramLong)
			throws MozartSessionException;

	public abstract List<ChartApartamentoVO> pesquisarChartApartamento(
			ChartApartamentoVO paramChartApartamentoVO)
			throws MozartSessionException;

	public abstract List<StatusNotaVO> pesquisarStatusNota(
			HotelEJB paramHotelEJB, String paramString,
			Timestamp paramTimestamp1, Timestamp paramTimestamp2)
			throws MozartSessionException;

	public abstract List<ProcurarHospedeVO> procurarHospede(
			ProcurarHospedeVO paramProcurarHospedeVO)
			throws MozartSessionException;

	public abstract CheckinEJB obterCheckinParaAlteracao(Long paramLong)
			throws MozartSessionException;

	public abstract List<TipoLancamentoEJB> pesquisarGrupoLancamento(
			TipoLancamentoEJB paramTipoLancamentoEJB)
			throws MozartSessionException;

	public abstract void unificaTaxasCheckin(CheckinEJB paramCheckinEJB)
			throws MozartSessionException;

	public abstract RoomListEJB liberarHospedeComPrincipal(
			RoomListEJB paramRoomListEJB, Long paramLong)
			throws MozartSessionException;

	public abstract void substituirHospedeCheckin(RoomListEJB paramRoomListEJB,
			HospedeEJB paramHospedeEJB) throws MozartSessionException;

	public abstract Object refresh(Class paramClass, Object paramObject)
			throws MozartSessionException;

	public abstract void excluir(Object paramObject)
			throws MozartSessionException;

	public abstract CheckinEJB obterCheckinComplemento(
			CheckinEJB paramCheckinEJB);

	public abstract void gravarCheckin(UsuarioEJB paramUsuarioEJB,
			List<CheckinEJB> paramList) throws MozartSessionException;

	public abstract List<MovAptoPgtoAntecipadoVO> buscarPagamentoAntecipado(Long idReserva) throws MozartSessionException;

	public abstract StatusNotaEJB atualizarDadosRPS(StatusNotaEJB pStatusNota) throws MozartSessionException;
	
	public abstract List<RoomListVO> pesquisarHospedeFNRH(RoomListEJB roomListEJB) throws MozartSessionException;

	public abstract List<ContaCorrenteGeralVO> pesquisarContaCorrenteGeral(ContaCorrenteGeralVO pFiltro) throws MozartSessionException;
	
	public abstract List obterValidacaoContrato(Long idHotel) throws MozartSessionException;

	public abstract void lancarContrato(ControlaDataEJB controlaData) throws MozartSessionException;
	
	public List<MovimentoApartamentoEJB> obterMovimentosPorIdNota(Long idNota) throws MozartSessionException;

	public abstract CidadeEJB pesquisarCidadePorCodigoIBGE(Long valor);
	
}