package MainGame;

public class PumpkinSeeds extends SeedsPouch {
	
	public PumpkinSeeds() {
		super("images/seeds.png");
	}

	@Override
	public void use() {
		if (level.replaceTile(Playing.blockX, Playing.blockY, 4, 5)) {
			
		}
	}


}
