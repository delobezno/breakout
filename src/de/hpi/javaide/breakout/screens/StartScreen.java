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
public class StartScreen implements Screen {

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
	
	private StartScreen(Game game){
		this.game = game;
		init();
	}

	/** 
	 * StartScreen folgt dem Ansatz der "Lazy Instantiation" des 
	 * Singleton Design Patterns (Gang of Four)
	 * Dieser Ansatz ist nicht "Thread safe", genügt hier aber unseren Ansprüchen.
	 * 
	 * @return the StartScreen
	 */
	public static Screen getInstance(Game game){
		if(instance == null){
	    	instance = new StartScreen(game);
	    } else {
	    	instance.init();
	    }
	    return instance;
	}
	
	@Override
	public void init() {
		game.noLoop();
		game.background(0);
		String info = "Press Enter to start!\n";
		info += "Press Enter to launch the balls\n";
		infoBox = new Info(game, info);
		infoBox.display();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void display() {
		System.out.println("Hit enter to start");
		infoBox.display();
	}

	@Override
	public void handleKeyPressed(String key) {
		switch (key) {
		case Screen.KEY_ENTER: 
			System.out.println("starting..");
			ScreenManager.setScreen(game, Screen.GAME);
			break;
		default: break;
		}
	}

	@Override
	public void handleMouseDragged() {
		// Interaction with the mouse is not necessary in the EndScreen
	}

	@Override
	public void increaseScore(int i) {
		// There is no counter in the EndScreen
	}
}
