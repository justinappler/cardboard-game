package com.immortallabs.cardboard.ui; 

import com.immortallabs.cardboard.game.GameState;

public class GameWindowDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      //CREATE a Jframe 
      javax.swing.JFrame app = new javax.swing.JFrame();
      
      //SET the frame to exit on close 
      app.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
      
      //CREATE a game window 
      GameWindow gw = new GameWindow(app,true);
      
      // CREATE the menu bar and set it to the applet's menu bar  
      app.setJMenuBar(gw.menu.getMenuBar());
      
      //ADD the game window to the frame 
      app.add(gw); 
      
      //SET the size of the frame 
      app.setSize(gw.kWindowWidth, gw.kWindowHeight);   
      
      //SET the visibility of the game window to true 
      app.setVisible(true);             
      
      //CREATE the off screen image for the game window 
      gw.makeImageBuffer();
      
      gw.repaint();  
	}

}
