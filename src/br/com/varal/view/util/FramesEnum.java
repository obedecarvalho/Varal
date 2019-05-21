package br.com.varal.view.util;

import java.util.List;

import br.com.varal.view.frame.AbstractFrame;
import br.com.varal.view.frame.InicioFrame;
import br.com.varal.view.frame.MinhasComprasFrame;
import br.com.varal.view.frame.MeusProdutosFrame;;

public enum FramesEnum {
	
	INICIO(new InicioFrame()), 
	MINHAS_COMPRAS(new MinhasComprasFrame()), 
	MEUS_PRODUTOS(new MeusProdutosFrame())
	/*
	 * MINHAS_VENDAS(null), MEU_DINHEIRO(null),
	 * MEUS_CLIENTES(null)
	 */
	;
	
	private AbstractFrame frame;
	//private List<JFrame> childFrame;
	
	private FramesEnum(AbstractFrame frame) {
		setFrame(frame);
		//getFrame().initialPanel();
	}

	public AbstractFrame getFrame() {
		return frame;
	}

	public void setFrame(AbstractFrame frame) {
		this.frame = frame;
	}	
	
}
