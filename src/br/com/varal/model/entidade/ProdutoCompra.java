package br.com.varal.model.entidade;

import br.com.varal.model.annotation.DBColumn;
import br.com.varal.model.annotation.DBTable;
import br.com.varal.model.util.DataType;

@DBTable(tableName="produtocompra")
public class ProdutoCompra {

	@DBColumn(columnName="idcompra",dataType=DataType.INTEGER)
	private Integer idCompra;

	@DBColumn(columnName="idproduto",dataType=DataType.INTEGER)
	private Integer idProduto;

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

}
