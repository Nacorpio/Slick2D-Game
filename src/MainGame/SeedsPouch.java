package MainGame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.peter.generator.Level;

public abstract class SeedsPouch extends Item {
	
	private Image seed;
	public int seeds = 5;
	protected int x;
	protected int y;
	
	public Level level = new Level();
	
	public SeedsPouch(String location) {
		try {
			seed = new Image(location);
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(Graphics g) {
		seed.draw(x, y);
	}
	

	@Override
	public void setBounds(int x, int y) {
		this.x = x - inv.extraX;
		this.y = y - inv.extraY;
	}

}
