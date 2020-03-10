package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.HotelVO;


@Remote
public interface HotelSession {

	List <HotelVO> consultarHoteisAtivos()  throws MozartSessionException;

	HotelEJB consultarHotelPorId(Long idHotel) throws MozartSessionException;
}
