package com.mozart.model.ejb.facade.interceptor;

import com.mozart.model.ejb.entity.MozartEntity;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.ejb.entity.UsuarioSessionInfo;
import com.mozart.model.vo.MozartVO;
import com.mozart.model.vo.ReservaVO;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioSessionInfoInterceptor {
	@PersistenceContext(unitName = "MozartModel")
	protected EntityManager manager;

	@AroundInvoke
	public Object audit(InvocationContext ic) throws Exception {
		if ("apagarReservaOmnibees".equals(ic.getMethod().getName()) || 
				((ic.getParameters() != null) && (ic.getParameters()[0] != null))) {
			Object param0 = ic.getParameters()[0];
			UsuarioEJB usuario = getUsuario(param0);

			if(usuario == null && "apagarReservaOmnibees".equals(ic.getMethod().getName())){
				usuario = new UsuarioEJB();
				usuario.setIdUsuario(150000L);
				usuario.setNick("MOZART");
			}
			
			if (usuario != null) {
				UsuarioSessionInfo user = new UsuarioSessionInfo(usuario
						.getIdUsuario(), usuario.getNick());
				this.manager.persist(user);
				this.manager.flush();
			}
		}
		return ic.proceed();
	}

	private UsuarioEJB getUsuario(Object param) {
		if (((param instanceof UsuarioEJB))
				&& (((UsuarioEJB) param).getIdUsuario() != null)) {
			return (UsuarioEJB) param;
		}
		if ((param instanceof MozartEntity)) {
			return ((MozartEntity) param).getUsuario();
		}
		if ((param instanceof MozartVO)) {
			return ((MozartVO) param).getUsuario();
		}

		if ((param instanceof ReservaVO)) {
			return ((ReservaVO) param).getUsuario();
		}

		return null;
	}
}