package com.mozart.model.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mozart.model.ejb.entity.CheckinEJB;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

	private void start() {

		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("MozartLocal");
			EntityManager em = emf.createEntityManager();
			// com.sun.faces.application.ApplicationAssociate d;
			String sql = " SELECT *  "
					+ " FROM CHECKIN C, MOVIMENTO_APARTAMENTO MOV, ROOM_LIST RL "
					+ " WHERE C.ID_CHECKIN = 19005881 "
					+ " AND C.ID_CHECKIN = MOV.ID_CHECKIN(+) "
					+ " AND MOV.CHECKOUT(+) = 'N' "
					+ " AND MOV.MOV_TMP(+) = 'S' "
					+ " AND RL.ID_CHECKIN = C.ID_CHECKIN "
					+ " AND RL.CHEGOU = 'S' " + " AND RL.DATA_SAIDA IS NULL ";
			em.createNativeQuery(sql, CheckinEJB.class).getResultList();

			System.out.println(System.getProperty("local.home"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static String QUERY = "SELECT NEW com.mozart.model.app.Teste(ID_RESERVA_APARTAMENTO) \n"
			+ "FROM (\n"
			+ "SELECT DISTINCT RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO "
			+ "\n"
			+ "FROM RESERVA_APARTAMENTO, RESERVA, empresa_rede, HOTEL HT, TIPO_APARTAMENTO,HOSPEDE , TIPO_HOSPEDE, ROOM_LIST,\n"
			+ "CENTRAL_RESERVAS, CONTROLA_DATA, CHECKIN,APARTAMENTO\n"
			+ "    \n"
			+ "WHERE RESERVA.ID_EMPRESA = EMPRESA_REDE.ID_EMPRESA\n"
			+ "AND CENTRAL_RESERVAS.ID_CENTRAL_RESERVAS(+) = RESERVA.ID_CENTRAL_RESERVAS\n"
			+ "AND CHECKIN.ID_RESERVA_APARTAMENTO(+) = RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO\n"
			+ "AND RESERVA_APARTAMENTO.ID_APARTAMENTO = APARTAMENTO.ID_APARTAMENTO(+)\n"
			+ "AND CONTROLA_DATA.ID_HOTEL = RESERVA.ID_HOTEL\n"
			+ "AND RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO = ROOM_LIST.ID_RESERVA_APARTAMENTO(+)\n"
			+ "AND HOSPEDE.ID_TIPO_HOSPEDE = TIPO_HOSPEDE.ID_TIPO_HOSPEDE(+)\n"
			+ "AND HOSPEDE.ID_HOSPEDE(+) = ROOM_LIST.ID_HOSPEDE   \n"
			+ "AND EMPRESA_REDE.ID_REDE_HOTEL =  HT.ID_REDE_HOTEL\n"
			+ "AND RESERVA_APARTAMENTO.ID_RESERVA = RESERVA.ID_RESERVA\n"
			+ "AND RESERVA_APARTAMENTO.ID_HOTEL = RESERVA.ID_HOTEL\n"
			+ "AND RESERVA_APARTAMENTO.ID_HOTEL = TIPO_APARTAMENTO.ID_HOTEL\n"
			+ "AND RESERVA_APARTAMENTO.ID_TIPO_APARTAMENTO = TIPO_APARTAMENTO.ID_TIPO_APARTAMENTO\n"
			+ "AND HT.ID_HOTEL = RESERVA.ID_HOTEL\n"
			+ "AND RESERVA_APARTAMENTO.QTDE_APARTAMENTO > 0\n"
			+ " AND INSTR(';33;', ';'||RESERVA.ID_HOTEL||';') > 0\n"
			+ " AND RESERVA_APARTAMENTO.DATA_ENTRADA  between to_date('10/05/2008','dd/mm/yyyy') and to_date('10/05/2008','dd/mm/yyyy')\n"
			+ " GROUP BY RESERVA_APARTAMENTO.ID_RESERVA_APARTAMENTO)\n"
			+ "\n"
			+ " \n" + "";

}
