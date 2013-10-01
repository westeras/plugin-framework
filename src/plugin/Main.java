package plugin;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		PluginManager manager = new PluginManager();
		ArrayList<PluginFile> files = manager.loadInstalledPlugins();
		FrameworkUI ui = new FrameworkUI();
		ui.setVisible(true);

		PluginFile plugin = files.get(0);
		manager.loadPlugin(plugin, ui);
	}
}
