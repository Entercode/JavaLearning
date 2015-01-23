package com.github.entercode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameWindow extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private Point pos;
	private Image man;
	
	public GameWindow() {
	
		pos = new Point(30, 30);
//		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(640, 320));
		setDoubleBuffered(true);
		setVisible(true);
		
		loadImage();
		
		timer = new Timer(25, this);
		timer.start();
	}
	
	
	// Render method
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMan(g);
	}

	
	// Update method
	@Override
	public void actionPerformed(ActionEvent e) {
		
		pos.x += 1;
		pos.y += 1;
		
		if (pos.x > 640 || pos.y > 320) {
			pos.x = 0;
			pos.y = 0;
		}
		
		repaint();
	}
	
	private void loadImage() {

        ImageIcon ii = new ImageIcon("test.png");
        man = ii.getImage();
    }
	
	private void drawMan(Graphics g) {
		g.drawImage(man, pos.x, pos.y, this);
        Toolkit.getDefaultToolkit().sync();
	}
}
