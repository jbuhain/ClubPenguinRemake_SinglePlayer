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
public class Dj extends Npc
{
	protected Image pic1;
	protected Image dialogue1;
	

	public Dj(int x, int y)
	{
		
		
		super(x,y);
		dialogue = 1; 
		try {
			pic1 = ImageIO.read(new File("resources/Dj.png"));
			dialogue1 = ImageIO.read(new File("resources/Quest2.png"));
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
	}
	

	public void drawMe(Graphics g)
	{
		g.drawImage(pic1, x, y, null);
		if(dialogue==1)
		{
			g.drawImage(dialogue1,x+30,y-130,null);
		}
		//do more dialogues
	}
	public void nextDialogue()
	{
		dialogue++;
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