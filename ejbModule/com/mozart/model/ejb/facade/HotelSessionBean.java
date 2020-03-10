package com.mozart.model.ejb.facade;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.HotelVO;


@Stateless(name = "HotelSession")
@SuppressWarnings("unchecked")
public class HotelSessionBean implements HotelSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager entityManager;

	@Override
	public List<HotelVO> consultarHoteisAtivos() throws MozartSessionException {
		
		List<HotelVO> listaHoteis = new ArrayList <HotelVO> ();
		
		String sql = "SELECT ID_HOTEL, NOME_FANTASIA  \n" + 
				"FROM HOTEL H \n" + 
				"WHERE ATIVO= 'S' \n" + 
				"ORDER BY NOME_FANTASIA";
		
		List <Object[]> listaQuery = this.entityManager.createNativeQuery(sql).getResultList();
		
		for(Object[] obj : listaQuery) {
			Object[] param = (Object[]) obj;
			
			HotelVO vo = new HotelVO();
			vo.setIdHotel(Long.parseLong(param[0].toString()));
			vo.setNomeFantasia(param[1].toString());
			
			listaHoteis.add(vo);
		}
		
		return listaHoteis;
	}

	@Override
	public HotelEJB consultarHotelPorId(Long idHotel) throws MozartSessionException {
		return this.entityManager.find(HotelEJB.class, idHotel);
	}

}