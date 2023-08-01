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
public class Player
{
	int x;
	int y;
	
	int width;
	int height;
	
	Color orange;
	Color gray;
	
	private Image pic1;
	private Image pic2; 
	private Image pic3; 
	private Image pic4; 
	private Image pic5; 
	private Image pic6;
	private Image pic7; 
	private Image pic8;
	private boolean moving;//make public if it causes problems
	private boolean teleport;
	private boolean fireMoveRight;
	private boolean fireMoveLeft;
	private boolean fireClothes;
	
	private boolean walkLeft;
	private boolean walkRight;
	
	//have 3 images 
	//2 gifs 1 straight imageio
	//use straight image when prone and use rest when moving
	//have set x set y methods to chagne position when entering new areas
	public Player(int x, int y)
	{
		
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.orange = new Color(250,131,32);
		this.gray = new Color(57,61,72);
		try {
			pic1 = new ImageIcon("resources/mainCharacter.gif").getImage();
			pic2 = ImageIO.read(new File("resources/Prone.png"));
			pic3 = new ImageIcon("resources/Teleport.gif").getImage();
			pic4 = new ImageIcon("resources/FireMoveRight.gif").getImage();
			pic5 = new ImageIcon("resources/FireMoveLeft.gif").getImage();
			pic6 = ImageIO.read(new File("resources/FireNinjaCostume.png"));
			pic7 = ImageIO.read(new File("resources/CostumeWalkLeft.png"));
			pic8 = ImageIO.read(new File("resources/CostumeWalkRight.png"));
			
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
		
		fireClothes = false;
		moving = false;
		fireMoveLeft = false;
		fireMoveRight = false;
		fireClothes = false;
		walkRight = false;
		walkLeft = false;
	}
	public void wearFireCostume()
	{
		fireClothes = true;
	}
	public void cancelFireCostume()
	{
		fireClothes = false;
	}

	public void drawMe(Graphics g)
	{
		//g.setColor(orange);
		//g.fillRect(x,y,width,height);
		//g.setColor(gray);
		//g.fillRect(x,y+15,75,20);
		if(teleport)
			g.drawImage(pic3, x, y, null);
		else if(moving && !(fireClothes))
			g.drawImage(pic1, x, y, null);
		else if(moving && (fireClothes) && walkRight)
			g.drawImage(pic8, x, y, null);
		else if(moving && (fireClothes) && walkLeft)
			g.drawImage(pic7, x, y, null);
		else if(fireMoveRight)
		{
			//System.out.println("yi");
			g.drawImage(pic4, x, y-50, null);
		}
		else if(fireMoveLeft)
		{
			g.drawImage(pic5, x-50, y-50, null);
		}
		else if(fireClothes)
			g.drawImage(pic6,x,y,null); //Change
		else 
			g.drawImage(pic2,x,y,null);//png
		//System.out.println("x:" + x + "y" + y);
	}
	public void stop()
	{
		//System.out.println("stop");
		moving = false;
		walkLeft = false;
		walkRight = false;
	}
	public void teleport()
	{
		teleport = true;
	}
	public void stopTeleport()
	{
		teleport = false;
	}
	public void startFireMoveRight()
	{
		fireMoveRight = true;
	}
	public void startFireMoveLeft()
	{
		fireMoveLeft = true;
	}
	public void stopFireMoveRight()
	{
		fireMoveRight = false;
	}
	public void stopFireMoveLeft()
	{
		fireMoveLeft = false;
	}
	public void moveUp(int level)
	{
		if(level == 1 && getY()>100)
		{
			if(!fireClothes)
				y= y - 4;
			else
				y = y - 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 2 && getY()>294)
		{
			if(!fireClothes)
				y= y - 4;
			else
				y = y - 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 3 && getY()>190)
		{
			if(!fireClothes)
				y= y - 4;
			else
				y = y - 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 4 && getY()>400)
		{
			if(!fireClothes)
				y= y - 4;
			else
				y = y - 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 5 && getY()>270)
		{
			if(!fireClothes)
				y= y - 4;
			else
				y = y - 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else
		{
			//do nothing;
		}
			
			
	}
	public void moveDown(int level)
	{
		if(level == 1 && getY()<620)
		{
			if(!fireClothes)
				y= y + 4;
			else
				y= y + 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 2 && getY()<620)
		{
			if(!fireClothes)
				y= y + 4;
			else
				y= y + 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 3 && getY()<620)
		{
			if(!fireClothes)
				y= y + 4;
			else
				y= y + 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 4 && getY()<630)
		{
			if(!fireClothes)
				y= y + 4;
			else
				y= y + 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 5 && getY()<600)
		{
			if(!fireClothes)
				y= y + 4;
			else
				y= y + 4;
			if(!fireClothes)
				moving = true;
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else
		{
			//do nothing;
		}
	}
	public  int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void moveLeft(int level)
	{
		if(level == 1 && getX()>100)
		{
			if(!fireClothes)
				x= x - 4;
			else
				x= x - 4;
			if(!fireClothes)//u might wanna change this
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkLeft = true;
				fireMoveLeft = true;
			}
				
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 2 && getX()>45)
		{
			if(!fireClothes)
				x= x - 4;
			else
				x= x - 4;
			if(!fireClothes)//u might wanna change this
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkLeft = true;
				fireMoveLeft = true;
			}
				
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 3 && getX()>320)
		{
			if(!fireClothes)
				x= x - 4;
			else
				x= x - 4;
			if(!fireClothes)//u might wanna change this
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkLeft = true;
				fireMoveLeft = true;
			}
				
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 4 && getX()>150)
		{
			if(!fireClothes)
				x= x - 4;
			else
				x= x - 4;
			if(!fireClothes)//u might wanna change this
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkLeft = true;
				fireMoveLeft = true;
			}
				
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 5 && getX()>180)
		{
			if(!fireClothes)
				x= x - 4;
			else
				x= x - 4;
			if(!fireClothes)//u might wanna change this
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkLeft = true;
				fireMoveLeft = true;
			}
				
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else
		{
			//do nothing;
		}
		
	}
	public void moveRight(int level)
	{
		if(level == 1 && getX()<1150)
		{
			if(!fireClothes)
				x= x + 4;
			else
				x= x + 4;
			if(!fireClothes)
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkRight = true;
				fireMoveRight = true;
			}
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 2 && getX()<1156)
		{
			if(!fireClothes)
				x= x + 4;
			else
				x= x + 4;
			if(!fireClothes)
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkRight = true;
				fireMoveRight = true;
			}
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 3 && getX()<1250)
		{
			if(!fireClothes)
				x= x + 4;
			else
				x= x + 4;
			if(!fireClothes)
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkRight = true;
				fireMoveRight = true;
			}
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 4 && getX()<1200)
		{
			if(!fireClothes)
				x= x + 4;
			else
				x= x + 4;
			if(!fireClothes)
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkRight = true;
				fireMoveRight = true;
			}
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else if(level == 5 && getX()<1270)
		{
			if(!fireClothes)
				x= x + 4;
			else
				x= x + 4;
			if(!fireClothes)
			{
				moving = true;
			}
			else
			{
				moving = true;
				walkRight = true;
				fireMoveRight = true;
			}
			fireMoveLeft = false;
			fireMoveRight = false;
		}
		else
		{
			//do nothing;
		}

	}
	public void setCoordinates(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	

}