/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

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
        EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				JFrame ex = new JFrame();
				ex.add(new com.github.entercode.GameFrameEngine());
				ex.setSize(640, 480);
				ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ex.pack();
				ex.setVisible(true);
			}
		});
    }
    
}
