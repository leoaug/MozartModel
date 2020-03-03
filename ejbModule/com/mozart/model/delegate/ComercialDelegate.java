package com.mozart.model.delegate;

import java.util.List;

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
import com.mozart.model.ejb.facade.ComercialSession;
import com.mozart.model.ejb.facade.ReservaSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.AdministradorCanaisVO;
import com.mozart.model.vo.CanalVendaVO;
import com.mozart.model.vo.EmpresaAcessoVO;
import com.mozart.model.vo.GrupoEconomicoVO;
import com.mozart.model.vo.HospedeVO;
import com.mozart.model.vo.PermutaVO;
import com.mozart.model.vo.ProfissaoVO;
import com.mozart.model.vo.TarifaGrupoVO;
import com.mozart.model.vo.TarifaVO;

public class ComercialDelegate extends MozartDelegate{

	
	    private static ComercialDelegate instance;
	    private static ComercialSession session;
	    

	    private ComercialDelegate() throws MozartSessionException {
	    
	        try{
	            session = (ComercialSession) getLookup("ComercialSession");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: ComercialSession");            
	            }
	        }catch(Exception ex){
	        
	            throw new MozartSessionException(ex.getMessage());             
	        
	        }
	    
	    }
	    
		private ComercialDelegate(String name) throws MozartSessionException {

			try {
	            session = (ComercialSession) getLookup(name, "ComercialSession");
				if (session == null) {
					throw new MozartSessionException("Não foi possivel localizar: ReservaSessionEJB");
				}
			} catch (Exception ex) {
				throw new MozartSessionException(ex.getMessage());
			}
		}

		public static ComercialDelegate instance(String name) throws MozartSessionException {
			return instance == null ? instance = new ComercialDelegate(name) : instance;
		}

	    
	    public static ComercialDelegate instance() throws MozartSessionException{
	        
	        return instance==null?instance = new ComercialDelegate() : instance;
	    
	    }
	    
	    
	    public List<TarifaGrupoVO> pesquisarTarifaGrupo(TarifaGrupoVO filtro) throws MozartSessionException{
	    	
	    	return session.pesquisarTarifaGrupo(filtro);
	    }

		public List<ProfissaoVO> pesquisarProfissao(ProfissaoVO filtro) throws MozartSessionException{
			
			return session.pesquisarProfissao(filtro);
			
		}

		public List<GrupoEconomicoVO> pesquisarGrupoEconomico(
				GrupoEconomicoVO filtro) throws MozartSessionException{

			return session.pesquisarGrupoEconomico(filtro);		
		}

		public List<HospedeVO> pesquisarHospede(HospedeVO filtro) throws MozartSessionException{
			return session.pesquisarHospede(filtro);		
		}

		public List<TipoHospedeEJB> obterTipoHospede(TipoHospedeEJB thFiltro) throws MozartSessionException{
			return session.obterTipoHospede(thFiltro);		
		}

		public List<ProfissaoEJB> obterProfissao() throws MozartSessionException{

			return session.obterProfissao();		
		}

		public List<PermutaVO> pesquisarPremuta(PermutaVO filtro)  throws MozartSessionException{
			
			return session.pesquisarPremuta(filtro);
			
		}

		public List<EmpresaAcessoVO> pesquisarEmpresaAcesso(EmpresaAcessoVO filtro)  throws MozartSessionException{
			return session.pesquisarEmpresaAcesso(filtro);		
		}
		
		
		
		public List<CanalVendaVO> pesquisarCanalVendas(CanalVendaVO filtro)  throws MozartSessionException{
			return session.pesquisarCanalVendas(filtro);		
		}

		public List<TarifaVO> pesquisarTarifa(TarifaVO filtro)  throws MozartSessionException{

			return session.pesquisarTarifa(filtro);	
		}

		public void gravarTarifa(TarifaEJB entidade, List<TarifaEJB> listaTarifa)  throws MozartSessionException{
			try{
				
				session.gravarTarifa(entidade, listaTarifa);
	    	}catch(MozartValidateException ex){
	    		throw ex;
	
			}catch(Exception ex){
				String msg = ex.getCause().getCause().getMessage();
				if (msg.indexOf("-2000") >= 0){
					throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
				}else{
					throw new MozartSessionException(ex.getMessage());
				}
			}
			
			
		}
		
		public List<IdiomaMozartEJB> pesquisarIdioma(IdiomaMozartEJB filtro)  throws MozartSessionException{

			return session.pesquisarIdioma(filtro);	
		}

		public List<CaracteristicaGeralEJB> pesquisarCaracteristicaGeral(
				Long idHotel) {

			return session.pesquisarCaracteristicaGeral(idHotel);	
		}
		public List<CaracteristicaGeralEJB> pesquisarCaracteristicaGeral(
				Long idHotel, Long idIdioma) {
			
			return session.pesquisarCaracteristicaGeral(idHotel, idIdioma);	
		}

		public List<CaracteristicaEJB> obterCaracteristicaHotel()  throws MozartSessionException{

			return session.obterCaracteristicaHotel();
		}

		public List<CaracteristicaEJB> obterCaracteristicaDoHotel(
				HotelEJB hotelCorrente) throws MozartSessionException{
			
			return session.obterCaracteristicaDoHotel(hotelCorrente);
			
		}

		public List<CaracteristicaEJB> obterCaracteristicaTipoApartamento() throws MozartSessionException{

			return session.obterCaracteristicaTipoApartamento();
		}

		public List<TipoApartamentoEJB> obterCaracteristicaDoTipoApartamento(
				HotelEJB hotelCorrente) throws MozartSessionException{

			return session.obterCaracteristicaDoTipoApartamento(hotelCorrente);
		}

		public void gravarCaracteristicaHotelTipoApartamento(
				HotelEJB hotel,
				List<HotelApartCaracteristicaEJB> hotelApartCaracteristicaEJBList)  throws MozartSessionException{

			session.gravarCaracteristicaHotelTipoApartamento(hotel, hotelApartCaracteristicaEJBList);
			
		}

		public List<NoticiaEJB> pesquisarNoticias(NoticiaEJB filtro) throws MozartSessionException{

			return session.pesquisarNoticias( filtro );
		}

		public void gravarNoticia(NoticiaEJB entidade,
				List<NoticiaEJB> entidades)  throws MozartSessionException{
				
			session.gravarNoticia(entidade, entidades);
			
		}
		
		
		public PoliticaHotelEJB obterPoliticaHotel(PoliticaHotelEJB politicaHotel) throws MozartSessionException{

			return session.obterPoliticaHotel(politicaHotel);
		}
	    
}