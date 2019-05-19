package br.com.varal.model.util;

import static br.com.varal.controller.util.ValidatorUtil.isEmpty;
import static br.com.varal.controller.util.ValidatorUtil.isNotEmpty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.varal.controller.Constante;
import br.com.varal.controller.util.LogUtil;

public class DAOUtil {
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if (isEmpty(connection)) {
			try {
				connection = DriverManager.getConnection("jdbc:sqlite:" + Constante.DB_NAME);
				if (isEmpty(connection)) {
					new Exception("Não foi possível abrir a conexão.");
				}
				LogUtil.info("Conexão aberta...");
			} catch (Exception e) {
				LogUtil.error(e);
				return null;
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		if (isNotEmpty(connection)) {
			try {
				connection.close();
				LogUtil.info("Conexão fechada.");
			} catch (SQLException e) {
				LogUtil.error(e);
			}
		}
	}

}
