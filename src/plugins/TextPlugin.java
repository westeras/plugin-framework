package plugins;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import plugin.Plugin;

public class TextPlugin extends Plugin {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doActions() {
		System.out.println("Actions being done");
	}

	@Override
	public void unload() {
		// TODO Auto-generated method stub

	}

	@Override
	public JPanel getComponent() {
		this.panel = new JPanel();
		final JTextField text = new JTextField(20);
		text.setVisible(true);
		this.panel.add(text, BorderLayout.CENTER);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(text.getText());
			}	
		});
		
		this.panel.add(button, BorderLayout.CENTER);
		this.panel.setVisible(true);
		return this.panel;
	}
}
