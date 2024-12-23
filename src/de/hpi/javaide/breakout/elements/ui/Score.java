package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for the UIObject to display the current score of a player
 *  
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Score extends UIObject {

	/**
	 * The score to be displayed
	 */
	private int score;
	
	public Score(Game game) {
		super(game);
		score = 0;
	}

	@Override
	public void update(String input) { 
		score += Integer.parseInt(input);
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Score: " + score, game.width-150, game.height-100);
	}
}
