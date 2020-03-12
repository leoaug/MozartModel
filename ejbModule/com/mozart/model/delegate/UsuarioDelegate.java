package com.mozart.model.delegate;

import com.mozart.model.ejb.entity.ConfigWebEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MenuMozartWebEJB;
import com.mozart.model.ejb.entity.MenuMozartWebUsuarioEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.ejb.entity.UsuarioSessionEJB;
import com.mozart.model.ejb.facade.ReservaSession;
import com.mozart.model.ejb.facade.UsuarioSession;
import com.mozart.model.exception.MozartSessionException;

import java.util.List;

public class UsuarioDelegate extends MozartDelegate{


    private static UsuarioDelegate instance;
    private static UsuarioSession session;

    private UsuarioDelegate() throws MozartSessionException{
            try{
                session = (UsuarioSession) getLookup("UsuarioSession");
            }catch(Exception ex){
                throw new MozartSessionException(ex.getMessage());             
            }
            
    }
    
    
    public static UsuarioDelegate instance() throws MozartSessionException{
    
        return instance==null?instance = new UsuarioDelegate() : instance;
    
    }
    
	private UsuarioDelegate(String name) throws MozartSessionException {

		try {
            session = (UsuarioSession) getLookup(name, "UsuarioSession");
			if (session == null) {
				throw new MozartSessionException("Não foi possivel localizar: ReservaSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static UsuarioDelegate instance(String name) throws MozartSessionException {
		return instance == null ? instance = new UsuarioDelegate(name) : instance;
	}

    
    
    public UsuarioEJB autenticar(UsuarioEJB usuario) {
    
    
        return session.autenticar(usuario);
    
    
    }
    
    public void criarSessao(UsuarioSessionEJB sessao) {
    
    
         session.criarSessao(sessao);
    
    
    }


    public void fecharSessao(UsuarioSessionEJB sessao) {
        session.fecharSessao(sessao);
    
    }

    public List<UsuarioSessionEJB> listarSessoesAtivas() {
        return session.listaSessoesAtivas();
    
    }

    public List<MenuMozartWebEJB> listarMenus(Long tipo, Long tipoRede) {
        return session.listarMenus( tipo,  tipoRede );
        
    }

    public List<UsuarioEJB> listarUsuarios(HotelEJB hotelEJB) {
        return session.listarUsuarios(hotelEJB);
    }

    public void salvarUsuario(UsuarioEJB usuario, List<Long> listProgramas)throws MozartSessionException {
        
        try{
            session.salvarUsuario( usuario, listProgramas );
        }catch(Exception ex){
            if(ex.getCause() != null && ex.getCause().getCause() != null && ex.getCause().getCause().getMessage().contains("restrição exclusiva (MOZART.IDX_USER_NICK) violada")) {
            	throw new MozartSessionException( ex.getCause().getCause().getMessage() );
            } else {
            	throw new MozartSessionException( ex.getMessage() );
            }
        	
        }
    }
    
    public List<MenuMozartWebUsuarioEJB> listarPermissoes(UsuarioEJB usuario)throws MozartSessionException {
        
        try{
            return session.listarPermissoes( usuario );
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );
        }
    }
    
    public void trocarSenha(UsuarioEJB usuario)throws MozartSessionException {
        
        try{
            session.trocarSenha( usuario );
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );
        }
    }

    public ControlaDataEJB obterControlaData(Long idHotel) {
        return session.obterControlaData( idHotel );
    }

    public boolean validarSessao(String sessionId) {
        return session.validarSessao(sessionId);
        
    }

    public RedeHotelEJB obterRedeHotel(Long idHotel) {
    
        return session.obterRedeHotel(idHotel);
    
    }


	public List<UsuarioEJB> listarUsuarios(UsuarioEJB usuarioEJB) {
	        return session.listarUsuarios(usuarioEJB);
	}


	public ConfigWebEJB obterConfiguracaoWeb() {

		return session.obterConfiguracaoWeb();
	}
}
