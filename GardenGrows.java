/*
 * Aarav Goyal
 * 3/5/2025
 * Garden.java
 */ 	
 
 
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Image;
 import java.awt.Font;


 import java.awt.event.KeyListener;
 import java.awt.event.MouseListener;
 import java.awt.event.KeyEvent;
 import java.awt.event.MouseEvent;

 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JLabel;

 import java.io.File;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 
 public class Garden
 {
	 public void runIt()
	 {
		JFrame frame = new JFrame("Watch The Garden Grow");
		frame.setSize(1115, 640);
		frame.setLocation(100, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setResizable(false);       
		GardenPanel mpPanel = new GardenPanel();
		frame.getContentPane().add(mpPanel);
		frame.setVisible(true);
	 }
 }

 class GardenPanel extends JPanel implements MouseListener, KeyListener
 {	
	int xpos, ypos;
	boolean pink, mouseClicked, flower;
	
	public GardenPanel()
	{
		xpos = 0;
		ypos = 0;
		pink = true;
		mouseClicked = false;
		flower = false;
		addMouseListener(this);
		addKeyListener(this);
	}
		
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Font font = new Font("Arial", Font.PLAIN, 12);
		g.drawString("Click the mouse and % to water the garden. Then, click the mouse and the up arrow to add sun and grow flowers. Press the Space Bar to reset.", 0, 12);
		drawSoil(g);
	}
	
	public void drawSoil(Graphics g)
	{
		if (pink)
				g.setColor(Color.PINK);
			else
				g.setColor(Color.GREEN);
		g.fillRect(50,50, 1000, 500);
			
		if (flower && !pink)
		{
			g.setColor(Color.YELLOW);
			int x = 100; 
			int y = 75;
			for (int i = 1; i < 16; i++)
			{
				g.fillOval(x, y, 50, 50);
				x += 200;
				if (i % 5 == 0 && i != 0)
				{
					y += 200;
					x = 100;
				}
			}
		}	
	}
	
	public void mousePressed(MouseEvent evt)
	{
		requestFocusInWindow();
		xpos = evt.getX();
		ypos = evt.getY();
		if (!flower && !pink)
			mouseClicked = true;
				
		if (xpos > 50 && xpos < 1050 && ypos > 50 && ypos < 550 && !flower)
		{
			mouseClicked = true;
			repaint();
		}
	}
	
	public void keyPressed(KeyEvent evt)
	{
		int code = evt.getKeyCode();
		if (code == KeyEvent.VK_SPACE)
		{
			pink = true;
			mouseClicked = false;
			flower = false;
			repaint();
		}
		else if (mouseClicked && evt.getKeyChar() == '%')
		{
			pink = false;
			repaint();
			mouseClicked = false;
		
		}
		else if (code == KeyEvent.VK_UP && !pink && mouseClicked)
		{
			flower = true;
			repaint();
			mouseClicked = false;
		}
	}
	
	public void keyTyped(KeyEvent evt) {}
	
	public void keyReleased(KeyEvent evt) {}
	
	public void mouseClicked(MouseEvent evt) {}
	
	public void mouseReleased(MouseEvent evt) {}
	
	public void mouseEntered(MouseEvent evt) {}
	
	public void mouseExited(MouseEvent evt) {}
	
 }
