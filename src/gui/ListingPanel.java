package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.org.apache.bcel.internal.generic.Select;

import plugin.PluginFile;
import plugin.PluginManager;

public class ListingPanel extends JPanel {
	public ListingPanel(PluginFile[] plugins) {
		String imgLocation = "images/file.gif";
		URL imageURL = Toolbar.class.getResource(imgLocation);
		setLayout(new BorderLayout());
		final JList<PluginFile> list = new JList<PluginFile>();
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

	private void initializeButton(JButton selectionButton, final JList list) {
		selectionButton.setText("Load");
		selectionButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub.

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub.

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub.

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub.

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				PluginFile selected=(PluginFile) list.getSelectedValue();
				PluginManager.runSelected(selected);
				System.out.println("HOLA!");
			}

		});
	}

}
