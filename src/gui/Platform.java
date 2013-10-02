package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import plugin.PluginFile;
import plugin.PluginManager;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author schepedw. Created Sep 29, 2013.
 */
public class Platform {
	private static final Dimension FRAME_SIZE = new Dimension(800, 480);
	public static void main(String[] args) {
		PluginManager manager = new PluginManager();
		ArrayList<PluginFile> files = manager.loadInstalledPlugins();
		JFrame platform = new JFrame("Plugin Platform");
		platform.add(new ListingPanel(files.toArray(new PluginFile[] {})), BorderLayout.WEST);
		StatusPanel.createConsole(platform);//Goes to the south
		platform.add(new ExecutionPanel(), BorderLayout.EAST);
		platform.setSize(900,480);
		System.out.println("printing to the console");
		platform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		platform.setVisible(true);
	}
}
