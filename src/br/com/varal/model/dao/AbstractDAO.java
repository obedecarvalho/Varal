package br.com.varal.model.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.varal.controller.util.LogUtil;
import br.com.varal.controller.util.StringUtil;
import br.com.varal.controller.util.ValidatorUtil;
import br.com.varal.model.annotation.DBColumn;
import br.com.varal.model.annotation.util.AnnotationUtil;
import br.com.varal.model.entidade.AbstractEntidade;
import br.com.varal.model.util.Coluna;
import br.com.varal.model.util.DAOUtil;

public abstract class AbstractDAO<T extends AbstractEntidade> {

	private static final String SQL_INSERT = "INSERT INTO %s (%s) VALUES (%s);";
	private static final String SQL_UPDATE = "UPDATE %s SET %s WHERE ID = ?;";
	private static final String SQL_DELETE = "DELETE FROM %s WHERE ID = ?;";
	private static final String SQL_SELECT_ALL = "SELECT %d FROM %s;";
	private static final String SQL_SELECT = "SELECT %d FROM %s WHERE ID = ?;";

	private static final String SQL_FIELD = "%s = ?";

	private static final String LOG_DELETE = "Delete: {sql: %s, id: %d, total: %d}";
	private static final String LOG_UPDATE = "Update: {sql: %s, id: %d, total: %d}";
	private static final String LOG_INSERT = "Insert: {sql: %s, id: %d, total: %d}";

	public void insert(T obj) throws Exception {
		Connection conn = DAOUtil.getConnection();
		String tableName = AnnotationUtil.getDBTable(obj.getClass()).tableName();
		List<Coluna> fields = AnnotationUtil.getColumnValues(obj);
		String fieldsString = generateFieldsInsert(fields);
		String fieldCard = StringUtil.stringMultiple("?", fields.size(), ",");
		PreparedStatement stmn = conn.prepareStatement(String.format(SQL_INSERT, tableName, fieldsString, fieldCard));
		for (int i = 0; i< fields.size(); i++) {
			setAttributeByType(stmn, fields.get(i), i);
		}
		Integer rowDeleted = stmn.executeUpdate();
		LogUtil.info(String.format(LOG_INSERT, String.format(SQL_INSERT, tableName, fieldsString, fieldCard), obj.getId(), rowDeleted));
	}

	public void insert(Collection<T> list) throws Exception {
		for (T obj : list) {
			insert(obj);
		}
	}

	public void update(T obj) throws Exception {
		Connection conn = DAOUtil.getConnection();
		String tableName = AnnotationUtil.getDBTable(obj.getClass()).tableName();
		List<Coluna> fields = AnnotationUtil.getColumnValues(obj);
		String fieldsString = generateFieldsUpdate(fields);
		PreparedStatement stmn = conn.prepareStatement(String.format(SQL_UPDATE, tableName, fieldsString));
		for (int i = 0; i< fields.size(); i++) {
			setAttributeByType(stmn, fields.get(i), i);
		}
		stmn.setInt(fields.size(), obj.getId());
		Integer rowUpdated = stmn.executeUpdate();
		LogUtil.info(String.format(LOG_UPDATE, String.format(SQL_UPDATE, tableName, fieldsString), obj.getId(), rowUpdated));
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

	public T findById(Integer id, Class<? extends AbstractEntidade> clazz) throws Exception {
		Connection conn = DAOUtil.getConnection();
		String tableName = AnnotationUtil.getDBTable(clazz).tableName();
		Map<DBColumn,Field> fields = AnnotationUtil.getDBColumns(clazz);
		String fieldsString = generateFieldsInsert(fields);
		PreparedStatement stmn = conn.prepareStatement(String.format(SQL_SELECT, fieldsString, tableName));
		stmn.setInt(0, id);
		// TODO
		return null;
	}

	public List<T> findAll(Class<? extends AbstractEntidade> clazz){
		//TODO
		return null;
	}

	private String generateFieldsUpdate(List<Coluna> columns) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			Coluna c = columns.get(i);
			sb.append(String.format(SQL_FIELD, c.getColumnName()));
		}
		return sb.toString();
	}

	private String generateFieldsInsert(Map<DBColumn,Field> columns) {
		StringBuilder sb = new StringBuilder();
		Collection<DBColumn> colunas = columns.keySet();
		for (DBColumn col : colunas) {
			sb.append(", ");
			sb.append(col.columnName());
		}
		return sb.toString().toString().substring(1);
	}


	private String generateFieldsInsert(List<Coluna> columns) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			Coluna c = columns.get(i);
			sb.append(c.getColumnName());
		}
		return sb.toString();
	}

	private void setAttributeByType(PreparedStatement stmn, Coluna column, int pos) throws SQLException {
		if (ValidatorUtil.isEmpty(column.getValue())) {
			stmn.setNull(pos, Types.NULL);
		} else if (column.getType().isInteger()) {
			stmn.setInt(pos, column.getValueInteger());
		} else if (column.getType().isReal()) {
			stmn.setDouble(pos, column.getValueReal());
		} else if (column.getType().isText()) {
			stmn.setString(pos, column.getValueText());
		} else if (column.getType().isBlob()) {
			//TODO
			//stmn.setBlob(pos, column.getValueBlob());
		}
	}

}
