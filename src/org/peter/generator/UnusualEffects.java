package org.peter.generator;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import MainGame.Player;
import MainGame.Playing;

public class UnusualEffects extends Tile {
	
	private ParticleSystem system;
	private File file;
	private ConfigurableEmitter emitter;
	private Image img;
	
	public UnusualEffects(float x, float y, int id, String location) {
		super(x, y, id, location);
		
		try {
			setSystemLocation("emitter.xml");
			setParticle("images/pp.png");
			
			
			system = new ParticleSystem(img);
			
			emitter = ParticleIO.loadEmitter(file);
			system.addEmitter(emitter);
			
			system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		} catch (SlickException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSystemLocation(String name) {
		file = new File("ParticleSystem/" + name);
	}
	
	public void setParticle(String name) throws SlickException {
		img = new Image(name, false);
	}

	public void update(int delta) {
		x = oX - Playing.offsetX;
		y = oY - Playing.offsetY;

		tileArea.setBounds((int) x, (int) y, BLOCK, BLOCK);
		if(tileArea.contains(mouse.getMouseX() - Playing.offsetX, mouse.getMouseY() - Playing.offsetY)){
			showBorders = true;
		}else{
			showBorders = false;
		}
		
		emitter.setPosition(x, y);
		system.update(delta);
	}

	public void render(Graphics g) {
		tile.draw(x, y, BLOCK, BLOCK);
		
		if (Player.playerRange == false) {
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		
		if(showBorders){
			g.drawRect(x, y, BLOCK - 1, BLOCK - 1);
		}
		
		system.render();
	}
	
}
