package com.immortallabs.cardboard;


import javax.swing.JApplet;

import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.ui.GameWindow;
import com.immortallabs.cardboard.ui.TextUI;


/**
 * <p>The CardBoardApp class starts the logic and CardBoard UI required to
 * run the CardBoard Game.</p>
 * 
 * @author Lamont Samuels 
 * @author John Dalbey 
 * @author ImmortalLabs CSC 309 W'09
 * @author Formerly Michael Brooks in v1.4
 * @author Formerly Justin Appler in v1.1
 * @author Formerly Thomas Dvornik in v1.0 
 * @author Formerly RustyNail CSC308 F08
 * @version 2.1
 * @version March 08th, 2009
 * 
 * @history
 *  - 03/08/09 2.1 Corrected checkstyle errors.
 *  - 03/07/09 2.0 Updated CardBoardApp to run the game in text,graphical as an 
 *                 applet and graphical from a jar. 
 *  - 01/30/09 1.4 Fixed checkstyle errors.(Ticket 65)<br> 
 *  - 01/26/09 1.3 Fixed initial bugs.<br>
 *  - 01/17/08 1.2 Added pseudocode and code.<br>
 *  - 12/03/08 1.1 Took class from Tom, Added Pseudocode, Conformed JavaDocs<br>
 *  - 12/01/08 1.0 Initial Class Skeleton<br>
 */
public class CardBoardApp extends JApplet 
{
   
   /**
    * Starts the CardBoard Game.  While the method accepts arguments per the
    * Java Specification, no arguments are used.
    * 
    * @param args Arguments sent to CardBoardApp when the game is started. 
    */
   public static void main(String[] args) 
   {
      // A flag to mark if the application will be running in graphical mode.
      boolean isGraphical = true;
      
      // A flag to mark if the application will be running in test mode.
      boolean isNormal = true;

      // FOR EACH argument
      for (String arg : args)
      {
         // IF the argument is "-text"
         if (arg.equals("-text"))
         {
            // SET that the program will run in text mode.
            isGraphical = false;
         }

         // IF the argument is "-t"
         else if (arg.equals("-t"))
         {
            // SET that the program will run in test mode.
            isNormal = false;
         }
      }

      // IF the game is set to run graphically,
      if (isGraphical)
      {
         //CREATE a Jframe 
         javax.swing.JFrame app = new javax.swing.JFrame();
         
         //SET the frame to exit on close 
         app.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
         
         //CREATE a game window 
         GameWindow gw = new GameWindow(app,isNormal);
         
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
      // IF the game is not set to run graphically,
      else
      {
         //CREATE a new GameState
         GameState state = new GameState(isNormal);
         
         // CREATE a new TextUI.
         TextUI window = new TextUI(state);
      }
   }
   
   /**
    * Initializes the game window.
    */
   public void init() 
   {
      //CREATE an offscreen image for the window  
      GameWindow gw = new GameWindow(this,true);
      
      //CREATE the menu bar and set it to the applet's menu bar  
      setJMenuBar(gw.menu.getMenuBar());
      
      //ADD the game window to the applet's content pane 
      getContentPane().add(gw);
      
      //SET the applet to be visible 
      this.setVisible(true); 
      
      //SET the focus to be in the applet
      this.requestFocus(); 
      
      //SET the visibility of the game window to true 
      gw.setVisible(true);
 
      //CREATE the off screen image for the game window 
      gw.makeImageBuffer();
      

     } 
   
}
