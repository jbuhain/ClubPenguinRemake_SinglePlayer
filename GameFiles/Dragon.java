import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.BorderLayout;
import java.net.URL;
public class Dragon
{
	private int x;
	private int y;
	
	
	//will have commands that have dialogue pop ups
	private Image pic1;
	private Image pic2;
	private Image pic3;
	private Image pic4;
	private Image pic5;
	private Image pic6;
	private Image dialogue1;
	
	private Image healthBar100;
	private Image healthBar75;
	private Image healthBar50;
	private Image healthBar25;
	
	private int width;
	private int height;
	private int dialogue;
	
	private int healthBar;
	
	private boolean hit;
	private boolean visible; 
	private boolean finished;
	private boolean taunt;
	
	private boolean attack;
	

	public Dragon(int x, int y)
	{
		
		this.x = x;
		this.y = y;
		
		dialogue = 0;
		
		this.width = 200;
		this.height = 200;
		
		healthBar = 4;
		
		
		//pic1 = new ImageIcon("BossProne.gif").getImage();
		//pic2 = new ImageIcon("BossAttack.gif").getImage();
		pic3 = new ImageIcon("resources/Explosion.gif").getImage();
		//pic4 = new ImageIcon("BossDeath.gif").getImage();
		pic5 = new ImageIcon("resources/Thunder.gif").getImage();
		pic6 = new ImageIcon("resources/FireBurst.gif").getImage();
		
		try {
			pic1 = ImageIO.read(new File("resources/MainBoss.png"));
			healthBar100 = ImageIO.read(new File("resources/HealthBar100.png"));
			healthBar75 = ImageIO.read(new File("resources/HealthBar75.png"));
			healthBar50 = ImageIO.read(new File("resources/HealthBar50.png"));
			healthBar25 = ImageIO.read(new File("resources/HealthBar25.png"));
			dialogue1 = ImageIO.read(new File("resources/DragonDialogue1.png"));
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
		
		hit = false;
		visible = false;
		finished = false;
		//attack = true;//test
	}
	public void setDialogue(int x)
	{
		dialogue = x;
	}

	public void drawMe(Graphics g)
	{
		if(healthBar>0)
		{
			g.drawImage(pic1, x, y, null);
			g.drawImage(pic5, x+700, y+200, null);
		}
		if(hit)//puts fire on him if hit
			g.drawImage(pic3, x+500, y, null);
		
		if(attack)
			g.drawImage(pic6, x+550, y+20, null);
		
		if(taunt)
			g.drawImage(dialogue1, x+550, y+20, null);
			
		if(healthBar == 4)
			g.drawImage(healthBar100, x-100, y, null);
		else if(healthBar == 3)
			g.drawImage(healthBar75, x-100, y, null);
		else if(healthBar == 2)
			g.drawImage(healthBar50, x-100, y, null);
		else if(healthBar == 1)
			g.drawImage(healthBar25, x-100, y, null);
		if(healthBar<=0)
		{
			finished = true;
		}
		
		//do more dialogues
	}
	public void visible()
	{
		visible = true;
	}
	public boolean checkVisible()
	{
		return visible;
	}
	public void loseHealth()
	{
		healthBar--;
	}
	public boolean checkCollision(Player player)
	{
		if(visible)
		{
			//System.out.println("player x: " + player.getX() +  "has to be between " + (x-200) + "and " + (x+width));
			if(player.getX()>660 && player.getX()<1200 && player.getY()>200 && player.getY()<500)
			{
				//System.out.println("Item received");
				//System.out.println("Boss hit");
				hit = true;
				return true; 
			}
			return false;
		}
		else
			return false;
	}
	public int getHealth()
	{
		return healthBar;
	}
	public void stopHit()
	{
		hit = false;
	}
	public boolean attack(Player player)
	{
		attack = true;
		if(visible)
		{
			if(player.getX()>645 && player.getX()<1250 && player.getY()>250 && player.getY()<520)
			{
				healthBar = 4;
				player.setCoordinates(350,520);
				taunt = true;
			}
			return false;
		}
		else
			return false;
	}
	public void stopAttack()
	{
		taunt = false;
		attack = false;
	}
	public boolean ifHit() // bit misleading
	{
		return finished;
	}
	/*
	public void moveUp()
	{
		y= y - 5;
	}
	
	public void moveDown()
	{
		y= y + 5;
	}
	public  int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void moveLeft()
	{
		x = x -5;
	}
	public void moveRight()
	{
		x = x +5;
	}
	*/

}