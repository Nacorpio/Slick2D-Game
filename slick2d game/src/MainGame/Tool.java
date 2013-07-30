package MainGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.peter.generator.Level;

public abstract class Tool extends Item {

	public int duration;
	public int displayDuration = 50;
	public int type;
	public Image item;
	public String path;
	public int x, y;
	
	private boolean bigInv = false;
	
	protected Level level = new Level();
	
	public Tool(types type, String path) {
		this.path = path;
		
		switch(type) {
		case CHALCEUS:
			duration = 25;
			path += "Chalceus.png";
		break;
		case ARGNTUM:
			duration = 40;
			path += "Argentum.png";
		break;
		case AURAIRUS:
			duration = 60;
			path += "Aurairus.png";
			
		break;
		case AETHERIUM:
			duration = 100;
			path += "Aetherium.png";
		break;
		}
		
		try {
			item = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
    public void subtractDuration() {
    	duration -= 1;
    	displayDuration -= 2;
    	
    	if (duration <= 0) {
    		inv.removeItem(this);
    	}
    }
	
	public void setBounds(int x, int y) {
		this.x = x - inv.extraX;
		this.y = y - inv.extraY;
	}
	
	public void setToBigInv(boolean set) {
		bigInv = set;
	}
	
	public void render(Graphics g) {
	    item.draw(x, y, 32, 32);
	    
	    //The duration bar.
	    g.setColor(Color.cyan);
	    if (bigInv) {
	    	g.fillRect(x - 4 , y + 32  , displayDuration - 7, inv.extraY - 1);
	    }else{
	    	 g.fillRect(x - 5, y + 45, displayDuration, inv.extraY);
	    }
	    g.setColor(Color.white);
	}
	
	public static enum types {
		CHALCEUS, ARGNTUM, AURAIRUS, AETHERIUM
	} 
	
	
}
