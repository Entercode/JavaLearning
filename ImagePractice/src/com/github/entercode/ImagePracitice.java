package com.github.entercode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ImagePracitice {
	
	Timer timer;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				JFrame ex = new JFrame();
				ex.add(new GameFrameEngine());
				ex.setSize(640, 480);
				ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ex.pack();
				ex.setVisible(true);
			}
		});
		
		JFrame iv = new JFrame();
		iv.setBounds(0, 480, 320, 320);
		iv.setVisible(true);
		iv.add(new ImageView());
//		iv.pack();
		
	}

}
