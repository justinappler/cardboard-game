package com.immortallabs.cardboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.immortallabs.cardboard.game.Score;
import com.immortallabs.cardboard.ui.ScoresGraphic;

public class CardBoardResourceTester extends JFrame
{
   private JPanel main;
   
   public CardBoardResourceTester()
   {
      this.setTitle("CardBoardResourceTester");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setPreferredSize(new Dimension(500, 200));
      
      BufferedImage temp = CardBoardResource.getImage(this, "NotAValidImage.jpg");
      System.out.println("\n error should match this line\n" +
    	  		"Couldn't load image file: NotAValidImage.jpg");
      
      
      this.setBackground(Color.BLACK);
      
      main = new JPanel();
      
      main.setBackground(Color.WHITE);
      this.add(main);
      
      JLabel imageOne = new JLabel();
      imageOne.setIcon(new ImageIcon(CardBoardResource.getImage(this, "0000.jpg")));
      this.getContentPane().add(imageOne, BorderLayout.EAST);
      
      JLabel imageTwo = new JLabel();
      imageTwo.setIcon(new ImageIcon(CardBoardResource.getImage(this, "0100.jpg")));
      this.getContentPane().add(imageTwo, BorderLayout.CENTER);
      
      JLabel imageThree = new JLabel();
      imageThree.setIcon(new ImageIcon(CardBoardResource.getImage(this, "0200.jpg")));
      this.getContentPane().add(imageThree, BorderLayout.WEST);
      
      this.pack();
      this.setResizable(false);
      this.setVisible(true);
      
  //    this.paint(main.getGraphics());
   }
}
