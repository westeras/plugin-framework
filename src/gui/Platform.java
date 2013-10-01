package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author schepedw. Created Sep 29, 2013.
 */
public class Platform {
	private static final Dimension FRAME_SIZE = new Dimension(640, 480);

	// if we revove the main method, we can make the panels public variables
	public static void main(String[] args) {

		JFrame platform = new JFrame();
		platform.setTitle("Platform");
		platform.setSize(FRAME_SIZE);
		platform.add(new ListingPanel(), BorderLayout.NORTH);
		createConsole(platform);
		//platform.add(ep, BorderLayout.SOUTH);
		platform.add(new StatusPanel(), BorderLayout.EAST);
		platform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		platform.setVisible(true);
	}


	private static void createConsole(JFrame frame) {
		frame.add( new JLabel("Console" ), BorderLayout.CENTER );

        JTextArea ta = new JTextArea();
        Console taos = new Console( ta, 60 );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );


        frame.add( new JScrollPane( ta ), BorderLayout.SOUTH  );

        frame.pack();
        frame.setVisible( true );

        for( int i = 0 ; i < 10 ; i++ ) {
            System.out.println( i );
            try {
				Thread.sleep( 500 );
			} catch (InterruptedException exception) {
				// TODO Auto-generated catch-block stub.
				exception.printStackTrace();
			}
        }
		
	}

}
