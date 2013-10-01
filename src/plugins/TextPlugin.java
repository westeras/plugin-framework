package plugins;

import javax.swing.JPanel;
import javax.swing.JTextField;

import plugin.FrameworkUI;
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
	public void setComponent(FrameworkUI ui) {
		this.panel = new JPanel();
		JTextField text = new JTextField(20);
		text.setVisible(true);
		this.panel.add(text);
		this.panel.setVisible(true);
		ui.add(this.panel);
	}
}
