package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ApartamentoEJB;
import com.mozart.model.ejb.entity.CamareiraEJB;
import com.mozart.model.ejb.entity.ConfigFnrhEJB;
import com.mozart.model.ejb.entity.GarconEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MesaEJB;
import com.mozart.model.ejb.entity.NfeImpressoraEJB;
import com.mozart.model.ejb.entity.PontoVendaEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.ejb.entity.RepresentanteRedeEJB;
import com.mozart.model.ejb.entity.TipoApartamentoEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.entity.TipoRefeicaoEJB;
import com.mozart.model.ejb.entity.UnidadeEstoqueEJB;
import com.mozart.model.ejb.entity.VendedorRedeEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ApartamentoHospedeVO;
import com.mozart.model.vo.ApartamentoVO;
import com.mozart.model.vo.CamareiraVO;
import com.mozart.model.vo.GarconVO;
import com.mozart.model.vo.MesaVO;
import com.mozart.model.vo.ObjetoVO;
import com.mozart.model.vo.PontoVendaVO;
import com.mozart.model.vo.RepresentanteVO;
import com.mozart.model.vo.TipoApartamentoVO;
import com.mozart.model.vo.UsuarioVO;
import com.mozart.model.vo.VendedorVO;

@Remote
public abstract interface OperacionalSession {
	public static final String QUERY_APARTAMENTO = "select a.id_apartamento, a.id_hotel, a.id_tipo_apartamento, a.num_apartamento, a.area, a.status,\na.cofan, a.observacao, a.deposito_antecipado, a.caracteristica, a.id_camareira, a.checkout, a.bloco, a.data_entrada, a.data_saida\nfrom apartamento a, tipo_apartamento t where a.id_tipo_apartamento=t.id_tipo_apartamento and a.id_hotel=t.id_hotel \n";
	public static final String QUERY_TIPO_APARTAMENTO = "select id_tipo_apartamento, tipo_apartamento, fantasia, id_hotel, qtde_pessoa, descricao_apartamento\nfrom tipo_apartamento\nwhere 1=1\n";
	public static final String QUERY_CAMAREIRA = "select c.id_camareira, c.nome_camareira, c.ativo, c.id_hotel, c.cod_central_adviser, c.id_usuario, h.sigla from camareira c, hotel h where h.id_hotel = c.id_hotel ";
	public static final String QUERY_OBJETO = " select id_objeto, fantasia, descricao, valor from objeto where 1 = 1 ";
	public static final String QUERY_GARCON = " SELECT ID_GARCON, NOME_GARCON, ATIVO, COMISSAO, DATA \tFROM GARCON where 1=1 ";
	public static final String QUERY_TIPO_REFEICAO = " SELECT ID_TIPO_REFEICAO, DESCRICAO FROM TIPO_REFEICAO  WHERE ID_REDE_HOTEL = ?1 ";
	public static final String QUERY_MESA = " SELECT M.ID_MESA, M.NUM_MESA, G.NOME_GARCON, PV.NOME_PONTO_VENDA, M.STATUS_MESA, M.NUM_PESSOAS  FROM MESA M, GARCON G, PONTO_VENDA PV  WHERE M.ID_GARCON = G.ID_GARCON  AND M.ID_PONTO_VENDA = PV.ID_PONTO_VENDA ";
	public static final String QUERY_PONTO_VENDA = " SELECT ID_PONTO_VENDA, NOME_PONTO_VENDA, TIPO_PONTO_VENDA,  NOME_PROPRIETARIO, PERC_TAXA_SERVICO  FROM PONTO_VENDA where 1=1 ";

	public static final String QUERY_PONTO_VENDA_POR_USUARIO = " SELECT PV.ID_PONTO_VENDA, PV.NOME_PONTO_VENDA"
			+ " FROM USUARIO_PONTO_VENDA UPV"
			+ " JOIN PONTO_VENDA PV ON (UPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA)"
			+ " WHERE UPV.ID_USUARIO = ?1 ";

	public static final String QUERY_PONTO_VENDA_POR_USUARIO_HOTEL = " SELECT PV.ID_PONTO_VENDA, PV.NOME_PONTO_VENDA"
			+ " FROM USUARIO_PONTO_VENDA UPV"
			+ " JOIN PONTO_VENDA PV ON (UPV.ID_PONTO_VENDA = PV.ID_PONTO_VENDA)"
			+ " WHERE UPV.ID_USUARIO = ?1 AND UPV.ID_HOTEL=?2";

	public static final String QUERY_TIPO_REFEICAO_POR_REDE = " SELECT ID_TIPO_REFEICAO,"
			+ " DESCRICAO FROM TIPO_REFEICAO WHERE ID_REDE_HOTEL = ?1"
			+ " ORDER BY DESCRICAO;  ";
	
	public static final String QRY_HOSPEDE_APARTAMENTO = " SELECT A.NUM_APARTAMENTO, H.NOME_HOSPEDE, H.SOBRENOME_HOSPEDE, "
			+ "C.ID_CHECKIN, A.ID_APARTAMENTO, RL.PRINCIPAL, RL.ID_ROOM_LIST "+ 
			" FROM CHECKIN C "
			+ " JOIN APARTAMENTO A ON (C.ID_APARTAMENTO = A.ID_APARTAMENTO)"
			+ " JOIN ROOM_LIST RL ON (C.ID_CHECKIN = RL.ID_CHECKIN )"
			+ " JOIN HOSPEDE H ON (RL.ID_HOSPEDE = H.ID_HOSPEDE) "
			+ " WHERE C.ID_HOTEL = ?1 "
			+ " AND C.CHECKOUT = 'N' "
			+ " AND A.CHECKOUT = 'N' ";
	
	String QRY_REPRESENTANTE = " SELECT UPPER (TRIM (E.CGC) " +
	//		"   ||' - ' " +
	//		"   || TRIM(E.CPF) " +
			"   ||' - ' " +
			"   || TRIM(E.CODIGO)) CNPJ, " +
			"     RR.ID_REPRESENTANTE,  " +
			"     RR.CONTATO,  " +
			"     RR.NOME_FANTASIA,  " +
			"     RR.TELEFONE_1,  " +
			"     RR.TELEFONE_2,  " +
			"     RR.E_MAIL_1, " +
			"     RR.NUM_AGENCIA, " +
			"	  RR.DIGITO_AGENCIA, " +
			"     RR.NUM_CONTA_CORRENTE, " +
			"     RR.DIGITO_CONTA, " +
			"     B.NOME_FANTASIA, " +
			"     RU.PRAZO_PAGAMENTO, " +
			"     RU.COMISSAO  " +
			" FROM  " +
			"     MOZART.REPRESENTANTE_REDE RR " +
			"     JOIN MOZART.REPRESENTANTE_UNIDADE RU ON RR.ID_REPRESENTANTE = RU.ID_REPRESENTANTE " +
			"     JOIN MOZART.EMPRESA E ON RR.ID_REPRESENTANTE = E.ID_EMPRESA " +
			"     JOIN BANCO B ON RR.ID_BANCO = B.ID_BANCO " +
			" WHERE RR.ID_REDE_HOTEL = ?1 ";
	
	String QRY_VENDEDOR = " SELECT UPPER (TRIM (E.CGC) " +
			"   ||' - ' " +
			"   || TRIM(E.CPF) " +
			"   ||' - ' " +
			"   || TRIM(E.CODIGO)) CNPJ, " +
			"     VR.ID_VENDEDOR,  " +
			"     VR.CONTATO,  " +
			"     VR.NOME_FANTASIA,  " +
			"     VR.TELEFONE_1,  " +
			"     VR.TELEFONE_2,  " +
			"     VR.E_MAIL_1, " +
			"     VR.NUM_AGENCIA," +
			"     VR.DIGITO_AGENCIA, " +
			"     VR.NUM_CONTA_CORRENTE, " +
			"	  VR.DIGITO_CONTA, " +
			"     B.NOME_FANTASIA, " +
			"     VU.PRAZO_PAGAMENTO, " +
			"     VU.COMISSAO  " +
			" FROM  " +
			"     MOZART.VENDEDOR_REDE VR " +
			"     JOIN MOZART.VENDEDOR_UNIDADE VU ON VR.ID_VENDEDOR= VU.ID_VENDEDOR " +
			"     JOIN MOZART.EMPRESA E ON VR.ID_VENDEDOR = E.ID_EMPRESA " +
			"     JOIN BANCO B ON VR.ID_BANCO = B.ID_BANCO " +
			" WHERE VR.ID_REDE_HOTEL = ?1 ";
	
	
	public static final String QUERY_MESA_LIVRE = "SELECT M.ID_MESA, M.CONTATO_RESERVA, M.ID_GARCON, M.LOCALIZACAO_MESA, M.NUM_MESA, M.NUM_PESSOAS, M.STATUS_MESA, M.ID_PONTO_VENDA, M.ID_HOTEL FROM MESA M WHERE M.ID_PONTO_VENDA = ?1";
	
	public static final String QUERY_PRATO = " SELECT P.* FROM PRATO P WHERE P.ID_HOTEL = ?1";
	
	public abstract List<ApartamentoHospedeVO> pesquisarApartamentoHospede(
			ApartamentoHospedeVO paramApartamentoVO) throws MozartSessionException;

	public abstract List<ApartamentoEJB> pesquisarApartamento(
			ApartamentoVO paramApartamentoVO) throws MozartSessionException;

	public abstract List<CamareiraEJB> pesquisaCamareira(
			CamareiraEJB paramCamareiraEJB) throws MozartSessionException;

	public abstract ApartamentoEJB gravarApartamento(
			ApartamentoEJB paramApartamentoEJB) throws MozartSessionException;

	public abstract ApartamentoEJB obterApartamento(
			ApartamentoEJB paramApartamentoEJB) throws MozartSessionException;

	public abstract TipoApartamentoEJB obterTipoApartamento(
			TipoApartamentoEJB paramTipoApartamentoEJB)
			throws MozartSessionException;

	public abstract List<TipoApartamentoVO> pesquisarTipoApartamento(
			TipoApartamentoVO paramTipoApartamentoVO)
			throws MozartSessionException;

	public abstract CamareiraEJB obterCamareira(CamareiraEJB paramCamareiraEJB)
			throws MozartSessionException;

	public abstract List<CamareiraVO> pesquisarCamareira(
			CamareiraVO paramCamareiraVO) throws MozartSessionException;

	public abstract List<GarconEJB> obterGarcon(GarconEJB paramGarconEJB)
			throws MozartSessionException;

	public abstract void alterarStatusApartamentoLote(
			ApartamentoEJB paramApartamentoEJB1,
			ApartamentoEJB paramApartamentoEJB2, String paramString)
			throws MozartSessionException;

	public abstract List<ApartamentoVO> pesquisarArea(
			ApartamentoVO paramApartamentoVO) throws MozartSessionException;

	public abstract List<GarconVO> pesquisarGarcon(GarconVO paramGarconVO)
			throws MozartSessionException;

	public abstract List<ObjetoVO> pesquisarObjeto(ObjetoVO paramObjetoVO)
			throws MozartSessionException;

	public abstract List<MesaVO> pesquisarMesa(MesaVO paramMesaVO)
			throws MozartSessionException;

	public abstract List<TipoRefeicaoEJB> pesquisarTipoRefeicao(
			TipoRefeicaoEJB paramTipoRefeicaoEJB) throws MozartSessionException;

	public abstract List<PontoVendaVO> pesquisarPontoVenda(
			PontoVendaVO paramPontoVendaVO) throws MozartSessionException;

	public abstract List<ConfigFnrhEJB> pesquisarConfigFnrh(
			ConfigFnrhEJB paramConfigFnrhEJB) throws MozartSessionException;

	public abstract List<TipoLancamentoEJB> pesquisarTipoLancamentoPDV(
			TipoLancamentoEJB paramTipoLancamentoEJB)
			throws MozartSessionException;

	public abstract List<TipoLancamentoEJB> pesquisarTipoLancamentoServico(
			TipoLancamentoEJB paramTipoLancamentoEJB)
			throws MozartSessionException;

	public abstract List<PratoEJB> pesquisarPrato(PratoEJB paramPratoEJB)
			throws MozartSessionException;

	public abstract void gravarPontoVenda(PontoVendaEJB paramPontoVendaEJB)
			throws MozartSessionException;

	public abstract List<TipoItemEJB> pesquisarTipoItem(
			TipoItemEJB paramTipoItemEJB) throws MozartSessionException;

	public abstract List<UnidadeEstoqueEJB> pesquisarUnidadeEstoque(
			UnidadeEstoqueEJB paramUnidadeEstoqueEJB)
			throws MozartSessionException;

	public abstract void encerrarPontoVenda(PontoVendaEJB paramPontoVendaEJB)
			throws MozartSessionException;

	public abstract List<PontoVendaEJB> obterPontoVendaEncerramento(
			HotelEJB paramHotelEJB) throws MozartSessionException;

	public abstract void gravarTipoLancamento(
			TipoLancamentoEJB paramTipoLancamentoEJB)
			throws MozartSessionException;

	public abstract List<PontoVendaVO> pesquisarPontoVendaUsuario(
			UsuarioVO pUsuario
			) throws MozartSessionException;
	
	public abstract List<MesaEJB> pesquisarMesaLivre(Long idPontoVenda, String numMesa, String statusMesa)
			throws MozartSessionException;
	
	public abstract List<PratoEJB> pesquisarPrato(String nomePrato, Long idHotel)
			throws MozartSessionException;
	
	public abstract List<TipoLancamentoEJB> pesquisarTipoLancamentoContrato(
			TipoLancamentoEJB valor) throws MozartSessionException;
	
	public abstract BigDecimal obterQuantidadeMovimentosAbertos(
			HotelEJB hotelCorrente) throws MozartSessionException;
	
	public abstract List<NfeImpressoraEJB> pesquisarImpressoras() throws MozartSessionException;
	
	public abstract List<TipoLancamentoEJB> pesquisarTipoLancamentoContratoPagamento(TipoLancamentoEJB valor) throws MozartSessionException;
	
	public abstract void gravarRepresentante(RepresentanteRedeEJB representante)
			throws MozartSessionException;
	
	public abstract List<RepresentanteVO> pesquisarRepresentante(RepresentanteVO filtro)
			throws MozartSessionException;
	
	public abstract void gravarVendedor(VendedorRedeEJB vendedor)
			throws MozartSessionException;
	
	public abstract List<VendedorVO> pesquisarVendedor(VendedorVO filtro)
			throws MozartSessionException;
}
