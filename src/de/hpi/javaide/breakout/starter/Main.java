package de.hpi.javaide.breakout.starter;

import processing.core.PApplet;

public class Main 
{

	/**
	 * This class just provides an entry point to start the program in full screen mode and then directly hands over to the Game class. 
	 * 
	 * @param args an array of Strings. Arguments to be passed via the command line when the program is started.
	 */
	public static void main(String[] args) 
	{
		PApplet.main(new String[]{"--present", "de.hpi.javaide.breakout.starter.Game"});
	}

}
