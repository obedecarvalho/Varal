package br.com.framework.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.framework.util.LogUtil;

public abstract class AbstractActionListener implements ActionListener{
	
	private static final String LOG_ACTION_PERFORMED = "Action Performed: %s";

	@Override
	public void actionPerformed(ActionEvent e) {
		LogUtil.trace(String.format(LOG_ACTION_PERFORMED,e.getActionCommand()));
	}

}