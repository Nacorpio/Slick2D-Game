package MainGame;

public class GlowingSeeds extends SeedsPouch {
	
	public GlowingSeeds() {
		super("images/glowing plant_state_1.png");
	}

	@Override
	public void use() {
		if (level.replaceTile(Playing.blockX, Playing.blockY, 4, 6)) {
			
		}
	}


}
