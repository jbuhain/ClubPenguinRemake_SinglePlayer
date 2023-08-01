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
public class Sensei extends Npc
{
	protected Image pic1;
	protected Image dialogue1;
	protected Image dialogue2;
	protected Image dialogue3;
	protected Image dialogue4;
	

	public Sensei(int x, int y)
	{
		
		super(x,y);
		
		dialogue = 1; 
		try {
			pic1 = ImageIO.read(new File("resources/Sensei.png"));
			dialogue1 = ImageIO.read(new File("resources/SenseiDialogue1.png"));
			dialogue2 = ImageIO.read(new File("resources/SenseiDialogue2.png"));
			dialogue3 = ImageIO.read(new File("resources/SenseiDialogue3.png"));
			dialogue4 = ImageIO.read(new File("resources/SenseiDialogue4.png"));
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
	}
	

	public void drawMe(Graphics g)
	{
		//g.setColor(orange);
		//g.fillRect(x,y,width,height);
		//g.setColor(gray);
		//g.fillRect(x,y+15,75,20);
		g.drawImage(pic1, x, y, null);
		if(dialogue==1)
		{
			g.drawImage(dialogue1,x+30,y-130,null);
		}
		else if(dialogue==2)
		{
			g.drawImage(dialogue2,x+30,y-130,null);
		}
		else if(dialogue==3)
		{
			g.drawImage(dialogue3,x+30,y-130,null);
		}
		else if(dialogue==4)
		{
			g.drawImage(dialogue4,x+30,y-130,null);
		}
		//do more dialogues
		
	}
	public void nextDialogue()
	{
		dialogue++;
	}
	public int getDialogue()
	{
		return dialogue;
	}
	
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
		int tempX = x;
		return tempX;
	}
	public int getY()
	{
		int tempY = y;
		return tempY;
	}
	public void moveLeft()
	{
		x = x -3;
	}
	public void moveRight()
	{
		x = x +5;
	}
	

}