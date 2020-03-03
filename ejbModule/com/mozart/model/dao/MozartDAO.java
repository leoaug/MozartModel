package com.mozart.model.dao;

import com.mozart.model.exception.MozartSessionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.pool.OracleDataSource;

public class MozartDAO {
	public Connection newConnection() throws MozartSessionException {
		String mensagem = "Obtendo concexao\n";
		try {
			OracleDataSource ods = new OracleDataSource();
			mensagem = mensagem.concat(" - Datasource ok\n");
			ods.setDriverType("thin");
			mensagem = mensagem.concat(" - drive ok\n");
			ods.setServerName("10.0.0.47");
			mensagem = mensagem.concat(" - server ok\n");
			ods.setDatabaseName("mozart");
			mensagem = mensagem.concat(" - db ok\n");
			ods.setPortNumber(1521);
			mensagem = mensagem.concat(" - porta ok\n");
			ods.setUser("mozart_web");
			mensagem = mensagem.concat(" - login ok\n");
			ods.setPassword("mozartweb");
			mensagem = mensagem.concat(" - senha ok\n");
			return ods.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MozartSessionException(mensagem + "-" + ex.getMessage());
		}
	}

	public void fecharRecurso(Connection conexao, ResultSet rs,
			PreparedStatement st) {
		try {
			if (conexao != null) {
				conexao.close();
			}
		} catch (Exception localException) {
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception localException1) {
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception localException2) {
		}
	}
}