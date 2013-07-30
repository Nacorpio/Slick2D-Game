package MainGame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Inventory {
	
	public static final int TOOLS = 1, SEEDS = 2;
	private static int x, y;
	private static boolean showInventory = false;
	private static boolean isSelected = false;
	
	private static Item[][] items = new Item[4][30];
	
	private Image inventory;

	public void addItem(Item item, int tab) {
		for (int i = 0; i < 30; i++) {
			if (items[tab][i] == null) {
				items[tab][i] = item;
				return;
			}

		}
	}
	
	public void init() {
		x = 125;
		y = 125;
		
		try {
			inventory = new Image("images/inventory.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setBounds(int row) {		
		for (int select = 0; select < 30; select++) {
			
			if (items[row][select] != null) {
				
				if (items[row][select] instanceof Tool) {
					((Tool) items[row][select]).setToBigInv(true);
				}
				
				switch (select) {
					case 0: items[row][select].setBounds(x + 50, y + 78); break;
					case 1: items[row][select].setBounds(x + 105, y + 78); break;
					case 2: items[row][select].setBounds(x + 160, y + 78); break;
					case 3: items[row][select].setBounds(x + 210, y + 78); break;
					case 4: items[row][select].setBounds(x + 260, y + 78); break;
				}
			}
		    	
		}
	}
	
	public void update() {
		setBounds(0);
		
		int mx = Mouse.getX();
		int my = Game.screenHeight - Mouse.getY();
		
		//Exit button.
		if (mx > x + 350 && mx < x + 375 && my > y + 3 && my < y + 25 && Mouse.isButtonDown(0) && isSelected == false) {
			showInventory = false;
		}
		
		//Drag the inventory.
		if (mx > x && mx < x + 375 && my > y && my < y + 30 || isSelected) {
			
			if (Mouse.isButtonDown(0)) {
				isSelected = true;
				x += Mouse.getDX();
				y += -Mouse.getDY();
				
				if (x + 290 > Game.screenHeight) {
					x = Game.screenHeight - 290 - Mouse.getDX(); 
				}else if (x < 0) {
					x = 0;
				}else if (y + 350 > Game.screenHeight) {
					y = Game.screenHeight - 350 - Mouse.getDY();
				}else if (y < 0) {
					y = 0;
				}
				
			}else{
				isSelected = false;
				
			}
			
		}
		
	}
	
	public void render(Graphics g) {
		if (showInventory) {
			inventory.draw(x, y);
			
			for (Item item: items[0]) {
				if (item != null) {
					item.render(g);
				}
			}
			
		}
		
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void showInventory(boolean show) {
		showInventory = show;
	}

}
