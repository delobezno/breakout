package de.hpi.javaide.breakout.screens;

import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.elements.ui.Info;
import de.hpi.javaide.breakout.starter.Game;

/**
 * The Screen can be in three states, either the StartScreen, the GameScreen, or the EndScreen.
 * The game logic takes care, which of those is the currently active screen.
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class EndScreen implements Screen {

	/**
	 * This variable is needed for the Singleton pattern
	 */
	private static Screen instance;
	/**
	 * A reference to get access to the Processing features
	 */
	private Game game;
	/**
	 * A UIObject to display some information
	 */
	private UIObject infoBox;

	private EndScreen(Game game) {
		this.game = game;
		init();
	}

	/**
	 * EndScreen folgt dem Ansatz der "Lazy Instantiation" des Singleton Design
	 * Patterns (Gang of Four) Dieser Ansatz ist nicht "Thread safe", genügt
	 * hier aber unseren Ansprüchen.
	 * 
	 * @return the EndScreen
	 */
	public static Screen getInstance(Game game) {
		if (instance == null) {
			instance = new EndScreen(game);
		} else {
			instance.init();
		}
		return instance;
	}

	/**
	 * Initialize the EndScreen 
	 */
	@Override
	public void init() {
		game.background(0);
		String info = "Game over!!!\n";
		info += "Press Enter to restart!\n";
		infoBox = new Info(game, info);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void display() {
		System.out.println("Game over: Hit enter to restart.");
		infoBox.display();
	}

	@Override
	public void handleKeyPressed(String key) {
		switch (key) {
		case Screen.KEY_ENTER:
			System.out.println("restart..");
			ScreenManager.setScreen(game, Screen.START);
		}
	}

	@Override
	public void handleMouseDragged() {
		// Im EndScreen ist keine Interaktion mit der Maus notwendig.
	}

	@Override
	public void increaseScore(int i) {
		// Im EndScreen gibt es keinen Counter.
	}
}
