package ballworlds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * Renders a world of balls on the GUI.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public class BallWorldComponent extends JComponent {

	/**
	 * Color used for a Ball selected by the user.
	 */
	public static final Color SELECTED_BALL_COLOR = Color.CYAN;

	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;

	private BallWorld world;
	private boolean hasShownNullErrorMessage = false;
	private Ball selectedBall = null;

	/**
	 * Constructs a component for rendering the given ball environment on the
	 * GUI.
	 * 
	 * @param world
	 */
	public BallWorldComponent(BallWorld world) {
		this.world = world;

		setPreferredSize(world.getSize());
		setMaximumSize(world.getSize());

		BallWorldMouseHandler mousehandler = new BallWorldMouseHandler();
		addMouseListener(mousehandler);
		addMouseMotionListener(mousehandler);

		// Creates a separate "thread of execution" to trigger periodic
		// repainting of this component.
		Runnable repainter = new Runnable() {
			@Override
			public void run() {
				// Periodically asks Java to repaint this component
				while (true) {
					try {
						Thread.sleep(REPAINT_INTERVAL_MS);
					} catch (InterruptedException exception) {
						// Nothing to do but go back to sleep
					}
					repaint();
				}
			}
		};
		new Thread(repainter).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		drawDrawable(g2, this.world);

		List<Drawable> drawableParts = this.world.getDrawableParts();
		for (Drawable d : drawableParts) {
			drawDrawable(g2, d);
		}
	}

	/**
	 * This helper method draws the given drawable object on the given graphics
	 * area.
	 * 
	 * @param g2
	 *            the graphics area on which to draw
	 * @param d
	 *            the drawable object
	 */
	private void drawDrawable(Graphics2D g2, Drawable d) {
		Color color = d.getColor();
		if (color == null) {
			showNullPointerMessage("color", d);
			return;
		}
		Shape shape = d.getShape();
		if (shape == null) {
			showNullPointerMessage("shape", d);
			return;
		}

		if (d == this.selectedBall) {
			g2.setColor(SELECTED_BALL_COLOR);
		} else {
			g2.setColor(color);
		}
		g2.fill(shape);
	}

	/**
	 * Displays an error message explaining that the Ball's color/shape was null
	 * so it could not be drawn. Show the message only once per component.
	 */
	private void showNullPointerMessage(String nullAttribute, Drawable d) {
		if (!this.hasShownNullErrorMessage) {
			this.hasShownNullErrorMessage = true;
			String message = "I could not draw this Drawable object of type "
					+ d.getClass().getName() + " because its " + nullAttribute
					+ " is null.\n";
			JOptionPane.showMessageDialog(null, message,
					"Null pointer exception", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * This inner class handles mouse events on the outer class's world.
	 */
	public class BallWorldMouseHandler implements MouseMotionListener,
			MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			Ball nearestBall = BallWorldComponent.this.world.nearestBall(e
					.getPoint());
			if (nearestBall != null) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// System.out.println(MouseEvent.MOUSE_PRESSED);
					nearestBall.setIsPaused(!nearestBall.getIsPaused());
				} else {
					// System.out.println(MouseEvent.MOUSE_PRESSED);
					nearestBall.die();
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			Ball nearestBall = BallWorldComponent.this.world.nearestBall(e
					.getPoint());
			BallWorldComponent.this.selectedBall = nearestBall;
			if(		BallWorldComponent.this.selectedBall != null)
			BallWorldComponent.this.selectedBall.setIsPaused(true);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (BallWorldComponent.this.selectedBall != null) {
				BallWorldComponent.this.selectedBall.moveTo(e.getPoint());

				if (BallWorldComponent.this.selectedBall instanceof AbstractBouncer) {
					AbstractBouncer temp;
					temp = (AbstractBouncer) BallWorldComponent.this.selectedBall;
					temp.setXY(e.getPoint());

				} else if (BallWorldComponent.this.selectedBall instanceof Mover) {
					Mover temp;
					temp = (Mover) BallWorldComponent.this.selectedBall;
					temp.setXY(e.getPoint());

				}

//				BallWorldComponent.this.selectedBall.setIsPaused(false);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (BallWorldComponent.this.selectedBall != null) {
				BallWorldComponent.this.selectedBall.setIsPaused(false);
				BallWorldComponent.this.selectedBall = null;
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// nothing to do
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// nothing to do
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// nothing to do
		}
	}

}
