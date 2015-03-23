package com.github.entercode;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage img;
	
	public ImageView() {
		try {
			img = ImageIO.read(new File("test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, 100, 100, null);
	}
}
