package org.peter.generator;

import org.newdawn.slick.geom.Rectangle;

public class BlockedTile extends Tile {

	protected float positionY;
	protected float positionX;

	public BlockedTile(float x, float y, int id, String location) {
		super(x, y, id, location);
		
		positionY = y;
		positionX = x;
	}
	
	//Checks if the tile is blocked.
	public boolean blocked(Rectangle player) {
		
		Rectangle t = new Rectangle(positionX, positionY, 32, 32);
		
		if (player.intersects(t)) {
			return true;
		}else{
			return false;
		}
	}
}
