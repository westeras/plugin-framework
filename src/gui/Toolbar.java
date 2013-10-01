package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author schepedw. Created Sep 30, 2013.
 */
public class Toolbar extends JPanel implements ActionListener {
	static final private String SELECT = "Select";

	public Toolbar() {
		super(new BorderLayout());

		// Create the toolbar.
		JToolBar toolBar = new JToolBar("Still draggable");
		addButtons(toolBar);
		// Create the text area used for output. Request
		// enough space for 5 rows and 30 columns.
		JTextArea textArea = new JTextArea(5, 30);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		// Lay out the main panel.
		setPreferredSize(new Dimension(450, 130));
		add(toolBar, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);
	}

	protected void addButtons(JToolBar toolBar) {
		// first button
		JButton button = makeNavigationButton("Back24", SELECT,
				"Back to previous something-or-other", "Previous");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Create a file chooser
				final JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("./PluginJars"));
				int returnVal = fc.showOpenDialog(null);
				if (returnVal != JFileChooser.APPROVE_OPTION) {
					System.out.println("User cancelled file open!");
					System.exit(0);
				}
			}
		});
		toolBar.add(button);

	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param string
	 * @param select2
	 * @param string2
	 * @param string3
	 * @return
	 */
	protected JButton makeNavigationButton(String imageName,
			String actionCommand, String toolTipText, String altText) {
		// Look for the image.
		String imgLocation = "images/" + imageName + ".gif";
		URL imageURL = Toolbar.class.getResource(imgLocation);

		// Create and initialize the button.
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);

		if (imageURL != null) { // image found
			button.setIcon(new ImageIcon(imageURL, altText));
		} else { // no image found
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}

		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action performed so hard");

	}
}
