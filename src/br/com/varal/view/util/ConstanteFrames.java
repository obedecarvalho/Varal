package br.com.varal.view.util;

import java.util.List;

import br.com.varal.view.AbstractFrame;
import br.com.varal.view.InicioFrame;
import br.com.varal.view.MinhasComprasFrame;

public enum ConstanteFrames {

	INICIO(new InicioFrame()), 
	MINHAS_COMPRAS(new MinhasComprasFrame()), 
	/*
	 * MINHAS_VENDAS(null), MEUS_PRODUTOS(null), MEU_DINHEIRO(null),
	 * MEUS_CLIENTES(null)
	 */
	;
	
	private AbstractFrame frame;
	//private List<JFrame> childFrame;
	
	private ConstanteFrames(AbstractFrame frame) {
		setFrame(frame);
		getFrame().criarPanel();
	}

	public AbstractFrame getFrame() {
		return frame;
	}

	public void setFrame(AbstractFrame frame) {
		this.frame = frame;
	}
	
	
}
