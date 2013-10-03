package plugin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPlugin implements Plugin {

	public JPanel getComponent() {
		JPanel panel = new JPanel();
		final JTextField text = new JTextField(20);
		text.setVisible(true);
		panel.add(text, BorderLayout.CENTER);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(text.getText());
			}	
		});
		
		panel.add(button, BorderLayout.CENTER);
		panel.setVisible(true);
		return panel;
	}
}
