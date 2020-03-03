package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.CentralReservaEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.CrsVO;

@Remote
public interface CrsSession {
	
	
	String QRY_TARIFA_HOTEL=
		" SELECT  to_char(DATA,'dd/mm/yyyy') data, TIPOA.FANTASIA,0 valor, DECODE(?1,0,0,1,TA.PAX1,2,TA.PAX2,3,TA.PAX3,4,TA.PAX4,5,TA.PAX5,6,TA.PAX6,7,TA.PAX7) PAX, "+
		" substr(to_char(DATA,'day'),1,3) dia, 0 total, 0 totaldia, 0 percDia, t.id_tarifa, TIPOA.ID_TIPO_APARTAMENTO "+
		" FROM TIPO_APARTAMENTO TIPOA, TARIFA_APARTAMENTO TA, TARIFA T,  "+
		" (SELECT * FROM TABLE(CAST(FC_TARIFA(?2,?3, NULL,?4,?5,1) AS TARIFA_SET))) TARIFA_CRS "+ 
		" WHERE TARIFA_CRS.ID_TARIFA = T.ID_TARIFA "+  
		" AND T.ID_TARIFA = TA.ID_TARIFA "+ 
		" AND T.ID_HOTEL = NVL(?6, T.ID_HOTEL) "+
		" AND TA.ID_HOTEL = T.ID_HOTEL "+
		" AND TA.ID_HOTEL = TIPOA.ID_HOTEL "+
		" AND TA.ID_TIPO_APARTAMENTO = TIPOA.ID_TIPO_APARTAMENTO order by  fantasia, data "; 
	
	String QRY_DISPO_HOTEL =
		" SELECT TO_CHAR(DATA,'dd/mm/yyyy')DATA, FANTASIA, VALOR, PERCENTUAL, DIASEMANA, TOTAL, TOTDIA, PERCENTDIA, null, null " +
		" FROM TABLE (CAST(DISPONIBILIDADEGERALOTIMIZADA(?1,?2,?3,?4)AS DISP_SET)) ORDER BY TO_TIMESTAMP(DATA,'DD/MM/YY'), FANTASIA ";

	String QRY_OCUPACAO_HOTEL =
		" SELECT TO_CHAR(DATA,'dd/mm/yyyy')DATA, FANTASIA, VALOR, PERCENTUAL, DIASEMANA, TOTAL, TOTDIA, PERCENTDIA, null, null " +
		" FROM TABLE (CAST(OCUPACAOGERAL(?1,?2,?3,?4)AS DISP_SET)) ORDER BY TO_TIMESTAMP(DATA,'DD/MM/YY'), FANTASIA ";

	String QRY_PESQUISA_HOTEL = 
			" SELECT H.* "+ 
			" FROM CENTRAL_RESERVAS_HOTEL CRS, HOTEL H, "+ 
			" 	(SELECT T.ID_HOTEL, AVG( DECODE(?1,0,0,1,TA.PAX1,2,TA.PAX2,3,TA.PAX3,4,TA.PAX4,5,TA.PAX5,6,TA.PAX6,7,TA.PAX7)) PAX "+ 
			" 	FROM TARIFA_APARTAMENTO TA, TARIFA T, "+ 
			" 	(SELECT * FROM TABLE(CAST(FC_TARIFA_CRS(?2,?3, ?4) AS TARIFA_SET))) TARIFA_CRS "+ 
			" 	WHERE TARIFA_CRS.ID_TARIFA = T.ID_TARIFA "+  
			" 	AND T.ID_TARIFA = TA.ID_TARIFA "+ 
			" 	AND T.ID_HOTEL = NVL(?5, T.ID_HOTEL) "+
			" 	AND TA.ID_HOTEL = T.ID_HOTEL "+
			" 	GROUP BY T.ID_HOTEL) TARIFA_MEDIA "+
			" WHERE CRS.ID_CENTRAL_RESERVAS = ?6 "+
			" AND CRS.ATIVO = 'S' "+
			" AND CRS.ID_HOTEL = H.ID_HOTEL "+
			" AND H.ID_HOTEL = TARIFA_MEDIA.ID_HOTEL "+
			" AND H.ATIVO = 'S' "+
			" AND H.ID_HOTEL = NVL(?7, H.ID_HOTEL) "+
			" AND UPPER(H.BAIRRO) LIKE '%'||NVL(?8, UPPER(H.BAIRRO))||'%' "+
			" AND H.ID_HOTEL = TARIFA_MEDIA.ID_HOTEL(+) "+
			" AND TARIFA_MEDIA.PAX <= NVL(?9, TARIFA_MEDIA.PAX) AND H.ID_CIDADE = NVL(?10, H.ID_CIDADE)"; 

	String QRY_CRS_PROPRIA =
		" SELECT CRS.* "+ 
		" FROM CENTRAL_RESERVAS_REDE CRSR, CENTRAL_RESERVAS CRS "+
		" WHERE CRSR.ID_CRS = CRS.ID_CENTRAL_RESERVAS "+
		" AND CRSR.ID_REDE = ?1 "+
		" AND CRSR.ATIVO = 'S' "+
		" AND CRSR.CRS_PROPRIA = 'S' ";

	
	List<HotelEJB> pesquisarHotel(CrsVO filtro) throws MozartSessionException;
	HotelEJB pesquisarOcupacao(CrsVO filtro) throws MozartSessionException;
	HotelEJB pesquisarDisponibilidade(CrsVO filtro) throws MozartSessionException;
	CentralReservaEJB obterCrsPropria(RedeHotelEJB redeHotelEJB)throws MozartSessionException;
}
