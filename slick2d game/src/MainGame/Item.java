package MainGame;

import org.newdawn.slick.Graphics;

public abstract class Item {

	public FastInv inv = new FastInv();
	
	public abstract void use();
	
	public abstract void render(Graphics g);

	public abstract void setBounds(int x, int y);

	
}
