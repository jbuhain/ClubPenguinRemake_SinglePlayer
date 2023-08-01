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
public class Homey extends Npc
{
	//will have commands that have dialogue pop ups
	protected Image pic1;
	protected Image dialogue1;
	

	public Homey(int x, int y) 
	{
		super(x,y);
		dialogue = 1; 
		try {
			pic1 = new ImageIcon("resources/Homey.gif").getImage();
			dialogue1 = ImageIO.read(new File("resources/Quest1.png"));
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
		//do more dialogues
	}
	

}