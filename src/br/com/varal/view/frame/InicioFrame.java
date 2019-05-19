package br.com.varal.view.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.varal.view.AbstractActionListener;
import br.com.varal.view.util.ConstanteFrame;
import br.com.varal.view.util.FramesEnum;
import br.com.varal.view.util.FramesManager;

public class InicioFrame extends AbstractFrame {

	/*
	 * Texto Botões
	 */
	private final String BTN_MINHAS_COMPRAS = "Minhas Compras";
	private final String BTN_MINHAS_VENDAS = "Minhas Vendas";
	private final String BTN_MEUS_PRODUTOS = "Meus Produtos";
	private final String BTN_MEUS_CLIENTES = "Meus Clientes";
	private final String BTN_MEU_DINHEIRO = "Meu Dinheiro";
	/*
	 * Configuração Layout
	 */
	private final int LAYOUT_ROWS = 0;
	private final int LAYOUT_COLS = 2;
	
	public InicioFrame() {
		super(ConstanteFrame.FRAME_NAME_INICIO);
	}

	@Override
	public void criarPanelInicial() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS));
		panel.add(addBtnMinhasCompras());
		panel.add(addBtnMinhasVendas());
		panel.add(addBtnMeusProdutos());
		panel.add(addBtnMeuDinheiro());
		panel.add(addBtnMeusClientes());
		add(panel);
	}

	private JButton addBtnMinhasCompras() {
		JButton btnMinhasCompras = new JButton(BTN_MINHAS_COMPRAS);
		btnMinhasCompras.addActionListener(new AbstractActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
				FramesManager.selecionarFrame(FramesEnum.MINHAS_COMPRAS);
			}
		});
		return btnMinhasCompras;
	}

	private JButton addBtnMinhasVendas() {
		JButton btnMinhasVendas = new JButton(BTN_MINHAS_VENDAS);
		return btnMinhasVendas;
	}

	private JButton addBtnMeusProdutos() {
		JButton btnMeusProdutos = new JButton(BTN_MEUS_PRODUTOS);
		return btnMeusProdutos;
	}
	
	private JButton addBtnMeuDinheiro() {
		JButton btnMeuDinheiro = new JButton(BTN_MEU_DINHEIRO);
		return btnMeuDinheiro;
	}
	
	private JButton addBtnMeusClientes() {
		JButton btnMeusClientes = new JButton(BTN_MEUS_CLIENTES);
		return btnMeusClientes;
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		
	}

}
