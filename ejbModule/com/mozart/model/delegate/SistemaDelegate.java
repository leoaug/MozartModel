package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.EstadoEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MensagemWebEJB;
import com.mozart.model.ejb.entity.MensagemWebUsuarioEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.ejb.facade.SistemaSession;
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

public class SistemaDelegate extends MozartDelegate{

	
	  private static SistemaDelegate instance;
	  private static SistemaSession session;
	    

	    private SistemaDelegate() throws MozartSessionException {
	    
	        try{
	        
	            session = (SistemaSession) getLookup("SistemaSession");
	            if (session == null){
	                throw new MozartSessionException("Não foi possivel localizar: SistemaSession");            
	            }
	        }catch(Exception ex){
	        
	            throw new MozartSessionException(ex.getMessage());             
	        
	        }
	    
	    }
	    
	    public static SistemaDelegate instance() throws MozartSessionException{
	    
	        return instance==null?instance = new SistemaDelegate() : instance;
	    
}
	    
	    
	    public List<CidadeVO> pesquisarCidade(CidadeVO filtro) throws MozartSessionException {
			return session.pesquisarCidade(filtro);
		}
	    
	    public List<EstadoEJB> pesquisarEstado() throws MozartSessionException {
			return session.pesquisarEstado();
		}
	    
	    public List<BancoVO> pesquisarBanco(BancoVO filtro) throws MozartSessionException {
			return session.pesquisarBanco(filtro);
		}
	    public List<BancoVO> pesquisarBancoCombo(BancoVO filtro) throws MozartSessionException {
	    	return session.pesquisarBancoCombo(filtro);
	    }
	    public List<BancoVO> pesquisarBancoComboAutoComplete(BancoVO filtro) throws MozartSessionException {
	    	return session.pesquisarBancoComboAutoComplete(filtro);
	    }

		public List<MensagemWebUsuarioEJB> pesquisarMensagens(
				UsuarioEJB usuarioEJB) throws MozartSessionException{
			
			return session.pesquisarMensagens(usuarioEJB);		
		}

		public List<MensagemWebVO> pesquisarMensagem(MensagemWebVO filtro) throws MozartSessionException{
			return session.pesquisarMensagens(filtro);		
		}

		public List<HotelVO> pesquisarHotel(HotelVO hotelVO) throws MozartSessionException{
			return session.pesquisarHotel(hotelVO);		
		}

		public List<RedeHotelVO> pesquisarRedeHotel(RedeHotelVO redeHotelVO)  throws MozartSessionException{
			return session.pesquisarRedeHotel(redeHotelVO);			
		}

		public List<UsuarioVO> pesquisarUsuario(Long idRedeHotel, Long idHotel,
				String usuarioAdm, String suporteMozart)  throws MozartSessionException{
			
			return session.pesquisarUsuario(idRedeHotel, idHotel, usuarioAdm, suporteMozart);

		}

		public void gravarMensagem(MensagemWebEJB entidade)  throws MozartSessionException{
			session.gravarMensagem(entidade);
		}

		public List<MensagemWebUsuarioVO> pesquisarMensagemWebUsuario(MensagemWebUsuarioVO filtro) throws MozartSessionException{
			return session.pesquisarMensagensWebUsuario(filtro);
		}
		
		public List<BancoVO> pesquisarBancoUsadoNoHotel(Long idHotel) throws MozartSessionException {
			return session.pesquisarBancoUsadoNoHotel(idHotel);
		}

		public List<RedeHotelEJB> pesquisarRedeHotel() throws MozartSessionException {

			return session.pesquisarRedeHotel();
		}
	    
		public List<HotelEJB> pesquisarHotelEJB(HotelVO filtro) throws MozartSessionException {

			return session.pesquisarHotelEJB(filtro);
		}
		
		public List<ControlaDataEJB> pesquisarControlaData(ControlaDataVO filtro) throws MozartSessionException {

			return session.pesquisarControlaData(filtro);
		}
		
		public List<RedeHotelEJB> pesquisarRedeHotelEJB(RedeHotelVO filtro) throws MozartSessionException {

			return session.pesquisarRedeHotelEJB(filtro);
		}
		
		public List<EmpresaVO> pesquisarEmpresa(EmpresaVO filtro)  throws MozartSessionException{

			return session.pesquisarEmpresa(filtro);
		}

		public List<AchadosPerdidoVO> pesquisarAchadosPerdido(AchadosPerdidoVO filtro) throws MozartSessionException{

			return session.pesquisarAchadosPerdido(filtro);
		}

		public List<HospedeAchadosPerdidoVO> pesquisarHospedeAP(HospedeAchadosPerdidoVO ap) throws MozartSessionException{

			return session.pesquisarHospedeAP(ap);
		}
		public List<NotaFiscalVO> pesquisarNotaFiscal(NotaFiscalVO filtro) throws MozartSessionException{
			return session.pesquisarNotaFiscal(filtro);
		}
		public List<String> pesquisarUltimaNotaFiscalEnviada(NotaFiscalVO filtro) throws MozartSessionException{
			return session.pesquisarUltimaNotaFiscalEnviada(filtro);
		}
		public ConfiguracaoTributarioVO pesquisarConfiguracaoTributaria(ConfiguracaoTributarioVO filtro)
				throws MozartSessionException{
			return session.pesquisarConfiguracaoTributaria(filtro);
		}
		
		public List<ExigibilidadeVO> obterExigibilidade() throws MozartSessionException{
			return session.obterExigibilidade();
		}
		
		public List<RegimeTributarioVO>  obterRegimeTributario() throws MozartSessionException{
			return session.obterRegimeTributario();
		}
		
		public List<UsuarioVO> obterComboUsuarios(UsuarioVO filtro) throws MozartSessionException{
			return session.obterComboUsuarios(filtro);
		}
				
//		public List<ListaFiscalServicoVO> pesquisarListaServicoFiscal(ListaFiscalServicoVO filtro) throws MozartSessionException{
//			return session.pesquisarListaServicoFiscal(filtro);
//		}
		
}