package MainGame;


public class Hoe extends Tool {

	public Hoe(types type) {
		super(type, "images/tools/hoe");
		
	}
	
	public void use() {
	    if (level.replaceTile(Playing.blockX, Playing.blockY, 0, 3)) {
	    	subtractDuration();
	    }
	    
	}

}
