package plugin;
import javax.swing.JComponent;


public abstract class Plugin {
	public JComponent component;
	
	public void run() {
		init();
		doActions();
		unload();
	}
	
	public abstract void init();
	public abstract void doActions();
	public abstract void unload();
}
