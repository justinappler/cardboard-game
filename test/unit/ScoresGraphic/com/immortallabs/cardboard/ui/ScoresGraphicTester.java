package com.immortallabs.cardboard.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.immortallabs.cardboard.game.Score;
import com.immortallabs.cardboard.game.GameState;




public class ScoresGraphicTester
{
   Point drawLocation;

   ScoresGraphic players;

   JFrame main;
   
   JPanel panel;
   
   int number;
   
   public ScoresGraphicTester(int num) throws InterruptedException
   {
      drawLocation = new Point(50, 50);

      if (num == 1)
      {
         players = new ScoresGraphic(drawLocation, new Score(), null, null,
               null);
      }
      else if (num == 2)
      {
         players = new ScoresGraphic(drawLocation, new Score(), new Score(),
               null, null);
      }
      else if (num == 3)
      {
         players = new ScoresGraphic(drawLocation, new Score(), new Score(),
               new Score(), null);
      }
      else if (num == 4)
      {
         players = new ScoresGraphic(drawLocation, new Score(), new Score(),
               new Score(), new Score());
      }

      number = num;
      
      panel = new JPanel();
      
      addPlayers();
   }
   
   public void initWindow()
   {
      main = new JFrame("ScoresGraphicTester Main Window");
      
      main.setSize(600, 400);

      main.setVisible(true);
      
      main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void addPlayers() throws InterruptedException
   {
      initWindow();
      
      main.add(panel.add(players));
      
      Thread.sleep(2000);
      
      if (number > 1)
      {
         buzzPlayers();
      }
      
      main.dispose();
   }
   
   private void buzzPlayers() throws InterruptedException
   {
      if (number == 2)
      {
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER1);
         players.paint(main.getGraphics());
      
         Thread.sleep(1000);
         
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER2);
         players.paint(main.getGraphics());
         
         Thread.sleep(1000);
      }
      if (number == 3)
      {
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER1);
         players.paint(main.getGraphics());
      
         Thread.sleep(1000);
         
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER2);
         players.paint(main.getGraphics());
         
         Thread.sleep(1000);
         
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER3);
         players.paint(main.getGraphics());
         
         Thread.sleep(1000);
      }
      if (number == 4)
      {
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER1);
         players.paint(main.getGraphics());
         
         Thread.sleep(1000);
         
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER2);
         players.paint(main.getGraphics());
         
         Thread.sleep(1000);
         
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER3);
         players.paint(main.getGraphics());
         
         Thread.sleep(1000);
         
         players.setBuzzedPlayer(GameState.PLAYER.PLAYER4);
         players.paint(main.getGraphics());
         
         Thread.sleep(1000);
      }
      
   }
}
