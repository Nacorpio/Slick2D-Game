package MainGame;


import java.io.File;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.*;
import org.peter.generator.*;
import org.peter.time.Timer;

import Rain.Raining;

public class Playing extends BasicGameState {

	private Level level;
	private MouseHandler mouse;
	private FastInv basicInv;
	private Player player;
	private Inventory inv;
	private Raining rain;

	// Coordinates
	public static float offsetX = (Tile.SIZE * Tile.BLOCK) / 2;
	public static float offsetY = (Tile.SIZE * Tile.BLOCK) / 2;
	public final float startingX = offsetX;
	public final float startingY = offsetY;
	public static float shiftX = Game.screenWidth / 2;
	public static float shiftY = Game.screenHeight / 2;
	public float imageX = 0;
	public float imageY = 0;
	public static int mouseX = (int) offsetX;
	public static int mouseY = (int) offsetY;
	public static int blockX = 0;
	public static int blockY = 0;
	
	private Timer time = new Timer();
	
	// Init
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		level = new Level();
		mouse = new MouseHandler();
		basicInv = new FastInv();
		player = new Player();
		inv = new Inventory();
		rain = new Raining();
		
		time.startTimer();

		inv.init();
		basicInv.init();
		level.generate();
		player.init();
		inv.addItem(new Pickaxe(Tool.types.CHALCEUS), 0);
		
	}

	// Render
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.white);
		
		level.render(g);
		rain.render();
		basicInv.render(g);
		player.render(g);
		time.render(g);
		inv.render(g);
		
		g.drawString(
				String.format(
						"offsetX: %f\noffsetY: %f\nshiftX: %f\nshiftY: %f\nimageX: %f\nimageY: %f\nmouseX: %d\nmouseY: %d\n"
								+ "blockX: %d\nblockY: %d\n testX: %f\ntestY: %f",
						offsetX, offsetY, shiftX, shiftY, imageX, imageY,
						mouseX, mouseY, blockX, blockY,
						(Playing.offsetX + Playing.shiftX) / 32,
						(Playing.offsetY + Playing.shiftY) / 32),
				Game.screenWidth - 200, 15);
	}

	// Update
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		Input input = container.getInput();
		
		level.updateLevel(delta);
		player.update(container, delta);
		inv.update();
		rain.update(delta);
		
		if (input.isMousePressed(1)) {
			int x = mouse.getBlockX();
			int y = mouse.getBlockY();
			
			//Picks up plant.
			if (level.getTile(x, y) instanceof Seeds) {
				((Seeds) level.getTile(x, y)).pickPlant();
			}
		}
		
        if (input.isKeyDown(Input.KEY_I)) {
			inv.showInventory(true);
		}
		
		if (inv.isSelected()) {
			return; 
		}else{
			mouseX = mouse.getMouseX();
			mouseY = mouse.getMouseY();
			blockX = mouse.getBlockX();
			blockY = mouse.getBlockY();
			basicInv.update();
		}

		
	}

	public int getID() {
		return 1;
	}
}
