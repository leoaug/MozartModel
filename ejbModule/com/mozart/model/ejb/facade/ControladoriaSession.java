package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ConfigBloqueteEJB;
import com.mozart.model.ejb.entity.ContaCorrenteEJB;
import com.mozart.model.ejb.entity.IdentificaLancamentoEJB;
import com.mozart.model.ejb.entity.TipoPensaoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ContaCorrenteVO;
import com.mozart.model.vo.LogUsuarioVO;
import com.mozart.model.vo.TipoLancamentoVO;
import com.mozart.model.vo.ValorCafeVO;
import com.mozart.model.vo.ValorDolarVO;

@Remote
public interface ControladoriaSession {

	String QRY_VALOR_DOLAR = " select id_valor_dolar, data, valor_dolar, m.simbolo, m.nome_moeda "
			+ " from valor_dolar vd, moeda m "
			+ " where vd.id_moeda = m.id_moeda ";

	List<ValorDolarVO> pesquisarValorDolar(ValorDolarVO filtro)
			throws MozartSessionException;

	String QRY_VALOR_CAFE = " SELECT ID_VALOR_CAFE, DATA, VALOR_CAFE, DESCRICAO "
			+ " FROM VALOR_CAFE VC, TIPO_PENSAO TP "
			+ " WHERE VC.ID_TIPO_PENSAO = TP.ID_TIPO_PENSAO ";

	List<ValorCafeVO> pesquisarValorCafe(ValorCafeVO filtro)
			throws MozartSessionException;

	List<TipoPensaoEJB> pesquisarTipoPensao() throws MozartSessionException;

	String QRY_CONTA_CORRENTE = " SELECT CC.ID_CONTA_CORRENTE, CC.NUM_CONTA_CORRENTE, B.BANCO, CC.NOME_AGENCIA, CC.NUMERO_AGENCIA, "
			+ " CC.COBRANCA, CC.PAGAMENTO, HC.HISTORICO HISTORICO_CREDITO, HD.HISTORICO HISTORICO_DEBITO, "
			+ " PC_REC.NOME_CONTA NOME_CONTAS_REC, PC_PAG.NOME_CONTA NOME_CONTAS_PAG, "
			+ " CCC.DESCRICAO_CENTRO_CUSTO CENTRO_CUSTO_CREDITO, CCD.DESCRICAO_CENTRO_CUSTO CENTRO_CUSTO_DEBITO, CC.ID_CONTABIL_REC , CC.CARTEIRA "
			+ " FROM CONTA_CORRENTE_X CC, BANCO B, HISTORICO_CONTABIL HC, HISTORICO_CONTABIL HD, PLANO_CONTAS PC_REC, PLANO_CONTAS PC_PAG, "
			+ " CENTRO_CUSTO_CONTABIL CCC, CENTRO_CUSTO_CONTABIL CCD "
			+ " WHERE B.ID_BANCO = CC.ID_BANCO AND CC.ID_HOTEL = ?1 "
			+ " AND CC.ID_HISTORICO_CREDITO = HC.ID_HISTORICO(+) "
			+ " AND CC.ID_REDE_HOTEL = HC.ID_REDE_HOTEL (+) "
			+ " AND CC.ID_HISTORICO_DEBITO = HD.ID_HISTORICO (+) "
			+ " AND CC.ID_REDE_HOTEL = HD.ID_REDE_HOTEL (+) "
			+ " AND CC.ID_CONTABIL_REC = PC_REC.ID_PLANO_CONTAS (+) "
			+ " AND CC.ID_REDE_HOTEL = PC_REC.ID_REDE_HOTEL (+) "
			+ " AND CC.ID_CONTABIL_PAG = PC_PAG.ID_PLANO_CONTAS (+) "
			+ " AND CC.ID_REDE_HOTEL = PC_PAG.ID_REDE_HOTEL (+) "
			+ " AND CC.ID_CENTRO_CUSTO_CONTABIL_D = CCD.ID_CENTRO_CUSTO_CONTABIL(+) "
			+ " AND CC.ID_REDE_HOTEL = CCD.ID_REDE_HOTEL(+) "
			+ " AND CC.ID_CENTRO_CUSTO_C = CCC.ID_CENTRO_CUSTO_CONTABIL(+) "
			+ " AND CC.ID_REDE_HOTEL = CCC.ID_REDE_HOTEL(+) ";

	String QRY_LOG_USUARIO = " SELECT ID_AUDITADO, OPERACAO, USUARIO, ESTACAO, DATA_SISTEMA, HORA, ALTERACAO, GERAL, NULL GERAL2 "
			+ " FROM (SELECT LOG.ID_AUDITADO, OPERACAO, SUBSTR(U.NICK,8) USUARIO, ESTACAO, "
			+ " DATA DATA_SISTEMA, HORA, ALTERACAO, '' GERAL "
			+ " FROM LOG_USUARIO LOG, USUARIO U "
			+ " WHERE LOG.ID_USUARIO = U.ID_USUARIO "
			+ " AND TABELA_AUDITADA = ?1 ";

	String QRY_LOG_USUARIO_RESERVA = " SELECT ID_AUDITADO, OPERACAO, USUARIO, ESTACAO, DATA_SISTEMA, HORA, ALTERACAO, GERAL, GERAL2 FROM ("
			+ " SELECT /*+INDEX(EMPRESA_REDE PK_EMPRESA_REDE)*/ "
			+ " ID_AUDITADO, LOG.OPERACAO, SUBSTR(USUARIO.NICK,8) USUARIO, LOG.ESTACAO, "
			+ " LOG.DATA DATA_SISTEMA, LOG.HORA, LOG.ALTERACAO, "
			+ " TRIM(HOSPEDE.NOME_HOSPEDE) || '  ' || TRIM( HOSPEDE.SOBRENOME_HOSPEDE) GERAL, "
			+ " EMPRESA_REDE.NOME_FANTASIA GERAL2 "
			+ " FROM LOG_USUARIO LOG, USUARIO, RESERVA, ROOM_LIST, HOSPEDE, EMPRESA_REDE,  CONTROLA_DATA CD "
			+ " WHERE EMPRESA_REDE.ID_REDE_HOTEL = CD.ID_REDE_HOTEL "
			+ " AND EMPRESA_REDE.ID_EMPRESA = RESERVA.ID_EMPRESA "
			+ " AND RESERVA.ID_HOTEL = CD.ID_HOTEL "
			+ " AND RESERVA.ID_RESERVA =  LOG.ID_AUDITADO "
			+ " AND LOG.ID_HOTEL = RESERVA.ID_HOTEL "
			+ " AND LOG.TABELA_AUDITADA = ?1 "
			+ " AND LOG.ID_USUARIO = USUARIO.ID_USUARIO "
			+ " AND ROOM_LIST.ID_HOTEL = CD.ID_HOTEL "
			+ " AND ROOM_LIST.ID_RESERVA = RESERVA.ID_RESERVA "
			+ " AND ROOM_LIST.ID_HOSPEDE = HOSPEDE.ID_HOSPEDE ";

	String QRY_LOG_USUARIO_CHECKIN = " SELECT ID_AUDITADO, OPERACAO, USUARIO, ESTACAO, DATA_SISTEMA, HORA, ALTERACAO, GERAL, GERAL2 "
			+ " FROM (  "
			+ " SELECT   "
			+ " ID_AUDITADO, LOG.OPERACAO,  "
			+ " SUBSTR(USUARIO.NICK,8) USUARIO, LOG.ESTACAO,  "
			+ " LOG.DATA DATA_SISTEMA, LOG.HORA,   "
			+ " LOG.ALTERACAO,   "
			+ " 'Reserva: '||RESERVA.ID_RESERVA GERAL, EMPRESA_REDE.NOME_FANTASIA GERAL2 "
			+ " FROM LOG_USUARIO LOG, CHECKIN, USUARIO, EMPRESA_REDE, RESERVA, CONTROLA_DATA CD "
			+ " WHERE EMPRESA_REDE.ID_REDE_HOTEL = CD.ID_REDE_HOTEL "
			+ " AND EMPRESA_REDE.ID_EMPRESA = RESERVA.ID_EMPRESA "
			+ " AND RESERVA.ID_HOTEL = CD.ID_HOTEL "
			+ " AND CD.ID_HOTEL = CHECKIN.ID_HOTEL "
			+ " AND LOG.ID_HOTEL = CHECKIN.ID_HOTEL "
			+ " AND LOG.ID_AUDITADO = CHECKIN.ID_CHECKIN "
			+ " AND LOG.ID_USUARIO = USUARIO.ID_USUARIO "
			+ " AND LOG.TABELA_AUDITADA = ?1 "
			+ " AND CHECKIN.ID_RESERVA = RESERVA.ID_RESERVA";

	String QRY_LOG_USUARIO_EMPRESA = " SELECT ID_AUDITADO, OPERACAO, USUARIO, ESTACAO, DATA_SISTEMA, HORA, ALTERACAO, GERAL, GERAL2 "
			+ " FROM ( "
			+ " SELECT ID_AUDITADO, log.OPERACAO, "
			+ " SUBSTR(USUARIO.NICK,8) USUARIO, log.ESTACAO, "
			+ " log.DATA DATA_SISTEMA, log.HORA, "
			+ " log.ALTERACAO, "
			+ " EMPRESA_REDE.NOME_FANTASIA GERAL, NULL GERAL2 "
			+ " FROM LOG_USUARIO log, USUARIO, EMPRESA_REDE, CONTROLA_DATA CD "
			+ " WHERE EMPRESA_REDE.ID_REDE_HOTEL = CD.ID_REDE_HOTEL "
			+ " AND log.ID_HOTEL = CD.ID_HOTEL "
			+ " AND log.ID_AUDITADO = EMPRESA_REDE.ID_EMPRESA "
			+ " AND log.ID_USUARIO = USUARIO.ID_USUARIO "
			+ " AND log.TABELA_AUDITADA = ?1 ";

	String QRY_TIPO_LANCAMENTO = " SELECT TL.ID_TIPO_LANCAMENTO, H.SIGLA, TL.DESCRICAO_LANCAMENTO, TL.GRUPO_LANCAMENTO, TL.SUB_GRUPO_LANCAMENTO, DECODE(TL.DEBITO_CREDITO,'D','Débito','Crédito') DC, "
			+ " DECODE(TL.NOTA_FISCAL,'S','Sim','Não') NOTA_FISCAL, "
			+ " DECODE(TL.ISS,'S','Sim','Não') ISS, "
			+ " DECODE(TL.TAXA_SERVICO,'S','Sim','Não') TAXA, TL.ID_IDENTIFICA_LANCAMENTO "
			+ " FROM TIPO_LANCAMENTO TL, HOTEL H "
			+ " WHERE TL.ID_HOTEL = H.ID_HOTEL ";

	String QRY_NAMED_CONFIG_BLOQUETE = " SELECT o FROM ConfigBloqueteEJB o ";

	List<ContaCorrenteVO> pesquisarContaCorrente(ContaCorrenteVO filtro)
			throws MozartSessionException;

	String[] obterDadosContaCorrente(ContaCorrenteEJB contaCorrente)
			throws MozartSessionException;

	List<LogUsuarioVO> pesquisarLogUsuario(LogUsuarioVO filtro)
			throws MozartSessionException;

	List<TipoLancamentoVO> pesquisarTipoLancamento(TipoLancamentoVO filtro)
			throws MozartSessionException;

	List<IdentificaLancamentoEJB> obterIdentificaLancamentoEJB(
			IdentificaLancamentoEJB filtro) throws MozartSessionException;

	TipoLancamentoVO obterProximoSubGrupoLancamento(TipoLancamentoVO pFiltro)
			throws MozartSessionException;

	public List<ConfigBloqueteEJB> obterListConfigBloquete(
			ConfigBloqueteEJB configBloqueteEJB) throws MozartSessionException;

	public void gravarConfigBloquete(ConfigBloqueteEJB configBloqueteEJB)
			throws MozartSessionException;

	public Object find(Class classe, Object id) throws MozartSessionException;

	public List<ContaCorrenteVO> obterContaCorrenteLookup(ContaCorrenteVO filtro)
			throws MozartSessionException;
}