package br.com.varal.main;

import br.com.framework.core.VaralApplication;
import br.com.framework.core.util.LogUtil;
import br.com.framework.view.FramesManager;
import br.com.framework.view.util.SceneUtil;
import br.com.varal.controller.ProdutoMBean;
import br.com.varal.view.util.FramesEnum;

public class Main extends VaralApplication {

	public static void main(String[] args) {
		SceneUtil.addManageBean(ProdutoMBean.class);
		
		launch(args);
	}

}
