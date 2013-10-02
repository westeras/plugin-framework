package plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;



public class PluginManager {
	
	public static ArrayList<PluginFile> loadInstalledPlugins() {
		File path = new File("src/plugin");
		File files[] = path.listFiles();
		ArrayList<PluginFile> filePaths = new ArrayList<PluginFile>();
		try {
			URL[] url = { path.toURI().toURL() };
			@SuppressWarnings("resource")
			ClassLoader loader = new URLClassLoader(url);
			
			for (File file : files) {
				if (file.getName().contains(".jar")) {
					String name = file.getName().replace(".jar", "");
					Plugin plugin = (Plugin) loader.loadClass("plugin." + name).newInstance();
					PluginFile pFile = new PluginFile(name, file.getPath(), plugin);
					filePaths.add(pFile);
				}
			}
		}
		catch (MalformedURLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return filePaths;
	}
}
