package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Makes a mover
 *
 * @author Daniel Schepers and Omar Abdel-Rahman
 *         Created Jan 27, 2011.
 */
public class Mover extends Ball {

	private double size = 50;

	private double x;

	private double y;

	private double randX;

	private double randY;

	/**
	 * Constructs a mover that can be added to the given world
	 * 
	 * @param world
	 */
	public Mover(BallEnvironment world) {
		super(world);
		this.x = (world.getSize().width / 2);
		this.y = (world.getSize().height / 2);
		setCenterPoint(new Point2D.Double(this.x, this.y));
		this.randX = Random.randRange(-3, 3);
		this.randY = Random.randRange(-3, 3);
	}

	/**
	 * This is never used.
	 *
	 * @param world
	 * @param x 
	 * @param y 
	 * @param j 
	 * @param i 
	 * @param size 
	 * @param sTARSIZE 
	 */
	public Mover(BallEnvironment world, double x, double y, int i, int j, double size) {
		super(world);
		this.x = x;
		this.y = y;
		this.randX = i;
		this.randY = j;
		this.size = size;
		setCenterPoint(new Point2D.Double(x, y));
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updateColor() {
		// Does nothing- the color of the mover is a constant

	}
	
	

	@Override
	public void updatePosition() {
		if(!this.getIsPaused()){
					while (this.randX == 0 && this.randY == 0) {
			this.randX = Random.randRange(-3, 3);
		}
		this.x = this.x + this.randX;
		this.y = this.y + this.randY;
		setCenterPoint(new Point2D.Double(this.x, this.y));

		}

	}
	
	/**
	 * Gets the last point of the Ball
	 *
	 * @param pt
	 */
	public void setXY(Point2D pt){
		this.x = pt.getX();
		this.y = pt.getY();
	}

	@Override
	public void updateSize() {
		// Does nothing- the size of the mover is constant
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}

}
