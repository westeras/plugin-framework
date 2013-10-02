package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import plugin.PluginFile;
import plugin.PluginManager;

public class Platform {
	private static final Dimension FRAME_SIZE = new Dimension(900, 480);
	public static ExecutionPanel ePanel;
	public static JFrame platform;
	public static void main(String[] args) {
		ArrayList<PluginFile> files = PluginManager.loadInstalledPlugins();
		platform = new JFrame("Plugin Platform");
		ePanel = new ExecutionPanel();
		platform.add(ePanel, BorderLayout.EAST);
		platform.add(new ListingPanel(files.toArray(new PluginFile[] {})), BorderLayout.WEST);
		StatusPanel.createConsole(platform); //Goes to the south
		
		platform.setSize(FRAME_SIZE);
		
		platform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ePanel.setVisible(true);
		platform.setVisible(true);
	}
}
