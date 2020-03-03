package com.mozart.model.ejb.facade;

import com.mozart.model.ejb.entity.ConfigWebEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MenuMozartWebEJB;
import com.mozart.model.ejb.entity.MenuMozartWebUsuarioEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.UsuarioEJB;


import com.mozart.model.ejb.entity.UsuarioSessionEJB;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UsuarioSession {
    UsuarioEJB autenticar(UsuarioEJB usuario);
    void criarSessao(UsuarioSessionEJB sessao);
    void fecharSessao(UsuarioSessionEJB sessao);
    List<UsuarioSessionEJB> listaSessoesAtivas();

    List<MenuMozartWebEJB> listarMenus(Long tipo, Long tipoRede) ;

    List<UsuarioEJB> listarUsuarios(HotelEJB hotelEJB) ;

    void salvarUsuario(UsuarioEJB usuario, List<Long> listProgramas);
    
    List<MenuMozartWebUsuarioEJB> listarPermissoes(UsuarioEJB user);

    void trocarSenha(UsuarioEJB usuario) ;

    ControlaDataEJB obterControlaData(Long idHotel);

    boolean validarSessao(String sessionId) ;

    RedeHotelEJB obterRedeHotel(Long idHotel);
	List<UsuarioEJB> listarUsuarios(UsuarioEJB usuarioEJB);
	ConfigWebEJB obterConfiguracaoWeb();
    
}
