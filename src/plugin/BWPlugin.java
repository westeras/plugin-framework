package plugin;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ballworlds.Random;
import ballworlds.SimulationPanel;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schepedw.
 *         Created Oct 2, 2013.
 */
public class BWPlugin implements Plugin {
	private static final int GAP = 10;
	private static final int NUMBER_OF_SIMULATIONS = 2;
	private static final int MIN_WIDTH = 200;
	private static final int MAX_WIDTH = 600;
	private static final int MIN_HEIGHT = 100;
	private static final int MAX_HEIGHT = 300;
	private static final Color[] BACKGROUND_COLORS = { Color.RED,
			Color.BLUE, Color.GREEN };
	
	
	@Override
	public JPanel getComponent() {
		ArrayList<SimulationPanel> panels = constructSimulations();
		JPanel content = new JPanel();
		// Changes the layout of the panel so the worlds will stack vertically
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		// add "rigid stuff" to force minimum spacing
		content.add(Box.createVerticalStrut(GAP));
		for (SimulationPanel sp : panels) {
			content.add(sp);
			content.add(Box.createVerticalStrut(GAP));
		}
		return content;

	}
	private static ArrayList<SimulationPanel> constructSimulations() {
		ArrayList<SimulationPanel> result = new ArrayList<SimulationPanel>();
		for (int i = 0; i < NUMBER_OF_SIMULATIONS; i++) {
			int width = Random.randRange(MIN_WIDTH, MAX_WIDTH);
			int height = Random.randRange(MIN_HEIGHT, MAX_HEIGHT);
			Color c = BACKGROUND_COLORS[i % BACKGROUND_COLORS.length];
			SimulationPanel sp = new SimulationPanel(width, height, c);
			result.add(sp);
		}
		return result;
	}

}
