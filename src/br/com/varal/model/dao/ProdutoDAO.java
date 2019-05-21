package br.com.varal.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.varal.model.entidade.Produto;
import br.com.varal.model.util.DAOUtil;

public class ProdutoDAO extends AbstractDAO<Produto> {

	//TODO : refatorar -> usar findAll
	public List<Produto> buscarTodos() throws Exception{
		Connection conn = DAOUtil.getConnection();
		PreparedStatement pstmn = conn.prepareStatement("select * from produto;");
		ResultSet rs = pstmn.executeQuery();

		List<Produto> produtos = new ArrayList<Produto>();
		Produto p = null;

		while(rs.next()) {
			p = new Produto();
			p.setId(rs.getInt("id"));
			p.setDescricao(rs.getString("descricao"));
			produtos.add(p);
		}

		return produtos;
	}
}
