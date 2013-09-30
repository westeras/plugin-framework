package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author schepedw. Created Sep 29, 2013.
 */
public class Platform {
	private static final Dimension FRAME_SIZE = new Dimension(640,480);
	public static void main(String[] args) {
		JFrame fanFrame = new JFrame();
		fanFrame.setTitle("Platform");
		fanFrame.setSize(FRAME_SIZE);
		fanFrame.add(new ListingPanel());
		fanFrame.add(new ExecutionPanel());
		fanFrame.add(new StatusPanel());
		fanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fanFrame.setVisible(true);
	}
}
