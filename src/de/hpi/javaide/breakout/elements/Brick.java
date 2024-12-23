package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Blueprint for the Brick
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Brick extends Rectangular {
	/**
	 * The Brick's status. Is reduced by 1 each time it is hit by a Ball.
	 */
	private int status = 3;
	/**
	 * Width and height of a brick
	 */
	public final static int WIDTH = 100;
	public final static int HEIGHT = 20;
	/**
	 * The distance between the bricks
	 */
	public final static int OFFSET = 5;

	/**
	 * Create a new Brick at the given position.
	 * Pass a reference to access the Processing features.
	 * 
	 * @param game
	 * @param position
	 */
	public Brick(Game game, Point position) {
		super(game, position, new Dimension(WIDTH, HEIGHT));
	}

	/**
	 * Display the Brick. 
	 * Make it invisible if it's dead.
	 */
	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.strokeWeight(4);
		game.noStroke();
		if (isDead()) {
			game.noFill();
		} else {
			game.fill(getR(), getG(), getB());
		}
		game.rect(getX(), getY(), getWidth(), getHeight());
	}

	/**
	 * If the Brick is hit (and not already dead), set the next status.
	 * Calculate the color of the brick depending on the status.
	 */
	public void nextStatus() {
		if (!isDead())
			status--;
		setColor(calcColorComponent(85), calcColorComponent(60), calcColorComponent(20));
	}

	/**
	 * Determine if the Brick is already dead.
	 * @return true if the status is 0 or less
	 */
	public boolean isDead() {
		return status <= 0;
	}

	/**
	 * Helper to calculate the Brick's color components depending on the status.
	 * @param factor int basic value for the color component (0-255)
	 * @return int the new color value (0-255)
	 */
	private int calcColorComponent(int factor) {
		return status * factor;
	}
}
