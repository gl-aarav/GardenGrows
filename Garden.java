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

 class GardenPanel extends JPanel implements MouseListener
 {	
	int xpos, ypos;
	
	public GardenPanel()
	{
		xpos = 0;
		ypos = 0;
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawSoil(g);
	}
	
	public void drawSoil(Graphics g)
	{
		g.setColor(Color.PINK);
		g.fillRect(50,50, 1000, 500);
	}
	
	public void mousePressed(MouseEvent evt)
	{
		requestFocusInWindow();
		xpos = evt.getX();
		ypos = evt.getY();
		if (xpos > 50 && xpos < 1050 && ypos > 50 && ypos < 550)
		{
			System.out.println(xpos + ypos);
		}
	}
	
	public void mouseClicked(MouseEvent evt)
	{
		
	}
	
	public void mouseReleased(MouseEvent evt)
	{
		
	}
	
	public void mouseEntered(MouseEvent evt)
	{
		
	}
	
	public void mouseExited(MouseEvent evt)
	{
		
	}
	
 }
