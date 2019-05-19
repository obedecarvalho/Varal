package br.com.varal.model.entidade;

import br.com.varal.model.annotation.DBColumn;
import br.com.varal.model.annotation.DBTable;
import br.com.varal.model.util.DataType;

@DBTable(tableName="produto")
public class Produto extends AbstractEntidade {

	@DBColumn(columnName="descricao",dataType=DataType.TEXT)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
