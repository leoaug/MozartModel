package com.mozart.model.ejb.facade;

import javax.ejb.Remote;
import javax.inject.Named;

import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.EstadoEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MensagemWebEJB;
import com.mozart.model.ejb.entity.MensagemWebUsuarioEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.AchadosPerdidoVO;
import com.mozart.model.vo.BancoVO;
import com.mozart.model.vo.CidadeVO;
import com.mozart.model.vo.ConfiguracaoTributarioVO;
import com.mozart.model.vo.ControlaDataVO;
import com.mozart.model.vo.EmpresaVO;
import com.mozart.model.vo.ExigibilidadeVO;
import com.mozart.model.vo.HospedeAchadosPerdidoVO;
import com.mozart.model.vo.HotelVO;
//import com.mozart.model.vo.ListaFiscalServicoVO;
import com.mozart.model.vo.MensagemWebUsuarioVO;
import com.mozart.model.vo.MensagemWebVO;
import com.mozart.model.vo.NotaFiscalVO;
import com.mozart.model.vo.RedeHotelVO;
import com.mozart.model.vo.RegimeTributarioVO;
import com.mozart.model.vo.UsuarioVO;

import java.util.List;

@Remote
@Named
public interface SistemaSession {

	String QRY_PROCEDENCIA 	 = " SELECT ID_CIDADE, CIDADE, ESTADO, UF, PAIS, DESCRICAO, DDI, DDD FROM V_CIDADE WHERE 1=1 ";
	String QRY_BANCO 		 = " SELECT ID_BANCO, NUMERO_BANCO, BANCO, NOME_FANTASIA FROM BANCO WHERE 1=1 ";
	// TODO: (ID/Conta Corrente)
//	String QRY_BANCO_HOTEL 	 = " SELECT B.ID_BANCO, B.NUMERO_BANCO, B.BANCO, B.NOME_FANTASIA FROM BANCO B, CONTA_CORRENTE C WHERE B.ID_BANCO = C.ID_BANCO AND C.ID_HOTEL = ?1 ORDER BY B.BANCO ";
	String QRY_BANCO_HOTEL 	 = " SELECT B.ID_BANCO, B.NUMERO_BANCO, B.BANCO, B.NOME_FANTASIA FROM BANCO B, CONTA_CORRENTE_X C WHERE B.ID_BANCO = C.ID_BANCO AND C.ID_HOTEL = ?1 ORDER BY B.BANCO ";
	String QRY_MENSAGEM 	 = "SELECT M.ID_MENSAGEM, M.TITULO, M.DATA_CRIACAO, DECODE(M.NIVEL, 1, 'Normal', 2, 'Médio', 3, 'Urgente')NIVEL, null NOME_USUARIO, NULL DATA_RESPOSTA, NULL NOME_HOTEL, NULL RESPOSTA, SUBSTR(UC.NICK,8) CRIACAO FROM MENSAGEM_WEB M, USUARIO UC WHERE M.ID_USUARIO = UC.ID_USUARIO AND UC.ID_USUARIO = NVL(?1,UC.ID_USUARIO) ";
	String QRY_MENSAGEM_FULL = " SELECT M.ID_MENSAGEM, M.TITULO, M.DATA_CRIACAO, DECODE(M.NIVEL, 1, 'Normal', 2, 'Médio', 3, 'Urgente')NIVEL, SUBSTR(U.NICK,8) NICK, MU.DATA_RESPOSTA, H.NOME_FANTASIA, MU.RESPOSTA, SUBSTR(UC.NICK,8) CRIACAO "+
							   " FROM MENSAGEM_WEB M, MENSAGEM_WEB_USUARIO MU, USUARIO U, HOTEL H, USUARIO UC "+
							   " WHERE UC.ID_USUARIO = NVL(?1, UC.ID_USUARIO) AND M.ID_MENSAGEM = MU.ID_MENSAGEM AND M.ID_USUARIO = UC.ID_USUARIO "+
							   " AND MU.ID_USUARIO = U.ID_USUARIO "+
							   " AND U.ID_HOTEL = H.ID_HOTEL(+) ";
	
	String QRY_HOTEL = " SELECT ID_HOTEL, NOME_FANTASIA, RAZAO_SOCIAL, ENDERECO, CEP, BAIRRO, TELEFONE, EMAIL, FAX, CGC " +
					   " FROM HOTEL " +
					   " WHERE ATIVO = 'S' " +
					   " AND ID_HOTEL = NVL(?1, ID_HOTEL) " +
					   " AND ID_REDE_HOTEL = NVL(?2, ID_REDE_HOTEL) ";
	
	String QRY_REDE_HOTEL = " SELECT ID_REDE_HOTEL, NOME_FANTASIA, RAZAO_SOCIAL, ENDERECO, CEP, BAIRRO, TELEFONE, EMAIL, FAX, CGC, " +
							" INSC_ESTADUAL, INSC_MUNICIPAL, INSC_EMBRATUR, TELEX, AUTOMATICO, VALOR_INSCRICAO, QTD_VALOR, EXPIRAR, FORA_ANO, SIGLA, " +
							" ENDERECO_LOGOTIPO, LINK_VOUCHER, FORMATO_CONTA FROM REDE_HOTEL WHERE ATIVO = 'S' AND ID_REDE_HOTEL = NVL(?1, ID_REDE_HOTEL) ";
							
	String QRY_USUARIO = "SELECT ID_USUARIO, INITCAP(NOME)||' - ['||SUBSTR(NICK,8)||']' NOME FROM USUARIO WHERE ATIVO = 'S' AND SENHA IS NOT NULL AND DATA_VALIDADE > SYSDATE ";
	String QRY_MSG_WEB_USUARIO = " SELECT M.ID_MENSAGEM, M.TITULO, M.DESCRICAO, M.DATA_CRIACAO, " +
								 " DECODE(M.NIVEL, 1, 'Normal', 2, 'Médio', 3, 'Urgente')NIVEL, DATA_RESPOSTA, RESPOSTA, SUBSTR(U.NICK, 8)NICK " +
								 " FROM MENSAGEM_WEB M, MENSAGEM_WEB_USUARIO MU, USUARIO U " +
								 " WHERE U.ID_USUARIO = M.ID_USUARIO AND M.ID_MENSAGEM = MU.ID_MENSAGEM " +
								 " AND MU.ID_USUARIO = ?1 ";
	String QRY_TIPO_APARTAMENTO = " SELECT H.ID_HOTEL, TA.TIPO_APARTAMENTO, " +
								  " TA.FANTASIA, TA.DESCRICAO_APARTAMENTO " +
								  " FROM TIPO_APARTAMENTO TA, HOTEL H " +
								  " WHERE TA.ID_HOTEL = H.ID_HOTEL ";

	String QRY_CONTROLA_DATA = " SELECT ID_HOTEL, FRONT_OFFICE, FATURAMENTO_CONTAS_RECEBER, CONTABILIDADE, " +
							   " CONTAS_PAGAR, TESOURARIA, ESTOQUE, ULTIMA_NOTA_HOSPEDAGEM, " +
							   " ULTIMO_NUM_DUPLICATA, ULTIMO_NUM_COTACAO, ULTIMO_NUM_PEDIDO, ULTIMO_NUM_CONTAS_PAGAR, " +
							   " TELEFONIA, CONTAS_RECEBER, ID_REDE_HOTEL, SALDO_ELEVADO, FECHADURA, ULTIMA_REQUISICAO, " +
							   " CENTRAL_ADVISER, AUD_ENCERRA, ULTIMA_NFS, ULTIMA_CNFS, ULTIMA_SEQ_BANCARIA, ULTIMA_NR  "+
							   " FROM CONTROLA_DATA " +
							   " WHERE 1 = 1 ";
	
	String QRY_EMPRESA_SISTEMA = " SELECT UNIQUE EM.ID_EMPRESA, null ID_REDE_HOTEL, null ID_HOTEL, null NOME_FANTASIA,EM.RAZAO_SOCIAL, " +
								 " null TELEFONE, null FAX, null TELEX, null CONTATO, EM.CGC, null EMAIL, null CREDITO, null TIPO_EMPRESA, " +
								 " CIDADE,ESTADO,PAIS, null COMISSAO_CRS, EM.NACIONAL,EM.ENDERECO, EM.BAIRRO, null SIGLA, null VALOR_CREDITO, " +
								 " null COMISSAO, null PRAZO_PAGAMENTO " +
								 " FROM EMPRESA EM, CIDADE CI, ESTADO ES, PAIS PA " +
								 " WHERE EM.ID_CIDADE = CI.ID_CIDADE " +
								 " AND CI.ID_ESTADO = ES.ID_ESTADO " +
								 " AND ES.CODPAIS = PA.CODPAIS ";
	
	String QRY_ACHADOS_PERDIDO = " SELECT AP.ID_ACHADOS_PERDIDOS, AP.OBJETO, AP.PERIODO, AP.LOCAL, AP.DATA, AP.FUNCIONARIO_ACHOU, H.ID_HOSPEDE, AP.DATA_DEVOLUCAO, "+ 
									" AP.FUNCIONARIO_RECEBE, AP.DOCUMENTO, AP.ID_HOTEL,  "+
									" AP.RECEBEDOR, AP.DOC_RECEBEDOR, H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE HOSPEDE, H.CELULAR "+ 
									" FROM ACHADOS_PERDIDOS AP "+
									" LEFT JOIN HOSPEDE H ON(AP.ID_HOSPEDE = H.ID_HOSPEDE) "+
									" WHERE AP.ID_HOTEL IN (?1) ";




	
	String QRY_HOSPEDE = " SELECT rl.ID_HOTEL, H.ID_HOSPEDE, RL.ID_ROOM_LIST, A.NUM_APARTAMENTO, C.ID_CHECKIN, H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, H.CELULAR "+ 
						" FROM APARTAMENTO A, CHECKIN C, HOSPEDE H, ROOM_LIST RL "+
						" WHERE A.ID_APARTAMENTO = C.ID_APARTAMENTO "+
						" AND C.ID_CHECKIN = RL.ID_CHECKIN "+ 
						" AND RL.ID_HOSPEDE = H.ID_HOSPEDE "+
						" AND C.ID_HOTEL = ?1 ";
	
	String QRY_COMBO_BANCO = " SELECT ID_BANCO,"
			+ " NUMERO_BANCO, "
			+ " UPPER (" + " TRIM (NUMERO_BANCO) " + " ||' - ' " + " || TRIM (BANCO) " + " ||' - ' " + " || TRIM (NOME_FANTASIA)) BANCO, "
			+ " NOME_FANTASIA "
			+ " FROM BANCO "
			+ " WHERE 1=1 ";
                                       
	String QRY_NOTA_FISCAL = "SELECT  "
			+ " SN.ID_NOTA,"
			+ " H.CGC,"
			+ " H.INSC_MUNICIPAL,"
			+ " SN.NUM_NOTA, "
			+ " SN.NOTA_INICIAL, "
			+ " SN.SERIE,"
			+ " '1' TIPO,"
			+ " TO_CHAR(SN.DATA,'YYYY/MM/DD') DataEmissao,"
			+ " DECODE(SN.STATUS,'OK',1,2) Status,"
			+ " '1' NaturezaOperacao,"
			+ " DECODE (H.ID_FISCAL_REGIME_TRIBUTARIO,1,1,2) OptanteSimplesNacional,"
			+ " DECODE(H.INCENTIVO_FISCAL_ISS, 'S',1,2) IncentivoCultura,"
			+ " SN.BASE_CALCULO ValorServicos,"
			+ " SN.VALOR_DEDUCAO ValorDeducoes,"
			+ " SN.PIS ValorPis,"
			+ " SN.COFINS ValorCofins,"
			+ " SN.INSS ValorInss,"
			+ " SN.IR_RETENCAO ValorIr,"
			+ " SN.CSLL ValorCsll,"
			+ " SN.ISS_RETIDO IssRetido,"
			+ " SN.ISS ValorIss,"
			+ " SN.OUTRAS_RETENCOES OutrasRetencoes,"
			+ " SN.ALIQUOTA_ISS Aliquota,"
			+ " '0.00' DescontoIncondicionado,"
			+ " '0.00' DescontoCondicionado,"
			+ " to_char(replace(FLS.CODIGO,'.')) ItemListaServico,"
			+ " CODIGO_SERVICO CodigoTributacaoMunicipio,"
			+ " 'Serviços' Discriminacao,"
			+ " C_DO_HOTEL.CODIGO_IBGE CodigoMunicipio,"
			+ " DECODE(QUEM_PAGA,'E', E.CGC, HO.CPF) CpfCnpj,"
			+ " DECODE(QUEM_PAGA,'E', E.ENDERECO, HO.ENDERECO) Endereco,"
			+ " DECODE(QUEM_PAGA,'E', E.NUMERO, HO.NUMERO) Numero,"
			+ " DECODE(QUEM_PAGA,'E', E.COMPLEMENTO, HO.COMPLEMENTO) Complemento,"
			+ " DECODE(QUEM_PAGA,'E', E.BAIRRO, HO.BAIRRO) Bairro,"
			+ " DECODE(QUEM_PAGA,'E', C_DA_EMPRESA.CODIGO_IBGE, C_DO_HOSPEDE.CODIGO_IBGE) CodigoMunicipioTomador,"
			+ " DECODE(QUEM_PAGA,'E', UF_DA_EMPRESA.UF, UF_DO_HOSPEDE.UF) UF  ,"
			+ " DECODE(QUEM_PAGA,'E', TO_CHAR(REPLACE(E.CEP,'-')), TO_CHAR(REPLACE(HO.CEP,'-'))) Cep, "
			+ " TO_CHAR(SN.DATA,'DD/MM/YYYY') DataEmissaoFormatada, "
			+ " SN.RPS_STATUS, "
			+ " DECODE(QUEM_PAGA,'E', ER.NOME_FANTASIA, TRIM(HO.NOME_HOSPEDE || ' ' ||HO.SOBRENOME_HOSPEDE)) RazaoSocial "
			+ " FROM STATUS_NOTA SN"
			+ " JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL)"
			+ " JOIN CIDADE C_DO_HOTEL ON (H.ID_CIDADE = C_DO_HOTEL.ID_CIDADE)"
			+ " JOIN FISCAL_LISTA_SERVICOS FLS ON (H.ID_FISCAL_LISTA_SERVICOS = FLS.ID_FISCAL_LISTA_SERVICOS)"
			+ " JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA)"
			+ " LEFT JOIN HOSPEDE HO ON (SN.ID_HOSPEDE = HO.ID_HOSPEDE)"
			+ " LEFT JOIN CIDADE C_DO_HOSPEDE ON (HO.ID_CIDADE = C_DO_HOSPEDE.ID_CIDADE) "
			+ " LEFT JOIN ESTADO UF_DO_HOSPEDE ON (C_DO_HOSPEDE.ID_ESTADO = UF_DO_HOSPEDE.ID_ESTADO) "
			+ " JOIN CIDADE C_DA_EMPRESA ON (E.ID_CIDADE = C_DA_EMPRESA.ID_CIDADE)"
			+ " JOIN ESTADO UF_DA_EMPRESA ON (C_DA_EMPRESA.ID_ESTADO = UF_DA_EMPRESA.ID_ESTADO) " 
			+ " JOIN EMPRESA_REDE ER ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND SN.ID_EMPRESA = ER.ID_EMPRESA) "  
			+ " WHERE 1=1 ";


	String QRY_ULTIMO_RPS_NOTA_FISCAL = "SELECT MAX(SN.NOTA_INICIAL) "
			+ " FROM STATUS_NOTA SN"
			+ " JOIN HOTEL H ON (SN.ID_HOTEL = H.ID_HOTEL)"
			+ " JOIN CIDADE C_DO_HOTEL ON (H.ID_CIDADE = C_DO_HOTEL.ID_CIDADE)"
			+ " JOIN FISCAL_LISTA_SERVICOS FLS ON (H.ID_FISCAL_LISTA_SERVICOS = FLS.ID_FISCAL_LISTA_SERVICOS)"
			+ " JOIN EMPRESA E ON (SN.ID_EMPRESA = E.ID_EMPRESA)"
			+ " JOIN HOSPEDE HO ON (SN.ID_HOSPEDE = HO.ID_HOSPEDE)"
			+ " LEFT OUTER JOIN CIDADE C_DO_HOSPEDE ON (HO.ID_CIDADE = C_DO_HOSPEDE.ID_CIDADE) "
			+ " LEFT OUTER JOIN ESTADO UF_DO_HOSPEDE ON (C_DO_HOSPEDE.ID_ESTADO = UF_DO_HOSPEDE.ID_ESTADO) "
			+ " JOIN CIDADE C_DA_EMPRESA ON (E.ID_CIDADE = C_DA_EMPRESA.ID_CIDADE)"
			+ " JOIN ESTADO UF_DA_EMPRESA ON (C_DA_EMPRESA.ID_ESTADO = UF_DA_EMPRESA.ID_ESTADO)"
			+ " WHERE 1=1 ";

	String QRY_CONFIGURACAO_TRIBUTARIA = "SELECT "
	   + " CD.ID_HOTEL, "
	   + " CD.ULTIMA_NFS NUMERO_RPS, "
       + " H.NOTA_HOSP_TIPO SERIE, " 
       + " H.SUB_SERIE, "
       + " H.ISS ALIQUOTA, "
       + " H.IMPOSTOS_SERVICOS IMP_INCIDENTESS, " 
       + " H.AIDF, "
       + " H.PRODUCAO, "
       + " H.INCENTIVO_FISCAL_ISS INC_FISCAL, " 
       + " CD.ULTIMA_CNFS LOTE, "
       + " IE.ID_ISS_EXIGIBILIDADE ID_EXIGIBILIDADE, "
       + " IE.DESCRICAO EXIGIBILIDADE, "
       + " FR.NOME_FANTASIA PREFEITURA, " 
       + " H.CODIGO_SERVICO, " 
       + " H.SENHA, "
       + " H.FRASE_SECRETA, "
       + " H.NOTA_TERMO DISCRIMINACAO, "
       + " H.IMPOSTOS_MERCADORIAS IMP_INCIDENTESM, " 
       + " FRT.ID_FISCAL_REGIME_TRIBUTARIO ID_REGIME_TRIBUTARIO, "
       + " FRT.REGIME REGIME_TRIBUTARIO, "
       + " FLS.DESCRICAO TABELA_SERVICO, " 
       + " H.CNAE, "
       + " H.SIGLA, "
       + " H.CNPJ_AUTORIZADO_XML, "
       + " H.CPF_AUTORIZADO_XML "
	   + " FROM HOTEL H "
	   + " 	JOIN CONTROLA_DATA CD "
	   + "    ON (H.ID_HOTEL = CD.ID_HOTEL) " 
	   + "  JOIN FORNECEDOR_REDE FR "
	   + "    ON (H.ID_REDE_HOTEL = FR.ID_REDE_HOTEL) " 
	   + "  JOIN FORNECEDOR_HOTEL FH "
	   + "    ON (    FR.ID_FORNECEDOR = FH.ID_FORNECEDOR "
	   + "       AND H.ID_FORNECEDOR_PREFEITURA = FR.ID_FORNECEDOR " 
	   + "       AND FH.ID_HOTEL = H.ID_HOTEL) "
	   + "  LEFT JOIN FISCAL_REGIME_TRIBUTARIO FRT "
	   + "    ON (H.ID_FISCAL_REGIME_TRIBUTARIO = FRT.ID_FISCAL_REGIME_TRIBUTARIO) " 
	   + "  LEFT JOIN FISCAL_LISTA_SERVICOS FLS "
	   + "    ON (H.ID_FISCAL_LISTA_SERVICOS = FLS.ID_FISCAL_LISTA_SERVICOS) " 
	   + "  LEFT JOIN ISS_EXIGIBILIDADE IE  "
	   + "    ON (H.ID_ISS_EXIGIBILIDADE = IE.ID_ISS_EXIGIBILIDADE) " 
	   + "  WHERE CD.ID_HOTEL = ?1  ";
	
	String QRY_EXIBILIDADE = " SELECT EX.ID_ISS_EXIGIBILIDADE, EX.DESCRICAO " + 
			" FROM ISS_EXIGIBILIDADE EX ";
	
	String QRY_REGIME_TRIBUTARIO = " SELECT RT.ID_FISCAL_REGIME_TRIBUTARIO, RT.REGIME " + 
			" FROM FISCAL_REGIME_TRIBUTARIO RT ";
	
	String QRY_FISCAL_LISTA_SERVICO = " SELECT FL.ID_FISCAL_LISTA_SERVICOS, (TRIM (FL.CODIGO) || ' - ' || TRIM (FL.DESCRICAO)) REDUZIDA " + 
			" FROM FISCAL_LISTA_SERVICOS FL " +
			" WHERE FL.TIPO = 'A' ";
	
	String QRY_PESQUISAR_USUARIO = " SELECT U.ID_USUARIO, SUBSTR (U.NICK,8)||' - ' ||U.NOME NOME " +
			" FROM USUARIO U " +
			" JOIN CONTROLA_DATA CD ON U.ID_HOTEL = CD.ID_HOTEL " +
			" WHERE U.ID_HOTEL = ?1  " +
			" AND U.ATIVO = 'S' " +
			" AND U.DATA_VALIDADE >= CD.FRONT_OFFICE ";
	
	List <CidadeVO> pesquisarCidade (CidadeVO filtro) throws MozartSessionException; 
	List <EstadoEJB> pesquisarEstado () throws MozartSessionException;
	List <BancoVO> pesquisarBanco (BancoVO filtro) throws MozartSessionException;
	List <BancoVO> pesquisarBancoCombo (BancoVO filtro) throws MozartSessionException;
	List<MensagemWebUsuarioEJB> pesquisarMensagens(UsuarioEJB usuarioEJB)throws MozartSessionException;
	List<MensagemWebVO> pesquisarMensagens(MensagemWebVO filtro)throws MozartSessionException;
	List<HotelVO> pesquisarHotel(HotelVO hotelVO)throws MozartSessionException;
	List<RedeHotelVO> pesquisarRedeHotel(RedeHotelVO redeHotelVO)throws MozartSessionException;
	List<UsuarioVO> pesquisarUsuario(Long idRedeHotel, Long idHotel, String usuarioAdm, String suporteMozart) throws MozartSessionException;
	void gravarMensagem(MensagemWebEJB entidade) throws MozartSessionException;
	List<MensagemWebUsuarioVO> pesquisarMensagensWebUsuario(MensagemWebUsuarioVO filtro) throws MozartSessionException;
	List<BancoVO> pesquisarBancoUsadoNoHotel(Long idHotel) throws MozartSessionException;
	List<RedeHotelEJB> pesquisarRedeHotel() throws MozartSessionException;
	List<HotelEJB> pesquisarHotelEJB(HotelVO filtro)throws MozartSessionException;
	List<ControlaDataEJB> pesquisarControlaData(ControlaDataVO filtro)throws MozartSessionException;
	List<RedeHotelEJB> pesquisarRedeHotelEJB(RedeHotelVO filtro) throws MozartSessionException;
	List<EmpresaVO> pesquisarEmpresa(EmpresaVO filtro) throws MozartSessionException;
	List<AchadosPerdidoVO> pesquisarAchadosPerdido(AchadosPerdidoVO filtro)throws MozartSessionException;
	List<HospedeAchadosPerdidoVO> pesquisarHospedeAP(HospedeAchadosPerdidoVO ap)throws MozartSessionException;
	List<BancoVO> pesquisarBancoComboAutoComplete(BancoVO filtro) throws MozartSessionException;
	List<NotaFiscalVO> pesquisarNotaFiscal(NotaFiscalVO filtro) throws MozartSessionException;
	List<String> pesquisarUltimaNotaFiscalEnviada(NotaFiscalVO filtro) throws MozartSessionException;
	ConfiguracaoTributarioVO pesquisarConfiguracaoTributaria(ConfiguracaoTributarioVO filtro) throws MozartSessionException;
	List<ExigibilidadeVO> obterExigibilidade() throws MozartSessionException;
	List<RegimeTributarioVO>  obterRegimeTributario() throws MozartSessionException;
	List<UsuarioVO> obterComboUsuarios(UsuarioVO filtro) throws MozartSessionException;
//	List<ListaFiscalServicoVO> pesquisarListaServicoFiscal(ListaFiscalServicoVO filtro) throws MozartSessionException;
	
}