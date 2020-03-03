package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ContaCorrenteVO;

@SuppressWarnings("rawtypes")
@Remote
public interface ContaCorrenteSession {
	
	String QRY_CONTA_CORRENTE = "SELECT "
			+ " CC.ID_CONTA_CORRENTE, CC.NUM_CONTA_CORRENTE, "
			+ " B.NOME_FANTASIA, CC.NOME_AGENCIA, CC.NUMERO_AGENCIA, "
			+ " CC.COBRANCA, CC.PAGAMENTO, HC.HISTORICO HISTORICO_CREDITO, "
			+ " HD.HISTORICO HISTORICO_DEBITO, "
			+ " PC_REC.NOME_CONTA NOME_CONTAS_REC, PC_PAG.NOME_CONTA NOME_CONTAS_PAG, "
			+ " CCC.DESCRICAO_CENTRO_CUSTO CENTRO_CUSTO_CREDITO, "
			+ " CCD.DESCRICAO_CENTRO_CUSTO CENTRO_CUSTO_DEBITO, "
			+ " CC.ID_CONTABIL_REC , CC.CARTEIRA "
			+ " FROM "
			+ " CONTA_CORRENTE_X CC, BANCO B, HISTORICO_CONTABIL HC, "
			+ " HISTORICO_CONTABIL HD, PLANO_CONTAS PC_REC, PLANO_CONTAS PC_PAG, "
			+ " CENTRO_CUSTO_CONTABIL CCC, CENTRO_CUSTO_CONTABIL CCD "
			+ " WHERE "
			+ " B.ID_BANCO = CC.ID_BANCO "
			+ " AND CC.ID_HOTEL = ?1 "
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

	public abstract Object persist(Object paramObject)
			throws MozartSessionException;
	
	public abstract Object alterar(Object paramObject)
			throws MozartSessionException;
	
	public abstract Object obter(Class paramClass, Object paramObject)
			throws MozartSessionException;
	
	public abstract Object refresh(Class paramClass, Object paramObject)
			throws MozartSessionException;

	public abstract void excluir(Object paramObject)
			throws MozartSessionException;

	public abstract List<ContaCorrenteVO> obterContasCorrente(ContaCorrenteVO contaCorrenteFiltro)
			throws MozartSessionException;
	
	public abstract  ContaCorrenteVO obterContaCorrente(ContaCorrenteVO filtro)
			throws MozartSessionException;
}