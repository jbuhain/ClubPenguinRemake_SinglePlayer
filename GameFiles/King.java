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
public class King extends Npc
{
	protected Image pic1;
	protected Image pic2;
	protected Image pic3;
	protected Image dialogue1;
	protected Image dialogue2;
	protected Image dialogue3;
	protected Image dialogue4;
	protected boolean trap;
	

	public King(int x, int y)
	{
		
		super(x,y);
		dialogue = 1; 
		try {
			pic1 = ImageIO.read(new File("resources/KingMain.png"));
			pic2 = ImageIO.read(new File("resources/KingFinal.png"));
			pic3 = ImageIO.read(new File("resources/Cage.png"));
			dialogue1 = ImageIO.read(new File("resources/KingDialogue1.png"));
			dialogue2 = ImageIO.read(new File("resources/KingDialogue2.png"));
			dialogue3 = ImageIO.read(new File("resources/KingDialogue3.png"));
			dialogue4 = ImageIO.read(new File("resources/KingDialogue4.png"));
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
		trap = true;
	}
	

	public void drawMe(Graphics g)
	{
		if(dialogue<=3)
		{
			g.drawImage(pic1, x, y, null);
			g.drawImage(pic3, x-100, y-100, null);
		}
		else
		{
			g.drawImage(pic2, x-100, y, null);
		}
		
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