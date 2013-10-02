package plugin;
import javax.swing.JPanel;


public abstract class Plugin {
	public JPanel panel;
	
	public void run() {
		init();
		doActions();
		unload();
	}
	
	public abstract void init();
	public abstract void doActions();
	public abstract void unload();
	public abstract JPanel getComponent();
}
