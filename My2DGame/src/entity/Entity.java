package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldX, worldY, speed, screenX, screenY;
	public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	//collision area
	public Rectangle solidArea;
	public boolean collisionOn = false;
	
}
