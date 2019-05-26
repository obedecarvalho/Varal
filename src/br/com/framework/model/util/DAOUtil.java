package br.com.framework.model.util;

import static br.com.framework.util.ValidatorUtil.isEmpty;
import static br.com.framework.util.ValidatorUtil.isNotEmpty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.framework.util.LogUtil;
import br.com.varal.controller.Constante;

public class DAOUtil {
	
	private static Connection connection = null;
	
	private static final String CONNECTION_STRING = "jdbc:sqlite:%s";
	
	private static final String LOG_ERROR_CONNECTION = "Não foi possível abrir a conexão: %s";
	private static final String LOG_OPEN_CONNECTION = "Conexão aberta: %s";
	private static final String LOG_CLOSE_CONNECTION = "Conexão fechada: %s";
	
	public static Connection getConnection() throws Exception {
		if (isEmpty(connection)) {
			connection = DriverManager.getConnection(String.format(CONNECTION_STRING, Constante.DB_NAME));
			if (isEmpty(connection)) {
				String erro = String.format(LOG_ERROR_CONNECTION, Constante.DB_NAME);
				LogUtil.error(erro);
				throw new Exception(erro);
			}
			LogUtil.info(String.format(LOG_OPEN_CONNECTION, Constante.DB_NAME));
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if (isNotEmpty(connection)) {
			try {
				connection.close();
				LogUtil.info(String.format(LOG_CLOSE_CONNECTION, Constante.DB_NAME));
			} catch (SQLException e) {
				LogUtil.error(e);
				throw e;
			}
		}
	}
}
