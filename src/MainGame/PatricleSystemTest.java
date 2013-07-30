package MainGame;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

public class PatricleSystemTest extends BasicGame {
	
	ParticleSystem system;
	
	public PatricleSystemTest(String title) {
		super(title);
	}

	public void init(GameContainer container) throws SlickException {
		system = new ParticleSystem(new Image("images/pp.png", false), 1500);
		
		try {
			File xmlFile = new File("images/emitter.xml");
			ConfigurableEmitter emitter = ParticleIO.loadEmitter(xmlFile);
			emitter.setPosition(250, 250);
			system.addEmitter(emitter);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		system.render();
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		system.update(delta);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new PatricleSystemTest("test"));
		app.setDisplayMode(500,500, false);
		app.start();

	}



}
