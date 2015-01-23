package com.github.entercode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameWindow extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point pos;
	private Image man;
	private Thread animator;
	private boolean skip = false;
	
	private int DELAY = 25;
	private long beforeTime, timeDiff, frameDiff;
	
	public GameWindow() {
	
		pos = new Point(30, 30);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(640, 320));
		setDoubleBuffered(true);
		setVisible(true);
		
		loadImage();
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
	
	/*private class ScheduledTask extends TimerTask {

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
		
	}*/
	
	// Update
	private void update() {
		pos.x += 1;
		pos.y += 1;
		
		if (pos.x > 640 || pos.y > 320) {
			pos.x = 0;
			pos.y = 0;
		}
		
	}
	
	@Override
	public void addNotify() {
		System.out.println("[Notify] ");
		super.addNotify();
		
		animator = new Thread(this);
		animator.start();
		
	}

	@Override
	public void run() {
		
		
		beforeTime = System.currentTimeMillis();
		
		while (true) {
			
			// レンダリング
			if (skip) {
				System.out.println("[Render] skipped");
			}
			else {
				// レンダー
				repaint();
			}
				
				
			// アップデート
			update();
			
			// 前の時刻からの時間差（前の処理にかかった時間）
			timeDiff = System.currentTimeMillis() - beforeTime;
			frameDiff = DELAY - timeDiff;
			
			// フレーム内で処理が完了していない
			if (frameDiff < 0) {
				skip = true;
			}
			// フレーム内で処理が完了
			else {
				skip = false;
				// 処理後に余った時間の間スリープ
				try {
					Thread.sleep(frameDiff);
				} catch (InterruptedException e) {
					System.out.println("Interrupted: " + e.getMessage());
				}
			}
			
			// 全処理完了時刻
			beforeTime = System.currentTimeMillis();
		}
	}
}
