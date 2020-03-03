package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.RamalTelefonicoEJB;
import com.mozart.model.ejb.entity.TelefoniaDiscrepanciaEJB;
import com.mozart.model.ejb.entity.TelefoniaEJB;
import com.mozart.model.ejb.entity.TelefoniasConfigEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.DiscrepanciaVO;
import com.mozart.model.vo.RamalVO;

@Remote
public interface TelefoniaSession {

	String QRY_RAMAL = 
		" SELECT RT.ID_RAMAL_TELEFONICO, RT.RAMAL, A.NUM_APARTAMENTO, DECODE(RT.INTERNO,'S','Sim','Não') INTERNO "+ 
		" FROM RAMAL_TELEFONICO RT, APARTAMENTO A "+
		" WHERE RT.ID_APARTAMENTO = A.ID_APARTAMENTO(+) "+
		" AND RT.ID_HOTEL = A.ID_HOTEL(+) ";
	
	String QRY_DISCREPANCIA = 
		" SELECT TD.ID_TELEFONIA, RT.RAMAL, A.NUM_APARTAMENTO, TD.NUM_TELEFONE, TD.DATA, TD.HORA_INICIO, TD.HORA_FIM, TD.VALOR "+ 
		" FROM TELEFONIA_DISCREPANCIA TD, RAMAL_TELEFONICO RT, APARTAMENTO A  "+
		" WHERE TD.ID_RAMAL_TELEFONICO = RT.ID_RAMAL_TELEFONICO AND TD.ID_HOTEL = RT.ID_HOTEL "+ 
		" AND RT.ID_APARTAMENTO = A.ID_APARTAMENTO (+) AND RT.ID_HOTEL = A.ID_HOTEL (+) ";
	
	String QRY_CHECKIN_TELEFONIA = 
		" SELECT /*+ INDEX(RA IDX_RAMAL_TELEFONICO_ID_HOTEL)*/ C.ID_CHECKIN, RA.ID_RAMAL_TELEFONICO, C.ID_ROOM_LIST, C.QUEM_PAGA, C.CALCULA_ISS, C.CALCULA_TAXA "+   
    	" FROM RAMAL_TELEFONICO RA, "+ 							 
    	" 	 				  ( SELECT C.ID_CHECKIN, C.CALCULA_ISS, C.CALCULA_TAXA, C.ID_HOTEL, C.ID_APARTAMENTO,  RL.ID_ROOM_LIST, CGL.QUEM_PAGA "+
    	" 					  	FROM CHECKIN C, ROOM_LIST RL, CHECKIN_GRUPO_LANCAMENTO CGL "+
    	" 						WHERE C.ID_HOTEL = ?1 "+ 
    	" 						AND C.CHECKOUT = 'N'  "+
    	" 						AND C.ID_CHECKIN = RL.ID_CHECKIN "+ 
    	" 						AND RL.PRINCIPAL = 'S' "+ 
    	" 						AND RL.ID_HOTEL = C.ID_HOTEL "+
    	" 						AND C.ID_CHECKIN = CGL.ID_CHECKIN "+ 
    	" 						AND CGL.ID_HOTEL = C.ID_HOTEL "+ 
    	" 						AND CGL.ID_IDENTIFICA_LANCAMENTO = 6 )C "+
    	" WHERE RA.ID_HOTEL = ?2 "+ 
    	" AND RA.RAMAL = ?3 "+ 
    	" AND RA.ID_APARTAMENTO = C.ID_APARTAMENTO(+) "+
    	" AND RA.ID_HOTEL = C.ID_HOTEL(+) ";   
		
	void lancarTelefonia(HotelEJB hotel, String[] linhas) throws MozartSessionException;

	List<TelefoniaEJB> obterCentralTelefonia()throws MozartSessionException;

	TelefoniasConfigEJB obterTelefoniasConfigPorHotel(TelefoniasConfigEJB filtro);

	List<RamalVO> pesquisarRamal(RamalVO filtro)throws MozartSessionException;

	void gravarRamalTelefonico(RamalTelefonicoEJB entidade)throws MozartSessionException;

	void excluirRamalTelefonico(RamalTelefonicoEJB entidade)throws MozartSessionException;

	List<DiscrepanciaVO> pesquisarDiscrepancia(DiscrepanciaVO filtro) throws MozartSessionException;

	void lancarMovimentoDiscrepancia(TelefoniaDiscrepanciaEJB entidade)throws MozartSessionException;
}
