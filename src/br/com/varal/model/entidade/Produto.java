package br.com.varal.model.entidade;

import br.com.framework.core.AbstractEntidade;
import br.com.framework.model.DataType;
import br.com.framework.model.annotation.DBColumn;
import br.com.framework.model.annotation.DBTable;
import br.com.framework.view.annotation.VWColumn;
import br.com.framework.view.annotation.VWMBean;

@DBTable(tableName="produto")
public class Produto extends AbstractEntidade {

	@DBColumn(columnName="descricao",dataType=DataType.TEXT)
	@VWColumn(name="descricao", descricao="descricao do produto")
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
