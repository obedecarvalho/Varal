package br.com.varal.model.entidade;

import br.com.framework.model.AbstractEntidade;
import br.com.framework.model.DataType;
import br.com.framework.model.annotation.DBColumn;
import br.com.framework.model.annotation.DBTable;

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

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
