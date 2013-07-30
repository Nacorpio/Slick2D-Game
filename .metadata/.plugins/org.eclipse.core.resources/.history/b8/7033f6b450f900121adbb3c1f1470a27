package MainGame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.peter.time.Timer;

public final class Game extends StateBasedGame {

	public static final int MAIN_MENU = 0;
	public static final int PLAYING = 1;

	public static int screenWidth = 900;
	public static int screenHeight = 800;

	public void initStatesList(GameContainer container) {
		this.addState(new MainMenu());
		this.addState(new Playing());

		this.enterState(PLAYING);
	}

	public Game(String name) {
		super(name);
	}

	public static void main(String args[]) {
		AppGameContainer app;

		try {
			app = new AppGameContainer(new Game("No name 1.0"), screenWidth, screenHeight, false);
			app.setTargetFrameRate(60);
			app.setAlwaysRender(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}

}
