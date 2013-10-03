package plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;



public class PluginManager {
	
	public static ArrayList<PluginFile> loadInstalledPlugins() {
		File path = new File("plugins");
		File files[] = path.listFiles();
		ArrayList<PluginFile> filePaths = new ArrayList<PluginFile>();
		
		try {
			URL[] url = { path.toURI().toURL() };
			ClassLoader loader = new URLClassLoader(url);
			
			for (File file : files) {
				String name = file.getName();
				System.out.println(file.getName());
				IPlugin plugin = (IPlugin) loader.loadClass(name + ".Plugin").newInstance();
				PluginFile pFile = new PluginFile(name, file.getPath(), plugin);
				filePaths.add(pFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePaths;
	}
}
