package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for an UIObject to display info texts
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Info extends UIObject {

	/**
	 * The info text to be displayed
	 */
	private String content;
	
	/**
	 * Create a new info text
	 *  
	 * @param game Game reference to provide access to the Processing features
	 * @param content
	 */
	public Info(Game game, String content) {
		super(game);
		this.content = content; 
	}

	/**
	 * Set the new content of the info text to be displayed
	 */
	@Override
	public void update(String input) {
		content = input;
	}

	/**
	 * Display the info text
	 */
	@Override
	public void display() {
		game.textFont(Font.getFont32());
		game.text(content, game.width / 2, game.height / 2);
	}
}
