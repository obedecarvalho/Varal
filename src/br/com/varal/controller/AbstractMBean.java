package br.com.varal.controller;

import java.util.List;

import br.com.varal.controller.util.LogUtil;
import br.com.varal.model.entidade.AbstractEntidade;

public abstract class AbstractMBean<T extends AbstractEntidade> {
	
	protected T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	protected abstract void initObj();
	
	public abstract void save();
	
	public abstract void view();
	
	public abstract void edit();
	
	public abstract void novo();
	
	public abstract List<T> list();
	
	public abstract void cancel();
	
	protected void tratarErroPadrao(Exception e) {
		//TODO
		LogUtil.error(e);
	} 

}