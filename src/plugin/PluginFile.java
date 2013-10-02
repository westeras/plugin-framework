package plugin;

public class PluginFile {
	
	private String pluginName;
	private String path;
	private Plugin plugin;
	
	public PluginFile(String name, String path, Plugin plugin) {
		this.pluginName = name;
		this.path = path;
		this.plugin = plugin;
	}
	
	public Plugin getPlugin() {
		return plugin;
	}
	
	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}
	public String getPluginName() {
		return pluginName;
	}
	
	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}	
	
	@Override
	public String toString() {
		return getPluginName();
	}
}
