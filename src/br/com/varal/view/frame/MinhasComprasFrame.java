package br.com.varal.view.frame;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.varal.view.AbstractActionListener;
import br.com.varal.view.util.ConstanteView;

public class MinhasComprasFrame extends AbstractFrameCRUD {
	
	public MinhasComprasFrame() {
		super(ConstanteView.FRAME_NAME_MINHAS_COMPRAS);
	}

	@Override
	public void initialPanel() {
		JPanel panel = new JPanel();
		panel.add(addBtnInicio());
		panel.add(addLblNomeFrame());
		panel.add(addBtnAdicionarCompra());
		add(panel);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}
	
	private JButton addBtnAdicionarCompra() {
		JButton btnAdicionarCompra = new JButton(ConstanteView.BTN_ADD_COMPRA);
		btnAdicionarCompra.addActionListener(new AbstractActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
				// TODO : implementar
			}
		});
		return btnAdicionarCompra;
	}

	@Override
	public void editPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchPanel() {
		// TODO Auto-generated method stub
		
	}

}
