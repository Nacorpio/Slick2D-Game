package org.peter.generator;

public class Rock extends BlockedTile {

	public Rock(float x, float y) {
		super(x, y, 2, "images/rock.png");
		
	}
	
	@Override
	public void setLocation(float x, float y) {
		oX = x;
		oY = y;
		positionX = x;
		positionY = y;
		this.x = x;
		this.y = y;
	}


}
