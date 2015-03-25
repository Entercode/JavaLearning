/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author entercode
 */
public class JavaGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
		{
			JFrame app = new JFrame("GameFrameEngineV2");
			GameFrameEngineV2 gf = new GameFrameEngineV2(128, 96, Color.BLACK);
			app.setIgnoreRepaint(true);
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.add(gf);
			
			app.pack();
			app.setVisible(true);
			gf.init();
			gf.run();
		}
		
		
        /*EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				GameRegister.load();
				
				JFrame ex = new JFrame();
				ex.add(new GameFrameEngine());
				ex.setSize(640, 480);
				ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ex.pack();
				ex.setVisible(true);
                                ex.addKeyListener(new GameInputListener());
			}
		});*/
    }
    
}
