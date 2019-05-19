package br.com.varal.view;

import javax.swing.JPanel;

public class MinhasComprasFrame extends AbstractFrame {
	
	private static final String frameName = "Minhas Compras";

	public MinhasComprasFrame() {
		super(frameName);
	}

	@Override
	public void criarPanel() {
		JPanel panel = new JPanel();
		panel.add(addBtnInicio());
		panel.add(addLblNomeFrame());
		add(panel);
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
	}

}
