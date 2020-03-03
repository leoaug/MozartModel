package com.mozart.model.ejb.facade;

import com.mozart.model.ejb.entity.EmpresaEJB;
import com.mozart.model.ejb.entity.EmpresaGrupoLancamentoEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJBPK;
import com.mozart.model.ejb.entity.GrupoEconomicoEJB;
import com.mozart.model.ejb.entity.IdentificaLancamentoEJB;
import com.mozart.model.ejb.entity.PromotorEJB;
import com.mozart.model.ejb.entity.RepresentanteRedeEJB;
import com.mozart.model.ejb.entity.TarifaEJB;
import com.mozart.model.ejb.entity.TarifaGrupoEJB;
import com.mozart.model.ejb.entity.TipoEmpresaEJB;
import com.mozart.model.ejb.entity.VendedorRedeEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.EmpresaHotelVO;
import com.mozart.model.vo.EmpresaVO;
import com.mozart.model.vo.TipoEmpresaVO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public abstract interface EmpresaSession {
	public static final String QRY_LOOKUP_FANTASIA_CNPJ = "SELECT ID_HOTEL, ID_EMPRESA, NOME_FANTASIA,\nCALCULA_ISS, CALCULA_TAXA, CALCULA_ROOMTAX FROM\n(SELECT EH.ID_HOTEL, EH.ID_EMPRESA, (ER.CREDITO||'-'||ER.NOME_FANTASIA||DECODE(EM.CGC,NULL,'','-'||EM.CGC)) NOME_FANTASIA, EH.ID_REDE_HOTEL,\nEH.CALCULA_ISS, EH.CALCULA_TAXA, EH.CALCULA_ROOMTAX\nFROM EMPRESA_HOTEL EH, EMPRESA_REDE ER, EMPRESA EM\nWHERE EH.ID_HOTEL = ?1\nAND EH.ID_REDE_HOTEL = ER.ID_REDE_HOTEL\nAND EH.ID_EMPRESA = ER.ID_EMPRESA\nAND ER.ID_EMPRESA = EM.ID_EMPRESA\nAND (UPPER(TRIM(ER.CREDITO||'-'||ER.NOME_FANTASIA)) LIKE UPPER(TRIM('%'||NVL(?2, ER.CREDITO||'-'||ER.NOME_FANTASIA)||'%')) OR \nEM.CGC like '%'||nvl(?3, EM.CGC)||'%')\nORDER BY TRIM(ER.NOME_FANTASIA))";
	public static final String QRY_EMPRESA = " SELECT UNIQUE EM.ID_EMPRESA,ER.ID_REDE_HOTEL,EH.ID_HOTEL, Er.NOME_FANTASIA,EM.RAZAO_SOCIAL, ER.TELEFONE,ER.FAX,ER.TELEX, ER.CONTATO, EM.CGC,ER.EMAIL,ER.CREDITO,TH.TIPO_EMPRESA,  CIDADE,ESTADO,PAIS,TE.COMISSAO_CRS, EM.NACIONAL,EM.ENDERECO, EM.BAIRRO, HOTEL.SIGLA,EH.VALOR_CREDITO,EH.COMISSAO, EH.PRAZO_PAGAMENTO, EM.numero, EM.complemento FROM EMPRESA EM,  EMPRESA_HOTEL EH, EMPRESA_REDE ER, TIPO_EMPRESA TE, TIPO_EMPRESA TH,CIDADE CI, ESTADO ES, PAIS PA, HOTEL WHERE TH.ID_TIPO_EMPRESA = EH.ID_TIPO_EMPRESA AND ER.ID_EMPRESA = EM.ID_EMPRESA AND EM.ID_CIDADE = CI.ID_CIDADE AND CI.ID_ESTADO = ES.ID_ESTADO AND TE.ID_TIPO_EMPRESA = EH.ID_TIPO_EMPRESA AND ER.ID_REDE_HOTEL = ?1  AND EH.ID_HOTEL = HOTEL.ID_HOTEL AND ES.CODPAIS = PA.CODPAIS AND EM.ID_EMPRESA  = EH.ID_EMPRESA";
	public static final String QRY_TIPO_EMPRESA = " SELECT ID_TIPO_EMPRESA, TIPO_EMPRESA, COMISSAO_CRS  FROM TIPO_EMPRESA  WHERE ID_HOTEL = ?1 ";
	public static final String QRY_FORNECEDORES_HOTEL = "SELECT E.ID_EMPRESA, E.CGC, FR.NOME_FANTASIA, FH.PRAZO_ENTREGA FROM EMPRESA E JOIN FORNECEDOR_HOTEL FH ON (E.ID_EMPRESA = FH.ID_FORNECEDOR) JOIN HOTEL H ON (FH.ID_HOTEL = H.ID_HOTEL) JOIN FORNECEDOR_REDE FR ON (E.ID_EMPRESA = FR.ID_FORNECEDOR AND H.ID_REDE_HOTEL = FR.ID_REDE_HOTEL) WHERE FH.ID_HOTEL = ?1 ";

	public abstract List<EmpresaHotelVO> obterEmpresaLookup(
			EmpresaHotelEJB paramEmpresaHotelEJB);

	public abstract List<EmpresaGrupoLancamentoEJB> obterGrupoLancamentoByEmpresa(
			EmpresaHotelEJB paramEmpresaHotelEJB)
			throws MozartValidateException;

	public abstract EmpresaHotelEJB obterEmpresaHotelByPK(
			EmpresaHotelEJBPK paramEmpresaHotelEJBPK)
			throws MozartValidateException;

	public abstract List<EmpresaVO> pesquisarEmpresa(EmpresaVO paramEmpresaVO)
			throws MozartSessionException;

	public abstract List<GrupoEconomicoEJB> obterGrupoEconomico(
			GrupoEconomicoEJB paramGrupoEconomicoEJB)
			throws MozartSessionException;

	public abstract List<TipoEmpresaEJB> obterTipoEmpresa(
			TipoEmpresaEJB paramTipoEmpresaEJB) throws MozartSessionException;

	public abstract List<PromotorEJB> obterPromotor(PromotorEJB paramPromotorEJB)
			throws MozartSessionException;

	public abstract List<IdentificaLancamentoEJB> obterIdentificaLancamento(
			IdentificaLancamentoEJB paramIdentificaLancamentoEJB)
			throws MozartSessionException;

	public abstract List<TarifaGrupoEJB> obterTarifaGrupo(
			TarifaGrupoEJB paramTarifaGrupoEJB) throws MozartSessionException;

	public abstract List<TarifaEJB> obterTarifa(TarifaEJB paramTarifaEJB)
			throws MozartSessionException;

	public abstract EmpresaEJB gravarEmpresa(EmpresaEJB paramEmpresaEJB)
			throws MozartSessionException;

	public abstract EmpresaEJB obterEmpresa(EmpresaEJB paramEmpresaEJB)
			throws MozartSessionException;

	public abstract void replicarEmpresaRede(EmpresaEJB paramEmpresaEJB,
			Long paramLong) throws MozartSessionException;

	public abstract List<TipoEmpresaVO> pesquisarTipoEmpresa(
			TipoEmpresaVO paramTipoEmpresaVO) throws MozartSessionException;
	
	public abstract List<EmpresaVO> obterFornecedoresHotelPorNomeOuCNPJ(EmpresaVO filtro) throws MozartSessionException;
	
	public EmpresaHotelVO obterEmpresaPorIdEmpresa(EmpresaHotelVO filtro);
	
	public abstract List<VendedorRedeEJB> obterVendedor(VendedorRedeEJB filtro) throws MozartSessionException;
	
	public abstract List<RepresentanteRedeEJB> obterRepresentante(RepresentanteRedeEJB filtro) throws MozartSessionException;
}