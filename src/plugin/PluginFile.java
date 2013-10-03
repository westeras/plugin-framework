package plugin;

public class PluginFile {
	
	private String pluginName;
	private String path;
	private IPlugin plugin;
	
	public PluginFile(String name, String path, IPlugin plugin) {
		this.pluginName = name;
		this.path = path;
		this.plugin = plugin;
	}
	
	public IPlugin getPlugin() {
		return plugin;
	}
	
	public void setPlugin(IPlugin plugin) {
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
