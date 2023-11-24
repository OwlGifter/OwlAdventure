package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		int additionalTiles = 2 * gp.tileSize;
		//draws tiles on screen only
		if(worldX + additionalTiles > gp.player.worldX - gp.player.screenX && 
				worldX - additionalTiles < gp.player.worldX + gp.player.screenX &&
				worldY + additionalTiles > gp.player.worldY - gp.player.screenY && 
				worldY - additionalTiles < gp.player.worldY + gp.player.screenY) {
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
		
		
	}
}
