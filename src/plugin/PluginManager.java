package plugin;
import java.io.File;
import java.util.ArrayList;


public class PluginManager {
	private ArrayList<PluginFile> plugins;
	
	public PluginManager() {
		this.plugins = new ArrayList<PluginFile>();
		String current = System.getProperty("user.dir");
		System.out.println(current);
	}
	
	public ArrayList<PluginFile> loadInstalledPlugins() {
		File path = new File("src/plugins");
		File files[] = path.listFiles();
		ArrayList<PluginFile> filePaths = new ArrayList<PluginFile>();
		for (File file : files) {
			PluginFile pFile = new PluginFile(file.getName(), file.getPath());
			filePaths.add(pFile);
		}
		return filePaths;
	}
	
	public ArrayList<PluginFile> getPlugins() {
		return this.plugins;
	}
	
	public void loadPlugin(PluginFile plugin, FrameworkUI ui) {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		try {
			Plugin loadedPlugin = (Plugin) loader.loadClass("plugins.TextPlugin").newInstance();
			loadedPlugin.setComponent(ui);
			loadedPlugin.doActions();
			//loader.loadClass("plugins." + plugin.getPluginName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
