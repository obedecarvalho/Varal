package br.com.varal.model.entidade;

import br.com.framework.model.AbstractEntidade;
import br.com.framework.model.DataType;
import br.com.framework.model.annotation.DBColumn;
import br.com.framework.model.annotation.DBTable;

@DBTable(tableName="compra")
public class Compra extends AbstractEntidade {

	@DBColumn(columnName="datacompra",dataType=DataType.INTEGER)
	private Integer dataCompra;

	public void setDataCompra(Integer dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getDataCompra() {
		return dataCompra;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}


}
