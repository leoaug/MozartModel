package com.mozart.model.ejb.facade;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.mozart.model.ejb.entity.ConfigWebEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.EmpresaSeguradoraEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MenuMozartWebEJB;
import com.mozart.model.ejb.entity.MenuMozartWebUsuarioEJB;
import com.mozart.model.ejb.entity.MenuMozartWebUsuarioEJBPK;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.ejb.entity.UsuarioSessionEJB;
import com.mozart.model.ejb.entity.UsuarioSessionEJBPK;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.util.MozartUtil;

@Stateless(name = "UsuarioSession")
@SuppressWarnings("unchecked")
public class UsuarioSessionBean implements UsuarioSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public UsuarioEJB autenticar(UsuarioEJB usuario) {
		try {
			UsuarioEJB usuarioBean = (UsuarioEJB) this.manager
					.createNamedQuery("UsuarioEJB.findByNick").setHint(
							"eclipselink.refresh", "TRUE").setParameter(1,
							"MOZART_" + usuario.getNick()).setParameter(2,
							usuario.getSenha()).getSingleResult();
			if (usuarioBean == null) {
				return null;
			}
			if (!MozartUtil.isNull(usuarioBean.getRedeHotelEJB())) {
				List<HotelEJB> listaHotel = this.manager
						.createNativeQuery(
								"select * from hotel where id_rede_hotel = nvl(?1,id_rede_hotel) and ativo='S' order by id_rede_hotel, nome_fantasia",
								HotelEJB.class).setHint("eclipselink.refresh",
								"TRUE").setParameter(
								1,
								"MOZART_MANUTENCAO".equals(usuarioBean
										.getNick()) ? null : usuarioBean
										.getRedeHotelEJB().getIdRedeHotel())
						.getResultList();
				for (HotelEJB hotel : listaHotel) {
					if ((hotel.getEmpresaSeguradoraEJB() != null)
							&& (hotel.getEmpresaSeguradoraEJB()
									.getDtFimSeguro() != null)) {
						hotel.setEmpresaSeguradoraEJB(null);
					}
				}
				usuarioBean.getRedeHotelEJB().setHoteis(listaHotel);
			} else if ((usuarioBean.getHotelEJB() != null)
					&& (usuarioBean.getHotelEJB().getEmpresaSeguradoraEJB() != null)
					&& (usuarioBean.getHotelEJB().getEmpresaSeguradoraEJB()
							.getDtFimSeguro() != null)) {
				usuarioBean.getHotelEJB().setEmpresaSeguradoraEJB(null);
			}
			if ((usuarioBean.getHotelEJB() != null)
					&& (usuarioBean.getHotelEJB().getRedeHotelEJB()
							.getIdRedeHotel().intValue() == 82)) {
				List<EmpresaSeguradoraEJB> lista = this.manager
						.createQuery(
								"select o from EmpresaSeguradoraEJB o where o.idSeguradora = ?1")
						.setHint("eclipselink.refresh", "TRUE").setParameter(1,
								Integer.valueOf(82)).getResultList();

				List<HotelEJB> hoteis = new ArrayList();
				for (EmpresaSeguradoraEJB segurado : lista) {
					hoteis.add(segurado.getSegurado());
				}
				if (!hoteis.isEmpty()) {
					usuarioBean.getRedeHotelEJB().setHoteis(hoteis);
				}
			}
			usuarioBean
					.setMenuMozartWebUsuarioEJBList(listarPermissoes(usuarioBean));

			return usuarioBean;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<MenuMozartWebUsuarioEJB> listarPermissoes(UsuarioEJB user) {
		return this.manager.createNamedQuery(
				"MenuMozartWebUsuarioEJB.findByUsuario").setHint(
						QueryHints.REFRESH , HintValues.TRUE).setParameter(1,
				user.getIdUsuario()).getResultList();
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void criarSessao(UsuarioSessionEJB usuario) {
		this.manager.persist(usuario);
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void fecharSessao(UsuarioSessionEJB usuario) {
		UsuarioSessionEJB sessao = (UsuarioSessionEJB) this.manager.find(
				UsuarioSessionEJB.class,
				new UsuarioSessionEJBPK(usuario.getUsuarioEJB().getIdUsuario(),
						usuario.getSessionId()));
		sessao.setDtFinalizacao(new Timestamp(new Date().getTime()));
		this.manager.merge(sessao);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UsuarioSessionEJB> listaSessoesAtivas() {
		return this.manager.createNamedQuery("UsuarioSessionEJB.findActive")
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MenuMozartWebEJB> listarMenus(Long tipo, Long tipoRede) {
		List<MenuMozartWebEJB> menus = this.manager
				.createNamedQuery("MenuMozartWebEJB.findAllByPrograma").setParameter(1,
						tipo).setParameter(2, tipoRede).getResultList();

		return menus;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UsuarioEJB> listarUsuarios(HotelEJB hotelEJB) {
		try {
			return

			this.manager.createNamedQuery("UsuarioEJB.findByHotel").setHint(
					"eclipselink.refresh", "TRUE").setParameter(1,
					hotelEJB.getIdHotel()).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarUsuario(UsuarioEJB usuario, List<Long> listProgramas) {
		try {
			if (MozartUtil.isNull(usuario.getIdUsuario())) {
				this.manager.persist(usuario);
			} else {
				if (MozartUtil.isNull(usuario.getSenha())) {
					UsuarioEJB old = (UsuarioEJB) this.manager.find(
							UsuarioEJB.class, usuario.getIdUsuario());
					usuario.setSenha(old.getSenha());
				}
				String sql = " delete Menu_Mozart_Web_Usuario where id_Usuario=?1 ";
				
				String filtroPrograma = " and id_menu_item in (select id_menu_item from menu_mozart_web "
						+ " where id_programa in ("+listProgramas.get(0) +"," +listProgramas.get(1) +" ))";
				
				sql = sql + (MozartUtil.isNull(listProgramas) ? " " : filtroPrograma);
				
				Query q =this.manager.createNativeQuery(sql);
				
				q.setParameter(1, usuario.getIdUsuario());
				
				q.executeUpdate();
				HashSet<MenuMozartWebUsuarioEJB> set = new HashSet<MenuMozartWebUsuarioEJB>();
				
				set.addAll(usuario
						.getMenuMozartWebUsuarioEJBList());
				
				for (MenuMozartWebUsuarioEJB menu : set) {
					if (menu.getIdMenuItem() != null) {
						this.manager.persist(menu);
					}
				}
				this.manager.merge(usuario);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void trocarSenha(UsuarioEJB usuario) {
		UsuarioEJB old = (UsuarioEJB) this.manager.find(UsuarioEJB.class,
				usuario.getIdUsuario());
		old.setSenha(usuario.getSenha());
		this.manager.merge(old);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ControlaDataEJB obterControlaData(Long idHotel) {
		ControlaDataEJB controla = (ControlaDataEJB) this.manager.find(
				ControlaDataEJB.class, idHotel);
		this.manager.refresh(controla);
		return controla;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean validarSessao(String sessionId) {
		try {
			this.manager.createQuery(
					"select o from UsuarioSessionEJB o where o.sessionId = ?1")
					.setHint("eclipselink.refresh", "TRUE").setParameter(1,
							sessionId).getSingleResult();
			return Boolean.FALSE.booleanValue();
		} catch (Exception es) {
		}
		return Boolean.TRUE.booleanValue();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public RedeHotelEJB obterRedeHotel(Long idHotel) {
		return (RedeHotelEJB) this.manager
				.createQuery(
						"select o from RedeHotelEJB o where o.idRedeHotel in (select h.RedeHotelEJB.idRedeHotel from HotelEJB h where h.idHotel = ?1)")
				.setHint("eclipselink.refresh", "TRUE")
				.setParameter(1, idHotel).getSingleResult();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<UsuarioEJB> listarUsuarios(UsuarioEJB usuarioEJB) {
		try {
			String qry = " select * from (select * from usuario where id_hotel = ?1 and ativo = ?2 union all  select * from usuario where id_rede_hotel = ?3 and ativo = ?4 union all  select * from usuario where id_central_reservas = ?5 and ativo = ?6 union all select * from usuario where (id_hotel = 23 or id_usuario = nvl(?7, id_usuario)) and ativo = ?8 and nivel between ?9 and ?10)  order by id_hotel, id_rede_hotel, id_central_reservas, nome ";

			String paramAtivo = MozartUtil.isNull(usuarioEJB.getAtivo()) ? "S"
					: usuarioEJB.getAtivo();

			return this.manager
					.createNativeQuery(qry, UsuarioEJB.class)
					.setParameter(
							1,
							usuarioEJB.getHotelEJB() == null ? null
									: usuarioEJB.getHotelEJB().getIdHotel())
					.setParameter(2, paramAtivo)
					.setParameter(
							3,
							usuarioEJB.getRedeHotelEJB() == null ? null
									: usuarioEJB.getHotelEJB()
											.getRedeHotelEJB().getIdRedeHotel())
					.setParameter(4, paramAtivo).setParameter(
							5,
							usuarioEJB.getCrsEJB() == null ? null : Long
									.valueOf(usuarioEJB.getCrsEJB()
											.getIdCentralReservas()))
					.setParameter(6, paramAtivo).setParameter(
							7,
							usuarioEJB.getNivel() == null ? null
									: Integer.valueOf(usuarioEJB.getNivel()
											.intValue() == 11 ? 10 : usuarioEJB
											.getNivel().intValue() <= 10 ? 10
											: 11)).setParameter(8, paramAtivo)
					.setParameter(
							9,
							usuarioEJB.getNivel() == null ? null
									: Integer.valueOf(usuarioEJB.getNivel()
											.intValue() <= 10 ? 11 : 12))
					.setParameter(10, usuarioEJB.getIdUsuario())
					.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Collections.emptyList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConfigWebEJB obterConfiguracaoWeb() {
		ConfigWebEJB result = new ConfigWebEJB();
		try {
			result = (ConfigWebEJB) this.manager.find(ConfigWebEJB.class,
					new Long(1L));
			this.manager.refresh(result);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}