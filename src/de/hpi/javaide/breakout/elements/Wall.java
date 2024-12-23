package de.hpi.javaide.breakout.elements;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for the Wall
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Wall implements Displayable, Iterable<Brick> {

	/**
	 * Datastructure to keep the Bricks
	 */
	private ArrayList<Brick> wall;
	/**
	 * Set the position of the Wall depending on window size and number of columns
	 */
	private int offsetX;
	private int offsetY;

	/**
	 * Create the wall with the given amount of rows and columns
	 * @param game Game a reference to the Processing features
	 * @param columns int the number of columns in the wall
	 * @param rows int the number of rows in the wall
	 */
	public Wall(Game game, int columns, int rows) {
		wall = new ArrayList<>();
		offsetX = (game.width / 2) - (columns * Brick.WIDTH / 2);
		offsetY = Brick.HEIGHT / 2;
		buildWall(game, columns, rows);
	}

	/**
	 * Remove a brick from the wall
	 * @param index
	 */
	public void removeBrick(int index) {
		wall.set(index, null);
	}

	/**
	 * Display the wall by displaying its Bricks
	 */
	@Override
	public void display() {
		for (Brick b : wall) {
			if (b != null)
				b.display();
		}
	}

	/**
	 * Make the Wall iterable by delegating to the ArrayList iterator 
	 */
	@Override
	public Iterator<Brick> iterator() {
		return wall.iterator();
	}
	
	/**
	 * Helper to build the Wall
	 * 
	 * @param game
	 * @param columns
	 * @param rows
	 */
	private void buildWall(Game game, int columns, int rows) {
		int bricksCount = columns * rows;

		for (int index = 0; index < bricksCount; index++) {
			int column = index % columns;
			int row = (index - column) / columns;
			addBrick(game, index, column, row);
		}
	}
	
	/**
	 * Add a new Brick to the Wall.
	 * Calculate its position depending on column and row.
	 * 
	 * @param game
	 * @param index
	 * @param column
	 * @param row
	 */
	private void addBrick(Game game, int index, int column, int row) {
		// System.out.println("Set: x: " + calcXPos(column) + " - y: " +
		// calcYPos(row));
		Brick brick = new Brick(game, new Point(calcXPos(column), calcYPos(row)));
//		System.out.println("Get: x: " + brick.getX() + "  -  y: " + brick.getY());
//		System.out.println("Get: w: " + brick.getWidth() + "  -  h: " + brick.getHeight());
		wall.add(brick);
	}

	/**
	 * Helper to calculate a Bricks x-pos (within the Wall) depending on the current column
	 * @param column
	 * @return
	 */
	private int calcXPos(int column) {
//		System.out.println("w: " + Brick.WIDTH + "  -  o: " + Brick.OFFSET);
		return column * (Brick.WIDTH + Brick.OFFSET) + this.offsetX;
	}

	/**
	 * Helper to calculate a Bricks x-pos (within the Wall) depending on the current row
	 * @param row
	 * @return
	 */
	private int calcYPos(int row) {
		return row * (Brick.HEIGHT + Brick.OFFSET) + this.offsetY;
	}
}
