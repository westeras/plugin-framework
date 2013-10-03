package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011. Updated by Daniel Schepers and
 *         Omar Abdel-Rahman, 1/27/2011
 */
public abstract class AbstractBouncer extends Ball {

	private double x;

	private double y;

	private double randX;

	private double randY;

	private BallEnvironment world;

	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world
	 */
	public AbstractBouncer(BallEnvironment world) {
		super(world);
		this.world = world;
		this.x = Random.randRange((int) this.getDiameter() / 2, (int) (world
				.getSize().width - this.getDiameter() / 2));
		this.y = Random.randRange((int) this.getDiameter() / 2, (int) (world
				.getSize().height - this.getDiameter() / 2));
		setCenterPoint(new Point2D.Double(this.x, this.y));
	}

	/**
	 * Makes an abstract class that both bouncer and exploder can use
	 * 
	 * @param world
	 * @param x
	 * @param y
	 */
	public AbstractBouncer(BallEnvironment world, double x, double y) {
		super(world, new Point2D.Double(x, y));
		this.world = world;
		this.x = x;
		this.y = y;
		setCenterPoint(new Point2D.Double(this.x, this.y));
	}

	@Override
	public double getDiameter() {
		// Not implemented
		return 0;
	}

	@Override
	public void updateColor() {
		// Not implemented

	}

	@Override
	public void updatePosition() {
		if (!this.getIsPaused()) {
			while (this.randX == 0) {
				this.randX = Random.randRange(-3, 3);
			}
			while (this.randY == 0) {
				this.randY = Random.randRange(-3, 3);
			}
			if ((this.getCenterPoint().getX() - (this.getDiameter()/2) <= 0)){
				this.randX = Math.abs(this.randX);
			}
			if ((this.getCenterPoint().getX() + (this.getDiameter()/2) >= this.world.getSize().width)) {
				this.randX = Math.abs(this.randX) * (-1);
			}
			if ((this.getCenterPoint().getY() - (this.getDiameter()/2) <= 0)){
				this.randY = Math.abs(this.randY);
			} 
			if (this.getCenterPoint().getY() + (this.getDiameter()/2) >= this.world.getSize().height) {
				this.randY = Math.abs(this.randY) * (-1);
			}
			this.x = this.x + this.randX;
			this.y = this.y + this.randY;
			setCenterPoint(new Point2D.Double(this.x, this.y));
		}

	}

	/**
	 * Sets the new points
	 *
	 * @param pt
	 */
	public void setXY(Point2D pt) {
		this.x = pt.getX();
		this.y = pt.getY();
	}

	@Override
	public void updateSize() {
		// Not implemented

	}

	@Override
	public Color getColor() {
		// Not implemented
		return null;
	}
	
	/**
	 * Gets the x velocity
	 *
	 * @return the x velocity
	 */
	public double getVelocityX() {
		// TODO Auto-generated method stub.
		return this.randX;
	}
	
	/**
	 * Gets the y velocity
	 *
	 * @return the y velocity
	 */
	public double getVelocityY() {
		// TODO Auto-generated method stub.
		return this.randY;
	}
	
	/**
	 * Sets the x and y velocity to the new values
	 *
	 * @param x
	 * @param y
	 */
	public void setVelocity(int x, int y) {
		this.randX = x;
		this.randY = y;
	}

}
