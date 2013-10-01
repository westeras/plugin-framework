package plugin;
import java.io.File;
import java.util.ArrayList;


public class PluginManager {
	private ArrayList<File> plugins;
	
	public PluginManager() {
		this.plugins = new ArrayList<File>();
		String current = System.getProperty("user.dir");
		System.out.println(current);
	}
	
	public ArrayList<File> loadPlugins() {
		File path = new File("src/");
		return null;
	}
	
	public ArrayList<File> getPlugins() {
		return this.plugins;
	}
}
