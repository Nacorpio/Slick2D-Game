package org.peter.generator;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import MainGame.Game;
import MainGame.Playing;

public class Level {

	public static Tile level[][] = new Tile[Tile.SIZE][Tile.SIZE];
	
	public static int scale = 2;

	//Make level.
	public void generate() {
		int counter = 2;
		
		int amountOfLakes = 6;
		int lakesMade = 0;

		for (int x = 0; x < Tile.SIZE; x++) {

			for (int y = 0; y < Tile.SIZE; y++) {
				int random = (int) (Math.random() * 50000);

				//Generates random tiles.
				if (level[x][y] == null) {
					
					if (random > 0 && random < 10000) {
						level[x][y] = new Plant(x * Tile.BLOCK, y * Tile.BLOCK);
					} else if (random > 10000 && random < 11000) {
						level[x][y] = new Rock(x * Tile.BLOCK, y * Tile.BLOCK);
						
					//Lake generator...
					} else if(random < 50000 && random > 49994 & lakesMade < amountOfLakes && x > 25 / 2 && y > 25) {
						int widthLake = (int) (Math.random() * 20);
						int heightLake = (int) (Math.random() * 20);
						
						for (int i = 0; i < widthLake; i++) {
							
							for (int t = 0; t < heightLake; t++) {
								level[x + i][y + t] = new Water((x + i) * Tile.BLOCK, (y + t) * Tile.BLOCK);
								
							}
						}
						
						lakesMade += 1;
						System.out.println("water " + x + "   " + y);
					}else{
						level[x][y] = new Grass(x * Tile.BLOCK, y * Tile.BLOCK);
					}
				}else{
					
				}
				
				counter = 2;
			}
		}

	}
	
	public static boolean hitBlockedTile(Rectangle player) {
		
	    for (int x = 0; x < Tile.SIZE; x++) {
	    	
	    	for(int y = 0; y < Tile.SIZE; y++) {
	    		if (level[x][y].id == 2) {
	    			if (((BlockedTile) level[x][y]).blocked(player)) {
	    				return true;
	    			}
	    		}
	    	}
	    }
	    
	    return false;
	}
	
	//Get tile.
	public static Tile getTile(float playerX, float playerY) {
		return level[(int) playerX][(int) playerY];
	}
	
	//Gets the tile.
	public Tile getTile(int ID) {
		switch(ID) {
		case 0: return new Grass(0,0);
		case 1: return new Plant(0,0);
		case 2: return new Rock(0,0);
		case 3: return new HoedGrass(0,0);
		case 4: return new HoedGrassWatered(0,0);
		case 5: return new PumpkinSeeds(0,0);
		case 6: return new GlowingPlantSeeds(0,0);
		case 7: return new Water(0,0);
		}
		
		return null;
	}
	
	//Replace tile
	public boolean replaceTile(int x, int y, int remove, int replace) {
		Tile object = getTile(replace);
		object.setLocation(x * 32, y * 32);
		
		if (remove == level[x][y].id) {
			level[x][y] = object;
			return true;
		}
		
		return false;
	}
	
	//Remove tile
	public boolean removeTile(int x, int y, int ID) {
		if (ID == level[x][y].id) {
			level[x][y] = new Grass(x * 32, y * 32);
			return true;
		}
		return false;
		
	}
	
	public void removeTile(int x, int y) {
		level[x][y] = new Grass(x * 32, y * 32);
	}
	
	//Updates all the plants.
	public void updatePlants(int delta) {
	    for (int x = 0; x < Tile.SIZE; x++) {
	    	
	    	for (int y = 0; y < Tile.SIZE; y++) {
	    		if (level[x][y] instanceof Seeds) {
	    			level[x][y].update(delta);
	    		} 
	    	}
	    }
	}
	
	//Updates level
	public synchronized void updateLevel(int delta) {
		updatePlants(delta);
		
		for (int x = (int) (Playing.offsetX / Tile.BLOCK) - 1; x < (Game.screenWidth / Tile.BLOCK) + Playing.offsetX / Tile.BLOCK + 1; x++) {
			
			for (int y = (int) (Playing.offsetY / Tile.BLOCK) - 1; y < (Game.screenHeight / Tile.BLOCK) + Playing.offsetY / Tile.BLOCK  + 1; y++) {
				if (level[x][y] instanceof Water) {
					
				}else{
					level[x][y].update(delta);
				}
			}
		}
		
		for (Water w: Water.waterTiles) {
			w.update(delta);
		}
	}

	//Renders tiles
	public void render(Graphics g) {
		
		for (int x = (int) (Playing.offsetX / Tile.BLOCK) - 1; x < (Game.screenWidth / Tile.BLOCK) + Playing.offsetX / Tile.BLOCK + 1; x++) {
			
			for (int y = (int) (Playing.offsetY / Tile.BLOCK) - 1; y < (Game.screenHeight / Tile.BLOCK) + Playing.offsetY / Tile.BLOCK  + 1; y++) {
				level[x][y].render(g);
			}
		}
		
	}

}
