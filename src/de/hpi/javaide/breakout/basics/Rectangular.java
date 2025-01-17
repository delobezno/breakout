package de.hpi.javaide.breakout.basics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import de.hpi.javaide.breakout.starter.Game;

/**
 * Extends the CollisionObject to provide the basis for the rectangular collidable Elements, such as the Paddle or a Brick.
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public abstract class Rectangular extends CollisionObject {

	/**
	 * Constructor to create the basis for a rectangular object
	 * 
	 * @param game Game reference to the game that provides access to the Processing features
	 * @param position Position x,y position of the Object
	 * @param dimension
	 */
	public Rectangular(Game game, Point position, Dimension dimension) {
		super(game, position, dimension);
		geometry = new Rectangle2D.Float(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
	}

	@Override
	public void update(Point position, Dimension dimension) {
		super.update(position, dimension);
		((Rectangle2D) this.getGeometry()).setFrame(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
	}
}
