package br.com.varal.view.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.varal.view.AbstractActionListener;
import br.com.varal.view.util.ConstanteView;
import br.com.varal.view.util.FramesEnum;
import br.com.varal.view.util.FramesManager;

public class InicioFrame extends AbstractFrame {

	public InicioFrame() {
		super(ConstanteView.FRAME_NAME_INICIO);
	}

	@Override
	public void initialPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(ConstanteView.LAYOUT_ROWS_INICIO, ConstanteView.LAYOUT_COLS_INICIO));
		panel.add(addBtnMinhasCompras());
		panel.add(addBtnMinhasVendas());
		panel.add(addBtnMeusProdutos());
		panel.add(addBtnMeuDinheiro());
		panel.add(addBtnMeusClientes());
		add(panel);
	}

	private JButton addBtnMinhasCompras() {
		JButton btnMinhasCompras = new JButton(ConstanteView.BTN_MENU_MINHAS_COMPRAS);
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
		JButton btnMinhasVendas = new JButton(ConstanteView.BTN_MENU_MINHAS_VENDAS);
		return btnMinhasVendas;
	}

	private JButton addBtnMeusProdutos() {
		JButton btnMeusProdutos = new JButton(ConstanteView.BTN_MENU_MEUS_PRODUTOS);
		btnMeusProdutos.addActionListener(new AbstractActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
				FramesManager.selecionarFrame(FramesEnum.MEUS_PRODUTOS);
			}
		});
		return btnMeusProdutos;
	}
	
	private JButton addBtnMeuDinheiro() {
		JButton btnMeuDinheiro = new JButton(ConstanteView.BTN_MENU_MEU_DINHEIRO);
		return btnMeuDinheiro;
	}
	
	private JButton addBtnMeusClientes() {
		JButton btnMeusClientes = new JButton(ConstanteView.BTN_MENU_MEUS_CLIENTES);
		return btnMeusClientes;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
