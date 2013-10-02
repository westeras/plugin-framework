package plugin;

public class PluginFile {
	
	private String pluginName;
	private String path;
	
	public PluginFile(String name, String path) {
		this.pluginName = name;
		this.path = path;
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
