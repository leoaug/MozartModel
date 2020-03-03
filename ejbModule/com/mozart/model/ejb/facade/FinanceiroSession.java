package com.mozart.model.ejb.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ClassificacaoContabilEJB;
import com.mozart.model.ejb.entity.ContaCorrenteEJB;
import com.mozart.model.ejb.entity.ContasPagarEJB;
import com.mozart.model.ejb.entity.DuplicataEJB;
import com.mozart.model.ejb.entity.DuplicataHistoricoEJB;
import com.mozart.model.ejb.entity.FornecedorHotelEJB;
import com.mozart.model.ejb.entity.HistoricoContabilEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoContabilEJB;
import com.mozart.model.ejb.entity.PlanoContaEJB;
import com.mozart.model.ejb.entity.TesourariaEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ClassificacaoContabilVO;
import com.mozart.model.vo.ContasPagarComissaoVO;
import com.mozart.model.vo.ContasPagarVO;
import com.mozart.model.vo.DuplicataVO;
import com.mozart.model.vo.RpsVO;
import com.mozart.model.vo.TesourariaVO;

@Remote
public interface FinanceiroSession {

	String QRY_DUPLICATA_TEMP = " SELECT DU.ID_DUPLICATA_TEMP, "
			+ " EM.NOME_FANTASIA, NULL NUM_DUPLICATA, STATUS_NOTA.NUM_NOTA, NUM_PARCELAS, "
			+ " DU.VALOR_DUPLICATA, DU.COMISSAO, "
			+ " DU.IR, DU.AJUSTES, DU.ENCARGOS, "
			+ " DU.DATA_VENCIMENTO,  STATUS_NOTA.DATA, "
			// TODO: (ID/Conta Corrente) 
//			+ " DU.CONTA_CORRENTE, HOTEL.SIGLA,EM.ID_EMPRESA, null banco, null SEQUENCIA_BANCARIA "
			+ " CC.NUM_CONTA_CORRENTE, HOTEL.SIGLA,EM.ID_EMPRESA, null banco, null SEQUENCIA_BANCARIA "
			+ " FROM DUPLICATA_TEMP DU, EMPRESA_REDE EM, STATUS_NOTA, "
			+ " CHECKIN, CONTROLA_DATA, HOTEL, CONTA_CORRENTE_X CC "
			+ " WHERE DU.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND EM.ID_REDE_HOTEL =  HOTEL.ID_REDE_HOTEL "
			+ " AND CONTROLA_DATA.ID_HOTEL = DU.ID_HOTEL "
			+ " AND DU.ID_NOTA = STATUS_NOTA.ID_NOTA "
			+ " AND STATUS_NOTA.ID_CHECKIN = CHECKIN.ID_CHECKIN "
			+ " AND DU.ID_CONTA_CORRENTE = CC.ID_CONTA_CORRENTE "
			+ " AND trunc(STATUS_NOTA.DATA) = trunc(CONTROLA_DATA.FATURAMENTO_CONTAS_RECEBER) "
			+ " AND DU.ID_EMPRESA = EM.ID_EMPRESA ";

	String QRY_DUPLICATA = " SELECT DU.ID_DUPLICATA, EM.NOME_FANTASIA, DU.NUM_DUPLICATA, STATUS_NOTA.NUM_NOTA, "
			+ " NUM_PARCELAS, DU.VALOR_DUPLICATA, DU.COMISSAO, DU.IR, DU.AJUSTES, "
			// TODO: (ID/Conta Corrente)
//			+ " DU.ENCARGOS, DU.DATA_VENCIMENTO, STATUS_NOTA.DATA, DU.CONTA_CORRENTE, "
			+ " DU.ENCARGOS, DU.DATA_VENCIMENTO, STATUS_NOTA.DATA, CC.NUM_CONTA_CORRENTE, "
			+ " HOTEL.SIGLA, EM.ID_EMPRESA, B.NUMERO_BANCO,  DU.SEQUENCIA_BANCARIA"
			// TODO: (ID/Conta Corrente) 
//			+ " FROM DUPLICATA DU, EMPRESA_REDE EM, STATUS_NOTA, CHECKIN, CONTROLA_DATA, CONTA_CORRENTE CC,BANCO B, HOTEL "
			+ " FROM DUPLICATA DU, EMPRESA_REDE EM, STATUS_NOTA, CHECKIN, CONTROLA_DATA, CONTA_CORRENTE_X CC,BANCO B, HOTEL "
			+ " WHERE DU.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND CONTROLA_DATA.ID_HOTEL = DU.ID_HOTEL "
			+ " AND EM.ID_REDE_HOTEL = HOTEL.ID_REDE_HOTEL "
			+ " AND DU.ID_NOTA = STATUS_NOTA.ID_NOTA "
			// TODO: (ID/Conta Corrente) 
//			+ " AND CC.CONTA_CORRENTE = DU.CONTA_CORRENTE "
			+ " AND CC.ID_CONTA_CORRENTE = DU.ID_CONTA_CORRENTE "
			+ " AND CC.ID_HOTEL = DU.ID_HOTEL "
			+ " AND B.ID_BANCO = CC.ID_BANCO "
			+ " AND STATUS_NOTA.ID_CHECKIN = CHECKIN.ID_CHECKIN "
			+ " AND trunc(STATUS_NOTA.DATA) = trunc(CONTROLA_DATA.FATURAMENTO_CONTAS_RECEBER) "
			+ " AND DU.ID_EMPRESA = EM.ID_EMPRESA ";

	String QRY_DUPLICATA_COMBO = " SELECT DU.ID_DUPLICATA, EM.NOME_FANTASIA, DU.NUM_DUPLICATA, STATUS_NOTA.NUM_NOTA, "
			+ " NUM_PARCELAS, DU.VALOR_DUPLICATA, DU.COMISSAO, DU.IR, DU.AJUSTES, "
			// TODO: (ID/Conta Corrente)
//			+ " DU.ENCARGOS, DU.DATA_VENCIMENTO, STATUS_NOTA.DATA, DU.CONTA_CORRENTE, "
			+ " DU.ENCARGOS, DU.DATA_VENCIMENTO, STATUS_NOTA.DATA, CC.NUM_CONTA_CORRENTE, "
			+ " HOTEL.SIGLA, EM.ID_EMPRESA, B.NUMERO_BANCO, DU.SEQUENCIA_BANCARIA "
			// TODO: (ID/Conta Corrente) 
//			+ " FROM DUPLICATA DU, EMPRESA_REDE EM, STATUS_NOTA, CHECKIN, CONTROLA_DATA, CONTA_CORRENTE CC,BANCO B, HOTEL "
			+ " FROM DUPLICATA DU, EMPRESA_REDE EM, STATUS_NOTA, CHECKIN, CONTROLA_DATA, CONTA_CORRENTE_X CC,BANCO B, HOTEL "
			+ " WHERE DU.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND CONTROLA_DATA.ID_HOTEL = DU.ID_HOTEL "
			+ " AND EM.ID_REDE_HOTEL = HOTEL.ID_REDE_HOTEL "
			+ " AND DU.ID_NOTA = STATUS_NOTA.ID_NOTA "
			// TODO: (ID/Conta Corrente) 
//			+ " AND CC.CONTA_CORRENTE = DU.CONTA_CORRENTE "
			+ " AND CC.ID_CONTA_CORRENTE = DU.ID_CONTA_CORRENTE "
			+ " AND B.ID_BANCO = CC.ID_BANCO "
			+ " AND CC.ID_HOTEL = DU.ID_HOTEL "
			+ " AND STATUS_NOTA.ID_CHECKIN = CHECKIN.ID_CHECKIN "
			+ " AND DU.ID_EMPRESA = EM.ID_EMPRESA AND DU.IMPRIMIR = 'S' ";

	String QRY_CONTAS_RECEBER = "SELECT  "
			+ " DU.ID_DUPLICATA, HOTEL.SIGLA, ER.NOME_FANTASIA, RTRIM(LTRIM(DU.NUM_DUPLICATA || '-' || DU.NUM_PARCELAS || '-' || SUBSTR(DU.ANO,3,2))) AS DUP, "
			+ " DU.VALOR_DUPLICATA, DU.DATA_LANCAMENTO, DU.DATA_VENCIMENTO, DU.DATA_DESCONTO, DU.DATA_RECEBIMENTO, "
			+ " DU.PRORROGADO, DU.DATA_RECOMPRA, DU.COMISSAO, DU.IR, DU.AJUSTES, DU.ENCARGOS, "
			+ " (NVL(DU.PIS, 0) - NVL(DU.COFINS, 0)- NVL(DU.ISS, 0) - NVL(DU.IR_RETENCAO, 0) - NVL(DU.CSSL, 0)) AS RETENCOES, "
			+ " DU.DESCONTO_RECEBIMENTO, DU.ID_DUPLICATA_DESCONTADA NUM_LOTE, "
//			+ " DU.AGRUPAR,((DU.VALOR_DUPLICATA + NVL(DU.IR, 0) - NVL(DU.COMISSAO, 0)- NVL(DU.AJUSTES, 0) - NVL(DU.ENCARGOS, 0))) VR_LIQUIDO, DU.CONTA_CORRENTE, DU.JUROS_RECEBIMENTO, DU.COFINS, DU.PIS, DU.CSSL, DU.ISS, DU.JUSTIFICA_AJUSTE, DU.VALOR_RECEBIDO, er.id_empresa, du.id_plano_contas, du.id_centro_custo_contabil, DU.DESP_FINANCEIRA,NVL(DU.IR_RETENCAO, 0), B.NUMERO_BANCO||'-'||B.BANCO BANCO   "
			+ " DU.AGRUPAR,((DU.VALOR_DUPLICATA + NVL(DU.IR, 0) - NVL(DU.COMISSAO, 0)- NVL(DU.AJUSTES, 0) - NVL(DU.ENCARGOS, 0))) VR_LIQUIDO, CC.NUM_CONTA_CORRENTE, DU.JUROS_RECEBIMENTO, DU.COFINS, DU.PIS, DU.CSSL, DU.ISS, DU.JUSTIFICA_AJUSTE, DU.VALOR_RECEBIDO, er.id_empresa, du.id_plano_contas, du.id_centro_custo_contabil, DU.DESP_FINANCEIRA,NVL(DU.IR_RETENCAO, 0), B.NUMERO_BANCO||'-'||B.BANCO BANCO,   "
			+ " CC.ID_CONTA_CORRENTE "
//			+ " FROM DUPLICATA DU, EMPRESA_REDE ER, HOTEL, CONTROLA_DATA CD, CONTA_CORRENTE_X CC, BANCO B "
			+ " FROM DUPLICATA DU, EMPRESA_REDE ER, HOTEL, CONTROLA_DATA CD, CONTA_CORRENTE CC, BANCO B "
			+ " WHERE DU.ID_CONTA_CORRENTE = CC.ID_CONTA_CORRENTE AND DU.ID_HOTEL = CC.ID_HOTEL"
			+ " AND CC.ID_BANCO = B.ID_BANCO AND DU.ID_HOTEL = CD.ID_HOTEL "
			+ " AND DU.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND DU.ID_EMPRESA = ER.ID_EMPRESA "
			+ " AND DU.SITUACAO LIKE ?1 "
			+ " AND ER.ID_REDE_HOTEL = HOTEL.ID_REDE_HOTEL "
			+ " AND TRUNC(DU.DATA_LANCAMENTO) <= TRUNC(CD.CONTAS_RECEBER) ";

	String QRY_CONTAS_PAGAR = " SELECT /*+INDEX(FR PK_FORNECEDOR_REDE)*/ "
			+ "   CP.ID_CONTAS_PAGAR, HOTEL.SIGLA, FR.NOME_FANTASIA, CP.NUM_DOCUMENTO || '-' || CP.NUM_PARCELAS AS DOCUMENTO, "
			+ " 	CP.DATA_PAGAMENTO, CP.DATA_VENCIMENTO, CP.DATA_LANCAMENTO, CP.PRORROGACAO, "
			+ " 	NVL(CP.VALOR_BRUTO,0) VALOR_BRUTO, NVL(CP.JUROS,0) JUROS, NVL(CP.DESCONTO,0) DESCONTO, (NVL(CP.VALOR_BRUTO,0) + NVL(CP.JUROS,0) -NVL(CP.DESCONTO,0))AS VALOR_LIQUIDO, "
			+ " 	CP.VALOR_PAGAMENTO, CP.NUM_CHEQUE, CP.TIPO_DOCUMENTO, CP.SERIE_DOCUMENTO, CP.SITUACAO, "
//			+ " 	CP.CONTA_CORRENTE, CP.INTERNET, CP.OBSERVACAO, FR.ID_FORNECEDOR, CP.ID_CENTRO_CUSTO_CONTABIL_DESC, CP.ID_PLANO_CONTAS_DEBITO_DESC, CP.JUSTIFICATIVA_DESC "
			+ " 	CC.NUM_CONTA_CORRENTE, CP.INTERNET, CP.OBSERVACAO, FR.ID_FORNECEDOR, CP.ID_CENTRO_CUSTO_CONTABIL_DESC, CP.ID_PLANO_CONTAS_DEBITO_DESC, CP.JUSTIFICATIVA_DESC, "
			+ " 	CC.ID_CONTA_CORRENTE, "
			+ " 	CP.ARQUIVO_IMAGEM, "
			+ " 	CP.ARQUIVO_NOME "
			+ " 	FROM CONTAS_PAGAR CP, FORNECEDOR_REDE FR, CONTROLA_DATA CD, HOTEL, CONTA_CORRENTE_X CC "
			+ " 	WHERE CP.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " 	AND CD.ID_HOTEL = CP.ID_HOTEL "
			+ " 	AND CP.ID_FORNECEDOR = FR.ID_FORNECEDOR "
			+ " 	AND CP.ID_REDE_HOTEL = FR.ID_REDE_HOTEL "
			+ " 	AND CP.ID_CONTA_CORRENTE = CC.ID_CONTA_CORRENTE "
			+ " 	AND CP.PAGO LIKE ?1 "
			+ " 	AND TRUNC(CP.DATA_LANCAMENTO) <= TRUNC(CD.CONTAS_PAGAR) ";

	// TODO: (ID/Conta Corrente) 
//	String QRY_TESOURARIA = " SELECT TESOURARIA.ID_TESOURARIA, HOTEL.SIGLA, BANCO.BANCO||'-'|| TESOURARIA.CONTA_CORRENTE NOMBAN, "
	String QRY_TESOURARIA = " SELECT TESOURARIA.ID_TESOURARIA, HOTEL.SIGLA, BANCO.BANCO||'-'|| TESOURARIA.ID_CONTA_CORRENTE NOMBAN, "
			// TODO: (ID/Conta Corrente) 
//			+ " TESOURARIA.CONTA_CORRENTE, TESOURARIA.DATA_LANCAMENTO,  TESOURARIA.VALOR, DECODE(TESOURARIA.DEBITO_CREDITO,'D','Débito','Crédito') DEBITO_CREDITO, "
			+ " CC.NUM_CONTA_CORRENTE, TESOURARIA.DATA_LANCAMENTO,  TESOURARIA.VALOR, DECODE(TESOURARIA.DEBITO_CREDITO,'D','Débito','Crédito') DEBITO_CREDITO, "
			+ " DECODE(TESOURARIA.CONCILIADO,'N','Não','Sim') CONCILIADO, TESOURARIA.DATA_CONCILIADO, tesouraria.COMPLEMENTO_HISTORICO NUM_DOCUMENTO, "
			+ " HISTORICO_CONTABIL.HISTORICO "
			// TODO: (ID/Conta Corrente) 
//			+ " FROM TESOURARIA, PLANO_CONTAS, BANCO, CONTA_CORRENTE, HISTORICO_CONTABIL, SALDO_TESOURARIA, HOTEL, CONTROLA_DATA "
			+ " FROM TESOURARIA, PLANO_CONTAS, BANCO, CONTA_CORRENTE_X CC, HISTORICO_CONTABIL, SALDO_TESOURARIA, HOTEL, CONTROLA_DATA "
			+ " WHERE TESOURARIA.ID_PLANO_CONTAS = PLANO_CONTAS.ID_PLANO_CONTAS "
			+ " AND TESOURARIA.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND CONTROLA_DATA.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND PLANO_CONTAS.ID_REDE_HOTEL = HOTEL.ID_REDE_HOTEL "
			// TODO: (ID/Conta Corrente) 
//			+ " AND CONTA_CORRENTE.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND CC.ID_HOTEL = HOTEL.ID_HOTEL "
			+ " AND HISTORICO_CONTABIL.ID_REDE_HOTEL = HOTEL.ID_REDE_HOTEL "
			+ " AND SALDO_TESOURARIA.ID_HOTEL = HOTEL.ID_HOTEL "
			// TODO: (ID/Conta Corrente) 
//			+ " AND (CONTA_CORRENTE.ID_CONTABIL_REC = PLANO_CONTAS.ID_PLANO_CONTAS OR CONTA_CORRENTE.ID_CONTABIL_PAG = PLANO_CONTAS.ID_PLANO_CONTAS) "
			+ " AND (CC.ID_CONTABIL_REC = PLANO_CONTAS.ID_PLANO_CONTAS OR CC.ID_CONTABIL_PAG = PLANO_CONTAS.ID_PLANO_CONTAS) "
			// TODO: (ID/Conta Corrente) 
//			+ " AND BANCO.ID_BANCO = CONTA_CORRENTE.ID_BANCO "
			+ " AND BANCO.ID_BANCO = CC.ID_BANCO "
			// TODO: (ID/Conta Corrente) 
//			+ " AND TESOURARIA.CONTA_CORRENTE = SALDO_TESOURARIA.CONTA_CORRENTE "
			+ " AND TESOURARIA.ID_CONTA_CORRENTE = SALDO_TESOURARIA.ID_CONTA_CORRENTE "
			// TODO: (ID/Conta Corrente) 
//			+ " AND CONTA_CORRENTE.CONTA_CORRENTE = TESOURARIA.CONTA_CORRENTE "
			+ " AND CC.ID_CONTA_CORRENTE = TESOURARIA.ID_CONTA_CORRENTE "
			+ " AND TESOURARIA.ID_HISTORICO = HISTORICO_CONTABIL.ID_HISTORICO "
			+ " AND SALDO_TESOURARIA.MES = 12 "
			+ " AND SALDO_TESOURARIA.ANO = TO_NUMBER(TO_CHAR(CONTROLA_DATA.TESOURARIA,'yyyy'))-1 "
			+ " AND TESOURARIA.VALOR <> 0 "
			+ " AND ((TRUNC(TESOURARIA.DATA_LANCAMENTO) BETWEEN TRUNC(CONTROLA_DATA.TESOURARIA, 'MONTH') AND LAST_DAY(CONTROLA_DATA.TESOURARIA)) OR "
			// TODO: (ID/Conta Corrente) 
//			+ " (TRUNC(TESOURARIA.DATA_LANCAMENTO) <= LAST_DAY(CONTROLA_DATA.TESOURARIA) AND TESOURARIA.CONCILIADO = 'N' AND CONTA_CORRENTE.CARTEIRA = 'N'))";
			+ " (TRUNC(TESOURARIA.DATA_LANCAMENTO) <= LAST_DAY(CONTROLA_DATA.TESOURARIA) AND TESOURARIA.CONCILIADO = 'N' AND CC.CARTEIRA = 'N'))";

	
	public static String QRY_STATUS_NOTA = "SELECT SN.id_nota, H.cgc, H.insc_municipal, SN.nota_inicial, SN.serie, '1' TIPO,"  
       + " To_char(SN.data, 'YYYY/MM/DD') DataEmissao, Decode(SN.status, 'OK', 1, 2) Status, '1' NaturezaOperacao, Decode (H.id_fiscal_regime_tributario, 1, 1, 2) OptanteSimplesNacional,"
       + " Decode(H.incentivo_fiscal_iss, 'S', 1, 2) IncentivoCultura, SN.base_calculo ValorServicos, 0 ValorDeducoes, SN.pis ValorPis, SN.cofins ValorCofins, " 
       + "SN.inss ValorInss, SN.ir_retencao ValorIr, SN.csll ValorCsll, SN.iss_retido IssRetido, SN.iss ValorIss, SN.outras_retencoes OutrasRetencoes, SN.aliquota_iss Aliquota, " 
       + " '0.00' DescontoIncondicionado,  '0.00' DescontoCondicionado, To_char(Replace(FLS.codigo, '.')) ItemListaServico, H.codigo_servico CodigoTributacaoMunicipio, " 
       + " 'Hospedagem' Discriminacao, C_DO_HOTEL.codigo_ibge CodigoMunicipio, Decode(quem_paga, 'E', E.cgc, HO.cpf) CpfCnpjTomador, Decode(quem_paga, 'E', E.endereco, HO.endereco) EnderecoTomador, " 
       + " Decode(quem_paga, 'E', E.numero, HO.numero) NumeroTomador, Decode(quem_paga, 'E', E.complemento, HO.complemento) ComplementoTomador, Decode(quem_paga, 'E', E.bairro, HO.bairro) BairroTomador, " 
       + " Decode(quem_paga, 'E', C_DA_EMPRESA.codigo_ibge, C_DO_HOSPEDE.codigo_ibge)      CodigoMunicipioTomador, Decode(quem_paga, 'E', UF_DA_EMPRESA.uf, UF_DO_HOSPEDE.uf) UFTomador, " 
       + " Decode(quem_paga, 'E', To_char(Replace(E.cep, '-')), To_char(Replace(HO.cep, '-'))) CepTomador, Decode(quem_paga, 'E', ER.email, HO.email) EMAILtomador FROM   status_nota SN " 
       + " JOIN hotel H ON ( SN.id_hotel = H.id_hotel ) JOIN cidade C_DO_HOTEL ON ( H.id_cidade = C_DO_HOTEL.id_cidade ) " 
       + " JOIN fiscal_lista_servicos FLS ON ( H.id_fiscal_lista_servicos = FLS.id_fiscal_lista_servicos ) " 
       + " JOIN empresa E ON ( SN.id_empresa = E.id_empresa ) JOIN empresa_rede ER ON( SN.id_empresa = ER.id_empresa AND H.id_rede_hotel = ER.id_rede_hotel ) " 
       + " JOIN hospede HO ON ( SN.id_hospede = HO.id_hospede ) JOIN cidade C_DO_HOSPEDE ON ( H.id_cidade = C_DO_HOSPEDE.id_cidade ) " 
       + " JOIN estado UF_DO_HOSPEDE ON ( C_DO_HOSPEDE.id_estado = UF_DO_HOSPEDE.id_estado ) JOIN cidade C_DA_EMPRESA ON ( E.id_cidade = C_DA_EMPRESA.id_cidade ) " 
       + " JOIN estado UF_DA_EMPRESA ON ( C_DA_EMPRESA.id_estado = UF_DA_EMPRESA.id_estado ) WHERE  SN.id_hotel = ?1 " 
       + " AND SN.data = To_date(?2, 'YYYY-MM-DD') AND tipo_nota = 'F' ORDER  BY num_nota " ;
	 
	public static String QRY_STATUS_NOTA_POR_ID = " SELECT  SN.ID_NOTA, H.CGC Cnpj, H.INSC_MUNICIPAL InscricaoMunicipal, SN.NOTA_INICIAL Numero, SN.SERIE Serie, '1' Tipo, "
		+ " TO_CHAR(SN.DATA_EMISSAO,'YYYY-MM-DD') DataEmissao, DECODE(SN.STATUS,'OK',1,2) Status, '1' NaturezaOperacao, TO_CHAR(SN.DATA_EMISSAO,'YYYY-MM-DD') Competencia, "
		+ " SN.BASE_CALCULO ValorServicos, SN.PIS ValorPis, SN.COFINS ValorCofins, SN.INSS ValorInss, SN.IR_RETENCAO ValorIr, SN.CSLL ValorCsll, "
		+ " SN.OUTRAS_RETENCOES OutrasRetencoes, SN.ISS ValorIss, SN.ALIQUOTA_ISS Aliquota, DECODE(SN.ISS_RETIDO,NULL,2,1) IssRetido, "
		+ " DECODE(SN.ISS_RETIDO,NULL,0,1) ResponsavelRetencao, FLS.CODIGO ItemListaServico, To_char(Replace(Replace(H.CNAE , '-'), '.')) CodigoCnae, "
		+ " TRIM('Serviços prestados para: ' ||HO.NOME_HOSPEDE||' '||HO.SOBRENOME_HOSPEDE|| ' - ' ||'Período de '|| ck.data_entrada||' a '|| CK.DATA_SAIDA || ' nh: '|| SN.NUM_NOTA ) Discriminacao, "
		+ " C_DO_HOTEL.CODIGO_IBGE CodigoMunicipio, '1' ExigibilidadeISS,  H.SENHA Senha, H.FRASE_SECRETA,  "
		+ " DECODE(SN.QUEM_PAGA,'E', E.CGC,HO.CPF) CpfCnpjTomador,  DECODE(SN.QUEM_PAGA,'E', E.INSC_MUNICIPAL) InscricaoMunicipalTomador,  "
		+ " DECODE(SN.QUEM_PAGA,'E', E.RAZAO_SOCIAL, TRIM(HO.NOME_HOSPEDE || ' ' ||HO.SOBRENOME_HOSPEDE)) RazaoSocialTomador, "
		+ " DECODE(SN.QUEM_PAGA,'E', E.ENDERECO, HO.ENDERECO) EnderecoTomador, DECODE(SN.QUEM_PAGA,'E', E.NUMERO, HO.NUMERO) NumeroTomador, "
		+ " DECODE(SN.QUEM_PAGA,'E', E.COMPLEMENTO, HO.COMPLEMENTO) ComplementoTomador,  DECODE(SN.QUEM_PAGA,'E', E.BAIRRO, HO.BAIRRO) BairroTomador,  "
		+ " DECODE(SN.QUEM_PAGA,'E', C_DA_EMPRESA.CODIGO_IBGE, C_DO_HOSPEDE.CODIGO_IBGE) CodigoMunicipioTomador, "
		+ " DECODE(SN.QUEM_PAGA,'E', UF_DA_EMPRESA.UF, UF_DO_HOSPEDE.UF) UFTomador,  DECODE(SN.QUEM_PAGA,'E', TO_CHAR(REPLACE(E.CEP,'-')), TO_CHAR(REPLACE(HO.CEP,'-'))) CepTomador, "
		+ " DECODE(SN.QUEM_PAGA,'E', P_DA_EMPRESA.PAIS, P_DO_HOSPEDE.PAIS) PaisTomador, "
		+ " DECODE(SN.QUEM_PAGA,'E', ER.EMAIL, HO.EMAIL) EmailTomador,   '6' RegimeEspecialTributacao,  "
		+ " DECODE (H.ID_FISCAL_REGIME_TRIBUTARIO,1,1,2) OptanteSimplesNacional,   DECODE(H.INCENTIVO_FISCAL_ISS, 'S',1,2) IncentivoCultura,  '2' Producao "
		+ " FROM STATUS_NOTA SN JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL)  JOIN CHECKIN CK ON (SN.ID_CHECKIN = CK.ID_CHECKIN)  "
		+ " JOIN CIDADE C_DO_HOTEL ON (H.ID_CIDADE = C_DO_HOTEL.ID_CIDADE)  JOIN FISCAL_LISTA_SERVICOS FLS ON (H.ID_FISCAL_LISTA_SERVICOS = FLS.ID_FISCAL_LISTA_SERVICOS)  "
		+ " JOIN FISCAL_SERV_MUN FSM ON(H.ID_FISCAL_SERV_MUN = FSM.ID_FISCAL_SERV_MUN) JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA)  "
		+ " JOIN HOSPEDE HO ON (SN.ID_HOSPEDE = HO.ID_HOSPEDE)  LEFT OUTER JOIN CIDADE C_DO_HOSPEDE ON (HO.ID_CIDADE = C_DO_HOSPEDE.ID_CIDADE)  "
		+ " LEFT OUTER JOIN ESTADO UF_DO_HOSPEDE ON (C_DO_HOSPEDE.ID_ESTADO = UF_DO_HOSPEDE.ID_ESTADO) LEFT OUTER JOIN PAIS P_DO_HOSPEDE ON (P_DO_HOSPEDE.CODPAIS = UF_DO_HOSPEDE.CODPAIS) "
		+ " JOIN CIDADE C_DA_EMPRESA ON (E.ID_CIDADE = C_DA_EMPRESA.ID_CIDADE) JOIN ESTADO UF_DA_EMPRESA ON (C_DA_EMPRESA.ID_ESTADO = UF_DA_EMPRESA.ID_ESTADO) "
		+ " JOIN PAIS P_DA_EMPRESA ON (P_DA_EMPRESA.CODPAIS = UF_DA_EMPRESA.CODPAIS) JOIN EMPRESA_REDE ER ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND SN.ID_EMPRESA = ER.ID_EMPRESA)  "
		+ " WHERE TIPO_NOTA = 'F' ";

	public static String QRY_CONTAS_PAGAR_COMISSAO = "SELECT UNIQUE MAX(TBL.ID_MOVIMENTO_APARTAMENTO) ID_MOVIMENTO_APARTAMENTO, TBL.DATA_LANCAMENTO, TBL.ID_CONTAS_PAGAR,"    
		+ " TBL.VALOR_LANCAMENTO, TBL.NOME_FANTASIA, TBL.ID_EMPRESA, TBL.PRAZO_PAGAMENTO, TBL.COMISSAO, TBL.ID_NOTA, TBL.NOME_HOSPEDE, TBL.NUM_NOTA, TBL.ID_CONTA_CORRENTE," 
        + " TBL.SIGLA, TBL.ID_PLANO_CONTAS_CREDITO, TBL.ID_CENTRO_CUSTO_CREDITO, TBL.ID_PLANO_CONTAS_DEBITO, TBL.ID_CENTRO_CUSTO_DEBITO, TBL.ID_HISTORICO_CREDITO," 
        + " TBL.ID_HISTORICO_DEBITO, TBL.ID_PLANO_CONTAS_FINANCEIRO"
        + " FROM (SELECT MA.ID_MOVIMENTO_APARTAMENTO, MA.DATA_LANCAMENTO, MA.ID_CONTAS_PAGAR, sum (MA2.VALOR_LANCAMENTO) VALOR_LANCAMENTO, ER.NOME_FANTASIA," 
        + " ER.ID_EMPRESA, EH.COMISSAO, MA.ID_NOTA, RL.NOME_HOSPEDE, SN.NUM_NOTA, TL.DESCRICAO_LANCAMENTO, CC.ID_CONTA_CORRENTE, HO.SIGLA, CB_C.ID_PLANO_CONTAS_CREDITO," 
        + " CB_C.ID_CENTRO_CUSTO_CREDITO, CB_D.ID_PLANO_CONTAS_DEBITO, CB_D.ID_CENTRO_CUSTO_DEBITO, PC_C.ID_HISTORICO_CREDITO, PC_D.ID_HISTORICO_DEBITO," 
        + " ch.id_checkin, EH.PRAZO_PAGAMENTO, CB_C.ID_PLANO_CONTAS_FINANCEIRO"
        + " FROM MOVIMENTO_APARTAMENTO MA  "
        + " JOIN TIPO_LANCAMENTO TL ON (TL.ID_TIPO_LANCAMENTO = MA.ID_TIPO_LANCAMENTO )" 
        + " JOIN IDENTIFICA_LANCAMENTO IL ON (TL.ID_IDENTIFICA_LANCAMENTO = IL.ID_IDENTIFICA_LANCAMENTO AND IL.RECEITA_CHECKOUT = 2)" 
        + " JOIN MOVIMENTO_APARTAMENTO MA2 ON (MA2.ID_NOTA = MA.ID_NOTA AND MA2.ID_HOTEL IN (?1) )" 
        + " JOIN TIPO_LANCAMENTO TL2 ON (TL2.ID_TIPO_LANCAMENTO = MA2.ID_TIPO_LANCAMENTO AND TL2.ID_IDENTIFICA_LANCAMENTO IN (2,3,26,28) )" 
        + " JOIN CHECKIN CH ON (MA.ID_CHECKIN = CH.ID_CHECKIN)" 
        + " JOIN STATUS_NOTA SN ON (MA.ID_NOTA = SN.ID_NOTA)" 
        + " JOIN CONTROLA_DATA CD ON ( MA.ID_HOTEL = CD.ID_HOTEL)" 
        + " JOIN (  SELECT RL.ID_CHECKIN, MIN(HO.NOME_HOSPEDE || ' '|| HO.SOBRENOME_HOSPEDE) NOME_HOSPEDE" 
        + " FROM  ROOM_LIST RL" 
        + " JOIN HOSPEDE HO ON (HO.ID_HOSPEDE = RL.ID_HOSPEDE)"  
        + " GROUP BY ID_CHECKIN) RL ON (RL.ID_CHECKIN = CH.ID_CHECKIN)"  
        + " JOIN HOTEL HO ON (MA.ID_HOTEL = HO.ID_HOTEL) "
        + " JOIN EMPRESA_HOTEL EH ON (EH.ID_EMPRESA = CH.ID_EMPRESA AND EH.COMISSAO > 0 AND EH.ID_HOTEL IN (?2)) "
        + " JOIN EMPRESA_REDE ER ON (ER.ID_EMPRESA = EH.ID_EMPRESA AND ER.ID_REDE_HOTEL = HO.ID_REDE_HOTEL) "
        + " JOIN CONTA_CORRENTE CC ON(EH.ID_HOTEL = CC.ID_HOTEL AND CC.PAGAMENTO = 'S') "
        + " LEFT JOIN CLASSIFICACAO_CONTABIL CB_C ON (EH.ID_HOTEL = CB_C.ID_HOTEL AND CB_C.DESCRICAO = 'PAG_FOR') "
        + " LEFT JOIN CLASSIFICACAO_CONTABIL CB_D ON (EH.ID_HOTEL = CB_D.ID_HOTEL AND CB_D.DESCRICAO = 'PAG_COM') "
        + " LEFT JOIN PLANO_CONTAS PC_C ON(CB_C.ID_PLANO_CONTAS_CREDITO = PC_C.ID_PLANO_CONTAS AND PC_C.ID_REDE_HOTEL = ER.ID_REDE_HOTEL) "
        + " LEFT JOIN PLANO_CONTAS PC_D ON(CB_D.ID_PLANO_CONTAS_DEBITO = PC_D.ID_PLANO_CONTAS)  "
        + " WHERE MA.ID_HOTEL IN (?3)  "
        + " AND MA.CHECKOUT = 'S' "
		+ " AND TL.ID_IDENTIFICA_LANCAMENTO <> 18 ";

	
	List<DuplicataVO> pesquisarDuplicata(DuplicataVO filtro)
			throws MozartSessionException;

	void gerarUnificarDuplicata(HotelEJB hotel, Long[] idDuplicata,
			String string) throws MozartSessionException;

	void gravarParcelamento(DuplicataEJB entidade, List<DuplicataEJB> parcelas)
			throws MozartSessionException;

	void encerrarFaturamento(HotelEJB hotel) throws MozartSessionException;

	@SuppressWarnings({ "rawtypes" })
	List obterValidacao(Long pIdHotel) throws MozartSessionException;

	List<DuplicataVO> pesquisarContasReceber(DuplicataVO filtro)
			throws MozartSessionException;

	void receberDuplicatas(DuplicataVO rec, List<DuplicataVO> listaRecebimento)
			throws MozartSessionException;

	void descontarDuplicatas(DuplicataVO rec, List<DuplicataVO> listaDesconto)
			throws MozartSessionException;

	void encerrarContasReceber(HotelEJB hotel) throws MozartSessionException;

	List<ContasPagarVO> pesquisarContasPagar(ContasPagarVO filtro)
			throws MozartSessionException;
	
	List<ContasPagarComissaoVO> pesquisarContasPagarComissao(ContasPagarComissaoVO filtro)
			throws MozartSessionException;

	List<FornecedorHotelEJB> obterFornecedorLookup(FornecedorHotelEJB pFiltro)
			throws MozartSessionException;

	List<HistoricoContabilEJB> obterHistoricoContabil(
			HistoricoContabilEJB filtro) throws MozartSessionException;

	List<ClassificacaoContabilVO> obterClassificacaoContabil(
			ClassificacaoContabilVO filtro) throws MozartSessionException;

	void gravarContasPagar(ContasPagarEJB entidadeCP,
			DuplicataHistoricoEJB entidadeHistorico)
			throws MozartSessionException;

	ContasPagarEJB obterContasPagar(ContasPagarEJB entidadeCP)
			throws MozartSessionException;

	String obterProximoContasPagar(HotelEJB hotel)
			throws MozartSessionException;

	void pagarTitulos(ContasPagarVO rec, List<ContasPagarVO> listaPagamento)
			throws MozartSessionException;

	void gravarParcelamento(ContasPagarEJB entidadeCP,
			List<ContasPagarEJB> parcelasCP) throws MozartSessionException;

	void encerrarContasPagar(HotelEJB hotel) throws MozartSessionException;

	@SuppressWarnings("rawtypes")
	List obterValidacaoEncerramentoContasPagar(Long idHotel)
			throws MozartSessionException;

	List<TesourariaVO> pesquisarTesouraria(TesourariaVO filtro)
			throws MozartSessionException;

	List<ContaCorrenteEJB> obterContaCorrentePorPlanoContas(PlanoContaEJB filtro)
			throws MozartSessionException;

	void gravarTesouraria(HotelEJB hotel, List<TesourariaEJB> tesourariaList,
			List<MovimentoContabilEJB> movimentoSemTesourariaList,
			String origemMovimento) throws MozartSessionException;

	List<ClassificacaoContabilEJB> obterClassificacaoContabilPadrao(
			ClassificacaoContabilEJB filtro) throws MozartSessionException;

	void conciliarTesouraria(TesourariaVO filtro,
			List<TesourariaVO> listaConciliacao) throws MozartSessionException;

	void encerrarTesouraria(HotelEJB hotel) throws MozartSessionException;
	
	List<RpsVO> obterListaDeRps(int idHotel, Date data) throws MozartSessionException;
	List<RpsVO> obterListaDeRps(List<String> rps) throws MozartSessionException;
}
