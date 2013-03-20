package com.immortallabs.cardboard;

import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.ui.TextUI;


public class CardBoardApp
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


         //CREATE a new GameState
         GameState state = new GameState(false);
         
         // CREATE a new TextUI.
         TextUI window = new TextUI(state);
   }
   

   
}
