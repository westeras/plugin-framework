package plugin;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;


public class PluginManager {
	
	public static ArrayList<PluginFile> loadInstalledPlugins() {
		File path = new File(".");
		File files[] = path.listFiles();
		ArrayList<PluginFile> filePaths = new ArrayList<PluginFile>();
		for (File file : files) {
			if (file.getName().contains(".jar")) {
				PluginFile pFile = new PluginFile(file.getName().replace(".jar", ""), file.getPath());
				filePaths.add(pFile);
			}
		}
		return filePaths;
	}
	
	public static JPanel loadPlugin(PluginFile plugin) {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Plugin loadedPlugin = null;
		try {
			loadedPlugin = (Plugin) loader.loadClass("TextPlugin").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return loadedPlugin.getComponent();
	}
}
