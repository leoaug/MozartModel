package com.mozart.model.ejb.entity;

public class UsuarioSessionEJBPK extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3770545370630900986L;
	public Long idUsuario;
    public String sessionId;

    public UsuarioSessionEJBPK() {
    }

    public UsuarioSessionEJBPK(Long idUsuario, String sessionId) {
        this.idUsuario = idUsuario;
        this.sessionId = sessionId;
    }

    public boolean equals(Object other) {
        if (other instanceof UsuarioSessionEJBPK) {
            final UsuarioSessionEJBPK otherUsuarioSessionEJBPK = (UsuarioSessionEJBPK) other;
            final boolean areEqual = 
                (otherUsuarioSessionEJBPK.idUsuario.equals(idUsuario) && otherUsuarioSessionEJBPK.sessionId.equals(sessionId));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
