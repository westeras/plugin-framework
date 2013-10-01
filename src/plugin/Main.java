package plugin;
public class Main {

	public static void main(String[] args) {
		PluginManager manager = new PluginManager();
		manager.loadPlugins();
		FrameworkUI ui = new FrameworkUI();
		ui.setVisible(true);
	}

}
