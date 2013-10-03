package ballworlds;

import java.awt.Color;

/**
 * Makes an exploder
 * 
 * @author Daniel Schepers and Omar Abdel-Rahman Created Jan 27, 2011.
 */
public class Exploder extends AbstractBouncer {
	
	private static double initialSize = 10;
	
	private double size = initialSize;

	private static final double MAXSIZE = Random.randRange((int) initialSize * 2,
			(int) initialSize * 10);

	private static final double SIZE_INCREMEMNT = 500;

	private BallEnvironment world;

	/**
	 * Makes an exploder in the given world
	 * 
	 * @param world
	 */
	public Exploder(BallEnvironment world) {
		super(world);
		this.world = world;

	}

	/**
	 * Another Exploder Constructor, this one given an x,y position to place the
	 * exploder in
	 * 
	 * @param world
	 * @param x
	 * @param y
	 */
	public Exploder(BallEnvironment world, double x, double y) {
		super(world, x, y);
		this.world = world;
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updateColor() {
		// This method is unimplemented- an exploder is a constant color

	}

	@Override
	public void updatePosition() {
		super.updatePosition();

	}

	@Override
	public void updateSize() {
		if(!this.getIsPaused()){
				if (this.size < Exploder.MAXSIZE) {
			this.size = this.size + (Exploder.MAXSIZE / SIZE_INCREMEMNT);
		}
		if (this.size >= Exploder.MAXSIZE) {
			this.world.addBall(new Exploder(this.world, this.getCenterPoint()
					.getX(), this.getCenterPoint().getY()));
			this.world.addBall(new Exploder(this.world, this.getCenterPoint()
					.getX(), this.getCenterPoint().getY()));
			super.die();

		}
		}
	

	}

	@Override
	public Color getColor() {
		return Color.black;
	}

}
