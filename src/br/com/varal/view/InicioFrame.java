package br.com.varal.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.varal.view.util.ConstanteFrames;
import br.com.varal.view.util.FramesManager;

public class InicioFrame extends AbstractFrame {
	
	private static final String frameName = "Inicio";

	public InicioFrame() {
		super(frameName);		
	}

	@Override
	public void criarPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		panel.add(addBtnMinhasCompras());
		panel.add(addBtnMinhasVendas());
		panel.add(addBtnMeusProdutos());
		panel.add(addBtnMeuDinheiro());
		panel.add(addBtnMeusClientes());
		add(panel);
	}

	private JButton addBtnMinhasCompras() {
		JButton btnMinhasCompras = new JButton("Minhas Compras");
		btnMinhasCompras.addActionListener(new AbstractActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
				FramesManager.selecionarFrame(ConstanteFrames.MINHAS_COMPRAS);
			}
		});
		return btnMinhasCompras;
	}

	private JButton addBtnMinhasVendas() {
		JButton btnMinhasVendas = new JButton("Minhas Vendas");
		return btnMinhasVendas;
	}

	private JButton addBtnMeusProdutos() {
		JButton btnMeusProdutos = new JButton("Meus Produtos");
		return btnMeusProdutos;
	}
	
	private JButton addBtnMeuDinheiro() {
		JButton btnMeuDinheiro = new JButton("Meu Dinheiro");
		return btnMeuDinheiro;
	}
	
	private JButton addBtnMeusClientes() {
		JButton btnMeusClientes = new JButton("Meus Clientes");
		return btnMeusClientes;
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		
	}

}
