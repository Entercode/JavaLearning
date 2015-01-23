package com.github.entercode;

import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ImagePracitice {
	
	Timer timer;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				JFrame ex = new JFrame();
				ex.add(new GameWindow());
				ex.setSize(640, 480);
				ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ex.pack();
				ex.setVisible(true);
			}
		});
		
		
//		GameWindow gw = new GameWindow();
//		
//		JFrame frame = new JFrame();
//		frame.setBackground(Color.lightGray);
//		frame.setSize(640, 480);
//		frame.add(gw);
//		frame.setVisible(true);
		
	}

}
