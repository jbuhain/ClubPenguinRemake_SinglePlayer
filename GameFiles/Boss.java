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
public class Boss
{
	private int x;
	private int y;
	
	
	//will have commands that have dialogue pop ups
	private Image pic1;
	private Image pic2;
	private Image pic3;
	private Image pic4;
	
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
	
	private boolean attack;
	

	public Boss(int x, int y)
	{
		
		this.x = x;
		this.y = y;
		
		dialogue = 0;
		
		this.width = 200;
		this.height = 200;
		
		healthBar = 4;
		
		pic1 = new ImageIcon("resources/BossProne.gif").getImage();
		pic2 = new ImageIcon("resources/BossAttack.gif").getImage();
		pic3 = new ImageIcon("resources/SmallExplosion.gif").getImage();
		pic4 = new ImageIcon("resources/BossDeath.gif").getImage();

		try {
			healthBar100 = ImageIO.read(new File("resources/HealthBar100.png"));
			healthBar75 = ImageIO.read(new File("resources/HealthBar75.png"));
			healthBar50 = ImageIO.read(new File("resources/HealthBar50.png"));
			healthBar25 = ImageIO.read(new File("resources/HealthBar25.png"));
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
		
		hit = false;
		visible = false;
		finished = false;
	}
	public void setDialogue(int x)
	{
		dialogue = x;
	}
	

	public void drawMe(Graphics g)
	{
		
		if(!finished && !(attack))//if not dead
			g.drawImage(pic1, x, y, null);
		else if(!finished && attack)
			g.drawImage(pic2, x, y, null);
		else//if finished
			g.drawImage(pic4,x,y,null);
		
		if(hit)//puts fire on him if hit
			g.drawImage(pic3, x-100, y, null);
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
	public void loseHealth()
	{
		healthBar--;
	}
	public boolean checkCollision(Player player)
	{
		if(visible)
		{
			//System.out.println("player x: " + player.getX() +  "has to be between " + (x-200) + "and " + (x+width));
			if(player.getX()>x-150 && player.getX()<x+width && player.getY()>y-100 && player.getY()<y+height)
			{
				//System.out.println("Item received");
				//System.out.println("Boss hit");
				hit = true;
				//soon he'll have lives
				return true; // no purpose at the moment
			}
			return false;
		}
		else
			return false;
	}
	public void stopHit()
	{
		hit = false;
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