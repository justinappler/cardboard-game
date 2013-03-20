package com.immortallabs.cardboard.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

import com.immortallabs.cardboard.game.Score;


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



   public ScoresGraphic(Point p, Score p1, Score p2, Score p3, Score p4)
   {

   }



   public void paint(Graphics g)
   {
      
   }


   private void drawOnePlayer(Graphics g, FontMetrics metrics)
   {

   }

   
   private void drawTwoPlayers(Graphics g, FontMetrics metrics)
   {
      
   }


   private void drawThreePlayers(Graphics g, FontMetrics metrics)
   {
      
   }


   private void drawFourPlayers(Graphics g, FontMetrics metrics)
   {
      
   }
}
