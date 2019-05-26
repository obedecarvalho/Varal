package br.com.framework.view;

import br.com.framework.util.LogUtil;
import br.com.framework.util.ValidatorUtil;
import br.com.varal.view.util.FramesEnum;

public class FramesManager {
	
	static private AbstractFrame frameAtual;
	
	static final String LOG_SELECT_FRAME = "Frame selecionado: %s";
	
	static public void selecionarFrame(FramesEnum novoFrame) {
		if (ValidatorUtil.isNotEmpty(frameAtual)) {
			frameAtual.setVisible(false);
			frameAtual.clear();
		}
		frameAtual = novoFrame.getFrame();
		LogUtil.trace(String.format(LOG_SELECT_FRAME, frameAtual.getName()));
		frameAtual.initialPanel();
		frameAtual.view();
	}
	
	static public void inicio() {
		selecionarFrame(FramesEnum.INICIO);
	}

}
