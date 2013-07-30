package org.peter.generator;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import MainGame.Playing;

public class Water extends Tile {
	
	
	public static ArrayList<Water> waterTiles = new ArrayList<Water>();
	private Image images[] = new Image[3];
	private Animation animation;

	public Water(int x, int y) {
		super(x, y, 7, "images/Water_1.png");
		
		setImages();
		animation = new Animation(images, 1000, false);
		waterTiles.add(this);
	}
	
	
	public void setImages() {
		try {
			images[0] = new Image("images/Water_1.png");
			images[1] = new Image("images/Water_2.png");
			images[2] = new Image("images/Water_3.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g) {
		g.drawAnimation(animation, x, y);
	}
	
	public void update(int delta) {
		x = oX - Playing.offsetX;
		y = oY - Playing.offsetY;
		
		animation.update(delta);
	}
}
