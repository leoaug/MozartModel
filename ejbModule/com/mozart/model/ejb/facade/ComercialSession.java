package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.AdministradorCanaisEJB;
import com.mozart.model.ejb.entity.CaracteristicaEJB;
import com.mozart.model.ejb.entity.CaracteristicaGeralEJB;
import com.mozart.model.ejb.entity.HotelApartCaracteristicaEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.IdiomaMozartEJB;
import com.mozart.model.ejb.entity.NoticiaEJB;
import com.mozart.model.ejb.entity.PoliticaHotelEJB;
import com.mozart.model.ejb.entity.ProfissaoEJB;
import com.mozart.model.ejb.entity.TarifaEJB;
import com.mozart.model.ejb.entity.TipoApartamentoEJB;
import com.mozart.model.ejb.entity.TipoHospedeEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.AdministradorCanaisVO;
import com.mozart.model.vo.CanalVendaVO;
import com.mozart.model.vo.EmpresaAcessoVO;
import com.mozart.model.vo.GrupoEconomicoVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.PermutaVO;
import com.mozart.model.vo.ProfissaoVO;
import com.mozart.model.vo.TarifaGrupoVO;
import com.mozart.model.vo.TarifaVO;


@Remote
public interface ComercialSession {
	
	String QRY_TARIFA_GRUPO = 
		" select t.id_tarifa_grupo, t.id_hotel, t.descricao, h.sigla " +
		" from tarifa_grupo t, hotel h " +
		" where t.id_hotel = h.id_hotel ";

	String QRY_PROFISSAO = 
		" select id_profissao, profissao " +
		" from profissao ";
	
	String QRY_GRUPO_ECONOMICO = 
		" select ge.id_grupo_economico, ge.id_hotel, ge.nome_grupo, decode(ge.hotel_empresa,'E','EMPRESA','HOTEL') hotel_empresa, h.sigla" +
		" from grupo_economico ge, hotel h " +
		" where ge.id_hotel = h.id_hotel ";
		
	
	String QRY_HOSPEDE = 
		" select hos.id_hospede, trim(hos.nome_hospede)||' '||trim(hos.sobrenome_hospede) nome_hospede," +
		" hos.cpf, hos.nascimento, hos.passaporte, hos.identidade, hos.telefone, hos.fax, hos.telex, hos.celular, hos.email" +
		" from hospede hos " +
		" where " +
		" 1 = 1 ";
	

	String QRY_PERMUTA = "" +
			" SELECT P.ID_PERMUTA, ER.NOME_FANTASIA, P.DESCRICAO, P.DATA_INICIO, P.DATA_FIM, P.QTD_DIARIA, P.VALOR_DIARIA, H.SIGLA " +
			" FROM PERMUTA P, EMPRESA_HOTEL EH, EMPRESA_REDE ER, HOTEL H " +
			" WHERE P.ID_EMPRESA = EH.ID_EMPRESA " +
			" AND P.ID_HOTEL = EH.ID_HOTEL " +
			" AND EH.ID_EMPRESA = ER.ID_EMPRESA " +
			" AND EH.ID_REDE_HOTEL = ER.ID_REDE_HOTEL AND EH.ID_HOTEL = H.ID_HOTEL "; 
	
	String QRY_EMPRESA_ACESSO = "" +
			" select ea.id_user, ea.nome, ea.username, ea.email, ea.master, ea.data_validade, ea.ativo, e.nome_fantasia " +
			" from empresa_acesso ea, empresa e " +
			" where ea.id_empresa = e.id_empresa ";
	
	
	
	String QRY_CANAL_VENDA=" SELECT GC.ID_GDS_CANAL, "
			+ " GC.ID_GDS, "
			+ " GC.ID_EMPRESA, "
			+ " GC.ID_HOTEL, "
			+ " GC.CODIGO, "
			+ " GC.ATIVO, "
			+ " ER.NOME_FANTASIA, "
			+ " ER_GDS.NOME_FANTASIA  NOME_ADM_CANAL "
			+ " FROM GDS_CANAL GC "
			+ " JOIN GDS "
			+ "     ON (GC.ID_GDS = GDS.ID_GDS) "
			+ "	JOIN EMPRESA_REDE ER_GDS"
			+ "     ON GDS.ID_EMPRESA = ER_GDS.ID_EMPRESA "
			+ "     AND GDS.ID_REDE_HOTEL = ER_GDS.ID_REDE_HOTEL "
			+ " JOIN EMPRESA_REDE ER "
			+ "     ON (GC.ID_EMPRESA = ER.ID_EMPRESA) "
			+ " JOIN HOTEL H "
			+ "     ON GC.ID_HOTEL = H.ID_HOTEL "
			+ "     AND H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL "; 
	
	
	String QRY_TARIFA = 
		" select t.id_tarifa, t.descricao, t.data_entrada, t.data_saida, t.tipo, trim(t.observacao) obs, t.id_hotel, h.sigla, decode(t.ativo,'S','Sim','Não') ativo, t.id_moeda, m.simbolo, tg.descricao grupoTarifa, log.nick "+ 
		" from tarifa t, hotel h, moeda m, tarifa_grupo tg,  "+
		"	 (select unique id_auditado, substr(u.nick,8) nick  "+
		"		from log_usuario log, usuario u "+
		"		where instr(?1, ';'||log.id_hotel||';') >= 1 "+
		"		and log.tabela_auditada = 'TARIFA' "+
		"		and log.operacao = 'Inclusão' "+
		"		and log.id_usuario = u.id_usuario "+
		"		) log "+ 
		" where instr(?2, ';'||t.id_hotel||';') >= 1 "+
		" and t.id_hotel = h.id_hotel "+
		" and m.id_moeda = t.id_moeda "+
		" and t.id_tarifa_grupo = tg.id_tarifa_grupo(+) "+
		" and t.id_tarifa = log.id_auditado ";

	
	String QRY_VALIDA_PERIODO = 
		" SELECT TARIFA.ID_TARIFA "+ 
		" FROM TARIFA "+ 
		" WHERE TARIFA.TIPO = ?1 "+ 
		" AND TARIFA.TIPO <> 'A' "+
		" AND  (TRUNC(?2) between TRUNC(TARIFA.DATA_ENTRADA)  and TRUNC(TARIFA.DATA_SAIDA) or "+ 
		"  	  TRUNC(?3) between TRUNC(TARIFA.DATA_ENTRADA)  and TRUNC(TARIFA.DATA_SAIDA) ) "+
		" AND TARIFA.ID_HOTEL = ?4 "+
		" AND TARIFA.ID_MOEDA = ?5 "+ 
		" and TARIFA.ATIVO = 'S' "+
		" AND TARIFA.ID_TARIFA <> ? ";

	List<TarifaGrupoVO> pesquisarTarifaGrupo (TarifaGrupoVO filtro) throws MozartSessionException;
	List<ProfissaoVO> pesquisarProfissao (ProfissaoVO filtro) throws MozartSessionException;
	List<GrupoEconomicoVO> pesquisarGrupoEconomico(GrupoEconomicoVO filtro)throws MozartSessionException;
	List<HospedeVO> pesquisarHospede(HospedeVO filtro)throws MozartSessionException;
	List<TipoHospedeEJB> obterTipoHospede(TipoHospedeEJB thFiltro)throws MozartSessionException;
	List<ProfissaoEJB> obterProfissao()throws MozartSessionException;
	List<PermutaVO> pesquisarPremuta(PermutaVO filtro)throws MozartSessionException;
	List<EmpresaAcessoVO> pesquisarEmpresaAcesso(EmpresaAcessoVO filtro)throws MozartSessionException;
	List<TarifaVO> pesquisarTarifa(TarifaVO filtro) throws MozartSessionException;
	void gravarTarifa(TarifaEJB entidade, List<TarifaEJB> listaTarifa) throws MozartSessionException;
	List<IdiomaMozartEJB> pesquisarIdioma(IdiomaMozartEJB filtro)throws MozartSessionException;
	List<CaracteristicaGeralEJB> pesquisarCaracteristicaGeral(Long idHotel);
	List<CaracteristicaGeralEJB> pesquisarCaracteristicaGeral(Long idHotel, Long idIdioma);
	List<CaracteristicaEJB> obterCaracteristicaHotel() throws MozartSessionException;
	List<CaracteristicaEJB> obterCaracteristicaDoHotel(HotelEJB hotelCorrente) throws MozartSessionException;
	List<CaracteristicaEJB> obterCaracteristicaTipoApartamento() throws MozartSessionException;
	List<TipoApartamentoEJB> obterCaracteristicaDoTipoApartamento(HotelEJB hotelCorrente)throws MozartSessionException;
	void gravarCaracteristicaHotelTipoApartamento(HotelEJB hotel,List<HotelApartCaracteristicaEJB> hotelApartCaracteristicaEJBList)throws MozartSessionException;
	List<NoticiaEJB> pesquisarNoticias(NoticiaEJB filtro)throws MozartSessionException;
	void gravarNoticia(NoticiaEJB entidade, List<NoticiaEJB> entidades)throws MozartSessionException;
	public PoliticaHotelEJB obterPoliticaHotel(PoliticaHotelEJB politicaHotel)throws MozartSessionException;
	
	public List<CanalVendaVO> pesquisarCanalVendas(CanalVendaVO filtro) throws MozartSessionException;
	
}
