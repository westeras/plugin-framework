import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class FrameworkUI extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameworkUI() {
		init();
	}
	
	public void init() {
//		JFrame frame = new JFrame();
//		JPanel panel1 = new JPanel();
//		JPanel panel2 = new JPanel();
//		JPanel panel3 = new JPanel();
//
//		// put three panels into a horizontal split pane,
//		// with 2 resizeable dividers
//		JSplitPane splitPaneLeft = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//		JSplitPane splitPaneRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//		splitPaneLeft.setLeftComponent( panel1 );
//		splitPaneLeft.setRightComponent( panel2 );
//		splitPaneRight.setLeftComponent( splitPaneLeft );
//		splitPaneRight.setRightComponent( panel3 );
//
//		// put splitPaneRight onto a single panel
//		JPanel panelSplit = new JPanel();
//		panelSplit.add( splitPaneRight );
//		
//		frame.add(panel1);
//		frame.add(panel2);
//		frame.add(panel3);
//		
//		frame.setTitle("Tooltip");
//        frame.setSize(300, 200);
//        frame.setLocationRelativeTo(null);
//        
//        add(frame);
		JFrame frame = new JFrame("Hello, world");
		JPanel panel = new JPanel();
		frame.setVisible(true);
		add(panel);
	}
}
