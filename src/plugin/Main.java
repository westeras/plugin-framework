package plugin;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<PluginFile> files = PluginManager.loadInstalledPlugins();
		FrameworkUI ui = new FrameworkUI();
		ui.setVisible(true);
		PluginFile plugin = files.get(0);
		PluginManager.loadPlugin(plugin);
	}
}
