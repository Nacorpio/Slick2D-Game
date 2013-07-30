package org.peter.generator;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import MainGame.Pumpkin;

public class GlowingPlantSeeds extends Seeds {
	
	private static String img[] = {"images/glowing plant_state_1.png", "images/glowing plant_state_2.png",
			"images/glowing plant_state_3.png", "images/glowing plant_state_4.png",
			"images/glowing plant_state_5.png", "images/glowing plant_state_6.png",
			"images/glowing plant_state_7.png", "images/glowing plant_state_8.png"};

	public GlowingPlantSeeds(int x, int y) {
		super(x, y, 6, img);
	}
	
	public void render(Graphics g) {
		g.drawImage(tile, x, y);
		g.drawImage(seed[state], x, y);

		if (showBorders) {
			g.setColor(Color.white);
			g.drawRect(x, y, BLOCK - 1, BLOCK - 1);
		}

	}
	
	public void harvest() {
		inv.addItem(new Pumpkin(), 0);
	}
	
}
