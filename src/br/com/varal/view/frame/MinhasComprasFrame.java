package br.com.varal.view.frame;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.varal.view.AbstractActionListener;
import br.com.varal.view.util.ConstanteFrame;

public class MinhasComprasFrame extends AbstractFrame {
	
	/*
	 * Texto Botões
	 */
	private final String BTN_ADD_COMPRA = "Adicionar Compra";

	public MinhasComprasFrame() {
		super(ConstanteFrame.FRAME_NAME_MINHAS_COMPRAS);
	}

	@Override
	public void criarPanelInicial() {
		JPanel panel = new JPanel();
		panel.add(addBtnInicio());
		panel.add(addLblNomeFrame());
		panel.add(addBtnAdicionarCompra());
		add(panel);
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
	}
	
	private JButton addBtnAdicionarCompra() {
		JButton btnAdicionarCompra = new JButton(BTN_ADD_COMPRA);
		btnAdicionarCompra.addActionListener(new AbstractActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
				// TODO : implementar
			}
		});
		return btnAdicionarCompra;
	}

}
