package com.mozart.model.ejb.entity;



public class MenuMozartWebUsuarioEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4065465892481264850L;
	public Long idMenuItem;
    public Long idUsuario;

    public MenuMozartWebUsuarioEJBPK() {
    }

    public MenuMozartWebUsuarioEJBPK(Long idMenuItem, Long idUsuario) {
        this.idMenuItem = idMenuItem;
        this.idUsuario = idUsuario;
    }

    public boolean equals(Object other) {
        if (other instanceof MenuMozartWebUsuarioEJBPK) {
            final MenuMozartWebUsuarioEJBPK otherMenuMozartWebUsuarioEJBPK = (MenuMozartWebUsuarioEJBPK) other;
            final boolean areEqual = 
                (otherMenuMozartWebUsuarioEJBPK.idMenuItem.equals(idMenuItem) && otherMenuMozartWebUsuarioEJBPK.idUsuario.equals(idUsuario));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
