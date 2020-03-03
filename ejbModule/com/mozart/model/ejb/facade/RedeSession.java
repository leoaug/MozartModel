package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.CentroCustoContabilEJB;
import com.mozart.model.ejb.entity.DepartamentoEJB;
import com.mozart.model.ejb.entity.GrupoPratoEJB;
import com.mozart.model.ejb.entity.HistoricoContabilEJB;
import com.mozart.model.ejb.entity.IndiceEconomicoEJB;
import com.mozart.model.ejb.entity.IndiceTipoEJB;
import com.mozart.model.ejb.entity.PlanoContasSpedEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.SetorPatrimonioEJB;
import com.mozart.model.ejb.entity.TipoDiariaEJB;
import com.mozart.model.ejb.entity.TipoHospedeEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.AdministradorCanaisVO;
import com.mozart.model.vo.CentroCustoVO;
import com.mozart.model.vo.CreditoEmpresaDetalheVO;
import com.mozart.model.vo.CreditoEmpresaVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.LogUsuarioVO;
import com.mozart.model.vo.MoedaVO;
import com.mozart.model.vo.PatrimonioSetorVO;
import com.mozart.model.vo.PlanoContaVO;
import com.mozart.model.vo.PromotorVO;

@Remote
public interface RedeSession {

	String QUERY_CREDITO_EMPRESA = 
		" select ID_EMPRESA, NOME_FANTASIA, CREDITO, VALOR_CREDITO, OBSERVACAO, DATA_CADASTRO, ABERTAS, VENCIDAS, PAGAS, RESERVAS, CHECKINS, TOTAL, SALDO, CGC, DECODE(GREATEST(VENCIDAS,0),0,'N','S') POSSUI_DUP_VENCIDAS, DECODE(GREATEST(SALDO,0),0,'S','N') POSSUI_SALDO_NEGATIVO from ( "+
		" SELECT ER.ID_EMPRESA, ER.NOME_FANTASIA,ER.CREDITO , ER.VALOR_CREDITO,ER.OBSERVACAO,ER.DATA_CADASTRO, NVL(ABERTA.VALOR,0) \"ABERTAS\", "+
		" NVL(VENCIDAS.VALOR,0) \"VENCIDAS\", NVL(PAGAS.VALOR,0) \"PAGAS\", NVL(RESERVAGR.VALOR,0) + NVL(RESERVAIND.VALOR,0) \"RESERVAS\", "+
		" NVL(CHECKINS.VALOR,0) \"CHECKINS\", "+ 
		" (NVL(ABERTA.VALOR,0) + NVL(RESERVAGR.VALOR,0) + NVL(RESERVAIND.VALOR,0) + NVL(CHECKINS.VALOR,0) + NVL(VENCIDAS.VALOR,0)) \"TOTAL\", "+
		" NVL(ER.VALOR_CREDITO,0) - (NVL(VENCIDAS.VALOR,0) + NVL(ABERTA.VALOR,0) + NVL(RESERVAGR.VALOR,0) + NVL(RESERVAIND.VALOR,0) + NVL(CHECKINS.VALOR,0)) \"SALDO\", E.CGC "+
		" FROM EMPRESA_REDE ER, EMPRESA E, "+
		" (SELECT D.ID_EMPRESA , SUM(NVL(D.VALOR_DUPLICATA,0) - NVL(D.COMISSAO,0) - NVL(D.AJUSTES,0) - NVL(D.ENCARGOS,0) + NVL(D.IR,0)) VALOR "+         
		" FROM DUPLICATA D, EMPRESA_REDE EH,CONTROLA_DATA CD "+
		" WHERE EH.ID_REDE_HOTEL = ?1 "+
		" AND D.ID_HOTEL = EH.ID_HOTEL "+ 
		" AND D.ID_EMPRESA = EH.ID_EMPRESA "+
		" AND CD.ID_HOTEL  = D.ID_HOTEL "+ 
		" AND D.DATA_RECEBIMENTO IS NULL "+
		" AND TRUNC(D.DATA_VENCIMENTO) >= TRUNC(CD.FRONT_OFFICE) "+
		" GROUP BY D.ID_EMPRESA) ABERTA, "+
		" (SELECT D.ID_EMPRESA , SUM(NVL(D.VALOR_DUPLICATA,0) - NVL(D.COMISSAO,0) - NVL(D.AJUSTES,0) - NVL(D.ENCARGOS,0) + NVL(D.IR,0)) VALOR "+         
		" FROM DUPLICATA D, EMPRESA_REDE EH,CONTROLA_DATA CD "+
		" WHERE EH.ID_REDE_HOTEL = ?2 "+
		" AND D.ID_HOTEL = EH.ID_HOTEL "+ 
		" AND D.ID_EMPRESA = EH.ID_EMPRESA "+
		" AND CD.ID_HOTEL  = D.ID_HOTEL "+ 
		" AND D.DATA_RECEBIMENTO IS NULL "+
		" AND TRUNC(D.DATA_VENCIMENTO) < TRUNC(CD.FRONT_OFFICE) "+
		" GROUP BY D.ID_EMPRESA) VENCIDAS, "+
		" (SELECT SUM(MA.VALOR_LANCAMENTO) VALOR, C.ID_EMPRESA "+
		" FROM MOVIMENTO_APARTAMENTO MA "+
		" JOIN CHECKIN C ON(MA.ID_CHECKIN = C.ID_CHECKIN) "+
		" JOIN TIPO_LANCAMENTO TL ON (MA.ID_TIPO_LANCAMENTO = TL.ID_TIPO_LANCAMENTO) "+
		" JOIN IDENTIFICA_LANCAMENTO IL ON(TL.ID_IDENTIFICA_LANCAMENTO = IL.ID_IDENTIFICA_LANCAMENTO) "+  
		" WHERE MA.ID_REDE_HOTEL= ?3 "+
		" AND IL.RECEITA_CHECKOUT= 1 "+
		" GROUP BY C.ID_EMPRESA) PAGAS, "+
		" (SELECT R.ID_EMPRESA, SUM(NVL(RAD.TARIFA,0) * (NVL(RA.QTDE_APARTAMENTO,0) - NVL(RA.QTDE_CHECKIN,0))) VALOR "+
		" FROM RESERVA R , RESERVA_APARTAMENTO RA, HOTEL H, EMPRESA_HOTEL EH, RESERVA_APARTAMENTO_DIARIA RAD  "+
		" WHERE H.ID_REDE_HOTEL = ?4 "+
		" AND RAD.ID_HOTEL = H.ID_HOTEL "+
		" AND R.ID_HOTEL = H.ID_HOTEL "+
		" AND R.ID_HOTEL = EH.ID_HOTEL "+
		" AND R.ID_HOTEL = RA.ID_HOTEL "+
		" AND R.APAGADA = 'N' "+
		" AND R.ID_EMPRESA = EH.ID_EMPRESA "+
		" AND R.ID_RESERVA_BLOQUEIO IS NULL "+
		" AND R.ID_RESERVA = RA.ID_RESERVA "+
		" AND RAD.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO "+
		" AND RA.QTDE_CHECKIN > 0 "+
		" AND RA.QTDE_APARTAMENTO > RA.QTDE_CHECKIN "+ 
		" GROUP BY R.ID_EMPRESA) RESERVAGR, "+
		" (SELECT R.ID_EMPRESA,  SUM(NVL(RAD.TARIFA,0)) VALOR "+
		" FROM HOTEL H, EMPRESA_REDE ER, RESERVA R, (SELECT /*+ INDEX(RESERVA_APARTAMENTO IDX_RES_APTO_REDE_HOTEL)*/ * FROM RESERVA_APARTAMENTO ) RA, RESERVA_APARTAMENTO_DIARIA RAD "+ 
		" WHERE H.ID_REDE_HOTEL = ?5 "+ 
		" AND ER.ID_REDE_HOTEL = H.ID_REDE_HOTEL "+ 
		" AND R.ID_HOTEL = H.ID_HOTEL "+ 
		" AND R.ID_EMPRESA = ER.ID_EMPRESA "+
		" AND RA.ID_RESERVA = R.ID_RESERVA "+ 
		" AND RA.ID_HOTEL = R.ID_HOTEL "+
		" AND RA.QTDE_CHECKIN = 0 "+ 
		" AND RAD.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO "+ 
		" AND RAD.ID_HOTEL = R.ID_HOTEL "+ 
		" AND R.APAGADA = 'N' "+ 
		" AND R.ID_RESERVA_BLOQUEIO IS NULL "+ 
		" AND H.ATIVO = 'S' "+    
		" GROUP BY R.ID_EMPRESA) RESERVAIND, "+ 
		" (SELECT CH.ID_EMPRESA, SUM(NVL(RAD.TARIFA,0)) VALOR "+
		" FROM HOTEL H, CHECKIN CH, APARTAMENTO A , RESERVA_APARTAMENTO RA, RESERVA_APARTAMENTO_DIARIA RAD, EMPRESA_REDE ER "+  
		" WHERE H.ID_REDE_HOTEL = ?6 "+ 
		" AND CH.ID_HOTEL = H.ID_HOTEL "+
		" AND CH.ID_EMPRESA = ER.ID_EMPRESA "+
		" AND H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL "+
		" AND CH.ID_APARTAMENTO = A.ID_APARTAMENTO "+
		" AND CH.ID_HOTEL = A.ID_HOTEL "+
		" AND CH.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO "+
		" AND CH.ID_HOTEL = RA.ID_HOTEL "+
		" AND RAD.ID_HOTEL = RA.ID_HOTEL "+ 
		" AND RAD.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO "+
		" AND A.COFAN = 'N' "+ 
		" AND CH.CHECKOUT = 'N' "+ 
		" AND H.ATIVO = 'S' "+
		" GROUP BY CH.ID_EMPRESA) CHECKINS "+
		" WHERE ER.ID_REDE_HOTEL = ?7 "+
		" AND ER.ID_EMPRESA = E.ID_EMPRESA " + 
		" AND ER.ID_EMPRESA = VENCIDAS.ID_EMPRESA(+) "+
		" AND ER.ID_EMPRESA = ABERTA.ID_EMPRESA(+) "+
		" AND ER.ID_EMPRESA = PAGAS.ID_EMPRESA(+) "+
		" AND ER.ID_EMPRESA = RESERVAGR.ID_EMPRESA(+) "+
		" AND ER.ID_EMPRESA = RESERVAIND.ID_EMPRESA(+) "+
		" AND ER.ID_EMPRESA = CHECKINS.ID_EMPRESA(+) "+
		" ORDER BY ER.NOME_FANTASIA) "+
		" where 1 = 1 " ;
	
	String QUERY_LOG_USUARIO =
		" SELECT LOG.ID_AUDITADO, LOG.ID_USUARIO, SUBSTR(U.NICK,8) NICK, LOG.TABELA_AUDITADA, LOG.ESTACAO, LOG.DATA, LOG.HORA, LOG.OPERACAO, H.ID_REDE_HOTEL, H.ID_HOTEL, H.NOME_FANTASIA "+  
		" FROM LOG_USUARIO LOG, HOTEL H, USUARIO U "+ 
		" WHERE LOG.ID_AUDITADO = ?1 "+
		" AND LOG.TABELA_AUDITADA = ?2 "+
		" AND LOG.ID_HOTEL = H.ID_HOTEL "+
		" AND LOG.OPERACAO = 'Inclusão' "+
		" AND LOG.ID_USUARIO = U.ID_USUARIO "+
		" AND H.ID_REDE_HOTEL = ?3 ";
		//" ORDER BY LOG.HORA DESC";

	String QUERY_CREDITO_EMPRESA_DETALHE = 
"/*vencidas*/ "+
" SELECT 1 TIPO, H.ID_HOTEL, D.ID_EMPRESA, NULL ID_CHECKIN, NULL ID_RESERVA, D.NUM_DUPLICATA NUMERO, H.SIGLA SIGLA_HOTEL, EH.NOME_FANTASIA, D.PRORROGADO,  D.DATA_LANCAMENTO, (D.VALOR_DUPLICATA - D.COMISSAO - NVL(D.AJUSTES,0) - NVL(D.ENCARGOS,0) + NVL(D.IR,0)) VALOR "+          
		" FROM DUPLICATA D, EMPRESA_REDE EH, CONTROLA_DATA CD, HOTEL H "+ 
		" WHERE EH.ID_REDE_HOTEL = ?1 "+
		" AND CD.ID_REDE_HOTEL = EH.ID_REDE_HOTEL "+  
		" AND D.ID_EMPRESA = EH.ID_EMPRESA  "+
		" AND CD.ID_HOTEL  = D.ID_HOTEL "+  
		" AND CD.ID_HOTEL = H.ID_HOTEL "+
		" AND D.DATA_RECEBIMENTO IS NULL "+ 
		" AND TRUNC(D.PRORROGADO) < TRUNC(CD.FRONT_OFFICE) "+
		" AND EH.ID_EMPRESA = ?2 "+
		" UNION ALL "+ 	 
		" /*abertas*/ "+
		" SELECT 2 TIPO, H.ID_HOTEL, D.ID_EMPRESA, NULL ID_CHECKIN, NULL ID_RESERVA, D.NUM_DUPLICATA NUMERO, H.SIGLA SIGLA_HOTEL, EH.NOME_FANTASIA, D.PRORROGADO,  D.DATA_LANCAMENTO, (D.VALOR_DUPLICATA - D.COMISSAO - NVL(D.AJUSTES,0) - NVL(D.ENCARGOS,0) + NVL(D.IR,0)) VALOR "+
		" FROM DUPLICATA D, EMPRESA_REDE EH, CONTROLA_DATA CD, HOTEL H "+
		" WHERE EH.ID_REDE_HOTEL = ?3 "+
		" AND CD.ID_REDE_HOTEL = EH.ID_REDE_HOTEL "+  
		" AND D.ID_EMPRESA = EH.ID_EMPRESA  "+
		" AND CD.ID_HOTEL  = D.ID_HOTEL "+
		" AND CD.ID_HOTEL = H.ID_HOTEL "+  
		" AND D.DATA_RECEBIMENTO IS NULL "+ 
		" AND TRUNC(D.PRORROGADO) >= TRUNC(CD.FRONT_OFFICE) "+
		" AND EH.ID_EMPRESA = ?4 "+
		" UNION ALL "+
		" /*RESERVA*/ "+
		" SELECT /*+ INDEX(R IDX_RESERVA_REDE_HOTEL)*/  "+
		" 3 TIPO, H.ID_HOTEL, R.ID_EMPRESA,  null id_checkin, R.ID_RESERVA, null NUMERO, H.SIGLA SIGLA_HOTEL, ER.NOME_FANTASIA, RA.DATA_ENTRADA, RA.DATA_SAIDA, SUM(NVL(RAD.TARIFA,0)) VALOR "+ 
		" FROM HOTEL H, EMPRESA_REDE ER, RESERVA R, (SELECT /*+ INDEX(RESERVA_APARTAMENTO IDX_RES_APTO_REDE_HOTEL)*/ * FROM RESERVA_APARTAMENTO ) RA, RESERVA_APARTAMENTO_DIARIA RAD "+ 
		" WHERE H.ID_REDE_HOTEL = ?5 "+ 
		" AND ER.ID_REDE_HOTEL = H.ID_REDE_HOTEL "+ 
		" AND R.ID_HOTEL = H.ID_HOTEL "+ 
		" AND R.ID_EMPRESA = ER.ID_EMPRESA "+
		" AND ER.ID_EMPRESA = ?6 "+
		" AND RA.ID_RESERVA = R.ID_RESERVA "+ 
		" AND RA.ID_HOTEL = R.ID_HOTEL "+
		" AND RA.QTDE_CHECKIN = 0 "+ 
		" AND RAD.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO "+ 
		" AND RAD.ID_HOTEL = R.ID_HOTEL "+ 
		" AND R.APAGADA = 'N' "+ 
		" AND R.ID_RESERVA_BLOQUEIO IS NULL "+ 
		" AND H.ATIVO = 'S' "+ 
		" GROUP BY 3, H.ID_HOTEL, R.ID_EMPRESA,  null, R.ID_RESERVA,  NULL, H.SIGLA, ER.NOME_FANTASIA, RA.DATA_ENTRADA, RA.DATA_SAIDA "+
		" UNION ALL "+
		" /*CHECKINS */"+
		" SELECT 4 TIPO, H.ID_HOTEL, CH.ID_EMPRESA, CH.ID_CHECKIN, RA.ID_RESERVA, A.NUM_APARTAMENTO||'' NUMERO, H.SIGLA SIGLA_HOTEL, ER.NOME_FANTASIA, RA.DATA_ENTRADA, RA.DATA_SAIDA, SUM(NVL(RAD.TARIFA,0)) VALOR "+
		" FROM HOTEL H, CHECKIN CH, APARTAMENTO A , RESERVA_APARTAMENTO RA, RESERVA_APARTAMENTO_DIARIA RAD, EMPRESA_REDE ER "+  
		" WHERE H.ID_REDE_HOTEL = ?7 "+ 
		" AND CH.ID_HOTEL = H.ID_HOTEL "+
		" AND CH.ID_EMPRESA = ER.ID_EMPRESA "+
		" AND ER.ID_EMPRESA = ?8 "+
		" AND H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL "+
		" AND CH.ID_APARTAMENTO = A.ID_APARTAMENTO "+
		" AND CH.ID_HOTEL = A.ID_HOTEL "+
		" AND CH.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO "+
		" AND CH.ID_HOTEL = RA.ID_HOTEL "+
		" AND RAD.ID_HOTEL = RA.ID_HOTEL "+ 
		" AND RAD.ID_RESERVA_APARTAMENTO = RA.ID_RESERVA_APARTAMENTO "+
		" AND A.COFAN = 'N' "+ 
		" AND CH.CHECKOUT = 'N' "+ 
		" AND H.ATIVO = 'S' "+
		" GROUP BY 4, H.ID_HOTEL, CH.ID_EMPRESA, CH.ID_CHECKIN, RA.ID_RESERVA,A.NUM_APARTAMENTO||'', H.SIGLA, ER.NOME_FANTASIA, RA.DATA_ENTRADA, RA.DATA_SAIDA ";
	
	String QUERY_MOEDA = " SELECT ID_MOEDA, NOME_MOEDA, SIGLA, SIMBOLO "+
						 "	FROM MOEDA ORDER BY NOME_MOEDA ";
	
	String QUERY_MOEDA_CODIGO = " SELECT ID_MOEDA, NOME_MOEDA, SIGLA, SIMBOLO "+
			 "	FROM MOEDA WHERE SIGLA = ?1 ORDER BY NOME_MOEDA ";
	
	String QUERY_PROMOTOR =  " SELECT ID_PROMOTOR, PROMOTOR, COMISSAO, AREA "+
							 "	FROM PROMOTOR WHERE ID_REDE_HOTEL=?1 "+
							 "	ORDER BY PROMOTOR ";	
	
	String QUERY_PLANO_CONTA = " SELECT PC.ID_PLANO_CONTAS, PC.CONTA_REDUZIDA, PC.CONTA_CONTABIL, PC.NOME_CONTA, " +
							" DECODE (PC.TIPO_CONTA, 'A', 'Analítico', 'Sintético')TIPO_CONTA, DECODE (RAZAO_AUXILIAR, 'S', 'Sim', 'Não')RAZAO_AUXILIAR, " +
							" DECODE (CORRECAO_MONETARIA, 'S', 'Sim', 'Não')CORRECAO_MONETARIA, DECODE(DEPRECIACAO, 'S', 'Sim', 'Não')DEPRECIACAO, "+
							" DECODE(PC.ATIVO_PASSIVO, 'O', 'Outros', 'P', 'Passivo', 'A', 'Ativo')ATIVO_PASSIVO, "+ 
							"	HCC.HISTORICO HISTORICO_CREDITO, HCD.HISTORICO HISTORICO_DEBITO, PCS.DESCRICAO PLANO_CONTAS_SPED "+ 
							"	FROM PLANO_CONTAS PC, HISTORICO_CONTABIL HCD, HISTORICO_CONTABIL HCC, PLANO_CONTAS_SPED PCS "+
							"	WHERE PC.ID_REDE_HOTEL=?1"+
							"	AND PC.ID_HISTORICO_DEBITO = HCD.ID_HISTORICO (+) AND PC.ID_REDE_HOTEL = HCD.ID_REDE_HOTEL(+) "+
							"	AND PC.ID_HISTORICO_CREDITO = HCC.ID_HISTORICO (+) AND PC.ID_REDE_HOTEL = HCC.ID_REDE_HOTEL(+)  "+
							"	AND PC.ID_PLANO_CONTAS_SPED = PCS.ID_PLANO_CONTAS_SPED (+) ";
	
	String QUERY_PLANO_CONTA_SUGEST = " SELECT ID_PLANO_CONTAS, TRIM(CONTA_CONTABIL), TRIM(NOME_CONTA) " +  
									  " FROM PLANO_CONTAS " + 
									  " WHERE ID_REDE_HOTEL  = ?1 " +  
									  " AND TIPO_CONTA = 'A' ";
	
	String QRY_CENTRO_CUSTO = " SELECT DP.ID_DEPARTAMENTO, CCC.ID_CENTRO_CUSTO_CONTABIL, CCC.DESCRICAO_CENTRO_CUSTO, DP.DESCRICAO, CCC.CONTROLADO " + 
   							" FROM CENTRO_CUSTO_CONTABIL CCC, DEPARTAMENTO DP " +
							" WHERE CCC.ID_REDE_HOTEL = ?1 " +
							" AND CCC.ID_REDE_HOTEL = DP.ID_REDE_HOTEL (+)" +
							" AND CCC.ID_DEPARTAMENTO = DP.ID_DEPARTAMENTO (+) ";

	String QRY_ADMINISTRADOR_CANAIS=" SELECT "
			+ " G.ID_GDS, "
			+ " G.ID_EMPRESA, "
			+ " G.ID_REDE_HOTEL, "
			+ " G.CODIGO, "
			+ " G.ATIVO, "
			+ " G.COMISSAO, "
			+ " G.FEE_RESERVA, "
			+ " G.FEE_MENSAL, "
			+ " ER.NOME_FANTASIA,"
			+ " G.DISPONIBILIDADE_BLOQUEIO "
			+ " FROM GDS G "
			+ " JOIN EMPRESA_REDE ER "
			+ " ON (G.ID_EMPRESA       = ER.ID_EMPRESA "
			+ " AND G.ID_REDE_HOTEL = ER.ID_REDE_HOTEL) ";
	
	public static final String QUERY_OBTER_HOSPEDE_POR_NOME = "SELECT H.ID_HOSPEDE, UPPER(H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE) NOME_HOSPEDE, H.CPF, H.NASCIMENTO, H.PASSAPORTE \n    FROM HOSPEDE H\n";
	
	String QUERY_PATRIMONIO_SETOR =  " SELECT ID_PATRIMONIO_SETOR, DESCRICAO "+
			 "	FROM PATRIMONIO_SETOR "+
			 "	WHERE ID_HOTEL = ?1 ";	
	
	List<CreditoEmpresaVO> pesquisarCreditoEmpresa(CreditoEmpresaVO pFiltro) throws MozartSessionException;

	LogUsuarioVO obterUltimoLog(LogUsuarioVO ultimoLog) throws MozartSessionException;
	
	//CREDITO EMPRESA DETALHE
	List<CreditoEmpresaDetalheVO> obterCreditoEmpresaDetalhe(CreditoEmpresaDetalheVO pFiltro) throws MozartSessionException;
	
	//MOEDA
	List<MoedaVO> pesquisarMoeda(MoedaVO filtro) throws MozartSessionException;
	public MoedaVO buscarMoedaPorCodigo(String codigoMoeda) throws MozartSessionException;
	
	//PROMOTOR
	List<PromotorVO> pesquisarPromotor(PromotorVO filtro) throws MozartSessionException;
	
	//TIPO HOSPEDE
	List<TipoHospedeEJB> pesquisarTipoHospede(TipoHospedeEJB filtro) throws MozartSessionException;

	//GRUPO DE PRATO
	List<GrupoPratoEJB> pesquisarGrupoPrato(GrupoPratoEJB filtro) throws MozartSessionException;

	//SETOR DE PATRIMONIO
	List<SetorPatrimonioEJB> pesquisarSetorPatrimonio(SetorPatrimonioEJB filtro) throws MozartSessionException;
	
	//TIPO DIARIA
	List<TipoDiariaEJB> pesquisarTipoDiaria(TipoDiariaEJB filtro) throws MozartSessionException;

	//HISTÓRICO CONTABIL
	List<HistoricoContabilEJB> pesquisarHistoricoContabil(HistoricoContabilEJB filtro) throws MozartSessionException;
			
	//DEPARTAMENTO
	List<DepartamentoEJB> pesquisarDepartamento(DepartamentoEJB filtro) throws MozartSessionException;
	
	//ÍNDICE DE CORREÇÃO MONETÁRIA
	List<IndiceEconomicoEJB> pesquisarIndiceEconomico(IndiceEconomicoEJB filtro) throws MozartSessionException;
	List<IndiceTipoEJB> pesquisarIndiceTipo(Long idRedeHotel) throws MozartSessionException;
	
	//PLANO DE CONTAS
	List<PlanoContaVO> pesquisarPlanoConta(PlanoContaVO filtro) throws MozartSessionException;
	List<PlanoContaVO> obterPlanoContasDemonstrativoAnalitico(PlanoContaVO filtro) throws MozartSessionException;
	List<PlanoContasSpedEJB> pesquisarPlanoContasSped(Long idRedeHotel) throws MozartSessionException;
	
	//CUSTO CONTABIL
	List<CentroCustoContabilEJB> pesquisarCentroCusto(CentroCustoContabilEJB filtro) throws MozartSessionException;

	List<CentroCustoVO> pesquisarCentroCusto(CentroCustoVO filtro)throws MozartSessionException;

	List<AdministradorCanaisVO> pesquisarAdministradorCanais(AdministradorCanaisVO filtro) throws MozartSessionException;
	
	public abstract List<HospedeVO> obterHospedePorNomeSobrenomeCpfPassaporte(Long idRedeHotel, String parametro)
			throws MozartSessionException;
	
	public abstract List<HospedeVO> obterHospedePorNomeSobrenomeCpfPassaporte(Long idRedeHotel, String parametro, Long idHospedeNaoListado)
			throws MozartSessionException;
	
	public void executarProcedureTransferenciaHospede(RedeHotelEJB redeHotel, Long idHotel, Long idHospedeDe, Long idHospedePara)
			throws MozartSessionException;
	
	List<PatrimonioSetorVO> pesquisarListaSetorPatrimonio(PatrimonioSetorVO filtro)
			throws MozartSessionException;
	
	List<PlanoContaVO> pesquisarPlanoContaSugest(PlanoContaVO filtro)  throws MozartSessionException;
}	

