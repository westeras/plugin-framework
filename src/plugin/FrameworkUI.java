package plugin;
import javax.swing.JFrame;


public class FrameworkUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public FrameworkUI() {
		super("Hello");
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
	}
}
