package de.hpi.javaide.breakout.elements;

import java.awt.Point;
import java.util.ArrayList;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.Measureable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for the BallDepot
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class BallDepot implements Displayable, Measureable {

	/**
	 * Datastructure to store the Balls
	 */
	ArrayList<Ball> balls;

	/**
	 * x and y position of the depot
	 */
	private int depotX;
	private int depotY;
	/**
	 * distance between the balls in the depot
	 */
	private int offset = 50;

	/**
	 * Create the Depot at bottom right of the screen
	 * and add the amount of Balls that has been set in the game settings.
	 * @param game Game reference to access the Processing features
	 */
	public BallDepot(Game game) {
		balls = new ArrayList<>();

		depotX = game.width - this.getWidth();
		depotY = game.height - this.getHeight();

		for (int i = 0; i < Game.LIVES; i++) {
			balls.add(new Ball(game, new Point(depotX + (i * offset), depotY)));
		}
	}

	/**
	 * Dispense a Ball out of the Depot into the game.
	 * Remove it from the depot.
	 * Pump it up.
	 * Move it to the start position.
	 * 
	 * If the depot is empty, return null.
	 * 
	 * @return Ball the Ball (to become the currentBall)
	 */
	public Ball dispense() {
		if (balls.size() > 0) {
			System.out.println("go");
			Ball currentBall = balls.remove(0);
			currentBall.addAir();
			currentBall.moveToStart();
			return currentBall;
		} else {
			// todo: GAME OVER
			return null;
		}
	}

	/**
	 * Determine if the depot is empty by delegating to the ArrayLists isEmpty method
	 * @return
	 */
	public boolean isEmpty() {
		return balls.isEmpty();
	}

	/**
	 * Display the depot by displaying the Balls
	 */
	@Override
	public void display() {
		for (Ball ball : balls) {
			ball.display();
		}
	}

	@Override
	public int getX() {
		return depotX;
	}

	@Override
	public int getY() {
		return depotY;
	}

	@Override
	public int getWidth() {
		return Game.LIVES * offset;
	}

	@Override
	public int getHeight() {
		return offset;
	}
}
