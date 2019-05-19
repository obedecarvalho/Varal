package br.com.varal.main;

import br.com.varal.controller.util.LogUtil;
import br.com.varal.view.util.ConstanteFrames;
import br.com.varal.view.util.FramesManager;

public class Main {

	public static void main(String[] args) {
		LogUtil.info("Iniciando.");
		FramesManager.selecionarFrame(ConstanteFrames.INICIO);
	}

}