package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.AliquotaEJB;
import com.mozart.model.ejb.entity.FiscalCodigoEJB;
import com.mozart.model.ejb.entity.FiscalIncidenciaEJB;
import com.mozart.model.ejb.entity.GrupoPratoEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoCiEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.UsuarioConsumoInternoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.AjustePdvVO;
import com.mozart.model.vo.ConsumoInternoVO;
import com.mozart.model.vo.FiscalCodigoVO;
import com.mozart.model.vo.ItemEstoqueVO;
import com.mozart.model.vo.PratoConsumoInternoVO;
import com.mozart.model.vo.PratoVO;
import com.mozart.model.vo.TransferenciaCentroCustoVO;
import com.mozart.model.vo.UsuarioConsumoInternoVO;

@Remote
public interface CustoSession {

	String QRY_PRATO = " SELECT P.ID_PRATO, P.NOME_PRATO, TI.NOME_TIPO TIPO_PRATO, GP.NOME_GRUPO_PRATO, "
			+ " SUM(ROUND(NVL(T.VALOR_CUSTO,0),2)) VALOR_CUSTO, P.VALOR_PRATO VALOR_PRATO, "
			+ " SUM(ROUND(DECODE(VALOR_PRATO,0,0,NVL((VALOR_CUSTO*100/VALOR_PRATO),0)),2))CUSTO "
			+ " FROM PRATO P, GRUPO_PRATO GP, TIPO_ITEM TI, "
			+ " (SELECT /*+ INDEX_COMBINE ( FICHA_TECNICA_PRATO IDX_FICHA_TECN_PRATO_ID_PRATO ) */ "
			+ " PRATO.ID_PRATO, (FICHA_TECNICA_PRATO.QUANTIDADE * ITEM.VALOR)VALOR_CUSTO "
			+ " FROM MOVIMENTO_ESTOQUE, FICHA_TECNICA_PRATO, PRATO, "
			+ " (SELECT  NVL(VALOR_UNITARIO,0)VALOR,ID_ITEM "
			+ " FROM MOVIMENTO_ESTOQUE  "
			+ " WHERE %s "
			+ " AND TIPO_MOVIMENTO IN ('D','E') "
			+ " AND VALOR_UNITARIO<> 0 "
			+ " AND ID_MOVIMENTO_ESTOQUE IN ( "
			+ " SELECT  MAX(ID_MOVIMENTO_ESTOQUE) ID_MOVIMENTO_ESTOQUE "
			+ " FROM MOVIMENTO_ESTOQUE  "
			+ " WHERE  %s "
			+ " AND TIPO_MOVIMENTO IN ('D','E') "
			+ " AND VALOR_UNITARIO<> 0 "
			+ " GROUP BY ID_ITEM "
			+ " ))ITEM  "
			+ " WHERE MOVIMENTO_ESTOQUE.ID_ITEM = FICHA_TECNICA_PRATO.ID_ITEM "
			+ " AND FICHA_TECNICA_PRATO.ID_PRATO = PRATO.ID_PRATO "
			+ " and MOVIMENTO_ESTOQUE.ID_HOTEL = PRATO.ID_HOTEL "
			+ " and ITEM.ID_ITEM = MOVIMENTO_ESTOQUE.ID_ITEM "
			+ " GROUP BY PRATO.ID_PRATO,FICHA_TECNICA_PRATO.QUANTIDADE,ITEM.VALOR) T "
			+ " WHERE P.ID_PRATO = T.ID_PRATO (+) "
			+ " AND %s "
			+ " AND P.ID_GRUPO_PRATO = GP.ID_GRUPO_PRATO "
			+ " AND P.ID_TIPO_ITEM = TI.ID_TIPO_ITEM (+)  ";

	String QRY_ITEM_ESTOQUE_FICHA_TECNICA = " SELECT IR.ID_ITEM, IR.NOME_ITEM, ITEM.DATA_MOVIMENTO DATA_MOVIMENTO, "
			+ " NVL(ITEM.VALOR_UNITARIO,0) VALOR_UNITARIO  "
			+ " FROM ITEM_ESTOQUE I,ITEM_REDE IR, "
			+ " (SELECT ID_ITEM,ID_HOTEL, DATA_MOVIMENTO, VALOR_UNITARIO "
			+ " FROM MOVIMENTO_ESTOQUE "
			+ " WHERE ID_MOVIMENTO_ESTOQUE IN( "
			+ " SELECT MAX(ID_MOVIMENTO_ESTOQUE) "
			+ " FROM MOVIMENTO_ESTOQUE "
			+ " WHERE ID_HOTEL = ?1 "
			+ " AND (TIPO_MOVIMENTO = 'E' OR TIPO_MOVIMENTO = 'D') "
			+ " GROUP BY ID_ITEM) "
			+ " ) ITEM "
			+ " WHERE IR.ID_REDE_HOTEL = ?2 "
			+ " AND I.ID_ITEM = ITEM.ID_ITEM "
			+ " AND I.ID_HOTEL = ITEM.ID_HOTEL "
			+ " AND I.ID_ITEM = IR.ID_ITEM " + " ORDER BY NOME_ITEM ";
	
	String QRY_FISCAL_CODIGOS = "SELECT FC.ID_CODIGO_FISCAL, FC.COD_ESTADO, FC.COD_ESTRANGEIRO,  FC.COD_F_ESTADO, "
			+ "FC.DESCRICAO, FC.DESCRICAO_DOCUMENTO, FC.DESCRICAO_MOTIVO, FC.DESCRICAO_SERVICO, FC.DESCRICAO_SITUACAO, "
			+ "FC.FLG_PRINCIPAL, FC.ID_CIDADE, FC.MOTIVO_CANCELA, FC.SITUACAO_NF, FC.SUB_CODIGO, FC.TIPO_DOCUMENTO, FC.TIPO_SERVICO "
			+ "FROM FISCAL_CODIGO FC";
	
	String QRY_TRANSFERENCIA_CENTRO_CUSTO = " SELECT IR.NOME_ITEM, "
			+ "CCC.DESCRICAO_CENTRO_CUSTO,  "
			+ "ME.DATA_MOVIMENTO,  "
			+ "DECODE (ME.TIPO_MOVIMENTO, 'T', 'ENTRADA', 'SAIDA'), "  
			+ "ME.NUM_DOCUMENTO,  "
			+ "ME.TIPO_DOCUMENTO,  "
			+ "ME.QUANTIDADE,  "
			+ "ME.VALOR_UNITARIO, "  
			+ "ME.VALOR_TOTAL, "
			+ "H.SIGLA, "
			+ "ME.ID_MOVIMENTO_ESTOQUE "  
			+ "FROM MOVIMENTO_ESTOQUE ME "  
			+ "JOIN ITEM_ESTOQUE IE "
			+ "ON (ME.ID_ITEM = IE.ID_ITEM AND ME.ID_HOTEL = IE.ID_HOTEL) " 
			+ "JOIN ITEM_REDE IR "
			+ "ON (ME.ID_ITEM = IR.ID_ITEM)"  
			+ "JOIN HOTEL H "
			+ "ON (ME.ID_HOTEL = H.ID_HOTEL) " 
			+ "JOIN CENTRO_CUSTO_CONTABIL CCC "
			+ "ON (ME.ID_CENTRO_CUSTO = CCC.ID_CENTRO_CUSTO_CONTABIL) "     
			+ "WHERE ME.TIPO_MOVIMENTO IN ('T', 'R') AND ME.ID_HOTEL = ?1 ";	
	
	String QRY_USUARIO_CONSUMO_INTERNO = " SELECT DISTINCT UCI.ID_USUARIO_CONSUMO_INTERNO,   "
			+ "       UCI.NOME,   "
			+ "       UCI.ATIVO,   "
			+ "       CCC.DESCRICAO_CENTRO_CUSTO,   "
			+ "       UCI.DATA_INICIAL,   "
			+ "       UCI.DATA_FINAL, "
			+ "       UCI.ALCOOLICA, "
			+ "       UCI.TIPO_PENSAO,   "
			+ "       H.SIGLA   "
			+ "  FROM USUARIOS_CONSUMO_INTERNO UCI   "
			+ "       JOIN CENTRO_CUSTO_CONTABIL CCC   "
			+ "          ON (UCI.ID_CENTRO_CUSTO_CONTABIL = CCC.ID_CENTRO_CUSTO_CONTABIL)   "
			+ "       JOIN HOTEL H   "
			+ "          ON (UCI.ID_HOTEL = H.ID_HOTEL AND CCC.ID_REDE_HOTEL = H.ID_REDE_HOTEL )   "
			+ "WHERE H.ID_REDE_HOTEL = ?1   "
			+ "AND H.ATIVO_WEB = 'S' ";
	
	String QRY_CONSUMO_INTERNO = " SELECT DISTINCT UCI.NOME, "
	+ "          MCI.DATA_MOVIMENTO, "
	+ "          PDV.NOME_PONTO_VENDA, "
	+ "          PR.NOME_PRATO, "
	+ "          MCI.NUM_DOCUMENTO, "
	+ "          MCI.QTDE, "
	+ "          ROUND (MCI.VALOR_UNITARIO_CUSTO,2) CUSTO, "
	+ "          ROUND (MCI.VALOR_UNITARIO_VENDA,2) VENDA,          "
	+ "          ROUND (MCI.VALOR_UNITARIO_CUSTO * MCI.QTDE, 2) VALOR_CUSTO, "
	+ "          ROUND (MCI.VALOR_UNITARIO_VENDA * MCI.QTDE, 2) VALOR_VENDA, "
	+ "          ROUND (MCI.VALOR_UNITARIO_CUSTO * 100 / MCI.VALOR_UNITARIO_VENDA, 2) "
	+ "             PERCCUSTO, "
	+ "           H.SIGLA, "
	+ "          MCI.ID_MOVIMENTO_CI "
	+ "     FROM MOVIMENTO_CI MCI "
	+ "          JOIN USUARIOS_CONSUMO_INTERNO UCI "
	+ "             ON (MCI.ID_USUARIO_CONSUMO_INTERNO = UCI.ID_USUARIO_CONSUMO_INTERNO) "
	+ "          JOIN PONTO_VENDA PDV "
	+ "             ON (MCI.ID_PONTO_VENDA = PDV.ID_PONTO_VENDA) "
	+ "          JOIN PRATO PR "
	+ "             ON (MCI.ID_PRATO = PR.ID_PRATO) "
	+ "          JOIN HOTEL H "
	+ "             ON (MCI.ID_HOTEL = H.ID_HOTEL) "
	+ "    WHERE 1 = 1 ";
	
	String QRY_USUARIO_CONSUMO_COMBO = " SELECT DISTINCT UCI.ID_USUARIO_CONSUMO_INTERNO, "
	+ "        UCI.NOME "
	+ "   FROM USUARIOS_CONSUMO_INTERNO UCI "
	+ "        JOIN USUARIOS_CI_REDE UCIR "
	+ "           ON (UCI.ID_USUARIO_CONSUMO_INTERNO = "
	+ "                  UCIR.ID_USUARIO_CONSUMO_INTERNO) "
	+ "        JOIN PONTO_VENDA PV "
	+ "           ON (UCI.ID_HOTEL = PV.ID_HOTEL) "
	+ " WHERE     UCIR.ID_HOTEL = ?1 "
	+ "        AND TRUNC (UCI.DATA_INICIAL) <= PV.DATA_PV "
	+ "        AND TRUNC (UCI.DATA_FINAL) >= PV.DATA_PV ";
	
	String QRY_PONTO_VENDA_CONSUMO_COMBO = " SELECT DISTINCT "
			+ "        PV.ID_PONTO_VENDA, "
			+ "        PV.NOME_PONTO_VENDA "
			+ "   FROM USUARIOS_CONSUMO_INTERNO UCI "
			+ "        JOIN USUARIOS_CI_REDE UCIR "
			+ "           ON (UCI.ID_USUARIO_CONSUMO_INTERNO = "
			+ "                  UCIR.ID_USUARIO_CONSUMO_INTERNO) "
			+ "        JOIN PONTO_VENDA PV "
			+ "           ON (UCI.ID_HOTEL = PV.ID_HOTEL) "
			+ " WHERE     UCIR.ID_HOTEL = ?1 "
			+ "        AND TRUNC (UCI.DATA_INICIAL) <= PV.DATA_PV "
			+ "        AND TRUNC (UCI.DATA_FINAL) >= PV.DATA_PV ";
	
	String QRY_PONTO_VENDA_CONSUMO_DETALHE = " SELECT DISTINCT "
			+ "        PV.ID_PONTO_VENDA, "
			+ "        PV.NOME_PONTO_VENDA, "
			+ "        PV.DATA_PV, "
			+ "        DECODE (UCI.TIPO_PENSAO, "
			+ "                'NAO', 'Sem café da manhã', "
			+ "                'SIM', 'Com café da manhã', "
			+ "                'MAP', 'Meia pensão', "
			+ "                'FAP', 'Pensão completa', "
			+ "                'ALL', 'Tudo incluso') "
			+ "           PENSAO, "
			+ "           UCI.TIPO_PENSAO "
			+ "   FROM USUARIOS_CONSUMO_INTERNO UCI "
			+ "        JOIN USUARIOS_CI_REDE UCIR "
			+ "           ON (UCI.ID_USUARIO_CONSUMO_INTERNO = "
			+ "                  UCIR.ID_USUARIO_CONSUMO_INTERNO) "
			+ "        JOIN PONTO_VENDA PV "
			+ "           ON (UCI.ID_HOTEL = PV.ID_HOTEL) "
			+ " WHERE     UCIR.ID_HOTEL = ?1 "
			+ "        AND TRUNC (UCI.DATA_INICIAL) <= PV.DATA_PV "
			+ "        AND TRUNC (UCI.DATA_FINAL) >= PV.DATA_PV ";
	
	String QRY_PRATO_CONSUMO =" SELECT DISTINCT PR.ID_PRATO, PR.NOME_PRATO, NU.UNIDADE "
	+ "   FROM USUARIOS_CONSUMO_INTERNO UCI, "
	+ "              PRATO_PONTO_VENDA PPR "
	+ "          JOIN "
	+ "              PRATO PR "
	+ "           ON (PR.ID_PRATO = PPR.ID_PRATO) "
	+ "        JOIN "
	+ "           NFE_UNIDADE NU "
	+ "        ON (PR.ID_NFE_UNIDADE = NU.ID_NFE_UNIDADE) "
	+ " WHERE     UCI.ID_HOTEL = ?1 "
	+ "        AND PPR.ID_PONTO_VENDA = ?2 "
	+ "        AND UCI.ID_USUARIO_CONSUMO_INTERNO = ?3 "
	+ "        AND (UCI.ALCOOLICA = 'S' OR (UCI.ALCOOLICA = 'N' AND PR.FLG_ALCOOLICA = 'N'))";
	
	String QRY_PRATO_CUSTO_VENDA = " SELECT DISTINCT FTP.ID_PRATO, "
	+ "          SUM (FTP.QUANTIDADE * ME.VALOR_UNITARIO) CUSTO, "
	+ "          PR.VALOR_PRATO VENDA "
	+ "     FROM MOVIMENTO_ESTOQUE ME, "
	+ "          FICHA_TECNICA_PRATO FTP, "
	+ "          PRATO PR, "
	+ "          (  SELECT ME.ID_ITEM, MAX (ID_MOVIMENTO_ESTOQUE) ID_MOVIMENTO_ESTOQUE "
	+ "               FROM MOVIMENTO_ESTOQUE ME, FICHA_TECNICA_PRATO FTP "
	+ "              WHERE     ME.ID_ITEM = FTP.ID_ITEM "
	+ "                    AND FTP.ID_PRATO = ?1 "
	+ "                    AND ME.TIPO_MOVIMENTO IN ('E') "
	+ "           GROUP BY ME.ID_ITEM) E "
	+ "    WHERE     ME.ID_MOVIMENTO_ESTOQUE = E.ID_MOVIMENTO_ESTOQUE "
	+ "          AND ME.ID_HOTEL = ?2"
	+ "          AND ME.ID_ITEM = FTP.ID_ITEM "
	+ "          AND FTP.ID_PRATO = ?1 "
	+ "          AND FTP.ID_PRATO = PR.ID_PRATO "
	+ " GROUP BY FTP.ID_PRATO, PR.VALOR_PRATO ";

	String QRY_MOVIMENTO_CONSUMO_INTERNO = " SELECT FTP.ID_ITEM, "
	+ "          SUM (FTP.QUANTIDADE * ?1) QUANTIDADE, "
	+ "          ME.VALOR_UNITARIO, "
	+ "          SUM ( (FTP.QUANTIDADE * ?1) * ME.VALOR_UNITARIO) VALOR_TOTAL "
	+ "     FROM MOVIMENTO_ESTOQUE ME, "
	+ "          FICHA_TECNICA_PRATO FTP, "
	+ "          PRATO PR, "
	+ "          ITEM_ESTOQUE IE, "
	+ "          (  SELECT ME.ID_ITEM, MAX (ID_MOVIMENTO_ESTOQUE) ID_MOVIMENTO_ESTOQUE "
	+ "               FROM MOVIMENTO_ESTOQUE ME, FICHA_TECNICA_PRATO FTP "
	+ "              WHERE     ME.ID_ITEM = FTP.ID_ITEM "
	+ "                    AND FTP.ID_PRATO = ?2 "
	+ "                    AND ME.TIPO_MOVIMENTO IN ('E') "
	+ "           GROUP BY ME.ID_ITEM) E "
	+ "    WHERE     ME.ID_MOVIMENTO_ESTOQUE = E.ID_MOVIMENTO_ESTOQUE "
	+ "          AND ME.ID_HOTEL = ?3 "
	+ "          AND ME.ID_ITEM = FTP.ID_ITEM "
	+ "          AND FTP.ID_PRATO = ?2 "
	+ "          AND FTP.ID_PRATO = PR.ID_PRATO "
	+ "          AND FTP.ID_ITEM = IE.ID_ITEM "
	+ "          AND FTP.ID_HOTEL = IE.ID_HOTEL "
	+ "          AND IE.CONTROLADO = 'S' "
	+ " GROUP BY FTP.ID_ITEM, ME.VALOR_UNITARIO ";
	
	String QRY_AJUSTE_PDV = " SELECT  "
			+ "     me.data_movimento,  "
			+ "     ccc.descricao_centro_custo centro_custo,  "
			+ "     ir.nome_item,  "
			+ "     tipo_movimento tipo,  "
			+ "     DECODE(tipo_movimento,'A','Ajuste PDV(-)','S','Requisição(+)','R','Transf.Saida(-)','C','Cons.Interno(-)','D','Dev.Estoque(-)','T','Transf.Entrada(+)') movimento,  "
			+ "     me.num_documento,  "
			+ "     me.tipo_documento,  "
			+ "     me.quantidade,  "
			+ "     me.motivo,  "
			+ "     me.id_movimento_estoque  "
			+ " FROM  "
			+ "     movimento_estoque me  "
			+ "     JOIN controla_data cd ON ( me.id_hotel = cd.id_hotel )  "
			+ "     JOIN centro_custo_contabil ccc ON ( cd.id_rede_hotel = ccc.id_rede_hotel AND me.id_centro_custo = ccc.id_centro_custo_contabil )  "
			+ "     JOIN item_rede ir ON ( me.id_item = ir.id_item AND cd.id_rede_hotel = ir.id_rede_hotel )  "
			+ "     JOIN item_estoque ie ON ( me.id_item = ie.id_item AND me.id_hotel = ie.id_hotel )  "
			+ " WHERE  "
			+ "     me.id_hotel = ?1 "
			+ "     AND   me.tipo_movimento IN (  "
			+ "         'A',  "
			+ "         'S',  "
			+ "         'R',  "
			+ "         'C',  "
			+ "         'D',  "
			+ "         'T'  "
			+ "     )  "
			+ "     AND   ccc.controlado = 'S'  "
			+ "     AND   ie.controlado = 'S'  ";
	
	List<PratoVO> pesquisarPrato(PratoVO filtro) throws MozartSessionException;

	List<GrupoPratoEJB> obterGrupoPrato(HotelEJB hotel)
			throws MozartSessionException;

	List<TipoItemEJB> obterTipoItem(HotelEJB hotel)
			throws MozartSessionException;
	
	public List<TipoItemEJB> obterTipoItemLikeNome(HotelEJB hotel, 
			String nomeTipoItem)throws MozartSessionException;

	List<FiscalCodigoEJB> obterFiscalCodigo(HotelEJB hotel)
			throws MozartSessionException;

	List<FiscalCodigoEJB> obterFiscalCodigoCompra(HotelEJB hotel)
			throws MozartSessionException;
	
	List<FiscalCodigoVO> obterFiscalCodigos(FiscalCodigoVO filtro)
			throws MozartSessionException;

	List<FiscalIncidenciaEJB> obterFiscalIncidencias()
			throws MozartSessionException;

	List<AliquotaEJB> obterAliquota(HotelEJB hotel)
			throws MozartSessionException;

	List<ItemEstoqueVO> pesquisarItemEstoqueFichaTecnica(ItemEstoqueVO filtro)
			throws MozartSessionException;

	PratoEJB gravarProduto(PratoEJB entidade) throws MozartSessionException;
	
	List<AliquotaEJB> obterAliquota() throws MozartSessionException; 
	
	List<TransferenciaCentroCustoVO> pesquisarTransferenciaCentroCusto(TransferenciaCentroCustoVO filtro, HotelEJB hotel) throws MozartSessionException;
	
	List<UsuarioConsumoInternoVO> pesquisarConsumoInternoUsuario(UsuarioConsumoInternoVO filtro, HotelEJB hotel)throws MozartSessionException;
	
	List<HotelEJB> obterHoteis(HotelEJB hotel) throws MozartSessionException;
	
	HotelEJB obterHotelPorId(long idHotel) throws MozartSessionException;
	
	void gravarUsuarioConsumo(UsuarioConsumoInternoEJB entidade) throws MozartSessionException;
	
	List<ConsumoInternoVO> pesquisarConsumoInterno(ConsumoInternoVO filtro) throws MozartSessionException;
	
	List<ConsumoInternoVO> pesquisarComboUsuarioConsumoInterno(HotelEJB hotel) throws MozartSessionException;
	
	ConsumoInternoVO pesquisarUsuarioConsumoInternoPorId(HotelEJB hotel, long idUsuario, long idPontoVenda) throws MozartSessionException;
	
	List<PratoConsumoInternoVO> pesquisarPratoUsuarioConsumoInterno(PratoConsumoInternoVO filtro) throws MozartSessionException;
	
	PratoConsumoInternoVO pesquisarPratoValorConsumoInterno(PratoConsumoInternoVO filtro) throws MozartSessionException;
	
	List<ItemEstoqueVO> pesquisarItemEstoqueConsumoInterno(PratoConsumoInternoVO filtro) throws MozartSessionException;
	
	void salvarMovimentoCi(MovimentoCiEJB movimento) throws MozartSessionException;
	
	List<ConsumoInternoVO> pesquisarComboPontoVendaConsumoInterno(HotelEJB hotel) throws MozartSessionException;
	
	Long obterSeqMovimentoCiNextVal() throws MozartSessionException;
	
	List<AjustePdvVO> pesquisarAjustePdv(AjustePdvVO filtro, HotelEJB hotel) throws MozartSessionException;
}