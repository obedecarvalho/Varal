package br.com.varal.view.util;

import br.com.varal.controller.util.LogUtil;
import br.com.varal.controller.util.ValidatorUtil;
import br.com.varal.view.frame.AbstractFrame;

public class FramesManager {
	
	static private AbstractFrame frameAtual;
	
	static final String LOG_SELECT_FRAME = "Frame selecionado: %s";
	
	static public void selecionarFrame(FramesEnum novoFrame) {
		if (ValidatorUtil.isNotEmpty(frameAtual)) {
			frameAtual.setVisible(false);
			frameAtual.limpar();
		}
		frameAtual = novoFrame.getFrame();
		LogUtil.trace(String.format(LOG_SELECT_FRAME, frameAtual.getName()));
		frameAtual.view();
	}
	
	static public void inicio() {
		selecionarFrame(FramesEnum.INICIO);
	}

}
