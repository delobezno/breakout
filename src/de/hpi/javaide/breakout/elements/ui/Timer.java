package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;
/**
 * Blueprint for the UIObject to display a timer
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Timer extends UIObject {

	/**
	 * Constant (a variable that is not variable resp. can't be changed later on. 
	 * That's what the keyword final is for.)
	 * 
	 */
	public static final String RESET = "reset";
	/**
	 * The time in milliseconds 
	 */
	int time;
	/**
	 * Some values to do calculations on the time.
	 */
	int wait = 1000;
	private int seconds;

	public Timer(Game game) {
		super(game);
		seconds = 60;
		time = game.millis();
	}

	/**
	 * Do whatever calculations are necessary according to your intentions and update the value to be reset accordingly.
	 */
	@Override
	public void update(String input) {
		if (RESET.equals(input)) {
			seconds = 60;
		} else {
			//Wird einmal pro Sekunde ausgeführt.
			if(game.millis() - time >= wait){
				if (seconds > 0) {
					seconds--;
				} else {
					update(RESET);
				}
				if (seconds < 10) {
					game.increaseScore(-1);
				}
				time = game.millis();//also update the stored time
			}
		}
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Time left: " + seconds, game.width-150, game.height-80);
	}
}
