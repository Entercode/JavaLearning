package com.github.entercode;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
	
	public MainWindow() {
		setPreferredSize(new Dimension(640,560));
        // 画像ファイルの読み込み
        try {
            img = ImageIO.read(new File("test.png"));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public void startWindow() {
		JFrame f = new JFrame();
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(this);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
	}
}
