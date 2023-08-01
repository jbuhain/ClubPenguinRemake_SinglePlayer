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
public class Cd extends Item
{
	
	//will have commands that have dialogue pop ups

	public Cd(int x, int y, Image pic1)
	{
		super(x,y,pic1);
	}
	//sets a trap
	public void drawMe(Graphics g)
	{
		if(!use)
		{
			//System.out.println(x+" " + y);
			g.drawImage(pic1, x, y, null);	
		}
		if(trap)
		{
			g.drawImage(cage, x-200, y-150, null);
		}
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	//stats
	public void inUse()
	{
		use = true;
	}
	

}