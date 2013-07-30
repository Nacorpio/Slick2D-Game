package MainGame;

public class WateringCan extends Tool {

	public WateringCan(types type) {
		super(type, "images/tools/wateringcan");
	}

	
	public void use() {
		if (level.replaceTile(Playing.blockX, Playing.blockY, 3, 4)) {
			subtractDuration();
		}
		
	}

}
