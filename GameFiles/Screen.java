import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Screen extends JPanel implements KeyListener, ActionListener
{
	private Player player;
	private Npc homey;
	private Npc shery;
	private Npc sensei;
	private Npc king;
	
	Font font = new Font("Georgia", Font.PLAIN, 30);
	
	private Dragon dragon;
	
	private Dummy d1;
	private Dummy d2;
	
	private Boss b1;
	
	private boolean start;
	private boolean trapped;
	
	private boolean timer;
	private int time;
	
	private boolean timerBossFight;
	private int timeBossFight;
	
	private boolean bossFightEnd;
	
	private int hitOnce;
	
	private Input input;
	
	private JButton startButton;
	private Image startImage;
	private Image level1Image;
	private Image cdItem;
	private Image keyImage;
	private Image hud;
	private Image club;
	private Image dancing;
	private Image dancing2;
	private Image ninjas;
	private Image boxItem;
	private Image ninjaItem;
	private Image gearItem;
	private Image cloakItem;
	private Image staffItem;
	private Image treasureItem;
	private Image endGame;
	private Image endGame1;
	
	private Image dojo;
	private Image bossLevel;
	
	private boolean level2Start;
	private boolean level3Start;
	private boolean level3Start2;
	private boolean level4Start;
	
	private boolean releaseBoss;
	
	
	private boolean costumeAcquired;
	private boolean staffAcquired;
	private boolean cloakAcquired;
	
	private boolean treasureRelease;
	
	private boolean fireMoveRight;
	private boolean fireMoveLeft;
	
	private List<Item> itemStorage;
	private List<Item> characterStorage;
	private Item cd;
	private Item key;
	private Item box;
	private Item ninjaSuit;
	private Item gear;
	private Item staff;
	private Item cloak;
	private Item treasure;
	private int level; 
	
	
	public Screen()
	{
		level = 0; //sign in
		
		player = new Player(400,400);
		homey = new Homey(780,340);
		shery = new Dj(500,150);
		sensei = new Sensei(1280,450);
		king = new King(710,400);
		
		
		
		b1 = new Boss(900,420);
		d1 = new Dummy(310,360);
		d2 = new Dummy(840,360);
		dragon = new Dragon(100,0);
		
		setLayout(null);
		startButton = new JButton("Start");
		startButton.setBounds(520,400,285,100);
		add(startButton);
		startButton.addActionListener(this);
		
		hitOnce = 0;
		
		input = new Input(this); 
		
		try {
			startImage = ImageIO.read(new File("resources/Start.png"));
			level1Image = ImageIO.read(new File("resources/Town.png"));
			cdItem = new ImageIcon("resources/Item1.gif").getImage();//fix this makeit png
			keyImage = ImageIO.read(new File("resources/keyItem.png"));
			hud = ImageIO.read(new File("resources/HUD.png"));
			club = ImageIO.read(new File("resources/Club.png"));
			dancing = new ImageIcon("resources/Dancing.gif").getImage();
			dancing2 = new ImageIcon("resources/Dancing2.gif").getImage();
			ninjas = new ImageIcon("resources/Ninjas.gif").getImage();
			boxItem = ImageIO.read(new File("resources/Box.png"));
			dojo = ImageIO.read(new File("resources/Dojo.png"));
			ninjaItem = ImageIO.read(new File("resources/NinjaItem.png"));
			gearItem = new ImageIcon("resources/GearItem.gif").getImage();
			bossLevel = ImageIO.read(new File("resources/FinalLevel.png"));
			cloakItem = ImageIO.read(new File("resources/cloakItem.png"));
			staffItem = ImageIO.read(new File("resources/staffItem.png"));
			treasureItem = new ImageIcon("resources/Treasure.gif").getImage();
			endGame1 = ImageIO.read(new File("resources/EndGame1.png"));
			endGame = ImageIO.read(new File("resources/EndGame.png"));
		} catch (IOException e) {
			System.out.println("Could not load images. ");
			System.exit(-1);
		}
		
		itemStorage = new ArrayList<Item>();
		characterStorage = new ArrayList<Item>();
		cd = new Cd(500,500,cdItem);
		key = new Key(850,425,keyImage);
		box = new Box(900,600,boxItem);
		ninjaSuit = new NinjaSuit(600,270,ninjaItem);
		gear = new Gear(930,520,gearItem);
		staff = new Staff(980,550,staffItem);
		cloak = new Cloak(1100,630,cloakItem);
		treasure = new Treasure(700,400,treasureItem);
		
		itemStorage.add(cd);
		itemStorage.add(key);
		itemStorage.add(box);
		itemStorage.add(ninjaSuit);
		itemStorage.add(gear);
		itemStorage.add(staff);
		itemStorage.add(cloak);
		itemStorage.add(treasure);
		
		level2Start = false;
		level3Start = false;
		level3Start2 = false;
		level4Start = false;
		
		fireMoveRight = false;
		fireMoveLeft = false;
		costumeAcquired = false;
		releaseBoss = false;
		
		treasureRelease = false;
		
		staffAcquired = false;
		cloakAcquired = false;
		
		bossFightEnd = false;
		
		trapped = false;
		
		addKeyListener(this);
		setFocusable(true);
	}

	public Dimension getPreferredSize() 
	{
		//Sets the size of the panel
        return new Dimension(1280,780);
	}
	
	public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
		
		if(level==0)
		{
			g.drawImage(startImage, 0, 0, null);
		}
		else if(level==1)
		{
			//System.out.println("npc");
			g.drawImage(level1Image, 0, 0, null);
			homey.drawMe(g);
			player.drawMe(g);
			g.drawImage(hud, 0, 700, null);
			key.drawMe(g);
			key.visible();
			
			if(key.checkUse() && player.getX()>575 && player.getX()<800 && player.getY()>150 && player.getY()<325)
			{
				level=2;
				level2Start = true;
			}
			//edit item and use the Disc.java class, by instantiating it first
		}
		else if(level==2)
		{
			//System.out.println("npc");
			
			g.drawImage(club, 0, 0, null);
			shery.drawMe(g);
			g.drawImage(hud, 0, 700, null);
			if(level2Start)
			{
				player.setCoordinates(150,350);
				level2Start = false;
			}
			trapped = cd.trapped();
			if(!trapped && sensei.getDialogue()==1)
			{
				g.drawImage(dancing, 500, 400, null);
				g.drawImage(dancing2, 700, 450, null);
				g.drawImage(dancing, 400, 390, null);
				g.drawImage(dancing2, 600, 420, null);
				g.drawImage(dancing2, 520, 550, null);
			}
			if(trapped||sensei.getDialogue()==2)
			{
				g.drawImage(ninjas, 650, 400, null);
				g.drawImage(ninjas, 720, 430, null);
				g.drawImage(ninjas, 780, 460, null);
				g.drawImage(ninjas, 720, 490, null);
				g.drawImage(ninjas, 650, 520, null);
				sensei.drawMe(g);
				if(sensei.getX()>575)
				{
					sensei.moveLeft();
				}
				if(sensei.getDialogue()==2)
				{
					cd.removeTrap();
					box.drawMe(g);
					box.visible();
				}
			}
			player.drawMe(g);
			cd.drawMe(g);
			cd.visible();
			//edit item and use the Disc.java class, by instantiating it first
		}
		else if(level == 3)
		{
			g.drawImage(dojo, -50, 0, null);
			g.drawImage(hud, 0, 700, null);
			sensei.setCoordinates(584,150);
			sensei.drawMe(g);
			//once senseidialogueisdone
				ninjaSuit.drawMe(g);
				ninjaSuit.visible();
			if(level3Start)
			{
				//System.out.println("Level 3 start");
				player.stopTeleport();
				player.setCoordinates(584,500);
				sensei.setDialogue(3);
				level3Start = false;//only goes once
			}
			if(ninjaSuit.checkUse() && level3Start2 == false) //when u pick up fire costume
			{
				costumeAcquired = true; 
				d1.setDialogue(1);
				d2.setDialogue(2);
				level3Start2 = true; //only goes once
			}
			if(costumeAcquired)
			{
				player.wearFireCostume(); //use this method when u press a button
			}
			
			//if practice
				d1.drawMe(g);
				d2.drawMe(g);
				d1.visible();
				d2.visible();
			
			if(releaseBoss)
			{
				b1.drawMe(g);
				b1.visible();
			}
			if(b1.ifHit())
			{
				gear.drawMe(g);
				gear.visible();
			}
			if(gear.checkUse())
			{
				d2.setDialogue(3);
				if(player.getX()>1050 && player.getY()>400 && player.getY()<526)
				{
					level4Start = true;
					level = 4;
				}
			}
			player.drawMe(g);
		}
		else if(level ==4)
		{
			g.drawImage(bossLevel, -50, 0, null);
			if(level4Start)
			{
				//System.out.println("Level 4 start");
				player.setCoordinates(200,500);
				level4Start = false;//only goes once
			}
			king.drawMe(g);
			if(king.getDialogue()>1)
			{
				dragon.drawMe(g);
				dragon.visible();
			}
			if((dragon.ifHit())&& !(bossFightEnd) && !(bossFightEnd))
			{
				bossFightEnd = true;
			}
			if(dragon.ifHit()&&king.getDialogue()==2)
			{
				king.setDialogue(3);
			}
			if(bossFightEnd)
			{
				timeBossFight = 0;
				if(player.getY()<400)
				{
					player.setCoordinates(650,520);
				}
				staff.drawMe(g);
				staff.visible();
				cloak.drawMe(g);
				cloak.visible();
			}
			if(treasureRelease)
			{
				treasure.drawMe(g);
				treasure.visible();
			}
			
			player.drawMe(g);
			g.drawImage(hud, 0, 700, null);
		}
		else if(level == 5)
		{
			g.drawImage(endGame, 0, -100, null);
			g.drawImage(endGame1, 450, 520, null);
			g.drawImage(hud, 0, 700, null);
		}
		
		//Player inventory
		for(int i = 0; i<characterStorage.size();i++)
		{
			if(characterStorage.get(i) instanceof Key)
			{
				g.drawImage(keyImage, 220, 725, null);
			}
			else if(characterStorage.get(i) instanceof Cd)
			{
				g.drawImage(cdItem, 220+45, 725, null);
			}
			else if(characterStorage.get(i) instanceof Box)
			{
				g.drawImage(boxItem, 220+45+45, 725, null);
			}
			else if(characterStorage.get(i) instanceof NinjaSuit)
			{
				g.drawImage(ninjaItem, 220+45+45+45+45, 735, null);
			}
			else if(characterStorage.get(i) instanceof Gear)
			{
				g.drawImage(gearItem, 850,725, null);
			}
			else if(characterStorage.get(i) instanceof Cloak)
			{
				cloakAcquired = true;
				g.drawImage(cloakItem, 850+45,725, null);
			}
			else if(characterStorage.get(i) instanceof Staff)
			{
				staffAcquired = true;
				g.drawImage(staffItem, 850+45+45,725, null);
			}
			else if(characterStorage.get(i) instanceof Treasure)
			{
				level = 5;
				g.drawImage(treasureItem, 850+45+45+30,715, null);
			}
		}
		if(level != 5)
		{
			g.setFont(font);
			if(level<2 || level ==3)
				g.setColor(Color.BLACK);
			else if(level == 4 ||level == 2)
				g.setColor(Color.WHITE);
			if(level!=0)
			g.drawString("Act: "+(level),50,90);
		}
		
		repaint();
        //Draw Projectile		
		
		///ITEMS
		
		///

	} 
	public void actionPerformed(ActionEvent e)
	{
		if( e.getActionCommand().equals("Start"))
		{ 
			level=1;	
			remove(startButton);
			//System.out.println("test");
		}
		repaint();
		requestFocus();
	}
	
	 public void animate()
    {
        while(true)
        {
            //wait for .01 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
			if( Input.keyboard[38] ) //arrow up
			{
				if(!(dragon.ifHit())&& !trapped && time==0 && level !=3)
				{
					player.moveUp(level+1);
				}
				else if(!trapped && time==0) 
					player.moveUp(level);
			}
			else if( Input.keyboard[40] ) //arrow down
			{
				if(!(dragon.ifHit())&& !trapped && time==0 && level !=3)
				{
					player.moveDown(level+1);
				}
				else if(!trapped && time==0)
					player.moveDown(level);
	
					
			}
			else if( Input.keyboard[37] )
			{
				if(!(dragon.ifHit())&& !trapped && time==0 && level !=3)
				{
					player.moveLeft(level+1);
				}
				else if(!trapped && time==0)
					player.moveLeft(level);
			}
			else if( Input.keyboard[39] )
			{
				if(!(dragon.ifHit())&& !trapped && time==0 && level !=3)
				{
					player.moveRight(level+1);
				}
				else if(!trapped && time==0)
					player.moveRight(level);
			}
			
			for(int i = 0; i<itemStorage.size();i++)
			{
				itemStorage.get(i).checkCollision(player);
				if(itemStorage.get(i).checkUse())
				{
					characterStorage.add(itemStorage.get(i));
					itemStorage.remove(i);
				}
			}
			
			if(level == 4 && !dragon.ifHit())
			{
				timerBossFight = true;
				if(timerBossFight)
				{
					timeBossFight++;
					//System.out.println(timeBossFight);
				}
				
				if(timeBossFight/100 == 4 || timeBossFight/100 == 5)//when it is 4-5 second mark. 
				{
					dragon.attack(player);
				}
				
				if(timeBossFight/100 == 6)//when it reaches 6 seconds.
				{
					timeBossFight = 0;
					dragon.stopAttack();
				}
				
			}
			
			//timer test
			if(timer)
			{
				time++;
				if(fireMoveRight||fireMoveLeft)
				{
					//System.out.println("checking");
					d1.checkCollision(player);
					d2.checkCollision(player);
					b1.checkCollision(player);
					dragon.checkCollision(player);
					if(b1.checkCollision(player) && hitOnce == 1)
					{
						b1.loseHealth();
						hitOnce = 0;
					}
					else if(dragon.checkCollision(player) && hitOnce == 1)
					{
						dragon.loseHealth();
						hitOnce = 0;
					}
				}
				//System.out.println(time);
			}
			if(time==200 && level ==2)
			{
				timer = false;
				level = 3;
				level3Start = true;
				time = 0;
			}
			//shud  prob  be else ifs
			if(time==150 && (fireMoveRight))
			{
				fireMoveRight = false;
				timer = false;
				player.stopFireMoveRight();
				player.stop();
				d1.stopHit();
				d2.stopHit();//do for all of em
				b1.stopHit();
				dragon.stopHit();
				time = 0;
			}
			else if(time==150 && (fireMoveLeft))
			{
				fireMoveLeft = false;
				timer = false;
				player.stopFireMoveLeft();
				player.stop();
				d1.stopHit();
				d2.stopHit();
				b1.stopHit();
				dragon.stopHit();
				time = 0;
			}
			
			
			if(level == 3)//training dummies both hit
			{
				if(d1.ifHit() && d2.ifHit() && sensei.getDialogue()== 3 )
				{
					//System.out.println("hit test");
					releaseBoss = true;
					sensei.setDialogue(4);
				}
			}
            //repaint the graphics drawn
            repaint();
        }
 
    }
	
	public void keyPressed(KeyEvent e)
	{
		
		if( e.getKeyCode() == 32 )//spacebar
		{
			if(level ==1)
			{
				level=2;
				level2Start = true;	
				if(!key.checkUse())
				{
					characterStorage.add(key);
				}
			}
			else if(level ==2)
			{
				level=3;
				level3Start = true;
				if(!cd.checkUse())
				{
					characterStorage.add(cd);
				}
				if(!box.checkUse())
				{
					characterStorage.add(box);
				} 
			}
			else if(level ==3)
			{
				level=4;
				level4Start = true;
				costumeAcquired = true;
				player.wearFireCostume();
				if(!ninjaSuit.checkUse())
				{
					characterStorage.add(ninjaSuit);
				}
				if(!gear.checkUse())
				{
					characterStorage.add(gear);
				}
			}
			else if(level ==4)
			{
				level=5;
				if(!treasure.checkUse())
				{
					characterStorage.add(treasure);
				}
				if(!cloak.checkUse())
				{
					characterStorage.add(cloak);
				}
				if(!staff.checkUse())
				{
					characterStorage.add(staff);
				}
			}
		}
		else if( e.getKeyCode() == 49 )//1
		{
			
			if(level==2)
			{
				sensei.setDialogue(2);
			}
			else if(level==4 && king.getDialogue()==1)
			{
				king.setDialogue(2);
			}
			else if(level == 4 && king.getDialogue()==4)
			{
				treasureRelease = true;
			}
			
			
		}
		else if( e.getKeyCode() == 80 )//p
		{
			if(level==2)
			{
				//System.out.println("yo");
				player.teleport();
				timer = true; // timer for 1 second
					
			}
			else if(level == 4 && king.getDialogue()==3 && staffAcquired && cloakAcquired)
			{
				king.setDialogue(4);
			}
			
		}
		else if( e.getKeyCode() == 69&& time ==0 )//e
		{
			hitOnce = 1;
			fireMoveRight = true;
			timer = true;
			player.startFireMoveRight();	
			
		}
		else if( e.getKeyCode() == 81 && time==0)//q
		{
			//this if statement prevents spamming animation
			hitOnce = 1;
			fireMoveLeft = true;
			timer = true;
			player.startFireMoveLeft();
		}
		
		
		
		repaint();
	}
	public void keyReleased(KeyEvent e){
		player.stop();
	}
	public void keyTyped(KeyEvent e){}
}
