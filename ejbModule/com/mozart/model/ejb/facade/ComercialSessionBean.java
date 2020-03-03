package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.AdministradorCanaisVO;
import com.mozart.model.vo.CanalVendaVO;
import com.mozart.model.vo.EmpresaAcessoVO;
import com.mozart.model.vo.GrupoEconomicoVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.PermutaVO;
import com.mozart.model.vo.ProfissaoVO;
import com.mozart.model.vo.TarifaGrupoVO;
import com.mozart.model.vo.TarifaVO;


@SuppressWarnings("unchecked")
@Stateless(name="ComercialSession")
public class ComercialSessionBean implements ComercialSession{
	
	@PersistenceContext(unitName="MozartModel")
	private EntityManager manager;
	
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<TarifaGrupoVO> pesquisarTarifaGrupo (TarifaGrupoVO filtro) throws MozartSessionException{
		
		String sql = QRY_TARIFA_GRUPO;
		
		if (!MozartUtil.isNull(filtro.getFiltroDescricao().getTipoIntervalo())){
			sql += " and UPPER(t.descricao) " + filtro.getFiltroDescricao();
		}
		
		if  (!MozartUtil.isNull(filtro.getIdHoteis())){
             sql += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||t.id_hotel||';') >= 1 ";
        }
		sql += " and h.id_rede_hotel = " + filtro.getIdRedeHotel();
        sql +=  " order by t.descricao";
		
        
        
        List lista = manager.createNativeQuery( sql ).
		        getResultList();
		List<TarifaGrupoVO> resultado = new ArrayList<TarifaGrupoVO>();                     
		for (Object l: lista){
			resultado.add( new TarifaGrupoVO( (Object[])l ) );
		}           
		return resultado;
		
	}


	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ProfissaoVO> pesquisarProfissao(ProfissaoVO filtro)
			throws MozartSessionException {
		
		String sql = QRY_PROFISSAO;
		
		if (!MozartUtil.isNull(filtro.getFiltroProfissao().getTipoIntervalo())){
			sql += " where UPPER(profissao) " + filtro.getFiltroProfissao();
		}
		
        sql +=  " order by profissao";
		
        
        List lista = manager.createNativeQuery( sql ).
		        getResultList();
		List<ProfissaoVO> resultado = new ArrayList<ProfissaoVO>();                     
		for (Object l: lista){
			resultado.add( new ProfissaoVO( (Object[])l ) );
		}           
		return resultado;
	}


	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<GrupoEconomicoVO> pesquisarGrupoEconomico(GrupoEconomicoVO filtro) throws MozartSessionException {

		String sql = QRY_GRUPO_ECONOMICO;
		
		if (!MozartUtil.isNull(filtro.getFiltroNomeGrupo().getTipoIntervalo())){
			sql += " and UPPER(ge.nome_grupo) " + filtro.getFiltroNomeGrupo();
		}
		
		if (!MozartUtil.isNull(filtro.getFiltroTipoGrupo().getTipoIntervalo())){
			sql += " and decode(ge.hotel_empresa,'E','EMPRESA','HOTEL') " + filtro.getFiltroTipoGrupo();
		}
		
		if  (!MozartUtil.isNull(filtro.getIdHoteis())){
             sql += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||h.id_hotel||';') >= 1 ";
        }
		sql += " and h.id_rede_hotel = " + filtro.getIdRedeHotel();
        sql +=  " order by ge.nome_grupo ";
		
        
        
        List lista = manager.createNativeQuery( sql ).getResultList();
		List<GrupoEconomicoVO> resultado = new ArrayList<GrupoEconomicoVO>();                     
		for (Object l: lista){
			resultado.add( new GrupoEconomicoVO( (Object[])l ) );
		}           
		return resultado;
	}


	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<HospedeVO> pesquisarHospede(HospedeVO filtro)
			throws MozartSessionException {
		String sql = QRY_HOSPEDE;
		
		if (!MozartUtil.isNull(filtro.getFiltroNome().getTipoIntervalo())){
			sql += " and UPPER(hos.nome_hospede) " + filtro.getFiltroNome();
		}
		if (!MozartUtil.isNull(filtro.getFiltroSobrenome().getTipoIntervalo())){
			sql += " and UPPER(hos.sobrenome_hospede) " + filtro.getFiltroSobrenome();
		}
		if (!MozartUtil.isNull(filtro.getFiltroCpf().getTipoIntervalo())){
			sql += " and UPPER(hos.cpf) " + filtro.getFiltroCpf();
		}
		if (!MozartUtil.isNull(filtro.getFiltroIdentidade().getTipoIntervalo())){
			sql += " and UPPER(hos.identidade) " + filtro.getFiltroIdentidade();
		}
		if (!MozartUtil.isNull(filtro.getFiltroTelefone().getTipoIntervalo())){
			sql += " and UPPER(hos.telefone) " + filtro.getFiltroTelefone();
		}
		if (!MozartUtil.isNull(filtro.getFiltroPassaporte().getTipoIntervalo())){
			sql += " and UPPER(hos.passaporte) " + filtro.getFiltroPassaporte();
		}
		
		if  (!MozartUtil.isNull(filtro.getIdHoteis())){
           //sql += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||h.id_hotel||';') >= 1 ";
        }
		sql += " and hos.id_rede_hotel = " + filtro.getIdRedeHotel();
        sql +=  " order by nome_hospede ";
		
        List lista = manager.createNativeQuery( sql ).getResultList();
		List<HospedeVO> resultado = new ArrayList<HospedeVO>();                     
		for (Object l: lista){
			resultado.add( new HospedeVO( (Object[])l ) );
		}           
		return resultado;
	}


	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<TipoHospedeEJB> obterTipoHospede(TipoHospedeEJB thFiltro)
			throws MozartSessionException {

		if (MozartUtil.isNull( thFiltro ) || MozartUtil.isNull( thFiltro.getIdRedeHotel() ) ){
			throw new MozartValidateException("Filtro inválido");
		}

		if(MozartUtil.isNull(thFiltro.getPadrao())){
			return manager.createQuery("select o from TipoHospedeEJB o where o.idRedeHotel = ?1 order by o.tipoHospede").setHint("eclipselink.refresh", "TRUE").
					setParameter(1, thFiltro.getIdRedeHotel()).getResultList();
			
		}
		else{
			return manager.createQuery("select o from TipoHospedeEJB o where o.idRedeHotel = ?1 and o.padrao = ?2 order by o.tipoHospede").setHint("eclipselink.refresh", "TRUE").
					setParameter(1, thFiltro.getIdRedeHotel()).setParameter(2, thFiltro.getPadrao()).getResultList();

		}
	}

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ProfissaoEJB> obterProfissao() throws MozartSessionException {
		return manager.createQuery("select o from ProfissaoEJB o order by o.profissao").setHint("eclipselink.refresh", "TRUE").getResultList();
	}

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<PermutaVO> pesquisarPremuta(PermutaVO filtro)
			throws MozartSessionException {
		String sql = QRY_PERMUTA;
		
		if (!MozartUtil.isNull(filtro.getFiltroEmpresa().getTipoIntervalo())){
			sql += " and UPPER(ER.NOME_FANTASIA) " + filtro.getFiltroEmpresa();
		}
		if (!MozartUtil.isNull(filtro.getFiltroContrato().getTipoIntervalo())){
			sql += " and UPPER(P.ID_PERMUTA) " + filtro.getFiltroContrato();
		}
		if (!MozartUtil.isNull(filtro.getFiltroDataFim().getTipoIntervalo())){
			sql += " and TRUNC(P.DATA_FIM) " + filtro.getFiltroDataFim();
		}
		if (!MozartUtil.isNull(filtro.getFiltroDataInicio().getTipoIntervalo())){
			sql += " and TRUNC(P.DATA_INICIO) " + filtro.getFiltroDataInicio();
		}
		if (!MozartUtil.isNull(filtro.getFiltroQtdeDiaria().getTipoIntervalo())){
			sql += " and UPPER(P.QTD_DIARIA) " + filtro.getFiltroQtdeDiaria();
		}
		if (!MozartUtil.isNull(filtro.getFiltroValorDiaria().getTipoIntervalo())){
			sql += " and UPPER(P.VALOR_DIARIA) " + filtro.getFiltroValorDiaria();
		}
		
		if  (!MozartUtil.isNull(filtro.getIdHoteis())){
             sql += " and instr('"+filtro.getIdHoteisSQL()+"', ';'||h.id_hotel||';') >= 1 ";
        }
		sql += " and h.id_rede_hotel = " + filtro.getIdRedeHotel();
        sql +=  " order by ER.NOME_FANTASIA ";
		
        List lista = manager.createNativeQuery( sql ).getResultList();
		List<PermutaVO> resultado = new ArrayList<PermutaVO>();                     
		for (Object l: lista){
			resultado.add( new PermutaVO( (Object[])l ) );
		}           
		return resultado;
	}

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<EmpresaAcessoVO> pesquisarEmpresaAcesso(EmpresaAcessoVO filtro)
			throws MozartSessionException {
	
		String sql = QRY_EMPRESA_ACESSO;

		if (!MozartUtil.isNull(filtro.getFiltroAtivo().getTipoIntervalo())){
			sql += " and UPPER(ea.ativo) " + filtro.getFiltroAtivo();
		}
		if (!MozartUtil.isNull(filtro.getFiltroMaster().getTipoIntervalo())){
			sql += " and UPPER(ea.master) " + filtro.getFiltroMaster();
		}
		if (!MozartUtil.isNull(filtro.getFiltroNome().getTipoIntervalo())){
			sql += " and UPPER(ea.nome) " + filtro.getFiltroNome();
		}
		if (!MozartUtil.isNull(filtro.getFiltroNomeFantasia().getTipoIntervalo())){
			sql += " and UPPER(e.nome_fantasia) " + filtro.getFiltroNomeFantasia();
		}
		if (!MozartUtil.isNull(filtro.getFiltroValidade().getTipoIntervalo())){
			sql += " and TRUNC(ea.data_validade) " + filtro.getFiltroValidade();
		}
        sql +=  " order by e.nome_fantasia "; 
		
        List lista = manager.createNativeQuery( sql ).getResultList();
		List<EmpresaAcessoVO> resultado = new ArrayList<EmpresaAcessoVO>();                     
		for (Object l: lista){
			resultado.add( new EmpresaAcessoVO( (Object[])l ) );
		}           
		return resultado;	
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<CanalVendaVO> pesquisarCanalVendas(CanalVendaVO filtro)
			throws MozartSessionException {
		
		String sql = QRY_CANAL_VENDA;
		String sqlConector = " ", sqlFiltro="";
		
		if (!MozartUtil.isNull(filtro.getEmpresa().getTipoIntervalo())){
			sqlFiltro += sqlConector +  " UPPER(ER.NOME_FANTASIA) " + filtro.getEmpresa().toString().toUpperCase();
			sqlConector = "\n AND ";
		}
		if (!MozartUtil.isNull(filtro.getIdHotel())){
			sqlFiltro += sqlConector + " GC.ID_HOTEL = " + filtro.getIdHotel();
			sqlConector = "\n AND ";
		}

		if(!MozartUtil.isNull(sqlFiltro)){
			sql += " WHERE \n" + sqlFiltro;
		}
		sql +=  "\n order by er.nome_fantasia "; 
		
		List lista = manager.createNativeQuery( sql ).getResultList();
		List<CanalVendaVO> resultado = new ArrayList<CanalVendaVO>();                     
		for (Object l: lista){
			resultado.add( new CanalVendaVO( (Object[])l ) );
		}           
		return resultado;	
	}


	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<TarifaVO> pesquisarTarifa(TarifaVO filtro) throws MozartSessionException {
		
			String sql = QRY_TARIFA; 
			boolean entrou = false;
			if (!MozartUtil.isNull(filtro.getFiltroDataEntrada().getTipoIntervalo())){
				sql += " and t.data_entrada " + filtro.getFiltroDataEntrada();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataSaida().getTipoIntervalo())){
				sql += " and t.data_saida " + filtro.getFiltroDataSaida();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDescricao().getTipoIntervalo())){
				sql += " and upper(t.descricao) " + filtro.getFiltroDescricao();
			}
			if (!MozartUtil.isNull(filtro.getFiltroGrupoTarifa().getTipoIntervalo())){
				sql += " and upper(tg.descricao) " + filtro.getFiltroGrupoTarifa();
			}
			if (!MozartUtil.isNull(filtro.getFiltroTipoTarifa().getTipoIntervalo())){
				sql += " and upper(t.tipo) " + filtro.getFiltroTipoTarifa();
			}
			if (!MozartUtil.isNull(filtro.getFiltroAtivo().getTipoIntervalo())){
				sql += " and upper(t.ativo) " + filtro.getFiltroAtivo();
			}
			if (!MozartUtil.isNull(filtro.getFiltroPassandoPor().getTipoIntervalo())){
				sql += " and (";
					if (!MozartUtil.isNull(filtro.getFiltroPassandoPor().getValorInicial())){
						entrou = true;
						sql += "to_date('" + filtro.getFiltroPassandoPor().getValorInicial()+"','dd/mm/yyyy') between t.data_entrada and t.data_saida ";
					}
					if (!MozartUtil.isNull(filtro.getFiltroPassandoPor().getValorFinal()))
						sql += (entrou?" AND ":" ") + " to_date('" + filtro.getFiltroPassandoPor().getValorFinal()+"','dd/mm/yyyy') between t.data_entrada and t.data_saida ";
					
				sql += ")";		
			}
			
	        sql +=  " order by t.descricao";
			
	        List lista = manager.createNativeQuery( sql ).
	        	setParameter(1, filtro.getIdHoteisSQL()).
	        	setParameter(2, filtro.getIdHoteisSQL()).
	        	getResultList();
	        
			List<TarifaVO> resultado = new ArrayList<TarifaVO>();                     
			for (Object l: lista){
				resultado.add( new TarifaVO( (Object[])l ) );
			}           
			return resultado;
			
	}

	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void gravarTarifa(TarifaEJB entidade, List<TarifaEJB> listaTarifa) throws MozartSessionException {
		
		try{
			for (TarifaEJB tarifa : listaTarifa){
				
				
				if (tarifa.getIdTarifa() == null){
					
					manager.persist( tarifa );
				}else{
					manager.createNativeQuery("delete from tarifa_idioma where id_tarifa = ?1").
							setParameter(1, tarifa.getIdTarifa()).
							executeUpdate();
					manager.merge( tarifa );
					
				}
			}
			
		}catch(Exception ex){
				throw new MozartSessionException(ex.getMessage());
		}
	}


	public List<IdiomaMozartEJB> pesquisarIdioma(IdiomaMozartEJB filtro)
			throws MozartSessionException {
			
		return (List<IdiomaMozartEJB>)manager.createQuery("select o from IdiomaMozartEJB o order by o.descricao").setHint("eclipselink.refresh", "TRUE").getResultList();

	}


	public List<CaracteristicaGeralEJB> pesquisarCaracteristicaGeral(Long idHotel) {
		return manager.createQuery("select o from CaracteristicaGeralEJB o where o.idHotel = ?1").setParameter(1, idHotel).getResultList();
	}
	
	public List<CaracteristicaGeralEJB> pesquisarCaracteristicaGeral(Long idHotel, Long idIdioma) {
		return manager.createQuery("select o from CaracteristicaGeralEJB o where o.idHotel = ?1  and o.idioma.idIdioma = ?2")
				.setParameter(1, idHotel)
				.setParameter(2, idIdioma)
				.getResultList();
	}


	public List<CaracteristicaEJB> obterCaracteristicaHotel() throws MozartSessionException {
		try{
			return (List<CaracteristicaEJB>)manager.createNamedQuery("CaracteristicaEJB.findByHotel").getResultList();
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}	
	}

	public List<CaracteristicaEJB> obterCaracteristicaDoHotel(HotelEJB pHotel) throws MozartSessionException {
		try{
			String sql = 
				" SELECT C.* "+ 
				" FROM CARACTERISTICAS C, HOTEL_APART_CARACTERISTICAS HAC "+
				" WHERE C.ID_CARACTERISTICA = HAC.ID_CARACTERISTICA "+
				" AND HAC.ID_HOTEL = ?1 "+
				" AND HAC.ID_TIPO_APARTAMENTO IS NULL ";

			return (List<CaracteristicaEJB>)manager.createNativeQuery(sql, CaracteristicaEJB.class)
					.setParameter(1, pHotel.getIdHotel())
					.getResultList();
			
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}	
	}


	public List<CaracteristicaEJB> obterCaracteristicaTipoApartamento() throws MozartSessionException {
		try{
			return (List<CaracteristicaEJB>)manager.createNamedQuery("CaracteristicaEJB.findByTipoApartamento").getResultList();
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}	
	}


	public List<TipoApartamentoEJB> obterCaracteristicaDoTipoApartamento(HotelEJB hotelCorrente) throws MozartSessionException {
		try{
			List<TipoApartamentoEJB> tipoAptoList = 
						manager.createQuery("select o from TipoApartamentoEJB o where o.idHotel = ?1 order by o.tipoApartamento")
						.setParameter(1, hotelCorrente.getIdHotel())
						.getResultList();
			
			String sql = 
				" SELECT C.* "+ 
				" FROM CARACTERISTICAS C, HOTEL_APART_CARACTERISTICAS HAC "+
				" WHERE C.ID_CARACTERISTICA = HAC.ID_CARACTERISTICA "+
				" AND HAC.ID_TIPO_APARTAMENTO = ?1 ";

			for (TipoApartamentoEJB tipo: tipoAptoList){
				
					tipo.setCaracteristicaList(
							manager.createNativeQuery(sql, CaracteristicaEJB.class)
							.setParameter(1, tipo.getIdTipoApartamento())
							.getResultList()
					);
			}	
			
			return tipoAptoList;
			
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
		
	
	}

	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public void gravarCaracteristicaHotelTipoApartamento(HotelEJB hotel,
			List<HotelApartCaracteristicaEJB> hotelApartCaracteristicaEJBList)
			throws MozartSessionException {

		try{

			manager.createNativeQuery("DELETE HOTEL_APART_CARACTERISTICAS WHERE ID_HOTEL = ?1")
									.setParameter(1, hotel.getIdHotel())
									.executeUpdate();
			
			for(HotelApartCaracteristicaEJB carac: hotelApartCaracteristicaEJBList){
				manager.persist( carac );
			}
			
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
	}


	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<NoticiaEJB> pesquisarNoticias(NoticiaEJB filtro) throws MozartSessionException {
		try{
			
			String sql = "NoticiaEJB.findByHotel";
			Long param = filtro.getIdHotel();
			
			if (filtro.getId()!=null && filtro.getId().getIdNoticia()!=null){
				sql = "NoticiaEJB.findByIdNoticia";
				param = filtro.getId().getIdNoticia();
			}
			
	        List<NoticiaEJB> lista = manager.createNamedQuery(sql)
	        						.setParameter(1, param)
	        						.getResultList();
	        return lista;
	        
		}catch(Exception ex){
			throw new MozartSessionException ( ex.getMessage() );
		}
		
	}

	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public void gravarNoticia(NoticiaEJB entidade, List<NoticiaEJB> entidades)throws MozartSessionException {
		try{
			Long id = entidade.getId().getIdNoticia();
			if (id == null){
				id = ((BigDecimal)manager.createNativeQuery("SELECT MOZART.ID.NEXTVAL from dual").getSingleResult()).longValue();
			}
			
			for (NoticiaEJB noticia: entidades){
				noticia.getId().setIdNoticia( id );
				if (noticia.getId().getIdNoticia()!=null){
					manager.merge( noticia );
				}else{
					manager.persist( noticia );
				}
			}
				
		}catch(Exception ex){
			throw new MozartSessionException ( ex.getMessage() );
		}
		
	}
	

	public PoliticaHotelEJB obterPoliticaHotel(PoliticaHotelEJB politicaHotel)throws MozartSessionException {
			
		try{
			List<PoliticaHotelEJB> lista=
			manager.createQuery("select o from PoliticaHotelEJB o where o.idHotel=?1").setParameter(1, politicaHotel.getIdHotel()).getResultList();
			if (MozartUtil.isNull(lista)){
			
				return new PoliticaHotelEJB();
			}else {
				
				return lista.get(0);
			}
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
		
	}


	
}
