package org.peter.generator;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import MainGame.Pumpkin;

public class PumpkinSeeds extends Seeds {

	private static String[] seeds = { "images/seeds.png",
			"images/seeds_state_2.png", "images/seeds_state_3.png",
			"images/seeds_state_4.png",
			"images/seeds_state_5.png",
			"images/seeds_state_6.png",
			"images/seeds_state_7.png",
			"images/seeds_state_8.png" };

	public PumpkinSeeds(int x, int y) {
		super(x, y, 5, seeds);
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
