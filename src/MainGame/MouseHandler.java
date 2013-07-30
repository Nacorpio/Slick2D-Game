package MainGame;

import org.lwjgl.input.Mouse;
import org.peter.generator.Tile;

public class MouseHandler {

	public int getMouseX() {
		return (int) (Mouse.getX() + Playing.offsetX);
	}
	
	public int getMouseY() {
		return (int) (Game.screenHeight - Mouse.getY() + Playing.offsetY);
	}
	
	public int getBlockX() {
		return getMouseX() / Tile.BLOCK;
	}
	
	public int getBlockY() {
		return getMouseY() / Tile.BLOCK;
	}
	
	public int getMouseDY() {
		return Mouse.getDY();
	}
	
	public int getBlockOnScreenX() {
		return getMouseOnScreenX() / Tile.BLOCK;
	}
	
	public int getBlockOnScreenY() {
		return getMouseOnScreenY() / Tile.BLOCK;
	}
	
	public int getMouseOnScreenX() {
		return Mouse.getX();
	}
	
	public int getMouseOnScreenY() {
		return Game.screenHeight - Mouse.getY();
	}
	
	public int getMouseDX() {
		return Mouse.getDX();
	}
	
}
