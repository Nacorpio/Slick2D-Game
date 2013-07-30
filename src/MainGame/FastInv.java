package MainGame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FastInv {

	private static int counter = 1;
	private int rectX;
	private int rectY;
	private Image invImage;
	public int extraX = 3;
	public int extraY = 3;

	private static Item smallInv[] = { null, null, null, null };

	public void init() throws SlickException {
		invImage = new Image("images/inv.png");
		addItem(new GlowingSeeds());
		addItem(new PumpkinSeeds());
		addItem(new Hoe(Tool.types.CHALCEUS));
		addItem(new WateringCan(Tool.types.CHALCEUS));
	}

	public void render(Graphics g) {
		g.drawImage(invImage, Game.screenWidth - 150 - extraX, Game.screenHeight - 150 - extraY);

		for (Item inv : smallInv) {
			if (inv != null)
				inv.render(g);
		}

		g.drawRect(rectX, rectY, 50 - 1, 50 - 1);
	}

	public void addItem(Item item) {
		for (int i = 0; i < 4; i++) {
			if (smallInv[i] == null) {
				smallInv[i] = item;
				return;
			}

		}
	}

	public void removeItem(Item item) {
		for (int i = 0; i < 4; i++) {
			
			if (smallInv[i] == item) {
				smallInv[i] = null;

				return;
			}

		}
	}

	public Item getItem(int slot) {
		return smallInv[slot];
	}

	public int getItemSlot(Item item) {
		for (int i = 0; i < smallInv.length; i++) {
			if (smallInv[i] == item) {
				return i;
			}
		}

		return -1;
	}

	public void update() {
		int wheel = Mouse.getDWheel();
		if (wheel < 0) {
			counter -= 1;
			if (counter < 0) {
				counter = 3;
			}
		} else if (wheel > 0) {
			counter += 1;
			if (counter > 3) {
				counter = 0;
			}
		}

		//The selector.
		switch (counter) {
		case 0:
			rectX = Game.screenWidth - 100 - extraX;
			rectY = Game.screenHeight - 150 - extraY;
			break;
		case 1:
			rectX = Game.screenWidth - 150 - extraX;
			rectY = Game.screenHeight - 100 - extraY;
			break;
		case 2:
			rectX = Game.screenWidth - 100 - extraX;
			rectY = Game.screenHeight - 50 - extraY;
			break;
		case 3:
			rectX = Game.screenWidth - 50 - extraX;
			rectY = Game.screenHeight - 100 - extraY;
			break;
		}

		for (Item inv : smallInv) {
			if (inv != null) {
				if (getItemSlot(inv) == 0) {
					inv.setBounds(Game.screenWidth - 95, Game.screenHeight - 145);
				} else if (getItemSlot(inv) == 1) {
					inv.setBounds(Game.screenWidth - 145, Game.screenHeight - 95);
				} else if (getItemSlot(inv) == 2) {
					inv.setBounds(Game.screenWidth - 95, Game.screenHeight - 45);
				} else if (getItemSlot(inv) == 3) {
					inv.setBounds(Game.screenWidth - 45, Game.screenHeight - 95);
				}

				if (counter == getItemSlot(inv) && Mouse.isButtonDown(0) && Player.playerRange) {
					inv.use();
				}
			}

		}

	}
	
}

