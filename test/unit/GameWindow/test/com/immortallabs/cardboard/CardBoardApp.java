package com.immortallabs.cardboard;

import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.ui.GameWindow;
import com.immortallabs.cardboard.ui.TextUI;

/**
 * <p>The CardBoardApp class starts the logic and CardBoard UI required to
 * run the CardBoard Game.</p>
 * 
 * @author Michael Brooks 
 * @author ImmortalLabs CSC 309 W'09
 * @author Formerly Justin Appler in v1.1
 * @author Formerly Thomas Dvornik in v1.0 
 * @author Formerly RustyNail CSC308 F08
 * @version 1.4
 * @version Jan. 30th, 2009
 * 
 * @history
 *  - 01/30/09 1.4 Fixed checkstyle errors.(Ticket 65)<br> 
 *  - 01/26/09 1.3 Fixed initial bugs.<br>
 *  - 01/17/08 1.2 Added pseudocode and code.<br>
 *  - 12/03/08 1.1 Took class from Tom, Added Pseudocode, Conformed JavaDocs<br>
 *  - 12/01/08 1.0 Initial Class Skeleton<br>
 */
public final class CardBoardApp 
{
   /**
    * Constructs a new version of CardBoardApp.
    */
   private CardBoardApp()
   {
   
   }
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
      // DEFINE a GameState
      GameState game;
      
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
      
      // CREATE a new GameState.
      game = new GameState(isNormal);
      
      // IF the game is set to run graphically,
      if (isGraphical)
      {
         // CREATE a new GameWindow.
         GameWindow window = new GameWindow();
         window.init(); 
      
      }
      // IF the game is not set to run graphically,
      else
      {
         // CREATE a new TextUI.
         TextUI window = new TextUI(game);
      }
   }
}
