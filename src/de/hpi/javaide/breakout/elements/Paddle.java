package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Blueprint for the Paddle
 *  
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Paddle extends Rectangular {

	/**
	 * The speed of the paddle
	 */
	private int speed;

	/**
	 * Create the paddle
	 * @param game Game provide access to the Processing features
	 */
	public Paddle(Game game) {
		super(game, new Point(game.displayWidth / 2, game.displayHeight - 200), new Dimension(100, 20));
		setColor(150, 150, 150);
	}

	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.rect(getX(), getY(), getWidth(), getHeight());
	}

	/**
	 * Move the paddle. 
	 * Calculate the speed as the absolute distance between the current position of the mouse and the position of the mouse 
	 * in the previous frame (only makes sense when the Paddle is controlled by the mouse and not the keyboard)
	 */
	public void move() {
		update(new Point(game.mouseX, getY()), new Dimension(getWidth(), getHeight()));
		speed = Math.abs(game.mouseX - game.pmouseX);
	}

	/**
	 * The paddle's speed that is returned to the public.
	 * Make sure that the Ball does not get too fast.
	 * @return
	 */
	public int getSpeed() {
		int speed = (this.speed < 4) ? 4 : this.speed;
		return speed;
	}

}
