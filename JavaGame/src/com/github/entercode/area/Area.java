/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.area;

import com.github.entercode.GameRegister;
import com.github.entercode.entity.*;
import com.github.entercode.tile.*;
import com.github.entercode.util.Log;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author entercode
 */
public abstract class Area {
	
	protected int		id;
	protected String	name		= "NA-Area";
	protected int		width		= 4;
	protected int		height		= 3;
	public Image		texture;
	public BufferedImage backTile;
	public BufferedImage frontTile;
	
	public ArrayList<Integer> AreaDataBack = new ArrayList<>();
	public ArrayList<Integer> AreaDataMiddle = new ArrayList<>();
	public ArrayList<Integer> AreaDataFront = new ArrayList<>();

	public ArrayList<Entity> entityRegister = new ArrayList<>();
	public ArrayList<Tile> backTileRegister = new ArrayList<>();
	public ArrayList<Tile> middleTileRegister = new ArrayList<>();
	public ArrayList<Tile> frontTileRegister = new ArrayList<>();
	
	public Area(int id, String name) {
		init(id, name);
	}
	
	private void init(int id, String name) {
		this.id = id;
		this.name = name;
		
		
		load();
	}
	
	public void draw(Graphics2D g2d) {
		// Background Image
		g2d.drawImage(texture, 0, 0, null);
		
		// Back Tile
		g2d.drawImage(backTile, null, 0, 0);
		
		// Front Tile
		g2d.drawImage(frontTile, null, 0, 0);
		
	}
	
	public abstract void update();
	
	
	
	private void load() {
		loadAreaData();
		this.backTile = new BufferedImage(width * 32, height * 32, BufferedImage.TYPE_INT_ARGB);
		this.frontTile = new BufferedImage(width * 32, height * 32, BufferedImage.TYPE_INT_ARGB);
		loadBackground();
		drawBackTile();
		drawFrontTile();
	}
	
	private void drawBackTile() {
		Graphics2D g2d = backTile.createGraphics();
		
		int cnt = 0, row, col;
		for(int n : AreaDataBack) {
			col = cnt % width;
			row = cnt / width;
			
			Tile t = GameRegister.TileRegister.get(n);
			if(t == null) {
				System.out.printf("id: %4d is unknown", n);
			} else {
				t.draw(g2d, col, row, 0, 0);
			}
			
			cnt++;
		}	
	}
	
	private void drawFrontTile() {
		Graphics2D g2d = frontTile.createGraphics();
		
		int cnt = 0, row, col;
		for(int n : AreaDataFront) {
			col = cnt % width;
			row = cnt / width;
			
			Tile t = GameRegister.TileRegister.get(n);
			if(t == null) {
				System.out.printf("id: %4d is unknown", n);
			} else {
				t.draw(g2d, col, row, 0, 0);
			}
			
			cnt++;
		}
	}
	
	private void loadAreaData() {
		File f = new File("res/area/" + name.toLowerCase());
		
		String line;
		int cnt = 0;
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			while((line = br.readLine()) != null) {
				switch(cnt) {
					case 0:
						String[] strs = line.split(" ");
						this.width = Integer.parseInt(strs[0]);
						this.height = Integer.parseInt(strs[1]);
						break;
					case 1:
						break;
					case 2:
						break;
						
					// Area Data
					case 3:			// back
						
						for(String str : line.split(" ")) {
							AreaDataBack.add(Integer.parseInt(str));
						}
						break;
					case 4:			// middle
						for(String str : line.split(" ")) {
							AreaDataMiddle.add(Integer.parseInt(str));
						}
						break;
					case 5:			// front
						for(String str : line.split(" ")) {
							AreaDataFront.add(Integer.parseInt(str));
						}
						break;
					default:
						Log.error("Not area file?");
						break;
					
				}
				cnt++;
			}
			
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Area.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Area.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		
	}
		
	private void loadBackground() {
		
		try {
			texture = ImageIO.read(new File("res/texture/area/" + name.toLowerCase() + ".png"));
		} catch (IOException ex) {
			Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
