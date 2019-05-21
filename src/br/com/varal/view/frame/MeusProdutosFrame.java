package br.com.varal.view.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.varal.controller.ProdutoMBean;
import br.com.varal.model.entidade.Produto;
import br.com.varal.view.AbstractActionListener;
import br.com.varal.view.util.ConstanteView;

public class MeusProdutosFrame extends AbstractFrame {

	public MeusProdutosFrame() {
		super(ConstanteView.FRAME_NAME_MEUS_PRODUTOS);
	}

	@Override
	public void criarPanelInicial() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(ConstanteView.LAYOUT_ROWS, ConstanteView.LAYOUT_COLS));
		//Descricao/Qtde
		//TODO
		panel.add(addBtnInicio());
		panel.add(addLblNomeFrame());
		panel.add(addBtnAdicionarProduto());

		panel.add(addTbProdutos(ProdutoMBean.getInstance().list()));

		add(panel);
	}

	public void criarPainelNovoProduto() {
		// TODO : Editar Produto
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(ConstanteView.LAYOUT_ROWS, ConstanteView.LAYOUT_COLS));
		//Descricao/Qtde
		//TODO
		panel.add(addBtnInicio());
		panel.add(addLblNomeFrame());
		panel.add(addBtnAdicionarProduto());

		panel.add(new JLabel("Descrição"));
		JTextField descricao = new JTextField();
		descricao.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ProdutoMBean.getInstance().getObj().setDescricao(descricao.getText());
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(descricao);

	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		
	}
	
	private JScrollPane addTbProdutos(List<Produto> produtos) {
		DefaultTableModel base = new DefaultTableModel();
		base.addColumn("Descrição");
		for (Produto p : produtos) {
			base.addRow(new String[] {p.getDescricao()});
		}

		JTable table = new JTable(base);

		return new JScrollPane(table);
	}

	private JButton addBtnAdicionarProduto() {
		JButton btnAdicionarCompra = new JButton(ConstanteView.BTN_ADD_PRODUTO);
		btnAdicionarCompra.addActionListener(new AbstractActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
				// TODO : implementar
				ProdutoMBean.getInstance().novo();
			}
		});
		return btnAdicionarCompra;
	}
	
	private JButton addBtnSalvarProduto() {
		JButton btnAdicionarCompra = new JButton(ConstanteView.BTN_PADRAO_SAVE);
		btnAdicionarCompra.addActionListener(new AbstractActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
				// TODO : implementar
				ProdutoMBean.getInstance().save();
			}
		});
		return btnAdicionarCompra;
	}

}
