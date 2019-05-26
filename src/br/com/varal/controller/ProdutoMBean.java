package br.com.varal.controller;

import java.util.List;

import br.com.framework.controller.AbstractMBean;
import br.com.framework.util.ValidatorUtil;
import br.com.varal.model.dao.ProdutoDAO;
import br.com.varal.model.entidade.Produto;

public class ProdutoMBean extends AbstractMBean<Produto> {
	
	private static ProdutoMBean instance;
	
	protected ProdutoMBean() {}
	
	public static ProdutoMBean getInstance() {
		if (ValidatorUtil.isEmpty(instance)) {
			instance = new ProdutoMBean();
		}
		return instance;
	}
	
	@Override
	protected void initObj() {
		setObj(new Produto());		
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void novo() {
		//TODO
		initObj();
	}

	@Override
	public List<Produto> list() {
		//TODO
		ProdutoDAO dao = new ProdutoDAO();
		try {
			return dao.buscarTodos();
		} catch (Exception e) {
			tratarErroPadrao(e);
		}
		return null;
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO : validate
		ProdutoDAO dao = new ProdutoDAO();
		try {
			dao.insert(getObj());
		} catch (Exception e) {
			tratarErroPadrao(e);
		}
	}	

}
