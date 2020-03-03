package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.NfeCofinsCadastroEJB;
import com.mozart.model.ejb.entity.NfeCofinsCadastroStEJB;
import com.mozart.model.ejb.entity.NfeCofinsCstEJB;
import com.mozart.model.ejb.entity.NfeIICadastroEJB;
import com.mozart.model.ejb.entity.NfeIcmsCadastroEJB;
import com.mozart.model.ejb.entity.NfeIcmsModBcIcmsEJB;
import com.mozart.model.ejb.entity.NfeIcmsModBcIcmsStEJB;
import com.mozart.model.ejb.entity.NfeIcmsMotivoDesoneracaoEJB;
import com.mozart.model.ejb.entity.NfeIcmsOrigemMercadoriaEJB;
import com.mozart.model.ejb.entity.NfeIpiCadastroEJB;
import com.mozart.model.ejb.entity.NfeIpiCstEJB;
import com.mozart.model.ejb.entity.NfePisCadastroEJB;
import com.mozart.model.ejb.entity.NfePisCadastroStEJB;
import com.mozart.model.ejb.entity.NfePisCstEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.EstadoNfeVO;
import com.mozart.model.vo.SituacaoTributariaVO;
import com.mozart.model.vo.UnidadeNfeVO;
import com.mozart.model.vo.ValorBaseCalculoNfeVO;

@Remote
public interface NfeSession {
	
	String QRY_LISTA_SITUACAO_TRIBUTARIA = "SELECT NIC.ID_NFE_ICMS_CST, TRIM (NIC.CSOSN || ' - ' || NIC.DESCRICAO) "  
			+ " FROM HOTEL H, NFE_ICMS_CST NIC "  
			+ " WHERE     H.ID_HOTEL = ?1 "
			+ " AND H.ID_FISCAL_REGIME_TRIBUTARIO = 1 "  
			+ " AND NIC.CSOSN IS NOT NULL "  
			+ " UNION "
			+ " SELECT NIC.ID_NFE_ICMS_CST, TRIM (NIC.CST || ' - ' || NIC.DESCRICAO) "  
			+ " FROM HOTEL H, NFE_ICMS_CST NIC " 
			+ " WHERE     H.ID_HOTEL = ?2  "
			+ " AND H.ID_FISCAL_REGIME_TRIBUTARIO > 1"  
			+ " AND NIC.CST IS NOT NULL";
	
	String QRY_BC_ALIQ_VAL_ICMS = "SELECT (PR.VALOR_PRATO * (100 - NICA.PREDBC) / 100) BASE_CALCULO, " 
			+ " A.ALIQUOTA, "
			+ " (PR.VALOR_PRATO * (100 - NICA.PREDBC) / 100) * A.ALIQUOTA / 100 " 
			+ " VALOR_ICMS "
       		+ " FROM PRATO PR "
       		+ " JOIN NFE_ICMS_CADASTRO NICA " 
       		+ " ON (PR.ID_PRATO = NICA.ID_PRATO) " 
       		+ " JOIN ALIQUOTAS A "
       		+ " ON (PR.ID_ALIQUOTA = A.ID_ALIQUOTAS) " 
       		+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 "; 
	
	String QRY_VR_CRED_ICMS = "SELECT NVL (PR.VALOR_PRATO * NICA.PCREDSN / 100, 0) " 
			+ " FROM PRATO PR JOIN NFE_ICMS_CADASTRO NICA ON (PR.ID_PRATO = NICA.ID_PRATO) " 
			+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 ";
	
	String QRY_VAL_ICMS_DIF = "SELECT NVL (PR.VALOR_PRATO * NICA.PDIF / 100, 0) " 
			+ " FROM PRATO PR JOIN NFE_ICMS_CADASTRO NICA ON (PR.ID_PRATO = NICA.ID_PRATO) " 
			+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 ";
	
	String QRY_VAL_BASE_CAL_ST = "SELECT (CASE"
			+ " WHEN (NICA.PMVAST > 0)" 
	        + " THEN "
	        + " (PR.VALOR_PRATO * NICA.PMVAST) / 100 + PR.VALOR_PRATO" 
	        + " WHEN (NICA.PREDBCST > 0)" 
	        + " THEN "
	        + " (PR.VALOR_PRATO * -NICA.PREDBCST) / 100 + PR.VALOR_PRATO" 
	        + " WHEN (NICA.PMVAST = NULL) AND (NICA.PREDBCST = NULL)" 
	        + " THEN PR.VALOR_PRATO" 
	        + " END) "
	        + " VBCST, "
	        + " 0,"
	        + " (CASE "
	        + " WHEN (NICA.PMVAST > 0)" 
	        + " THEN "
	        + "  ( (PR.VALOR_PRATO * NICA.PMVAST) / 100 + PR.VALOR_PRATO) * NICA.PICMSST / 100" 
	        + " WHEN (NICA.PREDBCST > 0)" 
	        + " THEN "
	        + " ( (PR.VALOR_PRATO * -NICA.PREDBCST) / 100 + PR.VALOR_PRATO) * NICA.PICMSST / 100" 
	        + " WHEN (NICA.PMVAST = NULL) AND (NICA.PREDBCST = NULL)" 
	        + " THEN PR.VALOR_PRATO END) ICMSST "
	        + " FROM PRATO PR JOIN NFE_ICMS_CADASTRO NICA ON (PR.ID_PRATO = NICA.ID_PRATO) " 
	        + " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 ";
	
	String QRY_REGIME_TRIBUTARIO = "SELECT  FRT.REGIME " 
			+ " FROM    HOTEL H JOIN " 
			+ " FISCAL_REGIME_TRIBUTARIO FRT " 
			+ " ON (H.ID_FISCAL_REGIME_TRIBUTARIO = FRT.ID_FISCAL_REGIME_TRIBUTARIO) " 
			+ " WHERE H.ID_HOTEL = ?1 "; 
	
	String QRY_VAL_BASE_CAL_COFINS = "SELECT NVL (PR.VALOR_PRATO, 0) BASE_CALCULO " 
			+ " FROM PRATO PR " 
			+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 "; 
	
	String QRY_VAL_COFINS = "SELECT TO_CHAR ( (PR.VALOR_PRATO * NCC.PCOFINS / 100), 'FM999G999G999D90') " 
			+ " VCOFINS " 
			+ " FROM PRATO PR JOIN NFE_COFINS_CADASTRO NCC ON (PR.ID_PRATO = NCC.ID_PRATO) " 
			+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 ";
	
	String QRY_VAL_COFINS_ST = "SELECT TO_CHAR ( (PR.VALOR_PRATO * NCC.PCOFINS / 100), 'FM999G999G999D90') " 
			+ " VCOFINS " 
			+ " FROM PRATO PR JOIN NFE_COFINS_CADASTRO_ST NCC ON (PR.ID_PRATO = NCC.ID_PRATO) " 
			+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 ";
	
	String QRY_VAL_PIS = "SELECT TO_CHAR ( (PR.VALOR_PRATO * NPC.PPIS / 100), 'FM999G999G999D90') " 
			+ " VPIS " 
			+ " FROM PRATO PR JOIN NFE_PIS_CADASTRO NPC ON (PR.ID_PRATO = NPC.ID_PRATO) " 
			+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 ";
	
	String QRY_VAL_PIS_ST = "SELECT TO_CHAR ( (PR.VALOR_PRATO * NPC.PPIS / 100), 'FM999G999G999D90') " 
			+ " VPIS " 
			+ " FROM PRATO PR JOIN NFE_PIS_CADASTRO_ST NPC ON (PR.ID_PRATO = NPC.ID_PRATO) " 
			+ " WHERE PR.ID_HOTEL = ?1 AND PR.ID_PRATO = ?2 ";
	
	String QRY_UNIDADE_NFE = "SELECT ID_NFE_UNIDADE, UNIDADE || ' - ' || DESCRICAO FROM NFE_UNIDADE ORDER BY UNIDADE";
	
	public static final String QUERY_ESTADO_ICMS = " SELECT FCP.ID_NFE_FCP, E.ID_ESTADO, E.UF||' - '||E.ESTADO, FCP.PERCENTUAL "
			+ " FROM ESTADO E "
			+ " LEFT JOIN NFE_FCP FCP ON FCP.ID_ESTADO = E.ID_ESTADO "
			+ " WHERE E.CODIGO_IBGE IS NOT NULL ORDER BY E.UF ";
	
	List<SituacaoTributariaVO> obterListaSituacaoTributaria(HotelEJB hotel)
			throws MozartSessionException;
	
	List<NfeIcmsOrigemMercadoriaEJB> obterOrigemMercadoriaIcms()
			throws MozartSessionException;
	
	List<NfeIcmsModBcIcmsEJB> obterModalidadeBaseCalculoIcms()
			throws MozartSessionException;
	
	List<NfeIcmsModBcIcmsStEJB> obterModalidadeBaseCalculoIcmsSt()
			throws MozartSessionException;
	
	List<NfeIcmsMotivoDesoneracaoEJB> obterMotivoDesoneracaoIcms()
			throws MozartSessionException;

	String obterRegimeTributario(HotelEJB hotel) 
			throws MozartSessionException;
	
	List<NfeCofinsCstEJB> obterListaSituacaoTributariaCofins()
			throws MozartSessionException;
	
	List<NfePisCstEJB> obterListaSituacaoTributariaPis()
			throws MozartSessionException;
	
	List<NfeIpiCstEJB> obterListaSituacaoTributariaIpi()
			throws MozartSessionException;
	
	NfeIcmsCadastroEJB gravarIcms(NfeIcmsCadastroEJB entidade) 
			throws MozartSessionException;

	NfeCofinsCadastroEJB gravarCofins(NfeCofinsCadastroEJB entidade) 
			throws MozartSessionException;
	
	NfeCofinsCadastroStEJB gravarCofinsSt(NfeCofinsCadastroStEJB entidade) 
			throws MozartSessionException;
	
	NfePisCadastroEJB gravarPis(NfePisCadastroEJB entidade) 
			throws MozartSessionException;
	
	NfePisCadastroStEJB gravarPisSt(NfePisCadastroStEJB entidade) 
			throws MozartSessionException;
	
	NfeIICadastroEJB gravarII(NfeIICadastroEJB entidade) 
			throws MozartSessionException;
	
	NfeIpiCadastroEJB gravarIpi(NfeIpiCadastroEJB entidade) 
			throws MozartSessionException;
	
	ValorBaseCalculoNfeVO obterValorBaseCalculoIcms(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	Double obterValorCredIcms(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	Double obterValorIcmsDiferido(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	ValorBaseCalculoNfeVO obterValorBaseCalculoIcmsSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	Double obterValorBaseCalculoCofins(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	Double obterValorCofins(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	Double obterValorCofinsSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	Double obterValorPis(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
			
	Double obterValorPisSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	NfeIcmsCadastroEJB obterIcmsCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	NfeCofinsCadastroEJB obterCofinsCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	NfeCofinsCadastroStEJB obterCofinsCadastroSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	NfeIICadastroEJB obterIICadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	NfeIpiCadastroEJB obterIpiCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	NfePisCadastroEJB obterPisCadastro(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	NfePisCadastroStEJB obterPisCadastroSt(HotelEJB hotel, PratoEJB prato)
			throws MozartSessionException;
	
	List<UnidadeNfeVO> obterListaUnidadesNfe()
			throws MozartSessionException;
	
	List<EstadoNfeVO> obterListaEstadosNfe()
			throws MozartSessionException;
	
	EstadoNfeVO gravarFcp(EstadoNfeVO entidade) throws MozartSessionException;
}