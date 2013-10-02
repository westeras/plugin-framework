package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import plugin.PluginFile;
import plugin.PluginManager;

public class ListingPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public ListingPanel(PluginFile[] plugins) {
		setLayout(new BorderLayout());
		final JList<PluginFile> list = new JList<PluginFile>();
		
		String[] names = new String[plugins.length];
		for (int i = 0; i < plugins.length; i++) {
			names[i] = plugins[i].getPluginName();
		}
		
		list.setListData(plugins);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		final JButton selectionButton = new JButton();
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.getSelectedIndex() == -1)
					selectionButton.setEnabled(false);
				else
					selectionButton.setEnabled(true);
			}
		});

		initializeButton(selectionButton, list);

		add(list);
		add(selectionButton, BorderLayout.SOUTH);
	}

	private void initializeButton(JButton selectionButton, final JList<PluginFile> list) {
		selectionButton.setText("Load");
		selectionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PluginFile selected = (PluginFile) list.getSelectedValue();
				Platform.ePanel.removeAll();
				Platform.ePanel.add(PluginManager.loadPlugin(selected));
				Platform.ePanel.repaint();
				Platform.platform.pack();
			}
		});
	}

}
