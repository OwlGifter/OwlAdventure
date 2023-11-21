package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		this.x = 100;
		this.y = 100;
		this.speed = 4;
		this.direction = "down";
	}
	
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/owl_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/owl_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/owl_down_1_update.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/owl_down_2_update.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/owl_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/owl_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/owl_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/owl_right_2.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void update() {
		//moves character
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				this.direction = "up";
				this.y -= this.speed;
			}
			if(keyH.downPressed == true) {
				this.direction = "down";
				this.y += this.speed;
			}
			if(keyH.leftPressed == true) {
				this.direction = "left";
				this.x -= this.speed;
			}
			if(keyH.rightPressed == true) {
				this.direction = "right";
				this.x += this.speed;
			}
			
			//adds walking animation
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1 ) {
					spriteNum = 2;
				}else {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			
			
		}		
	}
	public void draw(Graphics2D g2) {
		
		//adds character image
		BufferedImage image = null;
		switch(direction) {
			case "up":
				if(this.spriteNum == 1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
				break;
			case "down":
				if(this.spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
					image = down2;
				}
				break;
			case "right":
				if(this.spriteNum == 1) {
					image = right1;
				}
				if(spriteNum == 2) {
					image = right2;
				}
				break;
			case "left":
				if(this.spriteNum == 1) {
					image = left1;
				}
				if(spriteNum == 2) {
					image = left2;
				}
				break;
		}
		g2.drawImage(image, this.x, this.y, gp.tileSize, gp.tileSize, null);
	}
	
	
	
	
	
	
	
	
}
