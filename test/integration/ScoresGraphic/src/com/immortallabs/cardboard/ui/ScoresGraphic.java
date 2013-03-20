package com.immortallabs.cardboard.ui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.immortallabs.cardboard.game.Score;

/**
 * <p>The ScoresGraphic class displays the information of
 * all the player's Score's in a graphical display.</p>
 *
 * <br><br>
 * <b>Operations:</b>
 * <ul>
 * <li>The ScoresGraphic class can graphically display the scores of four players.
 * </ul>
 *
 * @author Nikhil Kowshik
 * @author Formerly Ryan S. Lange at version 0.2
 * @version 0.3
 * @version 1/14/09
 * 
 * @see Point
 * @see Score
 * 
 * @history
 *  - 12/04/08 0.2 Added Version History & Pseudocode<br>
 *  - 12/01/08 0.1 Initial Class Skeleton<br>
 */

public class ScoresGraphic extends JComponent 
{
   /**
    * Scores of player 1
    */
   private Score player1;

   /**
    * Scores of player 2
    */
   private Score player2;

   /**
    * Scores of player 3
    */
   private Score player3;

   /**
    * Scores of player 4
    */
   private Score player4;
   
   /**
    * The amount of players to paint in the window
    */
   private int amountOfPlayers;
   
   /**
    * The location to draw the players scores in the given frame.
    */
   private Point drawLocation;
   
   /**
    * Initializes the ScoresGraphic with a Score from each player.
    * If the Score for a player is NULL than that Score is ignored.
    *
    * @param p  the Point at which to draw the ScoresGraphic window.
    * @param p1 the Score of player one.
    * @param p2 the Score of player two.
    * @param p3 the Score of player three.
    * @param p4 the Score of player four. 
    */
    public ScoresGraphic(Point p, Score p1, Score p2, Score p3, Score p4) 
    {
       //SET srawLoaction equal to p
       drawLocation = p;
       
      //SET player1 equal to p1
      player1 = p1;
      //SET player2 equal to p2
      player2 = p2;
      //SET player3 equal to p3
      player3 = p3;
      //SET player4 equal to p4
      player4 = p4;
      
      //IF p2 equals null
      if (p2 == null)
      {
         //SET amountOfPlayers to 1
         amountOfPlayers = 1;
      }
      //ELSE IF p3 equals null
      else if (p3 == null)
      {
         //SET amountOfPlayers to 2
         amountOfPlayers = 2;
      }
      //ELSE IF p4 equals null
      else if (p4 == null)
      {
         //SET amountOfPlayers to 3 
         amountOfPlayers = 3;
      }
      //ELSE
      else
      {
         //SET amountOfPlayers to 4
         amountOfPlayers = 4;
      }
      //END IF
    }

    @Override
    public void paint(Graphics g)
    {
       //PAINT the score graphic window
       //super.paint(g);
      
       //IF amountOfPlayers is 1
       if (amountOfPlayers == 1)
       {
          //Draw the player's score
          g.drawString("Player 1: " + player1.getScore(),
                drawLocation.x, drawLocation.y);
       }
       //ELSE IF amountOfPlayers is 2
       else if (amountOfPlayers == 2)
       {
          g.drawString("Player 1: " + player1.getScore() + 
                     "\tPlayer 2: " + player2.getScore(),
                     drawLocation.x, drawLocation.y);
       }
       //ELSE IF amountOfPlayers is 3     
       else if (amountOfPlayers == 3)
       {
          g.drawString("Player 1: " + player1.getScore() + 
                     "\tPlayer 2: " + player2.getScore() +
                     "\tPlayer 3: " + player3.getScore(),
                     drawLocation.x, drawLocation.y);
       }
       //ELSE IF amountOfPlayers is 4
       else if (amountOfPlayers == 4)
       {
          g.drawString("Player 1: " + player1.getScore() + 
                     "\tPlayer 2: " + player2.getScore() +
                     "\tPlayer 3: " + player3.getScore() +
                     "\tPlayer 4: " + player4.getScore(),
                     drawLocation.x, drawLocation.y);
       }
    }
}
