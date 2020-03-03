package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
@NamedQuery(name = "MenuMozartWebUsuarioEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from MenuMozartWebUsuarioEJB o"),
@NamedQuery(name = "MenuMozartWebUsuarioEJB.findByUsuario", 
            query = "select o from MenuMozartWebUsuarioEJB o where o.usuarioEJB.idUsuario = ?1 and o.idMenuItem >= 1500 order by o.menuMozartWebEJB.tipoMenu, o.menuMozartWebEJB.numOrdem, o.menuMozartWebEJB.seqMenu", 
            hints=@QueryHint(name="eclipselink.refresh", value="TRUE")),
})
@Table(name = "MENU_MOZART_WEB_USUARIO")
@IdClass(MenuMozartWebUsuarioEJBPK.class)
public class MenuMozartWebUsuarioEJB extends MozartEntity {
    @Id
    @Column(name="ID_MENU_ITEM", nullable = false, insertable = false, 
        updatable = false)
    private Long idMenuItem;
    @Id
    @Column(name="ID_USUARIO", nullable = false, insertable = false, 
        updatable = false)
    private Long idUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private UsuarioEJB usuarioEJB;
    @ManyToOne
    @JoinColumn(name = "ID_MENU_ITEM", referencedColumnName = "ID_MENU_ITEM")
    private MenuMozartWebEJB menuMozartWebEJB;
    //@OneToMany(mappedBy = "menuMozartWebUsuarioEJB")
    //private List<MenuMozartWebUsuarioXRoleEJB> menuMozartWebUsuarioXRoleEJBList;
    
    public MenuMozartWebUsuarioEJB() {
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMenuItem == null) ? 0 : idMenuItem.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MenuMozartWebUsuarioEJB)) {
			return false;
		}
		MenuMozartWebUsuarioEJB other = (MenuMozartWebUsuarioEJB) obj;
		if (idMenuItem == null) {
			if (other.idMenuItem != null) {
				return false;
			}
		} else if (!idMenuItem.equals(other.idMenuItem)) {
			return false;
		}
		if (idUsuario == null) {
			if (other.idUsuario != null) {
				return false;
			}
		} else if (!idUsuario.equals(other.idUsuario)) {
			return false;
		}
		
		return true;
	}


	@Override
	public String toString() {
		return "MenuMozartWebUsuarioEJB [usuarioEJB=" + usuarioEJB.getNick()
				+ ", menuMozartWebEJB=" + menuMozartWebEJB.getDsMenu() + "]";
	}

	public MenuMozartWebUsuarioEJB(UsuarioEJB usuario, MenuMozartWebEJB idMenuItem) {
        this.usuarioEJB = usuario;
        this.menuMozartWebEJB = idMenuItem;
        this.idUsuario = usuario.getIdUsuario();
        this.idMenuItem = idMenuItem.getIdMenuItem();
    }
    public Long getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(Long idMenuItem) {
        this.idMenuItem = idMenuItem;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioEJB getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public MenuMozartWebEJB getMenuMozartWebEJB() {
        return menuMozartWebEJB;
    }

    public void setMenuMozartWebEJB(MenuMozartWebEJB menuMozartWebEJB) {
        this.menuMozartWebEJB = menuMozartWebEJB;
    }

}
