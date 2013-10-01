package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ListingPanel extends JPanel {

	public ListingPanel() {
		setLayout(new BorderLayout());
		
		add(new Toolbar());
	}

}
