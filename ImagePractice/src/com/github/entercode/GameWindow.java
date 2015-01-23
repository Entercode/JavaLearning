package com.github.entercode;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
//import javax.swing.Timer;

public class GameWindow extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private Point pos;
	private Image man;
	private int INITIAL_DELAY = 100;
	private int PERIOD_INTERVAL = 25;
	
	public GameWindow() {
	
		pos = new Point(30, 30);
//		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(640, 320));
		setDoubleBuffered(true);
		setVisible(true);
		
		loadImage();
		
/*		
 * Old Method javax.swing.Timer
		timer = new Timer(25, this);
		timer.start();
*/
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduledTask(), INITIAL_DELAY, PERIOD_INTERVAL);
		
	}
	
	
	// Render method
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMan(g);
	}
	
	private void loadImage() {

        ImageIcon ii = new ImageIcon("test.png");
        man = ii.getImage();
    }
	
	private void drawMan(Graphics g) {
		g.drawImage(man, pos.x, pos.y, this);
        Toolkit.getDefaultToolkit().sync();
	}
	
	private class ScheduledTask extends TimerTask {

		// Update
		@Override
		public void run() {
			pos.x += 1;
			pos.y += 1;
			
			if (pos.x > 640 || pos.y > 320) {
				pos.x = 0;
				pos.y = 0;
			}
			
			repaint();
		}
		
	}
}
