package com.github.entercode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImagePracitice {

	public static void main(String[] args) {
		
		File file = new File("test.png");
		
		try {
			BufferedImage img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame();
		
		MainWindow window = new MainWindow();
		window.startWindow();
		
		
	}

}
