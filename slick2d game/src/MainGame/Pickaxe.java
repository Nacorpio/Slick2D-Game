package MainGame;


public class Pickaxe extends Tool {

	public Pickaxe(types type) {
		super(type, "images/tools/pickaxe");
		
	}
	
	public void use() {
	    if (level.removeTile(Playing.blockX, Playing.blockY, 2)) {
	    	subtractDuration();
	    }
	    
	}

}
