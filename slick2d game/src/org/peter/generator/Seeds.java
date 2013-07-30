package org.peter.generator;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.peter.time.*;

import MainGame.Inventory;
import MainGame.Playing;

public abstract class Seeds extends Tile {
	
	public Image seed[];
	private Timer time;
	private boolean justTicked = false;
	private boolean finishedGrowing = false;
	public boolean harvested = false;
	
	protected Inventory inv = new Inventory();
	private Level level = new Level();
	
	public int state = 0;

	public Seeds(int x, int y, int ID, String path[]) {
		super(x, y, ID, "images/hoed-watered.png");
		seed = new Image[path.length];
		time = new Timer();
		
		try {
			for (int i = 0; i < seed.length; i++) {
				seed[i] = new Image(path[i]);
			}
 		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(int delta) {
		x = oX - Playing.offsetX;
		y = oY - Playing.offsetY;
		
		//Changes stages depending on time.
		if (time.day() && justTicked && finishedGrowing == false) {
			state += 1;
			justTicked = false;
			
			System.out.println("Plant state: " + state);
			
			if (state == seed.length - 1) {
				finishedGrowing = true;
			}
		}
		
		
		if (time.day() == false) {
			justTicked = true;
		}

		tileArea.setBounds((int) x, (int) y, BLOCK, BLOCK);
		if(tileArea.contains(mouse.getMouseX() - Playing.offsetX, mouse.getMouseY() - Playing.offsetY)){
			showBorders = true;
		}else{
			showBorders = false;
		}
		
		
	}
	
	//Picks the plant / harvests it.
	public void pickPlant() {
		if (harvested == false) {
			harvest();
			
			level.replaceTile((int) oX/32, (int) oY/32, id, 3);
		}
		
	    harvested = true;
	}
	
	public abstract void harvest();

}
