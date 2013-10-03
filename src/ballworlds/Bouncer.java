package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Creates a Bouncer for the world
 *
 * @author abdelroh.
 *         Created Jan 27, 2011.
 */
public class Bouncer extends AbstractBouncer {
	
	
	private double size = 30;
	@SuppressWarnings("unused")
	private double x;
	@SuppressWarnings("unused")
	private double y;
	@SuppressWarnings("unused")
	private int randX;
	@SuppressWarnings("unused")
	private int randY;
	private Color color = Color.orange;

	/**
	 * Constructs a bouncer in the world
	 *
	 * @param world
	 */
	public Bouncer(BallEnvironment world) {
		super(world);
		// TODO Auto-generated constructor stub.
	}

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param world
	 * @param x
	 * @param y
	 * @param i
	 * @param j
	 * @param size 
	 * @param color 
	 * @param pink 
	 * @param starSIZE
	 */
	public Bouncer(BallEnvironment world, double x, double y, int i, int j,
			double size, Color color) {
			super(world);
			this.x = x;
			this.y = y;
			this.randX = i;
			this.randY = j;
			this.size = size;
			this.color = color;
			setCenterPoint(new Point2D.Double(x, y));
	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub.
		return this.size;
	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updatePosition() {
		super.updatePosition();

	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return this.color;
	}
}
