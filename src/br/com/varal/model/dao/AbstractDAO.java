package br.com.varal.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

import br.com.varal.controller.util.LogUtil;
import br.com.varal.model.annotation.util.AnnotationUtil;
import br.com.varal.model.entidade.AbstractEntidade;
import br.com.varal.model.util.DAOUtil;

public abstract class AbstractDAO<T extends AbstractEntidade> {

	private static final String SQL_INSERT = "INSERT INTO %s (%s) VALUES (%s);";
	private static final String SQL_UPDATE = "UPDATE %s SET %s WHERE ID = ?;";
	private static final String SQL_DELETE = "DELETE FROM %s WHERE ID = ?;";

	private static final String LOG_DELETE = "Delete: {sql: %s, id: %d, total: %d}";

	public void insert(T obj) throws Exception {
		Connection conn = DAOUtil.getConnection();
	}

	public void insert(Collection<T> list) throws Exception {
		for (T obj : list) {
			insert(obj);
		}
	}

	public void update(T obj) throws Exception {
		Connection conn = DAOUtil.getConnection();
	}

	public void update(Collection<T> list) throws Exception {
		for (T obj : list) {
			update(obj);
		}
	}

	public void delete(T obj) throws Exception {
		Connection conn = DAOUtil.getConnection();
		String tableName = AnnotationUtil.getDBTable(obj.getClass()).tableName();
		PreparedStatement stmn = conn.prepareStatement(String.format(SQL_DELETE, tableName));
		stmn.setInt(0, obj.getId());
		Integer rowDeleted = stmn.executeUpdate();
		LogUtil.info(String.format(LOG_DELETE, String.format(SQL_DELETE, tableName), obj.getId(), rowDeleted));
	}

	public void delete(Collection<T> list) throws Exception {
		for (T obj : list) {
			delete(obj);
		}
	}

}
