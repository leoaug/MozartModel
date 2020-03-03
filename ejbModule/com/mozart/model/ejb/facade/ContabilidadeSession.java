package com.mozart.model.ejb.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.CentroCustoContabilEJB;
import com.mozart.model.ejb.entity.ClassificacaoContabilEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoContabilEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ClassificacaoContabilCentroCustoVO;
import com.mozart.model.vo.ClassificacaoContabilFaturamentoGrupoVO;
import com.mozart.model.vo.ClassificacaoContabilFaturamentoVO;
import com.mozart.model.vo.ClassificacaoContabilPadraoVO;
import com.mozart.model.vo.DemonstrativoVO;
import com.mozart.model.vo.ImobilizadoDepreciacaoVO;
import com.mozart.model.vo.MovimentoContabilVO;
import com.mozart.model.vo.PlanoContaVO;

@Remote
public abstract interface ContabilidadeSession {
	
	public static final String QRY_MOVIMENTO_CONTABIL = 
		" SELECT MOVIMENTO_CONTABIL.ID_SEQ_CONTABIL, MOVIMENTO_CONTABIL.ID_MOVIMENTO_CONTABIL, HOTEL.SIGLA, MOVIMENTO_CONTABIL.DATA_DOCUMENTO, "+
		" PLANO_CONTAS.CONTA_REDUZIDA, PLANO_CONTAS.NOME_CONTA,  MOVIMENTO_CONTABIL.VALOR, "+
		" DECODE(MOVIMENTO_CONTABIL.DEBITO_CREDITO,'D','Débito','Crédito') DC, "+  
		" HISTORICO_CONTABIL.HISTORICO, MOVIMENTO_CONTABIL.NUM_DOCUMENTO, "+
		" CENTRO_CUSTO_CONTABIL.DESCRICAO_CENTRO_CUSTO, "+
		" DECODE(MOVIMENTO_CONTABIL.CONTROLE_ATIVO_FIXO,NULL, 0,MOVIMENTO_CONTABIL.CONTROLE_ATIVO_FIXO) CONTROLE_ATIVO_FIXO "+   
		" FROM MOVIMENTO_CONTABIL, PLANO_CONTAS, HISTORICO_CONTABIL, CENTRO_CUSTO_CONTABIL, HOTEL "+
		" WHERE MOVIMENTO_CONTABIL.ID_HOTEL = HOTEL.ID_HOTEL "+ 
		" AND PLANO_CONTAS.ID_REDE_HOTEL = HOTEL.ID_REDE_HOTEL "+
		" AND HISTORICO_CONTABIL.ID_REDE_HOTEL = HOTEL.ID_REDE_HOTEL "+
		" AND MOVIMENTO_CONTABIL.ID_PLANO_CONTAS = PLANO_CONTAS.ID_PLANO_CONTAS "+
		" AND MOVIMENTO_CONTABIL.ID_CENTRO_CUSTO = CENTRO_CUSTO_CONTABIL.ID_CENTRO_CUSTO_CONTABIL(+) "+
		" AND MOVIMENTO_CONTABIL.ID_REDE_HOTEL = CENTRO_CUSTO_CONTABIL.ID_REDE_HOTEL(+) "+
		" AND MOVIMENTO_CONTABIL.ID_HISTORICO = HISTORICO_CONTABIL.ID_HISTORICO "+
		" AND MOVIMENTO_CONTABIL.TIPO_MOVIMENTO = ?1 ";
	
	
	public static final String QRY_SALDO_MOVIMENTO_CONTABIL = 
		" SELECT nvl(VALOR_CREDITO,0), nvl(VALOR_DEBITO,0), nvl(ABS(VALOR_CREDITO-VALOR_DEBITO),0) DIFERENCA  FROM "+  
		" (SELECT SUM(MOVIMENTO_CONTABIL.VALOR) VALOR_DEBITO "+
		" FROM MOVIMENTO_CONTABIL, CONTROLA_DATA CD "+
		" WHERE MOVIMENTO_CONTABIL.ID_HOTEL = ?1 "+
		" AND MOVIMENTO_CONTABIL.ID_HOTEL = CD.ID_HOTEL "+
		" AND MOVIMENTO_CONTABIL.DEBITO_CREDITO = 'D' "+
		" AND MOVIMENTO_CONTABIL.TIPO_MOVIMENTO = 'M' "+
		" AND TRUNC(MOVIMENTO_CONTABIL.DATA_DOCUMENTO) BETWEEN TRUNC(CD.CONTABILIDADE,'MONTH') AND LAST_DAY(CD.CONTABILIDADE)) VL_D, "+
		" (SELECT SUM(MOVIMENTO_CONTABIL.VALOR) VALOR_CREDITO "+
		" FROM MOVIMENTO_CONTABIL, CONTROLA_DATA CD "+
		" WHERE MOVIMENTO_CONTABIL.ID_HOTEL = ?2 "+
		" AND MOVIMENTO_CONTABIL.ID_HOTEL = CD.ID_HOTEL "+
		" AND MOVIMENTO_CONTABIL.DEBITO_CREDITO = 'C' "+
		" AND MOVIMENTO_CONTABIL.TIPO_MOVIMENTO = 'M' "+
		" AND TRUNC(MOVIMENTO_CONTABIL.DATA_DOCUMENTO) BETWEEN TRUNC(CD.CONTABILIDADE,'MONTH') AND LAST_DAY(CD.CONTABILIDADE)) VL_C ";

	public static final String QRY_DEMONSTRATIVO_PLANO_CONTAS =
		" select dr.id_plano_contas, pc.conta_contabil, pc.nome_conta nome, dr.tipo_conta, 1 ordem, pc.id_rede_hotel "+  
		" from demonstrativo_plano_contas dr, plano_contas pc "+ 
		" where dr.id_rede_hotel = ?1 "+
		" and dr.id_plano_contas = pc.id_plano_contas "+
		" and dr.id_rede_hotel = pc.id_rede_hotel "+
		" order by conta_contabil ";

	public static final String QRY_DEMONSTRATIVO_RESULTADO =
		" select dr.id_plano_contas, pc.conta_contabil, nvl(pc.nome_conta,descricao) nome, dr.tipo, ordem, dr.id_rede_hotel "+  
		" from demonstrativo_resultado dr, plano_contas pc "+ 
		" where dr.id_rede_hotel = ?1 "+
		" and dr.id_plano_contas = pc.id_plano_contas(+) "+
		" and dr.id_rede_hotel = pc.id_rede_hotel(+) "+
		" order by ordem ";
	
	public static final String QRY_CLASSIFICACAO_CONTABIL_CENTRO_CUSTO = 
			" SELECT ID_CENTRO_CUSTO_CONTABIL, DESCRICAO_CENTRO_CUSTO"+
			" FROM CENTRO_CUSTO_CONTABIL CCC"+
			" WHERE CCC.ID_REDE_HOTEL  = ?1"+
			" ORDER BY CCC.DESCRICAO_CENTRO_CUSTO";
	
	public static final String QRY_CLASSIFICACAO_CONTABIL_FATURAMENTO_DEBITO = 
			"SELECT "+
			" PC.ID_PLANO_CONTAS, "+
			" PC.ID_HISTORICO_DEBITO, "+ 
			" UPPER(TRIM (PC.CONTA_REDUZIDA)||' - '|| TRIM(PC.CONTA_CONTABIL)||' - '|| TRIM(PC.NOME_CONTA)||' - '||TRIM(HC.HISTORICO)) REDUZIDACONTANOME "+
			" FROM "+
			" PLANO_CONTAS PC, "+ 
			" HISTORICO_CONTABIL HC "+
			" WHERE "+
			" PC.ID_REDE_HOTEL = HC.ID_REDE_HOTEL "+
			" AND PC.ID_HISTORICO_DEBITO = HC.ID_HISTORICO "+
			" AND PC.ID_REDE_HOTEL = ?1 "+
			" AND PC.TIPO_CONTA = 'A' "+
			" AND (UPPER(TRIM(PC.CONTA_REDUZIDA)) LIKE '%'|| ?2 ||'%' "+
			" OR UPPER(TRIM(PC.CONTA_CONTABIL))LIKE '%'|| ?3 ||'%' "+
			" OR UPPER(TRIM(PC.NOME_CONTA))LIKE '%'|| ?4 ||'%') "
			;
	
	public static final String QRY_CLASSIFICACAO_CONTABIL_FATURAMENTO_CREDITO = 
			" SELECT PC.ID_PLANO_CONTAS,PC.ID_HISTORICO_CREDITO, " + 
			" UPPER (TRIM (PC.CONTA_REDUZIDA)||' - '|| TRIM(PC.CONTA_CONTABIL)||' - '|| TRIM(PC.NOME_CONTA)||' - '||TRIM(HC.HISTORICO)) REDUZIDACONTANOME"+
			" FROM PLANO_CONTAS PC, HISTORICO_CONTABIL HC"+
			" WHERE PC.ID_REDE_HOTEL = HC.ID_REDE_HOTEL"+
			" AND PC.ID_HISTORICO_CREDITO = HC.ID_HISTORICO"+
			" AND PC.ID_REDE_HOTEL = ?1"+
			" AND PC.TIPO_CONTA = 'A'"+
			" AND (UPPER(TRIM(PC.CONTA_REDUZIDA)) LIKE '%'|| ?2 ||'%'"+
			" OR UPPER(TRIM(PC.CONTA_CONTABIL))LIKE '%'|| ?3 ||'%'"+
			" OR UPPER(TRIM(PC.NOME_CONTA))LIKE '%'|| ?4 ||'%')"+
			" ORDER BY PC.NOME_CONTA";
	
	public static final String QRY_CLASSIFICACAO_CONTABIL_POR_ID_HOTEL_E_LIKE_DESCRICAO = " SELECT "
			+ " CC.ID_CLASSIFICACAO_CONTABIL,"
			+ " CC.ID_HOTEL,"
			+ " CC.ID_PLANO_CONTAS_DEBITO,"
			+ " PCD.CONTA_REDUZIDA AS CONTA_REDUZIDA_DEBITO,"
			+ " PCD.CONTA_CONTABIL AS CONTA_CONTABIL_DEBITO,"
			+ " PCD.NOME_CONTA     AS NOME_CONTA_DEBITO,"
			+ " CC.ID_CENTRO_CUSTO_DEBITO,"
			+ " CCD.DESCRICAO_CENTRO_CUSTO AS DESCRICAO_CENTRO_CUSTO_DEBITO,"
			+ " CC.ID_PLANO_CONTAS_CREDITO,"
			+ " PCC.CONTA_REDUZIDA         AS CONTA_REDUZIDA_CREDITO,"
			+ " PCC.CONTA_CONTABIL AS CONTA_CONTABIL_CREDITO,"
			+ " PCC.NOME_CONTA     AS NOME_CONTA_CREDITO,"
			+ " CC.ID_CENTRO_CUSTO_CREDITO,"
			+ " CCC.DESCRICAO_CENTRO_CUSTO AS DESCRICAO_CENTRO_CUSTO_CREDITO,"
			+ " CC.DESCRICAO, "
			+ " CC.PIS "
			+ " FROM CLASSIFICACAO_CONTABIL CC"
			+ " LEFT JOIN CENTRO_CUSTO_CONTABIL CCC "
			+ " ON CC.ID_CENTRO_CUSTO_CREDITO = CCC.ID_CENTRO_CUSTO_CONTABIL "
			+ " LEFT JOIN CENTRO_CUSTO_CONTABIL CCD"			
			+ " ON CC.ID_CENTRO_CUSTO_DEBITO = CCD.ID_CENTRO_CUSTO_CONTABIL "
			+ " LEFT JOIN PLANO_CONTAS PCC "
			+ " ON CC.ID_PLANO_CONTAS_CREDITO = PCC.ID_PLANO_CONTAS "
			+ " AND CC.ID_REDE_HOTEL          = PCC.ID_REDE_HOTEL "
			+ " LEFT JOIN PLANO_CONTAS PCD "
			+ " ON CC.ID_PLANO_CONTAS_DEBITO = PCD.ID_PLANO_CONTAS AND CC.ID_REDE_HOTEL         = PCD.ID_REDE_HOTEL "
			+ " WHERE CC.ID_HOTEL = ?1 "
			+ " AND DESCRICAO LIKE ?2"
			+ " ORDER BY CC.ID_CLASSIFICACAO_CONTABIL ";

	
	
	public static final String QRY_CLASSIFICACAO_CONTABIL_PADRAO_POR_ID_HOTEL_E_LIKE_DESCRICAO = " SELECT UNIQUE "
			+ "\n SIGLA, "
			+ "\n ID_CLASSIFICACAO_CONTABIL, "
			+ "\n DESCRICAO_CENTRO_CUSTO, "
			+ "\n CONTA CONTA_REDUZIDA, "
			+ "\n NOME_CONTA, "
			+ "\n DESCRICAO, "
			+ "\n PERCENTUAL, "
			+ "\n DEBITO_CREDITO, "
			+ "\n CONTA_FINANCEIRA, "
			+ "\n PIS "
			+ "\n FROM ( " 
			/******************************************************************************/
			+ "\n\t SELECT H.SIGLA, "
			+ "\n\t\t ID_CLASSIFICACAO_CONTABIL,"
			+ "\n\t\t CCC_D.DESCRICAO_CENTRO_CUSTO, "
			+ "\n\t\t PC_D.CONTA_REDUZIDA CONTA, "
			+ "\n\t\t PC_D.NOME_CONTA , "
			+ "\n\t\t UPPER(SUBSTR(CC.DESCRICAO,4)) DESCRICAO, "
			+ "\n\t\t CC.PERCENTUAL PERCENTUAL, "
			+ "\n\t\t CC.DEBITO_CREDITO, "
			+ "\n\t\t PC_F.CONTA_CONTABIL CONTA_FINANCEIRA, "
			+ "\n\t\t CC.PIS "
			+ "\n\t FROM CLASSIFICACAO_CONTABIL CC, "
			+ "\n\t\t PLANO_CONTAS PC_D, "
			+ "\n\t\t CENTRO_CUSTO_CONTABIL CCC_D, "
			+ "\n\t\t PLANO_CONTAS PC_F, "
			+ "\n\t\t HOTEL H "
			+ "\n\t WHERE "
			+ "\n\t\t CC.DESCRICAO LIKE ?1 "
			+ "\n\t\t AND CC.ID_PLANO_CONTAS_FINANCEIRO = PC_F.ID_PLANO_CONTAS(+) "
			+ "\n\t\t AND CC.ID_HOTEL = ?2 "
			+ "\n\t\t AND H.ID_HOTEL = CC.ID_HOTEL "
			+ "\n\t\t AND CC.DEBITO_CREDITO = 'D' "
			+ "\n\t\t AND CC.ID_PLANO_CONTAS_DEBITO = PC_D.ID_PLANO_CONTAS "
			+ "\n\t\t AND CC.ID_REDE_HOTEL = PC_D.ID_REDE_HOTEL "
			+ "\n\t\t AND CCC_D.ID_REDE_HOTEL = CC.ID_REDE_HOTEL "
			+ "\n\t\t AND CCC_D.ID_CENTRO_CUSTO_CONTABIL = CC.ID_CENTRO_CUSTO_DEBITO "
			/******************************************************************************/
			+ "\n\t UNION ALL"
			/******************************************************************************/
			+ "\n\t SELECT H.SIGLA, " 
			+ "\n\t\t ID_CLASSIFICACAO_CONTABIL, "
			+ "\n\t\t CCC_C.DESCRICAO_CENTRO_CUSTO, "
			+ "\n\t\t PC_C.CONTA_REDUZIDA CONTA, "
			+ "\n\t\t PC_C.NOME_CONTA, "
			+ "\n\t\t UPPER(SUBSTR(CC.DESCRICAO,4)) DESCRICAO, "
			+ "\n\t\t CC.PERCENTUAL PERCENTUAL, "
			+ "\n\t\t CC.DEBITO_CREDITO, "
			+ "\n\t\t PC_F.CONTA_CONTABIL CONTA_FINANCEIRA, "
			+ "\n\t\t CC.PIS "
			+ "\n\t FROM CLASSIFICACAO_CONTABIL CC, "
			+ "\n\t\t PLANO_CONTAS PC_C, "
			+ "\n\t\t CENTRO_CUSTO_CONTABIL CCC_C, "
			+ "\n\t\t PLANO_CONTAS PC_F, "
			+ "\n\t\t HOTEL H "
			+ "\n\t WHERE CC.DESCRICAO LIKE ?3 "
			+ "\n\t\t AND CC.ID_PLANO_CONTAS_FINANCEIRO = PC_F.ID_PLANO_CONTAS(+) "
			+ "\n\t\t AND CC.ID_HOTEL = ?4 "
			+ "\n\t\t AND H.ID_HOTEL = CC.ID_HOTEL "
			+ "\n\t\t AND PC_C.ID_REDE_HOTEL = H.ID_REDE_HOTEL "
			+ "\n\t\t AND CC.DEBITO_CREDITO = 'C' "
			+ "\n\t\t AND CC.ID_PLANO_CONTAS_CREDITO = PC_C.ID_PLANO_CONTAS "
			+ "\n\t\t AND CC.ID_REDE_HOTEL = PC_C.ID_REDE_HOTEL "
			+ "\n\t\t AND CCC_C.ID_REDE_HOTEL = CC.ID_REDE_HOTEL "
			+ "\n\t\t AND CCC_C.ID_CENTRO_CUSTO_CONTABIL = CC.ID_CENTRO_CUSTO_CREDITO "
			/******************************************************************************/
			+ "\n ) WHERE 1 = 1 ";
	
	public static final String QRY_IMOBILIZADO_DEPRECIACAO = 
			" SELECT MC.CONTROLE_ATIVO_FIXO, " +
					"	   MC.DATA_DOCUMENTO DATA_DOCUMENTO, " +
					"	   MC.NUM_DOCUMENTO,   " +
					"	   CCC.DESCRICAO_CENTRO_CUSTO, " +
					"	   MC.VALOR, " +
					"	   MC.DEBITO_CREDITO, " +
					"	   PC.CONTA_CONTABIL, " +
					"	   PC.NOME_CONTA,  " +
					"	   PCC.NOME_CONTA NOME_CONTA_CREDORA, " +
					"	   PCD.NOME_CONTA NOME_CONTA_DEPRECIACAO,  " +
					"	   PS.NOME_FANTASIA, " +
					"	   HC.HISTORICO,  " +
					"	   MC.ID_MOVIMENTO_CONTABIL " +
					"  FROM MOVIMENTO_CONTABIL MC   " +
					"     JOIN CONTROLA_DATA CD ON MC.ID_HOTEL = CD.ID_HOTEL  " +
					"     JOIN PLANO_CONTAS PC ON CD.ID_REDE_HOTEL = PC.ID_REDE_HOTEL AND MC.ID_PLANO_CONTAS = PC.ID_PLANO_CONTAS  " +
					"     JOIN PLANO_CONTAS PCC ON CD.ID_REDE_HOTEL = PCC.ID_REDE_HOTEL AND PCC.ID_PLANO_CONTAS = PC.ID_CONTA_CRED_DEP  " +
					"     JOIN PLANO_CONTAS PCD ON CD.ID_REDE_HOTEL = PCD.ID_REDE_HOTEL AND PCD.ID_PLANO_CONTAS = PC.ID_CONTA_DEV_DEP  " +
					"     JOIN CENTRO_CUSTO_CONTABIL CCC ON CD.ID_REDE_HOTEL = CCC.ID_REDE_HOTEL AND MC.ID_CENTRO_CUSTO = CCC.ID_CENTRO_CUSTO_CONTABIL  " +
					"     JOIN HISTORICO_CONTABIL HC ON CD.ID_REDE_HOTEL = HC.ID_REDE_HOTEL AND MC.ID_HISTORICO = HC.ID_HISTORICO  " +
					"     LEFT OUTER JOIN PATRIMONIO_SETOR PS ON MC.ID_PATRIMONIO_SETOR = PS.ID_PATRIMONIO_SETOR   " +
					"     WHERE MC.ID_HOTEL = ?1   " +
					"     AND PC.DEPRECIACAO = 'S'  " +
					"     AND MC.TIPO_MOVIMENTO = 'M' " +
					"	  AND MC.CONTROLE_ATIVO_FIXO IS NOT NULL ";
	
	public static final String QRY_ALTERACAO_IMOBILIZADO_DEPRECIACAO = 
			" SELECT MC.NUM_DOCUMENTO, "
			+ " MC.DEBITO_CREDITO, "
			+ " PC.CONTA_CONTABIL, "
			+ " PC.NOME_CONTA, "
			+ " MC.VALOR, "
			+ " MC.CONTROLE_ATIVO_FIXO, "
			+ " CCC.ID_CENTRO_CUSTO_CONTABIL, "
			+ " CCC.DESCRICAO_CENTRO_CUSTO, "
			+ " MC.ID_MOVIMENTO_CONTABIL, " 
			+ " MC.ID_PATRIMONIO_SETOR, "
			+ " PS.DESCRICAO   " +
			" FROM MOVIMENTO_CONTABIL MC " +
			" JOIN CONTROLA_DATA CD ON MC.ID_HOTEL = CD.ID_HOTEL " +
			" JOIN PLANO_CONTAS PC ON CD.ID_REDE_HOTEL = PC.ID_REDE_HOTEL AND MC.ID_PLANO_CONTAS = PC.ID_PLANO_CONTAS " +
			" LEFT JOIN CENTRO_CUSTO_CONTABIL CCC ON CD.ID_REDE_HOTEL = CCC.ID_REDE_HOTEL AND MC.ID_CENTRO_CUSTO = CCC.ID_CENTRO_CUSTO_CONTABIL " +
			" LEFT JOIN PATRIMONIO_SETOR PS ON MC.ID_PATRIMONIO_SETOR = PS.ID_PATRIMONIO_SETOR " +
			" WHERE MC.ID_HOTEL = ?1 " +
			" AND MC.ID_MOVIMENTO_CONTABIL = ?2 ";
	
	public static final String QRY_CALCULO_JA_LANCADAS_DEPRECIACAO = 
				" SELECT COUNT(*) " +
					" FROM " + 
					    " log_usuario, " +
					    " controla_data " +
					" WHERE " +
					    " log_usuario.id_hotel = ?1" +
					    " AND   log_usuario.id_hotel = controla_data.id_hotel " +
					    " AND   trunc(log_usuario.data) = trunc(controla_data.contabilidade) " +
					    " AND   log_usuario.tabela_auditada = 'MOVIMENTO_CONTABIL' " +
					    " AND   log_usuario.operacao = 'DEPRECIAÇÃO'";
	
	public static final String QRY_CALCULO_CONTROLE_ATIVO_FIXO = " select fc_agrupa_dados( " +
	" 'SELECT PC.CONTA_CONTABIL|| '' - ''||ID_MOVIMENTO_CONTABIL||'' - ''|| TO_CHAR(DATA_DOCUMENTO,''DD/MM/YYYY'') " +
	" FROM MOVIMENTO_CONTABIL MC, PLANO_CONTAS PC, CONTROLA_DATA CD " +
	    " WHERE PC.ID_REDE_HOTEL = ||P_ID_REDE_HOTEL|| " +
	        " AND MC.ID_PLANO_CONTAS = PC.ID_PLANO_CONTAS " +
	        " AND PC.DEPRECIACAO = ''S'' " +
	        " AND MC.TIPO_MOVIMENTO = ''M'' " +
	        " AND MC.CONTROLE_ATIVO_FIXO IS NULL " +
	        " AND MC.ID_HOTEL = ?2 " +
	        " AND CD.ID_HOTEL = MC.ID_HOTEL  " +
	        " AND MC.DATA_DOCUMENTO <= CD.CONTABILIDADE  " +
	    " order by MC.CONTROLE_ATIVO_FIXO',',') from dual ";
	
	public static final String QRY_COMBO_CONTABIL = 
			"SELECT "+
			" PC.ID_PLANO_CONTAS, "+ 
			" UPPER(TRIM(PC.CONTA_CONTABIL)) AS CONTA_CONTABIL, " +
			" UPPER(TRIM (PC.CONTA_REDUZIDA)) AS CONTA_REDUZIDA, " +
			" UPPER(TRIM(PC.NOME_CONTA)) AS NOME_CONTA " +
			" FROM "+
			" PLANO_CONTAS PC "+ 
			" WHERE "+
			" PC.ID_REDE_HOTEL = ?1 "+
			" AND PC.DEPRECIACAO = 'S' ";
	
	public static final String QRY_COMBO_CONTROLE_ATIVO_FIXO = " SELECT DISTINCT MC.CONTROLE_ATIVO_FIXO CAF " +
	" FROM MOVIMENTO_CONTABIL MC " +
	" JOIN CONTROLA_DATA CD ON MC.ID_HOTEL = CD.ID_HOTEL " +
	" WHERE MC.ID_HOTEL = ?1  " +
	" AND MC.CONTROLE_ATIVO_FIXO IS NOT NULL  " +
	" AND TIPO_MOVIMENTO = 'M' AND MC.DATA_DOCUMENTO <= CD.CONTABILIDADE ";
	
	public static final String QRY_QUANTIDADE_PLANO_CONTAS = 
			"SELECT COUNT(*) "+
			" FROM "+
			" PLANO_CONTAS PC "+ 
			" WHERE "+
			" PC.ID_PLANO_CONTAS = ?1 "+
			" AND PC.DEPRECIACAO = 'S' ";
	
	public abstract List<MovimentoContabilVO> pesquisarMovimentoContabil(MovimentoContabilVO filtro)throws MozartSessionException;
	public abstract MovimentoContabilVO obterSaldoMovimentoContabil(HotelEJB filtro)throws MozartSessionException;
	public abstract void encerrarMovimentoContabil(MovimentoContabilEJB entidadeMov)throws MozartSessionException;
	public abstract void executarProcedureBalanceteRede(String idHoteis, Long idRedeHotel, Date data, String cnpj)throws MozartSessionException;
	public abstract void executarProcedureTotLote(String idHoteis, Long idHotel, RedeHotelEJB redeHotelEJB, Date data, String cnpj)throws MozartSessionException;
	public abstract List<DemonstrativoVO> obterDemonstrativoPlanoContas(RedeHotelEJB redeHotelEJB)throws MozartSessionException;
	public abstract List<DemonstrativoVO> obterDemonstrativoResultado(RedeHotelEJB redeHotelEJB)throws MozartSessionException;
	public abstract void gravarDemonstrativos(DemonstrativoVO entidade) throws MozartSessionException;
	public abstract List<ClassificacaoContabilFaturamentoVO> obterComboCredito(RedeHotelEJB redeHotelEJB, String valor)throws MozartSessionException;
	public abstract List<ClassificacaoContabilFaturamentoVO> obterComboDebito(RedeHotelEJB redeHotelEJB, String valor)throws MozartSessionException;
	public abstract List<ClassificacaoContabilFaturamentoVO> obterComboDebito(RedeHotelEJB redeHotelEJB, String valor, String ativoPassivo)throws MozartSessionException;
	public abstract List<ClassificacaoContabilCentroCustoVO> obterComboCentroCusto(RedeHotelEJB redeHotelEJB)throws MozartSessionException;
	public abstract Long obterNextVal() throws MozartSessionException;
	public abstract void salvarClassificacaoContabilFaturamento( ClassificacaoContabilEJB faturamento) throws MozartSessionException;
	public abstract List<ClassificacaoContabilEJB> obterClassificacaoContabilFaturamento(ClassificacaoContabilEJB faturamento) throws MozartSessionException;
	public abstract List<ClassificacaoContabilFaturamentoGrupoVO> pesquisarClassificacaoContabilFaturamento(ClassificacaoContabilFaturamentoGrupoVO filtro)  throws MozartSessionException;
	public abstract void alterarClassificacaoContabilFaturamento(ClassificacaoContabilEJB faturamento) throws MozartSessionException;
	public abstract List<ClassificacaoContabilEJB> obterClassificacaoContabilPadrao(ClassificacaoContabilEJB faturamento) throws MozartSessionException;
	public abstract List<ClassificacaoContabilPadraoVO> pesquisarClassificacaoContabilPadrao(ClassificacaoContabilPadraoVO padrao) throws MozartSessionException;
	public abstract void salvarClassificacaoContabil(ClassificacaoContabilEJB obj) throws MozartSessionException;
	public abstract ClassificacaoContabilEJB obterClassificacaoContabilPorId(Long idClassificacaoContabil) throws MozartSessionException;
	public abstract void removerClassificacaoContabil(ClassificacaoContabilEJB classificacaoContabil) throws MozartSessionException;
	public abstract void alterarClassificacaoContabil(ClassificacaoContabilEJB classificacaoContabil) throws MozartSessionException;
	public CentroCustoContabilEJB buscarCentroCustoContabil(CentroCustoContabilEJB centroCustoContabil) throws MozartSessionException;
	public abstract Long obterMaxControleAtivoFixoMovimentoContabilPorHotel(Long pIdHotel) throws MozartSessionException;
	public List<ImobilizadoDepreciacaoVO> pesquisarImobilizadoDepreciacao(ImobilizadoDepreciacaoVO filtro, HotelEJB hotel) throws MozartSessionException;
	public abstract ImobilizadoDepreciacaoVO obterImobilizadoDepreciacao(long idMovimentoContabil, HotelEJB hotel) throws MozartSessionException;
	public abstract Long verificaDepreciacaoJaLancada(long idHotel) throws MozartSessionException;
	public abstract List<String> obterValidacaoControleAtivoFixo(Long pIdHotel, Long pIdRedeHotel) throws MozartSessionException;
	public abstract void executarProcedureCalculoDepreciacao(Long idHotel) throws MozartSessionException;
	public abstract List<PlanoContaVO> obterComboPlanoConta(PlanoContaVO filtro) throws MozartSessionException;
	public abstract List<String> obterComboControleAtivoFixo(Long pIdHotel) throws MozartSessionException;
	public abstract Long verificaQuantidadePlanoConta(long idPlanoConta) throws MozartSessionException;
}
