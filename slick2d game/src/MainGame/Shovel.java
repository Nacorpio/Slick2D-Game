package MainGame;

public class Shovel extends Tool{
	
    public Shovel(types type) {	
		super(type, "images/tools/shovel");
	}
    
    public void use() {
    	if (level.removeTile(Playing.blockX, Playing.blockY, 1)) {
    		subtractDuration();
    	}
    }

	
}
