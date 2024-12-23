package de.hpi.javaide.breakout.starter;

import java.awt.Point;
/**
 * Just some Constants to be used throughout the Game
 * As it turned out, SCREEN_X and SCRREN_Y were not the best idea as this lead to problems with different screen resolutions.
 * Rather use the dynamic values to access the size of the window as provided by Processing.
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public interface GameConstants {
	int LIVES = 3;
	int SCREEN_X = 1280;
	int SCREEN_Y = 720;
	Point STARTPOSITION = new Point(SCREEN_X/2, SCREEN_Y/2);
}
