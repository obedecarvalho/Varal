package br.com.varal.controller;

import java.util.List;

import br.com.framework.controller.AbstractMBean;
import br.com.framework.core.util.ValidatorUtil;
import br.com.framework.view.annotation.VWMBean;
import br.com.varal.model.dao.ProdutoDAO;
import br.com.varal.model.entidade.Produto;
@VWMBean(entityName="Produto", entityNamePlural="Produtos")
public class ProdutoMBean extends AbstractMBean<Produto> {
	
	/* private static ProdutoMBean instance; */
	
	/* protected ProdutoMBean() {} */
	
	/*
	 * public static ProdutoMBean getInstance() { if
	 * (ValidatorUtil.isEmpty(instance)) { instance = new ProdutoMBean(); } return
	 * instance; }
	 */
	
	@Override
	protected void initObj() {
		setObj(new Produto());		
	}
	
	
	/*
	 * public void view1() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 * public void edit() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 * public void novo() { //TODO initObj(); }
	 * 
	 * 
	 * public List<Produto> list() { //TODO ProdutoDAO dao = new ProdutoDAO(); try {
	 * return dao.buscarTodos(); } catch (Exception e) { tratarErroPadrao(e); }
	 * return null; }
	 * 
	 * 
	 * public void cancel1() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 * public void save1() { // TODO : validate ProdutoDAO dao = new ProdutoDAO();
	 * try { dao.insert(getObj()); } catch (Exception e) { tratarErroPadrao(e); } }
	 */

}
