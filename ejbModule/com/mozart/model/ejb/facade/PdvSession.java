package com.mozart.model.ejb.facade;

import java.text.ParseException;
import java.util.List;

import javax.ejb.Remote;

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
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.DadosDescricaoVendaNotaVO;
import com.mozart.model.vo.DadosFormaPagamentoNotaVO;
import com.mozart.model.vo.DadosGeraisNotaVO;
import com.mozart.model.vo.DadosResumoItensNotaVO;
import com.mozart.model.vo.MovimentoRestauranteVO;
import com.mozart.model.vo.NotaFiscalEnvioVO;
import com.mozart.model.vo.NotaFiscalVO;
import com.mozart.model.vo.ProdutoEnvioVO;

@Remote
public interface PdvSession {

	public static final String QUERY_URL_QR_CODE = "SELECT NL.LINK " 
			+ " FROM HOTEL H "
	        + " JOIN CIDADE C "
	        + "    ON (H.ID_CIDADE = C.ID_CIDADE) " 
	        + " JOIN NFE_LINK NL "
	        + "   ON (C.ID_ESTADO = NL.ID_ESTADO) "
	        + " JOIN PONTO_VENDA PV "
	        + "   ON (H.ID_HOTEL = PV.ID_HOTEL AND NL.AMBIENTE = PV.AMBIENTE) " 
	        + " WHERE PV.ID_PONTO_VENDA = ?1 ";

	public static final String QUERY_CHAVE_NOTA = " SELECT UNIQUE E.CODIGO_IBGE||TO_CHAR(CPV.DATA_MOVIMENTO,'YYMM')||H.CGC||NM.MODELO||PV.SERIE||LPAD(TRIM(CPV.NUM_NOTA),9,0)||9||LPAD(SN.ID_NOTA,8,0) AS CHAVE_ACESSO "
			+ " FROM STATUS_NOTA SN  "
			+ " JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL) "
			+ " JOIN CIDADE C ON (H.ID_CIDADE = C.ID_CIDADE) "
			+ " JOIN ESTADO E ON (C.ID_ESTADO = E.ID_ESTADO) "
			+ " JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA)   "
			+ " JOIN PONTO_VENDA PV ON (SN.ID_HOTEL = PV.ID_HOTEL AND CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA)   "
			+ " JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO)   "
			+ " WHERE SN.ID_HOTEL = ?1 "
			+ " AND SN.ID_NOTA = ?2 ";
	
	public static final String QUERY_DADOS_GERAIS_NOTA = " SELECT "
			+ " H.razao_social,  "
			+ " H.cgc                                                         CNPJ,  "
			+ " To_char(Replace(H.insc_estadual, '.'))                        INSCRICAO_ESTADUAL,  "
			+ " H.endereco,  "
			+ " h.numero,  "
			+ " H.complemento,  "
			+ " H.bairro,  "
			+ " C.cidade,  "
			+ " E.uf,  "
			+ " H.cep,  "
			+ " 'DOCUMENTO AUXILIAR DA NOTA FISCAL DE CONSUMIDOR ELETRÔNICA' NFCE,  "
			+ " 'EMITIDA EM CONTIGÊNCIA'                                     CONTIGENCIA,  "
			+ " SN.num_nota,  "
			+ " TO_CHAR (SN.DATA_EMISSAO, 'DD/MM/YYYY HH24:MM:SS')          DATA_EMISSAO,  "
			+ " 'Via Consumidor'                                              Via,  "
			+ " 'Consulte pela chave de acesso em'                            Consulte,  "
			+ " 'Gerar chave'                                                 cNF,  "
			+ " 'Protocolo de autorização: '                                Protocolo,  "
			+ " H.aidf,  "
			+ " H.aidf_data,  "
			+ " 'Consumidor: '                                                Consumidor,  "
			+ " SN.discriminacao,  "
			+ " PV.ORGAO_1,  "
			+ " PV.ORGAO_2,  "
			+ " 'Mozart NFCe'||' - '||PV.VERSAO                              MOZART,  "
			+ " 'PDV: '                                                       PDV,  "
			+ " PV.id_ponto_venda,  "
			+ " PV.SERIE "
			+ " FROM   status_nota SN  "
			       + " JOIN hotel H  "
			         + " ON ( SN.id_hotel = H.id_hotel )  "
			       + " JOIN cidade C  "
			         + " ON ( H.id_cidade = C.id_cidade )  "
			       + " JOIN estado E  "
			         + " ON ( C.id_estado = E.id_estado )  "
			       + " JOIN caixa_ponto_venda CPV  "
			         + " ON ( SN.id_nota = CPV.id_nota )  "
			       + " JOIN ponto_venda PV  "
			         + " ON ( CPV.id_ponto_venda = PV.id_ponto_venda )  "
			+ " WHERE  SN.id_hotel = ?1  "
			       + " AND SN.id_nota = ?2  "
			       + " AND tipo_nota = 'R'  ";
	
	public static final String QUERY_DESCRICAO_VENDA_NOTA = " SELECT MR.id_prato                                 COdigo, "
				   + "PR.nome_prato                               DESCRICAO,  " 
			       + "MR.quantidade                               Qtde,  " 
			       + "'UN'                                        Un,  " 
			       + "To_char(valor_unitario, 'FM999G999G999D90') VrUnit,  " 
			       + "To_char(MR.valor_prato, 'FM999G999G999D90') VrTotal  " 
			+ "FROM   status_nota SN  " 
			       + "JOIN caixa_ponto_venda CPV  " 
			         + "ON ( SN.id_nota = CPV.id_nota )  " 
			       + "JOIN movimento_restaurante MR  " 
			         + "ON ( CPV.id_caixa_ponto_venda = MR.id_caixa_ponto_venda )  " 
			       + "JOIN prato PR  " 
			         + "ON ( MR.id_prato = PR.id_prato )  " 
			+ "WHERE  SN.id_hotel = ?1  " 
			       + "AND SN.id_nota = ?2  " 
			       + "AND SN.tipo_nota = 'R'  ";	
	
	public static final String QUERY_RESUMO_ITENS_NOTA = " SELECT "
			   + " COUNT(*) QTDE_ITENS, "
		       + " TO_CHAR(SUM(MR.VALOR_PRATO),'FM999G999G999D90')  VALOR_PRODUTO, "
		       + " TO_CHAR(SUM(MR.VALOR_TAXA_SERVICO),'FM999G999G999D90')  TAXA, "
		       + " TO_CHAR(SUM(MR.VALOR_PRATO+MR.VALOR_TAXA_SERVICO),'FM999G999G999D90')  VALOR_TOTAL, "
		       + " TO_CHAR((SUM(MR.VALOR_PRATO)*H.IMPOSTOS_MERCADORIAS/100),'FM999G999G999D90') IMPOSTOS " 
		       + " FROM   status_nota SN "
		       + " JOIN caixa_ponto_venda CPV "
		         + " ON ( SN.id_nota = CPV.id_nota ) "
		       + " JOIN movimento_restaurante MR "
		         + " ON ( CPV.id_caixa_ponto_venda = MR.id_caixa_ponto_venda ) "
		       + " JOIN prato PR "
		         + " ON ( MR.id_prato = PR.id_prato ) "
		       + " JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL) "  
		+ " WHERE  SN.id_hotel = ?1 "
		       + " AND SN.id_nota = ?2 "
		       + " AND SN.tipo_nota = 'R' "
		       + " GROUP BY  H.IMPOSTOS_MERCADORIAS ";
		
	public static final String QUERY_FORMA_PAGAMENTO_NOTA = " SELECT TL.descricao_lancamento, "
		       + " To_char(Sum(MR.valor_prato + MR.valor_taxa_servico), 'FM999G999G999D90') "
		       + " VALOR_TOTAL "
		+ " FROM   status_nota SN "
		       + " JOIN caixa_ponto_venda CPV "
		         + " ON ( SN.id_nota = CPV.id_nota ) "
		       + " JOIN movimento_restaurante MR "
		         + " ON ( CPV.id_caixa_ponto_venda = MR.id_caixa_ponto_venda ) "
		       + " JOIN prato PR "
		         + " ON ( MR.id_prato = PR.id_prato ) "
		       + " JOIN tipo_lancamento TL "
		         + " ON ( CPV.id_tipo_lancamento = TL.id_tipo_lancamento ) "
		+ " WHERE  SN.id_hotel = ?1 "
		       + " AND SN.id_nota = ?2 "
		       + " AND SN.tipo_nota = 'R' "
		+ " GROUP BY TL.DESCRICAO_LANCAMENTO ";
	
	public static final String QUERY_MOVIMENTO_RESTAURANTE = " SELECT PV.NOME_PONTO_VENDA, P.NOME_PRATO, "
			+ " M.NUM_MESA, MR.QUANTIDADE, MR.NUM_NOTA, MR.VALOR_PRATO, MR.VALOR_UNITARIO, MR.VALOR_DESCONTO, "
			+ " H.SIGLA, MR.ID_MOVIMENTO_RESTAURANTE, MR.NUM_COMANDA, MR.ID_GARCON, G.NOME_GARCON "
			+ " FROM MOVIMENTO_RESTAURANTE MR "
			+ " JOIN PONTO_VENDA PV ON (MR.ID_PONTO_VENDA = PV.ID_PONTO_VENDA)"
			+ " JOIN PRATO P ON (MR.ID_PRATO = P.ID_PRATO)"
			+ " JOIN MESA M ON (MR.ID_MESA = M.ID_MESA)"
			+ " JOIN HOTEL H ON (MR.ID_HOTEL = H.ID_HOTEL)"
			+ " LEFT JOIN GARCON G ON MR.ID_GARCON = G.ID_GARCON "
			+ " WHERE MR.ID_HOTEL = ?1  ";
	
	String QRY_NOTA_FISCAL_NFCE = " SELECT      " +
			"			 SN.RPS_STATUS,															" +
			"            TO_CHAR(SN.DATA_EMISSAO,'DD-MM-YYYY') DATA_EMISSAO_NF," +
			"            PV.NOME_PONTO_VENDA," +
			"            NM.DESCRICAO MODELO_NF, " +
			"            LPAD(SN.NUM_NOTA,8,0) NUMERO_NF, " +
			"            DECODE(PV.SERIE,NULL,'000',PV.SERIE) SERIE_NF, " +
			"           'VENDA' NAT_OPERACAO_NF," +
			"            ( CASE" +
			"                WHEN ( SN.TIPO_NOTA = 'R'" +
			"                       AND PV.ID_NFE_MODELO = 2 ) THEN TO_NUMBER(SUM(MR.VALOR_PRATO - MR.VALOR_DESCONTO + MR.VALOR_TAXA_SERVICO) )" +
			"                WHEN ( SN.TIPO_NOTA = 'R'" +
			"                       AND PV.ID_NFE_MODELO = 1 ) THEN TO_NUMBER(SUM(MR.VALOR_PRATO - MR.VALOR_DESCONTO + MR.VALOR_TAXA_SERVICO) )" +
			"            END ) TOTAL_NOTA," +
			"            SN.CHAVE_ACESSO, " +
			"            CL.CODIGO, " +
			"            CL.MENSAGEM," +
			"            SN.ARQUIVO_NOME," +
			"            SN.ID_NOTA," +
			" 			 TO_CHAR(SN.DATA_EMISSAO,'DD/MM/YYYY') DataEmissaoFormatada, " +
			"            H.SIGLA" +
			"        FROM" +
			"            STATUS_NOTA SN" +
			"            LEFT JOIN HOTEL H ON ( SN.ID_HOTEL = H.ID_HOTEL )" +
			"            LEFT JOIN CAIXA_PONTO_VENDA CPV ON ( SN.ID_NOTA = CPV.ID_NOTA )" +
			"            LEFT JOIN PONTO_VENDA PV ON ( CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA )" +
			"            LEFT JOIN MOVIMENTO_RESTAURANTE MR ON ( CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA )" +
			"            LEFT JOIN PRATO PR ON (MR.ID_PRATO = PR.ID_PRATO)" +
			"            LEFT JOIN NFE_MODELO NM ON ( PV.ID_NFE_MODELO = NM.ID_NFE_MODELO )" +
			"            LEFT JOIN NFE_ICMS_CADASTRO NIC ON (PR.ID_PRATO = NIC.ID_PRATO) " +
			"            LEFT JOIN CONTROLE_LOTE CL ON (SN.ID_CONTROLE_LOTE = CL.ID_CONTROLE_LOTE) " +
			"        WHERE" +
			"            H.ID_HOTEL =?1" +
			"            AND SN.TIPO_NOTA = 'R' ";

	
	public static final String QUERY_EMITIR_NOTA_FISCAL = " SELECT * FROM ( " +
			" SELECT DISTINCT " +
			" NA.TOKEN, " +
			" H.CGC CPF_CNPJ_EMPRESA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN SN.CPF_CNPJ   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',SN.ID_EMPRESA,SN.ID_HOSPEDE))  " +
			          " WHEN SN.TIPO_NOTA =  'F'  THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.CGC,HOS.CPF ))  " +
			          " END) CPF_CNPJ_CLIENTE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.RAZAO_SOCIAL,HOS.NOME_HOSPEDE||' ' ||HOS.SOBRENOME_HOSPEDE  ))  " +
			          " WHEN SN.TIPO_NOTA =  'F'  THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.RAZAO_SOCIAL,HOS.NOME_HOSPEDE||' ' ||HOS.SOBRENOME_HOSPEDE  ))  " +
			          " END) NOME_CLIENTE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.CEP,HOS.CEP))  " +
			          " WHEN SN.TIPO_NOTA =  'F'  THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.CEP,HOS.CEP))  " +
			          " END) CEP, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'E' ) THEN REPLACE(ER.TELEFONE,'-')  " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'H' ) THEN REPLACE(HOS.TELEFONE,'-')  " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'E') THEN REPLACE(ER.TELEFONE,'-') " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'H') THEN REPLACE(HOS.TELEFONE,'-')  " +
			          " END) FONE_CLIENTE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 3   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'E' ) THEN 2  " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'H' ) THEN 3  " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'E') THEN NULL " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'H') THEN NULL  " +
			          " END) INDICADOR_ID_DESTINATARIO, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'E' ) THEN ER.EMAIL  " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'H' ) THEN HOS.EMAIL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'E') THEN  ER.EMAIL " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'H') THEN HOS.EMAIL  " +
			          " END) EMAIL_CLIENTE, " +
			" TO_CHAR(SN.DATA_EMISSAO,'YYYY-MM-DD hh24:mi:ss') DATA_EMISSAO_NF, " +
			" NM.MODELO MODELO_NF, " +
			" DECODE(PV.SERIE,NULL,'000',PV.SERIE) SERIE_NF, " +
			" LPAD(sn.num_nota,8,0) NUMERO_NF, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 1   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN 1  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) TIPO_EMISSAO_NF, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN '1'   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN '1'  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) CODIGO_NF, " +
			" 'VENDA' AS NAT_OPERACAO_NF, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN '0'   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN '0'  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) IND_PAG_NF, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN '1'   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN '1'  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) TIPO_NF, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN '4'   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN '1'  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) TIPO_IMPRESSAO, " +
			" NVL(SN.LOTE_NFE,0) NUMERO_LOTE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'E' ) THEN E.NUMERO  " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'H' ) THEN HOS.NUMERO " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'E') THEN  E.NUMERO " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'H') THEN HOS.NUMERO " +
			          " END) NUMERO_RESIDENCIA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'E' ) THEN REPLACE(E.COMPLEMENTO,'&')  " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 AND SN.QUEM_PAGA = 'H' ) THEN REPLACE(HOS.COMPLEMENTO,'&') " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'E') THEN REPLACE(E.COMPLEMENTO,'&')  " +
			          " WHEN (SN.TIPO_NOTA =  'F' AND SN.QUEM_PAGA = 'H') THEN REPLACE(HOS.COMPLEMENTO,'&') " +
			          " END) COMPLEMENTO_CLIENTE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN '1'   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN '1'  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) TFIN_NFE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN '1'   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN '1'  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) INDFINAL, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 2   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN 2  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) INDIEDEST, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 99 " +   
					  " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN 99 " +
					  " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
					  " END) TIPO_PAGAMENTO, " +  
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) INFCPL, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN U.NOME  " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN U.NOME  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN U.NOME " +
			          " END) INFOPERADOR, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 0   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN 0  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN 0 " +
			          " ELSE 0 " +
			          " END) VL_TROCO, " +
			" '9' AS TIPO_FRETE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) CNPJ_TRANSPORTADOR, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) RAZAO_SOCIAL_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) INSC_ESTADUAL_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) CEP_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) LOGRADOURO_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) NUMERO_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) BAIRRO_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) CODIGO_ANTT, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) MUNICIPIO_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) UF_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) PLACA_VEICULO, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) QTD_TRANSPORTADORA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) ESPECIE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) MARCA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) NUMERACAO, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) PESO_BRUTO, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) PESO_LIQUIDO, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.ENDERECO||', '||E.NUMERO||', '||E.COMPLEMENTO,HOS.ENDERECO  )) " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.ENDERECO||', '||E.NUMERO||', '||E.COMPLEMENTO,HOS.ENDERECO )) " +
			          " END) LOGRADOURO_CLIENTE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.BAIRRO,HOS.BAIRRO  ))   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.BAIRRO,HOS.BAIRRO  ))  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) BAIRRO_CLIENTE, " +
			" TO_CHAR(SN.DATA_EMISSAO,'YYYY-MM-DD hh24:mi:ss') DATA_SAIDA, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN TO_CHAR(DECODE(SN.QUEM_PAGA,'E',E.INSC_ESTADUAL,NULL  ))  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) IE_CLIENTE, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) nf_ref, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) Nfat, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) Ndup, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN NULL   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN NULL  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN NULL " +
			          " END) Vencimento, " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 0   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN 0  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN 0 " +
			          " END) PRECO_FRETE " +
			" FROM NFE_API NA,HOTEL H " +
			" JOIN STATUS_NOTA SN ON (H.ID_HOTEL = SN.ID_HOTEL) " +
			" JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA) " +
			" JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			" JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO) " +
			" LEFT JOIN HOSPEDE HOS ON (SN.ID_HOSPEDE = HOS.ID_HOSPEDE) " +
			" LEFT JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA) " +
			" LEFT JOIN EMPRESA_REDE ER ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND E.ID_EMPRESA = ER.ID_EMPRESA) " +
			" JOIN LOG_USUARIO LU ON (SN.ID_NOTA = LU.ID_AUDITADO AND LU.OPERACAO = 'Inclusão') " +
			" JOIN USUARIO U ON (LU.ID_USUARIO = U.ID_USUARIO) " +
			" WHERE H.ID_HOTEL = ?1 " +
			" AND SN.ID_NOTA = ?2 " +
			" AND NA.ID_NFE_API = 1), " +
			" (Select  " +
			" (CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 0   " +
			          " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN SUM(NIC.Vicmsdeson)  " +
			          " WHEN (SN.TIPO_NOTA =  'F' ) THEN 0 " +
			          " END)Vicmsdeson " +
			" FROM HOTEL H " +
			" JOIN STATUS_NOTA SN ON (H.ID_HOTEL = SN.ID_HOTEL) " +
			" JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA) " +
			" JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			" JOIN MOVIMENTO_RESTAURANTE MR ON CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA " +
			" JOIN PRATO PR ON (MR.ID_PRATO = PR.ID_PRATO) " +
			" JOIN NFE_ICMS_CADASTRO NIC ON (PR.ID_PRATO = NIC.ID_PRATO) " +
			" WHERE H.ID_HOTEL = ?1 " +
			" AND SN.ID_NOTA = ?2 " +
			" group by SN.TIPO_NOTA,PV.ID_NFE_MODELO,NIC.VICMSDESON), " +
			" (SELECT DISTINCT " +
				" NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2 AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (1) )  " +
				"         THEN NULL  " +
				"       WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO IN (1,2) AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (2,3) )   " +
				"         THEN  " +
				"         TO_NUMBER(SUM(NVL(NF.PERCENTUAL * (MR.VALOR_PRATO-MR.VALOR_DESCONTO),0)))   " +
				"       WHEN (SN.TIPO_NOTA =  'F' )  " +
				"         THEN NULL " +
				"  END),0) VFCPUFDEST   " +
				"     FROM STATUS_NOTA SN " +
				"          LEFT JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL) " +
				"          LEFT JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA ) " +
				"          LEFT JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
				"          LEFT JOIN MOVIMENTO_RESTAURANTE MR ON (CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA) " +
				"          LEFT JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO) " +
				"          LEFT JOIN EMPRESA_REDE ER ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL) " +
				"          LEFT JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA AND E.ID_EMPRESA = ER.ID_EMPRESA) " +
				"          LEFT JOIN CIDADE C ON C.ID_CIDADE = E.ID_CIDADE " +
				"          LEFT JOIN NFE_FCP NF ON C.ID_ESTADO = NF.ID_ESTADO " +
				"     WHERE H.ID_HOTEL = ?1 " +
				"          AND SN.ID_NOTA = ?2 " +
				"          GROUP BY SN.TIPO_NOTA,PV.ID_NFE_MODELO,H.ID_FISCAL_REGIME_TRIBUTARIO,MR.ID_MOVIMENTO_RESTAURANTE,C.ID_ESTADO, NF.ID_ESTADO), " +
	        " (SELECT DISTINCT " +
	        " NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2 AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (1) )  " +
	        "         THEN NULL  " +
	        "       WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO IN (1,2) AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (2,3))   " +
	        "         THEN TO_NUMBER(SUM(NVL(NF.PERCENTUAL * (MR.VALOR_PRATO-MR.VALOR_DESCONTO),0)))   " +
	        "       WHEN (SN.TIPO_NOTA =  'F' )  " +
	        "         THEN NULL " +
	        "  END),0) Vfcp   " +
	        "     FROM STATUS_NOTA SN " +
	        "          LEFT JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL) " +
	        "          LEFT JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA ) " +
	        "          LEFT JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
	        "          LEFT JOIN MOVIMENTO_RESTAURANTE MR ON (CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA) " +
	        "          LEFT JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO) " +
	        "          LEFT JOIN EMPRESA_REDE ER ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL) " +
			"          LEFT JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA AND E.ID_EMPRESA = ER.ID_EMPRESA) " +
			"          LEFT JOIN CIDADE C ON C.ID_CIDADE = E.ID_CIDADE " +
			"          LEFT JOIN NFE_FCP NF ON C.ID_ESTADO = NF.ID_ESTADO " +
	        "     WHERE H.ID_HOTEL = ?1 " +
	        "          AND SN.ID_NOTA = ?2 " +
	        "     GROUP BY SN.TIPO_NOTA,PV.ID_NFE_MODELO,H.ID_FISCAL_REGIME_TRIBUTARIO,MR.ID_MOVIMENTO_RESTAURANTE,C.ID_ESTADO, NF.ID_ESTADO), " +
			" (SELECT DISTINCT " +
			" NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2 AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (1) )  " +
			"         THEN NULL  " +
			"       WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO IN (1,2) AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (2,3) AND NIC.VBCSTDEST IS NOT NULL)   " +
			"         THEN TO_NUMBER(SUM(NVL(NF.PERCENTUAL * (MR.VALOR_PRATO-MR.VALOR_DESCONTO),0)))   " +
			"       WHEN (SN.TIPO_NOTA =  'F' )  " +
			"         THEN NULL " +
			"  END),0) Vfcpst   " +
			"     FROM STATUS_NOTA SN " +
			"          LEFT JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL) " +
			"          LEFT JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA ) " +
			"          LEFT JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			"          LEFT JOIN MOVIMENTO_RESTAURANTE MR ON (CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA) " +
			"          LEFT JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO) " +
			"          LEFT JOIN NFE_ICMS_CADASTRO NIC ON(MR.ID_PRATO = NIC.ID_PRATO) " +
			"          LEFT JOIN EMPRESA_REDE ER ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL) " +
			"          LEFT JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA AND E.ID_EMPRESA = ER.ID_EMPRESA) " +
			"          LEFT JOIN CIDADE C ON C.ID_CIDADE = E.ID_CIDADE " +
			"          LEFT JOIN NFE_FCP NF ON C.ID_ESTADO = NF.ID_ESTADO " +
			"     WHERE H.ID_HOTEL = ?1 " +
			"          AND SN.ID_NOTA = ?2 " +
			"     GROUP BY SN.TIPO_NOTA,PV.ID_NFE_MODELO,H.ID_FISCAL_REGIME_TRIBUTARIO,MR.ID_MOVIMENTO_RESTAURANTE,C.ID_ESTADO, NF.ID_ESTADO,NIC.VBCSTDEST), " +
			" (SELECT DISTINCT " +
			" NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2 AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (1) )  " +
			"         THEN NULL  " +
			"       WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO IN (1,2) AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (2,3) AND NIC.VBCSTRETUF IS NOT NULL)   " +
			"         THEN TO_NUMBER(SUM(NVL(NF.PERCENTUAL * (MR.VALOR_PRATO-MR.VALOR_DESCONTO),0)))   " +
			"       WHEN (SN.TIPO_NOTA =  'F' )  " +
			"         THEN NULL " +
			"  END),0) Vfcpstret   " +
			"     FROM STATUS_NOTA SN " +
			"          LEFT JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL) " +
			"          LEFT JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA ) " +
			"          LEFT JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			"          LEFT JOIN MOVIMENTO_RESTAURANTE MR ON (CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA) " +
			"          LEFT JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO) " +
			"          LEFT JOIN NFE_ICMS_CADASTRO NIC ON(MR.ID_PRATO = NIC.ID_PRATO) " +
			"          LEFT JOIN EMPRESA_REDE ER ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL) " +
			"          LEFT JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA AND E.ID_EMPRESA = ER.ID_EMPRESA) " +
			"          LEFT JOIN CIDADE C ON C.ID_CIDADE = E.ID_CIDADE " +
			"          LEFT JOIN NFE_FCP NF ON C.ID_ESTADO = NF.ID_ESTADO " +
			"     WHERE H.ID_HOTEL = ?1 " +
			"          AND SN.ID_NOTA = ?2 " +
			"     GROUP BY SN.TIPO_NOTA,PV.ID_NFE_MODELO,H.ID_FISCAL_REGIME_TRIBUTARIO,MR.ID_MOVIMENTO_RESTAURANTE,C.ID_ESTADO, NF.ID_ESTADO,NIC.VBCSTRETUF), " +
			" (Select  " +
			    " NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 0   " +
			              " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN SUM(NIIC.Vii)  " +
			              " WHEN (SN.TIPO_NOTA =  'F' ) THEN 0 " +
			              " END),0) Vii " +
			    " FROM HOTEL H " +
			    " JOIN STATUS_NOTA SN ON (H.ID_HOTEL = SN.ID_HOTEL) " +
			    " JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA) " +
			    " JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			    " JOIN MOVIMENTO_RESTAURANTE MR ON CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA " +
			    " JOIN PRATO PR ON (MR.ID_PRATO = PR.ID_PRATO) " +
			    " JOIN NFE_II_CADASTRO NIIC ON (PR.ID_PRATO = NIIC.ID_PRATO) " +
			    " WHERE H.ID_HOTEL = ?1 " +
			    " AND SN.ID_NOTA = ?2 " +
			    " group by SN.TIPO_NOTA,PV.ID_NFE_MODELO,NIIC.VII), " +
			" (Select  " +
			    " NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 0   " +
			              " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN SUM(NIPIC.Vipidevol)  " +
			              " WHEN (SN.TIPO_NOTA =  'F' ) THEN 0 " +
			              " END),0) Vipidevol " +
			    " FROM HOTEL H " +
			    " JOIN STATUS_NOTA SN ON (H.ID_HOTEL = SN.ID_HOTEL) " +
			    " JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA) " +
			    " JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			    " JOIN MOVIMENTO_RESTAURANTE MR ON CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA " +
			    " JOIN PRATO PR ON (MR.ID_PRATO = PR.ID_PRATO) " +
			    " LEFT JOIN NFE_IPI_CADASTRO NIPIC ON (PR.ID_PRATO = NIPIC.ID_PRATO) " +
			    " WHERE H.ID_HOTEL = ?1 " +
			    " AND SN.ID_NOTA = ?2 " +
			    " group by SN.TIPO_NOTA,PV.ID_NFE_MODELO,NIPIC.Vipidevol), " +
			" (Select  " +
			    " NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2) THEN 0   " +
			              " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 1 ) THEN SUM(MR.VALOR_DESCONTO)  " +
			              " WHEN (SN.TIPO_NOTA =  'F' ) THEN 0 " +
			              " END),0) VALOR_DESCONTO " +
			    " FROM HOTEL H " +
			    " JOIN STATUS_NOTA SN ON (H.ID_HOTEL = SN.ID_HOTEL) " +
			    " JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA) " +
			    " JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			    " JOIN MOVIMENTO_RESTAURANTE MR ON CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA " +
			    " JOIN PRATO PR ON (MR.ID_PRATO = PR.ID_PRATO) " +
			    " WHERE H.ID_HOTEL = ?1 " +
			    " AND SN.ID_NOTA = ?2 " +
			    " group by SN.TIPO_NOTA,PV.ID_NFE_MODELO,MR.VALOR_DESCONTO), " +
		    " (SELECT DISTINCT " +
			    " NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2 )  " +
			    "         THEN TO_NUMBER(SUM(MR.VALOR_PRATO-MR.VALOR_DESCONTO),'FM999G999G999D99') " +
			    "       WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO IN (1) )   " +
			    "         THEN TO_NUMBER(SUM(MR.VALOR_PRATO-MR.VALOR_DESCONTO),'FM999G999G999D99')   " +
			    "       WHEN (SN.TIPO_NOTA =  'F' ) THEN 0 " +
			    "  END),0) VL_PAGO   " +
			    "     FROM STATUS_NOTA SN " +
			    "          LEFT JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL) " +
			    "          LEFT JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA ) " +
			    "          LEFT JOIN PONTO_VENDA PV ON (CPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
			    "          LEFT JOIN MOVIMENTO_RESTAURANTE MR ON (CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA) " +
			    "          LEFT JOIN PRATO PR ON (MR.ID_PRATO = PR.ID_PRATO) " +
			    "          LEFT JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO) " +
			    "          LEFT JOIN CIDADE C ON (H.ID_CIDADE = C.ID_CIDADE) " +
				"          LEFT JOIN NFE_FCP NF ON C.ID_ESTADO = NF.ID_ESTADO " +
			    "          LEFT JOIN NFE_ICMS_CADASTRO NIC ON(MR.ID_PRATO = NIC.ID_PRATO) " +
			    "     WHERE H.ID_HOTEL = ?1 " +
			    "          AND SN.ID_NOTA = ?2 " +
			    "     GROUP BY SN.TIPO_NOTA,PV.ID_NFE_MODELO) ";
	
	public static final String QUERY_INCLUIR_PRODUTO_NOTA = " SELECT  " +
								" LPAD(MR.ID_PRATO,10,0) CPROD, " +
								" PR.CEAN CEAN, " +
								" TRIM(PR.NOME_PRATO) XPROD , " +
								" PR.NCM NCM, " +
								" PR.CEST CEST, " +
								" '5'||FC.SUB_CODIGO CFOP, " +
								" NU.UNIDADE UCOM, " +
								" MR.QUANTIDADE QCOM, " +
								" NVL(MR.VALOR_UNITARIO,0) VUNCOM, " +
								" NVL(MR.VALOR_PRATO,0) VPROD, " +
								" PR.CEANTRIB CEANTRIB, " +
								" NU.UNIDADE UTRIB, " +
								" NVL(MR.QUANTIDADE,0) QTRIB, " +
								" NVL(MR.VALOR_UNITARIO,0) VUNTRIB, " +
								" NVL(MR.VALOR_DESCONTO,0) VDESC, " +
								" NVL(MR.VALOR_TAXA_SERVICO,0) VOUTROS, " +
								" 1 as INDTOTAL, " +
								" NVL(H.IMPOSTOS_MERCADORIAS,0) VTOTTRIB, " +
								" NIOM.CODIGO ICMS_ORIGEM, " +
								" DECODE(NICST.CST,NULL,NICST.CSOSN) ICMS_CST, " +
								" DECODE(NIC.ID_NFE_ICMS_MOD_BC_ICMS,NULL,NIC.ID_NFE_ICMS_MOD_BC_ICMSST) ICMS_MODBC, " +
								" TO_NUMBER (NVL(DECODE(NIC.PREDBC,NULL,NIC.PREDBCST),0)) ICMS_REDBC, " +
								" TO_NUMBER (NVL(DECODE(A.ID_ALIQUOTAS,1,NULL,2,NULL,3,NULL,4,NULL,TO_NUMBER (MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO),'FM999G999G999D90'),0))  ICMS_VBC, " +
								" TO_NUMBER (NVL(DECODE(A.ID_ALIQUOTAS,1,NULL,2,NULL,3,NULL,4,NULL,A.ALIQUOTA),0)) ICMS_PICMS, " +
								" TO_NUMBER (NVL(TO_NUMBER (((MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO)*(DECODE(A.ID_ALIQUOTAS,1,NULL,2,NULL,3,NULL,4,NULL,A.ALIQUOTA)/100)),'FM999G999G999D90'),0)) ICMS_VICMS, " +
								" NIPIC.CENQ IPI_CENQ, " +
								" NIPICST.CST IPINT_CST, " +
								" NPISCST.CST PISALIQ_CST, " +
								" TO_NUMBER (NVL((CASE WHEN (NPISC.PPIS > 0) THEN TO_NUMBER(MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO)  " +
								            " WHEN (NPISC.VALIQPROD > 0 ) THEN TO_NUMBER(MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO)  " +
								            " WHEN (NPISC.PPIS = NULL) AND (NPISC.VALIQPROD = NULL ) THEN TO_NUMBER(MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO) " +
								            " END),0)) PISALIQ_VBC, " +
								" NVL(NPISC.PPIS,0) PISALIQ_PPIS, " +
								" NVL(NPISC.VPIS,0) PISALIQ_VPIS, " +
								" NCOFINSCST.CST COFINSALIQ_CST, " +
								" NVL((CASE WHEN (NCOFINSC.PCOFINS > 0) THEN TO_NUMBER(MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO)  " +
								            " WHEN (NCOFINSC.VALIQPROD > 0 ) THEN TO_NUMBER(MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO)  " +
								            " WHEN (NCOFINSC.PCOFINS = NULL) AND (NCOFINSC.VALIQPROD = NULL ) THEN TO_NUMBER(MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO) " +
								            " END),0) COFINSALIQ_VBC, " +
								" NVL(NCOFINSC.PCOFINS,0) COFINSALIQ_PCOFINS, " +
								" NVL(NCOFINSC.VCOFINS,0) COFINSALIQ_VCOFINS, " +
								" NVL(NIC.PREDBC,0) ICMS_PREDBC, " +
								" 'SN' TIPO_TRIBUTACAO, " +
								" NICST.CSOSN CSOSN, " +
								" NVL(NIC.VBCSTRET,0) VBCSTRET, " +
								" NVL(NIC.VICMSSTRET,0) VICMSST_RETN, " +
								" NIPICST.CST PISNT_CST, " +
								" NCOFINSCST.CST COFINSNT_CST, " +
								" H.NOTA_TERMO||'R$'||' '||TO_CHAR(H.IMPOSTOS_MERCADORIAS*PR.VALOR_PRATO/100,'FM9999G999D90') INFADPROD, " +
								" NIPICST.CST IPI_CST, " +
								" 0 IPI_VBC, " +
								" 0 IPI_PIPI, " +
								" 0 IPI_VIPI, " +
								" NVL(NF.PERCENTUAL * MR.VALOR_PRATO,0) vfcpufdest, " +
								" NVL((NF.PERCENTUAL * MR.VALOR_PRATO),0) vfcp, " +
								" NVL(NIC.PMVAST,0) pmvast, " +
								" NVL(TO_NUMBER((MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO),'FM999G999G999D90'),0) vbcst, " +
								" NVL(NIC.picmsst,0) picmsst, " +
								" NVL(NIC.picmsst*(MR.VALOR_PRATO-MR.VALOR_DESCONTO-MR.VALOR_TAXA_SERVICO),0) vicmsst, " +
								" NVL((CASE WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO = 2 AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (1) )  " +
								        " THEN 0  " +
								      " WHEN (SN.TIPO_NOTA = 'R' AND PV.ID_NFE_MODELO IN (1,2) AND H.ID_FISCAL_REGIME_TRIBUTARIO IN (2,3) AND C.ID_ESTADO = NF.ID_ESTADO)   " +
								        " THEN NVL(NF.PERCENTUAL * MR.VALOR_PRATO,0)   " +
								      " WHEN (SN.TIPO_NOTA =  'F' )  " +
								        " THEN 0  " +
								" END),0) pfcp " +
								" FROM  NFE_API NA, STATUS_NOTA SN " +
								" JOIN CAIXA_PONTO_VENDA CPV ON (SN.ID_NOTA = CPV.ID_NOTA) " +
								" JOIN MOVIMENTO_RESTAURANTE MR ON (CPV.ID_CAIXA_PONTO_VENDA = MR.ID_CAIXA_PONTO_VENDA) " +
								" JOIN PONTO_VENDA PV ON (MR.ID_PONTO_VENDA = PV.ID_PONTO_VENDA) " +
								" JOIN PRATO PR ON (MR.ID_PRATO = PR.ID_PRATO) " +
								" JOIN FISCAL_CODIGO FC ON (PR.ID_FISCAL_CODIGO = FC.ID_CODIGO_FISCAL) " +
								" JOIN HOTEL H ON(SN.ID_HOTEL = H.ID_HOTEL) " +
								" JOIN ALIQUOTAS A ON (PR.ID_ALIQUOTA = A.ID_ALIQUOTAS) " +
								" JOIN NFE_MODELO NM ON (PV.ID_NFE_MODELO = NM.ID_NFE_MODELO) " +
								" LEFT JOIN NFE_ICMS_CADASTRO NIC ON (MR.ID_PRATO = NIC.ID_PRATO) " +
								" LEFT JOIN NFE_ICMS_ORIGEM_MERCADORIA NIOM ON (NIC.ID_NFE_ICMS_ORIGEM_MERCADORIA = NIOM.ID_NFE_ICMS_ORIGEM_MERCADORIA) " +
								" LEFT JOIN NFE_ICMS_CST NICST ON (NICST.ID_NFE_ICMS_CST = NIC.ID_NFE_ICMS_CST AND NIC.ID_NFE_ICMS_CST = NICST.ID_NFE_ICMS_CST AND NIC.ID_NFE_ICMS_CST = NICST.ID_NFE_ICMS_CST) " +
								" LEFT JOIN NFE_IPI_CADASTRO NIPIC ON (MR.ID_PRATO = NIPIC.ID_PRATO) " +
								" LEFT JOIN NFE_IPI_CST NIPICST ON (NIPIC.ID_NFE_IPI_CST = NIPICST.ID_NFE_IPI_CST AND NIPIC.ID_NFE_IPI_CST = NIPIC.ID_NFE_IPI_CST) " +
								" LEFT JOIN NFE_PIS_CADASTRO NPISC ON (MR.ID_PRATO = NPISC.ID_PRATO) " +
								" LEFT JOIN NFE_PIS_CST NPISCST ON (NPISC.ID_NFE_PIS_CST = NPISCST.ID_NFE_PIS_CST) " +
								" LEFT JOIN NFE_COFINS_CADASTRO NCOFINSC ON (MR.ID_PRATO = NCOFINSC.ID_PRATO) " +
								" LEFT JOIN NFE_COFINS_CST NCOFINSCST ON (NCOFINSC.ID_NFE_COFINS_CST = NCOFINSCST.ID_NFE_COFINS_CST AND NCOFINSC.ID_NFE_COFINS_CST = NCOFINSCST.ID_NFE_COFINS_CST) " +
								" JOIN NFE_UNIDADE NU ON (PR.ID_NFE_UNIDADE = NU.ID_NFE_UNIDADE) " +
								" LEFT JOIN CIDADE C ON (H.ID_CIDADE = C.ID_CIDADE) " +
								" LEFT JOIN NFE_FCP NF ON C.ID_ESTADO = NF.ID_ESTADO " +
								" WHERE SN.ID_HOTEL = ?1 " +
								" AND SN.ID_NOTA = ?2 " +
								" AND NA.ID_NFE_API = 2 ";



	
	public abstract List<MovimentoRestauranteVO> pesquisarMovimentoRestaurante(
			MovimentoRestauranteVO pFiltro) throws MozartSessionException;

	public abstract MovimentoRestauranteEJB gravarMovimentoRestaurante(
			MovimentoRestauranteEJB movimentoRestaurante, MesaEJB mesa)
			throws MozartSessionException;

	public abstract void excluir(MovimentoRestauranteEJB entidade)
			throws MozartSessionException;

	public abstract RoomListEJB getRoomListPrincipalCheckin(Long pIdCheckin,
			String pPrincipal) throws MozartSessionException;

	public abstract PontoVendaEJB gravarPontoVenda(PontoVendaEJB pPontoVenda)
			throws MozartSessionException;

	public abstract CaixaPontoVendaEJB gravarCaixaPontoVenda(
			CaixaPontoVendaEJB entidade) throws MozartSessionException;

	public abstract MovimentoApartamentoEJB gravarMovimentoApartamento(
			MovimentoApartamentoEJB entidade) throws MozartSessionException;

	public abstract StatusNotaEJB gravarStatusNota(StatusNotaEJB entidade)
			throws MozartSessionException;

	public abstract HotelEJB getHotelPorRestaurante(Long pIdRestaurante)
			throws MozartSessionException;

	public abstract TipoLancamentoEJB consultarTipoLancamentoParaRestauranteTerceirizado(
			TipoLancamentoEJB pTipoLancamentoRestaurante)
			throws MozartSessionException;

	public abstract TipoLancamentoEJB consultarTipoLancamentoDoRestaurante(
			TipoLancamentoEJB pTipoLancamentoRestaurante, HotelEJB pRestaurante)
			throws MozartSessionException;

	public abstract List<MovimentoRestauranteEJB> consultarMovimentacaoMesa(
			MesaEJB mesaEJB) throws MozartSessionException;

	public abstract RestTlHtlEJB consultarRestTlHtl(
			TipoLancamentoEJB tipoLancamentoHotel,
			TipoLancamentoEJB tipoLancamentoRest) throws MozartSessionException;

	public abstract NfeMovRestConfinsEJB gravarMovCofins(NfeMovRestConfinsEJB entidade) throws MozartSessionException;
	
	public abstract String obterChaveNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException; 
	
	public abstract List<DadosGeraisNotaVO> obterDadosGeraisNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException; 
	
	public abstract List<DadosDescricaoVendaNotaVO> obterDescricaoVendaNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException;
	
	public abstract List<DadosResumoItensNotaVO> obterResumoItensNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException;
	
	public abstract List<DadosFormaPagamentoNotaVO> obterFormaPagamentoNota(HotelEJB hotel, StatusNotaEJB nota) throws MozartSessionException;
	
	public abstract void executarProcedureNfeRestaurante(Long idMovimentoRestaurante) throws MozartSessionException;
	
	public abstract String obterUrlQrCode(PontoVendaEJB pdv) throws MozartSessionException;
	
	public abstract NotaFiscalEnvioVO consultarNotaFiscalEmissao(NotaFiscalEnvioVO filtro) throws MozartSessionException, ParseException;
	
	public abstract List<ProdutoEnvioVO> obterProdutosEmissaoNota(ProdutoEnvioVO filtro) throws MozartSessionException;
	
	abstract PartnerDominioEJB getDesignHotel(String urlHotel) throws MozartSessionException;
	
	public abstract List<NotaFiscalVO> consultarNotaFiscalNfce(NotaFiscalVO pFiltro) throws MozartSessionException;
}