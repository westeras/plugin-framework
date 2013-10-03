package ballworlds;

import java.awt.Color;

/**
 * Constructs a special type of ball :D
 *
 * @author abdelroh.
 *         Created Jan 28, 2011.
 */
public class ExplodingStar extends AbstractBouncer {

	private double x;

	private double y;
	
	private final double STAR_SIZE = 10;

	private static double initialSize = 10;

	private double size = initialSize;

	private static final double MAXSIZE = Random.randRange(
			(int) initialSize * 2, (int) initialSize * 10);

	private static final double SIZE_INCREMEMNT = 500;

	private BallEnvironment world;

	/**
	 * Makes an exploder in the given world
	 * 
	 * @param world
	 */
	public ExplodingStar(BallEnvironment world) {
		super(world);
		this.world = world;
		this.x = Random.randRange(0, world.getSize().width);
		this.y = Random.randRange(0, world.getSize().height);

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
		if (!this.getIsPaused()) {
			if (this.size < ExplodingStar.MAXSIZE) {
				this.size = this.size
						+ (ExplodingStar.MAXSIZE / SIZE_INCREMEMNT);
			}
			if (this.size >= ExplodingStar.MAXSIZE) {
				this.x = this.getCenterPoint().getX();
				this.y = this.getCenterPoint().getY();
				this.world.addBall(new Bouncer(this.world, this.x, this.y, 1, 1, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Bouncer(this.world, this.x, this.y, 1, -1, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Bouncer(this.world, this.x, this.y, -1, 1, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Bouncer(this.world, this.x, this.y, 0, 0, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Bouncer(this.world, this.x, this.y, 0, 1, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Bouncer(this.world, this.x, this.y, 0, -1, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Bouncer(this.world, this.x, this.y, 1, 0, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Bouncer(this.world, this.x, this.y, -1, 0, this.STAR_SIZE, Color.pink));
				this.world.addBall(new Pulsar(this.world, this.x, this.y, this.STAR_SIZE));

				super.die();

			}
		}

	}

	@Override
	public Color getColor() {
		return Color.yellow;
	}

}
