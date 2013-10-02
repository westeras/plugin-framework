package gui;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StatusPanel extends JPanel {

		protected static void createConsole(JFrame frame) {
			
			frame.add( new JLabel("Console" ), BorderLayout.SOUTH );
	        JTextArea ta = new JTextArea(10,10);
	        Console taos = new Console( ta, 1000 );
	        PrintStream ps = new PrintStream( taos );
	        System.setOut( ps );
	        System.setErr( ps );
	        frame.add( new JScrollPane( ta ), BorderLayout.SOUTH  );
	        frame.pack();
	        frame.setVisible( true );
		}
	

}