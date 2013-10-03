package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * The pulsar class
 *
 * @author Daniel Schepers and Omar Abdel-Rahman
 *         Created Jan 27, 2011.
 */
public class Pulsar extends Ball {
	
	private double size = 30;

	private static final float INTENSITY_STEP = 0.01f;
	
	private boolean isIncreasing = true;
	private float intensity;

	private double x;

	private double y;

	/**
	 * 
	 * Makes a pulsar in the given world
	 *
	 * @param world
	 */
	public Pulsar(BallEnvironment world ){
		super(world);
		this.x = Random.randRange(0, world.getSize().width);
		this.y = Random.randRange(0, world.getSize().height);
		setCenterPoint(new Point2D.Double(this.x, this.y));
		this.intensity = 0.0f;
	}

	/**
	 * Creates a pulsar at a given point
	 *
	 * @param world
	 * @param x
	 * @param y
	 * @param size 
	 */
	public Pulsar(BallEnvironment world, double x, double y, double size) {
		super(world);
		this.x = x;
		this.y = y;
		this.size = size;
		setCenterPoint(new Point2D.Double(x, y));
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updateColor() {
		if (this.isIncreasing){
			this.intensity += INTENSITY_STEP;
			if (this.intensity > 1.0f){
				this.intensity = 1.0f;
				this.isIncreasing = false;
			}
		}
		else{
			this.intensity -= INTENSITY_STEP;
			if (this.intensity < 0.0f){
				this.intensity = 0.0f;
				this.isIncreasing = true;
			}
			
		}

	}

	@Override
	public void updatePosition() {
		//Unimplemented- The pulsar stays in the same place

	}

	@Override
	public void updateSize() {
		// Unimplemented- The pulsar stays the same size

	}

	@Override
	public Color getColor() {
		return new Color(this.intensity, this.intensity, this.intensity);
	}
}
