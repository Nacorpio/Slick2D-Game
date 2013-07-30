package MainGame;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.peter.generator.Level;
import org.peter.generator.Tile;

public class Player {
	
	public static Rectangle playerBounds;
	private static Animation player, up, down, left, right;
	private final float dx = 0.1f;
	private final float dy = 0.1f;
	
	public static boolean playerRange = false;

	private float playerX;
	private float playerY;
	private float extraSpace = 5;
	
	private float width = 24;
	private float height = 31;
	
	public void init() throws SlickException {
		Image playerLeft[] = { new Image("images/player/left_1.png"), new Image("images/player/left_3.png") };
		Image playerRight[] = { new Image("images/player/right_1.png"), new Image("images/player/right_3.png")};
		Image playerUp[] = { new Image("images/player/up_1.png"), new Image("images/player/up_3.png")};
		Image playerDown[] = { new Image("images/player/down_1.png"), new Image("images/player/down_3.png")};
		
		left = new Animation(playerLeft, 250, false);
		right = new Animation(playerRight, 250, false);
		up = new Animation(playerUp, 250, false);
		down = new Animation(playerDown, 250, false);
		
		player = down;
		
		playerBounds = new Rectangle(0, 0, 0, 0);
	}
	
	public void render(Graphics g) {
		player.draw(Playing.shiftX, Playing.shiftY);
		
	}
	
	//Sets the X and Y pixels of where the player is.
	public void updatePosition() {
		playerX = (Playing.offsetX + Playing.shiftX + extraSpace);
	    playerY = (Playing.offsetY + Playing.shiftY);
		playerBounds.setBounds(playerX, playerY, width, height);
	}
	
	public void update(GameContainer container, int delta) {
		  Input input = container.getInput();
		  
		        //down
				if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
					Playing.offsetY += dy * delta;
					player = down;
					player.update(delta);
					updatePosition();
					
					if (Level.hitBlockedTile(playerBounds)) {
						Playing.offsetY -= dy * delta;
					}
					
					
					if (Playing.offsetY > Tile.SIZE * Tile.BLOCK - Game.screenHeight - Tile.BLOCK) {
						Playing.offsetY = Tile.SIZE * Tile.BLOCK - Game.screenHeight - Tile.BLOCK;
					}
					
				}
				
				//up
		        if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
		        	Playing.offsetY -= dy * delta;
					player = up;
					player.update(delta);
					updatePosition();
					
					if (Level.hitBlockedTile(playerBounds)) {
						Playing.offsetY += dy * delta;
					}
					
		            if (Playing.offsetY < 0 + Tile.BLOCK) {
		            	Playing.offsetY = 0 + Tile.BLOCK;
					}
				}
		        
		        //right
		        if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
		        	Playing.offsetX += dx * delta;
		        	player = right;
		        	player.update(delta);
		        	updatePosition();
		        	
		        	if (Level.hitBlockedTile(playerBounds)) {
						Playing.offsetX -= dx * delta;
					}
		        	
		        	if (Playing.offsetX > Tile.SIZE * Tile.BLOCK - Game.screenWidth - Tile.BLOCK) {
		        		Playing.offsetX = Tile.SIZE * Tile.BLOCK - Game.screenWidth - Tile.BLOCK;
					}
		      	}
		        
		        //left
		        if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
		        	Playing.offsetX -= dx * delta;
		        	player = left;
		        	player.update(delta);
		        	updatePosition();
		        	
		        	if (Level.hitBlockedTile(playerBounds)) {
						Playing.offsetX += dx * delta;
					}
		        	
		        	if (Playing.offsetX < Tile.BLOCK) {
		        		Playing.offsetX = Tile.BLOCK;
					}
		      	}
		        
		        updateRange(input);
		        
	}
	
	public void updateRange(Input input) {
		MouseHandler mouse = new MouseHandler();
		int x = mouse.getBlockOnScreenX();
		int y = mouse.getBlockOnScreenY();
		float playerX = Playing.shiftX / 32;
		float playerY = Playing.shiftY / 32;
		
		if (x > playerX + 5 || x < playerX - 5 || y > playerY + 5 || y < playerY - 5) {
			playerRange = false;
		}else{
			playerRange = true;
		}
	}
	
	public Rectangle getPlayer() {
		return playerBounds;
	}


}

