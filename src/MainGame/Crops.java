package MainGame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Crops extends Item {
		
		private Image crop;
		protected int x;
		protected int y;
		
		public Crops(String location) {
			try {
				crop = new Image(location);
			}catch(SlickException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void render(Graphics g) {
			crop.draw(x, y);
		}
		

		@Override
		public void setBounds(int x, int y) {
			this.x = x - inv.extraX;
			this.y = y - inv.extraY;
		}

}
