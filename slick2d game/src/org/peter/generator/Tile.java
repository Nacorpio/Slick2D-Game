package org.peter.generator;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import MainGame.MouseHandler;
import MainGame.Player;
import MainGame.Playing;

public class Tile {

	/**
	 * This is the Tile class.
	 * This is where you can change the SIZE of the map, the block size, etc.
	 * This is the base class of tiles, you will be able to use poly and extend this class to make
	 * more complex tiles.
	 */

	public static final int SIZE = 300;
	public static final int BLOCK = 32;

	public float x;
	public float y;
	public float oX;
	public float oY;
	public int id = 0;

	protected Image tile;

	public Rectangle tileArea;
	protected MouseHandler mouse;
	boolean showBorders = false;

	//The constructor.
	public Tile(float x, float y, int id, String location) {
		this.oX = x;
		this.oY = y;
		this.id = id;

		try {
			tile = new Image(location);
			mouse = new MouseHandler();
			tileArea = new Rectangle(x, y, BLOCK, BLOCK);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	//sets location
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
		oX = x;
		oY = y;
	}

	//Updates the tile.
	public void update(int delta) {
		x = oX - Playing.offsetX;
		y = oY - Playing.offsetY;

		tileArea.setBounds((int) x, (int) y, BLOCK, BLOCK);
		if(tileArea.contains(mouse.getMouseX() - Playing.offsetX, mouse.getMouseY() - Playing.offsetY)){
			showBorders = true;
		}else{
			showBorders = false;
		}
	}

	//Renders the tile to the screen.
	public void render(Graphics g) {
		tile.draw(x, y, BLOCK, BLOCK);
		
		if (Player.playerRange == false) {
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		
		if(showBorders){
			g.drawRect(x, y, BLOCK - 1, BLOCK - 1);
		}
		
	}
	

}
