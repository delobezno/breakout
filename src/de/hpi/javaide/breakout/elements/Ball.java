package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Blueprint for a Ball
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Ball extends Elliptic {
	/**
	 * the size of the Ball when its in the game
	 */
	private int fullSize;
	/**
	 * the direction in which the Ball is moving
	 */
	private Vector direction;

	/**
	 * Create a Ball at the given position with size 10,10 (depotSize).
	 * The fullSize of the Ball will be 30, 30 (gameSize).
	 * The color of the Ball is somewhat reddish
	 * 
	 * @param game Game reference to the Game that provides access to the Processing features 
	 * @param position Position x,y 
	 */
	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));
		direction = new Vector(2, 2);
		fullSize = 30;
		setColor(150, 0, 77);
	}

	/**
	 * Define the inherited to draw the Ball. 
	 * Use the Processing features as provided from the game to do so.
	 * Uses the methods that are provided by the CollisionObject to access the 
	 */
	@Override
	public void display() {
		game.ellipseMode(PApplet.CENTER);
		game.strokeWeight(4);
		game.fill(getR(), getG(), getB());
		game.noStroke();
		game.ellipse(getX(), getY(), getWidth(), getHeight());
	}
	/**
	 * Pump up the Ball to gameSize when it is moved from the depot to the game
	 */
	public void addAir() {
		update(new Point(getX(), getY()), new Dimension(fullSize, fullSize));
	}
	/**
	 * Move the Ball from the depot to its starting position in the game
	 */
	public void moveToStart() {
		update(Game.STARTPOSITION, new Dimension(fullSize, fullSize));
	}
	
	/**
	 * Move the Ball around.
	 */
	public void move() {
		update(new Point(getX() + (int) direction.getX(), getY() + (int) direction.getY()),
				new Dimension(getWidth(), getHeight()));
	}

	/**
	 * Bounce the ball in x-direction on collision
	 */
	void bounceX() {
		direction.setX(-direction.getX());
	}

	/**
	 * Bounce the ball in y-direction on collision
	 */
	void bounceY() {
		direction.setY(-direction.getY());
	}

	/**
	 * Set the speed of the ball (when it hits the paddle)
	 * @param speed
	 */
	void setSpeed(int speed) {
		direction.normalize();
		direction.mult(speed);
	}

	/**
	 * Determine in which direction the ball is currently moving
	 * @return boolean true if it is moving upwards
	 */
	public boolean isMovingUpwards() {
		return direction.getY() > 0;
	}
}
