package com.immortallabs.cardboard.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

import com.immortallabs.cardboard.game.Score;
import com.immortallabs.cardboard.game.GameState.PLAYER;

/**
 * <p>
 * The ScoresGraphic class displays the information of all the player's Score's
 * in a graphical display.
 * </p>
 * <br>
 * <br>
 * <b>Operations:</b>
 * <ul>
 * <li>The ScoresGraphic class can graphically display the scores of four
 * players.
 * </ul>
 * 
 * @author Nikhil Kowshik
 * @author Formerly Ryan S. Lange at version 0.2
 * @version 0.3
 * @version 1/14/09
 * @see Point
 * @see Score
 * @history - 12/04/08 0.2 Added Version History & Pseudocode<br> - 12/01/08
 *          0.1 Initial Class Skeleton<br>
 */

public class ScoresGraphic extends JComponent
{
   /**
    * One player is playing the game.
    */
   private static final int kOnePlayer = 1;

   /**
    * Two players are playing the game.
    */
   private static final int kTwoPlayers = 2;

   /**
    * Three players are playing the game.
    */
   private static final int kThreePlayers = 3;

   /**
    * Four players are playing the game.
    */
   private static final int kFourPlayers = 4;
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
    * The player that is currently buzzed in to select a set.
    */
   private PLAYER buzzedPlayer;

   /**
    * Initializes the ScoresGraphic with a Score from each player. If the Score
    * for a player is NULL than that Score is ignored.
    * 
    * @param p
    *           the Point at which to draw the ScoresGraphic window.
    * @param p1
    *           the Score of player one.
    * @param p2
    *           the Score of player two.
    * @param p3
    *           the Score of player three.
    * @param p4
    *           the Score of player four.
    */
   public ScoresGraphic(Point p, Score p1, Score p2, Score p3, Score p4)
   {
      // SET srawLoaction equal to p
      drawLocation = p;

      // SET player1 equal to p1
      player1 = p1;
      // SET player2 equal to p2
      player2 = p2;
      // SET player3 equal to p3
      player3 = p3;
      // SET player4 equal to p4
      player4 = p4;

      // IF p2 equals null
      if (p2 == null)
      {
         // SET amountOfPlayers to 1
         amountOfPlayers = kOnePlayer;
      }
      // ELSE IF p3 equals null
      else if (p3 == null)
      {
         // SET amountOfPlayers to 2
         amountOfPlayers = kTwoPlayers;
      }
      // ELSE IF p4 equals null
      else if (p4 == null)
      {
         // SET amountOfPlayers to 3
         amountOfPlayers = kThreePlayers;
      }
      // ELSE
      else
      {
         // SET amountOfPlayers to 4
         amountOfPlayers = kFourPlayers;
      }
      // END IF

      // SET buzzedPlayer to 0
      buzzedPlayer = null;
   }

   /**
    * Set the buzzed player.
    * 
    * @param com.immortallabs.cardboard.game.GameState.Player
    *           player the player that has buzzed in
    */
   public void setBuzzedPlayer(PLAYER player)
   {
      buzzedPlayer = player;
   }

   /**
    * Draws the Scores onto the main game window.
    * 
    * @param g
    *           The graphics context to draw the scores onto
    */
   public void paint(Graphics g)
   {
      FontMetrics metrics;
      int width = 0;

      // CALL the parent's paintComponent
      super.paintComponent(g);

      // SET the background color to white
      g.setColor(java.awt.Color.WHITE);

      // Set the font to Arial-Bold with font size of 16
      g.setFont(java.awt.Font.decode("Arial-BOLD-12"));

      // SET metrics to the FontMetrics for this graphics object
      metrics = g.getFontMetrics(new java.awt.Font("Arial", java.awt.Font.BOLD,
            12));

      // IF amountOfPlayers is 1
      if (amountOfPlayers == kOnePlayer)
      {
         drawOnePlayer(g, metrics);
      }
      // ELSE IF amountOfPlayers is 2
      else if (amountOfPlayers == kTwoPlayers)
      {
         drawTwoPlayers(g, metrics);
      }
      // ELSE IF amountOfPlayers is 3
      else if (amountOfPlayers == kThreePlayers)
      {
         drawThreePlayers(g, metrics);
      }
      // ELSE IF amountOfPlayers is 4
      else if (amountOfPlayers == kFourPlayers)
      {
         drawFourPlayers(g, metrics);
      }
   }

   /**
    * Draws a single players score.
    * 
    * @param g
    *           the graphics object to draw onto
    * @param metrics
    *           the metrics to use to draw the score String
    */
   private void drawOnePlayer(Graphics g, FontMetrics metrics)
   {
      // Draw the player's score
      g.drawString("Player 1: " + player1.getScore(), drawLocation.x,
            drawLocation.y);
   }

   /**
    * Draws two players' scores.
    * 
    * @param g
    *           the graphics object to draw onto
    * @param metrics
    *           the metrics to use to draw the score String
    */
   private void drawTwoPlayers(Graphics g, FontMetrics metrics)
   {
      int width = 0;

      // IF the first player has buzzed in
      if (buzzedPlayer == PLAYER.PLAYER1)
      {
         // SET width to the width of the first player's score strings
         width = metrics
               .stringWidth("Player: 1" + player1.getScore() + "     ");

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the first player's score strings
         g.drawString("Player 1: " + player1.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Black
         g.setColor(Color.WHITE);

         // DRAW the second player's score strings
         g.drawString("Player 2: " + player2.getScore(),
               drawLocation.x + width, drawLocation.y);
      }
      // ELSE IF the second player has buzzed in
      else if (buzzedPlayer == PLAYER.PLAYER2)
      {
         // SET width to the width of the first player's score strings
         width = metrics
               .stringWidth("Player: 1" + player1.getScore() + "     ");

         // DRAW the first player's score strings
         g.drawString("Player 1: " + player1.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the second player's score strings
         g.drawString("Player 2: " + player2.getScore(),
               drawLocation.x + width, drawLocation.y);
      }
      // ELSE
      else
      {
         g.drawString("Player 1: " + player1.getScore() + "     "
               + "Player 2: " + player2.getScore(), drawLocation.x,
               drawLocation.y);
      }
      // END IF
   }

   /**
    * Draws three players' score.
    * 
    * @param g
    *           the graphics object to draw onto
    * @param metrics
    *           the metrics to use to draw the score String
    */
   private void drawThreePlayers(Graphics g, FontMetrics metrics)
   {
      int width = 0;

      // IF the first player has buzzed in
      if (buzzedPlayer == PLAYER.PLAYER1)
      {
         // SET width to the width of the first player's score strings
         width = metrics
               .stringWidth("Player: 1" + player1.getScore() + "     ");

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the first player's score strings
         g.drawString("Player 1: " + player1.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Black
         g.setColor(Color.WHITE);

         // DRAW the second and third players' score string
         g.drawString("Player 2: " + player2.getScore() + "     "
               + "Player 3: " + player3.getScore(), drawLocation.x + width,
               drawLocation.y);
      }
      // ELSE IF the second player has buzzed in
      else if (buzzedPlayer == PLAYER.PLAYER2)
      {
         // SET width to the width of the first player's score strings
         width = metrics
               .stringWidth("Player: 1" + player1.getScore() + "     ");

         // DRAW the first player's score strings
         g.drawString("Player 1: " + player1.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the second player's score string
         g.drawString("Player 2: " + player2.getScore() + "     ",
               drawLocation.x + width, drawLocation.y);

         // CHANGE the graphics' color to Black
         g.setColor(Color.WHITE);

         // ADD the width of player two's score string to width
         width += metrics.stringWidth("Player 2: " + player2.getScore()
               + "     ");

         // DRAW the third player's score string
         g.drawString("Player 3: " + player3.getScore(),
               drawLocation.x + width, drawLocation.y);
      }
      // ELSE IF the third player has buzzed in
      else if (buzzedPlayer == PLAYER.PLAYER3)
      {
         // SET width to the width of the first 2 player's score strings
         width = metrics.stringWidth("Player 1: " + player1.getScore()
               + "     " + "Player 2: " + player2.getScore() + "     ");

         // DRAW the first 2 player's score strings
         g.drawString("Player 1: " + player1.getScore() + "     "
               + "Player 2: " + player2.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the third player's score string
         g.drawString("Player 3: " + player3.getScore(),
               drawLocation.x + width, drawLocation.y);
      }
      // ELSE
      else
      {
         // Draw the entire score string
         g.drawString("Player 1: " + player1.getScore() + "     Player 2: "
               + player2.getScore() + "     Player 3: " + player3.getScore(),
               drawLocation.x, drawLocation.y);
      }
      // END IF
   }

   /**
    * Draws four players' score.
    * 
    * @param g
    *           the graphics object to draw onto
    * @param metrics
    *           the metrics to use to draw the score String
    */
   private void drawFourPlayers(Graphics g, FontMetrics metrics)
   {
      int width = 0;

      // IF the first player has buzzed in
      if (buzzedPlayer == PLAYER.PLAYER1)
      {
         // SET width to the width of the first player's score strings
         width = metrics
               .stringWidth("Player: 1" + player1.getScore() + "     ");

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the first player's score strings
         g.drawString("Player 1: " + player1.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Black
         g.setColor(Color.WHITE);

         // DRAW the second, third and fourth players' score string
         g.drawString("Player 2: " + player2.getScore() + "     "
               + "Player 3: " + player3.getScore() + "     " + "Player 4: "
               + player4.getScore(), drawLocation.x + width, drawLocation.y);
      }
      // ELSE IF the second player has buzzed in
      else if (buzzedPlayer == PLAYER.PLAYER2)
      {
         // SET width to the width of the first player's score strings
         width = metrics
               .stringWidth("Player: 1" + player1.getScore() + "     ");

         // DRAW the first player's score strings
         g.drawString("Player 1: " + player1.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the second player's score string
         g.drawString("Player 2: " + player2.getScore() + "     ",
               drawLocation.x + width, drawLocation.y);

         // CHANGE the graphics' color to Black
         g.setColor(Color.WHITE);

         // ADD the width of player two's score string to width
         width += metrics.stringWidth("Player 2: " + player2.getScore()
               + "     ");

         // DRAW the third and fourth players' score string
         g.drawString("Player 3: " + player3.getScore() + "     "
               + "Player 4: " + player4.getScore(), drawLocation.x + width,
               drawLocation.y);
      }
      // ELSE IF the third player has buzzed in
      else if (buzzedPlayer == PLAYER.PLAYER3)
      {
         // SET width to the width of the first 2 player's score strings
         width = metrics.stringWidth("Player 1: " + player1.getScore()
               + "     " + "Player 2: " + player2.getScore() + "     ");

         // DRAW the first 2 player's score strings
         g.drawString("Player 1: " + player1.getScore() + "     "
               + "Player 2: " + player2.getScore(), drawLocation.x,
               drawLocation.y);

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the third player's score string
         g.drawString("Player 3: " + player3.getScore(),
               drawLocation.x + width, drawLocation.y);

         // ADD the width of player three's score string to width
         width += metrics.stringWidth("Player 3: " + player3.getScore()
               + "     ");
         // CHANGE the graphics' color to Black
         g.setColor(Color.WHITE);

         // DRAW the fourth player's score string
         g.drawString("Player 4: " + player4.getScore(),
               drawLocation.x + width, drawLocation.y);
      }
      // ELSE IF the fourth player has buzzed in
      else if (buzzedPlayer == PLAYER.PLAYER4)
      {
         // SET width to the width of the first 3 player's score strings
         width = metrics.stringWidth("Player 1: " + player1.getScore()
               + "     " + "Player 2: " + player2.getScore() + "     "
               + "Player 3: " + player3.getScore() + "     ");

         // DRAW the first 3 player's score strings
         g.drawString("Player 1: " + player1.getScore() + "     "
               + "Player 2: " + player2.getScore() + "     " + "Player 3: "
               + player3.getScore() + "     ", drawLocation.x, drawLocation.y);

         // CHANGE the graphics' color to Red
         g.setColor(Color.RED);

         // DRAW the fourth player's score string
         g.drawString("Player 4: " + player4.getScore(),
               drawLocation.x + width, drawLocation.y);
      }
      // ELSE
      else
      {
         // Draw the entire score string
         g.drawString("Player 1: " + player1.getScore() + "     Player 2: "
               + player2.getScore() + "     Player 3: " + player3.getScore()
               + "     Player 4: " + player4.getScore(), drawLocation.x,
               drawLocation.y);
      }
      // END IF
   }
}
