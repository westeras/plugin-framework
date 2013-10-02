package plugin;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FrameworkUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panel;

	public FrameworkUI() {
		super("Hello");
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.panel = new JPanel();
		this.add(this.panel);
	}
}
