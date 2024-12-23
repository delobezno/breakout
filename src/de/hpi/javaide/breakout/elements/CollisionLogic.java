package de.hpi.javaide.breakout.elements;

import java.awt.geom.Rectangle2D;

import de.hpi.javaide.breakout.Collidable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Static Class. Provides a method that handles collisions by calling the "hooks" that are provided by the CollisionObjects.
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class CollisionLogic {
	/**
	 * Make sure the Class is not instantiated
	 */
	private CollisionLogic() {
	}

	/**
	 * Check if any of the CollisionObjects collides with another one. 
	 * Hand the action back to the CollisionObject.
	 * 
	 * @param game Game provides access to the Processing methods
	 * @param ball Ball the current ball
	 * @param paddle Paddle the paddle
	 * @param wall Wall the wall
	 */
	public static void checkCollision(Game game, Ball ball, Paddle paddle, Wall wall) {
		if (collidesWithSideBoundary(game, ball)) {
			ball.bounceX();
		} else if (collidesWithTopBoundary(game, ball)) {
			ball.bounceY();
		} else if (collidesWithPaddle(ball, paddle)) {
			// System.out.println("GS.update - PaddleCollision detected");
			ball.bounceY();
			ball.setSpeed(paddle.getSpeed());
		} else {
			for (Brick b : wall) {
				if (collidesWithBrick(ball, b)) {
					if (!b.isDead()) {
						ball.bounceY();
						if (ball.isMovingUpwards()) {
							b.nextStatus();
							game.increaseScore(1);
						}
					}
				}
			}
		}
	}

	/**
	 * Internal helper methods to provide speaking names for the actual decision making.
	 */
	private static boolean collidesWithSideBoundary(Game game, Collidable ball) {
        return 0 > (ball.getX() - ball.getWidth() / 2) || game.width < (ball.getX() + ball.getWidth() / 2);
	}

	private static boolean collidesWithTopBoundary(Game game, Collidable ball) {
		return 0 > (ball.getY() - ball.getHeight() / 2);
	}

	private static boolean collidesWithPaddle(Collidable ball, Collidable paddle) {
		return ball.getGeometry().intersects((Rectangle2D) paddle.getGeometry());
	}

	private static boolean collidesWithBrick(Collidable ball, Collidable brick) {
		return ball.getGeometry().intersects((Rectangle2D) brick.getGeometry());
	}
}
