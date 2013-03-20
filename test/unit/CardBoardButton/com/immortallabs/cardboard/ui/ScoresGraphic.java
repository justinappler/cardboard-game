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

    }

    @Override
    public void paint(Graphics g)
    {

    }
}
