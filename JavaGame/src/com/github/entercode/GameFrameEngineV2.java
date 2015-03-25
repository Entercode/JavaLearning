/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

import com.github.entercode.entity.Entity;
import com.github.entercode.util.Log;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author entercode
 */
public class GameFrameEngineV2 extends Canvas {
	
	// Generic
	private int w;
	private int h;
	
	// FPS
	private int		fps			= 0;
	private int		frames		= 0;
	private long	totalTime	= 0;
	private long	currentTime = System.currentTimeMillis();
	private long	lastTime	= 0;

	// BackBuffer
	private BufferedImage			bi;
	private BufferStrategy			bs;
	private GraphicsEnvironment		ge;
	private GraphicsDevice			gd;
	private GraphicsConfiguration	gc;
	
	// Rendering
	private Color		bgColor		= Color.BLACK;
	private Graphics	g			= null;
	private Graphics2D	g2d			= null;
	
	// Frag
	boolean running		= true;
	boolean debug		= true;
	boolean loading		= true;
	
	
	public GameFrameEngineV2(int width, int height, Color bgColor) {
		
		// Generic
		this.w = width;
		this.h = height;
		this.bgColor = bgColor;
		
		// Canvas Configuration
		this.setIgnoreRepaint(true);
		this.setBackground(bgColor);
		this.setSize(w, h);
	}
	
	public void init() {
		
		Log.info("Graphics", "init");
		// Create back buffer
		this.createBufferStrategy(2);
		bs = this.getBufferStrategy();
		
		
		// Graphics Configuration
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();
		
		
		// off-screen drawing surface
		bi = gc.createCompatibleImage(w, h);
		
		
		// Game Register
		Log.info("GameRegister", "init");
		GameRegister.load();
		
		// Input Listener
		Log.info("InputListener", "init");
		this.addKeyListener(new GameInputListener());
		
		
		
	}
	
	// Render loop
	public void render() {
		for(Entity e : GameRegister.EntityRegister) {
			e.draw(g2d, null);
		}
		
//		try {
//			g2d.drawImage(ImageIO.read(new File("resource/texture/entity/player/test.png")), 100, 100, null);
//		} catch (IOException ex) {
//			Logger.getLogger(GameFrameEngineV2.class.getName()).log(Level.SEVERE, null, ex);
//		}
		g2d.setColor(Color.cyan);
		g2d.fillRect(0, 0, 10, 10);
		
//		if(loadarea) {
			GameRegister.currentArea.draw(g2d);
			loading = false;
//		}
	}
	
	// Update loop
	public void update() {
		
	}
	
	public void debugRender() {
		// display frames per second...
		g2d.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
		g2d.setColor( Color.GREEN );
		g2d.drawString( String.format( "FPS: %s", fps ), 20, 20 );
	}
	
	// Engine loop
	public void run() {
		while(running) {
			
			try {
				// FPS
				lastTime = currentTime;
				currentTime = System.currentTimeMillis();
				totalTime += currentTime - lastTime;

				if(totalTime > 1000) {
					totalTime -= 1000;
					fps = frames;
					frames = 0;
				}

				frames++;

				// Clear backbuffer
				g2d = bi.createGraphics();
				g2d.setColor(bgColor);
				g2d.setBackground(bgColor);
				g2d.fillRect(0, 0, w, h);
				
				
				// Rendering some
				render();
				
				// Rendering debug info
				if(debug) {
					debugRender();
				}
				
				// Update
				update();
				

				// Blit and Flip
				g = bs.getDrawGraphics();
				g.drawImage(bi, 0, 0, null);
				
				if(!bs.contentsLost()) {
					bs.show();
				}
				
				Thread.yield();
				
			
			
			} finally {
				
				if(g != null) {
					g.dispose();
				}
				
				if(g2d != null) {
					g2d.dispose();
				}
			}
		}
		
	}
	
}
