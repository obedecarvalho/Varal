package br.com.varal.model.entidade;

import br.com.varal.model.annotation.DBColumn;
import br.com.varal.model.annotation.DBTable;
import br.com.varal.model.util.DataType;

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
	boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
}
