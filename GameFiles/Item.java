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
public class Item
{
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	protected boolean use; //if character picks it up
	protected boolean visible; //if item has not appeared ingame yet
	protected boolean trap; 
	//will have commands that have dialogue pop ups
	protected Image pic1; 
	protected Image cage;

	public Item(int x, int y, Image pic1)
	{
		
		this.x = x;
		this.y = y;
		
		this.width = 100;
		this.height = 50;
		this.pic1 = pic1;
		trap = false;
		use = false;
		visible = false;
		
		try {
			cage = ImageIO.read(new File("resources/Cage.png"));
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
	}
	public boolean checkCollision(Player player)
	{
		if(visible)
		{
			if(player.getX()>x-75 && player.getX()<x+width && player.getY()>y-100 && player.getY()<y+height)
			{
				//System.out.println("Item received");
				use = true;
				trap = true;
				return true; // no purpose at the moment
			}
			return false;
		}
		else
			return false;
	}
	public void removeTrap()
	{
		trap = false;
	}
	public void drawMe(Graphics g)
	{
		if(!use)
		{
			g.drawImage(pic1, x, y, null);	
		}
	}
	public boolean checkUse()
	{
		if(use)
			return true;
		else
			return false;
	}
	public void visible()
	{
		visible = true;
	}
	public boolean trapped()
	{
		if(trap)
			return true;
		return false;
	}
	public void hidden()
	{
		visible = false;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	

}