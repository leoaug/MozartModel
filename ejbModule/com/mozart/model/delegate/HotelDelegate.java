package com.mozart.model.delegate;


import java.util.List;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.facade.HotelSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.HotelVO;

public class HotelDelegate extends MozartDelegate {

	private static HotelDelegate instance;
	private static HotelSession session;
	
	private HotelDelegate() throws MozartSessionException {
		try {
			session = (HotelSession) getLookup("HotelSession");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: HotelSession");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static HotelDelegate instance() throws MozartSessionException {
		return instance == null ? (HotelDelegate.instance = new HotelDelegate())
				: instance;
	}

	public List <HotelVO> consultarHoteisAtivos() throws MozartSessionException {
		return session.consultarHoteisAtivos();
	}
}
