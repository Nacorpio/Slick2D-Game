package Rain;

import java.io.File;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.peter.time.Timer;

import MainGame.Game;

public class Raining {

	private ParticleSystem system;
	private boolean isRaining = true;
	private Timer timer = new Timer();

	public Raining() throws SlickException {
		system = new ParticleSystem(new Image("images/p.png", false), 1500);
		
		try {
			File xmlFile = new File("ParticleSystem/rain.xml");
			ConfigurableEmitter emitter = ParticleIO.loadEmitter(xmlFile);
			emitter.setPosition(Game.screenWidth / 2, -5);
			system.addEmitter(emitter);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}
	
	
	public void render() {
		if (isRaining) {
			system.render();
		}
		
	}
	
	public void update(int delta) {
		if (isRaining) {
			system.update(delta);
		}
		
	}
	
	public boolean getIsRaining() {
		return isRaining;
	}
}
